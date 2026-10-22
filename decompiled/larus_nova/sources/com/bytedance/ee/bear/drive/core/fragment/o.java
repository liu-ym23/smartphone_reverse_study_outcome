package com.bytedance.ee.bear.drive.core.fragment;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f224254a;

    public o(k r100) {
        this.f224254a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k.b(this.f224254a);     // Catch: Throwable -> L6
        this.f224254a.j();     // Catch: Throwable -> L6
        k r100 = this.f224254a;     // Catch: Throwable -> L6
        if (r100.f224234p == null) goto L9;
        r100.e();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
