package kotlin;

import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0005\u001a\u00020\t*\u00020\n2\u0006\u0010\b\u001a\u00020\u0001H\u0087\b\u001a\r\u0010\u000b\u001a\u00020\f*\u00020\u0006H\u0087\b\u001a\r\u0010\u000b\u001a\u00020\f*\u00020\tH\u0087\b\u001a\r\u0010\r\u001a\u00020\f*\u00020\u0006H\u0087\b\u001a\r\u0010\r\u001a\u00020\f*\u00020\tH\u0087\b\u001a\r\u0010\u000e\u001a\u00020\f*\u00020\u0006H\u0087\b\u001a\r\u0010\u000e\u001a\u00020\f*\u00020\tH\u0087\b\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001H\u0087\b\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010\u0012\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\u0013\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010\u0013\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\u0014\u001a\u00020\u0002*\u00020\u0006H\u0087\b\u001a\r\u0010\u0014\u001a\u00020\u0001*\u00020\tH\u0087\b\u001a\r\u0010\u0015\u001a\u00020\u0002*\u00020\u0006H\u0087\b\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\tH\u0087\b¨\u0006\u0016"}, d2 = {"countLeadingZeroBits", "", "", "countOneBits", "countTrailingZeroBits", "fromBits", "", "Lkotlin/Double$Companion;", "bits", "", "Lkotlin/Float$Companion;", "isFinite", "", "isInfinite", "isNaN", "rotateLeft", "bitCount", "rotateRight", "takeHighestOneBit", "takeLowestOneBit", "toBits", "toRawBits", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/NumbersKt")
class NumbersKt__NumbersJVMKt extends NumbersKt__FloorDivModKt {
    public NumbersKt__NumbersJVMKt() {
    }

    private static final int countLeadingZeroBits(int r100) {
        return Integer.numberOfLeadingZeros(r100);
    }

    private static final int countOneBits(int r100) {
        return Integer.bitCount(r100);
    }

    private static final int countTrailingZeroBits(int r100) {
        return Integer.numberOfTrailingZeros(r100);
    }

    private static final boolean isFinite(double r100) {
        if (Double.isInfinite(r100) == false) goto L5;
    L7:
        return false;
    L5:
        if (Double.isNaN(r100) == true) goto L7;
        return true;
    }

    private static final boolean isInfinite(double r100) {
        return Double.isInfinite(r100);
    }

    private static final boolean isNaN(double r100) {
        return Double.isNaN(r100);
    }

    private static final int takeHighestOneBit(int r100) {
        return Integer.highestOneBit(r100);
    }

    private static final int takeLowestOneBit(int r100) {
        return Integer.lowestOneBit(r100);
    }

    private static final int toBits(float r100) {
        return Float.floatToIntBits(r100);
    }

    private static final int toRawBits(float r100) {
        return Float.floatToRawIntBits(r100);
    }

    private static final int countLeadingZeroBits(long r100) {
        return Long.numberOfLeadingZeros(r100);
    }

    private static final int countOneBits(long r100) {
        return Long.bitCount(r100);
    }

    private static final int countTrailingZeroBits(long r100) {
        return Long.numberOfTrailingZeros(r100);
    }

    private static final boolean isFinite(float r100) {
        if (Float.isInfinite(r100) == false) goto L5;
    L7:
        return false;
    L5:
        if (Float.isNaN(r100) == true) goto L7;
        return true;
    }

    private static final boolean isInfinite(float r100) {
        return Float.isInfinite(r100);
    }

    private static final boolean isNaN(float r100) {
        return Float.isNaN(r100);
    }

    private static final long takeHighestOneBit(long r100) {
        return Long.highestOneBit(r100);
    }

    private static final long takeLowestOneBit(long r100) {
        return Long.lowestOneBit(r100);
    }

    private static final long toBits(double r100) {
        return Double.doubleToLongBits(r100);
    }

    private static final long toRawBits(double r100) {
        return Double.doubleToRawLongBits(r100);
    }

    private static final double fromBits(DoubleCompanionObject r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return Double.longBitsToDouble(r101);
    }

    private static final int rotateLeft(int r100, int r101) {
        return Integer.rotateLeft(r100, r101);
    }

    private static final int rotateRight(int r100, int r101) {
        return Integer.rotateRight(r100, r101);
    }

    private static final float fromBits(FloatCompanionObject r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return Float.intBitsToFloat(r101);
    }

    private static final long rotateLeft(long r100, int r101) {
        return Long.rotateLeft(r100, r101);
    }

    private static final long rotateRight(long r100, int r101) {
        return Long.rotateRight(r100, r101);
    }
}
