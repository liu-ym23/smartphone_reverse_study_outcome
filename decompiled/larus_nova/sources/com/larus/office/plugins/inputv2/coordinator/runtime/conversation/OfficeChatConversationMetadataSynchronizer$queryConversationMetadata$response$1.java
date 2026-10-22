package com.larus.office.plugins.inputv2.coordinator.runtime.conversation;

import com.larus.network.bean.BizResponse;
import com.larus.office.biz.docx.DocxApi;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/office/biz/docx/GetSubConversationRespV2;", "Lcom/larus/office/biz/docx/DocxApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.plugins.inputv2.coordinator.runtime.conversation.OfficeChatConversationMetadataSynchronizer$queryConversationMetadata$response$1", f = "OfficeChatConversationMetadataSynchronizer.kt", i = {}, l = {213}, m = "invokeSuspend", n = {}, s = {})
final class OfficeChatConversationMetadataSynchronizer$queryConversationMetadata$response$1 extends SuspendLambda implements Function2<DocxApi, Continuation<? super BizResponse<on9.e>>, Object> {
    final /* synthetic */ boolean $fillMessageId;
    final /* synthetic */ String $resourceId;
    final /* synthetic */ int $resourceType;
    final /* synthetic */ Integer $sourceType;
    private /* synthetic */ Object L$0;
    int label;

    public OfficeChatConversationMetadataSynchronizer$queryConversationMetadata$response$1(String r100, int r101, Integer r102, boolean r103, Continuation<? super OfficeChatConversationMetadataSynchronizer$queryConversationMetadata$response$1> r104) {
        this.$resourceId = r100;
        this.$resourceType = r101;
        this.$sourceType = r102;
        this.$fillMessageId = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        OfficeChatConversationMetadataSynchronizer$queryConversationMetadata$response$1 r102 = new OfficeChatConversationMetadataSynchronizer$queryConversationMetadata$response$1(this.$resourceId, this.$resourceType, this.$sourceType, this.$fillMessageId, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(DocxApi r100, Continuation<? super BizResponse<on9.e>> r101) {
        return ((OfficeChatConversationMetadataSynchronizer$queryConversationMetadata$response$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
    L21:
        return r110;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        DocxApi r111 = (DocxApi) this.L$0;
        String r102 = this.$resourceId;
        Integer r103 = Boxing.boxInt(this.$resourceType);
        if (r103.intValue() < 0) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == true) goto L15;
        r103 = null;
    L15:
        if (r103 == null) goto L17;
        int r105 = r103.intValue();
    L18:
        on9.d r106 = new on9.d(r102, r105, this.$sourceType, true, this.$fillMessageId);
        this.label = 1;
        r110 = r111.getSubConversationV2(r106, this);
        if (r110 != r100) goto L21;
        return r100;
    L17:
        r105 = 10;
        goto L18
    L11:
        r104 = false;
        goto L12
    }
}
