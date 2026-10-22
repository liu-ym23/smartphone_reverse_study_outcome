package com.bytedance.android.shopping.widget.rittag;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/widget/rittag/RitTagPart;", "", "START", "NORMAL", "END", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RitTagPart extends Enum<RitTagPart> {
    public static final RitTagPart END = null;
    public static final RitTagPart NORMAL = null;
    public static final RitTagPart START = null;
    public static final /* synthetic */ RitTagPart[] a = null;

    static {
        RitTagPart r1 = new RitTagPart("START", 0);
        START = r1;
        RitTagPart r2 = new RitTagPart("NORMAL", 1);
        NORMAL = r2;
        RitTagPart r3 = new RitTagPart("END", 2);
        END = r3;
        a = new RitTagPart[]{r1, r2, r3};
    }

    public static RitTagPart valueOf(String r1) {
        return (RitTagPart) r27.a.a(RitTagPart.class, r1);
    }

    public static RitTagPart[] values() {
        return (RitTagPart[]) a.clone();
    }

    public RitTagPart(String r1, int r2) {
        super(r1, r2);
    }
}
