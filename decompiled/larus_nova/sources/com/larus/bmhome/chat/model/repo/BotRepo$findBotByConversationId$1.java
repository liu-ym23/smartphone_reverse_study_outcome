package com.larus.bmhome.chat.model.repo;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.BotRepo", f = "BotRepo.kt", i = {0, 0, 1}, l = {166, 170}, m = "findBotByConversationId", n = {"conversationId", "forceNew", "conversationId"}, s = {"L$0", "Z$0", "L$0"})
public final class BotRepo$findBotByConversationId$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BotRepo this$0;

    public BotRepo$findBotByConversationId$1(BotRepo r100, Continuation<? super BotRepo$findBotByConversationId$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.j1(null, false, this);
    }
}
