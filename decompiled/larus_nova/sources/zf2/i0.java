package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedRemoteAudioState;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f571718a = null;

    static {
        int[] r100 = new int[LiveWrappedRemoteAudioState.values().length];
        f571718a = r100;
        r100[LiveWrappedRemoteAudioState.REMOTE_AUDIO_STATE_STOPPED.ordinal()] = 1;
        r100[LiveWrappedRemoteAudioState.REMOTE_AUDIO_STATE_STARTING.ordinal()] = 2;
        r100[LiveWrappedRemoteAudioState.REMOTE_AUDIO_STATE_DECODING.ordinal()] = 3;
        r100[LiveWrappedRemoteAudioState.REMOTE_AUDIO_STATE_FROZEN.ordinal()] = 4;
        r100[LiveWrappedRemoteAudioState.REMOTE_AUDIO_STATE_FAILED.ordinal()] = 5;
    }
}
