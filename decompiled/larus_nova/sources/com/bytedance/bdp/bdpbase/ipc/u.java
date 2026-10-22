package com.bytedance.bdp.bdpbase.ipc;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f201216a;

    @Override // java.lang.Runnable
    public final void run() {
        v r100 = this.f201216a;     // Catch: Throwable -> L4
        long r101 = System.nanoTime();     // Catch: Throwable -> L4
        v r102 = this.f201216a;     // Catch: Throwable -> L4
        r100.f201239v = r101 - r102.f201236s;     // Catch: Throwable -> L4
        r102.f201236s = System.nanoTime();     // Catch: Throwable -> L4
        x r103 = this.f201216a.f201218a;     // Catch: Throwable -> L4
        e.a r104 = (e.a) r103;     // Catch: Throwable -> L4
        r104.a(this.f201216a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public u(v r100) {
        this.f201216a = r100;
    }
}
