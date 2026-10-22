package com.bytedance.lark.lark_rust_sdk_integrator_android;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final a a = null;
    public static final Map<Long, i> b = null;

    public a() {
    }

    static {
        a = new a();
        new AtomicLong(100);
        b = new LinkedHashMap();
    }

    public final void a(long r4) {
        monitor-enter(this);
        Map<Long, i> r0 = b;     // Catch: Throwable -> L10
        LinkedHashMap r2 = (LinkedHashMap) r0;     // Catch: Throwable -> L10
        if (((i) r2.get(Long.valueOf(r4))) != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        i r5 = r0.remove(Long.valueOf(r4));     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
