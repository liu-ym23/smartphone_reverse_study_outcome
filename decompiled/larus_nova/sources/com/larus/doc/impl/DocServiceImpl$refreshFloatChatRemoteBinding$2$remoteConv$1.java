package com.larus.doc.impl;

import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.ss.bduploader.UploadKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/im/bean/conversation/Conversation;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.DocServiceImpl$refreshFloatChatRemoteBinding$2$remoteConv$1", f = "DocServiceImpl.kt", i = {}, l = {UploadKeys.KeyIsEnd2EndEncryptionOption}, m = "invokeSuspend", n = {}, s = {})
public final class DocServiceImpl$refreshFloatChatRemoteBinding$2$remoteConv$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super wc9.e>, Object> {
    final /* synthetic */ String $remoteConvId;
    int label;

    public DocServiceImpl$refreshFloatChatRemoteBinding$2$remoteConv$1(String r100, Continuation<? super DocServiceImpl$refreshFloatChatRemoteBinding$2$remoteConv$1> r101) {
        this.$remoteConvId = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DocServiceImpl$refreshFloatChatRemoteBinding$2$remoteConv$1(this.$remoteConvId, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super wc9.e> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super wc9.e> r101) {
        return ((DocServiceImpl$refreshFloatChatRemoteBinding$2$remoteConv$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r110);
    L14:
        return r110;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        IConversationRepoService r102 = RepoDispatcherDelegate.f307737b.f();
        String r111 = this.$remoteConvId;
        if (r111 != null) goto L11;
        r111 = "";
    L11:
        this.label = 1;
        r110 = IConversationRepoService.a.c(r102, r111, false, null, this, 6);
        if (r110 != r100) goto L14;
        return r100;
    }
}
