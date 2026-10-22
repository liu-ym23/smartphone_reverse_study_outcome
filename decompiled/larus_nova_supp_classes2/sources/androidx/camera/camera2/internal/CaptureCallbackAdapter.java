package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.TagBundle;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class CaptureCallbackAdapter extends CameraCaptureSession.CaptureCallback {
    private final CameraCaptureCallback mCameraCaptureCallback;

    public CaptureCallbackAdapter(CameraCaptureCallback r2) {
        if (r2 == null) goto L7;
        this.mCameraCaptureCallback = r2;
        return;
    L7:
        throw new NullPointerException("cameraCaptureCallback is null");
    }

    private int getCaptureConfigId(CaptureRequest r3) {
        if ((r3.getTag() instanceof TagBundle) == true) goto L5;
        return -1;
    L5:
        Integer r4 = (Integer) ((TagBundle) r3.getTag()).getTag(CaptureConfig.CAPTURE_CONFIG_ID_TAG_KEY);
        if (r4 != null) goto L9;
        return -1;
    L9:
        return r4.intValue();
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureCompleted(CameraCaptureSession r3, CaptureRequest r4, TotalCaptureResult r5) {
        super.onCaptureCompleted(r3, r4, r5);
        Object r6 = r4.getTag();
        if (r6 == null) goto L5;
        Preconditions.checkArgument(r6 instanceof TagBundle, "The tagBundle object from the CaptureResult is not a TagBundle object.");
        TagBundle r7 = (TagBundle) r6;
    L6:
        this.mCameraCaptureCallback.onCaptureCompleted(getCaptureConfigId(r4), new Camera2CameraCaptureResult(r7, r5));
        return;
    L5:
        r7 = TagBundle.emptyBundle();
        goto L6
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureFailed(CameraCaptureSession r1, CaptureRequest r2, CaptureFailure r3) {
        super.onCaptureFailed(r1, r2, r3);
        CameraCaptureFailure r4 = new CameraCaptureFailure(CameraCaptureFailure.Reason.ERROR);
        this.mCameraCaptureCallback.onCaptureFailed(getCaptureConfigId(r2), r4);
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureStarted(CameraCaptureSession r1, CaptureRequest r2, long r3, long r5) {
        super.onCaptureStarted(r1, r2, r3, r5);
        this.mCameraCaptureCallback.onCaptureStarted(getCaptureConfigId(r2));
    }
}
