package com.larus.office.base.plugins.authorization;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tb5.m;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.base.plugins.authorization.LarkAuthorizationPluginV2$GetAuthHeader$handle$1", f = "LarkAuthorizationPluginV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class LarkAuthorizationPluginV2$GetAuthHeader$handle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ m $callback;
    final /* synthetic */ AuthModel $data;
    int label;
    final /* synthetic */ LarkAuthorizationPluginV2.b this$0;

    public LarkAuthorizationPluginV2$GetAuthHeader$handle$1(LarkAuthorizationPluginV2.b r100, AuthModel r101, m r102, Continuation<? super LarkAuthorizationPluginV2$GetAuthHeader$handle$1> r103) {
        this.this$0 = r100;
        this.$data = r101;
        this.$callback = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new LarkAuthorizationPluginV2$GetAuthHeader$handle$1(this.this$0, this.$data, this.$callback, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((LarkAuthorizationPluginV2$GetAuthHeader$handle$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        LarkAuthorizationPluginV2.access$getAuthorizationData(this.this$0.f360730a, this.$data, this.$callback);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
