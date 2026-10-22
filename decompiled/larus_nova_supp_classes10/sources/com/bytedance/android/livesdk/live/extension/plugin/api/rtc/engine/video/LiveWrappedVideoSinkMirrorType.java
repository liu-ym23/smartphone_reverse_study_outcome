package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.video;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/video/LiveWrappedVideoSinkMirrorType;", "", "", "value", "I", "getValue", "()I", "Companion", "a", "ON", "OFF", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedVideoSinkMirrorType extends Enum<LiveWrappedVideoSinkMirrorType> {
    public static final a Companion = null;
    public static final LiveWrappedVideoSinkMirrorType OFF = null;
    public static final LiveWrappedVideoSinkMirrorType ON = null;
    public static final /* synthetic */ LiveWrappedVideoSinkMirrorType[] a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.video.LiveWrappedVideoSinkMirrorType$a] */
    static {
        LiveWrappedVideoSinkMirrorType r2 = new LiveWrappedVideoSinkMirrorType("ON", 0, 1);
        ON = r2;
        LiveWrappedVideoSinkMirrorType r3 = new LiveWrappedVideoSinkMirrorType("OFF", 1, 2);
        OFF = r3;
        a = new LiveWrappedVideoSinkMirrorType[]{r2, r3};
        Companion = new a();
    }

    public static LiveWrappedVideoSinkMirrorType valueOf(String r1) {
        return (LiveWrappedVideoSinkMirrorType) r27.a.a(LiveWrappedVideoSinkMirrorType.class, r1);
    }

    public static LiveWrappedVideoSinkMirrorType[] values() {
        return (LiveWrappedVideoSinkMirrorType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveWrappedVideoSinkMirrorType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
