package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioMixingType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class h {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LiveWrappedAudioMixingType.values().length];
        a = r0;
        r0[LiveWrappedAudioMixingType.AUDIO_MIXING_TYPE_PLAYOUT.ordinal()] = 1;
        r0[LiveWrappedAudioMixingType.AUDIO_MIXING_TYPE_PUBLISH.ordinal()] = 2;
        r0[LiveWrappedAudioMixingType.AUDIO_MIXING_TYPE_PLAYOUT_AND_PUBLISH.ordinal()] = 3;
    }
}
