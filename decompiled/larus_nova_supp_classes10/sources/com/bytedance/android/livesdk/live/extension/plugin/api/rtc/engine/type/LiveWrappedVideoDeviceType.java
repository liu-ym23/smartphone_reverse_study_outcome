package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedVideoDeviceType;", "", "", "value", "I", "Companion", "a", "VIDEO_DEVICE_TYPE_UNKNOWN", "VIDEO_DEVICE_TYPE_RENDER_DEVICE", "VIDEO_DEVICE_TYPE_CAPTURE_DEVICE", "VIDEO_DEVICE_TYPE_SCREEN_CAPTURE_DEVICE", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedVideoDeviceType extends Enum<LiveWrappedVideoDeviceType> {
    public static final a Companion = null;
    public static final LiveWrappedVideoDeviceType VIDEO_DEVICE_TYPE_CAPTURE_DEVICE = null;
    public static final LiveWrappedVideoDeviceType VIDEO_DEVICE_TYPE_RENDER_DEVICE = null;
    public static final LiveWrappedVideoDeviceType VIDEO_DEVICE_TYPE_SCREEN_CAPTURE_DEVICE = null;
    public static final LiveWrappedVideoDeviceType VIDEO_DEVICE_TYPE_UNKNOWN = null;
    public static final /* synthetic */ LiveWrappedVideoDeviceType[] a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedVideoDeviceType$a] */
    static {
        LiveWrappedVideoDeviceType r1 = new LiveWrappedVideoDeviceType("VIDEO_DEVICE_TYPE_UNKNOWN", 0, -1);
        VIDEO_DEVICE_TYPE_UNKNOWN = r1;
        LiveWrappedVideoDeviceType r2 = new LiveWrappedVideoDeviceType("VIDEO_DEVICE_TYPE_RENDER_DEVICE", 1, 0);
        VIDEO_DEVICE_TYPE_RENDER_DEVICE = r2;
        LiveWrappedVideoDeviceType r3 = new LiveWrappedVideoDeviceType("VIDEO_DEVICE_TYPE_CAPTURE_DEVICE", 2, 1);
        VIDEO_DEVICE_TYPE_CAPTURE_DEVICE = r3;
        LiveWrappedVideoDeviceType r4 = new LiveWrappedVideoDeviceType("VIDEO_DEVICE_TYPE_SCREEN_CAPTURE_DEVICE", 3, 2);
        VIDEO_DEVICE_TYPE_SCREEN_CAPTURE_DEVICE = r4;
        a = new LiveWrappedVideoDeviceType[]{r1, r2, r3, r4};
        Companion = new a();
    }

    public static LiveWrappedVideoDeviceType valueOf(String r1) {
        return (LiveWrappedVideoDeviceType) r27.a.a(LiveWrappedVideoDeviceType.class, r1);
    }

    public static LiveWrappedVideoDeviceType[] values() {
        return (LiveWrappedVideoDeviceType[]) a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedVideoDeviceType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
