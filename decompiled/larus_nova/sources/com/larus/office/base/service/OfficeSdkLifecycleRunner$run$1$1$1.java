package com.larus.office.base.service;

import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.base.service.OfficeSdkLifecycleRunner$run$1$1$1", f = "OfficeSdkLifecycleRunner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class OfficeSdkLifecycleRunner$run$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $afterInit;
    final /* synthetic */ boolean $forceInitDoc;
    final /* synthetic */ OfficeSDKUserApi $officeSDKUserApi;
    final /* synthetic */ String $source;
    int label;

    public OfficeSdkLifecycleRunner$run$1$1$1(OfficeSDKUserApi r100, boolean r101, String r102, Function0<Unit> r103, Continuation<? super OfficeSdkLifecycleRunner$run$1$1$1> r104) {
        this.$officeSDKUserApi = r100;
        this.$forceInitDoc = r101;
        this.$source = r102;
        this.$afterInit = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new OfficeSdkLifecycleRunner$run$1$1$1(this.$officeSDKUserApi, this.$forceInitDoc, this.$source, this.$afterInit, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((OfficeSdkLifecycleRunner$run$1$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        f.f361103a.f(this.$officeSDKUserApi, this.$forceInitDoc, this.$source, this.$afterInit);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
