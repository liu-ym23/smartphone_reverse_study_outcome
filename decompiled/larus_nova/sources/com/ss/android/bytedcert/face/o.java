package com.ss.android.bytedcert.face;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes34.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f407411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f407412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FaceDetectionRecorder f407413c;

    @Override // java.lang.Runnable
    public final void run() {
        FaceDetectionRecorder.a(this.f407413c, this.f407411a, this.f407412b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public o(FaceDetectionRecorder r100, int r101, int r102) {
        this.f407413c = r100;
        this.f407411a = r101;
        this.f407412b = r102;
    }
}
