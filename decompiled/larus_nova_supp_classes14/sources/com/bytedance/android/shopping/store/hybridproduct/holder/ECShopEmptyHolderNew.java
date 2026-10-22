package com.bytedance.android.shopping.store.hybridproduct.holder;

import android.view.View;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopEmptyHolderNew;", "Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopBaseHolder;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopEmptyHolderNew extends ECShopBaseHolder {
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
        ej3.d.a r5 = ej3.d.l;
        if ((r3 instanceof ej3.d) == false) goto L6;
    L12:
        ej3.d r6 = (ej3.d) r3;
        if (r6 != null) goto L15;
        return;
    L15:
        this.q.c(com.bytedance.android.shopping.store.hybridproduct.module.c.class, r6);
        return;
    L6:
        if ((r3 instanceof dj3.e) == true) goto L8;
        r3 = null;
    L8:
        dj3.e r7 = (dj3.e) r3;
        if (r7 != null) goto L11;
        r3 = null;
        goto L12
    L11:
        r5.getClass();
        r3 = ej3.d.a.a(r7);
        goto L12
    }

    public ECShopEmptyHolderNew(QUIManager r2, View r3, ECStoreViewModel r4) {
        Intrinsics.checkNotNullParameter(r2, "uiManager");
        Intrinsics.checkNotNullParameter(r3, "itemView");
        Intrinsics.checkNotNullParameter(r4, "storeViewModel");
        super(r3, r4);
        this.q = r2;
    }
}
