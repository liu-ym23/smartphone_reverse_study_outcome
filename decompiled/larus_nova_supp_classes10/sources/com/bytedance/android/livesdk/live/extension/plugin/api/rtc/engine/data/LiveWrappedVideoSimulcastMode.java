package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import kotlin.Metadata;
import zf2.u0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedVideoSimulcastMode;", "", "", "value", "", "toString", "I", "Companion", "a", "VIDEO_SIMULCAST_MODE_ONLY_ONE", "VIDEO_SIMULCAST_MODE_ON_DEMAND", "VIDEO_SIMULCAST_MODE_ALWAYS_SIMULCAST", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedVideoSimulcastMode extends Enum<LiveWrappedVideoSimulcastMode> {
    public static final a Companion = null;
    public static final LiveWrappedVideoSimulcastMode VIDEO_SIMULCAST_MODE_ALWAYS_SIMULCAST = null;
    public static final LiveWrappedVideoSimulcastMode VIDEO_SIMULCAST_MODE_ONLY_ONE = null;
    public static final LiveWrappedVideoSimulcastMode VIDEO_SIMULCAST_MODE_ON_DEMAND = null;
    public static final /* synthetic */ LiveWrappedVideoSimulcastMode[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoSimulcastMode$a] */
    static {
        LiveWrappedVideoSimulcastMode r1 = new LiveWrappedVideoSimulcastMode("VIDEO_SIMULCAST_MODE_ONLY_ONE", 0, 0);
        VIDEO_SIMULCAST_MODE_ONLY_ONE = r1;
        LiveWrappedVideoSimulcastMode r2 = new LiveWrappedVideoSimulcastMode("VIDEO_SIMULCAST_MODE_ON_DEMAND", 1, 1);
        VIDEO_SIMULCAST_MODE_ON_DEMAND = r2;
        LiveWrappedVideoSimulcastMode r3 = new LiveWrappedVideoSimulcastMode("VIDEO_SIMULCAST_MODE_ALWAYS_SIMULCAST", 2, 2);
        VIDEO_SIMULCAST_MODE_ALWAYS_SIMULCAST = r3;
        a = new LiveWrappedVideoSimulcastMode[]{r1, r2, r3};
        Companion = new a();
    }

    public static LiveWrappedVideoSimulcastMode valueOf(String r1) {
        return (LiveWrappedVideoSimulcastMode) r27.a.a(LiveWrappedVideoSimulcastMode.class, r1);
    }

    public static LiveWrappedVideoSimulcastMode[] values() {
        return (LiveWrappedVideoSimulcastMode[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r0 = u0.a[ordinal()];
        if (r0 != 1) goto L5;
        return "kVideoSimulcastModeOnlyOne";
    L5:
        if (r0 != 2) goto L7;
        return "kVideoSimulcastModeOnDemand";
    L7:
        if (r0 == 3) goto L10;
        return "valid";
    L10:
        return "kVideoSimulcastModeAlwaysSimulcast";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedVideoSimulcastMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
