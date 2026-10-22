package csa;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;

/* JADX INFO: loaded from: classes34.dex */
public final class e extends CameraCaptureSession.CaptureCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f465226a;

    public e(c r100) {
        this.f465226a = r100;
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public final void onCaptureCompleted(CameraCaptureSession r100, CaptureRequest r101, TotalCaptureResult r102) {
        this.f465226a.f465205h.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);     // Catch: Exception -> L4
        c r103 = this.f465226a;     // Catch: Exception -> L4
        r103.f465204g.capture(r103.f465205h.build(), null, this.f465226a.f465207j);     // Catch: Exception -> L4
    L6:
        c.a(this.f465226a);
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }
}
