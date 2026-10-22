package com.relax;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes34.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f404629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RelaxEventListener f404630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BackendWorker f404631c;

    @Override // java.lang.Runnable
    public final void run() {
        BackendWorkerJNI r100 = this.f404631c.f404534a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.removeEventListener(this.f404629a, this.f404630b);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public e(BackendWorker r100, String r101, RelaxEventListener r102) {
        this.f404631c = r100;
        this.f404629a = r101;
        this.f404630b = r102;
    }
}
