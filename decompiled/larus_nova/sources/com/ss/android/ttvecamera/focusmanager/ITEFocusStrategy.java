package com.ss.android.ttvecamera.focusmanager;

import android.graphics.Rect;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes38.dex */
public interface ITEFocusStrategy {
    public static final String FOCUS_TAG = "FOCUS_TAG";
    public static final MeteringRectangle[] ZERO_WEIGHT_3A_REGION = null;

    public interface NormalCallbackRequest {
        int rollbackMeteringSessionRequest();

        int rollbackNormalSessionRequest();

        void updateRequestRepeating(CameraCaptureSession r100, CaptureRequest.Builder r101);
    }

    static {
        ZERO_WEIGHT_3A_REGION = new MeteringRectangle[]{new MeteringRectangle(0, 0, 0, 0, 0)};
    }

    int cancelFocus();

    void configFocus(CaptureRequest.Builder r100, Rect r101);

    void configMeter(CaptureRequest.Builder r100, Rect r101);

    void enableCaf(CaptureRequest.Builder r100);

    CameraCaptureSession.CaptureCallback getFocusCaptureCallback(CaptureRequest.Builder r100, AtomicBoolean r101, boolean r102);

    CameraCaptureSession.CaptureCallback getMeteringCaptureCallback(CaptureRequest.Builder r100, boolean r101);

    void setCaptureCallback(CameraCaptureSession.CaptureCallback r100);
}
