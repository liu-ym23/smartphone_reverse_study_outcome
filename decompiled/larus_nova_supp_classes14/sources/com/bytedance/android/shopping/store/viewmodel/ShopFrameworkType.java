package com.bytedance.android.shopping.store.viewmodel;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/store/viewmodel/ShopFrameworkType;", "", "", "type", "I", "getType", "()I", "NORMAL", "MIDDLE_TAB", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ShopFrameworkType extends Enum<ShopFrameworkType> {
    public static final ShopFrameworkType MIDDLE_TAB = null;
    public static final ShopFrameworkType NORMAL = null;
    public static final /* synthetic */ ShopFrameworkType[] a = null;
    private final int type;

    static {
        ShopFrameworkType r2 = new ShopFrameworkType("NORMAL", 0, 0);
        NORMAL = r2;
        ShopFrameworkType r3 = new ShopFrameworkType("MIDDLE_TAB", 1, 2);
        MIDDLE_TAB = r3;
        a = new ShopFrameworkType[]{r2, r3};
    }

    public static ShopFrameworkType valueOf(String r1) {
        return (ShopFrameworkType) r27.a.a(ShopFrameworkType.class, r1);
    }

    public static ShopFrameworkType[] values() {
        return (ShopFrameworkType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public ShopFrameworkType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
