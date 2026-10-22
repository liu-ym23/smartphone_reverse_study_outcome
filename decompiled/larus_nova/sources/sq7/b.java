package sq7;

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
import iq7.g;
import oq7.c;

/* JADX INFO: loaded from: classes22.dex */
public class b extends WebViewClient implements pq7.b, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f543082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pq7.a f543083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WebViewClient f543084c;

    @Override // pq7.b
    public final oq7.a getExtendableContext() {
        pq7.a r100 = this.f543083b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f530284a;
    }

    public b() {
        this.f543083b = new pq7.a();
    }

    @Override // pq7.b
    public final void b(g r100) {
        this.f543082a = r100;
        this.f543083b.f530284a = new oq7.a(this.f543082a, this);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView r100, String r101) {
        WebViewClient r102 = this.f543084c;
        if (r102 == null) goto L6;
        r102.onLoadResource(r100, r101);
        return;
    L6:
        super.onLoadResource(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public void onPageCommitVisible(WebView r100, String r101) {
        WebViewClient r102 = this.f543084c;
        if (r102 == null) goto L6;
        r102.onPageCommitVisible(r100, r101);
        return;
    L6:
        super.onPageCommitVisible(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r100, String r101) {
        WebViewClient r102 = this.f543084c;
        if (r102 == null) goto L6;
        r102.onPageFinished(r100, r101);
        return;
    L6:
        super.onPageFinished(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedClientCertRequest(WebView r100, ClientCertRequest r101) {
        WebViewClient r102 = this.f543084c;
        if (r102 == null) goto L6;
        r102.onReceivedClientCertRequest(r100, r101);
        return;
    L6:
        super.onReceivedClientCertRequest(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView r100, RenderProcessGoneDetail r101) {
        WebViewClient r102 = this.f543084c;
        if (r102 == null) goto L7;
        return r102.onRenderProcessGone(r100, r101);
    L7:
        return super.onRenderProcessGone(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(WebView r100, KeyEvent r101) {
        WebViewClient r102 = this.f543084c;
        if (r102 == null) goto L6;
        r102.onUnhandledKeyEvent(r100, r101);
        return;
    L6:
        super.onUnhandledKeyEvent(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView r100, WebResourceRequest r101) {
        WebViewClient r102 = this.f543084c;
        if (r102 == null) goto L7;
        return r102.shouldInterceptRequest(r100, r101);
    L7:
        return super.shouldInterceptRequest(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView r100, KeyEvent r101) {
        WebViewClient r102 = this.f543084c;
        if (r102 == null) goto L7;
        return r102.shouldOverrideKeyEvent(r100, r101);
    L7:
        return super.shouldOverrideKeyEvent(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r100, WebResourceRequest r101) {
        WebViewClient r102 = this.f543084c;
        if (r102 == null) goto L7;
        return r102.shouldOverrideUrlLoading(r100, r101);
    L7:
        return super.shouldOverrideUrlLoading(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView r100, String r101) {
        WebViewClient r102 = this.f543084c;
        if (r102 == null) goto L7;
        return r102.shouldInterceptRequest(r100, r101);
    L7:
        return super.shouldInterceptRequest(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r100, String r101) {
        WebViewClient r102 = this.f543084c;
        if (r102 == null) goto L7;
        return r102.shouldOverrideUrlLoading(r100, r101);
    L7:
        return super.shouldOverrideUrlLoading(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView r100, String r101, boolean r102) {
        WebViewClient r103 = this.f543084c;
        if (r103 == null) goto L6;
        r103.doUpdateVisitedHistory(r100, r101, r102);
        return;
    L6:
        super.doUpdateVisitedHistory(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public void onFormResubmission(WebView r100, Message r101, Message r102) {
        WebViewClient r103 = this.f543084c;
        if (r103 == null) goto L6;
        r103.onFormResubmission(r100, r101, r102);
        return;
    L6:
        super.onFormResubmission(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView r100, String r101, Bitmap r102) {
        WebViewClient r103 = this.f543084c;
        if (r103 == null) goto L6;
        r103.onPageStarted(r100, r101, r102);
        return;
    L6:
        super.onPageStarted(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView r100, WebResourceRequest r101, WebResourceError r102) {
        WebViewClient r103 = this.f543084c;
        if (r103 == null) goto L6;
        r103.onReceivedError(r100, r101, r102);
        return;
    L6:
        super.onReceivedError(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView r100, WebResourceRequest r101, WebResourceResponse r102) {
        WebViewClient r103 = this.f543084c;
        if (r103 == null) goto L6;
        r103.onReceivedHttpError(r100, r101, r102);
        return;
    L6:
        super.onReceivedHttpError(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView r100, SslErrorHandler r101, SslError r102) {
        WebViewClient r103 = this.f543084c;
        if (r103 == null) goto L6;
        r103.onReceivedSslError(r100, r101, r102);
        return;
    L6:
        super.onReceivedSslError(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(WebView r100, float r101, float r102) {
        WebViewClient r103 = this.f543084c;
        if (r103 == null) goto L6;
        r103.onScaleChanged(r100, r101, r102);
        return;
    L6:
        super.onScaleChanged(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public void onTooManyRedirects(WebView r100, Message r101, Message r102) {
        WebViewClient r103 = this.f543084c;
        if (r103 == null) goto L6;
        r103.onTooManyRedirects(r100, r101, r102);
        return;
    L6:
        super.onTooManyRedirects(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView r100, int r101, String r102, String r103) {
        WebViewClient r104 = this.f543084c;
        if (r104 == null) goto L6;
        r104.onReceivedError(r100, r101, r102, r103);
        return;
    L6:
        super.onReceivedError(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView r100, HttpAuthHandler r101, String r102, String r103) {
        WebViewClient r104 = this.f543084c;
        if (r104 == null) goto L6;
        r104.onReceivedHttpAuthRequest(r100, r101, r102, r103);
        return;
    L6:
        super.onReceivedHttpAuthRequest(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedLoginRequest(WebView r100, String r101, String r102, String r103) {
        WebViewClient r104 = this.f543084c;
        if (r104 == null) goto L6;
        r104.onReceivedLoginRequest(r100, r101, r102, r103);
        return;
    L6:
        super.onReceivedLoginRequest(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebViewClient
    public void onSafeBrowsingHit(WebView r100, WebResourceRequest r101, int r102, SafeBrowsingResponse r103) {
        WebViewClient r104 = this.f543084c;
        if (r104 == null) goto L6;
        r104.onSafeBrowsingHit(r100, r101, r102, r103);
        return;
    L6:
        super.onSafeBrowsingHit(r100, r101, r102, r103);
    }
}
