package com.bytedance.android.shopping.store.search.presenter;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.response.anchorv3.SourceType;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.product.presenter.utils.ECProductCardFunctionUtils;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.ec.store.search.repository.dto.LogPbDTO;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.android.shopping.store.search.router.ECShopSearchParam;
import com.bytedance.android.shopping.store.search.viewmodel.ShopSearchFragmentProductViewModel;
import com.bytedance.android.shopping.widget.ecvideoplayer.ECVideoPlayer;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ShopSearchProductCardGroupPresenter extends sm.m {
    public final Lazy o;
    public final a p;
    public final b q;

    public static final class a implements sm.h {
        public final /* synthetic */ ShopSearchProductCardGroupPresenter a;

        public final Function3<String, String, Long, Unit> b() {
            return null;
        }

        public final Function1<Integer, Unit> e() {
            return null;
        }

        public final String g() {
            return null;
        }

        public final boolean h(StoreV2ProductItemVO r1) {
            return false;
        }

        public final void i(View r1) {
        }

        public final qn.a<ECVideoPlayer> k() {
            return null;
        }

        public final long l() {
            return -1;
        }

        public final boolean m(StoreV2ProductItemVO r1) {
            return false;
        }

        public final Integer n() {
            return 1;
        }

        public final xm.c o() {
            return null;
        }

        public final com.bytedance.android.ec.core.imagex.r p(Integer r1) {
            return null;
        }

        public final jm.a<ej3.a> q() {
            return null;
        }

        public final String a() {
            return ShopSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getStoreAccountParam().getUserId();
        }

        public final LayoutTypes c() {
            LayoutTypes r0 = (LayoutTypes) ShopSearchProductCardGroupPresenter.k0(this.a).getLayoutType().getValue();
            if (r0 == null) goto L5;
            return r0;
        L5:
            return LayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE;
        }

        public final String d() {
            return ShopSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getStoreAccountParam().getSecUserId();
        }

        public final xm.c f() {
            return ShopSearchProductCardGroupPresenter.k0(this.a).getTagPools();
        }

        public final boolean isClickable() {
            return !ShopSearchProductCardGroupPresenter.k0(this.a).getSearchParam().isPreview();
        }

        public a(ShopSearchProductCardGroupPresenter r1) {
            this.a = r1;
        }

        public final com.bytedance.android.ec.core.imagex.r j(Integer r1) {
            int r2 = com.bytedance.android.ec.core.imagex.r.h;
            return com.bytedance.android.ec.core.imagex.r.a.c("ec_shop_search_product_card");
        }
    }

    public static final class b implements sm.g {
        public final /* synthetic */ ShopSearchProductCardGroupPresenter a;
        public final /* synthetic */ Fragment b;

        public final void b(StoreV2ProductItemVO r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
        }

        public final void a(View r2) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            Intrinsics.checkNotNullParameter(r2, "tag");
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
            if (ShopSearchProductCardGroupPresenter.k0(this.a).getIdRecords().contains(r6.a) == false) goto L5;
            return;
        L5:
            StringBuilder r0 = new StringBuilder();
            if ((r6 instanceof com.bytedance.android.ec.store.repository.vo.o) == false) goto L8;
            String r1 = "a1.b7881.c1215.d7284";
        L9:
            r0.append(r1);
            r0.append("_i");
            r0.append(r6.v + 1);
            String r2 = r0.toString();
            Map<String, String> r3 = k(r6);
            int r4 = com.bytedance.android.ec.store.window.f.a;
            com.bytedance.android.ec.store.window.f.e(this.a.a0(), r2, r6, r3, ShopSearchProductCardGroupPresenter.k0(this.a));
            ShopSearchFragmentProductViewModel r5 = ShopSearchProductCardGroupPresenter.k0(this.a);
            Pair[] r7 = new Pair[9];
            r7[0] = TuplesKt.to("log_pb", GsonProtectorUtils.toJson(new Gson(), ShopSearchProductCardGroupPresenter.k0(this.a).getRequestParam().getLogPb()));
            LogPbDTO r8 = ShopSearchProductCardGroupPresenter.k0(this.a).getRequestParam().getLogPb();
            if (r8 == null) goto L12;
            String r9 = r8.getImprId();
        L13:
            r7[1] = TuplesKt.to("impr_id", r9);
            r7[2] = TuplesKt.to("search_id", ShopSearchProductCardGroupPresenter.k0(this.a).getRequestParam().getSearchId());
            r7[3] = TuplesKt.to("search_result_id", r6.a);
            r7[4] = TuplesKt.to("search_keyword", ShopSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getSearchKeyword());
            r7[5] = TuplesKt.to("rank", String.valueOf(r6.v));
            r7[6] = TuplesKt.to("enter_from", "search_store");
            r7[7] = TuplesKt.to("is_aladdin", "0");
            r7[8] = TuplesKt.to("token_type", "commodity");
            r5.doEventAction("search_result_show", r7);
            ShopSearchProductCardGroupPresenter.k0(this.a).getIdRecords().add(r6.a);
            return;
        L12:
            r9 = null;
            goto L13
        L8:
            r1 = "a1.b7881.c9580.d5355";
            goto L9
        }

        public final void f(StoreV2ProductItemVO r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r2, "item");
        }

        public final void g(StoreV2ProductItemVO r43) {
            Intrinsics.checkNotNullParameter(r43, "item");
            HashMap r2 = new HashMap();
            String r3 = ShopSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getStoreSourcePage();
            if (r3 != null) goto L5;
            r3 = "store_page";
        L5:
            r2.put("enter_from_merge", r3);
            String r4 = ShopSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getStoreSourceMethod();
            if (r4 != null) goto L8;
            r4 = "mini_Window";
        L8:
            r2.put("enter_method", r4);
            r2.put("data_type", "commerce_data");
            int r5 = ECProductCardFunctionUtils.a;
            ECProductCardFunctionUtils.b(r43, this.a.Y(), r2);
            ECShopSearchParam r6 = this.a.Y().g(ShopSearchFragmentProductViewModel.class).getSearchParam();
            JSONObject r7 = new JSONObject();
            String r8 = ShopSearchProductCardGroupPresenter.k0(this.a).getRequestParam().getSearchId();
            if (r8 != null) goto L11;
            r8 = "";
        L11:
            r7.put("search_id", r8);
            r7.put("search_result_id", r43.a);
            String r9 = r7.toString();
            StringBuilder r10 = new StringBuilder();
            boolean r11 = r43 instanceof com.bytedance.android.ec.store.repository.vo.o;
            if (r11 == false) goto L14;
            String r12 = "a1.b7881.c1215.d7284";
        L15:
            r10.append(r12);
            r10.append("_i");
            r10.append(r43.v + 1);
            String r13 = r10.toString();
            int r14 = com.bytedance.android.ec.store.product.presenter.utils.a.a;
            Pair r15 = com.bytedance.android.ec.store.product.presenter.utils.a.b(r13, this.a.a0());
            Map<String, String> r16 = k(r43);
            int r17 = com.bytedance.android.ec.store.window.f.a;
            com.bytedance.android.ec.store.window.f.c(this.a.a0(), r13, r43, r16, ShopSearchProductCardGroupPresenter.k0(this.a));
            ShopSearchFragmentProductViewModel r18 = ShopSearchProductCardGroupPresenter.k0(this.a);
            Pair[] r19 = new Pair[11];
            r19[0] = TuplesKt.to("log_pb", GsonProtectorUtils.toJson(new Gson(), ShopSearchProductCardGroupPresenter.k0(this.a).getRequestParam().getLogPb()));
            LogPbDTO r110 = ShopSearchProductCardGroupPresenter.k0(this.a).getRequestParam().getLogPb();
            if (r110 == null) goto L18;
            String r111 = r110.getImprId();
        L19:
            r19[1] = TuplesKt.to("impr_id", r111);
            r19[2] = TuplesKt.to("search_id", ShopSearchProductCardGroupPresenter.k0(this.a).getRequestParam().getSearchId());
            r19[3] = TuplesKt.to("search_result_id", r43.a);
            r19[4] = TuplesKt.to("search_keyword", ShopSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getSearchKeyword());
            r19[5] = TuplesKt.to("rank", String.valueOf(r43.v));
            r19[6] = TuplesKt.to("enter_from", "search_store");
            r19[7] = TuplesKt.to("is_aladdin", "0");
            r19[8] = TuplesKt.to("token_type", "commodity");
            r19[9] = TuplesKt.to("button_type", "click_info");
            r19[10] = r15;
            r18.doEventAction("search_result_click", r19);
            if (com.bytedance.android.shopping.extensions.k.c(r43.l) == false) goto L26;
            int r112 = ECSdk.a;
            IAdapterService r113 = (IAdapterService) ECSdk.a(IAdapterService.class);
            if (r113 == null) goto L26;
            com.bytedance.android.ec.adapter.api.j r114 = r113.getLiveWindowService();
            if (r114 == null) goto L26;
            r114.stopShowFloat();
            Unit r115 = Unit.INSTANCE;
        L26:
            List r116 = com.bytedance.android.ec.store.utils.c.a;
            com.bytedance.android.ec.store.utils.c.a(r43.a);
            BtmSDK r117 = BtmSDK.INSTANCE;
            PageFinder r118 = PageFinder.via(this.b);
            BcmParams r119 = new BcmParams();
            r119.put("search_params", r9);
            r119.put("bst_group_type", "product");
            Unit r20 = Unit.INSTANCE;
            String r21 = r117.createJumpSourceBtmToken(r13, r118, r119);
            if (r11 == false) goto L29;
            String r22 = "search_result_102";
        L30:
            String r120 = "products";
            if (Intrinsics.areEqual(r6.getTabName(), "products") == false) goto L34;
        L37:
            com.bytedance.commerce.base.json.a[] r23 = new com.bytedance.commerce.base.json.a[24];
            r23[0] = JsonDslUtilKt.d("product_source_page", r6.getEntranceLocation());
            r23[1] = JsonDslUtilKt.d("source_method", r120);
            String r121 = r6.getTabNameSecond();
            if (r121 == null) goto L41;
            r22 = r121;
        L41:
            r23[2] = JsonDslUtilKt.d("source_method_second", r22);
            String r24 = r6.getTabLabel();
            if (r24 != null) goto L44;
            r24 = "";
        L44:
            r23[3] = JsonDslUtilKt.d("tab_label", r24);
            r23[4] = JsonDslUtilKt.d("page_name", r6.getPageName());
            r23[5] = JsonDslUtilKt.d("price_type", String.valueOf(r43.h));
            Integer r25 = r6.getFollowStatus();
            if (r25 == null) goto L47;
            String r26 = String.valueOf(r25.intValue());
        L48:
            if (r26 != null) goto L50;
            r26 = "";
        L50:
            r23[6] = JsonDslUtilKt.d("follow_status", r26);
            String r27 = r6.getTempId();
            if (r27 != null) goto L53;
            r27 = "";
        L53:
            r23[7] = JsonDslUtilKt.d("temp_id", r27);
            r23[8] = JsonDslUtilKt.d("store_type", "shop");
            String r28 = r6.getStoreSourcePage();
            if (r28 != null) goto L56;
            r28 = "";
        L56:
            r23[9] = JsonDslUtilKt.d("store_source_page", r28);
            String r29 = r6.getStoreSourceMethod();
            if (r29 != null) goto L59;
            r29 = "";
        L59:
            r23[10] = JsonDslUtilKt.d("store_source_method", r29);
            String r30 = r6.getStoreGroupType();
            if (r30 != null) goto L62;
            r30 = "";
        L62:
            r23[11] = JsonDslUtilKt.d("store_group_type", r30);
            im.v r31 = r43.u;
            if (r31 == null) goto L65;
            String r32 = r31.i();
        L66:
            r23[12] = JsonDslUtilKt.d("room_id", String.valueOf(r32));
            List r33 = r43.c("ecom_shop_product_below");
            String r122 = CommentScene.COMMENTSCENE_NO_AWEME;
            if (r33 == null) goto L69;
            String r34 = CommentScene.COMMENTSCENE_NO_AWEME;
        L70:
            r23[13] = JsonDslUtilKt.d("is_product_info", r34);
            if (com.bytedance.android.shopping.extensions.k.c(r43.h) == false) goto L73;
            String r35 = CommentScene.COMMENTSCENE_NO_AWEME;
        L74:
            r23[14] = JsonDslUtilKt.d("is_price_info", r35);
            if (r43.c("ecom_shop_product_recommend") == null) goto L77;
            String r36 = CommentScene.COMMENTSCENE_NO_AWEME;
        L78:
            r23[15] = JsonDslUtilKt.d("is_recommend_info", r36);
            if (r6.isStoreHotSearch() == true) goto L82;
            r122 = "0";
        L82:
            r23[16] = JsonDslUtilKt.d("is_store_hot_search", r122);
            com.bytedance.android.ec.store.repository.dto.l.b r37 = r43.s;
            if (r37 == null) goto L85;
            String r38 = r37.d();
        L86:
            r23[17] = JsonDslUtilKt.d("content_form", r38);
            r23[18] = JsonDslUtilKt.d("content_source", "shop");
            r23[19] = JsonDslUtilKt.d("product_ratio", r43.b());
            r23[20] = JsonDslUtilKt.d("search_keyword", ShopSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getSearchKeyword());
            LayoutTypes r39 = (LayoutTypes) ShopSearchProductCardGroupPresenter.k0(this.a).getLayoutType().getValue();
            if (r39 != null) goto L90;
        L91:
            String r40 = "double_product";
        L93:
            r23[21] = JsonDslUtilKt.d("product_form", r40);
            r23[22] = JsonDslUtilKt.d("source_page", "store_page");
            r23[23] = JsonDslUtilKt.d("ecom_entrance_form", "search_result");
            JSONObject r41 = JsonDslUtilKt.a(r23);
            if (r6.getProductBasicRequestParam().isCustom() == false) goto L97;
            r41.accumulate("customer_id", r6.getProductBasicRequestParam().getMaterialId());
        L97:
            if (r6.isEcShare() == false) goto L99;
            r41.accumulate("share_content", r6.getShareContent());
            r41.accumulate("share_object", r6.getShareObject());
        L99:
            Map r42 = r43.o;
            if (r42 == null) goto L105;
            Iterator r44 = r42.entrySet().iterator();
        L103:
            if (r44.hasNext() == false) goto L105;
            Map.Entry r45 = (Map.Entry) r44.next();
            r41.put((String) r45.getKey(), r45.getValue());
        L105:
            JSONObject r46 = com.bytedance.android.shopping.extensions.k.w((String) ShopSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getPassThroughParam("pass_through_api"));
            if (r46 == null) goto L108;
            r41.put(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, r46.optString(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID));
        L108:
            z1.c(r41, ShopSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getEntranceInfo());
            JSONObject r47 = new JSONObject();
            String r123 = ShopSearchProductCardGroupPresenter.k0(this.a).getRequestParam().getSearchId();
            if (r123 != null) goto L111;
            r123 = "";
        L111:
            r47.put("search_id", r123);
            r47.put("search_result_id", r43.a);
            Unit r48 = Unit.INSTANCE;
            r41.put("search_params", r47.toString());
            if (com.bytedance.android.shopping.extensions.k.c(r43.C) == false) goto L117;
            int r49 = com.bytedance.android.ec.store.utils.b.a;
            String r310 = com.bytedance.android.ec.store.utils.b.a(r43.C, r21);
            if (r310 != null) goto L116;
            return;
        L116:
            hm.b r311 = hm.b.c;
            Context r312 = this.a.Y().c();
            String r313 = String.valueOf(r6.getFollowStatus());
            Map<String, Object> r50 = ShopSearchProductCardGroupPresenter.k0(this.a).getAdParams();
            r50.put("uid", r6.getAuthorId());
            r50.put("product_id", r43.a);
            com.bytedance.android.ec.store.common.starter.e.b(r311, r312, r310, r313, r41, r50, null, false, 448);
        L146:
            dm.a.a("SHOP").i("[click search product]productId:" + r43.a);
            dm.a.a("SHOP").i("[click search product]secShopId:" + r6.getSecShopId());
            return;
        L117:
            hm.b r51 = hm.b.c;
            Context r52 = this.a.Y().c();
            String r53 = r43.b;
            if (r53 != null) goto L120;
        L127:
            r53 = r43.a;
        L128:
            String r124 = r53;
            String r54 = r43.l;
            String r125 = ShopSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getAuthorId();
            String r126 = ShopSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getSecAuthorId();
            String r55 = r43.a;
            Integer r127 = r6.getFollowStatus();
            String r56 = r43.b;
            if (r56 != null) goto L131;
            r56 = "";
        L131:
            r41.put("promotion_id", r56);
            r41.put("carrier_source", "search_store");
            String r57 = r41.toString();
            com.bytedance.commerce.base.json.a[] r58 = new com.bytedance.commerce.base.json.a[1];
            JSONObject r59 = com.bytedance.android.shopping.extensions.k.w((String) ShopSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getPassThroughParam("pass_through_api"));
            if (r59 == null) goto L134;
            String r60 = r59.optString(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID);
        L135:
            if (r60 != null) goto L137;
            r60 = "";
        L137:
            r58[0] = JsonDslUtilKt.d(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, r60);
            JSONObject r210 = JsonDslUtilKt.a(r58);
            String r61 = (String) CollectionsKt.getOrNull(r43.f, 0);
            im.v r62 = r43.u;
            if (r62 == null) goto L140;
            String r211 = r62.i();
        L141:
            Long r63 = r43.c;
            if (r63 == null) goto L144;
            long r64 = r63.longValue();
        L145:
            long r212 = r64;
            Map<String, Object> r65 = ShopSearchProductCardGroupPresenter.k0(this.a).getAdParams();
            r65.put("uid", r6.getAuthorId());
            com.bytedance.android.ec.store.common.starter.e.a(r51, r52, r124, "store_page", r54, r125, r126, r55, r127, "search_result", null, r57, r9, r210, r61, false, r211, r212, null, r65, null, null, r21, null, 199786496);
            goto L146
        L144:
            r64 = SourceType.UNKNOWN.getType();
            goto L145
        L140:
            r211 = null;
            goto L141
        L134:
            r60 = null;
            goto L135
        L120:
            if (r53.length() <= 0) goto L122;
            boolean r128 = true;
        L123:
            if (r128 == true) goto L126;
            r53 = null;
        L126:
            if (r53 != null) goto L128;
        L122:
            r128 = false;
            goto L123
        L90:
            if (l.b[r39.ordinal()] != 1) goto L91;
            r40 = "single_product";
            goto L93
        L85:
            r38 = "";
            goto L86
        L77:
            r36 = "0";
            goto L78
        L73:
            r35 = "0";
            goto L74
        L69:
            r34 = "0";
            goto L70
        L65:
            r32 = null;
            goto L66
        L47:
            r26 = null;
            goto L48
        L34:
            if (com.bytedance.android.shopping.extensions.k.c(r6.getTabNameSecond()) == false) goto L36;
            r120 = "homepage_featured";
            goto L37
        L36:
            r120 = "product_card";
            goto L37
        L29:
            r22 = "search_result_101";
            goto L30
        L18:
            r111 = null;
            goto L19
        L14:
            r12 = "a1.b7881.c9580.d5355";
            goto L15
        }

        public final void h(StoreV2ProductItemVO r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r2, "item");
        }

        public final Map<String, String> k(StoreV2ProductItemVO r10) {
            Intrinsics.checkNotNullParameter(r10, "item");
            ECShopSearchParam r0 = this.a.Y().g(ShopSearchFragmentProductViewModel.class).getSearchParam();
            StringBuilder r1 = new StringBuilder();
            if ((r10 instanceof com.bytedance.android.ec.store.repository.vo.o) == false) goto L5;
            String r2 = "a1.b7881.c1215.d7284";
        L6:
            r1.append(r2);
            r1.append("_i");
            r1.append(r10.v + 1);
            String r3 = r1.toString();
            int r4 = com.bytedance.android.ec.store.product.presenter.utils.a.a;
            Pair r5 = com.bytedance.android.ec.store.product.presenter.utils.a.b(r3, this.a.a0());
            boolean r6 = com.bytedance.android.shopping.extensions.k.c(ShopSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getTabNameSecond());
            if ((r10 instanceof com.bytedance.android.ec.store.repository.vo.o) == false) goto L9;
            String r7 = "search_result_102";
        L10:
            String r8 = "products";
            if (Intrinsics.areEqual(ShopSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getTabName(), "products") == true) goto L16;
            if (r6 == false) goto L15;
            r8 = "homepage_featured";
            goto L16
        L15:
            r8 = "search_result";
        L16:
            Map<String, String> r9 = com.bytedance.android.ec.store.product.presenter.utils.a.d(r10);
            Pair[] r11 = new Pair[27];
            r11[0] = TuplesKt.to("tab_name", r8);
            r11[1] = TuplesKt.to("ecom_entrance_form", r8);
            String r12 = ShopSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getTabNameSecond();
            if (r12 != null) goto L19;
            r12 = r7;
        L19:
            r11[2] = TuplesKt.to("tab_name_second", r12);
            String r13 = ShopSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getTabNameSecond();
            if (r13 == null) goto L23;
            r7 = r13;
        L23:
            r11[3] = TuplesKt.to("ecom_entrance_form_second", r7);
            r11[4] = TuplesKt.to("shop_id", ShopSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getShopId());
            r11[5] = TuplesKt.to("follow_status", String.valueOf(ShopSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getFollowStatus()));
            r11[6] = TuplesKt.to("entrance_info", ShopSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getEntranceInfo());
            r11[7] = TuplesKt.to("author_id", r0.getAuthorId());
            r11[8] = TuplesKt.to("entrance_location", r0.getEntranceLocation());
            JSONObject r14 = new JSONObject();
            r14.put("search_id", ShopSearchProductCardGroupPresenter.k0(this.a).getRequestParam().getSearchId());
            r14.put("search_result_id", r10.a);
            Unit r15 = Unit.INSTANCE;
            r11[9] = TuplesKt.to("search_params", r14.toString());
            if (r0.isPreview() == false) goto L26;
            String r16 = CommentScene.COMMENTSCENE_NO_AWEME;
        L27:
            r11[10] = TuplesKt.to("is_enter_preview", r16);
            r11[11] = TuplesKt.to("store_source_page", r0.getStoreSourcePage());
            r11[12] = TuplesKt.to("store_source_method", r0.getStoreSourceMethod());
            r11[13] = TuplesKt.to("store_group_type", r0.getStoreGroupType());
            r11[14] = TuplesKt.to("brand_verified", "0");
            r11[15] = TuplesKt.to("content_source", "shop");
            r11[16] = TuplesKt.to("source_page", "store_page");
            r11[17] = TuplesKt.to("store_type", "shop");
            r11[18] = TuplesKt.to("temp_id", ShopSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getTempId());
            LayoutTypes r17 = (LayoutTypes) ShopSearchProductCardGroupPresenter.k0(this.a).getLayoutType().getValue();
            if (r17 != null) goto L31;
        L32:
            String r18 = "double_product";
        L34:
            r11[19] = TuplesKt.to("product_form", r18);
            r11[20] = TuplesKt.to("page_name", ShopSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getPageName());
            if (ShopSearchProductCardGroupPresenter.k0(this.a).getSearchParam().isEcShare() == false) goto L37;
            Pair r19 = TuplesKt.to("share_content", ShopSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getShareContent());
        L38:
            r11[21] = r19;
            if (ShopSearchProductCardGroupPresenter.k0(this.a).getSearchParam().isEcShare() == false) goto L41;
            Pair r110 = TuplesKt.to("share_object", ShopSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getShareObject());
        L42:
            r11[22] = r110;
            r11[23] = r5;
            r11[24] = TuplesKt.to("bst_group_type", "product");
            r11[25] = TuplesKt.to("shop_search_enter_method", ShopSearchProductCardGroupPresenter.k0(this.a).getSearchParam().getEnterMethod());
            r11[26] = TuplesKt.to("bst_tag", "bst_tag");
            r9.putAll(MapsKt.mapOf(r11));
            return r9;
        L41:
            r110 = TuplesKt.to("", "");
            goto L42
        L37:
            r19 = TuplesKt.to("", "");
            goto L38
        L31:
            if (l.a[r17.ordinal()] != 1) goto L32;
            r18 = "single_product";
            goto L34
        L26:
            r16 = "0";
            goto L27
        L9:
            r7 = "search_result_101";
            goto L10
        L5:
            r2 = "a1.b7881.c9580.d5355";
            goto L6
        }

        public b(ShopSearchProductCardGroupPresenter r1, Fragment r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void i(StoreV2ProductItemVO r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "item");
            Intrinsics.checkNotNullParameter(r1, "item");
        }

        public final void j(com.bytedance.android.ec.store.repository.vo.l r2, Map r3, List r4, List r5) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "eventParams");
            Intrinsics.checkNotNullParameter(r4, "tagCodeList");
            Intrinsics.checkNotNullParameter(r5, "highlightTagCode");
            sm.g.a.a(r2, r3, r4, r5);
        }
    }

    public final sm.g h0() {
        return this.q;
    }

    public final sm.h i0() {
        return this.p;
    }

    public ShopSearchProductCardGroupPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.o = LazyKt.lazy(new ShopSearchProductCardGroupPresenter$viewModel$2(this));
        this.p = new a(this);
        this.q = new b(this, r2);
    }

    public static final ShopSearchFragmentProductViewModel k0(ShopSearchProductCardGroupPresenter r0) {
        return (ShopSearchFragmentProductViewModel) r0.o.getValue();
    }
}
