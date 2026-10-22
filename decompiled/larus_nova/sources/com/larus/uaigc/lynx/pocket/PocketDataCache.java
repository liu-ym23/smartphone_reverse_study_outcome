package com.larus.uaigc.lynx.pocket;

import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.ixigua.lib.track.TrackParams;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.g;
import com.larus.platform.service.o;
import com.larus.uaigc.lynx.k;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class PocketDataCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PocketDataCache f373514a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f373515b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Object> f373516c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f373517d = null;

    public PocketDataCache() {
    }

    static {
        f373514a = new PocketDataCache();
        f373515b = LazyKt.lazy(new a());
        f373516c = new ConcurrentHashMap();
        f373517d = LazyKt.lazy(new b());
    }

    public static Map c() {
        ConcurrentHashMap<String, Object> r100 = f373516c;
        if ((!r100.isEmpty()) == false) goto L5;
        return r100;
    L5:
        String r101 = "pocket_page_online_data_".concat(o.f365780a.getDeviceId());
        String r102 = ((Keva) f373515b.getValue()).getString(r101, "");
        FLogger.f375446a.i("SpringMainVenueDataManager", "[getPocketPageCache] key = " + r101 + ", json = " + r102);
        Intrinsics.checkNotNull(r102);
        Object r103 = null;
        Map r104 = null;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L14
        if (r102.length() != 0) goto L9;
        boolean r106 = true;
    L10:
        if (r106 == true) goto L20;
        r104 = (Map) ((Gson) f373517d.getValue()).fromJson(r102, new c().getType());     // Catch: Throwable -> L14
    L20:
        if (r104 == null) goto L34;
        ConcurrentHashMap<String, Object> r107 = f373516c;
        LinkedHashMap r108 = new LinkedHashMap();
        Iterator r109 = r104.entrySet().iterator();
    L23:
        if (r109.hasNext() == false) goto L32;
        Map.Entry r110 = (Map.Entry) r109.next();
        if (r110.getKey() != null) goto L27;
    L29:
        boolean r111 = false;
    L30:
        if (r111 == false) goto L23;
        r108.put(r110.getKey(), r110.getValue());
        goto L23
    L27:
        if (r110.getValue() == null) goto L29;
        r111 = true;
        goto L30
    L32:
        r107.putAll(r108);
    L34:
        return f373516c;
    L9:
        r106 = false;
    L14:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        Object r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r113) == true) goto L19;
        r103 = r113;
    L19:
        r104 = (Map) r103;
        goto L20
    }

    public static void e() {
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new PocketDataCache$preFetchPocketData$1(null), 2, null);
    }

    public static boolean d(Map r100) {
        if (r100 == null) goto L7;
        boolean r101 = true;
        if ((!r100.isEmpty()) != true) goto L7;
    L8:
        if (r101 == false) goto L17;
        Object r102 = r100.get("pocket_page_data");
        Object r103 = null;
        if ((r102 instanceof Map) == false) goto L12;
        Map r104 = (Map) r102;
    L13:
        if (r104 == null) goto L16;
        r103 = r104.get("can_support_be_gala_time_config");
    L16:
        return Intrinsics.areEqual(r103, Boolean.TRUE);
    L12:
        r104 = null;
        goto L13
    L17:
        return false;
    L7:
        r101 = false;
        goto L8
    }

    public final Object b(Continuation<? super Map<String, ? extends Object>> r110) {
        if ((r110 instanceof PocketDataCache$getCacheOrFetchPocketData$1) == false) goto L7;
        PocketDataCache$getCacheOrFetchPocketData$1 r100 = (PocketDataCache$getCacheOrFetchPocketData$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        Map r104 = (Map) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L37:
        if (((Boolean) r111).booleanValue() == false) goto L55;
        Map r112 = c();
        if (r112 != null) goto L41;
        r112 = MapsKt.emptyMap();
    L41:
        boolean r105 = d(r112);
        FLogger.f375446a.i("SpringMainVenueDataManager", "[getCacheOrFetchSpringPocketData] newCache size = " + r104.size() + ", canUse = " + r105);
        ConcurrentHashMap r106 = new ConcurrentHashMap();
        LinkedHashMap r107 = new LinkedHashMap();
        Iterator r113 = r112.entrySet().iterator();
    L43:
        if (r113.hasNext() == false) goto L52;
        Map.Entry r108 = (Map.Entry) r113.next();
        if (r108.getKey() != null) goto L47;
    L49:
        boolean r109 = false;
    L50:
        if (r109 == false) goto L43;
        r107.put(r108.getKey(), r108.getValue());
        goto L43
    L47:
        if (r108.getValue() == null) goto L49;
        r109 = true;
        goto L50
    L52:
        r106.putAll(r107);
        return r106;
    L55:
        return MapsKt.emptyMap();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        Map r114 = c();
        if (r114 != null) goto L17;
        r114 = MapsKt.emptyMap();
    L17:
        boolean r115 = d(r114);
        FLogger.f375446a.i("SpringMainVenueDataManager", "[getCacheOrFetchSpringPocketData] oldCache size = " + r114.size() + ", oldCacheCanUse = " + r115);
        if (r115 == false) goto L32;
        ConcurrentHashMap r116 = new ConcurrentHashMap();
        LinkedHashMap r117 = new LinkedHashMap();
        Iterator r118 = r114.entrySet().iterator();
    L21:
        if (r118.hasNext() == false) goto L30;
        Map.Entry r119 = (Map.Entry) r118.next();
        if (r119.getKey() != null) goto L25;
    L27:
        boolean r120 = false;
    L28:
        if (r120 == false) goto L21;
        r117.put(r119.getKey(), r119.getValue());
        goto L21
    L25:
        if (r119.getValue() == null) goto L27;
        r120 = true;
        goto L28
    L30:
        r116.putAll(r117);
        return r116;
    L32:
        r100.L$0 = r114;
        r100.label = 1;
        Object r121 = f(3, "source_from_fe", r100);
        if (r121 != r102) goto L35;
        return r102;
    L35:
        r104 = r114;
        r111 = r121;
    L7:
        r100 = new PocketDataCache$getCacheOrFetchPocketData$1(this, r110);
        goto L8
    }

    public static Object f(int r100, String r101, Continuation r102) {
        return BuildersKt.withContext(Dispatchers.getIO(), new PocketDataCache$refreshGetPocketPageDataResponseDataCache$2(r100, r101, null), r102);
    }

    public static final void a(PocketDataCache r100, int r101, long r110, Integer r111, String r112) {
        r100.getClass();
        FLogger.f375446a.i("SpringMainVenueDataManager", "[refreshPocketPageCache] getPocketPageData fail, error msg: " + r112 + ", error code: " + r111);
        g(r101, System.currentTimeMillis() - r110, r111, r112, false);
    }

    public static void g(int r110, long r111, Integer r210, String r211, boolean r212) {
        k.f373509a.getClass();
        long r100 = AppHost.f326268a.getAppClock().currentTimeMillis();
        FLogger.f375446a.i("ServerEnterTimeRecorder", "[getLastEnterMainVenueMillisDiff] currentTimeMillis = " + r100 + ", lastEnterMainVenueMs = " + k.f373510b);
        Long r101 = k.f373510b;
        if (r101 == null) goto L5;
        int r102 = (int) (r100 - r101.longValue());
    L6:
        JSONObject r103 = new JSONObject();
        r103.put("scene", r110);
        r103.put("duration", r111);
        r103.put("success", r212);
        if (r210 == null) goto L10;
        r103.put("error_code", r210.intValue());
    L10:
        if (r211 == null) goto L13;
        r103.put("error_msg", r211);
    L13:
        if (r110 != 1) goto L15;
        r103.put("interval_ms", r102);
    L15:
        g.f365738a.monitorEventForSlardar("pocket_page_data_request", r103, null, null);
        JSONObject r104 = new JSONObject();
        r104.put("scene", r110);     // Catch: Exception -> L25
        r104.put("duration", r111);     // Catch: Exception -> L25
        r104.put("success", r212);     // Catch: Exception -> L25
        if (r210 == null) goto L19;
        r104.put("error_code", r210.intValue());     // Catch: Exception -> L25
    L19:
        if (r211 == null) goto L21;
        r104.put("error_msg", r211);     // Catch: Exception -> L25
    L21:
        int r105 = 1;
        if (r110 != 1) goto L28;
        r104.put("interval_ms", r102);     // Catch: Exception -> L25
    L27:
        r105 = 1;
    L28:
        if (r110 != r105) goto L30;
        k.f373509a.getClass();
        long r106 = AppHost.f326268a.getAppClock().currentTimeMillis();
        FLogger.f375446a.i("ServerEnterTimeRecorder", "[updateLastEnterMainVenueMs] currentTimeMillis = " + r106 + ", lastEnterMainVenueMs = " + k.f373510b);
        k.f373510b = Long.valueOf(r106);
    L30:
        TrackParams r107 = new TrackParams().merge(r104);
        by7.a r108 = new by7.a("pocket_page_data_request");
        r108.f21463a.merge(r107);
        r108.b();
        return;
    L25:
        e = move-exception;
        FLogger.f375446a.e("SpringMainVenueDataManager", "error in SpringMainVenueDataManager [reportPocketPageDataRequest] " + e.getLocalizedMessage());
        goto L27
    L5:
        r102 = -1;
        goto L6
    }
}
