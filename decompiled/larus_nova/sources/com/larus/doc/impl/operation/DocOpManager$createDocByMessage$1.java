package com.larus.doc.impl.operation;

import android.content.Context;
import com.larus.doc.api.IDocService;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.operation.DocOpManager$createDocByMessage$1", f = "DocOpManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DocOpManager$createDocByMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $currentPage;
    final /* synthetic */ String $docId;
    final /* synthetic */ String $docRealToken;
    final /* synthetic */ String $from;
    final /* synthetic */ boolean $isInMainConversation;
    final /* synthetic */ String $meetingRecordCreatePlatform;
    final /* synthetic */ String $messageId;
    int label;

    public DocOpManager$createDocByMessage$1(Context r100, String r101, String r102, boolean r103, String r104, String r105, String r106, String r107, String r108, Continuation<? super DocOpManager$createDocByMessage$1> r110) {
        this.$context = r100;
        this.$docId = r101;
        this.$conversationId = r102;
        this.$isInMainConversation = r103;
        this.$messageId = r104;
        this.$from = r105;
        this.$meetingRecordCreatePlatform = r106;
        this.$docRealToken = r107;
        this.$currentPage = r108;
        super(2, r110);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r110, Continuation<?> r111) {
        return new DocOpManager$createDocByMessage$1(this.$context, this.$docId, this.$conversationId, this.$isInMainConversation, this.$messageId, this.$from, this.$meetingRecordCreatePlatform, this.$docRealToken, this.$currentPage, r111);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DocOpManager$createDocByMessage$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r100);
        IDocService.Companion r101 = IDocService.f330931a;
        Context r102 = this.$context;
        Pair[] r103 = new Pair[7];
        r103[0] = TuplesKt.to("key_doc_id", this.$docId);
        r103[1] = TuplesKt.to("create_doc_by_msg_conv_id", this.$conversationId);
        r103[2] = TuplesKt.to("argIsInMainConversation", Boxing.boxBoolean(this.$isInMainConversation));
        r103[3] = TuplesKt.to("argMessageId", this.$messageId);
        r103[4] = TuplesKt.to("key_doc_enter_from", this.$from);
        r103[5] = TuplesKt.to("key_meeting_record_create_platform", this.$meetingRecordCreatePlatform);
        String r104 = this.$docRealToken;
        if (r104 != null) goto L7;
    L9:
        r104 = null;
    L10:
        r103[6] = TuplesKt.to("key_offline_retry_doc_real_token", r104);
        r101.Z9(r102, com.larus.utils.f.c(r103), this.$currentPage);
        return Unit.INSTANCE;
    L7:
        if ((true ^ StringsKt.isBlank(r104)) == false) goto L9;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
