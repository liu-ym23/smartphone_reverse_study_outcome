package com.bytedance.android.window.shop.search.presenter;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.UrlBuilderV2;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.core.utils.m0;
import com.bytedance.android.ec.model.response.anchorv3.SourceType;
import com.bytedance.android.ec.window.base.common.param.WindowLogPbDTO;
import com.bytedance.android.ec.window.base.product.holder.WindowLayoutTypes;
import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductItemDTO;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.android.window.shop.product.utils.WindowBstReport;
import com.bytedance.android.window.shop.search.router.ECWindowSearchParam;
import com.bytedance.android.window.shop.search.viewmodel.WindowSearchFragmentProductViewModel;
import com.bytedance.android.window.shop.widget.product.WindowFollowCouponTagView;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentServiceId;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import zq3.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowSearchProductCardGroupPresenter extends yo.j {
    public final String n;
    public final Lazy o;
    public final a p;
    public final b q;

    public static final class a implements yo.h {
        public final /* synthetic */ WindowSearchProductCardGroupPresenter a;

        public final Function3<String, String, Long, Unit> b() {
            return null;
        }

        public final Function1<Integer, Unit> e() {
            return null;
        }

        public final void g() {
        }

        public final String a() {
            String r0 = WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getAuthorId();
            if (r0 != null) goto L6;
            return "";
        L6:
            return r0;
        }

        public final WindowLayoutTypes c() {
            WindowLayoutTypes r0 = (WindowLayoutTypes) WindowSearchProductCardGroupPresenter.k0(this.a).getLayoutType().getValue();
            if (r0 == null) goto L5;
            return r0;
        L5:
            return WindowLayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE;
        }

        public final String d() {
            String r0 = WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getSecAuthorId();
            if (r0 != null) goto L6;
            return "";
        L6:
            return r0;
        }

        public final ap.c f() {
            return WindowSearchProductCardGroupPresenter.k0(this.a).getTagPools();
        }

        public final com.bytedance.android.ec.core.imagex.r h() {
            int r0 = com.bytedance.android.ec.core.imagex.r.h;
            return com.bytedance.android.ec.core.imagex.r.a.d("ec_window_search_product_card");
        }

        public final boolean isClickable() {
            return !WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().isPreview();
        }

        public a(WindowSearchProductCardGroupPresenter r1) {
            this.a = r1;
        }
    }

    public static final class b implements yo.g {
        public final /* synthetic */ WindowSearchProductCardGroupPresenter a;
        public final /* synthetic */ Fragment b;

        public final void j(WindowV2ProductItemVO r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
        }

        public final void a(View r2) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            Intrinsics.checkNotNullParameter(r2, "tag");
        }

        public final void b(WindowV2ProductItemVO r37) {
            Intrinsics.checkNotNullParameter(r37, "item");
            HashMap r2 = new HashMap();
            String r3 = WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getStoreSourcePage();
            if (r3 != null) goto L5;
            r3 = "store_page";
        L5:
            r2.put("enter_from_merge", r3);
            String r4 = WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getStoreSourceMethod();
            if (r4 != null) goto L8;
            r4 = "mini_Window";
        L8:
            r2.put("enter_method", r4);
            r2.put("data_type", "commerce_data");
            int r5 = com.bytedance.android.ec.window.base.product.presenter.utils.c.a;
            com.bytedance.android.ec.window.base.product.presenter.utils.c.a(r37, this.a.Y(), r2);
            ECWindowSearchParam r6 = this.a.Y().g(WindowSearchFragmentProductViewModel.class).getSearchParam();
            JSONObject r7 = new JSONObject();
            String r8 = WindowSearchProductCardGroupPresenter.k0(this.a).getRequestParam().getSearchId();
            if (r8 != null) goto L11;
            r8 = "";
        L11:
            r7.put("search_id", r8);
            r7.put("search_result_id", r37.a);
            String r9 = r7.toString();
            StringBuilder r10 = new StringBuilder();
            if ((r37 instanceof com.bytedance.android.ec.window.base.repository.vo.e) == false) goto L14;
            String r11 = "a1.b7881.c1215.d7284";
        L15:
            r10.append(r11);
            r10.append("_i");
            r10.append(r37.y + 1);
            String r12 = r10.toString();
            int r13 = com.bytedance.android.ec.window.base.product.presenter.utils.b.a;
            Pair r14 = com.bytedance.android.ec.window.base.product.presenter.utils.b.b(r12, false, this.a.a0());
            WindowSearchFragmentProductViewModel r15 = WindowSearchProductCardGroupPresenter.k0(this.a);
            Pair[] r16 = new Pair[11];
            r16[0] = TuplesKt.to("log_pb", GsonProtectorUtils.toJson(new Gson(), WindowSearchProductCardGroupPresenter.k0(this.a).getRequestParam().getLogPb()));
            WindowLogPbDTO r17 = WindowSearchProductCardGroupPresenter.k0(this.a).getRequestParam().getLogPb();
            if (r17 == null) goto L18;
            String r18 = r17.getImprId();
        L19:
            r16[1] = TuplesKt.to("impr_id", r18);
            r16[2] = TuplesKt.to("search_id", WindowSearchProductCardGroupPresenter.k0(this.a).getRequestParam().getSearchId());
            r16[3] = TuplesKt.to("search_result_id", r37.a);
            r16[4] = TuplesKt.to("search_keyword", WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getSearchKeyword());
            r16[5] = TuplesKt.to("rank", String.valueOf(r37.y));
            r16[6] = TuplesKt.to("enter_from", "search_store");
            String r19 = "0";
            r16[7] = TuplesKt.to("is_aladdin", "0");
            r16[8] = TuplesKt.to("token_type", "commodity");
            r16[9] = TuplesKt.to("button_type", "click_info");
            r16[10] = r14;
            r15.doEventAction("search_result_click", r16);
            com.bytedance.commerce.base.json.a[] r20 = new com.bytedance.commerce.base.json.a[23];
            r20[0] = JsonDslUtilKt.d("product_source_page", r6.getEntranceLocation());
            r20[1] = JsonDslUtilKt.d("carrier_source", r6.getPageName());
            r20[2] = JsonDslUtilKt.d("source_method", "search_result");
            Integer r110 = r6.getFollowStatus();
            if (r110 == null) goto L22;
            String r111 = String.valueOf(r110.intValue());
        L23:
            if (r111 != null) goto L25;
            r111 = "";
        L25:
            r20[3] = JsonDslUtilKt.d("follow_status", r111);
            r20[4] = JsonDslUtilKt.d("price_type", String.valueOf(r37.i));
            if (r6.getProductBasicRequestParam().isCustom() == false) goto L28;
            String r112 = "featured";
        L29:
            r20[5] = JsonDslUtilKt.d("tab_label", r112);
            String r113 = r6.getTempId();
            if (r113 != null) goto L32;
            r113 = "";
        L32:
            r20[6] = JsonDslUtilKt.d("temp_id", r113);
            String r114 = r6.getStoreSourcePage();
            if (r114 != null) goto L35;
            r114 = "";
        L35:
            r20[7] = JsonDslUtilKt.d("store_source_page", r114);
            String r115 = r6.getStoreSourceMethod();
            if (r115 != null) goto L38;
            r115 = "";
        L38:
            r20[8] = JsonDslUtilKt.d("store_source_method", r115);
            String r116 = r6.getStoreGroupType();
            if (r116 != null) goto L41;
            r116 = "";
        L41:
            r20[9] = JsonDslUtilKt.d("store_group_type", r116);
            r20[10] = JsonDslUtilKt.d("store_type", "window");
            String r21 = r37.b;
            if (r21 != null) goto L44;
        L51:
            r21 = r37.a;
        L52:
            r20[11] = JsonDslUtilKt.d("promotion_id", r21);
            if (r37.f() == null) goto L55;
            String r22 = CommentScene.COMMENTSCENE_NO_AWEME;
        L56:
            r20[12] = JsonDslUtilKt.d("is_product_info", r22);
            if (com.bytedance.android.shopping.extensions.k.c(r37.i) == false) goto L59;
            String r23 = CommentScene.COMMENTSCENE_NO_AWEME;
        L60:
            r20[13] = JsonDslUtilKt.d("is_price_info", r23);
            if (r37.d() == null) goto L63;
            String r24 = CommentScene.COMMENTSCENE_NO_AWEME;
        L64:
            r20[14] = JsonDslUtilKt.d("is_recommend_info", r24);
            WindowV2ProductItemDTO.b r25 = r37.v;
            if (r25 == null) goto L67;
            String r26 = r25.a();
        L68:
            r20[15] = JsonDslUtilKt.d("content_form", r26);
            if (r6.isStoreHotSearch() == false) goto L71;
            r19 = CommentScene.COMMENTSCENE_NO_AWEME;
        L71:
            r20[16] = JsonDslUtilKt.d("is_store_hot_search", r19);
            r20[17] = JsonDslUtilKt.d("content_source", "shop");
            r20[18] = JsonDslUtilKt.d("search_params", r9);
            r20[19] = JsonDslUtilKt.d("search_keyword", WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getSearchKeyword());
            r20[20] = JsonDslUtilKt.d("source_page", "store_page");
            r20[21] = JsonDslUtilKt.d("ecom_entrance_form", "search_result");
            r20[22] = JsonDslUtilKt.d("which_account", "");
            JSONObject r27 = JsonDslUtilKt.a(r20);
            if (r6.getProductBasicRequestParam().isCustom() == false) goto L75;
            r27.accumulate("customer_id", r6.getProductBasicRequestParam().getMaterialId());
        L75:
            if (r6.isEcShare() == false) goto L77;
            r27.accumulate("share_content", r6.getShareContent());
            r27.accumulate("share_object", r6.getShareObject());
        L77:
            Map r28 = r37.q;
            if (r28 == null) goto L83;
            Iterator r29 = r28.entrySet().iterator();
        L81:
            if (r29.hasNext() == false) goto L83;
            Map.Entry r30 = (Map.Entry) r29.next();
            r27.put((String) r30.getKey(), r30.getValue());
        L83:
            JSONObject r31 = com.bytedance.android.shopping.extensions.k.w((String) WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getPassThroughParam("pass_through_api"));
            if (r31 == null) goto L86;
            r27.put(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, r31.optString(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID));
        L86:
            List r32 = com.bytedance.android.ec.window.base.utils.g.a;
            com.bytedance.android.ec.window.base.utils.g.a(r37.a);
            BcmParams r33 = new BcmParams();
            r33.put("search_params", r9);
            r33.put("bst_group_type", "product");
            BtmItemBuilder r34 = new BtmItemBuilder(r12, Boolean.TRUE).withView(this.a.a0());
            r34.internalSetUnitParams("ecom_entrance", r33);
            String r35 = r34.createBtmId();
            if (com.bytedance.android.shopping.extensions.k.c(r37.E) == false) goto L96;
            int r36 = zq3.f.a;
            String r38 = r37.E;
            Intrinsics.checkNotNull(r38);
            PageFinder r39 = PageFinder.via(this.a.a0());
            BcmParams.a r40 = BcmParams.Companion;
            Map r117 = (Map) r37.O.getValue();
            r40.getClass();
            String r210 = zq3.f.c(r38, r12, r39, BcmParams.a.c(r117));
            xn.b r211 = xn.b.f;
            Context r212 = this.a.Y().c();
            String r213 = String.valueOf(r6.getFollowStatus());
            Pair[] r41 = new Pair[2];
            String r42 = r6.getAuthorId();
            if (r42 != null) goto L91;
            r42 = "";
        L91:
            r41[0] = TuplesKt.to("uid", r42);
            r41[1] = TuplesKt.to("product_id", r37.a);
            Map r310 = MapsKt.mutableMapOf(r41);
            yn.u r43 = r37.w;
            if (r43 == null) goto L94;
            String r311 = r43.i();
        L95:
            com.bytedance.android.ec.window.base.common.starter.f.b(r211, r212, r210, r213, r27, r310, r311);
            String r312 = "";
        L131:
            int r44 = WindowBstReport.a;
            View r45 = this.a.a0();
            Map<String, String> r46 = l("click_product", r37);
            if (r46 != null) goto L134;
            r46 = MapsKt.emptyMap();
        L134:
            WindowSearchFragmentProductViewModel r47 = WindowSearchProductCardGroupPresenter.k0(this.a);
            Intrinsics.checkNotNullParameter(r46, "eventParams");
            Intrinsics.checkNotNullParameter(r47, "reporter");
            WindowBstReport.d(r45, r35, r37, new com.bytedance.android.window.shop.product.utils.b(r47, r46, r46));
            dm.a.a("WINDOW").i("[click search product]productId:" + r37.a);
            dm.a.b r1 = dm.a.a("WINDOW");
            String r48 = r6.getSecAuthorId();
            if (r48 != null) goto L137;
            String r49 = r312;
        L138:
            r1.i("[click search product]secAuthorId:".concat(r49));
            return;
        L137:
            r49 = r48;
            goto L138
        L94:
            r311 = null;
            goto L95
        L96:
            xn.b r50 = xn.b.f;
            Context r51 = this.a.Y().c();
            String r118 = r37.b;
            if (r118 != null) goto L99;
        L106:
            r118 = r37.a;
        L107:
            String r119 = r6.getPageName();
            String r120 = r37.m;
            String r121 = r6.getAuthorId();
            if (r121 != null) goto L110;
            r121 = "";
        L110:
            String r122 = r6.getSecAuthorId();
            if (r122 != null) goto L113;
            r122 = "";
        L113:
            String r123 = r37.a;
            Integer r214 = r6.getFollowStatus();
            String r52 = r27.toString();
            r312 = "";
            com.bytedance.commerce.base.json.a[] r124 = new com.bytedance.commerce.base.json.a[1];
            JSONObject r53 = com.bytedance.android.shopping.extensions.k.w((String) WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getPassThroughParam("pass_through_api"));
            if (r53 == null) goto L116;
            String r54 = r53.optString(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID);
        L117:
            if (r54 != null) goto L119;
            r54 = r312;
        L119:
            r124[0] = JsonDslUtilKt.d(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, r54);
            JSONObject r55 = JsonDslUtilKt.a(r124);
            String r215 = (String) CollectionsKt.getOrNull(r37.h, 0);
            yn.u r56 = r37.w;
            if (r56 == null) goto L122;
            String r216 = r56.i();
        L123:
            Long r57 = r37.c;
            if (r57 == null) goto L126;
            long r58 = r57.longValue();
        L127:
            long r313 = r58;
            Pair[] r59 = new Pair[1];
            String r125 = r6.getAuthorId();
            if (r125 != null) goto L130;
            r125 = r312;
        L130:
            r59[0] = TuplesKt.to("uid", r125);
            com.bytedance.android.ec.window.base.common.starter.f.a(r50, r51, r118, r119, r120, r121, r122, r123, r214, "search_result", null, r52, r9, r55, r215, false, r216, r313, MapsKt.mutableMapOf(r59), (String) r37.C.a(wn.a.y), (String) r37.C.a(wn.a.z), null, 260603904);
            goto L131
        L126:
            r58 = SourceType.UNKNOWN.getType();
            goto L127
        L122:
            r216 = null;
            goto L123
        L116:
            r54 = null;
            goto L117
        L99:
            if (r118.length() <= 0) goto L101;
            boolean r126 = true;
        L102:
            if (r126 == true) goto L105;
            r118 = null;
        L105:
            if (r118 != null) goto L107;
        L101:
            r126 = false;
            goto L102
        L67:
            r26 = "";
            goto L68
        L63:
            r24 = "0";
            goto L64
        L59:
            r23 = "0";
            goto L60
        L55:
            r22 = "0";
            goto L56
        L44:
            if (r21.length() <= 0) goto L46;
            boolean r127 = true;
        L47:
            if (r127 == true) goto L50;
            r21 = null;
        L50:
            if (r21 != null) goto L52;
        L46:
            r127 = false;
            goto L47
        L28:
            r112 = "products";
            goto L29
        L22:
            r111 = null;
            goto L23
        L18:
            r18 = null;
            goto L19
        L14:
            r11 = "a1.b7881.c9580.d5355";
            goto L15
        }

        public final void c(WindowV2ProductItemVO r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r2, "item");
        }

        public final void d(WindowV2ProductItemVO r19) {
            Intrinsics.checkNotNullParameter(r19, "item");
            if (a2.b(r19.r) == false) goto L83;
            int r0 = r19.f;
            if (r0 != 1) goto L16;
            UrlBuilderV2 r1 = new UrlBuilderV2(r19.r);
            JSONObject r13 = com.bytedance.android.shopping.extensions.k.w((String) WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getPassThroughParam(this.a.n));
            if (r13 == null) goto L9;
            r1.addOrReplaceParam(this.a.n, r13);
        L9:
            String r2 = r1.build();
            com.bytedance.android.ec.sdk.helper.p r14 = com.bytedance.android.ec.sdk.helper.p.a;
            QContext r15 = this.a.Y();
            Context r16 = l0.c(r15.c());
            if ((r16 instanceof FragmentActivity) == true) goto L12;
            Context r7 = null;
        L13:
            if (r7 != null) goto L15;
            r7 = r15.a();
        L15:
            r14.openSchema(r7, r2);
            WindowSearchProductCardGroupPresenter.k0(this.a).doEventAction("window_tag_click", new Pair[]{TuplesKt.to("entrance_location", "store_page_product_card"), TuplesKt.to("enter_from", "store_page_product_card"), TuplesKt.to("product_id", r19.a), TuplesKt.to("tag_type", CommentServiceId.HOT_SPOT)});
            return;
        L12:
            r7 = r16;
            goto L13
        L16:
            if (r0 != 2) goto L85;
            int r3 = zq3.l.a;
            Gson r4 = zq3.c.a;
            Object r8 = Boolean.TRUE;
            if (zq3.c.b == false) goto L29;
            int r5 = com.bytedance.android.ec.core.opt.ab.p.a;
            Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L24
            jj4.b r9 = jj4.b.b;     // Catch: Throwable -> L24
            Object r10 = jj4.a.a("window_search_remove_passthrough", Boolean.class, r8, false);     // Catch: Throwable -> L24
            if (r10 != null) goto L56;
            Intrinsics.throwNpe();     // Catch: Throwable -> L24
        L56:
            if (((Boolean) r10).booleanValue() == true) goto L58;
            String r11 = r19.r;
        L62:
            StringBuilder r12 = new StringBuilder();
            if ((r19 instanceof com.bytedance.android.ec.window.base.repository.vo.e) == false) goto L65;
            String r17 = "a1.b7881.c1215.d4718";
        L66:
            r12.append(r17);
            r12.append("_i");
            r12.append(r19.y + 1);
            String r18 = r12.toString();
            int r110 = com.bytedance.android.ec.window.base.product.presenter.utils.b.a;
            Pair r111 = com.bytedance.android.ec.window.base.product.presenter.utils.b.b(r18, true, this.a.a0());
            com.bytedance.android.ec.sdk.helper.p r112 = com.bytedance.android.ec.sdk.helper.p.a;
            QContext r113 = this.a.Y();
            FragmentActivity r20 = l0.c(r113.c());
            if ((r20 instanceof FragmentActivity) == true) goto L69;
            FragmentActivity r114 = null;
        L70:
            if (r114 != null) goto L72;
            r114 = r113.a();
        L72:
            int r21 = com.bytedance.android.ec.window.base.utils.f.a;
            r112.openSchema(r114, com.bytedance.android.ec.window.base.utils.f.b(r11, r18, PageFinder.via(this.b)));
            WindowSearchFragmentProductViewModel r22 = WindowSearchProductCardGroupPresenter.k0(this.a);
            Pair[] r23 = new Pair[6];
            String r24 = WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getAuthorId();
            if (r24 != null) goto L75;
            r24 = "";
        L75:
            r23[0] = TuplesKt.to("author_id", r24);
            r23[1] = TuplesKt.to("entrance_location", "store_page_product_card");
            r23[2] = TuplesKt.to("enter_from", "store_page_product_card");
            r23[3] = TuplesKt.to("store_type", "shop");
            r23[4] = TuplesKt.to("product_id", r19.a);
            r23[5] = r111;
            r22.doEventAction("click_store_entrance", r23);
            return;
        L69:
            r114 = r20;
            goto L70
        L65:
            r17 = "a1.b7881.c9580.d89587";
            goto L66
        L58:
            String r25 = r19.r;
            if (r25 == null) goto L61;
            m0 r26 = new m0(r25);
            r26.b("enter_from", "store_page_product_card");
            r26.b("pass_through_api", (String) WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getPassThroughParam("pass_through_api"));
            r11 = r26.c();
            goto L62
        L61:
            r11 = null;
        L24:
            th = move-exception;
            Result.Companion r115 = Result.Companion;
            Object r27 = Result.constructor-impl(ResultKt.createFailure(th));
            if (Result.isFailure-impl(r27) == true) goto L54;
        L28:
            r8 = r27;
        L54:
            r10 = r8;
            goto L56
        L29:
            String r28 = hq7.d.b("debug.shopping.mock.window_search_remove_passthrough");
            if (r28 != null) goto L32;
        L35:
            boolean r116 = true;
        L36:
            if (r116 == false) goto L79;
        L44:
            r10 = null;
        L45:
            if (r10 != null) goto L56;
            int r29 = com.bytedance.android.ec.core.opt.ab.p.a;
            Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L51
            jj4.b r31 = jj4.b.b;     // Catch: Throwable -> L51
            r10 = jj4.a.a("window_search_remove_passthrough", Boolean.class, r8, false);     // Catch: Throwable -> L51
            if (r10 != null) goto L56;
            Intrinsics.throwNpe();     // Catch: Throwable -> L51
        L51:
            th = move-exception;
            Result.Companion r117 = Result.Companion;
            r27 = Result.constructor-impl(ResultKt.createFailure(th));
            if (Result.isFailure-impl(r27) == false) goto L28;
        L79:
            r10 = zq3.c.a.fromJson(r28, new c0().getType());     // Catch: Exception -> L42
            if (r10 == null) goto L44;
        L42:
            e = move-exception;
            ECExceptionMonitor.e(e);
            goto L44
        L32:
            if (StringsKt.isBlank(r28) == true) goto L35;
            r116 = false;
            goto L36
        L85:
            return;
        }

        public final void e(WindowV2ProductItemVO r10) {
            Intrinsics.checkNotNullParameter(r10, "item");
            StringBuilder r0 = new StringBuilder();
            if ((r10 instanceof com.bytedance.android.ec.window.base.repository.vo.e) == false) goto L5;
            String r1 = "a1.b7881.c1215.d4718";
        L6:
            r0.append(r1);
            r0.append("_i");
            r0.append(r10.y + 1);
            String r4 = r0.toString();
            WindowSearchFragmentProductViewModel r3 = WindowSearchProductCardGroupPresenter.k0(this.a);
            PageFinder r5 = PageFinder.via(this.b);
            Pair[] r2 = new Pair[5];
            String r6 = WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getAuthorId();
            if (r6 != null) goto L9;
            r6 = "";
        L9:
            r2[0] = TuplesKt.to("author_id", r6);
            r2[1] = TuplesKt.to("entrance_location", "store_page_product_card");
            r2[2] = TuplesKt.to("enter_from", "store_page_product_card");
            r2[3] = TuplesKt.to("store_type", "shop");
            r2[4] = TuplesKt.to("product_id", r10.a);
            r3.doAnyEventActionWithBtm(r4, r5, "show_store_entrance", MapsKt.mapOf(r2), new Pair[0]);
            return;
        L5:
            r1 = "a1.b7881.c9580.d89587";
            goto L6
        }

        public final void f(WindowFollowCouponTagView r2) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            Intrinsics.checkNotNullParameter(r2, "tag");
        }

        public final void g(WindowV2ProductItemVO r7) {
            Intrinsics.checkNotNullParameter(r7, "item");
            if (WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().isPreview() == false) goto L6;
            return;
        L6:
            if (WindowSearchProductCardGroupPresenter.k0(this.a).getIdRecords().contains(r7.a) == true) goto L15;
            StringBuilder r0 = new StringBuilder();
            if ((r7 instanceof com.bytedance.android.ec.window.base.repository.vo.e) == false) goto L10;
            String r2 = "a1.b7881.c1215.d7284";
        L11:
            r0.append(r2);
            r0.append("_i");
            r0.append(r7.y + 1);
            String r1 = r0.toString();
            int r3 = WindowBstReport.a;
            View r4 = this.a.a0();
            Map<String, String> r5 = l("show_product", r7);
            if (r5 != null) goto L14;
            r5 = MapsKt.emptyMap();
        L14:
            WindowSearchFragmentProductViewModel r6 = WindowSearchProductCardGroupPresenter.k0(this.a);
            Intrinsics.checkNotNullParameter(r5, "eventParams");
            Intrinsics.checkNotNullParameter(r6, "reporter");
            WindowBstReport.e(r4, r1, r7, new com.bytedance.android.window.shop.product.utils.c(r6, r5, r5));
            goto L15
        L10:
            r2 = "a1.b7881.c9580.d5355";
        L15:
            WindowSearchFragmentProductViewModel r8 = WindowSearchProductCardGroupPresenter.k0(this.a);
            Pair[] r9 = new Pair[9];
            r9[0] = TuplesKt.to("log_pb", GsonProtectorUtils.toJson(new Gson(), WindowSearchProductCardGroupPresenter.k0(this.a).getRequestParam().getLogPb()));
            WindowLogPbDTO r10 = WindowSearchProductCardGroupPresenter.k0(this.a).getRequestParam().getLogPb();
            if (r10 == null) goto L18;
            String r11 = r10.getImprId();
        L19:
            r9[1] = TuplesKt.to("impr_id", r11);
            r9[2] = TuplesKt.to("search_id", WindowSearchProductCardGroupPresenter.k0(this.a).getRequestParam().getSearchId());
            r9[3] = TuplesKt.to("search_result_id", r7.a);
            r9[4] = TuplesKt.to("search_keyword", WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getSearchKeyword());
            r9[5] = TuplesKt.to("rank", String.valueOf(r7.y));
            r9[6] = TuplesKt.to("enter_from", "search_window");
            r9[7] = TuplesKt.to("is_aladdin", "0");
            r9[8] = TuplesKt.to("token_type", "commodity");
            r8.doEventAction("search_result_show", r9);
            WindowSearchProductCardGroupPresenter.k0(this.a).getIdRecords().add(r7.a);
            return;
        L18:
            r11 = null;
            goto L19
        }

        public final void h(WindowV2ProductItemVO r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r2, "item");
        }

        public final void i(WindowV2ProductItemVO r5) {
            Intrinsics.checkNotNullParameter(r5, "item");
            WindowSearchProductCardGroupPresenter.k0(this.a).doEventAction("click_add_to_cart", com.bytedance.android.ec.window.base.product.presenter.utils.b.c(r5), new Pair[]{TuplesKt.to("ecom_entrance_form", "featured"), TuplesKt.to("temp_id", WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getTempId()), TuplesKt.to("customer_id", WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getProductBasicRequestParam().getMaterialId()), TuplesKt.to("page_type", "product_list"), TuplesKt.to("search_params", WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getSearchParams()), TuplesKt.to("follow_status", String.valueOf(WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getFollowStatus())), TuplesKt.to("bst_group_type", "product")});
        }

        public final void k(sq3.h r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r2, "item");
        }

        public b(WindowSearchProductCardGroupPresenter r1, Fragment r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Map<String, String> l(String r42, WindowV2ProductItemVO r43) {
            Intrinsics.checkNotNullParameter(r42, "eventName");
            Intrinsics.checkNotNullParameter(r43, "item");
            int r3 = r42.hashCode();
            if (r3 == 1132134829) goto L37;
            if (r3 == 2022256952) goto L8;
        L65:
            return null;
        L8:
            if (r42.equals("click_product") == false) goto L65;
            JSONObject r1 = new JSONObject();
            String r4 = WindowSearchProductCardGroupPresenter.k0(this.a).getRequestParam().getSearchId();
            if (r4 != null) goto L12;
            r4 = "";
        L12:
            r1.put("search_id", r4);
            r1.put("search_result_id", r43.a);
            String r2 = r1.toString();
            StringBuilder r5 = new StringBuilder();
            if ((r43 instanceof com.bytedance.android.ec.window.base.repository.vo.e) == false) goto L15;
            String r11 = "a1.b7881.c1215.d7284";
        L16:
            r5.append(r11);
            r5.append("_i");
            r5.append(r43.y + 1);
            String r6 = r5.toString();
            int r10 = com.bytedance.android.ec.window.base.product.presenter.utils.b.a;
            Pair r7 = com.bytedance.android.ec.window.base.product.presenter.utils.b.b(r6, false, this.a.a0());
            Map<String, String> r8 = com.bytedance.android.ec.window.base.product.presenter.utils.b.c(r43);
            Pair[] r12 = new Pair[17];
            if (Intrinsics.areEqual(WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getShareContent(), "showcase") == false) goto L19;
            Object r9 = "share_alert";
        L20:
            r12[0] = TuplesKt.to("ecom_entrance_form", r9);
            String r13 = WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getAuthorId();
            if (r13 != null) goto L23;
            r13 = "";
        L23:
            r12[1] = TuplesKt.to("author_id", r13);
            r12[2] = TuplesKt.to("entrance_location", WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getEntranceLocation());
            r12[3] = TuplesKt.to("search_params", r2);
            if (WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().isPreview() == false) goto L26;
            Object r14 = CommentScene.COMMENTSCENE_NO_AWEME;
        L27:
            r12[4] = TuplesKt.to("is_enter_preview", r14);
            r12[5] = TuplesKt.to("store_source_page", WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getStoreSourcePage());
            r12[6] = TuplesKt.to("store_source_method", WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getStoreSourceMethod());
            r12[7] = TuplesKt.to("store_group_type", WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getStoreGroupType());
            r12[8] = TuplesKt.to("brand_verified", "0");
            r12[9] = TuplesKt.to("content_source", "shop");
            r12[10] = TuplesKt.to("source_page", "store_page");
            r12[11] = TuplesKt.to("store_type", "window");
            if (WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().isEcShare() == false) goto L30;
            Pair r15 = TuplesKt.to("share_content", WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getShareContent());
            Object r16 = "";
        L31:
            r12[12] = r15;
            if (WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().isEcShare() == false) goto L34;
            Pair r17 = TuplesKt.to("share_object", WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getShareObject());
        L35:
            r12[13] = r17;
            r12[14] = r7;
            r12[15] = TuplesKt.to("bst_group_type", "product");
            r12[16] = TuplesKt.to("bst_tag", "bst_tag");
            r8.putAll(MapsKt.mapOf(r12));
            return r8;
        L34:
            r17 = TuplesKt.to(r16, r16);
            goto L35
        L30:
            r16 = "";
            r15 = TuplesKt.to(r16, r16);
            goto L31
        L26:
            r14 = "0";
            goto L27
        L19:
            r9 = "search_result";
            goto L20
        L15:
            r11 = "a1.b7881.c9580.d5355";
            goto L16
        L37:
            if (r42.equals("show_product") == false) goto L65;
            JSONObject r18 = new JSONObject();
            String r19 = WindowSearchProductCardGroupPresenter.k0(this.a).getRequestParam().getSearchId();
            if (r19 != null) goto L41;
            r19 = "";
        L41:
            r18.put("search_id", r19);
            r18.put("search_result_id", r43.a);
            String r20 = r18.toString();
            StringBuilder r21 = new StringBuilder();
            if ((r43 instanceof com.bytedance.android.ec.window.base.repository.vo.e) == false) goto L44;
            String r110 = "a1.b7881.c1215.d7284";
        L45:
            r21.append(r110);
            r21.append("_i");
            r21.append(r43.y + 1);
            String r22 = r21.toString();
            int r111 = com.bytedance.android.ec.window.base.product.presenter.utils.b.a;
            Pair r23 = com.bytedance.android.ec.window.base.product.presenter.utils.b.b(r22, false, this.a.a0());
            Map<String, String> r24 = com.bytedance.android.ec.window.base.product.presenter.utils.b.c(r43);
            Pair[] r112 = new Pair[17];
            if (Intrinsics.areEqual(WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getShareContent(), "showcase") == false) goto L48;
            Object r25 = "share_alert";
        L49:
            r112[0] = TuplesKt.to("ecom_entrance_form", r25);
            String r26 = WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getAuthorId();
            if (r26 != null) goto L52;
            r26 = "";
        L52:
            r112[1] = TuplesKt.to("author_id", r26);
            r112[2] = TuplesKt.to("entrance_location", WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getEntranceLocation());
            r112[3] = TuplesKt.to("search_params", r20);
            if (WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().isPreview() == false) goto L55;
            Object r27 = CommentScene.COMMENTSCENE_NO_AWEME;
        L56:
            r112[4] = TuplesKt.to("is_enter_preview", r27);
            r112[5] = TuplesKt.to("store_source_page", WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getStoreSourcePage());
            r112[6] = TuplesKt.to("store_source_method", WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getStoreSourceMethod());
            r112[7] = TuplesKt.to("store_group_type", WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getStoreGroupType());
            r112[8] = TuplesKt.to("brand_verified", "0");
            r112[9] = TuplesKt.to("content_source", "shop");
            r112[10] = TuplesKt.to("source_page", "store_page");
            r112[11] = TuplesKt.to("store_type", "window");
            r112[12] = r23;
            r112[13] = TuplesKt.to("bst_group_type", "product");
            r112[14] = TuplesKt.to("bst_tag", "bst_tag");
            if (WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().isEcShare() == false) goto L59;
            Pair r28 = TuplesKt.to("share_content", WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getShareContent());
            Object r29 = "";
        L60:
            r112[15] = r28;
            if (WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().isEcShare() == false) goto L63;
            Pair r30 = TuplesKt.to("share_object", WindowSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getShareObject());
        L64:
            r112[16] = r30;
            r24.putAll(MapsKt.mapOf(r112));
            return r24;
        L63:
            r30 = TuplesKt.to(r29, r29);
            goto L64
        L59:
            r29 = "";
            r28 = TuplesKt.to(r29, r29);
            goto L60
        L55:
            r27 = "0";
            goto L56
        L48:
            r25 = "search_result";
            goto L49
        L44:
            r110 = "a1.b7881.c9580.d5355";
            goto L45
        }
    }

    public final yo.g e0() {
        return this.q;
    }

    public final yo.h h0() {
        return this.p;
    }

    public WindowSearchProductCardGroupPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.n = "metaInfo";
        this.o = LazyKt.lazy(new WindowSearchProductCardGroupPresenter$viewModel$2(this));
        this.p = new a(this);
        this.q = new b(this, r2);
    }

    public static final WindowSearchFragmentProductViewModel k0(WindowSearchProductCardGroupPresenter r0) {
        return (WindowSearchFragmentProductViewModel) r0.o.getValue();
    }
}
