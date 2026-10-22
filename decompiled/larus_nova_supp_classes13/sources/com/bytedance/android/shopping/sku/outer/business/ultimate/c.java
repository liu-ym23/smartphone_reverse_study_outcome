package com.bytedance.android.shopping.sku.outer.business.ultimate;

import android.text.TextUtils;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayUtils;
import com.bytedance.android.ec.common.api.entranceinfo.IEntranceInfoService;
import com.bytedance.android.ec.core.hybrid.utils.j;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.ECAdInfo;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.ECBoltParam;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.ec.model.sku.SkuExtraData;
import com.bytedance.android.ec.model.sku.SkuOrderParams;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.android.shopping.api.ultimate.UltimateBuyOrderExParams;
import com.bytedance.android.shopping.buynow.data.model.PageType;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.utils.p;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import ul.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public static Map a(SkuParams r41, boolean r42) {
        Intrinsics.checkNotNullParameter(r41, "skuParams");
        String r2 = r41.getH5Url();
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        String r18 = r2;
        if (r41.isLiveSkuCheck() == false) goto L130;
        b r4 = new b(r41);
        Map r0 = r4.a.getEventParams();
        JSONObject r12 = new JSONObject();
        r12.put("biometric_params", "1");
        TTCJPayUtils.Companion r8 = TTCJPayUtils.Companion;
        r12.put("is_jailbreak", r8.getInstance().getJailBreak());
        r12.put("cj_sdk", r8.getInstance().getSDKVersion());
        r12.put("bio_type", r8.getInstance().getBioType());
        int r7 = p.a;
        r12.put("installed_union_pay_app", false);
        com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b r6 = com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b.a;
        com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b.b();
        r12.put("cj_pass_through_info", "");
        if (r42 == false) goto L10;
        MapsKt.mapOf(TuplesKt.to("buy_now_page_type", PageType.ULTIMATEBUYNOW));
        p.a();
        r12.put("finance_risk", null);
    L11:
        String r1 = r12.toString();
        LinkedHashMap r3 = new LinkedHashMap();
        Map<String, String> r5 = MapsKt.toMutableMap(r4.a.getLiveEventParams());
        String r9 = (String) r0.get("screen_type");
        if (r9 != null) goto L14;
        r9 = "";
    L14:
        r5.put("screen_type", r9);
        String r10 = (String) r0.get("is_groupbuying");
        if (r10 != null) goto L17;
        r10 = "";
    L17:
        r5.put("is_groupbuying", r10);
        String r11 = (String) r0.get("is_explain_apply");
        if (r11 != null) goto L20;
        r11 = "0";
    L20:
        r5.put("is_explain_apply", r11);
        String r13 = (String) r0.get("base_verified_category");
        if (r13 != null) goto L23;
        r13 = "";
    L23:
        r5.put("base_verified_category", r13);
        String r14 = (String) r0.get("upfront_presell");
        if (r14 != null) goto L26;
        r14 = "";
    L26:
        r5.put("upfront_presell", r14);
        String r15 = (String) r0.get("is_crossborder_goods");
        if (r15 != null) goto L29;
        r15 = "";
    L29:
        r5.put("is_crossborder_goods", r15);
        String r16 = (String) r0.get("label_name");
        if (r16 != null) goto L32;
        r16 = "";
    L32:
        r5.put("label_name", r16);
        String r17 = (String) r0.get("label_name_live");
        if (r17 != null) goto L35;
        r17 = "";
    L35:
        r5.put("label_name_live", r17);
        String r19 = (String) r0.get("tab_name");
        if (r19 != null) goto L38;
        r19 = "";
    L38:
        r5.put("tab_name", r19);
        String r110 = (String) r0.get("with_sku");
        if (r110 != null) goto L41;
        r110 = "";
    L41:
        r5.put("with_sku", r110);
        String r111 = (String) r0.get("is_explaining");
        if (r111 != null) goto L44;
        r111 = "";
    L44:
        r5.put("is_explaining", r111);
        r5.put("page_init_timestamp", String.valueOf(System.currentTimeMillis()));
        r5.put(SimilarProductParam.ENTER_FROM, "live");
        String r112 = (String) r0.get("new_source_type");
        if (r112 != null) goto L47;
        String r20 = "";
    L48:
        r5.put("new_source_type", r20);
        if (r4.a.isFromPlayback() == false) goto L51;
        String r113 = "1";
        r5.put("product_detail_reply", r113);
    L52:
        String r114 = (String) r0.get("card_status");
        String r37 = r113;
        if (r114 != null) goto L55;
        String r115 = "";
    L56:
        r5.put("card_status", r115);
        r4.a(r5);
        String r116 = r4.a.getSkuLogExtra();
        if (r116 == null) goto L68;
        if (r116.length() <= 0) goto L61;
        boolean r117 = true;
    L62:
        if (r117 == true) goto L65;
        r116 = null;
    L65:
        if (r116 == null) goto L68;
        JSONObject r21 = new JSONObject(r116);
        r5.put("fxh_white_list_flag", r21.optString("fxh_white_list_flag"));
        r5.put("user_open_fxh_flag", r21.optString("user_open_fxh_flag"));
        r5.put("bind_card_flag", r21.optString("bind_card_flag"));
        r5.put("shop_open_fxh_flag", r21.optString("shop_open_fxh_flag"));
        goto L68
    L61:
        r117 = false;
    L68:
        String r22 = new JSONObject(r5).toString();
        LinkedHashMap r23 = new LinkedHashMap();
        String r24 = (String) r0.get("is_groupbuying");
        if (r24 != null) goto L71;
        r24 = "";
    L71:
        r23.put("is_groupbuying", r24);
        String r25 = (String) r4.a.getEventParams().get("is_explain_apply");
        if (r25 != null) goto L74;
        String r118 = "0";
    L75:
        r23.put("is_explain_apply", r118);
        String r26 = (String) r0.get("label_name");
        if (r26 != null) goto L78;
        r26 = "";
    L78:
        r23.put("label_name", r26);
        String r27 = (String) r0.get("label_name_live");
        if (r27 != null) goto L81;
        r27 = "";
    L81:
        r23.put("label_name_live", r27);
        r23.put(SimilarProductParam.ENTER_FROM, "live");
        String r28 = (String) r0.get("ecom_group_type");
        if (r28 != null) goto L84;
        r28 = "";
    L84:
        r23.put("ecom_group_type", r28);
        String r29 = (String) r0.get("upfront_presell");
        if (r29 != null) goto L87;
        r29 = "";
    L87:
        r23.put("upfront_presell", r29);
        String r30 = (String) r0.get("base_verified_category");
        if (r30 != null) goto L90;
        r30 = "";
    L90:
        r23.put("base_verified_category", r30);
        String r31 = (String) r0.get("tab_name");
        if (r31 != null) goto L93;
        r31 = "";
    L93:
        r23.put("tab_name", r31);
        String r32 = (String) r0.get(PdpOpenThirdParam.KEY_PAGE_NAME);
        if (r32 != null) goto L96;
        r32 = "";
    L96:
        r23.put(PdpOpenThirdParam.KEY_PAGE_NAME, r32);
        String r33 = (String) r0.get("is_explaining");
        if (r33 != null) goto L99;
        r33 = "";
    L99:
        r23.put("is_explaining", r33);
        String r34 = (String) r0.get("card_status");
        if (r34 != null) goto L102;
        r34 = "";
    L102:
        r23.put("card_status", r34);
        String r35 = (String) r0.get("source_3d");
        if (r35 != null) goto L105;
        r35 = "";
    L105:
        r23.put("source_3d", r35);
        String r36 = r4.a.getCommodityType();
        if (r36 != null) goto L108;
        String r38 = "";
    L109:
        r23.put("commodity_type", r38);
        r4.a(r23);
        Map r39 = EcomBcmTracker.f(null, r23);
        if (r39 == null) goto L115;
        Iterator r40 = r39.entrySet().iterator();
    L113:
        if (r40.hasNext() == false) goto L115;
        Map.Entry r43 = (Map.Entry) r40.next();
        r23.put(r43.getKey(), String.valueOf(r43.getValue()));
    L115:
        int r44 = ECSdk.a;
        IEntranceInfoService r45 = (IEntranceInfoService) ECSdk.a(IEntranceInfoService.class);
        if (r45 == null) goto L118;
        gl.a r46 = r45.initEntranceInfo(new EntranceInfoScene("sku", "ultimateBuy"), null);
    L119:
        if (r46 == null) goto L121;
        r46.putAll(r23);
    L121:
        if (r46 == null) goto L124;
        String r47 = r46.h();
        if (r47 == null) goto L124;
    L125:
        r3.put("log_data", r22);
        r3.put("entrance_info", r47);
        r3.put("cj_info", r1);
        LinkedHashMap r48 = new LinkedHashMap();
        String r49 = r4.a.getSpellGroupId();
        if (r49 == null) goto L128;
        r48.put("spell_group_id", r49);
    L128:
        r48.put("iesec_auto_coupon_opt_ab", r37);
        r48.put("page_init_timestamp", Long.valueOf(System.currentTimeMillis()));
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("cj_info", r1), TuplesKt.to("mega_object", k.x(r3)), TuplesKt.to("query_items", k.x(r48))});
    L124:
        r47 = new JSONObject(r23).toString();
        goto L125
    L118:
        r46 = null;
        goto L119
    L108:
        r38 = r36;
        goto L109
    L74:
        r118 = r25;
        goto L75
    L55:
        r115 = r114;
        goto L56
    L51:
        r113 = "1";
        goto L52
    L47:
        r20 = r112;
        goto L48
    L10:
        r12.put("finance_risk", r8.getInstance().getFinanceRisk());
        goto L11
    L130:
        if (k.c(r18) == true) goto L132;
    L134:
        a r119 = new a(r41);
        int r50 = ECSdk.a;
        IEntranceInfoService r51 = (IEntranceInfoService) ECSdk.a(IEntranceInfoService.class);
        if (r51 == null) goto L137;
        gl.a r52 = r51.initEntranceInfo(new EntranceInfoScene("sku", "orderUrl"), r119.a.getEntranceInfo());
    L139:
        if (r52 == null) goto L142;
        r52.g(new Pair[]{TuplesKt.to("auto_coupon", 1), TuplesKt.to("with_sku", "1")});
    L142:
        if (r52 == null) goto L144;
        r52.delete(new String[]{"apt_path_id"});
    L144:
        String r120 = "cid";
        if (r52 == null) goto L175;
        Pair[] r53 = new Pair[15];
        ECAdLogExtra r54 = r119.a.getAdLogExtra();
        if (r54 == null) goto L149;
        String r55 = r54.getCreativeId();
    L150:
        r53[0] = TuplesKt.to("cid", r55);
        SkuExtraData r56 = r119.a.getSkuExtraData();
        if (r56 == null) goto L153;
        String r57 = r56.getBrandVerified();
    L154:
        r53[1] = TuplesKt.to("brand_verified", r57);
        SkuExtraData r58 = r119.a.getSkuExtraData();
        if (r58 == null) goto L157;
        String r59 = r58.getLabelName();
    L158:
        r53[2] = TuplesKt.to("label_name", r59);
        SkuExtraData r60 = r119.a.getSkuExtraData();
        if (r60 == null) goto L161;
        String r61 = r60.getLabelNameLive();
    L162:
        r53[3] = TuplesKt.to("label_name_live", r61);
        SkuExtraData r62 = r119.a.getSkuExtraData();
        if (r62 == null) goto L165;
        String r63 = r62.getHasReplay();
    L166:
        r53[4] = TuplesKt.to("is_replay", r63);
        r53[5] = TuplesKt.to("label_name_live", r119.a.getEventParams().get("label_name_live"));
        SkuExtraData r64 = r119.a.getSkuExtraData();
        if (r64 == null) goto L169;
        String r65 = r64.getProductTypeVerified();
    L170:
        r53[6] = TuplesKt.to("base_verified_category", r65);
        r53[7] = TuplesKt.to("card_status", r119.a.getEventParams().get("card_status"));
        SkuExtraData r66 = r119.a.getSkuExtraData();
        if (r66 == null) goto L173;
        String r67 = r66.getWithVideo();
    L174:
        r53[8] = TuplesKt.to("is_with_video", r67);
        r53[9] = TuplesKt.to("is_package_sale", r119.a.getEventParams().get("is_package_sale"));
        r53[10] = TuplesKt.to("new_source_type", r119.a.getEventParams().get("new_source_type"));
        r53[11] = TuplesKt.to("source_3d", r119.a.getEventParams().get("source_3d"));
        r53[12] = TuplesKt.to("commodity_id", r119.a.getPromotionId());
        r53[13] = TuplesKt.to("commodity_type", r119.a.getCommodityType());
        r53[14] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r119.a.getProductId());
        r52.j(r53, AheadBuyOrderParamsForAnchor$getExEntranceInfos$1.INSTANCE);
    L176:
        HashMap r68 = j.a;
        JSONObject r69 = j.i(r119.a.getTransmissibleJson());
        if (r69 == null) goto L181;
        Map r70 = z1.j(r69);
        if (r52 == null) goto L181;
        r52.putAll(r70);
    L181:
        ECAdInfo r71 = r119.a.getLatestRecommendFeedAdInfo();
        if (r71 == null) goto L185;
        if (r52 == null) goto L185;
        r52.g(new Pair[]{TuplesKt.to("creative_id", r71.getCid()), TuplesKt.to("log_extra", r71.getLogExtra())});
    L185:
        if (r52 == null) goto L187;
        String r72 = r52.h();
    L188:
        JSONObject r73 = z1.f(r72);
        JSONObject r74 = EcomBcmTracker.c(null, r73);
        if (r74 != null) goto L191;
        r74 = r73;
    L191:
        JSONObject r75 = new JSONObject();
        String r76 = r119.a.getAnchorBuyNowLogData();
        if (r76 == null) goto L197;
        JSONObject r77 = com.bytedance.android.ec.hybrid.list.util.k.b(r76);
        Iterator<String> r78 = r77.keys();
    L195:
        if (r78.hasNext() == false) goto L197;
        String r121 = r78.next();
        r75.put(r121, r77.optString(r121));
    L197:
        Map r79 = r119.a.getEventParams();
        String r80 = r119.a.getEntranceInfo();
        if (r80 == null) goto L200;
        HashMap r122 = j.a;
        JSONObject r81 = j.i(r80);
    L201:
        r75.putOpt("auto_coupon", 1);
        String r82 = r119.a.getEcomEntranceForm();
        if (r82 != null) goto L204;
        r82 = (String) r79.get("ecom_entrance_form");
    L204:
        r75.putOpt("ecom_entrance_form", r82);
        r75.putOpt("cash_rebate", r79.get("cash_rebate"));
        r75.putOpt("new_user_activity", r79.get("new_user_activity"));
        r75.putOpt("new_user_activity_id", r79.get("new_user_activity_id"));
        r75.putOpt("campaign_type", r79.get("campaign_type"));
        r75.putOpt("campaign_sub_type", r79.get("campaign_sub_type"));
        r75.putOpt("avl_discount", r79.get("avl_discount"));
        r75.putOpt("coupon_id", r79.get("coupon_id"));
        String r84 = (String) r79.get("is_explain_apply");
        if (r84 != null) goto L207;
        r84 = "0";
    L207:
        r75.putOpt("is_explain_apply", r84);
        r75.putOpt("with_sku", "1");
        if (r119.a.isGroupingBuy() == false) goto L210;
        Object r123 = "1";
    L211:
        r75.putOpt("is_groupbuying", r123);
        r75.putOpt("author_id", r119.a.getAuthorId());
        SkuExtraData r85 = r119.a.getSkuExtraData();
        if (r85 == null) goto L214;
        String r86 = r85.getProductTypeVerified();
    L215:
        r75.putOpt("base_verified_category", r86);
        SkuExtraData r87 = r119.a.getSkuExtraData();
        if (r87 == null) goto L218;
        String r88 = r87.getBrandVerified();
    L219:
        r75.putOpt("brand_verified", r88);
        SkuExtraData r89 = r119.a.getSkuExtraData();
        if (r89 == null) goto L222;
        String r90 = r89.getGoodsType();
    L223:
        r75.putOpt("goods_type", r90);
        SkuExtraData r91 = r119.a.getSkuExtraData();
        if (r91 == null) goto L226;
        String r92 = r91.getLabelName();
    L227:
        r75.putOpt("label_name", r92);
        SkuExtraData r94 = r119.a.getSkuExtraData();
        if (r94 == null) goto L231;
        String r95 = r94.getLabelNameLive();
        if (r95 == null) goto L231;
    L232:
        r75.putOpt("label_name_live", r95);
        SkuExtraData r96 = r119.a.getSkuExtraData();
        if (r96 == null) goto L235;
        String r97 = r96.isAuthenticInsure();
    L236:
        r75.putOpt("is_authentic_insure", r97);
        SkuExtraData r98 = r119.a.getSkuExtraData();
        if (r98 == null) goto L239;
        String r99 = r98.getSourcePage();
    L240:
        r75.putOpt(PdpOpenThirdParam.KEY_SOURCE_PAGE, r99);
        r75.putOpt("card_status", r79.get("card_status"));
        r75.putOpt("is_package_sale", r79.get("is_package_sale"));
        r75.putOpt(PdpOpenThirdParam.KEY_ITEM_ID, r79.get(PdpOpenThirdParam.KEY_ITEM_ID));
        if (r81 == null) goto L243;
        String r100 = r81.optString("carrier_source");
    L244:
        r75.putOpt("carrier_source", r100);
        if (r81 == null) goto L247;
        String r101 = r81.optString("source_method");
    L248:
        r75.putOpt("source_method", r101);
        if (r81 == null) goto L251;
        String r102 = r81.optString("similar_type");
    L252:
        r75.putOpt("similar_type", r102);
        if (r81 == null) goto L255;
        String r103 = r81.optString("ecom_tag_type");
    L256:
        r75.putOpt("ecom_tag_type", r103);
        if (r81 == null) goto L259;
        String r104 = r81.optString("module_label");
    L260:
        r75.putOpt("module_label", r104);
        if (StringsKt.isBlank(r75.optString("is_crossborder_goods")) == false) goto L269;
        SkuExtraData r105 = r119.a.getSkuExtraData();
        if (r105 != null) goto L265;
    L267:
        Object r124 = "0";
    L268:
        r75.putOpt("is_crossborder_goods", r124);
        goto L269
    L265:
        if (r105.isCrossborderProduct() != true) goto L267;
        r124 = "1";
    L269:
        String r106 = r119.a.getTransmissibleJson();
        if (r106 != null) goto L272;
    L286:
        SkuExtraData r107 = r119.a.getSkuExtraData();
        if (r107 == null) goto L305;
        String r108 = r107.getTransitionTrackerData();
        if (r108 == null) goto L305;
        if (r108.length() <= 0) goto L293;
        boolean r109 = true;
    L294:
        if (r109 == true) goto L297;
        r108 = null;
    L297:
        if (r108 == null) goto L305;
        JSONObject r125 = new JSONObject(r108);     // Catch: Exception -> L303
        Iterator<String> r126 = r125.keys();     // Catch: Exception -> L303
    L300:
        if (r126.hasNext() == false) goto L305;
        String r127 = r126.next();     // Catch: Exception -> L303
        r75.put(r127, r125.optString(r127));     // Catch: Exception -> L303
    L303:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L305
    L293:
        r109 = false;
    L305:
        r75.remove("coupon_type");
        LinkedHashMap r128 = new LinkedHashMap();
        LinkedHashMap r129 = new LinkedHashMap();
        JSONObject r130 = new JSONObject();
        r130.put("biometric_params", "1");
        TTCJPayUtils.Companion r131 = TTCJPayUtils.Companion;
        r130.put("is_jailbreak", r131.getInstance().getJailBreak());
        r130.put("cj_sdk", r131.getInstance().getSDKVersion());
        r130.put("bio_type", r131.getInstance().getBioType());
        int r132 = p.a;
        r130.put("installed_union_pay_app", false);
        com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b r133 = com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b.a;
        com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b.b();
        r130.put("cj_pass_through_info", "");
        if (r42 == false) goto L308;
        MapsKt.mapOf(TuplesKt.to("buy_now_page_type", PageType.ULTIMATEBUYNOW));
        p.a();
        String r134 = null;
        r130.put("finance_risk", null);
    L309:
        String r135 = r130.toString();
        SkuExtraData r136 = r119.a.getSkuExtraData();
        if (r136 == null) goto L313;
        String r137 = r136.getMarketChannel();
        if (r137 == null) goto L313;
    L314:
        r129.put("marketing_channel", r137);
        String r138 = r119.a.getSpellGroupId();
        if (r138 == null) goto L317;
        r129.put("spell_group_id", r138);
    L317:
        ECBoltParam r139 = r119.a.getBoltParam();
        if (r139 == null) goto L327;
        String r140 = r139.getActivityId();
        if (r140 == null) goto L327;
        if ((!TextUtils.isEmpty(r140)) == true) goto L325;
        r140 = r134;
    L325:
        if (r140 == null) goto L327;
        r129.put("activity_id", r140);
    L327:
        ECBoltParam r141 = r119.a.getBoltParam();
        if (r141 == null) goto L337;
        String r142 = r141.getNewSourceId();
        if (r142 == null) goto L337;
        if ((!TextUtils.isEmpty(r142)) == true) goto L335;
        r142 = r134;
    L335:
        if (r142 == null) goto L337;
        r129.put("new_source_id", r142);
    L337:
        r129.put("page_init_timestamp", String.valueOf(System.currentTimeMillis()));
        r129.put("iesec_auto_coupon_opt_ab", "1");
        ECAdLogExtra r143 = r119.a.getAdLogExtra();
        if (r143 != null) goto L340;
    L342:
        SkuOrderParams r144 = r119.a.getOrderParams();
        if (r144 == null) goto L355;
        HashMap r145 = j.a;
        JSONObject r146 = j.i(r144.getMegaObject());
        if (r146 == null) goto L349;
        Object r147 = r146.get("entrance_info");
        if (r147 == null) goto L349;
        JSONObject r148 = com.bytedance.android.ec.hybrid.list.util.k.b(r147);
    L350:
        e.a(r74, r148);
        Map<String, Object> r149 = k.z(r144.getQueryItems());
        if (r149 == null) goto L355;
        Map r150 = MapsKt.toMutableMap(r149);
        if (r150 == null) goto L355;
        r129.putAll(r150);
    L349:
        r148 = new JSONObject();
    L355:
        r128.put("log_data", r75.toString());
        r128.put("cj_info", r135);
        r128.put("entrance_info", r74.toString());
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("cj_info", r135), TuplesKt.to("mega_object", k.x(r128)), TuplesKt.to("query_items", k.x(r129))});
    L340:
        if (a2.b(r143.getCreativeId()) == false) goto L342;
        String r151 = r143.getAdExtraData();
        JSONObject r152 = new JSONObject();
        r152.put(r120, r143.getCreativeId());
        r152.put("log_extra", r143.getLogExtra());
        r152.put("ad_extra_data", r151);
        r129.put("has_adinfojson", "1");
        r129.put("adinfojson", r152.toString());
    L313:
        r137 = "";
        goto L314
    L308:
        r134 = null;
        r130.put("finance_risk", r131.getInstance().getFinanceRisk());
        goto L309
    L272:
        if (r106.length() <= 0) goto L274;
        boolean r153 = true;
    L275:
        if (r153 == true) goto L278;
        r106 = null;
    L278:
        if (r106 == null) goto L286;
        JSONObject r154 = new JSONObject(r106);     // Catch: Exception -> L284
        Iterator<String> r155 = r154.keys();     // Catch: Exception -> L284
    L281:
        if (r155.hasNext() == false) goto L286;
        String r156 = r155.next();     // Catch: Exception -> L284
        r75.put(r156, r154.optString(r156));     // Catch: Exception -> L284
    L284:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L286
    L274:
        r153 = false;
        goto L275
    L259:
        r104 = null;
        goto L260
    L255:
        r103 = null;
        goto L256
    L251:
        r102 = null;
        goto L252
    L247:
        r101 = null;
        goto L248
    L243:
        r100 = null;
        goto L244
    L239:
        r99 = null;
        goto L240
    L235:
        r97 = null;
    L231:
        r95 = (String) r79.get("label_name_live");
        goto L232
    L226:
        r92 = null;
        goto L227
    L222:
        r90 = null;
        goto L223
    L218:
        r88 = null;
        goto L219
    L214:
        r86 = null;
        goto L215
    L210:
        r123 = "0";
        goto L211
    L200:
        r81 = null;
        goto L201
    L187:
        r72 = null;
        goto L188
    L173:
        r67 = null;
        goto L174
    L169:
        r65 = null;
        goto L170
    L165:
        r63 = null;
        goto L166
    L161:
        r61 = null;
        goto L162
    L157:
        r59 = null;
        goto L158
    L153:
        r57 = null;
        goto L154
    L149:
        r55 = null;
        goto L150
    L175:
        r120 = "cid";
        goto L176
    L137:
        r52 = null;
        goto L139
    L132:
        if (r41.isFromVideoFeed() == false) goto L134;
        Intrinsics.checkNotNullParameter(r41, "skuParams");
        Intrinsics.checkNotNullParameter(r18, "originUrl");
        UltimateBuyOrderExParams r157 = UltimateBuyOrderSchemaParser.a(UriProtector.parse(j.c(new com.bytedance.android.shopping.sku.outer.business.buynow.e(new com.bytedance.android.shopping.sku.outer.business.buynow.c(r41, null, null, true)).a(r18), false, 12)));
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("cj_info", r157.getCjInfo()), TuplesKt.to("mega_object", r157.getMegaObjectJsonString()), TuplesKt.to("query_items", k.x(r157.getQueryParams()))});
    }
}
