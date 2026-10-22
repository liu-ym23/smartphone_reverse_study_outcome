package com.bytedance.bdp.bdpbase.ipc;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f201176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f201177b;

    @Override // java.lang.Runnable
    public final void run() {
        this.f201176a.c("null_binder_in_service_connected", "get iTransfer of " + this.f201177b.f201157v + " fail, iTransfer is null", this.f201177b.f201157v);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public i(e r100, v r101) {
        this.f201177b = r100;
        this.f201176a = r101;
    }
}
