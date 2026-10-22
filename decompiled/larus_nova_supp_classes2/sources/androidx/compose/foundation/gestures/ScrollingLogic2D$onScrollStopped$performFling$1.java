package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/Velocity;", "velocity"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic2D$onScrollStopped$performFling$1", f = "Scrollable2D.kt", i = {0, 1, 1, 2, 2}, l = {379, 382, 385}, m = "invokeSuspend", n = {"velocity", "velocity", "available", "velocity", "velocityLeft"}, s = {"J$0", "J$0", "J$1", "J$0", "J$1"})
public final class ScrollingLogic2D$onScrollStopped$performFling$1 extends SuspendLambda implements Function2<Velocity, Continuation<? super Velocity>, Object> {
    /* synthetic */ long J$0;
    long J$1;
    int label;
    final /* synthetic */ ScrollingLogic2D this$0;

    public ScrollingLogic2D$onScrollStopped$performFling$1(ScrollingLogic2D r1, Continuation<? super ScrollingLogic2D$onScrollStopped$performFling$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ScrollingLogic2D$onScrollStopped$performFling$1 r0 = new ScrollingLogic2D$onScrollStopped$performFling$1(this.this$0, r4);
        r0.J$0 = ((Velocity) r3).unbox-impl();
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4) {
        return m713invokesFctU(((Velocity) r3).unbox-impl(), (Continuation) r4);
    }

    /* JADX INFO: renamed from: invoke-sF-c-tU, reason: not valid java name */
    public final Object m713invokesFctU(long r1, Continuation<? super Velocity> r3) {
        return create(Velocity.box-impl(r1), r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L12;
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L10;
        if (r0 != 3) goto L9;
        long r1 = this.J$1;
        long r2 = this.J$0;
        ResultKt.throwOnFailure(r14);
        long r9 = r1;
        Object r3 = r14;
    L25:
        return Velocity.box-impl(Velocity.minus-AH228Gc(r2, Velocity.minus-AH228Gc(r9, ((Velocity) r3).unbox-impl())));
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        long r4 = this.J$1;
        long r5 = this.J$0;
        ResultKt.throwOnFailure(r14);
        Object r7 = r14;
        long r8 = r5;
    L20:
        r9 = ((Velocity) r7).unbox-impl();
        NestedScrollDispatcher r10 = ScrollingLogic2D.access$getNestedScrollDispatcher$p(this.this$0);
        long r11 = Velocity.minus-AH228Gc(r4, r9);
        this.J$0 = r8;
        this.J$1 = r9;
        this.label = 3;
        r3 = r10.dispatchPostFling-RZ2iAVY(r11, r9, this);
        if (r3 != r6) goto L23;
        return r6;
    L23:
        r2 = r8;
        goto L25
    L11:
        long r12 = this.J$0;
        ResultKt.throwOnFailure(r14);
        Object r13 = r14;
    L16:
        long r15 = Velocity.minus-AH228Gc(r12, ((Velocity) r13).unbox-impl());
        ScrollingLogic2D r16 = this.this$0;
        this.J$0 = r12;
        this.J$1 = r15;
        this.label = 2;
        r7 = r16.mo656doFlingAnimationQWom1Mo(r15, this);
        if (r7 != r6) goto L19;
        return r6;
    L19:
        r4 = r15;
        r8 = r12;
        goto L20
    L12:
        ResultKt.throwOnFailure(r14);
        long r17 = this.J$0;
        NestedScrollDispatcher r18 = ScrollingLogic2D.access$getNestedScrollDispatcher$p(this.this$0);
        this.J$0 = r17;
        this.label = 1;
        r13 = r18.dispatchPreFling-QWom1Mo(r17, this);
        if (r13 != r6) goto L15;
        return r6;
    L15:
        r12 = r17;
        goto L16
    }
}
