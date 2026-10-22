package com.bytedance.bdp.appbase.network.upload;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f200930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BdpUploadCallback f200931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f200932c;

    public d(a r100, BdpUploadCallback r101, long r102) {
        this.f200930a = r100;
        this.f200931b = r101;
        this.f200932c = r102;
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
        if (this.f200930a.f200915b.get() != 2) goto L9;
        BdpUploadCallback r100 = this.f200931b;     // Catch: Throwable -> L6
        a r101 = this.f200930a;     // Catch: Throwable -> L6
        r100.onProgress(r101.f200918e, this.f200932c, r101.f200914a);     // Catch: Throwable -> L6
        return;
    }
}
