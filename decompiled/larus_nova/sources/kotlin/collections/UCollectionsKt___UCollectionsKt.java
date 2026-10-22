package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\n0\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\u0005\u001a\u0017\u0010\f\u001a\u00020\r*\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001a\u0017\u0010\u0010\u001a\u00020\u0011*\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010\u0012\u001a\u0017\u0010\u0013\u001a\u00020\u0014*\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0007¢\u0006\u0002\u0010\u0015\u001a\u0017\u0010\u0016\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020\n0\u000eH\u0007¢\u0006\u0002\u0010\u0018¨\u0006\u0019"}, d2 = {"sum", "Lkotlin/UInt;", "", "Lkotlin/UByte;", "sumOfUByte", "(Ljava/lang/Iterable;)I", "sumOfUInt", "Lkotlin/ULong;", "sumOfULong", "(Ljava/lang/Iterable;)J", "Lkotlin/UShort;", "sumOfUShort", "toUByteArray", "Lkotlin/UByteArray;", "", "(Ljava/util/Collection;)[B", "toUIntArray", "Lkotlin/UIntArray;", "(Ljava/util/Collection;)[I", "toULongArray", "Lkotlin/ULongArray;", "(Ljava/util/Collection;)[J", "toUShortArray", "Lkotlin/UShortArray;", "(Ljava/util/Collection;)[S", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/UCollectionsKt")
class UCollectionsKt___UCollectionsKt {
    public UCollectionsKt___UCollectionsKt() {
    }

    public static final int sumOfUByte(Iterable<UByte> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Iterator<UByte> r101 = r100.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L6;
        r102 = UInt.m9544constructorimpl(r102 + UInt.m9544constructorimpl(r101.next().m9517unboximpl() & UByte.MAX_VALUE));
        goto L4
    L6:
        return r102;
    }

    public static final int sumOfUInt(Iterable<UInt> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Iterator<UInt> r101 = r100.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L6;
        r102 = UInt.m9544constructorimpl(r102 + r101.next().m9596unboximpl());
        goto L4
    L6:
        return r102;
    }

    public static final long sumOfULong(Iterable<ULong> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Iterator<ULong> r101 = r100.iterator();
        long r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L6;
        r102 = ULong.m9623constructorimpl(r102 + r101.next().m9675unboximpl());
        goto L4
    L6:
        return r102;
    }

    public static final int sumOfUShort(Iterable<UShort> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Iterator<UShort> r101 = r100.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L6;
        r102 = UInt.m9544constructorimpl(r102 + UInt.m9544constructorimpl(r101.next().m9780unboximpl() & 65535));
        goto L4
    L6:
        return r102;
    }

    public static final byte[] toUByteArray(Collection<UByte> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        byte[] r101 = UByteArray.m9519constructorimpl(r100.size());
        Iterator<UByte> r102 = r100.iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L6;
        UByteArray.m9530setVurrAj0(r101, r103, r102.next().m9517unboximpl());
        r103 = r103 + 1;
        goto L4
    L6:
        return r101;
    }

    public static final int[] toUIntArray(Collection<UInt> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int[] r101 = UIntArray.m9598constructorimpl(r100.size());
        Iterator<UInt> r102 = r100.iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L6;
        UIntArray.m9609setVXSXFK8(r101, r103, r102.next().m9596unboximpl());
        r103 = r103 + 1;
        goto L4
    L6:
        return r101;
    }

    public static final long[] toULongArray(Collection<ULong> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        long[] r101 = ULongArray.m9677constructorimpl(r100.size());
        Iterator<ULong> r102 = r100.iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L6;
        ULongArray.m9688setk8EXiF4(r101, r103, r102.next().m9675unboximpl());
        r103 = r103 + 1;
        goto L4
    L6:
        return r101;
    }

    public static final short[] toUShortArray(Collection<UShort> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        short[] r101 = UShortArray.m9782constructorimpl(r100.size());
        Iterator<UShort> r102 = r100.iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L6;
        UShortArray.m9793set01HTLdE(r101, r103, r102.next().m9780unboximpl());
        r103 = r103 + 1;
        goto L4
    L6:
        return r101;
    }
}
