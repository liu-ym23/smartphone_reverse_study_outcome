package com.bytedance.android.shopping.store.hybridproduct.presenter;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.repository.vo.ShopSlcProductItemV2;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.shopping.store.hybridproduct.actionhandler.AddProductActionHandler;
import com.bytedance.android.shopping.store.slicecard.SliceActionType;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopSlcProductCardGroupPresenter$actionHandler$1 implements com.bytedance.android.shopping.store.slicecard.a {
    public final Map<SliceActionType, com.bytedance.android.shopping.store.slicecard.a> a;
    public final /* synthetic */ ECShopSlcProductCardGroupPresenter b;

    public static final class a implements com.bytedance.android.shopping.store.hybridproduct.actionhandler.a<StoreV2ProductItemVO> {
        public final /* synthetic */ ECShopSlcProductCardGroupPresenter$actionHandler$1 a;

        public a(ECShopSlcProductCardGroupPresenter$actionHandler$1 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.store.hybridproduct.actionhandler.a
        public final void a(com.bytedance.android.shopping.store.hybridproduct.extension.d r2) {
            StoreV2ProductItemVO r3 = (StoreV2ProductItemVO) r2;
            Intrinsics.checkNotNullParameter(r3, "item");
            ECShopSlcProductCardGroupPresenter.l0(this.a.b, r3);
        }
    }

    public static final class b implements com.bytedance.android.shopping.store.hybridproduct.actionhandler.d {
        public final /* synthetic */ ECShopSlcProductCardGroupPresenter$actionHandler$1 a;

        @Override // com.bytedance.android.shopping.store.hybridproduct.actionhandler.d
        public final Map<String, Object> a() {
            ECStoreViewModel r0 = this.a.b.A;
            if (r0 == null) goto L7;
            com.bytedance.android.shopping.store.slicecard.b r1 = r0.getSliceService();
            if (r1 == null) goto L7;
            return r1.a();
        L7:
            return null;
        }

        @Override // com.bytedance.android.shopping.store.hybridproduct.actionhandler.d
        public final String b() {
            ECShopSlcProductCardGroupPresenter r0 = this.a.b;
            Lazy r1 = ECShopSlcProductCardGroupPresenter.B;
            return r0.r0().getStoreParam().getSecShopId();
        }

        @Override // com.bytedance.android.shopping.store.hybridproduct.actionhandler.d
        public final String getPassThroughApi() {
            ECShopSlcProductCardGroupPresenter r0 = this.a.b;
            Lazy r1 = ECShopSlcProductCardGroupPresenter.B;
            return (String) r0.r0().getStoreParam().getPassThroughParam("pass_through_api");
        }

        @Override // com.bytedance.android.shopping.store.hybridproduct.actionhandler.d
        public final String getShopId() {
            ECShopSlcProductCardGroupPresenter r0 = this.a.b;
            Lazy r1 = ECShopSlcProductCardGroupPresenter.B;
            String r2 = r0.r0().getStoreParam().getShopId();
            if (r2 != null) goto L6;
            return "";
        L6:
            return r2;
        }

        @Override // com.bytedance.android.shopping.store.hybridproduct.actionhandler.d
        public final boolean isClickable() {
            ECShopSlcProductCardGroupPresenter r0 = this.a.b;
            Lazy r1 = ECShopSlcProductCardGroupPresenter.B;
            return !r0.r0().getStoreParam().isPreview();
        }

        public b(ECShopSlcProductCardGroupPresenter$actionHandler$1 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.store.hybridproduct.actionhandler.d
        public final void c(Map r4) {
            Intrinsics.checkNotNullParameter("click_ecom_element", "actionName");
            ECShopSlcProductCardGroupPresenter r0 = this.a.b;
            Lazy r2 = ECShopSlcProductCardGroupPresenter.B;
            r0.r0().doEventAction("click_ecom_element", r4, new Pair[0]);
        }

        @Override // com.bytedance.android.shopping.store.hybridproduct.actionhandler.d
        public final void d(Map<String, ? extends Object> r3) {
            Intrinsics.checkNotNullParameter(r3, "dataCtx");
            Object r0 = ((sm.m) this.a.b).n.a.get(Reflection.getOrCreateKotlinClass(sm.n.class));
            if ((r0 instanceof sm.n) == true) goto L5;
            r0 = null;
        L5:
            sm.n r1 = (sm.n) r0;
            if (r1 == null) goto L9;
            r1.a(r3);
            return;
        }
    }

    public ECShopSlcProductCardGroupPresenter$actionHandler$1(ECShopSlcProductCardGroupPresenter r5, Fragment r6) {
        this.b = r5;
        LinkedHashMap r7 = new LinkedHashMap();
        r7.put(SliceActionType.PRODUCT_ADD_CART, new AddProductActionHandler(new ECShopSlcProductCardGroupPresenter$actionHandler$1$$special$$inlined$apply$lambda$1(this), new a(this), r6));
        r7.put(SliceActionType.PRODUCT_SUBSCRIBE, new com.bytedance.android.shopping.store.hybridproduct.actionhandler.g(new b(this), r6));
        Unit r8 = Unit.INSTANCE;
        this.a = r7;
    }

    @Override // com.bytedance.android.shopping.store.slicecard.a
    public final void b(StoreV2ProductItemVO r1, View r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r1, "item");
        Intrinsics.checkNotNullParameter(r2, "target");
        com.bytedance.android.shopping.store.slicecard.a.C0017a.c(r1, r2);
    }

    @Override // com.bytedance.android.shopping.store.slicecard.a
    public final void a(ShopSlcProductItemV2 r1, View r2, Map<String, ? extends Object> r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r1, "item");
        Intrinsics.checkNotNullParameter(r2, "target");
        Intrinsics.checkNotNullParameter(r1, "item");
        Intrinsics.checkNotNullParameter(r2, "target");
    }

    @Override // com.bytedance.android.shopping.store.slicecard.a
    public final void c(SliceActionType r1, ShopSlcProductItemV2 r2, View r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r1, "actionType");
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "target");
        com.bytedance.android.shopping.store.slicecard.a.C0017a.b(r1, r2, r3);
    }

    @Override // com.bytedance.android.shopping.store.slicecard.a
    public final void d(SliceActionType r2, StoreV2ProductItemVO r3, View r4, Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r2, "actionType");
        Intrinsics.checkNotNullParameter(r3, "item");
        Intrinsics.checkNotNullParameter(r4, "target");
        com.bytedance.android.shopping.store.slicecard.a r6 = (com.bytedance.android.shopping.store.slicecard.a) ((LinkedHashMap) this.a).get(r2);
        if (r6 == null) goto L6;
        r6.b(r3, r4, r5);
        return;
    }
}
