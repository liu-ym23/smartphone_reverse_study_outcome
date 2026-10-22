package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"com/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference", "", "Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference;", "", "value", "I", "getValue", "()I", "Companion", "a", "Disabled", "MaintainFramerate", "MaintainQuality", "Balance", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference extends Enum<LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference> {
    public static final LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference Balance = null;
    public static final a Companion = null;
    public static final LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference Disabled = null;
    public static final LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference MaintainFramerate = null;
    public static final LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference MaintainQuality = null;
    public static final /* synthetic */ LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference[] a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference$a] */
    static {
        LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference r1 = new LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference("Disabled", 0, 0);
        Disabled = r1;
        LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference r2 = new LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference("MaintainFramerate", 1, 1);
        MaintainFramerate = r2;
        LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference r3 = new LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference("MaintainQuality", 2, 2);
        MaintainQuality = r3;
        LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference r4 = new LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference("Balance", 3, 3);
        Balance = r4;
        a = new LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference[]{r1, r2, r3, r4};
        Companion = new a();
    }

    public static LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference valueOf(String r1) {
        return (LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference) r27.a.a(LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference.class, r1);
    }

    public static LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference[] values() {
        return (LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveWrappedVideoStreamDescription$LiveWrappedEncoderPreference(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
