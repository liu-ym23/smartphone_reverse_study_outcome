package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedWTNRemoteVideoStateChangeReason;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class c1 {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LiveWrappedWTNRemoteVideoStateChangeReason.values().length];
        a = r0;
        r0[LiveWrappedWTNRemoteVideoStateChangeReason.Internal.ordinal()] = 1;
        r0[LiveWrappedWTNRemoteVideoStateChangeReason.NetworkCongestion.ordinal()] = 2;
        r0[LiveWrappedWTNRemoteVideoStateChangeReason.NetworkRecovery.ordinal()] = 3;
        r0[LiveWrappedWTNRemoteVideoStateChangeReason.LocalUnmute.ordinal()] = 4;
        r0[LiveWrappedWTNRemoteVideoStateChangeReason.LocalMute.ordinal()] = 5;
        r0[LiveWrappedWTNRemoteVideoStateChangeReason.RemoteStart.ordinal()] = 6;
        r0[LiveWrappedWTNRemoteVideoStateChangeReason.RemoteStop.ordinal()] = 7;
    }
}
