package m5;

import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f511939a = 0;

    static {
    }

    public static void a(Map r100, h1 r101, b1 r102) {
        Intrinsics.checkNotNullParameter(r101, "timeStampMap");
        Intrinsics.checkNotNullParameter(r102, "durationMap");
        if (r100 == null) goto L44;
        HashMap r103 = null;
        if (r100.get("metrics") == null) goto L16;
        Object r104 = r100.get("metrics");
        if ((r104 instanceof HashMap) == false) goto L9;
        HashMap r105 = (HashMap) r104;
    L10:
        if (r105 == null) goto L16;
        Object r106 = r100.get("metrics");
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>");
        HashMap r107 = (HashMap) r106;
        Iterator r108 = r107.keySet().iterator();
    L13:
        if (r108.hasNext() == false) goto L16;
        String r109 = (String) r108.next();
        Object r110 = r107.get(r109);
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type kotlin.Long");
        r102.d(r109, (Long) r110);
        goto L13
    L9:
        r105 = null;
    L16:
        if (r100.get("ssr_metrics") == null) goto L27;
        Object r111 = r100.get("ssr_metrics");
        if ((r111 instanceof HashMap) == false) goto L20;
        HashMap r112 = (HashMap) r111;
    L21:
        if (r112 == null) goto L27;
        Object r113 = r100.get("ssr_metrics");
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>");
        HashMap r114 = (HashMap) r113;
        Iterator r115 = r114.keySet().iterator();
    L24:
        if (r115.hasNext() == false) goto L27;
        String r116 = (String) r115.next();
        Object r117 = r114.get(r116);
        Intrinsics.checkNotNull(r117, "null cannot be cast to non-null type kotlin.Long");
        r102.d(r116, (Long) r117);
        goto L24
    L20:
        r112 = null;
    L27:
        if (r100.get(LynxMonitorService.KEY_SETUP_TIMING) == null) goto L35;
        Object r118 = r100.get(LynxMonitorService.KEY_SETUP_TIMING);
        if ((r118 instanceof HashMap) == false) goto L31;
        HashMap r119 = (HashMap) r118;
    L32:
        if (r119 == null) goto L35;
        Object r120 = r100.get(LynxMonitorService.KEY_SETUP_TIMING);
        Intrinsics.checkNotNull(r120, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>");
        HashMap r121 = (HashMap) r120;
        Intrinsics.checkNotNull(r121, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.Any?, kotlin.Any?>");
        r101.a(new JSONObject(r121));
        r102.d("create_lynx", Long.valueOf(b(r121, "create_lynx_start", "create_lynx_end")));
        r102.d("load_core", Long.valueOf(b(r121, "load_core_start", "load_core_end")));
        r102.d("decode", Long.valueOf(b(r121, "decode_start", "decode_end")));
        r102.d("lepus_execute", Long.valueOf(b(r121, "lepus_excute_start", "lepus_excute_end")));
        r102.d("create_vdom", Long.valueOf(b(r121, "create_vdom_start", "create_vdom_end")));
        r102.d("dispatch", Long.valueOf(b(r121, "dispatch_start", "dispatch_end")));
        r102.d("layout", Long.valueOf(b(r121, "layout_start", "layout_end")));
        r102.d("ui_operation_flush", Long.valueOf(b(r121, "ui_operation_flush_start", "ui_operation_flush_end")));
        r102.d("load_app", Long.valueOf(b(r121, "load_app_start", "load_app_end")));
        r102.d("load_template", Long.valueOf(b(r121, "load_template_start", "load_template_end")));
        goto L35
    L31:
        r119 = null;
    L35:
        if (r100.get("ssr_render_page_timing") == null) goto L45;
        Object r122 = r100.get("ssr_render_page_timing");
        if ((r122 instanceof HashMap) == false) goto L39;
        r103 = (HashMap) r122;
    L39:
        if (r103 == null) goto L46;
        Object r123 = r100.get("ssr_render_page_timing");
        Intrinsics.checkNotNull(r123, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>");
        HashMap r124 = (HashMap) r123;
        Intrinsics.checkNotNull(r124, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.Any?, kotlin.Any?>");
        r101.a(new JSONObject(r124));
        r102.d("render_page_ssr", Long.valueOf(b(r124, "render_page_start_ssr", "render_page_end_ssr")));
        r102.d("layout_ssr", Long.valueOf(b(r124, "layout_start_ssr", "layout_end_ssr")));
        r102.d("create_vdom_ssr", Long.valueOf(b(r124, "create_vdom_start_ssr", "create_vdom_end_ssr")));
        r102.d("dispatch_ssr", Long.valueOf(b(r124, "dispatch_start_ssr", "dispatch_end_ssr")));
        r102.d("ui_operation_flush_ssr", Long.valueOf(b(r124, "ui_operation_flush_start_ssr", "ui_operation_flush_end_ssr")));
        r102.d("decode_ssr", Long.valueOf(b(r124, "decode_start_ssr", "decode_end_ssr")));
        return;
    L46:
        return;
    L45:
        return;
    }

    public static long b(HashMap r100, String r101, String r102) {
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
        com.bytedance.ai.utils.g.f37637a.e("LynxTimelineHelper", "getDurationFromMap: " + r105 + ", " + r104 + ", " + r100);
        return 0;
    L5:
        r105 = null;
        goto L6
    }
}
