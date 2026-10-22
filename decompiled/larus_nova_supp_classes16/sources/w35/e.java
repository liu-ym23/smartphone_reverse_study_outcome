package w35;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e extends WebViewClient {
    public final /* synthetic */ d a;

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView r1, RenderProcessGoneDetail r2) {
        return true;
    }

    public e(d r1) {
        this.a = r1;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r1, String r2) {
        super.onPageFinished(r1, r2);
        tt5.a.h("SSR", "onPageFinished");
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView r3, WebResourceRequest r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "request");
        return this.a.a.t(r4.getUrl().toString(), r4.getMethod(), r4.getRequestHeaders());
    }
}
