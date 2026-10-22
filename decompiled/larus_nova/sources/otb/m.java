package otb;

import android.os.Build;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class m implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebView f526702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f526703b;

    @Override // otb.e
    public final void a(h r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // otb.e
    public final void b(g r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // otb.e
    public final void getLoadingStatusCode() {
    }

    @Override // otb.e
    public final void getPerformanceTiming() {
    }

    @Override // otb.e
    public final void isFeatureSupport(String r100) {
        Intrinsics.checkNotNullParameter(r100, "feature");
    }

    @Override // otb.e
    public final void notifyV8ToGC() {
    }

    public m(WebView r100) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        this.f526702a = r100;
    }

    public final void c(j r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f526703b = r100;
        if (Build.VERSION.SDK_INT < 26) goto L14;
        WebViewClient r101 = this.f526702a.getWebViewClient();     // Catch: Exception -> L10
        if ((r101 instanceof k) == false) goto L8;
        j r102 = this.f526703b;     // Catch: Exception -> L10
        ((k) r101).f526699b = r102;     // Catch: Exception -> L10
    L11:
        return;
    L8:
        this.f526702a.setWebViewClient(new k(r101, this.f526703b));     // Catch: Exception -> L10
    L15:
        return;
    }
}
