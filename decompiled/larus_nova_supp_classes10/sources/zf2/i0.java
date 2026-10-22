package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedRemoteAudioState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class i0 {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LiveWrappedRemoteAudioState.values().length];
        a = r0;
        r0[LiveWrappedRemoteAudioState.REMOTE_AUDIO_STATE_STOPPED.ordinal()] = 1;
        r0[LiveWrappedRemoteAudioState.REMOTE_AUDIO_STATE_STARTING.ordinal()] = 2;
        r0[LiveWrappedRemoteAudioState.REMOTE_AUDIO_STATE_DECODING.ordinal()] = 3;
        r0[LiveWrappedRemoteAudioState.REMOTE_AUDIO_STATE_FROZEN.ordinal()] = 4;
        r0[LiveWrappedRemoteAudioState.REMOTE_AUDIO_STATE_FAILED.ordinal()] = 5;
    }
}
