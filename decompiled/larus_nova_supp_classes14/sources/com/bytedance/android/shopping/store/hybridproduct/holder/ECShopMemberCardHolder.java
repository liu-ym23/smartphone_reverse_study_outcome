package com.bytedance.android.shopping.store.hybridproduct.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.shopping.store.home.entity.Module;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.hybridproduct.module.t;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopMemberCardHolder;", "Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopBaseHolder;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopMemberCardHolder extends ECShopBaseHolder {
    public static final a r = null;
    public final QUIManager q;

    public static final class a {
        public a() {
        }

        public static ECShopMemberCardHolder a(ViewGroup r4, ECShopHybridProductViewModel r5, ECStoreViewModel r6, Fragment r7, LayoutTypes r8) {
            Intrinsics.checkNotNullParameter(r4, "parent");
            Intrinsics.checkNotNullParameter(r5, "viewModel");
            Intrinsics.checkNotNullParameter(r6, "storeViewModel");
            Intrinsics.checkNotNullParameter(r7, "fragment");
            Intrinsics.checkNotNullParameter(r8, "layoutTypes");
            QUIManager r9 = new QUIManager();
            if (r8 != LayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE) goto L5;
            ShoppingAsyncInflater.a r0 = ShoppingAsyncInflater.e;
            Context r3 = r4.getContext();
            r0.getClass();
            View r1 = ShoppingAsyncInflater.a.a(r3).aU(2131564741, null, false);
        L6:
            pn.b.a(r9, new t(r7, r1, r8), r4.getContext(), r7);
            return new ECShopMemberCardHolder(r9, r1, r6);
        L5:
            ShoppingAsyncInflater.a r2 = ShoppingAsyncInflater.e;
            Context r10 = r4.getContext();
            r2.getClass();
            r1 = ShoppingAsyncInflater.a.a(r10).aU(2131564742, null, false);
            goto L6
        }
    }

    static {
        r = new a();
    }

    @Override // com.bytedance.android.shopping.store.hybridproduct.holder.ECShopBaseHolder
    public final void q4(Object r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "itemId");
        uj3.d.a r5 = uj3.d.k;
        if ((r3 instanceof uj3.d) == false) goto L6;
    L12:
        uj3.d r6 = (uj3.d) r3;
        if (r6 != null) goto L15;
        return;
    L15:
        this.q.c(t.class, r6);
        return;
    L6:
        if ((r3 instanceof Module) == true) goto L8;
        r3 = null;
    L8:
        Module r7 = (Module) r3;
        if (r7 != null) goto L11;
        r3 = null;
        goto L12
    L11:
        r5.getClass();
        r3 = uj3.d.a.a(r7);
        goto L12
    }

    public ECShopMemberCardHolder(QUIManager r2, View r3, ECStoreViewModel r4) {
        Intrinsics.checkNotNullParameter(r2, "uiManager");
        Intrinsics.checkNotNullParameter(r3, "itemView");
        Intrinsics.checkNotNullParameter(r4, "storeViewModel");
        super(r3, r4);
        this.q = r2;
    }
}
