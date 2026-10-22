package com.bytedance.android.shopping.buynow.data.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/buynow/data/model/PayShowType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "DEFAULT", "AUCTION", "NO_PAYMENT", "ONLY_METHOD", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PayShowType extends Enum<PayShowType> {
    public static final PayShowType AUCTION = null;
    public static final PayShowType DEFAULT = null;
    public static final PayShowType NO_PAYMENT = null;
    public static final PayShowType ONLY_METHOD = null;
    public static final /* synthetic */ PayShowType[] a = null;
    private final String type;

    static {
        PayShowType r1 = new PayShowType("DEFAULT", 0, "0");
        DEFAULT = r1;
        PayShowType r2 = new PayShowType("AUCTION", 1, "1");
        AUCTION = r2;
        PayShowType r3 = new PayShowType("NO_PAYMENT", 2, "2");
        NO_PAYMENT = r3;
        PayShowType r4 = new PayShowType("ONLY_METHOD", 3, "3");
        ONLY_METHOD = r4;
        a = new PayShowType[]{r1, r2, r3, r4};
    }

    public static PayShowType valueOf(String r1) {
        return (PayShowType) a.a(PayShowType.class, r1);
    }

    public static PayShowType[] values() {
        return (PayShowType[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public PayShowType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
