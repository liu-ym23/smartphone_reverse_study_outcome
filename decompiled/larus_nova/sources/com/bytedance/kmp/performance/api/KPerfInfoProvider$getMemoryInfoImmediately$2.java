package com.bytedance.kmp.performance.api;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import md6.f1;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/kmp/performance/model/KPerfMemoryData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.kmp.performance.api.KPerfInfoProvider$getMemoryInfoImmediately$2", f = "KPerfInfoProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class KPerfInfoProvider$getMemoryInfoImmediately$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super f1>, Object> {
    int label;

    public KPerfInfoProvider$getMemoryInfoImmediately$2(Continuation<? super KPerfInfoProvider$getMemoryInfoImmediately$2> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new KPerfInfoProvider$getMemoryInfoImmediately$2(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super f1> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super f1> r101) {
        return ((KPerfInfoProvider$getMemoryInfoImmediately$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        return com.bytedance.kmp.performance.platform.v.a();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
