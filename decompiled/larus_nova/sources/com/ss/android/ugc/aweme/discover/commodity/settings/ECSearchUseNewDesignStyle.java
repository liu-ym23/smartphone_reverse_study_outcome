package com.ss.android.ugc.aweme.discover.commodity.settings;

import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.search.common.ab.ECSearchExperiment;
import com.ss.android.ugc.aweme.search.common.ab.TradeFastSDKSetting;
import com.ss.android.ugc.aweme.search.common.ab.TradeSDKSetting;
import com.ss.android.ugc.aweme.search.common.ab.TradeSDKSettingsCacheManager;
import java.util.Map;
import jj4.a;
import jj4.b;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/settings/ECSearchUseNewDesignStyle;", "", "<init>", "()V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchUseNewDesignStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ECSearchUseNewDesignStyle f450354a = null;

    private ECSearchUseNewDesignStyle() {
    }

    static {
        f450354a = new ECSearchUseNewDesignStyle();
    }

    public static boolean a() {
        Map<String, String> r100 = ECSearchExperiment.f451413a;
        int r101 = TradeFastSDKSetting.f451415a;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L168
        TradeSDKSettingsCacheManager r103 = TradeSDKSettingsCacheManager.f451417a;     // Catch: Throwable -> L168
        Object r104 = null;
        r103.getClass();     // Catch: Throwable -> L57
        Object r105 = TradeSDKSettingsCacheManager.f451419c.get("ecom_search_use_new_design_style");     // Catch: Throwable -> L57
        if (r105 != null) goto L9;
    L54:
        Object r106 = null;
    L55:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L57
    L59:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L168
        if (r108 == null) goto L63;
        EnsureManager.ensureNotReachHere(r108);     // Catch: Throwable -> L168
    L63:
        if (Result.m9455isFailureimpl(r107) == false) goto L66;
        r107 = null;
    L66:
        if ((r107 instanceof String) == true) goto L68;
        r107 = null;
    L68:
        Object r109 = (String) r107;     // Catch: Throwable -> L168
        if (r109 != null) goto L75;
        r103.getClass();     // Catch: Throwable -> L168
        Object r110 = TradeSDKSettingsCacheManager.f451418b.get("ecom_search_use_new_design_style");     // Catch: Throwable -> L168
        if ((r110 instanceof String) == true) goto L74;
        r110 = null;
    L74:
        r109 = (String) r110;     // Catch: Throwable -> L168
    L75:
        if (r109 != null) goto L176;
        int r111 = TradeSDKSetting.f451416a;     // Catch: Throwable -> L168
    L157:
        th = move-exception;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L168
        Object r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L168
    L159:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);     // Catch: Throwable -> L168
        if (r114 == null) goto L163;
        EnsureManager.ensureNotReachHere(r114);     // Catch: Throwable -> L168
    L163:
        if (Result.m9455isFailureimpl(r113) == false) goto L165;
        r109 = "0";
    L166:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L168
        TradeSDKSettingsCacheManager.b("ecom_search_use_new_design_style", r109);     // Catch: Throwable -> L168
    L165:
        r109 = r113;
        goto L166
    L181:
        TradeSDKSettingsCacheManager.f451417a.getClass();     // Catch: Throwable -> L131
        Object r115 = TradeSDKSettingsCacheManager.f451419c.get("ecom_search_use_new_design_style");     // Catch: Throwable -> L131
        if (r115 != null) goto L83;
    L128:
        Object r116 = null;
    L129:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L131
    L133:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L157
        if (r118 == null) goto L137;
        EnsureManager.ensureNotReachHere(r118);     // Catch: Throwable -> L157
    L137:
        if (Result.m9455isFailureimpl(r117) == false) goto L140;
        r117 = null;
    L140:
        if ((r117 instanceof String) == true) goto L142;
        r117 = null;
    L142:
        r113 = (String) r117;     // Catch: Throwable -> L157
        if (r113 != null) goto L165;
        b r119 = b.f499326b;     // Catch: Throwable -> L157
        Object r120 = a.a("ecom_search_use_new_design_style", String.class, "0", false);     // Catch: Throwable -> L157
        if (r120 != null) goto L149;
        Intrinsics.throwNpe();     // Catch: Throwable -> L157
    L149:
        if ((r120 instanceof String) == false) goto L152;
        r104 = r120;
    L152:
        String r121 = (String) r104;     // Catch: Throwable -> L157
        if (r121 != null) goto L155;
        r121 = "0";
    L155:
        r113 = Result.m9449constructorimpl(r121);     // Catch: Throwable -> L157
    L83:
        if ((r115 instanceof String) == true) goto L85;
        Object r122 = null;
    L86:
        r116 = (String) r122;     // Catch: Throwable -> L131
        if (r116 != null) goto L129;
        if ((r115 instanceof Number) == false) goto L116;
        if (String.class != Float.class) goto L98;
        Float r123 = Float.valueOf(((Number) r115).floatValue());     // Catch: Throwable -> L131
        if ((r123 instanceof String) == true) goto L96;
        r123 = null;
    L96:
        r116 = (String) r123;     // Catch: Throwable -> L131
        goto L129
    L98:
        if (String.class != Double.class) goto L104;
        Double r124 = Double.valueOf(((Number) r115).doubleValue());     // Catch: Throwable -> L131
        if ((r124 instanceof String) == true) goto L102;
        r124 = null;
    L102:
        r116 = (String) r124;     // Catch: Throwable -> L131
        goto L129
    L104:
        if (String.class != Integer.class) goto L110;
        Integer r125 = Integer.valueOf(((Number) r115).intValue());     // Catch: Throwable -> L131
        if ((r125 instanceof String) == true) goto L108;
        r125 = null;
    L108:
        r116 = (String) r125;     // Catch: Throwable -> L131
        goto L129
    L110:
        if (String.class != Long.class) goto L116;
        Long r126 = Long.valueOf(((Number) r115).longValue());     // Catch: Throwable -> L131
        if ((r126 instanceof String) == true) goto L114;
        r126 = null;
    L114:
        r116 = (String) r126;     // Catch: Throwable -> L131
    L116:
        if ((r115 instanceof JSONObject) == false) goto L118;
    L187:
        Object r127 = TradeSDKSettingsCacheManager.a().fromJson(r115.toString(), String.class);     // Catch: Throwable -> L124
        if ((r127 instanceof String) == true) goto L122;
        r127 = null;
    L122:
        Object r128 = Result.m9449constructorimpl((String) r127);     // Catch: Throwable -> L124
    L126:
        r116 = r128;
        if (Result.m9455isFailureimpl(r116) == false) goto L129;
    L124:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L131
        r128 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L131
        goto L126
    L118:
        if ((r115 instanceof JSONArray) == false) goto L128;
    L85:
        r122 = r115;
    L131:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L157
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L157
    L176:
        return !"0".equals((String) r109);
    L9:
        if ((r105 instanceof String) == true) goto L11;
        Object r131 = null;
    L12:
        r106 = (String) r131;     // Catch: Throwable -> L57
        if (r106 != null) goto L55;
        if ((r105 instanceof Number) == false) goto L42;
        if (String.class != Float.class) goto L24;
        Float r132 = Float.valueOf(((Number) r105).floatValue());     // Catch: Throwable -> L57
        if ((r132 instanceof String) == true) goto L22;
        r132 = null;
    L22:
        r106 = (String) r132;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (String.class != Double.class) goto L30;
        Double r133 = Double.valueOf(((Number) r105).doubleValue());     // Catch: Throwable -> L57
        if ((r133 instanceof String) == true) goto L28;
        r133 = null;
    L28:
        r106 = (String) r133;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (String.class != Integer.class) goto L36;
        Integer r134 = Integer.valueOf(((Number) r105).intValue());     // Catch: Throwable -> L57
        if ((r134 instanceof String) == true) goto L34;
        r134 = null;
    L34:
        r106 = (String) r134;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (String.class != Long.class) goto L42;
        Long r135 = Long.valueOf(((Number) r105).longValue());     // Catch: Throwable -> L57
        if ((r135 instanceof String) == true) goto L40;
        r135 = null;
    L40:
        r106 = (String) r135;     // Catch: Throwable -> L57
    L42:
        if ((r105 instanceof JSONObject) == false) goto L44;
    L179:
        Object r136 = TradeSDKSettingsCacheManager.a().fromJson(r105.toString(), String.class);     // Catch: Throwable -> L50
        if ((r136 instanceof String) == true) goto L48;
        r136 = null;
    L48:
        Object r137 = Result.m9449constructorimpl((String) r136);     // Catch: Throwable -> L50
    L52:
        r106 = r137;
        if (Result.m9455isFailureimpl(r106) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L57
        r137 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r105 instanceof JSONArray) == false) goto L54;
    L11:
        r131 = r105;
    L57:
        th = move-exception;
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L168
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L168
    L168:
        th = move-exception;
        Result.Companion r140 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r141 = Result.m9452exceptionOrNullimpl(r109);
        if (r141 == null) goto L173;
        EnsureManager.ensureNotReachHere(r141);
    L173:
        if (Result.m9455isFailureimpl(r109) == false) goto L176;
        r109 = "0";
        goto L176
    }
}
