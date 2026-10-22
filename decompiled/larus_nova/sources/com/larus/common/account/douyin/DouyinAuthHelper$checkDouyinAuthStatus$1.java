package com.larus.common.account.douyin;

import com.larus.common.account.douyin.network.DouyinAuthNetHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import n38.r;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.account.douyin.DouyinAuthHelper$checkDouyinAuthStatus$1", f = "DouyinAuthHelper.kt", i = {}, l = {94}, m = "invokeSuspend", n = {}, s = {})
final class DouyinAuthHelper$checkDouyinAuthStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ r $callback;
    final /* synthetic */ String $clientKey;
    final /* synthetic */ String $scope;
    final /* synthetic */ String $state;
    int label;

    public DouyinAuthHelper$checkDouyinAuthStatus$1(String r100, String r101, String r102, r r103, Continuation<? super DouyinAuthHelper$checkDouyinAuthStatus$1> r104) {
        this.$clientKey = r100;
        this.$scope = r101;
        this.$state = r102;
        this.$callback = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DouyinAuthHelper$checkDouyinAuthStatus$1(this.$clientKey, this.$scope, this.$state, this.$callback, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DouyinAuthHelper$checkDouyinAuthStatus$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        boolean r103 = ((Boolean) r100).booleanValue();
        this.$callback.a(r103, this.$clientKey, this.$scope, this.$state);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        DouyinAuthNetHelper r104 = DouyinAuthNetHelper.f326087a;
        String r105 = this.$clientKey;
        String r106 = this.$scope;
        String r107 = this.$state;
        this.label = 1;
        r100 = r104.b(r105, r106, r107, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
