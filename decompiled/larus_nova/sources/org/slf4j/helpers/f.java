package org.slf4j.helpers;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes42.dex */
public final class f implements xwc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f526230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, e> f526231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedBlockingQueue<org.slf4j.event.b> f526232c;

    public f() {
        this.f526230a = false;
        this.f526231b = new ConcurrentHashMap();
        this.f526232c = new LinkedBlockingQueue();
    }

    @Override // xwc.a
    public final synchronized xwc.c a(String r100) {
        monitor-enter(this);
        e r101 = (e) ((ConcurrentHashMap) this.f526231b).get(r100);     // Catch: Throwable -> L8
        if (r101 != null) goto L6;
        r101 = new e(r100, this.f526232c, this.f526230a);     // Catch: Throwable -> L8
        ((ConcurrentHashMap) this.f526231b).put(r100, r101);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return r101;
    L8:
        th = move-exception;
        throw th;
    }
}
