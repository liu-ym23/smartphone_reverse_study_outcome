package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.animation.core.TransitionKt$rememberTransition$1$1", f = "Transition.kt", i = {0}, l = {2173}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
public final class TransitionKt$rememberTransition$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TransitionState<T> $transitionState;
    Object L$0;
    Object L$1;
    int label;

    public TransitionKt$rememberTransition$1$1(TransitionState<T> r1, Continuation<? super TransitionKt$rememberTransition$1$1> r2) {
        this.$transitionState = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new TransitionKt$rememberTransition$1$1(this.$transitionState, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        TransitionState r2 = (TransitionState) this.L$1;
        kotlinx.coroutines.sync.a r3 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r5);
    L21:
        ((SeekableTransitionState) r2).setComposedTargetState$animation_core(((SeekableTransitionState) r2).getTargetState());     // Catch: Throwable -> L18
        kotlinx.coroutines.i r6 = ((SeekableTransitionState) r2).getCompositionContinuation$animation_core();     // Catch: Throwable -> L18
        if (r6 == null) goto L15;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L18
        r6.resumeWith(Result.constructor-impl(((SeekableTransitionState) r2).getTargetState()));     // Catch: Throwable -> L18
    L15:
        ((SeekableTransitionState) r2).setCompositionContinuation$animation_core(null);     // Catch: Throwable -> L18
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L18
        r3.unlock(null);
        return Unit.INSTANCE;
    L18:
        th = move-exception;
        r3.unlock(null);
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        ((SeekableTransitionState) this.$transitionState).observeTotalDuration$animation_core();
        r3 = ((SeekableTransitionState) this.$transitionState).getCompositionContinuationMutex$animation_core();
        TransitionState r8 = this.$transitionState;
        this.L$0 = r3;
        this.L$1 = r8;
        this.label = 1;
        if (r3.a(null, this) != r0) goto L11;
        return r0;
    L11:
        r2 = r8;
        goto L21
    }
}
