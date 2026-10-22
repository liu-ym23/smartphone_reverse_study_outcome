package com.bytedance.lark.base.open.pkm;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f252890a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicLong f252891b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<Long, g> f252892c = null;

    public a() {
    }

    static {
        f252890a = new a();
        f252891b = new AtomicLong(100);
        f252892c = new LinkedHashMap();
    }

    public final void a(long r100) {
        monitor-enter(this);
        Map<Long, g> r101 = f252892c;     // Catch: Throwable -> L10
        LinkedHashMap r102 = (LinkedHashMap) r101;     // Catch: Throwable -> L10
        if (((g) r102.get(Long.valueOf(r100))) != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        g r103 = r101.remove(Long.valueOf(r100));     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
