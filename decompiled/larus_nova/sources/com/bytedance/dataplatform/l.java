package com.bytedance.dataplatform;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes6.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f204325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ij4.a f204326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f204327c;

    @Override // java.lang.Runnable
    public final void run() {
        this.f204327c.f204312h.b(this.f204325a, this.f204326b, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public l(i r100, String r101, ij4.a r102) {
        this.f204327c = r100;
        this.f204325a = r101;
        this.f204326b = r102;
    }
}
