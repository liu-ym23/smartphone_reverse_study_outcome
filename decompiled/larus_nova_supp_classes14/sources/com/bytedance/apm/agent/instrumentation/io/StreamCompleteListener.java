package com.bytedance.apm.agent.instrumentation.io;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public interface StreamCompleteListener {
    void streamComplete(StreamCompleteEvent r1);

    void streamError(StreamCompleteEvent r1);
}
