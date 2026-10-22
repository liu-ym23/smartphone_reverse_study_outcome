package com.ss.android.ttvecamera.focusmanager;

import android.graphics.Rect;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes38.dex */
public class TEFocusAndMeterStrategy extends TEFocusStrategyBase {
    private static final String TAG = "TEFocusAndMeterStrategy";
    private AtomicBoolean mManualFocusEngaged;
    private final ITEFocusStrategy.NormalCallbackRequest mNormalCallbackRequest;

    @Override // com.ss.android.ttvecamera.focusmanager.TEFocusStrategyBase, com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy
    public void setCaptureCallback(CameraCaptureSession.CaptureCallback r100) {
    }

    @Override // com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy
    public int cancelFocus() {
        return this.mNormalCallbackRequest.rollbackNormalSessionRequest();
    }

    public TEFocusAndMeterStrategy(ITEFocusStrategy.NormalCallbackRequest r100) {
        this.mNormalCallbackRequest = r100;
    }

    public static /* synthetic */ AtomicBoolean access$000(TEFocusAndMeterStrategy r100) {
        return r100.mManualFocusEngaged;
    }

    public static /* synthetic */ ITEFocusStrategy.NormalCallbackRequest access$100(TEFocusAndMeterStrategy r100) {
        return r100.mNormalCallbackRequest;
    }

    @Override // com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy
    public void enableCaf(CaptureRequest.Builder r100) {
        r100.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
        r100.set(CaptureRequest.CONTROL_AF_MODE, 3);
    }

    @Override // com.ss.android.ttvecamera.focusmanager.TEFocusStrategyBase, com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy
    public void configFocus(CaptureRequest.Builder r100, Rect r101) {
        r100.set(CaptureRequest.CONTROL_MODE, 1);
        r100.set(CaptureRequest.CONTROL_AF_MODE, 1);
        r100.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[]{new MeteringRectangle(r101, 999)});
        r100.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
    }

    @Override // com.ss.android.ttvecamera.focusmanager.TEFocusStrategyBase, com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy
    public void configMeter(CaptureRequest.Builder r100, Rect r101) {
        r100.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{new MeteringRectangle(r101, 999)});
    }

    @Override // com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy
    public CameraCaptureSession.CaptureCallback getMeteringCaptureCallback(CaptureRequest.Builder r100, final boolean r101) {
        return new AnonymousClass2(this, r101);
    }

    @Override // com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy
    public CameraCaptureSession.CaptureCallback getFocusCaptureCallback(final CaptureRequest.Builder r100, AtomicBoolean r101, final boolean r102) {
        this.mManualFocusEngaged = r101;
        return new AnonymousClass1(this, r102, r100);
    }
}
