package com.larus.im.internal.core.conversation;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.conversation.ConversationHandler", f = "ConversationHandler.kt", i = {0}, l = {181}, m = "updateConversation$core_release", n = {"notify"}, s = {"Z$0"})
public final class ConversationHandler$updateConversation$2 extends ContinuationImpl {
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationHandler this$0;

    public ConversationHandler$updateConversation$2(ConversationHandler r100, Continuation<? super ConversationHandler$updateConversation$2> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateConversation$core_release(null, null, false, this);
    }
}
