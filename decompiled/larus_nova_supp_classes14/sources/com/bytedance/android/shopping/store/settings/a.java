package com.bytedance.android.shopping.store.settings;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.d;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static boolean a() {
        ConcurrentHashMap<String, Object> r0 = ECShopABSettings.a;
        Object r1 = 1;
        Object r6 = null;
        if (Intrinsics.areEqual("ec_shop_frame_experience_opt", "ec_shop_launch_opt_common_2") == false) goto L179;
        if (ECShopABSettings.b != null) goto L173;
        int r2 = n.a;
        Object r3 = 0;
        int r4 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L163
        Object r7 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L57
        if (r7 != null) goto L12;
    L54:
        Object r8 = null;
    L55:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L57
    L59:
        Throwable r10 = Result.exceptionOrNull-impl(r9);     // Catch: Throwable -> L163
        if (r10 == null) goto L63;
        EnsureManager.ensureNotReachHere(r10);     // Catch: Throwable -> L163
    L63:
        if (Result.isFailure-impl(r9) == false) goto L66;
        r9 = null;
    L66:
        if ((r9 instanceof Integer) == true) goto L68;
        r9 = null;
    L68:
        Object r11 = (Integer) r9;     // Catch: Throwable -> L163
        if (r11 != null) goto L75;
        Object r12 = d.a.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L163
        if ((r12 instanceof Integer) == true) goto L74;
        r12 = null;
    L74:
        r11 = (Integer) r12;     // Catch: Throwable -> L163
    L75:
        if (r11 != null) goto L172;
        int r13 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L163
        Object r14 = d.c.get("ec_shop_launch_opt_common_2");     // Catch: Throwable -> L127
        if (r14 != null) goto L82;
    L124:
        Object r15 = null;
    L125:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L127
    L129:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L154
        if (r17 == null) goto L133;
        EnsureManager.ensureNotReachHere(r17);     // Catch: Throwable -> L154
    L133:
        if (Result.isFailure-impl(r16) == false) goto L136;
        r16 = null;
    L136:
        if ((r16 instanceof Integer) == true) goto L138;
        r16 = null;
    L138:
        r11 = (Integer) r16;     // Catch: Throwable -> L154
        if (r11 != null) goto L161;
        IHybridHostService r18 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r18 == null) goto L144;
        Object r19 = r18.getHostABValue("ec_shop_launch_opt_common_2", r3);     // Catch: Throwable -> L154
    L145:
        if (r19 != null) goto L147;
    L160:
        r11 = r3;
        goto L161
    L147:
        if ((r19 instanceof Integer) == false) goto L150;
        r6 = r19;
    L150:
        Integer r20 = (Integer) r6;     // Catch: Throwable -> L154
        if (r20 == null) goto L160;
        r11 = r20;
        goto L161
    L154:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L163
        r11 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r22 = Result.exceptionOrNull-impl(r11);     // Catch: Throwable -> L163
        if (r22 == null) goto L159;
        EnsureManager.ensureNotReachHere(r22);     // Catch: Throwable -> L163
    L159:
        if (Result.isFailure-impl(r11) == false) goto L161;
    L144:
        r19 = null;
    L161:
        d.d("ec_shop_launch_opt_common_2", r11);     // Catch: Throwable -> L163
        goto L172
    L82:
        if ((r14 instanceof Integer) == true) goto L84;
        Object r23 = null;
    L85:
        r15 = (Integer) r23;     // Catch: Throwable -> L127
        if (r15 != null) goto L125;
        if ((r14 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r24 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L127
        if ((r24 instanceof Integer) == true) goto L95;
        r24 = null;
    L95:
        r15 = (Integer) r24;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r25 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L127
        if ((r25 instanceof Integer) == true) goto L101;
        r25 = null;
    L101:
        r15 = (Integer) r25;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r15 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r26 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L127
        if ((r26 instanceof Integer) == true) goto L110;
        r26 = null;
    L110:
        r15 = (Integer) r26;     // Catch: Throwable -> L127
    L112:
        if ((r14 instanceof JSONObject) == false) goto L114;
    L367:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L120
        Object r27 = SDKSettingsCacheManager.a().fromJson(r14.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r27 instanceof Integer) == true) goto L118;
        r27 = null;
    L118:
        Object r28 = Result.constructor-impl((Integer) r27);     // Catch: Throwable -> L120
    L122:
        r15 = r28;
        if (Result.isFailure-impl(r15) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L127
        r28 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r14 instanceof JSONArray) == false) goto L124;
    L84:
        r23 = r14;
    L127:
        th = move-exception;
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L154
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L172:
        ECShopABSettings.b = (Integer) r11;
        goto L173
    L12:
        if ((r7 instanceof Integer) == true) goto L14;
        Object r31 = null;
    L15:
        r8 = (Integer) r31;     // Catch: Throwable -> L57
        if (r8 != null) goto L55;
        if ((r7 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L27;
        Float r32 = Float.valueOf(((Number) r7).floatValue());     // Catch: Throwable -> L57
        if ((r32 instanceof Integer) == true) goto L25;
        r32 = null;
    L25:
        r8 = (Integer) r32;     // Catch: Throwable -> L57
        goto L55
    L27:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L33;
        Double r33 = Double.valueOf(((Number) r7).doubleValue());     // Catch: Throwable -> L57
        if ((r33 instanceof Integer) == true) goto L31;
        r33 = null;
    L31:
        r8 = (Integer) r33;     // Catch: Throwable -> L57
        goto L55
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        r8 = Integer.valueOf(((Number) r7).intValue());     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r34 = Long.valueOf(((Number) r7).longValue());     // Catch: Throwable -> L57
        if ((r34 instanceof Integer) == true) goto L40;
        r34 = null;
    L40:
        r8 = (Integer) r34;     // Catch: Throwable -> L57
    L42:
        if ((r7 instanceof JSONObject) == false) goto L44;
    L365:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r35 = SDKSettingsCacheManager.a().fromJson(r7.toString(), Integer.class);     // Catch: Throwable -> L50
        if ((r35 instanceof Integer) == true) goto L48;
        r35 = null;
    L48:
        Object r36 = Result.constructor-impl((Integer) r35);     // Catch: Throwable -> L50
    L52:
        r8 = r36;
        if (Result.isFailure-impl(r8) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L57
        r36 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r7 instanceof JSONArray) == false) goto L54;
    L14:
        r31 = r7;
    L57:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L163
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        Object r40 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r41 = Result.exceptionOrNull-impl(r40);
        if (r41 == null) goto L168;
        EnsureManager.ensureNotReachHere(r41);
    L168:
        if (Result.isFailure-impl(r40) == true) goto L171;
        r3 = r40;
    L171:
        r11 = r3;
    L173:
        r1 = ECShopABSettings.b;
        if (r1 == null) goto L177;
    L352:
        ECShopABSettings.a.put("ec_shop_frame_experience_opt", r1);
        if (((Number) r1).intValue() == 1) goto L382;
        return false;
    L382:
        return true;
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L179:
        if (Intrinsics.areEqual("HostExperiment", "ShopSetting") == false) goto L190;
        int r42 = p.a;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L185
        jj4.b r44 = jj4.b.b;     // Catch: Throwable -> L185
        Object r45 = jj4.a.a("ec_shop_frame_experience_opt", Integer.class, r1, false);     // Catch: Throwable -> L185
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
        int r47 = n.a;
        int r48 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L346
        Object r50 = d.c.get("ec_shop_frame_experience_opt");     // Catch: Throwable -> L241
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
        Object r54 = d.a.get("ec_shop_frame_experience_opt");     // Catch: Throwable -> L346
        if ((r54 instanceof Integer) == true) goto L258;
        r54 = null;
    L258:
        r45 = (Integer) r54;     // Catch: Throwable -> L346
    L259:
        if (r45 != null) goto L189;
        int r55 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L346
        Object r56 = d.c.get("ec_shop_frame_experience_opt");     // Catch: Throwable -> L311
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
        Object r61 = r60.getHostABValue("ec_shop_frame_experience_opt", r1);     // Catch: Throwable -> L337
    L329:
        if (r61 != null) goto L331;
    L343:
        r45 = r1;
        goto L344
    L331:
        if ((r61 instanceof Integer) == false) goto L334;
        r6 = r61;
    L334:
        r45 = (Integer) r6;     // Catch: Throwable -> L337
        if (r45 != null) goto L344;
    L328:
        r61 = null;
    L344:
        d.d("ec_shop_frame_experience_opt", r45);     // Catch: Throwable -> L346
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
    L380:
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
    L378:
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

    static {
    }
}
