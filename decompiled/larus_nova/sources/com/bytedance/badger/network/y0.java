package com.bytedance.badger.network;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes47.dex */
public final class y0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z0 f199159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f199160b;

    public y0(z0 r100, com.bytedance.badger.x.d0 r101) {
        this.f199159a = r100;
        this.f199160b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f199159a.a(this.f199160b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
