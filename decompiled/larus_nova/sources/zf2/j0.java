package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedRemoteAudioStateChangeReason;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f571724a = null;

    static {
        int[] r100 = new int[LiveWrappedRemoteAudioStateChangeReason.values().length];
        f571724a = r100;
        r100[LiveWrappedRemoteAudioStateChangeReason.REMOTE_AUDIO_STATE_CHANGE_REASON_INTERNAL.ordinal()] = 1;
        r100[LiveWrappedRemoteAudioStateChangeReason.REMOTE_AUDIO_STATE_CHANGE_REASON_NETWORK_CONGESTION.ordinal()] = 2;
        r100[LiveWrappedRemoteAudioStateChangeReason.REMOTE_AUDIO_STATE_CHANGE_REASON_NETWORK_RECOVERY.ordinal()] = 3;
        r100[LiveWrappedRemoteAudioStateChangeReason.REMOTE_AUDIO_STATE_CHANGE_REASON_LOCAL_MUTED.ordinal()] = 4;
        r100[LiveWrappedRemoteAudioStateChangeReason.REMOTE_AUDIO_STATE_CHANGE_REASON_LOCAL_UNMUTED.ordinal()] = 5;
        r100[LiveWrappedRemoteAudioStateChangeReason.REMOTE_AUDIO_STATE_CHANGE_REASON_REMOTE_MUTED.ordinal()] = 6;
        r100[LiveWrappedRemoteAudioStateChangeReason.REMOTE_AUDIO_STATE_CHANGE_REASON_REMOTE_UNMUTED.ordinal()] = 7;
        r100[LiveWrappedRemoteAudioStateChangeReason.REMOTE_AUDIO_STATE_CHANGE_REASON_REMOTE_OFFLINE.ordinal()] = 8;
    }
}
