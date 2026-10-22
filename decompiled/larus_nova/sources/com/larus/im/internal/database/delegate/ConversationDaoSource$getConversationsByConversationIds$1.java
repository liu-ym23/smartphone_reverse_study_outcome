package com.larus.im.internal.database.delegate;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.database.delegate.ConversationDaoSource", f = "ConversationDaoSource.kt", i = {}, l = {342}, m = "getConversationsByConversationIds", n = {}, s = {})
public final class ConversationDaoSource$getConversationsByConversationIds$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationDaoSource this$0;

    public ConversationDaoSource$getConversationsByConversationIds$1(ConversationDaoSource r100, Continuation<? super ConversationDaoSource$getConversationsByConversationIds$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.h(null, this);
    }
}
