package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedWTNRemoteAudioStateChangeReason;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f571692a = null;

    static {
        int[] r100 = new int[LiveWrappedWTNRemoteAudioStateChangeReason.values().length];
        f571692a = r100;
        r100[LiveWrappedWTNRemoteAudioStateChangeReason.Internal.ordinal()] = 1;
        r100[LiveWrappedWTNRemoteAudioStateChangeReason.NetworkCongestion.ordinal()] = 2;
        r100[LiveWrappedWTNRemoteAudioStateChangeReason.NetworkRecovery.ordinal()] = 3;
        r100[LiveWrappedWTNRemoteAudioStateChangeReason.LocalUnmute.ordinal()] = 4;
        r100[LiveWrappedWTNRemoteAudioStateChangeReason.LocalMute.ordinal()] = 5;
        r100[LiveWrappedWTNRemoteAudioStateChangeReason.RemoteStart.ordinal()] = 6;
        r100[LiveWrappedWTNRemoteAudioStateChangeReason.RemoteStop.ordinal()] = 7;
    }
}
