package com.bytedance.applet.event;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.event.LocalPluginService", f = "LocalPluginService.kt", i = {0, 0, 0, 0, 0}, l = {249}, m = "sendPayloadWithRetry", n = {"payload", "localPluginContext", "transport", "retryTimes", "attempt"}, s = {"L$0", "L$1", "L$2", "I$0", "I$2"})
final class LocalPluginService$sendPayloadWithRetry$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocalPluginService this$0;

    public LocalPluginService$sendPayloadWithRetry$1(LocalPluginService r1, Continuation<? super LocalPluginService$sendPayloadWithRetry$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return LocalPluginService.b(this.this$0, null, 0, null, this);
    }
}
