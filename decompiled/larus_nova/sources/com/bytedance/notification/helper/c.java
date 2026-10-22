package com.bytedance.notification.helper;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile c f266074c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Boolean> f266075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Integer> f266076b;

    public static c a() {
        if (f266074c != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f266074c != null) goto L9;
        f266074c = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f266074c;
    }

    public c() {
        this.f266075a = new ConcurrentHashMap();
        this.f266076b = new ConcurrentHashMap();
        new ConcurrentHashMap();
    }
}
