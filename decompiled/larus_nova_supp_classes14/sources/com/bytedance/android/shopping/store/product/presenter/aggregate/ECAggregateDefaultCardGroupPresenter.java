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
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import org.json.JSONObject;
import sm.g;
import sm.h;
import sm.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECAggregateDefaultCardGroupPresenter extends m {
    public final Lazy o;
    public final Lazy p;
    public final a q;

    public static final class a implements g {
        public final /* synthetic */ ECAggregateDefaultCardGroupPresenter a;
        public final /* synthetic */ Fragment b;

        public final Pair[] k() {
            ShopAggregatePageProductViewModel r0 = ECAggregateDefaultCardGroupPresenter.k0(this.a);
            String r2 = null;
            if (r0.isStoreParamInit() == true) goto L6;
            r0 = null;
        L6:
            if (r0 == null) goto L8;
            ShopAggregateParam r1 = r0.getStoreParam();
        L9:
            Pair[] r3 = new Pair[11];
            r3[0] = TuplesKt.to("ecom_entrance_form", "products");
            if (r1 == null) goto L12;
            String r4 = r1.getTabLabel();
        L13:
            r3[1] = TuplesKt.to("tab_label", r4);
            if (r1 == null) goto L16;
            String r5 = r1.getTempId();
        L17:
            r3[2] = TuplesKt.to("temp_id", r5);
            if (r1 == null) goto L22;
            ProductBasicRequestParam r6 = r1.getProductBasicRequestParam();
            if (r6 == null) goto L22;
            String r7 = r6.getMaterialId();
        L23:
            r3[3] = TuplesKt.to("customer_id", r7);
            r3[4] = TuplesKt.to("page_type", "product_list");
            if (r1 == null) goto L26;
            String r8 = r1.getSearchParams();
        L27:
            r3[5] = TuplesKt.to("search_params", r8);
            r3[6] = TuplesKt.to("content_source", "shop");
            r3[7] = TuplesKt.to("tab_name", "products");
            if (r1 == null) goto L30;
            r2 = r1.getTabNameSecond();
        L30:
            r3[8] = TuplesKt.to("tab_name_second", r2);
            if (r1 != null) goto L33;
        L35:
            Pair r9 = TuplesKt.to("", "");
        L36:
            r3[9] = r9;
            if (r1 != null) goto L39;
        L41:
            Pair r10 = TuplesKt.to("", "");
        L42:
            r3[10] = r10;
            return r3;
        L39:
            if (r1.isEcShare() != true) goto L41;
            r10 = TuplesKt.to("share_object", r1.getShareObject());
            goto L42
        L33:
            if (r1.isEcShare() != true) goto L35;
            r9 = TuplesKt.to("share_content", r1.getShareContent());
            goto L36
        L26:
            r8 = null;
        L22:
            r7 = null;
            goto L23
        L16:
            r5 = null;
            goto L17
        L12:
            r4 = null;
            goto L13
        L8:
            r1 = null;
            goto L9
        }

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

        public final void d(StoreV2ProductItemVO r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r2, "item");
        }

        public final void e(StoreV2ProductItemVO r5) {
            Intrinsics.checkNotNullParameter(r5, "item");
            ShopAggregatePageProductViewModel r0 = ECAggregateDefaultCardGroupPresenter.k0(this.a);
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
            if (ECAggregateDefaultCardGroupPresenter.k0(this.a).getIdRecords().contains(r5.a) == true) goto L16;
            ECAggregateDefaultCardGroupPresenter.k0(this.a).doEventAction("show_product", com.bytedance.android.ec.store.product.presenter.utils.a.d(r5), (Pair[]) Arrays.copyOf(k(), 11));
        L16:
            ECAggregateDefaultCardGroupPresenter.k0(this.a).getIdRecords().add(r5.a);
            return;
        }

        public final void f(StoreV2ProductItemVO r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r2, "item");
        }

        public final void g(StoreV2ProductItemVO r41) {
            Intrinsics.checkNotNullParameter(r41, "item");
            ShopAggregatePageProductViewModel r1 = ECAggregateDefaultCardGroupPresenter.k0(this.a);
            String r9 = null;
            if (r1.isStoreParamInit() == true) goto L6;
            r1 = null;
        L6:
            if (r1 == null) goto L56;
            ShopAggregateParam r10 = r1.getStoreParam();
            if (r10 == null) goto L57;
            c.a(r41, this.a.Y(), r10.getStoreSourcePage(), r10.getStoreSourceMethod());
            int r2 = com.bytedance.android.ec.store.product.presenter.utils.a.a;
            JSONObject r11 = com.bytedance.android.ec.store.product.presenter.utils.a.e(r10.getSearchParams(), r41);
            BtmItemBuilder r13 = new BtmItemBuilder("a1.b6269.c2429.d3147_i" + r41.v, null, 2, null).withPageFinder(PageFinder.via(this.b));
            BtmSDK r3 = BtmSDK.INSTANCE;
            String r4 = "a1.b6269.c2429.d3147_i" + r41.v;
            PageFinder r5 = PageFinder.via(this.b);
            BcmParams r6 = new BcmParams();
            r6.put("bst_group_type", "product");
            Unit r7 = Unit.INSTANCE;
            String r37 = r3.createJumpSourceBtmToken(r4, r5, r6);
            List r8 = com.bytedance.android.ec.store.utils.c.a;
            com.bytedance.android.ec.store.utils.c.a(r41.a);
            JSONObject r12 = b.a(ECAggregateDefaultCardGroupPresenter.k0(this.a), r41, "products", null, null, false, 248);
            String r14 = "";
            if (k.c(r41.C) == false) goto L19;
            Context r15 = this.a.Y().c();
            String r16 = r41.C;
            if (r16 != null) goto L15;
            String r17 = "";
        L17:
            if (com.bytedance.android.shopping.store.product.presenter.aggregate.a.d(r15, r17, r37, String.valueOf(r10.getFollowStatus()), r12, ECAggregateDefaultCardGroupPresenter.k0(this.a).getAdParams(), r41.a) == true) goto L54;
            return;
        L54:
            ShopAggregatePageProductViewModel r18 = ECAggregateDefaultCardGroupPresenter.k0(this.a);
            Map r19 = com.bytedance.android.ec.store.product.presenter.utils.a.d(r41);
            SpreadBuilder r20 = new SpreadBuilder(2);
            r20.addSpread(k());
            r20.add(TuplesKt.to("btm_id", r13.obtainEventBtmParams()));
            r18.doEventAction("click_product", r19, (Pair[]) r20.toArray(new Pair[r20.size()]));
            dm.a.a("SHOP").i("[click fulldiscount product]productId:" + r41.a);
            dm.a.a("SHOP").i("[click fulldiscount product]secShopId:" + r10.getSecShopId());
            return;
        L15:
            r17 = r16;
            goto L17
        L19:
            hm.b r110 = hm.b.c;
            Context r111 = this.a.Y().c();
            String r21 = r41.b;
            if (r21 != null) goto L22;
        L29:
            r21 = r41.a;
        L30:
            String r112 = r21;
            String r113 = r10.getPageName();
            String r22 = r41.l;
            String r23 = ((h) this.a.p.getValue()).a();
            if (r23 != null) goto L33;
            String r114 = "";
        L34:
            String r24 = ((h) this.a.p.getValue()).d();
            if (r24 != null) goto L37;
            String r25 = "";
        L38:
            String r26 = r41.a;
            Integer r27 = r10.getFollowStatus();
            String r28 = r10.getWhichAccount();
            String r29 = r41.b;
            if (r29 == null) goto L42;
            r14 = r29;
        L42:
            String r210 = com.bytedance.android.shopping.store.product.presenter.aggregate.a.a(r12, r14, r10.getPageName());
            if (r11 == null) goto L45;
            String r211 = r11.toString();
        L46:
            JSONObject r212 = com.bytedance.android.shopping.store.product.presenter.aggregate.a.c(ECAggregateDefaultCardGroupPresenter.k0(this.a));
            String r213 = (String) CollectionsKt.getOrNull(r41.f, 0);
            v r30 = r41.u;
            if (r30 == null) goto L49;
            r9 = r30.i();
        L49:
            String r31 = r9;
            Long r32 = r41.c;
            if (r32 == null) goto L52;
            long r33 = r32.longValue();
        L53:
            com.bytedance.android.ec.store.common.starter.e.a(r110, r111, r112, r113, r22, r114, r25, r26, r27, "featured", r28, r210, r211, r212, r213, true, r31, r33, null, ECAggregateDefaultCardGroupPresenter.k0(this.a).getAdParams(), null, null, r37, null, 199753728);
            goto L54
        L52:
            r33 = SourceType.UNKNOWN.getType();
            goto L53
        L45:
            r211 = null;
            goto L46
        L37:
            r25 = r24;
            goto L38
        L33:
            r114 = r23;
            goto L34
        L22:
            if (r21.length() <= 0) goto L24;
            boolean r34 = true;
        L25:
            if (r34 == true) goto L28;
            r21 = null;
        L28:
            if (r21 != null) goto L30;
        L24:
            r34 = false;
            goto L25
        L57:
            return;
        }

        public final void h(StoreV2ProductItemVO r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r2, "item");
        }

        public a(ECAggregateDefaultCardGroupPresenter r1, Fragment r2) {
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

    public ECAggregateDefaultCardGroupPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.o = LazyKt.lazy(new ECAggregateDefaultCardGroupPresenter$viewModel$2(this));
        this.p = LazyKt.lazy(new ECAggregateDefaultCardGroupPresenter$adapter$2(this));
        this.q = new a(this, r2);
    }

    public static final ShopAggregatePageProductViewModel k0(ECAggregateDefaultCardGroupPresenter r0) {
        return (ShopAggregatePageProductViewModel) r0.o.getValue();
    }
}
