package com.larus.reach.impl;

import com.larus.network.bean.BizResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/reach/impl/ReachActionResponse;", "Lcom/larus/reach/impl/ReachActionApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.reach.impl.ReachActionExecutor$sendRequest$result$1", f = "ReachActionExecutor.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
final class ReachActionExecutor$sendRequest$result$1 extends SuspendLambda implements Function2<ReachActionApi, Continuation<? super BizResponse<ReachActionResponse>>, Object> {
    final /* synthetic */ String $bizReqId;
    final /* synthetic */ String $bizReqPsm;
    final /* synthetic */ Map<String, String> $data;
    private /* synthetic */ Object L$0;
    int label;

    public ReachActionExecutor$sendRequest$result$1(String r100, String r101, Map<String, String> r102, Continuation<? super ReachActionExecutor$sendRequest$result$1> r103) {
        this.$bizReqPsm = r100;
        this.$bizReqId = r101;
        this.$data = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ReachActionExecutor$sendRequest$result$1 r102 = new ReachActionExecutor$sendRequest$result$1(this.$bizReqPsm, this.$bizReqId, this.$data, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(ReachActionApi r100, Continuation<? super BizResponse<ReachActionResponse>> r101) {
        return ((ReachActionExecutor$sendRequest$result$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ReachActionApi r100, Continuation<? super BizResponse<ReachActionResponse>> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r110);
    L27:
        return r110;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        ReachActionApi r111 = (ReachActionApi) this.L$0;
        String r102 = this.$bizReqPsm;
        String r103 = this.$bizReqId;
        if (r102 != null) goto L11;
        boolean r104 = true;
    L13:
        if (r104 == true) goto L16;
        r103 = null;
    L16:
        Map<String, String> r105 = this.$data;
        if (r105 == null) goto L23;
        String r106 = r105.get("params");
        if (r106 == null) goto L23;
        if ((!StringsKt.isBlank(r106)) == false) goto L23;
        String r107 = r106;
    L24:
        ReachActionRequest r112 = new ReachActionRequest(r102, r103, 0, r107, 4, null);
        this.label = 1;
        r110 = r111.sendCommonRequest(r112, this);
        if (r110 != r100) goto L27;
        return r100;
    L23:
        r107 = null;
        goto L24
    L11:
        r104 = false;
        goto L13
    }
}
