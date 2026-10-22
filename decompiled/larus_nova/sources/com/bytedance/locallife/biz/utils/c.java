package com.bytedance.locallife.biz.utils;

import android.os.SystemClock;
import com.bytedance.locallife.biz.fmp.PoiChainDurationMonitor;
import com.bytedance.locallife.dito.data.DitoPageInfo;
import com.bytedance.locallife.model.constant.SaasMobParams;
import com.ss.android.lark.language.api.LocaleWatchScene;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f256986a = 0;

    static {
    }

    public c() {
    }

    public static void c(PoiChainDurationMonitor r100) {
        Intrinsics.checkNotNullParameter(r100, "durationMonitor");
        PoiChainDurationMonitor.b.a r101 = new PoiChainDurationMonitor.b.a("poi_page_create");
        r101.f256692d = true;
        r101.a(LocaleWatchScene.ACTIVITY_CREATE, (String) ((ConcurrentHashMap) r100.f256674e).get(LocaleWatchScene.ACTIVITY_CREATE));
        r101.a("layout_inflate", (String) ((ConcurrentHashMap) r100.f256674e).get("layout_inflate"));
        r101.a("param_init", (String) ((ConcurrentHashMap) r100.f256674e).get("param_init"));
        r101.a("view_init", (String) ((ConcurrentHashMap) r100.f256674e).get("view_init"));
        r101.a("lynxview_preload", (String) ((ConcurrentHashMap) r100.f256674e).get("lynxview_preload"));
        r100.e(r101.b());
    }

    public static void f(PoiChainDurationMonitor r100) {
        Intrinsics.checkNotNullParameter(r100, "durationMonitor");
        Intrinsics.checkNotNullParameter("poi_content_fill_start", "mName");
        ConcurrentHashMap r101 = new ConcurrentHashMap();
        String r102 = (String) ((ConcurrentHashMap) r100.f256674e).get("dito_page_entity_id");
        Intrinsics.checkNotNullParameter("dito_page_entity_id", "key");
        if (r102 == null) goto L5;
        String r103 = (String) r101.put("dito_page_entity_id", r102);
    L5:
        PoiChainDurationMonitor.b r104 = new PoiChainDurationMonitor.b();
        r104.f256687c = "poi_content_fill_start";
        r104.f256685a = SystemClock.elapsedRealtime();
        r104.f256688d = true;
        ((ConcurrentHashMap) r104.f256686b).putAll(r101);
        r100.e(r104);
    }

    public static void j(PoiChainDurationMonitor r100) {
        Intrinsics.checkNotNullParameter(r100, "durationMonitor");
        Intrinsics.checkNotNullParameter("poi_content_ready_to_refresh", "mName");
        ConcurrentHashMap r101 = new ConcurrentHashMap();
        PoiChainDurationMonitor.b r102 = new PoiChainDurationMonitor.b();
        r102.f256687c = "poi_content_ready_to_refresh";
        r102.f256685a = SystemClock.elapsedRealtime();
        r102.f256688d = true;
        ((ConcurrentHashMap) r102.f256686b).putAll(r101);
        r100.e(r102);
    }

    public static void m(PoiChainDurationMonitor r100) {
        Intrinsics.checkNotNullParameter(r100, "durationMonitor");
        Intrinsics.checkNotNullParameter("poi_request_send", "mName");
        ConcurrentHashMap r101 = new ConcurrentHashMap();
        String r102 = (String) ((ConcurrentHashMap) r100.f256674e).get("dito_page_entity_id");
        Intrinsics.checkNotNullParameter("dito_page_entity_id", "key");
        if (r102 == null) goto L5;
        String r103 = (String) r101.put("dito_page_entity_id", r102);
    L5:
        PoiChainDurationMonitor.b r104 = new PoiChainDurationMonitor.b();
        r104.f256687c = "poi_request_send";
        r104.f256685a = SystemClock.elapsedRealtime();
        r104.f256688d = true;
        ((ConcurrentHashMap) r104.f256686b).putAll(r101);
        r100.e(r104);
    }

    public static void a(JSONObject r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        Intrinsics.checkNotNullParameter(r101, "hostName");
        r100.put(SaasMobParams.IS_SAAS.getKey(), "1");
        r100.put(SaasMobParams.SAAS_HOS_NAME.getKey(), r101);
    }

    public static Map b(Map r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "hostName");
        Map r102 = MapsKt.toMutableMap(r100);
        r102.put(SaasMobParams.IS_SAAS.getKey(), "1");
        r102.put(SaasMobParams.SAAS_HOS_NAME.getKey(), r101);
        return r102;
    }

    public static void d(PoiChainDurationMonitor r100, String r101, Map r102) {
        Intrinsics.checkNotNullParameter(r100, "durationMonitor");
        Intrinsics.checkNotNullParameter(r101, "type");
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "type");
        monitor-enter(r100);
        LinkedHashMap r103 = new LinkedHashMap();     // Catch: Throwable -> L22
        r103.put("session_id", r100.f256670a);     // Catch: Throwable -> L22
        r103.put("type", r101);     // Catch: Throwable -> L22
        long r104 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L22
        r103.put("total_duration", String.valueOf(r104 - r100.f256671b));     // Catch: Throwable -> L22
        PoiChainDurationMonitor.b r105 = r100.f256678i;     // Catch: Throwable -> L22
        if (r105 != null) goto L8;
        r105 = null;
    L8:
        if (r105 == null) goto L15;
        String r106 = r105.f256687c;     // Catch: Throwable -> L22
        if (Intrinsics.areEqual(r106, "poi_request_finish") == true) goto L12;
    L14:
        r103.put("last_event", r106);     // Catch: Throwable -> L22
        long r107 = r105.f256685a;     // Catch: Throwable -> L22
    L16:
        r103.put("dito_page_entity_id", ((ConcurrentHashMap) r100.f256674e).get("dito_page_entity_id"));     // Catch: Throwable -> L22
        r103.put("last_duration", String.valueOf(r104 - r107));     // Catch: Throwable -> L22
        if (r102 == null) goto L19;
        r103.putAll(r102);     // Catch: Throwable -> L22
    L19:
        r100.f256682m.a("poi_page_bounce", r103);     // Catch: Throwable -> L22
        r103.toString();     // Catch: Throwable -> L22
        monitor-exit(r100);
        return;
    L12:
        if (Intrinsics.areEqual(((ConcurrentHashMap) r105.f256686b).get("result"), "0") == true) goto L14;
        r106 = r106 + "_failed";     // Catch: Throwable -> L22
        goto L14
    L15:
        r103.put("last_event", "poi_page_create");     // Catch: Throwable -> L22
        r107 = r100.f256671b;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public static void g(PoiChainDurationMonitor r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "durationMonitor");
        Intrinsics.checkNotNullParameter(r101, "s");
        Intrinsics.checkNotNullParameter(r102, "reason");
        PoiChainDurationMonitor.b.a r103 = new PoiChainDurationMonitor.b.a("dito_data_parse_end");
        r103.a("result", r101);
        r103.a("reason", r102);
        r103.a("dito_page_entity_id", (String) ((ConcurrentHashMap) r100.f256674e).get("dito_page_entity_id"));
        Intrinsics.checkNotNullParameter("poi_request_finish", "lastEvent");
        r103.f256692d = true;
        r100.e(r103.b());
    }

    public static void l(PoiChainDurationMonitor r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "durationMonitor");
        Intrinsics.checkNotNullParameter(r101, "s");
        Intrinsics.checkNotNullParameter(r102, "reason");
        PoiChainDurationMonitor.b.a r103 = new PoiChainDurationMonitor.b.a("poi_request_finish");
        r103.a("result", r101);
        r103.a("reason", r102);
        r103.a("dito_page_entity_id", (String) ((ConcurrentHashMap) r100.f256674e).get("dito_page_entity_id"));
        r103.f256692d = true;
        r100.e(r103.b());
    }

    public static void n(PoiChainDurationMonitor r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "durationMonitor");
        Intrinsics.checkNotNullParameter(r101, "key");
        r100.h(r101, r102);
    }

    public static void h(PoiChainDurationMonitor r100, long r101, boolean r102, int r103, long r104, long r110, Function1 r111) {
        Intrinsics.checkNotNullParameter(r100, "durationMonitor");
        PoiChainDurationMonitor.b.a r105 = new PoiChainDurationMonitor.b.a("poi_fmp_complete");
        String r106 = (String) ((ConcurrentHashMap) r100.f256674e).get("is_retry");
        String r107 = "0";
        if (r106 != null) goto L5;
        r106 = "0";
    L5:
        r105.a("is_retry", r106);
        if (r102 == false) goto L8;
        r107 = "1";
    L8:
        r105.a("is_new", r107);
        r105.a("type", String.valueOf(r103));
        r105.a("total_cost", String.valueOf(r104));
        r105.a(com.bytedance.android.ec.core.event.a.KEY_TOTAL_COUNT, String.valueOf(r110));
        r105.a("dito_page_entity_id", (String) ((ConcurrentHashMap) r100.f256674e).get("dito_page_entity_id"));
        String r108 = (String) ((ConcurrentHashMap) r100.f256674e).get("server_trace");
        if (r108 == null) goto L11;
        r105.a("server_trace", r108);
    L11:
        String r109 = (String) ((ConcurrentHashMap) r100.f256674e).get("network_detail_time");
        if (r109 == null) goto L14;
        r105.a("network_detail_time", r109);
    L14:
        r105.f256690b = r101;
        if (r111 == null) goto L17;
        r111.invoke(r105);
    L17:
        r100.e(r105.b());
    }

    public static /* synthetic */ void i(PoiChainDurationMonitor r110, long r111, boolean r112, int r113, long r114, long r115, int r210) {
        if ((r210 & 8) == 0) goto L5;
        int r100 = -1;
    L7:
        if ((r210 & 16) == 0) goto L9;
        long r101 = -1;
    L11:
        if ((r210 & 32) == 0) goto L13;
        long r102 = -1;
    L14:
        h(r110, r111, r112, r100, r101, r102, null);
        return;
    L13:
        r102 = r115;
        goto L14
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }

    public static void k(PoiChainDurationMonitor r100, String r101, String r102, String r103, String r104, HashMap r105, DitoPageInfo r106) {
        Intrinsics.checkNotNullParameter(r100, "durationMonitor");
        Intrinsics.checkNotNullParameter(r101, "requestNetworkDuration");
        Intrinsics.checkNotNullParameter(r102, "totalReceivedBytes");
        Intrinsics.checkNotNullParameter(r103, "beforeNetworkDuration");
        Intrinsics.checkNotNullParameter(r104, "afterNetworkDuration");
        PoiChainDurationMonitor.b.a r107 = new PoiChainDurationMonitor.b.a("poi_request_cost");
        r107.a("total_request_duration", r101);
        r107.a("network_total_received_bytes", r102);
        r107.a("detail_client_pre_network_duration", r103);
        r107.a("detail_client_after_network_duration", r104);
        r107.a("client_pre_network_duration", r103);
        r107.a("client_after_network_duration", r104);
        r107.a("dito_page_entity_id", (String) ((ConcurrentHashMap) r100.f256674e).get("dito_page_entity_id"));
        r107.f256692d = true;
        if (r105 == null) goto L8;
        Iterator r108 = r105.entrySet().iterator();
    L6:
        if (r108.hasNext() == false) goto L8;
        Map.Entry r109 = (Map.Entry) r108.next();
        r107.a((String) r109.getKey(), (String) r109.getValue());
    L8:
        if (r106 == null) goto L15;
        Map<String, String> r110 = r106.getGlobalTrackParamsStrMap();
        if (r110 == null) goto L15;
        Iterator<Map.Entry<String, String>> r111 = r110.entrySet().iterator();
    L13:
        if (r111.hasNext() == false) goto L15;
        Map.Entry<String, String> r112 = r111.next();
        r107.a(r112.getKey(), r112.getValue());
    L15:
        r100.e(r107.b());
    }

    public static void e(PoiChainDurationMonitor r100, String r101, String r102, long r103, String r104, String r105, long r110, String r111, HashMap r112) {
        Intrinsics.checkNotNullParameter(r100, "durationMonitor");
        Intrinsics.checkNotNullParameter(r105, "bundle");
        PoiChainDurationMonitor.b.a r106 = new PoiChainDurationMonitor.b.a("poi_card_fill");
        r106.a("name", r101);
        r106.a("type", r102);
        r106.a("result", r104);
        r106.a("self_duration", String.valueOf(r103));
        r106.a("bundle", r105);
        r106.a("gecko_id", String.valueOf(r110));
        if (r111 != null) goto L5;
        r111 = "";
    L5:
        r106.a("sub_type", r111);
        r106.a("dito_page_entity_id", (String) ((ConcurrentHashMap) r100.f256674e).get("dito_page_entity_id"));
        Intrinsics.checkNotNullParameter("poi_content_fill_start", "lastEvent");
        if (r112 == null) goto L11;
        Iterator r107 = r112.entrySet().iterator();
    L9:
        if (r107.hasNext() == false) goto L11;
        Map.Entry r108 = (Map.Entry) r107.next();
        r106.a((String) r108.getKey(), (String) r108.getValue());
    L11:
        r100.e(r106.b());
    }
}
