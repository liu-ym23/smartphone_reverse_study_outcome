package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nJ\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedNetworkDetectionStopReason;", "", "", "value", "I", "getValue", "()I", "setValue", "(I)V", "Companion", "a", "USER", "TIMEOUT", "CONNECTION_LOST", "STREAMING", "INNER_ERR", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedNetworkDetectionStopReason extends Enum<LiveWrappedNetworkDetectionStopReason> {
    public static final LiveWrappedNetworkDetectionStopReason CONNECTION_LOST = null;
    public static final a Companion = null;
    public static final LiveWrappedNetworkDetectionStopReason INNER_ERR = null;
    public static final LiveWrappedNetworkDetectionStopReason STREAMING = null;
    public static final LiveWrappedNetworkDetectionStopReason TIMEOUT = null;
    public static final LiveWrappedNetworkDetectionStopReason USER = null;
    public static final /* synthetic */ LiveWrappedNetworkDetectionStopReason[] a = null;
    private int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedNetworkDetectionStopReason$a] */
    static {
        LiveWrappedNetworkDetectionStopReason r1 = new LiveWrappedNetworkDetectionStopReason("USER", 0, 0);
        USER = r1;
        LiveWrappedNetworkDetectionStopReason r2 = new LiveWrappedNetworkDetectionStopReason("TIMEOUT", 1, 1);
        TIMEOUT = r2;
        LiveWrappedNetworkDetectionStopReason r3 = new LiveWrappedNetworkDetectionStopReason("CONNECTION_LOST", 2, 2);
        CONNECTION_LOST = r3;
        LiveWrappedNetworkDetectionStopReason r4 = new LiveWrappedNetworkDetectionStopReason("STREAMING", 3, 3);
        STREAMING = r4;
        LiveWrappedNetworkDetectionStopReason r5 = new LiveWrappedNetworkDetectionStopReason("INNER_ERR", 4, 4);
        INNER_ERR = r5;
        a = new LiveWrappedNetworkDetectionStopReason[]{r1, r2, r3, r4, r5};
        Companion = new a();
    }

    public static LiveWrappedNetworkDetectionStopReason valueOf(String r1) {
        return (LiveWrappedNetworkDetectionStopReason) r27.a.a(LiveWrappedNetworkDetectionStopReason.class, r1);
    }

    public static LiveWrappedNetworkDetectionStopReason[] values() {
        return (LiveWrappedNetworkDetectionStopReason[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public final int value() {
        return this.value;
    }

    public final void setValue(int r1) {
        this.value = r1;
    }

    public LiveWrappedNetworkDetectionStopReason(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
