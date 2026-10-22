package com.bytedance.locallife.dito.utils;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f258689a = null;

    static {
        f258689a = new b();
    }

    public b() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.f258684a.getClass();     // Catch: Throwable -> L4
        a.b(true);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
