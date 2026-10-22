package com.bytedance.bmmt.video;

import com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface;

/* JADX INFO: loaded from: classes8.dex */
class VideoDecoderWrapper {
    public VideoDecoderWrapper() {
    }

    public static /* bridge */ /* synthetic */ void a(long r100, BmmtVideoFrameInterface r101) {
        nativeOnDecodedFrame(r100, r101);
    }

    public static /* bridge */ /* synthetic */ void b(long r100, VideoCodecStatus r101, String r102) {
        nativeOnMediaCodecStatus(r100, r101, r102);
    }

    private static native void nativeOnDecodedFrame(long r100, BmmtVideoFrameInterface r101);

    private static native void nativeOnMediaCodecStatus(long r100, VideoCodecStatus r101, String r102);

    public static VideoDecoder.Callback createDecoderCallback(final long r100) {
        return new AnonymousClass1(r100);
    }
}
