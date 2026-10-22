package com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/pendant/PendantType;", "", "TYPE_NATIVE", "TYPE_SLICE", "TYPE_LYNX", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PendantType extends Enum<PendantType> {
    public static final PendantType TYPE_LYNX = null;
    public static final PendantType TYPE_NATIVE = null;
    public static final PendantType TYPE_SLICE = null;
    public static final /* synthetic */ PendantType[] a = null;

    static {
        PendantType r1 = new PendantType("TYPE_NATIVE", 0);
        TYPE_NATIVE = r1;
        PendantType r2 = new PendantType("TYPE_SLICE", 1);
        TYPE_SLICE = r2;
        PendantType r3 = new PendantType("TYPE_LYNX", 2);
        TYPE_LYNX = r3;
        a = new PendantType[]{r1, r2, r3};
    }

    public static PendantType valueOf(String r1) {
        return (PendantType) r27.a.a(PendantType.class, r1);
    }

    public static PendantType[] values() {
        return (PendantType[]) a.clone();
    }

    public PendantType(String r1, int r2) {
        super(r1, r2);
    }
}
