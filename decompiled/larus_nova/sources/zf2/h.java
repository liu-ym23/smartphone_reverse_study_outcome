package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioMixingType;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f571716a = null;

    static {
        int[] r100 = new int[LiveWrappedAudioMixingType.values().length];
        f571716a = r100;
        r100[LiveWrappedAudioMixingType.AUDIO_MIXING_TYPE_PLAYOUT.ordinal()] = 1;
        r100[LiveWrappedAudioMixingType.AUDIO_MIXING_TYPE_PUBLISH.ordinal()] = 2;
        r100[LiveWrappedAudioMixingType.AUDIO_MIXING_TYPE_PLAYOUT_AND_PUBLISH.ordinal()] = 3;
    }
}
