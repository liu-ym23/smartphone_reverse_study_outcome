package kotlin;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\n\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\n\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\nH\u0087\b\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0087\b\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\rH\u0087\b\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u000b\u001a\u00020\fH\u0087\b\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\u000eH\u0087\b\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0087\b\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\u000fH\u0087\b\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0087\b\u001a\r\u0010\u0010\u001a\u00020\u0001*\u00020\u0001H\u0087\n¨\u0006\u0011"}, d2 = {"dec", "Ljava/math/BigDecimal;", "div", "other", "inc", "minus", "plus", "rem", "times", "toBigDecimal", "", "mathContext", "Ljava/math/MathContext;", "", "", "", "unaryMinus", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/NumbersKt")
class NumbersKt__BigDecimalsKt {
    public NumbersKt__BigDecimalsKt() {
    }

    private static final BigDecimal dec(BigDecimal r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.subtract(BigDecimal.ONE);
    }

    private static final BigDecimal inc(BigDecimal r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.add(BigDecimal.ONE);
    }

    private static final BigDecimal toBigDecimal(double r100) {
        return new BigDecimal(String.valueOf(r100));
    }

    private static final BigDecimal unaryMinus(BigDecimal r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.negate();
    }

    private static final BigDecimal toBigDecimal(float r100) {
        return new BigDecimal(String.valueOf(r100));
    }

    private static final BigDecimal toBigDecimal(int r100) {
        return BigDecimal.valueOf(r100);
    }

    private static final BigDecimal toBigDecimal(long r100) {
        return BigDecimal.valueOf(r100);
    }

    private static final BigDecimal div(BigDecimal r100, BigDecimal r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        return r100.divide(r101, RoundingMode.HALF_EVEN);
    }

    private static final BigDecimal minus(BigDecimal r100, BigDecimal r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        return r100.subtract(r101);
    }

    private static final BigDecimal plus(BigDecimal r100, BigDecimal r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        return r100.add(r101);
    }

    private static final BigDecimal rem(BigDecimal r100, BigDecimal r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        return r100.remainder(r101);
    }

    private static final BigDecimal times(BigDecimal r100, BigDecimal r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        return r100.multiply(r101);
    }

    private static final BigDecimal toBigDecimal(double r100, MathContext r101) {
        Intrinsics.checkNotNullParameter(r101, "mathContext");
        return new BigDecimal(String.valueOf(r100), r101);
    }

    private static final BigDecimal toBigDecimal(float r100, MathContext r101) {
        Intrinsics.checkNotNullParameter(r101, "mathContext");
        return new BigDecimal(String.valueOf(r100), r101);
    }

    private static final BigDecimal toBigDecimal(int r100, MathContext r101) {
        Intrinsics.checkNotNullParameter(r101, "mathContext");
        return new BigDecimal(r100, r101);
    }

    private static final BigDecimal toBigDecimal(long r100, MathContext r101) {
        Intrinsics.checkNotNullParameter(r101, "mathContext");
        return new BigDecimal(r100, r101);
    }
}
