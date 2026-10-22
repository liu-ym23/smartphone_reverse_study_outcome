package com.bytedance.android.shopping.store.utils.screenAdapt.unit;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/store/utils/screenAdapt/unit/Subunits;", "", "NONE", "PT", "IN", "MM", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Subunits extends Enum<Subunits> {
    public static final Subunits IN = null;
    public static final Subunits MM = null;
    public static final Subunits NONE = null;
    public static final Subunits PT = null;
    public static final /* synthetic */ Subunits[] a = null;

    static {
        Subunits r1 = new Subunits("NONE", 0);
        NONE = r1;
        Subunits r2 = new Subunits("PT", 1);
        PT = r2;
        Subunits r3 = new Subunits("IN", 2);
        IN = r3;
        Subunits r4 = new Subunits("MM", 3);
        MM = r4;
        a = new Subunits[]{r1, r2, r3, r4};
    }

    public static Subunits valueOf(String r1) {
        return (Subunits) a.a(Subunits.class, r1);
    }

    public static Subunits[] values() {
        return (Subunits[]) a.clone();
    }

    public Subunits(String r1, int r2) {
        super(r1, r2);
    }
}
