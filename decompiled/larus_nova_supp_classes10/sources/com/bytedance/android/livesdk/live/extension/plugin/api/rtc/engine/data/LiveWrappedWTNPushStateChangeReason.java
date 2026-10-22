package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import kotlin.Metadata;
import zf2.y0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedWTNPushStateChangeReason;", "", "", "value", "", "toString", "I", "Companion", "a", "PushSuccess", "StartPush", "StopPush", "InRetry", "RetryFail", "NoPushPermission", "StreamPushByOther", "Internal", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedWTNPushStateChangeReason extends Enum<LiveWrappedWTNPushStateChangeReason> {
    public static final a Companion = null;
    public static final LiveWrappedWTNPushStateChangeReason InRetry = null;
    public static final LiveWrappedWTNPushStateChangeReason Internal = null;
    public static final LiveWrappedWTNPushStateChangeReason NoPushPermission = null;
    public static final LiveWrappedWTNPushStateChangeReason PushSuccess = null;
    public static final LiveWrappedWTNPushStateChangeReason RetryFail = null;
    public static final LiveWrappedWTNPushStateChangeReason StartPush = null;
    public static final LiveWrappedWTNPushStateChangeReason StopPush = null;
    public static final LiveWrappedWTNPushStateChangeReason StreamPushByOther = null;
    public static final /* synthetic */ LiveWrappedWTNPushStateChangeReason[] a = null;
    private int value;

    public static LiveWrappedWTNPushStateChangeReason valueOf(String r1) {
        return (LiveWrappedWTNPushStateChangeReason) r27.a.a(LiveWrappedWTNPushStateChangeReason.class, r1);
    }

    public static LiveWrappedWTNPushStateChangeReason[] values() {
        return (LiveWrappedWTNPushStateChangeReason[]) a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedWTNPushStateChangeReason$a] */
    static {
        LiveWrappedWTNPushStateChangeReason r1 = new LiveWrappedWTNPushStateChangeReason("PushSuccess", 0, 0);
        PushSuccess = r1;
        LiveWrappedWTNPushStateChangeReason r2 = new LiveWrappedWTNPushStateChangeReason("StartPush", 1, 1);
        StartPush = r2;
        LiveWrappedWTNPushStateChangeReason r3 = new LiveWrappedWTNPushStateChangeReason("StopPush", 2, 2);
        StopPush = r3;
        LiveWrappedWTNPushStateChangeReason r4 = new LiveWrappedWTNPushStateChangeReason("InRetry", 3, 3);
        InRetry = r4;
        LiveWrappedWTNPushStateChangeReason r5 = new LiveWrappedWTNPushStateChangeReason("RetryFail", 4, 4);
        RetryFail = r5;
        LiveWrappedWTNPushStateChangeReason r6 = new LiveWrappedWTNPushStateChangeReason("NoPushPermission", 5, 5);
        NoPushPermission = r6;
        LiveWrappedWTNPushStateChangeReason r7 = new LiveWrappedWTNPushStateChangeReason("StreamPushByOther", 6, 6);
        StreamPushByOther = r7;
        LiveWrappedWTNPushStateChangeReason r8 = new LiveWrappedWTNPushStateChangeReason("Internal", 7, 7);
        Internal = r8;
        a = new LiveWrappedWTNPushStateChangeReason[]{r1, r2, r3, r4, r5, r6, r7, r8};
        Companion = new a();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(y0.a[ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return "kWTNPushStateChangeReasonInternal";
    L6:
        return "kWTNPushStateChangeReasonStreamPushByOther";
    L7:
        return "kWTNPushStateChangeReasonNoPushPermission";
    L8:
        return "kWTNPushStateChangeReasonRetryFail";
    L9:
        return "kWTNPushStateChangeReasonInRetry";
    L10:
        return "kWTNPushStateChangeReasonStopPush";
    L11:
        return "kWTNPushStateChangeReasonStartPush";
    L12:
        return "kWTNPushStateChangeReasonPushSuccess";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedWTNPushStateChangeReason(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
