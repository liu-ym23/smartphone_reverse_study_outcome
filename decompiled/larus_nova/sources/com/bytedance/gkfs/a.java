package com.bytedance.gkfs;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f245125a;

    public a(int r100) {
        this.f245125a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c.b(c.f245127c, "GkFSExecutor", "parallel core thread " + (this.f245125a + 1) + " warmup", 0, false, 12);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
