package com.bytedance.bdp.appbase.base.ipc;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BdpIpcServiceImpl.b f200565a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f200565a.f200564a.getMainBdpIPC().d();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(BdpIpcServiceImpl.b r100) {
        this.f200565a = r100;
    }
}
