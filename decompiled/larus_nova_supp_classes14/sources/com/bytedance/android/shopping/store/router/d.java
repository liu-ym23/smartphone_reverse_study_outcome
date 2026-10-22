package com.bytedance.android.shopping.store.router;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.g;
import com.bytedance.android.ec.store.setting.ECStoreSettings;
import com.bytedance.android.shopping.store.home.api.ECStoreApi;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.services.apm.api.EnsureManager;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d {
    public static JSONObject a;

    public static final class a<T> implements Consumer {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void accept(Object r2) {
            JSONObject r0 = d.a;
            d.a = z1.g((String) r2);
        }
    }

    static {
        ECStoreApi.a.getClass();
        ECStoreApi r0 = ECStoreApi.a.a;
        if (r0 == null) goto L23;
        Lazy r1 = ECStoreSettings.a;
        int r2 = p.a;
        Object r3 = "https://lf3-static.bytednsdoc.com/obj/eden-cn/hahk_wvoz_tvjl/ljhwZthlaukjlkulzlp/shop_entrance_locations.json";
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L9
        jj4.b r5 = jj4.b.b;     // Catch: Throwable -> L9
        Object r6 = jj4.a.a("ec_shop_entrance_location_config", String.class, "https://lf3-static.bytednsdoc.com/obj/eden-cn/hahk_wvoz_tvjl/ljhwZthlaukjlkulzlp/shop_entrance_locations.json", false);     // Catch: Throwable -> L9
        if (r6 != null) goto L15;
        Intrinsics.throwNpe();     // Catch: Throwable -> L9
    L15:
        Observable<String> r7 = r0.getEntranceLocations((String) r6);
        if (r7 == null) goto L24;
        Observable r8 = bg4.b.b(r7);
        if (r8 == null) goto L25;
        r8.subscribe(a.a);
        return;
    L25:
        return;
    L24:
        return;
    L9:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        Object r10 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r10) == true) goto L14;
        r3 = r10;
    L14:
        r6 = r3;
        goto L15
    }

    public static boolean a(Context r9, Uri r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "uri");
        if (ECAppInfoService.e.isLocalTest() == false) goto L423;
        Lazy r0 = ECStoreSettings.a;
        int r1 = p.a;
        Object r2 = Boolean.FALSE;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L9
        jj4.b r5 = jj4.b.b;     // Catch: Throwable -> L9
        Object r3 = jj4.a.a("ec_shop_entrance_location_intercept", Boolean.class, r2, false);     // Catch: Throwable -> L9
        if (r3 != null) goto L16;
        Intrinsics.throwNpe();     // Catch: Throwable -> L9
    L16:
        if (((Boolean) r3).booleanValue() == false) goto L424;
        ECShopABSettings.k.getClass();
        Object r6 = 0;
        Object r7 = null;
        if (Intrinsics.areEqual("ec_shop_entrance_location_switch", "ec_shop_launch_opt_common_2") == false) goto L191;
        if (ECShopABSettings.b != null) goto L185;
        int r8 = n.a;
        int r11 = com.bytedance.android.ec.base.settings.a.a;
        Object r12 = com.bytedance.android.ec.base.settings.d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L71
        if (r12 != null) goto L26;
    L68:
        Object r13 = null;
    L69:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L71
    L73:
        Throwable r15 = Result.exceptionOrNull-impl(r14);     // Catch: Throwable -> L175
        if (r15 == null) goto L77;
        EnsureManager.ensureNotReachHere(r15);     // Catch: Throwable -> L175
    L77:
        if (Result.isFailure-impl(r14) == false) goto L80;
        r14 = null;
    L80:
        if ((r14 instanceof Integer) == true) goto L82;
        r14 = null;
    L82:
        Object r16 = (Integer) r14;     // Catch: Throwable -> L175
        if (r16 != null) goto L89;
        Object r17 = com.bytedance.android.ec.base.settings.d.a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L175
        if ((r17 instanceof Integer) == true) goto L88;
        r17 = null;
    L88:
        r16 = (Integer) r17;     // Catch: Throwable -> L175
    L89:
        if (r16 != null) goto L184;
        int r18 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L175
        Object r19 = com.bytedance.android.ec.base.settings.d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L141
        if (r19 != null) goto L96;
    L138:
        Object r20 = null;
    L139:
        Object r21 = Result.constructor-impl(r20);     // Catch: Throwable -> L141
    L143:
        Throwable r22 = Result.exceptionOrNull-impl(r21);     // Catch: Throwable -> L166
        if (r22 == null) goto L147;
        EnsureManager.ensureNotReachHere(r22);     // Catch: Throwable -> L166
    L147:
        if (Result.isFailure-impl(r21) == false) goto L150;
        r21 = null;
    L150:
        if ((r21 instanceof Integer) == true) goto L152;
        r21 = null;
    L152:
        r16 = (Integer) r21;     // Catch: Throwable -> L166
        if (r16 != null) goto L173;
        IHybridHostService r23 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L166
        if (r23 == null) goto L158;
        Object r24 = r23.getHostABValue("ec_shop_launch_opt_common_2", r6);     // Catch: Throwable -> L166
    L159:
        if (r24 != null) goto L161;
    L172:
        r16 = r6;
        goto L173
    L161:
        if ((r24 instanceof Integer) == true) goto L163;
        r24 = null;
    L163:
        r16 = (Integer) r24;     // Catch: Throwable -> L166
        if (r16 != null) goto L173;
    L166:
        th = move-exception;
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L175
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L175
        Throwable r26 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L175
        if (r26 == null) goto L171;
        EnsureManager.ensureNotReachHere(r26);     // Catch: Throwable -> L175
    L171:
        if (Result.isFailure-impl(r16) == false) goto L173;
    L158:
        r24 = null;
    L173:
        com.bytedance.android.ec.base.settings.d.d("ec_shop_launch_opt_common_2", r16);     // Catch: Throwable -> L175
        goto L184
    L96:
        if ((r19 instanceof Integer) == true) goto L98;
        Object r27 = null;
    L99:
        r20 = (Integer) r27;     // Catch: Throwable -> L141
        if (r20 != null) goto L139;
        if ((r19 instanceof Number) == false) goto L126;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L111;
        Float r28 = Float.valueOf(((Number) r19).floatValue());     // Catch: Throwable -> L141
        if ((r28 instanceof Integer) == true) goto L109;
        r28 = null;
    L109:
        r20 = (Integer) r28;     // Catch: Throwable -> L141
        goto L139
    L111:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L117;
        Double r29 = Double.valueOf(((Number) r19).doubleValue());     // Catch: Throwable -> L141
        if ((r29 instanceof Integer) == true) goto L115;
        r29 = null;
    L115:
        r20 = (Integer) r29;     // Catch: Throwable -> L141
        goto L139
    L117:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L120;
        r20 = Integer.valueOf(((Number) r19).intValue());     // Catch: Throwable -> L141
        goto L139
    L120:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L126;
        Long r30 = Long.valueOf(((Number) r19).longValue());     // Catch: Throwable -> L141
        if ((r30 instanceof Integer) == true) goto L124;
        r30 = null;
    L124:
        r20 = (Integer) r30;     // Catch: Throwable -> L141
    L126:
        if ((r19 instanceof JSONObject) == false) goto L128;
    L417:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L134
        Object r31 = SDKSettingsCacheManager.a().fromJson(r19.toString(), Integer.class);     // Catch: Throwable -> L134
        if ((r31 instanceof Integer) == true) goto L132;
        r31 = null;
    L132:
        Object r32 = Result.constructor-impl((Integer) r31);     // Catch: Throwable -> L134
    L136:
        r20 = r32;
        if (Result.isFailure-impl(r20) == false) goto L139;
    L134:
        th = move-exception;
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L141
        r32 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L141
        goto L136
    L128:
        if ((r19 instanceof JSONArray) == false) goto L138;
    L98:
        r27 = r19;
    L141:
        th = move-exception;
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L166
        r21 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L184:
        ECShopABSettings.b = (Integer) r16;
        goto L185
    L26:
        if ((r12 instanceof Integer) == true) goto L28;
        Object r35 = null;
    L29:
        r13 = (Integer) r35;     // Catch: Throwable -> L71
        if (r13 != null) goto L69;
        if ((r12 instanceof Number) == false) goto L56;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L41;
        Float r36 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L71
        if ((r36 instanceof Integer) == true) goto L39;
        r36 = null;
    L39:
        r13 = (Integer) r36;     // Catch: Throwable -> L71
        goto L69
    L41:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L47;
        Double r37 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L71
        if ((r37 instanceof Integer) == true) goto L45;
        r37 = null;
    L45:
        r13 = (Integer) r37;     // Catch: Throwable -> L71
        goto L69
    L47:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L50;
        r13 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L71
        goto L69
    L50:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L56;
        Long r38 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L71
        if ((r38 instanceof Integer) == true) goto L54;
        r38 = null;
    L54:
        r13 = (Integer) r38;     // Catch: Throwable -> L71
    L56:
        if ((r12 instanceof JSONObject) == false) goto L58;
    L415:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L64
        Object r39 = SDKSettingsCacheManager.a().fromJson(r12.toString(), Integer.class);     // Catch: Throwable -> L64
        if ((r39 instanceof Integer) == true) goto L62;
        r39 = null;
    L62:
        Object r40 = Result.constructor-impl((Integer) r39);     // Catch: Throwable -> L64
    L66:
        r13 = r40;
        if (Result.isFailure-impl(r13) == false) goto L69;
    L64:
        th = move-exception;
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L71
        r40 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L71
        goto L66
    L58:
        if ((r12 instanceof JSONArray) == false) goto L68;
    L28:
        r35 = r12;
    L175:
        th = move-exception;
        Result.Companion r42 = Result.Companion;
        Object r43 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r44 = Result.exceptionOrNull-impl(r43);
        if (r44 == null) goto L180;
        EnsureManager.ensureNotReachHere(r44);
    L180:
        if (Result.isFailure-impl(r43) == true) goto L183;
        r6 = r43;
    L183:
        r16 = r6;
    L71:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L175
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L175
    L185:
        r6 = ECShopABSettings.b;
        if (r6 == null) goto L189;
    L362:
        ECShopABSettings.a.put("ec_shop_entrance_location_switch", r6);
        if (((Number) r6).intValue() == 0) goto L365;
        return true;
    L365:
        if (a == null) goto L426;
        String r110 = UriProtector.getQueryParameter(r10, "entrance_location");
        if (r110 != null) goto L369;
    L372:
        boolean r46 = true;
    L373:
        if (r46 == false) goto L375;
        ShopEntranceCheckActivity.a.startActivity(r9, "路径参数entrance_location缺失");
        b(r9, "miss_entrance_location");
    L380:
        return false;
    L375:
        JSONObject r47 = a;
        if (r47 != null) goto L378;
    L381:
        Lazy r48 = ECStoreSettings.a;
        int r49 = p.a;
        jj4.b r50 = jj4.b.b;     // Catch: Throwable -> L384
        Object r51 = jj4.a.a("ec_shop_unknown_entrances", List.class, null, false);     // Catch: Throwable -> L384
    L390:
        List r52 = (List) r51;
        if (r52 != null) goto L393;
        return true;
    L393:
        if (r52.contains(r110) != true) goto L429;
        ShopEntranceCheckActivity.a.startActivity(r9, "未知位置的entrance_location:" + r110);
        b(r9, "unknown_position");
        return true;
    L429:
        return true;
    L384:
        th = move-exception;
        Result.Companion r53 = Result.Companion;
        Object r54 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r54) == true) goto L389;
        r7 = r54;
    L389:
        r51 = r7;
        goto L390
    L378:
        if (r47.isNull(r110) != true) goto L381;
        ShopEntranceCheckActivity.a.startActivity(r9, "当前的路径参数entrance_location" + r110 + "未注册");
        b(r9, "not_register");
        goto L380
    L369:
        if (StringsKt.isBlank(r110) == true) goto L372;
        r46 = false;
        goto L373
    L426:
        return true;
    L189:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L191:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L202;
        int r55 = p.a;
        jj4.b r56 = jj4.b.b;     // Catch: Throwable -> L197
        Object r57 = jj4.a.a("ec_shop_entrance_location_switch", Integer.class, r6, false);     // Catch: Throwable -> L197
        if (r57 != null) goto L201;
        Intrinsics.throwNpe();     // Catch: Throwable -> L197
    L201:
        r6 = r57;
    L197:
        th = move-exception;
        Result.Companion r58 = Result.Companion;
        r57 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r57) == false) goto L201;
    L202:
        int r59 = n.a;
        int r60 = com.bytedance.android.ec.base.settings.a.a;
        Object r61 = com.bytedance.android.ec.base.settings.d.c.get("ec_shop_entrance_location_switch");     // Catch: Throwable -> L252
        if (r61 != null) goto L207;
    L249:
        Object r62 = null;
    L250:
        Object r63 = Result.constructor-impl(r62);     // Catch: Throwable -> L252
    L254:
        Throwable r64 = Result.exceptionOrNull-impl(r63);     // Catch: Throwable -> L356
        if (r64 == null) goto L258;
        EnsureManager.ensureNotReachHere(r64);     // Catch: Throwable -> L356
    L258:
        if (Result.isFailure-impl(r63) == false) goto L261;
        r63 = null;
    L261:
        if ((r63 instanceof Integer) == true) goto L263;
        r63 = null;
    L263:
        r57 = (Integer) r63;     // Catch: Throwable -> L356
        if (r57 != null) goto L270;
        Object r65 = com.bytedance.android.ec.base.settings.d.a.get("ec_shop_entrance_location_switch");     // Catch: Throwable -> L356
        if ((r65 instanceof Integer) == true) goto L269;
        r65 = null;
    L269:
        r57 = (Integer) r65;     // Catch: Throwable -> L356
    L270:
        if (r57 != null) goto L201;
        int r66 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L356
        Object r67 = com.bytedance.android.ec.base.settings.d.c.get("ec_shop_entrance_location_switch");     // Catch: Throwable -> L322
        if (r67 != null) goto L277;
    L319:
        Object r68 = null;
    L320:
        Object r69 = Result.constructor-impl(r68);     // Catch: Throwable -> L322
    L324:
        Throwable r70 = Result.exceptionOrNull-impl(r69);     // Catch: Throwable -> L347
        if (r70 == null) goto L328;
        EnsureManager.ensureNotReachHere(r70);     // Catch: Throwable -> L347
    L328:
        if (Result.isFailure-impl(r69) == false) goto L331;
        r69 = null;
    L331:
        if ((r69 instanceof Integer) == true) goto L333;
        r69 = null;
    L333:
        r57 = (Integer) r69;     // Catch: Throwable -> L347
        if (r57 != null) goto L354;
        IHybridHostService r71 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L347
        if (r71 == null) goto L339;
        Object r72 = r71.getHostABValue("ec_shop_entrance_location_switch", r6);     // Catch: Throwable -> L347
    L340:
        if (r72 != null) goto L342;
    L353:
        r57 = r6;
        goto L354
    L342:
        if ((r72 instanceof Integer) == true) goto L344;
        r72 = null;
    L344:
        r57 = (Integer) r72;     // Catch: Throwable -> L347
        if (r57 != null) goto L354;
    L339:
        r72 = null;
    L354:
        com.bytedance.android.ec.base.settings.d.d("ec_shop_entrance_location_switch", r57);     // Catch: Throwable -> L356
        goto L201
    L277:
        if ((r67 instanceof Integer) == true) goto L279;
        Object r73 = null;
    L280:
        r68 = (Integer) r73;     // Catch: Throwable -> L322
        if (r68 != null) goto L320;
        if ((r67 instanceof Number) == false) goto L307;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L292;
        Float r74 = Float.valueOf(((Number) r67).floatValue());     // Catch: Throwable -> L322
        if ((r74 instanceof Integer) == true) goto L290;
        r74 = null;
    L290:
        r68 = (Integer) r74;     // Catch: Throwable -> L322
        goto L320
    L292:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L298;
        Double r75 = Double.valueOf(((Number) r67).doubleValue());     // Catch: Throwable -> L322
        if ((r75 instanceof Integer) == true) goto L296;
        r75 = null;
    L296:
        r68 = (Integer) r75;     // Catch: Throwable -> L322
        goto L320
    L298:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L301;
        r68 = Integer.valueOf(((Number) r67).intValue());     // Catch: Throwable -> L322
        goto L320
    L301:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L307;
        Long r76 = Long.valueOf(((Number) r67).longValue());     // Catch: Throwable -> L322
        if ((r76 instanceof Integer) == true) goto L305;
        r76 = null;
    L305:
        r68 = (Integer) r76;     // Catch: Throwable -> L322
    L307:
        if ((r67 instanceof JSONObject) == false) goto L309;
    L421:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L315
        Object r77 = SDKSettingsCacheManager.a().fromJson(r67.toString(), Integer.class);     // Catch: Throwable -> L315
        if ((r77 instanceof Integer) == true) goto L313;
        r77 = null;
    L313:
        Object r78 = Result.constructor-impl((Integer) r77);     // Catch: Throwable -> L315
    L317:
        r68 = r78;
        if (Result.isFailure-impl(r68) == false) goto L320;
    L315:
        th = move-exception;
        Result.Companion r79 = Result.Companion;     // Catch: Throwable -> L322
        r78 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L322
        goto L317
    L309:
        if ((r67 instanceof JSONArray) == false) goto L319;
    L279:
        r73 = r67;
    L347:
        th = move-exception;
        Result.Companion r80 = Result.Companion;     // Catch: Throwable -> L356
        r57 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L356
        Throwable r81 = Result.exceptionOrNull-impl(r57);     // Catch: Throwable -> L356
        if (r81 == null) goto L352;
        EnsureManager.ensureNotReachHere(r81);     // Catch: Throwable -> L356
    L352:
        if (Result.isFailure-impl(r57) == false) goto L354;
    L322:
        th = move-exception;
        Result.Companion r82 = Result.Companion;     // Catch: Throwable -> L347
        r69 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L347
        goto L324
    L207:
        if ((r61 instanceof Integer) == true) goto L209;
        Object r83 = null;
    L210:
        r62 = (Integer) r83;     // Catch: Throwable -> L252
        if (r62 != null) goto L250;
        if ((r61 instanceof Number) == false) goto L237;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L222;
        Float r84 = Float.valueOf(((Number) r61).floatValue());     // Catch: Throwable -> L252
        if ((r84 instanceof Integer) == true) goto L220;
        r84 = null;
    L220:
        r62 = (Integer) r84;     // Catch: Throwable -> L252
        goto L250
    L222:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L228;
        Double r85 = Double.valueOf(((Number) r61).doubleValue());     // Catch: Throwable -> L252
        if ((r85 instanceof Integer) == true) goto L226;
        r85 = null;
    L226:
        r62 = (Integer) r85;     // Catch: Throwable -> L252
        goto L250
    L228:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L231;
        r62 = Integer.valueOf(((Number) r61).intValue());     // Catch: Throwable -> L252
        goto L250
    L231:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L237;
        Long r86 = Long.valueOf(((Number) r61).longValue());     // Catch: Throwable -> L252
        if ((r86 instanceof Integer) == true) goto L235;
        r86 = null;
    L235:
        r62 = (Integer) r86;     // Catch: Throwable -> L252
    L237:
        if ((r61 instanceof JSONObject) == false) goto L239;
    L419:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L245
        Object r87 = SDKSettingsCacheManager.a().fromJson(r61.toString(), Integer.class);     // Catch: Throwable -> L245
        if ((r87 instanceof Integer) == true) goto L243;
        r87 = null;
    L243:
        Object r88 = Result.constructor-impl((Integer) r87);     // Catch: Throwable -> L245
    L247:
        r62 = r88;
        if (Result.isFailure-impl(r62) == false) goto L250;
    L245:
        th = move-exception;
        Result.Companion r89 = Result.Companion;     // Catch: Throwable -> L252
        r88 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L252
        goto L247
    L239:
        if ((r61 instanceof JSONArray) == false) goto L249;
    L209:
        r83 = r61;
    L356:
        th = move-exception;
        Result.Companion r90 = Result.Companion;
        r57 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r91 = Result.exceptionOrNull-impl(r57);
        if (r91 == null) goto L361;
        EnsureManager.ensureNotReachHere(r91);
    L361:
        if (Result.isFailure-impl(r57) == false) goto L201;
    L252:
        th = move-exception;
        Result.Companion r92 = Result.Companion;     // Catch: Throwable -> L356
        r63 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L356
        goto L254
    L424:
        return true;
    L9:
        th = move-exception;
        Result.Companion r93 = Result.Companion;
        Object r94 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r94) == true) goto L14;
        r2 = r94;
    L14:
        r3 = r2;
        goto L16
    L423:
        return true;
    }

    public static void b(Context r3, String r4) {
        Pair[] r0 = new Pair[4];
        r0[0] = TuplesKt.to("store_type", "shop");
        r0[1] = TuplesKt.to("error", r4);
        Activity r5 = l0.b(r3);
        Map r1 = null;
        if (r5 == null) goto L5;
        String r6 = r5.getLocalClassName();
    L6:
        r0[2] = TuplesKt.to("entrance_local_class_name", r6);
        Activity r7 = l0.b(r3);
        if (r7 == null) goto L9;
        String r8 = r7.getClass().getSimpleName();
    L10:
        r0[3] = TuplesKt.to("entrance_class_simple_name", r8);
        Map r9 = MapsKt.mutableMapOf(r0);
        g r10 = g.a;
        if ((r9 instanceof Map) == false) goto L14;
        r1 = r9;
    L14:
        if (r1 != null) goto L16;
        r1 = MapsKt.emptyMap();
    L16:
        r10.logV3("shop_entrance_checker", new JSONObject(r1));
        return;
    L9:
        r8 = null;
        goto L10
    L5:
        r6 = null;
        goto L6
    }
}
