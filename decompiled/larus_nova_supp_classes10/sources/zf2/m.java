package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioRoute;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class m {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LiveWrappedAudioRoute.values().length];
        a = r0;
        r0[LiveWrappedAudioRoute.AUDIO_ROUTE_DEFAULT.ordinal()] = 1;
        r0[LiveWrappedAudioRoute.AUDIO_ROUTE_EARPIECE.ordinal()] = 2;
        r0[LiveWrappedAudioRoute.AUDIO_ROUTE_SPEAKERPHONE.ordinal()] = 3;
        r0[LiveWrappedAudioRoute.AUDIO_ROUTE_HEADSET.ordinal()] = 4;
        r0[LiveWrappedAudioRoute.AUDIO_ROUTE_HEADSET_USB.ordinal()] = 5;
        r0[LiveWrappedAudioRoute.AUDIO_ROUTE_HEADSET_BLUETOOTH.ordinal()] = 6;
    }
}
