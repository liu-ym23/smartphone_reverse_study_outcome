package n45;

import android.view.View;
import android.webkit.WebView;
import androidx.core.view.OneShotPreDrawListener;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ WebView b;

    public e(View r1, WebView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        tt5.a.h("WebViewExtend", "doOnPreDraw called");     // Catch: Throwable -> L4
        WebView r0 = this.b;     // Catch: Throwable -> L4
        OneShotPreDrawListener.add(r0, new f(r0, r0));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
