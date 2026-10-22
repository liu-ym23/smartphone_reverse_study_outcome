package com.bytedance.android.shopping.searchsimilar.utils;

import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.opt.ab.m;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.services.apm.api.EnsureManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    public static int a() {
        int r0 = ld3.c.a;
        int r1 = m.a;
        Object r2 = 0;
        boolean r3 = ECServiceManager.a;
        s83.g r4 = (s83.g) ECServiceManager.c(s83.g.class);
        if (r4 == null) goto L8;
        s83.a r5 = r4.q();
        if (r5 == null) goto L8;
        Object r6 = r5.e("ec_commerce_comment_similar_product");
        if (r6 == null) goto L8;
    L175:
        return ((Number) r6).intValue();
    L8:
        int r7 = n.a;
        int r8 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L165
        Object r10 = null;
        Object r11 = com.bytedance.android.ec.base.settings.d.c.get("ec_commerce_comment_similar_product");     // Catch: Throwable -> L60
        if (r11 != null) goto L15;
    L57:
        Object r12 = null;
    L58:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L60
    L62:
        Throwable r14 = Result.exceptionOrNull-impl(r13);     // Catch: Throwable -> L165
        if (r14 == null) goto L66;
        EnsureManager.ensureNotReachHere(r14);     // Catch: Throwable -> L165
    L66:
        if (Result.isFailure-impl(r13) == false) goto L69;
        r13 = null;
    L69:
        if ((r13 instanceof Integer) == true) goto L71;
        r13 = null;
    L71:
        Integer r15 = (Integer) r13;     // Catch: Throwable -> L165
        if (r15 != null) goto L78;
        Object r16 = com.bytedance.android.ec.base.settings.d.a.get("ec_commerce_comment_similar_product");     // Catch: Throwable -> L165
        if ((r16 instanceof Integer) == true) goto L77;
        r16 = null;
    L77:
        r15 = (Integer) r16;     // Catch: Throwable -> L165
    L78:
        if (r15 == null) goto L80;
        r6 = r15;
        goto L175
    L80:
        int r17 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L165
        Object r18 = com.bytedance.android.ec.base.settings.d.c.get("ec_commerce_comment_similar_product");     // Catch: Throwable -> L130
        if (r18 != null) goto L85;
    L127:
        Object r19 = null;
    L128:
        Object r20 = Result.constructor-impl(r19);     // Catch: Throwable -> L130
    L132:
        Throwable r21 = Result.exceptionOrNull-impl(r20);     // Catch: Throwable -> L156
        if (r21 == null) goto L136;
        EnsureManager.ensureNotReachHere(r21);     // Catch: Throwable -> L156
    L136:
        if (Result.isFailure-impl(r20) == false) goto L139;
        r20 = null;
    L139:
        if ((r20 instanceof Integer) == true) goto L141;
        r20 = null;
    L141:
        Integer r22 = (Integer) r20;     // Catch: Throwable -> L156
        if (r22 == null) goto L144;
        r6 = r22;
    L163:
        com.bytedance.android.ec.base.settings.d.d("ec_commerce_comment_similar_product", r6);     // Catch: Throwable -> L165
        goto L175
    L144:
        IHybridHostService r23 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r23 == null) goto L147;
        Object r24 = r23.getHostABValue("ec_commerce_comment_similar_product", r2);     // Catch: Throwable -> L156
    L148:
        if (r24 != null) goto L150;
    L162:
        r6 = r2;
        goto L163
    L150:
        if ((r24 instanceof Integer) == false) goto L153;
        r10 = r24;
    L153:
        r6 = (Integer) r10;     // Catch: Throwable -> L156
        if (r6 != null) goto L163;
    L156:
        th = move-exception;
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L165
        r6 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
        Throwable r26 = Result.exceptionOrNull-impl(r6);     // Catch: Throwable -> L165
        if (r26 == null) goto L161;
        EnsureManager.ensureNotReachHere(r26);     // Catch: Throwable -> L165
    L161:
        if (Result.isFailure-impl(r6) == false) goto L163;
    L147:
        r24 = null;
        goto L148
    L85:
        if ((r18 instanceof Integer) == true) goto L87;
        Object r27 = null;
    L88:
        r19 = (Integer) r27;     // Catch: Throwable -> L130
        if (r19 != null) goto L128;
        if ((r18 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r28 = Float.valueOf(((Number) r18).floatValue());     // Catch: Throwable -> L130
        if ((r28 instanceof Integer) == true) goto L98;
        r28 = null;
    L98:
        r19 = (Integer) r28;     // Catch: Throwable -> L130
        goto L128
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r29 = Double.valueOf(((Number) r18).doubleValue());     // Catch: Throwable -> L130
        if ((r29 instanceof Integer) == true) goto L104;
        r29 = null;
    L104:
        r19 = (Integer) r29;     // Catch: Throwable -> L130
        goto L128
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        r19 = Integer.valueOf(((Number) r18).intValue());     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r30 = Long.valueOf(((Number) r18).longValue());     // Catch: Throwable -> L130
        if ((r30 instanceof Integer) == true) goto L113;
        r30 = null;
    L113:
        r19 = (Integer) r30;     // Catch: Throwable -> L130
    L115:
        if ((r18 instanceof JSONObject) == false) goto L117;
    L186:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L123
        Object r31 = SDKSettingsCacheManager.a().fromJson(r18.toString(), Integer.class);     // Catch: Throwable -> L123
        if ((r31 instanceof Integer) == true) goto L121;
        r31 = null;
    L121:
        Object r32 = Result.constructor-impl((Integer) r31);     // Catch: Throwable -> L123
    L125:
        r19 = r32;
        if (Result.isFailure-impl(r19) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L130
        r32 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r18 instanceof JSONArray) == false) goto L127;
    L87:
        r27 = r18;
    L130:
        th = move-exception;
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L156
        r20 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
        goto L132
    L15:
        if ((r11 instanceof Integer) == true) goto L17;
        Object r35 = null;
    L18:
        r12 = (Integer) r35;     // Catch: Throwable -> L60
        if (r12 != null) goto L58;
        if ((r11 instanceof Number) == false) goto L45;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L30;
        Float r36 = Float.valueOf(((Number) r11).floatValue());     // Catch: Throwable -> L60
        if ((r36 instanceof Integer) == true) goto L28;
        r36 = null;
    L28:
        r12 = (Integer) r36;     // Catch: Throwable -> L60
        goto L58
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L36;
        Double r37 = Double.valueOf(((Number) r11).doubleValue());     // Catch: Throwable -> L60
        if ((r37 instanceof Integer) == true) goto L34;
        r37 = null;
    L34:
        r12 = (Integer) r37;     // Catch: Throwable -> L60
        goto L58
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L39;
        r12 = Integer.valueOf(((Number) r11).intValue());     // Catch: Throwable -> L60
        goto L58
    L39:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L45;
        Long r38 = Long.valueOf(((Number) r11).longValue());     // Catch: Throwable -> L60
        if ((r38 instanceof Integer) == true) goto L43;
        r38 = null;
    L43:
        r12 = (Integer) r38;     // Catch: Throwable -> L60
    L45:
        if ((r11 instanceof JSONObject) == false) goto L47;
    L184:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L53
        Object r39 = SDKSettingsCacheManager.a().fromJson(r11.toString(), Integer.class);     // Catch: Throwable -> L53
        if ((r39 instanceof Integer) == true) goto L51;
        r39 = null;
    L51:
        Object r40 = Result.constructor-impl((Integer) r39);     // Catch: Throwable -> L53
    L55:
        r12 = r40;
        if (Result.isFailure-impl(r12) == false) goto L58;
    L53:
        th = move-exception;
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L60
        r40 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L60
        goto L55
    L47:
        if ((r11 instanceof JSONArray) == false) goto L57;
    L17:
        r35 = r11;
    L60:
        th = move-exception;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L165
        r13 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
    L165:
        th = move-exception;
        Result.Companion r43 = Result.Companion;
        Object r44 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r45 = Result.exceptionOrNull-impl(r44);
        if (r45 == null) goto L170;
        EnsureManager.ensureNotReachHere(r45);
    L170:
        if (Result.isFailure-impl(r44) == true) goto L173;
        r2 = r44;
    L173:
        r6 = r2;
        goto L175
    }

    static {
    }
}
