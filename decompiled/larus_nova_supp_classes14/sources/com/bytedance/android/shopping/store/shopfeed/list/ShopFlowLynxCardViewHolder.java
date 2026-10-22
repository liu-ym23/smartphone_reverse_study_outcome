package com.bytedance.android.shopping.store.shopfeed.list;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/store/shopfeed/list/ShopFlowLynxCardViewHolder;", "Lcom/bytedance/android/shopping/store/shopfeed/list/ShopFeedBaseViewHolder;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopFlowLynxCardViewHolder extends ShopFeedBaseViewHolder {
    public static final /* synthetic */ int b = 0;
    public final ShopFlowLynxCardView a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.shopping.store.shopfeed.list.ShopFeedBaseViewHolder
    public final void o() {
    }

    public ShopFlowLynxCardViewHolder(ShopFlowLynxCardView r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxCardView");
        super(r2);
        this.a = r2;
    }

    @Override // com.bytedance.android.shopping.store.shopfeed.list.ShopFeedBaseViewHolder
    public final void T3(com.bytedance.android.shopping.store.shopfeed.list.a r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "vo");
        b r6 = (b) r3;
        ShopFlowLynxCardView r0 = this.a;
        ShopFeedItemCard r1 = r6.b;
        String r7 = r6.c;
        if (r4 != r5) goto L5;
        boolean r8 = true;
    L6:
        r0.a(r1, r7, r4, r8);
        return;
    L5:
        r8 = false;
        goto L6
    }
}
