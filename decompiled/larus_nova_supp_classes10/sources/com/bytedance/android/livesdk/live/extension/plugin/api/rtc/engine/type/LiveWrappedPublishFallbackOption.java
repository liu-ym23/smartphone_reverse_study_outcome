package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedPublishFallbackOption;", "", "", "value", "I", "Companion", "a", "DISABLE", "SIMULCAST_SMALL_VIDEO_ONLY", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedPublishFallbackOption extends Enum<LiveWrappedPublishFallbackOption> {
    public static final a Companion = null;
    public static final LiveWrappedPublishFallbackOption DISABLE = null;
    public static final LiveWrappedPublishFallbackOption SIMULCAST_SMALL_VIDEO_ONLY = null;
    public static final /* synthetic */ LiveWrappedPublishFallbackOption[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedPublishFallbackOption$a] */
    static {
        LiveWrappedPublishFallbackOption r1 = new LiveWrappedPublishFallbackOption("DISABLE", 0, 0);
        DISABLE = r1;
        LiveWrappedPublishFallbackOption r2 = new LiveWrappedPublishFallbackOption("SIMULCAST_SMALL_VIDEO_ONLY", 1, 1);
        SIMULCAST_SMALL_VIDEO_ONLY = r2;
        a = new LiveWrappedPublishFallbackOption[]{r1, r2};
        Companion = new a();
    }

    public static LiveWrappedPublishFallbackOption valueOf(String r1) {
        return (LiveWrappedPublishFallbackOption) r27.a.a(LiveWrappedPublishFallbackOption.class, r1);
    }

    public static LiveWrappedPublishFallbackOption[] values() {
        return (LiveWrappedPublishFallbackOption[]) a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedPublishFallbackOption(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
