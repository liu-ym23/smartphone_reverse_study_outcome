package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.LazyGridSnapLayoutInfoProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.NestedPrefetchScope;
import androidx.compose.foundation.lazy.layout.PrefetchScheduler;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0014\u0010\u0015\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0014\u0010\u0016\u001a\u00020\u0010*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J\u001c\u0010\u0019\u001a\u00020\u0010*\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u000bH\u0002J\u0014\u0010\u001c\u001a\u00020\u0003*\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u000bH\u0002J\u0014\u0010\u001d\u001a\u00020\u0003*\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u000bH\u0002J\b\u0010\u001e\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/lazy/grid/DefaultLazyGridPrefetchStrategy;", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchStrategy;", "initialNestedPrefetchItemCount", "", "<init>", "(I)V", "lineToPrefetch", "currentLinePrefetchHandles", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "wasScrollingForward", "", "previousPassItemCount", "previousPassDelta", "", "onScroll", "", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchScope;", "delta", "layoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "onVisibleItemsUpdated", "onNestedPrefetch", "Landroidx/compose/foundation/lazy/layout/NestedPrefetchScope;", "firstVisibleItemIndex", "evaluatePrefetchForCancellation", "currentPrefetchingLineIndex", "scrollingForward", "calculateLineIndexToPrefetch", "calculateClosestNextItemToPrefetch", "resetPrefetchState", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DefaultLazyGridPrefetchStrategy implements LazyGridPrefetchStrategy {
    private final MutableVector<LazyLayoutPrefetchState.PrefetchHandle> currentLinePrefetchHandles;
    private final int initialNestedPrefetchItemCount;
    private int lineToPrefetch;
    private float previousPassDelta;
    private int previousPassItemCount;
    private boolean wasScrollingForward;

    public DefaultLazyGridPrefetchStrategy() {
        int r2 = 0;
        this(r2, 1, null);
    }

    private final void resetPrefetchState() {
        this.lineToPrefetch = -1;
        MutableVector<LazyLayoutPrefetchState.PrefetchHandle> r0 = this.currentLinePrefetchHandles;
        Object[] r1 = r0.content;
        int r2 = r0.getSize();
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        ((LazyLayoutPrefetchState.PrefetchHandle) r1[r3]).cancel();
        r3 = r3 + 1;
        goto L3
    L5:
        this.currentLinePrefetchHandles.clear();
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridPrefetchStrategy
    public final /* synthetic */ PrefetchScheduler getPrefetchScheduler() {
        return LazyGridPrefetchStrategy.CC.$default$getPrefetchScheduler(this);
    }

    public DefaultLazyGridPrefetchStrategy(int r4) {
        this.initialNestedPrefetchItemCount = r4;
        this.lineToPrefetch = -1;
        this.currentLinePrefetchHandles = new MutableVector(new LazyLayoutPrefetchState.PrefetchHandle[16], 0);
        this.previousPassItemCount = -1;
    }

    private final int calculateClosestNextItemToPrefetch(LazyGridLayoutInfo r1, boolean r2) {
        if (r2 == false) goto L5;
        return ((LazyGridItemInfo) CollectionsKt.last(r1.getVisibleItemsInfo())).getIndex() + 1;
    L5:
        return ((LazyGridItemInfo) CollectionsKt.first(r1.getVisibleItemsInfo())).getIndex() - 1;
    }

    private final int calculateLineIndexToPrefetch(LazyGridLayoutInfo r2, boolean r3) {
        if (r3 == false) goto L8;
        LazyGridItemInfo r4 = (LazyGridItemInfo) CollectionsKt.last(r2.getVisibleItemsInfo());
        if (r2.getOrientation() != Orientation.Vertical) goto L6;
        int r5 = r4.getRow();
    L14:
        return r5 + 1;
    L6:
        r5 = r4.getColumn();
        goto L14
    L8:
        LazyGridItemInfo r6 = (LazyGridItemInfo) CollectionsKt.first(r2.getVisibleItemsInfo());
        if (r2.getOrientation() != Orientation.Vertical) goto L11;
        int r7 = r6.getRow();
    L13:
        return r7 - 1;
    L11:
        r7 = r6.getColumn();
        goto L13
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridPrefetchStrategy
    public void onNestedPrefetch(NestedPrefetchScope r4, int r5) {
        if (r4.getNestedPrefetchItemCount() != (-1)) goto L5;
        int r0 = this.initialNestedPrefetchItemCount;
    L6:
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L9;
        r4.schedulePrecomposition(r5 + r1);
        r1 = r1 + 1;
        goto L7
    L9:
        return;
    L5:
        r0 = r4.getNestedPrefetchItemCount();
        goto L6
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridPrefetchStrategy
    public void onVisibleItemsUpdated(LazyGridPrefetchScope r7, LazyGridLayoutInfo r8) {
        evaluatePrefetchForCancellation(r8, this.lineToPrefetch, this.wasScrollingForward);
        int r0 = r8.getTotalItemsCount();
        int r1 = this.previousPassItemCount;
        if (r1 == (-1)) goto L31;
        boolean r4 = true;
        if (this.previousPassDelta != MenuKt.ClosedAlphaTarget) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L31;
        if (r1 == r0) goto L31;
        if ((!r8.getVisibleItemsInfo().isEmpty()) == false) goto L31;
        if (this.previousPassDelta >= MenuKt.ClosedAlphaTarget) goto L15;
        boolean r3 = true;
    L16:
        int r5 = calculateLineIndexToPrefetch(r8, r3);
        if (this.previousPassDelta >= MenuKt.ClosedAlphaTarget) goto L19;
        boolean r6 = true;
    L20:
        int r9 = calculateClosestNextItemToPrefetch(r8, r6);
        if (r9 >= 0) goto L23;
    L25:
        r4 = false;
    L26:
        if (r4 == false) goto L31;
        if (r5 == this.lineToPrefetch) goto L31;
        if (r5 < 0) goto L31;
        this.lineToPrefetch = r5;
        this.currentLinePrefetchHandles.clear();
        MutableVector<LazyLayoutPrefetchState.PrefetchHandle> r10 = this.currentLinePrefetchHandles;
        r10.addAll(r10.getSize(), r7.scheduleLinePrefetch(r5));
        goto L31
    L23:
        if (r9 >= r8.getTotalItemsCount()) goto L25;
    L19:
        r6 = false;
        goto L20
    L15:
        r3 = false;
        goto L16
    L7:
        r2 = false;
    L31:
        this.previousPassItemCount = r0;
    }

    public /* synthetic */ DefaultLazyGridPrefetchStrategy(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 2;
    L5:
        this(r1);
    }

    private final void evaluatePrefetchForCancellation(LazyGridLayoutInfo r2, int r3, boolean r4) {
        if (r3 != (-1)) goto L5;
        return;
    L5:
        if ((!r2.getVisibleItemsInfo().isEmpty()) == true) goto L7;
        return;
    L7:
        if (r3 == calculateLineIndexToPrefetch(r2, r4)) goto L12;
        resetPrefetchState();
        return;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridPrefetchStrategy
    public void onScroll(LazyGridPrefetchScope r8, float r9, LazyGridLayoutInfo r10) {
        boolean r1 = true;
        if ((!r10.getVisibleItemsInfo().isEmpty()) == false) goto L35;
        int r2 = 0;
        if (r9 >= MenuKt.ClosedAlphaTarget) goto L7;
        boolean r0 = true;
    L8:
        int r3 = calculateLineIndexToPrefetch(r10, r0);
        int r4 = calculateClosestNextItemToPrefetch(r10, r0);
        if (r4 >= 0) goto L11;
    L13:
        r1 = false;
    L14:
        if (r1 == false) goto L35;
        if (r3 == this.lineToPrefetch) goto L24;
        if (r3 < 0) goto L24;
        if (this.wasScrollingForward == r0) goto L23;
        MutableVector<LazyLayoutPrefetchState.PrefetchHandle> r5 = this.currentLinePrefetchHandles;
        Object[] r6 = r5.content;
        int r7 = r5.getSize();
        int r11 = 0;
    L21:
        if (r11 >= r7) goto L23;
        ((LazyLayoutPrefetchState.PrefetchHandle) r6[r11]).cancel();
        r11 = r11 + 1;
    L23:
        this.wasScrollingForward = r0;
        this.lineToPrefetch = r3;
        this.currentLinePrefetchHandles.clear();
        MutableVector<LazyLayoutPrefetchState.PrefetchHandle> r12 = this.currentLinePrefetchHandles;
        r12.addAll(r12.getSize(), r8.scheduleLinePrefetch(r3));
    L24:
        if (r0 == false) goto L31;
        LazyGridItemInfo r13 = (LazyGridItemInfo) CollectionsKt.last(r10.getVisibleItemsInfo());
        int r14 = LazyGridSnapLayoutInfoProviderKt.sizeOnMainAxis(r13, r10.getOrientation());
        if ((((LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(r13, r10.getOrientation()) + r14) + r10.getMainAxisItemSpacing()) - r10.getViewportEndOffset()) >= (-r9)) goto L35;
        MutableVector<LazyLayoutPrefetchState.PrefetchHandle> r15 = this.currentLinePrefetchHandles;
        Object[] r16 = r15.content;
        int r17 = r15.getSize();
    L28:
        if (r2 >= r17) goto L35;
        ((LazyLayoutPrefetchState.PrefetchHandle) r16[r2]).markAsUrgent();
        r2 = r2 + 1;
        goto L28
    L31:
        if ((r10.getViewportStartOffset() - LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis((LazyGridItemInfo) CollectionsKt.first(r10.getVisibleItemsInfo()), r10.getOrientation())) >= r9) goto L35;
        MutableVector<LazyLayoutPrefetchState.PrefetchHandle> r18 = this.currentLinePrefetchHandles;
        Object[] r19 = r18.content;
        int r20 = r18.getSize();
    L33:
        if (r2 >= r20) goto L35;
        ((LazyLayoutPrefetchState.PrefetchHandle) r19[r2]).markAsUrgent();
        r2 = r2 + 1;
        goto L33
    L11:
        if (r4 >= r10.getTotalItemsCount()) goto L13;
    L7:
        r0 = false;
    L35:
        this.previousPassDelta = r9;
    }
}
