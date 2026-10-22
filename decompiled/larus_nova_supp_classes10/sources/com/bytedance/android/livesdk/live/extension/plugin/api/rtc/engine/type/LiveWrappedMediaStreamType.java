package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedMediaStreamType;", "", "", "value", "I", "getValue", "()I", "Companion", "a", "RTC_MEDIA_STREAM_TYPE_AUDIO", "RTC_MEDIA_STREAM_TYPE_VIDEO", "RTC_MEDIA_STREAM_TYPE_BOTH", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedMediaStreamType extends Enum<LiveWrappedMediaStreamType> {
    public static final a Companion = null;
    public static final LiveWrappedMediaStreamType RTC_MEDIA_STREAM_TYPE_AUDIO = null;
    public static final LiveWrappedMediaStreamType RTC_MEDIA_STREAM_TYPE_BOTH = null;
    public static final LiveWrappedMediaStreamType RTC_MEDIA_STREAM_TYPE_VIDEO = null;
    public static final /* synthetic */ LiveWrappedMediaStreamType[] a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedMediaStreamType$a] */
    static {
        LiveWrappedMediaStreamType r2 = new LiveWrappedMediaStreamType("RTC_MEDIA_STREAM_TYPE_AUDIO", 0, 1);
        RTC_MEDIA_STREAM_TYPE_AUDIO = r2;
        LiveWrappedMediaStreamType r3 = new LiveWrappedMediaStreamType("RTC_MEDIA_STREAM_TYPE_VIDEO", 1, 2);
        RTC_MEDIA_STREAM_TYPE_VIDEO = r3;
        LiveWrappedMediaStreamType r4 = new LiveWrappedMediaStreamType("RTC_MEDIA_STREAM_TYPE_BOTH", 2, 3);
        RTC_MEDIA_STREAM_TYPE_BOTH = r4;
        a = new LiveWrappedMediaStreamType[]{r2, r3, r4};
        Companion = new a();
    }

    public static LiveWrappedMediaStreamType valueOf(String r1) {
        return (LiveWrappedMediaStreamType) r27.a.a(LiveWrappedMediaStreamType.class, r1);
    }

    public static LiveWrappedMediaStreamType[] values() {
        return (LiveWrappedMediaStreamType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveWrappedMediaStreamType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
