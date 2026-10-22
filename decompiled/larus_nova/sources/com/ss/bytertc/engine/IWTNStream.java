package com.ss.bytertc.engine;

import com.ss.bytertc.engine.video.IVideoSink;
import com.ss.bytertc.engine.video.RemoteVideoSinkConfig;

/* JADX INFO: loaded from: classes40.dex */
public interface IWTNStream {
    void enableWTNRemoteAudioFrameCallback(boolean r100);

    int registerWTNAudioFrameObserver(IWTNAudioFrameObserver r100);

    int setWTNRemoteAudioPlaybackVolume(String r100, int r101);

    int setWTNRemoteVideoCanvas(String r100, VideoCanvas r101);

    int setWTNRemoteVideoSink(String r100, IVideoSink r101, RemoteVideoSinkConfig r102);

    int setWTNStreamEventHandler(IWTNStreamEventHandler r100);

    int subscribeWTNAudioStream(String r100, boolean r101);

    int subscribeWTNVideoStream(String r100, boolean r101);
}
