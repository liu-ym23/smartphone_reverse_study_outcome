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

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/setting/impl/ManualCacheCleanUiController$ManualCleanOutcome;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.setting.impl.ManualCacheCleanUiController$clean$terminalTask$1", f = "ManualCacheCleanUiController.kt", i = {}, l = {193}, m = "invokeSuspend", n = {}, s = {})
final class ManualCacheCleanUiController$clean$terminalTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ManualCacheCleanUiController.a>, Object> {
    final /* synthetic */ long $beforeBytes;
    final /* synthetic */ String $currentPage;
    final /* synthetic */ String $operationId;
    final /* synthetic */ long $startTime;
    int label;

    public ManualCacheCleanUiController$clean$terminalTask$1(long r100, String r101, String r102, long r103, Continuation<? super ManualCacheCleanUiController$clean$terminalTask$1> r104) {
        this.$beforeBytes = r100;
        this.$operationId = r101;
        this.$currentPage = r102;
        this.$startTime = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r110) {
        return new ManualCacheCleanUiController$clean$terminalTask$1(this.$beforeBytes, this.$operationId, this.$currentPage, this.$startTime, r110);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super ManualCacheCleanUiController.a> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super ManualCacheCleanUiController.a> r101) {
        return ((ManualCacheCleanUiController$clean$terminalTask$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r110);
    L11:
        return r110;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        ManualCacheCleanUiController r102 = ManualCacheCleanUiController.f367966a;
        long r103 = this.$beforeBytes;
        String r111 = this.$operationId;
        String r104 = this.$currentPage;
        long r105 = this.$startTime;
        this.label = 1;
        r110 = ManualCacheCleanUiController.b(r102, r103, r111, r104, r105, this);
        if (r110 != r100) goto L11;
        return r100;
    }
}
