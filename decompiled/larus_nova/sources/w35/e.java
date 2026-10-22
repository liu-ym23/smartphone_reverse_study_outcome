package w35;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class e extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f558157a;

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView r100, RenderProcessGoneDetail r101) {
        return true;
    }

    public e(d r100) {
        this.f558157a = r100;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r100, String r101) {
        super.onPageFinished(r100, r101);
        tt5.a.h("SSR", "onPageFinished");
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView r100, WebResourceRequest r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "request");
        return this.f558157a.f558156a.t(r101.getUrl().toString(), r101.getMethod(), r101.getRequestHeaders());
    }
}
