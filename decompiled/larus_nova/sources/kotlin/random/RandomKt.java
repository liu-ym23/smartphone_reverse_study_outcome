package kotlin.random;

import com.bytedance.ee.bear.sheet.filter.FilterData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0004H\u0007\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\fH\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000\u001a\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\u000f\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\u001a\u0014\u0010\u0012\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0013H\u0007\u001a\u0014\u0010\u0014\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0000¨\u0006\u0016"}, d2 = {"Random", "Lkotlin/random/Random;", "seed", "", "", "boundsErrorMessage", "", "from", "", "until", "checkRangeBounds", "", "", "fastLog2", "value", "nextInt", FilterData.FilterOptionItem.Type.RANGE, "Lkotlin/ranges/IntRange;", "nextLong", "Lkotlin/ranges/LongRange;", "takeUpperBits", "bitCount", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class RandomKt {
    public static final int takeUpperBits(int r100, int r101) {
        return (r100 >>> (32 - r101)) & ((-r101) >> 31);
    }

    public static final Random Random(long r100) {
        return new XorWowRandom((int) r100, (int) (r100 >> 32));
    }

    public static final int fastLog2(int r100) {
        return 31 - Integer.numberOfLeadingZeros(r100);
    }

    public static final Random Random(int r100) {
        return new XorWowRandom(r100, r100 >> 31);
    }

    public static final String boundsErrorMessage(Object r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Intrinsics.checkNotNullParameter(r101, "until");
        return "Random range is empty: [" + r100 + ", " + r101 + ").";
    }

    public static final void checkRangeBounds(double r100, double r101) {
        if (r101 <= r100) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(boundsErrorMessage(Double.valueOf(r100), Double.valueOf(r101)).toString());
    L5:
        r102 = false;
        goto L6
    }

    public static final int nextInt(Random r100, IntRange r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, FilterData.FilterOptionItem.Type.RANGE);
        if (r101.isEmpty() == true) goto L13;
        if (r101.getLast() >= Integer.MAX_VALUE) goto L8;
        return r100.nextInt(r101.getFirst(), r101.getLast() + 1);
    L8:
        if (r101.getFirst() <= Integer.MIN_VALUE) goto L11;
        return r100.nextInt(r101.getFirst() - 1, r101.getLast()) + 1;
    L11:
        return r100.nextInt();
    L13:
        throw new IllegalArgumentException("Cannot get random in empty range: " + r101);
    }

    public static final long nextLong(Random r100, LongRange r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, FilterData.FilterOptionItem.Type.RANGE);
        if (r101.isEmpty() == true) goto L13;
        if (r101.getLast() >= Long.MAX_VALUE) goto L8;
        return r100.nextLong(r101.getFirst(), r101.getLast() + 1);
    L8:
        if (r101.getFirst() <= Long.MIN_VALUE) goto L11;
        return r100.nextLong(r101.getFirst() - 1, r101.getLast()) + 1;
    L11:
        return r100.nextLong();
    L13:
        throw new IllegalArgumentException("Cannot get random in empty range: " + r101);
    }

    public static final void checkRangeBounds(long r100, long r101) {
        if (r101 <= r100) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(boundsErrorMessage(Long.valueOf(r100), Long.valueOf(r101)).toString());
    L5:
        r102 = false;
        goto L6
    }

    public static final void checkRangeBounds(int r100, int r101) {
        if (r101 <= r100) goto L4;
        boolean r102 = true;
    L5:
        if (r102 == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(boundsErrorMessage(Integer.valueOf(r100), Integer.valueOf(r101)).toString());
    L4:
        r102 = false;
        goto L5
    }
}
