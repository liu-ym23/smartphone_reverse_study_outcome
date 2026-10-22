package com.bytedance.sdk.bridge;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes22.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, BridgeMethodInfo> f269594a;

    public final Collection<BridgeMethodInfo> a() {
        return ((ConcurrentHashMap) this.f269594a).values();
    }

    public i() {
        this.f269594a = new ConcurrentHashMap();
    }

    public final void b(String r100, BridgeMethodInfo r101) {
        ((ConcurrentHashMap) this.f269594a).put(r100, r101);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
