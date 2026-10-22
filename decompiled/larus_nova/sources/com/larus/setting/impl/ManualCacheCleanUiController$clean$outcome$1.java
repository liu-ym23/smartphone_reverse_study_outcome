package com.larus.setting.impl;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/setting/impl/ManualCacheCleanUiController$ManualCleanOutcome;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.setting.impl.ManualCacheCleanUiController$clean$outcome$1", f = "ManualCacheCleanUiController.kt", i = {}, l = {203}, m = "invokeSuspend", n = {}, s = {})
final class ManualCacheCleanUiController$clean$outcome$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ManualCacheCleanUiController.a>, Object> {
    final /* synthetic */ Deferred<ManualCacheCleanUiController.a> $terminalTask;
    int label;

    public ManualCacheCleanUiController$clean$outcome$1(Deferred<ManualCacheCleanUiController.a> r100, Continuation<? super ManualCacheCleanUiController$clean$outcome$1> r101) {
        this.$terminalTask = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ManualCacheCleanUiController$clean$outcome$1(this.$terminalTask, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super ManualCacheCleanUiController.a> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super ManualCacheCleanUiController.a> r101) {
        return ((ManualCacheCleanUiController$clean$outcome$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        Deferred<ManualCacheCleanUiController.a> r103 = this.$terminalTask;
        this.label = 1;
        r100 = r103.await(this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
