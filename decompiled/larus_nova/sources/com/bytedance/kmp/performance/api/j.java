package com.bytedance.kmp.performance.api;

import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes19.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f252643a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.kmp.performance.utils.a<g> f252644b = null;

    static {
        f252643a = new g("globalDefault", com.bytedance.kmp.performance.reporter.b.f252838a);
        f252644b = new com.bytedance.kmp.performance.utils.a();
    }

    public static g a() {
        com.bytedance.kmp.performance.utils.a<g> r100 = f252644b;
        Object r101 = r100.f252852b;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (r100.f252851a.isEmpty() == false) goto L8;
        monitor-exit(r101);
        g r102 = null;
    L11:
        return r102;
    L8:
        CopyOnWriteArrayList<g> r103 = r100.f252851a;     // Catch: Throwable -> L12
        r102 = r103.get(r103.size() - 1);     // Catch: Throwable -> L12
        monitor-exit(r101);
        goto L11
    }
}
