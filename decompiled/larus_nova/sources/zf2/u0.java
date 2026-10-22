package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoSimulcastMode;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f571745a = null;

    static {
        int[] r100 = new int[LiveWrappedVideoSimulcastMode.values().length];
        f571745a = r100;
        r100[LiveWrappedVideoSimulcastMode.VIDEO_SIMULCAST_MODE_ONLY_ONE.ordinal()] = 1;
        r100[LiveWrappedVideoSimulcastMode.VIDEO_SIMULCAST_MODE_ON_DEMAND.ordinal()] = 2;
        r100[LiveWrappedVideoSimulcastMode.VIDEO_SIMULCAST_MODE_ALWAYS_SIMULCAST.ordinal()] = 3;
    }
}
