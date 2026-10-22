package com.bytedance.bdinstall;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class j0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i0 f199671a;

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.f199671a.f199659f.compareAndSet(false, true) == false) goto L9;
        i0 r100 = this.f199671a;     // Catch: Throwable -> L6
        r100.b(new c(r100.f199654a, r100.f199658e));     // Catch: Throwable -> L6
        return;
    }

    public j0(i0 r100) {
        this.f199671a = r100;
    }
}
