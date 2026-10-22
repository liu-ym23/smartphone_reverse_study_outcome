package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedWTNRemoteAudioState;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f571754a = null;

    static {
        int[] r100 = new int[LiveWrappedWTNRemoteAudioState.values().length];
        f571754a = r100;
        r100[LiveWrappedWTNRemoteAudioState.Stoped.ordinal()] = 1;
        r100[LiveWrappedWTNRemoteAudioState.Starting.ordinal()] = 2;
        r100[LiveWrappedWTNRemoteAudioState.Decoding.ordinal()] = 3;
        r100[LiveWrappedWTNRemoteAudioState.Frozen.ordinal()] = 4;
        r100[LiveWrappedWTNRemoteAudioState.Failed.ordinal()] = 5;
    }
}
