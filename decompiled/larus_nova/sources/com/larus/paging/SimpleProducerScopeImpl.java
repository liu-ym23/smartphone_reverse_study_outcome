package com.larus.paging;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: loaded from: classes29.dex */
public final class SimpleProducerScopeImpl<T> implements b1<T>, CoroutineScope, SendChannel<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SendChannel<T> f363736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f363737b;

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean close(Throwable r100) {
        return this.f363736a.close(r100);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.f363737b.getCoroutineContext();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final kotlinx.coroutines.selects.i<T, SendChannel<T>> getOnSend() {
        return this.f363736a.getOnSend();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final void invokeOnClose(Function1<? super Throwable, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        this.f363736a.invokeOnClose(r100);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean isClosedForSend() {
        return this.f363736a.isClosedForSend();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean offer(T r100) {
        return this.f363736a.offer(r100);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final Object send(T r100, Continuation<? super Unit> r101) {
        return this.f363736a.send(r100, r101);
    }

    public SimpleProducerScopeImpl(CoroutineScope r100, Channel r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "channel");
        this.f363736a = r101;
        this.f363737b = r100;
    }

    @Override // com.larus.paging.b1
    public final Object WA(Function0<Unit> r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof SimpleProducerScopeImpl$awaitClose$1) == false) goto L7;
        SimpleProducerScopeImpl$awaitClose$1 r102 = (SimpleProducerScopeImpl$awaitClose$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L16;
        if (r106 != 1) goto L15;
        Job r107 = (Job) r102.L$1;
        r100 = (Function0) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L28
    L24:
        r100.invoke();
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r104);
        CoroutineContext.Element r108 = getCoroutineContext().get(Job.Key);     // Catch: Throwable -> L28
        if (r108 == null) goto L27;
        Job r109 = (Job) r108;     // Catch: Throwable -> L28
        r102.L$0 = r100;     // Catch: Throwable -> L28
        r102.L$1 = r109;     // Catch: Throwable -> L28
        r102.label = 1;     // Catch: Throwable -> L28
        final kotlinx.coroutines.j r110 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r102), 1);     // Catch: Throwable -> L28
        r110.C();     // Catch: Throwable -> L28
        r109.invokeOnCompletion(new SimpleProducerScopeImpl$awaitClose$2$1(r110));     // Catch: Throwable -> L28
        Object r111 = r110.B();     // Catch: Throwable -> L28
        if (r111 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L22;
        DebugProbesKt.probeCoroutineSuspended(r102);     // Catch: Throwable -> L28
    L22:
        if (r111 != r105) goto L24;
        return r105;
    L27:
        throw new IllegalStateException("Internal error, context should have a job.".toString());     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        r100.invoke();
        throw th;
    L7:
        r102 = new SimpleProducerScopeImpl$awaitClose$1(this, r101);
        goto L8
    }
}
