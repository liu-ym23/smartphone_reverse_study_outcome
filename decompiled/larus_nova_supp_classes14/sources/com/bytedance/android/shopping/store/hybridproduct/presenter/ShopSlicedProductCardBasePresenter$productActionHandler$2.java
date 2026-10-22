package com.bytedance.android.shopping.store.hybridproduct.presenter;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.common.param.ProductBasicRequestParam;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.repository.vo.ShopSlcProductItemV2;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.shopping.store.hybridproduct.actionhandler.AddProductActionHandler;
import com.bytedance.android.shopping.store.router.hybridpage.slice.SliceProductCardData;
import com.bytedance.android.shopping.store.router.hybridpage.viewmodel.HybridPageViewModel;
import com.bytedance.android.shopping.store.slicecard.SliceActionType;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0007\n\u0002\b\u0004*\u0001\u0000\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"com/bytedance/android/shopping/store/hybridproduct/presenter/ShopSlicedProductCardBasePresenter$productActionHandler$2$c", "invoke", "()Lcom/bytedance/android/shopping/store/hybridproduct/presenter/ShopSlicedProductCardBasePresenter$productActionHandler$2$c;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class ShopSlicedProductCardBasePresenter$productActionHandler$2 extends Lambda implements Function0<c> {
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ ShopSlicedProductCardBasePresenter this$0;

    public static final class a implements com.bytedance.android.shopping.store.hybridproduct.actionhandler.a<ShopSlcProductItemV2> {
        public final /* synthetic */ ShopSlicedProductCardBasePresenter$productActionHandler$2 a;

        public a(ShopSlicedProductCardBasePresenter$productActionHandler$2 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.store.hybridproduct.actionhandler.a
        public final void a(com.bytedance.android.shopping.store.hybridproduct.extension.d r10) {
            Intrinsics.checkNotNullParameter((ShopSlcProductItemV2) r10, "item");
            ShopSlicedProductCardBasePresenter r11 = this.a.this$0;
            SliceProductCardData r0 = r11.o;
            String r1 = null;
            if (r0 == null) goto L5;
            String r2 = r0.getEcomEntranceFrom();
        L7:
            if (r2 != null) goto L9;
        L11:
            boolean r4 = false;
        L12:
            if (r4 == true) goto L15;
            r2 = null;
        L15:
            if (r2 != null) goto L31;
            SliceProductCardData r3 = r11.o;
            if (r3 == null) goto L19;
            String r5 = r3.getPageName();
        L21:
            if (Intrinsics.areEqual(r5, "classification_secondary_page") == false) goto L23;
            r2 = "classification";
            goto L31
        L23:
            SliceProductCardData r6 = r11.o;
            if (r6 == null) goto L30;
            ProductBasicRequestParam r7 = r6.getProductBasicRequestParam();
            if (r7 == null) goto L30;
            if (r7.isCustom() != true) goto L30;
            r2 = "featured";
        L30:
            r2 = "products";
            goto L31
        L19:
            r5 = null;
        L31:
            com.bytedance.commerce.base.json.a[] r8 = new com.bytedance.commerce.base.json.a[10];
            r8[0] = JsonDslUtilKt.d("carrier_source", "store_page");
            r8[1] = JsonDslUtilKt.d("store_type", "shop");
            r8[2] = JsonDslUtilKt.d("source_method", r2);
            ShopSlcProductItemV2 r9 = r11.k;
            if (r9 != null) goto L34;
            Intrinsics.throwUninitializedPropertyAccessException("currentItem");
        L34:
            r8[3] = JsonDslUtilKt.d("source_method_second", r11.i0(r9));
            com.bytedance.android.shopping.store.router.hybridpage.presenter.product.c r12 = r11.p;
            if (r12 == null) goto L39;
            jm.a<LayoutTypes> r13 = r12.a();
            if (r13 == null) goto L39;
            LayoutTypes r14 = (LayoutTypes) r13.getValue();
        L40:
            if (r14 != null) goto L43;
        L44:
            String r15 = "double_product";
        L46:
            r8[4] = JsonDslUtilKt.d("product_form", r15);
            r8[5] = JsonDslUtilKt.d("is_discount_selected", "0");
            SliceProductCardData r16 = r11.o;
            if (r16 == null) goto L49;
            String r17 = r16.getShareContent();
        L51:
            if (Intrinsics.areEqual(r17, "shop") == false) goto L53;
            String r18 = "share_alert";
        L58:
            r8[6] = JsonDslUtilKt.d("product_source_page", r18);
            SliceProductCardData r19 = r11.o;
            if (r19 == null) goto L61;
            String r20 = r19.getStoreSourcePage();
        L62:
            String r21 = "";
            if (r20 != null) goto L65;
            r20 = "";
        L65:
            r8[7] = JsonDslUtilKt.d("store_source_page", r20);
            SliceProductCardData r22 = r11.o;
            if (r22 == null) goto L68;
            String r23 = r22.getStoreSourceMethod();
        L69:
            if (r23 != null) goto L71;
            r23 = "";
        L71:
            r8[8] = JsonDslUtilKt.d("store_source_method", r23);
            SliceProductCardData r24 = r11.o;
            if (r24 == null) goto L74;
            r1 = r24.getStoreGroupType();
        L74:
            if (r1 == null) goto L77;
            r21 = r1;
        L77:
            r8[9] = JsonDslUtilKt.d("store_group_type", r21);
            String r25 = JsonDslUtilKt.a(r8).toString();
            HybridPageViewModel r26 = ((com.bytedance.android.shopping.store.router.hybridpage.presenter.product.d) r11).x;
            if (r26 == null) goto L83;
            int r27 = com.bytedance.android.ec.store.product.presenter.utils.a.a;
            ShopSlcProductItemV2 r110 = r11.k;
            if (r110 != null) goto L82;
            Intrinsics.throwUninitializedPropertyAccessException("currentItem");
        L82:
            r26.doEventAction("click_add_to_cart", com.bytedance.android.ec.store.product.presenter.utils.a.c(r110), new Pair[]{TuplesKt.to("entrance_info", r25), TuplesKt.to("bst_group_type", "product")});
        L83:
            com.bytedance.android.ec.sdk.helper.d.b.getClientAiService();
            return;
        L68:
            r23 = null;
            goto L69
        L61:
            r20 = null;
            goto L62
        L53:
            SliceProductCardData r28 = r11.o;
            if (r28 == null) goto L56;
            String r29 = r28.getEntranceLocation();
        L57:
            r18 = String.valueOf(r29);
            goto L58
        L56:
            r29 = null;
            goto L57
        L49:
            r17 = null;
            goto L51
        L43:
            if (b0.a[r14.ordinal()] != 1) goto L44;
            r15 = "single_product";
        L39:
            r14 = null;
            goto L40
        L9:
            if ((!StringsKt.isBlank(r2)) != true) goto L11;
            r4 = true;
            goto L12
        L5:
            r2 = null;
            goto L7
        }
    }

    public static final class b implements com.bytedance.android.shopping.store.hybridproduct.actionhandler.d {
        public final /* synthetic */ ShopSlicedProductCardBasePresenter$productActionHandler$2 a;

        @Override // com.bytedance.android.shopping.store.hybridproduct.actionhandler.d
        public final Map<String, Object> a() {
            com.bytedance.android.shopping.store.router.hybridpage.presenter.product.c r0 = this.a.this$0.p;
            if (r0 == null) goto L7;
            com.bytedance.android.shopping.store.slicecard.b r1 = r0.b();
            if (r1 == null) goto L7;
            return r1.a();
        L7:
            return null;
        }

        @Override // com.bytedance.android.shopping.store.hybridproduct.actionhandler.d
        public final String b() {
            SliceProductCardData r0 = this.a.this$0.o;
            if (r0 == null) goto L5;
            String r1 = r0.getSecShopId();
        L7:
            return com.bytedance.android.shopping.extensions.k.j(r1);
        L5:
            r1 = null;
            goto L7
        }

        @Override // com.bytedance.android.shopping.store.hybridproduct.actionhandler.d
        public final String getPassThroughApi() {
            SliceProductCardData r0 = this.a.this$0.o;
            if (r0 != null) goto L7;
            return null;
        L7:
            return (String) r0.getPassThroughParam("pass_through_api");
        }

        @Override // com.bytedance.android.shopping.store.hybridproduct.actionhandler.d
        public final String getShopId() {
            SliceProductCardData r0 = this.a.this$0.o;
            if (r0 == null) goto L5;
            String r1 = r0.getShopId();
        L6:
            if (r1 != null) goto L9;
            return "";
        L9:
            return r1;
        L5:
            r1 = null;
            goto L6
        }

        @Override // com.bytedance.android.shopping.store.hybridproduct.actionhandler.d
        public final boolean isClickable() {
            SliceProductCardData r0 = this.a.this$0.o;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if ((!r0.isPreview()) != true) goto L7;
            return true;
        }

        public b(ShopSlicedProductCardBasePresenter$productActionHandler$2 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.store.hybridproduct.actionhandler.d
        public final void c(Map r4) {
            Intrinsics.checkNotNullParameter("click_ecom_element", "actionName");
            HybridPageViewModel r0 = ((com.bytedance.android.shopping.store.router.hybridpage.presenter.product.d) this.a.this$0).x;
            if (r0 == null) goto L6;
            r0.doEventAction("click_ecom_element", r4, new Pair[0]);
            return;
        }

        @Override // com.bytedance.android.shopping.store.hybridproduct.actionhandler.d
        public final void d(Map<String, ? extends Object> r3) {
            Intrinsics.checkNotNullParameter(r3, "dataCtx");
            com.bytedance.android.ecom.arch.slice.render.r r0 = this.a.this$0.v;
            if (r0 == null) goto L6;
            com.bytedance.android.ecom.arch.slice.render.r.a r1 = com.bytedance.android.ecom.arch.slice.render.r.d;
            r0.a(r3, null);
            return;
        }
    }

    public static final class c implements com.bytedance.android.shopping.store.slicecard.a {
        public final /* synthetic */ ShopSlicedProductCardBasePresenter$productActionHandler$2 a;
        public final /* synthetic */ Map b;

        public c(ShopSlicedProductCardBasePresenter$productActionHandler$2 r1, Map r2) {
            this.a = r1;
            this.b = r2;
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
        public final void c(SliceActionType r3, ShopSlcProductItemV2 r4, View r5, Map<String, ? extends Object> r6) {
            Intrinsics.checkNotNullParameter(r3, "actionType");
            Intrinsics.checkNotNullParameter(r4, "item");
            Intrinsics.checkNotNullParameter(r5, "target");
            com.bytedance.android.shopping.store.slicecard.a.C0017a.b(r3, r4, r5);
            if (r3 != SliceActionType.OPEN_PRODUCT_DETAIL) goto L5;
            ShopSlicedProductCardBasePresenter r0 = this.a.this$0;
            Map<String, ? extends Object> r1 = MapsKt.mapOf(TuplesKt.to("event_params", MapsKt.plus(r0.f, r0.g)));
        L6:
            com.bytedance.android.shopping.store.slicecard.a r7 = (com.bytedance.android.shopping.store.slicecard.a) this.b.get(r3);
            if (r7 == null) goto L10;
            r7.a(r4, r5, r6, r1);
            return;
        L10:
            return;
        L5:
            r1 = MapsKt.emptyMap();
            goto L6
        }

        @Override // com.bytedance.android.shopping.store.slicecard.a
        public final void d(SliceActionType r1, StoreV2ProductItemVO r2, View r3, Map<String, ? extends Object> r4) {
            Intrinsics.checkNotNullParameter(r1, "actionType");
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "target");
            com.bytedance.android.shopping.store.slicecard.a.C0017a.a(r1, r2, r3);
        }
    }

    public ShopSlicedProductCardBasePresenter$productActionHandler$2(ShopSlicedProductCardBasePresenter r1, Fragment r2) {
        this.this$0 = r1;
        this.$fragment = r2;
        super(0);
    }

    public final c invoke() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put(SliceActionType.PRODUCT_ADD_CART, new AddProductActionHandler(new ShopSlicedProductCardBasePresenter$productActionHandler$2$$special$$inlined$apply$lambda$1(this), new a(this), this.$fragment));
        SliceActionType r1 = SliceActionType.OPEN_PRODUCT_DETAIL;
        com.bytedance.android.shopping.store.router.hybridpage.presenter.product.d r2 = (com.bytedance.android.shopping.store.router.hybridpage.presenter.product.d) this.this$0;
        r2.getClass();
        r0.put(r1, new com.bytedance.android.shopping.store.router.hybridpage.presenter.product.b(r2, ((QFragmentPresenter) r2).e, r2.x.getSliceProductCardData(), r2.x));
        r0.put(SliceActionType.PRODUCT_SUBSCRIBE, new com.bytedance.android.shopping.store.hybridproduct.actionhandler.g(new b(this), this.$fragment));
        return new c(this, r0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m251invoke() {
        return invoke();
    }
}
