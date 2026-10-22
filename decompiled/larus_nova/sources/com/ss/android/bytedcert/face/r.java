package com.ss.android.bytedcert.face;

import com.ss.android.cert.manager.utils.CertLog;

/* JADX INFO: loaded from: classes34.dex */
public final class r implements ksa.a.InterfaceC6605a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FaceDetectionRecorder f407419a;

    @Override // ksa.a.InterfaceC6605a
    public final void onStopped() {
    }

    @Override // ksa.a.InterfaceC6605a
    public final void onPrepared() {
        CertLog.d("FaceDetectionRecorder", "Record onPrepared");
        FaceDetectionRecorder r100 = this.f407419a;
        FaceDetectionRecorder.RecordState r101 = FaceDetectionRecorder.RecordState.RECORDING;
        Object r102 = r100.f407333g;
        monitor-enter(r102);
        r100.f407332f = r101;     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public r(FaceDetectionRecorder r100) {
        this.f407419a = r100;
    }
}
