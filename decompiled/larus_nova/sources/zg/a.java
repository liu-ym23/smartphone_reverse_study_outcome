package zg;

import com.bytedance.android.ec.ab.opt.HostExperimentKey;
import com.bytedance.android.ec.ab.opt.OptSetting;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.c;
import com.bytedance.android.ec.base.settings.d;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.services.apm.api.EnsureManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@OptSetting(business = "电商跨端Setting集合")
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f571786a = 0;

    @HostExperimentKey
    public static final int a() {
        int r100 = n.f45241a;
        Object r101 = 0;
        int r102 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L160
        Object r104 = null;
        Object r105 = d.f42818c.get("ab_order_schema_optimize");     // Catch: Throwable -> L54
        if (r105 != null) goto L9;
    L51:
        Object r106 = null;
    L52:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L54
    L56:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L160
        if (r108 == null) goto L60;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L160
    L60:
        if (Result.m9455isFailureimpl(r107) == false) goto L63;
        r107 = null;
    L63:
        if ((r107 instanceof Integer) == true) goto L65;
        r107 = null;
    L65:
        Object r109 = (Integer) r107;     // Catch: Throwable -> L160
        if (r109 != null) goto L72;
        Object r110 = d.f42816a.get("ab_order_schema_optimize");     // Catch: Throwable -> L160
        if ((r110 instanceof Integer) == true) goto L71;
        r110 = null;
    L71:
        r109 = (Integer) r110;     // Catch: Throwable -> L160
    L72:
        if (r109 != null) goto L170;
        int r111 = c.f42815a;     // Catch: Throwable -> L160
        Object r112 = d.f42818c.get("ab_order_schema_optimize");     // Catch: Throwable -> L124
        if (r112 != null) goto L79;
    L121:
        Object r113 = null;
    L122:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L124
    L126:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L150
        if (r115 == null) goto L130;
        EnsureManager.ensureNotReachHere(r115);     // Catch: Throwable -> L150
    L130:
        if (Result.m9455isFailureimpl(r114) == false) goto L133;
        r114 = null;
    L133:
        if ((r114 instanceof Integer) == true) goto L135;
        r114 = null;
    L135:
        r109 = (Integer) r114;     // Catch: Throwable -> L150
        if (r109 != null) goto L158;
        IHybridHostService r116 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L150
        if (r116 == null) goto L141;
        Object r117 = r116.getHostABValue("ab_order_schema_optimize", r101);     // Catch: Throwable -> L150
    L142:
        if (r117 != null) goto L144;
    L149:
        r109 = r101;
        goto L158
    L144:
        if ((r117 instanceof Integer) == false) goto L147;
        r104 = r117;
    L147:
        Object r118 = (Integer) r104;     // Catch: Throwable -> L150
        if (r118 == null) goto L149;
    L157:
        r109 = r118;
        goto L158
    L141:
        r117 = null;
    L158:
        d.d("ab_order_schema_optimize", r109);     // Catch: Throwable -> L160
        goto L170
    L79:
        if ((r112 instanceof Integer) == true) goto L81;
        Object r119 = null;
    L82:
        r113 = (Integer) r119;     // Catch: Throwable -> L124
        if (r113 != null) goto L122;
        if ((r112 instanceof Number) == false) goto L109;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L94;
        Float r120 = Float.valueOf(((Number) r112).floatValue());     // Catch: Throwable -> L124
        if ((r120 instanceof Integer) == true) goto L92;
        r120 = null;
    L92:
        r113 = (Integer) r120;     // Catch: Throwable -> L124
        goto L122
    L94:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L100;
        Double r121 = Double.valueOf(((Number) r112).doubleValue());     // Catch: Throwable -> L124
        if ((r121 instanceof Integer) == true) goto L98;
        r121 = null;
    L98:
        r113 = (Integer) r121;     // Catch: Throwable -> L124
        goto L122
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L103;
        r113 = Integer.valueOf(((Number) r112).intValue());     // Catch: Throwable -> L124
        goto L122
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L109;
        Long r122 = Long.valueOf(((Number) r112).longValue());     // Catch: Throwable -> L124
        if ((r122 instanceof Integer) == true) goto L107;
        r122 = null;
    L107:
        r113 = (Integer) r122;     // Catch: Throwable -> L124
    L109:
        if ((r112 instanceof JSONObject) == false) goto L111;
    L180:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L117
        Object r123 = SDKSettingsCacheManager.a().fromJson(r112.toString(), Integer.class);     // Catch: Throwable -> L117
        if ((r123 instanceof Integer) == true) goto L115;
        r123 = null;
    L115:
        Object r124 = Result.m9449constructorimpl((Integer) r123);     // Catch: Throwable -> L117
    L119:
        r113 = r124;
        if (Result.m9455isFailureimpl(r113) == false) goto L122;
    L117:
        th = move-exception;
        Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L124
        r124 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L124
        goto L119
    L111:
        if ((r112 instanceof JSONArray) == false) goto L121;
    L81:
        r119 = r112;
    L150:
        th = move-exception;
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L160
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
        Throwable r127 = Result.m9452exceptionOrNullimpl(r118);     // Catch: Throwable -> L160
        if (r127 == null) goto L155;
        EnsureManager.ensureNotReachHere(r127);     // Catch: Throwable -> L160
    L155:
        if (Result.m9455isFailureimpl(r118) == false) goto L157;
        r118 = r101;
    L124:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L150
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L150
    L170:
        return ((Number) r109).intValue();
    L9:
        if ((r105 instanceof Integer) == true) goto L11;
        Object r129 = null;
    L12:
        r106 = (Integer) r129;     // Catch: Throwable -> L54
        if (r106 != null) goto L52;
        if ((r105 instanceof Number) == false) goto L39;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r130 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L54
        if ((r130 instanceof Integer) == true) goto L22;
        r130 = null;
    L22:
        r106 = (Integer) r130;     // Catch: Throwable -> L54
        goto L52
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r131 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L54
        if ((r131 instanceof Integer) == true) goto L28;
        r131 = null;
    L28:
        r106 = (Integer) r131;     // Catch: Throwable -> L54
        goto L52
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L33;
        r106 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L54
        goto L52
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L39;
        Long r132 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L54
        if ((r132 instanceof Integer) == true) goto L37;
        r132 = null;
    L37:
        r106 = (Integer) r132;     // Catch: Throwable -> L54
    L39:
        if ((r105 instanceof JSONObject) == false) goto L41;
    L178:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L47
        Object r133 = SDKSettingsCacheManager.a().fromJson(r105.toString(), Integer.class);     // Catch: Throwable -> L47
        if ((r133 instanceof Integer) == true) goto L45;
        r133 = null;
    L45:
        Object r134 = Result.m9449constructorimpl((Integer) r133);     // Catch: Throwable -> L47
    L49:
        r106 = r134;
        if (Result.m9455isFailureimpl(r106) == false) goto L52;
    L47:
        th = move-exception;
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L54
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L54
        goto L49
    L41:
        if ((r105 instanceof JSONArray) == false) goto L51;
    L11:
        r129 = r105;
    L54:
        th = move-exception;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L160
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
    L160:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        Object r138 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r139 = Result.m9452exceptionOrNullimpl(r138);
        if (r139 == null) goto L165;
        EnsureManager.ensureNotReachHere(r139);
    L165:
        if (Result.m9455isFailureimpl(r138) == true) goto L168;
        r101 = r138;
    L168:
        r109 = r101;
        goto L170
    }

    static {
    }
}
