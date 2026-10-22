package com.ss.bytertc.base.media;

import com.bytedance.realx.video.VideoFrame;

/* JADX INFO: loaded from: classes40.dex */
public interface CapturerObserver {
    void onCapturerError(String r100);

    void onCapturerFormatSelected(int r100, int r101, int r102, int r103, int r104);

    void onCapturerStarted(boolean r100);

    void onCapturerStopped();

    void onFrameCaptured(VideoFrame r100);
}
