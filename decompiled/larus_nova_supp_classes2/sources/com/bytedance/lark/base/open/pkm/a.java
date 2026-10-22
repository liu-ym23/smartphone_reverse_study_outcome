package com.bytedance.lark.base.open.pkm;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f7223a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicLong f7224b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<Long, g> f7225c = null;

    public a() {
    }

    static {
        f7223a = new a();
        f7224b = new AtomicLong(100);
        f7225c = new LinkedHashMap();
    }

    public final void a(long r4) {
        monitor-enter(this);
        Map<Long, g> r0 = f7225c;     // Catch: Throwable -> L10
        LinkedHashMap r2 = (LinkedHashMap) r0;     // Catch: Throwable -> L10
        if (((g) r2.get(Long.valueOf(r4))) != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        g r5 = r0.remove(Long.valueOf(r4));     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
