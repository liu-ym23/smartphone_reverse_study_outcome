package v35;

import android.webkit.WebView;
import com.larus.apm.impl.protector.RunnableProtector;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements Runnable {
    public final /* synthetic */ a a;

    public c(a r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k r0 = this.a.getWeb();     // Catch: Throwable -> L15
        if (r0 == null) goto L9;
        WebView r1 = r0.getWebView();     // Catch: Throwable -> L15
        if (r1 == null) goto L9;
        boolean r2 = true;
        if (r1.isAttachedToWindow() != true) goto L9;
    L10:
        if (r2 == false) goto L18;
        a.c r3 = this.a.e;     // Catch: Throwable -> L15
        if (r3 == null) goto L22;
        r3.a();     // Catch: Throwable -> L15
        return;
    L22:
        return;
    L18:
        return;
    L9:
        r2 = false;
    L15:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L23;
        throw th;
    }
}
