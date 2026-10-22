package com.bytedance.android.shopping.sku.outer.business.buynow;

import android.text.TextUtils;
import com.bytedance.android.ec.common.api.entranceinfo.IEntranceInfoService;
import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.p0;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.utils.p;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g {
    public final c a;

    public g(c r2) {
        Intrinsics.checkNotNullParameter(r2, "buyNowData");
        this.a = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String a(String r24) {
        Intrinsics.checkNotNullParameter(r24, "orderUrl");
        int r3 = p0.a;
        String r1 = p0.g(p0.g(r24, "combo_id", this.a.b()), "combo_num", String.valueOf(this.a.c()));
        b r4 = this.a.a;
        if (r4 == null) goto L5;
        String r5 = r4.i();
    L6:
        if (r5 != null) goto L8;
    L16:
        Map<String, String> r6 = this.a.d();
        b r7 = this.a.a;
        if (r7 == null) goto L19;
        String r8 = r7.e();
    L20:
        String r9 = "";
        if (r8 != null) goto L23;
        r8 = "";
    L23:
        LinkedHashMap r10 = new LinkedHashMap();
        if (TextUtils.isEmpty(r8) == true) goto L27;
        r10.put("installment", r8);
    L27:
        if (BuyNowPerformanceOpt.j() == true) goto L32;
        r10.put("biometric_params", "1");
        int r11 = p.a;
        r10.put("is_jailbreak", "2");
        String r12 = p.b();
        if (r12 != null) goto L31;
        r12 = "";
    L31:
        r10.put("cj_sdk", r12);
        r10.put("bio_type", "1");
    L32:
        String r2 = wh3.b.b(r1, "cj_info", r10);
        Map r13 = MapsKt.toMutableMap(this.a.b.getLiveEventParams());
        String r14 = r6.get("screen_type");
        if (r14 != null) goto L35;
        r14 = "";
    L35:
        r13.put("screen_type", r14);
        String r15 = r6.get("is_groupbuying");
        if (r15 != null) goto L38;
        r15 = "";
    L38:
        r13.put("is_groupbuying", r15);
        String r16 = r6.get("is_explain_apply");
        if (r16 != null) goto L41;
        r16 = "0";
    L41:
        r13.put("is_explain_apply", r16);
        String r17 = r6.get("base_verified_category");
        if (r17 != null) goto L44;
        r17 = "";
    L44:
        r13.put("base_verified_category", r17);
        String r18 = r6.get("upfront_presell");
        if (r18 != null) goto L47;
        r18 = "";
    L47:
        r13.put("upfront_presell", r18);
        String r19 = r6.get("is_crossborder_goods");
        if (r19 != null) goto L50;
        String r20 = "";
    L51:
        r13.put("is_crossborder_goods", r20);
        String r110 = r6.get("label_name");
        if (r110 != null) goto L54;
        r110 = "";
    L54:
        r13.put("label_name", r110);
        String r111 = r6.get("label_name_live");
        if (r111 != null) goto L57;
        String r21 = "";
    L58:
        r13.put("label_name_live", r21);
        String r112 = r6.get("tab_name");
        if (r112 != null) goto L61;
        String r22 = "";
    L62:
        r13.put("tab_name", r22);
        String r113 = r6.get("with_sku");
        if (r113 == null) goto L66;
        r9 = r113;
    L66:
        r13.put("with_sku", r9);
        String r23 = r6.get("is_explaining");
        if (r23 != null) goto L69;
        r23 = "";
    L69:
        r13.put("is_explaining", r23);
        r13.put("page_init_timestamp", String.valueOf(System.currentTimeMillis()));
        r13.put(SimilarProductParam.ENTER_FROM, "live");
        String r25 = r6.get("new_source_type");
        if (r25 != null) goto L72;
        String r26 = "";
    L73:
        r13.put("new_source_type", r26);
        if (this.a.b.isFromPlayback() == false) goto L76;
        r13.put("product_detail_reply", "1");
    L76:
        String r27 = r6.get("card_status");
        if (r27 != null) goto L79;
        r27 = "";
    L79:
        r13.put("card_status", r27);
        b(r13);
        String r28 = wh3.b.b(r2, "log_data", r13);
        String r114 = this.a.b.getSpellGroupId();
        if (r114 != null) goto L82;
    L85:
        boolean r115 = true;
    L86:
        if (r115 == true) goto L89;
        r28 = wh3.b.a(r28, "spell_group_id", this.a.b.getSpellGroupId());
    L89:
        b r29 = this.a.a;
        if (r29 == null) goto L92;
        String r30 = r29.g();
    L93:
        if (r30 != null) goto L95;
        r30 = "";
    L95:
        String r31 = p0.d(r28, "poi_id", r30);
        Map r32 = new LinkedHashMap();
        String r116 = r6.get("is_groupbuying");
        if (r116 != null) goto L98;
        r116 = "";
    L98:
        r32.put("is_groupbuying", r116);
        String r33 = this.a.d().get("is_explain_apply");
        if (r33 != null) goto L101;
        r33 = "0";
    L101:
        r32.put("is_explain_apply", r33);
        String r34 = r6.get("label_name");
        if (r34 != null) goto L104;
        r34 = "";
    L104:
        r32.put("label_name", r34);
        String r35 = r6.get("label_name_live");
        if (r35 != null) goto L107;
        r35 = "";
    L107:
        r32.put("label_name_live", r35);
        r32.put(SimilarProductParam.ENTER_FROM, "live");
        String r36 = r6.get("ecom_group_type");
        if (r36 != null) goto L110;
        r36 = "";
    L110:
        r32.put("ecom_group_type", r36);
        String r37 = r6.get("upfront_presell");
        if (r37 != null) goto L113;
        r37 = "";
    L113:
        r32.put("upfront_presell", r37);
        String r38 = r6.get("base_verified_category");
        if (r38 != null) goto L116;
        r38 = "";
    L116:
        r32.put("base_verified_category", r38);
        String r39 = r6.get("tab_name");
        if (r39 != null) goto L119;
        r39 = "";
    L119:
        r32.put("tab_name", r39);
        String r40 = r6.get(PdpOpenThirdParam.KEY_PAGE_NAME);
        if (r40 != null) goto L122;
        r40 = "";
    L122:
        r32.put(PdpOpenThirdParam.KEY_PAGE_NAME, r40);
        String r41 = r6.get("is_explaining");
        if (r41 != null) goto L125;
        r41 = "";
    L125:
        r32.put("is_explaining", r41);
        String r42 = r6.get("card_status");
        if (r42 != null) goto L128;
        r42 = "";
    L128:
        r32.put("card_status", r42);
        String r43 = r6.get("source_3d");
        if (r43 != null) goto L131;
        r43 = "";
    L131:
        r32.put("source_3d", r43);
        r32.put("commodity_id", this.a.g());
        String r44 = this.a.b.getCommodityType();
        if (r44 != null) goto L134;
        r44 = "";
    L134:
        r32.put("commodity_type", r44);
        String r45 = this.a.f();
        if (r45 != null) goto L137;
        r45 = "";
    L137:
        r32.put(PdpOpenThirdParam.KEY_PRODUCT_ID, r45);
        b(r32);
        Map r46 = EcomBcmTracker.f(null, r32);
        if (r46 == null) goto L143;
        Iterator r47 = r46.entrySet().iterator();
    L141:
        if (r47.hasNext() == false) goto L143;
        Map.Entry r48 = (Map.Entry) r47.next();
        r32.put(r48.getKey(), String.valueOf(r48.getValue()));
    L143:
        int r49 = ECSdk.a;
        IEntranceInfoService r50 = (IEntranceInfoService) ECSdk.a(IEntranceInfoService.class);
        if (r50 == null) goto L146;
        Map<String, Object> r51 = null;
        gl.a r52 = r50.initEntranceInfo(new EntranceInfoScene("sku", "orderUrl"), null);
    L147:
        if (r52 == null) goto L149;
        r52.putAll(r32);
    L149:
        if (r52 == null) goto L153;
        String r53 = r52.h();
        if (r53 == null) goto L153;
        Map<String, Object> r54 = k.z(r53);
    L155:
        if (TypeIntrinsics.isMutableMap(r54) == true) goto L157;
        r54 = r51;
    L157:
        if (r54 == null) goto L160;
        r32 = r54;
    L160:
        String r55 = wh3.b.b(r31, "entrance_info", r32);
        String r56 = this.a.b.getSkuLogExtra();
        if (r56 != 0) goto L163;
    L171:
        String r57 = wh3.b.c(r55, "page_init_timestamp", String.valueOf(System.currentTimeMillis()));
        String r58 = r6.get(PdpOpenThirdParam.KEY_PAGE_NAME);
        if (r58 != null) goto L174;
        r58 = "";
    L174:
        r13.put(PdpOpenThirdParam.KEY_PAGE_NAME, r58);
        String r59 = p0.d(r57, "iesec_auto_coupon_opt_ab", "1");
        b r60 = this.a.a;
        if (r60 == null) goto L177;
        String r61 = r60.c();
    L178:
        if (r61 == 0) goto L180;
        r59 = p0.d(r59, "custom_property_list", r61);
    L180:
        b r62 = this.a.a;
        if (r62 == null) goto L183;
        String r63 = r62.d();
    L184:
        if (r63 == 0) goto L186;
        r59 = p0.d(r59, "sale_package_list", r63);
    L186:
        b r64 = this.a.a;
        if (r64 == null) goto L189;
        Map<String, Object> r65 = r64.b();
    L190:
        if (r65 == null) goto L195;
        Iterator<Map.Entry<String, Object>> r66 = r65.entrySet().iterator();
    L193:
        if (r66.hasNext() == false) goto L195;
        Map.Entry<String, Object> r67 = r66.next();
        int r68 = p0.a;
        r59 = p0.d(r59, r67.getKey(), String.valueOf(r67.getValue()));
    L195:
        return r59;
    L189:
        r65 = r51;
        goto L190
    L183:
        r63 = r51;
        goto L184
    L177:
        r61 = r51;
        goto L178
    L163:
        if (r56.length() <= 0) goto L165;
        boolean r69 = true;
    L166:
        if (r69 == true) goto L169;
        r56 = r51;
    L169:
        if (r56 == 0) goto L171;
        JSONObject r70 = new JSONObject(r56);
        r55 = wh3.b.b(r55, "log_data", MapsKt.mapOf(new Pair[]{new Pair("fxh_white_list_flag", r70.optString("fxh_white_list_flag")), new Pair("user_open_fxh_flag", r70.optString("user_open_fxh_flag")), new Pair("bind_card_flag", r70.optString("bind_card_flag")), new Pair("shop_open_fxh_flag", r70.optString("shop_open_fxh_flag"))}));
        goto L171
    L165:
        r69 = false;
    L153:
        r54 = r51;
        goto L155
    L146:
        r51 = null;
        r52 = null;
        goto L147
    L92:
        r30 = null;
        goto L93
    L82:
        if (r114.length() == 0) goto L85;
        r115 = false;
        goto L86
    L72:
        r26 = r25;
        goto L73
    L61:
        r22 = r112;
        goto L62
    L57:
        r21 = r111;
        goto L58
    L50:
        r20 = r19;
        goto L51
    L19:
        r8 = null;
        goto L20
    L8:
        if (r5.length() <= 0) goto L10;
        boolean r71 = true;
    L11:
        if (r71 == true) goto L14;
        r5 = null;
    L14:
        if (r5 == null) goto L16;
        r1 = p0.g(r1, "promise_type", r5);
        goto L16
    L10:
        r71 = false;
        goto L11
    L5:
        r5 = null;
        goto L6
    }

    public final void b(Map<String, String> r5) {
        String r0 = this.a.b.getTransmissibleJson();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L25;
        JSONObject r2 = new JSONObject(r0);     // Catch: Exception -> L17
        Iterator<String> r3 = r2.keys();     // Catch: Exception -> L17
    L14:
        if (r3.hasNext() == false) goto L26;
        String r4 = r3.next();     // Catch: Exception -> L17
        r5.put(r4, r2.optString(r4));     // Catch: Exception -> L17
        goto L14
    L26:
        return;
    L17:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L25:
        return;
    L7:
        r1 = false;
        goto L8
    }
}
