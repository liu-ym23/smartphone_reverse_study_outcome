package com.bytedance.realx.video;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes21.dex */
class VideoEncoderWrapper {
    public VideoEncoderWrapper() {
    }

    private static native void nativeOnEncodedEvent(long r100, int r101);

    private static native void nativeOnEncodedFrame(long r100, ByteBuffer r101, int r102, int r103, int r104, int r105, long r106, int r107, int r110, int r111, long r112, int r113);

    public static VideoEncoder.Callback createEncoderCallback(final long r100) {
        return new AnonymousClass1(r100);
    }

    public static Integer getScalingSettingsHigh(VideoEncoder.ScalingSettings r100) {
        return r100.high;
    }

    public static Integer getScalingSettingsLow(VideoEncoder.ScalingSettings r100) {
        return r100.low;
    }

    public static boolean getScalingSettingsOn(VideoEncoder.ScalingSettings r100) {
        return r100.f267129on;
    }

    public static /* synthetic */ void access$100(long r100, int r101) {
        nativeOnEncodedEvent(r100, r101);
    }

    public static /* synthetic */ void access$000(long r100, ByteBuffer r101, int r102, int r103, int r104, int r105, long r106, int r107, int r110, int r111, long r112, int r113) {
        nativeOnEncodedFrame(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113);
    }
}
