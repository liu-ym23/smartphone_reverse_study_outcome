package com.ss.android.ttvecamera.focusmanager;

import android.hardware.camera2.CaptureRequest;

/* JADX INFO: loaded from: classes38.dex */
public class TEVideoFocusAndMeterStrategy extends TEFocusAndMeterStrategy {
    public TEVideoFocusAndMeterStrategy(ITEFocusStrategy.NormalCallbackRequest r100) {
        super(r100);
    }

    @Override // com.ss.android.ttvecamera.focusmanager.TEFocusAndMeterStrategy, com.ss.android.ttvecamera.focusmanager.ITEFocusStrategy
    public void enableCaf(CaptureRequest.Builder r100) {
        r100.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
        r100.set(CaptureRequest.CONTROL_AF_MODE, 3);
    }
}
