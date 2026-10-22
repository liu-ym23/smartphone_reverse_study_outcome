package com.bytedance.android.shopping.store.product.presenter.aggregate;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.adapter.api.j;
import com.bytedance.android.ec.model.response.anchorv3.SourceType;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.ec.store.repository.vo.l;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.aggregate.ShopAggregateParam;
import com.bytedance.android.shopping.store.aggregate.viewmodel.ShopAggregatePageProductViewModel;
import com.larus.apm.impl.protector.RunnableProtector;
import im.v;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import sm.g;
import sm.h;
import sm.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopClassificationProductCardGroupPresenter extends m {
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final a s;

    public static final class a implements g {
        public final /* synthetic */ ECShopClassificationProductCardGroupPresenter a;
        public final /* synthetic */ Fragment b;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.store.product.presenter.aggregate.ECShopClassificationProductCardGroupPresenter$a$a, reason: collision with other inner class name */
        public static final class RunnableC0010a implements Runnable {
            public final /* synthetic */ a a;
            public final /* synthetic */ StoreV2ProductItemVO b;
            public final /* synthetic */ Map c;

            public RunnableC0010a(a r1, StoreV2ProductItemVO r2, Map r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int r0 = com.bytedance.android.ec.store.window.f.a;     // Catch: Throwable -> L4
                com.bytedance.android.ec.store.window.f.e(this.a.a.a0(), this.a.l(this.b), this.b, this.c, ECShopClassificationProductCardGroupPresenter.k0(this.a.a));     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
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

        public final void e(StoreV2ProductItemVO r6) {
            Intrinsics.checkNotNullParameter(r6, "item");
            ShopAggregatePageProductViewModel r0 = ECShopClassificationProductCardGroupPresenter.k0(this.a);
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
            if (ECShopClassificationProductCardGroupPresenter.k0(this.a).getIdRecords().contains(r6.a) == true) goto L16;
            Map<String, String> r2 = k(r6);
            r2.put("btm_id", new BtmItemBuilder(l(r6), null, 2, null).withPageFinder(PageFinder.via(this.b)).obtainEventBtmParams());
            this.a.a0().post(new RunnableC0010a(this, r6, r2));
        L16:
            ECShopClassificationProductCardGroupPresenter.k0(this.a).getIdRecords().add(r6.a);
            return;
        }

        public final void f(StoreV2ProductItemVO r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r2, "item");
        }

        public final void g(StoreV2ProductItemVO r41) {
            Intrinsics.checkNotNullParameter(r41, "item");
            ShopAggregatePageProductViewModel r1 = ECShopClassificationProductCardGroupPresenter.k0(this.a);
            String r10 = null;
            if (r1.isStoreParamInit() == true) goto L6;
            r1 = null;
        L6:
            if (r1 == null) goto L84;
            ShopAggregateParam r11 = r1.getStoreParam();
            if (r11 == null) goto L85;
            c.a(r41, this.a.Y(), r11.getStoreSourcePage(), r11.getStoreSourceMethod());
            int r2 = com.bytedance.android.ec.store.product.presenter.utils.a.a;
            JSONObject r12 = com.bytedance.android.ec.store.product.presenter.utils.a.e(r11.getSearchParams(), r41);
            BtmItemBuilder r13 = new BtmItemBuilder(l(r41), null, 2, null).withPageFinder(PageFinder.via(this.b));
            BtmSDK r3 = BtmSDK.INSTANCE;
            String r4 = l(r41);
            PageFinder r5 = PageFinder.via(this.b);
            BcmParams r6 = new BcmParams();
            r6.put("bst_group_type", "product");
            Unit r7 = Unit.INSTANCE;
            String r37 = r3.createJumpSourceBtmToken(r4, r5, r6);
            if (k.c(r41.l) == false) goto L17;
            int r8 = ECSdk.a;
            IAdapterService r9 = (IAdapterService) ECSdk.a(IAdapterService.class);
            if (r9 == null) goto L17;
            j r14 = r9.getLiveWindowService();
            if (r14 == null) goto L17;
            r14.stopShowFloat();
        L17:
            List r15 = com.bytedance.android.ec.store.utils.c.a;
            com.bytedance.android.ec.store.utils.c.a(r41.a);
            JSONObject r16 = b.a(ECShopClassificationProductCardGroupPresenter.k0(this.a), r41, (String) this.a.q.getValue(), (String) this.a.r.getValue(), r11.getTabLabel() + "_" + r41.v, false, 128);
            String r17 = r41.b;
            boolean r18 = true;
            if (r17 != null) goto L20;
        L27:
            r17 = r41.a;
        L28:
            r16.put("promotion_id", r17);
            r16.put("product_ratio", r41.b());
            LayoutTypes r19 = (LayoutTypes) ECShopClassificationProductCardGroupPresenter.k0(this.a).getLayoutType().getValue();
            if (r19 != null) goto L32;
        L33:
            String r20 = "double_product";
        L35:
            r16.put("product_form", r20);
            String r21 = "";
            if (k.c(r41.C) == false) goto L44;
            Context r110 = this.a.Y().c();
            String r22 = r41.C;
            if (r22 != null) goto L40;
            String r111 = "";
        L42:
            if (com.bytedance.android.shopping.store.product.presenter.aggregate.a.d(r110, r111, r37, String.valueOf(r11.getFollowStatus()), r16, ECShopClassificationProductCardGroupPresenter.k0(this.a).getAdParams(), r41.a) == true) goto L79;
            return;
        L79:
            Map<String, String> r23 = k(r41);
            r23.put("btm_id", r13.obtainEventBtmParams());
            int r24 = com.bytedance.android.ec.store.window.f.a;
            View r25 = this.a.a0();
            String r26 = l(r41);
            ShopAggregatePageProductViewModel r27 = ECShopClassificationProductCardGroupPresenter.k0(this.a);
            Intrinsics.checkNotNullParameter(r25, "view");
            Intrinsics.checkNotNullParameter(r26, "btm");
            Intrinsics.checkNotNullParameter(r13, "btmItemBuilder");
            Intrinsics.checkNotNullParameter(r41, "item");
            Intrinsics.checkNotNullParameter(r23, "params");
            Intrinsics.checkNotNullParameter(r27, "reporter");
            com.bytedance.android.ec.store.window.g r28 = com.bytedance.android.ec.store.window.f.a(r23, r27);
            Intrinsics.checkNotNullParameter(r25, "view");
            Intrinsics.checkNotNullParameter(r26, "btm");
            Intrinsics.checkNotNullParameter(r13, "btmItemBuilder");
            Intrinsics.checkNotNullParameter(r41, "item");
            Intrinsics.checkNotNullParameter(r28, "reporter");
            String r29 = r41.b;
            if (r29 != null) goto L82;
            r29 = r41.a;
        L82:
            r26.length();
            com.bytedance.android.bst.api.d r30 = new com.bytedance.android.bst.api.d(r25);
            r30.a = r26;
            r30.b = "click_product";
            r30.c = r29;
            r30.d = "shopping";
            r30.e = -1;
            r30.f = r28;
            com.bytedance.android.bst.api.f.b.getClass();
            com.bytedance.android.bst.api.f.c(r30);
            dm.a.a("SHOP").i("[click classification product]productId:" + r41.a);
            dm.a.a("SHOP").i("[click classification product]secShopId:" + r11.getSecShopId());
            return;
        L40:
            r111 = r22;
            goto L42
        L44:
            hm.b r112 = hm.b.c;
            Context r113 = this.a.Y().c();
            String r31 = r41.b;
            if (r31 != null) goto L47;
        L54:
            r31 = r41.a;
        L55:
            String r114 = r31;
            String r115 = r11.getPageName();
            String r32 = r41.l;
            String r33 = ((h) this.a.p.getValue()).a();
            if (r33 != null) goto L58;
            String r116 = "";
        L59:
            String r34 = ((h) this.a.p.getValue()).d();
            if (r34 != null) goto L62;
            String r210 = "";
        L63:
            String r35 = r41.a;
            Integer r211 = r11.getFollowStatus();
            String r212 = r11.getWhichAccount();
            String r36 = r41.b;
            if (r36 == null) goto L67;
            r21 = r36;
        L67:
            String r213 = com.bytedance.android.shopping.store.product.presenter.aggregate.a.a(r16, r21, "store_page");
            if (r12 == null) goto L70;
            String r214 = r12.toString();
        L71:
            JSONObject r215 = com.bytedance.android.shopping.store.product.presenter.aggregate.a.c(ECShopClassificationProductCardGroupPresenter.k0(this.a));
            String r216 = (String) CollectionsKt.getOrNull(r41.f, 0);
            v r38 = r41.u;
            if (r38 == null) goto L74;
            r10 = r38.i();
        L74:
            String r39 = r10;
            Long r40 = r41.c;
            if (r40 == null) goto L77;
            long r42 = r40.longValue();
        L78:
            com.bytedance.android.ec.store.common.starter.e.a(r112, r113, r114, r115, r32, r116, r210, r35, r211, "classification", r212, r213, r214, r215, r216, true, r39, r42, null, ECShopClassificationProductCardGroupPresenter.k0(this.a).getAdParams(), null, null, r37, null, 199753728);
            goto L79
        L77:
            r42 = SourceType.UNKNOWN.getType();
            goto L78
        L70:
            r214 = null;
            goto L71
        L62:
            r210 = r34;
            goto L63
        L58:
            r116 = r33;
            goto L59
        L47:
            if (r31.length() > 0) goto L50;
            r18 = false;
        L50:
            if (r18 == true) goto L53;
            r31 = null;
        L53:
            if (r31 != null) goto L55;
        L32:
            if (f.a[r19.ordinal()] != 1) goto L33;
            r20 = "single_product";
            goto L35
        L20:
            if (r17.length() <= 0) goto L22;
            boolean r43 = true;
        L23:
            if (r43 == true) goto L26;
            r17 = null;
        L26:
            if (r17 != null) goto L28;
        L22:
            r43 = false;
            goto L23
        L85:
            return;
        }

        public final void h(StoreV2ProductItemVO r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r2, "item");
        }

        public final Map<String, String> k(StoreV2ProductItemVO r6) {
            ShopAggregatePageProductViewModel r0 = ECShopClassificationProductCardGroupPresenter.k0(this.a);
            String r2 = null;
            if (r0.isStoreParamInit() == true) goto L6;
            r0 = null;
        L6:
            if (r0 == null) goto L8;
            ShopAggregateParam r1 = r0.getStoreParam();
        L9:
            Map<String, String> r3 = MapsKt.toMutableMap(com.bytedance.android.ec.store.product.presenter.utils.a.d(r6));
            ShopAggregatePageProductViewModel r4 = ECShopClassificationProductCardGroupPresenter.k0(this.a);
            StringBuilder r5 = new StringBuilder();
            if (r1 == null) goto L12;
            r2 = r1.getTabLabel();
        L12:
            if (r2 != null) goto L14;
            r2 = "";
        L14:
            r5.append(r2);
            r5.append("_");
            r5.append(r6.v);
            r3.putAll(com.bytedance.android.shopping.store.product.presenter.aggregate.a.b(r4, "classification", r5.toString()));
            r3.put("tab_name", (String) this.a.q.getValue());
            r3.put("tab_name_second", (String) this.a.r.getValue());
            LayoutTypes r7 = (LayoutTypes) ECShopClassificationProductCardGroupPresenter.k0(this.a).getLayoutType().getValue();
            if (r7 != null) goto L18;
        L19:
            String r8 = "double_product";
        L21:
            r3.put("product_form", r8);
            return r3;
        L18:
            if (f.b[r7.ordinal()] != 1) goto L19;
            r8 = "single_product";
            goto L21
        L8:
            r1 = null;
            goto L9
        }

        public final String l(StoreV2ProductItemVO r4) {
            Intrinsics.checkNotNullParameter(r4, "item");
            StringBuilder r0 = new StringBuilder();
            if (((h) this.a.p.getValue()).c() != LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE) goto L5;
            String r1 = "a1.b56317.c2429.d00357";
        L6:
            r0.append(r1);
            r0.append("_i");
            r0.append(r4.v);
            return r0.toString();
        L5:
            r1 = "a1.b56317.c2429.d3147";
            goto L6
        }

        public a(ECShopClassificationProductCardGroupPresenter r1, Fragment r2) {
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
        return this.s;
    }

    public static final ShopAggregatePageProductViewModel k0(ECShopClassificationProductCardGroupPresenter r0) {
        return (ShopAggregatePageProductViewModel) r0.o.getValue();
    }

    public ECShopClassificationProductCardGroupPresenter(Fragment r2, final int r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.o = LazyKt.lazy(new ECShopClassificationProductCardGroupPresenter$viewModel$2(this));
        this.p = LazyKt.lazy(new ECShopClassificationProductCardGroupPresenter$adapter$2(this));
        this.q = LazyKt.lazy(new ECShopClassificationProductCardGroupPresenter$tabName$2(this));
        this.r = LazyKt.lazy(new ECShopClassificationProductCardGroupPresenter$tabNameSecond$2(this, r3));
        this.s = new a(this, r2);
    }
}
