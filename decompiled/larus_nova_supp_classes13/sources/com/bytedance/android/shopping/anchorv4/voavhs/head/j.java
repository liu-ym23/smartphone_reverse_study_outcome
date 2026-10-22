package com.bytedance.android.shopping.anchorv4.voavhs.head;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j {
    public static boolean a() {
        Lazy r0 = ECSettingKeys.a;
        int r1 = com.bytedance.android.ec.base.settings.b.a;
        int r2 = com.bytedance.android.ec.core.abtest.e.a;
        Object r3 = com.bytedance.android.ec.core.abtest.e.a(1, 0);
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r5 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L166
        Object r6 = null;
        r5.getClass();     // Catch: Throwable -> L56
        Object r7 = SDKSettingsCacheManager.b.get("iesec_head_component_opt");     // Catch: Throwable -> L56
        if (r7 != null) goto L11;
    L53:
        Object r8 = null;
    L54:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L56
    L58:
        Throwable r10 = Result.exceptionOrNull-impl(r9);     // Catch: Throwable -> L166
        if (r10 == null) goto L62;
        EnsureManager.ensureNotReachHere(r10);     // Catch: Throwable -> L166
    L62:
        if (Result.isFailure-impl(r9) == false) goto L65;
        r9 = null;
    L65:
        if ((r9 instanceof Integer) == true) goto L67;
        r9 = null;
    L67:
        Object r11 = (Integer) r9;     // Catch: Throwable -> L166
        if (r11 != null) goto L74;
        r5.getClass();     // Catch: Throwable -> L166
        Object r12 = SDKSettingsCacheManager.a.get("iesec_head_component_opt");     // Catch: Throwable -> L166
        if ((r12 instanceof Integer) == true) goto L73;
        r12 = null;
    L73:
        r11 = (Integer) r12;     // Catch: Throwable -> L166
    L74:
        if (r11 != null) goto L176;
        int r13 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L166
        Object r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L156:
        if (Result.exceptionOrNull-impl(r15) != null) goto L190;
    L163:
        r11 = r15;
    L164:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("iesec_head_component_opt", r11);     // Catch: Throwable -> L166
        goto L176
    L190:
        r15 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_head_component_opt", Integer.class, r3);     // Catch: Throwable -> L160
    L161:
        if (r15 != null) goto L163;
        r11 = r3;
    L160:
        r15 = r3;
        goto L161
    L184:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L127
        Object r16 = SDKSettingsCacheManager.b.get("iesec_head_component_opt");     // Catch: Throwable -> L127
        if (r16 != null) goto L82;
    L124:
        Object r17 = null;
    L125:
        Object r18 = Result.constructor-impl(r17);     // Catch: Throwable -> L127
    L129:
        Throwable r19 = Result.exceptionOrNull-impl(r18);     // Catch: Throwable -> L153
        if (r19 == null) goto L133;
        EnsureManager.ensureNotReachHere(r19);     // Catch: Throwable -> L153
    L133:
        if (Result.isFailure-impl(r18) == false) goto L136;
        r18 = null;
    L136:
        if ((r18 instanceof Integer) == true) goto L138;
        r18 = null;
    L138:
        r15 = (Integer) r18;     // Catch: Throwable -> L153
        if (r15 != null) goto L163;
        jj4.b r20 = jj4.b.b;     // Catch: Throwable -> L153
        Object r21 = jj4.a.a("iesec_head_component_opt", Integer.class, r3, false);     // Catch: Throwable -> L153
        if (r21 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r21 instanceof Integer) == false) goto L148;
        r6 = r21;
    L148:
        Object r22 = (Integer) r6;     // Catch: Throwable -> L153
        if (r22 != null) goto L151;
        r22 = r3;
    L151:
        r15 = Result.constructor-impl(r22);     // Catch: Throwable -> L153
    L82:
        if ((r16 instanceof Integer) == true) goto L84;
        Object r23 = null;
    L85:
        r17 = (Integer) r23;     // Catch: Throwable -> L127
        if (r17 != null) goto L125;
        if ((r16 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r24 = Float.valueOf(((Number) r16).floatValue());     // Catch: Throwable -> L127
        if ((r24 instanceof Integer) == true) goto L95;
        r24 = null;
    L95:
        r17 = (Integer) r24;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r25 = Double.valueOf(((Number) r16).doubleValue());     // Catch: Throwable -> L127
        if ((r25 instanceof Integer) == true) goto L101;
        r25 = null;
    L101:
        r17 = (Integer) r25;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r17 = Integer.valueOf(((Number) r16).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r26 = Long.valueOf(((Number) r16).longValue());     // Catch: Throwable -> L127
        if ((r26 instanceof Integer) == true) goto L110;
        r26 = null;
    L110:
        r17 = (Integer) r26;     // Catch: Throwable -> L127
    L112:
        if ((r16 instanceof JSONObject) == false) goto L114;
    L180:
        Object r27 = SDKSettingsCacheManager.a().fromJson(r16.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r27 instanceof Integer) == true) goto L118;
        r27 = null;
    L118:
        Object r28 = Result.constructor-impl((Integer) r27);     // Catch: Throwable -> L120
    L122:
        r17 = r28;
        if (Result.isFailure-impl(r17) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L127
        r28 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r16 instanceof JSONArray) == false) goto L124;
    L84:
        r23 = r16;
    L127:
        th = move-exception;
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L153
        r18 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        if (((Number) r11).intValue() == 1) goto L194;
        return false;
    L194:
        return true;
    L11:
        if ((r7 instanceof Integer) == true) goto L13;
        Object r31 = null;
    L14:
        r8 = (Integer) r31;     // Catch: Throwable -> L56
        if (r8 != null) goto L54;
        if ((r7 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r32 = Float.valueOf(((Number) r7).floatValue());     // Catch: Throwable -> L56
        if ((r32 instanceof Integer) == true) goto L24;
        r32 = null;
    L24:
        r8 = (Integer) r32;     // Catch: Throwable -> L56
        goto L54
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r33 = Double.valueOf(((Number) r7).doubleValue());     // Catch: Throwable -> L56
        if ((r33 instanceof Integer) == true) goto L30;
        r33 = null;
    L30:
        r8 = (Integer) r33;     // Catch: Throwable -> L56
        goto L54
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        r8 = Integer.valueOf(((Number) r7).intValue());     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r34 = Long.valueOf(((Number) r7).longValue());     // Catch: Throwable -> L56
        if ((r34 instanceof Integer) == true) goto L39;
        r34 = null;
    L39:
        r8 = (Integer) r34;     // Catch: Throwable -> L56
    L41:
        if ((r7 instanceof JSONObject) == false) goto L43;
    L188:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r7.toString(), Integer.class);     // Catch: Throwable -> L49
        if ((r35 instanceof Integer) == true) goto L47;
        r35 = null;
    L47:
        Object r36 = Result.constructor-impl((Integer) r35);     // Catch: Throwable -> L49
    L51:
        r8 = r36;
        if (Result.isFailure-impl(r8) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L56
        r36 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r7 instanceof JSONArray) == false) goto L53;
    L13:
        r31 = r7;
    L56:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L166
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        Object r40 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r41 = Result.exceptionOrNull-impl(r40);
        if (r41 == null) goto L171;
        EnsureManager.ensureNotReachHere(r41);
    L171:
        if (Result.isFailure-impl(r40) == true) goto L174;
        r3 = r40;
    L174:
        r11 = r3;
        goto L176
    }

    static {
    }
}
