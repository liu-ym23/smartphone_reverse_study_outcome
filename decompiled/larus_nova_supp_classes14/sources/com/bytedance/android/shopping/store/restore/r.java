package com.bytedance.android.shopping.store.restore;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class r {
    public static final /* synthetic */ int a = 0;

    public static boolean a() {
        ConcurrentHashMap<String, Object> r0 = ECShopABSettings.a;
        Object r1 = 0;
        Object r5 = null;
        if (Intrinsics.areEqual("ec_shop_state_restore_enable", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (ECShopABSettings.b != null) goto L173;
        int r4 = com.bytedance.android.ec.core.opt.ab.n.a;
        int r6 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L163
        Object r8 = com.bytedance.android.ec.base.settings.d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r8 != null) goto L12;
    L54:
        Object r9 = null;
    L55:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L57
    L59:
        Throwable r11 = Result.exceptionOrNull-impl(r10);     // Catch: Throwable -> L163
        if (r11 == null) goto L63;
        EnsureManager.ensureNotReachHere(r11);     // Catch: Throwable -> L163
    L63:
        if (Result.isFailure-impl(r10) == false) goto L66;
        r10 = null;
    L66:
        if ((r10 instanceof Integer) == true) goto L68;
        r10 = null;
    L68:
        Object r12 = (Integer) r10;     // Catch: Throwable -> L163
        if (r12 != null) goto L75;
        Object r13 = com.bytedance.android.ec.base.settings.d.a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r13 instanceof Integer) == true) goto L74;
        r13 = null;
    L74:
        r12 = (Integer) r13;     // Catch: Throwable -> L163
    L75:
        if (r12 != null) goto L172;
        int r14 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L163
        Object r15 = com.bytedance.android.ec.base.settings.d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r15 != null) goto L82;
    L124:
        Object r16 = null;
    L125:
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L127
    L129:
        Throwable r18 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L154
        if (r18 == null) goto L133;
        EnsureManager.ensureNotReachHere(r18);     // Catch: Throwable -> L154
    L133:
        if (Result.isFailure-impl(r17) == false) goto L136;
        r17 = null;
    L136:
        if ((r17 instanceof Integer) == true) goto L138;
        r17 = null;
    L138:
        r12 = (Integer) r17;     // Catch: Throwable -> L154
        if (r12 != null) goto L161;
        IHybridHostService r19 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r19 == null) goto L144;
        Object r20 = r19.getHostABValue("ec_shop_launch_opt_common_2", r1);     // Catch: Throwable -> L154
    L145:
        if (r20 != null) goto L147;
    L160:
        r12 = r1;
        goto L161
    L147:
        if ((r20 instanceof Integer) == false) goto L150;
        r5 = r20;
    L150:
        Integer r21 = (Integer) r5;     // Catch: Throwable -> L154
        if (r21 == null) goto L160;
        r12 = r21;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L163
        r12 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r23 = Result.exceptionOrNull-impl(r12);     // Catch: Throwable -> L163
        if (r23 == null) goto L159;
        EnsureManager.ensureNotReachHere(r23);     // Catch: Throwable -> L163
    L159:
        if (Result.isFailure-impl(r12) == false) goto L161;
    L144:
        r20 = null;
    L161:
        com.bytedance.android.ec.base.settings.d.d("ec_shop_launch_opt_common_2", r12);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r15 instanceof Integer) == true) goto L84;
        Object r24 = null;
    L85:
        r16 = (Integer) r24;     // Catch: Throwable -> L127
        if (r16 != null) goto L125;
        if ((r15 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r25 = Float.valueOf(((Number) r15).floatValue());     // Catch: Throwable -> L127
        if ((r25 instanceof Integer) == true) goto L95;
        r25 = null;
    L95:
        r16 = (Integer) r25;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r26 = Double.valueOf(((Number) r15).doubleValue());     // Catch: Throwable -> L127
        if ((r26 instanceof Integer) == true) goto L101;
        r26 = null;
    L101:
        r16 = (Integer) r26;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r16 = Integer.valueOf(((Number) r15).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r27 = Long.valueOf(((Number) r15).longValue());     // Catch: Throwable -> L127
        if ((r27 instanceof Integer) == true) goto L110;
        r27 = null;
    L110:
        r16 = (Integer) r27;     // Catch: Throwable -> L127
    L112:
        if ((r15 instanceof JSONObject) == false) goto L114;
    L366:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L120
        Object r28 = SDKSettingsCacheManager.a().fromJson(r15.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r28 instanceof Integer) == true) goto L118;
        r28 = null;
    L118:
        Object r29 = Result.constructor-impl((Integer) r28);     // Catch: Throwable -> L120
    L122:
        r16 = r29;
        if (Result.isFailure-impl(r16) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L127
        r29 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r15 instanceof JSONArray) == false) goto L124;
    L84:
        r24 = r15;
    L127:
        th = move-exception;
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L154
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        ECShopABSettings.b = (Integer) r12;
        goto L173
    L12:
        if ((r8 instanceof Integer) == true) goto L14;
        Object r32 = null;
    L15:
        r9 = (Integer) r32;     // Catch: Throwable -> L57
        if (r9 != null) goto L55;
        if ((r8 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r33 = Float.valueOf(((Number) r8).floatValue());     // Catch: Throwable -> L57
        if ((r33 instanceof Integer) == true) goto L25;
        r33 = null;
    L25:
        r9 = (Integer) r33;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r34 = Double.valueOf(((Number) r8).doubleValue());     // Catch: Throwable -> L57
        if ((r34 instanceof Integer) == true) goto L31;
        r34 = null;
    L31:
        r9 = (Integer) r34;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r9 = Integer.valueOf(((Number) r8).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r35 = Long.valueOf(((Number) r8).longValue());     // Catch: Throwable -> L57
        if ((r35 instanceof Integer) == true) goto L40;
        r35 = null;
    L40:
        r9 = (Integer) r35;     // Catch: Throwable -> L57
    L42:
        if ((r8 instanceof JSONObject) == false) goto L44;
    L364:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r36 = SDKSettingsCacheManager.a().fromJson(r8.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r36 instanceof Integer) == true) goto L48;
        r36 = null;
    L48:
        Object r37 = Result.constructor-impl((Integer) r36);     // Catch: Throwable -> L50
    L52:
        r9 = r37;
        if (Result.isFailure-impl(r9) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L57
        r37 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r8 instanceof JSONArray) == false) goto L54;
    L14:
        r32 = r8;
    L57:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L163
        r10 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        Object r3 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r41 = Result.exceptionOrNull-impl(r3);
        if (r41 == null) goto L168;
        EnsureManager.ensureNotReachHere(r41);
    L168:
        if (Result.isFailure-impl(r3) == true) goto L171;
        r1 = r3;
    L171:
        r12 = r1;
    L173:
        r1 = ECShopABSettings.b;
        if (r1 == null) goto L177;
    L352:
        ECShopABSettings.a.put("ec_shop_state_restore_enable", r1);
        if (((Number) r1).intValue() != 1) goto L381;
        return true;
    L381:
        return false;
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r42 = com.bytedance.android.ec.core.opt.ab.p.a;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r44 = jj4.b.b;     // Catch: Throwable -> L185
        Object r45 = jj4.a.a("ec_shop_state_restore_enable", Integer.class, r1, false);     // Catch: Throwable -> L185
        if (r45 != null) goto L189;
        Intrinsics.throwNpe();     // Catch: Throwable -> L185
    L189:
        r1 = r45;
    L185:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r45) == false) goto L189;
    L190:
        int r47 = com.bytedance.android.ec.core.opt.ab.n.a;
        int r48 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L346
        Object r50 = com.bytedance.android.ec.base.settings.d.c.get("ec_shop_state_restore_enable");     // Catch: Throwable -> L241
        if (r50 != null) goto L196;
    L238:
        Object r51 = null;
    L239:
        Object r52 = Result.constructor-impl(r51);     // Catch: Throwable -> L241
    L243:
        Throwable r53 = Result.exceptionOrNull-impl(r52);     // Catch: Throwable -> L346
        if (r53 == null) goto L247;
        EnsureManager.ensureNotReachHere(r53);     // Catch: Throwable -> L346
    L247:
        if (Result.isFailure-impl(r52) == false) goto L250;
        r52 = null;
    L250:
        if ((r52 instanceof Integer) == true) goto L252;
        r52 = null;
    L252:
        r45 = (Integer) r52;     // Catch: Throwable -> L346
        if (r45 != null) goto L259;
        Object r54 = com.bytedance.android.ec.base.settings.d.a.get("ec_shop_state_restore_enable");     // Catch: Throwable -> L346
        if ((r54 instanceof Integer) == true) goto L258;
        r54 = null;
    L258:
        r45 = (Integer) r54;     // Catch: Throwable -> L346
    L259:
        if (r45 != null) goto L189;
        int r55 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L346
        Object r56 = com.bytedance.android.ec.base.settings.d.c.get("ec_shop_state_restore_enable");     // Catch: Throwable -> L311
        if (r56 != null) goto L266;
    L308:
        Object r57 = null;
    L309:
        Object r58 = Result.constructor-impl(r57);     // Catch: Throwable -> L311
    L313:
        Throwable r59 = Result.exceptionOrNull-impl(r58);     // Catch: Throwable -> L337
        if (r59 == null) goto L317;
        EnsureManager.ensureNotReachHere(r59);     // Catch: Throwable -> L337
    L317:
        if (Result.isFailure-impl(r58) == false) goto L320;
        r58 = null;
    L320:
        if ((r58 instanceof Integer) == true) goto L322;
        r58 = null;
    L322:
        r45 = (Integer) r58;     // Catch: Throwable -> L337
        if (r45 != null) goto L344;
        IHybridHostService r60 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L337
        if (r60 == null) goto L328;
        Object r61 = r60.getHostABValue("ec_shop_state_restore_enable", r1);     // Catch: Throwable -> L337
    L329:
        if (r61 != null) goto L331;
    L343:
        r45 = r1;
        goto L344
    L331:
        if ((r61 instanceof Integer) == false) goto L334;
        r5 = r61;
    L334:
        r45 = (Integer) r5;     // Catch: Throwable -> L337
        if (r45 != null) goto L344;
    L328:
        r61 = null;
    L344:
        com.bytedance.android.ec.base.settings.d.d("ec_shop_state_restore_enable", r45);     // Catch: Throwable -> L346
        goto L189
    L266:
        if ((r56 instanceof Integer) == true) goto L268;
        Object r62 = null;
    L269:
        r57 = (Integer) r62;     // Catch: Throwable -> L311
        if (r57 != null) goto L309;
        if ((r56 instanceof Number) == false) goto L296;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L281;
        Float r63 = Float.valueOf(((Number) r56).floatValue());     // Catch: Throwable -> L311
        if ((r63 instanceof Integer) == true) goto L279;
        r63 = null;
    L279:
        r57 = (Integer) r63;     // Catch: Throwable -> L311
        goto L309
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L287;
        Double r64 = Double.valueOf(((Number) r56).doubleValue());     // Catch: Throwable -> L311
        if ((r64 instanceof Integer) == true) goto L285;
        r64 = null;
    L285:
        r57 = (Integer) r64;     // Catch: Throwable -> L311
        goto L309
    L287:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L290;
        r57 = Integer.valueOf(((Number) r56).intValue());     // Catch: Throwable -> L311
        goto L309
    L290:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L296;
        Long r65 = Long.valueOf(((Number) r56).longValue());     // Catch: Throwable -> L311
        if ((r65 instanceof Integer) == true) goto L294;
        r65 = null;
    L294:
        r57 = (Integer) r65;     // Catch: Throwable -> L311
    L296:
        if ((r56 instanceof JSONObject) == false) goto L298;
    L379:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L304
        Object r66 = SDKSettingsCacheManager.a().fromJson(r56.toString(), Integer.class);     // Catch: Throwable -> L304
        if ((r66 instanceof Integer) == true) goto L302;
        r66 = null;
    L302:
        Object r67 = Result.constructor-impl((Integer) r66);     // Catch: Throwable -> L304
    L306:
        r57 = r67;
        if (Result.isFailure-impl(r57) == false) goto L309;
    L304:
        th = move-exception;
        Result.Companion r68 = Result.Companion;     // Catch: Throwable -> L311
        r67 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L311
        goto L306
    L298:
        if ((r56 instanceof JSONArray) == false) goto L308;
    L268:
        r62 = r56;
    L337:
        th = move-exception;
        Result.Companion r69 = Result.Companion;     // Catch: Throwable -> L346
        r45 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L346
        Throwable r70 = Result.exceptionOrNull-impl(r45);     // Catch: Throwable -> L346
        if (r70 == null) goto L342;
        EnsureManager.ensureNotReachHere(r70);     // Catch: Throwable -> L346
    L342:
        if (Result.isFailure-impl(r45) == false) goto L344;
    L311:
        th = move-exception;
        Result.Companion r71 = Result.Companion;     // Catch: Throwable -> L337
        r58 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L337
        goto L313
    L196:
        if ((r50 instanceof Integer) == true) goto L198;
        Object r72 = null;
    L199:
        r51 = (Integer) r72;     // Catch: Throwable -> L241
        if (r51 != null) goto L239;
        if ((r50 instanceof Number) == false) goto L226;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L211;
        Float r73 = Float.valueOf(((Number) r50).floatValue());     // Catch: Throwable -> L241
        if ((r73 instanceof Integer) == true) goto L209;
        r73 = null;
    L209:
        r51 = (Integer) r73;     // Catch: Throwable -> L241
        goto L239
    L211:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L217;
        Double r74 = Double.valueOf(((Number) r50).doubleValue());     // Catch: Throwable -> L241
        if ((r74 instanceof Integer) == true) goto L215;
        r74 = null;
    L215:
        r51 = (Integer) r74;     // Catch: Throwable -> L241
        goto L239
    L217:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L220;
        r51 = Integer.valueOf(((Number) r50).intValue());     // Catch: Throwable -> L241
        goto L239
    L220:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L226;
        Long r75 = Long.valueOf(((Number) r50).longValue());     // Catch: Throwable -> L241
        if ((r75 instanceof Integer) == true) goto L224;
        r75 = null;
    L224:
        r51 = (Integer) r75;     // Catch: Throwable -> L241
    L226:
        if ((r50 instanceof JSONObject) == false) goto L228;
    L377:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L234
        Object r76 = SDKSettingsCacheManager.a().fromJson(r50.toString(), Integer.class);     // Catch: Throwable -> L234
        if ((r76 instanceof Integer) == true) goto L232;
        r76 = null;
    L232:
        Object r77 = Result.constructor-impl((Integer) r76);     // Catch: Throwable -> L234
    L236:
        r51 = r77;
        if (Result.isFailure-impl(r51) == false) goto L239;
    L234:
        th = move-exception;
        Result.Companion r78 = Result.Companion;     // Catch: Throwable -> L241
        r77 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L241
        goto L236
    L228:
        if ((r50 instanceof JSONArray) == false) goto L238;
    L198:
        r72 = r50;
    L241:
        th = move-exception;
        Result.Companion r79 = Result.Companion;     // Catch: Throwable -> L346
        r52 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L346
    L346:
        th = move-exception;
        Result.Companion r80 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r81 = Result.exceptionOrNull-impl(r45);
        if (r81 == null) goto L351;
        EnsureManager.ensureNotReachHere(r81);
    L351:
        if (Result.isFailure-impl(r45) == false) goto L189;
        goto L189
    }

    public static boolean b() {
        if (c() == false) goto L383;
        Object r0 = 0;
        Object r5 = null;
        if (Intrinsics.areEqual("ec_shop_state_restore_product_full_enable", "ec_shop_launch_opt_common_2") == false) goto L181;
        if (ECShopABSettings.b != null) goto L175;
        int r4 = com.bytedance.android.ec.core.opt.ab.n.a;
        int r6 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L165
        Object r8 = com.bytedance.android.ec.base.settings.d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L59
        if (r8 != null) goto L14;
    L56:
        Object r9 = null;
    L57:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L59
    L61:
        Throwable r11 = Result.exceptionOrNull-impl(r10);     // Catch: Throwable -> L165
        if (r11 == null) goto L65;
        EnsureManager.ensureNotReachHere(r11);     // Catch: Throwable -> L165
    L65:
        if (Result.isFailure-impl(r10) == false) goto L68;
        r10 = null;
    L68:
        if ((r10 instanceof Integer) == true) goto L70;
        r10 = null;
    L70:
        Object r12 = (Integer) r10;     // Catch: Throwable -> L165
        if (r12 != null) goto L77;
        Object r13 = com.bytedance.android.ec.base.settings.d.a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L165
        if ((r13 instanceof Integer) == true) goto L76;
        r13 = null;
    L76:
        r12 = (Integer) r13;     // Catch: Throwable -> L165
    L77:
        if (r12 != null) goto L174;
        int r14 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L165
        Object r15 = com.bytedance.android.ec.base.settings.d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L129
        if (r15 != null) goto L84;
    L126:
        Object r16 = null;
    L127:
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L129
    L131:
        Throwable r18 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L156
        if (r18 == null) goto L135;
        EnsureManager.ensureNotReachHere(r18);     // Catch: Throwable -> L156
    L135:
        if (Result.isFailure-impl(r17) == false) goto L138;
        r17 = null;
    L138:
        if ((r17 instanceof Integer) == true) goto L140;
        r17 = null;
    L140:
        r12 = (Integer) r17;     // Catch: Throwable -> L156
        if (r12 != null) goto L163;
        IHybridHostService r19 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r19 == null) goto L146;
        Object r20 = r19.getHostABValue("ec_shop_launch_opt_common_2", r0);     // Catch: Throwable -> L156
    L147:
        if (r20 != null) goto L149;
    L162:
        r12 = r0;
        goto L163
    L149:
        if ((r20 instanceof Integer) == false) goto L152;
        r5 = r20;
    L152:
        Integer r21 = (Integer) r5;     // Catch: Throwable -> L156
        if (r21 == null) goto L162;
        r12 = r21;
        goto L163
    L156:
        th = move-exception;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L165
        r12 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
        Throwable r23 = Result.exceptionOrNull-impl(r12);     // Catch: Throwable -> L165
        if (r23 == null) goto L161;
        EnsureManager.ensureNotReachHere(r23);     // Catch: Throwable -> L165
    L161:
        if (Result.isFailure-impl(r12) == false) goto L163;
    L146:
        r20 = null;
    L163:
        com.bytedance.android.ec.base.settings.d.d("ec_shop_launch_opt_common_2", r12);     // Catch: Throwable -> L165
        goto L174
    L84:
        if ((r15 instanceof Integer) == true) goto L86;
        Object r24 = null;
    L87:
        r16 = (Integer) r24;     // Catch: Throwable -> L129
        if (r16 != null) goto L127;
        if ((r15 instanceof Number) == false) goto L114;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L99;
        Float r25 = Float.valueOf(((Number) r15).floatValue());     // Catch: Throwable -> L129
        if ((r25 instanceof Integer) == true) goto L97;
        r25 = null;
    L97:
        r16 = (Integer) r25;     // Catch: Throwable -> L129
        goto L127
    L99:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L105;
        Double r26 = Double.valueOf(((Number) r15).doubleValue());     // Catch: Throwable -> L129
        if ((r26 instanceof Integer) == true) goto L103;
        r26 = null;
    L103:
        r16 = (Integer) r26;     // Catch: Throwable -> L129
        goto L127
    L105:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L108;
        r16 = Integer.valueOf(((Number) r15).intValue());     // Catch: Throwable -> L129
        goto L127
    L108:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L114;
        Long r27 = Long.valueOf(((Number) r15).longValue());     // Catch: Throwable -> L129
        if ((r27 instanceof Integer) == true) goto L112;
        r27 = null;
    L112:
        r16 = (Integer) r27;     // Catch: Throwable -> L129
    L114:
        if ((r15 instanceof JSONObject) == false) goto L116;
    L368:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L122
        Object r28 = SDKSettingsCacheManager.a().fromJson(r15.toString(), Integer.class);     // Catch: Throwable -> L122
        if ((r28 instanceof Integer) == true) goto L120;
        r28 = null;
    L120:
        Object r29 = Result.constructor-impl((Integer) r28);     // Catch: Throwable -> L122
    L124:
        r16 = r29;
        if (Result.isFailure-impl(r16) == false) goto L127;
    L122:
        th = move-exception;
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L129
        r29 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L129
        goto L124
    L116:
        if ((r15 instanceof JSONArray) == false) goto L126;
    L86:
        r24 = r15;
    L129:
        th = move-exception;
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L156
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L174:
        ECShopABSettings.b = (Integer) r12;
        goto L175
    L14:
        if ((r8 instanceof Integer) == true) goto L16;
        Object r32 = null;
    L17:
        r9 = (Integer) r32;     // Catch: Throwable -> L59
        if (r9 != null) goto L57;
        if ((r8 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L29;
        Float r33 = Float.valueOf(((Number) r8).floatValue());     // Catch: Throwable -> L59
        if ((r33 instanceof Integer) == true) goto L27;
        r33 = null;
    L27:
        r9 = (Integer) r33;     // Catch: Throwable -> L59
        goto L57
    L29:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L35;
        Double r34 = Double.valueOf(((Number) r8).doubleValue());     // Catch: Throwable -> L59
        if ((r34 instanceof Integer) == true) goto L33;
        r34 = null;
    L33:
        r9 = (Integer) r34;     // Catch: Throwable -> L59
        goto L57
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        r9 = Integer.valueOf(((Number) r8).intValue());     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r35 = Long.valueOf(((Number) r8).longValue());     // Catch: Throwable -> L59
        if ((r35 instanceof Integer) == true) goto L42;
        r35 = null;
    L42:
        r9 = (Integer) r35;     // Catch: Throwable -> L59
    L44:
        if ((r8 instanceof JSONObject) == false) goto L46;
    L366:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L52
        Object r36 = SDKSettingsCacheManager.a().fromJson(r8.toString(), Integer.class);     // Catch: Throwable -> L52
        if ((r36 instanceof Integer) == true) goto L50;
        r36 = null;
    L50:
        Object r37 = Result.constructor-impl((Integer) r36);     // Catch: Throwable -> L52
    L54:
        r9 = r37;
        if (Result.isFailure-impl(r9) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L59
        r37 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r8 instanceof JSONArray) == false) goto L56;
    L16:
        r32 = r8;
    L59:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L165
        r10 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
    L165:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        Object r3 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r41 = Result.exceptionOrNull-impl(r3);
        if (r41 == null) goto L170;
        EnsureManager.ensureNotReachHere(r41);
    L170:
        if (Result.isFailure-impl(r3) == true) goto L173;
        r0 = r3;
    L173:
        r12 = r0;
    L175:
        r0 = ECShopABSettings.b;
        if (r0 == null) goto L179;
    L354:
        ECShopABSettings.a.put("ec_shop_state_restore_product_full_enable", r0);
        if (((Number) r0).intValue() != 1) goto L384;
        return true;
    L384:
        return false;
    L179:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L181:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L192;
        int r42 = com.bytedance.android.ec.core.opt.ab.p.a;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L187
        jj4.b r44 = jj4.b.b;     // Catch: Throwable -> L187
        Object r45 = jj4.a.a("ec_shop_state_restore_product_full_enable", Integer.class, r0, false);     // Catch: Throwable -> L187
        if (r45 != null) goto L191;
        Intrinsics.throwNpe();     // Catch: Throwable -> L187
    L191:
        r0 = r45;
    L187:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r45) == false) goto L191;
    L192:
        int r47 = com.bytedance.android.ec.core.opt.ab.n.a;
        int r48 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L348
        Object r50 = com.bytedance.android.ec.base.settings.d.c.get("ec_shop_state_restore_product_full_enable");     // Catch: Throwable -> L243
        if (r50 != null) goto L198;
    L240:
        Object r51 = null;
    L241:
        Object r52 = Result.constructor-impl(r51);     // Catch: Throwable -> L243
    L245:
        Throwable r53 = Result.exceptionOrNull-impl(r52);     // Catch: Throwable -> L348
        if (r53 == null) goto L249;
        EnsureManager.ensureNotReachHere(r53);     // Catch: Throwable -> L348
    L249:
        if (Result.isFailure-impl(r52) == false) goto L252;
        r52 = null;
    L252:
        if ((r52 instanceof Integer) == true) goto L254;
        r52 = null;
    L254:
        r45 = (Integer) r52;     // Catch: Throwable -> L348
        if (r45 != null) goto L261;
        Object r54 = com.bytedance.android.ec.base.settings.d.a.get("ec_shop_state_restore_product_full_enable");     // Catch: Throwable -> L348
        if ((r54 instanceof Integer) == true) goto L260;
        r54 = null;
    L260:
        r45 = (Integer) r54;     // Catch: Throwable -> L348
    L261:
        if (r45 != null) goto L191;
        int r55 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L348
        Object r56 = com.bytedance.android.ec.base.settings.d.c.get("ec_shop_state_restore_product_full_enable");     // Catch: Throwable -> L313
        if (r56 != null) goto L268;
    L310:
        Object r57 = null;
    L311:
        Object r58 = Result.constructor-impl(r57);     // Catch: Throwable -> L313
    L315:
        Throwable r59 = Result.exceptionOrNull-impl(r58);     // Catch: Throwable -> L339
        if (r59 == null) goto L319;
        EnsureManager.ensureNotReachHere(r59);     // Catch: Throwable -> L339
    L319:
        if (Result.isFailure-impl(r58) == false) goto L322;
        r58 = null;
    L322:
        if ((r58 instanceof Integer) == true) goto L324;
        r58 = null;
    L324:
        r45 = (Integer) r58;     // Catch: Throwable -> L339
        if (r45 != null) goto L346;
        IHybridHostService r60 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L339
        if (r60 == null) goto L330;
        Object r61 = r60.getHostABValue("ec_shop_state_restore_product_full_enable", r0);     // Catch: Throwable -> L339
    L331:
        if (r61 != null) goto L333;
    L345:
        r45 = r0;
        goto L346
    L333:
        if ((r61 instanceof Integer) == false) goto L336;
        r5 = r61;
    L336:
        r45 = (Integer) r5;     // Catch: Throwable -> L339
        if (r45 != null) goto L346;
    L330:
        r61 = null;
    L346:
        com.bytedance.android.ec.base.settings.d.d("ec_shop_state_restore_product_full_enable", r45);     // Catch: Throwable -> L348
        goto L191
    L268:
        if ((r56 instanceof Integer) == true) goto L270;
        Object r62 = null;
    L271:
        r57 = (Integer) r62;     // Catch: Throwable -> L313
        if (r57 != null) goto L311;
        if ((r56 instanceof Number) == false) goto L298;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L283;
        Float r63 = Float.valueOf(((Number) r56).floatValue());     // Catch: Throwable -> L313
        if ((r63 instanceof Integer) == true) goto L281;
        r63 = null;
    L281:
        r57 = (Integer) r63;     // Catch: Throwable -> L313
        goto L311
    L283:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L289;
        Double r64 = Double.valueOf(((Number) r56).doubleValue());     // Catch: Throwable -> L313
        if ((r64 instanceof Integer) == true) goto L287;
        r64 = null;
    L287:
        r57 = (Integer) r64;     // Catch: Throwable -> L313
        goto L311
    L289:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L292;
        r57 = Integer.valueOf(((Number) r56).intValue());     // Catch: Throwable -> L313
        goto L311
    L292:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L298;
        Long r65 = Long.valueOf(((Number) r56).longValue());     // Catch: Throwable -> L313
        if ((r65 instanceof Integer) == true) goto L296;
        r65 = null;
    L296:
        r57 = (Integer) r65;     // Catch: Throwable -> L313
    L298:
        if ((r56 instanceof JSONObject) == false) goto L300;
    L381:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L306
        Object r66 = SDKSettingsCacheManager.a().fromJson(r56.toString(), Integer.class);     // Catch: Throwable -> L306
        if ((r66 instanceof Integer) == true) goto L304;
        r66 = null;
    L304:
        Object r67 = Result.constructor-impl((Integer) r66);     // Catch: Throwable -> L306
    L308:
        r57 = r67;
        if (Result.isFailure-impl(r57) == false) goto L311;
    L306:
        th = move-exception;
        Result.Companion r68 = Result.Companion;     // Catch: Throwable -> L313
        r67 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L313
        goto L308
    L300:
        if ((r56 instanceof JSONArray) == false) goto L310;
    L270:
        r62 = r56;
    L339:
        th = move-exception;
        Result.Companion r69 = Result.Companion;     // Catch: Throwable -> L348
        r45 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L348
        Throwable r70 = Result.exceptionOrNull-impl(r45);     // Catch: Throwable -> L348
        if (r70 == null) goto L344;
        EnsureManager.ensureNotReachHere(r70);     // Catch: Throwable -> L348
    L344:
        if (Result.isFailure-impl(r45) == false) goto L346;
    L313:
        th = move-exception;
        Result.Companion r71 = Result.Companion;     // Catch: Throwable -> L339
        r58 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L339
        goto L315
    L198:
        if ((r50 instanceof Integer) == true) goto L200;
        Object r72 = null;
    L201:
        r51 = (Integer) r72;     // Catch: Throwable -> L243
        if (r51 != null) goto L241;
        if ((r50 instanceof Number) == false) goto L228;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L213;
        Float r73 = Float.valueOf(((Number) r50).floatValue());     // Catch: Throwable -> L243
        if ((r73 instanceof Integer) == true) goto L211;
        r73 = null;
    L211:
        r51 = (Integer) r73;     // Catch: Throwable -> L243
        goto L241
    L213:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L219;
        Double r74 = Double.valueOf(((Number) r50).doubleValue());     // Catch: Throwable -> L243
        if ((r74 instanceof Integer) == true) goto L217;
        r74 = null;
    L217:
        r51 = (Integer) r74;     // Catch: Throwable -> L243
        goto L241
    L219:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L222;
        r51 = Integer.valueOf(((Number) r50).intValue());     // Catch: Throwable -> L243
        goto L241
    L222:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L228;
        Long r75 = Long.valueOf(((Number) r50).longValue());     // Catch: Throwable -> L243
        if ((r75 instanceof Integer) == true) goto L226;
        r75 = null;
    L226:
        r51 = (Integer) r75;     // Catch: Throwable -> L243
    L228:
        if ((r50 instanceof JSONObject) == false) goto L230;
    L379:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L236
        Object r76 = SDKSettingsCacheManager.a().fromJson(r50.toString(), Integer.class);     // Catch: Throwable -> L236
        if ((r76 instanceof Integer) == true) goto L234;
        r76 = null;
    L234:
        Object r77 = Result.constructor-impl((Integer) r76);     // Catch: Throwable -> L236
    L238:
        r51 = r77;
        if (Result.isFailure-impl(r51) == false) goto L241;
    L236:
        th = move-exception;
        Result.Companion r78 = Result.Companion;     // Catch: Throwable -> L243
        r77 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L243
        goto L238
    L230:
        if ((r50 instanceof JSONArray) == false) goto L240;
    L200:
        r72 = r50;
    L243:
        th = move-exception;
        Result.Companion r79 = Result.Companion;     // Catch: Throwable -> L348
        r52 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L348
    L348:
        th = move-exception;
        Result.Companion r80 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r81 = Result.exceptionOrNull-impl(r45);
        if (r81 == null) goto L353;
        EnsureManager.ensureNotReachHere(r81);
    L353:
        if (Result.isFailure-impl(r45) == false) goto L191;
    L383:
        return false;
    }

    public static boolean c() {
        if (a() == false) goto L383;
        Object r0 = 0;
        Object r5 = null;
        if (Intrinsics.areEqual("ec_shop_state_restore_product_enable", "ec_shop_launch_opt_common_2") == false) goto L181;
        if (ECShopABSettings.b != null) goto L175;
        int r4 = com.bytedance.android.ec.core.opt.ab.n.a;
        int r6 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L165
        Object r8 = com.bytedance.android.ec.base.settings.d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L59
        if (r8 != null) goto L14;
    L56:
        Object r9 = null;
    L57:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L59
    L61:
        Throwable r11 = Result.exceptionOrNull-impl(r10);     // Catch: Throwable -> L165
        if (r11 == null) goto L65;
        EnsureManager.ensureNotReachHere(r11);     // Catch: Throwable -> L165
    L65:
        if (Result.isFailure-impl(r10) == false) goto L68;
        r10 = null;
    L68:
        if ((r10 instanceof Integer) == true) goto L70;
        r10 = null;
    L70:
        Object r12 = (Integer) r10;     // Catch: Throwable -> L165
        if (r12 != null) goto L77;
        Object r13 = com.bytedance.android.ec.base.settings.d.a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L165
        if ((r13 instanceof Integer) == true) goto L76;
        r13 = null;
    L76:
        r12 = (Integer) r13;     // Catch: Throwable -> L165
    L77:
        if (r12 != null) goto L174;
        int r14 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L165
        Object r15 = com.bytedance.android.ec.base.settings.d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L129
        if (r15 != null) goto L84;
    L126:
        Object r16 = null;
    L127:
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L129
    L131:
        Throwable r18 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L156
        if (r18 == null) goto L135;
        EnsureManager.ensureNotReachHere(r18);     // Catch: Throwable -> L156
    L135:
        if (Result.isFailure-impl(r17) == false) goto L138;
        r17 = null;
    L138:
        if ((r17 instanceof Integer) == true) goto L140;
        r17 = null;
    L140:
        r12 = (Integer) r17;     // Catch: Throwable -> L156
        if (r12 != null) goto L163;
        IHybridHostService r19 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r19 == null) goto L146;
        Object r20 = r19.getHostABValue("ec_shop_launch_opt_common_2", r0);     // Catch: Throwable -> L156
    L147:
        if (r20 != null) goto L149;
    L162:
        r12 = r0;
        goto L163
    L149:
        if ((r20 instanceof Integer) == false) goto L152;
        r5 = r20;
    L152:
        Integer r21 = (Integer) r5;     // Catch: Throwable -> L156
        if (r21 == null) goto L162;
        r12 = r21;
        goto L163
    L156:
        th = move-exception;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L165
        r12 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
        Throwable r23 = Result.exceptionOrNull-impl(r12);     // Catch: Throwable -> L165
        if (r23 == null) goto L161;
        EnsureManager.ensureNotReachHere(r23);     // Catch: Throwable -> L165
    L161:
        if (Result.isFailure-impl(r12) == false) goto L163;
    L146:
        r20 = null;
    L163:
        com.bytedance.android.ec.base.settings.d.d("ec_shop_launch_opt_common_2", r12);     // Catch: Throwable -> L165
        goto L174
    L84:
        if ((r15 instanceof Integer) == true) goto L86;
        Object r24 = null;
    L87:
        r16 = (Integer) r24;     // Catch: Throwable -> L129
        if (r16 != null) goto L127;
        if ((r15 instanceof Number) == false) goto L114;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L99;
        Float r25 = Float.valueOf(((Number) r15).floatValue());     // Catch: Throwable -> L129
        if ((r25 instanceof Integer) == true) goto L97;
        r25 = null;
    L97:
        r16 = (Integer) r25;     // Catch: Throwable -> L129
        goto L127
    L99:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L105;
        Double r26 = Double.valueOf(((Number) r15).doubleValue());     // Catch: Throwable -> L129
        if ((r26 instanceof Integer) == true) goto L103;
        r26 = null;
    L103:
        r16 = (Integer) r26;     // Catch: Throwable -> L129
        goto L127
    L105:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L108;
        r16 = Integer.valueOf(((Number) r15).intValue());     // Catch: Throwable -> L129
        goto L127
    L108:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L114;
        Long r27 = Long.valueOf(((Number) r15).longValue());     // Catch: Throwable -> L129
        if ((r27 instanceof Integer) == true) goto L112;
        r27 = null;
    L112:
        r16 = (Integer) r27;     // Catch: Throwable -> L129
    L114:
        if ((r15 instanceof JSONObject) == false) goto L116;
    L368:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L122
        Object r28 = SDKSettingsCacheManager.a().fromJson(r15.toString(), Integer.class);     // Catch: Throwable -> L122
        if ((r28 instanceof Integer) == true) goto L120;
        r28 = null;
    L120:
        Object r29 = Result.constructor-impl((Integer) r28);     // Catch: Throwable -> L122
    L124:
        r16 = r29;
        if (Result.isFailure-impl(r16) == false) goto L127;
    L122:
        th = move-exception;
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L129
        r29 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L129
        goto L124
    L116:
        if ((r15 instanceof JSONArray) == false) goto L126;
    L86:
        r24 = r15;
    L129:
        th = move-exception;
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L156
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L174:
        ECShopABSettings.b = (Integer) r12;
        goto L175
    L14:
        if ((r8 instanceof Integer) == true) goto L16;
        Object r32 = null;
    L17:
        r9 = (Integer) r32;     // Catch: Throwable -> L59
        if (r9 != null) goto L57;
        if ((r8 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L29;
        Float r33 = Float.valueOf(((Number) r8).floatValue());     // Catch: Throwable -> L59
        if ((r33 instanceof Integer) == true) goto L27;
        r33 = null;
    L27:
        r9 = (Integer) r33;     // Catch: Throwable -> L59
        goto L57
    L29:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L35;
        Double r34 = Double.valueOf(((Number) r8).doubleValue());     // Catch: Throwable -> L59
        if ((r34 instanceof Integer) == true) goto L33;
        r34 = null;
    L33:
        r9 = (Integer) r34;     // Catch: Throwable -> L59
        goto L57
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        r9 = Integer.valueOf(((Number) r8).intValue());     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r35 = Long.valueOf(((Number) r8).longValue());     // Catch: Throwable -> L59
        if ((r35 instanceof Integer) == true) goto L42;
        r35 = null;
    L42:
        r9 = (Integer) r35;     // Catch: Throwable -> L59
    L44:
        if ((r8 instanceof JSONObject) == false) goto L46;
    L366:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L52
        Object r36 = SDKSettingsCacheManager.a().fromJson(r8.toString(), Integer.class);     // Catch: Throwable -> L52
        if ((r36 instanceof Integer) == true) goto L50;
        r36 = null;
    L50:
        Object r37 = Result.constructor-impl((Integer) r36);     // Catch: Throwable -> L52
    L54:
        r9 = r37;
        if (Result.isFailure-impl(r9) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L59
        r37 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r8 instanceof JSONArray) == false) goto L56;
    L16:
        r32 = r8;
    L59:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L165
        r10 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
    L165:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        Object r3 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r41 = Result.exceptionOrNull-impl(r3);
        if (r41 == null) goto L170;
        EnsureManager.ensureNotReachHere(r41);
    L170:
        if (Result.isFailure-impl(r3) == true) goto L173;
        r0 = r3;
    L173:
        r12 = r0;
    L175:
        r0 = ECShopABSettings.b;
        if (r0 == null) goto L179;
    L354:
        ECShopABSettings.a.put("ec_shop_state_restore_product_enable", r0);
        if (((Number) r0).intValue() != 1) goto L384;
        return true;
    L384:
        return false;
    L179:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L181:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L192;
        int r42 = com.bytedance.android.ec.core.opt.ab.p.a;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L187
        jj4.b r44 = jj4.b.b;     // Catch: Throwable -> L187
        Object r45 = jj4.a.a("ec_shop_state_restore_product_enable", Integer.class, r0, false);     // Catch: Throwable -> L187
        if (r45 != null) goto L191;
        Intrinsics.throwNpe();     // Catch: Throwable -> L187
    L191:
        r0 = r45;
    L187:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r45) == false) goto L191;
    L192:
        int r47 = com.bytedance.android.ec.core.opt.ab.n.a;
        int r48 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L348
        Object r50 = com.bytedance.android.ec.base.settings.d.c.get("ec_shop_state_restore_product_enable");     // Catch: Throwable -> L243
        if (r50 != null) goto L198;
    L240:
        Object r51 = null;
    L241:
        Object r52 = Result.constructor-impl(r51);     // Catch: Throwable -> L243
    L245:
        Throwable r53 = Result.exceptionOrNull-impl(r52);     // Catch: Throwable -> L348
        if (r53 == null) goto L249;
        EnsureManager.ensureNotReachHere(r53);     // Catch: Throwable -> L348
    L249:
        if (Result.isFailure-impl(r52) == false) goto L252;
        r52 = null;
    L252:
        if ((r52 instanceof Integer) == true) goto L254;
        r52 = null;
    L254:
        r45 = (Integer) r52;     // Catch: Throwable -> L348
        if (r45 != null) goto L261;
        Object r54 = com.bytedance.android.ec.base.settings.d.a.get("ec_shop_state_restore_product_enable");     // Catch: Throwable -> L348
        if ((r54 instanceof Integer) == true) goto L260;
        r54 = null;
    L260:
        r45 = (Integer) r54;     // Catch: Throwable -> L348
    L261:
        if (r45 != null) goto L191;
        int r55 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L348
        Object r56 = com.bytedance.android.ec.base.settings.d.c.get("ec_shop_state_restore_product_enable");     // Catch: Throwable -> L313
        if (r56 != null) goto L268;
    L310:
        Object r57 = null;
    L311:
        Object r58 = Result.constructor-impl(r57);     // Catch: Throwable -> L313
    L315:
        Throwable r59 = Result.exceptionOrNull-impl(r58);     // Catch: Throwable -> L339
        if (r59 == null) goto L319;
        EnsureManager.ensureNotReachHere(r59);     // Catch: Throwable -> L339
    L319:
        if (Result.isFailure-impl(r58) == false) goto L322;
        r58 = null;
    L322:
        if ((r58 instanceof Integer) == true) goto L324;
        r58 = null;
    L324:
        r45 = (Integer) r58;     // Catch: Throwable -> L339
        if (r45 != null) goto L346;
        IHybridHostService r60 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L339
        if (r60 == null) goto L330;
        Object r61 = r60.getHostABValue("ec_shop_state_restore_product_enable", r0);     // Catch: Throwable -> L339
    L331:
        if (r61 != null) goto L333;
    L345:
        r45 = r0;
        goto L346
    L333:
        if ((r61 instanceof Integer) == false) goto L336;
        r5 = r61;
    L336:
        r45 = (Integer) r5;     // Catch: Throwable -> L339
        if (r45 != null) goto L346;
    L330:
        r61 = null;
    L346:
        com.bytedance.android.ec.base.settings.d.d("ec_shop_state_restore_product_enable", r45);     // Catch: Throwable -> L348
        goto L191
    L268:
        if ((r56 instanceof Integer) == true) goto L270;
        Object r62 = null;
    L271:
        r57 = (Integer) r62;     // Catch: Throwable -> L313
        if (r57 != null) goto L311;
        if ((r56 instanceof Number) == false) goto L298;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L283;
        Float r63 = Float.valueOf(((Number) r56).floatValue());     // Catch: Throwable -> L313
        if ((r63 instanceof Integer) == true) goto L281;
        r63 = null;
    L281:
        r57 = (Integer) r63;     // Catch: Throwable -> L313
        goto L311
    L283:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L289;
        Double r64 = Double.valueOf(((Number) r56).doubleValue());     // Catch: Throwable -> L313
        if ((r64 instanceof Integer) == true) goto L287;
        r64 = null;
    L287:
        r57 = (Integer) r64;     // Catch: Throwable -> L313
        goto L311
    L289:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L292;
        r57 = Integer.valueOf(((Number) r56).intValue());     // Catch: Throwable -> L313
        goto L311
    L292:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L298;
        Long r65 = Long.valueOf(((Number) r56).longValue());     // Catch: Throwable -> L313
        if ((r65 instanceof Integer) == true) goto L296;
        r65 = null;
    L296:
        r57 = (Integer) r65;     // Catch: Throwable -> L313
    L298:
        if ((r56 instanceof JSONObject) == false) goto L300;
    L381:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L306
        Object r66 = SDKSettingsCacheManager.a().fromJson(r56.toString(), Integer.class);     // Catch: Throwable -> L306
        if ((r66 instanceof Integer) == true) goto L304;
        r66 = null;
    L304:
        Object r67 = Result.constructor-impl((Integer) r66);     // Catch: Throwable -> L306
    L308:
        r57 = r67;
        if (Result.isFailure-impl(r57) == false) goto L311;
    L306:
        th = move-exception;
        Result.Companion r68 = Result.Companion;     // Catch: Throwable -> L313
        r67 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L313
        goto L308
    L300:
        if ((r56 instanceof JSONArray) == false) goto L310;
    L270:
        r62 = r56;
    L339:
        th = move-exception;
        Result.Companion r69 = Result.Companion;     // Catch: Throwable -> L348
        r45 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L348
        Throwable r70 = Result.exceptionOrNull-impl(r45);     // Catch: Throwable -> L348
        if (r70 == null) goto L344;
        EnsureManager.ensureNotReachHere(r70);     // Catch: Throwable -> L348
    L344:
        if (Result.isFailure-impl(r45) == false) goto L346;
    L313:
        th = move-exception;
        Result.Companion r71 = Result.Companion;     // Catch: Throwable -> L339
        r58 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L339
        goto L315
    L198:
        if ((r50 instanceof Integer) == true) goto L200;
        Object r72 = null;
    L201:
        r51 = (Integer) r72;     // Catch: Throwable -> L243
        if (r51 != null) goto L241;
        if ((r50 instanceof Number) == false) goto L228;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L213;
        Float r73 = Float.valueOf(((Number) r50).floatValue());     // Catch: Throwable -> L243
        if ((r73 instanceof Integer) == true) goto L211;
        r73 = null;
    L211:
        r51 = (Integer) r73;     // Catch: Throwable -> L243
        goto L241
    L213:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L219;
        Double r74 = Double.valueOf(((Number) r50).doubleValue());     // Catch: Throwable -> L243
        if ((r74 instanceof Integer) == true) goto L217;
        r74 = null;
    L217:
        r51 = (Integer) r74;     // Catch: Throwable -> L243
        goto L241
    L219:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L222;
        r51 = Integer.valueOf(((Number) r50).intValue());     // Catch: Throwable -> L243
        goto L241
    L222:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L228;
        Long r75 = Long.valueOf(((Number) r50).longValue());     // Catch: Throwable -> L243
        if ((r75 instanceof Integer) == true) goto L226;
        r75 = null;
    L226:
        r51 = (Integer) r75;     // Catch: Throwable -> L243
    L228:
        if ((r50 instanceof JSONObject) == false) goto L230;
    L379:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L236
        Object r76 = SDKSettingsCacheManager.a().fromJson(r50.toString(), Integer.class);     // Catch: Throwable -> L236
        if ((r76 instanceof Integer) == true) goto L234;
        r76 = null;
    L234:
        Object r77 = Result.constructor-impl((Integer) r76);     // Catch: Throwable -> L236
    L238:
        r51 = r77;
        if (Result.isFailure-impl(r51) == false) goto L241;
    L236:
        th = move-exception;
        Result.Companion r78 = Result.Companion;     // Catch: Throwable -> L243
        r77 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L243
        goto L238
    L230:
        if ((r50 instanceof JSONArray) == false) goto L240;
    L200:
        r72 = r50;
    L243:
        th = move-exception;
        Result.Companion r79 = Result.Companion;     // Catch: Throwable -> L348
        r52 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L348
    L348:
        th = move-exception;
        Result.Companion r80 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r81 = Result.exceptionOrNull-impl(r45);
        if (r81 == null) goto L353;
        EnsureManager.ensureNotReachHere(r81);
    L353:
        if (Result.isFailure-impl(r45) == false) goto L191;
    L383:
        return false;
    }

    static {
    }
}
