package com.ss.bytertc.engine.mediaio;

import com.ss.bytertc.engine.data.RemoteStreamKey;

/* JADX INFO: loaded from: classes40.dex */
public abstract class IRemoteEncodedVideoFrameObserver {
    public IRemoteEncodedVideoFrameObserver() {
    }

    public abstract void onRemoteEncodedVideoFrame(RemoteStreamKey r100, RTCEncodedVideoFrame r101);
}
