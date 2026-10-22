package hk3;

import com.bytedance.android.ec.ab.opt.HostExperimentKey;
import com.bytedance.android.ec.ab.opt.OptSetting;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.services.apm.api.EnsureManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@OptSetting(business = "品牌馆")
public final class e {
    public static final /* synthetic */ int a = 0;

    @HostExperimentKey(author = "zhangminglei.lei", desc = "TabKit容器启动优化")
    public static final int a() {
        int r0 = n.a;
        Object r1 = 0;
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L160
        Object r4 = null;
        Object r5 = com.bytedance.android.ec.base.settings.d.c.get("tabkit_init_opt");     // Catch: Throwable -> L54
        if (r5 != null) goto L9;
    L51:
        Object r6 = null;
    L52:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L54
    L56:
        Throwable r8 = Result.exceptionOrNull-impl(r7);     // Catch: Throwable -> L160
        if (r8 == null) goto L60;
        EnsureManager.ensureNotReachHere(r8);     // Catch: Throwable -> L160
    L60:
        if (Result.isFailure-impl(r7) == false) goto L63;
        r7 = null;
    L63:
        if ((r7 instanceof Integer) == true) goto L65;
        r7 = null;
    L65:
        Object r9 = (Integer) r7;     // Catch: Throwable -> L160
        if (r9 != null) goto L72;
        Object r10 = com.bytedance.android.ec.base.settings.d.a.get("tabkit_init_opt");     // Catch: Throwable -> L160
        if ((r10 instanceof Integer) == true) goto L71;
        r10 = null;
    L71:
        r9 = (Integer) r10;     // Catch: Throwable -> L160
    L72:
        if (r9 != null) goto L170;
        int r11 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L160
        Object r12 = com.bytedance.android.ec.base.settings.d.c.get("tabkit_init_opt");     // Catch: Throwable -> L124
        if (r12 != null) goto L79;
    L121:
        Object r13 = null;
    L122:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L124
    L126:
        Throwable r15 = Result.exceptionOrNull-impl(r14);     // Catch: Throwable -> L150
        if (r15 == null) goto L130;
        EnsureManager.ensureNotReachHere(r15);     // Catch: Throwable -> L150
    L130:
        if (Result.isFailure-impl(r14) == false) goto L133;
        r14 = null;
    L133:
        if ((r14 instanceof Integer) == true) goto L135;
        r14 = null;
    L135:
        r9 = (Integer) r14;     // Catch: Throwable -> L150
        if (r9 != null) goto L158;
        IHybridHostService r16 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L150
        if (r16 == null) goto L141;
        Object r17 = r16.getHostABValue("tabkit_init_opt", r1);     // Catch: Throwable -> L150
    L142:
        if (r17 != null) goto L144;
    L149:
        r9 = r1;
        goto L158
    L144:
        if ((r17 instanceof Integer) == false) goto L147;
        r4 = r17;
    L147:
        Object r18 = (Integer) r4;     // Catch: Throwable -> L150
        if (r18 == null) goto L149;
    L157:
        r9 = r18;
        goto L158
    L141:
        r17 = null;
    L158:
        com.bytedance.android.ec.base.settings.d.d("tabkit_init_opt", r9);     // Catch: Throwable -> L160
        goto L170
    L79:
        if ((r12 instanceof Integer) == true) goto L81;
        Object r19 = null;
    L82:
        r13 = (Integer) r19;     // Catch: Throwable -> L124
        if (r13 != null) goto L122;
        if ((r12 instanceof Number) == false) goto L109;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L94;
        Float r20 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L124
        if ((r20 instanceof Integer) == true) goto L92;
        r20 = null;
    L92:
        r13 = (Integer) r20;     // Catch: Throwable -> L124
        goto L122
    L94:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L100;
        Double r21 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L124
        if ((r21 instanceof Integer) == true) goto L98;
        r21 = null;
    L98:
        r13 = (Integer) r21;     // Catch: Throwable -> L124
        goto L122
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L103;
        r13 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L124
        goto L122
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L109;
        Long r22 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L124
        if ((r22 instanceof Integer) == true) goto L107;
        r22 = null;
    L107:
        r13 = (Integer) r22;     // Catch: Throwable -> L124
    L109:
        if ((r12 instanceof JSONObject) == false) goto L111;
    L180:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L117
        Object r23 = SDKSettingsCacheManager.a().fromJson(r12.toString(), Integer.class);     // Catch: Throwable -> L117
        if ((r23 instanceof Integer) == true) goto L115;
        r23 = null;
    L115:
        Object r24 = Result.constructor-impl((Integer) r23);     // Catch: Throwable -> L117
    L119:
        r13 = r24;
        if (Result.isFailure-impl(r13) == false) goto L122;
    L117:
        th = move-exception;
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L124
        r24 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L124
        goto L119
    L111:
        if ((r12 instanceof JSONArray) == false) goto L121;
    L81:
        r19 = r12;
    L150:
        th = move-exception;
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L160
        r18 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
        Throwable r27 = Result.exceptionOrNull-impl(r18);     // Catch: Throwable -> L160
        if (r27 == null) goto L155;
        EnsureManager.ensureNotReachHere(r27);     // Catch: Throwable -> L160
    L155:
        if (Result.isFailure-impl(r18) == false) goto L157;
        r18 = r1;
    L124:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L150
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L150
    L170:
        return ((Number) r9).intValue();
    L9:
        if ((r5 instanceof Integer) == true) goto L11;
        Object r29 = null;
    L12:
        r6 = (Integer) r29;     // Catch: Throwable -> L54
        if (r6 != null) goto L52;
        if ((r5 instanceof Number) == false) goto L39;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r30 = Float.valueOf(((Number) r5).floatValue());     // Catch: Throwable -> L54
        if ((r30 instanceof Integer) == true) goto L22;
        r30 = null;
    L22:
        r6 = (Integer) r30;     // Catch: Throwable -> L54
        goto L52
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r31 = Double.valueOf(((Number) r5).doubleValue());     // Catch: Throwable -> L54
        if ((r31 instanceof Integer) == true) goto L28;
        r31 = null;
    L28:
        r6 = (Integer) r31;     // Catch: Throwable -> L54
        goto L52
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L33;
        r6 = Integer.valueOf(((Number) r5).intValue());     // Catch: Throwable -> L54
        goto L52
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L39;
        Long r32 = Long.valueOf(((Number) r5).longValue());     // Catch: Throwable -> L54
        if ((r32 instanceof Integer) == true) goto L37;
        r32 = null;
    L37:
        r6 = (Integer) r32;     // Catch: Throwable -> L54
    L39:
        if ((r5 instanceof JSONObject) == false) goto L41;
    L178:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L47
        Object r33 = SDKSettingsCacheManager.a().fromJson(r5.toString(), Integer.class);     // Catch: Throwable -> L47
        if ((r33 instanceof Integer) == true) goto L45;
        r33 = null;
    L45:
        Object r34 = Result.constructor-impl((Integer) r33);     // Catch: Throwable -> L47
    L49:
        r6 = r34;
        if (Result.isFailure-impl(r6) == false) goto L52;
    L47:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L54
        r34 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L54
        goto L49
    L41:
        if ((r5 instanceof JSONArray) == false) goto L51;
    L11:
        r29 = r5;
    L54:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L160
        r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
    L160:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        Object r38 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r39 = Result.exceptionOrNull-impl(r38);
        if (r39 == null) goto L165;
        EnsureManager.ensureNotReachHere(r39);
    L165:
        if (Result.isFailure-impl(r38) == true) goto L168;
        r1 = r38;
    L168:
        r9 = r1;
        goto L170
    }

    static {
    }
}
