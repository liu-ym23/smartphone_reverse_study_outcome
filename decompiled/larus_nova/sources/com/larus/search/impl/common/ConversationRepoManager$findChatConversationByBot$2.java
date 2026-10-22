package com.larus.search.impl.common;

import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import wc9.e;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/im/bean/conversation/Conversation;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.search.impl.common.ConversationRepoManager$findChatConversationByBot$2", f = "ConversationRepoManager.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
final class ConversationRepoManager$findChatConversationByBot$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super e>, Object> {
    final /* synthetic */ String $botId;
    int label;

    public ConversationRepoManager$findChatConversationByBot$2(String r100, Continuation<? super ConversationRepoManager$findChatConversationByBot$2> r101) {
        this.$botId = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ConversationRepoManager$findChatConversationByBot$2(this.$botId, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super e> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super e> r101) {
        return ((ConversationRepoManager$findChatConversationByBot$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
        IConversationRepoService r103 = ConversationRepoManager.f367621b;
        String r104 = this.$botId;
        this.label = 1;
        r100 = r103.a(r104, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
