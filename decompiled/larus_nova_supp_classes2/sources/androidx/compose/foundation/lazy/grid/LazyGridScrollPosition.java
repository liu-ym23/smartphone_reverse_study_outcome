package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u0003J\u0016\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003J\u0016\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"2\u0006\u0010\b\u001a\u00020\u0003J\u0018\u0010#\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0002R+\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00038F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR+\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00038F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\fR\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006$"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridScrollPosition;", "", "initialIndex", "", "initialScrollOffset", "<init>", "(II)V", "<set-?>", "index", "getIndex", "()I", "setIndex", "(I)V", "index$delegate", "Landroidx/compose/runtime/MutableIntState;", "scrollOffset", "getScrollOffset", "setScrollOffset", "scrollOffset$delegate", "hadFirstNotEmptyLayout", "", "lastKnownFirstItemKey", "nearestRangeState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "getNearestRangeState", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "updateFromMeasureResult", "", "measureResult", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "updateScrollOffset", "requestPositionAndForgetLastKnownKey", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "update", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LazyGridScrollPosition {
    public static final int $stable = 8;
    private boolean hadFirstNotEmptyLayout;
    private final MutableIntState index$delegate;
    private Object lastKnownFirstItemKey;
    private final LazyLayoutNearestRangeState nearestRangeState;
    private final MutableIntState scrollOffset$delegate;

    public LazyGridScrollPosition() {
        int r2 = 0;
        this(r2, r2, 3, null);
    }

    public final int getIndex() {
        return this.index$delegate.getIntValue();
    }

    public final int getScrollOffset() {
        return this.scrollOffset$delegate.getIntValue();
    }

    public final LazyLayoutNearestRangeState getNearestRangeState() {
        return this.nearestRangeState;
    }

    private final void setIndex(int r2) {
        this.index$delegate.setIntValue(r2);
    }

    private final void setScrollOffset(int r2) {
        this.scrollOffset$delegate.setIntValue(r2);
    }

    public final void updateFromMeasureResult(LazyGridMeasureResult r6) {
        LazyGridMeasuredLine r0 = r6.getFirstVisibleLine();
        if (r0 == null) goto L9;
        LazyGridMeasuredItem[] r1 = r0.getItems();
        if (r1 == null) goto L9;
        LazyGridMeasuredItem r2 = (LazyGridMeasuredItem) ArraysKt.firstOrNull(r1);
        if (r2 == null) goto L9;
        Object r3 = r2.getKey();
    L10:
        this.lastKnownFirstItemKey = r3;
        if (this.hadFirstNotEmptyLayout == false) goto L13;
    L14:
        boolean r4 = true;
        this.hadFirstNotEmptyLayout = true;
        int r5 = r6.getFirstVisibleLineScrollOffset();
        int r7 = 0;
        if (r5 >= MenuKt.ClosedAlphaTarget) goto L18;
        r4 = false;
    L18:
        if (r4 == true) goto L20;
        InlineClassHelperKt.throwIllegalStateException("scrollOffset should be non-negative (" + r5 + ')');
    L20:
        LazyGridMeasuredLine r8 = r6.getFirstVisibleLine();
        if (r8 == null) goto L27;
        LazyGridMeasuredItem[] r9 = r8.getItems();
        if (r9 == null) goto L27;
        LazyGridMeasuredItem r10 = (LazyGridMeasuredItem) ArraysKt.firstOrNull(r9);
        if (r10 == null) goto L27;
        r7 = r10.getIndex();
    L27:
        update(r7, r5);
        return;
    L13:
        if (r6.getTotalItemsCount() > 0) goto L14;
        return;
    L9:
        r3 = null;
        goto L10
    }

    public final void updateScrollOffset(int r3) {
        if (r3 < MenuKt.ClosedAlphaTarget) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        InlineClassHelperKt.throwIllegalStateException("scrollOffset should be non-negative");
    L8:
        setScrollOffset(r3);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public LazyGridScrollPosition(int r3, int r4) {
        this.index$delegate = SnapshotIntStateKt.mutableIntStateOf(r3);
        this.scrollOffset$delegate = SnapshotIntStateKt.mutableIntStateOf(r4);
        this.nearestRangeState = new LazyLayoutNearestRangeState(r3, 90, 200);
    }

    private final void update(int r3, int r4) {
        if (r3 < MenuKt.ClosedAlphaTarget) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("Index should be non-negative");
    L8:
        setIndex(r3);
        this.nearestRangeState.update(r3);
        setScrollOffset(r4);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void requestPositionAndForgetLastKnownKey(int r1, int r2) {
        update(r1, r2);
        this.lastKnownFirstItemKey = null;
    }

    public final int updateScrollPositionIfTheFirstItemWasMoved(LazyGridItemProvider r2, int r3) {
        int r4 = LazyLayoutItemProviderKt.findIndexByKey(r2, this.lastKnownFirstItemKey, r3);
        if (r3 == r4) goto L5;
        setIndex(r4);
        this.nearestRangeState.update(r3);
    L5:
        return r4;
    }

    public /* synthetic */ LazyGridScrollPosition(int r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = 0;
    L8:
        this(r2, r3);
    }
}
