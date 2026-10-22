package com.bytedance.ies.argus.strategy.provider.client;

import android.app.Application;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/bytedance/ies/argus/strategy/provider/client/UploadFileVerifyStrategyProvider$b;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.ies.argus.strategy.provider.client.UploadFileVerifyStrategyProvider$calculate$result$1", f = "UploadFileVerifyStrategyProvider.kt", i = {}, l = {126}, m = "invokeSuspend", n = {}, s = {})
public final class UploadFileVerifyStrategyProvider$calculate$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super UploadFileVerifyStrategyProvider.b>, Object> {
    final /* synthetic */ Application $application;
    final /* synthetic */ UploadFileVerifyStrategyProvider.Detector $detector;
    int label;

    public UploadFileVerifyStrategyProvider$calculate$result$1(UploadFileVerifyStrategyProvider.Detector r100, Application r101, Continuation<? super UploadFileVerifyStrategyProvider$calculate$result$1> r102) {
        this.$detector = r100;
        this.$application = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new UploadFileVerifyStrategyProvider$calculate$result$1(this.$detector, this.$application, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super UploadFileVerifyStrategyProvider.b> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super UploadFileVerifyStrategyProvider.b> r101) {
        return ((UploadFileVerifyStrategyProvider$calculate$result$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
        UploadFileVerifyStrategyProvider.Detector r103 = this.$detector;
        Application r104 = this.$application;
        this.label = 1;
        r100 = r103.a(r104, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
