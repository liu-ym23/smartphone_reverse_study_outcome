package com.obric.assistant.cocreationreview;

import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "", "Lcom/obric/assistant/cocreationreview/CocreationLabelingServerApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.cocreationreview.CocreationLabelingServerClient$submitUserFeedbackStat$2", f = "CocreationLabelingServerClient.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
final class CocreationLabelingServerClient$submitUserFeedbackStat$2 extends SuspendLambda implements Function2<CocreationLabelingServerApi, Continuation<? super BizResponse<Object>>, Object> {
    final /* synthetic */ CocreationUserFeedbackStatRequest $request;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CocreationLabelingServerClient this$0;

    public CocreationLabelingServerClient$submitUserFeedbackStat$2(CocreationLabelingServerClient r100, CocreationUserFeedbackStatRequest r101, Continuation<? super CocreationLabelingServerClient$submitUserFeedbackStat$2> r102) {
        this.this$0 = r100;
        this.$request = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        CocreationLabelingServerClient$submitUserFeedbackStat$2 r102 = new CocreationLabelingServerClient$submitUserFeedbackStat$2(this.this$0, this.$request, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CocreationLabelingServerApi r100, Continuation<? super BizResponse<Object>> r101) {
        return ((CocreationLabelingServerClient$submitUserFeedbackStat$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CocreationLabelingServerApi r100, Continuation<? super BizResponse<Object>> r101) {
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
        CocreationLabelingServerApi r103 = (CocreationLabelingServerApi) this.L$0;
        String r104 = CocreationLabelingServerClient.a(this.this$0);
        CocreationUserFeedbackStatRequest r105 = this.$request;
        this.label = 1;
        r100 = r103.submitUserFeedbackStat(r104, r105, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
