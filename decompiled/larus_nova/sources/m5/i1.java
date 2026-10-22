package m5;

import android.util.LruCache;
import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class i1 extends a1 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LruCache<String, h1> f511963g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f511964h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LruCache<String, Map<String, Object>> f511965i;

    public i1() {
        this.f511963g = new LruCache(10);
        this.f511964h = "WidgetEventMonitor";
        this.f511965i = new LruCache(10);
    }

    public final JSONObject v(String r210) {
        Intrinsics.checkNotNullParameter(r210, "traceId");
        JSONObject r100 = new JSONObject();
        r100.put("eventName", "applet_widget_timeline_full");
        z0 r101 = d1.a(this.f511919e, r210);
        h1 r102 = d1.d(this.f511917c, r210);
        b1 r103 = d1.b(this.f511918d, r210);
        h1 r104 = d1.d(this.f511915a, r210);
        b1 r105 = d1.b(this.f511916b, r210);
        Object r106 = ((LinkedHashMap) r101.f512061d).get("render_type");
        if ((r106 instanceof String) == false) goto L5;
        String r107 = (String) r106;
    L6:
        JSONObject r110 = new JSONObject();
        r110.put(BindCardPayConfirmConstants.Key.TRACE_ID, r210);
        if (r107 != null) goto L9;
        String r111 = "";
    L10:
        r110.put("render_type", r111);
        r110.put("scene", r101.f512060c);
        Iterator r108 = ((LinkedHashMap) r101.f512061d).entrySet().iterator();
    L12:
        if (r108.hasNext() == false) goto L14;
        Map.Entry r112 = (Map.Entry) r108.next();
        r110.put((String) r112.getKey(), r112.getValue());
        goto L12
    L14:
        r100.put("category", r110);
        if (a(r210, r107) == false) goto L50;
        r110.put("success", 1);
        JSONObject r109 = new JSONObject();
        l5.z.a(r109, r102.f511946a);
        l5.z.a(r109, r103.f511946a);
        l5.z.a(r109, r104.f511946a);
        l5.z.a(r109, r105.f511946a);
        if (r102.c("draw_end") <= 0) goto L20;
        long r113 = r102.c("draw_end");
    L27:
        if (r104.c("update_draw_end") <= 0) goto L29;
        long r114 = r104.c("update_draw_end");
    L30:
        long r115 = r102.c("applet_create_container");
        long r116 = r113;
        long r117 = RangesKt.coerceAtLeast(r104.c("draw_end"), r104.c("load_app_end"));
        if (r117 <= 0) goto L33;
        r109.put("full_tti", r117 - r115);
    L33:
        r109.put("fcp_time", r116 - r115);
        r109.put("full_time", r114 - r115);
        if (r109.opt("load_applet_duration") != null) goto L36;
        int r118 = 0;
        r109.put("load_applet_duration", 0);
    L38:
        if (r109.opt("init_js_worker_duration") != null) goto L41;
        r109.put("init_js_worker_duration", r118);
    L41:
        if (r109.opt("load_main_js_duration") != null) goto L44;
        r109.put("load_main_js_duration", r118);
    L44:
        if (r102.c("app_launch_time") <= 0) goto L47;
        r109.put("app_launch_to_draw_end", r114 - r102.c("app_launch_time"));
    L47:
        if (r102.c("host_page_enter_time") <= 0) goto L49;
        r109.put("host_enter_to_draw_end", r114 - r102.c("host_page_enter_time"));
    L49:
        r100.put("metric", r109);
    L57:
        return r100;
    L36:
        r118 = 0;
        goto L38
    L29:
        r114 = r113;
        goto L30
    L20:
        if (r104.c("draw_end") <= 0) goto L23;
        r113 = r104.c("draw_end");
        goto L27
    L23:
        if (r102.c("page_finish") <= 0) goto L25;
        r113 = r102.c("page_finish");
        goto L27
    L25:
        r113 = 0;
        goto L27
    L50:
        boolean r119 = r101.f512061d.containsKey("error_msg");
        r110.put("success", 0);
        r110.put("error_stage", r101.f512059b);
        if (r119 == false) goto L55;
        Map<String, Integer> r120 = c1.f511929a;
        Integer r121 = r120.get(r101.f512059b);
        if (r121 != null) goto L56;
        r121 = r120.get("unexpectedError");
    L56:
        r110.put("error_stage_code", r121);
        goto L57
    L55:
        r121 = c1.f511929a.get("unknownError");
        goto L56
    L9:
        r111 = r107;
        goto L10
    L5:
        r107 = null;
        goto L6
    }

    public final void w(String r100) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r100, "traceId");
        this.f511917c.remove(r100);
        this.f511918d.remove(r100);
        this.f511919e.remove(r100);
        this.f511915a.remove(r100);
        this.f511916b.remove(r100);
        this.f511963g.remove(r100);
    }

    @Override // m5.a1
    public final void m(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        com.bytedance.ai.utils.g.f37637a.d(this.f511964h, "onPrepareComponentStart: " + r100 + ", " + r101);
        super.m(r100, r101);
        d1.b(this.f511918d, r100).d("widget_to_view", Long.valueOf(r101 - d1.d(this.f511917c, r100).c("applet_load_widget_info_end")));
    }

    @Override // m5.a1
    public final void q(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        com.bytedance.ai.utils.g.f37637a.d(this.f511964h, "onRunAppletRuntimeStart: " + r100 + ", " + r101);
        super.q(r100, r101);
        h1 r102 = d1.d(this.f511917c, r100);
        b1 r103 = d1.b(this.f511918d, r100);
        Intrinsics.checkNotNullParameter("applet_create_container", "start");
        Intrinsics.checkNotNullParameter("applet_run_applet_start", "end");
        long r104 = r102.c("applet_create_container");
        long r105 = r102.c("applet_run_applet_start");
        if (r104 != (-1)) goto L5;
    L8:
        long r106 = 0;
    L9:
        r103.d("create_to_runtime", Long.valueOf(r106));
        return;
    L5:
        if (r105 == (-1)) goto L8;
        r106 = r105 - r104;
        goto L9
    }
}
