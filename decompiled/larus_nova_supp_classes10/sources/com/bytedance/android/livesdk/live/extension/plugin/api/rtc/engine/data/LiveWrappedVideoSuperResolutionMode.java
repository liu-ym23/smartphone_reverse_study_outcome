package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedVideoSuperResolutionMode;", "", "", "value", "", "toString", "I", "Companion", "a", "OFF", "SCALE_AUTO", "SCALE_15X", "SCALE_20X", "SCALE_11X", "SCALE_12X", "SCALE_13X", "SCALE_14X", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedVideoSuperResolutionMode extends Enum<LiveWrappedVideoSuperResolutionMode> {
    public static final a Companion = null;
    public static final LiveWrappedVideoSuperResolutionMode OFF = null;
    public static final LiveWrappedVideoSuperResolutionMode SCALE_11X = null;
    public static final LiveWrappedVideoSuperResolutionMode SCALE_12X = null;
    public static final LiveWrappedVideoSuperResolutionMode SCALE_13X = null;
    public static final LiveWrappedVideoSuperResolutionMode SCALE_14X = null;
    public static final LiveWrappedVideoSuperResolutionMode SCALE_15X = null;
    public static final LiveWrappedVideoSuperResolutionMode SCALE_20X = null;
    public static final LiveWrappedVideoSuperResolutionMode SCALE_AUTO = null;
    public static final /* synthetic */ LiveWrappedVideoSuperResolutionMode[] a = null;
    private int value;

    public static LiveWrappedVideoSuperResolutionMode valueOf(String r1) {
        return (LiveWrappedVideoSuperResolutionMode) r27.a.a(LiveWrappedVideoSuperResolutionMode.class, r1);
    }

    public static LiveWrappedVideoSuperResolutionMode[] values() {
        return (LiveWrappedVideoSuperResolutionMode[]) a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoSuperResolutionMode$a] */
    static {
        LiveWrappedVideoSuperResolutionMode r1 = new LiveWrappedVideoSuperResolutionMode("OFF", 0, 0);
        OFF = r1;
        LiveWrappedVideoSuperResolutionMode r2 = new LiveWrappedVideoSuperResolutionMode("SCALE_AUTO", 1, 1);
        SCALE_AUTO = r2;
        LiveWrappedVideoSuperResolutionMode r3 = new LiveWrappedVideoSuperResolutionMode("SCALE_15X", 2, 2);
        SCALE_15X = r3;
        LiveWrappedVideoSuperResolutionMode r4 = new LiveWrappedVideoSuperResolutionMode("SCALE_20X", 3, 3);
        SCALE_20X = r4;
        LiveWrappedVideoSuperResolutionMode r5 = new LiveWrappedVideoSuperResolutionMode("SCALE_11X", 4, 4);
        SCALE_11X = r5;
        LiveWrappedVideoSuperResolutionMode r6 = new LiveWrappedVideoSuperResolutionMode("SCALE_12X", 5, 5);
        SCALE_12X = r6;
        LiveWrappedVideoSuperResolutionMode r7 = new LiveWrappedVideoSuperResolutionMode("SCALE_13X", 6, 6);
        SCALE_13X = r7;
        LiveWrappedVideoSuperResolutionMode r8 = new LiveWrappedVideoSuperResolutionMode("SCALE_14X", 7, 7);
        SCALE_14X = r8;
        a = new LiveWrappedVideoSuperResolutionMode[]{r1, r2, r3, r4, r5, r6, r7, r8};
        Companion = new a();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(this.value) {
            case 0: goto L20;
            case 1: goto L18;
            case 2: goto L16;
            case 3: goto L14;
            case 4: goto L12;
            case 5: goto L10;
            case 6: goto L8;
            case 7: goto L6;
            default: goto L4;
        };
    L4:
        return "";
    L6:
        return "kVideoSuperResolutionModeScale14X";
    L8:
        return "kVideoSuperResolutionModeScale13X";
    L10:
        return "kVideoSuperResolutionModeScale12X";
    L12:
        return "kVideoSuperResolutionModeScale11X";
    L14:
        return "kVideoSuperResolutionModeScale20X";
    L16:
        return "kVideoSuperResolutionModeScale15X";
    L18:
        return "kVideoSuperResolutionModeScaleAuto";
    L20:
        return "kVideoSuperResolutionModeOff";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedVideoSuperResolutionMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
