package com.bytedance.android.shopping.sku.outer.business.buynow;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.ec.common.api.entranceinfo.IEntranceInfoService;
import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.hybrid.utils.j;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.j1;
import com.bytedance.android.ec.core.utils.k2;
import com.bytedance.android.ec.core.utils.n0;
import com.bytedance.android.ec.core.utils.p0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.ECAdInfo;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.ECBoltParam;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.ec.model.sku.SkuExtraData;
import com.bytedance.android.ec.model.sku.SkuOrderParams;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.utils.p;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e {
    public final c a;

    public static final class a {
    }

    static {
    }

    public e(c r2) {
        Intrinsics.checkNotNullParameter(r2, "buyNowData");
        this.a = r2;
    }

    public final String a(String r25) {
        Intrinsics.checkNotNullParameter(r25, "originUrl");
        Uri r3 = UriProtector.parse(r25);
        b r0 = this.a.a;
        if (r0 == null) goto L7;
        uh3.b r1 = r0.k();
        if (r1 == null) goto L7;
        String r2 = r1.f();
    L8:
        int r5 = ECSdk.a;
        IEntranceInfoService r6 = (IEntranceInfoService) ECSdk.a(IEntranceInfoService.class);
        if (r6 == null) goto L11;
        gl.a r7 = r6.initEntranceInfo(new EntranceInfoScene("sku", "orderUrl"), this.a.b.getEntranceInfo());
    L13:
        if (r7 == null) goto L19;
        Pair[] r15 = new Pair[3];
        r15[0] = TuplesKt.to("auto_coupon", 1);
        String r4 = this.a.c;
        if (r4 != null) goto L17;
        r4 = "";
    L17:
        r15[1] = TuplesKt.to("coupon_id", r4);
        r15[2] = TuplesKt.to("with_sku", "1");
        r7.g(r15);
    L19:
        if (r7 == null) goto L22;
        r7.delete(new String[]{"apt_path_id"});
    L22:
        if (r7 == null) goto L53;
        Pair[] r8 = new Pair[16];
        r8[0] = TuplesKt.to("product_activity_type", r2);
        ECAdLogExtra r9 = this.a.a();
        if (r9 == null) goto L26;
        String r10 = r9.getCreativeId();
    L27:
        r8[1] = TuplesKt.to("cid", r10);
        SkuExtraData r11 = this.a.b.getSkuExtraData();
        if (r11 == null) goto L30;
        String r12 = r11.getBrandVerified();
    L31:
        r8[2] = TuplesKt.to("brand_verified", r12);
        SkuExtraData r13 = this.a.b.getSkuExtraData();
        if (r13 == null) goto L34;
        String r14 = r13.getLabelName();
    L35:
        r8[3] = TuplesKt.to("label_name", r14);
        SkuExtraData r16 = this.a.b.getSkuExtraData();
        if (r16 == null) goto L38;
        String r17 = r16.getLabelNameLive();
    L39:
        r8[4] = TuplesKt.to("label_name_live", r17);
        SkuExtraData r18 = this.a.b.getSkuExtraData();
        if (r18 == null) goto L42;
        String r19 = r18.getHasReplay();
    L43:
        r8[5] = TuplesKt.to("is_replay", r19);
        r8[6] = TuplesKt.to("label_name_live", this.a.d().get("label_name_live"));
        SkuExtraData r20 = this.a.b.getSkuExtraData();
        if (r20 == null) goto L46;
        String r21 = r20.getProductTypeVerified();
    L47:
        r8[7] = TuplesKt.to("base_verified_category", r21);
        r8[8] = TuplesKt.to("card_status", this.a.d().get("card_status"));
        SkuExtraData r22 = this.a.b.getSkuExtraData();
        if (r22 == null) goto L50;
        String r23 = r22.getWithVideo();
    L51:
        r8[9] = TuplesKt.to("is_with_video", r23);
        r8[10] = TuplesKt.to("is_package_sale", this.a.d().get("is_package_sale"));
        r8[11] = TuplesKt.to("new_source_type", this.a.d().get("new_source_type"));
        r8[12] = TuplesKt.to("source_3d", this.a.d().get("source_3d"));
        r8[13] = TuplesKt.to("commodity_id", this.a.g());
        r8[14] = TuplesKt.to("commodity_type", this.a.b.getCommodityType());
        r8[15] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, this.a.f());
        r7.j(r8, SkuOuterBuyNowSchemaForAnchor$addEntranceInfoToOrderUrl$1.INSTANCE);
        goto L53
    L50:
        r23 = null;
        goto L51
    L46:
        r21 = null;
        goto L47
    L42:
        r19 = null;
        goto L43
    L38:
        r17 = null;
        goto L39
    L34:
        r14 = null;
        goto L35
    L30:
        r12 = null;
        goto L31
    L26:
        r10 = null;
    L53:
        HashMap r24 = j.a;
        JSONObject r26 = j.i(this.a.b.getTransmissibleJson());
        if (r26 == null) goto L58;
        Map r27 = z1.j(r26);
        if (r7 == null) goto L58;
        r7.putAll(r27);
    L58:
        if (r7 == null) goto L60;
        String r28 = r7.h();
    L61:
        JSONObject r29 = z1.f(r28);
        SkuOrderParams r30 = this.a.b.getOrderParams();
        if (r30 == null) goto L70;
        JSONObject r31 = j.i(r30.getMegaObject());
        if (r31 == null) goto L70;
        Object r32 = r31.get("entrance_info");
        if (r32 == null) goto L70;
        String r33 = r32.toString();
        if (r33 == null) goto L70;
        ul.e.a(r29, z1.f(r33));
    L70:
        JSONObject r34 = EcomBcmTracker.c(null, r29);
        if (r34 != null) goto L73;
        r34 = r29;
    L73:
        String r35 = "log_data";
        String r36 = UriProtector.getQueryParameter(UriProtector.parse(r25), "log_data");
        if (r36 == null) goto L76;
        JSONObject r37 = new JSONObject(r36);
    L77:
        String r38 = this.a.b.getAnchorBuyNowLogData();
        if (r38 == null) goto L83;
        JSONObject r39 = z1.f(r38);
        Iterator<String> r110 = r39.keys();
    L81:
        if (r110.hasNext() == false) goto L83;
        String r210 = r35;
        String r40 = r110.next();
        r37.put(r40, r39.optString(r40));
        r34 = r34;
        r35 = r210;
    L83:
        String r211 = r35;
        JSONObject r212 = r34;
        Map<String, String> r41 = this.a.d();
        r37.putOpt("auto_coupon", 1);
        String r42 = this.a.c;
        if (r42 != null) goto L86;
        r42 = "";
    L86:
        r37.putOpt("coupon_id", r42);
        r37.putOpt("cash_rebate", r41.get("cash_rebate"));
        String r43 = this.a.b.getEcomEntranceForm();
        if (r43 != null) goto L89;
        r43 = r41.get("ecom_entrance_form");
    L89:
        r37.putOpt("ecom_entrance_form", r43);
        r37.putOpt("with_sku", "1");
        r37.putOpt("new_user_activity", r41.get("new_user_activity"));
        r37.putOpt("new_user_activity_id", r41.get("new_user_activity_id"));
        r37.putOpt("campaign_type", r41.get("campaign_type"));
        r37.putOpt("campaign_sub_type", r41.get("campaign_sub_type"));
        r37.putOpt("avl_discount", r41.get("avl_discount"));
        r37.putOpt("coupon_id", r41.get("coupon_id"));
        String r44 = "0";
        if (this.a.b.isGroupingBuy() == false) goto L92;
        Object r45 = "1";
    L93:
        r37.putOpt("is_groupbuying", r45);
        String r46 = r41.get("is_explain_apply");
        if (r46 != null) goto L96;
        r46 = "0";
    L96:
        r37.putOpt("is_explain_apply", r46);
        SkuExtraData r47 = this.a.b.getSkuExtraData();
        if (r47 == null) goto L99;
        String r48 = r47.getProductTypeVerified();
    L100:
        r37.putOpt("base_verified_category", r48);
        SkuExtraData r49 = this.a.b.getSkuExtraData();
        if (r49 == null) goto L103;
        String r50 = r49.getBrandVerified();
    L104:
        r37.putOpt("brand_verified", r50);
        if (StringsKt.isBlank(r37.optString("is_crossborder_goods")) == false) goto L114;
        SkuExtraData r51 = this.a.b.getSkuExtraData();
        if (r51 == null) goto L109;
        Boolean r52 = Boolean.valueOf(r51.isCrossborderProduct());
    L111:
        if (Intrinsics.areEqual(r52, Boolean.TRUE) == false) goto L113;
        r44 = "1";
    L113:
        r37.putOpt("is_crossborder_goods", r44);
        goto L114
    L109:
        r52 = null;
    L114:
        SkuExtraData r53 = this.a.b.getSkuExtraData();
        if (r53 == null) goto L117;
        String r54 = r53.getGoodsType();
    L118:
        r37.putOpt("goods_type", r54);
        r37.putOpt("author_id", this.a.b.getAuthorId());
        SkuExtraData r55 = this.a.b.getSkuExtraData();
        if (r55 == null) goto L121;
        String r56 = r55.getLabelName();
    L122:
        r37.putOpt("label_name", r56);
        String r57 = this.a.d().get("label_name_live");
        if (r57 != null) goto L128;
        SkuExtraData r58 = this.a.b.getSkuExtraData();
        if (r58 == null) goto L127;
        r57 = r58.getLabelNameLive();
        goto L128
    L127:
        r57 = null;
    L128:
        r37.putOpt("label_name_live", r57);
        SkuExtraData r59 = this.a.b.getSkuExtraData();
        if (r59 == null) goto L131;
        String r60 = r59.isAuthenticInsure();
    L132:
        r37.putOpt("is_authentic_insure", r60);
        b r61 = this.a.a;
        if (r61 == null) goto L137;
        uh3.b r62 = r61.k();
        if (r62 == null) goto L137;
        String r63 = r62.i();
    L138:
        r37.putOpt("upfront_presell", r63);
        r37.putOpt(PdpOpenThirdParam.KEY_SOURCE_PAGE, this.a.b.getSourcePage());
        r37.putOpt("card_status", this.a.d().get("card_status"));
        r37.putOpt("is_package_sale", this.a.d().get("is_package_sale"));
        r37.putOpt(PdpOpenThirdParam.KEY_ITEM_ID, this.a.d().get(PdpOpenThirdParam.KEY_ITEM_ID));
        String r64 = this.a.b.getTransmissibleJson();
        if (r64 != null) goto L141;
    L155:
        SkuExtraData r65 = this.a.b.getSkuExtraData();
        if (r65 == null) goto L158;
        String r66 = r65.getTransitionTrackerData();
    L159:
        if (r66 != null) goto L161;
    L175:
        r37.remove("coupon_type");
        String r67 = this.a.b.getEntranceInfo();
        if (r67 == null) goto L178;
        HashMap r68 = j.a;
        JSONObject r69 = j.i(r67);
    L180:
        if (r69 == null) goto L182;
        String r70 = r69.optString("carrier_source");
    L183:
        r37.putOpt("carrier_source", r70);
        if (r69 == null) goto L186;
        String r71 = r69.optString("source_method");
    L187:
        r37.putOpt("source_method", r71);
        if (r69 == null) goto L190;
        String r72 = r69.optString("similar_type");
    L191:
        r37.putOpt("similar_type", r72);
        if (r69 == null) goto L194;
        String r73 = r69.optString("ecom_tag_type");
    L195:
        r37.putOpt("ecom_tag_type", r73);
        if (r69 == null) goto L198;
        String r74 = r69.optString("module_label");
    L199:
        r37.putOpt("module_label", r74);
        JSONObject r75 = new JSONObject();
        if (BuyNowPerformanceOpt.j() == true) goto L202;
        r75.putOpt("biometric_params", "1");
        int r76 = p.a;
        r75.putOpt("is_jailbreak", "2");
        r75.putOpt("bio_type", "1");
        r75.putOpt("cj_sdk", p.b());
    L202:
        b r77 = this.a.a;
        if (r77 == null) goto L205;
        String r78 = r77.e();
    L206:
        r75.putOpt("installment", r78);
        if (UriProtector.getQueryParameter(r3, "rifle_mega_object") == null) goto L209;
        boolean r79 = true;
    L210:
        b r80 = this.a.a;
        if (r80 == null) goto L213;
        String r81 = r80.g();
    L214:
        String r82 = UriProtector.getQueryParameter(r3, "mega_object");
        if (r82 == null) goto L221;
        JSONObject r84 = new JSONObject(r82);
        HashMap r111 = j.a;
        JSONObject r85 = j.i(new JSONObject(r82).optString("entrance_info"));
        if (r85 == null) goto L219;
        r85.remove("apt_path_id");
        Unit r112 = Unit.INSTANCE;
    L220:
        String r86 = r84.put("entrance_info", String.valueOf(r85)).toString();
    L222:
        int r87 = p0.a;
        String r88 = p0.g(p0.g(p0.g(r25, "entrance_info", r212.toString()), r211, r37.toString()), "cj_info", String.valueOf(r75));
        b r89 = this.a.a;
        if (r89 == null) goto L225;
        String r90 = r89.i();
    L226:
        if (r90 != null) goto L228;
    L236:
        SkuExtraData r91 = this.a.b.getSkuExtraData();
        if (r91 == null) goto L239;
        String r92 = r91.getMarketChannel();
    L240:
        if (r92 != null) goto L242;
        r92 = "";
    L242:
        String r94 = p0.d(r88, "marketing_channel", r92);
        if (r81 != null) goto L245;
        r81 = "";
    L245:
        String r95 = p0.d(r94, "poi_id", r81);
        if (r86 != null) goto L248;
        r86 = "";
    L248:
        String r96 = p0.d(p0.c(r95, "mega_object", r86), "iesec_auto_coupon_opt_ab", "1");
        b r97 = this.a.a;
        if (r97 == null) goto L251;
        String r98 = r97.c();
    L252:
        if (r98 == null) goto L254;
        r96 = p0.d(r96, "custom_property_list", r98);
    L254:
        b r99 = this.a.a;
        if (r99 == null) goto L257;
        String r100 = r99.d();
    L258:
        if (r100 == null) goto L260;
        r96 = p0.d(r96, "sale_package_list", r100);
    L260:
        b r101 = this.a.a;
        if (r101 == null) goto L263;
        Map<String, Object> r102 = r101.b();
    L264:
        if (r102 == null) goto L269;
        Iterator<Map.Entry<String, Object>> r103 = r102.entrySet().iterator();
    L267:
        if (r103.hasNext() == false) goto L269;
        Map.Entry<String, Object> r104 = r103.next();
        int r105 = p0.a;
        r96 = p0.d(r96, r104.getKey(), String.valueOf(r104.getValue()));
    L269:
        String r106 = this.a.b();
        Long r107 = this.a.c();
        ECAdLogExtra r108 = this.a.a();
        ECBoltParam r109 = this.a.b.getBoltParam();
        String r113 = r212.toString();
        String r114 = this.a.b.getSpellGroupId();
        ECAdInfo r115 = this.a.b.getLatestRecommendFeedAdInfo();
        if (r96 == null) goto L274;
        boolean r116 = true;
        if ((!TextUtils.isEmpty(r96)) == true) goto L276;
    L275:
        r96 = null;
    L276:
        if (r96 != null) goto L278;
        r96 = "";
    L278:
        n0 r117 = new n0(r96, r116);
        if (r106 == null) goto L282;
        r117.b("combo_id", r106);
    L282:
        if (r107 == null) goto L284;
        r117.a("combo_num", r107.longValue());
    L284:
        if (r114 == null) goto L286;
        r117.b("spell_group_id", r114);
    L286:
        if (r109 == null) goto L295;
        String r118 = r109.getActivityId();
        if (r118 == null) goto L295;
        if ((!TextUtils.isEmpty(r118)) == true) goto L293;
        r118 = null;
    L293:
        if (r118 == null) goto L295;
        r117.b("activity_id", r118);
    L295:
        if (r109 == null) goto L304;
        String r119 = r109.getNewSourceId();
        if (r119 == null) goto L304;
        if ((!TextUtils.isEmpty(r119)) == true) goto L302;
        r119 = null;
    L302:
        if (r119 == null) goto L304;
        r117.b("new_source_id", r119);
    L304:
        if (r113 == null) goto L312;
        if ((!TextUtils.isEmpty(r113)) == true) goto L309;
        r113 = null;
    L309:
        if (r113 == null) goto L312;
        r117.b("entrance_info", r113);
    L312:
        r117.a("page_init_timestamp", System.currentTimeMillis());
        SkuOrderParams r120 = this.a.b.getOrderParams();
        if (r120 == null) goto L320;
        Map<String, Object> r121 = k.z(r120.getQueryItems());
        if (r121 == null) goto L320;
        Iterator<Map.Entry<String, Object>> r122 = r121.entrySet().iterator();
    L318:
        if (r122.hasNext() == false) goto L320;
        Map.Entry<String, Object> r123 = r122.next();
        r117.b(r123.getKey(), String.valueOf(r123.getValue()));
    L320:
        int r124 = wh3.a.a;
        String r125 = r117.c();
        if (r125 != null) goto L324;
        String r126 = "";
    L372:
        String r127 = k2.a(r126, this.a.b.getV3EventAdditions());
        if (r127 != null) goto L376;
        return r126;
    L376:
        return r127;
    L324:
        if (r108 != null) goto L326;
    L343:
        r126 = r125;
    L344:
        if (r115 == null) goto L372;
        String r128 = j1.c(UriProtector.parse(r125), "entrance_info");
        if (r128 != null) goto L380;
    L356:
        JSONObject r129 = new JSONObject();     // Catch: Exception -> L358
    L379:
    L360:
        if (r129.optString("creative_id").length() != 0) goto L362;
        boolean r130 = true;
    L363:
        if (r130 == false) goto L366;
        r129.put("creative_id", r115.getCid());
    L366:
        if (r129.optString("log_extra").length() != 0) goto L368;
        boolean r131 = true;
    L369:
        if (r131 == false) goto L371;
        r129.put("log_extra", r115.getLogExtra());
    L371:
        int r132 = p0.a;
        r126 = p0.d(r126, "entrance_info", r129.toString());
        goto L372
    L368:
        r131 = false;
        goto L369
    L362:
        r130 = false;
    L358:
        r129 = new JSONObject();
        goto L360
    L380:
        if (r128.length() <= 0) goto L350;
        boolean r133 = true;
    L351:
        if (r133 == true) goto L354;
        r128 = null;
    L354:
        if (r128 == null) goto L356;
        r129 = new JSONObject(r128);     // Catch: Exception -> L358
        goto L379
    L350:
        r133 = false;
        goto L351
    L326:
        if (a2.b(r108.getCreativeId()) == false) goto L343;
        String r134 = r108.getAdExtraData();
        if (r79 == true) goto L337;
        String r135 = r108.getCreativeId();
        String r136 = r108.getLogExtra();
        JSONObject r137 = new JSONObject();
        if (r135 == null) goto L332;
        r137.put("cid", r135);
    L332:
        if (r136 == null) goto L334;
        r137.put("log_extra", r136);
    L334:
        if (r134 == null) goto L336;
        r137.put("ad_extra_data", r134);
    L336:
        String r138 = r137.toString();
        Uri.Builder r139 = UriProtector.parse(r125).buildUpon();
        r139.appendQueryParameter("has_adinfojson", "1");
        r139.appendQueryParameter("adinfojson", r138);
        String r140 = r139.toString();
    L342:
        r126 = r140;
        goto L344
    L337:
        String r141 = r108.getCreativeId();
        String r142 = r108.getLogExtra();
        JSONObject r143 = z1.g(UriProtector.getQueryParameter(UriProtector.parse(r125), "rifle_mega_object"));
        if (r143 == null) goto L340;
        r143.put("cid", r141);
        r143.put("log_extra", r142);
        r143.put("ad_extra_data", r134);
    L341:
        int r144 = p0.a;
        r140 = p0.d(r125, "rifle_mega_object", String.valueOf(r143));
        goto L342
    L340:
        r143 = null;
        goto L341
    L274:
        r116 = true;
        goto L275
    L263:
        r102 = null;
        goto L264
    L257:
        r100 = null;
        goto L258
    L251:
        r98 = null;
        goto L252
    L239:
        r92 = null;
        goto L240
    L228:
        if (r90.length() <= 0) goto L230;
        boolean r145 = true;
    L231:
        if (r145 == true) goto L234;
        r90 = null;
    L234:
        if (r90 == null) goto L236;
        r88 = p0.g(r88, "promise_type", r90);
        goto L236
    L230:
        r145 = false;
        goto L231
    L225:
        r90 = null;
        goto L226
    L219:
        r85 = null;
        goto L220
    L221:
        r86 = null;
        goto L222
    L213:
        r81 = null;
        goto L214
    L209:
        r79 = false;
        goto L210
    L205:
        r78 = null;
        goto L206
    L198:
        r74 = null;
        goto L199
    L194:
        r73 = null;
        goto L195
    L190:
        r72 = null;
        goto L191
    L186:
        r71 = null;
        goto L187
    L182:
        r70 = null;
        goto L183
    L178:
        r69 = null;
        goto L180
    L161:
        if (r66.length() <= 0) goto L163;
        boolean r146 = true;
    L164:
        if (r146 == true) goto L167;
        r66 = null;
    L167:
        if (r66 == null) goto L175;
        JSONObject r147 = new JSONObject(r66);     // Catch: Exception -> L173
        Iterator<String> r148 = r147.keys();     // Catch: Exception -> L173
    L170:
        if (r148.hasNext() == false) goto L175;
        String r149 = r148.next();     // Catch: Exception -> L173
        r37.put(r149, r147.optString(r149));     // Catch: Exception -> L173
    L173:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L175
    L163:
        r146 = false;
        goto L164
    L158:
        r66 = null;
        goto L159
    L141:
        if (r64.length() <= 0) goto L143;
        boolean r150 = true;
    L144:
        if (r150 == true) goto L147;
        r64 = null;
    L147:
        if (r64 == null) goto L155;
        JSONObject r151 = new JSONObject(r64);     // Catch: Exception -> L153
        Iterator<String> r152 = r151.keys();     // Catch: Exception -> L153
    L150:
        if (r152.hasNext() == false) goto L155;
        String r153 = r152.next();     // Catch: Exception -> L153
        r37.put(r153, r151.optString(r153));     // Catch: Exception -> L153
    L153:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L155
    L143:
        r150 = false;
    L137:
        r63 = null;
        goto L138
    L131:
        r60 = null;
        goto L132
    L121:
        r56 = null;
        goto L122
    L117:
        r54 = null;
        goto L118
    L103:
        r50 = null;
        goto L104
    L99:
        r48 = null;
        goto L100
    L92:
        r45 = "0";
        goto L93
    L76:
        r37 = new JSONObject();
        goto L77
    L60:
        r28 = null;
        goto L61
    L11:
        r7 = null;
    L7:
        r2 = null;
        goto L8
    }
}
