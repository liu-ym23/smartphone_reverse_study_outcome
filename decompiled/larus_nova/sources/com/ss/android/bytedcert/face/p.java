package com.ss.android.bytedcert.face;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes34.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ byte[] f407414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FaceDetectionRecorder f407415b;

    @Override // java.lang.Runnable
    public final void run() {
        ksa.e r100 = this.f407415b.f407327a;     // Catch: Throwable -> L4
        byte[] r101 = this.f407414a;     // Catch: Throwable -> L4
        r100.b(r101, r101.length, System.nanoTime() / 1000);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public p(FaceDetectionRecorder r100, byte[] r101) {
        this.f407415b = r100;
        this.f407414a = r101;
    }
}
