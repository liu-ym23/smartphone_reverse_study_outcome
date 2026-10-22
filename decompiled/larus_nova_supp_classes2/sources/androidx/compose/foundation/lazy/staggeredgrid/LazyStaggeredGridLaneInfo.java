package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0001\u0018\u0000 !2\u00020\u0001:\u0002 !B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005J\u0006\u0010\u0013\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0005J\u0006\u0010\u0015\u001a\u00020\fJ\u0016\u0010\u0016\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005J\u0016\u0010\u0017\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0005J\u0018\u0010\u001a\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u0005J\u001a\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo;", "", "<init>", "()V", "anchor", "", "lanes", "", "spannedItems", "Lkotlin/collections/ArrayDeque;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo$SpannedItem;", "setLane", "", "itemIndex", "lane", "getLane", "assignedToLane", "", "targetLane", "upperBound", "lowerBound", "reset", "findPreviousItemIndex", "findNextItemIndex", "ensureValidIndex", "requestedIndex", "setGaps", "gaps", "getGaps", "ensureCapacity", "capacity", "newOffset", "SpannedItem", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LazyStaggeredGridLaneInfo {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    public static final int LaneFullSpan = -2;
    public static final int LaneUnset = -1;
    private static final int MaxCapacity = 131072;
    private int anchor;
    private int[] lanes;
    private final ArrayDeque<SpannedItem> spannedItems;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo$Companion;", "", "<init>", "()V", "MaxCapacity", "", "LaneUnset", "LaneFullSpan", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo$SpannedItem;", "", "index", "", "gaps", "", "<init>", "(I[I)V", "getIndex", "()I", "getGaps", "()[I", "setGaps", "([I)V", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SpannedItem {
        private int[] gaps;
        private final int index;

        public final int[] getGaps() {
            return this.gaps;
        }

        public final int getIndex() {
            return this.index;
        }

        public final void setGaps(int[] r1) {
            this.gaps = r1;
        }

        public SpannedItem(int r1, int[] r2) {
            this.index = r1;
            this.gaps = r2;
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    public final void reset() {
        ArraysKt.fill$default(this.lanes, 0, 0, 0, 6, null);
        this.spannedItems.clear();
    }

    public final int upperBound() {
        return this.anchor + this.lanes.length;
    }

    public LazyStaggeredGridLaneInfo() {
        this.lanes = new int[16];
        this.spannedItems = new ArrayDeque();
    }

    public final int lowerBound() {
        return this.anchor;
    }

    public final void ensureValidIndex(int r8) {
        int r0 = this.anchor;
        int r1 = r8 - r0;
        if (r1 < 0) goto L6;
        if (r1 >= MaxCapacity) goto L6;
        boolean r5 = true;
    L8:
        if (r5 == false) goto L10;
        ensureCapacity$default(this, r1 + 1, 0, 2, null);
    L24:
        if ((!this.spannedItems.isEmpty()) == false) goto L29;
        if (((SpannedItem) this.spannedItems.first()).getIndex() >= lowerBound()) goto L29;
        this.spannedItems.removeFirst();
    L29:
        if ((!this.spannedItems.isEmpty()) == false) goto L33;
        if (((SpannedItem) this.spannedItems.last()).getIndex() <= upperBound()) goto L40;
        this.spannedItems.removeLast();
        goto L29
    L40:
        return;
    L33:
        return;
    L10:
        int r9 = Math.max(r8 - (this.lanes.length / 2), 0);
        this.anchor = r9;
        int r10 = r9 - r0;
        if (r10 < 0) goto L16;
        int[] r2 = this.lanes;
        if (r10 >= r2.length) goto L15;
        ArraysKt.copyInto(r2, r2, 0, r10, r2.length);
    L15:
        int[] r3 = this.lanes;
        ArraysKt.fill(r3, 0, Math.max(0, r3.length - r10), this.lanes.length);
        goto L24
    L16:
        int r11 = -r10;
        int[] r4 = this.lanes;
        if ((r4.length + r11) >= MaxCapacity) goto L20;
        ensureCapacity((r4.length + r11) + 1, r11);
        goto L24
    L20:
        if (r11 >= r4.length) goto L22;
        ArraysKt.copyInto(r4, r4, r11, 0, r4.length - r11);
    L22:
        int[] r6 = this.lanes;
        ArraysKt.fill(r6, 0, 0, Math.min(r6.length, r11));
    L6:
        r5 = false;
        goto L8
    }

    public final int[] getGaps(int r4) {
        ArrayDeque<SpannedItem> r0 = this.spannedItems;
        final Integer r5 = Integer.valueOf(r4);
        int r6 = CollectionsKt.binarySearch(r0, 0, r0.size(), new LazyStaggeredGridLaneInfo$getGaps$$inlined$binarySearchBy$default$1(r5));
        SpannedItem r7 = (SpannedItem) CollectionsKt.getOrNull(this.spannedItems, r6);
        if (r7 != null) goto L7;
        return null;
    L7:
        return r7.getGaps();
    }

    public final int getLane(int r3) {
        if (r3 >= lowerBound()) goto L5;
        return -1;
    L5:
        if (r3 < upperBound()) goto L8;
        return -1;
    L8:
        return this.lanes[r3 - this.anchor] - 1;
    }

    private final void ensureCapacity(int r9, int r10) {
        if (r9 > MaxCapacity) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("Requested item capacity " + r9 + " is larger than max supported: 131072!");
    L8:
        int[] r1 = this.lanes;
        if (r1.length >= r9) goto L16;
        int r2 = r1.length;
    L11:
        if (r2 >= r9) goto L13;
        r2 = r2 * 2;
        goto L11
    L13:
        this.lanes = ArraysKt.copyInto$default(this.lanes, new int[r2], r10, 0, 0, 12, null);
        return;
    L16:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final boolean assignedToLane(int r1, int r2) {
        int r3 = getLane(r1);
        if (r3 != r2) goto L5;
    L10:
        return true;
    L5:
        if (r3 == (-1)) goto L10;
        if (r3 == (-2)) goto L10;
        return false;
    }

    public final int findNextItemIndex(int r3, int r4) {
        int r5 = r3 + 1;
        int r0 = upperBound();
    L3:
        if (r5 >= r0) goto L9;
        if (assignedToLane(r5, r4) == true) goto L6;
        r5 = r5 + 1;
        goto L3
    L6:
        return r5;
    L9:
        return upperBound();
    }

    public final int findPreviousItemIndex(int r2, int r3) {
    L3:
        r2 = r2 - 1;
        if ((-1) >= r2) goto L9;
        if (assignedToLane(r2, r3) == false) goto L3;
        return r2;
    L9:
        return -1;
    }

    public final void setGaps(int r5, int[] r6) {
        ArrayDeque<SpannedItem> r0 = this.spannedItems;
        final Integer r1 = Integer.valueOf(r5);
        int r2 = CollectionsKt.binarySearch(r0, 0, r0.size(), new LazyStaggeredGridLaneInfo$setGaps$$inlined$binarySearchBy$default$1(r1));
        if (r2 >= 0) goto L7;
        if (r6 != null) goto L6;
        return;
    L6:
        ArrayDeque<SpannedItem> r3 = this.spannedItems;
        r3.add(-(r2 + 1), new SpannedItem(r5, r6));
        return;
    L7:
        if (r6 != null) goto L9;
        this.spannedItems.remove(r2);
        return;
    L9:
        ((SpannedItem) this.spannedItems.get(r2)).setGaps(r6);
    }

    public final void setLane(int r4, int r5) {
        if (r4 < 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("Negative lanes are not supported");
    L8:
        ensureValidIndex(r4);
        this.lanes[r4 - this.anchor] = r5 + 1;
        return;
    L5:
        r1 = false;
        goto L6
    }

    public static /* synthetic */ void ensureCapacity$default(LazyStaggeredGridLaneInfo r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = 0;
    L5:
        r0.ensureCapacity(r1, r2);
    }
}
