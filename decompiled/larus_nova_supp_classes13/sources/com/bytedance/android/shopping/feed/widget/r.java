package com.bytedance.android.shopping.feed.widget;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService;
import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.g2;
import com.bytedance.android.ec.core.utils.j1;
import com.bytedance.android.ec.core.utils.o0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductAuthorEntriesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductShopEntryStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.model.response.anchorv3.ShopBindAuthorDTO;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3PromotionRequestParam;
import com.bytedance.android.shopping.api.model.ECAnchorV3ExtraData;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class r extends com.bytedance.android.ec.core.widget.d {
    public final /* synthetic */ ProductFeedAbilityBarView g;
    public final /* synthetic */ AnchorV3Param h;

    public final void a(View r32) {
        Intrinsics.checkNotNullParameter(r32, "v");
        rd3.a r2 = this.g.e;
        if (r2 != null) goto L5;
    L7:
        String r3 = "c4701.d801643";
    L8:
        String r5 = r3;
        BtmItemBuilder r0 = new BtmItemBuilder(r5, Boolean.FALSE).withView(r32);
        BtmSDK r4 = BtmSDK.INSTANCE;
        String r6 = BtmSDK.createJumpSourceBtmToken$default(r4, r5, PageFinder.via(this.g.getShopAbilityView()), null, 4, null);
        rd3.a r7 = this.g.e;
        if (r7 == null) goto L265;
        ProductFeedViewModel r8 = r7.c;
        if (r8 == null) goto L266;
        int r9 = com.bytedance.android.shopping.feed.utils.u.a;
        AnchorV3Param r10 = this.h;
        int r11 = com.bytedance.android.shopping.feed.utils.b.a;
        Promotion r12 = r7.f();
        if (r12 == null) goto L15;
        PromotionProductStruct r13 = r12.getPromotionInfo();
    L16:
        ProductFeedViewModel r14 = r7.c;
        if (r14 == null) goto L19;
        AnchorV3Param r15 = r14.m907getAnchorV3Param();
    L20:
        if (r13 == null) goto L22;
        d63.t r16 = d63.r.b(r13);
    L23:
        String r17 = "inflow_product_card_mode";
        String r18 = "module_label";
        String r1 = "ecom_group_type";
        if (r16 == null) goto L73;
        g2 r19 = new g2(r16.b);
        if (r15 == null) goto L28;
        String r20 = r15.getEntranceInfo();
    L29:
        JSONObject r21 = z1.g(r20);
        if (r21 == null) goto L32;
        String r22 = r21.optString("ecom_group_type", "");
    L33:
        if (r15 == null) goto L37;
        AnchorV3PromotionRequestParam r23 = r15.getRequestParam();
        if (r23 == null) goto L37;
        String r24 = r23.getSourcePage();
    L38:
        if (r15 == null) goto L40;
        String r25 = r15.getEComEntranceFrom();
    L41:
        r19.a("store_source_method", r25);
        if (r7.e != true) goto L44;
        r19.a("module_label", "guess_you_like_product");
        String r26 = "guess_you_like_product";
    L45:
        if (r6 == null) goto L47;
        r19.a("source_btm_token", r6);
    L47:
        r19.a("store_source_page", r24);
        r19.a("store_group_type", r26);
        if (r15 == null) goto L50;
        String r27 = r15.getProductId();
    L51:
        r19.a("pre_product_id", r27);
        r19.a("inflow_product_card_mode", r7.m);
        if (r15 == null) goto L56;
        AnchorV3PromotionRequestParam r28 = r15.getRequestParam();
        if (r28 == null) goto L56;
        String r29 = r28.getRoomId();
    L57:
        r19.a("pre_room_id", r29);
        if (r15 == null) goto L60;
        String r30 = r15.getVideoId();
    L61:
        r19.a("pre_group_id", r30);
        if (r21 == null) goto L64;
        String r31 = r21.optString("ecom_scene_id");
    L65:
        if (r31 != null) goto L67;
    L69:
        com.bytedance.commerce.base.json.a[] r33 = new com.bytedance.commerce.base.json.a[1];
        if (r31 != null) goto L72;
        r31 = "";
    L72:
        r33[0] = JsonDslUtilKt.d("ecom_scene_id", r31);
        r19.a("pass_through_api", JsonDslUtilKt.a(r33).toString());
        String r34 = r19.b();
    L74:
        boolean r35 = r8.isExpanded();
        String r36 = r21;
        HashMap<String, String> r37 = this.g.f;
        if (r10 == null) goto L269;
        if (r34 != null) goto L79;
        return;
    L79:
        if (a2.d(r34) == null) goto L270;
        String r38 = r10.getEntranceInfo();
        if (r38 == null) goto L84;
        JSONObject r39 = com.bytedance.android.shopping.extensions.k.w(r38);
    L85:
        o0 r40 = new o0(r34);
        ECAnchorV3ExtraData r41 = r10.getAnchorV3ExtraData();
        String r110 = "carrier_source";
        if (r41 != null) goto L88;
    L94:
        String r42 = r7;
        if (r39 == null) goto L97;
        String r43 = r39.optString("module_label");
    L98:
        if (r39 == null) goto L100;
        String r44 = r39.optString(r1);
    L101:
        String r45 = r40.e("entrance_location");
        if (r45 != null) goto L104;
        r45 = "product_detail_tab";
    L104:
        if (r39 == null) goto L106;
        String r46 = r39.optString("carrier_source");
    L107:
        if (r39 == null) goto L109;
        String r47 = r39.optString("source_method");
        Object r48 = null;
    L111:
        if (StringsKt.equals$default(r43, "guess_you_like_product", false, 2, r48) == true) goto L114;
        r43 = r44;
    L114:
        r40.b("store_source_page", r46);
        r40.b(r42, r47);
        r40.b("store_group_type", r43);
        r40.b("pre_product_id", r10.getProductId());
        r40.b("pre_room_id", r10.getRequestParam().getRoomId());
        r40.b("pre_group_id", r10.getVideoId());
        int r49 = ECSdk.a;
        IECUserTrackerService r50 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r50 == null) goto L119;
        of.a r51 = r50.getMarketingService();
        if (r51 == null) goto L119;
        r51.a("product_detail_click_enter_shop", PostActionType.DO, "product_detail");
    L119:
        String r52 = r46;
        String r53 = r47;
        String r54 = r45;
        String r55 = r43;
    L120:
        r40.a("entrance_location", r54);
        if (r35 == false) goto L123;
        String r56 = "full_screen";
    L124:
        r40.b("page_type", r56);
        r40.b(SimilarProductParam.ENTER_FROM, r54);
        PromotionProductBaseStruct r57 = r10.getCurrentPromotion().getBaseInfo();
        if (r57 == null) goto L127;
        String r58 = r57.getProductId();
    L128:
        r40.b("source_product_id", r58);
        if (r39 == null) goto L131;
        String r59 = r18;
        String r111 = r39.optString(r59);
    L132:
        r40.b(r59, r111);
        if (r39 == null) goto L135;
        String r60 = r39.optString(r110);
    L137:
        if (Intrinsics.areEqual(r60, "store_page") == false) goto L139;
        r40.a("pre_product_id", r39.optString("pre_product_id"));
        r40.a("pre_room_id", r39.optString("pre_room_id"));
        r40.a("pre_group_id", r39.optString("pre_group_id"));
    L139:
        if (r0 == null) goto L141;
        String r112 = r4.createBtmId(r0.copy().setEnterPage(true).build());
    L143:
        if (Intrinsics.areEqual(r40.e("pre_group_id"), "0") == false) goto L145;
        r40.a("pre_group_id", null);
    L145:
        String r113 = r40.c();
        if (r39 != null) goto L262;
    L153:
        String r114 = r54;
        r113 = r113;
    L168:
        String r115 = r113;
    L169:
        Activity r61 = ECAppInfoService.e.getCurrentActivity();
        if (r61 == null) goto L268;
        com.bytedance.android.ec.sdk.helper.p.a.d(r115, r61);
        int r62 = com.bytedance.android.ec.core.monitor.e.a;
        PromotionProductAuthorEntriesStruct r63 = r10.getCurrentPromotion().getEntryInfo();
        if (r63 == null) goto L174;
        PromotionProductShopEntryStruct r64 = r63.getShopEntry();
    L176:
        if (r64 == null) goto L178;
        String r65 = "enter_shop";
    L179:
        String r116 = r10.getSourceMethod();
        Intrinsics.checkNotNullParameter(r65, "scene");
        if (r115 != null) goto L182;
    L185:
        boolean r117 = true;
    L186:
        if (r117 == false) goto L188;
        Activity r118 = r61;
        o0 r210 = r40;
    L218:
        int r66 = com.bytedance.android.ec.core.anchorv3.a.a;
        Pair[] r67 = new Pair[7];
        if (r37 == 0) goto L221;
        HashMap<String, String> r68 = r37;
        String r69 = r68.get("request_id");
    L222:
        r67[0] = TuplesKt.to("request_id", r69);
        if (r68 == null) goto L225;
        String r70 = r68.get(PdpOpenThirdParam.KEY_PRODUCT_ID);
    L226:
        r67[1] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r70);
        r67[2] = TuplesKt.to("store_source_page", r52);
        r67[3] = TuplesKt.to(r42, r53);
        r67[4] = TuplesKt.to("store_group_type", r55);
        r67[5] = TuplesKt.to("btm_id", r112);
        String r71 = r17;
        r67[6] = TuplesKt.to(r71, r210.e(r71));
        Map r72 = MapsKt.mapOf(r67);
        String r73 = r114;
        Intrinsics.checkNotNullParameter(r73, "entranceLocation");
        Intrinsics.checkNotNullParameter(r72, "extra_log");
        int r74 = a63.a.a;
        int r75 = com.bytedance.android.ec.core.opt.ab.c.a;
        jd3.g r76 = new jd3.g();
        PromotionProductExtraStruct r77 = r10.getCurrentPromotion().getExtraInfo();
        if (r77 == null) goto L229;
        String r78 = r77.getShopId();
    L230:
        if (r78 != null) goto L232;
        r78 = r36;
    L232:
        r76.b = r78;
        r76.c = r73;
        PromotionProductAuthorEntriesStruct r79 = r10.getCurrentPromotion().getEntryInfo();
        if (r79 != null) goto L235;
    L237:
        String r80 = "shop";
    L238:
        r76.a = r80;
        PromotionProductAuthorEntriesStruct r81 = r10.getCurrentPromotion().getEntryInfo();
        if (r81 == null) goto L249;
        PromotionProductShopEntryStruct r82 = r81.getShopEntry();
        if (r82 == null) goto L246;
        String r84 = r82.getShopAuthorId();
        if (r84 == null) goto L246;
        String r85 = r84;
    L250:
        if (r85 != null) goto L252;
        r85 = r36;
    L252:
        r76.d = r85;
        Iterator r86 = r72.entrySet().iterator();
    L254:
        if (r86.hasNext() == false) goto L256;
        Map.Entry r87 = (Map.Entry) r86.next();
        String r88 = (String) r87.getKey();
        String r89 = (String) r87.getValue();
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        r76.appendParam(r88, r89, com.bytedance.android.ec.core.event.a.b.a.a);
        goto L254
    L256:
        com.bytedance.android.ec.core.anchorv3.b.a(r76, r118, null);
        return;
    L246:
        ShopBindAuthorDTO r90 = r81.getShopBindAuthor();
        if (r90 == null) goto L249;
        r85 = r90.getAuthorId();
    L249:
        r85 = null;
        goto L250
    L235:
        if (r79.getShopEntry() == null) goto L237;
        r80 = "window";
        goto L238
    L229:
        r78 = null;
        goto L230
    L225:
        r70 = null;
        goto L226
    L221:
        r68 = r37;
        r69 = null;
        goto L222
    L188:
        Uri r119 = UriProtector.parse(r115);
        String r120 = UriProtector.getQueryParameter(r119, "entrance_location");
        r118 = r61;
        JSONObject r91 = new JSONObject();
        r210 = r40;
        if (r116 != null) goto L191;
        r116 = r36;
    L191:
        r91.put("enter_method", r116);
        r91.put("entrance_location", r120);
        int r92 = r65.hashCode();
        if (r92 == (-818408451)) goto L208;
        if (r92 != 399499450) goto L218;
        if (r65.equals("enter_store") == false) goto L218;
        String r94 = UriProtector.getQueryParameter(r119, "sec_shop_id");
        if (r94 != null) goto L201;
    L204:
        boolean r95 = true;
    L205:
        if (r95 == false) goto L218;
        com.bytedance.android.ec.core.monitor.d.d("sec_shop_id", "presence", null, r65, r91);
        goto L218
    L201:
        if (r94.length() == 0) goto L204;
        r95 = false;
        goto L205
    L208:
        if (r65.equals("enter_shop") == false) goto L218;
        String r96 = UriProtector.getQueryParameter(r119, "uid");
        if (r96 != null) goto L212;
    L215:
        boolean r97 = true;
    L216:
        if (r97 == false) goto L218;
        com.bytedance.android.ec.core.monitor.d.d("uid", "presence", null, r65, r91);
        goto L218
    L212:
        if (r96.length() == 0) goto L215;
        r97 = false;
        goto L216
    L182:
        if (r115.length() == 0) goto L185;
        r117 = false;
        goto L186
    L178:
        r65 = "enter_store";
        goto L179
    L174:
        r64 = null;
        goto L176
    L268:
        return;
    L262:
        String r121 = r39.optString("cid");     // Catch: Exception -> L165
        if (r121.length() != 0) goto L151;
        boolean r122 = true;
    L152:
        if (r122 == true) goto L153;
        r114 = r54;
        int r98 = r39.optInt("ad_type", 0);     // Catch: Exception -> L163
        Uri r99 = UriProtector.parse(r113);     // Catch: Exception -> L163
        JSONObject r123 = com.bytedance.android.shopping.extensions.k.w(UriProtector.getQueryParameter(r99, "entrance_info"));     // Catch: Exception -> L163
        if (r123 != null) goto L158;
        r123 = new JSONObject();     // Catch: Exception -> L163
    L158:
        JSONObject r124 = r123;
        r124.put("cid", r121);     // Catch: Exception -> L161
        r124.put("ad_type", r98);     // Catch: Exception -> L161
        r115 = j1.d(r99, "entrance_info").buildUpon().appendQueryParameter("entrance_info", r124.toString()).build().toString();     // Catch: Exception -> L161
    L161:
        e = e;
    L167:
        ye.a.b(e);
    L163:
        e = e;
        goto L167
    L151:
        r122 = false;
    L165:
        e = e;
        r114 = r54;
        goto L167
    L141:
        r112 = r36;
        goto L143
    L135:
        r60 = null;
        goto L137
    L131:
        r59 = r18;
        r111 = null;
        goto L132
    L127:
        r58 = null;
        goto L128
    L123:
        r56 = "half_screen";
        goto L124
    L109:
        r48 = null;
        r47 = null;
        goto L111
    L106:
        r46 = null;
        goto L107
    L100:
        r44 = null;
        goto L101
    L97:
        r43 = null;
        goto L98
    L88:
        if (r41.getShowInternalFeedProduct() != true) goto L94;
        if (StringsKt.equals$default(r40.e("module_label"), "guess_you_like_product", false, 2, null) == false) goto L92;
        String r100 = "product_flow_page_102";
    L93:
        String r101 = r40.e("store_source_page");
        r42 = "store_source_method";
        r53 = r40.e(r42);
        r55 = r40.e("store_group_type");
        String r211 = r100;
        r40.b("inflow_product_card_mode", r40.e("inflow_product_card_mode"));
        r18 = "module_label";
        r110 = "carrier_source";
        r17 = "inflow_product_card_mode";
        r52 = r101;
        r54 = r211;
        goto L120
    L92:
        r100 = "product_flow_page_101";
        goto L93
    L84:
        r39 = null;
        goto L85
    L270:
        return;
    L269:
        return;
    L67:
        if (StringsKt.indexOf$default(r31, "1002", 0, false, 6, null) != (-1)) goto L69;
        r31 = r31.concat(",1002");
        goto L69
    L64:
        r31 = null;
        goto L65
    L60:
        r30 = null;
    L56:
        r29 = null;
        goto L57
    L50:
        r27 = null;
        goto L51
    L44:
        r26 = r22;
        goto L45
    L40:
        r25 = null;
    L37:
        r24 = null;
        goto L38
    L32:
        r22 = null;
        goto L33
    L28:
        r20 = null;
        goto L29
    L73:
        r1 = "ecom_group_type";
        String r102 = "";
        r34 = r102;
        goto L74
    L22:
        r16 = null;
        goto L23
    L19:
        r15 = null;
        goto L20
    L15:
        r13 = null;
        goto L16
    L266:
        return;
    L265:
        return;
    L5:
        if (r2.e != true) goto L7;
        r3 = "c3865.d1098";
        goto L8
    }

    public r(ProductFeedAbilityBarView r2, AnchorV3Param r3) {
        this.g = r2;
        this.h = r3;
        super(null, "bind_product_flow_card", 1);
    }
}
