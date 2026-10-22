package hk3;

import com.bytedance.android.ec.ab.opt.OptSetting;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.g;
import com.bytedance.android.ec.base.settings.h;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.shopping.store.tabkit.model.u;
import com.bytedance.dataplatform.config.SettingPanel;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@OptSetting(business = "TabKit专用")
public final class a {
    public static final /* synthetic */ int a = 0;

    public static final JsonObject b() {
        int r0 = n.a;
        Object r1 = new JsonObject();
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L166
        Object r4 = null;
        Object r5 = com.bytedance.android.ec.base.settings.d.c.get("ec_tabkit_deeplink_inject_data");     // Catch: Throwable -> L57
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
        if ((r7 instanceof JsonObject) == true) goto L68;
        r7 = null;
    L68:
        Object r9 = (JsonObject) r7;     // Catch: Throwable -> L166
        if (r9 != null) goto L75;
        Object r10 = com.bytedance.android.ec.base.settings.d.a.get("ec_tabkit_deeplink_inject_data");     // Catch: Throwable -> L166
        if ((r10 instanceof JsonObject) == true) goto L74;
        r10 = null;
    L74:
        r9 = (JsonObject) r10;     // Catch: Throwable -> L166
    L75:
        if (r9 != null) goto L176;
        int r11 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L166
        Object r12 = com.bytedance.android.ec.base.settings.d.c.get("ec_tabkit_deeplink_inject_data");     // Catch: Throwable -> L130
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
        if ((r14 instanceof JsonObject) == true) goto L141;
        r14 = null;
    L141:
        r9 = (JsonObject) r14;     // Catch: Throwable -> L156
        if (r9 != null) goto L164;
        IHybridHostService r16 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r16 == null) goto L147;
        Object r17 = r16.getHostABValue("ec_tabkit_deeplink_inject_data", r1);     // Catch: Throwable -> L156
    L148:
        if (r17 != null) goto L150;
    L155:
        r9 = r1;
        goto L164
    L150:
        if ((r17 instanceof JsonObject) == false) goto L153;
        r4 = r17;
    L153:
        Object r18 = (JsonObject) r4;     // Catch: Throwable -> L156
        if (r18 == null) goto L155;
    L163:
        r9 = r18;
        goto L164
    L147:
        r17 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d("ec_tabkit_deeplink_inject_data", r9);     // Catch: Throwable -> L166
        goto L176
    L82:
        if ((r12 instanceof JsonObject) == true) goto L84;
        Object r19 = null;
    L85:
        r13 = (JsonObject) r19;     // Catch: Throwable -> L130
        if (r13 != null) goto L128;
        if ((r12 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(JsonObject.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r20 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L130
        if ((r20 instanceof JsonObject) == true) goto L95;
        r20 = null;
    L95:
        r13 = (JsonObject) r20;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(JsonObject.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r21 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L130
        if ((r21 instanceof JsonObject) == true) goto L101;
        r21 = null;
    L101:
        r13 = (JsonObject) r21;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(JsonObject.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r22 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L130
        if ((r22 instanceof JsonObject) == true) goto L107;
        r22 = null;
    L107:
        r13 = (JsonObject) r22;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(JsonObject.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r23 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L130
        if ((r23 instanceof JsonObject) == true) goto L113;
        r23 = null;
    L113:
        r13 = (JsonObject) r23;     // Catch: Throwable -> L130
    L115:
        if ((r12 instanceof JSONObject) == false) goto L117;
    L184:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L123
        Object r24 = SDKSettingsCacheManager.a().fromJson(r12.toString(), JsonObject.class);     // Catch: Throwable -> L123
        if ((r24 instanceof JsonObject) == true) goto L121;
        r24 = null;
    L121:
        Object r25 = Result.constructor-impl((JsonObject) r24);     // Catch: Throwable -> L123
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
        return (JsonObject) r9;
    L9:
        if ((r5 instanceof JsonObject) == true) goto L11;
        Object r30 = null;
    L12:
        r6 = (JsonObject) r30;     // Catch: Throwable -> L57
        if (r6 != null) goto L55;
        if ((r5 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(JsonObject.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r31 = Float.valueOf(((Number) r5).floatValue());     // Catch: Throwable -> L57
        if ((r31 instanceof JsonObject) == true) goto L22;
        r31 = null;
    L22:
        r6 = (JsonObject) r31;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(JsonObject.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r32 = Double.valueOf(((Number) r5).doubleValue());     // Catch: Throwable -> L57
        if ((r32 instanceof JsonObject) == true) goto L28;
        r32 = null;
    L28:
        r6 = (JsonObject) r32;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(JsonObject.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r33 = Integer.valueOf(((Number) r5).intValue());     // Catch: Throwable -> L57
        if ((r33 instanceof JsonObject) == true) goto L34;
        r33 = null;
    L34:
        r6 = (JsonObject) r33;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(JsonObject.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r34 = Long.valueOf(((Number) r5).longValue());     // Catch: Throwable -> L57
        if ((r34 instanceof JsonObject) == true) goto L40;
        r34 = null;
    L40:
        r6 = (JsonObject) r34;     // Catch: Throwable -> L57
    L42:
        if ((r5 instanceof JSONObject) == false) goto L44;
    L181:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r35 = SDKSettingsCacheManager.a().fromJson(r5.toString(), JsonObject.class);     // Catch: Throwable -> L50
        if ((r35 instanceof JsonObject) == true) goto L48;
        r35 = null;
    L48:
        Object r36 = Result.constructor-impl((JsonObject) r35);     // Catch: Throwable -> L50
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

    public static final JsonObject c() {
        int r0 = n.a;
        Object r1 = new JsonObject();
        int r2 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L166
        Object r4 = null;
        Object r5 = com.bytedance.android.ec.base.settings.d.c.get("tabkit_deeplink_prefetch_config");     // Catch: Throwable -> L57
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
        if ((r7 instanceof JsonObject) == true) goto L68;
        r7 = null;
    L68:
        Object r9 = (JsonObject) r7;     // Catch: Throwable -> L166
        if (r9 != null) goto L75;
        Object r10 = com.bytedance.android.ec.base.settings.d.a.get("tabkit_deeplink_prefetch_config");     // Catch: Throwable -> L166
        if ((r10 instanceof JsonObject) == true) goto L74;
        r10 = null;
    L74:
        r9 = (JsonObject) r10;     // Catch: Throwable -> L166
    L75:
        if (r9 != null) goto L176;
        int r11 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L166
        Object r12 = com.bytedance.android.ec.base.settings.d.c.get("tabkit_deeplink_prefetch_config");     // Catch: Throwable -> L130
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
        if ((r14 instanceof JsonObject) == true) goto L141;
        r14 = null;
    L141:
        r9 = (JsonObject) r14;     // Catch: Throwable -> L156
        if (r9 != null) goto L164;
        IHybridHostService r16 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r16 == null) goto L147;
        Object r17 = r16.getHostABValue("tabkit_deeplink_prefetch_config", r1);     // Catch: Throwable -> L156
    L148:
        if (r17 != null) goto L150;
    L155:
        r9 = r1;
        goto L164
    L150:
        if ((r17 instanceof JsonObject) == false) goto L153;
        r4 = r17;
    L153:
        Object r18 = (JsonObject) r4;     // Catch: Throwable -> L156
        if (r18 == null) goto L155;
    L163:
        r9 = r18;
        goto L164
    L147:
        r17 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d("tabkit_deeplink_prefetch_config", r9);     // Catch: Throwable -> L166
        goto L176
    L82:
        if ((r12 instanceof JsonObject) == true) goto L84;
        Object r19 = null;
    L85:
        r13 = (JsonObject) r19;     // Catch: Throwable -> L130
        if (r13 != null) goto L128;
        if ((r12 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(JsonObject.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r20 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L130
        if ((r20 instanceof JsonObject) == true) goto L95;
        r20 = null;
    L95:
        r13 = (JsonObject) r20;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(JsonObject.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r21 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L130
        if ((r21 instanceof JsonObject) == true) goto L101;
        r21 = null;
    L101:
        r13 = (JsonObject) r21;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(JsonObject.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r22 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L130
        if ((r22 instanceof JsonObject) == true) goto L107;
        r22 = null;
    L107:
        r13 = (JsonObject) r22;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(JsonObject.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r23 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L130
        if ((r23 instanceof JsonObject) == true) goto L113;
        r23 = null;
    L113:
        r13 = (JsonObject) r23;     // Catch: Throwable -> L130
    L115:
        if ((r12 instanceof JSONObject) == false) goto L117;
    L184:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L123
        Object r24 = SDKSettingsCacheManager.a().fromJson(r12.toString(), JsonObject.class);     // Catch: Throwable -> L123
        if ((r24 instanceof JsonObject) == true) goto L121;
        r24 = null;
    L121:
        Object r25 = Result.constructor-impl((JsonObject) r24);     // Catch: Throwable -> L123
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
        return (JsonObject) r9;
    L9:
        if ((r5 instanceof JsonObject) == true) goto L11;
        Object r30 = null;
    L12:
        r6 = (JsonObject) r30;     // Catch: Throwable -> L57
        if (r6 != null) goto L55;
        if ((r5 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(JsonObject.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r31 = Float.valueOf(((Number) r5).floatValue());     // Catch: Throwable -> L57
        if ((r31 instanceof JsonObject) == true) goto L22;
        r31 = null;
    L22:
        r6 = (JsonObject) r31;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(JsonObject.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r32 = Double.valueOf(((Number) r5).doubleValue());     // Catch: Throwable -> L57
        if ((r32 instanceof JsonObject) == true) goto L28;
        r32 = null;
    L28:
        r6 = (JsonObject) r32;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(JsonObject.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r33 = Integer.valueOf(((Number) r5).intValue());     // Catch: Throwable -> L57
        if ((r33 instanceof JsonObject) == true) goto L34;
        r33 = null;
    L34:
        r6 = (JsonObject) r33;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(JsonObject.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r34 = Long.valueOf(((Number) r5).longValue());     // Catch: Throwable -> L57
        if ((r34 instanceof JsonObject) == true) goto L40;
        r34 = null;
    L40:
        r6 = (JsonObject) r34;     // Catch: Throwable -> L57
    L42:
        if ((r5 instanceof JSONObject) == false) goto L44;
    L181:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r35 = SDKSettingsCacheManager.a().fromJson(r5.toString(), JsonObject.class);     // Catch: Throwable -> L50
        if ((r35 instanceof JsonObject) == true) goto L48;
        r35 = null;
    L48:
        Object r36 = Result.constructor-impl((JsonObject) r35);     // Catch: Throwable -> L50
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

    @SettingPanel("TabKit 参数拼接过滤")
    public static final u d() {
        int r0 = com.bytedance.android.ec.base.settings.b.a;
        Object r1 = new u();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L172
        h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r3 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L172
        Object r4 = null;
        r3.getClass();     // Catch: Throwable -> L59
        Object r5 = SDKSettingsCacheManager.b.get("ec_tabkit_query_filter");     // Catch: Throwable -> L59
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
        if ((r7 instanceof u) == true) goto L70;
        r7 = null;
    L70:
        Object r9 = (u) r7;     // Catch: Throwable -> L172
        if (r9 != null) goto L77;
        r3.getClass();     // Catch: Throwable -> L172
        Object r10 = SDKSettingsCacheManager.a.get("ec_tabkit_query_filter");     // Catch: Throwable -> L172
        if ((r10 instanceof u) == true) goto L76;
        r10 = null;
    L76:
        r9 = (u) r10;     // Catch: Throwable -> L172
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
        SDKSettingsCacheManager.e("ec_tabkit_query_filter", r9);     // Catch: Throwable -> L172
        goto L182
    L185:
        r13 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_tabkit_query_filter", u.class, r1);     // Catch: Throwable -> L166
    L167:
        if (r13 != null) goto L169;
        r9 = r1;
    L166:
        r13 = r1;
        goto L167
    L191:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L133
        Object r14 = SDKSettingsCacheManager.b.get("ec_tabkit_query_filter");     // Catch: Throwable -> L133
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
        if ((r16 instanceof u) == true) goto L144;
        r16 = null;
    L144:
        r13 = (u) r16;     // Catch: Throwable -> L159
        if (r13 != null) goto L169;
        jj4.b r18 = jj4.b.b;     // Catch: Throwable -> L159
        Object r19 = jj4.a.a("ec_tabkit_query_filter", u.class, r1, false);     // Catch: Throwable -> L159
        if (r19 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r19 instanceof u) == false) goto L154;
        r4 = r19;
    L154:
        Object r20 = (u) r4;     // Catch: Throwable -> L159
        if (r20 != null) goto L157;
        r20 = r1;
    L157:
        r13 = Result.constructor-impl(r20);     // Catch: Throwable -> L159
    L85:
        if ((r14 instanceof u) == true) goto L87;
        Object r21 = null;
    L88:
        r15 = (u) r21;     // Catch: Throwable -> L133
        if (r15 != null) goto L131;
        if ((r14 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(u.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r22 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L133
        if ((r22 instanceof u) == true) goto L98;
        r22 = null;
    L98:
        r15 = (u) r22;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(u.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r23 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L133
        if ((r23 instanceof u) == true) goto L104;
        r23 = null;
    L104:
        r15 = (u) r23;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(u.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r24 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L133
        if ((r24 instanceof u) == true) goto L110;
        r24 = null;
    L110:
        r15 = (u) r24;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(u.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r25 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L133
        if ((r25 instanceof u) == true) goto L116;
        r25 = null;
    L116:
        r15 = (u) r25;     // Catch: Throwable -> L133
    L118:
        if ((r14 instanceof JSONObject) == false) goto L120;
    L183:
        Object r26 = SDKSettingsCacheManager.a().fromJson(r14.toString(), u.class);     // Catch: Throwable -> L126
        if ((r26 instanceof u) == true) goto L124;
        r26 = null;
    L124:
        Object r27 = Result.constructor-impl((u) r26);     // Catch: Throwable -> L126
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
        return (u) r9;
    L11:
        if ((r5 instanceof u) == true) goto L13;
        Object r30 = null;
    L14:
        r6 = (u) r30;     // Catch: Throwable -> L59
        if (r6 != null) goto L57;
        if ((r5 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(u.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r31 = Float.valueOf(((Number) r5).floatValue());     // Catch: Throwable -> L59
        if ((r31 instanceof u) == true) goto L24;
        r31 = null;
    L24:
        r6 = (u) r31;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(u.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r32 = Double.valueOf(((Number) r5).doubleValue());     // Catch: Throwable -> L59
        if ((r32 instanceof u) == true) goto L30;
        r32 = null;
    L30:
        r6 = (u) r32;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(u.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r33 = Integer.valueOf(((Number) r5).intValue());     // Catch: Throwable -> L59
        if ((r33 instanceof u) == true) goto L36;
        r33 = null;
    L36:
        r6 = (u) r33;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(u.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r34 = Long.valueOf(((Number) r5).longValue());     // Catch: Throwable -> L59
        if ((r34 instanceof u) == true) goto L42;
        r34 = null;
    L42:
        r6 = (u) r34;     // Catch: Throwable -> L59
    L44:
        if ((r5 instanceof JSONObject) == false) goto L46;
    L189:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r5.toString(), u.class);     // Catch: Throwable -> L52
        if ((r35 instanceof u) == true) goto L50;
        r35 = null;
    L50:
        Object r36 = Result.constructor-impl((u) r35);     // Catch: Throwable -> L52
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

    static {
    }

    @JvmStatic
    public static final boolean a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "bizTag");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        JsonElement r3 = b().get(r2);     // Catch: Throwable -> L11
        if (r3 == null) goto L7;
        int r4 = r3.getAsInt();     // Catch: Throwable -> L11
    L8:
        if (r4 <= 0) goto L16;
        return true;
    L16:
        return false;
    L7:
        r4 = 0;
    L11:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return false;
    }
}
