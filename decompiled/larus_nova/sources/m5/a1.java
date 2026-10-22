package m5;

import com.bytedance.ai.monitor.timeline.LoadingStage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, h1> f511915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, b1> f511916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, h1> f511917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, b1> f511918d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, z0> f511919e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f511920f;

    public a1() {
        this.f511915a = new LinkedHashMap();
        this.f511916b = new LinkedHashMap();
        this.f511917c = new LinkedHashMap();
        this.f511918d = new LinkedHashMap();
        this.f511919e = new LinkedHashMap();
        this.f511920f = "CommonEventMonitor";
    }

    public final boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        z0 r101 = d1.a(this.f511919e, r100);
        if (r101.f512060c.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return true;
    L8:
        if (r101.f512058a == true) goto L13;
        return false;
    L13:
        return true;
    L5:
        r102 = false;
        goto L6
    }

    public final void t(String r100) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        d1.a(this.f511919e, r100).f512058a = true;
    }

    public final boolean u(String r100) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Object r101 = ((LinkedHashMap) d1.a(this.f511919e, r100).f512061d).get("render_type");
        if ((r101 instanceof String) == false) goto L5;
        String r102 = (String) r101;
    L6:
        if (r102 != null) goto L9;
        return false;
    L9:
        return a(r100, r102);
    L5:
        r102 = null;
        goto L6
    }

    public final boolean a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        if (r101 != null) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r101, "lynx") == false) goto L10;
        if (d1.d(this.f511915a, r100).c("draw_end") <= 0) goto L16;
    L13:
        return true;
    L16:
        return false;
    L10:
        if (Intrinsics.areEqual(r101, "webview") == false) goto L13;
        if (d1.d(this.f511917c, r100).c("page_finish") > 0) goto L13;
        return false;
    }

    public final void d(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r100, "traceId");
        com.bytedance.ai.utils.g.f37637a.d(this.f511920f, "onInitJSWorkerEnd: " + r100 + ", " + r101);
        h1 r102 = d1.d(this.f511917c, r100);
        r102.d("applet_init_js_worker_end", Long.valueOf(r101));
        d1.b(this.f511918d, r100).d("init_js_worker_duration", Long.valueOf(r101 - r102.c("applet_init_js_worker_start")));
    }

    public final void e(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r100, "traceId");
        com.bytedance.ai.utils.g.f37637a.d(this.f511920f, "onInitJSWorkerStart: " + r100 + ", " + r101);
        d1.d(this.f511917c, r100).d("applet_init_js_worker_start", Long.valueOf(r101));
        d1.a(this.f511919e, r100).a(LoadingStage.STAGE_RUN_MAIN_JS.getStageName());
    }

    public final void g(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r100, "traceId");
        com.bytedance.ai.utils.g.f37637a.d(this.f511920f, "onLoadAppletStart: " + r100 + ", " + r101);
        d1.d(this.f511917c, r100).d("applet_load_applet_info_start", Long.valueOf(r101));
        d1.a(this.f511919e, r100).a(LoadingStage.STAGE_LOAD_APPLET.getStageName());
    }

    public final void i(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r100, "traceId");
        com.bytedance.ai.utils.g.f37637a.d(this.f511920f, "onLoadMainJSStart: " + r100 + ", " + r101);
        d1.d(this.f511917c, r100).d("applet_load_main_js_start", Long.valueOf(r101));
        d1.a(this.f511919e, r100).a(LoadingStage.STAGE_LOAD_MAIN_JS.getStageName());
    }

    public final void j(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r100, "traceId");
        com.bytedance.ai.utils.g.f37637a.d(this.f511920f, "onPageFinished: " + r100 + ", " + r101);
        h1 r102 = d1.d(this.f511917c, r100);
        r102.d("page_finish", Long.valueOf(r101));
        d1.b(this.f511918d, r100).d("load_template_duration", Long.valueOf(r101 - r102.c("page_start")));
    }

    public final void k(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r100, "traceId");
        com.bytedance.ai.utils.g.f37637a.d(this.f511920f, "onPageStart: " + r100 + ", " + r101);
        d1.d(this.f511917c, r100).d("page_start", Long.valueOf(r101));
    }

    public final void l(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r100, "traceId");
        com.bytedance.ai.utils.g.f37637a.d(this.f511920f, "onPrepareComponentEnd: " + r100 + ", " + r101);
        h1 r102 = d1.d(this.f511917c, r100);
        r102.d("prepare_component_end", Long.valueOf(r101));
        d1.b(this.f511918d, r100).d("prepare_component_duration", Long.valueOf(r101 - r102.c("prepare_component_start")));
    }

    public void m(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r100, "traceId");
        com.bytedance.ai.utils.g.f37637a.d(this.f511920f, "onPrepareComponentStart: " + r100 + ", " + r101);
        d1.d(this.f511917c, r100).d("prepare_component_start", Long.valueOf(r101));
        d1.a(this.f511919e, r100).a(LoadingStage.STAGE_PREPARE_COMPONENT.getStageName());
    }

    public final void n(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r100, "traceId");
        com.bytedance.ai.utils.g.f37637a.d(this.f511920f, "onRenderTemplateEnd: " + r100 + ", " + r101);
        h1 r102 = d1.d(this.f511917c, r100);
        r102.d("render_template_end", Long.valueOf(r101));
        d1.b(this.f511918d, r100).d("render_template_main", Long.valueOf(r101 - r102.c("render_template_start")));
    }

    public void q(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r100, "traceId");
        com.bytedance.ai.utils.g.f37637a.d(this.f511920f, "onRunAppletRuntimeStart: " + r100 + ", " + r101);
        d1.d(this.f511917c, r100).d("applet_run_applet_start", Long.valueOf(r101));
        d1.a(this.f511919e, r100).a(LoadingStage.STAGE_RUN_APPLET_RUNTIME.getStageName());
    }

    public final void c(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        com.bytedance.ai.utils.g.f37637a.d(this.f511920f, "onError: " + r100 + ", " + r101 + ", " + r102);
        z0 r103 = d1.a(this.f511919e, r100);
        r103.f512061d.put("error_msg", r101);
        r103.f512061d.put("error_code", Integer.valueOf(r102));
    }

    public final void f(String r100, long r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r102, "eventInfo");
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r102, "eventInfo");
        com.bytedance.ai.utils.g.f37637a.d(this.f511920f, "onLoadAppletEnd: " + r100 + ", " + r101);
        h1 r103 = d1.d(this.f511917c, r100);
        r103.d("applet_load_applet_info_end", Long.valueOf(r101));
        d1.a(this.f511919e, r100).f512061d.putAll(r102);
        d1.b(this.f511918d, r100).d("load_applet_duration", Long.valueOf(r101 - r103.c("applet_load_applet_info_start")));
    }

    public final void h(String r100, long r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r102, "eventInfo");
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r102, "eventInfo");
        com.bytedance.ai.utils.g.f37637a.d(this.f511920f, "onLoadMainJSEnd: " + r100 + ", " + r101);
        h1 r103 = d1.d(this.f511917c, r100);
        r103.d("applet_load_main_js_end", Long.valueOf(r101));
        d1.a(this.f511919e, r100).f512061d.putAll(r102);
        d1.b(this.f511918d, r100).d("load_main_js_duration", Long.valueOf(r101 - r103.c("applet_load_main_js_start")));
        d1.a(this.f511919e, r100).a(LoadingStage.STAGE_RUN_MAIN_JS.getStageName());
    }

    public final void o(String r100, long r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r102, "eventInfo");
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r102, "eventInfo");
        com.bytedance.ai.utils.g.f37637a.d(this.f511920f, "onRenderTemplateStart: " + r100 + ", " + r101);
        h1 r103 = d1.d(this.f511917c, r100);
        r103.d("render_template_start", Long.valueOf(r101));
        d1.b(this.f511918d, r100).d("view_create_to_render", Long.valueOf(r101 - r103.c("prepare_component_end")));
        z0 r104 = d1.a(this.f511919e, r100);
        r104.a(LoadingStage.STAGE_RENDER_TEMPLATE.getStageName());
        r104.f512061d.putAll(r102);
    }

    public final void p(String r100, long r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r102, "eventInfo");
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r102, "eventInfo");
        com.bytedance.ai.utils.g.f37637a.d(this.f511920f, "onRunAppletRuntimeEnd: " + r100 + ", " + r101);
        h1 r103 = d1.d(this.f511917c, r100);
        r103.d("applet_run_applet_end", Long.valueOf(r101));
        d1.a(this.f511919e, r100).f512061d.putAll(r102);
        d1.b(this.f511918d, r100).d("load_applet_runtime_duration", Long.valueOf(r101 - r103.c("applet_run_applet_start")));
    }

    public final void s(String r100, long r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r100, "traceId");
        com.bytedance.ai.utils.g.f37637a.d(this.f511920f, "onWebDrawEnd: " + r100 + ", " + r101 + ", " + r102);
        h1 r103 = d1.d(this.f511917c, r100);
        r103.d("navigation_start", Long.valueOf(r101));
        r103.d("draw_end", Long.valueOf(r102));
        d1.b(this.f511918d, r100).d("web_fmp", Long.valueOf(r102 - r101));
    }

    public final void r(String r100, Map<String, Object> r101, Map<String, Long> r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        h1 r102 = d1.d(this.f511915a, r100);
        b1 r103 = d1.b(this.f511916b, r100);
        e1.a(r101, r102, r103);
        Intrinsics.checkNotNullParameter(r102, "timeStampMap");
        Intrinsics.checkNotNullParameter(r103, "durationMap");
        Long r104 = null;
        if (r101 == null) goto L16;
        if (r101.get("metrics") == null) goto L16;
        Object r105 = r101.get("metrics");
        if ((r105 instanceof HashMap) == false) goto L9;
        HashMap r106 = (HashMap) r105;
    L10:
        if (r106 == null) goto L16;
        Object r107 = r101.get("metrics");
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>");
        HashMap r108 = (HashMap) r107;
        Iterator r109 = r108.keySet().iterator();
    L13:
        if (r109.hasNext() == false) goto L16;
        String r112 = (String) r109.next();
        Object r113 = r108.get(r112);
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type kotlin.Long");
        r103.d(r112, (Long) r113);
        goto L13
    L9:
        r106 = null;
    L16:
        if ((r110 instanceof HashMap) == false) goto L18;
        HashMap r114 = (HashMap) r110;
    L19:
        if (r114 == null) goto L29;
        Iterator r115 = r114.keySet().iterator();
    L22:
        if (r115.hasNext() == false) goto L24;
        String r116 = (String) r115.next();
        Object r117 = r114.get(r116);
        Intrinsics.checkNotNull(r117, "null cannot be cast to non-null type kotlin.Long");
        r102.d(r116, (Long) r117);
        goto L22
    L24:
        r103.d("create_vdom", Long.valueOf(e1.b(r114, "create_vdom_start", "create_vdom_end")));
        r103.d("dispatch", Long.valueOf(e1.b(r114, "dispatch_start", "dispatch_end")));
        r103.d("layout", Long.valueOf(e1.b(r114, "layout_start", "layout_end")));
        r103.d("ui_operation_flush", Long.valueOf(e1.b(r114, "ui_operation_flush_start", "ui_operation_flush_end")));
        r103.d("load_app_end", Long.valueOf(e1.b(r114, "api_request_start", "api_request_end")));
        Object r118 = r114.get("draw_end");
        if ((r118 instanceof Long) == false) goto L27;
        r104 = (Long) r118;
    L27:
        if (r104 == null) goto L29;
        r102.d("update_draw_end", Long.valueOf(r104.longValue()));
    L29:
        z0 r119 = d1.a(this.f511919e, r100);
        if (r111 == null) goto L35;
        r119.f512061d.put("lynx_update_flag", r111);
        return;
    L35:
        return;
    L18:
        r114 = null;
        goto L19
    }
}
