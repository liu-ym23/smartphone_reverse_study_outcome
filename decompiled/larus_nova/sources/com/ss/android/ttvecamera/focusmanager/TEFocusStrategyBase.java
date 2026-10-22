package com.ss.android.ttvecamera.focusmanager;

import android.graphics.Rect;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import com.ss.android.ttvecamera.TECameraSettings;
import com.ss.android.ttvecamera.TEFocusSettings;

/* JADX INFO: loaded from: classes38.dex */
public abstract class TEFocusStrategyBase implements ITEFocusStrategy {
    protected TECameraSettings mCameraSettings;
    protected TEFocusSettings mFocusSettings;
    protected boolean mIsManualFinalize;
    protected boolean mbSupportGyro;

    @Override // com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy
    public void setCaptureCallback(CameraCaptureSession.CaptureCallback r100) {
    }

    public TEFocusStrategyBase() {
        this.mIsManualFinalize = true;
        this.mbSupportGyro = false;
    }

    public void setCameraSettings(TECameraSettings r100) {
        this.mCameraSettings = r100;
        this.mIsManualFinalize = r100.mEnableManualReleaseCaptureResult;
    }

    public void setFocusSettings(TEFocusSettings r100) {
        this.mFocusSettings = r100;
    }

    public void setSupportGyro(boolean r100) {
        this.mbSupportGyro = r100;
    }

    @Override // com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy
    public void configFocus(CaptureRequest.Builder r100, Rect r101) {
        r100.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[]{new MeteringRectangle(r101, 999)});
        r100.set(CaptureRequest.CONTROL_MODE, 1);
        r100.set(CaptureRequest.CONTROL_AF_MODE, 1);
        r100.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
        r100.setTag(ITEFocusStrategy.FOCUS_TAG);
    }

    @Override // com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy
    public void configMeter(CaptureRequest.Builder r100, Rect r101) {
        r100.setTag(ITEFocusStrategy.FOCUS_TAG);
        r100.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{new MeteringRectangle(r101, 999)});
    }
}
