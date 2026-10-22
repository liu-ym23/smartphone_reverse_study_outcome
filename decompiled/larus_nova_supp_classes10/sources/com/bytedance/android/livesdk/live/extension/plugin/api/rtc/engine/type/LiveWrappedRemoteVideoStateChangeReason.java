package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedRemoteVideoStateChangeReason;", "", "", "value", "I", "Companion", "a", "REMOTE_VIDEO_STATE_CHANGE_REASON_INTERNAL", "REMOTE_VIDEO_STATE_CHANGE_REASON_NETWORK_CONGESTION", "REMOTE_VIDEO_STATE_CHANGE_REASON_NETWORK_RECOVERY", "REMOTE_VIDEO_STATE_CHANGE_REASON_LOCAL_MUTED", "REMOTE_VIDEO_STATE_CHANGE_REASON_LOCAL_UNMUTED", "REMOTE_VIDEO_STATE_CHANGE_REASON_REMOTE_MUTED", "REMOTE_VIDEO_STATE_CHANGE_REASON_REMOTE_UNMUTED", "REMOTE_VIDEO_STATE_CHANGE_REASON_REMOTE_OFFLINE", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedRemoteVideoStateChangeReason extends Enum<LiveWrappedRemoteVideoStateChangeReason> {
    public static final a Companion = null;
    public static final LiveWrappedRemoteVideoStateChangeReason REMOTE_VIDEO_STATE_CHANGE_REASON_INTERNAL = null;
    public static final LiveWrappedRemoteVideoStateChangeReason REMOTE_VIDEO_STATE_CHANGE_REASON_LOCAL_MUTED = null;
    public static final LiveWrappedRemoteVideoStateChangeReason REMOTE_VIDEO_STATE_CHANGE_REASON_LOCAL_UNMUTED = null;
    public static final LiveWrappedRemoteVideoStateChangeReason REMOTE_VIDEO_STATE_CHANGE_REASON_NETWORK_CONGESTION = null;
    public static final LiveWrappedRemoteVideoStateChangeReason REMOTE_VIDEO_STATE_CHANGE_REASON_NETWORK_RECOVERY = null;
    public static final LiveWrappedRemoteVideoStateChangeReason REMOTE_VIDEO_STATE_CHANGE_REASON_REMOTE_MUTED = null;
    public static final LiveWrappedRemoteVideoStateChangeReason REMOTE_VIDEO_STATE_CHANGE_REASON_REMOTE_OFFLINE = null;
    public static final LiveWrappedRemoteVideoStateChangeReason REMOTE_VIDEO_STATE_CHANGE_REASON_REMOTE_UNMUTED = null;
    public static final /* synthetic */ LiveWrappedRemoteVideoStateChangeReason[] a = null;
    private int value;

    public static LiveWrappedRemoteVideoStateChangeReason valueOf(String r1) {
        return (LiveWrappedRemoteVideoStateChangeReason) r27.a.a(LiveWrappedRemoteVideoStateChangeReason.class, r1);
    }

    public static LiveWrappedRemoteVideoStateChangeReason[] values() {
        return (LiveWrappedRemoteVideoStateChangeReason[]) a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedRemoteVideoStateChangeReason$a] */
    static {
        LiveWrappedRemoteVideoStateChangeReason r1 = new LiveWrappedRemoteVideoStateChangeReason("REMOTE_VIDEO_STATE_CHANGE_REASON_INTERNAL", 0, 0);
        REMOTE_VIDEO_STATE_CHANGE_REASON_INTERNAL = r1;
        LiveWrappedRemoteVideoStateChangeReason r2 = new LiveWrappedRemoteVideoStateChangeReason("REMOTE_VIDEO_STATE_CHANGE_REASON_NETWORK_CONGESTION", 1, 1);
        REMOTE_VIDEO_STATE_CHANGE_REASON_NETWORK_CONGESTION = r2;
        LiveWrappedRemoteVideoStateChangeReason r3 = new LiveWrappedRemoteVideoStateChangeReason("REMOTE_VIDEO_STATE_CHANGE_REASON_NETWORK_RECOVERY", 2, 2);
        REMOTE_VIDEO_STATE_CHANGE_REASON_NETWORK_RECOVERY = r3;
        LiveWrappedRemoteVideoStateChangeReason r4 = new LiveWrappedRemoteVideoStateChangeReason("REMOTE_VIDEO_STATE_CHANGE_REASON_LOCAL_MUTED", 3, 3);
        REMOTE_VIDEO_STATE_CHANGE_REASON_LOCAL_MUTED = r4;
        LiveWrappedRemoteVideoStateChangeReason r5 = new LiveWrappedRemoteVideoStateChangeReason("REMOTE_VIDEO_STATE_CHANGE_REASON_LOCAL_UNMUTED", 4, 4);
        REMOTE_VIDEO_STATE_CHANGE_REASON_LOCAL_UNMUTED = r5;
        LiveWrappedRemoteVideoStateChangeReason r6 = new LiveWrappedRemoteVideoStateChangeReason("REMOTE_VIDEO_STATE_CHANGE_REASON_REMOTE_MUTED", 5, 5);
        REMOTE_VIDEO_STATE_CHANGE_REASON_REMOTE_MUTED = r6;
        LiveWrappedRemoteVideoStateChangeReason r7 = new LiveWrappedRemoteVideoStateChangeReason("REMOTE_VIDEO_STATE_CHANGE_REASON_REMOTE_UNMUTED", 6, 6);
        REMOTE_VIDEO_STATE_CHANGE_REASON_REMOTE_UNMUTED = r7;
        LiveWrappedRemoteVideoStateChangeReason r8 = new LiveWrappedRemoteVideoStateChangeReason("REMOTE_VIDEO_STATE_CHANGE_REASON_REMOTE_OFFLINE", 7, 7);
        REMOTE_VIDEO_STATE_CHANGE_REASON_REMOTE_OFFLINE = r8;
        a = new LiveWrappedRemoteVideoStateChangeReason[]{r1, r2, r3, r4, r5, r6, r7, r8};
        Companion = new a();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedRemoteVideoStateChangeReason(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
