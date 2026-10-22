package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedWTNPushState;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f571751a = null;

    static {
        int[] r100 = new int[LiveWrappedWTNPushState.values().length];
        f571751a = r100;
        r100[LiveWrappedWTNPushState.Init.ordinal()] = 1;
        r100[LiveWrappedWTNPushState.Start.ordinal()] = 2;
        r100[LiveWrappedWTNPushState.Success.ordinal()] = 3;
        r100[LiveWrappedWTNPushState.Stop.ordinal()] = 4;
        r100[LiveWrappedWTNPushState.Failed.ordinal()] = 5;
    }
}
