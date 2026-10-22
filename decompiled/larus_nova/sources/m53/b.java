package m53;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.g;
import com.bytedance.android.ec.base.settings.h;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.HashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, Number> f512108a = null;

    static {
        HashMap<String, Number> r100 = new HashMap();
        r100.put("active", 30);
        r100.put(VSConstants.EXTRA_SHOW_MSG_BOARD_FROM_PASSIVE_ACTION, 7);
        f512108a = r100;
    }

    public static long a(String r100, int r101) {
        int r102 = a.f512107a;
        int r103 = com.bytedance.android.ec.base.settings.b.f42814a;
        Object r104 = f512108a;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L172
        h.a();     // Catch: Throwable -> L172
        SDKSettingsCacheManager r106 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L172
        Object r107 = null;
        r106.getClass();     // Catch: Throwable -> L59
        Object r108 = SDKSettingsCacheManager.f42809b.get("ec_comment_nps_frequency_limit");     // Catch: Throwable -> L59
        if (r108 != null) goto L11;
    L56:
        Object r109 = null;
    L57:
        Object r110 = Result.m9449constructorimpl(r109);     // Catch: Throwable -> L59
    L61:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r110);     // Catch: Throwable -> L172
        if (r111 == null) goto L65;
        EnsureManager.ensureNotReachHere(r111);     // Catch: Throwable -> L172
    L65:
        if (Result.m9455isFailureimpl(r110) == false) goto L68;
        r110 = null;
    L68:
        if ((r110 instanceof HashMap) == true) goto L70;
        r110 = null;
    L70:
        Object r112 = (HashMap) r110;     // Catch: Throwable -> L172
        if (r112 != null) goto L77;
        r106.getClass();     // Catch: Throwable -> L172
        Object r113 = SDKSettingsCacheManager.f42808a.get("ec_comment_nps_frequency_limit");     // Catch: Throwable -> L172
        if ((r113 instanceof HashMap) == true) goto L76;
        r113 = null;
    L76:
        r112 = (HashMap) r113;     // Catch: Throwable -> L172
    L77:
        if (r112 != null) goto L181;
        int r114 = g.f42821a;     // Catch: Throwable -> L172
    L159:
        th = move-exception;
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L172
        Object r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L162:
        if (Result.m9452exceptionOrNullimpl(r116) != null) goto L190;
    L169:
        r112 = r116;
    L170:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L172
        SDKSettingsCacheManager.e("ec_comment_nps_frequency_limit", r112);     // Catch: Throwable -> L172
        goto L181
    L190:
        r116 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_comment_nps_frequency_limit", HashMap.class, r104);     // Catch: Throwable -> L166
    L167:
        if (r116 != null) goto L169;
        r112 = r104;
    L166:
        r116 = r104;
        goto L167
    L196:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L133
        Object r117 = SDKSettingsCacheManager.f42809b.get("ec_comment_nps_frequency_limit");     // Catch: Throwable -> L133
        if (r117 != null) goto L85;
    L130:
        Object r118 = null;
    L131:
        Object r119 = Result.m9449constructorimpl(r118);     // Catch: Throwable -> L133
    L135:
        Throwable r120 = Result.m9452exceptionOrNullimpl(r119);     // Catch: Throwable -> L159
        if (r120 == null) goto L139;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L159
    L139:
        if (Result.m9455isFailureimpl(r119) == false) goto L142;
        r119 = null;
    L142:
        if ((r119 instanceof HashMap) == true) goto L144;
        r119 = null;
    L144:
        r116 = (HashMap) r119;     // Catch: Throwable -> L159
        if (r116 != null) goto L169;
        jj4.b r121 = jj4.b.f499326b;     // Catch: Throwable -> L159
        Object r122 = jj4.a.a("ec_comment_nps_frequency_limit", HashMap.class, r104, false);     // Catch: Throwable -> L159
        if (r122 != null) goto L151;
        Intrinsics.throwNpe();     // Catch: Throwable -> L159
    L151:
        if ((r122 instanceof HashMap) == false) goto L154;
        r107 = r122;
    L154:
        Object r123 = (HashMap) r107;     // Catch: Throwable -> L159
        if (r123 != null) goto L157;
        r123 = r104;
    L157:
        r116 = Result.m9449constructorimpl(r123);     // Catch: Throwable -> L159
    L85:
        if ((r117 instanceof HashMap) == true) goto L87;
        Object r124 = null;
    L88:
        r118 = (HashMap) r124;     // Catch: Throwable -> L133
        if (r118 != null) goto L131;
        if ((r117 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r125 = Float.valueOf(((Number) r117).floatValue());     // Catch: Throwable -> L133
        if ((r125 instanceof HashMap) == true) goto L98;
        r125 = null;
    L98:
        r118 = (HashMap) r125;     // Catch: Throwable -> L133
        goto L131
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r126 = Double.valueOf(((Number) r117).doubleValue());     // Catch: Throwable -> L133
        if ((r126 instanceof HashMap) == true) goto L104;
        r126 = null;
    L104:
        r118 = (HashMap) r126;     // Catch: Throwable -> L133
        goto L131
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        Integer r127 = Integer.valueOf(((Number) r117).intValue());     // Catch: Throwable -> L133
        if ((r127 instanceof HashMap) == true) goto L110;
        r127 = null;
    L110:
        r118 = (HashMap) r127;     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r128 = Long.valueOf(((Number) r117).longValue());     // Catch: Throwable -> L133
        if ((r128 instanceof HashMap) == true) goto L116;
        r128 = null;
    L116:
        r118 = (HashMap) r128;     // Catch: Throwable -> L133
    L118:
        if ((r117 instanceof JSONObject) == false) goto L120;
    L188:
        Object r129 = SDKSettingsCacheManager.a().fromJson(r117.toString(), HashMap.class);     // Catch: Throwable -> L126
        if ((r129 instanceof HashMap) == true) goto L124;
        r129 = null;
    L124:
        Object r130 = Result.m9449constructorimpl((HashMap) r129);     // Catch: Throwable -> L126
    L128:
        r118 = r130;
        if (Result.m9455isFailureimpl(r118) == false) goto L131;
    L126:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L133
        r130 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L133
        goto L128
    L120:
        if ((r117 instanceof JSONArray) == false) goto L130;
    L87:
        r124 = r117;
    L133:
        th = move-exception;
        Result.Companion r132 = Result.Companion;     // Catch: Throwable -> L159
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L159
    L181:
        Number r133 = (Number) ((HashMap) r112).get(r100);
        if (r133 != null) goto L184;
        r133 = f512108a.get(r100);
    L184:
        if (r133 == null) goto L187;
        return r133.longValue();
    L187:
        return r101;
    L11:
        if ((r108 instanceof HashMap) == true) goto L13;
        Object r134 = null;
    L14:
        r109 = (HashMap) r134;     // Catch: Throwable -> L59
        if (r109 != null) goto L57;
        if ((r108 instanceof Number) == false) goto L44;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r135 = Float.valueOf(((Number) r108).floatValue());     // Catch: Throwable -> L59
        if ((r135 instanceof HashMap) == true) goto L24;
        r135 = null;
    L24:
        r109 = (HashMap) r135;     // Catch: Throwable -> L59
        goto L57
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r136 = Double.valueOf(((Number) r108).doubleValue());     // Catch: Throwable -> L59
        if ((r136 instanceof HashMap) == true) goto L30;
        r136 = null;
    L30:
        r109 = (HashMap) r136;     // Catch: Throwable -> L59
        goto L57
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L38;
        Integer r137 = Integer.valueOf(((Number) r108).intValue());     // Catch: Throwable -> L59
        if ((r137 instanceof HashMap) == true) goto L36;
        r137 = null;
    L36:
        r109 = (HashMap) r137;     // Catch: Throwable -> L59
        goto L57
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(HashMap.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L44;
        Long r138 = Long.valueOf(((Number) r108).longValue());     // Catch: Throwable -> L59
        if ((r138 instanceof HashMap) == true) goto L42;
        r138 = null;
    L42:
        r109 = (HashMap) r138;     // Catch: Throwable -> L59
    L44:
        if ((r108 instanceof JSONObject) == false) goto L46;
    L194:
        Object r139 = SDKSettingsCacheManager.a().fromJson(r108.toString(), HashMap.class);     // Catch: Throwable -> L52
        if ((r139 instanceof HashMap) == true) goto L50;
        r139 = null;
    L50:
        Object r140 = Result.m9449constructorimpl((HashMap) r139);     // Catch: Throwable -> L52
    L54:
        r109 = r140;
        if (Result.m9455isFailureimpl(r109) == false) goto L57;
    L52:
        th = move-exception;
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L59
        r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L59
        goto L54
    L46:
        if ((r108 instanceof JSONArray) == false) goto L56;
    L13:
        r134 = r108;
    L59:
        th = move-exception;
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L172
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
    L172:
        th = move-exception;
        Result.Companion r143 = Result.Companion;
        Object r144 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r145 = Result.m9452exceptionOrNullimpl(r144);
        if (r145 == null) goto L177;
        EnsureManager.ensureNotReachHere(r145);
    L177:
        if (Result.m9455isFailureimpl(r144) == true) goto L180;
        r104 = r144;
    L180:
        r112 = r104;
        goto L181
    }
}
