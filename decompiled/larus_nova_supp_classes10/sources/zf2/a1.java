package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedWTNRemoteAudioStateChangeReason;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class a1 {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LiveWrappedWTNRemoteAudioStateChangeReason.values().length];
        a = r0;
        r0[LiveWrappedWTNRemoteAudioStateChangeReason.Internal.ordinal()] = 1;
        r0[LiveWrappedWTNRemoteAudioStateChangeReason.NetworkCongestion.ordinal()] = 2;
        r0[LiveWrappedWTNRemoteAudioStateChangeReason.NetworkRecovery.ordinal()] = 3;
        r0[LiveWrappedWTNRemoteAudioStateChangeReason.LocalUnmute.ordinal()] = 4;
        r0[LiveWrappedWTNRemoteAudioStateChangeReason.LocalMute.ordinal()] = 5;
        r0[LiveWrappedWTNRemoteAudioStateChangeReason.RemoteStart.ordinal()] = 6;
        r0[LiveWrappedWTNRemoteAudioStateChangeReason.RemoteStop.ordinal()] = 7;
    }
}
