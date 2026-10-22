package com.bytedance.android.shopping.store.hybridproduct.holder;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.hybrid.list.ECHybridListAdapter;
import com.bytedance.android.ec.hybrid.list.ECHybridListItemType;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.ec.store.utils.playable.PlayAbleType;
import com.bytedance.android.shopping.store.hybridproduct.module.l;
import com.bytedance.android.shopping.store.hybridproduct.n0;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopProductCardHolderNew;", "Lcom/bytedance/android/shopping/store/hybridproduct/holder/BaseViewHolderWithPriceUpdateAnimation;", "Lcom/bytedance/android/shopping/store/hybridproduct/holder/d;", "Lln/c;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopProductCardHolderNew extends BaseViewHolderWithPriceUpdateAnimation implements d, ln.c {
    public static final a u = null;
    public String r;
    public final QUIManager s;
    public final n0 t;

    public static final class a {
        public a() {
        }

        public static ECShopProductCardHolderNew a(Fragment r4, ViewGroup r5, ECStoreViewModel r6, LayoutTypes r7) {
            Intrinsics.checkNotNullParameter(r4, "fragment");
            Intrinsics.checkNotNullParameter(r5, "parent");
            Intrinsics.checkNotNullParameter(r6, "storeViewModel");
            Intrinsics.checkNotNullParameter(r7, "layoutTypes");
            QUIManager r0 = new QUIManager();
            if (c.a[r7.ordinal()] == 1) goto L5;
            ShoppingAsyncInflater.a r1 = ShoppingAsyncInflater.e;
            Context r2 = r5.getContext();
            r1.getClass();
            View r3 = com.bytedance.android.ec.opt.asyncInflate.c.a(ShoppingAsyncInflater.a.a(r2), 2131564803, r5, 4);
        L6:
            n0 r8 = new n0();
            pn.b.a(r0, new l(r3, r6, r7, r8), r5.getContext(), r4);
            return new ECShopProductCardHolderNew(r0, r0.p(), r8, r6);
        L5:
            ShoppingAsyncInflater.a r9 = ShoppingAsyncInflater.e;
            Context r10 = r5.getContext();
            r9.getClass();
            r3 = com.bytedance.android.ec.opt.asyncInflate.c.a(ShoppingAsyncInflater.a.a(r10), 2131564805, r5, 4);
            goto L6
        }
    }

    public final void B() {
        this.t.B();
    }

    public final List<ln.c> L(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "visibleArea");
        return this.t.L(r2);
    }

    public final void R() {
        this.t.R();
    }

    public final boolean isPlaying() {
        return this.t.isPlaying();
    }

    public final void k1(nn.e.a r2) {
        this.t.k1(r2);
    }

    public final Rect r() {
        this.t.getClass();
        return null;
    }

    public final void v() {
        this.t.v();
    }

    static {
        u = new a();
    }

    public final void M() {
        n0 r0 = this.t;
        r0.getClass();
        ln.c.a.a(r0);
    }

    public final PlayAbleType P() {
        this.t.getClass();
        return PlayAbleType.OTHER;
    }

    public final ln.b m() {
        return ((nn.a) this.t).a;
    }

    public final void pausePlay() {
        n0 r0 = this.t;
        r0.getClass();
        ln.c.a.d(r0);
    }

    public final void startPlay() {
        n0 r0 = this.t;
        r0.getClass();
        ln.c.a.e(r0);
    }

    public final void stopPlay() {
        n0 r0 = this.t;
        r0.getClass();
        ln.c.a.f(r0);
    }

    public final void x() {
        n0 r0 = this.t;
        r0.getClass();
        ln.c.a.b(r0);
    }

    public final void z() {
        n0 r0 = this.t;
        r0.getClass();
        ln.c.a.c(r0);
    }

    @Override // com.bytedance.android.shopping.store.hybridproduct.holder.ECShopBaseHolder
    public final void q4(Object r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "itemId");
        this.r = r6;
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
        if (r3.getItemViewType(r0) != ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD_SINGLE.getType()) goto L27;
    L26:
        r1 = r1 + 1;
        goto L27
    L21:
        if (r2.getItemViewType(r0) == ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD.getType()) goto L26;
    L30:
        r8.w = r0 - 1;
        this.s.c(l.class, r8);
        return;
    L6:
        if ((r5 instanceof com.bytedance.android.ec.store.repository.dto.l) == true) goto L8;
        r5 = null;
    L8:
        com.bytedance.android.ec.store.repository.dto.l r10 = (com.bytedance.android.ec.store.repository.dto.l) r5;
        if (r10 != null) goto L11;
        r5 = null;
        goto L12
    L11:
        r7.getClass();
        r5 = StoreV2ProductItemVO.a.b(r10);
        goto L12
    }

    public ECShopProductCardHolderNew(QUIManager r2, View r3, n0 r4, ECStoreViewModel r5) {
        Intrinsics.checkNotNullParameter(r2, "uiManager");
        Intrinsics.checkNotNullParameter(r3, "itemView");
        Intrinsics.checkNotNullParameter(r4, "playableProxy");
        Intrinsics.checkNotNullParameter(r5, "storeViewModel");
        super(r3, r5);
        this.s = r2;
        this.t = r4;
    }
}
