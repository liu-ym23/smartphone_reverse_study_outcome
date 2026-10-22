package com.bytedance.ee.bear.lynx.impl.xbridge;

import java.util.UUID;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements p56.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f229932a;

    public e() {
        this.f229932a = UUID.randomUUID().toString();
    }

    @Override // p56.b
    public final String provideContainerID() {
        return this.f229932a;
    }
}
