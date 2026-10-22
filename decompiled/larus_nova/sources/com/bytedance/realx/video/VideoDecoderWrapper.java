package com.bytedance.realx.video;

import com.bytedance.realx.video.memory.RXVideoFrameInterface;

/* JADX INFO: loaded from: classes21.dex */
class VideoDecoderWrapper {
    public VideoDecoderWrapper() {
    }

    private static native void nativeOnDecodedFrame(long r100, RXVideoFrameInterface r101);

    private static native void nativeOnMediaCodecStatus(long r100, VideoCodecStatus r101, String r102);

    public static VideoDecoder.Callback createDecoderCallback(final long r100) {
        return new AnonymousClass1(r100);
    }

    public static /* synthetic */ void access$000(long r100, RXVideoFrameInterface r101) {
        nativeOnDecodedFrame(r100, r101);
    }

    public static /* synthetic */ void access$100(long r100, VideoCodecStatus r101, String r102) {
        nativeOnMediaCodecStatus(r100, r101, r102);
    }
}
