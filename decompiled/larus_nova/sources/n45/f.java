package n45;

import android.view.View;
import android.webkit.WebView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f517057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WebView f517058b;

    public f(View r100, WebView r101) {
        this.f517057a = r100;
        this.f517058b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        tt5.a.h("WebViewExtend", "clearView");     // Catch: Throwable -> L4
        this.f517058b.clearView();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
