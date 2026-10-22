package com.bytedance.lark.inject_request_android;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes39.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f252942a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Long, e> f252943b = null;

    public a() {
    }

    static {
        f252942a = new a();
        new AtomicLong(100);
        f252943b = new LinkedHashMap();
    }

    public final void a(long r100) {
        monitor-enter(this);
        Map<Long, e> r101 = f252943b;     // Catch: Throwable -> L10
        LinkedHashMap r102 = (LinkedHashMap) r101;     // Catch: Throwable -> L10
        if (((e) r102.get(Long.valueOf(r100))) != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        e r103 = r101.remove(Long.valueOf(r100));     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
