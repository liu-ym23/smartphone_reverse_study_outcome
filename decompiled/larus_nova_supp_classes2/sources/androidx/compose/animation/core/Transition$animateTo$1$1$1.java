package androidx.compose.animation.core;

import androidx.compose.runtime.MonotonicFrameClockKt;
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
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.animation.core.Transition$animateTo$1$1$1", f = "Transition.kt", i = {0, 0}, l = {1202}, m = "invokeSuspend", n = {"$this$launch", "durationScale"}, s = {"L$0", "F$0"})
public final class Transition$animateTo$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    float F$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ Transition<S> this$0;

    public Transition$animateTo$1$1$1(Transition<S> r1, Continuation<? super Transition$animateTo$1$1$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public static /* synthetic */ Unit a(Transition r0, float r1, long r2) {
        return invokeSuspend$lambda$0(r0, r1, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Transition$animateTo$1$1$1 r0 = new Transition$animateTo$1$1$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        final float r2 = this.F$0;
        CoroutineScope r3 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r7);
    L11:
        if (CoroutineScopeKt.isActive(r3) == false) goto L16;
        final Transition<S> r4 = this.this$0;
        Function1 r5 = new h0(r4, r2);
        this.L$0 = r3;
        this.F$0 = r2;
        this.label = 1;
        if (MonotonicFrameClockKt.withFrameNanos(r5, this) != r0) goto L11;
        return r0;
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        r2 = SuspendAnimationKt.getDurationScale(r8.getCoroutineContext());
        r3 = r8;
        goto L11
    }

    private static final Unit invokeSuspend$lambda$0(Transition r2, float r3, long r4) {
        if (r2.isSeeking() == true) goto L6;
        r2.onFrame$animation_core(r4 / 1, r3);
    L6:
        return Unit.INSTANCE;
    }
}
