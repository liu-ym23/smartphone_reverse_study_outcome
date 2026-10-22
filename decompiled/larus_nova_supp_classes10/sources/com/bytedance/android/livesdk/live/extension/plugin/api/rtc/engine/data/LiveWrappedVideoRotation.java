package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedVideoRotation;", "", "", "value", "I", "Companion", "a", "VIDEO_ROTATION_0", "VIDEO_ROTATION_90", "VIDEO_ROTATION_180", "VIDEO_ROTATION_270", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedVideoRotation extends Enum<LiveWrappedVideoRotation> {
    public static final a Companion = null;
    public static final LiveWrappedVideoRotation VIDEO_ROTATION_0 = null;
    public static final LiveWrappedVideoRotation VIDEO_ROTATION_180 = null;
    public static final LiveWrappedVideoRotation VIDEO_ROTATION_270 = null;
    public static final LiveWrappedVideoRotation VIDEO_ROTATION_90 = null;
    public static final /* synthetic */ LiveWrappedVideoRotation[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoRotation$a] */
    static {
        LiveWrappedVideoRotation r1 = new LiveWrappedVideoRotation("VIDEO_ROTATION_0", 0, 0);
        VIDEO_ROTATION_0 = r1;
        LiveWrappedVideoRotation r2 = new LiveWrappedVideoRotation("VIDEO_ROTATION_90", 1, 90);
        VIDEO_ROTATION_90 = r2;
        LiveWrappedVideoRotation r3 = new LiveWrappedVideoRotation("VIDEO_ROTATION_180", 2, 180);
        VIDEO_ROTATION_180 = r3;
        LiveWrappedVideoRotation r4 = new LiveWrappedVideoRotation("VIDEO_ROTATION_270", 3, 270);
        VIDEO_ROTATION_270 = r4;
        a = new LiveWrappedVideoRotation[]{r1, r2, r3, r4};
        Companion = new a();
    }

    public static LiveWrappedVideoRotation valueOf(String r1) {
        return (LiveWrappedVideoRotation) r27.a.a(LiveWrappedVideoRotation.class, r1);
    }

    public static LiveWrappedVideoRotation[] values() {
        return (LiveWrappedVideoRotation[]) a.clone();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedVideoRotation(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
