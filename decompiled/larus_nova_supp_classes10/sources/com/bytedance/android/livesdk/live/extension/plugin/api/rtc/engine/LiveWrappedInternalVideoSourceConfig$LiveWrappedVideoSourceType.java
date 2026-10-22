package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"com/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoSourceType", "", "Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoSourceType;", "", "value", "I", "getValue", "()I", "VIDEO_SOURCE_TYPE_EXTERNAL", "VIDEO_SOURCE_TYPE_INTERNAL", "VIDEO_SOURCE_TYPE_ENCODER_WITH_AUTO_SIMULCAST", "VIDEO_SOURCE_TYPE_ENCODER_WITHOUT_AUTO_SIMULCAST", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoSourceType extends Enum<LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoSourceType> {
    public static final LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoSourceType VIDEO_SOURCE_TYPE_ENCODER_WITHOUT_AUTO_SIMULCAST = null;
    public static final LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoSourceType VIDEO_SOURCE_TYPE_ENCODER_WITH_AUTO_SIMULCAST = null;
    public static final LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoSourceType VIDEO_SOURCE_TYPE_EXTERNAL = null;
    public static final LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoSourceType VIDEO_SOURCE_TYPE_INTERNAL = null;
    public static final /* synthetic */ LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoSourceType[] a = null;
    private final int value;

    static {
        LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoSourceType r1 = new LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoSourceType("VIDEO_SOURCE_TYPE_EXTERNAL", 0, 0);
        VIDEO_SOURCE_TYPE_EXTERNAL = r1;
        LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoSourceType r2 = new LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoSourceType("VIDEO_SOURCE_TYPE_INTERNAL", 1, 1);
        VIDEO_SOURCE_TYPE_INTERNAL = r2;
        LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoSourceType r3 = new LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoSourceType("VIDEO_SOURCE_TYPE_ENCODER_WITH_AUTO_SIMULCAST", 2, 2);
        VIDEO_SOURCE_TYPE_ENCODER_WITH_AUTO_SIMULCAST = r3;
        LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoSourceType r4 = new LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoSourceType("VIDEO_SOURCE_TYPE_ENCODER_WITHOUT_AUTO_SIMULCAST", 3, 3);
        VIDEO_SOURCE_TYPE_ENCODER_WITHOUT_AUTO_SIMULCAST = r4;
        a = new LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoSourceType[]{r1, r2, r3, r4};
    }

    public static LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoSourceType valueOf(String r1) {
        return (LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoSourceType) a.a(LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoSourceType.class, r1);
    }

    public static LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoSourceType[] values() {
        return (LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoSourceType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveWrappedInternalVideoSourceConfig$LiveWrappedVideoSourceType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
