package com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.lifecycle;

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

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.lifecycle.TTPayAnniePageLifecycleService$onPageCreate$3$1", f = "TTPayAnniePageLifecycleService.kt", i = {}, l = {119}, m = "invokeSuspend", n = {}, s = {})
public final class TTPayAnniePageLifecycleService$onPageCreate$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $blockLoadingTime;
    final /* synthetic */ gf4.a $state;
    int label;

    public TTPayAnniePageLifecycleService$onPageCreate$3$1(long r100, gf4.a r101, Continuation<? super TTPayAnniePageLifecycleService$onPageCreate$3$1> r102) {
        this.$blockLoadingTime = r100;
        this.$state = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new TTPayAnniePageLifecycleService$onPageCreate$3$1(this.$blockLoadingTime, this.$state, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((TTPayAnniePageLifecycleService$onPageCreate$3$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        this.$state.f481049b.set(false);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        long r103 = this.$blockLoadingTime;
        this.label = 1;
        if (DelayKt.delay(r103, this) != r101) goto L11;
        return r101;
    }
}
