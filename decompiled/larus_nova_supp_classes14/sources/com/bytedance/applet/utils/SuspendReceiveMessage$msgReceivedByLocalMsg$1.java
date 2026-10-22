package com.bytedance.applet.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.utils.SuspendReceiveMessage", f = "SuspendReceiveMessage.kt", i = {}, l = {34}, m = "msgReceivedByLocalMsg", n = {}, s = {})
public final class SuspendReceiveMessage$msgReceivedByLocalMsg$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SuspendReceiveMessage this$0;

    public SuspendReceiveMessage$msgReceivedByLocalMsg$1(SuspendReceiveMessage r1, Continuation<? super SuspendReceiveMessage$msgReceivedByLocalMsg$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
