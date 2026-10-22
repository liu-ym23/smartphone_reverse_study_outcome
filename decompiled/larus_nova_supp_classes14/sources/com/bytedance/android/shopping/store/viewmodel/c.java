package com.bytedance.android.shopping.store.viewmodel;

import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.shopping.store.hybrid.StoreTabConfig;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public boolean a;
    public boolean b;
    public int c;
    public StoreTabConfig d;
    public int e;
    public LayoutTypes f;

    public c() {
        this.a = true;
        this.b = true;
        this.c = -1;
        ECShopABSettings.k.getClass();
        this.e = 1 ^ (ECShopABSettings.c() ? 1 : 0);
        this.f = LayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE;
    }
}
