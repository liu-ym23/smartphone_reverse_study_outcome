package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioProcessorMethod;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f571717a = null;

    static {
        int[] r100 = new int[LiveWrappedAudioProcessorMethod.values().length];
        f571717a = r100;
        r100[LiveWrappedAudioProcessorMethod.AUDIO_FRAME_PROCESSOR_RECORD.ordinal()] = 1;
        r100[LiveWrappedAudioProcessorMethod.AUDIO_FRAME_PROCESSOR_PLAYBACK.ordinal()] = 2;
        r100[LiveWrappedAudioProcessorMethod.AUDIO_FRAME_PROCESSOR_REMOTE_USER.ordinal()] = 3;
        r100[LiveWrappedAudioProcessorMethod.AUDIO_FRAME_PROCESSOR_EAR_MONITOR.ordinal()] = 4;
        r100[LiveWrappedAudioProcessorMethod.AUDIO_FRAME_PROCESSOR_SCREEN.ordinal()] = 5;
    }
}
