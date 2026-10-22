package com.larus.im.internal.core.conversation;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.conversation.ConversationHandler", f = "ConversationHandler.kt", i = {0, 0}, l = {199}, m = "updateSection$core_release", n = {"conversationId", "sectionId"}, s = {"L$0", "L$1"})
public final class ConversationHandler$updateSection$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationHandler this$0;

    public ConversationHandler$updateSection$1(ConversationHandler r100, Continuation<? super ConversationHandler$updateSection$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateSection$core_release(null, null, this);
    }
}
