package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import kotlin.Metadata;
import zf2.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedWTNPlayStateChangeReason;", "", "", "value", "", "toString", "I", "Companion", "a", "PlaySuccess", "StartPlay", "StopPlay", "RemoteStop", "RemoteFailure", "StreamBanned", "NoPlayPermission", "StreamNotExist", "InRetry", "RetryFail", "Internal", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedWTNPlayStateChangeReason extends Enum<LiveWrappedWTNPlayStateChangeReason> {
    public static final a Companion = null;
    public static final LiveWrappedWTNPlayStateChangeReason InRetry = null;
    public static final LiveWrappedWTNPlayStateChangeReason Internal = null;
    public static final LiveWrappedWTNPlayStateChangeReason NoPlayPermission = null;
    public static final LiveWrappedWTNPlayStateChangeReason PlaySuccess = null;
    public static final LiveWrappedWTNPlayStateChangeReason RemoteFailure = null;
    public static final LiveWrappedWTNPlayStateChangeReason RemoteStop = null;
    public static final LiveWrappedWTNPlayStateChangeReason RetryFail = null;
    public static final LiveWrappedWTNPlayStateChangeReason StartPlay = null;
    public static final LiveWrappedWTNPlayStateChangeReason StopPlay = null;
    public static final LiveWrappedWTNPlayStateChangeReason StreamBanned = null;
    public static final LiveWrappedWTNPlayStateChangeReason StreamNotExist = null;
    public static final /* synthetic */ LiveWrappedWTNPlayStateChangeReason[] a = null;
    private int value;

    public static LiveWrappedWTNPlayStateChangeReason valueOf(String r1) {
        return (LiveWrappedWTNPlayStateChangeReason) r27.a.a(LiveWrappedWTNPlayStateChangeReason.class, r1);
    }

    public static LiveWrappedWTNPlayStateChangeReason[] values() {
        return (LiveWrappedWTNPlayStateChangeReason[]) a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedWTNPlayStateChangeReason$a] */
    static {
        LiveWrappedWTNPlayStateChangeReason r1 = new LiveWrappedWTNPlayStateChangeReason("PlaySuccess", 0, 0);
        PlaySuccess = r1;
        LiveWrappedWTNPlayStateChangeReason r2 = new LiveWrappedWTNPlayStateChangeReason("StartPlay", 1, 1);
        StartPlay = r2;
        LiveWrappedWTNPlayStateChangeReason r3 = new LiveWrappedWTNPlayStateChangeReason("StopPlay", 2, 2);
        StopPlay = r3;
        LiveWrappedWTNPlayStateChangeReason r4 = new LiveWrappedWTNPlayStateChangeReason("RemoteStop", 3, 3);
        RemoteStop = r4;
        LiveWrappedWTNPlayStateChangeReason r5 = new LiveWrappedWTNPlayStateChangeReason("RemoteFailure", 4, 4);
        RemoteFailure = r5;
        LiveWrappedWTNPlayStateChangeReason r6 = new LiveWrappedWTNPlayStateChangeReason("StreamBanned", 5, 5);
        StreamBanned = r6;
        LiveWrappedWTNPlayStateChangeReason r7 = new LiveWrappedWTNPlayStateChangeReason("NoPlayPermission", 6, 6);
        NoPlayPermission = r7;
        LiveWrappedWTNPlayStateChangeReason r8 = new LiveWrappedWTNPlayStateChangeReason("StreamNotExist", 7, 7);
        StreamNotExist = r8;
        LiveWrappedWTNPlayStateChangeReason r9 = new LiveWrappedWTNPlayStateChangeReason("InRetry", 8, 8);
        InRetry = r9;
        LiveWrappedWTNPlayStateChangeReason r10 = new LiveWrappedWTNPlayStateChangeReason("RetryFail", 9, 9);
        RetryFail = r10;
        LiveWrappedWTNPlayStateChangeReason r11 = new LiveWrappedWTNPlayStateChangeReason("Internal", 10, 10);
        Internal = r11;
        a = new LiveWrappedWTNPlayStateChangeReason[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11};
        Companion = new a();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(w0.a[ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L6;
            case 11: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return "kWTNPlayStateChangeReasonInternal";
    L6:
        return "kWTNPlayStateChangeReasonRetryFail";
    L7:
        return "kWTNPlayStateChangeReasonInRetry";
    L8:
        return "kWTNPlayStateChangeReasonStreamNotExist";
    L9:
        return "kWTNPlayStateChangeReasonNoPlayPermission";
    L10:
        return "kWTNPlayStateChangeReasonStreamBanned";
    L11:
        return "kWTNPlayStateChangeReasonRemoteFailure";
    L12:
        return "kWTNPlayStateChangeReasonRemoteStop";
    L13:
        return "kWTNPlayStateChangeReasonStopPlay";
    L14:
        return "kWTNPlayStateChangeReasonStartPlay";
    L15:
        return "kWTNPlayStateChangeReasonPlaySuccess";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedWTNPlayStateChangeReason(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
