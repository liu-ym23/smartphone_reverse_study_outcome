package yq3;

import com.bytedance.android.ec.ab.opt.HostExperimentKey;
import com.bytedance.android.ec.ab.opt.OptSetting;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.c;
import com.bytedance.android.ec.base.settings.d;
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
import s83.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@OptSetting(business = "橱窗AB实验参数")
public final class a {
    public static final /* synthetic */ int a = 0;

    @HostExperimentKey(author = "chenlong.hz", desc = "橱窗骨架屏样式")
    public static final int a() {
        int r0 = n.a;
        Object r1 = 0;
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L160
        Object r4 = null;
        Object r5 = d.c.get("ecom_window_tab_loading_view_type");     // Catch: Throwable -> L54
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
        Object r10 = d.a.get("ecom_window_tab_loading_view_type");     // Catch: Throwable -> L160
        if ((r10 instanceof Integer) == true) goto L71;
        r10 = null;
    L71:
        r9 = (Integer) r10;     // Catch: Throwable -> L160
    L72:
        if (r9 != null) goto L170;
        int r11 = c.a;     // Catch: Throwable -> L160
        Object r12 = d.c.get("ecom_window_tab_loading_view_type");     // Catch: Throwable -> L124
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
        Object r17 = r16.getHostABValue("ecom_window_tab_loading_view_type", r1);     // Catch: Throwable -> L150
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
        d.d("ecom_window_tab_loading_view_type", r9);     // Catch: Throwable -> L160
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

    @HostExperimentKey(author = "seven.zeng", desc = "橱窗使用ecom-image")
    public static final int b() {
        int r0 = n.a;
        Object r1 = 0;
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L160
        Object r4 = null;
        Object r5 = d.c.get("ec_window_use_ecom_image");     // Catch: Throwable -> L54
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
        Object r10 = d.a.get("ec_window_use_ecom_image");     // Catch: Throwable -> L160
        if ((r10 instanceof Integer) == true) goto L71;
        r10 = null;
    L71:
        r9 = (Integer) r10;     // Catch: Throwable -> L160
    L72:
        if (r9 != null) goto L170;
        int r11 = c.a;     // Catch: Throwable -> L160
        Object r12 = d.c.get("ec_window_use_ecom_image");     // Catch: Throwable -> L124
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
        Object r17 = r16.getHostABValue("ec_window_use_ecom_image", r1);     // Catch: Throwable -> L150
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
        d.d("ec_window_use_ecom_image", r9);     // Catch: Throwable -> L160
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

    @HostExperimentKey(author = "xuzhitao.cat", desc = "店铺直播优化实验组")
    public static final int c() {
        int r0 = m.a;
        Object r1 = 0;
        boolean r2 = ECServiceManager.a;
        g r3 = (g) ECServiceManager.c(g.class);
        if (r3 == null) goto L8;
        s83.a r4 = r3.q();
        if (r4 == null) goto L8;
        Object r5 = r4.e("store_live_optimize_group");
        if (r5 == null) goto L8;
    L175:
        return ((Number) r5).intValue();
    L8:
        int r6 = n.a;
        int r7 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L165
        Object r9 = null;
        Object r10 = d.c.get("store_live_optimize_group");     // Catch: Throwable -> L60
        if (r10 != null) goto L15;
    L57:
        Object r11 = null;
    L58:
        Object r12 = Result.constructor-impl(r11);     // Catch: Throwable -> L60
    L62:
        Throwable r13 = Result.exceptionOrNull-impl(r12);     // Catch: Throwable -> L165
        if (r13 == null) goto L66;
        EnsureManager.ensureNotReachHere(r13);     // Catch: Throwable -> L165
    L66:
        if (Result.isFailure-impl(r12) == false) goto L69;
        r12 = null;
    L69:
        if ((r12 instanceof Integer) == true) goto L71;
        r12 = null;
    L71:
        Integer r14 = (Integer) r12;     // Catch: Throwable -> L165
        if (r14 != null) goto L78;
        Object r15 = d.a.get("store_live_optimize_group");     // Catch: Throwable -> L165
        if ((r15 instanceof Integer) == true) goto L77;
        r15 = null;
    L77:
        r14 = (Integer) r15;     // Catch: Throwable -> L165
    L78:
        if (r14 == null) goto L80;
        r5 = r14;
        goto L175
    L80:
        int r16 = c.a;     // Catch: Throwable -> L165
        Object r17 = d.c.get("store_live_optimize_group");     // Catch: Throwable -> L130
        if (r17 != null) goto L85;
    L127:
        Object r18 = null;
    L128:
        Object r19 = Result.constructor-impl(r18);     // Catch: Throwable -> L130
    L132:
        Throwable r20 = Result.exceptionOrNull-impl(r19);     // Catch: Throwable -> L156
        if (r20 == null) goto L136;
        EnsureManager.ensureNotReachHere(r20);     // Catch: Throwable -> L156
    L136:
        if (Result.isFailure-impl(r19) == false) goto L139;
        r19 = null;
    L139:
        if ((r19 instanceof Integer) == true) goto L141;
        r19 = null;
    L141:
        Integer r21 = (Integer) r19;     // Catch: Throwable -> L156
        if (r21 == null) goto L144;
        r5 = r21;
    L163:
        d.d("store_live_optimize_group", r5);     // Catch: Throwable -> L165
        goto L175
    L144:
        IHybridHostService r22 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r22 == null) goto L147;
        Object r23 = r22.getHostABValue("store_live_optimize_group", r1);     // Catch: Throwable -> L156
    L148:
        if (r23 != null) goto L150;
    L162:
        r5 = r1;
        goto L163
    L150:
        if ((r23 instanceof Integer) == false) goto L153;
        r9 = r23;
    L153:
        r5 = (Integer) r9;     // Catch: Throwable -> L156
        if (r5 != null) goto L163;
    L147:
        r23 = null;
        goto L148
    L85:
        if ((r17 instanceof Integer) == true) goto L87;
        Object r24 = null;
    L88:
        r18 = (Integer) r24;     // Catch: Throwable -> L130
        if (r18 != null) goto L128;
        if ((r17 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r25 = Float.valueOf(((Number) r17).floatValue());     // Catch: Throwable -> L130
        if ((r25 instanceof Integer) == true) goto L98;
        r25 = null;
    L98:
        r18 = (Integer) r25;     // Catch: Throwable -> L130
        goto L128
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r26 = Double.valueOf(((Number) r17).doubleValue());     // Catch: Throwable -> L130
        if ((r26 instanceof Integer) == true) goto L104;
        r26 = null;
    L104:
        r18 = (Integer) r26;     // Catch: Throwable -> L130
        goto L128
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        r18 = Integer.valueOf(((Number) r17).intValue());     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r27 = Long.valueOf(((Number) r17).longValue());     // Catch: Throwable -> L130
        if ((r27 instanceof Integer) == true) goto L113;
        r27 = null;
    L113:
        r18 = (Integer) r27;     // Catch: Throwable -> L130
    L115:
        if ((r17 instanceof JSONObject) == false) goto L117;
    L183:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L123
        Object r28 = SDKSettingsCacheManager.a().fromJson(r17.toString(), Integer.class);     // Catch: Throwable -> L123
        if ((r28 instanceof Integer) == true) goto L121;
        r28 = null;
    L121:
        Object r29 = Result.constructor-impl((Integer) r28);     // Catch: Throwable -> L123
    L125:
        r18 = r29;
        if (Result.isFailure-impl(r18) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L130
        r29 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r17 instanceof JSONArray) == false) goto L127;
    L87:
        r24 = r17;
    L156:
        th = move-exception;
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L165
        r5 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
        Throwable r32 = Result.exceptionOrNull-impl(r5);     // Catch: Throwable -> L165
        if (r32 == null) goto L161;
        EnsureManager.ensureNotReachHere(r32);     // Catch: Throwable -> L165
    L161:
        if (Result.isFailure-impl(r5) == false) goto L163;
    L130:
        th = move-exception;
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L156
        r19 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
        goto L132
    L15:
        if ((r10 instanceof Integer) == true) goto L17;
        Object r34 = null;
    L18:
        r11 = (Integer) r34;     // Catch: Throwable -> L60
        if (r11 != null) goto L58;
        if ((r10 instanceof Number) == false) goto L45;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L30;
        Float r35 = Float.valueOf(((Number) r10).floatValue());     // Catch: Throwable -> L60
        if ((r35 instanceof Integer) == true) goto L28;
        r35 = null;
    L28:
        r11 = (Integer) r35;     // Catch: Throwable -> L60
        goto L58
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L36;
        Double r36 = Double.valueOf(((Number) r10).doubleValue());     // Catch: Throwable -> L60
        if ((r36 instanceof Integer) == true) goto L34;
        r36 = null;
    L34:
        r11 = (Integer) r36;     // Catch: Throwable -> L60
        goto L58
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L39;
        r11 = Integer.valueOf(((Number) r10).intValue());     // Catch: Throwable -> L60
        goto L58
    L39:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L45;
        Long r37 = Long.valueOf(((Number) r10).longValue());     // Catch: Throwable -> L60
        if ((r37 instanceof Integer) == true) goto L43;
        r37 = null;
    L43:
        r11 = (Integer) r37;     // Catch: Throwable -> L60
    L45:
        if ((r10 instanceof JSONObject) == false) goto L47;
    L181:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L53
        Object r38 = SDKSettingsCacheManager.a().fromJson(r10.toString(), Integer.class);     // Catch: Throwable -> L53
        if ((r38 instanceof Integer) == true) goto L51;
        r38 = null;
    L51:
        Object r39 = Result.constructor-impl((Integer) r38);     // Catch: Throwable -> L53
    L55:
        r11 = r39;
        if (Result.isFailure-impl(r11) == false) goto L58;
    L53:
        th = move-exception;
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L60
        r39 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L60
        goto L55
    L47:
        if ((r10 instanceof JSONArray) == false) goto L57;
    L17:
        r34 = r10;
    L60:
        th = move-exception;
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L165
        r12 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
    L165:
        th = move-exception;
        Result.Companion r42 = Result.Companion;
        Object r43 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r44 = Result.exceptionOrNull-impl(r43);
        if (r44 == null) goto L170;
        EnsureManager.ensureNotReachHere(r44);
    L170:
        if (Result.isFailure-impl(r43) == true) goto L173;
        r1 = r43;
    L173:
        r5 = r1;
        goto L175
    }

    @HostExperimentKey(author = "chenlong.hz", desc = "橱窗强制doframe")
    public static final int d() {
        int r0 = n.a;
        Object r1 = 0;
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L160
        Object r4 = null;
        Object r5 = d.c.get("window_opt_do_frame");     // Catch: Throwable -> L54
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
        Object r10 = d.a.get("window_opt_do_frame");     // Catch: Throwable -> L160
        if ((r10 instanceof Integer) == true) goto L71;
        r10 = null;
    L71:
        r9 = (Integer) r10;     // Catch: Throwable -> L160
    L72:
        if (r9 != null) goto L170;
        int r11 = c.a;     // Catch: Throwable -> L160
        Object r12 = d.c.get("window_opt_do_frame");     // Catch: Throwable -> L124
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
        Object r17 = r16.getHostABValue("window_opt_do_frame", r1);     // Catch: Throwable -> L150
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
        d.d("window_opt_do_frame", r9);     // Catch: Throwable -> L160
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

    @HostExperimentKey(author = "chenlong.hz", desc = "Lynx卡使用forest")
    public static final int e() {
        int r0 = n.a;
        Object r1 = 0;
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L160
        Object r4 = null;
        Object r5 = d.c.get("window_opt_gecko_forest");     // Catch: Throwable -> L54
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
        Object r10 = d.a.get("window_opt_gecko_forest");     // Catch: Throwable -> L160
        if ((r10 instanceof Integer) == true) goto L71;
        r10 = null;
    L71:
        r9 = (Integer) r10;     // Catch: Throwable -> L160
    L72:
        if (r9 != null) goto L170;
        int r11 = c.a;     // Catch: Throwable -> L160
        Object r12 = d.c.get("window_opt_gecko_forest");     // Catch: Throwable -> L124
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
        Object r17 = r16.getHostABValue("window_opt_gecko_forest", r1);     // Catch: Throwable -> L150
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
        d.d("window_opt_gecko_forest", r9);     // Catch: Throwable -> L160
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

    @HostExperimentKey(author = "chenlong.hz", desc = "大图子线程解码")
    public static final int f() {
        int r0 = n.a;
        Object r1 = 0;
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L160
        Object r4 = null;
        Object r5 = d.c.get("window_opt_image_decode");     // Catch: Throwable -> L54
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
        Object r10 = d.a.get("window_opt_image_decode");     // Catch: Throwable -> L160
        if ((r10 instanceof Integer) == true) goto L71;
        r10 = null;
    L71:
        r9 = (Integer) r10;     // Catch: Throwable -> L160
    L72:
        if (r9 != null) goto L170;
        int r11 = c.a;     // Catch: Throwable -> L160
        Object r12 = d.c.get("window_opt_image_decode");     // Catch: Throwable -> L124
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
        Object r17 = r16.getHostABValue("window_opt_image_decode", r1);     // Catch: Throwable -> L150
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
        d.d("window_opt_image_decode", r9);     // Catch: Throwable -> L160
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

    @HostExperimentKey(author = "yeyufeng", desc = "橱窗ssr开关")
    public static final int g() {
        int r0 = n.a;
        Object r1 = 0;
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L160
        Object r4 = null;
        Object r5 = d.c.get("ecom_window_ssr");     // Catch: Throwable -> L54
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
        Object r10 = d.a.get("ecom_window_ssr");     // Catch: Throwable -> L160
        if ((r10 instanceof Integer) == true) goto L71;
        r10 = null;
    L71:
        r9 = (Integer) r10;     // Catch: Throwable -> L160
    L72:
        if (r9 != null) goto L170;
        int r11 = c.a;     // Catch: Throwable -> L160
        Object r12 = d.c.get("ecom_window_ssr");     // Catch: Throwable -> L124
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
        Object r17 = r16.getHostABValue("ecom_window_ssr", r1);     // Catch: Throwable -> L150
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
        d.d("ecom_window_ssr", r9);     // Catch: Throwable -> L160
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
