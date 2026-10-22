package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import kotlin.Metadata;
import zf2.j0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedRemoteAudioStateChangeReason;", "", "", "value", "", "toString", "I", "Companion", "a", "REMOTE_AUDIO_STATE_CHANGE_REASON_INTERNAL", "REMOTE_AUDIO_STATE_CHANGE_REASON_NETWORK_CONGESTION", "REMOTE_AUDIO_STATE_CHANGE_REASON_NETWORK_RECOVERY", "REMOTE_AUDIO_STATE_CHANGE_REASON_LOCAL_MUTED", "REMOTE_AUDIO_STATE_CHANGE_REASON_LOCAL_UNMUTED", "REMOTE_AUDIO_STATE_CHANGE_REASON_REMOTE_MUTED", "REMOTE_AUDIO_STATE_CHANGE_REASON_REMOTE_UNMUTED", "REMOTE_AUDIO_STATE_CHANGE_REASON_REMOTE_OFFLINE", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedRemoteAudioStateChangeReason extends Enum<LiveWrappedRemoteAudioStateChangeReason> {
    public static final a Companion = null;
    public static final LiveWrappedRemoteAudioStateChangeReason REMOTE_AUDIO_STATE_CHANGE_REASON_INTERNAL = null;
    public static final LiveWrappedRemoteAudioStateChangeReason REMOTE_AUDIO_STATE_CHANGE_REASON_LOCAL_MUTED = null;
    public static final LiveWrappedRemoteAudioStateChangeReason REMOTE_AUDIO_STATE_CHANGE_REASON_LOCAL_UNMUTED = null;
    public static final LiveWrappedRemoteAudioStateChangeReason REMOTE_AUDIO_STATE_CHANGE_REASON_NETWORK_CONGESTION = null;
    public static final LiveWrappedRemoteAudioStateChangeReason REMOTE_AUDIO_STATE_CHANGE_REASON_NETWORK_RECOVERY = null;
    public static final LiveWrappedRemoteAudioStateChangeReason REMOTE_AUDIO_STATE_CHANGE_REASON_REMOTE_MUTED = null;
    public static final LiveWrappedRemoteAudioStateChangeReason REMOTE_AUDIO_STATE_CHANGE_REASON_REMOTE_OFFLINE = null;
    public static final LiveWrappedRemoteAudioStateChangeReason REMOTE_AUDIO_STATE_CHANGE_REASON_REMOTE_UNMUTED = null;
    public static final /* synthetic */ LiveWrappedRemoteAudioStateChangeReason[] a = null;
    private int value;

    public static LiveWrappedRemoteAudioStateChangeReason valueOf(String r1) {
        return (LiveWrappedRemoteAudioStateChangeReason) r27.a.a(LiveWrappedRemoteAudioStateChangeReason.class, r1);
    }

    public static LiveWrappedRemoteAudioStateChangeReason[] values() {
        return (LiveWrappedRemoteAudioStateChangeReason[]) a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedRemoteAudioStateChangeReason$a] */
    static {
        LiveWrappedRemoteAudioStateChangeReason r1 = new LiveWrappedRemoteAudioStateChangeReason("REMOTE_AUDIO_STATE_CHANGE_REASON_INTERNAL", 0, 0);
        REMOTE_AUDIO_STATE_CHANGE_REASON_INTERNAL = r1;
        LiveWrappedRemoteAudioStateChangeReason r2 = new LiveWrappedRemoteAudioStateChangeReason("REMOTE_AUDIO_STATE_CHANGE_REASON_NETWORK_CONGESTION", 1, 1);
        REMOTE_AUDIO_STATE_CHANGE_REASON_NETWORK_CONGESTION = r2;
        LiveWrappedRemoteAudioStateChangeReason r3 = new LiveWrappedRemoteAudioStateChangeReason("REMOTE_AUDIO_STATE_CHANGE_REASON_NETWORK_RECOVERY", 2, 2);
        REMOTE_AUDIO_STATE_CHANGE_REASON_NETWORK_RECOVERY = r3;
        LiveWrappedRemoteAudioStateChangeReason r4 = new LiveWrappedRemoteAudioStateChangeReason("REMOTE_AUDIO_STATE_CHANGE_REASON_LOCAL_MUTED", 3, 3);
        REMOTE_AUDIO_STATE_CHANGE_REASON_LOCAL_MUTED = r4;
        LiveWrappedRemoteAudioStateChangeReason r5 = new LiveWrappedRemoteAudioStateChangeReason("REMOTE_AUDIO_STATE_CHANGE_REASON_LOCAL_UNMUTED", 4, 4);
        REMOTE_AUDIO_STATE_CHANGE_REASON_LOCAL_UNMUTED = r5;
        LiveWrappedRemoteAudioStateChangeReason r6 = new LiveWrappedRemoteAudioStateChangeReason("REMOTE_AUDIO_STATE_CHANGE_REASON_REMOTE_MUTED", 5, 5);
        REMOTE_AUDIO_STATE_CHANGE_REASON_REMOTE_MUTED = r6;
        LiveWrappedRemoteAudioStateChangeReason r7 = new LiveWrappedRemoteAudioStateChangeReason("REMOTE_AUDIO_STATE_CHANGE_REASON_REMOTE_UNMUTED", 6, 6);
        REMOTE_AUDIO_STATE_CHANGE_REASON_REMOTE_UNMUTED = r7;
        LiveWrappedRemoteAudioStateChangeReason r8 = new LiveWrappedRemoteAudioStateChangeReason("REMOTE_AUDIO_STATE_CHANGE_REASON_REMOTE_OFFLINE", 7, 7);
        REMOTE_AUDIO_STATE_CHANGE_REASON_REMOTE_OFFLINE = r8;
        a = new LiveWrappedRemoteAudioStateChangeReason[]{r1, r2, r3, r4, r5, r6, r7, r8};
        Companion = new a();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(j0.a[ordinal()]) {
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
        return "kRemoteAudioReasonRemoteOffline";
    L6:
        return "kRemoteAudioReasonRemoteUnmuted";
    L7:
        return "kRemoteAudioReasonRemoteMuted";
    L8:
        return "kRemoteAudioReasonLocalUnmuted";
    L9:
        return "kRemoteAudioReasonLocalMuted";
    L10:
        return "kRemoteAudioReasonNetworkRecovery";
    L11:
        return "kRemoteAudioReasonNetworkCongestion";
    L12:
        return "kRemoteAudioReasonInternal";
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedRemoteAudioStateChangeReason(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
