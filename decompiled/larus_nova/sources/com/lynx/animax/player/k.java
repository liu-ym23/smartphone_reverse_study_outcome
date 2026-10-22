package com.lynx.animax.player;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes32.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f380388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f380389b;

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.f380389b.f380374m == null) goto L9;
        this.f380388a.run();     // Catch: Throwable -> L6
        return;
    }

    public k(h r100, Runnable r101) {
        this.f380389b = r100;
        this.f380388a = r101;
    }
}
