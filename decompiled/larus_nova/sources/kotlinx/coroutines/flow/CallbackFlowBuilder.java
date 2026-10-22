package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes5.dex */
public final class CallbackFlowBuilder<T> extends c<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function2<kotlinx.coroutines.channels.k<? super T>, Continuation<? super Unit>, Object> f504741e;

    @Override // kotlinx.coroutines.flow.c, kotlinx.coroutines.flow.internal.d
    public final Object c(kotlinx.coroutines.channels.k<? super T> r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof CallbackFlowBuilder$collectTo$1) == false) goto L7;
        CallbackFlowBuilder$collectTo$1 r102 = (CallbackFlowBuilder$collectTo$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r100 = (kotlinx.coroutines.channels.k) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L18:
        if (r100.isClosedForSend() == false) goto L22;
        return Unit.INSTANCE;
    L22:
        throw new IllegalStateException("'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details.");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        r102.L$0 = r100;
        r102.label = 1;
        if (super.c(r100, r102) != r105) goto L18;
        return r105;
    L7:
        r102 = new CallbackFlowBuilder$collectTo$1(this, r101);
        goto L8
    }

    @Override // kotlinx.coroutines.flow.c, kotlinx.coroutines.flow.internal.d
    public final kotlinx.coroutines.flow.internal.d<T> d(CoroutineContext r100, int r101, BufferOverflow r102) {
        return new CallbackFlowBuilder(this.f504741e, r100, r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CallbackFlowBuilder(Function2<? super kotlinx.coroutines.channels.k<? super T>, ? super Continuation<? super Unit>, ? extends Object> r100, CoroutineContext r101, int r102, BufferOverflow r103) {
        super(r100, r101, r102, r103);
        this.f504741e = r100;
    }
}
