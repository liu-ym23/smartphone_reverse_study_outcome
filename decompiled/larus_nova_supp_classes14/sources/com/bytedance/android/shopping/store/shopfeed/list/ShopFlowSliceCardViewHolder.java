package com.bytedance.android.shopping.store.shopfeed.list;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.shopping.store.hybridproduct.holder.e;
import com.bytedance.android.shopping.store.shopfeed.viewmodel.ECShopFeedViewModel;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/store/shopfeed/list/ShopFlowSliceCardViewHolder;", "Lcom/bytedance/android/shopping/store/shopfeed/list/ShopFeedBaseViewHolder;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopFlowSliceCardViewHolder extends ShopFeedBaseViewHolder {
    public static final /* synthetic */ int e = 0;
    public final QUIManager a;
    public final ViewGroup b;
    public final ECShopFeedViewModel c;
    public final e d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.shopping.store.shopfeed.list.ShopFeedBaseViewHolder
    public final void o() {
        this.a.r(ek3.b.class);
    }

    @Override // com.bytedance.android.shopping.store.shopfeed.list.ShopFeedBaseViewHolder
    public final void T3(com.bytedance.android.shopping.store.shopfeed.list.a r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "vo");
        c r8 = (c) r5;
        r8.g = r6;
        if (this.d.a != null) goto L21;
        String r9 = r8.f;
        boolean r0 = true;
        if (r9 == null) goto L8;
        r r10 = this.c.getSliceCardFactory().a(r9, 1);
    L9:
        dm.a.b r1 = dm.a.a("测试轻览");
        StringBuilder r2 = new StringBuilder("ECShopSlcCommonCardHolder.bind2:");
        if (r10 == null) goto L13;
        r0 = false;
    L13:
        r2.append(r0);
        r1.a(r2.toString());
        if (r10 == null) goto L18;
        View r3 = r10.c;
        if (r3 == null) goto L18;
        this.b.addView(r3, new FrameLayout.LayoutParams(-1, -2));
    L18:
        if (r10 != null) goto L20;
        dm.a.a("ECShopSlcCommonCardHolder").b("bind:viewInfo is null", null);
    L20:
        this.d.a = r10;
        goto L21
    L8:
        r10 = null;
    L21:
        this.a.c(ek3.b.class, r5);
    }

    public ShopFlowSliceCardViewHolder(QUIManager r2, ViewGroup r3, ECShopFeedViewModel r4, e r5) {
        Intrinsics.checkNotNullParameter(r2, "uiManager");
        Intrinsics.checkNotNullParameter(r3, "itemView2");
        Intrinsics.checkNotNullParameter(r4, "shopFeedViewModel");
        Intrinsics.checkNotNullParameter(r5, "viewInfoProxy");
        super(r3);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
