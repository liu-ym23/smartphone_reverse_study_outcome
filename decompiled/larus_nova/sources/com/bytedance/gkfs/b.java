package com.bytedance.gkfs;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f245126a = null;

    static {
        f245126a = new b();
    }

    public b() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        c.b(c.f245127c, "GkFSExecutor", "sequence executor thread warmup", 0, false, 12);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
