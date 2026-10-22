package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/live/LiveWrappedChorusCacheSyncEvent;", "", "", "value", "I", "Companion", "a", "CHORUS_CACHE_SYNC_EVENT_START_SUCCESS", "CHORUS_CACHE_SYNC_EVENT_START_FAILED", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedChorusCacheSyncEvent extends Enum<LiveWrappedChorusCacheSyncEvent> {
    public static final LiveWrappedChorusCacheSyncEvent CHORUS_CACHE_SYNC_EVENT_START_FAILED = null;
    public static final LiveWrappedChorusCacheSyncEvent CHORUS_CACHE_SYNC_EVENT_START_SUCCESS = null;
    public static final a Companion = null;
    public static final /* synthetic */ LiveWrappedChorusCacheSyncEvent[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedChorusCacheSyncEvent$a] */
    static {
        LiveWrappedChorusCacheSyncEvent r1 = new LiveWrappedChorusCacheSyncEvent("CHORUS_CACHE_SYNC_EVENT_START_SUCCESS", 0, 0);
        CHORUS_CACHE_SYNC_EVENT_START_SUCCESS = r1;
        LiveWrappedChorusCacheSyncEvent r2 = new LiveWrappedChorusCacheSyncEvent("CHORUS_CACHE_SYNC_EVENT_START_FAILED", 1, 1);
        CHORUS_CACHE_SYNC_EVENT_START_FAILED = r2;
        a = new LiveWrappedChorusCacheSyncEvent[]{r1, r2};
        Companion = new a();
    }

    public static LiveWrappedChorusCacheSyncEvent valueOf(String r1) {
        return (LiveWrappedChorusCacheSyncEvent) r27.a.a(LiveWrappedChorusCacheSyncEvent.class, r1);
    }

    public static LiveWrappedChorusCacheSyncEvent[] values() {
        return (LiveWrappedChorusCacheSyncEvent[]) a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedChorusCacheSyncEvent(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
