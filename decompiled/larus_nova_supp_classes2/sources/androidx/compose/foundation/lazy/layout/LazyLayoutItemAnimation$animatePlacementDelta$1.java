package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.ui.unit.IntOffset;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animatePlacementDelta$1", f = "LazyLayoutItemAnimation.kt", i = {0}, l = {141, 148}, m = "invokeSuspend", n = {"finalSpec"}, s = {"L$0"})
public final class LazyLayoutItemAnimation$animatePlacementDelta$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FiniteAnimationSpec<IntOffset> $spec;
    final /* synthetic */ long $totalDelta;
    Object L$0;
    int label;
    final /* synthetic */ LazyLayoutItemAnimation this$0;

    public LazyLayoutItemAnimation$animatePlacementDelta$1(LazyLayoutItemAnimation r1, FiniteAnimationSpec<IntOffset> r2, long r3, Continuation<? super LazyLayoutItemAnimation$animatePlacementDelta$1> r5) {
        this.this$0 = r1;
        this.$spec = r2;
        this.$totalDelta = r3;
        super(2, r5);
    }

    public static /* synthetic */ Unit a(LazyLayoutItemAnimation r0, long r1, Animatable r3) {
        return invokeSuspend$lambda$0(r0, r1, r3);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new LazyLayoutItemAnimation$animatePlacementDelta$1(this.this$0, this.$spec, this.$totalDelta, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L13;
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L9;
        ResultKt.throwOnFailure(r12);     // Catch: CancellationException -> L33
    L30:
        LazyLayoutItemAnimation.access$setPlacementAnimationInProgress(this.this$0, false);     // Catch: CancellationException -> L33
        LazyLayoutItemAnimation.access$setRunningMovingAwayAnimation$p(this.this$0, false);     // Catch: CancellationException -> L33
        goto L32
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        FiniteAnimationSpec r2 = (FiniteAnimationSpec) this.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: CancellationException -> L33
    L26:
        LazyLayoutItemAnimation.access$getOnLayerPropertyChanged$p(this.this$0).invoke();     // Catch: CancellationException -> L33
    L27:
        FiniteAnimationSpec r5 = r2;
        final long r3 = IntOffset.minus-qkQi6aY(((IntOffset) LazyLayoutItemAnimation.access$getPlacementDeltaAnimation$p(this.this$0).getValue()).unbox-impl(), this.$totalDelta);     // Catch: CancellationException -> L33
        Animatable r13 = LazyLayoutItemAnimation.access$getPlacementDeltaAnimation$p(this.this$0);     // Catch: CancellationException -> L33
        IntOffset r4 = IntOffset.box-impl(r3);     // Catch: CancellationException -> L33
        final LazyLayoutItemAnimation r7 = this.this$0;     // Catch: CancellationException -> L33
        Function1 r8 = new h(r7, r3);     // Catch: CancellationException -> L33
        this.L$0 = null;     // Catch: CancellationException -> L33
        this.label = 2;     // Catch: CancellationException -> L33
        if (Animatable.animateTo$default(r13, r4, r5, null, r8, this, 4, null) != r0) goto L30;
        return r0;
    L13:
        ResultKt.throwOnFailure(r12);
        if (LazyLayoutItemAnimation.access$getPlacementDeltaAnimation$p(this.this$0).isRunning() == false) goto L20;
        FiniteAnimationSpec<IntOffset> r14 = this.$spec;     // Catch: CancellationException -> L33
        if ((r14 instanceof SpringSpec) == false) goto L19;
        FiniteAnimationSpec r15 = (SpringSpec) r14;     // Catch: CancellationException -> L33
    L21:
        r2 = r15;
        if (LazyLayoutItemAnimation.access$getPlacementDeltaAnimation$p(this.this$0).isRunning() == true) goto L27;
        Animatable r16 = LazyLayoutItemAnimation.access$getPlacementDeltaAnimation$p(this.this$0);     // Catch: CancellationException -> L33
        IntOffset r6 = IntOffset.box-impl(this.$totalDelta);     // Catch: CancellationException -> L33
        this.L$0 = r2;     // Catch: CancellationException -> L33
        this.label = 1;     // Catch: CancellationException -> L33
        if (r16.snapTo(r6, this) != r0) goto L26;
        return r0;
    L19:
        r15 = LazyLayoutItemAnimationKt.access$getInterruptionSpec$p();     // Catch: CancellationException -> L33
        goto L21
    L20:
        r15 = this.$spec;     // Catch: CancellationException -> L33
    L32:
        return Unit.INSTANCE;
    }

    private static final Unit invokeSuspend$lambda$0(LazyLayoutItemAnimation r2, long r3, Animatable r5) {
        LazyLayoutItemAnimation.m1141access$setPlacementDeltagyyYBs(r2, IntOffset.minus-qkQi6aY(((IntOffset) r5.getValue()).unbox-impl(), r3));
        LazyLayoutItemAnimation.access$getOnLayerPropertyChanged$p(r2).invoke();
        return Unit.INSTANCE;
    }
}
