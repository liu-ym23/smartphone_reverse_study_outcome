package com.ss.ttvideoengine.utils;

import android.content.Context;
import com.ss.ttvideoengine.log.HeadsetStateMonitor;

/* JADX INFO: loaded from: classes35.dex */
public class PlayDurationManager implements IPlayDurationManager {
    private static final String TAG = "PlayDurationManager";
    private final HeadsetStateMonitor mHeadsetMonitor;
    private final HeadsetStateMonitor.HeadsetStateChangedListener mHeadsetStateChangedListener;
    private volatile boolean mIsPlaying;
    private final PlayDuration mTotalPlayDuration;
    private final PlayDuration mWiredPlayDuration;
    private final PlayDuration mWirelessPlayDuration;

    @Override // com.ss.ttvideoengine.utils.IPlayDurationManager
    public void clear() {
        this.mTotalPlayDuration.clear();
        this.mWiredPlayDuration.clear();
        this.mWirelessPlayDuration.clear();
    }

    @Override // com.ss.ttvideoengine.utils.IPlayDurationManager
    public int getPlayedDuration() {
        return this.mTotalPlayDuration.getPlayedDuration();
    }

    @Override // com.ss.ttvideoengine.utils.IPlayDurationManager
    public long getWiredPlayedDuration() {
        return this.mWiredPlayDuration.getPlayedDuration();
    }

    @Override // com.ss.ttvideoengine.utils.IPlayDurationManager
    public void release() {
        this.mHeadsetMonitor.removeStateChangedListener(this.mHeadsetStateChangedListener);
    }

    @Override // com.ss.ttvideoengine.utils.IPlayDurationManager
    public void reset() {
        this.mTotalPlayDuration.reset();
        this.mWiredPlayDuration.reset();
        this.mWirelessPlayDuration.reset();
    }

    @Override // com.ss.ttvideoengine.utils.IPlayDurationManager
    public void start() {
        if (this.mIsPlaying == false) goto L6;
        TTVideoEngineLog.i(TAG, "Already started");
        return;
    L6:
        this.mIsPlaying = true;
        this.mTotalPlayDuration.start();
        if (this.mHeadsetMonitor.isWiredConnected() == false) goto L10;
        this.mWiredPlayDuration.start();
    L12:
        TTVideoEngineLog.d(TAG, "start play");
        return;
    L10:
        if (this.mHeadsetMonitor.isWirelessConnected() == false) goto L12;
        this.mWirelessPlayDuration.start();
        goto L12
    }

    @Override // com.ss.ttvideoengine.utils.IPlayDurationManager
    public void stop() {
        if (this.mIsPlaying == true) goto L6;
        TTVideoEngineLog.i(TAG, "Already stopped");
        return;
    L6:
        this.mIsPlaying = false;
        this.mTotalPlayDuration.stop();
        if (this.mHeadsetMonitor.isWiredConnected() == false) goto L10;
        this.mWiredPlayDuration.stop();
    L10:
        if (this.mHeadsetMonitor.isWirelessConnected() == false) goto L12;
        this.mWirelessPlayDuration.stop();
    L12:
        TTVideoEngineLog.d(TAG, String.format("stop: play duration: %s, wiredDuration: %s, wirelessDuration: %s", new Object[]{Integer.valueOf(this.mTotalPlayDuration.getPlayedDuration()), Integer.valueOf(this.mWiredPlayDuration.getPlayedDuration()), Integer.valueOf(this.mWirelessPlayDuration.getPlayedDuration())}));
    }

    public PlayDurationManager(HeadsetStateMonitor r100) {
        HeadsetStateMonitor.HeadsetStateChangedListener r101 = new AnonymousClass1(this);
        this.mHeadsetStateChangedListener = r101;
        this.mHeadsetMonitor = r100;
        this.mTotalPlayDuration = new PlayDuration();
        this.mWiredPlayDuration = new PlayDuration();
        this.mWirelessPlayDuration = new PlayDuration();
        r100.addStateChangedListener(r101);
    }

    public static /* synthetic */ PlayDuration access$000(PlayDurationManager r100) {
        return r100.mWiredPlayDuration;
    }

    public static /* synthetic */ PlayDuration access$100(PlayDurationManager r100) {
        return r100.mWirelessPlayDuration;
    }

    public static /* synthetic */ boolean access$200(PlayDurationManager r100) {
        return r100.mIsPlaying;
    }

    @Override // com.ss.ttvideoengine.utils.IPlayDurationManager
    public long getWirelessPlayedDuration(Context r100) {
        return this.mWirelessPlayDuration.getPlayedDuration();
    }
}
