package com.larus.im.internal.core.conversation.group;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.conversation.group.LoadLocalConversationsProcessor", f = "LoadLocalConversationsProcessor.kt", i = {0, 0}, l = {69}, m = "loadAllConversation", n = {"conversations", "dbCost"}, s = {"L$0", "L$1"})
final class LoadLocalConversationsProcessor$loadAllConversation$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoadLocalConversationsProcessor this$0;

    public LoadLocalConversationsProcessor$loadAllConversation$1(LoadLocalConversationsProcessor r100, Continuation<? super LoadLocalConversationsProcessor$loadAllConversation$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return LoadLocalConversationsProcessor.c(this.this$0, null, this);
    }
}
