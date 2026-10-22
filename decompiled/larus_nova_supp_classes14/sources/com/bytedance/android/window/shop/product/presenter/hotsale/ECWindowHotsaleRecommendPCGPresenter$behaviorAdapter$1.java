package com.bytedance.android.window.shop.product.presenter.hotsale;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.btm.api.model.c;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.core.utils.m0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.response.anchorv3.SourceType;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.ec.window.base.common.datachannel.ECWindowProductForm;
import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductItemDTO;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.android.window.shop.home.ECWindowParam;
import com.bytedance.android.window.shop.home.tab.WindowTabEventReporter;
import com.bytedance.android.window.shop.home.tab.WindowTabViewModelDeprecated;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.product.utils.WindowBstReport;
import com.bytedance.android.window.shop.product.utils.b;
import com.bytedance.android.window.shop.router.WindowEntranceInfoExtKt;
import com.bytedance.android.window.shop.router.WindowEntranceInfoScene;
import com.bytedance.android.window.shop.widget.product.WindowFollowCouponTagView;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.awemeopen.apps.photo.pinch.PinchEnterMethod;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import rp.a;
import sq3.h;
import uq3.s;
import yn.u;
import yo.g;
import zq3.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowHotsaleRecommendPCGPresenter$behaviorAdapter$1 implements g {
    public boolean a;
    public final /* synthetic */ ECWindowHotsaleRecommendPCGPresenter b;

    public ECWindowHotsaleRecommendPCGPresenter$behaviorAdapter$1(ECWindowHotsaleRecommendPCGPresenter r1) {
        this.b = r1;
    }

    public final void a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r2, "tag");
    }

    public final void b(WindowV2ProductItemVO r50) {
        Intrinsics.checkNotNullParameter(r50, "item");
        int r2 = a.a;
        if (a.a(r50.a.hashCode()) == false) goto L5;
        return;
    L5:
        StringBuilder r3 = new StringBuilder("c3406.d643143_i");
        Integer r4 = (Integer) r50.C.a(wn.a.C);
        if (r4 == null) goto L8;
        int r5 = r4.intValue();
    L9:
        r3.append(r5);
        String r6 = r3.toString();
        Boolean r7 = Boolean.TRUE;
        c r8 = new BtmItemBuilder(r6, r7).withBtmPage(this.b.p.getValue()).build();
        BtmSDK r9 = BtmSDK.INSTANCE;
        r9.willJumpToNextPage(r8);
        BtmItemBuilder r10 = new BtmItemBuilder(r6, r7).withBtmPage(this.b.p.getValue());
        String r11 = r9.obtainEventBtmParams(r10.build());
        FragmentActivity r12 = null;
        if ((r50 instanceof h) == true) goto L12;
        WindowV2ProductItemVO r13 = null;
    L13:
        h r14 = (h) r13;
        if (r14 == null) goto L18;
        s r15 = r14.U;
        if (r15 == null) goto L18;
        Long r16 = Long.valueOf(r15.b);
    L19:
        String r17 = "";
        if (r16 == null) goto L26;
        long r18 = r16.longValue();
        String r19 = r50.b;
        if (r19 == null) goto L25;
        r17 = r19;
    L25:
        l(r18, r17);
    L123:
        int r20 = WindowTabEventReporter.a;
        ECWindowParam r21 = ECWindowHotsaleRecommendPCGPresenter.k0(this.b).getShopParam();
        ECWindowProductForm r22 = ECWindowProductForm.DOUBLE_PRODUCT;
        QContext r23 = this.b.Y();
        FragmentActivity r110 = l0.c(r23.c());
        if ((r110 instanceof FragmentActivity) == false) goto L127;
        r12 = r110;
    L127:
        if (r12 != null) goto L129;
        r12 = r23.a();
    L129:
        Map r24 = WindowTabEventReporter.a(r50, r21, r22, r12, "live_top_102");
        if (r11 == null) goto L132;
        r24.put("btm_id", r11);
    L132:
        Map r25 = r50.q;
        if (r25 == null) goto L135;
        r24.putAll(r25);
    L135:
        r24.put("bst_tag", "bst_tag");
        int r26 = WindowBstReport.a;
        View r27 = this.b.a0();
        ECWindowViewModel r28 = ECWindowHotsaleRecommendPCGPresenter.k0(this.b);
        Intrinsics.checkNotNullParameter(r24, "eventParams");
        Intrinsics.checkNotNullParameter(r28, "reporter");
        WindowBstReport.c(r27, r6, r10, r50, new b(r28, r24, r24));
        dm.a.a("WINDOW").i("[click hotsale recommend product]productId:" + r50.a);
        dm.a.a("WINDOW").i("[click hotsale recommend product]secAuthorId:" + ECWindowHotsaleRecommendPCGPresenter.k0(this.b).getShopParam().getSecAuthorId());
        return;
    L26:
        ECWindowParam r29 = ECWindowHotsaleRecommendPCGPresenter.k0(this.b).getShopParam();
        int r111 = com.bytedance.android.ec.window.base.product.presenter.utils.b.a;
        JSONObject r112 = com.bytedance.android.ec.window.base.product.presenter.utils.b.d(r29.getSearchParams(), r50);
        com.bytedance.commerce.base.json.a[] r113 = new com.bytedance.commerce.base.json.a[21];
        r113[0] = JsonDslUtilKt.d("product_source_page", r29.getEntranceLocation());
        r113[1] = JsonDslUtilKt.d("carrier_source", r29.getPageName());
        r113[2] = JsonDslUtilKt.d("source_method", "live_top");
        r113[3] = JsonDslUtilKt.d("source_method_second", "live_top_102");
        Integer r114 = r29.getFollowStatus();
        if (r114 == null) goto L30;
        String r115 = String.valueOf(r114.intValue());
        if (r115 == null) goto L30;
    L31:
        r113[4] = JsonDslUtilKt.d("follow_status", r115);
        r113[5] = JsonDslUtilKt.d("tab_label", "list_card");
        String r30 = r29.getTempId();
        if (r30 != null) goto L34;
        r30 = "";
    L34:
        r113[6] = JsonDslUtilKt.d("temp_id", r30);
        r113[7] = JsonDslUtilKt.d("ecom_group_type", "product");
        String r31 = r29.getStoreSourcePage();
        if (r31 != null) goto L37;
        r31 = "";
    L37:
        r113[8] = JsonDslUtilKt.d("store_source_page", r31);
        String r32 = r29.getStoreSourceMethod();
        if (r32 != null) goto L40;
        r32 = "";
    L40:
        r113[9] = JsonDslUtilKt.d("store_source_method", r32);
        String r33 = r29.getStoreGroupType();
        if (r33 != null) goto L43;
        r33 = "";
    L43:
        r113[10] = JsonDslUtilKt.d("store_group_type", r33);
        r113[11] = JsonDslUtilKt.d("pre_product_id", ECWindowHotsaleRecommendPCGPresenter.k0(this.b).getShopParam().getPreProductId());
        r113[12] = JsonDslUtilKt.d("pre_room_id", ECWindowHotsaleRecommendPCGPresenter.k0(this.b).getShopParam().getPreRoomId());
        r113[13] = JsonDslUtilKt.d("pre_group_id", ECWindowHotsaleRecommendPCGPresenter.k0(this.b).getShopParam().getPreGroupId());
        r113[14] = JsonDslUtilKt.d("store_type", "window");
        String r34 = r50.b;
        if (r34 != null) goto L46;
    L53:
        r34 = r50.a;
    L54:
        r113[15] = JsonDslUtilKt.d("promotion_id", r34);
        boolean r35 = k.c(r50.i);
        String r116 = CommentScene.COMMENTSCENE_NO_AWEME;
        if (r35 == false) goto L57;
        String r36 = CommentScene.COMMENTSCENE_NO_AWEME;
    L58:
        r113[16] = JsonDslUtilKt.d("is_price_info", r36);
        if (r50.d() != null) goto L62;
        r116 = "0";
    L62:
        r113[17] = JsonDslUtilKt.d("is_recommend_info", r116);
        WindowV2ProductItemDTO.b r37 = r50.v;
        if (r37 == null) goto L65;
        String r38 = r37.a();
    L66:
        r113[18] = JsonDslUtilKt.d("content_form", r38);
        r113[19] = JsonDslUtilKt.d("content_source", "shop");
        String r39 = r29.getWhichAccount();
        if (r39 != null) goto L69;
        r39 = "";
    L69:
        r113[20] = JsonDslUtilKt.d("which_account", r39);
        JSONObject r40 = JsonDslUtilKt.a(r113);
        if (r29.isEcShare() == false) goto L72;
        r40.accumulate("share_content", r29.getShareContent());
        r40.accumulate("share_object", r29.getShareObject());
    L72:
        Map r117 = r50.q;
        if (r117 == null) goto L78;
        Iterator r118 = r117.entrySet().iterator();
    L76:
        if (r118.hasNext() == false) goto L78;
        Map.Entry r119 = (Map.Entry) r118.next();
        r40.put((String) r119.getKey(), r119.getValue());
    L78:
        JSONObject r120 = z1.g((String) ECWindowHotsaleRecommendPCGPresenter.k0(this.b).getShopParam().getPassThroughParam("pass_through_api"));
        if (r120 == null) goto L81;
        r40.put(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, r120.optString(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID));
    L81:
        JSONObject r210 = WindowEntranceInfoExtKt.a(r40, WindowEntranceInfoScene.ENTER_PRODUCT_DETAIL, null);
        List r41 = com.bytedance.android.ec.window.base.utils.g.a;
        com.bytedance.android.ec.window.base.utils.g.a(r50.a);
        int r42 = com.bytedance.android.ec.window.base.product.presenter.utils.b.a;
        com.bytedance.android.ec.window.base.product.presenter.utils.b.g(PageFinder.via(this.b.a0()));
        if (k.c(r50.E) == false) goto L92;
        StringBuilder r43 = new StringBuilder("c3406.d643143_i");
        Integer r44 = (Integer) r50.C.a(wn.a.C);
        if (r44 == null) goto L86;
        int r45 = r44.intValue();
    L87:
        r43.append(r45);
        String r46 = r43.toString();
        int r47 = f.a;
        String r48 = r50.E;
        Intrinsics.checkNotNull(r48);
        String r211 = f.c(r48, r46, PageFinder.via(this.b.a0()), null);
        xn.b r121 = xn.b.f;
        Context r122 = this.b.Y().c();
        String r212 = String.valueOf(r29.getFollowStatus());
        Map r213 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("uid", r29.getAuthorId()), TuplesKt.to("product_id", r50.a)});
        u r49 = r50.w;
        if (r49 == null) goto L90;
        String r214 = r49.i();
    L91:
        com.bytedance.android.ec.window.base.common.starter.f.b(r121, r122, r211, r212, r210, r213, r214);
        goto L123
    L90:
        r214 = null;
        goto L91
    L86:
        r45 = 1;
        goto L87
    L92:
        xn.b r215 = xn.b.f;
        Context r216 = this.b.Y().c();
        String r51 = r50.b;
        if (r51 != null) goto L95;
    L102:
        r51 = r50.a;
    L103:
        String r217 = r51;
        String r218 = r29.getPageName();
        String r52 = r50.m;
        String r310 = r29.getAuthorId();
        String r311 = r29.getSecAuthorId();
        String r53 = r50.a;
        Integer r312 = r29.getFollowStatus();
        String r313 = r29.getWhichAccount();
        String r314 = r210.toString();
        if (r112 == null) goto L106;
        String r315 = r112.toString();
    L107:
        com.bytedance.commerce.base.json.a[] r54 = new com.bytedance.commerce.base.json.a[1];
        JSONObject r123 = z1.g((String) ECWindowHotsaleRecommendPCGPresenter.k0(this.b).getShopParam().getPassThroughParam("pass_through_api"));
        if (r123 == null) goto L110;
        String r124 = r123.optString(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID);
    L111:
        if (r124 == null) goto L114;
        r17 = r124;
    L114:
        r54[0] = JsonDslUtilKt.d(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, r17);
        JSONObject r316 = JsonDslUtilKt.a(r54);
        String r317 = (String) CollectionsKt.getOrNull(r50.h, 0);
        u r55 = r50.w;
        if (r55 == null) goto L117;
        String r410 = r55.i();
    L118:
        Long r56 = r50.c;
        if (r56 == null) goto L121;
        long r125 = r56.longValue();
    L122:
        com.bytedance.android.ec.window.base.common.starter.f.a(r215, r216, r217, r218, r52, r310, r311, r53, r312, "list_card", r313, r314, r315, r316, r317, true, r410, r125, null, (String) r50.C.a(wn.a.y), (String) r50.C.a(wn.a.z), null, 261619712);
        goto L123
    L121:
        r125 = SourceType.UNKNOWN.getType();
        goto L122
    L117:
        r410 = null;
        goto L118
    L110:
        r124 = null;
        goto L111
    L106:
        r315 = null;
        goto L107
    L95:
        if (r51.length() <= 0) goto L97;
        boolean r57 = true;
    L98:
        if (r57 == true) goto L101;
        r51 = null;
    L101:
        if (r51 != null) goto L103;
    L97:
        r57 = false;
        goto L98
    L65:
        r38 = "";
        goto L66
    L57:
        r36 = "0";
        goto L58
    L46:
        if (r34.length() <= 0) goto L48;
        boolean r126 = true;
    L49:
        if (r126 == true) goto L52;
        r34 = null;
    L52:
        if (r34 != null) goto L54;
    L48:
        r126 = false;
    L30:
        r115 = "";
    L18:
        r16 = null;
        goto L19
    L12:
        r13 = r50;
        goto L13
    L8:
        r5 = 1;
        goto L9
    }

    public final void c(WindowV2ProductItemVO r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r2, "item");
    }

    public final void d(WindowV2ProductItemVO r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r2, "item");
    }

    public final void e(WindowV2ProductItemVO r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r2, "item");
    }

    public final void f(WindowFollowCouponTagView r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r2, "tag");
    }

    public final void g(final WindowV2ProductItemVO r8) {
        Intrinsics.checkNotNullParameter(r8, "item");
        if (((WindowTabViewModelDeprecated) this.b.o.getValue()).shouldReportEvent(wn.a.l, r8.a) == true) goto L5;
        return;
    L5:
        StringBuilder r0 = new StringBuilder("c3406.d643143_i");
        Integer r1 = (Integer) r8.C.a(wn.a.C);
        if (r1 == null) goto L8;
        int r2 = r1.intValue();
    L9:
        r0.append(r2);
        String r3 = r0.toString();
        c r4 = new BtmItemBuilder(r3, Boolean.FALSE).withBtmPage(this.b.p.getValue()).build();
        String r5 = BtmSDK.INSTANCE.obtainEventBtmParams(r4);
        int r6 = WindowTabEventReporter.a;
        ECWindowParam r7 = ECWindowHotsaleRecommendPCGPresenter.k0(this.b).getShopParam();
        ECWindowProductForm r9 = ECWindowProductForm.DOUBLE_PRODUCT;
        QContext r10 = this.b.Y();
        FragmentActivity r11 = l0.c(r10.c());
        if ((r11 instanceof FragmentActivity) == true) goto L12;
        r11 = null;
    L12:
        if (r11 != null) goto L14;
        r11 = r10.a();
    L14:
        Map r12 = WindowTabEventReporter.a(r8, r7, r9, r11, "live_top_102");
        Map r13 = r8.q;
        if (r13 == null) goto L17;
        r12.putAll(r13);
    L17:
        r12.put("btm_id", r5);
        r12.put("bst_tag", "bst_tag");
        int r14 = WindowBstReport.a;
        View r15 = this.b.a0();
        ECWindowViewModel r16 = ECWindowHotsaleRecommendPCGPresenter.k0(this.b);
        Intrinsics.checkNotNullParameter(r12, "eventParams");
        Intrinsics.checkNotNullParameter(r16, "reporter");
        WindowBstReport.e(r15, r3, r8, new com.bytedance.android.window.shop.product.utils.c(r16, r12, r12));
        ((WindowTabViewModelDeprecated) this.b.o.getValue()).runLowPriorityTask(new ECWindowHotsaleRecommendPCGPresenter$behaviorAdapter$1$onDisplay$2(this, r8));
        return;
    L8:
        r2 = 1;
        goto L9
    }

    public final void h(WindowV2ProductItemVO r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r2, "item");
    }

    public final void i(WindowV2ProductItemVO r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r2, "item");
    }

    public final void j(WindowV2ProductItemVO r10) {
        Intrinsics.checkNotNullParameter(r10, "item");
        this.b.getClass();
        if (com.bytedance.android.bst.api.f.e().isBstBindEnable("window") == true) goto L5;
        return;
    L5:
        wc.c r0 = new wc.c(r10.a, 0, "product", 1);
        Map r1 = ECWindowHotsaleRecommendPCGPresenter.k0(this.b).getBaseParams();
        int r2 = WindowTabEventReporter.a;
        ECWindowParam r3 = ECWindowHotsaleRecommendPCGPresenter.k0(this.b).getShopParam();
        ECWindowProductForm r4 = ECWindowProductForm.DOUBLE_PRODUCT;
        QContext r5 = this.b.Y();
        FragmentActivity r6 = l0.c(r5.c());
        com.bytedance.android.bst.api.b r7 = null;
        if ((r6 instanceof FragmentActivity) == true) goto L8;
        r6 = null;
    L8:
        if (r6 != null) goto L10;
        r6 = r5.a();
    L10:
        Map r8 = WindowTabEventReporter.a(r10, r3, r4, r6, "live_top_102");
        Map r9 = r10.q;
        if (r9 == null) goto L13;
        r8.putAll(r9);
    L13:
        Unit r11 = Unit.INSTANCE;
        Map r12 = MapsKt.plus(r1, r8);
        LinkedHashMap r13 = new LinkedHashMap();
        r13.putAll(r12);
        r13.remove("btm_id");
        r0.getExtraInfo().putAll(r13);
        ArrayList r14 = new ArrayList();
        LinkedHashMap r15 = new LinkedHashMap();
        ArrayList r16 = new ArrayList();
        View r17 = this.b.a0();
        String r18 = "c3406.d643143_i" + ((Integer) r10.C.a(wn.a.C));
        int r19 = sc.a.a;
        r14.add(PinchEnterMethod.CLICK);
        if (r17 == null) goto L17;
        if (r18 == null) goto L17;
        r7 = new com.bytedance.android.bst.api.b(r17, r18);
        r7.a = r0;
        r7.b = r10;
        r7.c.addAll(r16);
        r7.d.putAll(r15);
        ((ArrayList) r7.e).addAll(r14);
    L17:
        if (r7 == null) goto L20;
        com.bytedance.android.bst.api.f.b(r7);
        return;
    }

    public final void k(h r3) {
        Intrinsics.checkNotNullParameter(r3, "item");
        if ((r3 instanceof h) == true) goto L5;
        h r0 = null;
    L6:
        if (r0 == null) goto L13;
        s r1 = r0.U;
        if (r1 == null) goto L14;
        long r2 = Long.valueOf(r1.b).longValue();
        String r4 = ((WindowV2ProductItemVO) r3).b;
        if (r4 == null) goto L15;
        l(r2, r4);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    L5:
        r0 = r3;
        goto L6
    }

    public final void l(long r4, String r6) {
        m0 r0 = new m0("sslocal://goods/window/innerflow");
        r0.a("author_id", ECWindowHotsaleRecommendPCGPresenter.k0(this.b).getShopParam().getAuthorId());
        r0.a("uid", ECWindowHotsaleRecommendPCGPresenter.k0(this.b).getShopParam().getAuthorId());
        r0.a("sec_uid", ECWindowHotsaleRecommendPCGPresenter.k0(this.b).getShopParam().getSecAuthorId());
        r0.a("enter_from", ECWindowHotsaleRecommendPCGPresenter.k0(this.b).getShopParam().getEnterFrom());
        r0.a("enter_method", ECWindowHotsaleRecommendPCGPresenter.k0(this.b).getShopParam().getEnterMethod());
        r0.a("which_account", ECWindowHotsaleRecommendPCGPresenter.k0(this.b).getShopParam().getWhichAccount());
        r0.a("search_hint", th.a.f(this.b.Y().c()).getString(2131895922));
        r0.a("product_source_page", ECWindowHotsaleRecommendPCGPresenter.k0(this.b).getShopParam().getEntranceLocation());
        r0.a("store_source_page", ECWindowHotsaleRecommendPCGPresenter.k0(this.b).getShopParam().getStoreSourcePage());
        r0.a("store_source_method", ECWindowHotsaleRecommendPCGPresenter.k0(this.b).getShopParam().getStoreSourceMethod());
        r0.a("store_group_type", ECWindowHotsaleRecommendPCGPresenter.k0(this.b).getShopParam().getStoreGroupType());
        r0.a("search_params", ECWindowHotsaleRecommendPCGPresenter.k0(this.b).getShopParam().getSearchParams());
        r0.a("entrance_location", ECWindowHotsaleRecommendPCGPresenter.k0(this.b).getShopParam().getEntranceLocation());
        r0.a("tmp_id", ECWindowHotsaleRecommendPCGPresenter.k0(this.b).getShopParam().getTempId());
        r0.a("inner_flow_type", String.valueOf(6));
        r0.a("custom_ids", String.valueOf(r4));
        r0.a("promotion_id", r6);
        r0.a("pass_through_api", (String) ECWindowHotsaleRecommendPCGPresenter.k0(this.b).getShopParam().getPassThroughParam("pass_through_api"));
        ECWindowHotsaleRecommendPCGPresenter.k0(this.b).getLiveManager().c();
        p.a.openSchema(this.b.Y().c(), r0.c());
    }
}
