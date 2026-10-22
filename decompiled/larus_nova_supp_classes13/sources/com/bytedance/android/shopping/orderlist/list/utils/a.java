package com.bytedance.android.shopping.orderlist.list.utils;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.g;
import com.bytedance.android.ec.base.settings.h;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.abtest.j;
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
public final class a {
    public static String a;

    static {
        Lazy r0 = ECSettingKeys.a;
        int r1 = j.a;
        Object r2 = "";
        int r3 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L172
        h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r5 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r6 = null;
        r5.getClass();     // Catch: Throwable -> L59
        Object r7 = SDKSettingsCacheManager.b.get("order_detail_container_prerender");     // Catch: Throwable -> L59
        if (r7 != null) goto L11;
    L56:
        Object r8 = null;
    L57:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L59
    L61:
        Throwable r10 = Result.exceptionOrNull-impl(r9);     // Catch: Throwable -> L172
        if (r10 == null) goto L65;
        EnsureManager.ensureNotReachHere(r10);     // Catch: Throwable -> L172
    L65:
        if (Result.isFailure-impl(r9) == false) goto L68;
        r9 = null;
    L68:
        if ((r9 instanceof String) == true) goto L70;
        r9 = null;
    L70:
        Object r11 = (String) r9;     // Catch: Throwable -> L172
        if (r11 != null) goto L77;
        r5.getClass();     // Catch: Throwable -> L172
        Object r12 = SDKSettingsCacheManager.a.get("order_detail_container_prerender");     // Catch: Throwable -> L172
        if ((r12 instanceof String) == true) goto L76;
        r12 = null;
    L76:
        r11 = (String) r12;     // Catch: Throwable -> L172
    L77:
        if (r11 != null) goto L181;
        int r13 = g.a;     // Catch: Throwable -> L172
    L159:
        th = move-exception;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L172
        Object r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L162:
        if (Result.exceptionOrNull-impl(r15) != null) goto L189;
    L169:
        r11 = r15;
    L170:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L172
        SDKSettingsCacheManager.e("order_detail_container_prerender", r11);     // Catch: Throwable -> L172
        goto L181
    L189:
        r15 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("order_detail_container_prerender", String.class, "");     // Catch: Throwable -> L166
    L167:
        if (r15 != null) goto L169;
        r11 = "";
    L166:
        r15 = "";
        goto L167
    L195:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r16 = SDKSettingsCacheManager.b.get("order_detail_container_prerender");     // Catch: Throwable -> L133
        if (r16 != null) goto L85;
    L130:
        Object r17 = null;
    L131:
        Object r18 = Result.constructor-impl(r17);     // Catch: Throwable -> L133
    L135:
        Throwable r19 = Result.exceptionOrNull-impl(r18);     // Catch: Throwable -> L159
        if (r19 == null) goto L139;
        EnsureManager.ensureNotReachHere(r19);     // Catch: Throwable -> L159
    L139:
        if (Result.isFailure-impl(r18) == false) goto L142;
        r18 = null;
    L142:
        if ((r18 instanceof String) == true) goto L144;
        r18 = null;
    L144:
        r15 = (String) r18;     // Catch: Throwable -> L159
        if (r15 != null) goto L169;
        jj4.b r20 = jj4.b.b;     // Catch: Throwable -> L159
        Object r21 = jj4.a.a("order_detail_container_prerender", String.class, "", false);     // Catch: Throwable -> L159
        if (r21 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r21 instanceof String) == false) goto L154;
        r6 = r21;
    L154:
        String r22 = (String) r6;     // Catch: Throwable -> L159
        if (r22 != null) goto L157;
        r22 = "";
    L157:
        r15 = Result.constructor-impl(r22);     // Catch: Throwable -> L159
    L85:
        if ((r16 instanceof String) == true) goto L87;
        Object r23 = null;
    L88:
        r17 = (String) r23;     // Catch: Throwable -> L133
        if (r17 != null) goto L131;
        if ((r16 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r24 = Float.valueOf(((Number) r16).floatValue());     // Catch: Throwable -> L133
        if ((r24 instanceof String) == true) goto L98;
        r24 = null;
    L98:
        r17 = (String) r24;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r25 = Double.valueOf(((Number) r16).doubleValue());     // Catch: Throwable -> L133
        if ((r25 instanceof String) == true) goto L104;
        r25 = null;
    L104:
        r17 = (String) r25;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r26 = Integer.valueOf(((Number) r16).intValue());     // Catch: Throwable -> L133
        if ((r26 instanceof String) == true) goto L110;
        r26 = null;
    L110:
        r17 = (String) r26;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r27 = Long.valueOf(((Number) r16).longValue());     // Catch: Throwable -> L133
        if ((r27 instanceof String) == true) goto L116;
        r27 = null;
    L116:
        r17 = (String) r27;     // Catch: Throwable -> L133
    L118:
        if ((r16 instanceof JSONObject) == false) goto L120;
    L187:
        Object r28 = SDKSettingsCacheManager.a().fromJson(r16.toString(), String.class);     // Catch: Throwable -> L126
        if ((r28 instanceof String) == true) goto L124;
        r28 = null;
    L124:
        Object r29 = Result.constructor-impl((String) r28);     // Catch: Throwable -> L126
    L128:
        r17 = r29;
        if (Result.isFailure-impl(r17) == false) goto L131;
    L126:
        th = move-exception;
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L133
        r29 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L133
        goto L128
    L120:
        if ((r16 instanceof JSONArray) == false) goto L130;
    L87:
        r23 = r16;
    L133:
        th = move-exception;
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L159
        r18 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L159
    L181:
        a = (String) r11;
        return;
    L11:
        if ((r7 instanceof String) == true) goto L13;
        Object r32 = null;
    L14:
        r8 = (String) r32;     // Catch: Throwable -> L59
        if (r8 != null) goto L57;
        if ((r7 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r33 = Float.valueOf(((Number) r7).floatValue());     // Catch: Throwable -> L59
        if ((r33 instanceof String) == true) goto L24;
        r33 = null;
    L24:
        r8 = (String) r33;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r34 = Double.valueOf(((Number) r7).doubleValue());     // Catch: Throwable -> L59
        if ((r34 instanceof String) == true) goto L30;
        r34 = null;
    L30:
        r8 = (String) r34;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r35 = Integer.valueOf(((Number) r7).intValue());     // Catch: Throwable -> L59
        if ((r35 instanceof String) == true) goto L36;
        r35 = null;
    L36:
        r8 = (String) r35;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r36 = Long.valueOf(((Number) r7).longValue());     // Catch: Throwable -> L59
        if ((r36 instanceof String) == true) goto L42;
        r36 = null;
    L42:
        r8 = (String) r36;     // Catch: Throwable -> L59
    L44:
        if ((r7 instanceof JSONObject) == false) goto L46;
    L193:
        Object r37 = SDKSettingsCacheManager.a().fromJson(r7.toString(), String.class);     // Catch: Throwable -> L52
        if ((r37 instanceof String) == true) goto L50;
        r37 = null;
    L50:
        Object r38 = Result.constructor-impl((String) r37);     // Catch: Throwable -> L52
    L54:
        r8 = r38;
        if (Result.isFailure-impl(r8) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L59
        r38 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r7 instanceof JSONArray) == false) goto L56;
    L13:
        r32 = r7;
    L59:
        th = move-exception;
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L172
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L172:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        Object r42 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r43 = Result.exceptionOrNull-impl(r42);
        if (r43 == null) goto L177;
        EnsureManager.ensureNotReachHere(r43);
    L177:
        if (Result.isFailure-impl(r42) == true) goto L180;
        r2 = r42;
    L180:
        r11 = r2;
        goto L181
    }
}
