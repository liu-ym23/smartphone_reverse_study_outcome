package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotIntStateKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u0016\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0005J\u0016\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)2\u0006\u0010%\u001a\u00020\u0003J\u0018\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0005H\u0002J\u000e\u0010,\u001a\u00020!2\u0006\u0010&\u001a\u00020\u0005J\u000e\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020\u0003R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR+\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00038F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R+\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00058F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006/"}, d2 = {"Landroidx/compose/foundation/pager/PagerScrollPosition;", "", "currentPage", "", "currentPageOffsetFraction", "", "state", "Landroidx/compose/foundation/pager/PagerState;", "<init>", "(IFLandroidx/compose/foundation/pager/PagerState;)V", "getState", "()Landroidx/compose/foundation/pager/PagerState;", "<set-?>", "getCurrentPage", "()I", "setCurrentPage", "(I)V", "currentPage$delegate", "Landroidx/compose/runtime/MutableIntState;", "getCurrentPageOffsetFraction", "()F", "setCurrentPageOffsetFraction", "(F)V", "currentPageOffsetFraction$delegate", "Landroidx/compose/runtime/MutableFloatState;", "hadFirstNotEmptyLayout", "", "lastKnownCurrentPageKey", "nearestRangeState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "getNearestRangeState", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "updateFromMeasureResult", "", "measureResult", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "requestPositionAndForgetLastKnownKey", "index", "offsetFraction", "matchPageWithKey", "itemProvider", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "update", "page", "updateCurrentPageOffsetFraction", "applyScrollDelta", "delta", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PagerScrollPosition {
    public static final int $stable = 8;
    private final MutableIntState currentPage$delegate;
    private final MutableFloatState currentPageOffsetFraction$delegate;
    private boolean hadFirstNotEmptyLayout;
    private Object lastKnownCurrentPageKey;
    private final LazyLayoutNearestRangeState nearestRangeState;
    private final PagerState state;

    public final int getCurrentPage() {
        return this.currentPage$delegate.getIntValue();
    }

    public final float getCurrentPageOffsetFraction() {
        return this.currentPageOffsetFraction$delegate.getFloatValue();
    }

    public final LazyLayoutNearestRangeState getNearestRangeState() {
        return this.nearestRangeState;
    }

    public final PagerState getState() {
        return this.state;
    }

    private final void setCurrentPage(int r2) {
        this.currentPage$delegate.setIntValue(r2);
    }

    private final void setCurrentPageOffsetFraction(float r2) {
        this.currentPageOffsetFraction$delegate.setFloatValue(r2);
    }

    public final void applyScrollDelta(int r2) {
        if (this.state.getPageSizeWithSpacing$foundation_release() != 0) goto L5;
        float r3 = MenuKt.ClosedAlphaTarget;
    L6:
        setCurrentPageOffsetFraction(getCurrentPageOffsetFraction() + r3);
        return;
    L5:
        r3 = r2 / this.state.getPageSizeWithSpacing$foundation_release();
        goto L6
    }

    public final void updateCurrentPageOffsetFraction(float r1) {
        setCurrentPageOffsetFraction(r1);
    }

    public final void updateFromMeasureResult(PagerMeasureResult r3) {
        MeasuredPage r0 = r3.getCurrentPage();
        if (r0 == null) goto L5;
        Object r1 = r0.getKey();
    L6:
        this.lastKnownCurrentPageKey = r1;
        if (this.hadFirstNotEmptyLayout == false) goto L9;
    L10:
        this.hadFirstNotEmptyLayout = true;
        MeasuredPage r2 = r3.getCurrentPage();
        if (r2 == null) goto L13;
        int r4 = r2.getIndex();
    L14:
        update(r4, r3.getCurrentPageOffsetFraction());
        return;
    L13:
        r4 = 0;
        goto L14
    L9:
        if ((!r3.getVisiblePagesInfo().isEmpty()) == true) goto L10;
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void update(int r2, float r3) {
        setCurrentPage(r2);
        this.nearestRangeState.update(r2);
        setCurrentPageOffsetFraction(r3);
    }

    public final int matchPageWithKey(PagerLazyLayoutItemProvider r2, int r3) {
        int r4 = LazyLayoutItemProviderKt.findIndexByKey(r2, this.lastKnownCurrentPageKey, r3);
        if (r3 == r4) goto L5;
        setCurrentPage(r4);
        this.nearestRangeState.update(r3);
    L5:
        return r4;
    }

    public final void requestPositionAndForgetLastKnownKey(int r1, float r2) {
        update(r1, r2);
        this.lastKnownCurrentPageKey = null;
    }

    public PagerScrollPosition(int r2, float r3, PagerState r4) {
        this.state = r4;
        this.currentPage$delegate = SnapshotIntStateKt.mutableIntStateOf(r2);
        this.currentPageOffsetFraction$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(r3);
        this.nearestRangeState = new LazyLayoutNearestRangeState(r2, 30, 100);
    }

    public /* synthetic */ PagerScrollPosition(int r1, float r2, PagerState r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r2 = MenuKt.ClosedAlphaTarget;
    L8:
        this(r1, r2, r3);
    }
}
