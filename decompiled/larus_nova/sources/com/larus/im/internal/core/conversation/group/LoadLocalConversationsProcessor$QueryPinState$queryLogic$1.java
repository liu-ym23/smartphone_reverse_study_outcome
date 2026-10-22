package com.larus.im.internal.core.conversation.group;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.conversation.group.LoadLocalConversationsProcessor$QueryPinState", f = "LoadLocalConversationsProcessor.kt", i = {}, l = {330, 335}, m = "queryLogic", n = {}, s = {})
public final class LoadLocalConversationsProcessor$QueryPinState$queryLogic$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoadLocalConversationsProcessor.QueryPinState this$0;

    public LoadLocalConversationsProcessor$QueryPinState$queryLogic$1(LoadLocalConversationsProcessor.QueryPinState r100, Continuation<? super LoadLocalConversationsProcessor$QueryPinState$queryLogic$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(this);
    }
}
