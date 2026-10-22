package vv4;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes16.dex */
public final class d extends ws5.c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<WebViewClient> f557386e;

    public d(ys5.c r100) {
        super(r100);
        this.f557386e = new CopyOnWriteArrayList();
    }

    public final void a(WebViewClient r100) {
        if (((CopyOnWriteArrayList) this.f557386e).contains(r100) == true) goto L6;
        ((CopyOnWriteArrayList) this.f557386e).add(r100);
        return;
    }

    @Override // ws5.c, android.webkit.WebViewClient
    public void onLoadResource(WebView r100, String r101) {
        super.onLoadResource(r100, r101);
        Iterator r102 = ((CopyOnWriteArrayList) this.f557386e).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((WebViewClient) r102.next()).onLoadResource(r100, r101);
        goto L4
    }

    @Override // ws5.c, android.webkit.WebViewClient
    public void onPageCommitVisible(WebView r100, String r101) {
        super.onPageCommitVisible(r100, r101);
        Iterator r102 = ((CopyOnWriteArrayList) this.f557386e).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((WebViewClient) r102.next()).onPageCommitVisible(r100, r101);
        goto L4
    }

    @Override // ws5.c, android.webkit.WebViewClient
    public void onPageFinished(WebView r100, String r101) {
        super.onPageFinished(r100, r101);
        Iterator r102 = ((CopyOnWriteArrayList) this.f557386e).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((WebViewClient) r102.next()).onPageFinished(r100, r101);
        goto L4
    }

    @Override // ws5.c, android.webkit.WebViewClient
    public final void onReceivedClientCertRequest(WebView r100, ClientCertRequest r101) {
        super.onReceivedClientCertRequest(r100, r101);
        Iterator r102 = ((CopyOnWriteArrayList) this.f557386e).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((WebViewClient) r102.next()).onReceivedClientCertRequest(r100, r101);
        goto L4
    }

    @Override // ws5.c, android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView r100, RenderProcessGoneDetail r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f557386e).iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        if (((WebViewClient) r102.next()).onRenderProcessGone(r100, r101) == false) goto L4;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        return true;
    L11:
        if (super.onRenderProcessGone(r100, r101) == true) goto L19;
        return false;
    L19:
        return true;
    L8:
        r103 = false;
        goto L9
    }

    @Override // ws5.c, android.webkit.WebViewClient
    public final void onUnhandledKeyEvent(WebView r100, KeyEvent r101) {
        super.onUnhandledKeyEvent(r100, r101);
        Iterator r102 = ((CopyOnWriteArrayList) this.f557386e).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((WebViewClient) r102.next()).onUnhandledKeyEvent(r100, r101);
        goto L4
    }

    @Override // ws5.c, android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView r100, WebResourceRequest r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f557386e).iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        WebResourceResponse r103 = ((WebViewClient) r102.next()).shouldInterceptRequest(r100, r101);
        if (r103 == null) goto L4;
    L9:
        if (r103 == null) goto L12;
        return r103;
    L12:
        return super.shouldInterceptRequest(r100, r101);
    L8:
        r103 = null;
        goto L9
    }

    @Override // ws5.c, android.webkit.WebViewClient
    public final boolean shouldOverrideKeyEvent(WebView r100, KeyEvent r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f557386e).iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        if (((WebViewClient) r102.next()).shouldOverrideKeyEvent(r100, r101) == false) goto L4;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        return true;
    L11:
        if (super.shouldOverrideKeyEvent(r100, r101) == true) goto L19;
        return false;
    L19:
        return true;
    L8:
        r103 = false;
        goto L9
    }

    @Override // ws5.c, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView r100, WebResourceRequest r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f557386e).iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        if (((WebViewClient) r102.next()).shouldOverrideUrlLoading(r100, r101) == false) goto L4;
        return true;
    L8:
        return false;
    }

    @Override // ws5.c, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r100, String r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f557386e).iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        if (((WebViewClient) r102.next()).shouldOverrideUrlLoading(r100, r101) == false) goto L4;
        return true;
    L8:
        return false;
    }

    @Override // ws5.c, android.webkit.WebViewClient
    public final void doUpdateVisitedHistory(WebView r100, String r101, boolean r102) {
        super.doUpdateVisitedHistory(r100, r101, r102);
        Iterator r103 = ((CopyOnWriteArrayList) this.f557386e).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((WebViewClient) r103.next()).doUpdateVisitedHistory(r100, r101, r102);
        goto L4
    }

    @Override // ws5.c, android.webkit.WebViewClient
    public final void onFormResubmission(WebView r100, Message r101, Message r102) {
        super.onFormResubmission(r100, r101, r102);
        Iterator r103 = ((CopyOnWriteArrayList) this.f557386e).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((WebViewClient) r103.next()).onFormResubmission(r100, r101, r102);
        goto L4
    }

    @Override // ws5.c, android.webkit.WebViewClient
    public void onPageStarted(WebView r100, String r101, Bitmap r102) {
        super.onPageStarted(r100, r101, r102);
        Iterator r103 = ((CopyOnWriteArrayList) this.f557386e).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((WebViewClient) r103.next()).onPageStarted(r100, r101, r102);
        goto L4
    }

    @Override // ws5.c, android.webkit.WebViewClient
    public final void onReceivedError(WebView r100, WebResourceRequest r101, WebResourceError r102) {
        super.onReceivedError(r100, r101, r102);
        Iterator r103 = ((CopyOnWriteArrayList) this.f557386e).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((WebViewClient) r103.next()).onReceivedError(r100, r101, r102);
        goto L4
    }

    @Override // ws5.c, android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView r100, WebResourceRequest r101, WebResourceResponse r102) {
        super.onReceivedHttpError(r100, r101, r102);
        Iterator r103 = ((CopyOnWriteArrayList) this.f557386e).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((WebViewClient) r103.next()).onReceivedHttpError(r100, r101, r102);
        goto L4
    }

    @Override // ws5.c, android.webkit.WebViewClient
    public final void onReceivedSslError(WebView r100, SslErrorHandler r101, SslError r102) {
        super.onReceivedSslError(r100, r101, r102);
        Iterator r103 = ((CopyOnWriteArrayList) this.f557386e).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((WebViewClient) r103.next()).onReceivedSslError(r100, r101, r102);
        goto L4
    }

    @Override // ws5.c, android.webkit.WebViewClient
    public final void onScaleChanged(WebView r100, float r101, float r102) {
        super.onScaleChanged(r100, r101, r102);
        Iterator r103 = ((CopyOnWriteArrayList) this.f557386e).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((WebViewClient) r103.next()).onScaleChanged(r100, r101, r102);
        goto L4
    }

    @Override // ws5.c, android.webkit.WebViewClient
    public final void onTooManyRedirects(WebView r100, Message r101, Message r102) {
        super.onTooManyRedirects(r100, r101, r102);
        Iterator r103 = ((CopyOnWriteArrayList) this.f557386e).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((WebViewClient) r103.next()).onTooManyRedirects(r100, r101, r102);
        goto L4
    }

    @Override // ws5.c, android.webkit.WebViewClient
    public final void onReceivedError(WebView r100, int r101, String r102, String r103) {
        super.onReceivedError(r100, r101, r102, r103);
        Iterator r104 = ((CopyOnWriteArrayList) this.f557386e).iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((WebViewClient) r104.next()).onReceivedError(r100, r101, r102, r103);
        goto L4
    }

    @Override // ws5.c, android.webkit.WebViewClient
    public final void onReceivedHttpAuthRequest(WebView r100, HttpAuthHandler r101, String r102, String r103) {
        super.onReceivedHttpAuthRequest(r100, r101, r102, r103);
        Iterator r104 = ((CopyOnWriteArrayList) this.f557386e).iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((WebViewClient) r104.next()).onReceivedHttpAuthRequest(r100, r101, r102, r103);
        goto L4
    }

    @Override // ws5.c, android.webkit.WebViewClient
    public final void onReceivedLoginRequest(WebView r100, String r101, String r102, String r103) {
        super.onReceivedLoginRequest(r100, r101, r102, r103);
        Iterator r104 = ((CopyOnWriteArrayList) this.f557386e).iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((WebViewClient) r104.next()).onReceivedLoginRequest(r100, r101, r102, r103);
        goto L4
    }
}
