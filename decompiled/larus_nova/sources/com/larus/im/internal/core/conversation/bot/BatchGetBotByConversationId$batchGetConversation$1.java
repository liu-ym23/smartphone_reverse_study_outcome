package com.larus.im.internal.core.conversation.bot;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.conversation.bot.BatchGetBotByConversationId", f = "BatchGetBotByConversationId.kt", i = {0, 2}, l = {174, 176, 189}, m = "batchGetConversation", n = {"convIdSet", "result"}, s = {"L$0", "L$0"})
public final class BatchGetBotByConversationId$batchGetConversation$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BatchGetBotByConversationId this$0;

    public BatchGetBotByConversationId$batchGetConversation$1(BatchGetBotByConversationId r100, Continuation<? super BatchGetBotByConversationId$batchGetConversation$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, this);
    }
}
