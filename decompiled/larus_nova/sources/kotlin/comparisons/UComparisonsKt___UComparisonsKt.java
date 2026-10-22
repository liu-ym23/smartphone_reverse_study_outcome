package kotlin.comparisons;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0001H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u001f\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a(\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a#\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\n\u0010\t\u001a\u00020\u0012\"\u00020\rH\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001f\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a(\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a#\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\n\u0010\t\u001a\u00020\u001a\"\u00020\u0015H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001f\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001dH\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a(\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001dH\u0087\b¢\u0006\u0004\b \u0010!\u001a#\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\n\u0010\t\u001a\u00020\"\"\u00020\u001dH\u0007¢\u0006\u0004\b#\u0010$\u001a\u001f\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b&\u0010\u0005\u001a(\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b'\u0010\b\u001a#\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0001H\u0007¢\u0006\u0004\b(\u0010\f\u001a\u001f\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0007¢\u0006\u0004\b)\u0010\u000f\u001a(\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\b¢\u0006\u0004\b*\u0010\u0011\u001a#\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\n\u0010\t\u001a\u00020\u0012\"\u00020\rH\u0007¢\u0006\u0004\b+\u0010\u0014\u001a\u001f\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0015H\u0007¢\u0006\u0004\b,\u0010\u0017\u001a(\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\b¢\u0006\u0004\b-\u0010\u0019\u001a#\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\n\u0010\t\u001a\u00020\u001a\"\u00020\u0015H\u0007¢\u0006\u0004\b.\u0010\u001c\u001a\u001f\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001dH\u0007¢\u0006\u0004\b/\u0010\u001f\u001a(\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001dH\u0087\b¢\u0006\u0004\b0\u0010!\u001a#\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\n\u0010\t\u001a\u00020\"\"\u00020\u001dH\u0007¢\u0006\u0004\b1\u0010$¨\u00062"}, d2 = {"maxOf", "Lkotlin/UByte;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "maxOf-Kr8caGY", "(BB)B", "c", "maxOf-b33U2AM", "(BBB)B", "other", "Lkotlin/UByteArray;", "maxOf-Wr6uiD8", "(B[B)B", "Lkotlin/UInt;", "maxOf-J1ME1BU", "(II)I", "maxOf-WZ9TVnA", "(III)I", "Lkotlin/UIntArray;", "maxOf-Md2H83M", "(I[I)I", "Lkotlin/ULong;", "maxOf-eb3DHEI", "(JJ)J", "maxOf-sambcqE", "(JJJ)J", "Lkotlin/ULongArray;", "maxOf-R03FKyM", "(J[J)J", "Lkotlin/UShort;", "maxOf-5PvTz6A", "(SS)S", "maxOf-VKSA0NQ", "(SSS)S", "Lkotlin/UShortArray;", "maxOf-t1qELG4", "(S[S)S", "minOf", "minOf-Kr8caGY", "minOf-b33U2AM", "minOf-Wr6uiD8", "minOf-J1ME1BU", "minOf-WZ9TVnA", "minOf-Md2H83M", "minOf-eb3DHEI", "minOf-sambcqE", "minOf-R03FKyM", "minOf-5PvTz6A", "minOf-VKSA0NQ", "minOf-t1qELG4", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/comparisons/UComparisonsKt")
class UComparisonsKt___UComparisonsKt {
    public UComparisonsKt___UComparisonsKt() {
    }

    /* JADX INFO: renamed from: maxOf-5PvTz6A, reason: not valid java name */
    public static final short m10634maxOf5PvTz6A(short r100, short r101) {
        if (Intrinsics.compare(r100 & 65535, 65535 & r101) < 0) goto L6;
        return r100;
    L6:
        return r101;
    }

    /* JADX INFO: renamed from: maxOf-J1ME1BU, reason: not valid java name */
    public static int m10635maxOfJ1ME1BU(int r100, int r101) {
        if (Integer.compare(r100 ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ r101) < 0) goto L6;
        return r100;
    L6:
        return r101;
    }

    /* JADX INFO: renamed from: maxOf-Kr8caGY, reason: not valid java name */
    public static final byte m10636maxOfKr8caGY(byte r100, byte r101) {
        if (Intrinsics.compare(r100 & UByte.MAX_VALUE, r101 & UByte.MAX_VALUE) < 0) goto L6;
        return r100;
    L6:
        return r101;
    }

    /* JADX INFO: renamed from: maxOf-Md2H83M, reason: not valid java name */
    public static final int m10637maxOfMd2H83M(int r100, int... r101) {
        Intrinsics.checkNotNullParameter(r101, "other");
        int r102 = UIntArray.m9605getSizeimpl(r101);
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100 = m10635maxOfJ1ME1BU(r100, UIntArray.m9604getpVg5ArA(r101, r103));
        r103 = r103 + 1;
        goto L3
    L5:
        return r100;
    }

    /* JADX INFO: renamed from: maxOf-R03FKyM, reason: not valid java name */
    public static final long m10638maxOfR03FKyM(long r100, long... r101) {
        Intrinsics.checkNotNullParameter(r101, "other");
        int r102 = ULongArray.m9684getSizeimpl(r101);
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100 = m10643maxOfeb3DHEI(r100, ULongArray.m9683getsVKNKU(r101, r103));
        r103 = r103 + 1;
        goto L3
    L5:
        return r100;
    }

    /* JADX INFO: renamed from: maxOf-Wr6uiD8, reason: not valid java name */
    public static final byte m10641maxOfWr6uiD8(byte r100, byte... r101) {
        Intrinsics.checkNotNullParameter(r101, "other");
        int r102 = UByteArray.m9526getSizeimpl(r101);
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100 = m10636maxOfKr8caGY(r100, UByteArray.m9525getw2LRezQ(r101, r103));
        r103 = r103 + 1;
        goto L3
    L5:
        return r100;
    }

    /* JADX INFO: renamed from: maxOf-eb3DHEI, reason: not valid java name */
    public static long m10643maxOfeb3DHEI(long r100, long r101) {
        if (Long.compare(r100 ^ Long.MIN_VALUE, Long.MIN_VALUE ^ r101) < 0) goto L6;
        return r100;
    L6:
        return r101;
    }

    /* JADX INFO: renamed from: maxOf-t1qELG4, reason: not valid java name */
    public static final short m10645maxOft1qELG4(short r100, short... r101) {
        Intrinsics.checkNotNullParameter(r101, "other");
        int r102 = UShortArray.m9789getSizeimpl(r101);
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100 = m10634maxOf5PvTz6A(r100, UShortArray.m9788getMh2AYeg(r101, r103));
        r103 = r103 + 1;
        goto L3
    L5:
        return r100;
    }

    /* JADX INFO: renamed from: minOf-5PvTz6A, reason: not valid java name */
    public static final short m10646minOf5PvTz6A(short r100, short r101) {
        if (Intrinsics.compare(r100 & 65535, 65535 & r101) > 0) goto L6;
        return r100;
    L6:
        return r101;
    }

    /* JADX INFO: renamed from: minOf-J1ME1BU, reason: not valid java name */
    public static int m10647minOfJ1ME1BU(int r100, int r101) {
        if (Integer.compare(r100 ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ r101) > 0) goto L6;
        return r100;
    L6:
        return r101;
    }

    /* JADX INFO: renamed from: minOf-Kr8caGY, reason: not valid java name */
    public static final byte m10648minOfKr8caGY(byte r100, byte r101) {
        if (Intrinsics.compare(r100 & UByte.MAX_VALUE, r101 & UByte.MAX_VALUE) > 0) goto L6;
        return r100;
    L6:
        return r101;
    }

    /* JADX INFO: renamed from: minOf-Md2H83M, reason: not valid java name */
    public static final int m10649minOfMd2H83M(int r100, int... r101) {
        Intrinsics.checkNotNullParameter(r101, "other");
        int r102 = UIntArray.m9605getSizeimpl(r101);
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100 = m10647minOfJ1ME1BU(r100, UIntArray.m9604getpVg5ArA(r101, r103));
        r103 = r103 + 1;
        goto L3
    L5:
        return r100;
    }

    /* JADX INFO: renamed from: minOf-R03FKyM, reason: not valid java name */
    public static final long m10650minOfR03FKyM(long r100, long... r101) {
        Intrinsics.checkNotNullParameter(r101, "other");
        int r102 = ULongArray.m9684getSizeimpl(r101);
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100 = m10655minOfeb3DHEI(r100, ULongArray.m9683getsVKNKU(r101, r103));
        r103 = r103 + 1;
        goto L3
    L5:
        return r100;
    }

    /* JADX INFO: renamed from: minOf-Wr6uiD8, reason: not valid java name */
    public static final byte m10653minOfWr6uiD8(byte r100, byte... r101) {
        Intrinsics.checkNotNullParameter(r101, "other");
        int r102 = UByteArray.m9526getSizeimpl(r101);
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100 = m10648minOfKr8caGY(r100, UByteArray.m9525getw2LRezQ(r101, r103));
        r103 = r103 + 1;
        goto L3
    L5:
        return r100;
    }

    /* JADX INFO: renamed from: minOf-eb3DHEI, reason: not valid java name */
    public static long m10655minOfeb3DHEI(long r100, long r101) {
        if (Long.compare(r100 ^ Long.MIN_VALUE, Long.MIN_VALUE ^ r101) > 0) goto L6;
        return r100;
    L6:
        return r101;
    }

    /* JADX INFO: renamed from: minOf-t1qELG4, reason: not valid java name */
    public static final short m10657minOft1qELG4(short r100, short... r101) {
        Intrinsics.checkNotNullParameter(r101, "other");
        int r102 = UShortArray.m9789getSizeimpl(r101);
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100 = m10646minOf5PvTz6A(r100, UShortArray.m9788getMh2AYeg(r101, r103));
        r103 = r103 + 1;
        goto L3
    L5:
        return r100;
    }

    /* JADX INFO: renamed from: maxOf-VKSA0NQ, reason: not valid java name */
    private static final short m10639maxOfVKSA0NQ(short r100, short r101, short r102) {
        return m10634maxOf5PvTz6A(r100, m10634maxOf5PvTz6A(r101, r102));
    }

    /* JADX INFO: renamed from: maxOf-WZ9TVnA, reason: not valid java name */
    private static final int m10640maxOfWZ9TVnA(int r100, int r101, int r102) {
        return m10635maxOfJ1ME1BU(r100, m10635maxOfJ1ME1BU(r101, r102));
    }

    /* JADX INFO: renamed from: maxOf-b33U2AM, reason: not valid java name */
    private static final byte m10642maxOfb33U2AM(byte r100, byte r101, byte r102) {
        return m10636maxOfKr8caGY(r100, m10636maxOfKr8caGY(r101, r102));
    }

    /* JADX INFO: renamed from: maxOf-sambcqE, reason: not valid java name */
    private static final long m10644maxOfsambcqE(long r100, long r101, long r102) {
        return m10643maxOfeb3DHEI(r100, m10643maxOfeb3DHEI(r101, r102));
    }

    /* JADX INFO: renamed from: minOf-VKSA0NQ, reason: not valid java name */
    private static final short m10651minOfVKSA0NQ(short r100, short r101, short r102) {
        return m10646minOf5PvTz6A(r100, m10646minOf5PvTz6A(r101, r102));
    }

    /* JADX INFO: renamed from: minOf-WZ9TVnA, reason: not valid java name */
    private static final int m10652minOfWZ9TVnA(int r100, int r101, int r102) {
        return m10647minOfJ1ME1BU(r100, m10647minOfJ1ME1BU(r101, r102));
    }

    /* JADX INFO: renamed from: minOf-b33U2AM, reason: not valid java name */
    private static final byte m10654minOfb33U2AM(byte r100, byte r101, byte r102) {
        return m10648minOfKr8caGY(r100, m10648minOfKr8caGY(r101, r102));
    }

    /* JADX INFO: renamed from: minOf-sambcqE, reason: not valid java name */
    private static final long m10656minOfsambcqE(long r100, long r101, long r102) {
        return m10655minOfeb3DHEI(r100, m10655minOfeb3DHEI(r101, r102));
    }
}
