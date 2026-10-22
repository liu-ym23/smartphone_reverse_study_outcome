package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioChannel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class c {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LiveWrappedAudioChannel.values().length];
        a = r0;
        r0[LiveWrappedAudioChannel.AUDIO_CHANNEL_AUTO.ordinal()] = 1;
        r0[LiveWrappedAudioChannel.AUDIO_CHANNEL_MONO.ordinal()] = 2;
        r0[LiveWrappedAudioChannel.AUDIO_CHANNEL_STEREO.ordinal()] = 3;
    }
}
