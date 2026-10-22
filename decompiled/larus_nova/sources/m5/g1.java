package m5;

import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class g1 extends a1 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f511952g;

    public g1() {
        this.f511952g = "PageEventMonitor";
    }

    public final JSONObject v(String r110) {
        Intrinsics.checkNotNullParameter(r110, "traceId");
        JSONObject r100 = new JSONObject();
        r100.put("eventName", "applet_page_timeline_full");
        z0 r101 = d1.a(this.f511919e, r110);
        h1 r102 = d1.d(this.f511917c, r110);
        b1 r103 = d1.b(this.f511918d, r110);
        h1 r104 = d1.d(this.f511915a, r110);
        b1 r105 = d1.b(this.f511916b, r110);
        Object r106 = ((LinkedHashMap) r101.f512061d).get("render_type");
        if ((r106 instanceof String) == false) goto L5;
        String r107 = (String) r106;
    L6:
        JSONObject r111 = new JSONObject();
        r111.put(BindCardPayConfirmConstants.Key.TRACE_ID, r110);
        if (r107 != null) goto L9;
        String r112 = "";
    L10:
        r111.put("render_type", r112);
        r111.put("scene", r101.f512060c);
        Iterator r108 = ((LinkedHashMap) r101.f512061d).entrySet().iterator();
    L12:
        if (r108.hasNext() == false) goto L14;
        Map.Entry r113 = (Map.Entry) r108.next();
        r111.put((String) r113.getKey(), r113.getValue());
        goto L12
    L14:
        r100.put("category", r111);
        if (a(r110, r107) == false) goto L43;
        r111.put("success", 1);
        JSONObject r109 = new JSONObject();
        l5.z.a(r109, r102.f511946a);
        l5.z.a(r109, r103.f511946a);
        l5.z.a(r109, r104.f511946a);
        l5.z.a(r109, r105.f511946a);
        if (r102.c("draw_end") <= 0) goto L20;
        long r114 = r102.c("draw_end");
    L27:
        if (r104.c("update_draw_end") <= 0) goto L29;
        long r115 = r104.c("update_draw_end");
    L30:
        long r116 = r102.c("open_time");
        long r117 = RangesKt.coerceAtLeast(r104.c("draw_end"), r104.c("load_app_end"));
        if (r117 <= 0) goto L33;
        r109.put("full_tti", r117 - r116);
    L33:
        r109.put("fcp_time", r114 - r116);
        r109.put("full_time", r115 - r116);
        if (r109.opt("load_applet_duration") != null) goto L37;
        r109.put("load_applet_duration", 0);
    L37:
        if (r109.opt("init_js_worker_duration") != null) goto L40;
        r109.put("init_js_worker_duration", 0);
    L40:
        if (r109.opt("load_main_js_duration") != null) goto L42;
        r109.put("load_main_js_duration", 0);
    L42:
        r100.put("metric", r109);
        return r100;
    L29:
        r115 = r114;
        goto L30
    L20:
        if (r104.c("draw_end") <= 0) goto L23;
        r114 = r104.c("draw_end");
        goto L27
    L23:
        if (r102.c("page_finish") <= 0) goto L25;
        r114 = r102.c("page_finish");
        goto L27
    L25:
        r114 = 0;
        goto L27
    L43:
        boolean r118 = r101.f512061d.containsKey("error_msg");
        r111.put("success", 0);
        r111.put("error_stage", r101.f512059b);
        if (r118 == false) goto L48;
        Map<String, Integer> r119 = c1.f511929a;
        Integer r120 = r119.get(r101.f512059b);
        if (r120 != null) goto L49;
        r120 = r119.get("unexpectedError");
    L49:
        r111.put("error_stage_code", r120);
        return r100;
    L48:
        r120 = c1.f511929a.get("unknownError");
        goto L49
    L9:
        r112 = r107;
        goto L10
    L5:
        r107 = null;
        goto L6
    }

    @Override // m5.a1
    public final void m(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        com.bytedance.ai.utils.g.f37637a.d(this.f511952g, "onPrepareComponentStart: " + r100 + ", " + r101);
        super.m(r100, r101);
        d1.b(this.f511918d, r100).d("page_to_view", Long.valueOf(r101 - d1.d(this.f511917c, r100).c("create_page")));
    }

    @Override // m5.a1
    public final void q(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        com.bytedance.ai.utils.g.f37637a.d(this.f511952g, "onRunAppletRuntimeStart: " + r100 + ", " + r101);
        super.q(r100, r101);
        d1.b(this.f511918d, r100).d("create_to_runtime", Long.valueOf(r101 - d1.d(this.f511917c, r100).c("open_time")));
    }
}
