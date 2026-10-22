package com.ss.ttvideoengine;

/* JADX INFO: loaded from: classes34.dex */
public interface PlayerEventListener {
    void onAudioDecoderOpened(int r100, long r101, long r102);

    void onAudioInputFormatChanged(VideoFormatInfo r100);

    void onAudioRenderOpened(int r100, long r101, long r102);

    void onMediaOpened(VideoFormatInfo r100, long r101, long r102);

    void onVideoDecodedFirstFrame(long r100);

    void onVideoDecoderOpened(int r100, long r101, long r102);

    void onVideoInputFormatChanged(VideoFormatInfo r100);

    void onVideoRenderOpened(int r100, long r101, long r102);
}
