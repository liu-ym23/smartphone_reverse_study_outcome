package com.larus.common.account.bdauth.repository;

import com.larus.account.bdauth.api.UserInfoRequest;
import com.larus.common.account.bdauth.api.AuthorizeApi;
import com.larus.network.bean.BizResponse;
import com.larus.platform.service.AccountService;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/account/bdauth/api/ProfileOverviewResponse;", "Lcom/larus/common/account/bdauth/api/AuthorizeApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.account.bdauth.repository.BDAuthorizeRepository$requestUserInfoFromRemote$2$result$1", f = "BDAuthorizeRepository.kt", i = {}, l = {TTVideoEngineInterface.PLAYER_OPTION_SET_FIRST_RANGE_SIZE}, m = "invokeSuspend", n = {}, s = {})
public final class BDAuthorizeRepository$requestUserInfoFromRemote$2$result$1 extends SuspendLambda implements Function2<AuthorizeApi, Continuation<? super BizResponse<t38.c>>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public BDAuthorizeRepository$requestUserInfoFromRemote$2$result$1(Continuation<? super BDAuthorizeRepository$requestUserInfoFromRemote$2$result$1> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        BDAuthorizeRepository$requestUserInfoFromRemote$2$result$1 r102 = new BDAuthorizeRepository$requestUserInfoFromRemote$2$result$1(r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(AuthorizeApi r100, Continuation<? super BizResponse<t38.c>> r101) {
        return ((BDAuthorizeRepository$requestUserInfoFromRemote$2$result$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(AuthorizeApi r100, Continuation<? super BizResponse<t38.c>> r101) {
        return invoke2(r100, r101);
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
        AuthorizeApi r111 = (AuthorizeApi) this.L$0;
        UserInfoRequest r102 = new UserInfoRequest(AccountService.f365697a.getUserId(), null, 0, 6, null);
        this.label = 1;
        r110 = r111.requestUserInfo(r102, this);
        if (r110 != r100) goto L11;
        return r100;
    }
}
