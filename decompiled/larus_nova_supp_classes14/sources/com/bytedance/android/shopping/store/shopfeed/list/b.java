package com.bytedance.android.shopping.store.shopfeed.list;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends com.bytedance.android.shopping.store.shopfeed.list.a {
    public static final /* synthetic */ int d = 0;
    public final ShopFeedItemCard b;
    public final String c;

    public static final class a {
    }

    static {
    }

    public final int modelType() {
        return ShopFeedItemType.LYNX_CARD.getTypeValue();
    }

    public b(ShopFeedItemCard r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "shopFlowShopCard");
        Intrinsics.checkNotNullParameter(r3, "passThroughParams");
        super(ShopFeedItemType.LYNX_CARD);
        this.b = r2;
        this.c = r3;
    }
}
