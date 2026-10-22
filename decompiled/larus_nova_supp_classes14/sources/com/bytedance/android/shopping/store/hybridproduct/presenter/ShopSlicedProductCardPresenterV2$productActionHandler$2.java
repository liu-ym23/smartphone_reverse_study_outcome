package com.bytedance.android.shopping.store.hybridproduct.presenter;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.common.headlive.StoreV3LiveRoomVO;
import com.bytedance.android.ec.store.common.param.ProductBasicRequestParam;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.repository.vo.ShopSlcProductItemV2;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.hybridproduct.actionhandler.AddProductActionHandler;
import com.bytedance.android.shopping.store.slicecard.SliceActionType;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
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
@Metadata(d1 = {"\u0000\u0007\n\u0002\b\u0004*\u0001\u0000\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"com/bytedance/android/shopping/store/hybridproduct/presenter/ShopSlicedProductCardPresenterV2$productActionHandler$2$c", "invoke", "()Lcom/bytedance/android/shopping/store/hybridproduct/presenter/ShopSlicedProductCardPresenterV2$productActionHandler$2$c;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class ShopSlicedProductCardPresenterV2$productActionHandler$2 extends Lambda implements Function0<c> {
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ ShopSlicedProductCardPresenterV2 this$0;

    public static final class a implements com.bytedance.android.shopping.store.hybridproduct.actionhandler.a<ShopSlcProductItemV2> {
        public final /* synthetic */ ShopSlicedProductCardPresenterV2$productActionHandler$2 a;

        public a(ShopSlicedProductCardPresenterV2$productActionHandler$2 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.store.hybridproduct.actionhandler.a
        public final void a(com.bytedance.android.shopping.store.hybridproduct.extension.d r10) {
            Intrinsics.checkNotNullParameter((ShopSlcProductItemV2) r10, "item");
            ShopSlicedProductCardPresenterV2 r11 = this.a.this$0;
            ECShopHybridProductViewModel r0 = r11.k0();
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
            if (r2 != null) goto L35;
            ECShopHybridProductViewModel r3 = r11.k0();
            if (r3 == null) goto L21;
            ECStoreParam r5 = r3.getStoreParam();
            if (r5 == null) goto L21;
            String r6 = r5.getPageName();
        L23:
            if (Intrinsics.areEqual(r6, "classification_secondary_page") == false) goto L25;
            r2 = "classification";
            goto L35
        L25:
            ECShopHybridProductViewModel r7 = r11.k0();
            if (r7 == null) goto L34;
            ECStoreParam r8 = r7.getStoreParam();
            if (r8 == null) goto L34;
            ProductBasicRequestParam r9 = r8.getProductBasicRequestParam();
            if (r9 == null) goto L34;
            if (r9.isCustom() != true) goto L34;
            r2 = "featured";
        L34:
            r2 = "products";
        L21:
            r6 = null;
        L35:
            com.bytedance.commerce.base.json.a[] r12 = new com.bytedance.commerce.base.json.a[10];
            r12[0] = JsonDslUtilKt.d("carrier_source", "store_page");
            r12[1] = JsonDslUtilKt.d("store_type", "shop");
            r12[2] = JsonDslUtilKt.d("source_method", r2);
            ShopSlcProductItemV2 r13 = r11.l;
            if (r13 != null) goto L38;
            Intrinsics.throwUninitializedPropertyAccessException("currentItem");
        L38:
            r12[3] = JsonDslUtilKt.d("source_method_second", r11.j0(r13));
            ECShopHybridProductViewModel r14 = r11.k0();
            if (r14 == null) goto L43;
            jm.a<LayoutTypes> r15 = r14.getLayoutType();
            if (r15 == null) goto L43;
            LayoutTypes r16 = (LayoutTypes) r15.getValue();
        L44:
            if (r16 != null) goto L47;
        L48:
            String r17 = "double_product";
        L50:
            r12[4] = JsonDslUtilKt.d("product_form", r17);
            ECShopHybridProductViewModel r18 = r11.k0();
            if (r18 != null) goto L53;
        L55:
            String r19 = "0";
        L56:
            r12[5] = JsonDslUtilKt.d("is_discount_selected", r19);
            ECShopHybridProductViewModel r20 = r11.k0();
            if (r20 == null) goto L61;
            ECStoreParam r21 = r20.getStoreParam();
            if (r21 == null) goto L61;
            String r22 = r21.getShareContent();
        L63:
            if (Intrinsics.areEqual(r22, "shop") == false) goto L65;
            String r23 = "share_alert";
        L72:
            r12[6] = JsonDslUtilKt.d("product_source_page", r23);
            ECShopHybridProductViewModel r24 = r11.k0();
            if (r24 == null) goto L77;
            ECStoreParam r25 = r24.getStoreParam();
            if (r25 == null) goto L77;
            String r26 = r25.getStoreSourcePage();
        L78:
            String r27 = "";
            if (r26 != null) goto L81;
            r26 = "";
        L81:
            r12[7] = JsonDslUtilKt.d("store_source_page", r26);
            ECShopHybridProductViewModel r28 = r11.k0();
            if (r28 == null) goto L86;
            ECStoreParam r29 = r28.getStoreParam();
            if (r29 == null) goto L86;
            String r30 = r29.getStoreSourceMethod();
        L87:
            if (r30 != null) goto L89;
            r30 = "";
        L89:
            r12[8] = JsonDslUtilKt.d("store_source_method", r30);
            ECShopHybridProductViewModel r31 = r11.k0();
            if (r31 == null) goto L94;
            ECStoreParam r32 = r31.getStoreParam();
            if (r32 == null) goto L94;
            r1 = r32.getStoreGroupType();
        L94:
            if (r1 == null) goto L97;
            r27 = r1;
        L97:
            r12[9] = JsonDslUtilKt.d("store_group_type", r27);
            String r33 = JsonDslUtilKt.a(r12).toString();
            ECShopHybridProductViewModel r34 = r11.k0();
            if (r34 == null) goto L103;
            int r35 = com.bytedance.android.ec.store.product.presenter.utils.a.a;
            ShopSlcProductItemV2 r36 = r11.l;
            if (r36 != null) goto L102;
            Intrinsics.throwUninitializedPropertyAccessException("currentItem");
        L102:
            r34.doEventAction("click_add_to_cart", com.bytedance.android.ec.store.product.presenter.utils.a.c(r36), new Pair[]{TuplesKt.to("entrance_info", r33), TuplesKt.to("bst_group_type", "product")});
        L103:
            ECShopHybridProductViewModel r37 = r11.k0();
            if (r37 == null) goto L109;
            ShopSlcProductItemV2 r38 = r11.l;
            if (r38 != null) goto L108;
            Intrinsics.throwUninitializedPropertyAccessException("currentItem");
        L108:
            r37.doEventAction("add_to_cart_click", r11.i0("click_product", r38), new Pair[0]);
        L109:
            com.bytedance.android.ec.sdk.helper.d.b.getClientAiService();
            return;
        L86:
            r30 = null;
        L77:
            r26 = null;
            goto L78
        L65:
            ECShopHybridProductViewModel r39 = r11.k0();
            if (r39 == null) goto L70;
            ECStoreParam r40 = r39.getStoreParam();
            if (r40 == null) goto L70;
            String r41 = r40.getEntranceLocation();
        L71:
            r23 = String.valueOf(r41);
        L70:
            r41 = null;
        L61:
            r22 = null;
            goto L63
        L53:
            if (r18.hasDiscountSelected() != true) goto L55;
            r19 = CommentScene.COMMENTSCENE_NO_AWEME;
            goto L56
        L47:
            if (i0.a[r16.ordinal()] != 1) goto L48;
            r17 = "single_product";
        L43:
            r16 = null;
            goto L44
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
        public final /* synthetic */ ShopSlicedProductCardPresenterV2$productActionHandler$2 a;

        @Override // com.bytedance.android.shopping.store.hybridproduct.actionhandler.d
        public final Map<String, Object> a() {
            ECStoreViewModel r0 = this.a.this$0.u;
            if (r0 == null) goto L7;
            com.bytedance.android.shopping.store.slicecard.b r1 = r0.getSliceService();
            if (r1 == null) goto L7;
            return r1.a();
        L7:
            return null;
        }

        @Override // com.bytedance.android.shopping.store.hybridproduct.actionhandler.d
        public final String b() {
            ECShopHybridProductViewModel r0 = this.a.this$0.k0();
            if (r0 == null) goto L7;
            ECStoreParam r1 = r0.getStoreParam();
            if (r1 == null) goto L7;
            String r2 = r1.getSecShopId();
        L9:
            return com.bytedance.android.shopping.extensions.k.j(r2);
        L7:
            r2 = null;
            goto L9
        }

        @Override // com.bytedance.android.shopping.store.hybridproduct.actionhandler.d
        public final String getPassThroughApi() {
            ECShopHybridProductViewModel r0 = this.a.this$0.k0();
            if (r0 == null) goto L7;
            ECStoreParam r1 = r0.getStoreParam();
            if (r1 == null) goto L7;
            return (String) r1.getPassThroughParam("pass_through_api");
        L7:
            return null;
        }

        @Override // com.bytedance.android.shopping.store.hybridproduct.actionhandler.d
        public final String getShopId() {
            ECShopHybridProductViewModel r0 = this.a.this$0.k0();
            if (r0 == null) goto L7;
            ECStoreParam r1 = r0.getStoreParam();
            if (r1 == null) goto L7;
            String r2 = r1.getShopId();
        L8:
            if (r2 != null) goto L11;
            return "";
        L11:
            return r2;
        L7:
            r2 = null;
            goto L8
        }

        @Override // com.bytedance.android.shopping.store.hybridproduct.actionhandler.d
        public final boolean isClickable() {
            ECShopHybridProductViewModel r0 = this.a.this$0.k0();
            if (r0 == null) goto L9;
            ECStoreParam r1 = r0.getStoreParam();
            if (r1 == null) goto L9;
            if ((!r1.isPreview()) != true) goto L9;
            return true;
        L9:
            return false;
        }

        public b(ShopSlicedProductCardPresenterV2$productActionHandler$2 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.store.hybridproduct.actionhandler.d
        public final void c(Map r4) {
            Intrinsics.checkNotNullParameter("click_ecom_element", "actionName");
            ECShopHybridProductViewModel r0 = this.a.this$0.k0();
            if (r0 == null) goto L6;
            r0.doEventAction("click_ecom_element", r4, new Pair[0]);
            return;
        }

        @Override // com.bytedance.android.shopping.store.hybridproduct.actionhandler.d
        public final void d(Map<String, ? extends Object> r3) {
            Intrinsics.checkNotNullParameter(r3, "dataCtx");
            com.bytedance.android.ecom.arch.slice.render.r r0 = this.a.this$0.s;
            if (r0 == null) goto L6;
            com.bytedance.android.ecom.arch.slice.render.r.a r1 = com.bytedance.android.ecom.arch.slice.render.r.d;
            r0.a(r3, null);
            return;
        }
    }

    public static final class c implements com.bytedance.android.shopping.store.slicecard.a {
        public final /* synthetic */ ShopSlicedProductCardPresenterV2$productActionHandler$2 a;
        public final /* synthetic */ Map b;

        public c(ShopSlicedProductCardPresenterV2$productActionHandler$2 r1, Map r2) {
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
        public final void c(SliceActionType r4, ShopSlcProductItemV2 r5, View r6, Map<String, ? extends Object> r7) {
            Intrinsics.checkNotNullParameter(r4, "actionType");
            Intrinsics.checkNotNullParameter(r5, "item");
            Intrinsics.checkNotNullParameter(r6, "target");
            com.bytedance.android.shopping.store.slicecard.a.C0017a.b(r4, r5, r6);
            if (r4 != SliceActionType.OPEN_PRODUCT_DETAIL) goto L9;
            Pair[] r0 = new Pair[2];
            ShopSlicedProductCardPresenterV2 r1 = this.a.this$0;
            r0[0] = TuplesKt.to("event_params", MapsKt.plus(r1.g, r1.h));
            StoreV3LiveRoomVO r2 = (StoreV3LiveRoomVO) this.a.this$0.u.getLiveInfo().b.getValue();
            if (r2 == null) goto L7;
            String r3 = r2.getRoomId();
        L8:
            r0[1] = TuplesKt.to("live_room_id", r3);
            Map<String, ? extends Object> r8 = MapsKt.mapOf(r0);
        L10:
            com.bytedance.android.shopping.store.slicecard.a r9 = (com.bytedance.android.shopping.store.slicecard.a) this.b.get(r4);
            if (r9 == null) goto L14;
            r9.a(r5, r6, r7, r8);
            return;
        L14:
            return;
        L7:
            r3 = null;
            goto L8
        L9:
            r8 = MapsKt.emptyMap();
            goto L10
        }

        @Override // com.bytedance.android.shopping.store.slicecard.a
        public final void d(SliceActionType r1, StoreV2ProductItemVO r2, View r3, Map<String, ? extends Object> r4) {
            Intrinsics.checkNotNullParameter(r1, "actionType");
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "target");
            com.bytedance.android.shopping.store.slicecard.a.C0017a.a(r1, r2, r3);
        }
    }

    public ShopSlicedProductCardPresenterV2$productActionHandler$2(ShopSlicedProductCardPresenterV2 r1, Fragment r2) {
        this.this$0 = r1;
        this.$fragment = r2;
        super(0);
    }

    public final c invoke() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put(SliceActionType.PRODUCT_ADD_CART, new AddProductActionHandler(new ShopSlicedProductCardPresenterV2$productActionHandler$2$$special$$inlined$apply$lambda$1(this), new a(this), this.$fragment));
        SliceActionType r1 = SliceActionType.OPEN_PRODUCT_DETAIL;
        Fragment r3 = this.$fragment;
        ShopSlicedProductCardPresenterV2 r4 = this.this$0;
        r0.put(r1, new com.bytedance.android.shopping.store.hybridproduct.actionhandler.e(r3, r4.u, r4.k0()));
        r0.put(SliceActionType.PRODUCT_SUBSCRIBE, new com.bytedance.android.shopping.store.hybridproduct.actionhandler.g(new b(this), this.$fragment));
        return new c(this, r0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m257invoke() {
        return invoke();
    }
}
