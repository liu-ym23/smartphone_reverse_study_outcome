package com.larus.common.venue.impl.venue;

import com.android.ttcjpaysdk.verify.constants.DyVerifyEventConstants;
import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.ixigua.lib.track.TrackParams;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowCommonVenueDataCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f326477a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Map<String, Object>> f326478b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f326479c = null;

    static {
        f326477a = LazyKt.lazy(new b());
        f326478b = new ConcurrentHashMap();
        f326479c = LazyKt.lazy(new c());
    }

    public static String a(Integer r100) {
        if (r100 != null) goto L6;
        return "pocket_page_online_data_".concat(o.f365780a.getDeviceId());
    L6:
        return "pocket_page_online_data_" + o.f365780a.getDeviceId() + '_' + r100;
    }

    public static Map b(Integer r100) {
        Object r101 = null;
        Map r102 = null;
        if (r100 == null) goto L5;
        String r103 = r100.toString();
    L6:
        String r104 = "";
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        Map<String, Object> r105 = f326478b.get(r103);
        if (r105 != null) goto L12;
    L14:
        boolean r106 = false;
    L15:
        if (r106 == false) goto L17;
        return r105;
    L17:
        String r107 = a(r100);
        String r108 = ((Keva) f326477a.getValue()).getString(r107, "");
        FLogger.f375446a.i("FlowCommonVenueDataManager", "[getPocketPageCache] key = " + r107 + ", json = " + r108);
        if (r100 == null) goto L20;
        String r109 = r100.toString();
    L21:
        if (r109 == null) goto L24;
        r104 = r109;
    L24:
        Intrinsics.checkNotNull(r108);
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L33
        if (r108.length() != 0) goto L28;
        boolean r111 = true;
    L29:
        if (r111 == true) goto L39;
        r102 = (Map) ((Gson) f326479c.getValue()).fromJson(r108, new d().getType());     // Catch: Throwable -> L33
    L39:
        if (r102 == null) goto L51;
        ConcurrentHashMap<String, Map<String, Object>> r112 = f326478b;
        LinkedHashMap r113 = new LinkedHashMap();
        Iterator r114 = r102.entrySet().iterator();
    L42:
        if (r114.hasNext() == false) goto L49;
        Map.Entry r115 = (Map.Entry) r114.next();
        if (r115.getValue() == null) goto L46;
        boolean r116 = true;
    L47:
        if (r116 == false) goto L42;
        r113.put(r115.getKey(), r115.getValue());
        goto L42
    L46:
        r116 = false;
        goto L47
    L49:
        r112.put(r104, r113);
    L51:
        return f326478b.get(r104);
    L28:
        r111 = false;
    L33:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        Object r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r118) == true) goto L38;
        r101 = r118;
    L38:
        r102 = (Map) r101;
        goto L39
    L20:
        r109 = null;
        goto L21
    L12:
        if ((!r105.isEmpty()) != true) goto L14;
        r106 = true;
        goto L15
    L5:
        r103 = null;
        goto L6
    }

    public static void c(Integer r100) {
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new FlowCommonVenueDataCache$preloadPocketData$1(r100, null), 2, null);
    }

    public static Object d(int r100, String r101, Integer r102, Continuation r103) {
        return BuildersKt.withContext(Dispatchers.getIO(), new FlowCommonVenueDataCache$refreshGetPocketPageDataResponseDataCache$2(r101, r102, r100, null), r103);
    }

    public static void e(int r110, long r210, Integer r211, String r212, boolean r213, Integer r214) {
        e.f326583a.getClass();
        long r100 = AppHost.f326268a.getAppClock().currentTimeMillis();
        FLogger.f375446a.i("FlowCommonVenueEnterTimeRecorder", "[getLastEnterMainVenueMillisDiff] currentTimeMillis = " + r100 + ", lastEnterMainVenueMs = " + e.f326584b);
        Long r101 = e.f326584b;
        if (r101 == null) goto L5;
        int r102 = (int) (r100 - r101.longValue());
    L6:
        JSONObject r103 = new JSONObject();
        r103.put("scene", r110);
        r103.put("duration", r210);
        r103.put("success", r213);
        if (r214 == null) goto L10;
        r103.put(DyVerifyEventConstants.EventParam.BIZ_SCENE, r214.intValue());
    L10:
        if (r211 == null) goto L13;
        r103.put("error_code", r211.intValue());
    L13:
        if (r212 == null) goto L16;
        r103.put("error_msg", r212);
    L16:
        if (r110 != 1) goto L18;
        r103.put("interval_ms", r102);
    L18:
        int r111 = r102;
        com.larus.platform.service.g.f365738a.monitorEventForSlardar("common_venue_pocket_page_data_request", r103, null, null);
        JSONObject r104 = new JSONObject();
        r104.put("scene", r110);     // Catch: Exception -> L30
        r104.put("duration", r210);     // Catch: Exception -> L30
        r104.put("success", r213);     // Catch: Exception -> L30
        if (r214 == null) goto L22;
        r104.put(DyVerifyEventConstants.EventParam.BIZ_SCENE, r214.intValue());     // Catch: Exception -> L30
    L22:
        if (r211 == null) goto L24;
        r104.put("error_code", r211.intValue());     // Catch: Exception -> L30
    L24:
        if (r212 == null) goto L26;
        r104.put("error_msg", r212);     // Catch: Exception -> L30
    L26:
        int r105 = 1;
        if (r110 != 1) goto L33;
        r104.put("interval_ms", r111);     // Catch: Exception -> L30
    L32:
        r105 = 1;
    L33:
        if (r110 != r105) goto L35;
        e.f326583a.getClass();
        long r106 = AppHost.f326268a.getAppClock().currentTimeMillis();
        FLogger.f375446a.i("FlowCommonVenueEnterTimeRecorder", "[updateLastEnterMainVenueMs] currentTimeMillis = " + r106 + ", lastEnterMainVenueMs = " + e.f326584b);
        e.f326584b = Long.valueOf(r106);
    L35:
        TrackParams r107 = new TrackParams().merge(r104);
        by7.a r108 = new by7.a("common_venue_pocket_page_data_request");
        r108.f21463a.merge(r107);
        r108.b();
        return;
    L30:
        e = move-exception;
        FLogger.f375446a.e("FlowCommonVenueDataManager", "error in FlowCommonVenueDataManager [reportPocketPageDataRequest] " + e.getLocalizedMessage());
        goto L32
    L5:
        r102 = -1;
        goto L6
    }
}
