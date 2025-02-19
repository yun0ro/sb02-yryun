import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class TransactionManager {
    private List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    // Predicate: 조건에 맞는 트랜잭션만 반환
    // predicate는 boolean값을 반환한다. 맞는지만 확인하고,
    // transaction을 return한다.
    public List<Transaction> filterTransactions(Predicate<Transaction> predicate) {
        // 조건에 맞는 transaction list 저장할 곳
        List<Transaction> result = new ArrayList<>();
        for (Transaction t : transactions) {
            // 현재 매개변수로 들어온 predicate<transaction>
            // 이 조건에 맞는 transaction인지 test하고, 그걸 return한다.
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    // Function: 트랜잭션 금액 변환(매핑)
    // double = 할인율
    public List<Double> mapAmounts(Function<Transaction, Double> function) {
        List<Double> result = new ArrayList<>();
        for (Transaction t : transactions) {
            result.add(function.apply(t));
        }
        return result;
    }

    // Consumer: 트랜잭션 처리(출력, 로깅 등)
    //
    public void processTransactions(Consumer<Transaction> consumer) {
        for (Transaction t : transactions) {
            consumer.accept(t);
        }
    }
}
