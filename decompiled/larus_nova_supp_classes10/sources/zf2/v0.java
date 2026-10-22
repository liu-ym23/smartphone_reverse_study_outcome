package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedWTNPlayState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class v0 {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LiveWrappedWTNPlayState.values().length];
        a = r0;
        r0[LiveWrappedWTNPlayState.Init.ordinal()] = 1;
        r0[LiveWrappedWTNPlayState.Start.ordinal()] = 2;
        r0[LiveWrappedWTNPlayState.Success.ordinal()] = 3;
        r0[LiveWrappedWTNPlayState.Stop.ordinal()] = 4;
        r0[LiveWrappedWTNPlayState.Failed.ordinal()] = 5;
    }
}
