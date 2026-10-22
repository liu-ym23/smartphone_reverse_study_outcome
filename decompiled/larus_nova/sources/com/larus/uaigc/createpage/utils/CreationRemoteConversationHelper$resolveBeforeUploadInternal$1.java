package com.larus.uaigc.createpage.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.createpage.utils.CreationRemoteConversationHelper", f = "CreationRemoteConversationHelper.kt", i = {0, 0, 0, 1, 1}, l = {114, 63}, m = "resolveBeforeUploadInternal", n = {"conversationId", "fallbackBotId", "$this$withLock_u24default$iv", "conversationId", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
public final class CreationRemoteConversationHelper$resolveBeforeUploadInternal$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationRemoteConversationHelper this$0;

    public CreationRemoteConversationHelper$resolveBeforeUploadInternal$1(CreationRemoteConversationHelper r100, Continuation<? super CreationRemoteConversationHelper$resolveBeforeUploadInternal$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        CreationRemoteConversationHelper r101 = this.this$0;
        CreationRemoteConversationHelper r102 = CreationRemoteConversationHelper.f372613a;
        return r101.b(null, null, this);
    }
}
