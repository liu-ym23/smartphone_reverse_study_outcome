package i36;

import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f488109a = 0;

    static {
    }

    public static JSONObject a(d r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "timeStampMap");
        Intrinsics.checkNotNullParameter(r101, "durationMap");
        JSONObject r102 = new JSONObject();
        r102.put("timing", r100.f488108a);
        r102.put("duration", r101.f488108a);
        return r102;
    }

    public static JSONObject f(d r100, a r110) {
        Intrinsics.checkNotNullParameter(r100, "timeStampMap");
        Intrinsics.checkNotNullParameter(r110, "durationMap");
        JSONObject r101 = new JSONObject();
        k36.a.b(r101, r110.f488108a);
        r101.put("tti_time", r101.optLong("tti"));
        r101.put("lynx_tti_time", r101.optLong("lynx_tti"));
        Long r102 = Long.valueOf(r100.b("draw_end"));
        boolean r103 = false;
        if (r102.longValue() <= 0) goto L5;
        boolean r104 = true;
    L6:
        Long r105 = null;
        if (r104 == true) goto L10;
        r102 = null;
    L10:
        if (r102 == null) goto L12;
        r101.put("draw_end", r102.longValue());
    L12:
        Long r106 = Long.valueOf(r100.b("update_draw_end"));
        if (r106.longValue() <= 0) goto L15;
        r103 = true;
    L15:
        if (r103 == false) goto L17;
        r105 = r106;
    L17:
        if (r105 == null) goto L19;
        r101.put("update_draw_end", r105.longValue());
    L19:
        return r101;
    L5:
        r104 = false;
        goto L6
    }

    public static void b(Map r100, d r101, a r110) {
        Intrinsics.checkNotNullParameter(r101, "timeStampMap");
        Intrinsics.checkNotNullParameter(r110, "durationMap");
        if (r100 == null) goto L44;
        HashMap r102 = null;
        if (r100.get("metrics") != null) goto L11;
        Object r103 = r100.get("metrics");
        if ((r103 instanceof HashMap) == false) goto L9;
        HashMap r104 = (HashMap) r103;
    L10:
        if (r104 != null) goto L11;
    L16:
        if (r100.get("ssr_metrics") != null) goto L22;
        Object r105 = r100.get("ssr_metrics");
        if ((r105 instanceof HashMap) == false) goto L20;
        HashMap r106 = (HashMap) r105;
    L21:
        if (r106 != null) goto L22;
    L27:
        if (r100.get(LynxMonitorService.KEY_SETUP_TIMING) != null) goto L33;
        Object r107 = r100.get(LynxMonitorService.KEY_SETUP_TIMING);
        if ((r107 instanceof HashMap) == false) goto L31;
        HashMap r108 = (HashMap) r107;
    L32:
        if (r108 != null) goto L33;
    L35:
        if (r100.get("ssr_render_page_timing") != null) goto L40;
        Object r109 = r100.get("ssr_render_page_timing");
        if ((r109 instanceof HashMap) == false) goto L39;
        r102 = (HashMap) r109;
    L39:
        if (r102 != null) goto L40;
        return;
    L40:
        Object r111 = r100.get("ssr_render_page_timing");
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
        HashMap r112 = (HashMap) r111;
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.Any?, kotlin.Any?>");
        JSONObject r113 = new JSONObject(r112);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r113, "jsonObject");
        k36.a.b(r101.f488108a, r113);
        r110.c("render_page_ssr", Long.valueOf(e(r112, "render_page_start_ssr", "render_page_end_ssr")));
        r110.c("layout_ssr", Long.valueOf(e(r112, "layout_start_ssr", "layout_end_ssr")));
        r110.c("create_vdom_ssr", Long.valueOf(e(r112, "create_vdom_start_ssr", "create_vdom_end_ssr")));
        r110.c("dispatch_ssr", Long.valueOf(e(r112, "dispatch_start_ssr", "dispatch_end_ssr")));
        r110.c("ui_operation_flush_ssr", Long.valueOf(e(r112, "ui_operation_flush_start_ssr", "ui_operation_flush_end_ssr")));
        r110.c("decode_ssr", Long.valueOf(e(r112, "decode_start_ssr", "decode_end_ssr")));
        return;
    L31:
        r108 = null;
    L33:
        Object r114 = r100.get(LynxMonitorService.KEY_SETUP_TIMING);
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
        HashMap r115 = (HashMap) r114;
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.Any?, kotlin.Any?>");
        JSONObject r116 = new JSONObject(r115);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r116, "jsonObject");
        k36.a.b(r101.f488108a, r116);
        r110.c("create_lynx", Long.valueOf(e(r115, "create_lynx_start", "create_lynx_end")));
        r110.c("load_core", Long.valueOf(e(r115, "load_core_start", "load_core_end")));
        r110.c("decode", Long.valueOf(e(r115, "decode_start", "decode_end")));
        r110.c("lepus_execute", Long.valueOf(e(r115, "lepus_excute_start", "lepus_excute_end")));
        r110.c("create_vdom", Long.valueOf(e(r115, "create_vdom_start", "create_vdom_end")));
        r110.c("dispatch", Long.valueOf(e(r115, "dispatch_start", "dispatch_end")));
        r110.c("layout", Long.valueOf(e(r115, "layout_start", "layout_end")));
        r110.c("ui_operation_flush", Long.valueOf(e(r115, "ui_operation_flush_start", "ui_operation_flush_end")));
        r110.c("load_app", Long.valueOf(e(r115, "load_app_start", "load_app_end")));
        r110.c("load_template", Long.valueOf(e(r115, "load_template_start", "load_template_end")));
        goto L35
    L20:
        r106 = null;
    L22:
        Object r117 = r100.get("ssr_metrics");
        Intrinsics.checkNotNull(r117, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
        HashMap r118 = (HashMap) r117;
        Iterator r119 = r118.keySet().iterator();
    L24:
        if (r119.hasNext() == false) goto L27;
        String r120 = (String) r119.next();
        Object r121 = r118.get(r120);
        Intrinsics.checkNotNull(r121, "null cannot be cast to non-null type kotlin.Long");
        r110.c(r120, (Long) r121);
        goto L24
    L9:
        r104 = null;
    L11:
        Object r122 = r100.get("metrics");
        Intrinsics.checkNotNull(r122, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
        HashMap r123 = (HashMap) r122;
        Iterator r124 = r123.keySet().iterator();
    L13:
        if (r124.hasNext() == false) goto L16;
        String r125 = (String) r124.next();
        Object r126 = r123.get(r125);
        Intrinsics.checkNotNull(r126, "null cannot be cast to non-null type kotlin.Long");
        r110.c(r125, (Long) r126);
        goto L13
    }

    public static long e(HashMap r100, String r101, String r102) {
        Object r103 = r100.get(r101);
        Long r104 = null;
        if ((r103 instanceof Long) == false) goto L5;
        Long r105 = (Long) r103;
    L6:
        Object r106 = r100.get(r102);
        if ((r106 instanceof Long) == false) goto L9;
        r104 = (Long) r106;
    L9:
        if (r105 == null) goto L14;
        if (r104 == null) goto L14;
        return r104.longValue() - r105.longValue();
    L14:
        r100.toString();
        return 0;
    L5:
        r105 = null;
        goto L6
    }

    public static void c(Map r100, Map r101, d r102, a r103) {
        Intrinsics.checkNotNullParameter(r102, "timeStampMap");
        Intrinsics.checkNotNullParameter(r103, "durationMap");
        if (r100 != null) goto L5;
    L15:
        if (r101 == null) goto L21;
        Long r104 = (Long) r101.get("draw_end");
        if (r104 == null) goto L22;
        r102.c("update_draw_end", Long.valueOf(r104.longValue()));
        return;
    L22:
        return;
    L21:
        return;
    L5:
        if (r100.get("metrics") != null) goto L11;
        Object r105 = r100.get("metrics");
        if ((r105 instanceof HashMap) == false) goto L9;
        HashMap r106 = (HashMap) r105;
    L10:
        if (r106 == null) goto L15;
    L9:
        r106 = null;
    L11:
        Object r107 = r100.get("metrics");
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
        HashMap r108 = (HashMap) r107;
        Iterator r109 = r108.keySet().iterator();
    L13:
        if (r109.hasNext() == false) goto L15;
        String r110 = (String) r109.next();
        Object r111 = r108.get(r110);
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type kotlin.Long");
        r103.c(r110, (Long) r111);
        goto L13
    }

    public static void d(Map r100, Map r101, d r102, a r103) {
        Intrinsics.checkNotNullParameter(r102, "timeStampMap");
        Intrinsics.checkNotNullParameter(r103, "durationMap");
        HashMap r104 = null;
        if (r100 == null) goto L16;
        if (r100.get("metrics") != null) goto L11;
        Object r105 = r100.get("metrics");
        if ((r105 instanceof HashMap) == false) goto L9;
        HashMap r106 = (HashMap) r105;
    L10:
        if (r106 == null) goto L16;
    L9:
        r106 = null;
    L11:
        Object r107 = r100.get("metrics");
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
        HashMap r108 = (HashMap) r107;
        Iterator r109 = r108.keySet().iterator();
    L13:
        if (r109.hasNext() == false) goto L16;
        String r110 = (String) r109.next();
        Object r111 = r108.get(r110);
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type kotlin.Long");
        r103.c(r110, (Long) r111);
    L16:
        if ((r101 instanceof HashMap) == false) goto L18;
        r104 = (HashMap) r101;
    L18:
        if (r104 == null) goto L27;
        Iterator r112 = r104.keySet().iterator();
    L21:
        if (r112.hasNext() == false) goto L23;
        String r113 = (String) r112.next();
        Object r114 = r104.get(r113);
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type kotlin.Long");
        r102.c(r113, (Long) r114);
        goto L21
    L23:
        r103.c("create_vdom", Long.valueOf(e(r104, "create_vdom_start", "create_vdom_end")));
        r103.c("dispatch", Long.valueOf(e(r104, "dispatch_start", "dispatch_end")));
        r103.c("layout", Long.valueOf(e(r104, "layout_start", "layout_end")));
        r103.c("ui_operation_flush", Long.valueOf(e(r104, "ui_operation_flush_start", "ui_operation_flush_end")));
        return;
    }
}
