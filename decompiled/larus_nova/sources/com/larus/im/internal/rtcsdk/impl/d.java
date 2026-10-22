package com.larus.im.internal.rtcsdk.impl;

import com.ss.bytertc.engine.IAudioFrameObserver;
import com.ss.bytertc.engine.data.RemoteStreamKey;
import com.ss.bytertc.engine.utils.IAudioFrame;

/* JADX INFO: loaded from: classes30.dex */
public final class d extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IAudioFrameObserver f349855a;

    public d() {
    }

    @Override // com.larus.im.internal.rtcsdk.impl.c, com.ss.bytertc.engine.IAudioFrameObserver
    public final void onRemoteUserAudioFrame(RemoteStreamKey r100, IAudioFrame r101) {
        IAudioFrameObserver r102 = this.f349855a;
        if (r102 == null) goto L6;
        r102.onRemoteUserAudioFrame(r100, r101);
        return;
    }
}
