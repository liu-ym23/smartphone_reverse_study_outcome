package com.bytedance.android.shopping.store.shopfeed.router;

import android.content.Context;
import android.net.Uri;
import bf.c;
import com.bytedance.android.ec.core.utils.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopFeedRouter implements c {
    public ECShopFeedRouter() {
    }

    public final void a() {
    }

    public final String b() {
        return "goods/shop_feed";
    }

    public final boolean c(final Context r3, final Uri r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "uri");
        n.b(r3, r5, null, new ECShopFeedRouter$open$1(r3, r4), ECShopFeedRouter$open$2.INSTANCE);
        return true;
    }
}
