package com.bytedance.android.shopping.mall.homepage.card.headercard.util;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/util/Popup7Type;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Seckill", "Subsidy", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Popup7Type extends Enum<Popup7Type> {
    public static final Popup7Type Seckill = null;
    public static final Popup7Type Subsidy = null;
    public static final /* synthetic */ Popup7Type[] a = null;
    private final String value;

    static {
        Popup7Type r1 = new Popup7Type("Seckill", 0, "seckill");
        Seckill = r1;
        Popup7Type r2 = new Popup7Type("Subsidy", 1, "subsidy");
        Subsidy = r2;
        a = new Popup7Type[]{r1, r2};
    }

    public static Popup7Type valueOf(String r1) {
        return (Popup7Type) r27.a.a(Popup7Type.class, r1);
    }

    public static Popup7Type[] values() {
        return (Popup7Type[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public Popup7Type(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
