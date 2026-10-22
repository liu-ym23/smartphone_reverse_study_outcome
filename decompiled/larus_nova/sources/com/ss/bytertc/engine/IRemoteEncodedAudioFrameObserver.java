package com.ss.bytertc.engine;

import com.ss.bytertc.engine.data.RemoteStreamKey;
import com.ss.bytertc.engine.utils.EncodedAudioFrameData;

/* JADX INFO: loaded from: classes40.dex */
public interface IRemoteEncodedAudioFrameObserver {
    void onRemoteEncodedAudioFrame(RemoteStreamKey r100, EncodedAudioFrameData r101);
}
