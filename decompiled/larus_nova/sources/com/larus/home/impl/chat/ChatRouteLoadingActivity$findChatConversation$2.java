package com.larus.home.impl.chat;

import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/im/bean/conversation/Conversation;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.home.impl.chat.ChatRouteLoadingActivity$findChatConversation$2", f = "ChatRouteLoadingActivity.kt", i = {}, l = {902}, m = "invokeSuspend", n = {}, s = {})
final class ChatRouteLoadingActivity$findChatConversation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super wc9.e>, Object> {
    final /* synthetic */ String $convId;
    int label;

    public ChatRouteLoadingActivity$findChatConversation$2(String r100, Continuation<? super ChatRouteLoadingActivity$findChatConversation$2> r101) {
        this.$convId = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ChatRouteLoadingActivity$findChatConversation$2(this.$convId, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super wc9.e> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super wc9.e> r101) {
        return ((ChatRouteLoadingActivity$findChatConversation$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
        IConversationRepoService r102 = RepoDispatcherDelegate.f307737b.f();
        String r103 = this.$convId;
        this.label = 1;
        r110 = IConversationRepoService.a.c(r102, r103, false, null, this, 6);
        if (r110 != r100) goto L11;
        return r100;
    }
}
