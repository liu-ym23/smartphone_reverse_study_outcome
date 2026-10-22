package com.bytedance.apm.agent.instrumentation.okhttp3;

import okhttp3.Call;
import okhttp3.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class OkHttpEventFactory implements i.c {
    public i.c originFactory;

    public OkHttpEventFactory(i.c r1) {
        this.originFactory = r1;
    }

    public i create(Call r2) {
        i.c r0 = this.originFactory;
        if (r0 == null) goto L5;
        i r3 = r0.create(r2);
    L7:
        return new OkHttpEventListener(r3);
    L5:
        r3 = null;
        goto L7
    }
}
