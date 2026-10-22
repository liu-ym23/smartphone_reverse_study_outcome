package com.larus.bmhome.social.userchat.model;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.userchat.model.LocalSubConvHelper", f = "LocalSubConvHelper.kt", i = {0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3}, l = {105, 301, 112, 115}, m = "findOrCreateMainBotSubConversation", n = {"expectedSecUserId", "sourceConversation", "expectedSecUserId", "sourceConversation", "botId", "$this$withLock_u24default$iv", "expectedSecUserId", "sourceConversation", "botId", "$this$withLock_u24default$iv", "expectedSecUserId", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1"})
public final class LocalSubConvHelper$findOrCreateMainBotSubConversation$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocalSubConvHelper this$0;

    public LocalSubConvHelper$findOrCreateMainBotSubConversation$1(LocalSubConvHelper r100, Continuation<? super LocalSubConvHelper$findOrCreateMainBotSubConversation$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, null, this);
    }
}
