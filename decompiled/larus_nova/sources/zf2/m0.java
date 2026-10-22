package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedSimulcastStreamType;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f571734a = null;

    static {
        int[] r100 = new int[LiveWrappedSimulcastStreamType.values().length];
        f571734a = r100;
        r100[LiveWrappedSimulcastStreamType.SIMULCAST_STREAM_TYPE_WEAK.ordinal()] = 1;
        r100[LiveWrappedSimulcastStreamType.SIMULCAST_STREAM_TYPE_LOW.ordinal()] = 2;
        r100[LiveWrappedSimulcastStreamType.SIMULCAST_STREAM_TYPE_MID.ordinal()] = 3;
        r100[LiveWrappedSimulcastStreamType.SIMULCAST_STREAM_TYPE_HIGH.ordinal()] = 4;
    }
}
