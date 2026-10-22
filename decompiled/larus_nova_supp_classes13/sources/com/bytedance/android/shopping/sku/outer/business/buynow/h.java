package com.bytedance.android.shopping.sku.outer.business.buynow;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.IECCommonService;
import com.bytedance.android.ec.common.impl.order.OrderSchema;
import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.ECAdInfo;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.utils.p;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h implements a {
    public final IOrderSchema a;
    public final c b;
    public final PageFinder c;

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
        if (r0 == null) goto L129;
        OrderSchema.b r1 = r0.P();
        Map<String, String> r2 = this.b.d();
        boolean r3 = false;
        String r5 = "";
        if (r1 == null) goto L49;
        Pair[] r7 = new Pair[16];
        String r9 = r2.get("is_groupbuying");
        if (r9 != null) goto L9;
        r9 = "";
    L9:
        r7[0] = TuplesKt.to("is_groupbuying", r9);
        String r10 = r2.get("is_explain_apply");
        if (r10 != null) goto L12;
        r10 = "0";
    L12:
        r7[1] = TuplesKt.to("is_explain_apply", r10);
        String r11 = r2.get("label_name");
        if (r11 != null) goto L15;
        r11 = "";
    L15:
        r7[2] = TuplesKt.to("label_name", r11);
        String r12 = r2.get("label_name_live");
        if (r12 != null) goto L18;
        r12 = "";
    L18:
        r7[3] = TuplesKt.to("label_name_live", r12);
        r7[4] = TuplesKt.to(SimilarProductParam.ENTER_FROM, "live");
        String r13 = r2.get("ecom_group_type");
        if (r13 != null) goto L21;
        r13 = "";
    L21:
        r7[5] = TuplesKt.to("ecom_group_type", r13);
        String r14 = r2.get("upfront_presell");
        if (r14 != null) goto L24;
        r14 = "";
    L24:
        r7[6] = TuplesKt.to("upfront_presell", r14);
        String r15 = r2.get("base_verified_category");
        if (r15 != null) goto L27;
        r15 = "";
    L27:
        r7[7] = TuplesKt.to("base_verified_category", r15);
        String r16 = r2.get("tab_name");
        if (r16 != null) goto L30;
        r16 = "";
    L30:
        r7[8] = TuplesKt.to("tab_name", r16);
        String r17 = r2.get(PdpOpenThirdParam.KEY_PAGE_NAME);
        if (r17 != null) goto L33;
        r17 = "";
    L33:
        r7[9] = TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, r17);
        String r18 = r2.get("is_explaining");
        if (r18 != null) goto L36;
        r18 = "";
    L36:
        r7[10] = TuplesKt.to("is_explaining", r18);
        String r19 = r2.get("card_status");
        if (r19 != null) goto L39;
        r19 = "";
    L39:
        r7[11] = TuplesKt.to("card_status", r19);
        String r4 = r2.get("source_3d");
        if (r4 != null) goto L42;
        r4 = "";
    L42:
        r7[12] = TuplesKt.to("source_3d", r4);
        r7[13] = TuplesKt.to("commodity_id", this.b.g());
        String r6 = this.b.b.getCommodityType();
        if (r6 != null) goto L45;
        r6 = "";
    L45:
        r7[14] = TuplesKt.to("commodity_type", r6);
        String r8 = this.b.f();
        if (r8 != null) goto L48;
        r8 = "";
    L48:
        r7[15] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r8);
        r1.j(r7, SkuOuterBuyNowSchemaForLiveV2$appendEntranceInfo$1.INSTANCE);
    L49:
        JSONObject r20 = z1.g(this.b.b.getTransmissibleJson());
        if (r20 == null) goto L54;
        Map r21 = z1.j(r20);
        if (r1 == null) goto L54;
        r1.putAll(r21);
    L54:
        ECAdInfo r22 = this.b.b.getLatestRecommendFeedAdInfo();
        if (r22 == null) goto L58;
        if (r1 == null) goto L58;
        r1.g(new Pair[]{TuplesKt.to("creative_id", r22.getCid()), TuplesKt.to("log_extra", r22.getLogExtra())});
    L58:
        JSONObject r23 = new JSONObject();
        if (BuyNowPerformanceOpt.j() == true) goto L61;
        r23.put("biometric_params", "1");
        int r24 = p.a;
        r23.put("is_jailbreak", "2");
        r23.put("bio_type", "1");
        r23.put("cj_sdk", p.b());
    L61:
        b r25 = this.b.a;
        Map<String, Object> r26 = null;
        if (r25 == null) goto L64;
        String r27 = r25.e();
    L65:
        if (r27 != null) goto L67;
    L75:
        r0.replaceOrAppendParam("cj_info", r23.toString());
        String r28 = this.b.b();
        if (r28 != null) goto L78;
        r28 = "";
    L78:
        r0.replaceOrAppendParam("combo_id", r28);
        r0.replaceOrAppendParam("combo_num", String.valueOf(this.b.c()));
        String r29 = this.b.b.getSpellGroupId();
        if (r29 != null) goto L81;
    L89:
        b r30 = this.b.a;
        if (r30 == null) goto L92;
        String r31 = r30.g();
    L93:
        if (r31 == null) goto L96;
        r5 = r31;
    L96:
        r0.replaceOrAppendParam("poi_id", r5);
        b r32 = this.b.a;
        if (r32 == null) goto L99;
        String r33 = r32.i();
    L100:
        if (r33 != null) goto L102;
    L109:
        r0.replaceOrAppendParam("iesec_auto_coupon_opt_ab", "1");
        r0.replaceOrAppendParam("page_init_timestamp", String.valueOf(System.currentTimeMillis()));
        com.bytedance.android.ec.core.btm.c.g(r0, this.c);
        b r34 = this.b.a;
        if (r34 == null) goto L112;
        String r35 = r34.c();
    L113:
        if (r35 == null) goto L115;
        r0.replaceOrAppendParam("custom_property_list", r35);
    L115:
        b r36 = this.b.a;
        if (r36 == null) goto L118;
        String r37 = r36.d();
    L119:
        if (r37 == null) goto L121;
        r0.replaceOrAppendParam("sale_package_list", r37);
    L121:
        b r38 = this.b.a;
        if (r38 == null) goto L124;
        r26 = r38.b();
    L124:
        if (r26 == null) goto L131;
        Iterator<Map.Entry<String, Object>> r39 = r26.entrySet().iterator();
    L127:
        if (r39.hasNext() == false) goto L132;
        Map.Entry<String, Object> r40 = r39.next();
        r0.replaceOrAppendParam(r40.getKey(), String.valueOf(r40.getValue()));
        goto L127
    L132:
        return;
    L131:
        return;
    L118:
        r37 = null;
        goto L119
    L112:
        r35 = null;
        goto L113
    L102:
        if (r33.length() <= 0) goto L104;
        r3 = true;
    L104:
        if (r3 == true) goto L107;
        r33 = null;
    L107:
        if (r33 == null) goto L109;
        r0.replaceOrAppendParam("promise_type", r33);
        goto L109
    L99:
        r33 = null;
        goto L100
    L92:
        r31 = null;
        goto L93
    L81:
        if (r29.length() <= 0) goto L83;
        boolean r41 = true;
    L84:
        if (r41 == true) goto L87;
        r29 = null;
    L87:
        if (r29 == null) goto L89;
        r0.replaceOrAppendParam("spell_group_id", r29);
        goto L89
    L83:
        r41 = false;
        goto L84
    L67:
        if (r27.length() <= 0) goto L69;
        boolean r42 = true;
    L70:
        if (r42 == true) goto L73;
        r27 = null;
    L73:
        if (r27 == null) goto L75;
        r23.put("installment", r27);
        goto L75
    L69:
        r42 = false;
        goto L70
    L64:
        r27 = null;
        goto L65
    }

    @Override // com.bytedance.android.shopping.sku.outer.business.buynow.a
    public final IOrderSchema a() {
        return this.a;
    }

    public h(String r3, c r4, PageFinder r5) {
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
