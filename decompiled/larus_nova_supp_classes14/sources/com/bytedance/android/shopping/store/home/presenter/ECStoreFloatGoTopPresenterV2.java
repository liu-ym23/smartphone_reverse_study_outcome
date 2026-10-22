package com.bytedance.android.shopping.store.home.presenter;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECStoreFloatGoTopPresenterV2 extends ECShopAbsFloatPresenter {
    public final Lazy k;

    public static final class a implements z3 {
        public final /* synthetic */ ECStoreFloatGoTopPresenterV2 a;

        @Override // com.bytedance.android.shopping.store.home.presenter.z3
        public final void a() {
            this.a.S().getGoTopState().setValue(1);
        }

        @Override // com.bytedance.android.shopping.store.home.presenter.z3
        public final void onClick() {
            this.a.S().getScrollPositionFarEnough().c(Boolean.FALSE);
            this.a.S().getGoTopEventReceiver().c(new Object());
            com.bytedance.android.ec.core.arch.event.c.d(this.a.S(), new ui3.a());
            com.bytedance.android.ec.core.arch.event.c.d(this.a.S(), new ui3.b());
        }

        @Override // com.bytedance.android.shopping.store.home.presenter.z3
        public final void onHidden() {
            this.a.S().getGoTopState().setValue(0);
        }

        public a(ECStoreFloatGoTopPresenterV2 r1) {
            this.a = r1;
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ECStoreFloatGoTopPresenterV2 a;

        public b(ECStoreFloatGoTopPresenterV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Boolean r2 = (Boolean) r1;
            this.a.Q();
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ECStoreFloatGoTopPresenterV2 a;

        public c(ECStoreFloatGoTopPresenterV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (((Boolean) r2).booleanValue() == true) goto L5;
            return;
        L5:
            if (ECShopABSettings.getEC_SHOP_BRAND_SHOP_UI_UPGRADE() != 1) goto L9;
            this.a.y().setBackgroundResource(2131234725);
            return;
        }
    }

    public final ECStoreViewModel S() {
        return (ECStoreViewModel) this.k.getValue();
    }

    @Override // com.bytedance.android.shopping.store.home.presenter.ECShopAbsFloatPresenter
    public final z3 E() {
        return new a(this);
    }

    @Override // com.bytedance.android.shopping.store.home.presenter.ECShopAbsFloatPresenter
    public final boolean D() {
        uj3.j r0 = S().getCurrentTab();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.i() == false) goto L8;
    L9:
        Boolean r1 = (Boolean) S().getScrollPositionFarEnough().getValue();
        if (r1 == null) goto L12;
        boolean r2 = r1.booleanValue();
    L13:
        if (r2 == false) goto L17;
        return true;
    L17:
        return false;
    L12:
        r2 = false;
        goto L13
    L8:
        if (r0.g() == true) goto L9;
        return false;
    }

    @Override // com.bytedance.android.shopping.store.home.presenter.ECShopAbsFloatPresenter
    public final a4 F() {
        ECStoreViewModel r0 = S();
        Intrinsics.checkNotNullParameter(r0, "viewModel");
        return new com.bytedance.android.shopping.store.home.presenter.b(r0);
    }

    public ECStoreFloatGoTopPresenterV2(Fragment r1) {
        super(r1);
        this.k = LazyKt.lazy(new ECStoreFloatGoTopPresenterV2$viewModel$2(this));
    }

    public final void A(QModel r4) {
        this.h = Boolean.TRUE;
        y().setOnClickListener(new d(this));
        K();
        S().getScrollPositionFarEnough().a(ECQuickUtilKt.a(u()), new b(this), false);
        S().isBrandShop().a(ECQuickUtilKt.a(u()), new c(this), false);
    }
}
