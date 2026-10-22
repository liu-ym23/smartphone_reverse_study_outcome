package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedWTNPlayStateChangeReason;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class w0 {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LiveWrappedWTNPlayStateChangeReason.values().length];
        a = r0;
        r0[LiveWrappedWTNPlayStateChangeReason.PlaySuccess.ordinal()] = 1;
        r0[LiveWrappedWTNPlayStateChangeReason.StartPlay.ordinal()] = 2;
        r0[LiveWrappedWTNPlayStateChangeReason.StopPlay.ordinal()] = 3;
        r0[LiveWrappedWTNPlayStateChangeReason.RemoteStop.ordinal()] = 4;
        r0[LiveWrappedWTNPlayStateChangeReason.RemoteFailure.ordinal()] = 5;
        r0[LiveWrappedWTNPlayStateChangeReason.StreamBanned.ordinal()] = 6;
        r0[LiveWrappedWTNPlayStateChangeReason.NoPlayPermission.ordinal()] = 7;
        r0[LiveWrappedWTNPlayStateChangeReason.StreamNotExist.ordinal()] = 8;
        r0[LiveWrappedWTNPlayStateChangeReason.InRetry.ordinal()] = 9;
        r0[LiveWrappedWTNPlayStateChangeReason.RetryFail.ordinal()] = 10;
        r0[LiveWrappedWTNPlayStateChangeReason.Internal.ordinal()] = 11;
    }
}
