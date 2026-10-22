package com.bytedance.android.shopping.store.hybridproduct.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.hybrid.list.ECHybridListAdapter;
import com.bytedance.android.ec.hybrid.list.ECHybridListItemType;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.store.repository.dto.l;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopGuessLikeCardHolderNew;", "Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopBaseHolder;", "Lcom/bytedance/android/shopping/store/hybridproduct/holder/d;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopGuessLikeCardHolderNew extends ECShopBaseHolder implements d {
    public static final a r = null;
    public final QUIManager q;

    public static final class a {
        public a() {
        }

        public static ECShopGuessLikeCardHolderNew a(Fragment r3, ViewGroup r4, ECStoreViewModel r5, boolean r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r3, "fragment");
            Intrinsics.checkNotNullParameter(r4, "parent");
            Intrinsics.checkNotNullParameter(r5, "storeViewModel");
            QUIManager r0 = new QUIManager();
            ShoppingAsyncInflater.a r1 = ShoppingAsyncInflater.e;
            Context r2 = r4.getContext();
            r1.getClass();
            ShoppingAsyncInflater r8 = ShoppingAsyncInflater.a.a(r2);
            if (r7 == false) goto L5;
            int r9 = 2131564805;
        L6:
            pn.b.a(r0, new com.bytedance.android.shopping.store.hybridproduct.module.e(com.bytedance.android.ec.opt.asyncInflate.c.a(r8, r9, r4, 4), r5, r6), r4.getContext(), r3);
            return new ECShopGuessLikeCardHolderNew(r0, r0.p(), r5);
        L5:
            r9 = 2131564803;
            goto L6
        }
    }

    static {
        r = new a();
    }

    @Override // com.bytedance.android.shopping.store.hybridproduct.holder.ECShopBaseHolder
    public final void q4(Object r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "itemId");
        StoreV2ProductItemVO.a r7 = StoreV2ProductItemVO.Q;
        if ((r5 instanceof StoreV2ProductItemVO) == false) goto L6;
    L12:
        StoreV2ProductItemVO r8 = (StoreV2ProductItemVO) r5;
        if (r8 != null) goto L15;
        return;
    L15:
        r8.v = getAdapterPosition();
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
        if (r3.getItemViewType(r0) != ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD_GUESS_LIKE_SINGLE.getType()) goto L27;
    L26:
        r1 = r1 + 1;
        goto L27
    L21:
        if (r2.getItemViewType(r0) == ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD_GUESS_LIKE.getType()) goto L26;
    L30:
        r8.w = r0 - 1;
        this.q.c(com.bytedance.android.shopping.store.hybridproduct.module.e.class, r8);
        return;
    L6:
        if ((r5 instanceof l) == true) goto L8;
        r5 = null;
    L8:
        l r10 = (l) r5;
        if (r10 != null) goto L11;
        r5 = null;
        goto L12
    L11:
        r7.getClass();
        r5 = StoreV2ProductItemVO.a.b(r10);
        goto L12
    }

    public ECShopGuessLikeCardHolderNew(QUIManager r2, View r3, ECStoreViewModel r4) {
        Intrinsics.checkNotNullParameter(r2, "uiManager");
        Intrinsics.checkNotNullParameter(r3, "itemView");
        Intrinsics.checkNotNullParameter(r4, "storeViewModel");
        super(r3, r4);
        this.q = r2;
    }
}
