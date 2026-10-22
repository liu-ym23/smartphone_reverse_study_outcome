package sy2;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public final class e extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, String> f543864b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile e f543865c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f543866a;

    static {
        HashMap r100 = new HashMap();
        f543864b = r100;
        r100.put("pv", String.format("tt%s_webview_timing_monitor_pv_service", new Object[]{"live"}));
        r100.put("overview", String.format("tt%s_webview_timing_monitor_overview_service", new Object[]{"live"}));
        r100.put("performance", String.format("tt%s_webview_timing_monitor_performance_service", new Object[]{"live"}));
        r100.put("resource", String.format("tt%s_webview_timing_monitor_resource_service", new Object[]{"live"}));
        r100.put("error", String.format("tt%s_webview_timing_monitor_error_service", new Object[]{"live"}));
        r100.put("diff", String.format("tt%s_webview_timing_monitor_diff_service", new Object[]{"live"}));
        r100.put("custom", String.format("tt%s_webview_timing_monitor_custom_service", new Object[]{"live"}));
        r100.put("newcustom", String.format("bd%s_hybrid_monitor_custom_service", new Object[]{"live"}));
    }

    public e() {
    }
}
