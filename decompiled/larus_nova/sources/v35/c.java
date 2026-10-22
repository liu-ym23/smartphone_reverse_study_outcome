package v35;

import android.webkit.WebView;
import com.larus.apm.impl.protector.RunnableProtector;
import vv4.k;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f552841a;

    public c(a r100) {
        this.f552841a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k r100 = this.f552841a.getWeb();     // Catch: Throwable -> L15
        if (r100 == null) goto L9;
        WebView r101 = r100.getWebView();     // Catch: Throwable -> L15
        if (r101 == null) goto L9;
        boolean r102 = true;
        if (r101.isAttachedToWindow() != true) goto L9;
    L10:
        if (r102 == false) goto L18;
        a.c r103 = this.f552841a.f552831e;     // Catch: Throwable -> L15
        if (r103 == null) goto L22;
        r103.a();     // Catch: Throwable -> L15
        return;
    L22:
        return;
    L18:
        return;
    L9:
        r102 = false;
    L15:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L23;
        throw th;
    }
}
