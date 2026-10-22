package com.ss.bytertc.engine.live;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum MixedStreamSyncStrategy extends Enum<MixedStreamSyncStrategy> {
    private static final /* synthetic */ MixedStreamSyncStrategy[] $VALUES = null;
    public static final MixedStreamSyncStrategy MIXED_STREAM_SYNC_STRATEGY_AUDIO_PRECISE_SYNC = null;
    public static final MixedStreamSyncStrategy MIXED_STREAM_SYNC_STRATEGY_NO_SYNC = null;
    public static final MixedStreamSyncStrategy MIXED_STREAM_SYNC_STRATEGY_SIMPLEX_MODE_SYNC = null;
    private int syncStrategy;

    static {
        MixedStreamSyncStrategy r100 = new MixedStreamSyncStrategy("MIXED_STREAM_SYNC_STRATEGY_NO_SYNC", 0, 0);
        MIXED_STREAM_SYNC_STRATEGY_NO_SYNC = r100;
        MixedStreamSyncStrategy r101 = new MixedStreamSyncStrategy("MIXED_STREAM_SYNC_STRATEGY_AUDIO_PRECISE_SYNC", 1, 1);
        MIXED_STREAM_SYNC_STRATEGY_AUDIO_PRECISE_SYNC = r101;
        MixedStreamSyncStrategy r102 = new MixedStreamSyncStrategy("MIXED_STREAM_SYNC_STRATEGY_SIMPLEX_MODE_SYNC", 2, 2);
        MIXED_STREAM_SYNC_STRATEGY_SIMPLEX_MODE_SYNC = r102;
        $VALUES = new MixedStreamSyncStrategy[]{r100, r101, r102};
    }

    public static MixedStreamSyncStrategy[] values() {
        return (MixedStreamSyncStrategy[]) $VALUES.clone();
    }

    public int getValue() {
        return this.syncStrategy;
    }

    public static MixedStreamSyncStrategy valueOf(String r100) {
        return (MixedStreamSyncStrategy) a.a(MixedStreamSyncStrategy.class, r100);
    }

    private MixedStreamSyncStrategy(String r100, int r101, int r102) {
        super(r100, r101);
        this.syncStrategy = r102;
    }
}
