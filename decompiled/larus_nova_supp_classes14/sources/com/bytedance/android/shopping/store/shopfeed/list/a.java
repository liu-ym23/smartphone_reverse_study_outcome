package com.bytedance.android.shopping.store.shopfeed.list;

import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class a implements QModel {
    public final ShopFeedItemType a;

    public final int hashCode() {
        return this.a.hashCode() * 31;
    }

    public a(ShopFeedItemType r2) {
        Intrinsics.checkNotNullParameter(r2, "itemType");
        this.a = r2;
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L5;
        return true;
    L5:
        Class<?> r1 = getClass();
        if (r4 == null) goto L8;
        Class<?> r2 = r4.getClass();
    L10:
        if ((!Intrinsics.areEqual(r1, r2)) == false) goto L12;
        return false;
    L12:
        if (r4 == null) goto L18;
        if (this.a == ((a) r4).a) goto L16;
        return false;
    L16:
        return true;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.store.shopfeed.list.ShopFeedBaseViewObject");
    L8:
        r2 = null;
        goto L10
    }
}
