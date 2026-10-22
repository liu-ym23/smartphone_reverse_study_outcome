package uc2;

import com.bytedance.android.livesdk.interactivity.zdanmaku.layout.danmakuline.IHeatChangeController;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f549428a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f549429b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f549430c = null;

    static {
        int[] r100 = new int[IHeatChangeController.DanmakuHeat.values().length];
        f549428a = r100;
        IHeatChangeController.DanmakuHeat r101 = IHeatChangeController.DanmakuHeat.LOW;
        r100[r101.ordinal()] = 1;
        IHeatChangeController.DanmakuHeat r102 = IHeatChangeController.DanmakuHeat.MEDIUM;
        r100[r102.ordinal()] = 2;
        int[] r103 = new int[IHeatChangeController.DanmakuHeat.values().length];
        f549429b = r103;
        r103[r101.ordinal()] = 1;
        r103[r102.ordinal()] = 2;
        IHeatChangeController.DanmakuHeat r104 = IHeatChangeController.DanmakuHeat.HIGH;
        r103[r104.ordinal()] = 3;
        IHeatChangeController.DanmakuHeat r105 = IHeatChangeController.DanmakuHeat.HIGH_MAX;
        r103[r105.ordinal()] = 4;
        int[] r106 = new int[IHeatChangeController.DanmakuHeat.values().length];
        f549430c = r106;
        r106[r101.ordinal()] = 1;
        r106[r102.ordinal()] = 2;
        r106[r104.ordinal()] = 3;
        r106[r105.ordinal()] = 4;
    }
}
