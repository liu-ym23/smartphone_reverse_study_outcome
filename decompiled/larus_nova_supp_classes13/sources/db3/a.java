package db3;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.g;
import com.bytedance.android.ec.base.settings.h;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: db3.a$a, reason: collision with other inner class name */
    public static final class C0188a {
        public static b a() {
            int r0 = com.bytedance.android.ec.base.settings.b.a;
            Object r1 = new b();
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L172
            h.a();     // Catch: Throwable -> L172
            SDKSettingsCacheManager r3 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
            Object r4 = null;
            r3.getClass();     // Catch: Throwable -> L59
            Object r5 = SDKSettingsCacheManager.b.get("iesec_cart_popup_config");     // Catch: Throwable -> L59
            if (r5 != null) goto L11;
        L56:
            Object r6 = null;
        L57:
            Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L59
        L61:
            Throwable r8 = Result.exceptionOrNull-impl(r7);     // Catch: Throwable -> L172
            if (r8 == null) goto L65;
            EnsureManager.ensureNotReachHere(r8);     // Catch: Throwable -> L172
        L65:
            if (Result.isFailure-impl(r7) == false) goto L68;
            r7 = null;
        L68:
            if ((r7 instanceof b) == true) goto L70;
            r7 = null;
        L70:
            Object r9 = (b) r7;     // Catch: Throwable -> L172
            if (r9 != null) goto L77;
            r3.getClass();     // Catch: Throwable -> L172
            Object r10 = SDKSettingsCacheManager.a.get("iesec_cart_popup_config");     // Catch: Throwable -> L172
            if ((r10 instanceof b) == true) goto L76;
            r10 = null;
        L76:
            r9 = (b) r10;     // Catch: Throwable -> L172
        L77:
            if (r9 != null) goto L182;
            int r11 = g.a;     // Catch: Throwable -> L172
        L159:
            th = move-exception;
            Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L172
            Object r13 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
        L162:
            if (Result.exceptionOrNull-impl(r13) != null) goto L185;
        L169:
            r9 = r13;
        L170:
            SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L172
            SDKSettingsCacheManager.e("iesec_cart_popup_config", r9);     // Catch: Throwable -> L172
            goto L182
        L185:
            r13 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_cart_popup_config", b.class, r1);     // Catch: Throwable -> L166
        L167:
            if (r13 != null) goto L169;
            r9 = r1;
        L166:
            r13 = r1;
            goto L167
        L191:
            SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
            Object r14 = SDKSettingsCacheManager.b.get("iesec_cart_popup_config");     // Catch: Throwable -> L133
            if (r14 != null) goto L85;
        L130:
            Object r15 = null;
        L131:
            Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L133
        L135:
            Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L159
            if (r17 == null) goto L139;
            EnsureManager.ensureNotReachHere(r17);     // Catch: Throwable -> L159
        L139:
            if (Result.isFailure-impl(r16) == false) goto L142;
            r16 = null;
        L142:
            if ((r16 instanceof b) == true) goto L144;
            r16 = null;
        L144:
            r13 = (b) r16;     // Catch: Throwable -> L159
            if (r13 != null) goto L169;
            jj4.b r18 = jj4.b.b;     // Catch: Throwable -> L159
            Object r19 = jj4.a.a("iesec_cart_popup_config", b.class, r1, false);     // Catch: Throwable -> L159
            if (r19 != null) goto L151;
            Intrinsics.throwNpe();     // Catch: Throwable -> L159
        L151:
            if ((r19 instanceof b) == false) goto L154;
            r4 = r19;
        L154:
            Object r20 = (b) r4;     // Catch: Throwable -> L159
            if (r20 != null) goto L157;
            r20 = r1;
        L157:
            r13 = Result.constructor-impl(r20);     // Catch: Throwable -> L159
        L85:
            if ((r14 instanceof b) == true) goto L87;
            Object r21 = null;
        L88:
            r15 = (b) r21;     // Catch: Throwable -> L133
            if (r15 != null) goto L131;
            if ((r14 instanceof Number) == false) goto L118;
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(b.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
            Float r22 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L133
            if ((r22 instanceof b) == true) goto L98;
            r22 = null;
        L98:
            r15 = (b) r22;     // Catch: Throwable -> L133
            goto L131
        L100:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(b.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
            Double r23 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L133
            if ((r23 instanceof b) == true) goto L104;
            r23 = null;
        L104:
            r15 = (b) r23;     // Catch: Throwable -> L133
            goto L131
        L106:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(b.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
            Integer r24 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L133
            if ((r24 instanceof b) == true) goto L110;
            r24 = null;
        L110:
            r15 = (b) r24;     // Catch: Throwable -> L133
            goto L131
        L112:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(b.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
            Long r25 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L133
            if ((r25 instanceof b) == true) goto L116;
            r25 = null;
        L116:
            r15 = (b) r25;     // Catch: Throwable -> L133
        L118:
            if ((r14 instanceof JSONObject) == false) goto L120;
        L183:
            Object r26 = SDKSettingsCacheManager.a().fromJson(r14.toString(), b.class);     // Catch: Throwable -> L126
            if ((r26 instanceof b) == true) goto L124;
            r26 = null;
        L124:
            Object r27 = Result.constructor-impl((b) r26);     // Catch: Throwable -> L126
        L128:
            r15 = r27;
            if (Result.isFailure-impl(r15) == false) goto L131;
        L126:
            th = move-exception;
            Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L133
            r27 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L133
            goto L128
        L120:
            if ((r14 instanceof JSONArray) == false) goto L130;
        L87:
            r21 = r14;
        L133:
            th = move-exception;
            Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L159
            r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L159
        L182:
            return (b) r9;
        L11:
            if ((r5 instanceof b) == true) goto L13;
            Object r30 = null;
        L14:
            r6 = (b) r30;     // Catch: Throwable -> L59
            if (r6 != null) goto L57;
            if ((r5 instanceof Number) == false) goto L44;
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(b.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
            Float r31 = Float.valueOf(((Number) r5).floatValue());     // Catch: Throwable -> L59
            if ((r31 instanceof b) == true) goto L24;
            r31 = null;
        L24:
            r6 = (b) r31;     // Catch: Throwable -> L59
            goto L57
        L26:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(b.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
            Double r32 = Double.valueOf(((Number) r5).doubleValue());     // Catch: Throwable -> L59
            if ((r32 instanceof b) == true) goto L30;
            r32 = null;
        L30:
            r6 = (b) r32;     // Catch: Throwable -> L59
            goto L57
        L32:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(b.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
            Integer r33 = Integer.valueOf(((Number) r5).intValue());     // Catch: Throwable -> L59
            if ((r33 instanceof b) == true) goto L36;
            r33 = null;
        L36:
            r6 = (b) r33;     // Catch: Throwable -> L59
            goto L57
        L38:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(b.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
            Long r34 = Long.valueOf(((Number) r5).longValue());     // Catch: Throwable -> L59
            if ((r34 instanceof b) == true) goto L42;
            r34 = null;
        L42:
            r6 = (b) r34;     // Catch: Throwable -> L59
        L44:
            if ((r5 instanceof JSONObject) == false) goto L46;
        L189:
            Object r35 = SDKSettingsCacheManager.a().fromJson(r5.toString(), b.class);     // Catch: Throwable -> L52
            if ((r35 instanceof b) == true) goto L50;
            r35 = null;
        L50:
            Object r36 = Result.constructor-impl((b) r35);     // Catch: Throwable -> L52
        L54:
            r6 = r36;
            if (Result.isFailure-impl(r6) == false) goto L57;
        L52:
            th = move-exception;
            Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L59
            r36 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
            goto L54
        L46:
            if ((r5 instanceof JSONArray) == false) goto L56;
        L13:
            r30 = r5;
        L59:
            th = move-exception;
            Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L172
            r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
        L172:
            th = move-exception;
            Result.Companion r39 = Result.Companion;
            Object r40 = Result.constructor-impl(ResultKt.createFailure(th));
            Throwable r41 = Result.exceptionOrNull-impl(r40);
            if (r41 == null) goto L177;
            EnsureManager.ensureNotReachHere(r41);
        L177:
            if (Result.isFailure-impl(r40) == true) goto L180;
            r1 = r40;
        L180:
            r9 = r1;
            goto L182
        }

        public static boolean b() {
            int r0 = com.bytedance.android.ec.base.settings.b.a;
            Object r1 = Boolean.FALSE;
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L172
            h.a();     // Catch: Throwable -> L172
            SDKSettingsCacheManager r3 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
            Object r4 = null;
            r3.getClass();     // Catch: Throwable -> L59
            Object r5 = SDKSettingsCacheManager.b.get("ecom_cart_enable_frontier");     // Catch: Throwable -> L59
            if (r5 != null) goto L11;
        L56:
            Object r6 = null;
        L57:
            Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L59
        L61:
            Throwable r8 = Result.exceptionOrNull-impl(r7);     // Catch: Throwable -> L172
            if (r8 == null) goto L65;
            EnsureManager.ensureNotReachHere(r8);     // Catch: Throwable -> L172
        L65:
            if (Result.isFailure-impl(r7) == false) goto L68;
            r7 = null;
        L68:
            if ((r7 instanceof Boolean) == true) goto L70;
            r7 = null;
        L70:
            Object r9 = (Boolean) r7;     // Catch: Throwable -> L172
            if (r9 != null) goto L77;
            r3.getClass();     // Catch: Throwable -> L172
            Object r10 = SDKSettingsCacheManager.a.get("ecom_cart_enable_frontier");     // Catch: Throwable -> L172
            if ((r10 instanceof Boolean) == true) goto L76;
            r10 = null;
        L76:
            r9 = (Boolean) r10;     // Catch: Throwable -> L172
        L77:
            if (r9 != null) goto L182;
            int r11 = g.a;     // Catch: Throwable -> L172
        L159:
            th = move-exception;
            Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L172
            Object r13 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
        L162:
            if (Result.exceptionOrNull-impl(r13) != null) goto L185;
        L169:
            r9 = r13;
        L170:
            SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L172
            SDKSettingsCacheManager.e("ecom_cart_enable_frontier", r9);     // Catch: Throwable -> L172
            goto L182
        L185:
            r13 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ecom_cart_enable_frontier", Boolean.class, r1);     // Catch: Throwable -> L166
        L167:
            if (r13 != null) goto L169;
            r9 = r1;
        L166:
            r13 = r1;
            goto L167
        L191:
            SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
            Object r14 = SDKSettingsCacheManager.b.get("ecom_cart_enable_frontier");     // Catch: Throwable -> L133
            if (r14 != null) goto L85;
        L130:
            Object r15 = null;
        L131:
            Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L133
        L135:
            Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L159
            if (r17 == null) goto L139;
            EnsureManager.ensureNotReachHere(r17);     // Catch: Throwable -> L159
        L139:
            if (Result.isFailure-impl(r16) == false) goto L142;
            r16 = null;
        L142:
            if ((r16 instanceof Boolean) == true) goto L144;
            r16 = null;
        L144:
            r13 = (Boolean) r16;     // Catch: Throwable -> L159
            if (r13 != null) goto L169;
            jj4.b r18 = jj4.b.b;     // Catch: Throwable -> L159
            Object r19 = jj4.a.a("ecom_cart_enable_frontier", Boolean.class, r1, false);     // Catch: Throwable -> L159
            if (r19 != null) goto L151;
            Intrinsics.throwNpe();     // Catch: Throwable -> L159
        L151:
            if ((r19 instanceof Boolean) == false) goto L154;
            r4 = r19;
        L154:
            Object r20 = (Boolean) r4;     // Catch: Throwable -> L159
            if (r20 != null) goto L157;
            r20 = r1;
        L157:
            r13 = Result.constructor-impl(r20);     // Catch: Throwable -> L159
        L85:
            if ((r14 instanceof Boolean) == true) goto L87;
            Object r21 = null;
        L88:
            r15 = (Boolean) r21;     // Catch: Throwable -> L133
            if (r15 != null) goto L131;
            if ((r14 instanceof Number) == false) goto L118;
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
            Float r22 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L133
            if ((r22 instanceof Boolean) == true) goto L98;
            r22 = null;
        L98:
            r15 = (Boolean) r22;     // Catch: Throwable -> L133
            goto L131
        L100:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
            Double r23 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L133
            if ((r23 instanceof Boolean) == true) goto L104;
            r23 = null;
        L104:
            r15 = (Boolean) r23;     // Catch: Throwable -> L133
            goto L131
        L106:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
            Integer r24 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L133
            if ((r24 instanceof Boolean) == true) goto L110;
            r24 = null;
        L110:
            r15 = (Boolean) r24;     // Catch: Throwable -> L133
            goto L131
        L112:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
            Long r25 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L133
            if ((r25 instanceof Boolean) == true) goto L116;
            r25 = null;
        L116:
            r15 = (Boolean) r25;     // Catch: Throwable -> L133
        L118:
            if ((r14 instanceof JSONObject) == false) goto L120;
        L183:
            Object r26 = SDKSettingsCacheManager.a().fromJson(r14.toString(), Boolean.class);     // Catch: Throwable -> L126
            if ((r26 instanceof Boolean) == true) goto L124;
            r26 = null;
        L124:
            Object r27 = Result.constructor-impl((Boolean) r26);     // Catch: Throwable -> L126
        L128:
            r15 = r27;
            if (Result.isFailure-impl(r15) == false) goto L131;
        L126:
            th = move-exception;
            Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L133
            r27 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L133
            goto L128
        L120:
            if ((r14 instanceof JSONArray) == false) goto L130;
        L87:
            r21 = r14;
        L133:
            th = move-exception;
            Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L159
            r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L159
        L182:
            return ((Boolean) r9).booleanValue();
        L11:
            if ((r5 instanceof Boolean) == true) goto L13;
            Object r30 = null;
        L14:
            r6 = (Boolean) r30;     // Catch: Throwable -> L59
            if (r6 != null) goto L57;
            if ((r5 instanceof Number) == false) goto L44;
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
            Float r31 = Float.valueOf(((Number) r5).floatValue());     // Catch: Throwable -> L59
            if ((r31 instanceof Boolean) == true) goto L24;
            r31 = null;
        L24:
            r6 = (Boolean) r31;     // Catch: Throwable -> L59
            goto L57
        L26:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
            Double r32 = Double.valueOf(((Number) r5).doubleValue());     // Catch: Throwable -> L59
            if ((r32 instanceof Boolean) == true) goto L30;
            r32 = null;
        L30:
            r6 = (Boolean) r32;     // Catch: Throwable -> L59
            goto L57
        L32:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
            Integer r33 = Integer.valueOf(((Number) r5).intValue());     // Catch: Throwable -> L59
            if ((r33 instanceof Boolean) == true) goto L36;
            r33 = null;
        L36:
            r6 = (Boolean) r33;     // Catch: Throwable -> L59
            goto L57
        L38:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
            Long r34 = Long.valueOf(((Number) r5).longValue());     // Catch: Throwable -> L59
            if ((r34 instanceof Boolean) == true) goto L42;
            r34 = null;
        L42:
            r6 = (Boolean) r34;     // Catch: Throwable -> L59
        L44:
            if ((r5 instanceof JSONObject) == false) goto L46;
        L189:
            Object r35 = SDKSettingsCacheManager.a().fromJson(r5.toString(), Boolean.class);     // Catch: Throwable -> L52
            if ((r35 instanceof Boolean) == true) goto L50;
            r35 = null;
        L50:
            Object r36 = Result.constructor-impl((Boolean) r35);     // Catch: Throwable -> L52
        L54:
            r6 = r36;
            if (Result.isFailure-impl(r6) == false) goto L57;
        L52:
            th = move-exception;
            Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L59
            r36 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
            goto L54
        L46:
            if ((r5 instanceof JSONArray) == false) goto L56;
        L13:
            r30 = r5;
        L59:
            th = move-exception;
            Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L172
            r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
        L172:
            th = move-exception;
            Result.Companion r39 = Result.Companion;
            Object r40 = Result.constructor-impl(ResultKt.createFailure(th));
            Throwable r41 = Result.exceptionOrNull-impl(r40);
            if (r41 == null) goto L177;
            EnsureManager.ensureNotReachHere(r41);
        L177:
            if (Result.isFailure-impl(r40) == true) goto L180;
            r1 = r40;
        L180:
            r9 = r1;
            goto L182
        }
    }

    static {
    }
}
