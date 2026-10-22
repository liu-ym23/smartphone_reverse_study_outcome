package com.bytedance.android.window.shop;

import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.opt.ab.m;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.services.apm.api.EnsureManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;
import s83.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final WindowLayoutType a = null;

    static {
        int r0 = yq3.a.a;
        int r1 = m.a;
        Object r2 = 0;
        boolean r3 = ECServiceManager.a;
        g r4 = (g) ECServiceManager.c(g.class);
        if (r4 == null) goto L8;
        s83.a r5 = r4.q();
        if (r5 == null) goto L8;
        Object r6 = r5.e("ecom_window_goods_column");
        if (r6 == null) goto L8;
    L175:
        if (((Number) r6).intValue() == 1) goto L177;
        WindowLayoutType r7 = WindowLayoutType.DOUBLECOLUMN;
    L178:
        a = r7;
        return;
    L177:
        r7 = WindowLayoutType.SINGLECOLUMN;
    L8:
        int r8 = n.a;
        int r9 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L165
        Object r11 = null;
        Object r12 = com.bytedance.android.ec.base.settings.d.c.get("ecom_window_goods_column");     // Catch: Throwable -> L60
        if (r12 != null) goto L15;
    L57:
        Object r13 = null;
    L58:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L60
    L62:
        Throwable r15 = Result.exceptionOrNull-impl(r14);     // Catch: Throwable -> L165
        if (r15 == null) goto L66;
        EnsureManager.ensureNotReachHere(r15);     // Catch: Throwable -> L165
    L66:
        if (Result.isFailure-impl(r14) == false) goto L69;
        r14 = null;
    L69:
        if ((r14 instanceof Integer) == true) goto L71;
        r14 = null;
    L71:
        Integer r16 = (Integer) r14;     // Catch: Throwable -> L165
        if (r16 != null) goto L78;
        Object r17 = com.bytedance.android.ec.base.settings.d.a.get("ecom_window_goods_column");     // Catch: Throwable -> L165
        if ((r17 instanceof Integer) == true) goto L77;
        r17 = null;
    L77:
        r16 = (Integer) r17;     // Catch: Throwable -> L165
    L78:
        if (r16 == null) goto L80;
        r6 = r16;
        goto L175
    L80:
        int r18 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L165
        Object r19 = com.bytedance.android.ec.base.settings.d.c.get("ecom_window_goods_column");     // Catch: Throwable -> L130
        if (r19 != null) goto L85;
    L127:
        Object r20 = null;
    L128:
        Object r21 = Result.constructor-impl(r20);     // Catch: Throwable -> L130
    L132:
        Throwable r22 = Result.exceptionOrNull-impl(r21);     // Catch: Throwable -> L156
        if (r22 == null) goto L136;
        EnsureManager.ensureNotReachHere(r22);     // Catch: Throwable -> L156
    L136:
        if (Result.isFailure-impl(r21) == false) goto L139;
        r21 = null;
    L139:
        if ((r21 instanceof Integer) == true) goto L141;
        r21 = null;
    L141:
        Integer r23 = (Integer) r21;     // Catch: Throwable -> L156
        if (r23 == null) goto L144;
        r6 = r23;
    L163:
        com.bytedance.android.ec.base.settings.d.d("ecom_window_goods_column", r6);     // Catch: Throwable -> L165
        goto L175
    L144:
        IHybridHostService r24 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r24 == null) goto L147;
        Object r25 = r24.getHostABValue("ecom_window_goods_column", r2);     // Catch: Throwable -> L156
    L148:
        if (r25 != null) goto L150;
    L162:
        r6 = r2;
        goto L163
    L150:
        if ((r25 instanceof Integer) == false) goto L153;
        r11 = r25;
    L153:
        r6 = (Integer) r11;     // Catch: Throwable -> L156
        if (r6 != null) goto L163;
    L156:
        th = move-exception;
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L165
        r6 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
        Throwable r27 = Result.exceptionOrNull-impl(r6);     // Catch: Throwable -> L165
        if (r27 == null) goto L161;
        EnsureManager.ensureNotReachHere(r27);     // Catch: Throwable -> L165
    L161:
        if (Result.isFailure-impl(r6) == false) goto L163;
    L147:
        r25 = null;
        goto L148
    L85:
        if ((r19 instanceof Integer) == true) goto L87;
        Object r28 = null;
    L88:
        r20 = (Integer) r28;     // Catch: Throwable -> L130
        if (r20 != null) goto L128;
        if ((r19 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r29 = Float.valueOf(((Number) r19).floatValue());     // Catch: Throwable -> L130
        if ((r29 instanceof Integer) == true) goto L98;
        r29 = null;
    L98:
        r20 = (Integer) r29;     // Catch: Throwable -> L130
        goto L128
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r30 = Double.valueOf(((Number) r19).doubleValue());     // Catch: Throwable -> L130
        if ((r30 instanceof Integer) == true) goto L104;
        r30 = null;
    L104:
        r20 = (Integer) r30;     // Catch: Throwable -> L130
        goto L128
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        r20 = Integer.valueOf(((Number) r19).intValue());     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r31 = Long.valueOf(((Number) r19).longValue());     // Catch: Throwable -> L130
        if ((r31 instanceof Integer) == true) goto L113;
        r31 = null;
    L113:
        r20 = (Integer) r31;     // Catch: Throwable -> L130
    L115:
        if ((r19 instanceof JSONObject) == false) goto L117;
    L190:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L123
        Object r32 = SDKSettingsCacheManager.a().fromJson(r19.toString(), Integer.class);     // Catch: Throwable -> L123
        if ((r32 instanceof Integer) == true) goto L121;
        r32 = null;
    L121:
        Object r33 = Result.constructor-impl((Integer) r32);     // Catch: Throwable -> L123
    L125:
        r20 = r33;
        if (Result.isFailure-impl(r20) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L130
        r33 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r19 instanceof JSONArray) == false) goto L127;
    L87:
        r28 = r19;
    L130:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L156
        r21 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
        goto L132
    L15:
        if ((r12 instanceof Integer) == true) goto L17;
        Object r36 = null;
    L18:
        r13 = (Integer) r36;     // Catch: Throwable -> L60
        if (r13 != null) goto L58;
        if ((r12 instanceof Number) == false) goto L45;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L30;
        Float r37 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L60
        if ((r37 instanceof Integer) == true) goto L28;
        r37 = null;
    L28:
        r13 = (Integer) r37;     // Catch: Throwable -> L60
        goto L58
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L36;
        Double r38 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L60
        if ((r38 instanceof Integer) == true) goto L34;
        r38 = null;
    L34:
        r13 = (Integer) r38;     // Catch: Throwable -> L60
        goto L58
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L39;
        r13 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L60
        goto L58
    L39:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L45;
        Long r39 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L60
        if ((r39 instanceof Integer) == true) goto L43;
        r39 = null;
    L43:
        r13 = (Integer) r39;     // Catch: Throwable -> L60
    L45:
        if ((r12 instanceof JSONObject) == false) goto L47;
    L188:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L53
        Object r40 = SDKSettingsCacheManager.a().fromJson(r12.toString(), Integer.class);     // Catch: Throwable -> L53
        if ((r40 instanceof Integer) == true) goto L51;
        r40 = null;
    L51:
        Object r41 = Result.constructor-impl((Integer) r40);     // Catch: Throwable -> L53
    L55:
        r13 = r41;
        if (Result.isFailure-impl(r13) == false) goto L58;
    L53:
        th = move-exception;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L60
        r41 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L60
        goto L55
    L47:
        if ((r12 instanceof JSONArray) == false) goto L57;
    L17:
        r36 = r12;
    L60:
        th = move-exception;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L165
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
    L165:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        Object r45 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r46 = Result.exceptionOrNull-impl(r45);
        if (r46 == null) goto L170;
        EnsureManager.ensureNotReachHere(r46);
    L170:
        if (Result.isFailure-impl(r45) == true) goto L173;
        r2 = r45;
    L173:
        r6 = r2;
        goto L175
    }
}
