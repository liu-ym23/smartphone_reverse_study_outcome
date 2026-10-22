package androidx.compose.material3;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ \u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"androidx/compose/material3/ExitAlwaysScrollBehavior$nestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "consumed", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExitAlwaysScrollBehavior$nestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ ExitAlwaysScrollBehavior this$0;

    /* JADX INFO: renamed from: onPreFling-QWom1Mo, reason: not valid java name */
    public final /* synthetic */ Object m2661onPreFlingQWom1Mo(long r1, Continuation r3) {
        return NestedScrollConnection.-CC.$default$onPreFling-QWom1Mo(this, r1, r3);
    }

    /* JADX INFO: renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
    public final /* synthetic */ long m2662onPreScrollOzD1aCk(long r1, int r3) {
        return NestedScrollConnection.-CC.$default$onPreScroll-OzD1aCk(this, r1, r3);
    }

    public ExitAlwaysScrollBehavior$nestedScrollConnection$1(ExitAlwaysScrollBehavior r1) {
        this.this$0 = r1;
    }

    /* JADX INFO: renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
    public Object m2659onPostFlingRZ2iAVY(long r10, long r12, Continuation<? super Velocity> r14) {
        if ((r14 instanceof ExitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1) == false) goto L7;
        ExitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 r0 = (ExitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1) r14;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r15 = r0.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        long r11 = r0.J$0;
        ResultKt.throwOnFailure(r15);
    L35:
        return Velocity.box-impl(Velocity.plus-AH228Gc(r11, ((Velocity) r15).unbox-impl()));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r12 = r0.J$0;
        ResultKt.throwOnFailure(r15);
    L31:
        r11 = ((Velocity) r15).unbox-impl();
        BottomAppBarState r16 = this.this$0.getState();
        float r13 = Velocity.getY-impl(r12);
        DecayAnimationSpec<Float> r17 = this.this$0.getFlingAnimationSpec();
        AnimationSpec<Float> r3 = this.this$0.getSnapAnimationSpec();
        r0.J$0 = r11;
        r0.label = 2;
        r15 = AppBarKt.access$settleAppBarBottom(r16, r13, r17, r3, r0);
        if (r15 != r7) goto L35;
        return r7;
    L16:
        ResultKt.throwOnFailure(r15);
        if (Velocity.getY-impl(r12) <= MenuKt.ClosedAlphaTarget) goto L28;
        boolean r4 = false;
        if (this.this$0.getState().getHeightOffset() != MenuKt.ClosedAlphaTarget) goto L21;
        boolean r18 = true;
    L22:
        if (r18 == false) goto L24;
    L27:
        this.this$0.getState().setContentOffset(MenuKt.ClosedAlphaTarget);
        goto L28
    L24:
        if (this.this$0.getState().getHeightOffset() != this.this$0.getState().getHeightOffsetLimit()) goto L26;
        r4 = true;
    L26:
        if (r4 == false) goto L28;
    L21:
        r18 = false;
    L28:
        r0.J$0 = r12;
        r0.label = 1;
        r15 = NestedScrollConnection.-CC.$default$onPostFling-RZ2iAVY(this, r10, r12, r0);
        if (r15 != r7) goto L31;
        return r7;
    L7:
        r0 = new ExitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1(this, r14);
        goto L8
    }

    /* JADX INFO: renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
    public long m2660onPostScrollDzOQY0M(long r3, long r5, int r7) {
        if (((Boolean) this.this$0.getCanScroll().invoke()).booleanValue() == false) goto L5;
        BottomAppBarState r6 = this.this$0.getState();
        int r4 = (int) (r3 & 4294967295L);
        r6.setContentOffset(r6.getContentOffset() + Float.intBitsToFloat(r4));
        this.this$0.getState().setHeightOffset(this.this$0.getState().getHeightOffset() + Float.intBitsToFloat(r4));
        return Offset.Companion.getZero-F1C5BW0();
    L5:
        return Offset.Companion.getZero-F1C5BW0();
    }
}
