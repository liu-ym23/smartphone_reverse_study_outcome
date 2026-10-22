package com.ss.android.bytedcert.camera.refactor.mi;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.utils.CertLog;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MiSecCamService f407312a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f407312a.f407304b.closeMiSecCam();     // Catch: Throwable -> L4 Exception -> L6
        this.f407312a.f407307e = false;     // Catch: Throwable -> L4 Exception -> L6
    L16:
        return;
    L6:
        e = move-exception;
        CertLog.w("MiSecCameraService", "closeMiSecCam", e);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L12;
        return;
    L12:
        throw th;
    }

    public b(MiSecCamService r100) {
        this.f407312a = r100;
    }
}
