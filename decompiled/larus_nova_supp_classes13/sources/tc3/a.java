package tc3;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.dataplatform.config.SettingPanel;
import com.bytedance.services.apm.api.EnsureManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final b a = null;

    static {
        a = new b(0);
    }

    @SettingPanel("内流体验优化")
    public static final b a() {
        int r0 = n.a;
        Object r1 = a;
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L166
        Object r4 = null;
        Object r5 = com.bytedance.android.ec.base.settings.d.c.get("deep_feed_config");     // Catch: Throwable -> L57
        if (r5 != null) goto L9;
    L54:
        Object r6 = null;
    L55:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L57
    L59:
        Throwable r8 = Result.exceptionOrNull-impl(r7);     // Catch: Throwable -> L166
        if (r8 == null) goto L63;
        EnsureManager.ensureNotReachHere(r8);     // Catch: Throwable -> L166
    L63:
        if (Result.isFailure-impl(r7) == false) goto L66;
        r7 = null;
    L66:
        if ((r7 instanceof b) == true) goto L68;
        r7 = null;
    L68:
        Object r9 = (b) r7;     // Catch: Throwable -> L166
        if (r9 != null) goto L75;
        Object r10 = com.bytedance.android.ec.base.settings.d.a.get("deep_feed_config");     // Catch: Throwable -> L166
        if ((r10 instanceof b) == true) goto L74;
        r10 = null;
    L74:
        r9 = (b) r10;     // Catch: Throwable -> L166
    L75:
        if (r9 != null) goto L176;
        int r11 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L166
        Object r12 = com.bytedance.android.ec.base.settings.d.c.get("deep_feed_config");     // Catch: Throwable -> L130
        if (r12 != null) goto L82;
    L127:
        Object r13 = null;
    L128:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L130
    L132:
        Throwable r15 = Result.exceptionOrNull-impl(r14);     // Catch: Throwable -> L156
        if (r15 == null) goto L136;
        EnsureManager.ensureNotReachHere(r15);     // Catch: Throwable -> L156
    L136:
        if (Result.isFailure-impl(r14) == false) goto L139;
        r14 = null;
    L139:
        if ((r14 instanceof b) == true) goto L141;
        r14 = null;
    L141:
        r9 = (b) r14;     // Catch: Throwable -> L156
        if (r9 != null) goto L164;
        IHybridHostService r16 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r16 == null) goto L147;
        Object r17 = r16.getHostABValue("deep_feed_config", r1);     // Catch: Throwable -> L156
    L148:
        if (r17 != null) goto L150;
    L155:
        r9 = r1;
        goto L164
    L150:
        if ((r17 instanceof b) == false) goto L153;
        r4 = r17;
    L153:
        Object r18 = (b) r4;     // Catch: Throwable -> L156
        if (r18 == null) goto L155;
    L163:
        r9 = r18;
        goto L164
    L147:
        r17 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d("deep_feed_config", r9);     // Catch: Throwable -> L166
        goto L176
    L82:
        if ((r12 instanceof b) == true) goto L84;
        Object r19 = null;
    L85:
        r13 = (b) r19;     // Catch: Throwable -> L130
        if (r13 != null) goto L128;
        if ((r12 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(b.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r20 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L130
        if ((r20 instanceof b) == true) goto L95;
        r20 = null;
    L95:
        r13 = (b) r20;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(b.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r21 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L130
        if ((r21 instanceof b) == true) goto L101;
        r21 = null;
    L101:
        r13 = (b) r21;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(b.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r22 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L130
        if ((r22 instanceof b) == true) goto L107;
        r22 = null;
    L107:
        r13 = (b) r22;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(b.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r23 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L130
        if ((r23 instanceof b) == true) goto L113;
        r23 = null;
    L113:
        r13 = (b) r23;     // Catch: Throwable -> L130
    L115:
        if ((r12 instanceof JSONObject) == false) goto L117;
    L184:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L123
        Object r24 = SDKSettingsCacheManager.a().fromJson(r12.toString(), b.class);     // Catch: Throwable -> L123
        if ((r24 instanceof b) == true) goto L121;
        r24 = null;
    L121:
        Object r25 = Result.constructor-impl((b) r24);     // Catch: Throwable -> L123
    L125:
        r13 = r25;
        if (Result.isFailure-impl(r13) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L130
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r12 instanceof JSONArray) == false) goto L127;
    L84:
        r19 = r12;
    L156:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L166
        r18 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
        Throwable r28 = Result.exceptionOrNull-impl(r18);     // Catch: Throwable -> L166
        if (r28 == null) goto L161;
        EnsureManager.ensureNotReachHere(r28);     // Catch: Throwable -> L166
    L161:
        if (Result.isFailure-impl(r18) == false) goto L163;
        r18 = r1;
    L130:
        th = move-exception;
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L156
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L176:
        return (b) r9;
    L9:
        if ((r5 instanceof b) == true) goto L11;
        Object r30 = null;
    L12:
        r6 = (b) r30;     // Catch: Throwable -> L57
        if (r6 != null) goto L55;
        if ((r5 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(b.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r31 = Float.valueOf(((Number) r5).floatValue());     // Catch: Throwable -> L57
        if ((r31 instanceof b) == true) goto L22;
        r31 = null;
    L22:
        r6 = (b) r31;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(b.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r32 = Double.valueOf(((Number) r5).doubleValue());     // Catch: Throwable -> L57
        if ((r32 instanceof b) == true) goto L28;
        r32 = null;
    L28:
        r6 = (b) r32;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(b.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r33 = Integer.valueOf(((Number) r5).intValue());     // Catch: Throwable -> L57
        if ((r33 instanceof b) == true) goto L34;
        r33 = null;
    L34:
        r6 = (b) r33;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(b.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r34 = Long.valueOf(((Number) r5).longValue());     // Catch: Throwable -> L57
        if ((r34 instanceof b) == true) goto L40;
        r34 = null;
    L40:
        r6 = (b) r34;     // Catch: Throwable -> L57
    L42:
        if ((r5 instanceof JSONObject) == false) goto L44;
    L181:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r35 = SDKSettingsCacheManager.a().fromJson(r5.toString(), b.class);     // Catch: Throwable -> L50
        if ((r35 instanceof b) == true) goto L48;
        r35 = null;
    L48:
        Object r36 = Result.constructor-impl((b) r35);     // Catch: Throwable -> L50
    L52:
        r6 = r36;
        if (Result.isFailure-impl(r6) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L57
        r36 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r5 instanceof JSONArray) == false) goto L54;
    L11:
        r30 = r5;
    L57:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L166
        r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        Object r40 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r41 = Result.exceptionOrNull-impl(r40);
        if (r41 == null) goto L171;
        EnsureManager.ensureNotReachHere(r41);
    L171:
        if (Result.isFailure-impl(r40) == true) goto L174;
        r1 = r40;
    L174:
        r9 = r1;
        goto L176
    }
}
