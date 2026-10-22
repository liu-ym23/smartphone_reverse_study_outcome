package com.bytedance.android.shopping.store.home;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.entity.ToolType;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopShareHelper extends d {
    public final Lazy g;
    public final b h;
    public final a i;
    public final ECStoreTabKitFragment j;

    public static final class a implements com.bytedance.android.shopping.store.home.a {
        public final /* synthetic */ ECShopShareHelper a;

        @Override // com.bytedance.android.shopping.store.home.a
        public final void a() {
            ECShopShareHelper.g(this.a).doEventAction("share_store", new Pair[0]);
            ECShopShareHelper.g(this.a).doEventAction("show_shop_qr_code", new Pair[]{TuplesKt.to("panel_style", "new")});
            int r0 = com.bytedance.android.ec.store.utils.h.a;
            com.bytedance.android.ec.store.utils.h.d(ECShopShareHelper.g(this.a).getEntranceInfoJsonObject(), "share", "share_sign", ECShopShareHelper.g(this.a).getAdParams(), "shop_window_ad");
        }

        @Override // com.bytedance.android.shopping.store.home.a
        public final void b() {
            ECShopShareHelper.g(this.a).setEnterOtherPageCollaspeHeader(true);
            ECShopShareHelper.g(this.a).doEventAction("click_cart_entrance", "a1.b6269.c5887.d31199", PageFinder.via(this.a.j.getView()), new Pair[]{TuplesKt.to("click_area", "share_panel")});
        }

        @Override // com.bytedance.android.shopping.store.home.a
        public final void c() {
            ECShopShareHelper.g(this.a).setEnterOtherPageCollaspeHeader(true);
            ECShopShareHelper.g(this.a).doEventAction("click_order_entrance", "a1.b6269.c5887.d3813", PageFinder.via(this.a.j.getView()), new Pair[]{TuplesKt.to("enter_from", "others_store_page"), TuplesKt.to("click_area", "share_panel")});
        }

        @Override // com.bytedance.android.shopping.store.home.a
        public final void d() {
            ECShopShareHelper.g(this.a).doEventAction("click_member_entrance", "a1.b6269.c25145.d289907", PageFinder.via(this.a.j.getView()), new Pair[]{TuplesKt.to("enter_from", "others_store_page"), TuplesKt.to("click_area", "share_panel")});
        }

        @Override // com.bytedance.android.shopping.store.home.a
        public final void e() {
            ECShopShareHelper.g(this.a).doEventAction("show_cart_entrance", new Pair[]{TuplesKt.to("click_area", "share_panel")});
        }

        @Override // com.bytedance.android.shopping.store.home.a
        public final void f() {
            ECShopShareHelper.g(this.a).doEventAction("show_order_entrance", new Pair[]{TuplesKt.to("click_area", "share_panel")});
        }

        @Override // com.bytedance.android.shopping.store.home.a
        public final void g() {
            ECShopShareHelper.g(this.a).doEventAction("show_consultation", new Pair[]{TuplesKt.to("click_area", "share_panel")});
        }

        @Override // com.bytedance.android.shopping.store.home.a
        public final void i() {
            ECShopShareHelper.g(this.a).doEventAction("show_member_entrance", new Pair[]{TuplesKt.to("click_area", "share_panel")});
        }

        @Override // com.bytedance.android.shopping.store.home.a
        public final void j() {
            ECShopShareHelper.g(this.a).setEnterOtherPageCollaspeHeader(true);
            ECShopShareHelper.g(this.a).doEventAction("click_consultation", new Pair[]{TuplesKt.to("click_area", "share_panel")});
        }

        @Override // com.bytedance.android.shopping.store.home.a
        public final void k() {
            ECShopShareHelper.g(this.a).doEventAction("shop_tools_panel_entrance_show", "a1.b6269.c25145.d289907", PageFinder.via(this.a.j.getView()), new Pair[]{TuplesKt.to("entry_name", com.bytedance.android.shopping.store.home.view.f.a(ToolType.COUPON_RED_PACK))});
        }

        public a(ECShopShareHelper r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.store.home.a
        public final void h(ToolType r5) {
            Intrinsics.checkNotNullParameter(r5, "toolType");
            ECShopShareHelper.g(this.a).doEventAction("shop_tools_panel_entrance_click", "a1.b6269.c25145.d289907", PageFinder.via(this.a.j.getView()), new Pair[]{TuplesKt.to("entry_name", com.bytedance.android.shopping.store.home.view.f.a(r5))});
        }
    }

    public static final class b implements f0 {
        public final /* synthetic */ ECShopShareHelper a;

        @Override // com.bytedance.android.shopping.store.home.f0
        public final String b() {
            ECStoreParam r0 = ECShopShareHelper.g(this.a).getStoreParam();
            if (r0 == null) goto L5;
            String r1 = r0.getSecShopId();
        L6:
            if (r1 != null) goto L9;
            return "";
        L9:
            return r1;
        L5:
            r1 = null;
            goto L6
        }

        @Override // com.bytedance.android.shopping.store.home.f0
        public final String getPassThroughApi() {
            return (String) ECShopShareHelper.g(this.a).getStoreParam().getPassThroughParam("pass_through_api");
        }

        @Override // com.bytedance.android.shopping.store.home.f0
        public final String getShopId() {
            ECStoreParam r0 = ECShopShareHelper.g(this.a).getStoreParam();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getShopId();
        }

        public b(ECShopShareHelper r1) {
            this.a = r1;
        }
    }

    @Override // com.bytedance.android.shopping.store.home.d
    public final com.bytedance.android.shopping.store.home.a c() {
        return this.i;
    }

    @Override // com.bytedance.android.shopping.store.home.d
    public final f0 d() {
        return this.h;
    }

    public ECShopShareHelper(ECStoreTabKitFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "frgament");
        super(r2);
        this.j = r2;
        this.g = LazyKt.lazy(new ECShopShareHelper$viewModel$2(this));
        this.h = new b(this);
        this.i = new a(this);
    }

    public static final ECStoreViewModel g(ECShopShareHelper r0) {
        return (ECStoreViewModel) r0.g.getValue();
    }
}
