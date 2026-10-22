package ld3;

import com.bytedance.android.ec.ab.opt.HostExperimentKey;
import com.bytedance.android.ec.ab.opt.OptSetting;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.opt.ab.m;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.dataplatform.config.SettingPanel;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;
import s83.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@OptSetting(business = "短视频ab实验管理类")
public final class c {
    public static final /* synthetic */ int a = 0;

    @HostExperimentKey
    public static final int a() {
        int r0 = m.a;
        Object r1 = 0;
        boolean r2 = ECServiceManager.a;
        g r3 = (g) ECServiceManager.c(g.class);
        if (r3 == null) goto L8;
        s83.a r4 = r3.q();
        if (r4 == null) goto L8;
        Object r5 = r4.e("ecom_video_add_feedback_panel");
        if (r5 == null) goto L8;
    L175:
        return ((Number) r5).intValue();
    L8:
        int r6 = n.a;
        int r7 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L165
        Object r9 = null;
        Object r10 = com.bytedance.android.ec.base.settings.d.c.get("ecom_video_add_feedback_panel");     // Catch: Throwable -> L60
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
        Object r15 = com.bytedance.android.ec.base.settings.d.a.get("ecom_video_add_feedback_panel");     // Catch: Throwable -> L165
        if ((r15 instanceof Integer) == true) goto L77;
        r15 = null;
    L77:
        r14 = (Integer) r15;     // Catch: Throwable -> L165
    L78:
        if (r14 == null) goto L80;
        r5 = r14;
        goto L175
    L80:
        int r16 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L165
        Object r17 = com.bytedance.android.ec.base.settings.d.c.get("ecom_video_add_feedback_panel");     // Catch: Throwable -> L130
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
        com.bytedance.android.ec.base.settings.d.d("ecom_video_add_feedback_panel", r5);     // Catch: Throwable -> L165
        goto L175
    L144:
        IHybridHostService r22 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r22 == null) goto L147;
        Object r23 = r22.getHostABValue("ecom_video_add_feedback_panel", r1);     // Catch: Throwable -> L156
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

    @HostExperimentKey
    public static final int b() {
        int r0 = m.a;
        Object r1 = 0;
        boolean r2 = ECServiceManager.a;
        g r3 = (g) ECServiceManager.c(g.class);
        if (r3 == null) goto L8;
        s83.a r4 = r3.q();
        if (r4 == null) goto L8;
        Object r5 = r4.e("ec_inflow_cache_resp");
        if (r5 == null) goto L8;
    L175:
        return ((Number) r5).intValue();
    L8:
        int r6 = n.a;
        int r7 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L165
        Object r9 = null;
        Object r10 = com.bytedance.android.ec.base.settings.d.c.get("ec_inflow_cache_resp");     // Catch: Throwable -> L60
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
        Object r15 = com.bytedance.android.ec.base.settings.d.a.get("ec_inflow_cache_resp");     // Catch: Throwable -> L165
        if ((r15 instanceof Integer) == true) goto L77;
        r15 = null;
    L77:
        r14 = (Integer) r15;     // Catch: Throwable -> L165
    L78:
        if (r14 == null) goto L80;
        r5 = r14;
        goto L175
    L80:
        int r16 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L165
        Object r17 = com.bytedance.android.ec.base.settings.d.c.get("ec_inflow_cache_resp");     // Catch: Throwable -> L130
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
        com.bytedance.android.ec.base.settings.d.d("ec_inflow_cache_resp", r5);     // Catch: Throwable -> L165
        goto L175
    L144:
        IHybridHostService r22 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r22 == null) goto L147;
        Object r23 = r22.getHostABValue("ec_inflow_cache_resp", r1);     // Catch: Throwable -> L156
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

    @HostExperimentKey
    public static final List<String> c() {
        int r0 = m.a;
        Object r1 = CollectionsKt.emptyList();
        boolean r2 = ECServiceManager.a;
        g r3 = (g) ECServiceManager.c(g.class);
        if (r3 == null) goto L8;
        s83.a r4 = r3.q();
        if (r4 == null) goto L8;
        Object r5 = r4.e("ec_goods_feed_host_list");
        if (r5 == null) goto L8;
    L185:
        return (List) r5;
    L8:
        int r6 = n.a;
        int r7 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L175
        Object r9 = null;
        Object r10 = com.bytedance.android.ec.base.settings.d.c.get("ec_goods_feed_host_list");     // Catch: Throwable -> L63
        if (r10 != null) goto L15;
    L60:
        Object r11 = null;
    L61:
        Object r12 = Result.constructor-impl(r11);     // Catch: Throwable -> L63
    L65:
        Throwable r13 = Result.exceptionOrNull-impl(r12);     // Catch: Throwable -> L175
        if (r13 == null) goto L69;
        EnsureManager.ensureNotReachHere(r13);     // Catch: Throwable -> L175
    L69:
        if (Result.isFailure-impl(r12) == false) goto L72;
        r12 = null;
    L72:
        if ((r12 instanceof List) == true) goto L74;
        r12 = null;
    L74:
        List r14 = (List) r12;     // Catch: Throwable -> L175
        if (r14 != null) goto L77;
    L79:
        Object r15 = com.bytedance.android.ec.base.settings.d.a.get("ec_goods_feed_host_list");     // Catch: Throwable -> L175
        if ((r15 instanceof List) == true) goto L82;
        r15 = null;
    L82:
        r14 = (List) r15;     // Catch: Throwable -> L175
    L83:
        if (r14 == null) goto L85;
        r5 = r14;
        goto L185
    L85:
        int r16 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L175
        Object r17 = com.bytedance.android.ec.base.settings.d.c.get("ec_goods_feed_host_list");     // Catch: Throwable -> L138
        if (r17 != null) goto L90;
    L135:
        Object r18 = null;
    L136:
        Object r19 = Result.constructor-impl(r18);     // Catch: Throwable -> L138
    L140:
        Throwable r20 = Result.exceptionOrNull-impl(r19);     // Catch: Throwable -> L166
        if (r20 == null) goto L144;
        EnsureManager.ensureNotReachHere(r20);     // Catch: Throwable -> L166
    L144:
        if (Result.isFailure-impl(r19) == false) goto L147;
        r19 = null;
    L147:
        if ((r19 instanceof List) == true) goto L149;
        r19 = null;
    L149:
        List r21 = (List) r19;     // Catch: Throwable -> L166
        if (r21 != null) goto L152;
    L154:
        IHybridHostService r22 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L166
        if (r22 == null) goto L157;
        Object r23 = r22.getHostABValue("ec_goods_feed_host_list", r1);     // Catch: Throwable -> L166
    L158:
        if (r23 != null) goto L160;
    L172:
        r5 = r1;
    L173:
        com.bytedance.android.ec.base.settings.d.d("ec_goods_feed_host_list", r5);     // Catch: Throwable -> L175
        goto L185
    L160:
        if ((r23 instanceof List) == false) goto L163;
        r9 = r23;
    L163:
        r5 = (List) r9;     // Catch: Throwable -> L166
        if (r5 != null) goto L173;
    L166:
        th = move-exception;
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L175
        r5 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L175
        Throwable r25 = Result.exceptionOrNull-impl(r5);     // Catch: Throwable -> L175
        if (r25 == null) goto L171;
        EnsureManager.ensureNotReachHere(r25);     // Catch: Throwable -> L175
    L171:
        if (Result.isFailure-impl(r5) == false) goto L173;
    L157:
        r23 = null;
        goto L158
    L152:
        if ((r21 instanceof List) == false) goto L154;
        r5 = r21;
        goto L173
    L90:
        if ((r17 instanceof List) == true) goto L92;
        Object r26 = null;
    L93:
        r18 = (List) r26;     // Catch: Throwable -> L138
        if (r18 != null) goto L136;
        if ((r17 instanceof Number) == false) goto L123;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L105;
        Float r27 = Float.valueOf(((Number) r17).floatValue());     // Catch: Throwable -> L138
        if ((r27 instanceof List) == true) goto L103;
        r27 = null;
    L103:
        r18 = (List) r27;     // Catch: Throwable -> L138
        goto L136
    L105:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L111;
        Double r28 = Double.valueOf(((Number) r17).doubleValue());     // Catch: Throwable -> L138
        if ((r28 instanceof List) == true) goto L109;
        r28 = null;
    L109:
        r18 = (List) r28;     // Catch: Throwable -> L138
        goto L136
    L111:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L117;
        Integer r29 = Integer.valueOf(((Number) r17).intValue());     // Catch: Throwable -> L138
        if ((r29 instanceof List) == true) goto L115;
        r29 = null;
    L115:
        r18 = (List) r29;     // Catch: Throwable -> L138
        goto L136
    L117:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L123;
        Long r30 = Long.valueOf(((Number) r17).longValue());     // Catch: Throwable -> L138
        if ((r30 instanceof List) == true) goto L121;
        r30 = null;
    L121:
        r18 = (List) r30;     // Catch: Throwable -> L138
    L123:
        if ((r17 instanceof JSONObject) == false) goto L125;
    L194:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L131
        Object r31 = SDKSettingsCacheManager.a().fromJson(r17.toString(), List.class);     // Catch: Throwable -> L131
        if ((r31 instanceof List) == true) goto L129;
        r31 = null;
    L129:
        Object r32 = Result.constructor-impl((List) r31);     // Catch: Throwable -> L131
    L133:
        r18 = r32;
        if (Result.isFailure-impl(r18) == false) goto L136;
    L131:
        th = move-exception;
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L138
        r32 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L138
        goto L133
    L125:
        if ((r17 instanceof JSONArray) == false) goto L135;
    L92:
        r26 = r17;
    L138:
        th = move-exception;
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L166
        r19 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
        goto L140
    L77:
        if ((r14 instanceof List) == false) goto L79;
    L15:
        if ((r10 instanceof List) == true) goto L17;
        Object r35 = null;
    L18:
        r11 = (List) r35;     // Catch: Throwable -> L63
        if (r11 != null) goto L61;
        if ((r10 instanceof Number) == false) goto L48;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L30;
        Float r36 = Float.valueOf(((Number) r10).floatValue());     // Catch: Throwable -> L63
        if ((r36 instanceof List) == true) goto L28;
        r36 = null;
    L28:
        r11 = (List) r36;     // Catch: Throwable -> L63
        goto L61
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L36;
        Double r37 = Double.valueOf(((Number) r10).doubleValue());     // Catch: Throwable -> L63
        if ((r37 instanceof List) == true) goto L34;
        r37 = null;
    L34:
        r11 = (List) r37;     // Catch: Throwable -> L63
        goto L61
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L42;
        Integer r38 = Integer.valueOf(((Number) r10).intValue());     // Catch: Throwable -> L63
        if ((r38 instanceof List) == true) goto L40;
        r38 = null;
    L40:
        r11 = (List) r38;     // Catch: Throwable -> L63
        goto L61
    L42:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L48;
        Long r39 = Long.valueOf(((Number) r10).longValue());     // Catch: Throwable -> L63
        if ((r39 instanceof List) == true) goto L46;
        r39 = null;
    L46:
        r11 = (List) r39;     // Catch: Throwable -> L63
    L48:
        if ((r10 instanceof JSONObject) == false) goto L50;
    L196:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L56
        Object r40 = SDKSettingsCacheManager.a().fromJson(r10.toString(), List.class);     // Catch: Throwable -> L56
        if ((r40 instanceof List) == true) goto L54;
        r40 = null;
    L54:
        Object r41 = Result.constructor-impl((List) r40);     // Catch: Throwable -> L56
    L58:
        r11 = r41;
        if (Result.isFailure-impl(r11) == false) goto L61;
    L56:
        th = move-exception;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L63
        r41 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L63
        goto L58
    L50:
        if ((r10 instanceof JSONArray) == false) goto L60;
    L17:
        r35 = r10;
    L63:
        th = move-exception;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L175
        r12 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L175
    L175:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        Object r45 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r46 = Result.exceptionOrNull-impl(r45);
        if (r46 == null) goto L180;
        EnsureManager.ensureNotReachHere(r46);
    L180:
        if (Result.isFailure-impl(r45) == true) goto L183;
        r1 = r45;
    L183:
        r5 = r1;
        goto L185
    }

    @SettingPanel("内流替换价格字体")
    public static final boolean d() {
        int r0 = n.a;
        Object r1 = Boolean.TRUE;
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L166
        Object r4 = null;
        Object r5 = com.bytedance.android.ec.base.settings.d.c.get("ec_inflow_typeface_new");     // Catch: Throwable -> L57
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
        if ((r7 instanceof Boolean) == true) goto L68;
        r7 = null;
    L68:
        Object r9 = (Boolean) r7;     // Catch: Throwable -> L166
        if (r9 != null) goto L75;
        Object r10 = com.bytedance.android.ec.base.settings.d.a.get("ec_inflow_typeface_new");     // Catch: Throwable -> L166
        if ((r10 instanceof Boolean) == true) goto L74;
        r10 = null;
    L74:
        r9 = (Boolean) r10;     // Catch: Throwable -> L166
    L75:
        if (r9 != null) goto L176;
        int r11 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L166
        Object r12 = com.bytedance.android.ec.base.settings.d.c.get("ec_inflow_typeface_new");     // Catch: Throwable -> L130
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
        if ((r14 instanceof Boolean) == true) goto L141;
        r14 = null;
    L141:
        r9 = (Boolean) r14;     // Catch: Throwable -> L156
        if (r9 != null) goto L164;
        IHybridHostService r16 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r16 == null) goto L147;
        Object r17 = r16.getHostABValue("ec_inflow_typeface_new", r1);     // Catch: Throwable -> L156
    L148:
        if (r17 != null) goto L150;
    L155:
        r9 = r1;
        goto L164
    L150:
        if ((r17 instanceof Boolean) == false) goto L153;
        r4 = r17;
    L153:
        Object r18 = (Boolean) r4;     // Catch: Throwable -> L156
        if (r18 == null) goto L155;
    L163:
        r9 = r18;
        goto L164
    L147:
        r17 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d("ec_inflow_typeface_new", r9);     // Catch: Throwable -> L166
        goto L176
    L82:
        if ((r12 instanceof Boolean) == true) goto L84;
        Object r19 = null;
    L85:
        r13 = (Boolean) r19;     // Catch: Throwable -> L130
        if (r13 != null) goto L128;
        if ((r12 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r20 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L130
        if ((r20 instanceof Boolean) == true) goto L95;
        r20 = null;
    L95:
        r13 = (Boolean) r20;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r21 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L130
        if ((r21 instanceof Boolean) == true) goto L101;
        r21 = null;
    L101:
        r13 = (Boolean) r21;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r22 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L130
        if ((r22 instanceof Boolean) == true) goto L107;
        r22 = null;
    L107:
        r13 = (Boolean) r22;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r23 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L130
        if ((r23 instanceof Boolean) == true) goto L113;
        r23 = null;
    L113:
        r13 = (Boolean) r23;     // Catch: Throwable -> L130
    L115:
        if ((r12 instanceof JSONObject) == false) goto L117;
    L184:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L123
        Object r24 = SDKSettingsCacheManager.a().fromJson(r12.toString(), Boolean.class);     // Catch: Throwable -> L123
        if ((r24 instanceof Boolean) == true) goto L121;
        r24 = null;
    L121:
        Object r25 = Result.constructor-impl((Boolean) r24);     // Catch: Throwable -> L123
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
        return ((Boolean) r9).booleanValue();
    L9:
        if ((r5 instanceof Boolean) == true) goto L11;
        Object r30 = null;
    L12:
        r6 = (Boolean) r30;     // Catch: Throwable -> L57
        if (r6 != null) goto L55;
        if ((r5 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r31 = Float.valueOf(((Number) r5).floatValue());     // Catch: Throwable -> L57
        if ((r31 instanceof Boolean) == true) goto L22;
        r31 = null;
    L22:
        r6 = (Boolean) r31;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r32 = Double.valueOf(((Number) r5).doubleValue());     // Catch: Throwable -> L57
        if ((r32 instanceof Boolean) == true) goto L28;
        r32 = null;
    L28:
        r6 = (Boolean) r32;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r33 = Integer.valueOf(((Number) r5).intValue());     // Catch: Throwable -> L57
        if ((r33 instanceof Boolean) == true) goto L34;
        r33 = null;
    L34:
        r6 = (Boolean) r33;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r34 = Long.valueOf(((Number) r5).longValue());     // Catch: Throwable -> L57
        if ((r34 instanceof Boolean) == true) goto L40;
        r34 = null;
    L40:
        r6 = (Boolean) r34;     // Catch: Throwable -> L57
    L42:
        if ((r5 instanceof JSONObject) == false) goto L44;
    L181:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r35 = SDKSettingsCacheManager.a().fromJson(r5.toString(), Boolean.class);     // Catch: Throwable -> L50
        if ((r35 instanceof Boolean) == true) goto L48;
        r35 = null;
    L48:
        Object r36 = Result.constructor-impl((Boolean) r35);     // Catch: Throwable -> L50
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

    @SettingPanel("fix：首卡接口下发inner_flow_page_style为null时，内流页不可交互")
    public static final boolean e() {
        int r0 = n.a;
        Object r1 = Boolean.TRUE;
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L166
        Object r4 = null;
        Object r5 = com.bytedance.android.ec.base.settings.d.c.get("ec_inflow_untouchable_without_page_style_fix");     // Catch: Throwable -> L57
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
        if ((r7 instanceof Boolean) == true) goto L68;
        r7 = null;
    L68:
        Object r9 = (Boolean) r7;     // Catch: Throwable -> L166
        if (r9 != null) goto L75;
        Object r10 = com.bytedance.android.ec.base.settings.d.a.get("ec_inflow_untouchable_without_page_style_fix");     // Catch: Throwable -> L166
        if ((r10 instanceof Boolean) == true) goto L74;
        r10 = null;
    L74:
        r9 = (Boolean) r10;     // Catch: Throwable -> L166
    L75:
        if (r9 != null) goto L176;
        int r11 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L166
        Object r12 = com.bytedance.android.ec.base.settings.d.c.get("ec_inflow_untouchable_without_page_style_fix");     // Catch: Throwable -> L130
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
        if ((r14 instanceof Boolean) == true) goto L141;
        r14 = null;
    L141:
        r9 = (Boolean) r14;     // Catch: Throwable -> L156
        if (r9 != null) goto L164;
        IHybridHostService r16 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r16 == null) goto L147;
        Object r17 = r16.getHostABValue("ec_inflow_untouchable_without_page_style_fix", r1);     // Catch: Throwable -> L156
    L148:
        if (r17 != null) goto L150;
    L155:
        r9 = r1;
        goto L164
    L150:
        if ((r17 instanceof Boolean) == false) goto L153;
        r4 = r17;
    L153:
        Object r18 = (Boolean) r4;     // Catch: Throwable -> L156
        if (r18 == null) goto L155;
    L163:
        r9 = r18;
        goto L164
    L147:
        r17 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d("ec_inflow_untouchable_without_page_style_fix", r9);     // Catch: Throwable -> L166
        goto L176
    L82:
        if ((r12 instanceof Boolean) == true) goto L84;
        Object r19 = null;
    L85:
        r13 = (Boolean) r19;     // Catch: Throwable -> L130
        if (r13 != null) goto L128;
        if ((r12 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r20 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L130
        if ((r20 instanceof Boolean) == true) goto L95;
        r20 = null;
    L95:
        r13 = (Boolean) r20;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r21 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L130
        if ((r21 instanceof Boolean) == true) goto L101;
        r21 = null;
    L101:
        r13 = (Boolean) r21;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r22 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L130
        if ((r22 instanceof Boolean) == true) goto L107;
        r22 = null;
    L107:
        r13 = (Boolean) r22;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r23 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L130
        if ((r23 instanceof Boolean) == true) goto L113;
        r23 = null;
    L113:
        r13 = (Boolean) r23;     // Catch: Throwable -> L130
    L115:
        if ((r12 instanceof JSONObject) == false) goto L117;
    L184:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L123
        Object r24 = SDKSettingsCacheManager.a().fromJson(r12.toString(), Boolean.class);     // Catch: Throwable -> L123
        if ((r24 instanceof Boolean) == true) goto L121;
        r24 = null;
    L121:
        Object r25 = Result.constructor-impl((Boolean) r24);     // Catch: Throwable -> L123
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
        return ((Boolean) r9).booleanValue();
    L9:
        if ((r5 instanceof Boolean) == true) goto L11;
        Object r30 = null;
    L12:
        r6 = (Boolean) r30;     // Catch: Throwable -> L57
        if (r6 != null) goto L55;
        if ((r5 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r31 = Float.valueOf(((Number) r5).floatValue());     // Catch: Throwable -> L57
        if ((r31 instanceof Boolean) == true) goto L22;
        r31 = null;
    L22:
        r6 = (Boolean) r31;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r32 = Double.valueOf(((Number) r5).doubleValue());     // Catch: Throwable -> L57
        if ((r32 instanceof Boolean) == true) goto L28;
        r32 = null;
    L28:
        r6 = (Boolean) r32;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r33 = Integer.valueOf(((Number) r5).intValue());     // Catch: Throwable -> L57
        if ((r33 instanceof Boolean) == true) goto L34;
        r33 = null;
    L34:
        r6 = (Boolean) r33;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r34 = Long.valueOf(((Number) r5).longValue());     // Catch: Throwable -> L57
        if ((r34 instanceof Boolean) == true) goto L40;
        r34 = null;
    L40:
        r6 = (Boolean) r34;     // Catch: Throwable -> L57
    L42:
        if ((r5 instanceof JSONObject) == false) goto L44;
    L181:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r35 = SDKSettingsCacheManager.a().fromJson(r5.toString(), Boolean.class);     // Catch: Throwable -> L50
        if ((r35 instanceof Boolean) == true) goto L48;
        r35 = null;
    L48:
        Object r36 = Result.constructor-impl((Boolean) r35);     // Catch: Throwable -> L50
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

    @SettingPanel("会员购立即入会问题修复")
    public static final boolean f() {
        int r0 = n.a;
        Object r1 = Boolean.TRUE;
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L166
        Object r4 = null;
        Object r5 = com.bytedance.android.ec.base.settings.d.c.get("ec_inner_flow_member_ship_enter_meeting");     // Catch: Throwable -> L57
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
        if ((r7 instanceof Boolean) == true) goto L68;
        r7 = null;
    L68:
        Object r9 = (Boolean) r7;     // Catch: Throwable -> L166
        if (r9 != null) goto L75;
        Object r10 = com.bytedance.android.ec.base.settings.d.a.get("ec_inner_flow_member_ship_enter_meeting");     // Catch: Throwable -> L166
        if ((r10 instanceof Boolean) == true) goto L74;
        r10 = null;
    L74:
        r9 = (Boolean) r10;     // Catch: Throwable -> L166
    L75:
        if (r9 != null) goto L176;
        int r11 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L166
        Object r12 = com.bytedance.android.ec.base.settings.d.c.get("ec_inner_flow_member_ship_enter_meeting");     // Catch: Throwable -> L130
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
        if ((r14 instanceof Boolean) == true) goto L141;
        r14 = null;
    L141:
        r9 = (Boolean) r14;     // Catch: Throwable -> L156
        if (r9 != null) goto L164;
        IHybridHostService r16 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r16 == null) goto L147;
        Object r17 = r16.getHostABValue("ec_inner_flow_member_ship_enter_meeting", r1);     // Catch: Throwable -> L156
    L148:
        if (r17 != null) goto L150;
    L155:
        r9 = r1;
        goto L164
    L150:
        if ((r17 instanceof Boolean) == false) goto L153;
        r4 = r17;
    L153:
        Object r18 = (Boolean) r4;     // Catch: Throwable -> L156
        if (r18 == null) goto L155;
    L163:
        r9 = r18;
        goto L164
    L147:
        r17 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d("ec_inner_flow_member_ship_enter_meeting", r9);     // Catch: Throwable -> L166
        goto L176
    L82:
        if ((r12 instanceof Boolean) == true) goto L84;
        Object r19 = null;
    L85:
        r13 = (Boolean) r19;     // Catch: Throwable -> L130
        if (r13 != null) goto L128;
        if ((r12 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r20 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L130
        if ((r20 instanceof Boolean) == true) goto L95;
        r20 = null;
    L95:
        r13 = (Boolean) r20;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r21 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L130
        if ((r21 instanceof Boolean) == true) goto L101;
        r21 = null;
    L101:
        r13 = (Boolean) r21;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r22 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L130
        if ((r22 instanceof Boolean) == true) goto L107;
        r22 = null;
    L107:
        r13 = (Boolean) r22;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r23 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L130
        if ((r23 instanceof Boolean) == true) goto L113;
        r23 = null;
    L113:
        r13 = (Boolean) r23;     // Catch: Throwable -> L130
    L115:
        if ((r12 instanceof JSONObject) == false) goto L117;
    L184:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L123
        Object r24 = SDKSettingsCacheManager.a().fromJson(r12.toString(), Boolean.class);     // Catch: Throwable -> L123
        if ((r24 instanceof Boolean) == true) goto L121;
        r24 = null;
    L121:
        Object r25 = Result.constructor-impl((Boolean) r24);     // Catch: Throwable -> L123
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
        return ((Boolean) r9).booleanValue();
    L9:
        if ((r5 instanceof Boolean) == true) goto L11;
        Object r30 = null;
    L12:
        r6 = (Boolean) r30;     // Catch: Throwable -> L57
        if (r6 != null) goto L55;
        if ((r5 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r31 = Float.valueOf(((Number) r5).floatValue());     // Catch: Throwable -> L57
        if ((r31 instanceof Boolean) == true) goto L22;
        r31 = null;
    L22:
        r6 = (Boolean) r31;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r32 = Double.valueOf(((Number) r5).doubleValue());     // Catch: Throwable -> L57
        if ((r32 instanceof Boolean) == true) goto L28;
        r32 = null;
    L28:
        r6 = (Boolean) r32;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r33 = Integer.valueOf(((Number) r5).intValue());     // Catch: Throwable -> L57
        if ((r33 instanceof Boolean) == true) goto L34;
        r33 = null;
    L34:
        r6 = (Boolean) r33;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r34 = Long.valueOf(((Number) r5).longValue());     // Catch: Throwable -> L57
        if ((r34 instanceof Boolean) == true) goto L40;
        r34 = null;
    L40:
        r6 = (Boolean) r34;     // Catch: Throwable -> L57
    L42:
        if ((r5 instanceof JSONObject) == false) goto L44;
    L181:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r35 = SDKSettingsCacheManager.a().fromJson(r5.toString(), Boolean.class);     // Catch: Throwable -> L50
        if ((r35 instanceof Boolean) == true) goto L48;
        r35 = null;
    L48:
        Object r36 = Result.constructor-impl((Boolean) r35);     // Catch: Throwable -> L50
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

    @SettingPanel("内流页价格区域UI升级，客户端兜底开关")
    public static final boolean g() {
        int r0 = n.a;
        Object r1 = Boolean.TRUE;
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L166
        Object r4 = null;
        Object r5 = com.bytedance.android.ec.base.settings.d.c.get("ec_inflow_price_update_new");     // Catch: Throwable -> L57
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
        if ((r7 instanceof Boolean) == true) goto L68;
        r7 = null;
    L68:
        Object r9 = (Boolean) r7;     // Catch: Throwable -> L166
        if (r9 != null) goto L75;
        Object r10 = com.bytedance.android.ec.base.settings.d.a.get("ec_inflow_price_update_new");     // Catch: Throwable -> L166
        if ((r10 instanceof Boolean) == true) goto L74;
        r10 = null;
    L74:
        r9 = (Boolean) r10;     // Catch: Throwable -> L166
    L75:
        if (r9 != null) goto L176;
        int r11 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L166
        Object r12 = com.bytedance.android.ec.base.settings.d.c.get("ec_inflow_price_update_new");     // Catch: Throwable -> L130
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
        if ((r14 instanceof Boolean) == true) goto L141;
        r14 = null;
    L141:
        r9 = (Boolean) r14;     // Catch: Throwable -> L156
        if (r9 != null) goto L164;
        IHybridHostService r16 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r16 == null) goto L147;
        Object r17 = r16.getHostABValue("ec_inflow_price_update_new", r1);     // Catch: Throwable -> L156
    L148:
        if (r17 != null) goto L150;
    L155:
        r9 = r1;
        goto L164
    L150:
        if ((r17 instanceof Boolean) == false) goto L153;
        r4 = r17;
    L153:
        Object r18 = (Boolean) r4;     // Catch: Throwable -> L156
        if (r18 == null) goto L155;
    L163:
        r9 = r18;
        goto L164
    L147:
        r17 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d("ec_inflow_price_update_new", r9);     // Catch: Throwable -> L166
        goto L176
    L82:
        if ((r12 instanceof Boolean) == true) goto L84;
        Object r19 = null;
    L85:
        r13 = (Boolean) r19;     // Catch: Throwable -> L130
        if (r13 != null) goto L128;
        if ((r12 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r20 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L130
        if ((r20 instanceof Boolean) == true) goto L95;
        r20 = null;
    L95:
        r13 = (Boolean) r20;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r21 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L130
        if ((r21 instanceof Boolean) == true) goto L101;
        r21 = null;
    L101:
        r13 = (Boolean) r21;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r22 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L130
        if ((r22 instanceof Boolean) == true) goto L107;
        r22 = null;
    L107:
        r13 = (Boolean) r22;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r23 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L130
        if ((r23 instanceof Boolean) == true) goto L113;
        r23 = null;
    L113:
        r13 = (Boolean) r23;     // Catch: Throwable -> L130
    L115:
        if ((r12 instanceof JSONObject) == false) goto L117;
    L184:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L123
        Object r24 = SDKSettingsCacheManager.a().fromJson(r12.toString(), Boolean.class);     // Catch: Throwable -> L123
        if ((r24 instanceof Boolean) == true) goto L121;
        r24 = null;
    L121:
        Object r25 = Result.constructor-impl((Boolean) r24);     // Catch: Throwable -> L123
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
        return ((Boolean) r9).booleanValue();
    L9:
        if ((r5 instanceof Boolean) == true) goto L11;
        Object r30 = null;
    L12:
        r6 = (Boolean) r30;     // Catch: Throwable -> L57
        if (r6 != null) goto L55;
        if ((r5 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r31 = Float.valueOf(((Number) r5).floatValue());     // Catch: Throwable -> L57
        if ((r31 instanceof Boolean) == true) goto L22;
        r31 = null;
    L22:
        r6 = (Boolean) r31;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r32 = Double.valueOf(((Number) r5).doubleValue());     // Catch: Throwable -> L57
        if ((r32 instanceof Boolean) == true) goto L28;
        r32 = null;
    L28:
        r6 = (Boolean) r32;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r33 = Integer.valueOf(((Number) r5).intValue());     // Catch: Throwable -> L57
        if ((r33 instanceof Boolean) == true) goto L34;
        r33 = null;
    L34:
        r6 = (Boolean) r33;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r34 = Long.valueOf(((Number) r5).longValue());     // Catch: Throwable -> L57
        if ((r34 instanceof Boolean) == true) goto L40;
        r34 = null;
    L40:
        r6 = (Boolean) r34;     // Catch: Throwable -> L57
    L42:
        if ((r5 instanceof JSONObject) == false) goto L44;
    L181:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r35 = SDKSettingsCacheManager.a().fromJson(r5.toString(), Boolean.class);     // Catch: Throwable -> L50
        if ((r35 instanceof Boolean) == true) goto L48;
        r35 = null;
    L48:
        Object r36 = Result.constructor-impl((Boolean) r35);     // Catch: Throwable -> L50
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

    @SettingPanel("新大字内流页")
    public static final boolean h() {
        int r0 = n.a;
        Object r1 = Boolean.FALSE;
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L166
        Object r4 = null;
        Object r5 = com.bytedance.android.ec.base.settings.d.c.get("iesec_goods_feed_big_font");     // Catch: Throwable -> L57
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
        if ((r7 instanceof Boolean) == true) goto L68;
        r7 = null;
    L68:
        Object r9 = (Boolean) r7;     // Catch: Throwable -> L166
        if (r9 != null) goto L75;
        Object r10 = com.bytedance.android.ec.base.settings.d.a.get("iesec_goods_feed_big_font");     // Catch: Throwable -> L166
        if ((r10 instanceof Boolean) == true) goto L74;
        r10 = null;
    L74:
        r9 = (Boolean) r10;     // Catch: Throwable -> L166
    L75:
        if (r9 != null) goto L176;
        int r11 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L166
        Object r12 = com.bytedance.android.ec.base.settings.d.c.get("iesec_goods_feed_big_font");     // Catch: Throwable -> L130
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
        if ((r14 instanceof Boolean) == true) goto L141;
        r14 = null;
    L141:
        r9 = (Boolean) r14;     // Catch: Throwable -> L156
        if (r9 != null) goto L164;
        IHybridHostService r16 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r16 == null) goto L147;
        Object r17 = r16.getHostABValue("iesec_goods_feed_big_font", r1);     // Catch: Throwable -> L156
    L148:
        if (r17 != null) goto L150;
    L155:
        r9 = r1;
        goto L164
    L150:
        if ((r17 instanceof Boolean) == false) goto L153;
        r4 = r17;
    L153:
        Object r18 = (Boolean) r4;     // Catch: Throwable -> L156
        if (r18 == null) goto L155;
    L163:
        r9 = r18;
        goto L164
    L147:
        r17 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d("iesec_goods_feed_big_font", r9);     // Catch: Throwable -> L166
        goto L176
    L82:
        if ((r12 instanceof Boolean) == true) goto L84;
        Object r19 = null;
    L85:
        r13 = (Boolean) r19;     // Catch: Throwable -> L130
        if (r13 != null) goto L128;
        if ((r12 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r20 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L130
        if ((r20 instanceof Boolean) == true) goto L95;
        r20 = null;
    L95:
        r13 = (Boolean) r20;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r21 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L130
        if ((r21 instanceof Boolean) == true) goto L101;
        r21 = null;
    L101:
        r13 = (Boolean) r21;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r22 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L130
        if ((r22 instanceof Boolean) == true) goto L107;
        r22 = null;
    L107:
        r13 = (Boolean) r22;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r23 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L130
        if ((r23 instanceof Boolean) == true) goto L113;
        r23 = null;
    L113:
        r13 = (Boolean) r23;     // Catch: Throwable -> L130
    L115:
        if ((r12 instanceof JSONObject) == false) goto L117;
    L184:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L123
        Object r24 = SDKSettingsCacheManager.a().fromJson(r12.toString(), Boolean.class);     // Catch: Throwable -> L123
        if ((r24 instanceof Boolean) == true) goto L121;
        r24 = null;
    L121:
        Object r25 = Result.constructor-impl((Boolean) r24);     // Catch: Throwable -> L123
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
        return ((Boolean) r9).booleanValue();
    L9:
        if ((r5 instanceof Boolean) == true) goto L11;
        Object r30 = null;
    L12:
        r6 = (Boolean) r30;     // Catch: Throwable -> L57
        if (r6 != null) goto L55;
        if ((r5 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r31 = Float.valueOf(((Number) r5).floatValue());     // Catch: Throwable -> L57
        if ((r31 instanceof Boolean) == true) goto L22;
        r31 = null;
    L22:
        r6 = (Boolean) r31;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r32 = Double.valueOf(((Number) r5).doubleValue());     // Catch: Throwable -> L57
        if ((r32 instanceof Boolean) == true) goto L28;
        r32 = null;
    L28:
        r6 = (Boolean) r32;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r33 = Integer.valueOf(((Number) r5).intValue());     // Catch: Throwable -> L57
        if ((r33 instanceof Boolean) == true) goto L34;
        r33 = null;
    L34:
        r6 = (Boolean) r33;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r34 = Long.valueOf(((Number) r5).longValue());     // Catch: Throwable -> L57
        if ((r34 instanceof Boolean) == true) goto L40;
        r34 = null;
    L40:
        r6 = (Boolean) r34;     // Catch: Throwable -> L57
    L42:
        if ((r5 instanceof JSONObject) == false) goto L44;
    L181:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r35 = SDKSettingsCacheManager.a().fromJson(r5.toString(), Boolean.class);     // Catch: Throwable -> L50
        if ((r35 instanceof Boolean) == true) goto L48;
        r35 = null;
    L48:
        Object r36 = Result.constructor-impl((Boolean) r35);     // Catch: Throwable -> L50
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

    @SettingPanel("短视频内流跳券页面兜底开关")
    public static final boolean i() {
        int r0 = n.a;
        Object r1 = Boolean.TRUE;
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L166
        Object r4 = null;
        Object r5 = com.bytedance.android.ec.base.settings.d.c.get("iesec_inflow_benefit_jump_coupon_page");     // Catch: Throwable -> L57
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
        if ((r7 instanceof Boolean) == true) goto L68;
        r7 = null;
    L68:
        Object r9 = (Boolean) r7;     // Catch: Throwable -> L166
        if (r9 != null) goto L75;
        Object r10 = com.bytedance.android.ec.base.settings.d.a.get("iesec_inflow_benefit_jump_coupon_page");     // Catch: Throwable -> L166
        if ((r10 instanceof Boolean) == true) goto L74;
        r10 = null;
    L74:
        r9 = (Boolean) r10;     // Catch: Throwable -> L166
    L75:
        if (r9 != null) goto L176;
        int r11 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L166
        Object r12 = com.bytedance.android.ec.base.settings.d.c.get("iesec_inflow_benefit_jump_coupon_page");     // Catch: Throwable -> L130
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
        if ((r14 instanceof Boolean) == true) goto L141;
        r14 = null;
    L141:
        r9 = (Boolean) r14;     // Catch: Throwable -> L156
        if (r9 != null) goto L164;
        IHybridHostService r16 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r16 == null) goto L147;
        Object r17 = r16.getHostABValue("iesec_inflow_benefit_jump_coupon_page", r1);     // Catch: Throwable -> L156
    L148:
        if (r17 != null) goto L150;
    L155:
        r9 = r1;
        goto L164
    L150:
        if ((r17 instanceof Boolean) == false) goto L153;
        r4 = r17;
    L153:
        Object r18 = (Boolean) r4;     // Catch: Throwable -> L156
        if (r18 == null) goto L155;
    L163:
        r9 = r18;
        goto L164
    L147:
        r17 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d("iesec_inflow_benefit_jump_coupon_page", r9);     // Catch: Throwable -> L166
        goto L176
    L82:
        if ((r12 instanceof Boolean) == true) goto L84;
        Object r19 = null;
    L85:
        r13 = (Boolean) r19;     // Catch: Throwable -> L130
        if (r13 != null) goto L128;
        if ((r12 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r20 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L130
        if ((r20 instanceof Boolean) == true) goto L95;
        r20 = null;
    L95:
        r13 = (Boolean) r20;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r21 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L130
        if ((r21 instanceof Boolean) == true) goto L101;
        r21 = null;
    L101:
        r13 = (Boolean) r21;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r22 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L130
        if ((r22 instanceof Boolean) == true) goto L107;
        r22 = null;
    L107:
        r13 = (Boolean) r22;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r23 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L130
        if ((r23 instanceof Boolean) == true) goto L113;
        r23 = null;
    L113:
        r13 = (Boolean) r23;     // Catch: Throwable -> L130
    L115:
        if ((r12 instanceof JSONObject) == false) goto L117;
    L184:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L123
        Object r24 = SDKSettingsCacheManager.a().fromJson(r12.toString(), Boolean.class);     // Catch: Throwable -> L123
        if ((r24 instanceof Boolean) == true) goto L121;
        r24 = null;
    L121:
        Object r25 = Result.constructor-impl((Boolean) r24);     // Catch: Throwable -> L123
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
        return ((Boolean) r9).booleanValue();
    L9:
        if ((r5 instanceof Boolean) == true) goto L11;
        Object r30 = null;
    L12:
        r6 = (Boolean) r30;     // Catch: Throwable -> L57
        if (r6 != null) goto L55;
        if ((r5 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r31 = Float.valueOf(((Number) r5).floatValue());     // Catch: Throwable -> L57
        if ((r31 instanceof Boolean) == true) goto L22;
        r31 = null;
    L22:
        r6 = (Boolean) r31;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r32 = Double.valueOf(((Number) r5).doubleValue());     // Catch: Throwable -> L57
        if ((r32 instanceof Boolean) == true) goto L28;
        r32 = null;
    L28:
        r6 = (Boolean) r32;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r33 = Integer.valueOf(((Number) r5).intValue());     // Catch: Throwable -> L57
        if ((r33 instanceof Boolean) == true) goto L34;
        r33 = null;
    L34:
        r6 = (Boolean) r33;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r34 = Long.valueOf(((Number) r5).longValue());     // Catch: Throwable -> L57
        if ((r34 instanceof Boolean) == true) goto L40;
        r34 = null;
    L40:
        r6 = (Boolean) r34;     // Catch: Throwable -> L57
    L42:
        if ((r5 instanceof JSONObject) == false) goto L44;
    L181:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r35 = SDKSettingsCacheManager.a().fromJson(r5.toString(), Boolean.class);     // Catch: Throwable -> L50
        if ((r35 instanceof Boolean) == true) goto L48;
        r35 = null;
    L48:
        Object r36 = Result.constructor-impl((Boolean) r35);     // Catch: Throwable -> L50
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

    @HostExperimentKey
    public static final int j() {
        int r0 = m.a;
        Object r1 = 0;
        boolean r2 = ECServiceManager.a;
        g r3 = (g) ECServiceManager.c(g.class);
        if (r3 == null) goto L8;
        s83.a r4 = r3.q();
        if (r4 == null) goto L8;
        Object r5 = r4.e("inflow_feed_framework_opt");
        if (r5 == null) goto L8;
    L175:
        return ((Number) r5).intValue();
    L8:
        int r6 = n.a;
        int r7 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L165
        Object r9 = null;
        Object r10 = com.bytedance.android.ec.base.settings.d.c.get("inflow_feed_framework_opt");     // Catch: Throwable -> L60
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
        Object r15 = com.bytedance.android.ec.base.settings.d.a.get("inflow_feed_framework_opt");     // Catch: Throwable -> L165
        if ((r15 instanceof Integer) == true) goto L77;
        r15 = null;
    L77:
        r14 = (Integer) r15;     // Catch: Throwable -> L165
    L78:
        if (r14 == null) goto L80;
        r5 = r14;
        goto L175
    L80:
        int r16 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L165
        Object r17 = com.bytedance.android.ec.base.settings.d.c.get("inflow_feed_framework_opt");     // Catch: Throwable -> L130
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
        com.bytedance.android.ec.base.settings.d.d("inflow_feed_framework_opt", r5);     // Catch: Throwable -> L165
        goto L175
    L144:
        IHybridHostService r22 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r22 == null) goto L147;
        Object r23 = r22.getHostABValue("inflow_feed_framework_opt", r1);     // Catch: Throwable -> L156
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

    @HostExperimentKey
    public static final int k() {
        int r0 = m.a;
        Object r1 = 0;
        boolean r2 = ECServiceManager.a;
        g r3 = (g) ECServiceManager.c(g.class);
        if (r3 == null) goto L8;
        s83.a r4 = r3.q();
        if (r4 == null) goto L8;
        Object r5 = r4.e("ec_internal_feed_lightning");
        if (r5 == null) goto L8;
    L175:
        return ((Number) r5).intValue();
    L8:
        int r6 = n.a;
        int r7 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L165
        Object r9 = null;
        Object r10 = com.bytedance.android.ec.base.settings.d.c.get("ec_internal_feed_lightning");     // Catch: Throwable -> L60
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
        Object r15 = com.bytedance.android.ec.base.settings.d.a.get("ec_internal_feed_lightning");     // Catch: Throwable -> L165
        if ((r15 instanceof Integer) == true) goto L77;
        r15 = null;
    L77:
        r14 = (Integer) r15;     // Catch: Throwable -> L165
    L78:
        if (r14 == null) goto L80;
        r5 = r14;
        goto L175
    L80:
        int r16 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L165
        Object r17 = com.bytedance.android.ec.base.settings.d.c.get("ec_internal_feed_lightning");     // Catch: Throwable -> L130
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
        com.bytedance.android.ec.base.settings.d.d("ec_internal_feed_lightning", r5);     // Catch: Throwable -> L165
        goto L175
    L144:
        IHybridHostService r22 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r22 == null) goto L147;
        Object r23 = r22.getHostABValue("ec_internal_feed_lightning", r1);     // Catch: Throwable -> L156
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

    static {
    }
}
