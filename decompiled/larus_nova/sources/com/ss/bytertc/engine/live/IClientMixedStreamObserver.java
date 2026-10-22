package com.ss.bytertc.engine.live;

import com.ss.bytertc.engine.video.IVideoFrame;

/* JADX INFO: loaded from: classes40.dex */
public interface IClientMixedStreamObserver {
    void onCacheSyncVideoFrames(String r100, String[] r101, IVideoFrame[] r102, byte[][] r103, int r104);

    void onClientMixedStreamEvent(MixedStreamTaskInfo r100, MixedStreamType r101, MixedStreamTaskEvent r102, MixedStreamTaskErrorCode r103);

    void onMixedAudioFrame(String r100, byte[] r101, int r102, long r103);

    void onMixedDataFrame(String r100, byte[] r101, long r102);

    void onMixedFirstAudioFrame(String r100);

    void onMixedFirstVideoFrame(String r100);

    void onMixedVideoFrame(String r100, IVideoFrame r101);
}
