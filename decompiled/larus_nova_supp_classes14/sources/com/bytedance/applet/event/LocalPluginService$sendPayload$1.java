package com.bytedance.applet.event;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.event.LocalPluginService", f = "LocalPluginService.kt", i = {}, l = {265}, m = "sendPayload", n = {}, s = {})
public final class LocalPluginService$sendPayload$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocalPluginService this$0;

    public LocalPluginService$sendPayload$1(LocalPluginService r1, Continuation<? super LocalPluginService$sendPayload$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        LocalPluginService r3 = this.this$0;
        LocalPluginService r0 = LocalPluginService.a;
        return r3.f(null, this);
    }
}
