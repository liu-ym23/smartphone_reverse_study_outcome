package com.larus.bmhome.chat.model.prompt;

import com.larus.bmhome.chat.bean.UpdateWcbSuggestsRequest;
import com.larus.bmhome.chat.model.repo.UpdateWcbSuggestsApi;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "", "Lcom/larus/bmhome/chat/model/repo/UpdateWcbSuggestsApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.model.prompt.PromptRulesRepo$updateWcbSuggests$result$1", f = "PromptRulesRepo.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
public final class PromptRulesRepo$updateWcbSuggests$result$1 extends SuspendLambda implements Function2<UpdateWcbSuggestsApi, Continuation<? super BizResponse<Object>>, Object> {
    final /* synthetic */ String $messageId;
    final /* synthetic */ String $suggests;
    final /* synthetic */ String $userId;
    private /* synthetic */ Object L$0;
    int label;

    public PromptRulesRepo$updateWcbSuggests$result$1(String r100, String r101, String r102, Continuation<? super PromptRulesRepo$updateWcbSuggests$result$1> r103) {
        this.$userId = r100;
        this.$messageId = r101;
        this.$suggests = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        PromptRulesRepo$updateWcbSuggests$result$1 r102 = new PromptRulesRepo$updateWcbSuggests$result$1(this.$userId, this.$messageId, this.$suggests, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(UpdateWcbSuggestsApi r100, Continuation<? super BizResponse<Object>> r101) {
        return ((PromptRulesRepo$updateWcbSuggests$result$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(UpdateWcbSuggestsApi r100, Continuation<? super BizResponse<Object>> r101) {
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
        UpdateWcbSuggestsApi r103 = (UpdateWcbSuggestsApi) this.L$0;
        UpdateWcbSuggestsRequest r104 = new UpdateWcbSuggestsRequest(this.$userId, this.$messageId, this.$suggests, Boxing.boxBoolean(true));
        this.label = 1;
        r100 = r103.updateWcbSuggests(r104, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
