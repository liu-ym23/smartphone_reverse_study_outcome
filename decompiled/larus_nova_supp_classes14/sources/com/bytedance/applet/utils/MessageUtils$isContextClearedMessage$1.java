package com.bytedance.applet.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.utils.MessageUtils", f = "MessageUtils.kt", i = {1}, l = {345, 347}, m = "isContextClearedMessage", n = {"msg"}, s = {"L$0"})
public final class MessageUtils$isContextClearedMessage$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageUtils this$0;

    public MessageUtils$isContextClearedMessage$1(MessageUtils r1, Continuation<? super MessageUtils$isContextClearedMessage$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i(null, this);
    }
}
