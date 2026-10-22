package com.bytedance.lark.open_app_android;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f253416a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicLong f253417b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<Long, h> f253418c = null;

    public a() {
    }

    static {
        f253416a = new a();
        f253417b = new AtomicLong(100);
        f253418c = new LinkedHashMap();
    }

    public final void a(long r100) {
        monitor-enter(this);
        Map<Long, h> r101 = f253418c;     // Catch: Throwable -> L10
        LinkedHashMap r102 = (LinkedHashMap) r101;     // Catch: Throwable -> L10
        if (((h) r102.get(Long.valueOf(r100))) != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        h r103 = r101.remove(Long.valueOf(r100));     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
