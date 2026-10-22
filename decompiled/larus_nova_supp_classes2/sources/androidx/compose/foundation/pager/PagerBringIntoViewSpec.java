package androidx.compose.foundation.pager;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.BringIntoViewSpec;
import androidx.compose.material3.MenuKt;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/pager/PagerBringIntoViewSpec;", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "defaultBringIntoViewSpec", "<init>", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/gestures/BringIntoViewSpec;)V", "getPagerState", "()Landroidx/compose/foundation/pager/PagerState;", "getDefaultBringIntoViewSpec", "()Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "calculateScrollDistance", "", "offset", "size", "containerSize", "overrideProposedOffsetMove", "proposedOffsetMove", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class PagerBringIntoViewSpec implements BringIntoViewSpec {
    private final BringIntoViewSpec defaultBringIntoViewSpec;
    private final PagerState pagerState;

    @Override // androidx.compose.foundation.gestures.BringIntoViewSpec
    public final /* synthetic */ AnimationSpec getScrollAnimationSpec() {
        return BringIntoViewSpec.CC.$default$getScrollAnimationSpec(this);
    }

    public final BringIntoViewSpec getDefaultBringIntoViewSpec() {
        return this.defaultBringIntoViewSpec;
    }

    public final PagerState getPagerState() {
        return this.pagerState;
    }

    private final float overrideProposedOffsetMove(float r4) {
        float r0 = this.pagerState.getFirstVisiblePageOffset$foundation_release() * (-1);
    L4:
        if (r4 <= MenuKt.ClosedAlphaTarget) goto L9;
        if (r0 >= r4) goto L9;
        r0 = r0 + this.pagerState.getPageSizeWithSpacing$foundation_release();
    L9:
        if (r4 >= MenuKt.ClosedAlphaTarget) goto L13;
        if (r0 <= r4) goto L13;
        r0 = r0 - this.pagerState.getPageSizeWithSpacing$foundation_release();
    L13:
        return r0;
    }

    public PagerBringIntoViewSpec(PagerState r1, BringIntoViewSpec r2) {
        this.pagerState = r1;
        this.defaultBringIntoViewSpec = r2;
    }

    @Override // androidx.compose.foundation.gestures.BringIntoViewSpec
    public float calculateScrollDistance(float r6, float r7, float r8) {
        float r0 = this.defaultBringIntoViewSpec.calculateScrollDistance(r6, r7, r8);
        boolean r1 = true;
        if (r6 <= MenuKt.ClosedAlphaTarget) goto L8;
        if ((r6 + r7) > r8) goto L9;
    L10:
        boolean r9 = false;
    L12:
        if (Math.abs(r0) == MenuKt.ClosedAlphaTarget) goto L15;
        r1 = false;
    L15:
        if (r1 == true) goto L19;
        if (r9 == false) goto L19;
        return overrideProposedOffsetMove(r0);
    L19:
        if (Math.abs(this.pagerState.getFirstVisiblePageOffset$foundation_release()) < 1.0E-6d) goto L27;
        float r10 = this.pagerState.getFirstVisiblePageOffset$foundation_release() * (-1.0f);
        if (this.pagerState.getLastScrolledForward() == false) goto L25;
        r10 = r10 + this.pagerState.getPageSizeWithSpacing$foundation_release();
    L25:
        return RangesKt.coerceIn(r10, -r8, r8);
    L27:
        return MenuKt.ClosedAlphaTarget;
    L9:
        r9 = true;
        goto L12
    L8:
        if ((r6 + r7) > MenuKt.ClosedAlphaTarget) goto L10;
        goto L9
    }
}
