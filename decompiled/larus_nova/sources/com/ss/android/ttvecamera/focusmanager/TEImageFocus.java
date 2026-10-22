package com.ss.android.ttvecamera.focusmanager;

import android.graphics.Rect;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.os.Build;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes38.dex */
public class TEImageFocus extends TEFocusStrategyBase {
    private static final String TAG = "TEImageFocus";
    private CameraCaptureSession.CaptureCallback captureCallback;
    private AtomicBoolean mManualFocusEngaged;
    protected ITEFocusStrategy.NormalCallbackRequest mNormalCallbackRequest;

    @Override // com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy
    public int cancelFocus() {
        return this.mNormalCallbackRequest.rollbackNormalSessionRequest();
    }

    public TEImageFocus(ITEFocusStrategy.NormalCallbackRequest r100) {
        this.captureCallback = null;
        this.mNormalCallbackRequest = r100;
    }

    public static /* synthetic */ AtomicBoolean access$000(TEImageFocus r100) {
        return r100.mManualFocusEngaged;
    }

    public static /* synthetic */ CameraCaptureSession.CaptureCallback access$100(TEImageFocus r100) {
        return r100.captureCallback;
    }

    @Override // com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy
    public void enableCaf(CaptureRequest.Builder r100) {
        r100.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
        r100.set(CaptureRequest.CONTROL_AF_MODE, 4);
    }

    @Override // com.ss.android.ttvecamera.focusmanager.TEFocusStrategyBase, com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy
    public synchronized void setCaptureCallback(CameraCaptureSession.CaptureCallback r100) {
        monitor-enter(this);
        this.captureCallback = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.ttvecamera.focusmanager.TEFocusStrategyBase, com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy
    public void configMeter(CaptureRequest.Builder r100, Rect r101) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        r100.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 2);
    L5:
        super.configMeter(r100, r101);
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
