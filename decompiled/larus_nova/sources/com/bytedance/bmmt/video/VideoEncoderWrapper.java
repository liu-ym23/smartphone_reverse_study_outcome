package com.bytedance.bmmt.video;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes8.dex */
class VideoEncoderWrapper {
    public VideoEncoderWrapper() {
    }

    public static /* bridge */ /* synthetic */ void a(long r100, int r101) {
        nativeOnEncodedEvent(r100, r101);
    }

    public static /* bridge */ /* synthetic */ void b(long r100, ByteBuffer r101, ByteBuffer r102, int r103, int r104, int r105, int r106, long r107, int r110, int r111, int r112, long r113, int r114) {
        nativeOnEncodedFrame(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114);
    }

    private static native void nativeOnEncodedEvent(long r100, int r101);

    private static native void nativeOnEncodedFrame(long r100, ByteBuffer r101, ByteBuffer r102, int r103, int r104, int r105, int r106, long r107, int r110, int r111, int r112, long r113, int r114);

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
        return r100.f202128on;
    }
}
