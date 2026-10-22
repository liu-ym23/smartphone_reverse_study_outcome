package com.ss.bytertc.engine.live;

import com.ss.bytertc.engine.video.IVideoFrame;

/* JADX INFO: loaded from: classes40.dex */
public class PushMixedStreamToCDNObserver {
    private IClientMixedStreamObserver mLiveTransObserver;

    public PushMixedStreamToCDNObserver() {
        this.mLiveTransObserver = null;
    }

    public void onMixedFirstAudioFrame(String r100) {
        IClientMixedStreamObserver r101 = this.mLiveTransObserver;
        if (r101 == null) goto L6;
        r101.onMixedFirstAudioFrame(r100);
        return;
    }

    public void onMixedFirstVideoFrame(String r100) {
        IClientMixedStreamObserver r101 = this.mLiveTransObserver;
        if (r101 == null) goto L6;
        r101.onMixedFirstVideoFrame(r100);
        return;
    }

    public void setUserObserver(IClientMixedStreamObserver r100) {
        this.mLiveTransObserver = r100;
    }

    public void onMixedVideoFrame(String r100, IVideoFrame r101) {
        IClientMixedStreamObserver r102 = this.mLiveTransObserver;
        if (r102 == null) goto L6;
        r102.onMixedVideoFrame(r100, r101);
        return;
    }

    public void onMixedDataFrame(String r100, byte[] r101, long r102) {
        IClientMixedStreamObserver r103 = this.mLiveTransObserver;
        if (r103 == null) goto L6;
        r103.onMixedDataFrame(r100, r101, r102);
        return;
    }

    public void onClientMixedStreamEvent(MixedStreamTaskInfo r100, MixedStreamType r101, MixedStreamTaskEvent r102, MixedStreamTaskErrorCode r103) {
        IClientMixedStreamObserver r104 = this.mLiveTransObserver;
        if (r104 == null) goto L6;
        r104.onClientMixedStreamEvent(r100, r101, r102, r103);
        return;
    }

    public void onMixedAudioFrame(String r100, byte[] r101, int r102, long r110) {
        IClientMixedStreamObserver r103 = this.mLiveTransObserver;
        if (r103 == null) goto L6;
        r103.onMixedAudioFrame(r100, r101, r102, r110);
        return;
    }

    public void onCacheSyncVideoFrames(String r100, String[] r101, IVideoFrame[] r102, byte[][] r110, int r111) {
        IClientMixedStreamObserver r103 = this.mLiveTransObserver;
        if (r103 == null) goto L6;
        r103.onCacheSyncVideoFrames(r100, r101, r102, r110, r111);
        return;
    }
}
