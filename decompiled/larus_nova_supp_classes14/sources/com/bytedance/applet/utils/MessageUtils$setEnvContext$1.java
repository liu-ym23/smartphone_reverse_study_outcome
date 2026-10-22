package com.bytedance.applet.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.utils.MessageUtils", f = "MessageUtils.kt", i = {0, 0, 0, 0}, l = {388, 398}, m = "setEnvContext", n = {"conversationId", "key", "value", "eventType"}, s = {"L$0", "L$1", "L$2", "I$0"})
public final class MessageUtils$setEnvContext$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageUtils this$0;

    public MessageUtils$setEnvContext$1(MessageUtils r1, Continuation<? super MessageUtils$setEnvContext$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m(null, 0, null, null, this);
    }
}
