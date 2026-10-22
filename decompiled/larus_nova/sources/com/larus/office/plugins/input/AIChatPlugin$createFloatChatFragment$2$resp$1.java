package com.larus.office.plugins.input;

import com.larus.network.bean.BizResponse;
import com.larus.office.biz.docx.DocxApi;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/office/biz/docx/GetSubConversationRespV2;", "Lcom/larus/office/biz/docx/DocxApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.plugins.input.AIChatPlugin$createFloatChatFragment$2$resp$1", f = "AIChatPlugin.kt", i = {}, l = {4713}, m = "invokeSuspend", n = {}, s = {})
public final class AIChatPlugin$createFloatChatFragment$2$resp$1 extends SuspendLambda implements Function2<DocxApi, Continuation<? super BizResponse<on9.e>>, Object> {
    final /* synthetic */ String $docId;
    final /* synthetic */ boolean $requestFillMessageId;
    final /* synthetic */ Integer $requestSourceType;
    final /* synthetic */ int $resourceType;
    private /* synthetic */ Object L$0;
    int label;

    public AIChatPlugin$createFloatChatFragment$2$resp$1(String r100, int r101, Integer r102, boolean r103, Continuation<? super AIChatPlugin$createFloatChatFragment$2$resp$1> r104) {
        this.$docId = r100;
        this.$resourceType = r101;
        this.$requestSourceType = r102;
        this.$requestFillMessageId = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        AIChatPlugin$createFloatChatFragment$2$resp$1 r102 = new AIChatPlugin$createFloatChatFragment$2$resp$1(this.$docId, this.$resourceType, this.$requestSourceType, this.$requestFillMessageId, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(DocxApi r100, Continuation<? super BizResponse<on9.e>> r101) {
        return ((AIChatPlugin$createFloatChatFragment$2$resp$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(DocxApi r100, Continuation<? super BizResponse<on9.e>> r101) {
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
        DocxApi r111 = (DocxApi) this.L$0;
        on9.d r102 = new on9.d(this.$docId, this.$resourceType, this.$requestSourceType, true, this.$requestFillMessageId);
        this.label = 1;
        r110 = r111.getSubConversationV2(r102, this);
        if (r110 != r100) goto L11;
        return r100;
    }
}
