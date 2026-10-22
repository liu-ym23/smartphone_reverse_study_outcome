package com.bytedance.locallife.pdp.mob;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.locallife.biz.fmp.PoiChainDurationMonitor;
import com.bytedance.locallife.common.utils.j;
import com.bytedance.locallife.dito.data.DitoPageInfo;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f261576a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<String> f261577b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, PoiChainDurationMonitor> f261578c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, nn6.a> f261579d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, PoiChainDurationMonitor> f261580e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<String, Long> f261581f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Map<String, Long> f261582g = null;

    public b() {
    }

    static {
        f261576a = new b();
        f261577b = new ThreadLocal();
        f261578c = new LinkedHashMap();
        f261579d = new LinkedHashMap();
        f261580e = new LinkedHashMap();
        new LinkedHashMap();
        f261581f = new LinkedHashMap();
        f261582g = new LinkedHashMap();
    }

    public static void b(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        Map<String, Long> r102 = f261582g;
        if (r102.containsKey(r100) == false) goto L8;
        return;
    L8:
        r102.put(r100, Long.valueOf(r101));
    }

    public static void a(String r110, PoiChainDurationMonitor r111, nn6.a r112, HashMap r113, DitoPageInfo r114) {
        int r100 = j.f257151a;
        String r101 = null;
        if (r114 == null) goto L5;
        String r102 = r114.getId();
    L7:
        if (j.a(r102) == false) goto L14;
        Map<String, String> r103 = r111.f256674e;
        if (r114 == null) goto L11;
        r101 = r114.getPageId();
    L11:
        if (r101 != null) goto L13;
        r101 = "";
    L13:
        ((ConcurrentHashMap) r103).put("dito_page_entity_id", r101);
    L14:
        boolean r104 = false;
        if (r112 == null) goto L21;
        Map<String, String> r105 = r112.f519664c;
        if (r105 == null) goto L21;
        if (((HashMap) r105).containsKey("req_total") != true) goto L21;
        boolean r106 = true;
    L22:
        if (r106 == false) goto L27;
        String r107 = (String) ((HashMap) r112.f519664c).get("req_total");
        if (r107 == null) goto L27;
        String r108 = r107;
    L29:
        if (r112 == null) goto L35;
        Map<String, String> r109 = r112.f519664c;
        if (r109 == null) goto L35;
        if (((HashMap) r109).containsKey("response_content_length") != true) goto L35;
        boolean r115 = true;
    L36:
        if (r115 == false) goto L41;
        String r116 = (String) ((HashMap) r112.f519664c).get("response_content_length");
        if (r116 == null) goto L41;
        String r117 = r116;
    L43:
        if (r112 == null) goto L49;
        Map<String, String> r118 = r112.f519664c;
        if (r118 == null) goto L49;
        if (((HashMap) r118).containsKey("before_req") != true) goto L49;
        boolean r119 = true;
    L50:
        if (r119 == false) goto L55;
        String r120 = (String) ((HashMap) r112.f519664c).get("before_req");
        if (r120 == null) goto L55;
        String r121 = r120;
    L57:
        if (r112 == null) goto L63;
        Map<String, String> r122 = r112.f519664c;
        if (r122 == null) goto L63;
        if (((HashMap) r122).containsKey("after_req") != true) goto L63;
        r104 = true;
    L63:
        if (r104 == false) goto L68;
        String r123 = (String) ((HashMap) r112.f519664c).get("after_req");
        if (r123 == null) goto L68;
        String r124 = r123;
    L69:
        int r125 = com.bytedance.locallife.biz.utils.c.f256986a;
        com.bytedance.locallife.biz.utils.c.k(r111, r108, r117, r121, r124, r113, r114);
        f261579d.remove(r110);
        f261578c.remove(r110);
        return;
    L68:
        r124 = "";
    L55:
        r121 = "";
    L49:
        r119 = false;
    L41:
        r117 = "";
    L35:
        r115 = false;
    L27:
        r108 = "";
    L21:
        r106 = false;
        goto L22
    L5:
        r102 = null;
        goto L7
    }
}
