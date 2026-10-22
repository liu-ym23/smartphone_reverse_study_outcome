package otb;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class k extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebViewClient f526698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f526699b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RenderProcessGoneDetail f526700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k f526701b;

        public final boolean a() {
            return this.f526700a.didCrash();
        }

        public final void b() {
            this.f526701b.getClass();
        }

        public a(RenderProcessGoneDetail r100, k r101) {
            this.f526700a = r100;
            this.f526701b = r101;
        }
    }

    public k(WebViewClient r100, j r101) {
        this.f526698a = r100;
        this.f526699b = r101;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "url");
        WebViewClient r102 = this.f526698a;
        if (r102 == null) goto L6;
        r102.onLoadResource(r100, r101);
        return;
    }

    @Override // android.webkit.WebViewClient
    public void onPageCommitVisible(WebView r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "url");
        WebViewClient r102 = this.f526698a;
        if (r102 == null) goto L6;
        r102.onPageCommitVisible(r100, r101);
        return;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "url");
        WebViewClient r102 = this.f526698a;
        if (r102 == null) goto L6;
        r102.onPageFinished(r100, r101);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedClientCertRequest(WebView r100, ClientCertRequest r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "request");
        WebViewClient r102 = this.f526698a;
        if (r102 == null) goto L6;
        r102.onReceivedClientCertRequest(r100, r101);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView r100, RenderProcessGoneDetail r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "detail");
        j r102 = this.f526699b;
        if (r102 != null) goto L5;
        WebViewClient r103 = this.f526698a;
        if (r103 != null) goto L11;
        return true;
    L11:
        return r103.onRenderProcessGone(r100, r101);
    L5:
        return r102.a(r100, new a(r101, this));
    }

    @Override // android.webkit.WebViewClient
    public final void onUnhandledKeyEvent(WebView r100, KeyEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "event");
        WebViewClient r102 = this.f526698a;
        if (r102 == null) goto L6;
        r102.onUnhandledKeyEvent(r100, r101);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView r100, WebResourceRequest r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "request");
        WebViewClient r102 = this.f526698a;
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.shouldInterceptRequest(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideKeyEvent(WebView r100, KeyEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "event");
        WebViewClient r102 = this.f526698a;
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.shouldOverrideKeyEvent(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView r100, WebResourceRequest r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "request");
        WebViewClient r102 = this.f526698a;
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.shouldOverrideUrlLoading(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "Deprecated in Java")
    public final WebResourceResponse shouldInterceptRequest(WebView r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "url");
        WebViewClient r102 = this.f526698a;
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.shouldInterceptRequest(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "Deprecated in Java")
    public boolean shouldOverrideUrlLoading(WebView r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "url");
        WebViewClient r102 = this.f526698a;
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.shouldOverrideUrlLoading(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public final void doUpdateVisitedHistory(WebView r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "url");
        WebViewClient r103 = this.f526698a;
        if (r103 == null) goto L6;
        r103.doUpdateVisitedHistory(r100, r101, r102);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onFormResubmission(WebView r100, Message r101, Message r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        WebViewClient r103 = this.f526698a;
        if (r103 == null) goto L6;
        r103.onFormResubmission(r100, r101, r102);
        return;
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView r100, String r101, Bitmap r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "url");
        WebViewClient r103 = this.f526698a;
        if (r103 == null) goto L6;
        r103.onPageStarted(r100, r101, r102);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView r100, WebResourceRequest r101, WebResourceError r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "request");
        Intrinsics.checkNotNullParameter(r102, "error");
        WebViewClient r103 = this.f526698a;
        if (r103 == null) goto L6;
        r103.onReceivedError(r100, r101, r102);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView r100, WebResourceRequest r101, WebResourceResponse r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "request");
        Intrinsics.checkNotNullParameter(r102, "errorResponse");
        WebViewClient r103 = this.f526698a;
        if (r103 == null) goto L6;
        r103.onReceivedHttpError(r100, r101, r102);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView r100, SslErrorHandler r101, SslError r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "handler");
        Intrinsics.checkNotNullParameter(r102, "error");
        WebViewClient r103 = this.f526698a;
        if (r103 == null) goto L6;
        r103.onReceivedSslError(r100, r101, r102);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onScaleChanged(WebView r100, float r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        WebViewClient r103 = this.f526698a;
        if (r103 == null) goto L6;
        r103.onScaleChanged(r100, r101, r102);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onTooManyRedirects(WebView r100, Message r101, Message r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "cancelMsg");
        Intrinsics.checkNotNullParameter(r102, "continueMsg");
        WebViewClient r103 = this.f526698a;
        if (r103 == null) goto L6;
        r103.onTooManyRedirects(r100, r101, r102);
        return;
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "Deprecated in Java")
    public final void onReceivedError(WebView r100, int r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "view");
        WebViewClient r104 = this.f526698a;
        if (r104 == null) goto L6;
        r104.onReceivedError(r100, r101, r102, r103);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpAuthRequest(WebView r100, HttpAuthHandler r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "handler");
        Intrinsics.checkNotNullParameter(r102, "host");
        Intrinsics.checkNotNullParameter(r103, "realm");
        WebViewClient r104 = this.f526698a;
        if (r104 == null) goto L6;
        r104.onReceivedHttpAuthRequest(r100, r101, r102, r103);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedLoginRequest(WebView r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "realm");
        Intrinsics.checkNotNullParameter(r103, "args");
        WebViewClient r104 = this.f526698a;
        if (r104 == null) goto L6;
        r104.onReceivedLoginRequest(r100, r101, r102, r103);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onSafeBrowsingHit(WebView r100, WebResourceRequest r101, int r102, SafeBrowsingResponse r103) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "request");
        Intrinsics.checkNotNullParameter(r103, "callback");
        WebViewClient r104 = this.f526698a;
        if (r104 == null) goto L6;
        r104.onSafeBrowsingHit(r100, r101, r102, r103);
        return;
    }
}
