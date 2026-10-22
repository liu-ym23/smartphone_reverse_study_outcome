package com.bytedance.android.shopping.store.shopfeed.list;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.store.repository.vo.TabEnum;
import com.bytedance.android.shopping.store.shopfeed.ShopFeedParam;
import com.bytedance.android.shopping.store.shopfeed.viewmodel.ECShopFeedViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/store/shopfeed/list/ShopFlowFooterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopFlowFooterViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int c = 0;
    public final TextView a;
    public final FrameLayout b;

    public static final class a {
        public static ShopFlowFooterViewHolder a(ViewGroup r3) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            ShoppingAsyncInflater.a r0 = ShoppingAsyncInflater.e;
            Context r1 = r3.getContext();
            r0.getClass();
            return new ShopFlowFooterViewHolder(ShoppingAsyncInflater.a.a(r1).aU(2131560853, r3, false));
        }
    }

    static {
    }

    public ShopFlowFooterViewHolder(View r5) {
        Intrinsics.checkNotNullParameter(r5, "holderView");
        super(r5);
        TextView r6 = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131386231);
        this.a = r6;
        FrameLayout r0 = (FrameLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131386230);
        this.b = r0;
        r0.setLayoutParams(new FrameLayout.LayoutParams(-1, k1.j(((RecyclerView.ViewHolder) this).itemView.getContext()) / 5));
        Context r1 = ECAppInfoService.e.getApplicationContext();
        if (r1 == null) goto L6;
        String r2 = th.a.g(r1, 2131913774);
        if (r2 == null) goto L6;
    L7:
        r6.setText(r2);
        return;
    L6:
        r2 = "";
        goto L7
    }

    public final void T3(ECShopFeedViewModel r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r3, "shopFeedViewModel");
        ShopFeedParam r5 = r3.getShopFeedParam();
        if (r5 == null) goto L5;
        Integer r6 = r5.getTabType();
    L6:
        int r0 = TabEnum.SHOP_INNER_FLOW_PAGE.getType();
        if (r6 != null) goto L10;
    L12:
        TextView r7 = this.a;
        if (r4 == null) goto L17;
        r7.setTextColor(r4.intValue());
        return;
    L17:
        return;
    L10:
        if (r6.intValue() != r0) goto L12;
        this.a.setText("滑动到底了~");
        this.a.setTextColor((int) 4292994280L);
        return;
    L5:
        r6 = null;
        goto L6
    }
}
