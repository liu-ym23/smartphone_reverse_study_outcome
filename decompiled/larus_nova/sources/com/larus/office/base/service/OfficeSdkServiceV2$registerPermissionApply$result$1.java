package com.larus.office.base.service;

import com.larus.network.bean.BizResponse;
import com.larus.office.base.net.PermissionApi;
import com.larus.office.base.net.RegisterPermApplyRequest;
import com.larus.office.base.net.RegisterPermApplyResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/office/base/net/RegisterPermApplyResponse;", "Lcom/larus/office/base/net/PermissionApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.base.service.OfficeSdkServiceV2$registerPermissionApply$result$1", f = "OfficeSdkServiceV2.kt", i = {}, l = {601}, m = "invokeSuspend", n = {}, s = {})
public final class OfficeSdkServiceV2$registerPermissionApply$result$1 extends SuspendLambda implements Function2<PermissionApi, Continuation<? super BizResponse<RegisterPermApplyResponse>>, Object> {
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $messageId;
    final /* synthetic */ String $token;
    final /* synthetic */ Long $type;
    private /* synthetic */ Object L$0;
    int label;

    public OfficeSdkServiceV2$registerPermissionApply$result$1(String r100, String r101, String r102, Long r103, Continuation<? super OfficeSdkServiceV2$registerPermissionApply$result$1> r104) {
        this.$conversationId = r100;
        this.$messageId = r101;
        this.$token = r102;
        this.$type = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        OfficeSdkServiceV2$registerPermissionApply$result$1 r102 = new OfficeSdkServiceV2$registerPermissionApply$result$1(this.$conversationId, this.$messageId, this.$token, this.$type, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(PermissionApi r100, Continuation<? super BizResponse<RegisterPermApplyResponse>> r101) {
        return ((OfficeSdkServiceV2$registerPermissionApply$result$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(PermissionApi r100, Continuation<? super BizResponse<RegisterPermApplyResponse>> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L14:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        PermissionApi r103 = (PermissionApi) this.L$0;
        String r104 = this.$conversationId;
        if (r104 != null) goto L11;
        r104 = "";
    L11:
        RegisterPermApplyRequest r105 = new RegisterPermApplyRequest(r104, this.$messageId, this.$token, this.$type);
        Map<String, String> r106 = MapsKt.mapOf(TuplesKt.to("agw-js-conv", "str"));
        this.label = 1;
        r100 = r103.registerPermApply(r105, r106, this);
        if (r100 != r101) goto L14;
        return r101;
    }
}
