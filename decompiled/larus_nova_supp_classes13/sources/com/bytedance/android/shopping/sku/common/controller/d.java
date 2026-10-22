package com.bytedance.android.shopping.sku.common.controller;

import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.d1;
import com.bytedance.android.ec.core.utils.g0;
import com.bytedance.android.ec.core.utils.p0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.response.ProductSelectPoiInfo;
import com.bytedance.android.ec.model.sku.DefaultSelect;
import com.bytedance.android.ec.model.sku.SkuExtraData;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.model.sku.SkuPoiInfo;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import com.bytedance.android.shopping.sku.common.ability.SkuAbilityType;
import com.bytedance.android.shopping.sku.common.monitor.error.SkuErrorMonitorType;
import com.bytedance.android.shopping.sku.common.utils.SkuBuyNowPanelHeightHelper;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public final SkuParams a;
    public final boolean b;

    public final void a() {
        SkuRestoreState r0 = this.a.getSkuState();
        if (r0 == null) goto L5;
        String r1 = r0.getSelectedSkuId();
    L6:
        SkuRestoreState r2 = this.a.getSkuState();
        if (r2 == null) goto L9;
        Long r3 = Long.valueOf(r2.getProductCount());
    L10:
        if (r1 == null) goto L18;
        if (r3 == null) goto L18;
        long r11 = r3.longValue();
        SkuParams r13 = this.a;
        DefaultSelect r4 = r13.getDefaultSelect();
        if (r4 == null) goto L16;
        DefaultSelect r5 = DefaultSelect.copy$default(r4, null, null, r1, Long.valueOf(r11), false, false, 51, null);
        if (r5 == null) goto L16;
    L17:
        r13.setDefaultSelect(r5);
    L16:
        r5 = new DefaultSelect(null, null, r1, Long.valueOf(r11), false, false, 51, null);
    L18:
        boolean r6 = true;
        if (this.a.getSpecMode() != null) goto L34;
        SkuCommonBigPicCacheController.a r7 = SkuCommonBigPicCacheController.a;
        String r8 = this.a.getProductId();
        if (r8 != null) goto L23;
        r8 = "";
    L23:
        b r9 = SkuCommonBigPicCacheController.a(r8);
        SkuParams r10 = this.a;
        if (r9 != null) goto L26;
    L28:
        int r12 = 2;
    L29:
        r10.setSpecMode(r12);
        SkuParams r14 = this.a;
        if (r9 == null) goto L32;
        long r15 = r9.b;
    L33:
        r14.setSpecModeTime(Long.valueOf(r15 / ((long) 1000)));
        goto L34
    L32:
        r15 = 0;
        goto L33
    L26:
        if (r9.a != true) goto L28;
        r12 = 1;
    L34:
        this.a.setResumeTime(System.currentTimeMillis());
        String r16 = "1";
        if (this.a.getPoiInfo() != null) goto L73;
        ProductSelectPoiInfo r17 = d1.a;
        if (r17 != null) goto L42;
        SkuPoiInfo r18 = d1.b;
        if (r18 == null) goto L41;
        r17 = r18.getSelectedPoiInfo();
        goto L42
    L41:
        r17 = null;
    L42:
        SkuParams r19 = this.a;
        if (r17 == null) goto L71;
        SkuPoiInfo r20 = new SkuPoiInfo();
        r20.setSelectedPoiInfo(r17);
        SkuPoiInfo r21 = d1.b;
        if (r21 == null) goto L47;
        Long r22 = r21.getTotal();
    L48:
        r20.setTotal(r22);
        String r23 = r17.getPoiId();
        SkuPoiInfo r24 = d1.b;
        if (r24 == null) goto L51;
        String r25 = r24.getNavLink();
    L52:
        if (r25 != null) goto L54;
    L57:
        boolean r110 = true;
    L58:
        if (r110 == false) goto L60;
    L70:
        r20.setNavLink(r25);
    L72:
        r19.setPoiInfo(r20);
        goto L73
    L60:
        if (g0.a(ECAppInfoService.e.getApplicationContext()) == false) goto L62;
        String r111 = "1";
    L63:
        int r112 = p0.a;
        if (r25 != null) goto L66;
        r25 = "";
    L66:
        String r26 = p0.d(r25, "gpsOn", r111);
        if (r23 != null) goto L69;
        r23 = "";
    L69:
        r25 = p0.d(r26, "selectedShopId", r23);
        goto L70
    L62:
        r111 = "0";
        goto L63
    L54:
        if (StringsKt.isBlank(r25) == true) goto L57;
        r110 = false;
        goto L58
    L51:
        r25 = null;
        goto L52
    L47:
        r22 = null;
        goto L48
    L71:
        r20 = null;
    L73:
        SkuParams r27 = this.a;
        JSONObject r28 = z1.f(r27.getEntranceInfo());
        r28.putOpt("originId", this.a.getOriginId());
        r28.putOpt("originType", this.a.getOriginType());
        Unit r29 = Unit.INSTANCE;
        r27.setEntranceInfo(r28.toString());
        String r30 = "{}";
        Map r31 = MapsKt.toMutableMap(this.a.getEventParams());
        String r32 = this.a.getTransmissibleJson();
        if (r32 == null) goto L76;
        JSONObject r33 = z1.g(r32);
    L77:
        if (r33 == null) goto L88;
        Iterator<String> r34 = r33.keys();
        if (r34 == null) goto L88;
    L81:
        if (r34.hasNext() == false) goto L88;
        String r113 = r34.next();
        Object r114 = r33.opt(r113);
        if (r114 == null) goto L85;
        String r115 = r114.toString();
    L86:
        if (r115 == null) goto L81;
        r31.put(r113, r115);
        goto L81
    L85:
        r115 = null;
    L88:
        SkuExtraData r35 = this.a.getSkuExtraData();
        if (r35 == null) goto L93;
        String r36 = r35.getTransitionTrackerData();
        if (r36 == null) goto L93;
        JSONObject r37 = z1.g(r36);
    L94:
        if (r37 == null) goto L105;
        Iterator<String> r38 = r37.keys();
        if (r38 == null) goto L105;
    L98:
        if (r38.hasNext() == false) goto L105;
        String r116 = r38.next();
        Object r117 = r37.opt(r116);
        if (r117 == null) goto L102;
        String r118 = r117.toString();
    L103:
        if (r118 == null) goto L98;
        r31.put(r116, r118);
        goto L98
    L102:
        r118 = null;
    L105:
        SkuExtraData r39 = this.a.getSkuExtraData();
        if (r39 == null) goto L113;
        String r40 = r39.getTransitionTrackerData();
        if (r40 == null) goto L113;
        JSONObject r41 = z1.g(r40);
        if (r41 == null) goto L113;
        String r42 = r41.optString("module_label");
        if (r42 == null) goto L113;
    L119:
        CharSequence r119 = (CharSequence) r31.get("module_label");
        if (r119 != null) goto L122;
    L125:
        boolean r120 = true;
    L126:
        if (r120 == false) goto L259;
        r31.put("module_label", r42);
    L259:
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L133
        String r44 = this.a.getEntranceInfo();     // Catch: Throwable -> L133
        if (r44 != null) goto L131;
        r44 = "{}";
    L131:
        Object r45 = Result.constructor-impl(new JSONObject(r44));     // Catch: Throwable -> L133
    L136:
        if (Result.isFailure-impl(r45) == false) goto L138;
        r45 = null;
    L138:
        JSONObject r46 = (JSONObject) r45;
        if (r46 == null) goto L141;
        String r47 = r46.optString("search_params", "");
    L142:
        if (r47 != null) goto L144;
    L147:
        boolean r121 = true;
    L149:
        if ((!r121) == true) goto L152;
        r47 = null;
    L152:
        if (r47 != null) goto L156;
        r47 = this.a.getSearchParams();
        if (r47 != null) goto L156;
        r47 = (String) this.a.getEventParams().get("search_params");
    L156:
        CharSequence r122 = (CharSequence) r31.get("search_params");
        if (r122 != null) goto L159;
    L162:
        boolean r123 = true;
    L163:
        if (r123 == false) goto L165;
        r31.put("search_params", r47);
    L165:
        CharSequence r48 = (CharSequence) r31.get("sku_from");
        if (r48 != null) goto L168;
    L171:
        boolean r49 = true;
    L172:
        if (r49 == false) goto L257;
        String r50 = a2.d(this.a.getMethod());
        if (r50 != null) goto L176;
        r50 = BuyNowCloseMethod.OTHERS;
    L176:
        r31.put("sku_from", r50);
    L257:
        String r51 = this.a.getEntranceInfo();     // Catch: Throwable -> L183
        if (r51 == null) goto L181;
        r30 = r51;
    L181:
        Object r52 = Result.constructor-impl(new JSONObject(r30));     // Catch: Throwable -> L183
    L186:
        if (Result.isFailure-impl(r52) == false) goto L188;
        r52 = null;
    L188:
        JSONObject r53 = (JSONObject) r52;
        CharSequence r54 = (CharSequence) r31.get("previous_page");
        if (r54 != null) goto L191;
    L194:
        boolean r55 = true;
    L195:
        if (r55 == false) goto L201;
        if (r53 == null) goto L198;
        String r56 = r53.optString("previous_page", "");
    L199:
        r31.put("previous_page", r56);
        goto L201
    L198:
        r56 = null;
    L201:
        if (this.a.isFromMatchPurchase() == true) goto L204;
        r16 = "0";
    L204:
        CharSequence r57 = (CharSequence) r31.get("is_matching_product");
        if (r57 != null) goto L207;
    L210:
        boolean r58 = true;
    L211:
        if (r58 == false) goto L213;
        r31.put("is_matching_product", r16);
    L213:
        CharSequence r59 = (CharSequence) r31.get("combination_id");
        if (r59 != null) goto L216;
    L219:
        boolean r60 = true;
    L220:
        if (r60 == false) goto L222;
        r31.put("combination_id", this.a.getCombinationId());
    L222:
        CharSequence r61 = (CharSequence) r31.get(PdpOpenThirdParam.KEY_PAGE_NAME);
        if (r61 != null) goto L225;
    L228:
        boolean r62 = true;
    L229:
        if (r62 == true) goto L231;
    L235:
        this.a.setEventParams(r31);
        SkuParams r63 = this.a;
        Lazy r64 = SkuBuyNowPanelHeightHelper.a;
        r63.setHeightPercent(Integer.valueOf(SkuBuyNowPanelHeightHelper.a(String.valueOf(r63.getSceneType()), this.a.getHeightPercent())));
        Map<String, mh3.a> r65 = mh3.a.m;
        mh3.a r66 = mh3.a.C0219a.c(this.a.getMonitorId());
        if (r66 == null) goto L271;
        com.bytedance.android.shopping.sku.common.monitor.error.a r67 = r66.c;
        if (r67 != null) goto L241;
        return;
    L241:
        if (StringsKt.isBlank(this.a.getPromotionId()) == false) goto L244;
        SkuErrorMonitorType r68 = SkuErrorMonitorType.SERIOUS_BUSINESS_ERROR;
        Map<String, com.bytedance.android.shopping.sku.common.monitor.error.a> r69 = com.bytedance.android.shopping.sku.common.monitor.error.a.b;
        r67.a(r68, "promotionId is null", null);
    L244:
        if (StringsKt.isBlank(this.a.getProcessMonitorRdTag()) == false) goto L246;
        SkuErrorMonitorType r70 = SkuErrorMonitorType.MINOR_BUSINESS_ERROR;
        Map<String, com.bytedance.android.shopping.sku.common.monitor.error.a> r71 = com.bytedance.android.shopping.sku.common.monitor.error.a.b;
        r67.a(r70, "processMonitorRdTag is null", null);
    L246:
        String r72 = this.a.getProductId();
        if (r72 != null) goto L249;
    L252:
        if (r6 == true) goto L254;
        return;
    L254:
        if (this.b == true) goto L273;
        SkuErrorMonitorType r73 = SkuErrorMonitorType.SERIOUS_BUSINESS_ERROR;
        Map<String, com.bytedance.android.shopping.sku.common.monitor.error.a> r74 = com.bytedance.android.shopping.sku.common.monitor.error.a.b;
        r67.a(r73, "productId is null", null);
        return;
    L273:
        return;
    L249:
        if (StringsKt.isBlank(r72) == true) goto L252;
        r6 = false;
        goto L252
    L271:
        return;
    L231:
        if (this.a.isFromAnchorV3() == false) goto L233;
        String r75 = "product_detail";
    L234:
        r31.put(PdpOpenThirdParam.KEY_PAGE_NAME, r75);
        goto L235
    L233:
        r75 = "live_room_sku";
        goto L234
    L225:
        if (StringsKt.isBlank(r61) == true) goto L228;
        r62 = false;
        goto L229
    L216:
        if (StringsKt.isBlank(r59) == true) goto L219;
        r60 = false;
        goto L220
    L207:
        if (StringsKt.isBlank(r57) == true) goto L210;
        r58 = false;
        goto L211
    L191:
        if (StringsKt.isBlank(r54) == true) goto L194;
        r55 = false;
    L183:
        th = move-exception;
        Result.Companion r76 = Result.Companion;
        r52 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L186
    L168:
        if (StringsKt.isBlank(r48) == true) goto L171;
        r49 = false;
        goto L172
    L159:
        if (StringsKt.isBlank(r122) == true) goto L162;
        r123 = false;
        goto L163
    L144:
        if (StringsKt.isBlank(r47) == true) goto L147;
        r121 = false;
        goto L149
    L141:
        r47 = null;
    L133:
        th = move-exception;
        Result.Companion r77 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L136
    L122:
        if (StringsKt.isBlank(r119) == true) goto L125;
        r120 = false;
    L113:
        String r78 = this.a.getEntranceInfo();
        if (r78 == null) goto L118;
        JSONObject r79 = z1.g(r78);
        if (r79 == null) goto L118;
        r42 = r79.optString("module_label");
    L118:
        r42 = null;
    L93:
        r37 = null;
        goto L94
    L76:
        r33 = null;
        goto L77
    L9:
        r3 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public d(SkuAbilityType r2, SkuParams r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "skuBuyNowType");
        Intrinsics.checkNotNullParameter(r3, "skuParams");
        this.a = r3;
        this.b = r4;
    }
}
