package com.bytedance.android.shopping.sku.outer.business.buynow;

import android.text.TextUtils;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.IECCommonService;
import com.bytedance.android.ec.common.impl.order.OrderSchema;
import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.hybrid.utils.j;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.ECAdInfo;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.ECBoltParam;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.ec.model.sku.SkuExtraData;
import com.bytedance.android.ec.model.sku.SkuOrderParams;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.utils.p;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f implements com.bytedance.android.shopping.sku.outer.business.buynow.a {
    public final IOrderSchema a;
    public final c b;
    public final PageFinder c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.shopping.sku.outer.business.buynow.a
    public final boolean u() {
        IOrderSchema r0 = this.a;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.u() != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.shopping.sku.outer.business.buynow.a
    public final void v() {
        IOrderSchema r0 = this.a;
        if (r0 == null) goto L177;
        b r1 = this.b.a;
        String r2 = null;
        if (r1 == null) goto L9;
        uh3.b r3 = r1.k();
        if (r3 == null) goto L9;
        String r4 = r3.f();
    L10:
        OrderSchema.b r5 = r0.P();
        if (r5 == null) goto L13;
        r5.i(z1.f(this.b.b.getEntranceInfo()));
    L13:
        boolean r6 = false;
        String r7 = "";
        if (r5 == null) goto L19;
        Pair[] r10 = new Pair[3];
        r10[0] = TuplesKt.to("auto_coupon", 1);
        String r11 = this.b.c;
        if (r11 != null) goto L18;
        r11 = "";
    L18:
        r10[1] = TuplesKt.to("coupon_id", r11);
        r10[2] = TuplesKt.to("with_sku", "1");
        r5.g(r10);
    L19:
        if (r5 == null) goto L21;
        r5.delete(new String[]{"apt_path_id"});
    L21:
        Map<String, String> r12 = this.b.d();
        if (r5 == null) goto L52;
        Pair[] r13 = new Pair[16];
        r13[0] = TuplesKt.to("product_activity_type", r4);
        ECAdLogExtra r8 = this.b.a();
        if (r8 == null) goto L26;
        String r9 = r8.getCreativeId();
    L27:
        r13[1] = TuplesKt.to("cid", r9);
        SkuExtraData r14 = this.b.b.getSkuExtraData();
        if (r14 == null) goto L30;
        String r15 = r14.getBrandVerified();
    L31:
        r13[2] = TuplesKt.to("brand_verified", r15);
        SkuExtraData r16 = this.b.b.getSkuExtraData();
        if (r16 == null) goto L34;
        String r17 = r16.getLabelName();
    L35:
        r13[3] = TuplesKt.to("label_name", r17);
        SkuExtraData r18 = this.b.b.getSkuExtraData();
        if (r18 == null) goto L38;
        String r19 = r18.getLabelNameLive();
    L39:
        r13[4] = TuplesKt.to("label_name_live", r19);
        SkuExtraData r20 = this.b.b.getSkuExtraData();
        if (r20 == null) goto L42;
        String r21 = r20.getHasReplay();
    L43:
        r13[5] = TuplesKt.to("is_replay", r21);
        r13[6] = TuplesKt.to("label_name_live", r12.get("label_name_live"));
        SkuExtraData r22 = this.b.b.getSkuExtraData();
        if (r22 == null) goto L46;
        String r23 = r22.getProductTypeVerified();
    L47:
        r13[7] = TuplesKt.to("base_verified_category", r23);
        r13[8] = TuplesKt.to("card_status", r12.get("card_status"));
        SkuExtraData r24 = this.b.b.getSkuExtraData();
        if (r24 == null) goto L50;
        String r25 = r24.getWithVideo();
    L51:
        r13[9] = TuplesKt.to("is_with_video", r25);
        r13[10] = TuplesKt.to("is_package_sale", r12.get("is_package_sale"));
        r13[11] = TuplesKt.to("new_source_type", r12.get("new_source_type"));
        r13[12] = TuplesKt.to("source_3d", r12.get("source_3d"));
        r13[13] = TuplesKt.to("commodity_id", this.b.g());
        r13[14] = TuplesKt.to("commodity_type", this.b.b.getCommodityType());
        r13[15] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, this.b.f());
        r5.j(r13, SkuOuterBuyNowSchemaForAnchorV2$appendEntranceInfo$1.INSTANCE);
        goto L52
    L50:
        r25 = null;
        goto L51
    L46:
        r23 = null;
        goto L47
    L42:
        r21 = null;
        goto L43
    L38:
        r19 = null;
        goto L39
    L34:
        r17 = null;
        goto L35
    L30:
        r15 = null;
        goto L31
    L26:
        r9 = null;
    L52:
        HashMap r26 = j.a;
        JSONObject r27 = j.i(this.b.b.getTransmissibleJson());
        if (r27 == null) goto L57;
        Map r28 = z1.j(r27);
        if (r5 == null) goto L57;
        r5.putAll(r28);
    L57:
        SkuOrderParams r29 = this.b.b.getOrderParams();
        if (r29 == null) goto L68;
        JSONObject r30 = j.i(r29.getMegaObject());
        if (r30 == null) goto L68;
        Object r31 = r30.get("entrance_info");
        if (r31 == null) goto L68;
        String r32 = r31.toString();
        if (r32 == null) goto L68;
        Map r33 = z1.j(z1.f(r32));
        if (r5 == null) goto L68;
        r5.putAll(r33);
    L68:
        ECAdInfo r34 = this.b.b.getLatestRecommendFeedAdInfo();
        if (r34 == null) goto L72;
        if (r5 == null) goto L72;
        r5.g(new Pair[]{TuplesKt.to("creative_id", r34.getCid()), TuplesKt.to("log_extra", r34.getLogExtra())});
    L72:
        JSONObject r35 = new JSONObject();
        if (BuyNowPerformanceOpt.j() == true) goto L75;
        r35.put("biometric_params", "1");
        int r36 = p.a;
        r35.put("is_jailbreak", "2");
        r35.put("bio_type", "1");
        r35.put("cj_sdk", p.b());
    L75:
        b r37 = this.b.a;
        if (r37 == null) goto L78;
        String r38 = r37.e();
    L79:
        if (r38 != null) goto L81;
    L89:
        r0.replaceOrAppendParam("cj_info", r35.toString());
        SkuExtraData r39 = this.b.b.getSkuExtraData();
        if (r39 == null) goto L92;
        String r40 = r39.getMarketChannel();
    L93:
        if (r40 != null) goto L95;
        r40 = "";
    L95:
        r0.replaceOrAppendParam("marketing_channel", r40);
        b r41 = this.b.a;
        if (r41 == null) goto L98;
        String r42 = r41.g();
    L99:
        if (r42 == null) goto L102;
        r7 = r42;
    L102:
        r0.replaceOrAppendParam("poi_id", r7);
        b r43 = this.b.a;
        if (r43 == null) goto L105;
        String r44 = r43.i();
    L106:
        if (r44 != null) goto L108;
    L115:
        r0.replaceOrAppendParam("iesec_auto_coupon_opt_ab", "1");
        String r45 = this.b.b();
        if (r45 == null) goto L118;
        r0.replaceOrAppendParam("combo_id", r45);
    L118:
        r0.replaceOrAppendParam("combo_num", String.valueOf(this.b.c()));
        String r46 = this.b.b.getSpellGroupId();
        if (r46 == null) goto L121;
        r0.replaceOrAppendParam("spell_group_id", r46);
    L121:
        ECBoltParam r47 = this.b.b.getBoltParam();
        if (r47 == null) goto L131;
        String r48 = r47.getActivityId();
        if (r48 == null) goto L131;
        if ((!TextUtils.isEmpty(r48)) == true) goto L129;
        r48 = null;
    L129:
        if (r48 == null) goto L131;
        r0.replaceOrAppendParam("activity_id", r48);
    L131:
        ECBoltParam r49 = this.b.b.getBoltParam();
        if (r49 == null) goto L141;
        String r50 = r49.getNewSourceId();
        if (r50 == null) goto L141;
        if ((!TextUtils.isEmpty(r50)) == true) goto L139;
        r50 = null;
    L139:
        if (r50 == null) goto L141;
        r0.replaceOrAppendParam("new_source_id", r50);
    L141:
        r0.replaceOrAppendParam("page_init_timestamp", String.valueOf(System.currentTimeMillis()));
        SkuOrderParams r51 = this.b.b.getOrderParams();
        if (r51 == null) goto L149;
        Map<String, Object> r52 = k.z(r51.getQueryItems());
        if (r52 == null) goto L149;
        Iterator<Map.Entry<String, Object>> r53 = r52.entrySet().iterator();
    L147:
        if (r53.hasNext() == false) goto L149;
        Map.Entry<String, Object> r54 = r53.next();
        r0.replaceOrAppendParam(r54.getKey(), String.valueOf(r54.getValue()));
    L149:
        b r55 = this.b.a;
        if (r55 == null) goto L152;
        Map<String, Object> r56 = r55.b();
    L153:
        if (r56 == null) goto L158;
        Iterator<Map.Entry<String, Object>> r57 = r56.entrySet().iterator();
    L156:
        if (r57.hasNext() == false) goto L158;
        Map.Entry<String, Object> r58 = r57.next();
        r0.replaceOrAppendParam(r58.getKey(), String.valueOf(r58.getValue()));
    L158:
        ECAdLogExtra r59 = this.b.a();
        if (r59 != null) goto L161;
    L163:
        com.bytedance.android.ec.core.btm.c.g(r0, this.c);
        b r60 = this.b.a;
        if (r60 == null) goto L166;
        String r61 = r60.c();
    L167:
        if (r61 == null) goto L169;
        r0.replaceOrAppendParam("custom_property_list", r61);
    L169:
        b r62 = this.b.a;
        if (r62 == null) goto L172;
        r2 = r62.d();
    L172:
        if (r2 == null) goto L178;
        r0.replaceOrAppendParam("sale_package_list", r2);
        return;
    L178:
        return;
    L166:
        r61 = null;
        goto L167
    L161:
        if (a2.b(r59.getCreativeId()) == false) goto L163;
        String r63 = r59.getAdExtraData();
        JSONObject r64 = new JSONObject();
        r64.put("cid", r59.getCreativeId());
        r64.put("log_extra", r59.getLogExtra());
        r64.put("ad_extra_data", r63);
        r0.replaceOrAppendParam("has_adinfojson", "1");
        r0.replaceOrAppendParam("adinfojson", r64.toString());
        goto L163
    L152:
        r56 = null;
        goto L153
    L108:
        if (r44.length() <= 0) goto L110;
        r6 = true;
    L110:
        if (r6 == true) goto L113;
        r44 = null;
    L113:
        if (r44 == null) goto L115;
        r0.replaceOrAppendParam("promise_type", r44);
        goto L115
    L105:
        r44 = null;
        goto L106
    L98:
        r42 = null;
        goto L99
    L92:
        r40 = null;
        goto L93
    L81:
        if (r38.length() <= 0) goto L83;
        boolean r65 = true;
    L84:
        if (r65 == true) goto L87;
        r38 = null;
    L87:
        if (r38 == null) goto L89;
        r35.put("installment", r38);
        goto L89
    L83:
        r65 = false;
        goto L84
    L78:
        r38 = null;
    L9:
        r4 = null;
        goto L10
    }

    @Override // com.bytedance.android.shopping.sku.outer.business.buynow.a
    public final IOrderSchema a() {
        return this.a;
    }

    public f(String r3, c r4, PageFinder r5) {
        Intrinsics.checkNotNullParameter(r3, "originUrl");
        Intrinsics.checkNotNullParameter(r4, "buyNowData");
        Intrinsics.checkNotNullParameter(r5, "btmPageFinder");
        this.b = r4;
        this.c = r5;
        new EntranceInfoScene("sku", "orderUrl");
        int r6 = ECSdk.a;
        IECCommonService r7 = (IECCommonService) ECSdk.a(IECCommonService.class);
        if (r7 == null) goto L5;
        IOrderSchema r8 = r7.convertToOrderSchema(r3, new EntranceInfoScene("sku", "orderUrl"));
    L6:
        this.a = r8;
        return;
    L5:
        r8 = null;
        goto L6
    }
}
