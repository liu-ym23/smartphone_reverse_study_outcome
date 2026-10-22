package com.larus.im.internal.core.conversation.group;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.conversation.group.LoadLocalConversationsProcessor", f = "LoadLocalConversationsProcessor.kt", i = {0, 0}, l = {138}, m = "transformPageData", n = {"conversations", "pageIndex"}, s = {"L$0", "I$0"})
public final class LoadLocalConversationsProcessor$transformPageData$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoadLocalConversationsProcessor this$0;

    public LoadLocalConversationsProcessor$transformPageData$1(LoadLocalConversationsProcessor r100, Continuation<? super LoadLocalConversationsProcessor$transformPageData$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        LoadLocalConversationsProcessor r101 = this.this$0;
        int r102 = LoadLocalConversationsProcessor.f347584f;
        return r101.g(null, 0, this);
    }
}
