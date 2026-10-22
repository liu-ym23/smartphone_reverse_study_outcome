package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedLocalAudioStreamState;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f571746a = null;

    static {
        int[] r100 = new int[LiveWrappedLocalAudioStreamState.values().length];
        f571746a = r100;
        r100[LiveWrappedLocalAudioStreamState.LOCAL_AUDIO_STREAM_STATE_STOPPED.ordinal()] = 1;
        r100[LiveWrappedLocalAudioStreamState.LOCAL_AUDIO_STREAM_STATE_RECORDING.ordinal()] = 2;
        r100[LiveWrappedLocalAudioStreamState.LOCAL_AUDIO_STREAM_STATE_ENCODING.ordinal()] = 3;
        r100[LiveWrappedLocalAudioStreamState.LOCAL_AUDIO_STREAM_STATE_FAILED.ordinal()] = 4;
    }
}
