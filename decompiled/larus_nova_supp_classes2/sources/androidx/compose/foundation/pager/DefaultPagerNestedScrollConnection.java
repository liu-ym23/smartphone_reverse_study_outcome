package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\f\u001a\u00020\r*\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ \u0010\u001b\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0096@¢\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f*\u00020\u0011H\u0002¢\u0006\u0004\b \u0010!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\""}, d2 = {"Landroidx/compose/foundation/pager/DefaultPagerNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "state", "Landroidx/compose/foundation/pager/PagerState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "<init>", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/gestures/Orientation;)V", "getState", "()Landroidx/compose/foundation/pager/PagerState;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "consumeOnOrientation", "Landroidx/compose/ui/unit/Velocity;", "consumeOnOrientation-QWom1Mo", "(JLandroidx/compose/foundation/gestures/Orientation;)J", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPostFling", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mainAxis", "", "mainAxis-k-4lQ0M", "(J)F", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DefaultPagerNestedScrollConnection implements NestedScrollConnection {
    private final Orientation orientation;
    private final PagerState state;

    /* JADX INFO: renamed from: onPreFling-QWom1Mo, reason: not valid java name */
    public final /* synthetic */ Object m1250onPreFlingQWom1Mo(long r1, Continuation r3) {
        return NestedScrollConnection.-CC.$default$onPreFling-QWom1Mo(this, r1, r3);
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    public final PagerState getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: mainAxis-k-4lQ0M, reason: not valid java name */
    private final float m1246mainAxisk4lQ0M(long r3) {
        if (this.orientation != Orientation.Horizontal) goto L5;
        long r4 = r3 >> 32;
    L7:
        return Float.intBitsToFloat((int) r4);
    L5:
        r4 = r3 & 4294967295L;
        goto L7
    }

    public DefaultPagerNestedScrollConnection(PagerState r1, Orientation r2) {
        this.state = r1;
        this.orientation = r2;
    }

    /* JADX INFO: renamed from: consumeOnOrientation-QWom1Mo, reason: not valid java name */
    public final long m1247consumeOnOrientationQWom1Mo(long r8, Orientation r10) {
        if (r10 != Orientation.Vertical) goto L6;
        return Velocity.copy-OhffZ5M$default(r8, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 2, null);
    L6:
        return Velocity.copy-OhffZ5M$default(r8, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 1, null);
    }

    /* JADX INFO: renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
    public long m1251onPreScrollOzD1aCk(long r10, int r12) {
        if (NestedScrollSource.equals-impl0(r12, NestedScrollSource.Companion.getUserInput-WNlRxjI()) == false) goto L23;
        if (Math.abs(this.state.getCurrentPageOffsetFraction()) <= 1.0E-6d) goto L23;
        float r13 = this.state.getCurrentPageOffsetFraction() * this.state.getPageSize$foundation_release();
        float r0 = ((this.state.getLayoutInfo().getPageSize() + this.state.getLayoutInfo().getPageSpacing()) * (-Math.signum(this.state.getCurrentPageOffsetFraction()))) + r13;
        if (this.state.getCurrentPageOffsetFraction() <= MenuKt.ClosedAlphaTarget) goto L9;
        r0 = r13;
        r13 = r0;
    L9:
        Orientation r1 = this.orientation;
        Orientation r2 = Orientation.Horizontal;
        if (r1 != r2) goto L12;
        long r6 = r10 >> 32;
    L13:
        float r14 = -this.state.dispatchRawDelta(-RangesKt.coerceIn(Float.intBitsToFloat((int) r6), r13, r0));
        if (this.orientation != r2) goto L16;
        float r3 = r14;
    L18:
        if (this.orientation == Orientation.Vertical) goto L24;
        r14 = Float.intBitsToFloat((int) (r10 & 4294967295L));
    L24:
        return Offset.copy-dBAh8RU(r10, r3, r14);
    L16:
        r3 = Float.intBitsToFloat((int) (r10 >> 32));
        goto L18
    L12:
        r6 = r10 & 4294967295L;
    L23:
        return Offset.Companion.getZero-F1C5BW0();
    }

    /* JADX INFO: renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
    public Object m1248onPostFlingRZ2iAVY(long r1, long r3, Continuation<? super Velocity> r5) {
        return Velocity.box-impl(m1247consumeOnOrientationQWom1Mo(r3, this.orientation));
    }

    /* JADX INFO: renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
    public long m1249onPostScrollDzOQY0M(long r1, long r3, int r5) {
        if (NestedScrollSource.equals-impl0(r5, NestedScrollSource.Companion.getSideEffect-WNlRxjI()) == false) goto L13;
        if (m1246mainAxisk4lQ0M(r3) != MenuKt.ClosedAlphaTarget) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L13;
        throw new CancellationException("Scroll cancelled");
    L7:
        r2 = false;
    L13:
        return Offset.Companion.getZero-F1C5BW0();
    }
}
