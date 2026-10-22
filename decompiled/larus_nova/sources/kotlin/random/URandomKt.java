package kotlin.random;

import com.bytedance.ee.bear.sheet.filter.FilterData;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.ULongRange;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\bH\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0019\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001a\u001b\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u0011\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a/\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0011\u0010\u0018\u001a\u00020\u0003*\u00020\rH\u0007¢\u0006\u0002\u0010\u0019\u001a\u001b\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a#\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0019\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010 \u001a\u0011\u0010!\u001a\u00020\b*\u00020\rH\u0007¢\u0006\u0002\u0010\"\u001a\u001b\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u0004\u001a\u00020\bH\u0007¢\u0006\u0004\b#\u0010$\u001a#\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\bH\u0007¢\u0006\u0004\b%\u0010&\u001a\u0019\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u001e\u001a\u00020'H\u0007¢\u0006\u0002\u0010(¨\u0006)"}, d2 = {"checkUIntRangeBounds", "", "from", "Lkotlin/UInt;", "until", "checkUIntRangeBounds-J1ME1BU", "(II)V", "checkULongRangeBounds", "Lkotlin/ULong;", "checkULongRangeBounds-eb3DHEI", "(JJ)V", "nextUBytes", "Lkotlin/UByteArray;", "Lkotlin/random/Random;", "size", "", "(Lkotlin/random/Random;I)[B", "array", "nextUBytes-EVgfTAA", "(Lkotlin/random/Random;[B)[B", "fromIndex", "toIndex", "nextUBytes-Wvrt4B4", "(Lkotlin/random/Random;[BII)[B", "nextUInt", "(Lkotlin/random/Random;)I", "nextUInt-qCasIEU", "(Lkotlin/random/Random;I)I", "nextUInt-a8DCA5k", "(Lkotlin/random/Random;II)I", FilterData.FilterOptionItem.Type.RANGE, "Lkotlin/ranges/UIntRange;", "(Lkotlin/random/Random;Lkotlin/ranges/UIntRange;)I", "nextULong", "(Lkotlin/random/Random;)J", "nextULong-V1Xi4fY", "(Lkotlin/random/Random;J)J", "nextULong-jmpaW-c", "(Lkotlin/random/Random;JJ)J", "Lkotlin/ranges/ULongRange;", "(Lkotlin/random/Random;Lkotlin/ranges/ULongRange;)J", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class URandomKt {
    public static final int nextUInt(Random r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return UInt.m9544constructorimpl(r100.nextInt());
    }

    public static final long nextULong(Random r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return ULong.m9623constructorimpl(r100.nextLong());
    }

    /* JADX INFO: renamed from: checkUIntRangeBounds-J1ME1BU, reason: not valid java name */
    public static final void m10667checkUIntRangeBoundsJ1ME1BU(int r100, int r101) {
        if (Integer.compare(r101 ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ r100) <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(RandomKt.boundsErrorMessage(UInt.m9538boximpl(r100), UInt.m9538boximpl(r101)).toString());
    L5:
        r102 = false;
        goto L6
    }

    /* JADX INFO: renamed from: checkULongRangeBounds-eb3DHEI, reason: not valid java name */
    public static final void m10668checkULongRangeBoundseb3DHEI(long r100, long r101) {
        if (Long.compare(r101 ^ Long.MIN_VALUE, Long.MIN_VALUE ^ r100) <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(RandomKt.boundsErrorMessage(ULong.m9617boximpl(r100), ULong.m9617boximpl(r101)).toString());
    L5:
        r102 = false;
        goto L6
    }

    public static final byte[] nextUBytes(Random r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return UByteArray.m9520constructorimpl(r100.nextBytes(r101));
    }

    /* JADX INFO: renamed from: nextUBytes-EVgfTAA, reason: not valid java name */
    public static final byte[] m10669nextUBytesEVgfTAA(Random r100, byte[] r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(r101, "array");
        r100.nextBytes(r101);
        return r101;
    }

    public static final int nextUInt(Random r100, UIntRange r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, FilterData.FilterOptionItem.Type.RANGE);
        if (r101.isEmpty() == true) goto L13;
        if (Integer.compare(r101.m10677getLastpVg5ArA() ^ Integer.MIN_VALUE, Integer.MAX_VALUE) >= 0) goto L8;
        return m10672nextUInta8DCA5k(r100, r101.m10676getFirstpVg5ArA(), UInt.m9544constructorimpl(r101.m10677getLastpVg5ArA() + 1));
    L8:
        if (Integer.compare(r101.m10676getFirstpVg5ArA() ^ Integer.MIN_VALUE, Integer.MIN_VALUE) <= 0) goto L11;
        return UInt.m9544constructorimpl(m10672nextUInta8DCA5k(r100, UInt.m9544constructorimpl(r101.m10676getFirstpVg5ArA() - 1), r101.m10677getLastpVg5ArA()) + 1);
    L11:
        return nextUInt(r100);
    L13:
        throw new IllegalArgumentException("Cannot get random in empty range: " + r101);
    }

    /* JADX INFO: renamed from: nextUInt-qCasIEU, reason: not valid java name */
    public static final int m10673nextUIntqCasIEU(Random r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$nextUInt");
        return m10672nextUInta8DCA5k(r100, 0, r101);
    }

    public static final long nextULong(Random r100, ULongRange r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, FilterData.FilterOptionItem.Type.RANGE);
        if (r101.isEmpty() == true) goto L13;
        if (Long.compare(r101.m10686getLastsVKNKU() ^ Long.MIN_VALUE, Long.MAX_VALUE) >= 0) goto L8;
        return m10675nextULongjmpaWc(r100, r101.m10685getFirstsVKNKU(), ULong.m9623constructorimpl(r101.m10686getLastsVKNKU() + ULong.m9623constructorimpl(((long) 1) & BodyPartID.bodyIdMax)));
    L8:
        if (Long.compare(r101.m10685getFirstsVKNKU() ^ Long.MIN_VALUE, Long.MIN_VALUE) <= 0) goto L11;
        long r102 = r101.m10685getFirstsVKNKU();
        long r103 = ((long) 1) & BodyPartID.bodyIdMax;
        return ULong.m9623constructorimpl(m10675nextULongjmpaWc(r100, ULong.m9623constructorimpl(r102 - ULong.m9623constructorimpl(r103)), r101.m10686getLastsVKNKU()) + ULong.m9623constructorimpl(r103));
    L11:
        return nextULong(r100);
    L13:
        throw new IllegalArgumentException("Cannot get random in empty range: " + r101);
    }

    /* JADX INFO: renamed from: nextULong-V1Xi4fY, reason: not valid java name */
    public static final long m10674nextULongV1Xi4fY(Random r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$nextULong");
        return m10675nextULongjmpaWc(r100, 0, r101);
    }

    /* JADX INFO: renamed from: nextUInt-a8DCA5k, reason: not valid java name */
    public static final int m10672nextUInta8DCA5k(Random r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$nextUInt");
        m10667checkUIntRangeBoundsJ1ME1BU(r101, r102);
        return UInt.m9544constructorimpl(r100.nextInt(r101 ^ Integer.MIN_VALUE, r102 ^ Integer.MIN_VALUE) ^ Integer.MIN_VALUE);
    }

    /* JADX INFO: renamed from: nextULong-jmpaW-c, reason: not valid java name */
    public static final long m10675nextULongjmpaWc(Random r100, long r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$nextULong");
        m10668checkULongRangeBoundseb3DHEI(r101, r102);
        return ULong.m9623constructorimpl(r100.nextLong(r101 ^ Long.MIN_VALUE, r102 ^ Long.MIN_VALUE) ^ Long.MIN_VALUE);
    }

    /* JADX INFO: renamed from: nextUBytes-Wvrt4B4, reason: not valid java name */
    public static final byte[] m10670nextUBytesWvrt4B4(Random r100, byte[] r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(r101, "array");
        r100.nextBytes(r101, r102, r103);
        return r101;
    }

    /* JADX INFO: renamed from: nextUBytes-Wvrt4B4$default, reason: not valid java name */
    public static /* synthetic */ byte[] m10671nextUBytesWvrt4B4$default(Random r100, byte[] r101, int r102, int r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = 0;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = UByteArray.m9526getSizeimpl(r101);
    L9:
        return m10670nextUBytesWvrt4B4(r100, r101, r102, r103);
    }
}
