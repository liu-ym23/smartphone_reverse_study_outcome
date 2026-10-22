package com.bytedance.locallife.poi.dito.mob;

import com.bytedance.locallife.biz.fmp.PoiChainDurationMonitor;
import com.bytedance.locallife.biz.utils.c;
import com.bytedance.locallife.dito.data.DitoPageInfo;
import com.bytedance.locallife.groupon.struct.innerpush.Action;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f262418a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, PoiChainDurationMonitor> f262419b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, nn6.a> f262420c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ThreadLocal<String> f262421d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, HashMap<String, String>> f262422e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f262423f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Long f262424g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Long f262425h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Long f262426i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Long f262427j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static Long f262428k;

    public a() {
    }

    static {
        f262418a = new a();
        f262419b = new LinkedHashMap();
        f262420c = new LinkedHashMap();
        f262421d = new ThreadLocal();
        f262422e = new LinkedHashMap();
        f262423f = "";
    }

    public static void b(String r110, PoiChainDurationMonitor r111, nn6.a r112, DitoPageInfo r113) {
        r111.h(Action.TYPE_SUB_PAGE, f262423f);
        boolean r100 = false;
        if (r112 == null) goto L9;
        Map<String, String> r101 = r112.f519664c;
        if (r101 == null) goto L9;
        if (((HashMap) r101).containsKey("req_total") != true) goto L9;
        boolean r102 = true;
    L11:
        if (r102 == false) goto L16;
        String r103 = (String) ((HashMap) r112.f519664c).get("req_total");
        if (r103 == null) goto L16;
        String r104 = r103;
    L18:
        if (r112 == null) goto L24;
        Map<String, String> r105 = r112.f519664c;
        if (r105 == null) goto L24;
        if (((HashMap) r105).containsKey("response_content_length") != true) goto L24;
        boolean r106 = true;
    L25:
        if (r106 == false) goto L30;
        String r107 = (String) ((HashMap) r112.f519664c).get("response_content_length");
        if (r107 == null) goto L30;
        String r108 = r107;
    L32:
        if (r112 == null) goto L38;
        Map<String, String> r109 = r112.f519664c;
        if (r109 == null) goto L38;
        if (((HashMap) r109).containsKey("before_req") != true) goto L38;
        boolean r114 = true;
    L39:
        if (r114 == false) goto L44;
        String r115 = (String) ((HashMap) r112.f519664c).get("before_req");
        if (r115 == null) goto L44;
        String r116 = r115;
    L46:
        if (r112 == null) goto L52;
        Map<String, String> r117 = r112.f519664c;
        if (r117 == null) goto L52;
        if (((HashMap) r117).containsKey("after_req") != true) goto L52;
        r100 = true;
    L52:
        if (r100 == false) goto L57;
        String r118 = (String) ((HashMap) r112.f519664c).get("after_req");
        if (r118 == null) goto L57;
        String r119 = r118;
    L58:
        int r120 = c.f256986a;
        Map<String, HashMap<String, String>> r121 = f262422e;
        c.k(r111, r104, r108, r116, r119, (HashMap) ((LinkedHashMap) r121).get(r110), r113);
        f262420c.remove(r110);
        f262419b.remove(r110);
        r121.remove(r110);
        return;
    L57:
        r119 = "";
    L44:
        r116 = "";
    L38:
        r114 = false;
    L30:
        r108 = "";
    L24:
        r106 = false;
    L16:
        r104 = "";
    L9:
        r102 = false;
        goto L11
    }

    public final synchronized void a(String r100, nn6.a r101, HashMap<String, String> r102, String r103, DitoPageInfo r104, String r105, String r106) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r101, "poiDurationMonitor");     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r102, "params");     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r103, "subPage");     // Catch: Throwable -> L19
        f262423f = r103;     // Catch: Throwable -> L19
        if (r100 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        f262422e.put(r100, r102);     // Catch: Throwable -> L19
        Map<String, PoiChainDurationMonitor> r107 = f262419b;     // Catch: Throwable -> L19
        if (r107.containsKey(r100) == false) goto L16;
        PoiChainDurationMonitor r108 = (PoiChainDurationMonitor) ((LinkedHashMap) r107).get(r100);     // Catch: Throwable -> L19
        if (r108 == null) goto L17;
        if (r105 == null) goto L13;
        r108.a("server_trace", r105);     // Catch: Throwable -> L19
    L13:
        if (r106 == null) goto L15;
        r108.a("network_detail_time", r106);     // Catch: Throwable -> L19
    L15:
        b(r100, r108, r101, r104);     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);
        return;
    L16:
        f262420c.put(r100, r101);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }
}
