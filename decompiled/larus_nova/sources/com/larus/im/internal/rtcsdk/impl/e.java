package com.larus.im.internal.rtcsdk.impl;

import com.ss.bytertc.engine.IAudioFrameProcessor;
import com.ss.bytertc.engine.data.RemoteStreamKey;
import com.ss.bytertc.engine.utils.IAudioFrame;

/* JADX INFO: loaded from: classes30.dex */
public class e implements IAudioFrameProcessor {
    public e() {
    }

    @Override // com.ss.bytertc.engine.IAudioFrameProcessor
    public final int onProcessEarMonitorAudioFrame(IAudioFrame r100) {
        return 0;
    }

    @Override // com.ss.bytertc.engine.IAudioFrameProcessor
    public int onProcessPlayBackAudioFrame(IAudioFrame r100) {
        return 0;
    }

    @Override // com.ss.bytertc.engine.IAudioFrameProcessor
    public int onProcessRecordAudioFrame(IAudioFrame r100) {
        return 0;
    }

    @Override // com.ss.bytertc.engine.IAudioFrameProcessor
    public int onProcessRecordAudioFrame(IAudioFrame r100, IAudioFrame r101) {
        return 0;
    }

    @Override // com.ss.bytertc.engine.IAudioFrameProcessor
    public int onProcessRemoteUserAudioFrame(RemoteStreamKey r100, IAudioFrame r101) {
        return 0;
    }

    @Override // com.ss.bytertc.engine.IAudioFrameProcessor
    public final int onProcessScreenAudioFrame(IAudioFrame r100) {
        return 0;
    }
}
