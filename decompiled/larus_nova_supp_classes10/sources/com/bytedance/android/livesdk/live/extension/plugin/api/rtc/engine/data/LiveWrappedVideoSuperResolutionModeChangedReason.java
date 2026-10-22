package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedVideoSuperResolutionModeChangedReason;", "", "", "value", "", "toString", "I", "Companion", "a", "VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_API_OFF", "VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_API_ON", "VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_RESOLUTION_EXCEED", "VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_OVER_USE", "VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_DEVICE_NOT_SUPPORT", "VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_DYNAMIC_CLOSE", "VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_OTHER_SETTING_DISABLED", "VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_OTHER_SETTING_ENABLED", "VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_NO_COMPONENT", "VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_STREAM_NOT_EXIST", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedVideoSuperResolutionModeChangedReason extends Enum<LiveWrappedVideoSuperResolutionModeChangedReason> {
    public static final a Companion = null;
    public static final LiveWrappedVideoSuperResolutionModeChangedReason VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_API_OFF = null;
    public static final LiveWrappedVideoSuperResolutionModeChangedReason VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_API_ON = null;
    public static final LiveWrappedVideoSuperResolutionModeChangedReason VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_DEVICE_NOT_SUPPORT = null;
    public static final LiveWrappedVideoSuperResolutionModeChangedReason VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_DYNAMIC_CLOSE = null;
    public static final LiveWrappedVideoSuperResolutionModeChangedReason VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_NO_COMPONENT = null;
    public static final LiveWrappedVideoSuperResolutionModeChangedReason VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_OTHER_SETTING_DISABLED = null;
    public static final LiveWrappedVideoSuperResolutionModeChangedReason VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_OTHER_SETTING_ENABLED = null;
    public static final LiveWrappedVideoSuperResolutionModeChangedReason VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_OVER_USE = null;
    public static final LiveWrappedVideoSuperResolutionModeChangedReason VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_RESOLUTION_EXCEED = null;
    public static final LiveWrappedVideoSuperResolutionModeChangedReason VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_STREAM_NOT_EXIST = null;
    public static final /* synthetic */ LiveWrappedVideoSuperResolutionModeChangedReason[] a = null;
    private int value;

    public static LiveWrappedVideoSuperResolutionModeChangedReason valueOf(String r1) {
        return (LiveWrappedVideoSuperResolutionModeChangedReason) r27.a.a(LiveWrappedVideoSuperResolutionModeChangedReason.class, r1);
    }

    public static LiveWrappedVideoSuperResolutionModeChangedReason[] values() {
        return (LiveWrappedVideoSuperResolutionModeChangedReason[]) a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoSuperResolutionModeChangedReason$a] */
    static {
        LiveWrappedVideoSuperResolutionModeChangedReason r1 = new LiveWrappedVideoSuperResolutionModeChangedReason("VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_API_OFF", 0, 0);
        VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_API_OFF = r1;
        LiveWrappedVideoSuperResolutionModeChangedReason r2 = new LiveWrappedVideoSuperResolutionModeChangedReason("VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_API_ON", 1, 1);
        VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_API_ON = r2;
        LiveWrappedVideoSuperResolutionModeChangedReason r3 = new LiveWrappedVideoSuperResolutionModeChangedReason("VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_RESOLUTION_EXCEED", 2, 2);
        VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_RESOLUTION_EXCEED = r3;
        LiveWrappedVideoSuperResolutionModeChangedReason r4 = new LiveWrappedVideoSuperResolutionModeChangedReason("VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_OVER_USE", 3, 3);
        VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_OVER_USE = r4;
        LiveWrappedVideoSuperResolutionModeChangedReason r5 = new LiveWrappedVideoSuperResolutionModeChangedReason("VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_DEVICE_NOT_SUPPORT", 4, 4);
        VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_DEVICE_NOT_SUPPORT = r5;
        LiveWrappedVideoSuperResolutionModeChangedReason r6 = new LiveWrappedVideoSuperResolutionModeChangedReason("VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_DYNAMIC_CLOSE", 5, 5);
        VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_DYNAMIC_CLOSE = r6;
        LiveWrappedVideoSuperResolutionModeChangedReason r7 = new LiveWrappedVideoSuperResolutionModeChangedReason("VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_OTHER_SETTING_DISABLED", 6, 6);
        VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_OTHER_SETTING_DISABLED = r7;
        LiveWrappedVideoSuperResolutionModeChangedReason r8 = new LiveWrappedVideoSuperResolutionModeChangedReason("VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_OTHER_SETTING_ENABLED", 7, 7);
        VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_OTHER_SETTING_ENABLED = r8;
        LiveWrappedVideoSuperResolutionModeChangedReason r9 = new LiveWrappedVideoSuperResolutionModeChangedReason("VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_NO_COMPONENT", 8, 8);
        VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_NO_COMPONENT = r9;
        LiveWrappedVideoSuperResolutionModeChangedReason r10 = new LiveWrappedVideoSuperResolutionModeChangedReason("VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_STREAM_NOT_EXIST", 9, 9);
        VIDEO_SUPER_RESOLUTION_MODE_CHANGED_REASON_STREAM_NOT_EXIST = r10;
        a = new LiveWrappedVideoSuperResolutionModeChangedReason[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10};
        Companion = new a();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r0 = this.value;
        if (r0 != 0) goto L5;
        return "kVideoSuperResolutionModeChangedReasonAPIOff";
    L5:
        if (r0 != 1) goto L7;
        return "kVideoSuperResolutionModeChangedReasonAPIOn";
    L7:
        if (r0 != 2) goto L9;
        return "kVideoSuperResolutionModeChangedReasonResolutionExceed";
    L9:
        if (r0 != 3) goto L11;
        return "kVideoSuperResolutionModeChangedReasonOverUse";
    L11:
        if (r0 != 4) goto L13;
        return "kVideoSuperResolutionModeChangedReasonDeviceNotSupport";
    L13:
        if (r0 != 5) goto L15;
        return "kVideoSuperResolutionModeChangedReasonDynamicClose";
    L15:
        if (r0 != 100) goto L17;
        return "kVideoSuperResolutionModeChangedReasonNoComponent";
    L17:
        if (r0 != 101) goto L19;
        return "kVideoSuperResolutionModeChangedReasonStreamNotExist";
    L19:
        if (r0 == 200) goto L22;
        return "";
    L22:
        return "kVideoSuperResolutionModeChangedReasonOther";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedVideoSuperResolutionModeChangedReason(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
