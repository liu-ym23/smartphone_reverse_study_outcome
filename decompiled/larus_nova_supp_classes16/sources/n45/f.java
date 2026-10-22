package n45;

import android.view.View;
import android.webkit.WebView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ WebView b;

    public f(View r1, WebView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        tt5.a.h("WebViewExtend", "clearView");     // Catch: Throwable -> L4
        this.b.clearView();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
