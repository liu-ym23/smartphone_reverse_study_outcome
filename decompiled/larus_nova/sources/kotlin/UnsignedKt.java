package kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0007\u001a\u0016\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\tH\u0081\b¢\u0006\u0002\u0010\n\u001a\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\tH\u0081\b¢\u0006\u0002\u0010\f\u001a\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0001\u001a\u001f\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001f\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u0015\u0010\u0013\u001a\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u000eH\u0001\u001a\u0011\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u000eH\u0081\b\u001a\u0011\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u000eH\u0081\b\u001a\u0011\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u000eH\u0081\b\u001a\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000eH\u0081\b\u001a\u0016\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u000eH\u0081\b¢\u0006\u0002\u0010\u001e\u001a\u0018\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0019H\u0001\u001a\u001f\u0010 \u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0001¢\u0006\u0004\b!\u0010\"\u001a\u001f\u0010#\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0001¢\u0006\u0004\b$\u0010\"\u001a\u0010\u0010%\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0019H\u0001\u001a\u0011\u0010&\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0019H\u0081\b\u001a\u0011\u0010'\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u0019H\u0081\b\u001a\u0018\u0010'\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u000eH\u0000¨\u0006("}, d2 = {"doubleToUInt", "Lkotlin/UInt;", "value", "", "(D)I", "doubleToULong", "Lkotlin/ULong;", "(D)J", "floatToUInt", "", "(F)I", "floatToULong", "(F)J", "uintCompare", "", "v1", "v2", "uintDivide", "uintDivide-J1ME1BU", "(II)I", "uintRemainder", "uintRemainder-J1ME1BU", "uintToDouble", "uintToFloat", "uintToLong", "", "uintToString", "", "base", "uintToULong", "(I)J", "ulongCompare", "ulongDivide", "ulongDivide-eb3DHEI", "(JJ)J", "ulongRemainder", "ulongRemainder-eb3DHEI", "ulongToDouble", "ulongToFloat", "ulongToString", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class UnsignedKt {
    public static final double uintToDouble(int r100) {
        return ((double) (Integer.MAX_VALUE & r100)) + (((double) ((r100 >>> 31) << 30)) * ((double) 2));
    }

    private static final long uintToLong(int r100) {
        return ((long) r100) & BodyPartID.bodyIdMax;
    }

    public static final double ulongToDouble(long r100) {
        return ((r100 >>> 11) * ((double) 2048)) + (r100 & 2047);
    }

    public static final int doubleToUInt(double r100) {
        if (Double.isNaN(r100) == false) goto L6;
        return 0;
    L6:
        if (r100 > uintToDouble(0)) goto L9;
        return 0;
    L9:
        if (r100 < uintToDouble(-1)) goto L12;
        return -1;
    L12:
        if (r100 > 2.147483647E9d) goto L15;
        return UInt.m9544constructorimpl((int) r100);
    L15:
        return UInt.m9544constructorimpl(UInt.m9544constructorimpl((int) (r100 - ((double) Integer.MAX_VALUE))) + UInt.m9544constructorimpl(Integer.MAX_VALUE));
    }

    public static final long doubleToULong(double r100) {
        if (Double.isNaN(r100) == false) goto L6;
        return 0;
    L6:
        if (r100 > ulongToDouble(0)) goto L9;
        return 0;
    L9:
        if (r100 < ulongToDouble(-1)) goto L12;
        return -1;
    L12:
        if (r100 >= 9.223372036854776E18d) goto L15;
        return ULong.m9623constructorimpl((long) r100);
    L15:
        return ULong.m9623constructorimpl(ULong.m9623constructorimpl((long) (r100 - 9.223372036854776E18d)) - Long.MIN_VALUE);
    }

    private static final int floatToUInt(float r100) {
        return doubleToUInt(r100);
    }

    private static final long floatToULong(float r100) {
        return doubleToULong(r100);
    }

    private static final float uintToFloat(int r100) {
        return (float) uintToDouble(r100);
    }

    private static final String uintToString(int r100) {
        return String.valueOf(((long) r100) & BodyPartID.bodyIdMax);
    }

    private static final long uintToULong(int r100) {
        return ULong.m9623constructorimpl(((long) r100) & BodyPartID.bodyIdMax);
    }

    private static final float ulongToFloat(long r100) {
        return (float) ulongToDouble(r100);
    }

    private static final String ulongToString(long r100) {
        return ulongToString(r100, 10);
    }

    public static final int uintCompare(int r100, int r101) {
        return Intrinsics.compare(r100 ^ Integer.MIN_VALUE, r101 ^ Integer.MIN_VALUE);
    }

    /* JADX INFO: renamed from: uintDivide-J1ME1BU, reason: not valid java name */
    public static final int m9800uintDivideJ1ME1BU(int r100, int r101) {
        return UInt.m9544constructorimpl((int) ((((long) r100) & BodyPartID.bodyIdMax) / (((long) r101) & BodyPartID.bodyIdMax)));
    }

    /* JADX INFO: renamed from: uintRemainder-J1ME1BU, reason: not valid java name */
    public static final int m9801uintRemainderJ1ME1BU(int r100, int r101) {
        return UInt.m9544constructorimpl((int) ((((long) r100) & BodyPartID.bodyIdMax) % (((long) r101) & BodyPartID.bodyIdMax)));
    }

    private static final String uintToString(int r100, int r101) {
        return ulongToString(((long) r100) & BodyPartID.bodyIdMax, r101);
    }

    public static final int ulongCompare(long r100, long r101) {
        return Intrinsics.compare(r100 ^ Long.MIN_VALUE, r101 ^ Long.MIN_VALUE);
    }

    /* JADX INFO: renamed from: ulongDivide-eb3DHEI, reason: not valid java name */
    public static final long m9802ulongDivideeb3DHEI(long r100, long r101) {
        if (r101 >= 0) goto L10;
        if (Long.compare(r100 ^ Long.MIN_VALUE, r101 ^ Long.MIN_VALUE) >= 0) goto L8;
        return ULong.m9623constructorimpl(0);
    L8:
        return ULong.m9623constructorimpl(1);
    L10:
        if (r100 >= 0) goto L12;
        int r102 = 1;
        long r103 = ((r100 >>> 1) / r101) << 1;
        long r104 = ULong.m9623constructorimpl(r100 - (r103 * r101));
        if (Long.compare(r104 ^ Long.MIN_VALUE, ULong.m9623constructorimpl(r101) ^ Long.MIN_VALUE) >= 0) goto L18;
        r102 = 0;
    L18:
        return ULong.m9623constructorimpl(r103 + ((long) r102));
    L12:
        return ULong.m9623constructorimpl(r100 / r101);
    }

    /* JADX INFO: renamed from: ulongRemainder-eb3DHEI, reason: not valid java name */
    public static final long m9803ulongRemaindereb3DHEI(long r100, long r110) {
        if (r110 >= 0) goto L10;
        if (Long.compare(r100 ^ Long.MIN_VALUE, Long.MIN_VALUE ^ r110) >= 0) goto L8;
        return r100;
    L8:
        return ULong.m9623constructorimpl(r100 - r110);
    L10:
        if (r100 >= 0) goto L12;
        long r101 = r100 - ((((r100 >>> 1) / r110) << 1) * r110);
        if (Long.compare(ULong.m9623constructorimpl(r101) ^ Long.MIN_VALUE, Long.MIN_VALUE ^ ULong.m9623constructorimpl(r110)) >= 0) goto L18;
        r110 = 0;
    L18:
        return ULong.m9623constructorimpl(r101 - r110);
    L12:
        return ULong.m9623constructorimpl(r100 % r110);
    }

    public static final String ulongToString(long r100, int r101) {
        if (r100 >= 0) goto L5;
        long r102 = r101;
        long r103 = ((r100 >>> 1) / r102) << 1;
        long r104 = r100 - (r103 * r102);
        if (r104 < r102) goto L10;
        r104 = r104 - r102;
        r103 = r103 + 1;
    L10:
        return Long.toString(r103, CharsKt.checkRadix(r101)) + Long.toString(r104, CharsKt.checkRadix(r101));
    L5:
        return Long.toString(r100, CharsKt.checkRadix(r101));
    }
}
