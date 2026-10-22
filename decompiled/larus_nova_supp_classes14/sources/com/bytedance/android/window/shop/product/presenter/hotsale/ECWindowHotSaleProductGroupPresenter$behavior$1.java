package com.bytedance.android.window.shop.product.presenter.hotsale;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.core.utils.m0;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.ec.window.base.common.datachannel.ECWindowProductForm;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.window.shop.home.ECWindowParam;
import com.bytedance.android.window.shop.home.tab.WindowTabEventReporter;
import com.bytedance.android.window.shop.home.tab.WindowTabViewModelDeprecated;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.product.utils.WindowBstReport;
import com.bytedance.android.window.shop.product.utils.c;
import com.bytedance.android.window.shop.widget.product.WindowFollowCouponTagView;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import rp.a;
import sq3.h;
import uq3.s;
import yo.g;
import zq3.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowHotSaleProductGroupPresenter$behavior$1 implements g {
    public final /* synthetic */ ECWindowHotSaleProductGroupPresenter a;

    public ECWindowHotSaleProductGroupPresenter$behavior$1(ECWindowHotSaleProductGroupPresenter r1) {
        this.a = r1;
    }

    public final void a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r2, "tag");
    }

    public final void b(WindowV2ProductItemVO r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        int r0 = a.a;
        if (a.a(r4.a.hashCode()) == false) goto L5;
        return;
    L5:
        ECWindowHotSaleProductGroupPresenter.k0(this.a, r4, WindowTabEventReporter.HotSaleProductClickArea.OTHER, "c3406.d8964_i" + ((Integer) r4.C.a(wn.a.C)));
    }

    public final void c(WindowV2ProductItemVO r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        ECWindowHotSaleProductGroupPresenter.k0(this.a, r4, WindowTabEventReporter.HotSaleProductClickArea.BUY, "c3406.d09577_i" + ((Integer) r4.C.a(wn.a.C)));
    }

    public final void d(WindowV2ProductItemVO r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r2, "item");
    }

    public final void e(final WindowV2ProductItemVO r3) {
        Intrinsics.checkNotNullParameter(r3, "item");
        ((WindowTabViewModelDeprecated) this.a.o.getValue()).runLowPriorityTask(new ECWindowHotSaleProductGroupPresenter$behavior$1$onDisplaySource$1(this, r3));
    }

    public final void f(WindowFollowCouponTagView r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r2, "tag");
    }

    public final void g(WindowV2ProductItemVO r6) {
        Intrinsics.checkNotNullParameter(r6, "item");
        int r0 = WindowTabEventReporter.a;
        ECWindowParam r1 = this.a.l0().getShopParam();
        ECWindowProductForm r2 = ECWindowProductForm.SINGLE_PRODUCT;
        QContext r3 = this.a.Y();
        FragmentActivity r4 = l0.c(r3.c());
        if ((r4 instanceof FragmentActivity) == true) goto L5;
        r4 = null;
    L5:
        if (r4 != null) goto L7;
        r4 = r3.a();
    L7:
        Map r5 = WindowTabEventReporter.a(r6, r1, r2, r4, "live_top_101");
        Map r7 = r6.q;
        if (r7 == null) goto L10;
        r5.putAll(r7);
    L10:
        r5.put("bst_group_type", "product");
        r5.put("bst_tag", "bst_tag");
        int r8 = WindowBstReport.a;
        View r9 = this.a.a0();
        String r10 = "c3406.d8964_i" + ((Integer) r6.C.a(wn.a.C));
        ECWindowViewModel r11 = this.a.l0();
        Intrinsics.checkNotNullParameter(r5, "eventParams");
        Intrinsics.checkNotNullParameter(r11, "reporter");
        WindowBstReport.e(r9, r10, r6, new c(r11, r5, r5));
        if (((WindowTabViewModelDeprecated) this.a.o.getValue()).shouldReportEvent(wn.a.k, r6.a) == true) goto L13;
        return;
    L13:
        ((WindowTabViewModelDeprecated) this.a.o.getValue()).runLowPriorityTask(ECWindowHotSaleProductGroupPresenter$behavior$1$onDisplay$2.INSTANCE);
    }

    public final void h(WindowV2ProductItemVO r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r2, "item");
    }

    public final void i(WindowV2ProductItemVO r19) {
        Intrinsics.checkNotNullParameter(r19, "item");
        String r2 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("c3406.d18983_i" + ((Integer) r19.C.a(wn.a.C)), Boolean.FALSE).withBtmPage(this.a.p.getValue()).build());
        ECWindowViewModel r3 = this.a.l0();
        int r4 = WindowTabEventReporter.a;
        QContext r5 = this.a.Y();
        Activity r6 = l0.c(r5.c());
        if ((r6 instanceof FragmentActivity) == true) goto L5;
        r6 = null;
    L5:
        if (r6 != null) goto L7;
        r6 = r5.a();
    L7:
        ECWindowParam r7 = this.a.l0().getShopParam();
        Intrinsics.checkNotNullParameter(r6, "activity");
        Intrinsics.checkNotNullParameter(r7, "shopParam");
        Intrinsics.checkNotNullParameter(r19, "productVo");
        Map r8 = WindowTabEventReporter.b(r7);
        r8.put("product_id", r19.a);
        r8.put("commodity_id", r19.b);
        r8.put("carrier_source", "store_page");
        r8.put("source_method", "live_top");
        r8.put("source_method_second", "live_top_101");
        ECWindowProductForm r13 = ECWindowProductForm.SINGLE_PRODUCT;
        r8.put("product_form", r13.getDes());
        r8.put("product_source_page", r7.getEntranceLocation());
        r8.put("store_source_page", r7.getStoreSourcePage());
        r8.put("store_source_method", r7.getStoreSourceMethod());
        r8.put("store_group_type", r7.getStoreGroupType());
        r8.put("btm_id", r2);
        PageFinder r14 = PageFinder.via(r2);
        com.bytedance.commerce.base.json.a[] r9 = new com.bytedance.commerce.base.json.a[8];
        r9[0] = JsonDslUtilKt.d("author_id", r7.getAuthorId());
        String r1 = r19.b;
        if (r1 != null) goto L10;
        r1 = "";
    L10:
        r9[1] = JsonDslUtilKt.d("promotion_id", r1);
        r9[2] = JsonDslUtilKt.d("carrier_source", "store_page");
        r9[3] = JsonDslUtilKt.d("source_method", "live_top");
        r9[4] = JsonDslUtilKt.d("source_method_second", "live_top_101");
        r9[5] = JsonDslUtilKt.d("product_form", r13.getDes());
        r9[6] = JsonDslUtilKt.d("bst_group_type", "product");
        r9[7] = JsonDslUtilKt.d("btm_id", String.valueOf(r2));
        JSONObject r0 = JsonDslUtilKt.a(r9);
        xn.c.b(r0, r6);
        JSONObject r10 = EcomBcmTracker.c(r14, r0);
        if (r10 != null) goto L13;
        r10 = new JSONObject();
    L13:
        r8.put("entrance_info", r10.toString());
        r3.doEventAction("click_add_to_cart", r8, new Pair[]{TuplesKt.to("bst_group_type", "product")});
    }

    public final void j(WindowV2ProductItemVO r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r2, "item");
    }

    public final void k(h r9) {
        Intrinsics.checkNotNullParameter(r9, "item");
        ECWindowHotSaleProductGroupPresenter r0 = this.a;
        r0.getClass();
        s r1 = r9.U;
        FragmentActivity r2 = null;
        if (r1 == null) goto L5;
        Long r3 = Long.valueOf(r1.b);
    L6:
        long r4 = k.h(r3);
        String r5 = "c3406.d65850_i" + ((Integer) ((WindowV2ProductItemVO) r9).C.a(wn.a.C));
        m0 r6 = new m0("sslocal://goods/window/innerflow");
        r6.a("author_id", r0.l0().getShopParam().getAuthorId());
        r6.a("uid", r0.l0().getShopParam().getAuthorId());
        r6.a("sec_uid", r0.l0().getShopParam().getSecAuthorId());
        r6.a("enter_from", r0.l0().getShopParam().getEnterFrom());
        r6.a("enter_method", r0.l0().getShopParam().getEnterMethod());
        r6.a("which_account", r0.l0().getShopParam().getWhichAccount());
        r6.a("search_hint", th.a.f(r0.Y().c()).getString(2131895922));
        r6.a("product_source_page", r0.l0().getShopParam().getEntranceLocation());
        r6.a("store_source_page", r0.l0().getShopParam().getStoreSourcePage());
        r6.a("store_source_method", r0.l0().getShopParam().getStoreSourceMethod());
        r6.a("store_group_type", r0.l0().getShopParam().getStoreGroupType());
        r6.a("search_params", r0.l0().getShopParam().getSearchParams());
        r6.a("entrance_location", r0.l0().getShopParam().getEntranceLocation());
        r6.a("tmp_id", r0.l0().getShopParam().getTempId());
        r6.a("inner_flow_type", String.valueOf(5));
        r6.a("custom_ids", String.valueOf(r4));
        r6.a("pass_through_api", (String) r0.l0().getShopParam().getPassThroughParam("pass_through_api"));
        BtmSDK r7 = BtmSDK.INSTANCE;
        PageFinder r8 = PageFinder.via(r0.a0());
        int r10 = f.a;
        r6.a("source_btm_token", r7.createJumpSourceBtmToken(r5, r8, f.a(r0.l0().getShopParam().getAuthorId(), r9)));
        r0.l0().getLiveManager().c();
        p.a.openSchema(r0.Y().c(), r6.c());
        int r11 = WindowTabEventReporter.a;
        ECWindowParam r12 = this.a.l0().getShopParam();
        ECWindowProductForm r13 = ECWindowProductForm.SINGLE_PRODUCT;
        QContext r14 = this.a.Y();
        FragmentActivity r15 = l0.c(r14.c());
        if ((r15 instanceof FragmentActivity) == false) goto L10;
        r2 = r15;
    L10:
        if (r2 != null) goto L12;
        r2 = r14.a();
    L12:
        Map r16 = WindowTabEventReporter.a(r9, r12, r13, r2, "live_top_101");
        Map r17 = ((WindowV2ProductItemVO) r9).q;
        if (r17 == null) goto L15;
        r16.putAll(r17);
    L15:
        r16.put("click_area", String.valueOf(WindowTabEventReporter.HotSaleProductClickArea.WATCH_PLAY_BACK.getPosition()));
        this.a.l0().doEventAction("click_product", r16, new Pair[0]);
        return;
    L5:
        r3 = null;
        goto L6
    }
}
