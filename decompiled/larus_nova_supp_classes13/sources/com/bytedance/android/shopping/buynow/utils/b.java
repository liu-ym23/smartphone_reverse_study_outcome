package com.bytedance.android.shopping.buynow.utils;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import com.bytedance.services.apm.api.EnsureManager;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(BuyNowViewModel r6) {
        Intrinsics.checkNotNullParameter(r6, "buyNowViewModel");
        Lazy r0 = ECSettingKeys.a;
        int r1 = com.bytedance.android.ec.base.settings.a.a;
        Object r2 = "0";
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L166
        Object r4 = null;
        Object r5 = com.bytedance.android.ec.base.settings.d.c.get("standard_confirm_order_opt");     // Catch: Throwable -> L57
        if (r5 != null) goto L9;
    L54:
        Object r7 = null;
    L55:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L57
    L59:
        Throwable r9 = Result.exceptionOrNull-impl(r8);     // Catch: Throwable -> L166
        if (r9 == null) goto L63;
        EnsureManager.ensureNotReachHere(r9);     // Catch: Throwable -> L166
    L63:
        if (Result.isFailure-impl(r8) == false) goto L66;
        r8 = null;
    L66:
        if ((r8 instanceof String) == true) goto L68;
        r8 = null;
    L68:
        Object r10 = (String) r8;     // Catch: Throwable -> L166
        if (r10 != null) goto L75;
        Object r11 = com.bytedance.android.ec.base.settings.d.a.get("standard_confirm_order_opt");     // Catch: Throwable -> L166
        if ((r11 instanceof String) == true) goto L74;
        r11 = null;
    L74:
        r10 = (String) r11;     // Catch: Throwable -> L166
    L75:
        if (r10 != null) goto L175;
        int r12 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L166
        Object r13 = com.bytedance.android.ec.base.settings.d.c.get("standard_confirm_order_opt");     // Catch: Throwable -> L130
        if (r13 != null) goto L82;
    L127:
        Object r14 = null;
    L128:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L130
    L132:
        Throwable r16 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L156
        if (r16 == null) goto L136;
        EnsureManager.ensureNotReachHere(r16);     // Catch: Throwable -> L156
    L136:
        if (Result.isFailure-impl(r15) == false) goto L139;
        r15 = null;
    L139:
        if ((r15 instanceof String) == true) goto L141;
        r15 = null;
    L141:
        r10 = (String) r15;     // Catch: Throwable -> L156
        if (r10 != null) goto L164;
        IHybridHostService r17 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r17 == null) goto L147;
        Object r18 = r17.getHostABValue("standard_confirm_order_opt", "0");     // Catch: Throwable -> L156
    L148:
        if (r18 != null) goto L150;
    L155:
        r10 = "0";
        goto L164
    L150:
        if ((r18 instanceof String) == false) goto L153;
        r4 = r18;
    L153:
        Object r19 = (String) r4;     // Catch: Throwable -> L156
        if (r19 == null) goto L155;
    L163:
        r10 = r19;
        goto L164
    L147:
        r18 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d("standard_confirm_order_opt", r10);     // Catch: Throwable -> L166
        goto L175
    L82:
        if ((r13 instanceof String) == true) goto L84;
        Object r20 = null;
    L85:
        r14 = (String) r20;     // Catch: Throwable -> L130
        if (r14 != null) goto L128;
        if ((r13 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r21 = Float.valueOf(((Number) r13).floatValue());     // Catch: Throwable -> L130
        if ((r21 instanceof String) == true) goto L95;
        r21 = null;
    L95:
        r14 = (String) r21;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r22 = Double.valueOf(((Number) r13).doubleValue());     // Catch: Throwable -> L130
        if ((r22 instanceof String) == true) goto L101;
        r22 = null;
    L101:
        r14 = (String) r22;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r23 = Integer.valueOf(((Number) r13).intValue());     // Catch: Throwable -> L130
        if ((r23 instanceof String) == true) goto L107;
        r23 = null;
    L107:
        r14 = (String) r23;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r24 = Long.valueOf(((Number) r13).longValue());     // Catch: Throwable -> L130
        if ((r24 instanceof String) == true) goto L113;
        r24 = null;
    L113:
        r14 = (String) r24;     // Catch: Throwable -> L130
    L115:
        if ((r13 instanceof JSONObject) == false) goto L117;
    L188:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L123
        Object r25 = SDKSettingsCacheManager.a().fromJson(r13.toString(), String.class);     // Catch: Throwable -> L123
        if ((r25 instanceof String) == true) goto L121;
        r25 = null;
    L121:
        Object r26 = Result.constructor-impl((String) r25);     // Catch: Throwable -> L123
    L125:
        r14 = r26;
        if (Result.isFailure-impl(r14) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L130
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r13 instanceof JSONArray) == false) goto L127;
    L84:
        r20 = r13;
    L156:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L166
        r19 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
        Throwable r29 = Result.exceptionOrNull-impl(r19);     // Catch: Throwable -> L166
        if (r29 == null) goto L161;
        EnsureManager.ensureNotReachHere(r29);     // Catch: Throwable -> L166
    L161:
        if (Result.isFailure-impl(r19) == false) goto L163;
        r19 = "0";
    L130:
        th = move-exception;
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L156
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L175:
        String r31 = (String) r10;
        if (Intrinsics.areEqual(r31, "1") == true) goto L180;
        if (Intrinsics.areEqual(r31, "3") == true) goto L180;
    L186:
        return false;
    L180:
        if (ja3.a.c(r6.getStaticState().a) == false) goto L186;
        if (r6.getStaticState().a() == false) goto L186;
        if (ja3.a.d(r6.getStaticState().a) == true) goto L186;
        return true;
    L9:
        if ((r5 instanceof String) == true) goto L11;
        Object r32 = null;
    L12:
        r7 = (String) r32;     // Catch: Throwable -> L57
        if (r7 != null) goto L55;
        if ((r5 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r33 = Float.valueOf(((Number) r5).floatValue());     // Catch: Throwable -> L57
        if ((r33 instanceof String) == true) goto L22;
        r33 = null;
    L22:
        r7 = (String) r33;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r34 = Double.valueOf(((Number) r5).doubleValue());     // Catch: Throwable -> L57
        if ((r34 instanceof String) == true) goto L28;
        r34 = null;
    L28:
        r7 = (String) r34;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r35 = Integer.valueOf(((Number) r5).intValue());     // Catch: Throwable -> L57
        if ((r35 instanceof String) == true) goto L34;
        r35 = null;
    L34:
        r7 = (String) r35;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r36 = Long.valueOf(((Number) r5).longValue());     // Catch: Throwable -> L57
        if ((r36 instanceof String) == true) goto L40;
        r36 = null;
    L40:
        r7 = (String) r36;     // Catch: Throwable -> L57
    L42:
        if ((r5 instanceof JSONObject) == false) goto L44;
    L196:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r37 = SDKSettingsCacheManager.a().fromJson(r5.toString(), String.class);     // Catch: Throwable -> L50
        if ((r37 instanceof String) == true) goto L48;
        r37 = null;
    L48:
        Object r38 = Result.constructor-impl((String) r37);     // Catch: Throwable -> L50
    L52:
        r7 = r38;
        if (Result.isFailure-impl(r7) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L57
        r38 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r5 instanceof JSONArray) == false) goto L54;
    L11:
        r32 = r5;
    L57:
        th = move-exception;
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L166
        r8 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        Object r42 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r43 = Result.exceptionOrNull-impl(r42);
        if (r43 == null) goto L171;
        EnsureManager.ensureNotReachHere(r43);
    L171:
        if (Result.isFailure-impl(r42) == true) goto L174;
        r2 = r42;
    L174:
        r10 = r2;
        goto L175
    }
}
