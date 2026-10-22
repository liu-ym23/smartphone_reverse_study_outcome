package ly2;

import android.text.TextUtils;
import bz2.f;
import com.bytedance.android.live.browser.q;
import com.bytedance.android.monitor.HybridMonitor;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import ny2.e;
import ny2.g;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class c implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.monitor.webview.a f511295a;

    public c() {
        this.f511295a = q.b.f64160a;
    }

    public static void b(py2.d r100) {
        String r101 = "";
        if (r100 != null) goto L5;
        return;
    L5:
        JSONObject r102 = new JSONObject();
        JSONObject r103 = r100.f530984d;
        if (r103 == null) goto L8;
        bz2.e.h(r102, "client_category", r103);
    L8:
        JSONObject r104 = r100.f530985e;
        if (r104 == null) goto L11;
        bz2.e.h(r102, "client_metric", r104);
    L11:
        JSONObject r105 = r100.f530986f;
        if (r105 == null) goto L14;
        bz2.e.i(r105, ReportCardMonitorPlugin.EVENT_NAME, r100.f530983c);
        bz2.e.h(r102, "client_extra", r100.f530986f);
    L14:
        JSONObject r106 = r100.f530987g;
        if (r106 == null) goto L18;
        bz2.e.h(r102, "client_timing", r106);
    L18:
        if (r100.f530990j == false) goto L20;
        String r107 = "samplecustom";
    L21:
        String r108 = r107;
        String r109 = r100.f530981a;
        bz2.e.i(r102, "url", r109);
        if (r109 != null) goto L41;
    L29:
        bz2.e.i(r102, "ev_type", "custom");
        bz2.e.a(r102, r100.f530988h);
        if (TextUtils.isEmpty(r100.f530989i) == true) goto L32;
        bz2.e.i(r102, "virtual_aid", r100.f530989i);
    L32:
        com.bytedance.android.monitor.webview.a r110 = r100.f530991k;
        String r111 = r100.f530982b;
        if (r110 == null) goto L36;
        c(r110, r102, r108, "", r111, false);     // Catch: Throwable -> L37
        return;
    L36:
        throw new NullPointerException("monitor should not be null");     // Catch: Throwable -> L37
    L37:
        bz2.c.a();
        return;
    L41:
        String r112 = UriProtector.parse(r109).getHost();     // Catch: Exception -> L25
    L26:
        bz2.e.i(r102, "host", r112);
        r101 = UriProtector.parse(r109).getPath();     // Catch: Exception -> L39
    L28:
        bz2.e.i(r102, "path", r101);
    L25:
        r112 = "";
        goto L26
    L20:
        r107 = "newcustom";
        goto L21
    }

    public static void a(g r100, com.bytedance.android.monitor.webview.a r101) {
        if (r100 == null) goto L30;
        if (r101 == null) goto L28;
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L31
        bz2.e.i(r102, "event_type", r100.f().f521188a);     // Catch: Throwable -> L31
        if (r100.a() == null) goto L8;
        bz2.e.h(r102, "nativeBase", r100.a().a());     // Catch: Throwable -> L31
    L8:
        if (r100.f() == null) goto L11;
        bz2.e.h(r102, "nativeInfo", r100.f().a());     // Catch: Throwable -> L31
    L11:
        if (r100.b() == null) goto L14;
        bz2.e.h(r102, "jsInfo", r100.b());     // Catch: Throwable -> L31
    L14:
        if (r100.g() == null) goto L17;
        bz2.e.h(r102, "jsBase", r100.g());     // Catch: Throwable -> L31
    L17:
        if (r100.c() == null) goto L20;
        bz2.e.h(r102, "containerBase", r100.c().a());     // Catch: Throwable -> L31
    L20:
        if (r100.d() == null) goto L23;
        bz2.e.h(r102, "containerInfo", r100.d().a());     // Catch: Throwable -> L31
    L23:
        if ("jsbPerf".equals(r100.getEventType()) == true) goto L25;
        boolean r103 = true;
    L26:
        c(r101, r102, r100.getEventType(), r100.getContainerType(), r100.getBiz(), r103);     // Catch: Throwable -> L31
        return;
    L25:
        r103 = false;
        goto L26
    L28:
        throw new NullPointerException("monitor should not be null");     // Catch: Throwable -> L31
    L30:
        throw new NullPointerException("data should not be null");     // Catch: Throwable -> L31
    L31:
        bz2.c.a();
    }

    public static void c(com.bytedance.android.monitor.webview.a r100, JSONObject r101, String r102, String r103, String r104, boolean r105) {
        JSONObject r106 = new JSONObject();
        bz2.e.h(r106, "extra", r101);
        int r107 = f.f21872a;
        if (r104 != null) goto L7;
        r104 = "";
    L7:
        if (TextUtils.isEmpty(r102) == false) goto L10;
        String r108 = r102;
    L25:
        HybridMonitor.getInstance().notifyReportInterceptor(r108, r102, r103, r106);
        if (r100 != null) goto L28;
    L54:
        if (r105 == false) goto L59;
        bz2.a.b("BDHybridMonitor", String.format("service:%s,data:%s", new Object[]{r108, r106}));
        return;
    L59:
        return;
    L28:
        if (r108 != null) goto L57;
        String r109 = null;
    L34:
        if (TextUtils.isEmpty(r109) == false) goto L36;
        r109 = "default";
    L36:
        d r110 = d.a();     // Catch: Throwable -> L51
        r110.getClass();     // Catch: Throwable -> L51
        if (TextUtils.isEmpty(r109) == false) goto L39;
    L49:
        boolean r111 = false;
    L50:
        boolean r112 = !r111;
    L52:
        if (r112 == false) goto L54;
        r100.a(r108, r106);
        ty2.a.a("DataMonitor");
        goto L54
    L39:
        if (TextUtils.isEmpty(r108) == true) goto L49;
        Set r113 = (Set) ((ConcurrentHashMap) r110.f511297a).get(r109);     // Catch: Throwable -> L51
        if (r113 == null) goto L49;
        if (r113.contains("all") == false) goto L47;
        r111 = true;
        goto L50
    L47:
        r111 = r113.contains(r108);     // Catch: Throwable -> L51
    L51:
        bz2.c.a();
        r112 = true;
        goto L52
    L57:
        JSONObject r114 = bz2.e.c(r106, "extra");     // Catch: Throwable -> L51
        r109 = bz2.e.e(r114, "virtual_aid");     // Catch: Throwable -> L51
        if (TextUtils.isEmpty(r109) == false) goto L34;
        r109 = bz2.e.e(bz2.e.c(r114, "nativeBase"), "virtual_aid");     // Catch: Throwable -> L51
        goto L34
    L10:
        switch(r102.hashCode()) {
            case -1349088399: goto L22;
            case -136676079: goto L19;
            case 571840923: goto L16;
            case 831602183: goto L13;
            default: goto L24;
        };
    L24:
        r108 = "bd_hybrid_monitor_service_" + r102 + '_' + r103 + '_' + r104;
        goto L25
    L13:
        if (r102.equals("containerError") == false) goto L24;
        r108 = "bd_hybrid_monitor_service_containerError_".concat(r104);
        goto L25
    L16:
        if (r102.equals("samplecustom") == false) goto L24;
        r108 = "bd" + r104 + "_hybrid_monitor_custom_sample_service";
        goto L25
    L19:
        if (r102.equals("newcustom") == false) goto L24;
        r108 = "bd" + r104 + "_hybrid_monitor_custom_service";
        goto L25
    L22:
        if (r102.equals("custom") == false) goto L24;
        r108 = "tt" + r104 + "_webview_timing_monitor_custom_service";
        goto L25
    }
}
