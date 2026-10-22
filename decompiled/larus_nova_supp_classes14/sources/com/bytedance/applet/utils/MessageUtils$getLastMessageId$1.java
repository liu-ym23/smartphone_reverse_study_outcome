package com.bytedance.applet.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.utils.MessageUtils", f = "MessageUtils.kt", i = {}, l = {76}, m = "getLastMessageId", n = {}, s = {})
public final class MessageUtils$getLastMessageId$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageUtils this$0;

    public MessageUtils$getLastMessageId$1(MessageUtils r1, Continuation<? super MessageUtils$getLastMessageId$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        MessageUtils r3 = this.this$0;
        MessageUtils r0 = MessageUtils.a;
        return r3.f(null, this);
    }
}
