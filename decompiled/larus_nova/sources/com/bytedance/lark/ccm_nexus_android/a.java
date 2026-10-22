package com.bytedance.lark.ccm_nexus_android;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes17.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f252910a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicLong f252911b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<Long, k> f252912c = null;

    public a() {
    }

    static {
        f252910a = new a();
        f252911b = new AtomicLong(100);
        f252912c = new LinkedHashMap();
    }

    public final void a(long r100) {
        monitor-enter(this);
        Map<Long, k> r101 = f252912c;     // Catch: Throwable -> L10
        LinkedHashMap r102 = (LinkedHashMap) r101;     // Catch: Throwable -> L10
        if (((k) r102.get(Long.valueOf(r100))) != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        k r103 = r101.remove(Long.valueOf(r100));     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
