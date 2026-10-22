package nv5;

import android.os.SystemClock;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.falconx.statistic.InterceptorModel;
import com.bytedance.geckox.logger.GeckoLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f520875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f520876b;

    public e(f r100) {
        this.f520875a = r100;
        if (rv5.d.f539484c == null) goto L5;
    L14:
        rv5.d.f539484c.f539486b = r100;
        this.f520876b = new a(r100);
        if (ov5.b.f526910a == true) goto L18;
        List<pv5.a> r101 = ov5.a.f526904a;
        return;
    L18:
        if (ov5.a.f526904a != null) goto L20;
        ov5.a.f526904a = new ArrayList();
    L20:
        pv5.a r102 = new pv5.a(r100.f520879c, r100.f520880d);
        if (((ArrayList) ov5.a.f526904a).contains(r102) == true) goto L28;
        ((ArrayList) ov5.a.f526904a).add(r102);
        return;
    L28:
        return;
    L5:
        monitor-enter(rv5.d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (rv5.d.f539484c != null) goto L9;
        rv5.d.f539484c = new rv5.d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(rv5.d.class);     // Catch: Throwable -> L11
        goto L14
    }

    public final WebResourceResponse a(WebView r100, String r101) {
        List<d> r102 = this.f520875a.f520881e;     // Catch: Throwable -> L15
        if (r102 == null) goto L14;
        if (r102.isEmpty() == true) goto L14;
        InterceptorModel r103 = new InterceptorModel();     // Catch: Throwable -> L15
        Iterator<d> r104 = r102.iterator();     // Catch: Throwable -> L15
    L8:
        if (r104.hasNext() == false) goto L14;
        d r105 = r104.next();     // Catch: Throwable -> L15
        r103.startTime = SystemClock.uptimeMillis();     // Catch: Throwable -> L15
        WebResourceResponse r106 = r105.shouldInterceptRequest(r100, r101);     // Catch: Throwable -> L15
        if (r106 == null) goto L8;
        r103.loadFinish(true);     // Catch: Throwable -> L15
        r103.url = r101;     // Catch: Throwable -> L15
        r103.mimeType = r106.getMimeType();     // Catch: Throwable -> L15
        g.a(r100, r103, false);     // Catch: Throwable -> L15
        return r106;
    L14:
        return this.f520876b.shouldInterceptRequest(r100, r101);
    L15:
        th = move-exception;
        GeckoLogger.w("WebOffline-falcon", "shouldInterceptRequest:", th);
        return null;
    }
}
