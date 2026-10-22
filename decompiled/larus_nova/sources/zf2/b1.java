package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedWTNRemoteVideoState;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f571695a = null;

    static {
        int[] r100 = new int[LiveWrappedWTNRemoteVideoState.values().length];
        f571695a = r100;
        r100[LiveWrappedWTNRemoteVideoState.Stoped.ordinal()] = 1;
        r100[LiveWrappedWTNRemoteVideoState.Starting.ordinal()] = 2;
        r100[LiveWrappedWTNRemoteVideoState.Decoding.ordinal()] = 3;
        r100[LiveWrappedWTNRemoteVideoState.Frozen.ordinal()] = 4;
        r100[LiveWrappedWTNRemoteVideoState.Failed.ordinal()] = 5;
    }
}
