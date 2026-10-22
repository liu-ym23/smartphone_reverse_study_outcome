package com.larus.im.internal.rtcsdk.impl;

import com.ss.bytertc.engine.IAudioFrameProcessor;
import com.ss.bytertc.engine.data.RemoteStreamKey;
import com.ss.bytertc.engine.utils.IAudioFrame;

/* JADX INFO: loaded from: classes30.dex */
public final class f extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IAudioFrameProcessor f349859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IAudioFrameProcessor f349860b;

    public f() {
    }

    @Override // com.larus.im.internal.rtcsdk.impl.e, com.ss.bytertc.engine.IAudioFrameProcessor
    public final int onProcessPlayBackAudioFrame(IAudioFrame r100) {
        IAudioFrameProcessor r101 = this.f349859a;
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.onProcessPlayBackAudioFrame(r100);
    }

    @Override // com.larus.im.internal.rtcsdk.impl.e, com.ss.bytertc.engine.IAudioFrameProcessor
    public final int onProcessRecordAudioFrame(IAudioFrame r100) {
        IAudioFrameProcessor r101 = this.f349860b;
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.onProcessRecordAudioFrame(r100);
    }

    @Override // com.larus.im.internal.rtcsdk.impl.e, com.ss.bytertc.engine.IAudioFrameProcessor
    public final int onProcessRecordAudioFrame(IAudioFrame r100, IAudioFrame r101) {
        IAudioFrameProcessor r102 = this.f349860b;
        if (r102 != null) goto L7;
        return 0;
    L7:
        return r102.onProcessRecordAudioFrame(r100, r101);
    }

    @Override // com.larus.im.internal.rtcsdk.impl.e, com.ss.bytertc.engine.IAudioFrameProcessor
    public final int onProcessRemoteUserAudioFrame(RemoteStreamKey r100, IAudioFrame r101) {
        IAudioFrameProcessor r102 = this.f349859a;
        if (r102 != null) goto L7;
        return 0;
    L7:
        return r102.onProcessRemoteUserAudioFrame(r100, r101);
    }
}
