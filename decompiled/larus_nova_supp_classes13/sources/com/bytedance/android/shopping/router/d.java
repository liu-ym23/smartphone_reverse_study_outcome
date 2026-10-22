package com.bytedance.android.shopping.router;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.response.LynxCellDataConfig;
import com.bytedance.android.shopping.anchorv3.comment.model.BottomProductCardInfo;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentLogParams;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentParams;
import com.bytedance.android.shopping.anchorv3.comment.model.StatTagItem;
import com.bytedance.android.shopping.anchorv3.comment.view.AnchorV3CommentActivity;
import com.bytedance.android.shopping.api.model.ECAnchorV3ExtraData;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements bf.c {
    public d() {
    }

    public final void a() {
    }

    public final String b() {
        return "ec_goods_comment";
    }

    public final boolean c(Context r65, Uri r66, boolean r67) {
        Intrinsics.checkNotNullParameter(r65, "context");
        Intrinsics.checkNotNullParameter(r66, "uri");
        String r0 = UriProtector.getQueryParameter(r66, "creative_id");
        Intrinsics.checkNotNullParameter("0", "default");
        if (r0 != null) goto L5;
        r0 = "0";
    L5:
        String r5 = UriProtector.getQueryParameter(r66, "log_extra");
        String r6 = "";
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        String r7 = UriProtector.getQueryParameter(r66, "ad_group_id");
        Intrinsics.checkNotNullParameter("0", "default");
        if (r7 != null) goto L11;
        r7 = "0";
    L11:
        String r8 = UriProtector.getQueryParameter(r66, "ad_extra_data");
        if (r8 != null) goto L14;
        r8 = "";
    L14:
        String r9 = UriProtector.getQueryParameter(r66, "comment_entrance");
        if (r9 != null) goto L17;
        r9 = "";
    L17:
        String r10 = UriProtector.getQueryParameter(r66, PdpOpenThirdParam.KEY_PRODUCT_ID);
        Intrinsics.checkNotNullParameter("0", "default");
        if (r10 != null) goto L20;
        String r22 = "0";
    L21:
        String r11 = UriProtector.getQueryParameter(r66, "search_id");
        if (r11 != null) goto L24;
        String r27 = "";
    L25:
        String r12 = UriProtector.getQueryParameter(r66, "shop_id");
        Intrinsics.checkNotNullParameter("0", "default");
        if (r12 != null) goto L28;
        String r26 = "0";
    L29:
        String r13 = UriProtector.getQueryParameter(r66, "kol_id");
        if (r13 != null) goto L32;
        String r23 = "";
    L33:
        String r14 = UriProtector.getQueryParameter(r66, "author_id");
        Intrinsics.checkNotNullParameter("0", "default");
        if (r14 != null) goto L36;
        String r24 = "0";
    L37:
        String r15 = UriProtector.getQueryParameter(r66, "v3_event_addition");
        if (r15 != null) goto L40;
        String r31 = "";
    L41:
        String r16 = UriProtector.getQueryParameter(r66, "entrance_info");
        if (r16 != null) goto L44;
        String r17 = "";
    L45:
        List r32 = UriProtector.getQueryParameters(r66, "top_comment_ids");
        String r33 = UriProtector.getQueryParameter(r66, "top_comment_types");
        String r18 = UriProtector.getQueryParameter(r66, "show_order_stat");
        Intrinsics.checkNotNullParameter("0", "default");
        if (r18 != null) goto L48;
        r18 = "0";
    L48:
        boolean r36 = Intrinsics.areEqual(r18, "1");
        boolean r35 = Intrinsics.areEqual(UriProtector.getQueryParameter(r66, "is_store_comment"), "1");
        String r19 = UriProtector.getQueryParameter(r66, "source_btm_token");
        String r110 = UriProtector.getQueryParameter(r66, "is_impression_tag");
        if (r110 != null) goto L51;
        r110 = "";
    L51:
        String r111 = UriProtector.getQueryParameter(r66, "general_id");
        Object r48 = null;
        if (r111 == null) goto L54;
        Long r112 = StringsKt.toLongOrNull(r111);
    L55:
        StatTagItem.Companion.getClass();
        StatTagItem r113 = new StatTagItem(1, 0, null, "全部", 0, false, null, 0, 246, null);
        String r114 = UriProtector.getQueryParameter(r66, "reply_comment_id");
        if (r114 == null) goto L58;
        Long r43 = StringsKt.toLongOrNull(r114);
    L59:
        List r44 = CollectionsKt.toMutableList(UriProtector.getQueryParameters(r66, "highlight_reply_comment_id"));
        if (com.bytedance.android.shopping.extensions.k.c(r110) == false) goto L63;
        if (r112 == null) goto L63;
        r113 = new StatTagItem(r112.longValue(), 0, null, null, 0, Intrinsics.areEqual(r110, "0"), null, 0, 222, null);
    L63:
        StatTagItem r3 = r113;
        String r115 = UriProtector.getQueryParameter(r66, PdpOpenThirdParam.KEY_PAGE_NAME);
        if (r115 != null) goto L66;
        String r38 = "";
    L67:
        ECAdLogExtra r116 = new ECAdLogExtra(r0, r5, r8, r7);
        ECAnchorV3ExtraData r1 = new ECAnchorV3ExtraData(true, null, null, 6, null);
        if (Intrinsics.areEqual(r9, "product_flow_page") == true) goto L71;
        r1 = null;
    L71:
        CommentParams r20 = new CommentParams(false, r22, r23, r24, null, r26, r27, null, new CommentLogParams(r9, r116, r31, r17, r1, null, null, 96, null), null, com.bytedance.android.shopping.extensions.k.z(r31), r32, r33, null, r35, r36 ? 1 : 0, 0, r38, null, null, null, null, r43, r44, null, 20783761, null);
        r20.setEnterClickTagItem(r3);
        r20.setSourceBtmToken(r19);
        int r2 = m53.a.a;
        int r4 = com.bytedance.android.ec.base.settings.b.a;
        Object r21 = new HashMap();
        int r25 = 0;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L238
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L238
        SDKSettingsCacheManager r117 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L238
        r117.getClass();     // Catch: Throwable -> L127
        Object r29 = SDKSettingsCacheManager.b.get("ecom_comment_schema_ab_params");     // Catch: Throwable -> L127
        if (r29 != null) goto L79;
    L124:
        Object r118 = null;
    L125:
        Object r30 = Result.constructor-impl(r118);     // Catch: Throwable -> L127
    L129:
        Throwable r119 = Result.exceptionOrNull-impl(r30);     // Catch: Throwable -> L238
        if (r119 == null) goto L133;
        EnsureManager.ensureNotReachHere(r119);     // Catch: Throwable -> L238
    L133:
        if (Result.isFailure-impl(r30) == false) goto L136;
        r30 = null;
    L136:
        if ((r30 instanceof HashMap) == true) goto L138;
        r30 = null;
    L138:
        Object r34 = (HashMap) r30;     // Catch: Throwable -> L238
        if (r34 != null) goto L145;
        r117.getClass();     // Catch: Throwable -> L238
        Object r37 = SDKSettingsCacheManager.a.get("ecom_comment_schema_ab_params");     // Catch: Throwable -> L238
        if ((r37 instanceof HashMap) == true) goto L144;
        r37 = null;
    L144:
        r34 = (HashMap) r37;     // Catch: Throwable -> L238
    L145:
        if (r34 != null) goto L247;
        int r39 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L238
    L226:
        th = move-exception;
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L238
        r34 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L238
    L229:
        if (Result.exceptionOrNull-impl(r34) != null) goto L328;
    L236:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L238
        SDKSettingsCacheManager.e("ecom_comment_schema_ab_params", r34);     // Catch: Throwable -> L238
        goto L247
    L328:
        r34 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ecom_comment_schema_ab_params", HashMap.class, r21);     // Catch: Throwable -> L233
    L234:
        if (r34 != null) goto L236;
        r34 = r21;
    L233:
        r34 = r21;
        goto L234
    L316:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L201
        Object r40 = SDKSettingsCacheManager.b.get("ecom_comment_schema_ab_params");     // Catch: Throwable -> L201
        if (r40 != null) goto L153;
    L198:
        Object r121 = null;
    L199:
        Object r41 = Result.constructor-impl(r121);     // Catch: Throwable -> L201
    L203:
        Throwable r122 = Result.exceptionOrNull-impl(r41);     // Catch: Throwable -> L226
        if (r122 == null) goto L207;
        EnsureManager.ensureNotReachHere(r122);     // Catch: Throwable -> L226
    L207:
        if (Result.isFailure-impl(r41) == false) goto L210;
        r41 = null;
    L210:
        if ((r41 instanceof HashMap) == true) goto L212;
        r41 = null;
    L212:
        r34 = (HashMap) r41;     // Catch: Throwable -> L226
        if (r34 != null) goto L236;
        jj4.b r42 = jj4.b.b;     // Catch: Throwable -> L226
        Object r45 = jj4.a.a("ecom_comment_schema_ab_params", HashMap.class, r21, false);     // Catch: Throwable -> L226
        if (r45 != null) goto L219;
        Intrinsics.throwNpe();     // Catch: Throwable -> L226
    L219:
        if ((r45 instanceof HashMap) == true) goto L221;
        r45 = null;
    L221:
        Object r46 = (HashMap) r45;     // Catch: Throwable -> L226
        if (r46 != null) goto L224;
        r46 = r21;
    L224:
        r34 = Result.constructor-impl(r46);     // Catch: Throwable -> L226
    L153:
        if ((r40 instanceof HashMap) == true) goto L155;
        Object r123 = null;
    L156:
        r121 = (HashMap) r123;     // Catch: Throwable -> L201
        if (r121 != null) goto L199;
        if ((r40 instanceof Number) == false) goto L186;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L168;
        Float r47 = Float.valueOf(((Number) r40).floatValue());     // Catch: Throwable -> L201
        if ((r47 instanceof HashMap) == true) goto L166;
        r47 = null;
    L166:
        r121 = (HashMap) r47;     // Catch: Throwable -> L201
        goto L199
    L168:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L174;
        Double r49 = Double.valueOf(((Number) r40).doubleValue());     // Catch: Throwable -> L201
        if ((r49 instanceof HashMap) == true) goto L172;
        r49 = null;
    L172:
        r121 = (HashMap) r49;     // Catch: Throwable -> L201
        goto L199
    L174:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L180;
        Integer r50 = Integer.valueOf(((Number) r40).intValue());     // Catch: Throwable -> L201
        if ((r50 instanceof HashMap) == true) goto L178;
        r50 = null;
    L178:
        r121 = (HashMap) r50;     // Catch: Throwable -> L201
        goto L199
    L180:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L186;
        Long r51 = Long.valueOf(((Number) r40).longValue());     // Catch: Throwable -> L201
        if ((r51 instanceof HashMap) == true) goto L184;
        r51 = null;
    L184:
        r121 = (HashMap) r51;     // Catch: Throwable -> L201
    L186:
        if ((r40 instanceof JSONObject) == false) goto L188;
    L322:
        Object r52 = SDKSettingsCacheManager.a().fromJson(r40.toString(), HashMap.class);     // Catch: Throwable -> L194
        if ((r52 instanceof HashMap) == true) goto L192;
        r52 = null;
    L192:
        Object r53 = Result.constructor-impl((HashMap) r52);     // Catch: Throwable -> L194
    L196:
        r121 = r53;
        if (Result.isFailure-impl(r121) == false) goto L199;
    L194:
        th = move-exception;
        Result.Companion r124 = Result.Companion;     // Catch: Throwable -> L201
        r53 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L201
        goto L196
    L188:
        if ((r40 instanceof JSONArray) == false) goto L198;
    L155:
        r123 = r40;
    L201:
        th = move-exception;
        Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L226
        r41 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L226
    L247:
        HashMap r54 = (HashMap) r34;
        String r55 = UriProtector.getQueryParameter(r66, "extra_params");
        if (r55 != null) goto L250;
    L253:
        boolean r126 = true;
    L254:
        if (r126 == true) goto L256;
        Result.Companion r56 = Result.Companion;     // Catch: Throwable -> L260
        Object r57 = Result.constructor-impl((HashMap) u0.b(r55, new HashMap().getClass()));     // Catch: Throwable -> L260
    L262:
        Result.exceptionOrNull-impl(r57);
        if (Result.isFailure-impl(r57) == false) goto L265;
        r57 = null;
    L265:
        HashMap r58 = (HashMap) r57;
        if (r58 == null) goto L269;
        r20.setExtraParams(r58);
    L269:
        if (Intrinsics.areEqual(r9, "general_search") == false) goto L314;
        String r59 = UriProtector.getQueryParameter(r66, "show_product_card");
        if (r59 != null) goto L273;
        r59 = "";
    L273:
        String r60 = UriProtector.getQueryParameter(r66, "product_card_info");
        if (r60 != null) goto L277;
        r60 = "";
    L277:
        if (Intrinsics.areEqual(r59, "1") == false) goto L314;
        if (r60.length() <= 0) goto L281;
        boolean r61 = true;
    L282:
        if (r61 == false) goto L314;
        Object r62 = z1.f(r60).opt("config");     // Catch: JSONException -> L312
        if ((r62 instanceof String) == true) goto L286;
        r62 = null;
    L286:
        String r63 = (String) r62;     // Catch: JSONException -> L312
        if (r63 == null) goto L289;
        JSONObject r64 = z1.f(r63);     // Catch: JSONException -> L312
    L290:
        if (r64 == null) goto L292;
        Object r68 = r64.opt("height");     // Catch: JSONException -> L312
    L294:
        if ((r68 instanceof Integer) == true) goto L296;
        r68 = null;
    L296:
        Integer r69 = (Integer) r68;     // Catch: JSONException -> L312
        if (r69 == null) goto L299;
        r25 = r69.intValue();     // Catch: JSONException -> L312
    L299:
        if (r64 == null) goto L301;
        Object r70 = r64.opt("url");     // Catch: JSONException -> L312
    L303:
        if ((r70 instanceof String) == false) goto L306;
        r48 = r70;
    L306:
        String r410 = (String) r48;     // Catch: JSONException -> L312
        if (r410 == null) goto L310;
        r6 = r410;
    L310:
        r20.setBottomProductCardInfo(new BottomProductCardInfo(true, r60, new LynxCellDataConfig(r25, r6)));     // Catch: JSONException -> L312
        goto L314
    L301:
        r70 = null;
        goto L303
    L292:
        r68 = null;
        goto L294
    L289:
        r64 = null;
    L312:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L314
    L281:
        r61 = false;
    L314:
        int r71 = AnchorV3CommentActivity.l;
        AnchorV3CommentActivity.a.a(r65, r20);
        return true;
    L260:
        th = move-exception;
        Result.Companion r72 = Result.Companion;
        r57 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L262
    L256:
        if ((!r54.isEmpty()) == false) goto L269;
        LinkedHashMap r73 = new LinkedHashMap();
        r73.put("ab_params", r54);
        Unit r74 = Unit.INSTANCE;
        r20.setExtraParams(r73);
        goto L269
    L250:
        if (r55.length() == 0) goto L253;
        r126 = false;
        goto L254
    L79:
        if ((r29 instanceof HashMap) == true) goto L81;
        Object r127 = null;
    L82:
        r118 = (HashMap) r127;     // Catch: Throwable -> L127
        if (r118 != null) goto L125;
        if ((r29 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L94;
        Float r75 = Float.valueOf(((Number) r29).floatValue());     // Catch: Throwable -> L127
        if ((r75 instanceof HashMap) == true) goto L92;
        r75 = null;
    L92:
        r118 = (HashMap) r75;     // Catch: Throwable -> L127
        goto L125
    L94:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L100;
        Double r76 = Double.valueOf(((Number) r29).doubleValue());     // Catch: Throwable -> L127
        if ((r76 instanceof HashMap) == true) goto L98;
        r76 = null;
    L98:
        r118 = (HashMap) r76;     // Catch: Throwable -> L127
        goto L125
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        Integer r77 = Integer.valueOf(((Number) r29).intValue());     // Catch: Throwable -> L127
        if ((r77 instanceof HashMap) == true) goto L104;
        r77 = null;
    L104:
        r118 = (HashMap) r77;     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r78 = Long.valueOf(((Number) r29).longValue());     // Catch: Throwable -> L127
        if ((r78 instanceof HashMap) == true) goto L110;
        r78 = null;
    L110:
        r118 = (HashMap) r78;     // Catch: Throwable -> L127
    L112:
        if ((r29 instanceof JSONObject) == false) goto L114;
    L318:
        Object r79 = SDKSettingsCacheManager.a().fromJson(r29.toString(), HashMap.class);     // Catch: Throwable -> L120
        if ((r79 instanceof HashMap) == true) goto L118;
        r79 = null;
    L118:
        Object r80 = Result.constructor-impl((HashMap) r79);     // Catch: Throwable -> L120
    L122:
        r118 = r80;
        if (Result.isFailure-impl(r118) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L127
        r80 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r29 instanceof JSONArray) == false) goto L124;
    L81:
        r127 = r29;
    L127:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L238
        r30 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L238
    L238:
        th = move-exception;
        Result.Companion r81 = Result.Companion;
        Object r82 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r84 = Result.exceptionOrNull-impl(r82);
        if (r84 == null) goto L243;
        EnsureManager.ensureNotReachHere(r84);
    L243:
        if (Result.isFailure-impl(r82) == true) goto L246;
        r21 = r82;
    L246:
        r34 = r21;
        goto L247
    L66:
        r38 = r115;
        goto L67
    L58:
        r43 = null;
        goto L59
    L54:
        r112 = null;
        goto L55
    L44:
        r17 = r16;
        goto L45
    L40:
        r31 = r15;
        goto L41
    L36:
        r24 = r14;
        goto L37
    L32:
        r23 = r13;
        goto L33
    L28:
        r26 = r12;
        goto L29
    L24:
        r27 = r11;
        goto L25
    L20:
        r22 = r10;
        goto L21
    }
}
