package com.ss.bytertc.engine;

import com.ss.bytertc.engine.data.RemoteStreamKey;
import com.ss.bytertc.engine.utils.IAudioFrame;

/* JADX INFO: loaded from: classes40.dex */
public interface IAudioFrameObserver {
    void onCaptureMixedAudioFrame(IAudioFrame r100);

    void onMixedAudioFrame(IAudioFrame r100);

    void onPlaybackAudioFrame(IAudioFrame r100);

    void onRecordAudioFrame(IAudioFrame r100);

    void onRemoteUserAudioFrame(RemoteStreamKey r100, IAudioFrame r101);
}
