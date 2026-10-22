package com.ss.bytertc.base.media.screen;

import com.bytedance.realx.video.VideoFrame;

/* JADX INFO: loaded from: classes40.dex */
public final class RTCScreenVideoNativeFunctions {
    public RTCScreenVideoNativeFunctions() {
    }

    public static native void nativeOnCapturerError(long r100, int r101, String r102);

    public static native void nativeOnCapturerSetType(long r100, int r101);

    public static native void nativeOnCapturerStarted(long r100);

    public static native void nativeOnCapturerStopped(long r100);

    public static native void nativeOnFrameCaptured(long r100, VideoFrame r101);
}
