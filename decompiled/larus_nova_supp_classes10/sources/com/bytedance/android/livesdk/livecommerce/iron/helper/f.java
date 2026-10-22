package com.bytedance.android.livesdk.livecommerce.iron.helper;

import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.common.api.IECCommonService;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.common.impl.order.OrderSchema;
import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.ec.core.utils.UrlBuilderV2;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.ec.model.promotion.ECUIAskExplainInfo;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.event.ECEventUtilsV2;
import com.bytedance.android.livesdk.livecommerce.model.ECUISkuInfo;
import com.bytedance.android.livesdk.livecommerce.utils.EnumEntranceInfoScene;
import com.bytedance.android.livesdk.livecommerce.utils.LiveSettingKeys;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    public f() {
    }

    static {
    }

    public static void a(IOrderSchema r21, String r22, com.bytedance.android.ec.common.api.jump.model.g r23, com.bytedance.android.livesdk.livecommerce.promotion.card.d r24) {
        Intrinsics.checkNotNullParameter(r22, "sessionId");
        Intrinsics.checkNotNullParameter(r23, "promotionParams");
        Intrinsics.checkNotNullParameter(r24, "promotionSimpleSku");
        if (r21 != null) goto L5;
        return;
    L5:
        ql.a r4 = r23.a;
        LiveRoomParams r5 = r23.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        com.bytedance.android.ec.common.api.jump.model.f r6 = r23.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        if (r5 == null) goto L10;
        String r7 = r5.getGroupId();
        if (r7 == null) goto L10;
        r21.replaceOrAppendParam("sku_item_id", r7);
    L10:
        String r8 = PromotionDetailSchemaHelper.b(PromotionDetailSchemaHelper.a, r23, "blank");
        r21.replaceOrAppendParam("detail_url", r8);
        r21.replaceOrAppendParam("sku_session_id", r22);
        Pair<String[], Long> r0 = r24.a(r4.getPromotionId());
        String r3 = "";
        if (r0 == null) goto L18;
        String r9 = com.bytedance.android.shopping.extensions.k.x(r0.getFirst());
        if (r9 != null) goto L15;
        r9 = "";
    L15:
        r21.replaceOrAppendParam("default_spec_id", r9);
        r21.replaceOrAppendParam("combo_num", String.valueOf(((Number) r0.getSecond()).longValue()));
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_DISABLE_SKU_NUM() == true) goto L18;
        r21.replaceOrAppendParam("sku_num", String.valueOf(((Number) r0.getSecond()).longValue()));
    L18:
        Boolean r1 = BuyNowPerformanceOpt.a;
        Lazy r2 = ECAppInfoService.a;
        if (ECAppInfoService.h() == false) goto L25;
        Map r10 = BuyNowPerformanceOpt.g();
        if (r10 == null) goto L23;
        Object r11 = r10.get("iesec_live_enable_pass_through_deprecated");
    L24:
        boolean r12 = Intrinsics.areEqual(r11, 1);
    L198:
        if (r12 == false) goto L258;
        JSONObject r13 = r23.getAddToCartEntranceInfo();
        OrderSchema.b r14 = r21.P();
        if (r14 == null) goto L216;
        Pair[] r15 = new Pair[7];
        if (r5 == null) goto L207;
        String r16 = r5.getEnterFromMerge();
        if (r16 == null) goto L207;
        String r17 = a2.d(r16);
        if (r17 == null) goto L207;
    L208:
        r15[0] = TuplesKt.to("carrier_source", r17);
        if (r5 == null) goto L214;
        String r18 = r5.getEcomSceneId();
        if (r18 == null) goto L214;
        String r19 = a2.d(r18);
        if (r19 == null) goto L214;
    L215:
        r15[1] = TuplesKt.to("ecom_scene_id", r19);
        r15[2] = TuplesKt.to("creative_id", r13.optString("creative_id"));
        r15[3] = TuplesKt.to("enter_from", r13.optString("enter_from"));
        r15[4] = TuplesKt.to("is_package_sale", r13.optString("is_package_sale"));
        r15[5] = TuplesKt.to("market_channel_hot_fix", r13.optString("market_channel_hot_fix"));
        r15[6] = TuplesKt.to("previous_page", r13.optString("previous_page"));
        r14.b(r15, OrderSchemaHelper$appendSkuParamsWithoutPassThrough$1.INSTANCE);
    L214:
        r19 = r13.optString("ecom_scene_id");
    L207:
        r17 = r13.optString("carrier_source");
    L216:
        JSONObject r20 = r21.u0();
        if (r20 == null) goto L363;
        if (r5 == null) goto L222;
        JSONObject r25 = r5.getPassThroughLogData();
        if (r25 == null) goto L222;
        z1.b(r20, r25);
    L222:
        z1.b(r20, r4.getTransmissibleJson());
        if (r5 == null) goto L225;
        String r26 = r5.getEcomSceneId();
    L226:
        if (r26 != null) goto L228;
        r26 = "";
    L228:
        r20.put("ecom_scene_id", r26);
        if (r5 == null) goto L231;
        String r27 = r5.getAuthorId();
    L232:
        if (r27 != null) goto L234;
        r27 = "";
    L234:
        r20.put("anchor_id", r27);
        if (r5 == null) goto L237;
        String r28 = r5.getRoomId();
    L238:
        if (r28 == null) goto L241;
        r3 = r28;
    L241:
        r20.put("room_id", r3);
        int r29 = e.a;
        if (r5 == null) goto L248;
        Function0 r30 = r5.getRoomType();
        if (r30 == null) goto L248;
        Integer r31 = (Integer) r30.invoke();
        if (r31 == null) goto L248;
        int r110 = r31.intValue();
        String r32 = null;
    L249:
        Iterator r33 = ((LinkedHashMap) e.a(com.bytedance.android.livesdk.livecommerce.utils.k.f(r4, r32, r110), r23, 2)).entrySet().iterator();
    L251:
        if (r33.hasNext() == false) goto L253;
        Map.Entry r34 = (Map.Entry) r33.next();
        r20.put((String) r34.getKey(), r34.getValue());
        goto L251
    L253:
        if (r5 == null) goto L364;
        String r35 = r5.getSearchParams();
        if (r35 == null) goto L365;
        r20.put("search_params", r35);
        return;
    L365:
        return;
    L364:
        return;
    L248:
        r32 = null;
        r110 = -1;
        goto L249
    L237:
        r28 = null;
        goto L238
    L231:
        r27 = null;
        goto L232
    L225:
        r26 = null;
        goto L226
    L363:
        return;
    L258:
        JSONObject r36 = z1.f(r4.getTrackExtra());
        String r37 = r36.optString("cart_track");
        if (r37.length() <= 0) goto L261;
        boolean r111 = true;
    L262:
        if (r111 == false) goto L264;
        JSONObject r38 = new JSONObject(r37);
    L265:
        JSONObject r39 = r23.getAddToCartEntranceInfo();
        r39.put("product_id", r4.getProductId());
        Iterator<String> r112 = r39.keys();
    L267:
        if (r112.hasNext() == false) goto L269;
        String r113 = r112.next();
        Iterator<String> r210 = r112;
        r38.put(r113, r39.optString(r113));
        r112 = r210;
        goto L267
    L269:
        r36.put("cart_track", r38);
        r21.k0("api.add.extra", r36.toString(), 1);
        JSONObject r40 = new JSONObject();
        if (r5 == null) goto L274;
        JSONObject r41 = r5.getPassThroughLogData();
        if (r41 == null) goto L274;
        z1.b(r40, r41);
    L274:
        z1.b(r40, r4.getTransmissibleJson());
        if (r5 == null) goto L277;
        String r42 = r5.getEcomSceneId();
    L278:
        if (r42 != null) goto L280;
        r42 = "";
    L280:
        r40.put("ecom_scene_id", r42);
        if (r5 == null) goto L283;
        String r43 = r5.getAuthorId();
    L284:
        if (r43 != null) goto L286;
        r43 = r3;
    L286:
        r40.put("anchor_id", r43);
        if (r5 == null) goto L289;
        String r44 = r5.getRoomId();
    L290:
        if (r44 != null) goto L292;
        r44 = r3;
    L292:
        r40.put("room_id", r44);
        if (r5 == null) goto L299;
        Function0 r45 = r5.getRoomType();
        if (r45 == null) goto L299;
        Integer r46 = (Integer) r45.invoke();
        if (r46 == null) goto L299;
        int r114 = r46.intValue();
    L300:
        ECUISkuInfo r47 = com.bytedance.android.livesdk.livecommerce.utils.k.f(r4, r8, r114);
        if (r5 == null) goto L303;
        String r48 = r5.getRoomId();
    L304:
        r47.k = r48;
        if (r5 == null) goto L307;
        String r49 = r5.getAuthorId();
    L308:
        r47.l = r49;
        if (r5 == null) goto L311;
        String r50 = r5.getSecAuthorId();
    L312:
        r47.n = r50;
        if (r5 == null) goto L315;
        String r51 = r5.getGroupId();
    L316:
        r47.m = r51;
        if (r6 == null) goto L321;
        jf.b r52 = r6.c;
        if (r52 == null) goto L321;
        String r53 = r52.a;
    L322:
        r47.p = r53;
        Map r54 = e.a(r47, r23, 2);
        if (r5 == null) goto L327;
        String r55 = r5.getSearchParams();
        if (r55 == null) goto L327;
        r54.put("search_params", r55);
    L327:
        LinkedHashMap r56 = new LinkedHashMap();
        r56.putAll(z1.j(r40));
        r56.putAll(r54);
        String r57 = com.bytedance.android.shopping.extensions.k.x(r56);
        if (r57 == null) goto L330;
        r21.k0("track.client", r57, 0);
    L330:
        JSONObject r58 = r23.getEntranceInfo();
        com.bytedance.android.livesdk.livecommerce.room.controller.related.b.a(r58, z1.f((String) ((LinkedHashMap) r54).get("entrance_info")), false);
        com.bytedance.android.livesdk.livecommerce.room.controller.related.b.a(r58, r40, false);
        if (r5 == null) goto L333;
        String r59 = r5.getEnterFromMerge();
    L334:
        r58.put("carrier_source", r59);
        if (r5 == null) goto L337;
        String r60 = r5.getEnterMethod();
    L338:
        r58.put("source_method", r60);
        String r61 = r4.getEcomGroupType();
        if (r61 != null) goto L341;
        r61 = "live";
    L341:
        r58.put("ecom_group_type", r61);
        r21.v1(CollectionsKt.listOf(new String[]{"track.client.entrance_info", "api.sku.entrance_info"}), r58.toString());
        JSONObject r62 = new JSONObject();
        r62.put("_param_live_platform", "live");
        if (r5 == null) goto L344;
        String r115 = r5.getFollowStatus();
    L345:
        r62.put("follow_status", r115);
        r62.put("entrance_info", r23.getEntranceInfo().toString());
        r62.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        r62.put("enter_from", "live");
        Unit r63 = Unit.INSTANCE;
        r21.k0("url.coupon.log_data", r62.toString(), 0);
        return;
    L344:
        r115 = null;
        goto L345
    L337:
        r60 = null;
        goto L338
    L333:
        r59 = null;
    L321:
        r53 = null;
        goto L322
    L315:
        r51 = null;
        goto L316
    L311:
        r50 = null;
        goto L312
    L307:
        r49 = null;
        goto L308
    L303:
        r48 = null;
    L299:
        r114 = -1;
        goto L300
    L289:
        r44 = null;
        goto L290
    L283:
        r43 = null;
        goto L284
    L277:
        r42 = null;
        goto L278
    L264:
        r38 = new JSONObject();
        goto L265
    L261:
        r111 = false;
        goto L262
    L23:
        r11 = null;
        goto L24
    L25:
        com.bytedance.android.ec.core.abtest.d r64 = com.bytedance.android.ec.core.abtest.d.a;
        int r65 = com.bytedance.android.ec.core.abtest.j.a;
        Object r116 = 0;
        int r66 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r67 = Result.Companion;     // Catch: Throwable -> L184
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L184
        SDKSettingsCacheManager r117 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L184
        r117.getClass();     // Catch: Throwable -> L76
        Object r68 = SDKSettingsCacheManager.b.get("iesec_live_enable_pass_through_deprecated");     // Catch: Throwable -> L76
        if (r68 != null) goto L31;
    L73:
        Object r118 = null;
    L74:
        Object r69 = Result.constructor-impl(r118);     // Catch: Throwable -> L76
    L78:
        Throwable r119 = Result.exceptionOrNull-impl(r69);     // Catch: Throwable -> L184
        if (r119 == null) goto L82;
        EnsureManager.ensureNotReachHere(r119);     // Catch: Throwable -> L184
    L82:
        if (Result.isFailure-impl(r69) == false) goto L85;
        r69 = null;
    L85:
        if ((r69 instanceof Integer) == true) goto L87;
        r69 = null;
    L87:
        Object r70 = (Integer) r69;     // Catch: Throwable -> L184
        if (r70 != null) goto L94;
        r117.getClass();     // Catch: Throwable -> L184
        Object r71 = SDKSettingsCacheManager.a.get("iesec_live_enable_pass_through_deprecated");     // Catch: Throwable -> L184
        if ((r71 instanceof Integer) == true) goto L93;
        r71 = null;
    L93:
        r70 = (Integer) r71;     // Catch: Throwable -> L184
    L94:
        if (r70 != null) goto L194;
        int r72 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L184
    L172:
        th = move-exception;
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L184
        r70 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L184
    L175:
        if (Result.exceptionOrNull-impl(r70) != null) goto L349;
    L182:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L184
        SDKSettingsCacheManager.e("iesec_live_enable_pass_through_deprecated", r70);     // Catch: Throwable -> L184
        goto L194
    L349:
        r70 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_live_enable_pass_through_deprecated", Integer.class, r116);     // Catch: Throwable -> L179
    L180:
        if (r70 != null) goto L182;
        r70 = r116;
    L179:
        r70 = r116;
        goto L180
    L355:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L147
        Object r73 = SDKSettingsCacheManager.b.get("iesec_live_enable_pass_through_deprecated");     // Catch: Throwable -> L147
        if (r73 != null) goto L102;
    L144:
        Object r121 = null;
    L145:
        Object r74 = Result.constructor-impl(r121);     // Catch: Throwable -> L147
    L149:
        Throwable r122 = Result.exceptionOrNull-impl(r74);     // Catch: Throwable -> L172
        if (r122 == null) goto L153;
        EnsureManager.ensureNotReachHere(r122);     // Catch: Throwable -> L172
    L153:
        if (Result.isFailure-impl(r74) == false) goto L156;
        r74 = null;
    L156:
        if ((r74 instanceof Integer) == true) goto L158;
        r74 = null;
    L158:
        r70 = (Integer) r74;     // Catch: Throwable -> L172
        if (r70 != null) goto L182;
        jj4.b r75 = jj4.b.b;     // Catch: Throwable -> L172
        Object r76 = jj4.a.a("iesec_live_enable_pass_through_deprecated", Integer.class, r116, false);     // Catch: Throwable -> L172
        if (r76 != null) goto L165;
        Intrinsics.throwNpe();     // Catch: Throwable -> L172
    L165:
        if ((r76 instanceof Integer) == true) goto L167;
        r76 = null;
    L167:
        Object r77 = (Integer) r76;     // Catch: Throwable -> L172
        if (r77 != null) goto L170;
        r77 = r116;
    L170:
        r70 = Result.constructor-impl(r77);     // Catch: Throwable -> L172
    L102:
        if ((r73 instanceof Integer) == true) goto L104;
        Object r123 = null;
    L105:
        r121 = (Integer) r123;     // Catch: Throwable -> L147
        if (r121 != null) goto L145;
        if ((r73 instanceof Number) == false) goto L132;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L117;
        Float r78 = Float.valueOf(((Number) r73).floatValue());     // Catch: Throwable -> L147
        if ((r78 instanceof Integer) == true) goto L115;
        r78 = null;
    L115:
        r121 = (Integer) r78;     // Catch: Throwable -> L147
        goto L145
    L117:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L123;
        Double r79 = Double.valueOf(((Number) r73).doubleValue());     // Catch: Throwable -> L147
        if ((r79 instanceof Integer) == true) goto L121;
        r79 = null;
    L121:
        r121 = (Integer) r79;     // Catch: Throwable -> L147
        goto L145
    L123:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L126;
        r121 = Integer.valueOf(((Number) r73).intValue());     // Catch: Throwable -> L147
        goto L145
    L126:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L132;
        Long r80 = Long.valueOf(((Number) r73).longValue());     // Catch: Throwable -> L147
        if ((r80 instanceof Integer) == true) goto L130;
        r80 = null;
    L130:
        r121 = (Integer) r80;     // Catch: Throwable -> L147
    L132:
        if ((r73 instanceof JSONObject) == false) goto L134;
    L351:
        Object r81 = SDKSettingsCacheManager.a().fromJson(r73.toString(), Integer.class);     // Catch: Throwable -> L140
        if ((r81 instanceof Integer) == true) goto L138;
        r81 = null;
    L138:
        Object r82 = Result.constructor-impl((Integer) r81);     // Catch: Throwable -> L140
    L142:
        r121 = r82;
        if (Result.isFailure-impl(r121) == false) goto L145;
    L140:
        th = move-exception;
        Result.Companion r124 = Result.Companion;     // Catch: Throwable -> L147
        r82 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L147
        goto L142
    L134:
        if ((r73 instanceof JSONArray) == false) goto L144;
    L104:
        r123 = r73;
    L147:
        th = move-exception;
        Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L172
        r74 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L194:
        if (((Number) r70).intValue() != 1) goto L196;
        r12 = true;
        goto L198
    L196:
        r12 = false;
        goto L198
    L31:
        if ((r68 instanceof Integer) == true) goto L33;
        Object r126 = null;
    L34:
        r118 = (Integer) r126;     // Catch: Throwable -> L76
        if (r118 != null) goto L74;
        if ((r68 instanceof Number) == false) goto L61;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L46;
        Float r83 = Float.valueOf(((Number) r68).floatValue());     // Catch: Throwable -> L76
        if ((r83 instanceof Integer) == true) goto L44;
        r83 = null;
    L44:
        r118 = (Integer) r83;     // Catch: Throwable -> L76
        goto L74
    L46:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L52;
        Double r85 = Double.valueOf(((Number) r68).doubleValue());     // Catch: Throwable -> L76
        if ((r85 instanceof Integer) == true) goto L50;
        r85 = null;
    L50:
        r118 = (Integer) r85;     // Catch: Throwable -> L76
        goto L74
    L52:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L55;
        r118 = Integer.valueOf(((Number) r68).intValue());     // Catch: Throwable -> L76
        goto L74
    L55:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L61;
        Long r86 = Long.valueOf(((Number) r68).longValue());     // Catch: Throwable -> L76
        if ((r86 instanceof Integer) == true) goto L59;
        r86 = null;
    L59:
        r118 = (Integer) r86;     // Catch: Throwable -> L76
    L61:
        if ((r68 instanceof JSONObject) == false) goto L63;
    L347:
        Object r87 = SDKSettingsCacheManager.a().fromJson(r68.toString(), Integer.class);     // Catch: Throwable -> L69
        if ((r87 instanceof Integer) == true) goto L67;
        r87 = null;
    L67:
        Object r88 = Result.constructor-impl((Integer) r87);     // Catch: Throwable -> L69
    L71:
        r118 = r88;
        if (Result.isFailure-impl(r118) == false) goto L74;
    L69:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L76
        r88 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L76
        goto L71
    L63:
        if ((r68 instanceof JSONArray) == false) goto L73;
    L33:
        r126 = r68;
    L76:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L184
        r69 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L184
    L184:
        th = move-exception;
        Result.Companion r129 = Result.Companion;
        Object r89 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r130 = Result.exceptionOrNull-impl(r89);
        if (r130 == null) goto L189;
        EnsureManager.ensureNotReachHere(r130);
    L189:
        if (Result.isFailure-impl(r89) == true) goto L192;
        r116 = r89;
    L192:
        r70 = r116;
        goto L194
    }

    public static /* synthetic */ IOrderSchema c(String r7, com.bytedance.android.ec.common.api.jump.model.g r8, String r9, com.bytedance.android.btm.api.model.d r10) {
        return b(r7, r8, r9, r10, 0, 0);
    }

    public static IOrderSchema b(final String r25, com.bytedance.android.ec.common.api.jump.model.g r26, String r27, com.bytedance.android.btm.api.model.d r28, Integer r29, int r30) {
        Intrinsics.checkNotNullParameter(r26, "promotionParams");
        Map r3 = com.bytedance.android.ec.core.monitor.c.a;
        String r4 = com.bytedance.android.ec.core.monitor.c.c(MonitorScenes.EC_JSON_DEAL_DURATION, null);
        com.bytedance.android.ec.core.monitor.c.e(r4, LocationMonitorConst.TYPE, "entrance_info");
        com.bytedance.android.ec.core.monitor.c.e(r4, "scene", "live");
        if (r25 != null) goto L5;
        String r7 = "";
    L6:
        String r8 = "url";
        com.bytedance.android.ec.core.monitor.c.f(r4, "url", r7);
        com.bytedance.android.ec.core.monitor.c.h(r4, MetricNames.DEAL_DURATION, null);
        if (r29 == null) goto L9;
        int r9 = r29.intValue();
    L10:
        if (r25 == null) goto L17;
        final ql.a r10 = r26.a;
        final LiveRoomParams r11 = r26.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        final com.bytedance.android.ec.common.api.jump.model.f r12 = r26.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        int r13 = ECSdk.a;
        IECCommonService r14 = (IECCommonService) ECSdk.a(IECCommonService.class);
        if (r14 == null) goto L15;
        IOrderSchema r5 = r14.convertToOrderSchema(r25, new EntranceInfoScene("ecomLive", EnumEntranceInfoScene.ENTER_ORDER_PAGE.getValue()));
    L16:
        if (r5 == null) goto L17;
        r5.G(new OrderSchemaHelper$buildNewOrderSchemaInner$1(r11, r25));
        if (r30 <= 0) goto L22;
        if (r9 <= 0) goto L22;
        r5.replaceOrAppendParam("detail_url", PromotionDetailSchemaHelper.b(PromotionDetailSchemaHelper.a, r26, r27));
    L22:
        final JSONObject r0 = r26.getEntranceInfo();
        ECEventUtilsV2.b.getClass();
        Intrinsics.checkNotNullParameter(r5, "orderSchema");
        JSONObject r15 = z1.g(r5.getQueryParam("ad_extra_data"));
        if (r15 == null) goto L44;
        if (r27 == null) goto L42;
        int r16 = r27.hashCode();
        if (r16 == (-1377687758)) goto L40;
        if (r16 == 3046160) goto L37;
        if (r16 != 93819220) goto L42;
        if (r27.equals("blank") == false) goto L42;
        String r2 = "live_product_button";
    L43:
        r15.put("source_page", r2);
    L45:
        if (r15 == null) goto L47;
        r5.replaceOrAppendParam("ad_extra_data", r15.toString());
    L47:
        OrderSchema.b r6 = r5.P();
        if (r6 == null) goto L51;
        r6.b(new Pair[]{TuplesKt.to("live_product_type", r10.getLiveProductType())}, OrderSchemaHelper$buildNewOrderSchemaInner$3.INSTANCE);
    L51:
        if (r6 == null) goto L84;
        String r21 = "";
        Pair[] r17 = new Pair[14];
        if (r10.isPreSale() == false) goto L55;
        Object r18 = "1";
    L56:
        r17[0] = TuplesKt.to("upfront_presell", r18);
        String r19 = String.valueOf(r10.getLocalNum());
        String r24 = BDLocationException.ERROR_TIMEOUT;
        r17[1] = TuplesKt.to("local_num", r19);
        if (r10.isOnExplaining() == false) goto L59;
        String r1 = "1";
    L60:
        r17[2] = TuplesKt.to("is_explaining", r1);
        if (r10.getSingleSku() == false) goto L63;
        String r20 = r24;
    L64:
        r17[3] = TuplesKt.to("with_sku", r20);
        String r22 = r10.getLabelNameLive();
        if (r22 != null) goto L67;
        r22 = r21;
    L67:
        r17[4] = TuplesKt.to("label_name_live", r22);
        ECUIAskExplainInfo r23 = r10.getAskExplainInfo();
        if (r23 != null) goto L70;
    L72:
        String r31 = r24;
    L73:
        r17[5] = TuplesKt.to("is_explain_apply", r31);
        if (r10.isPreSale() == false) goto L76;
        String r32 = "1";
    L77:
        r17[6] = TuplesKt.to("upfront_presell", r32);
        String r33 = r10.getTrackLabelName();
        if (r33 != null) goto L80;
        r33 = r21;
    L80:
        r17[7] = TuplesKt.to("label_name", r33);
        r17[8] = TuplesKt.to("is_groupbuying", r10.getIsGroupBuying());
        r17[9] = TuplesKt.to("base_verified_category", r10.getBaseVerifiedCategory());
        String r34 = r10.getEcomGroupType();
        if (r34 != null) goto L83;
        r34 = "live";
    L83:
        r17[10] = TuplesKt.to("ecom_group_type", r34);
        r17[11] = TuplesKt.to("commodity_id", r10.getPromotionId());
        r17[12] = TuplesKt.to("commodity_type", r10.getEventItemType());
        r17[13] = TuplesKt.to("product_id", r10.getProductId());
        r6.g(r17);
    L85:
        if (r6 == null) goto L88;
        r6.b(new Pair[]{TuplesKt.to("page_name", "product_detail_replay")}, new OrderSchemaHelper$buildNewOrderSchemaInner$4(r12));
    L88:
        if (r6 == null) goto L96;
        Pair[] r35 = new Pair[1];
        if (r0 == null) goto L92;
        String r36 = r0.optString("enter_from_merge");
    L93:
        if (r36 != null) goto L95;
        r36 = r21;
    L95:
        r35[0] = TuplesKt.to("carrier_source", r36);
        com.bytedance.android.livesdk.livecommerce.utils.s.b(r6, r35, new OrderSchemaHelper$buildNewOrderSchemaInner$5(r10));
        goto L96
    L92:
        r36 = null;
    L96:
        if (r6 == null) goto L98;
        com.bytedance.android.livesdk.livecommerce.utils.s.a(r6, r10.getTransmissibleJson(), OrderSchemaHelper$buildNewOrderSchemaInner$6.INSTANCE);
    L98:
        if (r6 == null) goto L103;
        if (r11 == null) goto L101;
        JSONObject r37 = r11.getPassThroughLogData();
    L102:
        r6.i(r37);
        goto L103
    L101:
        r37 = null;
    L103:
        if (r6 == null) goto L105;
        r6.i(r0);
    L105:
        if (r6 == null) goto L124;
        Pair[] r38 = new Pair[7];
        r38[0] = TuplesKt.to("ecom_group_type", "live");
        if (r0 == null) goto L109;
        String r39 = r0.optString("enter_method");
    L110:
        r38[1] = TuplesKt.to("source_method", r39);
        if (r0 == null) goto L113;
        String r40 = r0.optString("enter_from_merge");
    L114:
        r38[2] = TuplesKt.to("carrier_source", r40);
        r38[3] = TuplesKt.to("promotion_id", r10.getPromotionId());
        r38[4] = TuplesKt.to("product_id", r10.getProductId());
        String r41 = r10.getPromotionId();
        if (com.bytedance.android.shopping.extensions.k.c(r41) == false) goto L117;
        String r110 = r41;
    L118:
        if (r110 != null) goto L120;
        r110 = r10.getProductId();
    L120:
        r38[5] = TuplesKt.to("commodity_id", r110);
        String r42 = r10.getEventItemType();
        if (r42 != null) goto L123;
        r42 = r24;
    L123:
        r38[6] = TuplesKt.to("commodity_type", r42);
        com.bytedance.android.livesdk.livecommerce.utils.s.b(r6, r38, new OrderSchemaHelper$buildNewOrderSchemaInner$8(r0));
        goto L124
    L117:
        r110 = null;
        goto L118
    L113:
        r40 = null;
        goto L114
    L109:
        r39 = null;
    L124:
        String r43 = r10.getGroupId();
        if (r43 == null) goto L128;
        r5.replaceOrAppendParam("spell_group_id", r43);
    L128:
        if (BuyNowPerformanceOpt.j() == true) goto L138;
        JSONObject r44 = new JSONObject();
        r44.put("biometric_params", "1");
        r44.put("is_jailbreak", hh2.f.c().a());
        r44.put("cj_sdk", hh2.f.c().getSdkVersion());
        r44.put("bio_type", hh2.f.c().getBioType());
        Unit r45 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r5, "$this$addOrReplaceParam");
        Intrinsics.checkNotNullParameter("cj_info", "key");
        Intrinsics.checkNotNullParameter(r44, "value");
        JSONObject r46 = z1.g(r5.getQueryParam("cj_info"));
        if (r46 == null) goto L136;
        Iterator<String> r47 = r44.keys();
    L133:
        if (r47.hasNext() == false) goto L135;
        String r48 = r47.next();
        r46.put(r48, r44.opt(r48));
        goto L133
    L135:
        r44 = r46;
    L136:
        r5.replaceOrAppendParam("cj_info", r44.toString());
    L138:
        if (r10.isInsuranceProduct() == false) goto L169;
        if (r11 == null) goto L169;
        Map r49 = r11.getReportParams();
        if (r49 == null) goto L169;
        LinkedHashMap r50 = new LinkedHashMap();
        r50.put("ecom_group_type", "live");
        String r51 = (String) r49.get("ecom_entrance_form");
        if (r51 != null) goto L145;
        r51 = r21;
    L145:
        r50.put("ecom_entrance_form", r51);
        String r52 = (String) r49.get("anchor_id");
        if (r52 != null) goto L148;
        r52 = r21;
    L148:
        r50.put("ecom_author_id", r52);
        String r53 = (String) r49.get("room_id");
        if (r53 != null) goto L151;
        r53 = r21;
    L151:
        r50.put("ecom_group_id", r53);
        r50.put("follow_status", r11.getFollowStatus());
        r50.put("new_source_type", r24);
        String r54 = (String) r49.get("is_other_channel");
        if (r54 != null) goto L154;
        r54 = r21;
    L154:
        r50.put("is_other_channel", r54);
        String r55 = (String) r49.get("creative_id");
        if (r55 != null) goto L157;
        r55 = r21;
    L157:
        r50.put("creative_id", r55);
        String r56 = (String) r49.get("ad_id");
        if (r56 != null) goto L160;
        r56 = r21;
    L160:
        r50.put("ad_id", r56);
        String r57 = r8;
        String r58 = r5.getQueryParam(r57);
        if (r58 != null) goto L163;
        Intrinsics.checkNotNullParameter(r5, "$this$addOrReplaceParam");
        Intrinsics.checkNotNullParameter(r50, "value");
        Iterator r59 = r50.entrySet().iterator();
    L167:
        if (r59.hasNext() == false) goto L169;
        Map.Entry r60 = (Map.Entry) r59.next();
        r5.replaceOrAppendParam((String) r60.getKey(), (String) r60.getValue());
        goto L167
    L163:
        if (LiveSettingKeys.getEC_LIVE_FIX_INSURANCE_ORDER_SCHEMA() == false) goto L169;
        UrlBuilderV2 r61 = new UrlBuilderV2(r58);
        r61.addOrReplaceParam(r50);
        r5.replaceOrAppendParam(r57, r61.toString());
    L169:
        r5.replaceOrAppendParam("page_init_timestamp", String.valueOf(System.currentTimeMillis()));
        com.bytedance.android.btm.api.model.d r62 = BtmUtilsKt.a(r28, r26.getChainParams());
        Intrinsics.checkNotNullParameter(r5, "$this$appendSourceBtmToken");
        if (r62 == null) goto L174;
        String r63 = BtmSDK.INSTANCE.createJumpSourceBtmToken(r62);
        if (r63 == null) goto L174;
        r5.replaceOrAppendParam("source_btm_token", r63);
    L174:
        Map r64 = com.bytedance.android.ec.core.monitor.c.a;
        String r65 = r4;
        com.bytedance.android.ec.core.monitor.c.j(r65, MetricNames.DEAL_DURATION);
        com.bytedance.android.ec.core.monitor.c.d(r65);
        return r5;
    L76:
        r32 = r24;
        goto L77
    L70:
        if (r23.isAsked() != true) goto L72;
        r31 = "1";
        goto L73
    L63:
        r20 = "1";
        goto L64
    L59:
        r1 = r24;
        goto L60
    L55:
        r18 = BDLocationException.ERROR_TIMEOUT;
        goto L56
    L84:
        r24 = BDLocationException.ERROR_TIMEOUT;
        r4 = r4;
        r21 = "";
        r8 = "url";
        goto L85
    L37:
        if (r27.equals("card") == false) goto L42;
        r2 = "live_card_button";
        goto L43
    L40:
        if (r27.equals("button") == false) goto L42;
        r2 = "live_confirm_button";
    L42:
        r2 = "";
        goto L43
    L44:
        r15 = null;
        goto L45
    L15:
        r5 = null;
    L17:
        r4 = r4;
        r5 = null;
        goto L174
    L9:
        r9 = 0;
        goto L10
    L5:
        r7 = r25;
        goto L6
    }
}
