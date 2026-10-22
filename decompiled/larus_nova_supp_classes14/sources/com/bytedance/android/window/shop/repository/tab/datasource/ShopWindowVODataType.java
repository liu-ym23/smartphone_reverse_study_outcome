package com.bytedance.android.window.shop.repository.tab.datasource;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/datasource/ShopWindowVODataType;", "", "PIN", "NORMAL", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ShopWindowVODataType extends Enum<ShopWindowVODataType> {
    public static final ShopWindowVODataType NORMAL = null;
    public static final ShopWindowVODataType PIN = null;
    public static final /* synthetic */ ShopWindowVODataType[] a = null;

    static {
        ShopWindowVODataType r1 = new ShopWindowVODataType("PIN", 0);
        PIN = r1;
        ShopWindowVODataType r2 = new ShopWindowVODataType("NORMAL", 1);
        NORMAL = r2;
        a = new ShopWindowVODataType[]{r1, r2};
    }

    public static ShopWindowVODataType valueOf(String r1) {
        return (ShopWindowVODataType) r27.a.a(ShopWindowVODataType.class, r1);
    }

    public static ShopWindowVODataType[] values() {
        return (ShopWindowVODataType[]) a.clone();
    }

    public ShopWindowVODataType(String r1, int r2) {
        super(r1, r2);
    }
}
