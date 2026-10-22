package ez2;

import android.app.Activity;
import android.webkit.WebView;
import com.bytedance.android.monitor.HybridMonitor;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes12.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f474843a;

    @Override // java.lang.Runnable
    public final void run() {
        WebView r100 = this.f474843a.f474844j.get();     // Catch: Throwable -> L8
        if (r100 == null) goto L11;
        Activity r101 = bz2.b.a(r100.getContext());     // Catch: Throwable -> L8
        if (r101 == null) goto L15;
        HybridMonitor.getInstance().wrapTouchTraceCallback(r101);     // Catch: Throwable -> L8
        c r102 = this.f474843a;     // Catch: Throwable -> L8
        r102.f474845k = r101.getClass().getName();     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L11:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }

    public b(c r100) {
        this.f474843a = r100;
    }
}
