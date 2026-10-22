package com.bytedance.android.shopping.store.hybridproduct.module;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.common.uiext.ExtensionsKt;
import com.bytedance.android.shopping.store.home.e0;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopSortBarAndFilterPresenter extends QFragmentPresenter {
    public final Lazy f;
    public final Lazy g;
    public final ECStoreViewModel h;

    public static final class a<T> implements Observer {
        public final /* synthetic */ ECShopSortBarAndFilterPresenter a;
        public final /* synthetic */ int b;

        public a(ECShopSortBarAndFilterPresenter r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r5) {
            ej3.f r6 = (ej3.f) r5;
            ECShopSortBarAndFilterPresenter r0 = this.a;
            if (r6 == null) goto L7;
            List<com.bytedance.android.ec.store.repository.dto.c> r7 = r6.d;
            if (r7 == null) goto L7;
            Integer r8 = Integer.valueOf(r7.size());
        L8:
            int r9 = com.bytedance.android.shopping.extensions.k.f(r8);
            int r1 = this.b;
            r0.h.getAnimator().a(2, new q(r0, r9, r1));
            return;
        L7:
            r8 = null;
            goto L8
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ECShopSortBarAndFilterPresenter a;
        public final /* synthetic */ int b;

        public b(ECShopSortBarAndFilterPresenter r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r5) {
            com.bytedance.android.ec.store.repository.vo.n r6 = (com.bytedance.android.ec.store.repository.vo.n) r5;
            ECShopSortBarAndFilterPresenter r0 = this.a;
            if (r6 == null) goto L7;
            List r7 = r6.a;
            if (r7 == null) goto L7;
            Integer r8 = Integer.valueOf(r7.size());
        L8:
            int r9 = com.bytedance.android.shopping.extensions.k.f(r8);
            int r1 = this.b;
            r0.h.getAnimator().a(2, new q(r0, r9, r1));
            return;
        L7:
            r8 = null;
            goto L8
        }
    }

    public final void b0(QModel r5) {
        if (Intrinsics.areEqual((Boolean) this.h.isBrandShop().getValue(), Boolean.TRUE) == false) goto L7;
        View r6 = com.bytedance.android.ec.store.product.presenter.utils.f.a(Z().b(2131372717));
        if (r6 == null) goto L7;
        r6.setPadding(0, 0, 0, 0);
    L7:
        int r7 = e0.a;
        if (ECShopABSettings.getEC_SHOP_TAB_INTERACTION_OPT() != 1) goto L10;
    L15:
        boolean r8 = true;
    L16:
        if (r8 == true) goto L18;
        return;
    L18:
        if (ECShopABSettings.getEC_SHOP_TAB_INTERACTION_OPT() != 1) goto L21;
        int r9 = ExtensionsKt.a(8);
    L27:
        ((ECShopHybridProductViewModel) this.f.getValue()).getSortsVO().a(Y().e(), new a(this, r9), false);
        ((ECShopHybridProductViewModel) this.f.getValue()).getDiscountButton().a(Y().e(), new b(this, r9), false);
        return;
    L21:
        if (ECShopABSettings.getEC_SHOP_TAB_INTERACTION_OPT() != 4) goto L24;
        r9 = ExtensionsKt.a(4);
        goto L27
    L24:
        if (ECShopABSettings.getEC_SHOP_TAB_INTERACTION_OPT() != 3) goto L26;
        r9 = ExtensionsKt.a(3);
        goto L27
    L26:
        r9 = 0;
        goto L27
    L10:
        if (ECShopABSettings.getEC_SHOP_TAB_INTERACTION_OPT() == 3) goto L15;
        if (ECShopABSettings.getEC_SHOP_TAB_INTERACTION_OPT() == 4) goto L15;
        r8 = false;
        goto L16
    }

    public ECShopSortBarAndFilterPresenter(Fragment r2, ECStoreViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "frgment");
        Intrinsics.checkNotNullParameter(r3, "storeViewModel");
        super(r2);
        this.h = r3;
        this.f = LazyKt.lazy(new ECShopSortBarAndFilterPresenter$viewModel$2(this));
        this.g = LazyKt.lazy(new ECShopSortBarAndFilterPresenter$container$2(this));
    }
}
