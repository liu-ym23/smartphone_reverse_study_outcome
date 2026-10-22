package com.ss.bytertc.base.media;

import com.bytedance.realx.video.VideoFrame;

/* JADX INFO: loaded from: classes40.dex */
public final class RXNativeFunctions {
    public RXNativeFunctions() {
    }

    public static native void nativeOnCapturerError(long r100, int r101);

    public static native void nativeOnCapturerFormatSelected(long r100, int r101, int r102, int r103, int r104, int r105);

    public static native void nativeOnCapturerStarted(long r100, boolean r101);

    public static native void nativeOnCapturerStopped(long r100);

    public static native void nativeOnFrameCaptured(long r100, VideoFrame r101);
}
