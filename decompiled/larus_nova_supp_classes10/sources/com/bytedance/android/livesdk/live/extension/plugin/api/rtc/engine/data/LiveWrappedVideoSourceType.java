package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedVideoSourceType;", "", "", "value", "I", "Companion", "a", "VIDEO_SOURCE_TYPE_EXTERNAL", "VIDEO_SOURCE_TYPE_INTERNAL", "VIDEO_SOURCE_TYPE_ENCODED_WITH_SIMULCAST", "VIDEO_SOURCE_TYPE_ENCODED_WITHOUT_SIMULCAST", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedVideoSourceType extends Enum<LiveWrappedVideoSourceType> {
    public static final a Companion = null;
    public static final LiveWrappedVideoSourceType VIDEO_SOURCE_TYPE_ENCODED_WITHOUT_SIMULCAST = null;
    public static final LiveWrappedVideoSourceType VIDEO_SOURCE_TYPE_ENCODED_WITH_SIMULCAST = null;
    public static final LiveWrappedVideoSourceType VIDEO_SOURCE_TYPE_EXTERNAL = null;
    public static final LiveWrappedVideoSourceType VIDEO_SOURCE_TYPE_INTERNAL = null;
    public static final /* synthetic */ LiveWrappedVideoSourceType[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoSourceType$a] */
    static {
        LiveWrappedVideoSourceType r1 = new LiveWrappedVideoSourceType("VIDEO_SOURCE_TYPE_EXTERNAL", 0, 0);
        VIDEO_SOURCE_TYPE_EXTERNAL = r1;
        LiveWrappedVideoSourceType r2 = new LiveWrappedVideoSourceType("VIDEO_SOURCE_TYPE_INTERNAL", 1, 1);
        VIDEO_SOURCE_TYPE_INTERNAL = r2;
        LiveWrappedVideoSourceType r3 = new LiveWrappedVideoSourceType("VIDEO_SOURCE_TYPE_ENCODED_WITH_SIMULCAST", 2, 2);
        VIDEO_SOURCE_TYPE_ENCODED_WITH_SIMULCAST = r3;
        LiveWrappedVideoSourceType r4 = new LiveWrappedVideoSourceType("VIDEO_SOURCE_TYPE_ENCODED_WITHOUT_SIMULCAST", 3, 3);
        VIDEO_SOURCE_TYPE_ENCODED_WITHOUT_SIMULCAST = r4;
        a = new LiveWrappedVideoSourceType[]{r1, r2, r3, r4};
        Companion = new a();
    }

    public static LiveWrappedVideoSourceType valueOf(String r1) {
        return (LiveWrappedVideoSourceType) r27.a.a(LiveWrappedVideoSourceType.class, r1);
    }

    public static LiveWrappedVideoSourceType[] values() {
        return (LiveWrappedVideoSourceType[]) a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedVideoSourceType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
