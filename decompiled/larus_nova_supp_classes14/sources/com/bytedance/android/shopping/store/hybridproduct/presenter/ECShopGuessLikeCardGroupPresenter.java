package com.bytedance.android.shopping.store.hybridproduct.presenter;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.model.response.anchorv3.SourceType;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.repository.dto.MarketingDataDTO;
import com.bytedance.android.ec.store.repository.vo.ProductCardType;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentServiceId;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopGuessLikeCardGroupPresenter extends sm.m {
    public final Lazy o;
    public final ECShopGuessLikeCardGroupPresenter$adapter$1 p;
    public final a q;
    public final ECStoreViewModel r;
    public final boolean s;

    public static final class a implements sm.g {
        public final /* synthetic */ ECShopGuessLikeCardGroupPresenter a;
        public final /* synthetic */ Fragment b;

        public final void a(View r2) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            Intrinsics.checkNotNullParameter(r2, "tag");
        }

        public final void b(StoreV2ProductItemVO r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r2, "item");
        }

        public final void c(StoreV2ProductItemVO r4) {
            Intrinsics.checkNotNullParameter(r4, "item");
            this.a.o0().doEventAction("add_to_cart_show", ECShopGuessLikeCardGroupPresenter.k0(this.a, "show_product", r4), new Pair[0]);
        }

        public final void d(StoreV2ProductItemVO r8) {
            Intrinsics.checkNotNullParameter(r8, "item");
            String r0 = this.a.o0().getEcomEntranceFrom();
            if ((!StringsKt.isBlank(r0)) == true) goto L6;
            r0 = null;
        L6:
            if (r0 == null) goto L8;
        L14:
            com.bytedance.commerce.base.json.a[] r1 = new com.bytedance.commerce.base.json.a[10];
            r1[0] = JsonDslUtilKt.d("carrier_source", "store_page");
            r1[1] = JsonDslUtilKt.d("store_type", "shop");
            r1[2] = JsonDslUtilKt.d("source_method", r0);
            r1[3] = JsonDslUtilKt.d("source_method_second", CommentServiceId.HOT_SPOT);
            LayoutTypes r2 = (LayoutTypes) this.a.o0().getLayoutType().getValue();
            if (r2 != null) goto L18;
        L19:
            String r3 = "double_product";
        L21:
            r1[4] = JsonDslUtilKt.d("product_form", r3);
            if (this.a.o0().hasDiscountSelected() == false) goto L24;
            String r4 = CommentScene.COMMENTSCENE_NO_AWEME;
        L25:
            r1[5] = JsonDslUtilKt.d("is_discount_selected", r4);
            if (Intrinsics.areEqual(this.a.o0().getStoreParam().getShareContent(), "shop") == false) goto L28;
            String r5 = "share_alert";
        L29:
            r1[6] = JsonDslUtilKt.d("product_source_page", r5);
            String r6 = this.a.o0().getStoreParam().getStoreSourcePage();
            String r7 = "";
            if (r6 != null) goto L32;
            r6 = "";
        L32:
            r1[7] = JsonDslUtilKt.d("store_source_page", r6);
            String r9 = this.a.o0().getStoreParam().getStoreSourceMethod();
            if (r9 != null) goto L35;
            r9 = "";
        L35:
            r1[8] = JsonDslUtilKt.d("store_source_method", r9);
            String r10 = this.a.o0().getStoreParam().getStoreGroupType();
            if (r10 == null) goto L39;
            r7 = r10;
        L39:
            r1[9] = JsonDslUtilKt.d("store_group_type", r7);
            this.a.o0().doEventAction("click_add_to_cart", com.bytedance.android.ec.store.product.presenter.utils.a.d(r8), new Pair[]{TuplesKt.to("entrance_info", JsonDslUtilKt.a(r1).toString()), TuplesKt.to("bst_group_type", "product")});
            this.a.o0().doEventAction("add_to_cart_click", ECShopGuessLikeCardGroupPresenter.k0(this.a, "click_product", r8), new Pair[0]);
            return;
        L28:
            r5 = this.a.o0().getStoreParam().getEntranceLocation();
            goto L29
        L24:
            r4 = "0";
            goto L25
        L18:
            if (c.a[r2.ordinal()] != 1) goto L19;
            r3 = "single_product";
            goto L21
        L8:
            if (Intrinsics.areEqual(this.a.o0().getStoreParam().getPageName(), "classification_secondary_page") == false) goto L11;
            r0 = "classification";
            goto L14
        L11:
            if (this.a.o0().getStoreParam().getProductBasicRequestParam().isCustom() == false) goto L13;
            r0 = "featured";
            goto L14
        L13:
            r0 = "products";
            goto L14
        }

        public final void e(StoreV2ProductItemVO r18) {
            Intrinsics.checkNotNullParameter(r18, "item");
            if (this.a.o0().getStoreParam().isPreview() == false) goto L6;
            return;
        L6:
            if (this.a.o0().getIdRecords().contains(r18.a) == false) goto L9;
            return;
        L9:
            if (r18.O.getType() >= ProductCardType.CROSS_SHOP_GOTO_SHOP.getType()) goto L11;
        L13:
            boolean r2 = false;
        L15:
            if (r2 == false) goto L17;
            this.a.o0().doAnyEventActionWithBtm(this.a.l0(r18), PageFinder.via(this.b), "show_ecom_component", MapsKt.mapOf(new Pair[]{TuplesKt.to("module_name", "cross_recommend_product"), TuplesKt.to("tab_name_second", "cross_recommend_product")}), new Pair[0]);
        L17:
            if (r2 == false) goto L19;
            String r9 = "cross_recommend_product";
        L30:
            ECShopHybridProductViewModel r11 = this.a.o0();
            String r12 = this.a.l0(r18);
            PageFinder r13 = PageFinder.via(this.b);
            Map<String, ? extends Object> r15 = com.bytedance.android.ec.store.product.presenter.utils.a.d(r18);
            ECShopGuessLikeCardGroupPresenter r10 = this.a;
            if (r10.s == false) goto L34;
            r15.put("ecom_entrance_form", r10.o0().getEcomEntranceFrom());
        L41:
            if (r2 == false) goto L43;
            r15.put("module_name", "cross_recommend_product");
        L43:
            Unit r3 = Unit.INSTANCE;
            Pair<String, ? extends Object>[] r4 = new Pair[5];
            ECStoreViewModel r5 = this.a.r;
            if (r5 == null) goto L47;
            String r6 = String.valueOf(r5.getShopExtraStatusType());
            if (r6 == null) goto L47;
        L48:
            r4[0] = TuplesKt.to("shop_extra_status_type", r6);
            r4[1] = TuplesKt.to("product_form", "double_product");
            r4[2] = TuplesKt.to("tab_name", "products");
            r4[3] = TuplesKt.to("tab_name_second", r9);
            r4[4] = TuplesKt.to("module_form", "store_shop_page");
            r11.doAnyEventActionWithBtm(r12, r13, "show_product", r15, r4);
            this.a.o0().getIdRecords().add(r18.a);
            return;
        L47:
            r6 = "";
            goto L48
        L34:
            if (r15.containsKey("ecom_entrance_form") == true) goto L41;
            Map r7 = r18.o;
            if (r7 == null) goto L39;
            String r8 = (String) r7.get("ecom_entrance_from");
            if (r8 == null) goto L39;
        L40:
            r15.put("ecom_entrance_form", r8);
            r15.remove("ecom_entrance_from");
        L39:
            r8 = "guess_you_like";
            goto L40
        L19:
            MarketingDataDTO r14 = r18.D;
            if (r14 == null) goto L22;
            String r16 = r14.getTransMeta();
        L24:
            if (com.bytedance.android.shopping.extensions.k.c(r16) == false) goto L27;
            r9 = "return_coin";
            goto L30
        L27:
            if (this.a.s == false) goto L29;
            r9 = "102";
            goto L30
        L29:
            r9 = "store_feed";
            goto L30
        L22:
            r16 = null;
            goto L24
        L11:
            if (r18.O.getType() > ProductCardType.CROSS_SHOP_GOTO_DETAIL.getType()) goto L13;
            r2 = true;
            goto L15
        }

        public final void f(StoreV2ProductItemVO r5) {
            Intrinsics.checkNotNullParameter(r5, "item");
            this.a.o0().doEventAction("add_cart_toast_show", com.bytedance.android.ec.store.product.presenter.utils.a.d(r5), new Pair[]{TuplesKt.to("page_name", "store_page"), TuplesKt.to("ecom_group_type", "product_card"), TuplesKt.to("bst_group_type", "product")});
        }

        public final void g(StoreV2ProductItemVO r58) {
            Intrinsics.checkNotNullParameter(r58, "item");
            BtmSDK r2 = BtmSDK.INSTANCE;
            String r3 = this.a.l0(r58);
            PageFinder r4 = PageFinder.via(this.b);
            BcmParams r5 = new BcmParams();
            r5.put("bst_group_type", "product");
            Unit r6 = Unit.INSTANCE;
            String r7 = r2.createJumpSourceBtmToken(r3, r4, r5);
            ECStoreParam r8 = this.a.o0().getStoreParam();
            ECStoreViewModel r9 = this.a.r;
            if (r9 == null) goto L7;
            im.b r10 = r9.getLiveManager();
            if (r10 == null) goto L7;
            r10.j();
        L7:
            ECStoreViewModel r11 = this.a.r;
            if (r11 == null) goto L10;
            r11.setEnterOtherPageCollaspeHeader(true);
        L10:
            int r12 = com.bytedance.android.ec.store.product.presenter.utils.a.a;
            JSONObject r13 = com.bytedance.android.ec.store.product.presenter.utils.a.e(r8.getSearchParams(), r58);
            String r14 = this.a.o0().getEcomEntranceFrom();
            String r33 = null;
            if ((!StringsKt.isBlank(r14)) == true) goto L14;
            r14 = null;
        L14:
            if (r14 == null) goto L16;
        L19:
            List r15 = com.bytedance.android.ec.store.utils.c.a;
            com.bytedance.android.ec.store.utils.c.a(r58.a);
            com.bytedance.commerce.base.json.a[] r16 = new com.bytedance.commerce.base.json.a[10];
            r16[0] = JsonDslUtilKt.d("product_form", "double_product");
            r16[1] = JsonDslUtilKt.d("carrier_source", "store_page");
            r16[2] = JsonDslUtilKt.d("store_type", "shop");
            if (this.a.s == false) goto L22;
            String r17 = "products";
        L27:
            r16[3] = JsonDslUtilKt.d("source_method", r17);
            if (r58.O.getType() >= ProductCardType.CROSS_SHOP_GOTO_SHOP.getType()) goto L30;
        L32:
            MarketingDataDTO r18 = r58.D;
            if (r18 == null) goto L35;
            String r19 = r18.getTransMeta();
        L37:
            if (com.bytedance.android.shopping.extensions.k.c(r19) == false) goto L40;
            String r20 = "return_coin";
        L43:
            r16[4] = JsonDslUtilKt.d("source_method_second", r20);
            r16[5] = JsonDslUtilKt.d("product_source_page", r8.getEntranceLocation());
            String r21 = r8.getStoreSourceMethod();
            if (r21 != null) goto L46;
            r21 = "";
        L46:
            r16[6] = JsonDslUtilKt.d("store_source_method", r21);
            String r22 = r8.getStoreSourcePage();
            if (r22 != null) goto L49;
            r22 = "";
        L49:
            r16[7] = JsonDslUtilKt.d("store_source_page", r22);
            String r23 = r8.getStoreGroupType();
            if (r23 != null) goto L52;
            r23 = "";
        L52:
            r16[8] = JsonDslUtilKt.d("store_group_type", r23);
            r16[9] = JsonDslUtilKt.d("module_form", "store_shop_page");
            JSONObject r24 = JsonDslUtilKt.a(r16);
            Map r110 = r58.o;
            if (r110 == null) goto L58;
            Iterator r111 = r110.entrySet().iterator();
        L56:
            if (r111.hasNext() == false) goto L58;
            Map.Entry r112 = (Map.Entry) r111.next();
            r24.put((String) r112.getKey(), r112.getValue());
        L58:
            String r25 = r58.M;
            if (r25 == null) goto L68;
            if (r25.length() <= 0) goto L63;
            boolean r26 = true;
        L65:
            if (r26 != true) goto L68;
            int r27 = com.bytedance.android.ec.store.utils.b.a;
            com.bytedance.android.ec.sdk.helper.p.a.openSchema(this.a.Y().c(), com.bytedance.android.ec.store.utils.b.a(r58.M, r7));
        L79:
            Object r51 = "store_shop_page";
            Object r50 = "module_form";
            Object r53 = "cross_recommend_product";
            Object r54 = "ecom_entrance_from";
            Object r52 = "products";
            int r28 = 2;
        L135:
            if (r58.O.getType() >= ProductCardType.CROSS_SHOP_GOTO_SHOP.getType()) goto L137;
        L139:
            boolean r113 = false;
        L141:
            if (r113 == false) goto L143;
            ECShopHybridProductViewModel r29 = this.a.o0();
            String r30 = this.a.l0(r58);
            PageFinder r31 = PageFinder.via(this.b);
            Pair[] r32 = new Pair[r28];
            Object r114 = r53;
            char r115 = 0;
            r32[0] = TuplesKt.to("module_name", r114);
            r32[1] = TuplesKt.to("tab_name_second", r114);
            r29.doAnyEventActionWithBtm(r30, r31, "click_ecom_component", MapsKt.mapOf(r32), new Pair[0]);
        L144:
            ECShopHybridProductViewModel r34 = this.a.o0();
            String r35 = this.a.l0(r58);
            PageFinder r36 = PageFinder.via(this.b);
            Map<String, ? extends Object> r116 = com.bytedance.android.ec.store.product.presenter.utils.a.d(r58);
            ECShopGuessLikeCardGroupPresenter r37 = this.a;
            if (r37.s == false) goto L148;
            r116.put("ecom_entrance_form", r37.o0().getEcomEntranceFrom());
        L155:
            if (r113 == false) goto L157;
            r116.put("module_name", r114);
        L157:
            Unit r38 = Unit.INSTANCE;
            Pair<String, ? extends Object>[] r117 = new Pair[6];
            ECStoreViewModel r39 = this.a.r;
            if (r39 == null) goto L161;
            String r40 = String.valueOf(r39.getShopExtraStatusType());
            if (r40 == null) goto L161;
        L162:
            r117[r115] = TuplesKt.to("shop_extra_status_type", r40);
            r117[1] = TuplesKt.to("product_form", "double_product");
            r117[2] = TuplesKt.to("sku_ids", this.a.m0(r58));
            r117[3] = TuplesKt.to("tab_name", r52);
            if (r113 == true) goto L175;
            MarketingDataDTO r41 = r58.D;
            if (r41 == null) goto L169;
            r33 = r41.getTransMeta();
        L169:
            if (com.bytedance.android.shopping.extensions.k.c(r33) == false) goto L172;
            r114 = "return_coin";
            goto L175
        L172:
            if (this.a.s == false) goto L174;
            r114 = "102";
            goto L175
        L174:
            r114 = "store_feed";
        L175:
            r117[4] = TuplesKt.to("tab_name_second", r114);
            r117[5] = TuplesKt.to(r50, r51);
            r34.doAnyEventActionWithBtm(r35, r36, "click_product", r116, r117);
            dm.a.a("SHOP").i("[click product]productId:" + r58.a);
            dm.a.a("SHOP").i("[click product]secShopId:" + r8.getSecShopId());
            return;
        L161:
            r40 = "";
            goto L162
        L148:
            if (r116.containsKey("ecom_entrance_form") == true) goto L155;
            Map r42 = r58.o;
            Object r118 = r54;
            if (r42 == null) goto L153;
            String r43 = (String) r42.get(r118);
            if (r43 == null) goto L153;
        L154:
            r116.put("ecom_entrance_form", r43);
            r116.remove(r118);
        L153:
            r43 = "guess_you_like";
            goto L154
        L143:
            r114 = r53;
            r115 = 0;
            goto L144
        L137:
            if (r58.O.getType() > ProductCardType.CROSS_SHOP_GOTO_DETAIL.getType()) goto L139;
            r113 = true;
            goto L141
        L63:
            r26 = false;
        L68:
            if (com.bytedance.android.shopping.extensions.k.c(r58.C) == false) goto L80;
            int r44 = com.bytedance.android.ec.store.utils.b.a;
            String r210 = com.bytedance.android.ec.store.utils.b.a(r58.C, r7);
            if (r210 != null) goto L72;
            return;
        L72:
            hm.b r119 = hm.b.c;
            Context r211 = this.a.Y().c();
            String r212 = String.valueOf(r8.getFollowStatus());
            ECStoreViewModel r45 = this.a.r;
            if (r45 == null) goto L77;
            Map<String, Object> r46 = r45.getAdParams();
            if (r46 == null) goto L77;
            r46.put("product_id", r58.a);
            Unit r47 = Unit.INSTANCE;
            Map<String, Object> r213 = r46;
        L78:
            com.bytedance.android.ec.store.common.starter.e.b(r119, r211, r210, r212, r24, r213, null, false, 448);
        L77:
            r213 = null;
            goto L78
        L80:
            hm.b r48 = hm.b.c;
            Context r120 = this.a.Y().c();
            String r121 = r58.b;
            if (r121 != null) goto L83;
        L90:
            r121 = r58.a;
        L91:
            String r122 = r58.l;
            String r49 = this.a.p.a();
            if (r49 != null) goto L94;
            String r214 = "";
        L95:
            String r55 = this.a.p.d();
            if (r55 != null) goto L98;
            String r215 = "";
        L99:
            String r56 = r58.a;
            Integer r216 = r8.getFollowStatus();
            ECShopGuessLikeCardGroupPresenter r57 = this.a;
            if (r57.s == false) goto L102;
            String r59 = r57.o0().getEcomEntranceFrom();
        L107:
            String r217 = r59;
        L109:
            String r218 = r8.getWhichAccount();
            MarketingDataDTO r60 = r58.D;
            if (r60 == null) goto L112;
            String r61 = r60.getTransMeta();
        L113:
            if (r61 != null) goto L115;
            r61 = "";
        L115:
            JsonDslUtilKt.d("trans_meta", r61);
            Unit r62 = Unit.INSTANCE;
            String r63 = r24.toString();
            if (r13 == null) goto L118;
            String r64 = r13.toString();
        L119:
            com.bytedance.commerce.base.json.a[] r65 = new com.bytedance.commerce.base.json.a[1];
            JSONObject r66 = com.bytedance.android.shopping.extensions.k.w((String) this.a.o0().getStoreParam().getPassThroughParam("pass_through_api"));
            if (r66 == null) goto L122;
            String r67 = r66.optString(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID);
        L123:
            if (r67 != null) goto L125;
            r67 = "";
        L125:
            r65[0] = JsonDslUtilKt.d(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, r67);
            JSONObject r310 = JsonDslUtilKt.a(r65);
            String r410 = (String) CollectionsKt.getOrNull(r58.f, 0);
            Long r68 = r58.c;
            if (r68 == null) goto L128;
            long r69 = r68.longValue();
        L129:
            long r411 = r69;
            ECStoreViewModel r70 = this.a.r;
            if (r70 == null) goto L132;
            Map<String, Object> r412 = r70.getAdParams();
        L133:
            r51 = "store_shop_page";
            r50 = "module_form";
            r52 = "products";
            r53 = "cross_recommend_product";
            r28 = 2;
            r54 = "ecom_entrance_from";
            com.bytedance.android.ec.store.common.starter.e.a(r48, r120, r121, "store_page", r122, r214, r215, r56, r216, r217, r218, r63, r64, r310, r410, false, null, r411, null, r412, null, null, r7, null, 199786496);
            goto L135
        L132:
            r412 = null;
            goto L133
        L128:
            r69 = SourceType.UNKNOWN.getType();
            goto L129
        L122:
            r67 = null;
            goto L123
        L118:
            r64 = null;
            goto L119
        L112:
            r61 = null;
            goto L113
        L102:
            Map r71 = r58.o;
            if (r71 == null) goto L108;
            r59 = (String) r71.get("ecom_entrance_from");
            if (r59 != null) goto L107;
        L108:
            r217 = "guess_you_like";
            goto L109
        L98:
            r215 = r55;
            goto L99
        L94:
            r214 = r49;
            goto L95
        L83:
            if (r121.length() <= 0) goto L85;
            boolean r123 = true;
        L86:
            if (r123 == true) goto L89;
            r121 = null;
        L89:
            if (r121 != null) goto L91;
        L85:
            r123 = false;
            goto L86
        L40:
            if (this.a.s == false) goto L42;
            r20 = "102";
            goto L43
        L42:
            r20 = "store_feed";
            goto L43
        L35:
            r19 = null;
            goto L37
        L30:
            if (r58.O.getType() > ProductCardType.CROSS_SHOP_GOTO_DETAIL.getType()) goto L32;
            r20 = "cross_recommend_product";
            goto L43
        L22:
            Map r72 = r58.o;
            if (r72 == null) goto L26;
            r17 = (String) r72.get("ecom_entrance_from");
            if (r17 != null) goto L27;
        L26:
            r17 = "guess_you_like";
            goto L27
        L16:
            if (Intrinsics.areEqual(this.a.o0().getStoreParam().getPageName(), "classification_secondary_page") == true) goto L19;
            r8.getProductBasicRequestParam().isCustom();
            goto L19
        }

        public final void h(StoreV2ProductItemVO r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r2, "item");
        }

        public a(ECShopGuessLikeCardGroupPresenter r1, Fragment r2) {
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

    public final ECShopHybridProductViewModel o0() {
        return (ECShopHybridProductViewModel) this.o.getValue();
    }

    public final sm.g h0() {
        return this.q;
    }

    public final sm.h i0() {
        return this.p;
    }

    public final String l0(StoreV2ProductItemVO r3) {
        return "a1.b6269.c2429.d54148_i" + (r3.w + 1);
    }

    public final String m0(StoreV2ProductItemVO r10) {
        com.bytedance.android.ec.store.repository.dto.i r11 = r10.J;
        if (r11 == null) goto L8;
        List r12 = r11.b();
        if (r12 == null) goto L8;
        String r13 = CollectionsKt.joinToString$default(r12, ",", null, null, 0, null, ECShopGuessLikeCardGroupPresenter$getSKUIds$1.INSTANCE, 30, null);
        if (r13 == null) goto L8;
        return r13;
    L8:
        return "";
    }

    public final String n0(StoreV2ProductItemVO r8) {
        MarketingDataDTO r9 = r8.D;
        Boolean r0 = null;
        if (r9 == null) goto L5;
        String r10 = r9.getTransMeta();
    L7:
        if (com.bytedance.android.shopping.extensions.k.c(r10) == false) goto L10;
        return "return_coin";
    L10:
        List<com.bytedance.android.ec.store.repository.dto.g> r11 = o0().getPickTypes();
        if (r11 == null) goto L25;
        Iterator<T> r12 = r11.iterator();
    L14:
        if (r12.hasNext() == false) goto L21;
        Object r3 = r12.next();
        if (((com.bytedance.android.ec.store.repository.dto.g) r3).a() != 1) goto L18;
        boolean r4 = true;
    L19:
        if (r4 == false) goto L14;
    L22:
        com.bytedance.android.ec.store.repository.dto.g r5 = (com.bytedance.android.ec.store.repository.dto.g) r3;
        if (r5 == null) goto L25;
        Boolean r13 = Boolean.valueOf(r5.b());
    L26:
        List<com.bytedance.android.ec.store.repository.dto.g> r6 = o0().getPickTypes();
        if (r6 == null) goto L41;
        Iterator<T> r7 = r6.iterator();
    L30:
        if (r7.hasNext() == false) goto L37;
        Object r14 = r7.next();
        if (((com.bytedance.android.ec.store.repository.dto.g) r14).a() != 2) goto L34;
        boolean r15 = true;
    L35:
        if (r15 == false) goto L30;
    L38:
        com.bytedance.android.ec.store.repository.dto.g r16 = (com.bytedance.android.ec.store.repository.dto.g) r14;
        if (r16 == null) goto L41;
        r0 = Boolean.valueOf(r16.b());
        goto L41
    L34:
        r15 = false;
        goto L35
    L37:
        r14 = null;
    L41:
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r13, r1) == false) goto L45;
        return "live_product";
    L45:
        if (Intrinsics.areEqual(r0, r1) == false) goto L47;
        return "living_product";
    L47:
        return CommentServiceId.HOT_SPOT;
    L18:
        r4 = false;
        goto L19
    L21:
        r3 = null;
    L25:
        r13 = null;
        goto L26
    L5:
        r10 = null;
        goto L7
    }

    public ECShopGuessLikeCardGroupPresenter(Fragment r2, ECStoreViewModel r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.r = r3;
        this.s = r4;
        this.o = LazyKt.lazy(new ECShopGuessLikeCardGroupPresenter$viewModel$2(this));
        this.p = new ECShopGuessLikeCardGroupPresenter$adapter$1(this);
        this.q = new a(this, r2);
    }

    public static final Map k0(ECShopGuessLikeCardGroupPresenter r58, String r59, StoreV2ProductItemVO r60) {
        String r3 = r58.o0().getEcomEntranceFrom();
        int r4 = r59.hashCode();
        String r8 = "0";
        if (r4 == 1132134829) goto L38;
        if (r4 != 2022256952) goto L68;
        if (r59.equals("click_product") == false) goto L68;
        Map r1 = com.bytedance.android.ec.store.product.presenter.utils.a.d(r60);
        ECStoreParam r5 = r58.Y().g(ECShopHybridProductViewModel.class).getStoreParam();
        Pair[] r10 = new Pair[26];
        if (Intrinsics.areEqual(r58.o0().getStoreParam().getPageName(), "classification_secondary_page") == false) goto L12;
        String r2 = "_" + r60.v;
    L13:
        r10[0] = TuplesKt.to("tab_label", r2);
        r10[1] = TuplesKt.to("category_id", null);
        r10[2] = TuplesKt.to("tab_type", null);
        r10[3] = TuplesKt.to("page_version", null);
        r10[4] = TuplesKt.to("ecom_entrance_form", r3);
        r10[5] = TuplesKt.to("brand_verified", "0");
        r10[6] = TuplesKt.to("search_params", r58.o0().getStoreParam().getSearchParams());
        r10[7] = TuplesKt.to("pre_product_id", r5.getPreProductId());
        r10[8] = TuplesKt.to("pre_room_id", r5.getPreRoomId());
        r10[9] = TuplesKt.to("pre_group_id", r5.getPreGroupId());
        r10[10] = TuplesKt.to("content_source", "shop");
        LayoutTypes r0 = (LayoutTypes) r58.o0().getLayoutType().getValue();
        if (r0 != null) goto L17;
    L18:
        Object r6 = "double_product";
    L20:
        r10[11] = TuplesKt.to("product_form", r6);
        r10[12] = TuplesKt.to("sku_ids", r58.m0(r60));
        if (com.bytedance.android.shopping.extensions.k.c(r60.e) == false) goto L23;
        Object r7 = "102";
    L24:
        r10[13] = TuplesKt.to("title_type", r7);
        r10[14] = TuplesKt.to("pay_price", String.valueOf(r60.j));
        r10[15] = TuplesKt.to("tab_name", r3);
        r10[16] = TuplesKt.to("tab_name_second", r58.n0(r60));
        if (r58.o0().hasDiscountSelected() == false) goto L27;
        Object r9 = CommentScene.COMMENTSCENE_NO_AWEME;
    L28:
        r10[17] = TuplesKt.to("is_discount_selected", r9);
        if (r58.o0().getStoreParam().isEcShare() == false) goto L31;
        Pair r11 = TuplesKt.to("share_content", r58.o0().getStoreParam().getShareContent());
        Object r12 = "";
    L32:
        r10[18] = r11;
        if (r58.o0().getStoreParam().isEcShare() == false) goto L35;
        Pair r13 = TuplesKt.to("share_object", r58.o0().getStoreParam().getShareObject());
    L36:
        r10[19] = r13;
        r10[20] = TuplesKt.to("btm_index", String.valueOf(r60.v + 1));
        r10[21] = TuplesKt.to("bst_group_type", "product");
        r10[22] = TuplesKt.to("product_view_num", String.valueOf(r58.o0().getProductViewsNum().getValue()));
        r10[23] = TuplesKt.to("product_total_num", String.valueOf(r58.o0().getTotalProductNum().getValue()));
        r10[24] = TuplesKt.to("product_click_index", String.valueOf(r60.w));
        r10[25] = TuplesKt.to("bst_tag", "bst_tag");
        Map r14 = r1;
        r14.putAll(MapsKt.mapOf(r10));
        r14.putAll(com.bytedance.android.shopping.store.utils.g.b(BtmSDK.INSTANCE.createReportParams(r58.l0(r60), PageFinder.via(((QFragmentPresenter) r58).e))));
    L69:
        return r14;
    L35:
        r13 = TuplesKt.to(r12, r12);
        goto L36
    L31:
        r12 = "";
        r11 = TuplesKt.to(r12, r12);
        goto L32
    L27:
        r9 = "0";
        goto L28
    L23:
        r7 = CommentServiceId.HOT_SPOT;
        goto L24
    L17:
        if (c.b[r0.ordinal()] != 1) goto L18;
        r6 = "single_product";
        goto L20
    L12:
        r2 = "";
    L68:
        return null;
    L38:
        if (r59.equals("show_product") == false) goto L68;
        Map r15 = com.bytedance.android.ec.store.product.presenter.utils.a.d(r60);
        Pair[] r16 = new Pair[23];
        if (Intrinsics.areEqual(r58.o0().getStoreParam().getPageName(), "classification_secondary_page") == false) goto L42;
        String r17 = "_" + r60.v;
    L43:
        r16[0] = TuplesKt.to("tab_label", r17);
        r16[1] = TuplesKt.to("category_id", null);
        r16[2] = TuplesKt.to("tab_type", null);
        r16[3] = TuplesKt.to("page_version", null);
        r16[4] = TuplesKt.to("ecom_entrance_form", r3);
        r16[5] = TuplesKt.to("pre_product_id", r58.o0().getStoreParam().getPreProductId());
        r16[6] = TuplesKt.to("pre_room_id", r58.o0().getStoreParam().getPreRoomId());
        r16[7] = TuplesKt.to("pre_group_id", r58.o0().getStoreParam().getPreGroupId());
        r16[8] = TuplesKt.to("brand_verified", "0");
        r16[9] = TuplesKt.to("search_params", r58.o0().getStoreParam().getSearchParams());
        r16[10] = TuplesKt.to("content_source", "shop");
        LayoutTypes r18 = (LayoutTypes) r58.o0().getLayoutType().getValue();
        if (r18 != null) goto L46;
        int r19 = 1;
    L48:
        Object r20 = "double_product";
    L50:
        r16[11] = TuplesKt.to("product_form", r20);
        r16[12] = TuplesKt.to("sku_ids", r58.m0(r60));
        r16[13] = TuplesKt.to("btm_index", String.valueOf(r60.v + r19));
        if (com.bytedance.android.shopping.extensions.k.c(r60.e) == false) goto L53;
        Object r21 = "102";
    L54:
        r16[14] = TuplesKt.to("title_type", r21);
        r16[15] = TuplesKt.to("pay_price", String.valueOf(r60.j));
        r16[16] = TuplesKt.to("tab_name", r3);
        r16[17] = TuplesKt.to("tab_name_second", r58.n0(r60));
        if (r58.o0().hasDiscountSelected() == false) goto L57;
        r8 = CommentScene.COMMENTSCENE_NO_AWEME;
    L57:
        r16[18] = TuplesKt.to("is_discount_selected", r8);
        if (r58.o0().getStoreParam().isEcShare() == false) goto L60;
        Pair r22 = TuplesKt.to("share_content", r58.o0().getStoreParam().getShareContent());
        Object r23 = "";
    L61:
        r16[19] = r22;
        if (r58.o0().getStoreParam().isEcShare() == false) goto L64;
        Pair r24 = TuplesKt.to("share_object", r58.o0().getStoreParam().getShareObject());
    L65:
        r16[20] = r24;
        r16[21] = TuplesKt.to("bst_group_type", "product");
        r16[22] = TuplesKt.to("bst_tag", "bst_tag");
        r14 = r15;
        r14.putAll(MapsKt.mapOf(r16));
        r14.putAll(com.bytedance.android.shopping.store.utils.g.b(BtmSDK.INSTANCE.createReportParams(r58.l0(r60), PageFinder.via(((QFragmentPresenter) r58).e))));
        goto L69
    L64:
        r24 = TuplesKt.to(r23, r23);
        goto L65
    L60:
        r23 = "";
        r22 = TuplesKt.to(r23, r23);
        goto L61
    L53:
        r21 = CommentServiceId.HOT_SPOT;
        goto L54
    L46:
        r19 = 1;
        if (c.c[r18.ordinal()] != 1) goto L48;
        r20 = "single_product";
        goto L50
    L42:
        r17 = "";
        goto L43
    }
}
