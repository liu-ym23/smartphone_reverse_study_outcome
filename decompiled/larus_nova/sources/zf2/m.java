package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioRoute;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f571733a = null;

    static {
        int[] r100 = new int[LiveWrappedAudioRoute.values().length];
        f571733a = r100;
        r100[LiveWrappedAudioRoute.AUDIO_ROUTE_DEFAULT.ordinal()] = 1;
        r100[LiveWrappedAudioRoute.AUDIO_ROUTE_EARPIECE.ordinal()] = 2;
        r100[LiveWrappedAudioRoute.AUDIO_ROUTE_SPEAKERPHONE.ordinal()] = 3;
        r100[LiveWrappedAudioRoute.AUDIO_ROUTE_HEADSET.ordinal()] = 4;
        r100[LiveWrappedAudioRoute.AUDIO_ROUTE_HEADSET_USB.ordinal()] = 5;
        r100[LiveWrappedAudioRoute.AUDIO_ROUTE_HEADSET_BLUETOOTH.ordinal()] = 6;
    }
}
