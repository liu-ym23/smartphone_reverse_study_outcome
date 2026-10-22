package com.ss.bytertc.engine.live;

/* JADX INFO: loaded from: classes40.dex */
public class MixedStreamSyncControlConfig {
    public String baseRoomID;
    public int baseStreamStartDelayMs;
    public MixedStreamVideoType baseStreamType;
    public String baseUserID;
    public int maxCacheTimeMs;
    public MixedStreamSyncStrategy syncStrategy;
    public boolean videoNeedSdkMix;

    public MixedStreamSyncControlConfig() {
        this.syncStrategy = MixedStreamSyncStrategy.MIXED_STREAM_SYNC_STRATEGY_NO_SYNC;
        this.maxCacheTimeMs = 2000;
        this.videoNeedSdkMix = true;
        this.baseUserID = "";
        this.baseRoomID = "";
        this.baseStreamType = MixedStreamVideoType.MIXED_STREAM_VIDEO_TYPE_MAIN;
        this.baseStreamStartDelayMs = 0;
    }
}
