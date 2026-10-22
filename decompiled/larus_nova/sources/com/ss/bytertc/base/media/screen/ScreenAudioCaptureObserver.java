package com.ss.bytertc.base.media.screen;

/* JADX INFO: loaded from: classes40.dex */
public interface ScreenAudioCaptureObserver {
    void onAudioFrameCapture(byte[] r100, int r101, int r102, int r103);

    void onCapturerStarted();

    void onCapturerStopped();
}
