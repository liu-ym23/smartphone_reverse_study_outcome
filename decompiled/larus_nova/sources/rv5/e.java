package rv5;

import android.webkit.WebView;
import com.bytedance.falconx.statistic.InterceptorModel;
import com.bytedance.geckox.logger.GeckoLogger;
import com.larus.apm.impl.protector.RunnableProtector;
import nv5.f;
import nv5.g;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebView f539487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InterceptorModel f539488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d f539489c;

    public final void a() {
        g.a(this.f539487a, this.f539488b, true);     // Catch: Throwable -> L4
    L6:
        d r100 = this.f539489c;     // Catch: Exception -> L8
        f r101 = r100.f539486b;     // Catch: Exception -> L8
        d.a(r100, r101.f520884h, r101.f520882f, r101.f520886j, this.f539488b);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        GeckoLogger.w("falconx intercept error:", e);
        return;
    L4:
        th = move-exception;
        GeckoLogger.e("WebOfflineGlobalMonitor.onInterceptRequest", th);     // Catch: Exception -> L8
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public e(d r100, WebView r101, InterceptorModel r102) {
        this.f539489c = r100;
        this.f539487a = r101;
        this.f539488b = r102;
    }
}
