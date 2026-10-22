package com.larus.im.internal.network.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.network.impl.ConversationNetworkImpl", f = "ConversationNetworkImpl.kt", i = {}, l = {73}, m = "getConversationInfo", n = {}, s = {})
public final class ConversationNetworkImpl$getConversationInfo$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationNetworkImpl this$0;

    public ConversationNetworkImpl$getConversationInfo$1(ConversationNetworkImpl r100, Continuation<? super ConversationNetworkImpl$getConversationInfo$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, null, false, this);
    }
}
