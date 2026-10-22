package com.ss.bytertc.engine.live;

import com.ss.bytertc.engine.video.IVideoFrame;

/* JADX INFO: loaded from: classes40.dex */
public class ChorusCacheSyncObserver {
    private IChorusCacheSyncObserver observer;

    public ChorusCacheSyncObserver() {
        this.observer = null;
    }

    public void setUserObserver(IChorusCacheSyncObserver r100) {
        if (r100 == null) goto L5;
        this.observer = r100;
        return;
    }

    public void onSyncEvent(ChorusCacheSyncEvent r100, ChorusCacheSyncError r101) {
        IChorusCacheSyncObserver r102 = this.observer;
        if (r102 == null) goto L6;
        r102.onSyncEvent(r100, r101);
        return;
    }

    public void onSyncedUsersChanged(int r100, String[] r101) {
        IChorusCacheSyncObserver r102 = this.observer;
        if (r102 == null) goto L6;
        r102.onSyncedUsersChanged(r100, r101);
        return;
    }

    public void onSyncedVideoFrames(int r100, String[] r101, IVideoFrame[] r102) {
        IChorusCacheSyncObserver r103 = this.observer;
        if (r103 == null) goto L6;
        r103.onSyncedVideoFrames(r100, r101, r102);
        return;
    }
}
