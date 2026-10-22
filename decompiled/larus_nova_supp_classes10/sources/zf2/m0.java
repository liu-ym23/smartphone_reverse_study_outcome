package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedSimulcastStreamType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class m0 {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LiveWrappedSimulcastStreamType.values().length];
        a = r0;
        r0[LiveWrappedSimulcastStreamType.SIMULCAST_STREAM_TYPE_WEAK.ordinal()] = 1;
        r0[LiveWrappedSimulcastStreamType.SIMULCAST_STREAM_TYPE_LOW.ordinal()] = 2;
        r0[LiveWrappedSimulcastStreamType.SIMULCAST_STREAM_TYPE_MID.ordinal()] = 3;
        r0[LiveWrappedSimulcastStreamType.SIMULCAST_STREAM_TYPE_HIGH.ordinal()] = 4;
    }
}
