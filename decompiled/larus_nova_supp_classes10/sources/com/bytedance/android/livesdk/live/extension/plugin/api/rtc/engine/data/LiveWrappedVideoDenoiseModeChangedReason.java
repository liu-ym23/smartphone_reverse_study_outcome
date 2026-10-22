package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedVideoDenoiseModeChangedReason;", "", "", "value", "", "toString", "I", "Companion", "a", "VIDEO_DENOISE_MODE_CHANGED_REASON_NULL", "VIDEO_DENOISE_MODE_CHANGED_REASON_API_OFF", "VIDEO_DENOISE_MODE_CHANGED_REASON_API_ON", "VIDEO_DENOISE_MODE_CHANGED_REASON_CONFIG_DISABLED", "VIDEO_DENOISE_MODE_CHANGED_REASON_CONFIG_ENABLED", "VIDEO_DENOISE_MODE_CHANGED_REASON_INTERNAL_EXCEPTION", "VIDEO_DENOISE_MODE_CHANGED_REASON_DYNAMIC_CLOSE", "VIDEO_DENOISE_MODE_CHANGED_REASON_DYNAMIC_OPEN", "VIDEO_DENOISE_MODE_CHANGED_REASON_RESOLUTION", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedVideoDenoiseModeChangedReason extends Enum<LiveWrappedVideoDenoiseModeChangedReason> {
    public static final a Companion = null;
    public static final LiveWrappedVideoDenoiseModeChangedReason VIDEO_DENOISE_MODE_CHANGED_REASON_API_OFF = null;
    public static final LiveWrappedVideoDenoiseModeChangedReason VIDEO_DENOISE_MODE_CHANGED_REASON_API_ON = null;
    public static final LiveWrappedVideoDenoiseModeChangedReason VIDEO_DENOISE_MODE_CHANGED_REASON_CONFIG_DISABLED = null;
    public static final LiveWrappedVideoDenoiseModeChangedReason VIDEO_DENOISE_MODE_CHANGED_REASON_CONFIG_ENABLED = null;
    public static final LiveWrappedVideoDenoiseModeChangedReason VIDEO_DENOISE_MODE_CHANGED_REASON_DYNAMIC_CLOSE = null;
    public static final LiveWrappedVideoDenoiseModeChangedReason VIDEO_DENOISE_MODE_CHANGED_REASON_DYNAMIC_OPEN = null;
    public static final LiveWrappedVideoDenoiseModeChangedReason VIDEO_DENOISE_MODE_CHANGED_REASON_INTERNAL_EXCEPTION = null;
    public static final LiveWrappedVideoDenoiseModeChangedReason VIDEO_DENOISE_MODE_CHANGED_REASON_NULL = null;
    public static final LiveWrappedVideoDenoiseModeChangedReason VIDEO_DENOISE_MODE_CHANGED_REASON_RESOLUTION = null;
    public static final /* synthetic */ LiveWrappedVideoDenoiseModeChangedReason[] a = null;
    private int value;

    public static LiveWrappedVideoDenoiseModeChangedReason valueOf(String r1) {
        return (LiveWrappedVideoDenoiseModeChangedReason) r27.a.a(LiveWrappedVideoDenoiseModeChangedReason.class, r1);
    }

    public static LiveWrappedVideoDenoiseModeChangedReason[] values() {
        return (LiveWrappedVideoDenoiseModeChangedReason[]) a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoDenoiseModeChangedReason$a] */
    static {
        LiveWrappedVideoDenoiseModeChangedReason r1 = new LiveWrappedVideoDenoiseModeChangedReason("VIDEO_DENOISE_MODE_CHANGED_REASON_NULL", 0, -1);
        VIDEO_DENOISE_MODE_CHANGED_REASON_NULL = r1;
        LiveWrappedVideoDenoiseModeChangedReason r2 = new LiveWrappedVideoDenoiseModeChangedReason("VIDEO_DENOISE_MODE_CHANGED_REASON_API_OFF", 1, 0);
        VIDEO_DENOISE_MODE_CHANGED_REASON_API_OFF = r2;
        LiveWrappedVideoDenoiseModeChangedReason r3 = new LiveWrappedVideoDenoiseModeChangedReason("VIDEO_DENOISE_MODE_CHANGED_REASON_API_ON", 2, 1);
        VIDEO_DENOISE_MODE_CHANGED_REASON_API_ON = r3;
        LiveWrappedVideoDenoiseModeChangedReason r4 = new LiveWrappedVideoDenoiseModeChangedReason("VIDEO_DENOISE_MODE_CHANGED_REASON_CONFIG_DISABLED", 3, 2);
        VIDEO_DENOISE_MODE_CHANGED_REASON_CONFIG_DISABLED = r4;
        LiveWrappedVideoDenoiseModeChangedReason r5 = new LiveWrappedVideoDenoiseModeChangedReason("VIDEO_DENOISE_MODE_CHANGED_REASON_CONFIG_ENABLED", 4, 3);
        VIDEO_DENOISE_MODE_CHANGED_REASON_CONFIG_ENABLED = r5;
        LiveWrappedVideoDenoiseModeChangedReason r6 = new LiveWrappedVideoDenoiseModeChangedReason("VIDEO_DENOISE_MODE_CHANGED_REASON_INTERNAL_EXCEPTION", 5, 4);
        VIDEO_DENOISE_MODE_CHANGED_REASON_INTERNAL_EXCEPTION = r6;
        LiveWrappedVideoDenoiseModeChangedReason r7 = new LiveWrappedVideoDenoiseModeChangedReason("VIDEO_DENOISE_MODE_CHANGED_REASON_DYNAMIC_CLOSE", 6, 5);
        VIDEO_DENOISE_MODE_CHANGED_REASON_DYNAMIC_CLOSE = r7;
        LiveWrappedVideoDenoiseModeChangedReason r8 = new LiveWrappedVideoDenoiseModeChangedReason("VIDEO_DENOISE_MODE_CHANGED_REASON_DYNAMIC_OPEN", 7, 6);
        VIDEO_DENOISE_MODE_CHANGED_REASON_DYNAMIC_OPEN = r8;
        LiveWrappedVideoDenoiseModeChangedReason r9 = new LiveWrappedVideoDenoiseModeChangedReason("VIDEO_DENOISE_MODE_CHANGED_REASON_RESOLUTION", 8, 7);
        VIDEO_DENOISE_MODE_CHANGED_REASON_RESOLUTION = r9;
        a = new LiveWrappedVideoDenoiseModeChangedReason[]{r1, r2, r3, r4, r5, r6, r7, r8, r9};
        Companion = new a();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(this.value) {
            case -1: goto L22;
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
        return "kVideoDenoiseModeChangedReasonResolution";
    L8:
        return "kVideoDenoiseModeChangedReasonDynamicOpen";
    L10:
        return "kVideoDenoiseModeChangedReasonDynamicClose";
    L12:
        return "kVideoDenoiseModeChangedReasonInternalException";
    L14:
        return "kVideoDenoiseModeChangedReasonConfigEnabled";
    L16:
        return "kVideoDenoiseModeChangedReasonConfigDisabled";
    L18:
        return "kVideoDenoiseModeChangedReasonApiOn";
    L20:
        return "kVideoDenoiseModeChangedReasonApiOff";
    L22:
        return "kVideoDenoiseModeChangedReasonNull";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedVideoDenoiseModeChangedReason(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
