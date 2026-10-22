package com.ss.bytertc.engine;

import com.ss.bytertc.engine.utils.AudioFrame;

/* JADX INFO: loaded from: classes40.dex */
public interface IAudioFrameTestObserver {
    void onAudioRecordFrame(AudioFrame r100);

    void onLocalAudioVolume(int r100, int r101);

    boolean onPlayoutBufferSink(int r100, AudioFrame r101);
}
