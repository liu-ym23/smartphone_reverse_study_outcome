package com.bytedance.applet.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.impl.AppletHostMessageServiceImpl", f = "AppletHostMessageServiceImpl.kt", i = {0, 0, 0, 1}, l = {307, 328}, m = "syncBotReply", n = {"content", "localMsgId", "suspendReceiveMessage", "content"}, s = {"L$0", "L$1", "L$2", "L$0"})
public final class AppletHostMessageServiceImpl$syncBotReply$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletHostMessageServiceImpl this$0;

    public AppletHostMessageServiceImpl$syncBotReply$1(AppletHostMessageServiceImpl r1, Continuation<? super AppletHostMessageServiceImpl$syncBotReply$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.h(null, this);
    }
}
