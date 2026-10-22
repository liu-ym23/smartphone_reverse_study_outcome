package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/live/LiveWrappedMixedStreamSyncStrategy;", "", "", "<set-?>", "value", "I", "getValue", "()I", "MIXED_STREAM_SYNC_STRATEGY_NO_SYNC", "MIXED_STREAM_SYNC_STRATEGY_AUDIO_PRECISE_SYNC", "MIXED_STREAM_SYNC_STRATEGY_SIMPLEX_MODE_SYNC", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedMixedStreamSyncStrategy extends Enum<LiveWrappedMixedStreamSyncStrategy> {
    public static final LiveWrappedMixedStreamSyncStrategy MIXED_STREAM_SYNC_STRATEGY_AUDIO_PRECISE_SYNC = null;
    public static final LiveWrappedMixedStreamSyncStrategy MIXED_STREAM_SYNC_STRATEGY_NO_SYNC = null;
    public static final LiveWrappedMixedStreamSyncStrategy MIXED_STREAM_SYNC_STRATEGY_SIMPLEX_MODE_SYNC = null;
    public static final /* synthetic */ LiveWrappedMixedStreamSyncStrategy[] a = null;
    private int value;

    static {
        LiveWrappedMixedStreamSyncStrategy r1 = new LiveWrappedMixedStreamSyncStrategy("MIXED_STREAM_SYNC_STRATEGY_NO_SYNC", 0, 0);
        MIXED_STREAM_SYNC_STRATEGY_NO_SYNC = r1;
        LiveWrappedMixedStreamSyncStrategy r2 = new LiveWrappedMixedStreamSyncStrategy("MIXED_STREAM_SYNC_STRATEGY_AUDIO_PRECISE_SYNC", 1, 1);
        MIXED_STREAM_SYNC_STRATEGY_AUDIO_PRECISE_SYNC = r2;
        LiveWrappedMixedStreamSyncStrategy r3 = new LiveWrappedMixedStreamSyncStrategy("MIXED_STREAM_SYNC_STRATEGY_SIMPLEX_MODE_SYNC", 2, 2);
        MIXED_STREAM_SYNC_STRATEGY_SIMPLEX_MODE_SYNC = r3;
        a = new LiveWrappedMixedStreamSyncStrategy[]{r1, r2, r3};
    }

    public static LiveWrappedMixedStreamSyncStrategy valueOf(String r1) {
        return (LiveWrappedMixedStreamSyncStrategy) a.a(LiveWrappedMixedStreamSyncStrategy.class, r1);
    }

    public static LiveWrappedMixedStreamSyncStrategy[] values() {
        return (LiveWrappedMixedStreamSyncStrategy[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveWrappedMixedStreamSyncStrategy(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
