package sk3;

import com.bytedance.android.shopping.store.utils.screenAdapt.unit.Subunits;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f542338a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f542339b = null;

    static {
        int[] r100 = new int[Subunits.values().length];
        f542338a = r100;
        Subunits r101 = Subunits.PT;
        r100[r101.ordinal()] = 1;
        Subunits r102 = Subunits.MM;
        r100[r102.ordinal()] = 2;
        int[] r103 = new int[Subunits.values().length];
        f542339b = r103;
        r103[Subunits.NONE.ordinal()] = 1;
        r103[r101.ordinal()] = 2;
        r103[Subunits.IN.ordinal()] = 3;
        r103[r102.ordinal()] = 4;
    }
}
