package com.bytedance.bdp.appbase.network.upload;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f200927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BdpUploadCallback f200928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f200929c;

    public c(a r100, BdpUploadCallback r101, long r102) {
        this.f200927a = r100;
        this.f200928b = r101;
        this.f200929c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BdpUploadCallback r100 = this.f200928b;     // Catch: Throwable -> L4
        a r101 = this.f200927a;     // Catch: Throwable -> L4
        r100.onProgress(r101.f200918e, this.f200929c, r101.f200914a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
