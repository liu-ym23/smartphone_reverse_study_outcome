package com.bytedance.android.shopping.store.hybridproduct.holder;

import android.view.View;
import com.bytedance.android.ec.store.repository.vo.n;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.hybridproduct.module.o;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import dj3.g;
import ej3.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopSortBarAndFilterHolder;", "Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopBaseHolder;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopSortBarAndFilterHolder extends ECShopBaseHolder {
    public static final a s = null;
    public final QUIManager q;
    public final ECShopHybridProductViewModel r;

    public static final class a {
        public a() {
        }
    }

    static {
        s = new a();
    }

    @Override // com.bytedance.android.shopping.store.hybridproduct.holder.ECShopBaseHolder
    public final void q4(Object r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "itemId");
        f.a r5 = f.g;
        if ((r3 instanceof f) == false) goto L6;
    L12:
        f r6 = (f) r3;
        if (r6 != null) goto L15;
        return;
    L15:
        List<com.bytedance.android.ec.store.repository.dto.c> r7 = r6.d;
        if (r7 == null) goto L18;
        jm.a<n> r0 = this.r.getDiscountButton();
        n r1 = new n();
        r1.a = r7;
        Unit r8 = Unit.INSTANCE;
        r0.setValue(r1);
    L18:
        this.r.getSortsVO().setValue(r6);
        this.r.getSortTypes().setValue(r6.a);
        this.r.getBigSaleMoveToTop().setValue(r6.c);
        this.q.c(o.class, r6);
        return;
    L6:
        if ((r3 instanceof g) == true) goto L8;
        r3 = null;
    L8:
        g r9 = (g) r3;
        if (r9 != null) goto L11;
        r3 = null;
        goto L12
    L11:
        r5.getClass();
        r3 = f.a.a(r9);
        goto L12
    }

    public ECShopSortBarAndFilterHolder(QUIManager r2, View r3, ECShopHybridProductViewModel r4, ECStoreViewModel r5) {
        Intrinsics.checkNotNullParameter(r2, "uiManager");
        Intrinsics.checkNotNullParameter(r3, "itemView");
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        Intrinsics.checkNotNullParameter(r5, "storeViewModel");
        super(r3, r5);
        this.q = r2;
        this.r = r4;
    }
}
