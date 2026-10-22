package sk3;

import com.bytedance.android.shopping.store.utils.screenAdapt.unit.Subunits;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class c {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[Subunits.values().length];
        a = r0;
        Subunits r1 = Subunits.PT;
        r0[r1.ordinal()] = 1;
        Subunits r2 = Subunits.MM;
        r0[r2.ordinal()] = 2;
        int[] r3 = new int[Subunits.values().length];
        b = r3;
        r3[Subunits.NONE.ordinal()] = 1;
        r3[r1.ordinal()] = 2;
        r3[Subunits.IN.ordinal()] = 3;
        r3[r2.ordinal()] = 4;
    }
}
