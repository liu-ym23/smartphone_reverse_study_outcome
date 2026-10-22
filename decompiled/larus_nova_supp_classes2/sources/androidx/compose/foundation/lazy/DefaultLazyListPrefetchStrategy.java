package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.NestedPrefetchScope;
import androidx.compose.foundation.lazy.layout.PrefetchScheduler;
import androidx.compose.material3.MenuKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0014\u0010\u0014\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0014\u0010\u0015\u001a\u00020\u000f*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0002J\u0014\u0010\u0019\u001a\u00020\u0003*\u00020\u00132\u0006\u0010\u001a\u001a\u00020\nH\u0002J\u001c\u0010\u001b\u001a\u00020\u000f*\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/lazy/DefaultLazyListPrefetchStrategy;", "Landroidx/compose/foundation/lazy/LazyListPrefetchStrategy;", "initialNestedPrefetchItemCount", "", "<init>", "(I)V", "indexToPrefetch", "currentPrefetchHandle", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "wasScrollingForward", "", "previousPassItemCount", "previousPassDelta", "", "onScroll", "", "Landroidx/compose/foundation/lazy/LazyListPrefetchScope;", "delta", "layoutInfo", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "onVisibleItemsUpdated", "onNestedPrefetch", "Landroidx/compose/foundation/lazy/layout/NestedPrefetchScope;", "firstVisibleItemIndex", "resetPrefetchState", "calculateIndexToPrefetch", "scrollingForward", "evaluatePrefetchForCancellation", "currentPrefetchingIndex", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DefaultLazyListPrefetchStrategy implements LazyListPrefetchStrategy {
    private LazyLayoutPrefetchState.PrefetchHandle currentPrefetchHandle;
    private int indexToPrefetch;
    private final int initialNestedPrefetchItemCount;
    private float previousPassDelta;
    private int previousPassItemCount;
    private boolean wasScrollingForward;

    public DefaultLazyListPrefetchStrategy() {
        int r2 = 0;
        this(r2, 1, null);
    }

    private final void resetPrefetchState() {
        this.indexToPrefetch = -1;
        LazyLayoutPrefetchState.PrefetchHandle r0 = this.currentPrefetchHandle;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.currentPrefetchHandle = null;
    }

    @Override // androidx.compose.foundation.lazy.LazyListPrefetchStrategy
    public final /* synthetic */ PrefetchScheduler getPrefetchScheduler() {
        return LazyListPrefetchStrategy.CC.$default$getPrefetchScheduler(this);
    }

    public DefaultLazyListPrefetchStrategy(int r1) {
        this.initialNestedPrefetchItemCount = r1;
        this.indexToPrefetch = -1;
        this.previousPassItemCount = -1;
    }

    private final int calculateIndexToPrefetch(LazyListLayoutInfo r1, boolean r2) {
        if (r2 == false) goto L5;
        return ((LazyListItemInfo) CollectionsKt.last(r1.getVisibleItemsInfo())).getIndex() + 1;
    L5:
        return ((LazyListItemInfo) CollectionsKt.first(r1.getVisibleItemsInfo())).getIndex() - 1;
    }

    @Override // androidx.compose.foundation.lazy.LazyListPrefetchStrategy
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

    @Override // androidx.compose.foundation.lazy.LazyListPrefetchStrategy
    public void onVisibleItemsUpdated(LazyListPrefetchScope r7, LazyListLayoutInfo r8) {
        evaluatePrefetchForCancellation(r8, this.indexToPrefetch, this.wasScrollingForward);
        int r0 = r8.getTotalItemsCount();
        int r1 = this.previousPassItemCount;
        if (r1 == (-1)) goto L23;
        boolean r4 = true;
        if (this.previousPassDelta != MenuKt.ClosedAlphaTarget) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L23;
        if (r1 == r0) goto L23;
        if ((!r8.getVisibleItemsInfo().isEmpty()) == false) goto L23;
        if (this.previousPassDelta >= MenuKt.ClosedAlphaTarget) goto L15;
        boolean r3 = true;
    L16:
        int r9 = calculateIndexToPrefetch(r8, r3);
        if (r9 < 0) goto L20;
        if (r9 >= r0) goto L20;
    L21:
        if (r4 == false) goto L23;
        this.indexToPrefetch = r9;
        this.currentPrefetchHandle = LazyListPrefetchScope.CC.schedulePrefetch$default(r7, r9, null, 2, null);
    L20:
        r4 = false;
        goto L21
    L15:
        r3 = false;
        goto L16
    L7:
        r2 = false;
    L23:
        this.previousPassItemCount = r0;
    }

    public /* synthetic */ DefaultLazyListPrefetchStrategy(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 2;
    L5:
        this(r1);
    }

    private final void evaluatePrefetchForCancellation(LazyListLayoutInfo r2, int r3, boolean r4) {
        if (r3 != (-1)) goto L5;
        return;
    L5:
        if ((!r2.getVisibleItemsInfo().isEmpty()) == true) goto L7;
        return;
    L7:
        if (r3 == calculateIndexToPrefetch(r2, r4)) goto L12;
        resetPrefetchState();
        return;
    }

    @Override // androidx.compose.foundation.lazy.LazyListPrefetchStrategy
    public void onScroll(LazyListPrefetchScope r6, float r7, LazyListLayoutInfo r8) {
        boolean r1 = true;
        if ((!r8.getVisibleItemsInfo().isEmpty()) == true) goto L5;
    L32:
        this.previousPassDelta = r7;
        return;
    L5:
        if (r7 >= MenuKt.ClosedAlphaTarget) goto L7;
        boolean r0 = true;
    L8:
        int r3 = calculateIndexToPrefetch(r8, r0);
        if (r3 >= 0) goto L11;
    L13:
        r1 = false;
    L14:
        if (r1 == false) goto L32;
        if (r3 != this.indexToPrefetch) goto L18;
    L21:
        if (r0 == false) goto L28;
        LazyListItemInfo r9 = (LazyListItemInfo) CollectionsKt.last(r8.getVisibleItemsInfo());
        if ((((r9.getOffset() + r9.getSize()) + r8.getMainAxisItemSpacing()) - r8.getViewportEndOffset()) >= (-r7)) goto L32;
        LazyLayoutPrefetchState.PrefetchHandle r10 = this.currentPrefetchHandle;
        if (r10 == null) goto L32;
        r10.markAsUrgent();
        goto L32
    L28:
        if ((r8.getViewportStartOffset() - ((LazyListItemInfo) CollectionsKt.first(r8.getVisibleItemsInfo())).getOffset()) >= r7) goto L32;
        LazyLayoutPrefetchState.PrefetchHandle r11 = this.currentPrefetchHandle;
        if (r11 == null) goto L32;
        r11.markAsUrgent();
        goto L32
    L18:
        if (this.wasScrollingForward == r0) goto L20;
        resetPrefetchState();
    L20:
        this.wasScrollingForward = r0;
        this.indexToPrefetch = r3;
        this.currentPrefetchHandle = LazyListPrefetchScope.CC.schedulePrefetch$default(r6, r3, null, 2, null);
        goto L21
    L11:
        if (r3 >= r8.getTotalItemsCount()) goto L13;
    L7:
        r0 = false;
        goto L8
    }
}
