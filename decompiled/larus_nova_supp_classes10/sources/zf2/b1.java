package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedWTNRemoteVideoState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class b1 {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LiveWrappedWTNRemoteVideoState.values().length];
        a = r0;
        r0[LiveWrappedWTNRemoteVideoState.Stoped.ordinal()] = 1;
        r0[LiveWrappedWTNRemoteVideoState.Starting.ordinal()] = 2;
        r0[LiveWrappedWTNRemoteVideoState.Decoding.ordinal()] = 3;
        r0[LiveWrappedWTNRemoteVideoState.Frozen.ordinal()] = 4;
        r0[LiveWrappedWTNRemoteVideoState.Failed.ordinal()] = 5;
    }
}
