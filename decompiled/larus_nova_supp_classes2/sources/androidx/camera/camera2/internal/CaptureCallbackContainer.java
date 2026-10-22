package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import androidx.camera.core.impl.CameraCaptureCallback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class CaptureCallbackContainer extends CameraCaptureCallback {
    private final CameraCaptureSession.CaptureCallback mCaptureCallback;

    public CameraCaptureSession.CaptureCallback getCaptureCallback() {
        return this.mCaptureCallback;
    }

    private CaptureCallbackContainer(CameraCaptureSession.CaptureCallback r2) {
        if (r2 == null) goto L7;
        this.mCaptureCallback = r2;
        return;
    L7:
        throw new NullPointerException("captureCallback is null");
    }

    public static CaptureCallbackContainer create(CameraCaptureSession.CaptureCallback r1) {
        return new CaptureCallbackContainer(r1);
    }
}
