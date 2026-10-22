package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedScreenMediaType;", "", "", "value", "I", "Companion", "a", "SCREEN_MEDIA_TYPE_VIDEO_ONLY", "SCREEN_MEDIA_TYPE_AUDIO_ONLY", "SCREEN_MEDIA_TYPE_VIDEO_AND_AUDIO", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedScreenMediaType extends Enum<LiveWrappedScreenMediaType> {
    public static final a Companion = null;
    public static final LiveWrappedScreenMediaType SCREEN_MEDIA_TYPE_AUDIO_ONLY = null;
    public static final LiveWrappedScreenMediaType SCREEN_MEDIA_TYPE_VIDEO_AND_AUDIO = null;
    public static final LiveWrappedScreenMediaType SCREEN_MEDIA_TYPE_VIDEO_ONLY = null;
    public static final /* synthetic */ LiveWrappedScreenMediaType[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedScreenMediaType$a] */
    static {
        LiveWrappedScreenMediaType r1 = new LiveWrappedScreenMediaType("SCREEN_MEDIA_TYPE_VIDEO_ONLY", 0, 0);
        SCREEN_MEDIA_TYPE_VIDEO_ONLY = r1;
        LiveWrappedScreenMediaType r2 = new LiveWrappedScreenMediaType("SCREEN_MEDIA_TYPE_AUDIO_ONLY", 1, 1);
        SCREEN_MEDIA_TYPE_AUDIO_ONLY = r2;
        LiveWrappedScreenMediaType r3 = new LiveWrappedScreenMediaType("SCREEN_MEDIA_TYPE_VIDEO_AND_AUDIO", 2, 2);
        SCREEN_MEDIA_TYPE_VIDEO_AND_AUDIO = r3;
        a = new LiveWrappedScreenMediaType[]{r1, r2, r3};
        Companion = new a();
    }

    public static LiveWrappedScreenMediaType valueOf(String r1) {
        return (LiveWrappedScreenMediaType) r27.a.a(LiveWrappedScreenMediaType.class, r1);
    }

    public static LiveWrappedScreenMediaType[] values() {
        return (LiveWrappedScreenMediaType[]) a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedScreenMediaType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
