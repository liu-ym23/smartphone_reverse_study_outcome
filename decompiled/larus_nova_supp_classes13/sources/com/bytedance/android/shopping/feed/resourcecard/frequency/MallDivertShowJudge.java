package com.bytedance.android.shopping.feed.resourcecard.frequency;

import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.d;
import com.bytedance.android.ec.core.opt.ab.m;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.services.apm.api.EnsureManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import ld3.c;
import org.json.JSONArray;
import org.json.JSONObject;
import s83.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class MallDivertShowJudge {
    public static final Lazy g = null;
    public static final a h = null;
    public final int a;
    public final long b;
    public long c;
    public String d;
    public String e;
    public boolean f;

    public static final class a {
        public a() {
        }

        public static MallDivertShowJudge a() {
            return (MallDivertShowJudge) MallDivertShowJudge.g.getValue();
        }
    }

    static {
        h = new a();
        g = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, MallDivertShowJudge$Companion$INSTANCE$2.INSTANCE);
    }

    public final boolean a() {
        if (this.f == false) goto L6;
        return false;
    L6:
        if ((System.currentTimeMillis() - this.c) <= this.b) goto L9;
        return true;
    L9:
        return false;
    }

    public final void b() {
        if (this.a == 1) goto L6;
        return;
    L6:
        if (a() == true) goto L8;
        return;
    L8:
        this.d = this.e;
        long r0 = System.currentTimeMillis();
        this.c = r0;
        sk.a.a.getClass();
        q.a.e("ec_last_hit_mall_time", r0);
    }

    public MallDivertShowJudge() {
        this.d = "";
        this.e = "";
        int r0 = c.a;
        int r1 = m.a;
        Object r2 = 0;
        boolean r3 = ECServiceManager.a;
        g r4 = (g) ECServiceManager.c(g.class);
        if (r4 == null) goto L8;
        s83.a r5 = r4.q();
        if (r5 == null) goto L8;
        Object r6 = r5.e("ec_video_promotion_inflow_mall_card_frequency_method");
        if (r6 == null) goto L8;
    L174:
        this.a = ((Number) r6).intValue();
        int r7 = c.a;
        this.b = ((long) 172800) * 1000;
        sk.a.a.getClass();
        this.c = q.a.getLong("ec_last_hit_mall_time", 0);
        return;
    L8:
        int r8 = n.a;
        int r9 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L165
        Object r11 = null;
        Object r12 = d.c.get("ec_video_promotion_inflow_mall_card_frequency_method");     // Catch: Throwable -> L60
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
        Object r17 = d.a.get("ec_video_promotion_inflow_mall_card_frequency_method");     // Catch: Throwable -> L165
        if ((r17 instanceof Integer) == true) goto L77;
        r17 = null;
    L77:
        r16 = (Integer) r17;     // Catch: Throwable -> L165
    L78:
        if (r16 == null) goto L80;
        r6 = r16;
        goto L174
    L80:
        int r18 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L165
        Object r19 = d.c.get("ec_video_promotion_inflow_mall_card_frequency_method");     // Catch: Throwable -> L130
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
        d.d("ec_video_promotion_inflow_mall_card_frequency_method", r6);     // Catch: Throwable -> L165
        goto L174
    L144:
        IHybridHostService r24 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r24 == null) goto L147;
        Object r25 = r24.getHostABValue("ec_video_promotion_inflow_mall_card_frequency_method", r2);     // Catch: Throwable -> L156
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
    L178:
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
    L176:
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
        goto L174
    }
}
