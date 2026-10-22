package com.bytedance.android.shopping.sku.inner.repo.composer;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.g;
import com.bytedance.android.ec.base.settings.h;
import com.bytedance.android.ec.core.abtest.d;
import com.bytedance.android.ec.core.abtest.j;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final List<String> a = null;

    static {
        d r0 = d.a;
        int r1 = j.a;
        Object r2 = new ArrayList();
        int r3 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L174
        h.a();     // Catch: Throwable -> L174
        SDKSettingsCacheManager r5 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L174
        Object r6 = null;
        r5.getClass();     // Catch: Throwable -> L59
        Object r7 = SDKSettingsCacheManager.b.get("iesec_sku_api_entrance_info_keys");     // Catch: Throwable -> L59
        if (r7 != null) goto L11;
    L56:
        Object r8 = null;
    L57:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L59
    L61:
        Throwable r10 = Result.exceptionOrNull-impl(r9);     // Catch: Throwable -> L174
        if (r10 == null) goto L65;
        EnsureManager.ensureNotReachHere(r10);     // Catch: Throwable -> L174
    L65:
        if (Result.isFailure-impl(r9) == false) goto L68;
        r9 = null;
    L68:
        if (TypeIntrinsics.isMutableList(r9) == true) goto L70;
        r9 = null;
    L70:
        Object r11 = (List) r9;     // Catch: Throwable -> L174
        if (r11 != null) goto L77;
        r5.getClass();     // Catch: Throwable -> L174
        Object r12 = SDKSettingsCacheManager.a.get("iesec_sku_api_entrance_info_keys");     // Catch: Throwable -> L174
        if (TypeIntrinsics.isMutableList(r12) == true) goto L76;
        r12 = null;
    L76:
        r11 = (List) r12;     // Catch: Throwable -> L174
    L77:
        if (r11 != null) goto L183;
        int r13 = g.a;     // Catch: Throwable -> L174
    L161:
        th = move-exception;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L174
        Object r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L164:
        if (Result.exceptionOrNull-impl(r15) != null) goto L193;
    L171:
        r11 = r15;
    L172:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L174
        SDKSettingsCacheManager.e("iesec_sku_api_entrance_info_keys", r11);     // Catch: Throwable -> L174
        goto L183
    L193:
        r15 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_sku_api_entrance_info_keys", List.class, r2);     // Catch: Throwable -> L168
    L169:
        if (r15 != null) goto L171;
        r11 = r2;
    L168:
        r15 = r2;
        goto L169
    L191:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r16 = SDKSettingsCacheManager.b.get("iesec_sku_api_entrance_info_keys");     // Catch: Throwable -> L133
        if (r16 != null) goto L85;
    L130:
        Object r17 = null;
    L131:
        Object r18 = Result.constructor-impl(r17);     // Catch: Throwable -> L133
    L135:
        Throwable r19 = Result.exceptionOrNull-impl(r18);     // Catch: Throwable -> L161
        if (r19 == null) goto L139;
        EnsureManager.ensureNotReachHere(r19);     // Catch: Throwable -> L161
    L139:
        if (Result.isFailure-impl(r18) == false) goto L142;
        r18 = null;
    L142:
        if (TypeIntrinsics.isMutableList(r18) == true) goto L144;
        r18 = null;
    L144:
        r15 = (List) r18;     // Catch: Throwable -> L161
        if (r15 != null) goto L147;
    L149:
        jj4.b r20 = jj4.b.b;     // Catch: Throwable -> L161
        Object r21 = jj4.a.a("iesec_sku_api_entrance_info_keys", List.class, r2, false);     // Catch: Throwable -> L161
        if (r21 != null) goto L153;
        Intrinsics.throwNpe();     // Catch: Throwable -> L161
    L153:
        if (TypeIntrinsics.isMutableList(r21) == false) goto L156;
        r6 = r21;
    L156:
        Object r22 = (List) r6;     // Catch: Throwable -> L161
        if (r22 != null) goto L159;
        r22 = r2;
    L159:
        r15 = Result.constructor-impl(r22);     // Catch: Throwable -> L161
    L147:
        if (TypeIntrinsics.isMutableList(r15) == false) goto L149;
    L85:
        if (TypeIntrinsics.isMutableList(r16) == true) goto L87;
        Object r23 = null;
    L88:
        r17 = (List) r23;     // Catch: Throwable -> L133
        if (r17 != null) goto L131;
        if ((r16 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r24 = Float.valueOf(((Number) r16).floatValue());     // Catch: Throwable -> L133
        if (TypeIntrinsics.isMutableList(r24) == true) goto L98;
        r24 = null;
    L98:
        r17 = (List) r24;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r25 = Double.valueOf(((Number) r16).doubleValue());     // Catch: Throwable -> L133
        if (TypeIntrinsics.isMutableList(r25) == true) goto L104;
        r25 = null;
    L104:
        r17 = (List) r25;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r26 = Integer.valueOf(((Number) r16).intValue());     // Catch: Throwable -> L133
        if (TypeIntrinsics.isMutableList(r26) == true) goto L110;
        r26 = null;
    L110:
        r17 = (List) r26;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r27 = Long.valueOf(((Number) r16).longValue());     // Catch: Throwable -> L133
        if (TypeIntrinsics.isMutableList(r27) == true) goto L116;
        r27 = null;
    L116:
        r17 = (List) r27;     // Catch: Throwable -> L133
    L118:
        if ((r16 instanceof JSONObject) == false) goto L120;
    L185:
        Object r28 = SDKSettingsCacheManager.a().fromJson(r16.toString(), List.class);     // Catch: Throwable -> L126
        if (TypeIntrinsics.isMutableList(r28) == true) goto L124;
        r28 = null;
    L124:
        Object r29 = Result.constructor-impl((List) r28);     // Catch: Throwable -> L126
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
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L161
        r18 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L161
    L183:
        a = (List) r11;
        return;
    L11:
        if (TypeIntrinsics.isMutableList(r7) == true) goto L13;
        Object r32 = null;
    L14:
        r8 = (List) r32;     // Catch: Throwable -> L59
        if (r8 != null) goto L57;
        if ((r7 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r33 = Float.valueOf(((Number) r7).floatValue());     // Catch: Throwable -> L59
        if (TypeIntrinsics.isMutableList(r33) == true) goto L24;
        r33 = null;
    L24:
        r8 = (List) r33;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r34 = Double.valueOf(((Number) r7).doubleValue());     // Catch: Throwable -> L59
        if (TypeIntrinsics.isMutableList(r34) == true) goto L30;
        r34 = null;
    L30:
        r8 = (List) r34;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r35 = Integer.valueOf(((Number) r7).intValue());     // Catch: Throwable -> L59
        if (TypeIntrinsics.isMutableList(r35) == true) goto L36;
        r35 = null;
    L36:
        r8 = (List) r35;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r36 = Long.valueOf(((Number) r7).longValue());     // Catch: Throwable -> L59
        if (TypeIntrinsics.isMutableList(r36) == true) goto L42;
        r36 = null;
    L42:
        r8 = (List) r36;     // Catch: Throwable -> L59
    L44:
        if ((r7 instanceof JSONObject) == false) goto L46;
    L187:
        Object r37 = SDKSettingsCacheManager.a().fromJson(r7.toString(), List.class);     // Catch: Throwable -> L52
        if (TypeIntrinsics.isMutableList(r37) == true) goto L50;
        r37 = null;
    L50:
        Object r38 = Result.constructor-impl((List) r37);     // Catch: Throwable -> L52
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
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L174
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L174:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        Object r42 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r43 = Result.exceptionOrNull-impl(r42);
        if (r43 == null) goto L179;
        EnsureManager.ensureNotReachHere(r43);
    L179:
        if (Result.isFailure-impl(r42) == true) goto L182;
        r2 = r42;
    L182:
        r11 = r2;
        goto L183
    }

    public static final String a(String r8) {
        Intrinsics.checkNotNullParameter(r8, "$this$filterApiEntranceInfoNeedKeys");
        if (a.isEmpty() == false) goto L5;
        return r8;
    L5:
        JSONObject r0 = new JSONObject();
        if ((!Intrinsics.areEqual(r8, "null")) == true) goto L9;
        r8 = null;
    L9:
        if (r8 == null) goto L11;
        JSONObject r9 = k.u(r8);
    L12:
        Iterator<String> r1 = r9.keys();
    L14:
        if (r1.hasNext() == false) goto L29;
        String r4 = r1.next();
        String r5 = r9.optString(r4);
        boolean r7 = false;
        if (r5.length() <= 0) goto L18;
        boolean r6 = true;
    L19:
        if (r6 == true) goto L21;
    L23:
        if (r7 == true) goto L26;
        r5 = null;
    L26:
        if (r5 == null) goto L14;
        r0.put(r4, r5);
        goto L14
    L21:
        if (a.contains(r4) == false) goto L23;
        r7 = true;
        goto L23
    L18:
        r6 = false;
        goto L19
    L29:
        return r0.toString();
    L11:
        r9 = new JSONObject();
        goto L12
    }
}
