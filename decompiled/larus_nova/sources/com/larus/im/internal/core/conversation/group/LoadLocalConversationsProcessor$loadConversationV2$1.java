package com.larus.im.internal.core.conversation.group;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.conversation.group.LoadLocalConversationsProcessor", f = "LoadLocalConversationsProcessor.kt", i = {0, 1, 2}, l = {105, 109, 111}, m = "loadConversationV2", n = {"queryState", "queryState", "queryState"}, s = {"L$0", "L$0", "L$0"})
final class LoadLocalConversationsProcessor$loadConversationV2$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoadLocalConversationsProcessor this$0;

    public LoadLocalConversationsProcessor$loadConversationV2$1(LoadLocalConversationsProcessor r100, Continuation<? super LoadLocalConversationsProcessor$loadConversationV2$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return LoadLocalConversationsProcessor.d(this.this$0, null, this);
    }
}
