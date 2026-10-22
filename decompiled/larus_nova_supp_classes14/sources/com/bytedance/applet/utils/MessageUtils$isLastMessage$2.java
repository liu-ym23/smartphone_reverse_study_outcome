package com.bytedance.applet.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.utils.MessageUtils", f = "MessageUtils.kt", i = {0, 1}, l = {89, 90}, m = "isLastMessage", n = {"msgId", "msgId"}, s = {"L$0", "L$0"})
public final class MessageUtils$isLastMessage$2 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageUtils this$0;

    public MessageUtils$isLastMessage$2(MessageUtils r1, Continuation<? super MessageUtils$isLastMessage$2> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.j(null, this);
    }
}
