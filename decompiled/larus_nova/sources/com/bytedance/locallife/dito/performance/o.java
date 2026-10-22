package com.bytedance.locallife.dito.performance;

import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import androidx.lifecycle.Observer;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.locallife.dito.Dito;
import com.bytedance.locallife.dito.common.perf.session.DitoPerformanceModule;
import com.bytedance.locallife.dito.core.d0;
import com.bytedance.locallife.dito.core.viewmodel.DitoViewModel;
import com.bytedance.locallife.dito.data.DitoNode;
import com.bytedance.locallife.dito.data.DitoPageInfo;
import com.bytedance.locallife.dito.event.ObserverWrapper;
import com.bytedance.locallife.dito.model.BaseDitoModel;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class o {
    public static final String e(com.bytedance.locallife.dito.data.m r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        DitoNode r100 = r110.f258221a;
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getCustomTag();
    L6:
        boolean r103 = true;
        if (r102 != null) goto L68;
        DitoNode r104 = r110.f258221a;
        if (r104 == null) goto L13;
        Map<String, String> r105 = r104.getTemplate();
        if (r105 == null) goto L13;
        String r106 = r105.get("url");
    L14:
        if (r106 == null) goto L68;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L61
        Uri r108 = UriProtector.parse(r106);     // Catch: Throwable -> L61
        String r109 = UriProtector.getQueryParameter(r108, "channel");     // Catch: Throwable -> L61
        String r111 = UriProtector.getQueryParameter(r108, "bundle");     // Catch: Throwable -> L61
        if (r109 != null) goto L18;
    L21:
        boolean r112 = true;
    L23:
        if (r112 == false) goto L50;
        if (r111 != null) goto L26;
    L29:
        boolean r113 = true;
    L30:
        if (r113 == false) goto L50;
        String r114 = UriProtector.getQueryParameter(r108, "surl");     // Catch: Throwable -> L61
        if (r114 != null) goto L34;
    L37:
        boolean r115 = true;
    L38:
        if (r115 == true) goto L49;
        Uri r116 = UriProtector.parse(r114);     // Catch: Throwable -> L61
        Iterator<String> r117 = r116.getPathSegments().iterator();     // Catch: Throwable -> L61
        int r118 = 0;
    L41:
        if (r117.hasNext() == false) goto L46;
        if (StringsKt.startsWith$default(r117.next(), ThumbGlideUrl.SOURCE_TEMPLATE, false, 2, null) == true) goto L47;
        r118 = r118 + 1;     // Catch: Throwable -> L61
    L47:
        if (r118 < 2) goto L49;
        String r119 = ((String) ListProtector.get(r116.getPathSegments(), r118 - 1)) + '#' + ((String) ListProtector.get(r116.getPathSegments(), r118 - 2));     // Catch: Throwable -> L61
    L51:
        if (r119 != null) goto L53;
    L56:
        boolean r120 = true;
    L57:
        if (r120 == false) goto L59;
        r119 = r110.f258222b;     // Catch: Throwable -> L61
    L59:
        Object r121 = Result.m9449constructorimpl(StringsKt.replace$default(r119, "/template.js", "", false, 4, null));     // Catch: Throwable -> L61
    L63:
        Throwable r122 = Result.m9452exceptionOrNullimpl(r121);
        if (r122 == null) goto L67;
        rq6.a.f538927a.b(DitoPerformanceModule.NAME, "getCustomTag error:" + r122.getMessage());
        r121 = null;
    L67:
        r102 = (String) r121;
        goto L68
    L53:
        if (r119.length() == 0) goto L56;
        r120 = false;
        goto L57
    L46:
        r118 = -1;
    L49:
        r119 = null;
        goto L51
    L34:
        if (r114.length() == 0) goto L37;
        r115 = false;
        goto L38
    L26:
        if (r111.length() == 0) goto L29;
        r113 = false;
    L50:
        r119 = r111 + '#' + r109;     // Catch: Throwable -> L61
        goto L51
    L18:
        if (r109.length() == 0) goto L21;
        r112 = false;
    L61:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r121 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L13:
        r106 = null;
    L68:
        if (r102 != null) goto L90;
        DitoNode r124 = r110.f258221a;
        if (r124 == null) goto L76;
        String r125 = r124.getSubType();
        if (r125 == null) goto L76;
        if (r125.equals("lynx") != true) goto L76;
    L77:
        if (r103 == false) goto L85;
        rq6.a r126 = rq6.a.f538927a;
        StringBuilder r127 = new StringBuilder("=====>lynx card not parse info:");
        DitoNode r128 = r110.f258221a;
        if (r128 == null) goto L83;
        Map<String, String> r129 = r128.getTemplate();
        if (r129 == null) goto L83;
        r101 = r129.get("url");
    L83:
        r127.append(r101);
        r126.b(DitoPerformanceModule.NAME, r127.toString());
    L85:
        return r110.f258222b;
    L76:
        r103 = false;
        goto L77
    L90:
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    public static final String f(BaseDitoModel<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r101 = r100.e("dito_custom_tag");
        if ((r101 instanceof String) == false) goto L5;
        String r102 = (String) r101;
    L6:
        if (r102 != null) goto L9;
        String r103 = e(r100.f258493b);
        r100.i("dito_custom_tag", r103);
        return r103;
    L9:
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    public static JSONObject g(Object r100) {
        Dito r101 = Dito.f257280a;
        Gson r102 = com.bytedance.locallife.dito.utils.l.d();
        Intrinsics.checkNotNullParameter(r102, "gson");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        Object r104 = Result.m9449constructorimpl(tv5.a.a(r102, r100));     // Catch: Throwable -> L5
    L7:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L12;
        rq6.a.f538927a.b(DitoPerformanceModule.NAME, "toJSONObject Error." + r105.getMessage() + ',' + Log.getStackTraceString(r105));
        r104 = null;
    L12:
        return (JSONObject) r104;
    L5:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static final Long a(Long r100, Long r101) {
        if (r101 == null) goto L14;
        r101.longValue();
        if (r100 == null) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L11;
        r101 = null;
    L11:
        if (r101 == null) goto L15;
        long r103 = r101.longValue();
        Intrinsics.checkNotNull(r100);
        return Long.valueOf(r103 - r100.longValue());
    L15:
        return null;
    L7:
        r102 = false;
        goto L8
    L14:
        return null;
    }

    public static final String b(Observer r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        Class<?> r102 = r100.getClass();
        if ((r100 instanceof ObserverWrapper) == false) goto L7;
        return b(((ObserverWrapper) r100).f258280a, r101);
    L7:
        if ((r100 instanceof d0) == false) goto L11;
        return ((d0) r100).getName();
    L11:
        if (r102.isAnonymousClass() == false) goto L57;
        if (r101 == false) goto L57;
        String r103 = null;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L44
        int r105 = 0;
        if (r102.getDeclaredFields().length != 0) goto L17;
        boolean r106 = true;
    L19:
        if ((!r106) == false) goto L38;
        Object r107 = r102.getEnclosingClass();     // Catch: Throwable -> L44
        if (r107 != null) goto L24;
        r107 = r102.getName();     // Catch: Throwable -> L44
    L24:
        Field[] r108 = r102.getDeclaredFields();     // Catch: Throwable -> L44
        int r109 = r108.length;     // Catch: Throwable -> L44
    L25:
        if (r105 >= r109) goto L30;
        Field r110 = r108[r105];     // Catch: Throwable -> L44
        if (r110.getType().equals(r107) == true) goto L31;
        r105 = r105 + 1;     // Catch: Throwable -> L44
    L31:
        if (r110 == null) goto L37;
        r110.setAccessible(true);     // Catch: Throwable -> L44
        Object r111 = r110.get(r100);     // Catch: Throwable -> L44
        if (r111 == null) goto L35;
        String r112 = r111.getClass().getName();     // Catch: Throwable -> L44
    L36:
        if (r112 == null) goto L37;
    L42:
        Object r113 = Result.m9449constructorimpl(r112);     // Catch: Throwable -> L44
    L46:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);
        if (r114 == null) goto L49;
        rq6.a.f538927a.b("DitoDataObserver", "DitoDataObserver getObserverTargetName  error:" + r114.getMessage());
        Class<?> r115 = r102.getEnclosingClass();
        if (r115 == null) goto L53;
        r103 = r115.getName();
    L53:
        if (r103 == null) goto L55;
        return r103;
    L55:
        return r102.getName();
    L49:
        return (String) r113;
    L35:
        r112 = null;
    L37:
        r112 = r102.getEnclosingClass().getName();     // Catch: Throwable -> L44
        goto L42
    L30:
        r110 = null;
        goto L31
    L38:
        Class<?> r116 = r102.getEnclosingClass();     // Catch: Throwable -> L44
        if (r116 == null) goto L41;
        r112 = r116.getName();     // Catch: Throwable -> L44
        goto L42
    L41:
        r112 = r102.getName();     // Catch: Throwable -> L44
        goto L42
    L17:
        r106 = false;
    L44:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L57:
        return r102.getName();
    }

    public static final void d(DitoViewModel r100, Map<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "traceDataMap");
        Dito r102 = Dito.f257280a;
        r r103 = (r) Dito.a().a(r.class);
        if (r103 == null) goto L5;
        r103.Z1(r100, r101);
    L5:
        Bundle r104 = r100.f258035a.getArguments();
        String r105 = null;
        if (r104 == null) goto L8;
        String r106 = r104.getString("dito_pref_extra");
    L9:
        if (r106 == null) goto L17;
        Gson r107 = com.bytedance.locallife.dito.utils.l.d();
        Intrinsics.checkNotNullParameter(r106, "<this>");
        Intrinsics.checkNotNullParameter(r106, "jsonStr");
        Intrinsics.checkNotNullParameter(r107, "gson");
        Object r108 = (Map) r107.fromJson(r106, new m().getType());     // Catch: Exception -> L13
    L15:
        if (r108 == null) goto L17;
        r101.put("dito_extra_params", r108);
    L13:
        e = move-exception;
        rq6.a.f538927a.b(DitoPerformanceModule.NAME, "json string parse error," + r106 + ',' + e.getMessage());
        r108 = new LinkedHashMap();
    L17:
        r101.put("dito_scene", r100.f258038d);
        DitoPageInfo r109 = r100.f258040f;
        if (r109 == null) goto L20;
        String r110 = r109.getBizCode();
    L21:
        r101.put("dito_biz_code", r110);
        DitoPageInfo r111 = r100.f258040f;
        if (r111 == null) goto L24;
        String r112 = r111.getPageKey();
    L25:
        r101.put("dito_page_key", r112);
        DitoPageInfo r113 = r100.f258040f;
        if (r113 == null) goto L28;
        String r114 = r113.getId();
    L29:
        r101.put("dito_page_entity_id", r114);
        String r115 = r100.G.name();
        Locale r116 = Locale.ROOT;
        if (r115 == null) goto L37;
        r101.put("page_stage", r115.toLowerCase(r116));
        DitoPageInfo r117 = r100.f258040f;
        if (r117 == null) goto L34;
        r105 = r117.getSessionId();
    L34:
        r101.put("dito_session_id", r105);
        return;
    L37:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L28:
        r114 = null;
        goto L29
    L24:
        r112 = null;
        goto L25
    L20:
        r110 = null;
        goto L21
    L8:
        r106 = null;
        goto L9
    }

    public static long c(long r100, long r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r101 = System.currentTimeMillis();
    L6:
        if ((r102 & 2) == 0) goto L8;
        long r103 = SystemClock.elapsedRealtime();
    L10:
        return r101 - (r103 - r100);
    L8:
        r103 = 0;
        goto L10
    }
}
