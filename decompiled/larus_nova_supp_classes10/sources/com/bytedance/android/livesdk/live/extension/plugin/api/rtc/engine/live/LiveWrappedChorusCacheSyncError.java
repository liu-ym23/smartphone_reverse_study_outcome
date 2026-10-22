package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/live/LiveWrappedChorusCacheSyncError;", "", "", "value", "I", "Companion", "a", "CHORUS_CACHE_SYNC_ERROR_OK", "CHORUS_CACHE_SYNC_ERROR_WRONG_STATE", "CHORUS_CACHE_SYNC_ERROR_ALREADY_RUNNING", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedChorusCacheSyncError extends Enum<LiveWrappedChorusCacheSyncError> {
    public static final LiveWrappedChorusCacheSyncError CHORUS_CACHE_SYNC_ERROR_ALREADY_RUNNING = null;
    public static final LiveWrappedChorusCacheSyncError CHORUS_CACHE_SYNC_ERROR_OK = null;
    public static final LiveWrappedChorusCacheSyncError CHORUS_CACHE_SYNC_ERROR_WRONG_STATE = null;
    public static final a Companion = null;
    public static final /* synthetic */ LiveWrappedChorusCacheSyncError[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedChorusCacheSyncError$a] */
    static {
        LiveWrappedChorusCacheSyncError r1 = new LiveWrappedChorusCacheSyncError("CHORUS_CACHE_SYNC_ERROR_OK", 0, 0);
        CHORUS_CACHE_SYNC_ERROR_OK = r1;
        LiveWrappedChorusCacheSyncError r2 = new LiveWrappedChorusCacheSyncError("CHORUS_CACHE_SYNC_ERROR_WRONG_STATE", 1, 1);
        CHORUS_CACHE_SYNC_ERROR_WRONG_STATE = r2;
        LiveWrappedChorusCacheSyncError r3 = new LiveWrappedChorusCacheSyncError("CHORUS_CACHE_SYNC_ERROR_ALREADY_RUNNING", 2, 2);
        CHORUS_CACHE_SYNC_ERROR_ALREADY_RUNNING = r3;
        a = new LiveWrappedChorusCacheSyncError[]{r1, r2, r3};
        Companion = new a();
    }

    public static LiveWrappedChorusCacheSyncError valueOf(String r1) {
        return (LiveWrappedChorusCacheSyncError) r27.a.a(LiveWrappedChorusCacheSyncError.class, r1);
    }

    public static LiveWrappedChorusCacheSyncError[] values() {
        return (LiveWrappedChorusCacheSyncError[]) a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedChorusCacheSyncError(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
