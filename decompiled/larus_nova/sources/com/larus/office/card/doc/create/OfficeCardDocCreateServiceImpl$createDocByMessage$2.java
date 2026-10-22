package com.larus.office.card.doc.create;

import com.larus.network.bean.BizResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/office/card/doc/create/OfficeCardCreateDocByMessageResponse;", "Lcom/larus/office/card/doc/create/OfficeCardDocCreateApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.card.doc.create.OfficeCardDocCreateServiceImpl$createDocByMessage$2", f = "OfficeCardDocCreateServiceImpl.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {})
public final class OfficeCardDocCreateServiceImpl$createDocByMessage$2 extends SuspendLambda implements Function2<OfficeCardDocCreateApi, Continuation<? super BizResponse<b>>, Object> {
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $docRealToken;
    final /* synthetic */ Map<String, String> $headers;
    final /* synthetic */ long $messageId;
    final /* synthetic */ int $resourceType;
    final /* synthetic */ int $sourceType;
    final /* synthetic */ Boolean $useMessageContent;
    private /* synthetic */ Object L$0;
    int label;

    public OfficeCardDocCreateServiceImpl$createDocByMessage$2(String r100, long r101, int r102, int r103, String r104, Boolean r105, Map<String, String> r106, Continuation<? super OfficeCardDocCreateServiceImpl$createDocByMessage$2> r107) {
        this.$conversationId = r100;
        this.$messageId = r101;
        this.$resourceType = r102;
        this.$sourceType = r103;
        this.$docRealToken = r104;
        this.$useMessageContent = r105;
        this.$headers = r106;
        super(2, r107);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r110, Continuation<?> r111) {
        OfficeCardDocCreateServiceImpl$createDocByMessage$2 r112 = new OfficeCardDocCreateServiceImpl$createDocByMessage$2(this.$conversationId, this.$messageId, this.$resourceType, this.$sourceType, this.$docRealToken, this.$useMessageContent, this.$headers, r111);
        r112.L$0 = r110;
        return r112;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(OfficeCardDocCreateApi r100, Continuation<? super BizResponse<b>> r101) {
        return ((OfficeCardDocCreateServiceImpl$createDocByMessage$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(OfficeCardDocCreateApi r100, Continuation<? super BizResponse<b>> r101) {
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
        OfficeCardDocCreateApi r111 = (OfficeCardDocCreateApi) this.L$0;
        a r102 = new a(this.$conversationId, Boxing.boxLong(this.$messageId), this.$resourceType, this.$sourceType, this.$docRealToken, this.$useMessageContent);
        Map<String, String> r103 = this.$headers;
        this.label = 1;
        r110 = r111.createDocByMessage(r102, r103, this);
        if (r110 != r100) goto L11;
        return r100;
    }
}
