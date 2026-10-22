package tc3;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.services.apm.api.EnsureManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public static final c a = null;

    static {
        int r0 = com.bytedance.android.ec.base.settings.a.a;
        Object r1 = new c(0);
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L166
        Object r3 = null;
        Object r4 = com.bytedance.android.ec.base.settings.d.c.get("mall_deep_feed_video_preload");     // Catch: Throwable -> L57
        if (r4 != null) goto L9;
    L54:
        Object r5 = null;
    L55:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L57
    L59:
        Throwable r7 = Result.exceptionOrNull-impl(r6);     // Catch: Throwable -> L166
        if (r7 == null) goto L63;
        EnsureManager.ensureNotReachHere(r7);     // Catch: Throwable -> L166
    L63:
        if (Result.isFailure-impl(r6) == false) goto L66;
        r6 = null;
    L66:
        if ((r6 instanceof c) == true) goto L68;
        r6 = null;
    L68:
        Object r8 = (c) r6;     // Catch: Throwable -> L166
        if (r8 != null) goto L75;
        Object r9 = com.bytedance.android.ec.base.settings.d.a.get("mall_deep_feed_video_preload");     // Catch: Throwable -> L166
        if ((r9 instanceof c) == true) goto L74;
        r9 = null;
    L74:
        r8 = (c) r9;     // Catch: Throwable -> L166
    L75:
        if (r8 != null) goto L175;
        int r10 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L166
        Object r11 = com.bytedance.android.ec.base.settings.d.c.get("mall_deep_feed_video_preload");     // Catch: Throwable -> L130
        if (r11 != null) goto L82;
    L127:
        Object r12 = null;
    L128:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L130
    L132:
        Throwable r14 = Result.exceptionOrNull-impl(r13);     // Catch: Throwable -> L156
        if (r14 == null) goto L136;
        EnsureManager.ensureNotReachHere(r14);     // Catch: Throwable -> L156
    L136:
        if (Result.isFailure-impl(r13) == false) goto L139;
        r13 = null;
    L139:
        if ((r13 instanceof c) == true) goto L141;
        r13 = null;
    L141:
        r8 = (c) r13;     // Catch: Throwable -> L156
        if (r8 != null) goto L164;
        IHybridHostService r15 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r15 == null) goto L147;
        Object r16 = r15.getHostABValue("mall_deep_feed_video_preload", r1);     // Catch: Throwable -> L156
    L148:
        if (r16 != null) goto L150;
    L155:
        r8 = r1;
        goto L164
    L150:
        if ((r16 instanceof c) == false) goto L153;
        r3 = r16;
    L153:
        Object r17 = (c) r3;     // Catch: Throwable -> L156
        if (r17 == null) goto L155;
    L163:
        r8 = r17;
        goto L164
    L147:
        r16 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d("mall_deep_feed_video_preload", r8);     // Catch: Throwable -> L166
        goto L175
    L82:
        if ((r11 instanceof c) == true) goto L84;
        Object r18 = null;
    L85:
        r12 = (c) r18;     // Catch: Throwable -> L130
        if (r12 != null) goto L128;
        if ((r11 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(c.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r19 = Float.valueOf(((Number) r11).floatValue());     // Catch: Throwable -> L130
        if ((r19 instanceof c) == true) goto L95;
        r19 = null;
    L95:
        r12 = (c) r19;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(c.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r20 = Double.valueOf(((Number) r11).doubleValue());     // Catch: Throwable -> L130
        if ((r20 instanceof c) == true) goto L101;
        r20 = null;
    L101:
        r12 = (c) r20;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(c.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r21 = Integer.valueOf(((Number) r11).intValue());     // Catch: Throwable -> L130
        if ((r21 instanceof c) == true) goto L107;
        r21 = null;
    L107:
        r12 = (c) r21;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(c.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r22 = Long.valueOf(((Number) r11).longValue());     // Catch: Throwable -> L130
        if ((r22 instanceof c) == true) goto L113;
        r22 = null;
    L113:
        r12 = (c) r22;     // Catch: Throwable -> L130
    L115:
        if ((r11 instanceof JSONObject) == false) goto L117;
    L184:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L123
        Object r23 = SDKSettingsCacheManager.a().fromJson(r11.toString(), c.class);     // Catch: Throwable -> L123
        if ((r23 instanceof c) == true) goto L121;
        r23 = null;
    L121:
        Object r24 = Result.constructor-impl((c) r23);     // Catch: Throwable -> L123
    L125:
        r12 = r24;
        if (Result.isFailure-impl(r12) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L130
        r24 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r11 instanceof JSONArray) == false) goto L127;
    L84:
        r18 = r11;
    L156:
        th = move-exception;
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L166
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
        Throwable r27 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L166
        if (r27 == null) goto L161;
        EnsureManager.ensureNotReachHere(r27);     // Catch: Throwable -> L166
    L161:
        if (Result.isFailure-impl(r17) == false) goto L163;
        r17 = r1;
    L130:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L156
        r13 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L175:
        a = (c) r8;
        return;
    L9:
        if ((r4 instanceof c) == true) goto L11;
        Object r29 = null;
    L12:
        r5 = (c) r29;     // Catch: Throwable -> L57
        if (r5 != null) goto L55;
        if ((r4 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(c.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r30 = Float.valueOf(((Number) r4).floatValue());     // Catch: Throwable -> L57
        if ((r30 instanceof c) == true) goto L22;
        r30 = null;
    L22:
        r5 = (c) r30;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(c.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r31 = Double.valueOf(((Number) r4).doubleValue());     // Catch: Throwable -> L57
        if ((r31 instanceof c) == true) goto L28;
        r31 = null;
    L28:
        r5 = (c) r31;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(c.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r32 = Integer.valueOf(((Number) r4).intValue());     // Catch: Throwable -> L57
        if ((r32 instanceof c) == true) goto L34;
        r32 = null;
    L34:
        r5 = (c) r32;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(c.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r33 = Long.valueOf(((Number) r4).longValue());     // Catch: Throwable -> L57
        if ((r33 instanceof c) == true) goto L40;
        r33 = null;
    L40:
        r5 = (c) r33;     // Catch: Throwable -> L57
    L42:
        if ((r4 instanceof JSONObject) == false) goto L44;
    L181:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r34 = SDKSettingsCacheManager.a().fromJson(r4.toString(), c.class);     // Catch: Throwable -> L50
        if ((r34 instanceof c) == true) goto L48;
        r34 = null;
    L48:
        Object r35 = Result.constructor-impl((c) r34);     // Catch: Throwable -> L50
    L52:
        r5 = r35;
        if (Result.isFailure-impl(r5) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L57
        r35 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r4 instanceof JSONArray) == false) goto L54;
    L11:
        r29 = r4;
    L57:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L166
        r6 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        Object r39 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r40 = Result.exceptionOrNull-impl(r39);
        if (r40 == null) goto L171;
        EnsureManager.ensureNotReachHere(r40);
    L171:
        if (Result.isFailure-impl(r39) == true) goto L174;
        r1 = r39;
    L174:
        r8 = r1;
        goto L175
    }
}
