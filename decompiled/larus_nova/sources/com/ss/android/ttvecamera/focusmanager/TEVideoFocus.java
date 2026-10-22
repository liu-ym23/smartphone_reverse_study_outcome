package com.ss.android.ttvecamera.focusmanager;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes38.dex */
public class TEVideoFocus extends TEFocusStrategyBase {
    public static final String TAG = "TEVideoFocus";
    private AtomicBoolean mManualFocusEngaged;
    private final ITEFocusStrategy.NormalCallbackRequest mNormalCallbackRequest;

    @Override // com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy
    public int cancelFocus() {
        return this.mNormalCallbackRequest.rollbackNormalSessionRequest();
    }

    public TEVideoFocus(ITEFocusStrategy.NormalCallbackRequest r100) {
        this.mNormalCallbackRequest = r100;
    }

    public static /* synthetic */ AtomicBoolean access$000(TEVideoFocus r100) {
        return r100.mManualFocusEngaged;
    }

    public static /* synthetic */ ITEFocusStrategy.NormalCallbackRequest access$100(TEVideoFocus r100) {
        return r100.mNormalCallbackRequest;
    }

    @Override // com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy
    public void enableCaf(CaptureRequest.Builder r100) {
        r100.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
        r100.set(CaptureRequest.CONTROL_AF_MODE, 3);
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
