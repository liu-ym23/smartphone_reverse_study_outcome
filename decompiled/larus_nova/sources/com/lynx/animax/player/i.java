package com.lynx.animax.player;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes32.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f380385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f380386b;

    @Override // java.lang.Runnable
    public final void run() {
        h r100 = this.f380386b;     // Catch: Throwable -> L7
        String r101 = this.f380385a;     // Catch: Throwable -> L7
        r100.f380348f++;     // Catch: Throwable -> L7
        r100.f380350h = false;     // Catch: Throwable -> L7
        if (r100.f380347e == false) goto L5;
        r100.a(r101);     // Catch: Throwable -> L7
    L12:
        return;
    L5:
        r100.f380347e = true;     // Catch: Throwable -> L7
        r100.b(r101);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L15;
        throw th;
    }

    public i(h r100, String r101) {
        this.f380386b = r100;
        this.f380385a = r101;
    }
}
