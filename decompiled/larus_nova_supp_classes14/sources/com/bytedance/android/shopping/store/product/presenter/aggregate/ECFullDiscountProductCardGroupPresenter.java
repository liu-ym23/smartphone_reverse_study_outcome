package com.bytedance.android.shopping.store.product.presenter.aggregate;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.model.response.anchorv3.SourceType;
import com.bytedance.android.ec.store.common.param.ProductBasicRequestParam;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.ec.store.repository.vo.l;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.aggregate.ShopAggregateParam;
import com.bytedance.android.shopping.store.aggregate.viewmodel.ShopAggregatePageProductViewModel;
import im.v;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import sm.g;
import sm.h;
import sm.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECFullDiscountProductCardGroupPresenter extends m {
    public final Lazy o;
    public final Lazy p;
    public final a q;

    public static final class a implements g {
        public final /* synthetic */ ECFullDiscountProductCardGroupPresenter a;
        public final /* synthetic */ Fragment b;

        public final void a(View r2) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            Intrinsics.checkNotNullParameter(r2, "tag");
        }

        public final void b(StoreV2ProductItemVO r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r2, "item");
        }

        public final void c(StoreV2ProductItemVO r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r2, "item");
        }

        public final void d(StoreV2ProductItemVO r7) {
            Intrinsics.checkNotNullParameter(r7, "item");
            ShopAggregatePageProductViewModel r0 = ECFullDiscountProductCardGroupPresenter.k0(this.a);
            Integer r2 = null;
            if (r0.isStoreParamInit() == true) goto L6;
            r0 = null;
        L6:
            if (r0 == null) goto L8;
            ShopAggregateParam r1 = r0.getStoreParam();
        L9:
            ShopAggregatePageProductViewModel r3 = ECFullDiscountProductCardGroupPresenter.k0(this.a);
            Map r8 = com.bytedance.android.ec.store.product.presenter.utils.a.d(r7);
            Pair[] r4 = new Pair[7];
            r4[0] = TuplesKt.to("ecom_entrance_form", "featured");
            if (r1 == null) goto L12;
            String r5 = r1.getTempId();
        L13:
            r4[1] = TuplesKt.to("temp_id", r5);
            if (r1 == null) goto L18;
            ProductBasicRequestParam r6 = r1.getProductBasicRequestParam();
            if (r6 == null) goto L18;
            String r9 = r6.getMaterialId();
        L19:
            r4[2] = TuplesKt.to("customer_id", r9);
            r4[3] = TuplesKt.to("page_type", "product_list");
            if (r1 == null) goto L22;
            String r10 = r1.getSearchParams();
        L23:
            r4[4] = TuplesKt.to("search_params", r10);
            if (r1 == null) goto L26;
            r2 = r1.getFollowStatus();
        L26:
            r4[5] = TuplesKt.to("follow_status", String.valueOf(r2));
            r4[6] = TuplesKt.to("bst_group_type", "product");
            r3.doEventAction("click_add_to_cart", r8, r4);
            return;
        L22:
            r10 = null;
        L18:
            r9 = null;
            goto L19
        L12:
            r5 = null;
            goto L13
        L8:
            r1 = null;
            goto L9
        }

        public final void e(StoreV2ProductItemVO r5) {
            Intrinsics.checkNotNullParameter(r5, "item");
            ShopAggregatePageProductViewModel r0 = ECFullDiscountProductCardGroupPresenter.k0(this.a);
            if (r0.isStoreParamInit() == true) goto L6;
            r0 = null;
        L6:
            if (r0 == null) goto L18;
            ShopAggregateParam r1 = r0.getStoreParam();
            if (r1 != null) goto L11;
            return;
        L11:
            if (r1.isPreview() == false) goto L14;
            return;
        L14:
            if (ECFullDiscountProductCardGroupPresenter.k0(this.a).getIdRecords().contains(r5.a) == true) goto L16;
            Map<String, String> r2 = k(r5);
            int r3 = com.bytedance.android.ec.store.window.f.a;
            com.bytedance.android.ec.store.window.f.e(this.a.a0(), "a1.b741019.c2429.d3147_i" + r5.v, r5, r2, ECFullDiscountProductCardGroupPresenter.k0(this.a));
        L16:
            ECFullDiscountProductCardGroupPresenter.k0(this.a).getIdRecords().add(r5.a);
            return;
        }

        public final void f(StoreV2ProductItemVO r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r2, "item");
        }

        public final void g(StoreV2ProductItemVO r40) {
            Intrinsics.checkNotNullParameter(r40, "item");
            ShopAggregatePageProductViewModel r1 = ECFullDiscountProductCardGroupPresenter.k0(this.a);
            String r9 = null;
            if (r1.isStoreParamInit() == true) goto L6;
            r1 = null;
        L6:
            if (r1 == null) goto L53;
            ShopAggregateParam r10 = r1.getStoreParam();
            if (r10 == null) goto L54;
            c.a(r40, this.a.Y(), r10.getStoreSourcePage(), r10.getStoreSourceMethod());
            int r2 = com.bytedance.android.ec.store.product.presenter.utils.a.a;
            JSONObject r11 = com.bytedance.android.ec.store.product.presenter.utils.a.e(r10.getSearchParams(), r40);
            String r3 = "a1.b741019.c2429.d3147_i" + r40.v;
            new BtmItemBuilder(null, null, 3, null).withPageFinder(PageFinder.via(this.b));
            BtmSDK r4 = BtmSDK.INSTANCE;
            PageFinder r5 = PageFinder.via(this.b);
            BcmParams r6 = new BcmParams();
            r6.put("bst_group_type", "product");
            Unit r7 = Unit.INSTANCE;
            String r15 = r4.createJumpSourceBtmToken(r3, r5, r6);
            List r8 = com.bytedance.android.ec.store.utils.c.a;
            com.bytedance.android.ec.store.utils.c.a(r40.a);
            JSONObject r12 = b.a(ECFullDiscountProductCardGroupPresenter.k0(this.a), r40, "homepage_featured", null, null, true, 120);
            if (k.c(r40.C) == false) goto L16;
            int r13 = com.bytedance.android.ec.store.utils.b.a;
            String r18 = com.bytedance.android.ec.store.utils.b.a(r40.C, r15);
            if (r18 != null) goto L15;
            return;
        L15:
            hm.b r16 = hm.b.c;
            Context r17 = this.a.Y().c();
            String r19 = String.valueOf(r10.getFollowStatus());
            Map<String, Object> r14 = ECFullDiscountProductCardGroupPresenter.k0(this.a).getAdParams();
            r14.put("product_id", r40.a);
            com.bytedance.android.ec.store.common.starter.e.b(r16, r17, r18, r19, r12, r14, null, false, 448);
        L51:
            Map<String, String> r20 = k(r40);
            int r21 = com.bytedance.android.ec.store.window.f.a;
            com.bytedance.android.ec.store.window.f.c(this.a.a0(), "a1.b741019.c2429.d3147_i" + r40.v, r40, r20, ECFullDiscountProductCardGroupPresenter.k0(this.a));
            dm.a.a("SHOP").i("[click fulldiscount product]productId:" + r40.a);
            dm.a.a("SHOP").i("[click fulldiscount product]secShopId:" + r10.getSecShopId());
            return;
        L16:
            hm.b r110 = hm.b.c;
            Context r111 = this.a.Y().c();
            String r22 = r40.b;
            if (r22 != null) goto L19;
        L26:
            r22 = r40.a;
        L27:
            String r112 = r10.getPageName();
            String r23 = r40.l;
            String r24 = ((h) this.a.p.getValue()).a();
            String r25 = "";
            if (r24 != null) goto L30;
            String r113 = "";
        L31:
            String r26 = ((h) this.a.p.getValue()).d();
            if (r26 != null) goto L34;
            String r114 = "";
        L35:
            String r27 = r40.a;
            Integer r28 = r10.getFollowStatus();
            String r29 = r10.getWhichAccount();
            String r30 = r40.b;
            if (r30 == null) goto L39;
            r25 = r30;
        L39:
            String r210 = com.bytedance.android.shopping.store.product.presenter.aggregate.a.a(r12, r25, r10.getPageName());
            if (r11 == null) goto L42;
            String r211 = r11.toString();
        L43:
            JSONObject r212 = com.bytedance.android.shopping.store.product.presenter.aggregate.a.c(ECFullDiscountProductCardGroupPresenter.k0(this.a));
            String r213 = (String) CollectionsKt.getOrNull(r40.f, 0);
            v r31 = r40.u;
            if (r31 == null) goto L46;
            r9 = r31.i();
        L46:
            String r214 = r9;
            Long r32 = r40.c;
            if (r32 == null) goto L49;
            long r33 = r32.longValue();
        L50:
            com.bytedance.android.ec.store.common.starter.e.a(r110, r111, r22, r112, r23, r113, r114, r27, r28, "featured", r29, r210, r211, r212, r213, true, r214, r33, null, ECFullDiscountProductCardGroupPresenter.k0(this.a).getAdParams(), null, null, r15, null, 199753728);
            goto L51
        L49:
            r33 = SourceType.UNKNOWN.getType();
            goto L50
        L42:
            r211 = null;
            goto L43
        L34:
            r114 = r26;
            goto L35
        L30:
            r113 = r24;
            goto L31
        L19:
            if (r22.length() <= 0) goto L21;
            boolean r34 = true;
        L22:
            if (r34 == true) goto L25;
            r22 = null;
        L25:
            if (r22 != null) goto L27;
        L21:
            r34 = false;
            goto L22
        L54:
            return;
        }

        public final void h(StoreV2ProductItemVO r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r2, "item");
        }

        public final Map<String, String> k(StoreV2ProductItemVO r6) {
            ShopAggregatePageProductViewModel r0 = ECFullDiscountProductCardGroupPresenter.k0(this.a);
            String r2 = null;
            if (r0.isStoreParamInit() == true) goto L6;
            r0 = null;
        L6:
            if (r0 == null) goto L8;
            ShopAggregateParam r1 = r0.getStoreParam();
        L9:
            Map<String, String> r7 = MapsKt.toMutableMap(com.bytedance.android.ec.store.product.presenter.utils.a.d(r6));
            r7.putAll(com.bytedance.android.shopping.store.product.presenter.aggregate.a.b(ECFullDiscountProductCardGroupPresenter.k0(this.a), "homepage_featured", "fulldiscount"));
            r7.put("tab_name", "homepage_featured");
            if (r1 == null) goto L12;
            r2 = r1.getTabNameSecond();
        L12:
            r7.put("tab_name_second", r2);
            r7.put("source_method", "homepage_featured");
            r7.put("carrier_source", "store_page");
            return r7;
        L8:
            r1 = null;
            goto L9
        }

        public a(ECFullDiscountProductCardGroupPresenter r1, Fragment r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void i(StoreV2ProductItemVO r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "item");
            Intrinsics.checkNotNullParameter(r1, "item");
        }

        public final void j(l r2, Map r3, List r4, List r5) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "eventParams");
            Intrinsics.checkNotNullParameter(r4, "tagCodeList");
            Intrinsics.checkNotNullParameter(r5, "highlightTagCode");
            g.a.a(r2, r3, r4, r5);
        }
    }

    public final h i0() {
        return (h) this.p.getValue();
    }

    public final g h0() {
        return this.q;
    }

    public ECFullDiscountProductCardGroupPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.o = LazyKt.lazy(new ECFullDiscountProductCardGroupPresenter$viewModel$2(this));
        this.p = LazyKt.lazy(new ECFullDiscountProductCardGroupPresenter$adapter$2(this));
        this.q = new a(this, r2);
    }

    public static final ShopAggregatePageProductViewModel k0(ECFullDiscountProductCardGroupPresenter r0) {
        return (ShopAggregatePageProductViewModel) r0.o.getValue();
    }
}
