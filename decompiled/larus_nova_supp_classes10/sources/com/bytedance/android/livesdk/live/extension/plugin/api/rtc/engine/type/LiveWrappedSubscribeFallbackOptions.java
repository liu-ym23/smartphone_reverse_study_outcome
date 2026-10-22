package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedSubscribeFallbackOptions;", "", "", "value", "I", "Companion", "a", "SUBSCRIBE_FALLBACK_OPTIONS_DISABLED", "SUBSCRIBE_FALLBACK_OPTIONS_STREAM_LOW", "SUBSCRIBE_FALLBACK_OPTIONS_AUDIO_ONLY", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedSubscribeFallbackOptions extends Enum<LiveWrappedSubscribeFallbackOptions> {
    public static final a Companion = null;
    public static final LiveWrappedSubscribeFallbackOptions SUBSCRIBE_FALLBACK_OPTIONS_AUDIO_ONLY = null;
    public static final LiveWrappedSubscribeFallbackOptions SUBSCRIBE_FALLBACK_OPTIONS_DISABLED = null;
    public static final LiveWrappedSubscribeFallbackOptions SUBSCRIBE_FALLBACK_OPTIONS_STREAM_LOW = null;
    public static final /* synthetic */ LiveWrappedSubscribeFallbackOptions[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedSubscribeFallbackOptions$a] */
    static {
        LiveWrappedSubscribeFallbackOptions r1 = new LiveWrappedSubscribeFallbackOptions("SUBSCRIBE_FALLBACK_OPTIONS_DISABLED", 0, 0);
        SUBSCRIBE_FALLBACK_OPTIONS_DISABLED = r1;
        LiveWrappedSubscribeFallbackOptions r2 = new LiveWrappedSubscribeFallbackOptions("SUBSCRIBE_FALLBACK_OPTIONS_STREAM_LOW", 1, 1);
        SUBSCRIBE_FALLBACK_OPTIONS_STREAM_LOW = r2;
        LiveWrappedSubscribeFallbackOptions r3 = new LiveWrappedSubscribeFallbackOptions("SUBSCRIBE_FALLBACK_OPTIONS_AUDIO_ONLY", 2, 2);
        SUBSCRIBE_FALLBACK_OPTIONS_AUDIO_ONLY = r3;
        a = new LiveWrappedSubscribeFallbackOptions[]{r1, r2, r3};
        Companion = new a();
    }

    public static LiveWrappedSubscribeFallbackOptions valueOf(String r1) {
        return (LiveWrappedSubscribeFallbackOptions) r27.a.a(LiveWrappedSubscribeFallbackOptions.class, r1);
    }

    public static LiveWrappedSubscribeFallbackOptions[] values() {
        return (LiveWrappedSubscribeFallbackOptions[]) a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedSubscribeFallbackOptions(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
