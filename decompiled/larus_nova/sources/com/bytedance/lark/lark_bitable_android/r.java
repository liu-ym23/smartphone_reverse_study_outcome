package com.bytedance.lark.lark_bitable_android;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f253103a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicLong f253104b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<Long, q0> f253105c = null;

    public r() {
    }

    static {
        f253103a = new r();
        f253104b = new AtomicLong(100);
        f253105c = new LinkedHashMap();
    }

    public final long a(q0 r100) {
        Intrinsics.checkNotNullParameter(r100, "cb");
        monitor-enter(this);
        long r101 = f253104b.incrementAndGet();     // Catch: Throwable -> L7
        Long r102 = Long.valueOf(r101);     // Catch: Throwable -> L7
        f253105c.put(r102, r100);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public final void b(long r100) {
        monitor-enter(this);
        Map<Long, q0> r101 = f253105c;     // Catch: Throwable -> L10
        LinkedHashMap r102 = (LinkedHashMap) r101;     // Catch: Throwable -> L10
        if (((q0) r102.get(Long.valueOf(r100))) != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        q0 r103 = r101.remove(Long.valueOf(r100));     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
