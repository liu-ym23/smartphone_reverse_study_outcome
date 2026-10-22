package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedWTNPushState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class x0 {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LiveWrappedWTNPushState.values().length];
        a = r0;
        r0[LiveWrappedWTNPushState.Init.ordinal()] = 1;
        r0[LiveWrappedWTNPushState.Start.ordinal()] = 2;
        r0[LiveWrappedWTNPushState.Success.ordinal()] = 3;
        r0[LiveWrappedWTNPushState.Stop.ordinal()] = 4;
        r0[LiveWrappedWTNPushState.Failed.ordinal()] = 5;
    }
}
