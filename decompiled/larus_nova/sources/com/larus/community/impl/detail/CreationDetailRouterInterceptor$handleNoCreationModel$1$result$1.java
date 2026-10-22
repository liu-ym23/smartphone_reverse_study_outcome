package com.larus.community.impl.detail;

import com.larus.community.impl.api.CreationRecommendApi;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/community/impl/api/CreationDetailResponse;", "Lcom/larus/community/impl/api/CreationRecommendApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.detail.CreationDetailRouterInterceptor$handleNoCreationModel$1$result$1", f = "CreationDetailRouterInterceptor.kt", i = {}, l = {203}, m = "invokeSuspend", n = {}, s = {})
public final class CreationDetailRouterInterceptor$handleNoCreationModel$1$result$1 extends SuspendLambda implements Function2<CreationRecommendApi, Continuation<? super BizResponse<com.larus.community.impl.api.e>>, Object> {
    final /* synthetic */ String $creationId;
    final /* synthetic */ boolean $isFromAnchor;
    private /* synthetic */ Object L$0;
    int label;

    public CreationDetailRouterInterceptor$handleNoCreationModel$1$result$1(String r100, boolean r101, Continuation<? super CreationDetailRouterInterceptor$handleNoCreationModel$1$result$1> r102) {
        this.$creationId = r100;
        this.$isFromAnchor = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        CreationDetailRouterInterceptor$handleNoCreationModel$1$result$1 r102 = new CreationDetailRouterInterceptor$handleNoCreationModel$1$result$1(this.$creationId, this.$isFromAnchor, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CreationRecommendApi r100, Continuation<? super BizResponse<com.larus.community.impl.api.e>> r101) {
        return ((CreationDetailRouterInterceptor$handleNoCreationModel$1$result$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CreationRecommendApi r100, Continuation<? super BizResponse<com.larus.community.impl.api.e>> r101) {
        return invoke2(r100, r101);
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
        CreationRecommendApi r103 = (CreationRecommendApi) this.L$0;
        com.larus.community.impl.api.d r104 = new com.larus.community.impl.api.d(CollectionsKt.listOf(this.$creationId), this.$isFromAnchor);
        this.label = 1;
        r100 = r103.getCreationDetail(r104, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
