package com.relax;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f404620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BackendWorker f404621b;

    @Override // java.lang.Runnable
    public final void run() {
        BackendWorkerJNI r100 = this.f404621b.f404534a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.setErrorReceiver(this.f404620a);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public b(BackendWorker r100, RelaxView.l r101) {
        this.f404621b = r100;
        this.f404620a = r101;
    }
}
