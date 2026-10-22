package com.lynx.tasm.ui.image;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes32.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f384017a;

    @Override // java.lang.Runnable
    public final void run() {
        h r100 = this.f384017a;     // Catch: Throwable -> L6
        if (r100.f383983u == false) goto L9;
        r100.f383983u = false;     // Catch: Throwable -> L6
        r100.A.d();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public k(h r100) {
        this.f384017a = r100;
    }
}
