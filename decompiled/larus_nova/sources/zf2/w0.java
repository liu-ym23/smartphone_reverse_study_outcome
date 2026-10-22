package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedWTNPlayStateChangeReason;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f571749a = null;

    static {
        int[] r100 = new int[LiveWrappedWTNPlayStateChangeReason.values().length];
        f571749a = r100;
        r100[LiveWrappedWTNPlayStateChangeReason.PlaySuccess.ordinal()] = 1;
        r100[LiveWrappedWTNPlayStateChangeReason.StartPlay.ordinal()] = 2;
        r100[LiveWrappedWTNPlayStateChangeReason.StopPlay.ordinal()] = 3;
        r100[LiveWrappedWTNPlayStateChangeReason.RemoteStop.ordinal()] = 4;
        r100[LiveWrappedWTNPlayStateChangeReason.RemoteFailure.ordinal()] = 5;
        r100[LiveWrappedWTNPlayStateChangeReason.StreamBanned.ordinal()] = 6;
        r100[LiveWrappedWTNPlayStateChangeReason.NoPlayPermission.ordinal()] = 7;
        r100[LiveWrappedWTNPlayStateChangeReason.StreamNotExist.ordinal()] = 8;
        r100[LiveWrappedWTNPlayStateChangeReason.InRetry.ordinal()] = 9;
        r100[LiveWrappedWTNPlayStateChangeReason.RetryFail.ordinal()] = 10;
        r100[LiveWrappedWTNPlayStateChangeReason.Internal.ordinal()] = 11;
    }
}
