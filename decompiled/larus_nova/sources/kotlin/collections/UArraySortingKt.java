package kotlin.collections;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\t\u0010\n\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\f\u0010\r\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u000f\u0010\u0010\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0013\u0010\u0014\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0015\u0010\u0016\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0017\u0010\u0018\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0019\u0010\u001a\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001e\u0010\u0014\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001f\u0010\u0016\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b \u0010\u0018\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b!\u0010\u001a¨\u0006\""}, d2 = {"partition", "", "array", "Lkotlin/UByteArray;", "left", "right", "partition-4UcCI2c", "([BII)I", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-oBK06Vg", "sortArray--nroSd4", "sortArray-Aa5vz7o", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class UArraySortingKt {
    /* JADX INFO: renamed from: partition--nroSd4, reason: not valid java name */
    private static final int m9909partitionnroSd4(long[] r100, int r101, int r110) {
        long r102 = ULongArray.m9683getsVKNKU(r100, (r101 + r110) / 2);
    L3:
        if (r101 > r110) goto L12;
    L4:
        long r103 = r102 ^ Long.MIN_VALUE;
        if (Long.compare(ULongArray.m9683getsVKNKU(r100, r101) ^ Long.MIN_VALUE, r103) >= 0) goto L8;
        r101 = r101 + 1;
    L8:
        if (Long.compare(ULongArray.m9683getsVKNKU(r100, r110) ^ Long.MIN_VALUE, r103) <= 0) goto L10;
        r110 = r110 - 1;
        goto L8
    L10:
        if (r101 > r110) goto L3;
        long r104 = ULongArray.m9683getsVKNKU(r100, r101);
        ULongArray.m9688setk8EXiF4(r100, r101, ULongArray.m9683getsVKNKU(r100, r110));
        ULongArray.m9688setk8EXiF4(r100, r110, r104);
        r101 = r101 + 1;
        r110 = r110 - 1;
        goto L3
    L12:
        return r101;
    }

    /* JADX INFO: renamed from: partition-4UcCI2c, reason: not valid java name */
    private static final int m9910partition4UcCI2c(byte[] r100, int r101, int r102) {
        byte r103 = UByteArray.m9525getw2LRezQ(r100, (r101 + r102) / 2);
    L3:
        if (r101 > r102) goto L12;
    L4:
        int r104 = UByteArray.m9525getw2LRezQ(r100, r101) & UByte.MAX_VALUE;
        int r105 = r103 & UByte.MAX_VALUE;
        if (Intrinsics.compare(r104, r105) >= 0) goto L8;
        r101 = r101 + 1;
    L8:
        if (Intrinsics.compare(UByteArray.m9525getw2LRezQ(r100, r102) & UByte.MAX_VALUE, r105) <= 0) goto L10;
        r102 = r102 - 1;
        goto L8
    L10:
        if (r101 > r102) goto L3;
        byte r106 = UByteArray.m9525getw2LRezQ(r100, r101);
        UByteArray.m9530setVurrAj0(r100, r101, UByteArray.m9525getw2LRezQ(r100, r102));
        UByteArray.m9530setVurrAj0(r100, r102, r106);
        r101 = r101 + 1;
        r102 = r102 - 1;
        goto L3
    L12:
        return r101;
    }

    /* JADX INFO: renamed from: partition-Aa5vz7o, reason: not valid java name */
    private static final int m9911partitionAa5vz7o(short[] r100, int r101, int r102) {
        short r103 = UShortArray.m9788getMh2AYeg(r100, (r101 + r102) / 2);
    L3:
        if (r101 > r102) goto L12;
    L4:
        int r104 = r103 & 65535;
        if (Intrinsics.compare(UShortArray.m9788getMh2AYeg(r100, r101) & 65535, r104) >= 0) goto L8;
        r101 = r101 + 1;
    L8:
        if (Intrinsics.compare(UShortArray.m9788getMh2AYeg(r100, r102) & 65535, r104) <= 0) goto L10;
        r102 = r102 - 1;
        goto L8
    L10:
        if (r101 > r102) goto L3;
        short r105 = UShortArray.m9788getMh2AYeg(r100, r101);
        UShortArray.m9793set01HTLdE(r100, r101, UShortArray.m9788getMh2AYeg(r100, r102));
        UShortArray.m9793set01HTLdE(r100, r102, r105);
        r101 = r101 + 1;
        r102 = r102 - 1;
        goto L3
    L12:
        return r101;
    }

    /* JADX INFO: renamed from: partition-oBK06Vg, reason: not valid java name */
    private static final int m9912partitionoBK06Vg(int[] r100, int r101, int r102) {
        int r103 = UIntArray.m9604getpVg5ArA(r100, (r101 + r102) / 2);
    L3:
        if (r101 > r102) goto L12;
    L4:
        int r104 = r103 ^ Integer.MIN_VALUE;
        if (Integer.compare(UIntArray.m9604getpVg5ArA(r100, r101) ^ Integer.MIN_VALUE, r104) >= 0) goto L8;
        r101 = r101 + 1;
    L8:
        if (Integer.compare(UIntArray.m9604getpVg5ArA(r100, r102) ^ Integer.MIN_VALUE, r104) <= 0) goto L10;
        r102 = r102 - 1;
        goto L8
    L10:
        if (r101 > r102) goto L3;
        int r105 = UIntArray.m9604getpVg5ArA(r100, r101);
        UIntArray.m9609setVXSXFK8(r100, r101, UIntArray.m9604getpVg5ArA(r100, r102));
        UIntArray.m9609setVXSXFK8(r100, r102, r105);
        r101 = r101 + 1;
        r102 = r102 - 1;
        goto L3
    L12:
        return r101;
    }

    /* JADX INFO: renamed from: quickSort--nroSd4, reason: not valid java name */
    private static final void m9913quickSortnroSd4(long[] r100, int r101, int r102) {
        int r103 = m9909partitionnroSd4(r100, r101, r102);
        int r104 = r103 - 1;
        if (r101 >= r104) goto L5;
        m9913quickSortnroSd4(r100, r101, r104);
    L5:
        if (r103 >= r102) goto L8;
        m9913quickSortnroSd4(r100, r103, r102);
        return;
    }

    /* JADX INFO: renamed from: quickSort-4UcCI2c, reason: not valid java name */
    private static final void m9914quickSort4UcCI2c(byte[] r100, int r101, int r102) {
        int r103 = m9910partition4UcCI2c(r100, r101, r102);
        int r104 = r103 - 1;
        if (r101 >= r104) goto L5;
        m9914quickSort4UcCI2c(r100, r101, r104);
    L5:
        if (r103 >= r102) goto L8;
        m9914quickSort4UcCI2c(r100, r103, r102);
        return;
    }

    /* JADX INFO: renamed from: quickSort-Aa5vz7o, reason: not valid java name */
    private static final void m9915quickSortAa5vz7o(short[] r100, int r101, int r102) {
        int r103 = m9911partitionAa5vz7o(r100, r101, r102);
        int r104 = r103 - 1;
        if (r101 >= r104) goto L5;
        m9915quickSortAa5vz7o(r100, r101, r104);
    L5:
        if (r103 >= r102) goto L8;
        m9915quickSortAa5vz7o(r100, r103, r102);
        return;
    }

    /* JADX INFO: renamed from: quickSort-oBK06Vg, reason: not valid java name */
    private static final void m9916quickSortoBK06Vg(int[] r100, int r101, int r102) {
        int r103 = m9912partitionoBK06Vg(r100, r101, r102);
        int r104 = r103 - 1;
        if (r101 >= r104) goto L5;
        m9916quickSortoBK06Vg(r100, r101, r104);
    L5:
        if (r103 >= r102) goto L8;
        m9916quickSortoBK06Vg(r100, r103, r102);
        return;
    }

    /* JADX INFO: renamed from: sortArray--nroSd4, reason: not valid java name */
    public static final void m9917sortArraynroSd4(long[] r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "array");
        m9913quickSortnroSd4(r100, r101, r102 - 1);
    }

    /* JADX INFO: renamed from: sortArray-4UcCI2c, reason: not valid java name */
    public static final void m9918sortArray4UcCI2c(byte[] r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "array");
        m9914quickSort4UcCI2c(r100, r101, r102 - 1);
    }

    /* JADX INFO: renamed from: sortArray-Aa5vz7o, reason: not valid java name */
    public static final void m9919sortArrayAa5vz7o(short[] r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "array");
        m9915quickSortAa5vz7o(r100, r101, r102 - 1);
    }

    /* JADX INFO: renamed from: sortArray-oBK06Vg, reason: not valid java name */
    public static final void m9920sortArrayoBK06Vg(int[] r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "array");
        m9916quickSortoBK06Vg(r100, r101, r102 - 1);
    }
}
