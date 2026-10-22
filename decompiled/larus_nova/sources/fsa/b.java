package fsa;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import com.ss.android.cert.manager.constants.ErrorConstant;
import com.ss.android.cert.manager.utils.CertLog;
import com.ss.android.cert.manager.utils.event.EventLogUtils;

/* JADX INFO: loaded from: classes34.dex */
public final class b extends CameraCaptureSession.StateCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f478715a;

    public b(a r100) {
        this.f478715a = r100;
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public final void onConfigureFailed(CameraCaptureSession r100) {
        CertLog.e("CameraDevice", "camera v2 ConfigureFailed. session: " + r100);
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public final void onConfigured(CameraCaptureSession r100) {
        a r101 = this.f478715a;
        r101.f478698n = r100;
        CertLog.v("CameraDevice", "camera v2 startPreview");
        if (r101.f478698n == null) goto L11;
        CaptureRequest.Builder r102 = r101.f478703s;
        if (r102 == null) goto L11;
        CaptureRequest r103 = r102.build();     // Catch: Exception -> L9
        r101.f478698n.setRepeatingRequest(r103, r101.f478709y, r101.f478705u);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        EventLogUtils.onExceptionEvent(e, ErrorConstant.checkClientException(e));
        return;
    L11:
        CertLog.w("CameraDevice", "camera v2 startPreview: mCaptureSession or mPreviewRequestBuilder is null");
    }
}
