package com.larus.common.account.bdauth.model;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.account.bdauth.model.CustomAuthorizePresenter$doRequest$3", f = "CustomAuthorizePresenter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CustomAuthorizePresenter$doRequest$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<za7.a> $authCodeResponseV2;
    final /* synthetic */ fb7.c $request;
    int label;
    final /* synthetic */ a this$0;

    public CustomAuthorizePresenter$doRequest$3(Ref.ObjectRef<za7.a> r100, a r101, fb7.c r102, Continuation<? super CustomAuthorizePresenter$doRequest$3> r103) {
        this.$authCodeResponseV2 = r100;
        this.$request = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CustomAuthorizePresenter$doRequest$3(this.$authCodeResponseV2, null, this.$request, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CustomAuthorizePresenter$doRequest$3) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r100);
        za7.a r101 = this.$authCodeResponseV2.element;
        if (r101 != null) goto L7;
    L11:
        int r102 = a.f325912a;
        throw null;
    L7:
        if (r101.f571091a == false) goto L11;
        int r103 = a.f325912a;
        throw null;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
