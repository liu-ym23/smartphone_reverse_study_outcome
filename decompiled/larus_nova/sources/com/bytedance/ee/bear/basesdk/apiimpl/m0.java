package com.bytedance.ee.bear.basesdk.apiimpl;

import com.bytedance.ee.bear.contract.ConnectionService;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class m0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ConnectionService.NetworkState f206521a;

    public m0(ConnectionService.NetworkState r100) {
        this.f206521a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.f206521a == null) goto L9;
        tt5.a.h("DocFragment", "onChanged: network state = " + this.f206521a);     // Catch: Throwable -> L6
        ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).V();     // Catch: Throwable -> L6
        return;
    }
}
