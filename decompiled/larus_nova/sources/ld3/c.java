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

/* JADX INFO: loaded from: classes13.dex */
@OptSetting(business = "短视频ab实验管理类")
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f508687a = 0;

    @HostExperimentKey
    public static final int a() {
        int r100 = m.f45240a;
        Object r101 = 0;
        boolean r102 = ECServiceManager.f42805a;
        g r103 = (g) ECServiceManager.c(g.class);
        if (r103 == null) goto L8;
        s83.a r104 = r103.q();
        if (r104 == null) goto L8;
        Object r105 = r104.e("ecom_video_add_feedback_panel");
        if (r105 == null) goto L8;
    L175:
        return ((Number) r105).intValue();
    L8:
        int r106 = n.f45241a;
        int r107 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L165
        Object r109 = null;
        Object r110 = com.bytedance.android.ec.base.settings.d.f42818c.get("ecom_video_add_feedback_panel");     // Catch: Throwable -> L60
        if (r110 != null) goto L15;
    L57:
        Object r111 = null;
    L58:
        Object r112 = Result.m9449constructorimpl(r111);     // Catch: Throwable -> L60
    L62:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);     // Catch: Throwable -> L165
        if (r113 == null) goto L66;
        EnsureManager.ensureNotReachHere(r113);     // Catch: Throwable -> L165
    L66:
        if (Result.m9455isFailureimpl(r112) == false) goto L69;
        r112 = null;
    L69:
        if ((r112 instanceof Integer) == true) goto L71;
        r112 = null;
    L71:
        Integer r114 = (Integer) r112;     // Catch: Throwable -> L165
        if (r114 != null) goto L78;
        Object r115 = com.bytedance.android.ec.base.settings.d.f42816a.get("ecom_video_add_feedback_panel");     // Catch: Throwable -> L165
        if ((r115 instanceof Integer) == true) goto L77;
        r115 = null;
    L77:
        r114 = (Integer) r115;     // Catch: Throwable -> L165
    L78:
        if (r114 == null) goto L80;
        r105 = r114;
        goto L175
    L80:
        int r116 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L165
        Object r117 = com.bytedance.android.ec.base.settings.d.f42818c.get("ecom_video_add_feedback_panel");     // Catch: Throwable -> L130
        if (r117 != null) goto L85;
    L127:
        Object r118 = null;
    L128:
        Object r119 = Result.m9449constructorimpl(r118);     // Catch: Throwable -> L130
    L132:
        Throwable r120 = Result.m9452exceptionOrNullimpl(r119);     // Catch: Throwable -> L156
        if (r120 == null) goto L136;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L156
    L136:
        if (Result.m9455isFailureimpl(r119) == false) goto L139;
        r119 = null;
    L139:
        if ((r119 instanceof Integer) == true) goto L141;
        r119 = null;
    L141:
        Integer r121 = (Integer) r119;     // Catch: Throwable -> L156
        if (r121 == null) goto L144;
        r105 = r121;
    L163:
        com.bytedance.android.ec.base.settings.d.d("ecom_video_add_feedback_panel", r105);     // Catch: Throwable -> L165
        goto L175
    L144:
        IHybridHostService r122 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r122 == null) goto L147;
        Object r123 = r122.getHostABValue("ecom_video_add_feedback_panel", r101);     // Catch: Throwable -> L156
    L148:
        if (r123 != null) goto L150;
    L162:
        r105 = r101;
        goto L163
    L150:
        if ((r123 instanceof Integer) == false) goto L153;
        r109 = r123;
    L153:
        r105 = (Integer) r109;     // Catch: Throwable -> L156
        if (r105 != null) goto L163;
    L147:
        r123 = null;
        goto L148
    L85:
        if ((r117 instanceof Integer) == true) goto L87;
        Object r124 = null;
    L88:
        r118 = (Integer) r124;     // Catch: Throwable -> L130
        if (r118 != null) goto L128;
        if ((r117 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r125 = Float.valueOf(((Number) r117).floatValue());     // Catch: Throwable -> L130
        if ((r125 instanceof Integer) == true) goto L98;
        r125 = null;
    L98:
        r118 = (Integer) r125;     // Catch: Throwable -> L130
        goto L128
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r126 = Double.valueOf(((Number) r117).doubleValue());     // Catch: Throwable -> L130
        if ((r126 instanceof Integer) == true) goto L104;
        r126 = null;
    L104:
        r118 = (Integer) r126;     // Catch: Throwable -> L130
        goto L128
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        r118 = Integer.valueOf(((Number) r117).intValue());     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r127 = Long.valueOf(((Number) r117).longValue());     // Catch: Throwable -> L130
        if ((r127 instanceof Integer) == true) goto L113;
        r127 = null;
    L113:
        r118 = (Integer) r127;     // Catch: Throwable -> L130
    L115:
        if ((r117 instanceof JSONObject) == false) goto L117;
    L183:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L123
        Object r128 = SDKSettingsCacheManager.a().fromJson(r117.toString(), Integer.class);     // Catch: Throwable -> L123
        if ((r128 instanceof Integer) == true) goto L121;
        r128 = null;
    L121:
        Object r129 = Result.m9449constructorimpl((Integer) r128);     // Catch: Throwable -> L123
    L125:
        r118 = r129;
        if (Result.m9455isFailureimpl(r118) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L130
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r117 instanceof JSONArray) == false) goto L127;
    L87:
        r124 = r117;
    L156:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L165
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
        Throwable r132 = Result.m9452exceptionOrNullimpl(r105);     // Catch: Throwable -> L165
        if (r132 == null) goto L161;
        EnsureManager.ensureNotReachHere(r132);     // Catch: Throwable -> L165
    L161:
        if (Result.m9455isFailureimpl(r105) == false) goto L163;
    L130:
        th = move-exception;
        Result.Companion r133 = Result.Companion;     // Catch: Throwable -> L156
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
        goto L132
    L15:
        if ((r110 instanceof Integer) == true) goto L17;
        Object r134 = null;
    L18:
        r111 = (Integer) r134;     // Catch: Throwable -> L60
        if (r111 != null) goto L58;
        if ((r110 instanceof Number) == false) goto L45;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L30;
        Float r135 = Float.valueOf(((Number) r110).floatValue());     // Catch: Throwable -> L60
        if ((r135 instanceof Integer) == true) goto L28;
        r135 = null;
    L28:
        r111 = (Integer) r135;     // Catch: Throwable -> L60
        goto L58
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L36;
        Double r136 = Double.valueOf(((Number) r110).doubleValue());     // Catch: Throwable -> L60
        if ((r136 instanceof Integer) == true) goto L34;
        r136 = null;
    L34:
        r111 = (Integer) r136;     // Catch: Throwable -> L60
        goto L58
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L39;
        r111 = Integer.valueOf(((Number) r110).intValue());     // Catch: Throwable -> L60
        goto L58
    L39:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L45;
        Long r137 = Long.valueOf(((Number) r110).longValue());     // Catch: Throwable -> L60
        if ((r137 instanceof Integer) == true) goto L43;
        r137 = null;
    L43:
        r111 = (Integer) r137;     // Catch: Throwable -> L60
    L45:
        if ((r110 instanceof JSONObject) == false) goto L47;
    L181:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L53
        Object r138 = SDKSettingsCacheManager.a().fromJson(r110.toString(), Integer.class);     // Catch: Throwable -> L53
        if ((r138 instanceof Integer) == true) goto L51;
        r138 = null;
    L51:
        Object r139 = Result.m9449constructorimpl((Integer) r138);     // Catch: Throwable -> L53
    L55:
        r111 = r139;
        if (Result.m9455isFailureimpl(r111) == false) goto L58;
    L53:
        th = move-exception;
        Result.Companion r140 = Result.Companion;     // Catch: Throwable -> L60
        r139 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L60
        goto L55
    L47:
        if ((r110 instanceof JSONArray) == false) goto L57;
    L17:
        r134 = r110;
    L60:
        th = move-exception;
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L165
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
    L165:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        Object r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r144 = Result.m9452exceptionOrNullimpl(r143);
        if (r144 == null) goto L170;
        EnsureManager.ensureNotReachHere(r144);
    L170:
        if (Result.m9455isFailureimpl(r143) == true) goto L173;
        r101 = r143;
    L173:
        r105 = r101;
        goto L175
    }

    @HostExperimentKey
    public static final int b() {
        int r100 = m.f45240a;
        Object r101 = 0;
        boolean r102 = ECServiceManager.f42805a;
        g r103 = (g) ECServiceManager.c(g.class);
        if (r103 == null) goto L8;
        s83.a r104 = r103.q();
        if (r104 == null) goto L8;
        Object r105 = r104.e("ec_inflow_cache_resp");
        if (r105 == null) goto L8;
    L175:
        return ((Number) r105).intValue();
    L8:
        int r106 = n.f45241a;
        int r107 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L165
        Object r109 = null;
        Object r110 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_inflow_cache_resp");     // Catch: Throwable -> L60
        if (r110 != null) goto L15;
    L57:
        Object r111 = null;
    L58:
        Object r112 = Result.m9449constructorimpl(r111);     // Catch: Throwable -> L60
    L62:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);     // Catch: Throwable -> L165
        if (r113 == null) goto L66;
        EnsureManager.ensureNotReachHere(r113);     // Catch: Throwable -> L165
    L66:
        if (Result.m9455isFailureimpl(r112) == false) goto L69;
        r112 = null;
    L69:
        if ((r112 instanceof Integer) == true) goto L71;
        r112 = null;
    L71:
        Integer r114 = (Integer) r112;     // Catch: Throwable -> L165
        if (r114 != null) goto L78;
        Object r115 = com.bytedance.android.ec.base.settings.d.f42816a.get("ec_inflow_cache_resp");     // Catch: Throwable -> L165
        if ((r115 instanceof Integer) == true) goto L77;
        r115 = null;
    L77:
        r114 = (Integer) r115;     // Catch: Throwable -> L165
    L78:
        if (r114 == null) goto L80;
        r105 = r114;
        goto L175
    L80:
        int r116 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L165
        Object r117 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_inflow_cache_resp");     // Catch: Throwable -> L130
        if (r117 != null) goto L85;
    L127:
        Object r118 = null;
    L128:
        Object r119 = Result.m9449constructorimpl(r118);     // Catch: Throwable -> L130
    L132:
        Throwable r120 = Result.m9452exceptionOrNullimpl(r119);     // Catch: Throwable -> L156
        if (r120 == null) goto L136;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L156
    L136:
        if (Result.m9455isFailureimpl(r119) == false) goto L139;
        r119 = null;
    L139:
        if ((r119 instanceof Integer) == true) goto L141;
        r119 = null;
    L141:
        Integer r121 = (Integer) r119;     // Catch: Throwable -> L156
        if (r121 == null) goto L144;
        r105 = r121;
    L163:
        com.bytedance.android.ec.base.settings.d.d("ec_inflow_cache_resp", r105);     // Catch: Throwable -> L165
        goto L175
    L144:
        IHybridHostService r122 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r122 == null) goto L147;
        Object r123 = r122.getHostABValue("ec_inflow_cache_resp", r101);     // Catch: Throwable -> L156
    L148:
        if (r123 != null) goto L150;
    L162:
        r105 = r101;
        goto L163
    L150:
        if ((r123 instanceof Integer) == false) goto L153;
        r109 = r123;
    L153:
        r105 = (Integer) r109;     // Catch: Throwable -> L156
        if (r105 != null) goto L163;
    L147:
        r123 = null;
        goto L148
    L85:
        if ((r117 instanceof Integer) == true) goto L87;
        Object r124 = null;
    L88:
        r118 = (Integer) r124;     // Catch: Throwable -> L130
        if (r118 != null) goto L128;
        if ((r117 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r125 = Float.valueOf(((Number) r117).floatValue());     // Catch: Throwable -> L130
        if ((r125 instanceof Integer) == true) goto L98;
        r125 = null;
    L98:
        r118 = (Integer) r125;     // Catch: Throwable -> L130
        goto L128
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r126 = Double.valueOf(((Number) r117).doubleValue());     // Catch: Throwable -> L130
        if ((r126 instanceof Integer) == true) goto L104;
        r126 = null;
    L104:
        r118 = (Integer) r126;     // Catch: Throwable -> L130
        goto L128
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        r118 = Integer.valueOf(((Number) r117).intValue());     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r127 = Long.valueOf(((Number) r117).longValue());     // Catch: Throwable -> L130
        if ((r127 instanceof Integer) == true) goto L113;
        r127 = null;
    L113:
        r118 = (Integer) r127;     // Catch: Throwable -> L130
    L115:
        if ((r117 instanceof JSONObject) == false) goto L117;
    L183:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L123
        Object r128 = SDKSettingsCacheManager.a().fromJson(r117.toString(), Integer.class);     // Catch: Throwable -> L123
        if ((r128 instanceof Integer) == true) goto L121;
        r128 = null;
    L121:
        Object r129 = Result.m9449constructorimpl((Integer) r128);     // Catch: Throwable -> L123
    L125:
        r118 = r129;
        if (Result.m9455isFailureimpl(r118) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L130
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r117 instanceof JSONArray) == false) goto L127;
    L87:
        r124 = r117;
    L156:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L165
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
        Throwable r132 = Result.m9452exceptionOrNullimpl(r105);     // Catch: Throwable -> L165
        if (r132 == null) goto L161;
        EnsureManager.ensureNotReachHere(r132);     // Catch: Throwable -> L165
    L161:
        if (Result.m9455isFailureimpl(r105) == false) goto L163;
    L130:
        th = move-exception;
        Result.Companion r133 = Result.Companion;     // Catch: Throwable -> L156
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
        goto L132
    L15:
        if ((r110 instanceof Integer) == true) goto L17;
        Object r134 = null;
    L18:
        r111 = (Integer) r134;     // Catch: Throwable -> L60
        if (r111 != null) goto L58;
        if ((r110 instanceof Number) == false) goto L45;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L30;
        Float r135 = Float.valueOf(((Number) r110).floatValue());     // Catch: Throwable -> L60
        if ((r135 instanceof Integer) == true) goto L28;
        r135 = null;
    L28:
        r111 = (Integer) r135;     // Catch: Throwable -> L60
        goto L58
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L36;
        Double r136 = Double.valueOf(((Number) r110).doubleValue());     // Catch: Throwable -> L60
        if ((r136 instanceof Integer) == true) goto L34;
        r136 = null;
    L34:
        r111 = (Integer) r136;     // Catch: Throwable -> L60
        goto L58
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L39;
        r111 = Integer.valueOf(((Number) r110).intValue());     // Catch: Throwable -> L60
        goto L58
    L39:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L45;
        Long r137 = Long.valueOf(((Number) r110).longValue());     // Catch: Throwable -> L60
        if ((r137 instanceof Integer) == true) goto L43;
        r137 = null;
    L43:
        r111 = (Integer) r137;     // Catch: Throwable -> L60
    L45:
        if ((r110 instanceof JSONObject) == false) goto L47;
    L181:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L53
        Object r138 = SDKSettingsCacheManager.a().fromJson(r110.toString(), Integer.class);     // Catch: Throwable -> L53
        if ((r138 instanceof Integer) == true) goto L51;
        r138 = null;
    L51:
        Object r139 = Result.m9449constructorimpl((Integer) r138);     // Catch: Throwable -> L53
    L55:
        r111 = r139;
        if (Result.m9455isFailureimpl(r111) == false) goto L58;
    L53:
        th = move-exception;
        Result.Companion r140 = Result.Companion;     // Catch: Throwable -> L60
        r139 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L60
        goto L55
    L47:
        if ((r110 instanceof JSONArray) == false) goto L57;
    L17:
        r134 = r110;
    L60:
        th = move-exception;
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L165
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
    L165:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        Object r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r144 = Result.m9452exceptionOrNullimpl(r143);
        if (r144 == null) goto L170;
        EnsureManager.ensureNotReachHere(r144);
    L170:
        if (Result.m9455isFailureimpl(r143) == true) goto L173;
        r101 = r143;
    L173:
        r105 = r101;
        goto L175
    }

    @HostExperimentKey
    public static final List<String> c() {
        int r100 = m.f45240a;
        Object r101 = CollectionsKt.emptyList();
        boolean r102 = ECServiceManager.f42805a;
        g r103 = (g) ECServiceManager.c(g.class);
        if (r103 == null) goto L8;
        s83.a r104 = r103.q();
        if (r104 == null) goto L8;
        Object r105 = r104.e("ec_goods_feed_host_list");
        if (r105 == null) goto L8;
    L185:
        return (List) r105;
    L8:
        int r106 = n.f45241a;
        int r107 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L175
        Object r109 = null;
        Object r110 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_goods_feed_host_list");     // Catch: Throwable -> L63
        if (r110 != null) goto L15;
    L60:
        Object r111 = null;
    L61:
        Object r112 = Result.m9449constructorimpl(r111);     // Catch: Throwable -> L63
    L65:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);     // Catch: Throwable -> L175
        if (r113 == null) goto L69;
        EnsureManager.ensureNotReachHere(r113);     // Catch: Throwable -> L175
    L69:
        if (Result.m9455isFailureimpl(r112) == false) goto L72;
        r112 = null;
    L72:
        if ((r112 instanceof List) == true) goto L74;
        r112 = null;
    L74:
        List r114 = (List) r112;     // Catch: Throwable -> L175
        if (r114 != null) goto L77;
    L79:
        Object r115 = com.bytedance.android.ec.base.settings.d.f42816a.get("ec_goods_feed_host_list");     // Catch: Throwable -> L175
        if ((r115 instanceof List) == true) goto L82;
        r115 = null;
    L82:
        r114 = (List) r115;     // Catch: Throwable -> L175
    L83:
        if (r114 == null) goto L85;
        r105 = r114;
        goto L185
    L85:
        int r116 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L175
        Object r117 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_goods_feed_host_list");     // Catch: Throwable -> L138
        if (r117 != null) goto L90;
    L135:
        Object r118 = null;
    L136:
        Object r119 = Result.m9449constructorimpl(r118);     // Catch: Throwable -> L138
    L140:
        Throwable r120 = Result.m9452exceptionOrNullimpl(r119);     // Catch: Throwable -> L166
        if (r120 == null) goto L144;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L166
    L144:
        if (Result.m9455isFailureimpl(r119) == false) goto L147;
        r119 = null;
    L147:
        if ((r119 instanceof List) == true) goto L149;
        r119 = null;
    L149:
        List r121 = (List) r119;     // Catch: Throwable -> L166
        if (r121 != null) goto L152;
    L154:
        IHybridHostService r122 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L166
        if (r122 == null) goto L157;
        Object r123 = r122.getHostABValue("ec_goods_feed_host_list", r101);     // Catch: Throwable -> L166
    L158:
        if (r123 != null) goto L160;
    L172:
        r105 = r101;
    L173:
        com.bytedance.android.ec.base.settings.d.d("ec_goods_feed_host_list", r105);     // Catch: Throwable -> L175
        goto L185
    L160:
        if ((r123 instanceof List) == false) goto L163;
        r109 = r123;
    L163:
        r105 = (List) r109;     // Catch: Throwable -> L166
        if (r105 != null) goto L173;
    L166:
        th = move-exception;
        Result.Companion r124 = Result.Companion;     // Catch: Throwable -> L175
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L175
        Throwable r125 = Result.m9452exceptionOrNullimpl(r105);     // Catch: Throwable -> L175
        if (r125 == null) goto L171;
        EnsureManager.ensureNotReachHere(r125);     // Catch: Throwable -> L175
    L171:
        if (Result.m9455isFailureimpl(r105) == false) goto L173;
    L157:
        r123 = null;
        goto L158
    L152:
        if ((r121 instanceof List) == false) goto L154;
        r105 = r121;
        goto L173
    L90:
        if ((r117 instanceof List) == true) goto L92;
        Object r126 = null;
    L93:
        r118 = (List) r126;     // Catch: Throwable -> L138
        if (r118 != null) goto L136;
        if ((r117 instanceof Number) == false) goto L123;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L105;
        Float r127 = Float.valueOf(((Number) r117).floatValue());     // Catch: Throwable -> L138
        if ((r127 instanceof List) == true) goto L103;
        r127 = null;
    L103:
        r118 = (List) r127;     // Catch: Throwable -> L138
        goto L136
    L105:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L111;
        Double r128 = Double.valueOf(((Number) r117).doubleValue());     // Catch: Throwable -> L138
        if ((r128 instanceof List) == true) goto L109;
        r128 = null;
    L109:
        r118 = (List) r128;     // Catch: Throwable -> L138
        goto L136
    L111:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L117;
        Integer r129 = Integer.valueOf(((Number) r117).intValue());     // Catch: Throwable -> L138
        if ((r129 instanceof List) == true) goto L115;
        r129 = null;
    L115:
        r118 = (List) r129;     // Catch: Throwable -> L138
        goto L136
    L117:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L123;
        Long r130 = Long.valueOf(((Number) r117).longValue());     // Catch: Throwable -> L138
        if ((r130 instanceof List) == true) goto L121;
        r130 = null;
    L121:
        r118 = (List) r130;     // Catch: Throwable -> L138
    L123:
        if ((r117 instanceof JSONObject) == false) goto L125;
    L194:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L131
        Object r131 = SDKSettingsCacheManager.a().fromJson(r117.toString(), List.class);     // Catch: Throwable -> L131
        if ((r131 instanceof List) == true) goto L129;
        r131 = null;
    L129:
        Object r132 = Result.m9449constructorimpl((List) r131);     // Catch: Throwable -> L131
    L133:
        r118 = r132;
        if (Result.m9455isFailureimpl(r118) == false) goto L136;
    L131:
        th = move-exception;
        Result.Companion r133 = Result.Companion;     // Catch: Throwable -> L138
        r132 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L138
        goto L133
    L125:
        if ((r117 instanceof JSONArray) == false) goto L135;
    L92:
        r126 = r117;
    L138:
        th = move-exception;
        Result.Companion r134 = Result.Companion;     // Catch: Throwable -> L166
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
        goto L140
    L77:
        if ((r114 instanceof List) == false) goto L79;
    L15:
        if ((r110 instanceof List) == true) goto L17;
        Object r135 = null;
    L18:
        r111 = (List) r135;     // Catch: Throwable -> L63
        if (r111 != null) goto L61;
        if ((r110 instanceof Number) == false) goto L48;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L30;
        Float r136 = Float.valueOf(((Number) r110).floatValue());     // Catch: Throwable -> L63
        if ((r136 instanceof List) == true) goto L28;
        r136 = null;
    L28:
        r111 = (List) r136;     // Catch: Throwable -> L63
        goto L61
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L36;
        Double r137 = Double.valueOf(((Number) r110).doubleValue());     // Catch: Throwable -> L63
        if ((r137 instanceof List) == true) goto L34;
        r137 = null;
    L34:
        r111 = (List) r137;     // Catch: Throwable -> L63
        goto L61
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L42;
        Integer r138 = Integer.valueOf(((Number) r110).intValue());     // Catch: Throwable -> L63
        if ((r138 instanceof List) == true) goto L40;
        r138 = null;
    L40:
        r111 = (List) r138;     // Catch: Throwable -> L63
        goto L61
    L42:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(List.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L48;
        Long r139 = Long.valueOf(((Number) r110).longValue());     // Catch: Throwable -> L63
        if ((r139 instanceof List) == true) goto L46;
        r139 = null;
    L46:
        r111 = (List) r139;     // Catch: Throwable -> L63
    L48:
        if ((r110 instanceof JSONObject) == false) goto L50;
    L196:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L56
        Object r140 = SDKSettingsCacheManager.a().fromJson(r110.toString(), List.class);     // Catch: Throwable -> L56
        if ((r140 instanceof List) == true) goto L54;
        r140 = null;
    L54:
        Object r141 = Result.m9449constructorimpl((List) r140);     // Catch: Throwable -> L56
    L58:
        r111 = r141;
        if (Result.m9455isFailureimpl(r111) == false) goto L61;
    L56:
        th = move-exception;
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L63
        r141 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L63
        goto L58
    L50:
        if ((r110 instanceof JSONArray) == false) goto L60;
    L17:
        r135 = r110;
    L63:
        th = move-exception;
        Result.Companion r143 = Result.Companion;     // Catch: Throwable -> L175
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L175
    L175:
        th = move-exception;
        Result.Companion r144 = Result.Companion;
        Object r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r146 = Result.m9452exceptionOrNullimpl(r145);
        if (r146 == null) goto L180;
        EnsureManager.ensureNotReachHere(r146);
    L180:
        if (Result.m9455isFailureimpl(r145) == true) goto L183;
        r101 = r145;
    L183:
        r105 = r101;
        goto L185
    }

    @SettingPanel("内流替换价格字体")
    public static final boolean d() {
        int r100 = n.f45241a;
        Object r101 = Boolean.TRUE;
        int r102 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L166
        Object r104 = null;
        Object r105 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_inflow_typeface_new");     // Catch: Throwable -> L57
        if (r105 != null) goto L9;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L166
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L166
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof Boolean) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (Boolean) r107;     // Catch: Throwable -> L166
        if (r109 != null) goto L75;
        Object r110 = com.bytedance.android.ec.base.settings.d.f42816a.get("ec_inflow_typeface_new");     // Catch: Throwable -> L166
        if ((r110 instanceof Boolean) == true) goto L74;
        r110 = null;
    L74:
        r109 = (Boolean) r110;     // Catch: Throwable -> L166
    L75:
        if (r109 != null) goto L176;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L166
        Object r112 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_inflow_typeface_new");     // Catch: Throwable -> L130
        if (r112 != null) goto L82;
    L127:
        Object r113 = null;
    L128:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L130
    L132:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L156
        if (r115 == null) goto L136;
        EnsureManager.ensureNotReachHere(r115);     // Catch: Throwable -> L156
    L136:
        if (Result.m9455isFailureimpl(r114) == false) goto L139;
        r114 = null;
    L139:
        if ((r114 instanceof Boolean) == true) goto L141;
        r114 = null;
    L141:
        r109 = (Boolean) r114;     // Catch: Throwable -> L156
        if (r109 != null) goto L164;
        IHybridHostService r116 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r116 == null) goto L147;
        Object r117 = r116.getHostABValue("ec_inflow_typeface_new", r101);     // Catch: Throwable -> L156
    L148:
        if (r117 != null) goto L150;
    L155:
        r109 = r101;
        goto L164
    L150:
        if ((r117 instanceof Boolean) == false) goto L153;
        r104 = r117;
    L153:
        Object r118 = (Boolean) r104;     // Catch: Throwable -> L156
        if (r118 == null) goto L155;
    L163:
        r109 = r118;
        goto L164
    L147:
        r117 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d("ec_inflow_typeface_new", r109);     // Catch: Throwable -> L166
        goto L176
    L82:
        if ((r112 instanceof Boolean) == true) goto L84;
        Object r119 = null;
    L85:
        r113 = (Boolean) r119;     // Catch: Throwable -> L130
        if (r113 != null) goto L128;
        if ((r112 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r120 = Float.valueOf(((Number) r112).floatValue());     // Catch: Throwable -> L130
        if ((r120 instanceof Boolean) == true) goto L95;
        r120 = null;
    L95:
        r113 = (Boolean) r120;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r121 = Double.valueOf(((Number) r112).doubleValue());     // Catch: Throwable -> L130
        if ((r121 instanceof Boolean) == true) goto L101;
        r121 = null;
    L101:
        r113 = (Boolean) r121;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r122 = Integer.valueOf(((Number) r112).intValue());     // Catch: Throwable -> L130
        if ((r122 instanceof Boolean) == true) goto L107;
        r122 = null;
    L107:
        r113 = (Boolean) r122;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r123 = Long.valueOf(((Number) r112).longValue());     // Catch: Throwable -> L130
        if ((r123 instanceof Boolean) == true) goto L113;
        r123 = null;
    L113:
        r113 = (Boolean) r123;     // Catch: Throwable -> L130
    L115:
        if ((r112 instanceof JSONObject) == false) goto L117;
    L184:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L123
        Object r124 = SDKSettingsCacheManager.a().fromJson(r112.toString(), Boolean.class);     // Catch: Throwable -> L123
        if ((r124 instanceof Boolean) == true) goto L121;
        r124 = null;
    L121:
        Object r125 = Result.m9449constructorimpl((Boolean) r124);     // Catch: Throwable -> L123
    L125:
        r113 = r125;
        if (Result.m9455isFailureimpl(r113) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L130
        r125 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r112 instanceof JSONArray) == false) goto L127;
    L84:
        r119 = r112;
    L156:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L166
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
        Throwable r128 = Result.m9452exceptionOrNullimpl(r118);     // Catch: Throwable -> L166
        if (r128 == null) goto L161;
        EnsureManager.ensureNotReachHere(r128);     // Catch: Throwable -> L166
    L161:
        if (Result.m9455isFailureimpl(r118) == false) goto L163;
        r118 = r101;
    L130:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L156
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L176:
        return ((Boolean) r109).booleanValue();
    L9:
        if ((r105 instanceof Boolean) == true) goto L11;
        Object r130 = null;
    L12:
        r106 = (Boolean) r130;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r131 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r131 instanceof Boolean) == true) goto L22;
        r131 = null;
    L22:
        r106 = (Boolean) r131;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r132 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r132 instanceof Boolean) == true) goto L28;
        r132 = null;
    L28:
        r106 = (Boolean) r132;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r133 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        if ((r133 instanceof Boolean) == true) goto L34;
        r133 = null;
    L34:
        r106 = (Boolean) r133;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r134 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r134 instanceof Boolean) == true) goto L40;
        r134 = null;
    L40:
        r106 = (Boolean) r134;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L181:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r135 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Boolean.class);     // Catch: Throwable -> L50
        if ((r135 instanceof Boolean) == true) goto L48;
        r135 = null;
    L48:
        Object r136 = Result.m9449constructorimpl((Boolean) r135);     // Catch: Throwable -> L50
    L52:
        r106 = r136;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r137 = Result.Companion;     // Catch: Throwable -> L57
        r136 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L11:
        r130 = r105;
    L57:
        th = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L166
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        Object r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r141 = Result.m9452exceptionOrNullimpl(r140);
        if (r141 == null) goto L171;
        EnsureManager.ensureNotReachHere(r141);
    L171:
        if (Result.m9455isFailureimpl(r140) == true) goto L174;
        r101 = r140;
    L174:
        r109 = r101;
        goto L176
    }

    @SettingPanel("fix：首卡接口下发inner_flow_page_style为null时，内流页不可交互")
    public static final boolean e() {
        int r100 = n.f45241a;
        Object r101 = Boolean.TRUE;
        int r102 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L166
        Object r104 = null;
        Object r105 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_inflow_untouchable_without_page_style_fix");     // Catch: Throwable -> L57
        if (r105 != null) goto L9;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L166
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L166
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof Boolean) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (Boolean) r107;     // Catch: Throwable -> L166
        if (r109 != null) goto L75;
        Object r110 = com.bytedance.android.ec.base.settings.d.f42816a.get("ec_inflow_untouchable_without_page_style_fix");     // Catch: Throwable -> L166
        if ((r110 instanceof Boolean) == true) goto L74;
        r110 = null;
    L74:
        r109 = (Boolean) r110;     // Catch: Throwable -> L166
    L75:
        if (r109 != null) goto L176;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L166
        Object r112 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_inflow_untouchable_without_page_style_fix");     // Catch: Throwable -> L130
        if (r112 != null) goto L82;
    L127:
        Object r113 = null;
    L128:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L130
    L132:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L156
        if (r115 == null) goto L136;
        EnsureManager.ensureNotReachHere(r115);     // Catch: Throwable -> L156
    L136:
        if (Result.m9455isFailureimpl(r114) == false) goto L139;
        r114 = null;
    L139:
        if ((r114 instanceof Boolean) == true) goto L141;
        r114 = null;
    L141:
        r109 = (Boolean) r114;     // Catch: Throwable -> L156
        if (r109 != null) goto L164;
        IHybridHostService r116 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r116 == null) goto L147;
        Object r117 = r116.getHostABValue("ec_inflow_untouchable_without_page_style_fix", r101);     // Catch: Throwable -> L156
    L148:
        if (r117 != null) goto L150;
    L155:
        r109 = r101;
        goto L164
    L150:
        if ((r117 instanceof Boolean) == false) goto L153;
        r104 = r117;
    L153:
        Object r118 = (Boolean) r104;     // Catch: Throwable -> L156
        if (r118 == null) goto L155;
    L163:
        r109 = r118;
        goto L164
    L147:
        r117 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d("ec_inflow_untouchable_without_page_style_fix", r109);     // Catch: Throwable -> L166
        goto L176
    L82:
        if ((r112 instanceof Boolean) == true) goto L84;
        Object r119 = null;
    L85:
        r113 = (Boolean) r119;     // Catch: Throwable -> L130
        if (r113 != null) goto L128;
        if ((r112 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r120 = Float.valueOf(((Number) r112).floatValue());     // Catch: Throwable -> L130
        if ((r120 instanceof Boolean) == true) goto L95;
        r120 = null;
    L95:
        r113 = (Boolean) r120;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r121 = Double.valueOf(((Number) r112).doubleValue());     // Catch: Throwable -> L130
        if ((r121 instanceof Boolean) == true) goto L101;
        r121 = null;
    L101:
        r113 = (Boolean) r121;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r122 = Integer.valueOf(((Number) r112).intValue());     // Catch: Throwable -> L130
        if ((r122 instanceof Boolean) == true) goto L107;
        r122 = null;
    L107:
        r113 = (Boolean) r122;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r123 = Long.valueOf(((Number) r112).longValue());     // Catch: Throwable -> L130
        if ((r123 instanceof Boolean) == true) goto L113;
        r123 = null;
    L113:
        r113 = (Boolean) r123;     // Catch: Throwable -> L130
    L115:
        if ((r112 instanceof JSONObject) == false) goto L117;
    L184:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L123
        Object r124 = SDKSettingsCacheManager.a().fromJson(r112.toString(), Boolean.class);     // Catch: Throwable -> L123
        if ((r124 instanceof Boolean) == true) goto L121;
        r124 = null;
    L121:
        Object r125 = Result.m9449constructorimpl((Boolean) r124);     // Catch: Throwable -> L123
    L125:
        r113 = r125;
        if (Result.m9455isFailureimpl(r113) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L130
        r125 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r112 instanceof JSONArray) == false) goto L127;
    L84:
        r119 = r112;
    L156:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L166
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
        Throwable r128 = Result.m9452exceptionOrNullimpl(r118);     // Catch: Throwable -> L166
        if (r128 == null) goto L161;
        EnsureManager.ensureNotReachHere(r128);     // Catch: Throwable -> L166
    L161:
        if (Result.m9455isFailureimpl(r118) == false) goto L163;
        r118 = r101;
    L130:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L156
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L176:
        return ((Boolean) r109).booleanValue();
    L9:
        if ((r105 instanceof Boolean) == true) goto L11;
        Object r130 = null;
    L12:
        r106 = (Boolean) r130;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r131 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r131 instanceof Boolean) == true) goto L22;
        r131 = null;
    L22:
        r106 = (Boolean) r131;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r132 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r132 instanceof Boolean) == true) goto L28;
        r132 = null;
    L28:
        r106 = (Boolean) r132;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r133 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        if ((r133 instanceof Boolean) == true) goto L34;
        r133 = null;
    L34:
        r106 = (Boolean) r133;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r134 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r134 instanceof Boolean) == true) goto L40;
        r134 = null;
    L40:
        r106 = (Boolean) r134;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L181:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r135 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Boolean.class);     // Catch: Throwable -> L50
        if ((r135 instanceof Boolean) == true) goto L48;
        r135 = null;
    L48:
        Object r136 = Result.m9449constructorimpl((Boolean) r135);     // Catch: Throwable -> L50
    L52:
        r106 = r136;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r137 = Result.Companion;     // Catch: Throwable -> L57
        r136 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L11:
        r130 = r105;
    L57:
        th = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L166
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        Object r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r141 = Result.m9452exceptionOrNullimpl(r140);
        if (r141 == null) goto L171;
        EnsureManager.ensureNotReachHere(r141);
    L171:
        if (Result.m9455isFailureimpl(r140) == true) goto L174;
        r101 = r140;
    L174:
        r109 = r101;
        goto L176
    }

    @SettingPanel("会员购立即入会问题修复")
    public static final boolean f() {
        int r100 = n.f45241a;
        Object r101 = Boolean.TRUE;
        int r102 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L166
        Object r104 = null;
        Object r105 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_inner_flow_member_ship_enter_meeting");     // Catch: Throwable -> L57
        if (r105 != null) goto L9;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L166
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L166
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof Boolean) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (Boolean) r107;     // Catch: Throwable -> L166
        if (r109 != null) goto L75;
        Object r110 = com.bytedance.android.ec.base.settings.d.f42816a.get("ec_inner_flow_member_ship_enter_meeting");     // Catch: Throwable -> L166
        if ((r110 instanceof Boolean) == true) goto L74;
        r110 = null;
    L74:
        r109 = (Boolean) r110;     // Catch: Throwable -> L166
    L75:
        if (r109 != null) goto L176;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L166
        Object r112 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_inner_flow_member_ship_enter_meeting");     // Catch: Throwable -> L130
        if (r112 != null) goto L82;
    L127:
        Object r113 = null;
    L128:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L130
    L132:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L156
        if (r115 == null) goto L136;
        EnsureManager.ensureNotReachHere(r115);     // Catch: Throwable -> L156
    L136:
        if (Result.m9455isFailureimpl(r114) == false) goto L139;
        r114 = null;
    L139:
        if ((r114 instanceof Boolean) == true) goto L141;
        r114 = null;
    L141:
        r109 = (Boolean) r114;     // Catch: Throwable -> L156
        if (r109 != null) goto L164;
        IHybridHostService r116 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r116 == null) goto L147;
        Object r117 = r116.getHostABValue("ec_inner_flow_member_ship_enter_meeting", r101);     // Catch: Throwable -> L156
    L148:
        if (r117 != null) goto L150;
    L155:
        r109 = r101;
        goto L164
    L150:
        if ((r117 instanceof Boolean) == false) goto L153;
        r104 = r117;
    L153:
        Object r118 = (Boolean) r104;     // Catch: Throwable -> L156
        if (r118 == null) goto L155;
    L163:
        r109 = r118;
        goto L164
    L147:
        r117 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d("ec_inner_flow_member_ship_enter_meeting", r109);     // Catch: Throwable -> L166
        goto L176
    L82:
        if ((r112 instanceof Boolean) == true) goto L84;
        Object r119 = null;
    L85:
        r113 = (Boolean) r119;     // Catch: Throwable -> L130
        if (r113 != null) goto L128;
        if ((r112 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r120 = Float.valueOf(((Number) r112).floatValue());     // Catch: Throwable -> L130
        if ((r120 instanceof Boolean) == true) goto L95;
        r120 = null;
    L95:
        r113 = (Boolean) r120;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r121 = Double.valueOf(((Number) r112).doubleValue());     // Catch: Throwable -> L130
        if ((r121 instanceof Boolean) == true) goto L101;
        r121 = null;
    L101:
        r113 = (Boolean) r121;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r122 = Integer.valueOf(((Number) r112).intValue());     // Catch: Throwable -> L130
        if ((r122 instanceof Boolean) == true) goto L107;
        r122 = null;
    L107:
        r113 = (Boolean) r122;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r123 = Long.valueOf(((Number) r112).longValue());     // Catch: Throwable -> L130
        if ((r123 instanceof Boolean) == true) goto L113;
        r123 = null;
    L113:
        r113 = (Boolean) r123;     // Catch: Throwable -> L130
    L115:
        if ((r112 instanceof JSONObject) == false) goto L117;
    L184:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L123
        Object r124 = SDKSettingsCacheManager.a().fromJson(r112.toString(), Boolean.class);     // Catch: Throwable -> L123
        if ((r124 instanceof Boolean) == true) goto L121;
        r124 = null;
    L121:
        Object r125 = Result.m9449constructorimpl((Boolean) r124);     // Catch: Throwable -> L123
    L125:
        r113 = r125;
        if (Result.m9455isFailureimpl(r113) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L130
        r125 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r112 instanceof JSONArray) == false) goto L127;
    L84:
        r119 = r112;
    L156:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L166
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
        Throwable r128 = Result.m9452exceptionOrNullimpl(r118);     // Catch: Throwable -> L166
        if (r128 == null) goto L161;
        EnsureManager.ensureNotReachHere(r128);     // Catch: Throwable -> L166
    L161:
        if (Result.m9455isFailureimpl(r118) == false) goto L163;
        r118 = r101;
    L130:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L156
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L176:
        return ((Boolean) r109).booleanValue();
    L9:
        if ((r105 instanceof Boolean) == true) goto L11;
        Object r130 = null;
    L12:
        r106 = (Boolean) r130;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r131 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r131 instanceof Boolean) == true) goto L22;
        r131 = null;
    L22:
        r106 = (Boolean) r131;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r132 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r132 instanceof Boolean) == true) goto L28;
        r132 = null;
    L28:
        r106 = (Boolean) r132;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r133 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        if ((r133 instanceof Boolean) == true) goto L34;
        r133 = null;
    L34:
        r106 = (Boolean) r133;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r134 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r134 instanceof Boolean) == true) goto L40;
        r134 = null;
    L40:
        r106 = (Boolean) r134;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L181:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r135 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Boolean.class);     // Catch: Throwable -> L50
        if ((r135 instanceof Boolean) == true) goto L48;
        r135 = null;
    L48:
        Object r136 = Result.m9449constructorimpl((Boolean) r135);     // Catch: Throwable -> L50
    L52:
        r106 = r136;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r137 = Result.Companion;     // Catch: Throwable -> L57
        r136 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L11:
        r130 = r105;
    L57:
        th = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L166
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        Object r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r141 = Result.m9452exceptionOrNullimpl(r140);
        if (r141 == null) goto L171;
        EnsureManager.ensureNotReachHere(r141);
    L171:
        if (Result.m9455isFailureimpl(r140) == true) goto L174;
        r101 = r140;
    L174:
        r109 = r101;
        goto L176
    }

    @SettingPanel("内流页价格区域UI升级，客户端兜底开关")
    public static final boolean g() {
        int r100 = n.f45241a;
        Object r101 = Boolean.TRUE;
        int r102 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L166
        Object r104 = null;
        Object r105 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_inflow_price_update_new");     // Catch: Throwable -> L57
        if (r105 != null) goto L9;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L166
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L166
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof Boolean) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (Boolean) r107;     // Catch: Throwable -> L166
        if (r109 != null) goto L75;
        Object r110 = com.bytedance.android.ec.base.settings.d.f42816a.get("ec_inflow_price_update_new");     // Catch: Throwable -> L166
        if ((r110 instanceof Boolean) == true) goto L74;
        r110 = null;
    L74:
        r109 = (Boolean) r110;     // Catch: Throwable -> L166
    L75:
        if (r109 != null) goto L176;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L166
        Object r112 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_inflow_price_update_new");     // Catch: Throwable -> L130
        if (r112 != null) goto L82;
    L127:
        Object r113 = null;
    L128:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L130
    L132:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L156
        if (r115 == null) goto L136;
        EnsureManager.ensureNotReachHere(r115);     // Catch: Throwable -> L156
    L136:
        if (Result.m9455isFailureimpl(r114) == false) goto L139;
        r114 = null;
    L139:
        if ((r114 instanceof Boolean) == true) goto L141;
        r114 = null;
    L141:
        r109 = (Boolean) r114;     // Catch: Throwable -> L156
        if (r109 != null) goto L164;
        IHybridHostService r116 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r116 == null) goto L147;
        Object r117 = r116.getHostABValue("ec_inflow_price_update_new", r101);     // Catch: Throwable -> L156
    L148:
        if (r117 != null) goto L150;
    L155:
        r109 = r101;
        goto L164
    L150:
        if ((r117 instanceof Boolean) == false) goto L153;
        r104 = r117;
    L153:
        Object r118 = (Boolean) r104;     // Catch: Throwable -> L156
        if (r118 == null) goto L155;
    L163:
        r109 = r118;
        goto L164
    L147:
        r117 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d("ec_inflow_price_update_new", r109);     // Catch: Throwable -> L166
        goto L176
    L82:
        if ((r112 instanceof Boolean) == true) goto L84;
        Object r119 = null;
    L85:
        r113 = (Boolean) r119;     // Catch: Throwable -> L130
        if (r113 != null) goto L128;
        if ((r112 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r120 = Float.valueOf(((Number) r112).floatValue());     // Catch: Throwable -> L130
        if ((r120 instanceof Boolean) == true) goto L95;
        r120 = null;
    L95:
        r113 = (Boolean) r120;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r121 = Double.valueOf(((Number) r112).doubleValue());     // Catch: Throwable -> L130
        if ((r121 instanceof Boolean) == true) goto L101;
        r121 = null;
    L101:
        r113 = (Boolean) r121;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r122 = Integer.valueOf(((Number) r112).intValue());     // Catch: Throwable -> L130
        if ((r122 instanceof Boolean) == true) goto L107;
        r122 = null;
    L107:
        r113 = (Boolean) r122;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r123 = Long.valueOf(((Number) r112).longValue());     // Catch: Throwable -> L130
        if ((r123 instanceof Boolean) == true) goto L113;
        r123 = null;
    L113:
        r113 = (Boolean) r123;     // Catch: Throwable -> L130
    L115:
        if ((r112 instanceof JSONObject) == false) goto L117;
    L184:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L123
        Object r124 = SDKSettingsCacheManager.a().fromJson(r112.toString(), Boolean.class);     // Catch: Throwable -> L123
        if ((r124 instanceof Boolean) == true) goto L121;
        r124 = null;
    L121:
        Object r125 = Result.m9449constructorimpl((Boolean) r124);     // Catch: Throwable -> L123
    L125:
        r113 = r125;
        if (Result.m9455isFailureimpl(r113) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L130
        r125 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r112 instanceof JSONArray) == false) goto L127;
    L84:
        r119 = r112;
    L156:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L166
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
        Throwable r128 = Result.m9452exceptionOrNullimpl(r118);     // Catch: Throwable -> L166
        if (r128 == null) goto L161;
        EnsureManager.ensureNotReachHere(r128);     // Catch: Throwable -> L166
    L161:
        if (Result.m9455isFailureimpl(r118) == false) goto L163;
        r118 = r101;
    L130:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L156
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L176:
        return ((Boolean) r109).booleanValue();
    L9:
        if ((r105 instanceof Boolean) == true) goto L11;
        Object r130 = null;
    L12:
        r106 = (Boolean) r130;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r131 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r131 instanceof Boolean) == true) goto L22;
        r131 = null;
    L22:
        r106 = (Boolean) r131;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r132 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r132 instanceof Boolean) == true) goto L28;
        r132 = null;
    L28:
        r106 = (Boolean) r132;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r133 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        if ((r133 instanceof Boolean) == true) goto L34;
        r133 = null;
    L34:
        r106 = (Boolean) r133;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r134 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r134 instanceof Boolean) == true) goto L40;
        r134 = null;
    L40:
        r106 = (Boolean) r134;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L181:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r135 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Boolean.class);     // Catch: Throwable -> L50
        if ((r135 instanceof Boolean) == true) goto L48;
        r135 = null;
    L48:
        Object r136 = Result.m9449constructorimpl((Boolean) r135);     // Catch: Throwable -> L50
    L52:
        r106 = r136;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r137 = Result.Companion;     // Catch: Throwable -> L57
        r136 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L11:
        r130 = r105;
    L57:
        th = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L166
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        Object r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r141 = Result.m9452exceptionOrNullimpl(r140);
        if (r141 == null) goto L171;
        EnsureManager.ensureNotReachHere(r141);
    L171:
        if (Result.m9455isFailureimpl(r140) == true) goto L174;
        r101 = r140;
    L174:
        r109 = r101;
        goto L176
    }

    @SettingPanel("新大字内流页")
    public static final boolean h() {
        int r100 = n.f45241a;
        Object r101 = Boolean.FALSE;
        int r102 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L166
        Object r104 = null;
        Object r105 = com.bytedance.android.ec.base.settings.d.f42818c.get("iesec_goods_feed_big_font");     // Catch: Throwable -> L57
        if (r105 != null) goto L9;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L166
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L166
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof Boolean) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (Boolean) r107;     // Catch: Throwable -> L166
        if (r109 != null) goto L75;
        Object r110 = com.bytedance.android.ec.base.settings.d.f42816a.get("iesec_goods_feed_big_font");     // Catch: Throwable -> L166
        if ((r110 instanceof Boolean) == true) goto L74;
        r110 = null;
    L74:
        r109 = (Boolean) r110;     // Catch: Throwable -> L166
    L75:
        if (r109 != null) goto L176;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L166
        Object r112 = com.bytedance.android.ec.base.settings.d.f42818c.get("iesec_goods_feed_big_font");     // Catch: Throwable -> L130
        if (r112 != null) goto L82;
    L127:
        Object r113 = null;
    L128:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L130
    L132:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L156
        if (r115 == null) goto L136;
        EnsureManager.ensureNotReachHere(r115);     // Catch: Throwable -> L156
    L136:
        if (Result.m9455isFailureimpl(r114) == false) goto L139;
        r114 = null;
    L139:
        if ((r114 instanceof Boolean) == true) goto L141;
        r114 = null;
    L141:
        r109 = (Boolean) r114;     // Catch: Throwable -> L156
        if (r109 != null) goto L164;
        IHybridHostService r116 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r116 == null) goto L147;
        Object r117 = r116.getHostABValue("iesec_goods_feed_big_font", r101);     // Catch: Throwable -> L156
    L148:
        if (r117 != null) goto L150;
    L155:
        r109 = r101;
        goto L164
    L150:
        if ((r117 instanceof Boolean) == false) goto L153;
        r104 = r117;
    L153:
        Object r118 = (Boolean) r104;     // Catch: Throwable -> L156
        if (r118 == null) goto L155;
    L163:
        r109 = r118;
        goto L164
    L147:
        r117 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d("iesec_goods_feed_big_font", r109);     // Catch: Throwable -> L166
        goto L176
    L82:
        if ((r112 instanceof Boolean) == true) goto L84;
        Object r119 = null;
    L85:
        r113 = (Boolean) r119;     // Catch: Throwable -> L130
        if (r113 != null) goto L128;
        if ((r112 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r120 = Float.valueOf(((Number) r112).floatValue());     // Catch: Throwable -> L130
        if ((r120 instanceof Boolean) == true) goto L95;
        r120 = null;
    L95:
        r113 = (Boolean) r120;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r121 = Double.valueOf(((Number) r112).doubleValue());     // Catch: Throwable -> L130
        if ((r121 instanceof Boolean) == true) goto L101;
        r121 = null;
    L101:
        r113 = (Boolean) r121;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r122 = Integer.valueOf(((Number) r112).intValue());     // Catch: Throwable -> L130
        if ((r122 instanceof Boolean) == true) goto L107;
        r122 = null;
    L107:
        r113 = (Boolean) r122;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r123 = Long.valueOf(((Number) r112).longValue());     // Catch: Throwable -> L130
        if ((r123 instanceof Boolean) == true) goto L113;
        r123 = null;
    L113:
        r113 = (Boolean) r123;     // Catch: Throwable -> L130
    L115:
        if ((r112 instanceof JSONObject) == false) goto L117;
    L184:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L123
        Object r124 = SDKSettingsCacheManager.a().fromJson(r112.toString(), Boolean.class);     // Catch: Throwable -> L123
        if ((r124 instanceof Boolean) == true) goto L121;
        r124 = null;
    L121:
        Object r125 = Result.m9449constructorimpl((Boolean) r124);     // Catch: Throwable -> L123
    L125:
        r113 = r125;
        if (Result.m9455isFailureimpl(r113) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L130
        r125 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r112 instanceof JSONArray) == false) goto L127;
    L84:
        r119 = r112;
    L156:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L166
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
        Throwable r128 = Result.m9452exceptionOrNullimpl(r118);     // Catch: Throwable -> L166
        if (r128 == null) goto L161;
        EnsureManager.ensureNotReachHere(r128);     // Catch: Throwable -> L166
    L161:
        if (Result.m9455isFailureimpl(r118) == false) goto L163;
        r118 = r101;
    L130:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L156
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L176:
        return ((Boolean) r109).booleanValue();
    L9:
        if ((r105 instanceof Boolean) == true) goto L11;
        Object r130 = null;
    L12:
        r106 = (Boolean) r130;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r131 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r131 instanceof Boolean) == true) goto L22;
        r131 = null;
    L22:
        r106 = (Boolean) r131;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r132 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r132 instanceof Boolean) == true) goto L28;
        r132 = null;
    L28:
        r106 = (Boolean) r132;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r133 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        if ((r133 instanceof Boolean) == true) goto L34;
        r133 = null;
    L34:
        r106 = (Boolean) r133;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r134 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r134 instanceof Boolean) == true) goto L40;
        r134 = null;
    L40:
        r106 = (Boolean) r134;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L181:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r135 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Boolean.class);     // Catch: Throwable -> L50
        if ((r135 instanceof Boolean) == true) goto L48;
        r135 = null;
    L48:
        Object r136 = Result.m9449constructorimpl((Boolean) r135);     // Catch: Throwable -> L50
    L52:
        r106 = r136;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r137 = Result.Companion;     // Catch: Throwable -> L57
        r136 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L11:
        r130 = r105;
    L57:
        th = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L166
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        Object r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r141 = Result.m9452exceptionOrNullimpl(r140);
        if (r141 == null) goto L171;
        EnsureManager.ensureNotReachHere(r141);
    L171:
        if (Result.m9455isFailureimpl(r140) == true) goto L174;
        r101 = r140;
    L174:
        r109 = r101;
        goto L176
    }

    @SettingPanel("短视频内流跳券页面兜底开关")
    public static final boolean i() {
        int r100 = n.f45241a;
        Object r101 = Boolean.TRUE;
        int r102 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L166
        Object r104 = null;
        Object r105 = com.bytedance.android.ec.base.settings.d.f42818c.get("iesec_inflow_benefit_jump_coupon_page");     // Catch: Throwable -> L57
        if (r105 != null) goto L9;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L166
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L166
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof Boolean) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (Boolean) r107;     // Catch: Throwable -> L166
        if (r109 != null) goto L75;
        Object r110 = com.bytedance.android.ec.base.settings.d.f42816a.get("iesec_inflow_benefit_jump_coupon_page");     // Catch: Throwable -> L166
        if ((r110 instanceof Boolean) == true) goto L74;
        r110 = null;
    L74:
        r109 = (Boolean) r110;     // Catch: Throwable -> L166
    L75:
        if (r109 != null) goto L176;
        int r111 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L166
        Object r112 = com.bytedance.android.ec.base.settings.d.f42818c.get("iesec_inflow_benefit_jump_coupon_page");     // Catch: Throwable -> L130
        if (r112 != null) goto L82;
    L127:
        Object r113 = null;
    L128:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L130
    L132:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L156
        if (r115 == null) goto L136;
        EnsureManager.ensureNotReachHere(r115);     // Catch: Throwable -> L156
    L136:
        if (Result.m9455isFailureimpl(r114) == false) goto L139;
        r114 = null;
    L139:
        if ((r114 instanceof Boolean) == true) goto L141;
        r114 = null;
    L141:
        r109 = (Boolean) r114;     // Catch: Throwable -> L156
        if (r109 != null) goto L164;
        IHybridHostService r116 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r116 == null) goto L147;
        Object r117 = r116.getHostABValue("iesec_inflow_benefit_jump_coupon_page", r101);     // Catch: Throwable -> L156
    L148:
        if (r117 != null) goto L150;
    L155:
        r109 = r101;
        goto L164
    L150:
        if ((r117 instanceof Boolean) == false) goto L153;
        r104 = r117;
    L153:
        Object r118 = (Boolean) r104;     // Catch: Throwable -> L156
        if (r118 == null) goto L155;
    L163:
        r109 = r118;
        goto L164
    L147:
        r117 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d("iesec_inflow_benefit_jump_coupon_page", r109);     // Catch: Throwable -> L166
        goto L176
    L82:
        if ((r112 instanceof Boolean) == true) goto L84;
        Object r119 = null;
    L85:
        r113 = (Boolean) r119;     // Catch: Throwable -> L130
        if (r113 != null) goto L128;
        if ((r112 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r120 = Float.valueOf(((Number) r112).floatValue());     // Catch: Throwable -> L130
        if ((r120 instanceof Boolean) == true) goto L95;
        r120 = null;
    L95:
        r113 = (Boolean) r120;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r121 = Double.valueOf(((Number) r112).doubleValue());     // Catch: Throwable -> L130
        if ((r121 instanceof Boolean) == true) goto L101;
        r121 = null;
    L101:
        r113 = (Boolean) r121;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r122 = Integer.valueOf(((Number) r112).intValue());     // Catch: Throwable -> L130
        if ((r122 instanceof Boolean) == true) goto L107;
        r122 = null;
    L107:
        r113 = (Boolean) r122;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r123 = Long.valueOf(((Number) r112).longValue());     // Catch: Throwable -> L130
        if ((r123 instanceof Boolean) == true) goto L113;
        r123 = null;
    L113:
        r113 = (Boolean) r123;     // Catch: Throwable -> L130
    L115:
        if ((r112 instanceof JSONObject) == false) goto L117;
    L184:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L123
        Object r124 = SDKSettingsCacheManager.a().fromJson(r112.toString(), Boolean.class);     // Catch: Throwable -> L123
        if ((r124 instanceof Boolean) == true) goto L121;
        r124 = null;
    L121:
        Object r125 = Result.m9449constructorimpl((Boolean) r124);     // Catch: Throwable -> L123
    L125:
        r113 = r125;
        if (Result.m9455isFailureimpl(r113) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L130
        r125 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r112 instanceof JSONArray) == false) goto L127;
    L84:
        r119 = r112;
    L156:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L166
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
        Throwable r128 = Result.m9452exceptionOrNullimpl(r118);     // Catch: Throwable -> L166
        if (r128 == null) goto L161;
        EnsureManager.ensureNotReachHere(r128);     // Catch: Throwable -> L166
    L161:
        if (Result.m9455isFailureimpl(r118) == false) goto L163;
        r118 = r101;
    L130:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L156
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L176:
        return ((Boolean) r109).booleanValue();
    L9:
        if ((r105 instanceof Boolean) == true) goto L11;
        Object r130 = null;
    L12:
        r106 = (Boolean) r130;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r131 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r131 instanceof Boolean) == true) goto L22;
        r131 = null;
    L22:
        r106 = (Boolean) r131;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r132 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r132 instanceof Boolean) == true) goto L28;
        r132 = null;
    L28:
        r106 = (Boolean) r132;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r133 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        if ((r133 instanceof Boolean) == true) goto L34;
        r133 = null;
    L34:
        r106 = (Boolean) r133;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r134 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r134 instanceof Boolean) == true) goto L40;
        r134 = null;
    L40:
        r106 = (Boolean) r134;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L181:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r135 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Boolean.class);     // Catch: Throwable -> L50
        if ((r135 instanceof Boolean) == true) goto L48;
        r135 = null;
    L48:
        Object r136 = Result.m9449constructorimpl((Boolean) r135);     // Catch: Throwable -> L50
    L52:
        r106 = r136;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r137 = Result.Companion;     // Catch: Throwable -> L57
        r136 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L11:
        r130 = r105;
    L57:
        th = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L166
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        Object r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r141 = Result.m9452exceptionOrNullimpl(r140);
        if (r141 == null) goto L171;
        EnsureManager.ensureNotReachHere(r141);
    L171:
        if (Result.m9455isFailureimpl(r140) == true) goto L174;
        r101 = r140;
    L174:
        r109 = r101;
        goto L176
    }

    @HostExperimentKey
    public static final int j() {
        int r100 = m.f45240a;
        Object r101 = 0;
        boolean r102 = ECServiceManager.f42805a;
        g r103 = (g) ECServiceManager.c(g.class);
        if (r103 == null) goto L8;
        s83.a r104 = r103.q();
        if (r104 == null) goto L8;
        Object r105 = r104.e("inflow_feed_framework_opt");
        if (r105 == null) goto L8;
    L175:
        return ((Number) r105).intValue();
    L8:
        int r106 = n.f45241a;
        int r107 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L165
        Object r109 = null;
        Object r110 = com.bytedance.android.ec.base.settings.d.f42818c.get("inflow_feed_framework_opt");     // Catch: Throwable -> L60
        if (r110 != null) goto L15;
    L57:
        Object r111 = null;
    L58:
        Object r112 = Result.m9449constructorimpl(r111);     // Catch: Throwable -> L60
    L62:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);     // Catch: Throwable -> L165
        if (r113 == null) goto L66;
        EnsureManager.ensureNotReachHere(r113);     // Catch: Throwable -> L165
    L66:
        if (Result.m9455isFailureimpl(r112) == false) goto L69;
        r112 = null;
    L69:
        if ((r112 instanceof Integer) == true) goto L71;
        r112 = null;
    L71:
        Integer r114 = (Integer) r112;     // Catch: Throwable -> L165
        if (r114 != null) goto L78;
        Object r115 = com.bytedance.android.ec.base.settings.d.f42816a.get("inflow_feed_framework_opt");     // Catch: Throwable -> L165
        if ((r115 instanceof Integer) == true) goto L77;
        r115 = null;
    L77:
        r114 = (Integer) r115;     // Catch: Throwable -> L165
    L78:
        if (r114 == null) goto L80;
        r105 = r114;
        goto L175
    L80:
        int r116 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L165
        Object r117 = com.bytedance.android.ec.base.settings.d.f42818c.get("inflow_feed_framework_opt");     // Catch: Throwable -> L130
        if (r117 != null) goto L85;
    L127:
        Object r118 = null;
    L128:
        Object r119 = Result.m9449constructorimpl(r118);     // Catch: Throwable -> L130
    L132:
        Throwable r120 = Result.m9452exceptionOrNullimpl(r119);     // Catch: Throwable -> L156
        if (r120 == null) goto L136;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L156
    L136:
        if (Result.m9455isFailureimpl(r119) == false) goto L139;
        r119 = null;
    L139:
        if ((r119 instanceof Integer) == true) goto L141;
        r119 = null;
    L141:
        Integer r121 = (Integer) r119;     // Catch: Throwable -> L156
        if (r121 == null) goto L144;
        r105 = r121;
    L163:
        com.bytedance.android.ec.base.settings.d.d("inflow_feed_framework_opt", r105);     // Catch: Throwable -> L165
        goto L175
    L144:
        IHybridHostService r122 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r122 == null) goto L147;
        Object r123 = r122.getHostABValue("inflow_feed_framework_opt", r101);     // Catch: Throwable -> L156
    L148:
        if (r123 != null) goto L150;
    L162:
        r105 = r101;
        goto L163
    L150:
        if ((r123 instanceof Integer) == false) goto L153;
        r109 = r123;
    L153:
        r105 = (Integer) r109;     // Catch: Throwable -> L156
        if (r105 != null) goto L163;
    L147:
        r123 = null;
        goto L148
    L85:
        if ((r117 instanceof Integer) == true) goto L87;
        Object r124 = null;
    L88:
        r118 = (Integer) r124;     // Catch: Throwable -> L130
        if (r118 != null) goto L128;
        if ((r117 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r125 = Float.valueOf(((Number) r117).floatValue());     // Catch: Throwable -> L130
        if ((r125 instanceof Integer) == true) goto L98;
        r125 = null;
    L98:
        r118 = (Integer) r125;     // Catch: Throwable -> L130
        goto L128
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r126 = Double.valueOf(((Number) r117).doubleValue());     // Catch: Throwable -> L130
        if ((r126 instanceof Integer) == true) goto L104;
        r126 = null;
    L104:
        r118 = (Integer) r126;     // Catch: Throwable -> L130
        goto L128
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        r118 = Integer.valueOf(((Number) r117).intValue());     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r127 = Long.valueOf(((Number) r117).longValue());     // Catch: Throwable -> L130
        if ((r127 instanceof Integer) == true) goto L113;
        r127 = null;
    L113:
        r118 = (Integer) r127;     // Catch: Throwable -> L130
    L115:
        if ((r117 instanceof JSONObject) == false) goto L117;
    L183:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L123
        Object r128 = SDKSettingsCacheManager.a().fromJson(r117.toString(), Integer.class);     // Catch: Throwable -> L123
        if ((r128 instanceof Integer) == true) goto L121;
        r128 = null;
    L121:
        Object r129 = Result.m9449constructorimpl((Integer) r128);     // Catch: Throwable -> L123
    L125:
        r118 = r129;
        if (Result.m9455isFailureimpl(r118) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L130
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r117 instanceof JSONArray) == false) goto L127;
    L87:
        r124 = r117;
    L156:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L165
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
        Throwable r132 = Result.m9452exceptionOrNullimpl(r105);     // Catch: Throwable -> L165
        if (r132 == null) goto L161;
        EnsureManager.ensureNotReachHere(r132);     // Catch: Throwable -> L165
    L161:
        if (Result.m9455isFailureimpl(r105) == false) goto L163;
    L130:
        th = move-exception;
        Result.Companion r133 = Result.Companion;     // Catch: Throwable -> L156
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
        goto L132
    L15:
        if ((r110 instanceof Integer) == true) goto L17;
        Object r134 = null;
    L18:
        r111 = (Integer) r134;     // Catch: Throwable -> L60
        if (r111 != null) goto L58;
        if ((r110 instanceof Number) == false) goto L45;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L30;
        Float r135 = Float.valueOf(((Number) r110).floatValue());     // Catch: Throwable -> L60
        if ((r135 instanceof Integer) == true) goto L28;
        r135 = null;
    L28:
        r111 = (Integer) r135;     // Catch: Throwable -> L60
        goto L58
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L36;
        Double r136 = Double.valueOf(((Number) r110).doubleValue());     // Catch: Throwable -> L60
        if ((r136 instanceof Integer) == true) goto L34;
        r136 = null;
    L34:
        r111 = (Integer) r136;     // Catch: Throwable -> L60
        goto L58
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L39;
        r111 = Integer.valueOf(((Number) r110).intValue());     // Catch: Throwable -> L60
        goto L58
    L39:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L45;
        Long r137 = Long.valueOf(((Number) r110).longValue());     // Catch: Throwable -> L60
        if ((r137 instanceof Integer) == true) goto L43;
        r137 = null;
    L43:
        r111 = (Integer) r137;     // Catch: Throwable -> L60
    L45:
        if ((r110 instanceof JSONObject) == false) goto L47;
    L181:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L53
        Object r138 = SDKSettingsCacheManager.a().fromJson(r110.toString(), Integer.class);     // Catch: Throwable -> L53
        if ((r138 instanceof Integer) == true) goto L51;
        r138 = null;
    L51:
        Object r139 = Result.m9449constructorimpl((Integer) r138);     // Catch: Throwable -> L53
    L55:
        r111 = r139;
        if (Result.m9455isFailureimpl(r111) == false) goto L58;
    L53:
        th = move-exception;
        Result.Companion r140 = Result.Companion;     // Catch: Throwable -> L60
        r139 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L60
        goto L55
    L47:
        if ((r110 instanceof JSONArray) == false) goto L57;
    L17:
        r134 = r110;
    L60:
        th = move-exception;
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L165
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
    L165:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        Object r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r144 = Result.m9452exceptionOrNullimpl(r143);
        if (r144 == null) goto L170;
        EnsureManager.ensureNotReachHere(r144);
    L170:
        if (Result.m9455isFailureimpl(r143) == true) goto L173;
        r101 = r143;
    L173:
        r105 = r101;
        goto L175
    }

    @HostExperimentKey
    public static final int k() {
        int r100 = m.f45240a;
        Object r101 = 0;
        boolean r102 = ECServiceManager.f42805a;
        g r103 = (g) ECServiceManager.c(g.class);
        if (r103 == null) goto L8;
        s83.a r104 = r103.q();
        if (r104 == null) goto L8;
        Object r105 = r104.e("ec_internal_feed_lightning");
        if (r105 == null) goto L8;
    L175:
        return ((Number) r105).intValue();
    L8:
        int r106 = n.f45241a;
        int r107 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L165
        Object r109 = null;
        Object r110 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_internal_feed_lightning");     // Catch: Throwable -> L60
        if (r110 != null) goto L15;
    L57:
        Object r111 = null;
    L58:
        Object r112 = Result.m9449constructorimpl(r111);     // Catch: Throwable -> L60
    L62:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);     // Catch: Throwable -> L165
        if (r113 == null) goto L66;
        EnsureManager.ensureNotReachHere(r113);     // Catch: Throwable -> L165
    L66:
        if (Result.m9455isFailureimpl(r112) == false) goto L69;
        r112 = null;
    L69:
        if ((r112 instanceof Integer) == true) goto L71;
        r112 = null;
    L71:
        Integer r114 = (Integer) r112;     // Catch: Throwable -> L165
        if (r114 != null) goto L78;
        Object r115 = com.bytedance.android.ec.base.settings.d.f42816a.get("ec_internal_feed_lightning");     // Catch: Throwable -> L165
        if ((r115 instanceof Integer) == true) goto L77;
        r115 = null;
    L77:
        r114 = (Integer) r115;     // Catch: Throwable -> L165
    L78:
        if (r114 == null) goto L80;
        r105 = r114;
        goto L175
    L80:
        int r116 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L165
        Object r117 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_internal_feed_lightning");     // Catch: Throwable -> L130
        if (r117 != null) goto L85;
    L127:
        Object r118 = null;
    L128:
        Object r119 = Result.m9449constructorimpl(r118);     // Catch: Throwable -> L130
    L132:
        Throwable r120 = Result.m9452exceptionOrNullimpl(r119);     // Catch: Throwable -> L156
        if (r120 == null) goto L136;
        EnsureManager.ensureNotReachHere(r120);     // Catch: Throwable -> L156
    L136:
        if (Result.m9455isFailureimpl(r119) == false) goto L139;
        r119 = null;
    L139:
        if ((r119 instanceof Integer) == true) goto L141;
        r119 = null;
    L141:
        Integer r121 = (Integer) r119;     // Catch: Throwable -> L156
        if (r121 == null) goto L144;
        r105 = r121;
    L163:
        com.bytedance.android.ec.base.settings.d.d("ec_internal_feed_lightning", r105);     // Catch: Throwable -> L165
        goto L175
    L144:
        IHybridHostService r122 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r122 == null) goto L147;
        Object r123 = r122.getHostABValue("ec_internal_feed_lightning", r101);     // Catch: Throwable -> L156
    L148:
        if (r123 != null) goto L150;
    L162:
        r105 = r101;
        goto L163
    L150:
        if ((r123 instanceof Integer) == false) goto L153;
        r109 = r123;
    L153:
        r105 = (Integer) r109;     // Catch: Throwable -> L156
        if (r105 != null) goto L163;
    L147:
        r123 = null;
        goto L148
    L85:
        if ((r117 instanceof Integer) == true) goto L87;
        Object r124 = null;
    L88:
        r118 = (Integer) r124;     // Catch: Throwable -> L130
        if (r118 != null) goto L128;
        if ((r117 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r125 = Float.valueOf(((Number) r117).floatValue());     // Catch: Throwable -> L130
        if ((r125 instanceof Integer) == true) goto L98;
        r125 = null;
    L98:
        r118 = (Integer) r125;     // Catch: Throwable -> L130
        goto L128
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r126 = Double.valueOf(((Number) r117).doubleValue());     // Catch: Throwable -> L130
        if ((r126 instanceof Integer) == true) goto L104;
        r126 = null;
    L104:
        r118 = (Integer) r126;     // Catch: Throwable -> L130
        goto L128
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        r118 = Integer.valueOf(((Number) r117).intValue());     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r127 = Long.valueOf(((Number) r117).longValue());     // Catch: Throwable -> L130
        if ((r127 instanceof Integer) == true) goto L113;
        r127 = null;
    L113:
        r118 = (Integer) r127;     // Catch: Throwable -> L130
    L115:
        if ((r117 instanceof JSONObject) == false) goto L117;
    L183:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L123
        Object r128 = SDKSettingsCacheManager.a().fromJson(r117.toString(), Integer.class);     // Catch: Throwable -> L123
        if ((r128 instanceof Integer) == true) goto L121;
        r128 = null;
    L121:
        Object r129 = Result.m9449constructorimpl((Integer) r128);     // Catch: Throwable -> L123
    L125:
        r118 = r129;
        if (Result.m9455isFailureimpl(r118) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L130
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r117 instanceof JSONArray) == false) goto L127;
    L87:
        r124 = r117;
    L156:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L165
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
        Throwable r132 = Result.m9452exceptionOrNullimpl(r105);     // Catch: Throwable -> L165
        if (r132 == null) goto L161;
        EnsureManager.ensureNotReachHere(r132);     // Catch: Throwable -> L165
    L161:
        if (Result.m9455isFailureimpl(r105) == false) goto L163;
    L130:
        th = move-exception;
        Result.Companion r133 = Result.Companion;     // Catch: Throwable -> L156
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
        goto L132
    L15:
        if ((r110 instanceof Integer) == true) goto L17;
        Object r134 = null;
    L18:
        r111 = (Integer) r134;     // Catch: Throwable -> L60
        if (r111 != null) goto L58;
        if ((r110 instanceof Number) == false) goto L45;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L30;
        Float r135 = Float.valueOf(((Number) r110).floatValue());     // Catch: Throwable -> L60
        if ((r135 instanceof Integer) == true) goto L28;
        r135 = null;
    L28:
        r111 = (Integer) r135;     // Catch: Throwable -> L60
        goto L58
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L36;
        Double r136 = Double.valueOf(((Number) r110).doubleValue());     // Catch: Throwable -> L60
        if ((r136 instanceof Integer) == true) goto L34;
        r136 = null;
    L34:
        r111 = (Integer) r136;     // Catch: Throwable -> L60
        goto L58
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L39;
        r111 = Integer.valueOf(((Number) r110).intValue());     // Catch: Throwable -> L60
        goto L58
    L39:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L45;
        Long r137 = Long.valueOf(((Number) r110).longValue());     // Catch: Throwable -> L60
        if ((r137 instanceof Integer) == true) goto L43;
        r137 = null;
    L43:
        r111 = (Integer) r137;     // Catch: Throwable -> L60
    L45:
        if ((r110 instanceof JSONObject) == false) goto L47;
    L181:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L53
        Object r138 = SDKSettingsCacheManager.a().fromJson(r110.toString(), Integer.class);     // Catch: Throwable -> L53
        if ((r138 instanceof Integer) == true) goto L51;
        r138 = null;
    L51:
        Object r139 = Result.m9449constructorimpl((Integer) r138);     // Catch: Throwable -> L53
    L55:
        r111 = r139;
        if (Result.m9455isFailureimpl(r111) == false) goto L58;
    L53:
        th = move-exception;
        Result.Companion r140 = Result.Companion;     // Catch: Throwable -> L60
        r139 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L60
        goto L55
    L47:
        if ((r110 instanceof JSONArray) == false) goto L57;
    L17:
        r134 = r110;
    L60:
        th = move-exception;
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L165
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
    L165:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        Object r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r144 = Result.m9452exceptionOrNullimpl(r143);
        if (r144 == null) goto L170;
        EnsureManager.ensureNotReachHere(r144);
    L170:
        if (Result.m9455isFailureimpl(r143) == true) goto L173;
        r101 = r143;
    L173:
        r105 = r101;
        goto L175
    }

    static {
    }
}
