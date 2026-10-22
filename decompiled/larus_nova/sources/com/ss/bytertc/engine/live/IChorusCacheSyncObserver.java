package com.ss.bytertc.engine.live;

import com.ss.bytertc.engine.video.IVideoFrame;

/* JADX INFO: loaded from: classes40.dex */
public interface IChorusCacheSyncObserver {
    void onSyncEvent(ChorusCacheSyncEvent r100, ChorusCacheSyncError r101);

    void onSyncedUsersChanged(int r100, String[] r101);

    void onSyncedVideoFrames(int r100, String[] r101, IVideoFrame[] r102);
}
