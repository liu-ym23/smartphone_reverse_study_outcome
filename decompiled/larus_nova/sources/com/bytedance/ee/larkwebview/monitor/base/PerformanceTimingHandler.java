package com.bytedance.ee.larkwebview.monitor.base;

import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.bytedance.ee.larkwebview.base.LarkWebView;
import ft5.a;
import gt5.p;
import java.io.Serializable;
import st5.g;
import st5.o;

/* JADX INFO: loaded from: classes19.dex */
public class PerformanceTimingHandler implements Serializable {
    public static final String API_NAME = "_container_performance_timing";
    public static final String FETCH_TIMING_RECORD = "javascript:window._container_performance_timing.report(JSON.stringify(performance.timing.toJSON()))";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f242890a = true;

    public PerformanceTimingHandler() {
    }

    public static void enableTTPerformanceTiming(WebView r100) {
        if (r100 == null) goto L5;
        r100.evaluateJavascript("ttwebview:/*enableTTLogEvent*/;", null);
        return;
    }

    @JavascriptInterface
    public void report(String r100) {
        int r101 = p.f482566a;
        p.d(f242890a, null, r100, null);
        throw null;
    }

    public static void reportPerformanceTiming(WebView r100, boolean r101, String r102, a r103) {
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof LarkWebView) == false) goto L9;
        o r104 = ((LarkWebView) r100).getServiceManager();
        if (r104 == null) goto L9;
        g r105 = (g) r104.a(g.class);
    L10:
        if (r105 != null) goto L12;
        return;
    L12:
        if (r105.B() == null) goto L16;
        r105.B().getPerformanceTiming();
        p.d(r101, r102, null, r103);
        return;
    L16:
        return;
    L9:
        r105 = null;
        goto L10
    }
}
