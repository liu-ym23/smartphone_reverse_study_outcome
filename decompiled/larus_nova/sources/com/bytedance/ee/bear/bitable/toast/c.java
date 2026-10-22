package com.bytedance.ee.bear.bitable.toast;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f215989a;

    public c(b r100) {
        this.f215989a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.a(this.f215989a);     // Catch: Throwable -> L6
        b.InterfaceC3083b r100 = this.f215989a.f215982c;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.onTimeout();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
