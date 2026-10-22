package csa;

import android.hardware.camera2.CameraCaptureSession;
import com.ss.android.cert.manager.utils.CertLog;

/* JADX INFO: loaded from: classes34.dex */
public final class d extends CameraCaptureSession.StateCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f465225a;

    public d(c r100) {
        this.f465225a = r100;
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public final void onConfigureFailed(CameraCaptureSession r100) {
        CertLog.e("CameraV2Proxy ", "ConfigureFailed. session: " + r100);
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public final void onConfigured(CameraCaptureSession r100) {
        c r101 = this.f465225a;
        r101.f465204g = r100;
        c.a(r101);
    }
}
