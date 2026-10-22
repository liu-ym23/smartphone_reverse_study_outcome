package com.bytedance.android.shopping.base.event;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.g;
import com.bytedance.android.ec.base.settings.h;
import com.bytedance.android.ec.core.abtest.j;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.slice.action.entity.CheckLoginParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.dataplatform.config.SettingPanel;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final ConcurrentHashMap<String, String> a = null;

    public a() {
    }

    static {
        a = new ConcurrentHashMap();
    }

    @SettingPanel("全链路trace监控开关")
    public static PdpFullNodeTraceSetting a() {
        int r0 = j.a;
        Object r3 = null;
        Object r1 = new PdpFullNodeTraceSetting(false, false, 3, null);
        int r2 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L171
        h.a();     // Catch: Throwable -> L171
        SDKSettingsCacheManager r5 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L171
        r5.getClass();     // Catch: Throwable -> L58
        Object r6 = SDKSettingsCacheManager.b.get("full_node_trace_setting");     // Catch: Throwable -> L58
        if (r6 != null) goto L10;
    L55:
        Object r7 = null;
    L56:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L58
    L60:
        Throwable r9 = Result.exceptionOrNull-impl(r8);     // Catch: Throwable -> L171
        if (r9 == null) goto L64;
        EnsureManager.ensureNotReachHere(r9);     // Catch: Throwable -> L171
    L64:
        if (Result.isFailure-impl(r8) == false) goto L67;
        r8 = null;
    L67:
        if ((r8 instanceof PdpFullNodeTraceSetting) == true) goto L69;
        r8 = null;
    L69:
        Object r10 = (PdpFullNodeTraceSetting) r8;     // Catch: Throwable -> L171
        if (r10 != null) goto L76;
        r5.getClass();     // Catch: Throwable -> L171
        Object r11 = SDKSettingsCacheManager.a.get("full_node_trace_setting");     // Catch: Throwable -> L171
        if ((r11 instanceof PdpFullNodeTraceSetting) == true) goto L75;
        r11 = null;
    L75:
        r10 = (PdpFullNodeTraceSetting) r11;     // Catch: Throwable -> L171
    L76:
        if (r10 != null) goto L181;
        int r12 = g.a;     // Catch: Throwable -> L171
    L158:
        th = move-exception;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L171
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L171
    L161:
        if (Result.exceptionOrNull-impl(r14) != null) goto L188;
    L168:
        r10 = r14;
    L169:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L171
        SDKSettingsCacheManager.e("full_node_trace_setting", r10);     // Catch: Throwable -> L171
        goto L181
    L188:
        r14 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("full_node_trace_setting", PdpFullNodeTraceSetting.class, r1);     // Catch: Throwable -> L165
    L166:
        if (r14 != null) goto L168;
        r10 = r1;
    L165:
        r14 = r1;
        goto L166
    L194:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L132
        Object r15 = SDKSettingsCacheManager.b.get("full_node_trace_setting");     // Catch: Throwable -> L132
        if (r15 != null) goto L84;
    L129:
        Object r16 = null;
    L130:
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L132
    L134:
        Throwable r18 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L158
        if (r18 == null) goto L138;
        EnsureManager.ensureNotReachHere(r18);     // Catch: Throwable -> L158
    L138:
        if (Result.isFailure-impl(r17) == false) goto L141;
        r17 = null;
    L141:
        if ((r17 instanceof PdpFullNodeTraceSetting) == true) goto L143;
        r17 = null;
    L143:
        PdpFullNodeTraceSetting r19 = (PdpFullNodeTraceSetting) r17;     // Catch: Throwable -> L158
        if (r19 == null) goto L146;
        r10 = r19;
        goto L169
    L146:
        jj4.b r20 = jj4.b.b;     // Catch: Throwable -> L158
        Object r21 = jj4.a.a("full_node_trace_setting", PdpFullNodeTraceSetting.class, r1, false);     // Catch: Throwable -> L158
        if (r21 != null) goto L150;
        Intrinsics.throwNpe();     // Catch: Throwable -> L158
    L150:
        if ((r21 instanceof PdpFullNodeTraceSetting) == false) goto L153;
        r3 = r21;
    L153:
        Object r22 = (PdpFullNodeTraceSetting) r3;     // Catch: Throwable -> L158
        if (r22 != null) goto L156;
        r22 = r1;
    L156:
        r14 = Result.constructor-impl(r22);     // Catch: Throwable -> L158
    L84:
        if ((r15 instanceof PdpFullNodeTraceSetting) == true) goto L86;
        Object r23 = null;
    L87:
        r16 = (PdpFullNodeTraceSetting) r23;     // Catch: Throwable -> L132
        if (r16 != null) goto L130;
        if ((r15 instanceof Number) == false) goto L117;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(PdpFullNodeTraceSetting.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L99;
        Float r24 = Float.valueOf(((Number) r15).floatValue());     // Catch: Throwable -> L132
        if ((r24 instanceof PdpFullNodeTraceSetting) == true) goto L97;
        r24 = null;
    L97:
        r16 = (PdpFullNodeTraceSetting) r24;     // Catch: Throwable -> L132
        goto L130
    L99:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(PdpFullNodeTraceSetting.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L105;
        Double r25 = Double.valueOf(((Number) r15).doubleValue());     // Catch: Throwable -> L132
        if ((r25 instanceof PdpFullNodeTraceSetting) == true) goto L103;
        r25 = null;
    L103:
        r16 = (PdpFullNodeTraceSetting) r25;     // Catch: Throwable -> L132
        goto L130
    L105:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(PdpFullNodeTraceSetting.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L111;
        Integer r26 = Integer.valueOf(((Number) r15).intValue());     // Catch: Throwable -> L132
        if ((r26 instanceof PdpFullNodeTraceSetting) == true) goto L109;
        r26 = null;
    L109:
        r16 = (PdpFullNodeTraceSetting) r26;     // Catch: Throwable -> L132
        goto L130
    L111:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(PdpFullNodeTraceSetting.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L117;
        Long r27 = Long.valueOf(((Number) r15).longValue());     // Catch: Throwable -> L132
        if ((r27 instanceof PdpFullNodeTraceSetting) == true) goto L115;
        r27 = null;
    L115:
        r16 = (PdpFullNodeTraceSetting) r27;     // Catch: Throwable -> L132
    L117:
        if ((r15 instanceof JSONObject) == false) goto L119;
    L186:
        Object r28 = SDKSettingsCacheManager.a().fromJson(r15.toString(), PdpFullNodeTraceSetting.class);     // Catch: Throwable -> L125
        if ((r28 instanceof PdpFullNodeTraceSetting) == true) goto L123;
        r28 = null;
    L123:
        Object r29 = Result.constructor-impl((PdpFullNodeTraceSetting) r28);     // Catch: Throwable -> L125
    L127:
        r16 = r29;
        if (Result.isFailure-impl(r16) == false) goto L130;
    L125:
        th = move-exception;
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L132
        r29 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L132
        goto L127
    L119:
        if ((r15 instanceof JSONArray) == false) goto L129;
    L86:
        r23 = r15;
    L132:
        th = move-exception;
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L158
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L158
    L181:
        return (PdpFullNodeTraceSetting) r10;
    L10:
        if ((r6 instanceof PdpFullNodeTraceSetting) == true) goto L12;
        Object r32 = null;
    L13:
        r7 = (PdpFullNodeTraceSetting) r32;     // Catch: Throwable -> L58
        if (r7 != null) goto L56;
        if ((r6 instanceof Number) == false) goto L43;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(PdpFullNodeTraceSetting.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L25;
        Float r33 = Float.valueOf(((Number) r6).floatValue());     // Catch: Throwable -> L58
        if ((r33 instanceof PdpFullNodeTraceSetting) == true) goto L23;
        r33 = null;
    L23:
        r7 = (PdpFullNodeTraceSetting) r33;     // Catch: Throwable -> L58
        goto L56
    L25:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(PdpFullNodeTraceSetting.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L31;
        Double r34 = Double.valueOf(((Number) r6).doubleValue());     // Catch: Throwable -> L58
        if ((r34 instanceof PdpFullNodeTraceSetting) == true) goto L29;
        r34 = null;
    L29:
        r7 = (PdpFullNodeTraceSetting) r34;     // Catch: Throwable -> L58
        goto L56
    L31:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(PdpFullNodeTraceSetting.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L37;
        Integer r35 = Integer.valueOf(((Number) r6).intValue());     // Catch: Throwable -> L58
        if ((r35 instanceof PdpFullNodeTraceSetting) == true) goto L35;
        r35 = null;
    L35:
        r7 = (PdpFullNodeTraceSetting) r35;     // Catch: Throwable -> L58
        goto L56
    L37:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(PdpFullNodeTraceSetting.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L43;
        Long r36 = Long.valueOf(((Number) r6).longValue());     // Catch: Throwable -> L58
        if ((r36 instanceof PdpFullNodeTraceSetting) == true) goto L41;
        r36 = null;
    L41:
        r7 = (PdpFullNodeTraceSetting) r36;     // Catch: Throwable -> L58
    L43:
        if ((r6 instanceof JSONObject) == false) goto L45;
    L192:
        Object r37 = SDKSettingsCacheManager.a().fromJson(r6.toString(), PdpFullNodeTraceSetting.class);     // Catch: Throwable -> L51
        if ((r37 instanceof PdpFullNodeTraceSetting) == true) goto L49;
        r37 = null;
    L49:
        Object r38 = Result.constructor-impl((PdpFullNodeTraceSetting) r37);     // Catch: Throwable -> L51
    L53:
        r7 = r38;
        if (Result.isFailure-impl(r7) == false) goto L56;
    L51:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L58
        r38 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L58
        goto L53
    L45:
        if ((r6 instanceof JSONArray) == false) goto L55;
    L12:
        r32 = r6;
    L58:
        th = move-exception;
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L171
        r8 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L171
    L171:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        Object r42 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r43 = Result.exceptionOrNull-impl(r42);
        if (r43 == null) goto L176;
        EnsureManager.ensureNotReachHere(r43);
    L176:
        if (Result.isFailure-impl(r42) == true) goto L179;
        r1 = r42;
    L179:
        r10 = r1;
        goto L181
    }

    public static void b(boolean r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter("ec_full_node_trace", "serviceName");
        if (a().getMonitorEnable() == true) goto L5;
        return;
    L5:
        int r0 = ECSdk.a;
        pi.b r1 = (pi.b) ECSdk.a(pi.b.class);
        if (r1 == null) goto L8;
        r6.put("data_type", "commerce_data");
        Unit r3 = Unit.INSTANCE;
        r1.monitorEvent("ec_full_node_trace", r6, null, null);
    L8:
        if (r5 == true) goto L10;
        return;
    L10:
        if (a().getALogEnable() == false) goto L14;
        JSONObject r7 = new JSONObject();
        z1.b(r7, r6);
        String r8 = r7.toString();
        dm.a.a("ec_full_node_trace").b(r8, null);
        return;
    }

    public static void c(String r5, String r6, String r7, String r8, boolean r9, JSONObject r10) {
        Intrinsics.checkNotNullParameter(r5, "pageName");
        Intrinsics.checkNotNullParameter(r6, "stage");
        Intrinsics.checkNotNullParameter(r7, "stage_status");
        if ((!Intrinsics.areEqual(r7, CheckLoginParam.KEY_FAILED)) == false) goto L8;
        String r2 = r5 + r6 + r7;
        ConcurrentHashMap<String, String> r3 = a;
        if (r3.containsKey(r2) == false) goto L7;
        return;
    L7:
        r3.put(r2, r2);
    L8:
        if (r10 == null) goto L18;
    L10:
        r10.put(PdpOpenThirdParam.KEY_PAGE_NAME, r5);     // Catch: Exception -> L15
        r10.put("stage", r6);     // Catch: Exception -> L15
        r10.put("stage_status", r7);     // Catch: Exception -> L15
        if (r8 == null) goto L13;
        r10.put("error_message", r8);     // Catch: Exception -> L15
    L13:
        b(r9, r10);     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L18:
        r10 = new JSONObject();     // Catch: Exception -> L15
        goto L10
    }

    public static /* synthetic */ void d(String r8, String r9, String r10, String r11, boolean r12, JSONObject r13, int r14) {
        if ((r14 & 8) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r14 & 16) == 0) goto L9;
        boolean r6 = false;
    L11:
        if ((r14 & 32) == 0) goto L13;
        JSONObject r7 = null;
    L14:
        c(r8, r9, r10, r5, r6, r7);
        return;
    L13:
        r7 = r13;
        goto L14
    L9:
        r6 = r12;
        goto L11
    L5:
        r5 = r11;
        goto L7
    }
}
