package com.larus.im.internal.core.thread.receiver;

import com.larus.im.bean.thread.ThreadData;
import com.larus.im.service.f0;
import java.util.Iterator;
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
@DebugMetadata(c = "com.larus.im.internal.core.thread.receiver.ThreadDispatcher$notifyReplace$1", f = "ThreadDispatcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ThreadDispatcher$notifyReplace$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ThreadData $localThread;
    final /* synthetic */ String $localThreadId;
    final /* synthetic */ ThreadData $remoteThread;
    int label;

    public ThreadDispatcher$notifyReplace$1(String r100, ThreadData r101, ThreadData r102, Continuation<? super ThreadDispatcher$notifyReplace$1> r103) {
        this.$localThreadId = r100;
        this.$localThread = r101;
        this.$remoteThread = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ThreadDispatcher$notifyReplace$1(this.$localThreadId, this.$localThread, this.$remoteThread, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ThreadDispatcher$notifyReplace$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r100);
        com.larus.im.internal.delegate.a.f348188b.i("ThreadDispatcher", "notifyReplace localThreadId:" + this.$localThreadId + ", localThread:" + this.$localThread + ", remoteThread:" + this.$remoteThread);
        Iterator<f0<ThreadData>> r101 = a.f347912b.iterator();
    L6:
        if (r101.hasNext() == false) goto L9;
        r101.next().a();
        goto L6
    L9:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
