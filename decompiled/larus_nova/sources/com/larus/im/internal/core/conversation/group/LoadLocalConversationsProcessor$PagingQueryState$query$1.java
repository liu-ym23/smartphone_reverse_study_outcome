package com.larus.im.internal.core.conversation.group;

import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.conversation.group.LoadLocalConversationsProcessor$PagingQueryState", f = "LoadLocalConversationsProcessor.kt", i = {0}, l = {249}, m = "query", n = {DyPayConstant.KEY_START_TIME}, s = {"J$0"})
public final class LoadLocalConversationsProcessor$PagingQueryState$query$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoadLocalConversationsProcessor.PagingQueryState this$0;

    public LoadLocalConversationsProcessor$PagingQueryState$query$1(LoadLocalConversationsProcessor.PagingQueryState r100, Continuation<? super LoadLocalConversationsProcessor$PagingQueryState$query$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.query(this);
    }
}
