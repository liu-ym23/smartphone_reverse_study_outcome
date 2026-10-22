package com.larus.ugc.perf.impl;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.ugc.perf.impl.BasePerfMonitor$cleanUpExpiredTrackers$1", f = "BasePerfMonitor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BasePerfMonitor$cleanUpExpiredTrackers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public BasePerfMonitor$cleanUpExpiredTrackers$1(Continuation<? super BasePerfMonitor$cleanUpExpiredTrackers$1> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new BasePerfMonitor$cleanUpExpiredTrackers$1(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((BasePerfMonitor$cleanUpExpiredTrackers$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r100);
        ConcurrentHashMap<String, g> r101 = c.f375101b;
        if (r101.size() < 50) goto L7;
        Iterator<Map.Entry<String, g>> r102 = r101.entrySet().iterator();
    L10:
        if (r102.hasNext() == false) goto L17;
        Map.Entry<String, g> r103 = r102.next();
        String r104 = r103.getKey();
        long r105 = r103.getValue().a();
        if (r105 <= 0) goto L15;
        if (r105 <= 600000) goto L10;
    L15:
        c.f375100a.getClass();
        c.e(r104);
        goto L10
    L17:
        return Unit.INSTANCE;
    L7:
        return Unit.INSTANCE;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
