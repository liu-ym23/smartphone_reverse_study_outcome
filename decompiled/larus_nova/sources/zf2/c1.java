package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedWTNRemoteVideoStateChangeReason;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f571698a = null;

    static {
        int[] r100 = new int[LiveWrappedWTNRemoteVideoStateChangeReason.values().length];
        f571698a = r100;
        r100[LiveWrappedWTNRemoteVideoStateChangeReason.Internal.ordinal()] = 1;
        r100[LiveWrappedWTNRemoteVideoStateChangeReason.NetworkCongestion.ordinal()] = 2;
        r100[LiveWrappedWTNRemoteVideoStateChangeReason.NetworkRecovery.ordinal()] = 3;
        r100[LiveWrappedWTNRemoteVideoStateChangeReason.LocalUnmute.ordinal()] = 4;
        r100[LiveWrappedWTNRemoteVideoStateChangeReason.LocalMute.ordinal()] = 5;
        r100[LiveWrappedWTNRemoteVideoStateChangeReason.RemoteStart.ordinal()] = 6;
        r100[LiveWrappedWTNRemoteVideoStateChangeReason.RemoteStop.ordinal()] = 7;
    }
}
