package com.bytedance.lark.lark_rust_sdk_integrator_android;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f253244a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Long, i> f253245b = null;

    public a() {
    }

    static {
        f253244a = new a();
        new AtomicLong(100);
        f253245b = new LinkedHashMap();
    }

    public final void a(long r100) {
        monitor-enter(this);
        Map<Long, i> r101 = f253245b;     // Catch: Throwable -> L10
        LinkedHashMap r102 = (LinkedHashMap) r101;     // Catch: Throwable -> L10
        if (((i) r102.get(Long.valueOf(r100))) != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        i r103 = r101.remove(Long.valueOf(r100));     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
