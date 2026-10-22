package androidx.compose.foundation.gestures;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0017H\u0096@¢\u0006\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollableNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollLogic;", "enabled", "", "<init>", "(Landroidx/compose/foundation/gestures/ScrollLogic;Z)V", "getScrollingLogic", "()Landroidx/compose/foundation/gestures/ScrollLogic;", "getEnabled", "()Z", "setEnabled", "(Z)V", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "consumed", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScrollableNestedScrollConnection implements NestedScrollConnection {
    public static final int $stable = 8;
    private boolean enabled;
    private final ScrollLogic scrollingLogic;

    /* JADX INFO: renamed from: onPreFling-QWom1Mo, reason: not valid java name */
    public final /* synthetic */ Object m683onPreFlingQWom1Mo(long r1, Continuation r3) {
        return NestedScrollConnection.-CC.$default$onPreFling-QWom1Mo(this, r1, r3);
    }

    /* JADX INFO: renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
    public final /* synthetic */ long m684onPreScrollOzD1aCk(long r1, int r3) {
        return NestedScrollConnection.-CC.$default$onPreScroll-OzD1aCk(this, r1, r3);
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final ScrollLogic getScrollingLogic() {
        return this.scrollingLogic;
    }

    public final void setEnabled(boolean r1) {
        this.enabled = r1;
    }

    public ScrollableNestedScrollConnection(ScrollLogic r1, boolean r2) {
        this.scrollingLogic = r1;
        this.enabled = r2;
    }

    /* JADX INFO: renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
    public Object m681onPostFlingRZ2iAVY(long r3, long r5, Continuation<? super Velocity> r7) {
        if ((r7 instanceof ScrollableNestedScrollConnection$onPostFling$1) == false) goto L7;
        ScrollableNestedScrollConnection$onPostFling$1 r4 = (ScrollableNestedScrollConnection$onPostFling$1) r7;
        int r6 = r4.label;
        if ((r6 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r4.label = r6 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r8 = r4.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = r4.label;
        if (r0 == 0) goto L14;
        if (r0 != 1) goto L13;
        r5 = r4.J$0;
        ResultKt.throwOnFailure(r8);
    L22:
        long r10 = ((Velocity) r8).unbox-impl();
    L23:
        long r11 = Velocity.minus-AH228Gc(r5, r10);
    L26:
        return Velocity.box-impl(r11);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        if (this.enabled == true) goto L17;
        r11 = Velocity.Companion.getZero-9UxMQ8M();
        goto L26
    L17:
        if (this.scrollingLogic.isFlinging() == false) goto L19;
        r10 = Velocity.Companion.getZero-9UxMQ8M();
        goto L23
    L19:
        ScrollLogic r12 = this.scrollingLogic;
        r4.J$0 = r5;
        r4.label = 1;
        r8 = r12.mo656doFlingAnimationQWom1Mo(r5, r4);
        if (r8 != r9) goto L22;
        return r9;
    L7:
        r4 = new ScrollableNestedScrollConnection$onPostFling$1(this, r7);
        goto L8
    }

    /* JADX INFO: renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
    public long m682onPostScrollDzOQY0M(long r1, long r3, int r5) {
        if (this.enabled == false) goto L6;
        return this.scrollingLogic.mo657performRawScrollMKHz9U(r3);
    L6:
        return Offset.Companion.getZero-F1C5BW0();
    }
}
