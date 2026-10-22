package com.larus.im.internal.core.cmd.receiver;

import com.larus.im.internal.jni.bean.OmniDispatchCommandResponse;
import com.larus.im.service.a0;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.cmd.receiver.DispatchCommandDispatcher$notifyReceiveDispatchCommand$1", f = "DispatchCommandDispatcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DispatchCommandDispatcher$notifyReceiveDispatchCommand$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OmniDispatchCommandResponse $response;
    int label;

    public DispatchCommandDispatcher$notifyReceiveDispatchCommand$1(OmniDispatchCommandResponse r100, Continuation<? super DispatchCommandDispatcher$notifyReceiveDispatchCommand$1> r101) {
        this.$response = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DispatchCommandDispatcher$notifyReceiveDispatchCommand$1(this.$response, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DispatchCommandDispatcher$notifyReceiveDispatchCommand$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r100);
        com.larus.im.internal.delegate.a.f348188b.i("DispatchCommandDispatcher", "notifyReceiveDispatchCommand");
        CopyOnWriteArrayList<a0> r101 = a.f347536a;
        OmniDispatchCommandResponse r102 = this.$response;
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L9;
        ((a0) r103.next()).onReceiveDispatchCommand(r102);
        goto L6
    L9:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
