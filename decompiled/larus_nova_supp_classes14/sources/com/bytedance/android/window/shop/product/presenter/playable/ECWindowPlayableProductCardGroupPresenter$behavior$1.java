package com.bytedance.android.window.shop.product.presenter.playable;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.UrlBuilderV2;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.core.utils.m0;
import com.bytedance.android.ec.core.utils.o0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.response.anchorv3.SourceType;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductItemDTO;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.android.window.shop.home.BaseWindowTabViewModel;
import com.bytedance.android.window.shop.home.ECWindowParam;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.product.utils.WindowBstReport;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.router.WindowEntranceInfoExtKt;
import com.bytedance.android.window.shop.router.WindowEntranceInfoScene;
import com.bytedance.android.window.shop.widget.product.WindowFollowCouponTagView;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentServiceId;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lq3.d;
import org.json.JSONObject;
import sq3.h;
import yn.u;
import yo.g;
import zq3.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowPlayableProductCardGroupPresenter$behavior$1 implements g {
    public final /* synthetic */ ECWindowPlayableProductCardGroupPresenter a;
    public final /* synthetic */ WindowLayoutType b;
    public final /* synthetic */ Fragment c;

    public final void g(WindowV2ProductItemVO r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(final View r3) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        int r0 = rp.a.a;
        if (rp.a.a(r3.getId()) == false) goto L6;
        return;
    L6:
        if ((r3 instanceof WindowFollowCouponTagView) == false) goto L9;
        this.a.m0().runLowPriorityTask(new ECWindowPlayableProductCardGroupPresenter$behavior$1$onProductTagClick$1(this, r3));
        int r1 = com.bytedance.android.window.shop.widget.b.a;
        com.bytedance.android.ec.core.async.a.a(com.bytedance.android.window.shop.widget.b.a(this.a.n0(), ((WindowFollowCouponTagView) r3).getFansCouponSceneParam()), this.a.n0());
        return;
    }

    public final void b(WindowV2ProductItemVO r50) {
        Intrinsics.checkNotNullParameter(r50, "item");
        HashMap r0 = new HashMap();
        String r2 = this.a.n0().getShopParam().getStoreSourcePage();
        if (r2 != null) goto L5;
        r2 = "store_page";
    L5:
        r0.put("enter_from_merge", r2);
        String r3 = this.a.n0().getShopParam().getStoreSourceMethod();
        if (r3 != null) goto L8;
        r3 = "mini_window";
    L8:
        r0.put("enter_method", r3);
        r0.put("data_type", "commerce_data");
        int r4 = com.bytedance.android.ec.window.base.product.presenter.utils.c.a;
        com.bytedance.android.ec.window.base.product.presenter.utils.c.a(r50, this.a.Y(), r0);
        ECWindowParam r10 = this.a.n0().getShopParam();
        int r1 = com.bytedance.android.ec.window.base.product.presenter.utils.b.a;
        JSONObject r5 = com.bytedance.android.ec.window.base.product.presenter.utils.b.d(r10.getSearchParams(), r50);
        String r6 = this.a.l0(r50);
        BtmItemBuilder r7 = new BtmItemBuilder(r6, Boolean.TRUE).withBtmPage(this.a.p.getValue());
        BcmParams r8 = new BcmParams();
        r8.put("category_id", this.a.m0().getLastCategoryId());
        Unit r9 = Unit.INSTANCE;
        r7.internalSetUnitParams("description", r8);
        String r11 = BtmSDK.INSTANCE.createBtmId(r7.build());
        List r12 = com.bytedance.android.ec.window.base.utils.g.a;
        com.bytedance.android.ec.window.base.utils.g.a(r50.a);
        String r13 = (String) r50.C.a(wn.a.E);
        Map r14 = (Map) r50.C.a(wn.a.F);
        com.bytedance.commerce.base.json.a[] r15 = new com.bytedance.commerce.base.json.a[26];
        r15[0] = JsonDslUtilKt.d("product_source_page", r10.getEntranceLocation());
        r15[1] = JsonDslUtilKt.d("carrier_source", r10.getPageName());
        r15[2] = JsonDslUtilKt.d("source_method", "product_card");
        Integer r16 = r10.getFollowStatus();
        String r17 = "";
        if (r16 == null) goto L12;
        String r18 = String.valueOf(r16.intValue());
        if (r18 == null) goto L12;
    L13:
        r15[3] = JsonDslUtilKt.d("follow_status", r18);
        r15[4] = JsonDslUtilKt.d("tab_label", "list_card");
        String r19 = r10.getTempId();
        if (r19 != null) goto L16;
        r19 = "";
    L16:
        r15[5] = JsonDslUtilKt.d("temp_id", r19);
        r15[6] = JsonDslUtilKt.d("product_form", com.bytedance.android.ec.window.base.product.presenter.utils.b.e(this.b));
        r15[7] = JsonDslUtilKt.d("ecom_group_type", "product");
        String r20 = r10.getStoreSourcePage();
        if (r20 != null) goto L19;
        r20 = "";
    L19:
        r15[8] = JsonDslUtilKt.d("store_source_page", r20);
        String r21 = r10.getStoreSourceMethod();
        if (r21 != null) goto L22;
        r21 = "";
    L22:
        r15[9] = JsonDslUtilKt.d("store_source_method", r21);
        String r22 = r10.getStoreGroupType();
        if (r22 != null) goto L25;
        r22 = "";
    L25:
        r15[10] = JsonDslUtilKt.d("store_group_type", r22);
        r15[11] = JsonDslUtilKt.d("pre_product_id", this.a.n0().getShopParam().getPreProductId());
        r15[12] = JsonDslUtilKt.d("pre_room_id", this.a.n0().getShopParam().getPreRoomId());
        r15[13] = JsonDslUtilKt.d("pre_group_id", this.a.n0().getShopParam().getPreGroupId());
        r15[14] = JsonDslUtilKt.d("store_type", "window");
        String r23 = r50.b;
        if (r23 != null) goto L28;
    L35:
        r23 = r50.a;
    L36:
        r15[15] = JsonDslUtilKt.d("promotion_id", r23);
        boolean r24 = com.bytedance.android.shopping.anchorv3.a.b(r50.i);
        String r110 = CommentScene.COMMENTSCENE_NO_AWEME;
        if (r24 == false) goto L39;
        String r25 = CommentScene.COMMENTSCENE_NO_AWEME;
    L40:
        r15[16] = JsonDslUtilKt.d("is_price_info", r25);
        if (r50.d() != null) goto L44;
        r110 = "0";
    L44:
        r15[17] = JsonDslUtilKt.d("is_recommend_info", r110);
        WindowV2ProductItemDTO.b r26 = r50.v;
        if (r26 == null) goto L47;
        String r27 = r26.a();
    L48:
        r15[18] = JsonDslUtilKt.d("content_form", r27);
        r15[19] = JsonDslUtilKt.d("content_source", "shop");
        String r28 = this.a.m0().getLastCategoryId();
        if (r28 != null) goto L52;
        r28 = null;
    L52:
        if (r28 != null) goto L54;
        r28 = "";
    L54:
        r15[20] = JsonDslUtilKt.d("tab_id", r28);
        BaseWindowTabViewModel r29 = this.a.m0();
        if ((r29 instanceof BaseWindowTabViewModel) == true) goto L57;
        r29 = null;
    L57:
        if (r29 == null) goto L60;
        String r30 = r29.getCategoryName();
        if (r30 == null) goto L60;
    L61:
        r15[21] = JsonDslUtilKt.d("classification_tab", r30);
        BaseWindowTabViewModel r31 = this.a.m0();
        if ((r31 instanceof BaseWindowTabViewModel) == true) goto L64;
        r31 = null;
    L64:
        if (r31 == null) goto L67;
        String r32 = r31.getLastCategoryId();
        if (r32 == null) goto L67;
    L68:
        r15[22] = JsonDslUtilKt.d("classification_tab_id", r32);
        BaseWindowTabViewModel r33 = this.a.m0();
        if ((r33 instanceof BaseWindowTabViewModel) == true) goto L71;
        r33 = null;
    L71:
        if (r33 == null) goto L74;
        String r34 = r33.getLastSubCategoryId();
        if (r34 == null) goto L74;
    L75:
        r15[23] = JsonDslUtilKt.d("classification_sub_tab_id", r34);
        String r35 = this.a.n0().getShopParam().getWhichAccount();
        if (r35 != null) goto L78;
        r35 = "";
    L78:
        r15[24] = JsonDslUtilKt.d("which_account", r35);
        ECWindowPlayableProductCardGroupPresenter r36 = this.a;
        if ((r50 instanceof tq3.c) == true) goto L81;
        WindowV2ProductItemVO r111 = null;
    L82:
        tq3.c r112 = (tq3.c) r111;
        r36.getClass();
        if (r112 == null) goto L94;
        List<WindowV2ProductItemDTO.WindowCardHeaderLabelInfo> r37 = r112.S;
        if (r37 == null) goto L94;
        ArrayList r113 = new ArrayList();
        Iterator<T> r38 = r37.iterator();
    L88:
        if (r38.hasNext() == false) goto L92;
        String r114 = ((WindowV2ProductItemDTO.WindowCardHeaderLabelInfo) r38.next()).c();
        if (r114 == null) goto L88;
        r113.add(r114);
        goto L88
    L92:
        String r39 = CollectionsKt.joinToString$default(r113, null, null, null, 0, null, null, 63, null);
        if (r39 == null) goto L94;
    L95:
        r15[25] = JsonDslUtilKt.d("product_tags", r39);
        JSONObject r40 = JsonDslUtilKt.a(r15);
        Map r41 = r50.q;
        if (r41 == null) goto L99;
        String r42 = (String) r41.get("tab_name_second");
        if (r42 == null) goto L99;
    L100:
        if (r42 == null) goto L102;
        r40.put("source_method_second", r42);
    L102:
        fo.b r43 = r50.C;
        fo.a r115 = wn.a.a;
        String r44 = (String) r43.a(r115);
        if (r44 == null) goto L105;
        r40.put(r115.a, r44);
    L105:
        fo.b r45 = r50.C;
        fo.a r116 = wn.a.e;
        String r46 = (String) r45.a(r116);
        if (r46 == null) goto L108;
        r40.put(r116.a, r46);
    L108:
        fo.b r47 = r50.C;
        fo.a r117 = wn.a.f;
        Integer r48 = (Integer) r47.a(r117);
        if (r48 == null) goto L112;
        r40.put(r117.a, r48.intValue());
    L112:
        if (r10.isEcShare() == false) goto L114;
        r40.accumulate("share_content", r10.getShareContent());
        r40.accumulate("share_object", r10.getShareObject());
    L114:
        Map r49 = r50.q;
        if (r49 == null) goto L120;
        Iterator r51 = r49.entrySet().iterator();
    L118:
        if (r51.hasNext() == false) goto L120;
        Map.Entry r118 = (Map.Entry) r51.next();
        r40.put((String) r118.getKey(), r118.getValue());
    L120:
        JSONObject r52 = z1.g((String) this.a.n0().getShopParam().getPassThroughParam("pass_through_api"));
        if (r52 == null) goto L123;
        r40.put(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, r52.optString(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID));
        Unit r53 = Unit.INSTANCE;
    L123:
        JSONObject r54 = WindowEntranceInfoExtKt.a(r40, WindowEntranceInfoScene.ENTER_PRODUCT_DETAIL, null);
        if (r13 != null) goto L126;
        String r55 = r50.E;
    L127:
        if (r55 != null) goto L129;
    L132:
        boolean r119 = true;
    L134:
        if (r119 == true) goto L156;
        int r56 = f.a;
        String r120 = f.c(r55, r11, PageFinder.via(this.c), f.a(r10.getAuthorId(), r50));
        if (Intrinsics.areEqual(r55, r13) == false) goto L151;
        p r57 = p.a;
        Context r58 = this.a.Y().c();
        o0 r59 = new o0(r55);
        xn.c.b(r54, this.a.Y().a());
        String r121 = r59.e("entrance_info");
        Result.Companion r60 = Result.Companion;     // Catch: Throwable -> L140
        Object r61 = Result.constructor-impl(z1.g(r121));     // Catch: Throwable -> L140
    L143:
        if (Result.isFailure-impl(r61) == false) goto L145;
        r61 = null;
    L145:
        JSONObject r62 = (JSONObject) r61;
        if (r121 == null) goto L149;
        if (r62 == null) goto L150;
        xn.c.a(r62, r54);
        r59.a("entrance_info", r62.toString());
    L150:
        r57.openSchema(r58, r59.c());
    L200:
        int r63 = ECWindowPlayableProductCardGroupPresenter.v;
        ECWindowViewModel r64 = this.a.n0();
        BaseWindowTabViewModel r65 = this.a.m0();
        WindowLayoutType r66 = this.b;
        String r67 = this.a.m0().getLastCategoryId();
        if (r67 == null) goto L203;
        String r122 = r67;
    L204:
        if (r122 == null) goto L207;
        r17 = r122;
    L207:
        Map r68 = ECWindowPlayableProductCardGroupPresenter.a.a(r64, r65, r50, r66, r17);
        if (r14 == null) goto L210;
        r68.putAll(r14);
    L210:
        Map r69 = MapsKt.plus(r68, this.a.q);
        int r70 = WindowBstReport.a;
        WindowBstReport.g(this.a.a0(), r6, r50, this.b, r69, this.a.n0(), this.a.m0());
        dm.a.a("WINDOW").i("[click product]productId:" + r50.a);
        dm.a.a("WINDOW").i("[click product]secAuthorId:" + r10.getSecAuthorId());
        return;
    L203:
        r122 = null;
        goto L204
    L149:
        r59.a("entrance_info", r54.toString());
    L140:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r61 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L143
    L151:
        xn.b r124 = xn.b.f;
        Context r125 = this.a.Y().c();
        String r210 = String.valueOf(r10.getFollowStatus());
        Map r211 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("uid", r10.getAuthorId()), TuplesKt.to("product_id", r50.a)});
        u r71 = r50.w;
        if (r71 == null) goto L154;
        String r212 = r71.i();
    L155:
        com.bytedance.android.ec.window.base.common.starter.f.b(r124, r125, r120, r210, r54, r211, r212);
        goto L200
    L154:
        r212 = null;
        goto L155
    L156:
        int r72 = com.bytedance.android.ec.window.base.product.presenter.utils.b.a;
        com.bytedance.android.ec.window.base.product.presenter.utils.b.f(PageFinder.via(this.a.a0()), this.a.n0().getShopParam().getAuthorId(), r50);
        xn.b r213 = xn.b.f;
        Context r214 = this.a.Y().c();
        String r73 = r50.b;
        if (r73 != null) goto L159;
    L166:
        r73 = r50.a;
    L167:
        String r215 = r73;
        String r216 = r10.getPageName();
        String r74 = r50.m;
        String r310 = r10.getAuthorId();
        String r311 = r10.getSecAuthorId();
        String r75 = r50.a;
        Integer r312 = r10.getFollowStatus();
        String r313 = r10.getWhichAccount();
        String r314 = r54.toString();
        if (r5 == null) goto L170;
        String r315 = r5.toString();
        int r76 = 1;
    L171:
        com.bytedance.commerce.base.json.a[] r77 = new com.bytedance.commerce.base.json.a[r76];
        JSONObject r78 = z1.g((String) this.a.n0().getShopParam().getPassThroughParam("pass_through_api"));
        if (r78 == null) goto L174;
        String r79 = r78.optString(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID);
    L175:
        if (r79 != null) goto L177;
        r79 = "";
    L177:
        r77[0] = JsonDslUtilKt.d(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, r79);
        JSONObject r80 = JsonDslUtilKt.a(r77);
        if ((r50 instanceof rq3.a) == true) goto L180;
        WindowV2ProductItemVO r81 = null;
    L181:
        rq3.a r82 = (rq3.a) r81;
        if (r82 == null) goto L191;
        String r83 = r82.Q;
        if (r83 == null) goto L191;
        if ((!StringsKt.isBlank(r83)) == true) goto L189;
        r83 = null;
    L189:
        if (r83 == null) goto L191;
        r80.put("cps_track", r83);
        r80.put("cps_report_type", 0);
        Unit r84 = Unit.INSTANCE;
    L191:
        Unit r85 = Unit.INSTANCE;
        String r316 = (String) CollectionsKt.getOrNull(r50.h, 0);
        u r86 = r50.w;
        if (r86 == null) goto L194;
        String r410 = r86.i();
    L195:
        Long r87 = r50.c;
        if (r87 == null) goto L198;
        long r88 = r87.longValue();
    L199:
        com.bytedance.android.ec.window.base.common.starter.f.a(r213, r214, r215, r216, r74, r310, r311, r75, r312, "list_card", r313, r314, r315, r80, r316, false, r410, r88, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("uid", this.a.n0().getShopParam().getAuthorId())}), (String) r50.C.a(wn.a.y), (String) r50.C.a(wn.a.z), null, 260603904);
        goto L200
    L198:
        r88 = SourceType.UNKNOWN.getType();
        goto L199
    L194:
        r410 = null;
        goto L195
    L180:
        r81 = r50;
        goto L181
    L174:
        r79 = null;
        goto L175
    L170:
        r76 = 1;
        r315 = null;
        goto L171
    L159:
        if (r73.length() <= 0) goto L161;
        boolean r89 = true;
    L162:
        if (r89 == true) goto L165;
        r73 = null;
    L165:
        if (r73 != null) goto L167;
    L161:
        r89 = false;
        goto L162
    L129:
        if (StringsKt.isBlank(r55) == true) goto L132;
        r119 = false;
        goto L134
    L126:
        r55 = r13;
    L99:
        r42 = (String) r50.C.a(wn.a.e);
    L94:
        r39 = "";
        goto L95
    L81:
        r111 = r50;
    L74:
        r34 = "";
    L67:
        r32 = "";
    L60:
        r30 = "";
        goto L61
    L47:
        r27 = "";
        goto L48
    L39:
        r25 = "0";
        goto L40
    L28:
        if (r23.length() <= 0) goto L30;
        boolean r126 = true;
    L31:
        if (r126 == true) goto L34;
        r23 = null;
    L34:
        if (r23 != null) goto L36;
    L30:
        r126 = false;
    L12:
        r18 = "";
        goto L13
    }

    public final void c(WindowV2ProductItemVO r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r2, "item");
    }

    public final void d(WindowV2ProductItemVO r28) {
        Intrinsics.checkNotNullParameter(r28, "item");
        if (a2.b(r28.r) == false) goto L49;
        int r2 = r28.f;
        if (r2 != 1) goto L14;
        UrlBuilderV2 r3 = new UrlBuilderV2(r28.r);
        JSONObject r14 = cd.a.c(this.a.n0().getMetaInfoWithoutKolId());
        r14.put("author_id", this.a.n0().getShopParam().getAuthorId());
        Unit r9 = Unit.INSTANCE;
        r3.addOrReplaceParam("meta_info", r14);
        String r17 = r3.build();
        int r4 = f.a;
        QContext r5 = this.a.Y();
        Context r10 = l0.c(r5.c());
        if ((r10 instanceof FragmentActivity) == true) goto L9;
        Context r7 = null;
    L10:
        if (r7 != null) goto L12;
        Context r15 = r5.a();
    L13:
        f.b(r15, this.a.n0(), r17, "a1.b7635.c68164.d22909", PageFinder.via(this.a.a0()), null);
        this.a.n0().doEventAction("window_tag_click", new Pair[]{TuplesKt.to("entrance_location", "store_page_product_card"), TuplesKt.to("enter_from", "store_page_product_card"), TuplesKt.to("product_id", r28.a), TuplesKt.to("tag_type", CommentServiceId.HOT_SPOT)});
        return;
    L12:
        r15 = r7;
        goto L13
    L9:
        r7 = r10;
        goto L10
    L14:
        if (r2 != 2) goto L51;
        String r6 = r28.r;
        if (r6 == null) goto L27;
        m0 r8 = new m0(r6);
        r8.b("enter_from", "store_page_product_card");
        r8.b("pre_product_id", this.a.n0().getShopParam().getPreProductId());
        r8.b("pre_group_id", this.a.n0().getShopParam().getPreGroupId());
        r8.b("pre_room_id", this.a.n0().getShopParam().getPreRoomId());
        r8.b("entrance_location", "store_page_product_card");
        String r11 = this.a.n0().getShopParam().getStoreSourcePage();
        if (r11 != null) goto L20;
        r11 = "";
    L20:
        r8.b("store_source_page", r11);
        String r12 = this.a.n0().getShopParam().getStoreSourceMethod();
        if (r12 != null) goto L23;
        r12 = "";
    L23:
        r8.b("store_source_method", r12);
        String r13 = this.a.n0().getShopParam().getStoreGroupType();
        if (r13 != null) goto L26;
        r13 = "";
    L26:
        r8.b("store_group_type", r13);
        r8.b("pass_through_api", (String) this.a.n0().getShopParam().getPassThroughParam("pass_through_api"));
        String r16 = r8.c();
    L28:
        BtmItemBuilder r18 = new BtmItemBuilder(this.a.l0(r28), Boolean.TRUE).withBtmPage(this.a.p.getValue());
        BcmParams r19 = new BcmParams();
        r19.put("category_id", this.a.m0().getLastCategoryId());
        Unit r20 = Unit.INSTANCE;
        r18.internalSetUnitParams("description", r19);
        BtmSDK.INSTANCE.createBtmId(r18.build());
        int r21 = f.a;
        QContext r22 = this.a.Y();
        FragmentActivity r23 = l0.c(r22.c());
        if ((r23 instanceof FragmentActivity) == true) goto L31;
        FragmentActivity r110 = null;
    L32:
        if (r110 != null) goto L34;
        r110 = r22.a();
    L34:
        FragmentActivity r24 = r110;
        ECWindowViewModel r25 = this.a.n0();
        if (r16 != null) goto L37;
        String r26 = "";
    L38:
        f.b(r24, r25, r26, "a1.b7635.c68164.d22909", PageFinder.via(this.a.a0()), null);
        ECWindowViewModel r27 = this.a.n0();
        PageFinder r29 = PageFinder.via(this.c);
        Pair[] r30 = new Pair[8];
        r30[0] = TuplesKt.to("author_id", this.a.n0().getShopParam().getAuthorId());
        r30[1] = TuplesKt.to("entrance_location", "store_page_product_card");
        r30[2] = TuplesKt.to("enter_from", "store_page_product_card");
        String r31 = this.a.n0().getShopParam().getStoreSourcePage();
        if (r31 != null) goto L41;
        r31 = "";
    L41:
        r30[3] = TuplesKt.to("store_source_page", r31);
        String r32 = this.a.n0().getShopParam().getStoreSourceMethod();
        if (r32 != null) goto L44;
        r32 = "";
    L44:
        r30[4] = TuplesKt.to("store_source_method", r32);
        String r33 = this.a.n0().getShopParam().getStoreGroupType();
        if (r33 != null) goto L47;
        r33 = "";
    L47:
        r30[5] = TuplesKt.to("store_group_type", r33);
        r30[6] = TuplesKt.to("store_type", "shop");
        r30[7] = TuplesKt.to("product_id", r28.a);
        r27.doAnyEventActionWithBtm("a1.b7635.c68164.d22909", r29, "click_store_entrance", MapsKt.mapOf(r30), new Pair[0]);
        return;
    L37:
        r26 = r16;
        goto L38
    L31:
        r110 = r23;
        goto L32
    L27:
        r16 = null;
        goto L28
    L51:
        return;
    }

    public final void e(final WindowV2ProductItemVO r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        BaseWindowTabViewModel r0 = this.a.m0();
        fo.a r1 = wn.a.a;
        if (r0.shouldReportEvent(wn.a.j, r4.a) == true) goto L5;
        return;
    L5:
        this.a.m0().runLowPriorityTask(new ECWindowPlayableProductCardGroupPresenter$behavior$1$onDisplaySource$1(this, r4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f(final WindowFollowCouponTagView r6) {
        Intrinsics.checkNotNullParameter(r6, "tag");
        Intrinsics.checkNotNullParameter(r6, "tag");
        BaseWindowTabViewModel r0 = this.a.m0();
        fo.a<Set<String>> r1 = wn.a.i;
        lq3.b<d> r2 = r6.getFansCouponSceneParam();
        String r3 = null;
        if (r2 == null) goto L7;
        d r4 = r2.b;
        if (r4 == null) goto L7;
        String r5 = r4.b();
    L8:
        lq3.b<d> r7 = r6.getFansCouponSceneParam();
        if (r7 == null) goto L14;
        d r8 = r7.b;
        if (r8 == null) goto L14;
        r3 = r8.a();
    L14:
        if (r0.shouldReportEvent(r1, Intrinsics.stringPlus(r5, r3)) == false) goto L17;
        this.a.m0().runLowPriorityTask(new ECWindowPlayableProductCardGroupPresenter$behavior$1$onProductTagShow$1(this, r6));
        return;
    L17:
        return;
    L7:
        r5 = null;
        goto L8
    }

    public final void h(WindowV2ProductItemVO r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r2, "item");
    }

    public final void i(WindowV2ProductItemVO r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r2, "item");
    }

    public final void j(WindowV2ProductItemVO r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r2, "item");
    }

    public final void k(h r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r2, "item");
    }

    public ECWindowPlayableProductCardGroupPresenter$behavior$1(ECWindowPlayableProductCardGroupPresenter r1, WindowLayoutType r2, Fragment r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
