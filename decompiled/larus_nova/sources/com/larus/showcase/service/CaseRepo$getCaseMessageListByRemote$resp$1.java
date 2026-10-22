package com.larus.showcase.service;

import com.larus.network.bean.BizResponse;
import com.larus.platform.model.showcase.CaseMessageDataRequest;
import com.larus.showcase.api.CaseApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "", "", "Lcom/larus/showcase/api/CaseApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.showcase.service.CaseRepo$getCaseMessageListByRemote$resp$1", f = "CaseRepo.kt", i = {}, l = {108}, m = "invokeSuspend", n = {}, s = {})
public final class CaseRepo$getCaseMessageListByRemote$resp$1 extends SuspendLambda implements Function2<CaseApi, Continuation<? super BizResponse<List<? extends String>>>, Object> {
    final /* synthetic */ String $caseId;
    private /* synthetic */ Object L$0;
    int label;

    public CaseRepo$getCaseMessageListByRemote$resp$1(String r100, Continuation<? super CaseRepo$getCaseMessageListByRemote$resp$1> r101) {
        this.$caseId = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        CaseRepo$getCaseMessageListByRemote$resp$1 r102 = new CaseRepo$getCaseMessageListByRemote$resp$1(this.$caseId, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CaseApi r100, Continuation<? super BizResponse<List<String>>> r101) {
        return ((CaseRepo$getCaseMessageListByRemote$resp$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CaseApi r100, Continuation<? super BizResponse<List<? extends String>>> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L15:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        CaseApi r103 = (CaseApi) this.L$0;
        Long r104 = StringsKt.toLongOrNull(this.$caseId);
        if (r104 == null) goto L11;
        long r105 = r104.longValue();
    L12:
        CaseMessageDataRequest r106 = new CaseMessageDataRequest(Boxing.boxLong(r105));
        this.label = 1;
        r100 = r103.getCaseData(r106, this);
        if (r100 != r101) goto L15;
        return r101;
    L11:
        r105 = 0;
        goto L12
    }
}
