package com.bytedance.ee.bear.lynx.impl.xbridge;

import java.util.UUID;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements p56.b {
    public final String a;

    public e() {
        this.a = UUID.randomUUID().toString();
    }

    public final String provideContainerID() {
        return this.a;
    }
}
