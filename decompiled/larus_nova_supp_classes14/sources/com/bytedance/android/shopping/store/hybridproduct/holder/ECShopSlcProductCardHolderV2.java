package com.bytedance.android.shopping.store.hybridproduct.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.hybrid.list.ECHybridListAdapter;
import com.bytedance.android.ec.hybrid.list.ECHybridListItemType;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.repository.vo.ShopSlcProductItemV2;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.shopping.store.hybridproduct.module.v;
import com.bytedance.android.shopping.store.slicecard.SliceItemType;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopSlcProductCardHolderV2;", "Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopBaseHolder;", "Lcom/bytedance/android/shopping/store/hybridproduct/holder/d;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopSlcProductCardHolderV2 extends ECShopBaseHolder implements d {
    public static final a r = null;
    public final QUIManager q;

    public static final class a {
        public a() {
        }

        public static ECShopSlcProductCardHolderV2 a(Fragment r7, ViewGroup r8, ECStoreViewModel r9, LayoutTypes r10) {
            QUIManager r0 = new QUIManager();
            FrameLayout r1 = new FrameLayout(r8.getContext());
            if (r10 != LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE) goto L5;
            r r2 = r9.getSliceCardFactory().e(SliceItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD_CARDPACK);
        L6:
            if (r2 == null) goto L16;
            View r3 = r2.c;
            if (r3 == null) goto L16;
            r1.addView(r3, new FrameLayout.LayoutParams(-1, -2));
        L16:
            pn.b.a(r0, new v(r1, r9, r2, r10), r8.getContext(), r7);     // Catch: Exception -> L12
        L15:
            return new ECShopSlcProductCardHolderV2(r0, r1, r9);
        L12:
            e = move-exception;
            e.printStackTrace();
            goto L15
        L5:
            r2 = r9.getSliceCardFactory().b(SliceItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD_CARDPACK);
            goto L6
        }
    }

    static {
        r = new a();
    }

    public final void o() {
        super.o();
        this.q.r(v.class);
    }

    public final void onRelease() {
        super.onRelease();
        this.q.r(v.class);
    }

    @Override // com.bytedance.android.shopping.store.hybridproduct.holder.ECShopBaseHolder
    public final void q4(Object r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "itemId");
        ShopSlcProductItemV2.a r7 = ShopSlcProductItemV2.x;
        if ((r5 instanceof ShopSlcProductItemV2) == false) goto L6;
    L12:
        ShopSlcProductItemV2 r8 = (ShopSlcProductItemV2) r5;
        if (r8 != null) goto L15;
        return;
    L15:
        r8.h = getAdapterPosition();
        int r9 = getAdapterPosition();
        int r0 = 0;
        if (r9 < 0) goto L30;
        int r1 = 0;
    L18:
        ECHybridListAdapter r2 = ((BaseViewHolder) this).g;
        if (r2 != null) goto L21;
    L22:
        ECHybridListAdapter r3 = ((BaseViewHolder) this).g;
        if (r3 != null) goto L25;
    L27:
        if (r0 == r9) goto L29;
        r0 = r0 + 1;
        goto L18
    L29:
        r0 = r1;
        goto L30
    L25:
        if (r3.getItemViewType(r0) != ECHybridListItemType.SHOP_SLICE_PRODUCT_CARD_SINGLE_NEW.getType()) goto L27;
    L26:
        r1 = r1 + 1;
        goto L27
    L21:
        if (r2.getItemViewType(r0) == ECHybridListItemType.SHOP_SLICE_PRODUCT_CARD_NEW.getType()) goto L26;
    L30:
        r8.i = r0 - 1;
        this.q.c(v.class, r8);
        return;
    L6:
        if ((r5 instanceof String) == true) goto L8;
        r5 = null;
    L8:
        String r10 = (String) r5;
        if (r10 != null) goto L11;
        r5 = null;
        goto L12
    L11:
        r7.getClass();
        r5 = ShopSlcProductItemV2.a.a(r10, null);
        goto L12
    }

    public ECShopSlcProductCardHolderV2(QUIManager r2, View r3, ECStoreViewModel r4) {
        Intrinsics.checkNotNullParameter(r2, "uiManager");
        Intrinsics.checkNotNullParameter(r3, "itemView");
        Intrinsics.checkNotNullParameter(r4, "storeViewModel");
        super(r3, r4);
        this.q = r2;
    }
}
