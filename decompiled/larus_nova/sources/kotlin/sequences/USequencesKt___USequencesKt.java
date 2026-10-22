package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\n0\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\u0005¨\u0006\f"}, d2 = {"sum", "Lkotlin/UInt;", "Lkotlin/sequences/Sequence;", "Lkotlin/UByte;", "sumOfUByte", "(Lkotlin/sequences/Sequence;)I", "sumOfUInt", "Lkotlin/ULong;", "sumOfULong", "(Lkotlin/sequences/Sequence;)J", "Lkotlin/UShort;", "sumOfUShort", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/sequences/USequencesKt")
class USequencesKt___USequencesKt {
    public USequencesKt___USequencesKt() {
    }

    public static final int sumOfUByte(Sequence<UByte> r100) {
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

    public static final int sumOfUInt(Sequence<UInt> r100) {
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

    public static final long sumOfULong(Sequence<ULong> r100) {
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

    public static final int sumOfUShort(Sequence<UShort> r100) {
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
}
