package androidx.camera.camera2.internal;

import android.hardware.camera2.CaptureFailure;
import androidx.camera.core.impl.CameraCaptureFailure;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class Camera2CameraCaptureFailure extends CameraCaptureFailure {
    private final CaptureFailure mCaptureFailure;

    @Override // androidx.camera.core.impl.CameraCaptureFailure
    public Object getCaptureFailure() {
        return this.mCaptureFailure;
    }

    public Camera2CameraCaptureFailure(CameraCaptureFailure.Reason r1, CaptureFailure r2) {
        super(r1);
        this.mCaptureFailure = r2;
    }
}
