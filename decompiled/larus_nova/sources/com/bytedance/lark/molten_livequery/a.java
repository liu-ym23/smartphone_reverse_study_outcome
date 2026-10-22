package com.bytedance.lark.molten_livequery;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f253323a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicLong f253324b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<Long, i> f253325c = null;

    public a() {
    }

    static {
        f253323a = new a();
        f253324b = new AtomicLong(100);
        f253325c = new LinkedHashMap();
    }

    public final i a(long r100) {
        monitor-enter(this);
        Map<Long, i> r101 = f253325c;     // Catch: Throwable -> L6
        LinkedHashMap r102 = (LinkedHashMap) r101;     // Catch: Throwable -> L6
        i r103 = (i) r102.get(Long.valueOf(r100));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r103;
    L6:
        th = move-exception;
        throw th;
    }
}
