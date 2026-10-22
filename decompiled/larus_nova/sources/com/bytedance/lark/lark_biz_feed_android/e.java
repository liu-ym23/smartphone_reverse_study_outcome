package com.bytedance.lark.lark_biz_feed_android;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f253155a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicLong f253156b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<Long, u0> f253157c = null;

    public e() {
    }

    static {
        f253155a = new e();
        f253156b = new AtomicLong(100);
        f253157c = new LinkedHashMap();
    }

    public final u0 a(long r100) {
        monitor-enter(this);
        Map<Long, u0> r101 = f253157c;     // Catch: Throwable -> L6
        LinkedHashMap r102 = (LinkedHashMap) r101;     // Catch: Throwable -> L6
        u0 r103 = (u0) r102.get(Long.valueOf(r100));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r103;
    L6:
        th = move-exception;
        throw th;
    }

    public final long b(u0 r100) {
        Intrinsics.checkNotNullParameter(r100, "cb");
        monitor-enter(this);
        long r101 = f253156b.incrementAndGet();     // Catch: Throwable -> L7
        Long r102 = Long.valueOf(r101);     // Catch: Throwable -> L7
        f253157c.put(r102, r100);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }
}
