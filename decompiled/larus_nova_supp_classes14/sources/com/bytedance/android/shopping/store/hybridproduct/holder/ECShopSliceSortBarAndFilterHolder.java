package com.bytedance.android.shopping.store.hybridproduct.holder;

import android.view.View;
import com.bytedance.android.ec.store.repository.vo.k;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.hybridproduct.module.w;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopSliceSortBarAndFilterHolder;", "Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopBaseHolder;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopSliceSortBarAndFilterHolder extends ECShopBaseHolder {
    public static final a r = null;
    public final QUIManager q;

    public static final class a {
        public a() {
        }
    }

    static {
        r = new a();
    }

    @Override // com.bytedance.android.shopping.store.hybridproduct.holder.ECShopBaseHolder
    public final void q4(Object r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "itemId");
        k.a r5 = k.i;
        if ((r3 instanceof k) == false) goto L6;
    L12:
        k r6 = (k) r3;
        if (r6 != null) goto L15;
        return;
    L15:
        this.q.c(w.class, r6);
        return;
    L6:
        if ((r3 instanceof String) == true) goto L8;
        r3 = null;
    L8:
        String r7 = (String) r3;
        if (r7 != null) goto L11;
        r3 = null;
        goto L12
    L11:
        r5.getClass();
        r3 = k.a.a(r7, null);
        goto L12
    }

    public ECShopSliceSortBarAndFilterHolder(QUIManager r2, View r3, ECShopHybridProductViewModel r4, ECStoreViewModel r5) {
        Intrinsics.checkNotNullParameter(r2, "uiManager");
        Intrinsics.checkNotNullParameter(r3, "itemView");
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        Intrinsics.checkNotNullParameter(r5, "storeViewModel");
        super(r3, r5);
        this.q = r2;
    }
}
