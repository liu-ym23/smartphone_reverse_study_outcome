package kotlin;

import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\r\u0010\u0006\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0087\f\u001a\u0015\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0087\f\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\r\u0010\u0010\u001a\u00020\u0011*\u00020\u0001H\u0087\b\u001a!\u0010\u0010\u001a\u00020\u0011*\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0087\b\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\rH\u0087\b\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\u0016H\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0018\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f¨\u0006\u0019"}, d2 = {"and", "Ljava/math/BigInteger;", "other", "dec", "div", "inc", "inv", "minus", SRStrategy.KEY_ORIGIN_RESOLUTION, "plus", "rem", "shl", OfficeSDKRequestTag.KEY_NEW_USER, "", "shr", "times", "toBigDecimal", "Ljava/math/BigDecimal;", "scale", "mathContext", "Ljava/math/MathContext;", "toBigInteger", "", "unaryMinus", "xor", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/NumbersKt")
class NumbersKt__BigIntegersKt extends NumbersKt__BigDecimalsKt {
    public NumbersKt__BigIntegersKt() {
    }

    private static final BigInteger dec(BigInteger r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.subtract(BigInteger.ONE);
    }

    private static final BigInteger inc(BigInteger r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.add(BigInteger.ONE);
    }

    private static final BigInteger inv(BigInteger r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.not();
    }

    private static final BigDecimal toBigDecimal(BigInteger r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new BigDecimal(r100);
    }

    private static final BigInteger toBigInteger(int r100) {
        return BigInteger.valueOf(r100);
    }

    private static final BigInteger unaryMinus(BigInteger r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.negate();
    }

    private static final BigInteger toBigInteger(long r100) {
        return BigInteger.valueOf(r100);
    }

    private static final BigInteger and(BigInteger r100, BigInteger r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        return r100.and(r101);
    }

    private static final BigInteger div(BigInteger r100, BigInteger r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        return r100.divide(r101);
    }

    private static final BigInteger minus(BigInteger r100, BigInteger r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        return r100.subtract(r101);
    }

    private static final BigInteger or(BigInteger r100, BigInteger r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        return r100.or(r101);
    }

    private static final BigInteger plus(BigInteger r100, BigInteger r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        return r100.add(r101);
    }

    private static final BigInteger rem(BigInteger r100, BigInteger r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        return r100.remainder(r101);
    }

    private static final BigInteger shl(BigInteger r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.shiftLeft(r101);
    }

    private static final BigInteger shr(BigInteger r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.shiftRight(r101);
    }

    private static final BigInteger times(BigInteger r100, BigInteger r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        return r100.multiply(r101);
    }

    private static final BigInteger xor(BigInteger r100, BigInteger r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        return r100.xor(r101);
    }

    private static final BigDecimal toBigDecimal(BigInteger r100, int r101, MathContext r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "mathContext");
        return new BigDecimal(r100, r101, r102);
    }

    public static /* synthetic */ BigDecimal toBigDecimal$default(BigInteger r100, int r101, MathContext r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = 0;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = MathContext.UNLIMITED;
    L8:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "mathContext");
        return new BigDecimal(r100, r101, r102);
    }
}
