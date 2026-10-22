package n45;

import android.view.View;
import android.webkit.WebView;
import androidx.core.view.OneShotPreDrawListener;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f517055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WebView f517056b;

    public e(View r100, WebView r101) {
        this.f517055a = r100;
        this.f517056b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        tt5.a.h("WebViewExtend", "doOnPreDraw called");     // Catch: Throwable -> L4
        WebView r100 = this.f517056b;     // Catch: Throwable -> L4
        OneShotPreDrawListener.add(r100, new f(r100, r100));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
