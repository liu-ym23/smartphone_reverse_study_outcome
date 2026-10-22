package com.ss.bytertc.base.media.screen;

/* JADX INFO: loaded from: classes40.dex */
public final class RTCScreenAudioNativeFunctions {
    public RTCScreenAudioNativeFunctions() {
    }

    public static native void nativeOnAuidoFrameCaptured(long r100, byte[] r101, int r102, int r103, int r104);

    public static native void nativeOnCapturerError(long r100, int r101);

    public static native void nativeOnCapturerStarted(long r100);

    public static native void nativeOnCapturerStopped(long r100);
}
