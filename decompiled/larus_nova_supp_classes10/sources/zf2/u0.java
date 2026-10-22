package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoSimulcastMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class u0 {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LiveWrappedVideoSimulcastMode.values().length];
        a = r0;
        r0[LiveWrappedVideoSimulcastMode.VIDEO_SIMULCAST_MODE_ONLY_ONE.ordinal()] = 1;
        r0[LiveWrappedVideoSimulcastMode.VIDEO_SIMULCAST_MODE_ON_DEMAND.ordinal()] = 2;
        r0[LiveWrappedVideoSimulcastMode.VIDEO_SIMULCAST_MODE_ALWAYS_SIMULCAST.ordinal()] = 3;
    }
}
