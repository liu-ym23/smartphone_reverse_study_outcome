package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.video;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/video/LiveWrappedVideoApplyRotation;", "", "", "value", "I", "getValue", "()I", "Companion", "a", "DEFAULT", "DEGREE_0", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedVideoApplyRotation extends Enum<LiveWrappedVideoApplyRotation> {
    public static final a Companion = null;
    public static final LiveWrappedVideoApplyRotation DEFAULT = null;
    public static final LiveWrappedVideoApplyRotation DEGREE_0 = null;
    public static final /* synthetic */ LiveWrappedVideoApplyRotation[] a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.video.LiveWrappedVideoApplyRotation$a] */
    static {
        LiveWrappedVideoApplyRotation r1 = new LiveWrappedVideoApplyRotation("DEFAULT", 0, -1);
        DEFAULT = r1;
        LiveWrappedVideoApplyRotation r2 = new LiveWrappedVideoApplyRotation("DEGREE_0", 1, 0);
        DEGREE_0 = r2;
        a = new LiveWrappedVideoApplyRotation[]{r1, r2};
        Companion = new a();
    }

    public static LiveWrappedVideoApplyRotation valueOf(String r1) {
        return (LiveWrappedVideoApplyRotation) r27.a.a(LiveWrappedVideoApplyRotation.class, r1);
    }

    public static LiveWrappedVideoApplyRotation[] values() {
        return (LiveWrappedVideoApplyRotation[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveWrappedVideoApplyRotation(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
