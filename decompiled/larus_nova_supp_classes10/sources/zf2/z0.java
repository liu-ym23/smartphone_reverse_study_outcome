package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedWTNRemoteAudioState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class z0 {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LiveWrappedWTNRemoteAudioState.values().length];
        a = r0;
        r0[LiveWrappedWTNRemoteAudioState.Stoped.ordinal()] = 1;
        r0[LiveWrappedWTNRemoteAudioState.Starting.ordinal()] = 2;
        r0[LiveWrappedWTNRemoteAudioState.Decoding.ordinal()] = 3;
        r0[LiveWrappedWTNRemoteAudioState.Frozen.ordinal()] = 4;
        r0[LiveWrappedWTNRemoteAudioState.Failed.ordinal()] = 5;
    }
}
