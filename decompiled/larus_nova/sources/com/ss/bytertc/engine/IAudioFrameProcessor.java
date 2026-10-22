package com.ss.bytertc.engine;

import com.ss.bytertc.engine.data.RemoteStreamKey;
import com.ss.bytertc.engine.utils.IAudioFrame;

/* JADX INFO: loaded from: classes40.dex */
public interface IAudioFrameProcessor {
    int onProcessEarMonitorAudioFrame(IAudioFrame r100);

    int onProcessPlayBackAudioFrame(IAudioFrame r100);

    int onProcessRecordAudioFrame(IAudioFrame r100);

    int onProcessRecordAudioFrame(IAudioFrame r100, IAudioFrame r101);

    int onProcessRemoteUserAudioFrame(RemoteStreamKey r100, IAudioFrame r101);

    int onProcessScreenAudioFrame(IAudioFrame r100);
}
