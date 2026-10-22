package com.ss.android.ugc.aweme.search.common.mob;

import com.bytedance.android.chunkstreamprediction.network.c;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.ugc.aweme.app.api.RequestInfoSensitive;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchEventService;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostService;
import com.ss.android.ugc.aweme.search.optimize.preload.monitor.TradeSearchPreloadCacheHitMonitor;
import com.ss.android.ugc.aweme.search.optimize.preload.monitor.TradeSearchPreloadCacheHitMonitorProvider;
import com.ss.android.ugc.aweme.search.service.TradeSearch;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/mob/ECSearchSaasResultShowEvent;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchSaasResultShowEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f451727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f451728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f451729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f451730d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f451731e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f451732f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f451733g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RequestInfoSensitive f451734h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f451735i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f451736j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f451737k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f451738l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f451739m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f451740n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public JsonObject f451741o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f451742p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f451743q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f451744r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f451745s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f451746t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public c f451747u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public NetworkUtils.NetworkType f451748v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Map<String, Object> f451749w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ECSearchResultSceneKey f451750x;

    public final void b() {
        if (Intrinsics.areEqual(this, ECSearchSaasResultShowEventTrackerKt.f451757b) == false) goto L5;
        return;
    L5:
        ECSearchSaasResultShowEventTracker r100 = ECSearchSaasResultShowEventTracker.f451754d;
        ECSearchResultSceneKey r101 = this.f451750x;
        r100.getClass();
        ECSearchSaasResultShowEventTracker.a(r101);
    }

    public final void e() {
        if (Intrinsics.areEqual(this, ECSearchSaasResultShowEventTrackerKt.f451757b) == false) goto L5;
        return;
    L5:
        long r100 = this.f451729c;
        if (r100 != 0) goto L9;
        r100 = this.f451727a;
    L9:
        long r101 = System.currentTimeMillis();
        this.f451733g = r101;
        this.f451740n = (int) (r101 - r100);
    }

    public final void f() {
        ECSearchSaasResultShowEvent r100 = ECSearchSaasResultShowEventTrackerKt.f451757b;
        if (Intrinsics.areEqual(this, r100) == false) goto L6;
        Logger.b("EventTrackerDebug", "networkStart this(" + hashCode() + " != STUB_EVENT_RESULT(" + r100.hashCode() + "), just return");
        return;
    L6:
        this.f451729c = System.currentTimeMillis();
        Logger.a("EventTrackerDebug", "networkStart this(" + hashCode() + " != STUB_EVENT_RESULT(" + r100.hashCode() + "), networkStart = " + this.f451729c);
    }

    public final void k() {
        ECSearchSaasResultShowEvent r100 = ECSearchSaasResultShowEventTrackerKt.f451757b;
        if (Intrinsics.areEqual(this, r100) == false) goto L6;
        Logger.b("EventTrackerDebug", "viewDrawStart this(" + hashCode() + " != STUB_EVENT_RESULT(" + r100.hashCode() + "), just return");
        return;
    L6:
        long r101 = 0;
        if (this.f451731e != 0) goto L10;
        this.f451731e = System.currentTimeMillis();
        Logger.a("EventTrackerDebug", "viewDrawStart this(" + hashCode() + " != STUB_EVENT_RESULT(" + r100.hashCode() + "), viewDrawStart = " + this.f451731e);
    L10:
        if (Intrinsics.areEqual(this, r100) == true) goto L21;
        TradeSearchPreloadCacheHitMonitorProvider.f453391a.getClass();
        TradeSearchPreloadCacheHitMonitor r102 = TradeSearchPreloadCacheHitMonitorProvider.f453392b.get("saas_search");
        if (r102 == null) goto L15;
        r101 = r102.f453385g;
    L15:
        this.f451738l = r101;
        if (r102 == null) goto L18;
        int r103 = r102.f453386h;
    L19:
        this.f451739m = r103;
        Logger.a("EventTrackerDebug", "preloadEndTime = " + this.f451738l);
        Logger.a("EventTrackerDebug", "preloadSuccessCount = " + this.f451739m);
        return;
    L18:
        r103 = -1;
        goto L19
    }

    public ECSearchSaasResultShowEvent(ECSearchResultSceneKey r100) {
        Intrinsics.checkNotNullParameter(r100, "sceneKey");
        this.f451750x = r100;
        this.f451738l = -1;
        this.f451743q = -1;
        this.f451749w = new LinkedHashMap();
    }

    public final void a(c r100) {
        if (Intrinsics.areEqual(this, ECSearchSaasResultShowEventTrackerKt.f451757b) == false) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        c r101 = null;
    L15:
        this.f451747u = r101;
        return;
    L7:
        monitor-enter(r100);
        List<c.a> r102 = r100.f42525a;     // Catch: Throwable -> L11
        monitor-exit(r100);
        r101 = new c(r102, r100.f42526b);
    L11:
        th = move-exception;
        throw th;
    }

    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        if (Intrinsics.areEqual(this, ECSearchSaasResultShowEventTrackerKt.f451757b) == false) goto L5;
        return;
    L5:
        this.f451743q = 1;
        this.f451745s = 2;
        this.f451744r = "业务逻辑取消请求，from: ".concat(r100);
    }

    public final void d(Throwable r100) {
        Intrinsics.checkNotNullParameter(this, "event");
        if ((r100 instanceof NetworkNotAvailabeException) == false) goto L6;
        this.f451743q = 2;
        this.f451745s = 1;
        this.f451744r = r100.getMessage();
        return;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(r101, IOException.class) == false) goto L21;
        String r102 = r100.getMessage();
        if (r102 != null) goto L14;
    L20:
        this.f451744r = r100.getMessage();
        return;
    L14:
        if (StringsKt.contains$default(r102, "missing CR", false, 2, null) == false) goto L17;
        this.f451743q = 4;
        this.f451745s = 3;
        goto L20
    L17:
        if (StringsKt.contains$default(r102, "Premature EOF", false, 2, null) == false) goto L19;
        this.f451743q = 4;
        this.f451745s = 2;
        goto L20
    L19:
        this.f451743q = 2;
        this.f451745s = 101;
        goto L20
    L21:
        this.f451743q = 2;
        return;
    L8:
        r101 = null;
        goto L10
    }

    public final void g(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        if (Intrinsics.areEqual(this, ECSearchSaasResultShowEventTrackerKt.f451757b) == false) goto L5;
        return;
    L5:
        this.f451749w.putAll(r100);
    }

    public final void h(boolean r110) {
        long r100 = System.currentTimeMillis();     // Catch: Throwable -> L42 Exception -> L46
        this.f451737k = r100;     // Catch: Throwable -> L42 Exception -> L46
        long r101 = this.f451727a;     // Catch: Throwable -> L42 Exception -> L46
        this.f451735i = (int) (r100 - r101);     // Catch: Throwable -> L42 Exception -> L46
        long r102 = this.f451728b;     // Catch: Throwable -> L42 Exception -> L46
        if (r102 <= 0) goto L6;
        this.f451736j = (int) (r101 - r102);     // Catch: Throwable -> L42 Exception -> L46
    L6:
        Logger.a("EventTrackerDebug", "performEnd start = " + this.f451727a + ", endTime = " + this.f451737k + ", cost = " + this.f451735i);     // Catch: Throwable -> L42 Exception -> L46
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L42 Exception -> L46
        r103.put(ChameleonOpenTracker.ParamKey.COST, this.f451735i);     // Catch: Throwable -> L42 Exception -> L46
        r103.put("click_to_undertake_cost_time", this.f451736j);     // Catch: Throwable -> L42 Exception -> L46
        int r104 = 0;
        if (this.f451736j > 0) goto L9;
    L11:
        boolean r105 = false;
    L12:
        r103.put("is_click_ts_missing", r105);     // Catch: Throwable -> L42 Exception -> L46
        r103.put("netCost", this.f451740n);     // Catch: Throwable -> L42 Exception -> L46
        r103.put("netLogId", this.f451742p);     // Catch: Throwable -> L42 Exception -> L46
        r103.put("status", this.f451743q);     // Catch: Throwable -> L42 Exception -> L46
        r103.put("errorMsg", this.f451744r);     // Catch: Throwable -> L42 Exception -> L46
        r103.put("errorCode", this.f451745s);     // Catch: Throwable -> L42 Exception -> L46
        r103.put("before_request_trigger", this.f451729c - this.f451727a);     // Catch: Throwable -> L42 Exception -> L46
        r103.put("client_cost", this.f451735i - this.f451740n);     // Catch: Throwable -> L42 Exception -> L46
        RequestInfoSensitive r106 = this.f451734h;     // Catch: Throwable -> L42 Exception -> L46
        if (r106 == null) goto L31;
        Intrinsics.checkNotNull(r106);     // Catch: Throwable -> L42 Exception -> L46
        BaseHttpRequestInfo r107 = r106.getRequestInfo();     // Catch: Throwable -> L42 Exception -> L46
        if (r107 == null) goto L31;
        r103.put("requestStart", r107.requestStart);     // Catch: Throwable -> L42 Exception -> L46
        long r111 = r107.totalTime;     // Catch: Throwable -> L42 Exception -> L46
        if (r111 <= 0) goto L25;
        int r108 = (int) r111;     // Catch: Throwable -> L42 Exception -> L46
        r103.put("timing_total", r111);     // Catch: Throwable -> L42 Exception -> L46
        r103.put("request_timing_total", r107.totalTime);     // Catch: Throwable -> L42 Exception -> L46
        int r109 = r103.optInt(RNParamRegisterEventHandler.SRC_INNER);     // Catch: Throwable -> L42 Exception -> L46
        if (r109 <= 0) goto L22;
        r103.put("timing_net", r107.totalTime - ((long) r109));     // Catch: Throwable -> L42 Exception -> L46
    L22:
        if (this.f451731e != 0) goto L24;
        this.f451731e = this.f451733g;     // Catch: Throwable -> L42 Exception -> L46
    L24:
        r103.put("after_response_end", this.f451733g - r107.requestEnd);     // Catch: Throwable -> L42 Exception -> L46
        r103.put("client_cost", ((long) this.f451735i) - r107.totalTime);     // Catch: Throwable -> L42 Exception -> L46
        r104 = r108;
    L25:
        r103.put("before_request_trigger", this.f451729c - this.f451727a);     // Catch: Throwable -> L42 Exception -> L46
        r103.put("timing_retrofit", r107.requestStart - r107.appLevelRequestStart);     // Catch: Throwable -> L42 Exception -> L46
        long r112 = r107.requestStart;     // Catch: Throwable -> L42 Exception -> L46
        if (r112 == 0) goto L29;
        r103.put("before_request_start", r112 - this.f451729c);     // Catch: Throwable -> L42 Exception -> L46
    L29:
        if (this.f451747u == null) goto L31;
        r104 = j(r103, r107.requestStart);     // Catch: Throwable -> L42 Exception -> L46
    L31:
        r103.put("view_draw_cost", r100 - this.f451731e);     // Catch: Throwable -> L42 Exception -> L46
        r103.put("switch_thread_cost", this.f451731e - this.f451733g);     // Catch: Throwable -> L42 Exception -> L46
        i(r103, r104);     // Catch: Throwable -> L42 Exception -> L46
        Iterator r113 = ((LinkedHashMap) this.f451749w).entrySet().iterator();     // Catch: Throwable -> L42 Exception -> L46
    L33:
        if (r113.hasNext() == false) goto L35;
        Map.Entry r114 = (Map.Entry) r113.next();     // Catch: Throwable -> L42 Exception -> L46
        r103.put((String) r114.getKey(), r114.getValue());     // Catch: Throwable -> L42 Exception -> L46
        goto L33
    L35:
        r103.put(a.KEY_EVENT_ORIGIN_FEATURE, a.VALUE_TEMAI);     // Catch: Throwable -> L42 Exception -> L46
        ITradeSearchHostService r115 = TradeSearch.c(TradeSearch.f453393a);     // Catch: Throwable -> L42 Exception -> L46
        if (r115 == null) goto L40;
        ITradeSearchEventService r116 = r115.getITradeSearchEventService();     // Catch: Throwable -> L42 Exception -> L46
        if (r116 == null) goto L40;
        r116.logV3("search_trigger_refresh_monitor", r103);     // Catch: Throwable -> L42 Exception -> L46
    L40:
        if (r110 == false) goto L53;
    L48:
        ECSearchSaasResultShowEventTracker.f451754d.getClass();
        ECSearchSaasResultShowEventTracker.f451752b.c(this.f451750x);
        return;
    L53:
        return;
    L9:
        if (this.f451728b <= 0) goto L11;
        r105 = true;
    L42:
        th = move-exception;
        if (r110 == false) goto L45;
        ECSearchSaasResultShowEventTracker.f451754d.getClass();
        ECSearchSaasResultShowEventTracker.f451752b.c(this.f451750x);
    L45:
        throw th;
    L47:
        if (r110 == true) goto L48;
    }

    public final void i(JSONObject r100, int r101) {
        JsonObject r102 = this.f451741o;
        if (r102 == null) goto L41;
        Iterator<T> r103 = r102.keySet().iterator();     // Catch: Exception -> L27
    L6:
        if (r103.hasNext() == false) goto L16;
        String r104 = (String) r103.next();     // Catch: Exception -> L27
        JsonPrimitive r105 = r102.get(r104).getAsJsonPrimitive();     // Catch: Exception -> L27
        if (r105.isNumber() == true) goto L9;
        if (r105.isBoolean() == true) goto L12;
        if (r105.isString() == false) goto L6;
        r100.put(r104, r105.getAsString());     // Catch: Exception -> L27
        goto L6
    L12:
        r100.put(r104, r105.getAsBoolean());     // Catch: Exception -> L27
        goto L6
    L9:
        r100.put(r104, r105.getAsNumber());     // Catch: Exception -> L27
        goto L6
    L16:
        JsonPrimitive r106 = r102.getAsJsonPrimitive("stream_inner");     // Catch: Exception -> L27
        r100.optInt("request_timing_total", 0);     // Catch: Exception -> L27
        if (r101 > 0) goto L20;
        r101 = this.f451740n;     // Catch: Exception -> L27
    L20:
        long r107 = r101;
        if (r107 > 0) goto L23;
    L25:
        r100.toString();     // Catch: Exception -> L27
        return;
    L23:
        if (r106.isNumber() == false) goto L25;
        r100.put("request_timing_network", r107 - r106.getAsNumber().longValue());     // Catch: Exception -> L27
    L42:
        return;
    }

    public final int j(JSONObject r110, long r111) {
        c r100 = this.f451747u;
        int r101 = 0;
        if (r100 != null) goto L5;
    L48:
        return r101;
    L5:
        if (r111 <= 0) goto L48;
        monitor-enter(r100);
        List<c.a> r102 = r100.f42525a;     // Catch: Throwable -> L45
        monitor-exit(r100);
        if ((!r102.isEmpty()) == false) goto L12;
        ArrayList r103 = (ArrayList) r102;
        c.a r104 = (c.a) ListProtector.get(r103, r103.size() - 1);
    L13:
        ArrayList r105 = (ArrayList) r102;
        if (r105.size() < 2) goto L20;
        r110.put("click_to_first_chunk_received", ((c.a) ListProtector.get(r105, 0)).f42532f - this.f451727a);
        r110.put("first_chunk_ack_chunk_gap", ((c.a) ListProtector.get(r105, 1)).f42532f - ((c.a) ListProtector.get(r105, 0)).f42532f);
        r110.put("pre_render_cost", this.f451731e - ((c.a) ListProtector.get(r105, 0)).f42532f);
        if (this.f451746t != 1) goto L20;
        c.a r106 = (c.a) CollectionsKt.getOrNull(r105, 0);
        if (r106 == null) goto L20;
        r110.put("lynx_preload_first_chunk_gap", r106.f42532f - this.f451738l);
        r110.put("first_chunk_filter_bind_gap", 0 - r106.f42532f);
    L20:
        if (r104 == null) goto L38;
        int r107 = (int) (r100.f42526b - r111);
        int r108 = (int) (r104.f42532f - r100.f42526b);
        Iterator r109 = r105.iterator();
        int r112 = 0;
    L23:
        if (r109.hasNext() == false) goto L25;
        c.a r113 = (c.a) r109.next();
        r112 = r112 + ((int) (r113.f42529c - r113.f42528b));
        goto L23
    L25:
        Iterator r114 = r105.iterator();
    L27:
        if (r114.hasNext() == false) goto L29;
        c.a r115 = (c.a) r114.next();
        r101 = r101 + ((int) (r115.f42531e - r115.f42530d));
        goto L27
    L29:
        int r116 = r107 + r112;
        int r117 = r107 + r108;
        int r118 = (r108 - r112) - r101;
        int r119 = (int) (r104.f42530d - r104.f42529c);
        r110.put("header_reading_cost", r107);
        r110.put("total_raw_response_body_reading_cost", r112);
        r110.put("total_response_distribute_cost", r101);
        r110.put("response_reading_cost", r108);
        if (this.f451735i < r116) goto L32;
    L37:
        r101 = r116;
    L39:
        if (r101 <= 0) goto L41;
        r110.put("timing_total", r101);
        r110.put("request_timing_total", r117);
        r110.put("client_cost", this.f451735i - r101);
        r110.put("client_cost_v2", this.f451735i - r117);
    L41:
        if (r119 <= 0) goto L43;
        r110.put("timing_gap_end", r119);
        r110.put("after_response_end", r119);
    L43:
        if (r118 <= 0) goto L48;
        r110.put("chunk_data_parsing_cost", r118);
        goto L48
    L32:
        if (r104.f42532f <= this.f451737k) goto L35;
        r110.put("client_cost_absent_reason", "requestEnd > endTime");
        goto L37
    L35:
        if (r111 >= this.f451727a) goto L37;
        r110.put("client_cost_absent_reason", "requestStart < start");
        goto L37
    L38:
        r117 = 0;
        r118 = 0;
        r119 = 0;
        goto L39
    L12:
        r104 = null;
    L45:
        th = move-exception;
        throw th;
    }
}
