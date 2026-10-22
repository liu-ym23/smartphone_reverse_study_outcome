package lp;

import com.bytedance.android.ec.window.base.shop.screenAdapt.unit.WindowSubunits;

/* JADX INFO: loaded from: classes44.dex */
public final /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f510172a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f510173b = null;

    static {
        int[] r100 = new int[WindowSubunits.values().length];
        f510172a = r100;
        WindowSubunits r101 = WindowSubunits.PT;
        r100[r101.ordinal()] = 1;
        WindowSubunits r102 = WindowSubunits.MM;
        r100[r102.ordinal()] = 2;
        int[] r103 = new int[WindowSubunits.values().length];
        f510173b = r103;
        r103[WindowSubunits.NONE.ordinal()] = 1;
        r103[r101.ordinal()] = 2;
        r103[WindowSubunits.IN.ordinal()] = 3;
        r103[r102.ordinal()] = 4;
    }
}
