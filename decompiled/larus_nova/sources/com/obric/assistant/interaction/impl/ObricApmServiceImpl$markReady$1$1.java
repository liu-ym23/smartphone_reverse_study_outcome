package com.obric.assistant.interaction.impl;

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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.interaction.impl.ObricApmServiceImpl$markReady$1$1", f = "ObricApmServiceImpl.kt", i = {1}, l = {40, 90}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
public final class ObricApmServiceImpl$markReady$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ObricApmServiceImpl this$0;

    public ObricApmServiceImpl$markReady$1$1(ObricApmServiceImpl r100, Continuation<? super ObricApmServiceImpl$markReady$1$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ObricApmServiceImpl$markReady$1$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ObricApmServiceImpl$markReady$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L9;
        if (r102 != 2) goto L8;
        ObricApmServiceImpl r103 = (ObricApmServiceImpl) this.L$1;
        kotlinx.coroutines.sync.a r104 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r100);
    L27:
        ObricApmServiceImpl.access$isReady$p(r103).set(true);     // Catch: Throwable -> L24
        Iterator r105 = ObricApmServiceImpl.access$getPendingSlardarEvents$p(r103).iterator();     // Catch: Throwable -> L24
    L19:
        if (r105.hasNext() == false) goto L21;
        ObricApmServiceImpl.SlardarEventParams r106 = (ObricApmServiceImpl.SlardarEventParams) r105.next();     // Catch: Throwable -> L24
        ObricApmServiceImpl.access$reportEventForSlardar(r103, r106.getEvent(), r106.getCategory(), r106.getMetric(), r106.getExtraLog());     // Catch: Throwable -> L24
        goto L19
    L21:
        ObricApmServiceImpl.access$getPendingSlardarEvents$p(r103).clear();     // Catch: Throwable -> L24
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L24
        r104.unlock(null);
        return Unit.INSTANCE;
    L24:
        th = move-exception;
        r104.unlock(null);
        throw th;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
    L13:
        r104 = ObricApmServiceImpl.access$getLock$p(this.this$0);
        ObricApmServiceImpl r108 = this.this$0;
        this.L$0 = r104;
        this.L$1 = r108;
        this.label = 2;
        if (r104.a(null, this) != r101) goto L16;
        return r101;
    L16:
        r103 = r108;
        goto L27
    L10:
        ResultKt.throwOnFailure(r100);
        this.label = 1;
        if (DelayKt.delay(1000, this) != r101) goto L13;
        return r101;
    }
}
