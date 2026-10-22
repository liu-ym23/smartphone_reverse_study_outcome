package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioChannel;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f571696a = null;

    static {
        int[] r100 = new int[LiveWrappedAudioChannel.values().length];
        f571696a = r100;
        r100[LiveWrappedAudioChannel.AUDIO_CHANNEL_AUTO.ordinal()] = 1;
        r100[LiveWrappedAudioChannel.AUDIO_CHANNEL_MONO.ordinal()] = 2;
        r100[LiveWrappedAudioChannel.AUDIO_CHANNEL_STEREO.ordinal()] = 3;
    }
}
