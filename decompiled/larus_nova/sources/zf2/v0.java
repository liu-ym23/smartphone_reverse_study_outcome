package zf2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedWTNPlayState;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f571747a = null;

    static {
        int[] r100 = new int[LiveWrappedWTNPlayState.values().length];
        f571747a = r100;
        r100[LiveWrappedWTNPlayState.Init.ordinal()] = 1;
        r100[LiveWrappedWTNPlayState.Start.ordinal()] = 2;
        r100[LiveWrappedWTNPlayState.Success.ordinal()] = 3;
        r100[LiveWrappedWTNPlayState.Stop.ordinal()] = 4;
        r100[LiveWrappedWTNPlayState.Failed.ordinal()] = 5;
    }
}
