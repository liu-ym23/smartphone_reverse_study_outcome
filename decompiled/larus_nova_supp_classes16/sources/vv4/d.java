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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d extends ws5.c {
    public final List<WebViewClient> e;

    public d(ys5.c r1) {
        super(r1);
        this.e = new CopyOnWriteArrayList();
    }

    public final void a(WebViewClient r2) {
        if (((CopyOnWriteArrayList) this.e).contains(r2) == true) goto L6;
        ((CopyOnWriteArrayList) this.e).add(r2);
        return;
    }

    public void onLoadResource(WebView r3, String r4) {
        super.onLoadResource(r3, r4);
        Iterator r0 = ((CopyOnWriteArrayList) this.e).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((WebViewClient) r0.next()).onLoadResource(r3, r4);
        goto L4
    }

    public void onPageCommitVisible(WebView r3, String r4) {
        super.onPageCommitVisible(r3, r4);
        Iterator r0 = ((CopyOnWriteArrayList) this.e).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((WebViewClient) r0.next()).onPageCommitVisible(r3, r4);
        goto L4
    }

    public void onPageFinished(WebView r3, String r4) {
        super.onPageFinished(r3, r4);
        Iterator r0 = ((CopyOnWriteArrayList) this.e).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((WebViewClient) r0.next()).onPageFinished(r3, r4);
        goto L4
    }

    public final void onReceivedClientCertRequest(WebView r3, ClientCertRequest r4) {
        super.onReceivedClientCertRequest(r3, r4);
        Iterator r0 = ((CopyOnWriteArrayList) this.e).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((WebViewClient) r0.next()).onReceivedClientCertRequest(r3, r4);
        goto L4
    }

    public final boolean onRenderProcessGone(WebView r5, RenderProcessGoneDetail r6) {
        Iterator r0 = ((CopyOnWriteArrayList) this.e).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (((WebViewClient) r0.next()).onRenderProcessGone(r5, r6) == false) goto L4;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return true;
    L11:
        if (super.onRenderProcessGone(r5, r6) == true) goto L19;
        return false;
    L19:
        return true;
    L8:
        r1 = false;
        goto L9
    }

    public final void onUnhandledKeyEvent(WebView r3, KeyEvent r4) {
        super.onUnhandledKeyEvent(r3, r4);
        Iterator r0 = ((CopyOnWriteArrayList) this.e).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((WebViewClient) r0.next()).onUnhandledKeyEvent(r3, r4);
        goto L4
    }

    public final WebResourceResponse shouldInterceptRequest(WebView r3, WebResourceRequest r4) {
        Iterator r0 = ((CopyOnWriteArrayList) this.e).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        WebResourceResponse r1 = ((WebViewClient) r0.next()).shouldInterceptRequest(r3, r4);
        if (r1 == null) goto L4;
    L9:
        if (r1 == null) goto L12;
        return r1;
    L12:
        return super.shouldInterceptRequest(r3, r4);
    L8:
        r1 = null;
        goto L9
    }

    public final boolean shouldOverrideKeyEvent(WebView r5, KeyEvent r6) {
        Iterator r0 = ((CopyOnWriteArrayList) this.e).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (((WebViewClient) r0.next()).shouldOverrideKeyEvent(r5, r6) == false) goto L4;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return true;
    L11:
        if (super.shouldOverrideKeyEvent(r5, r6) == true) goto L19;
        return false;
    L19:
        return true;
    L8:
        r1 = false;
        goto L9
    }

    public final boolean shouldOverrideUrlLoading(WebView r3, WebResourceRequest r4) {
        Iterator r0 = ((CopyOnWriteArrayList) this.e).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (((WebViewClient) r0.next()).shouldOverrideUrlLoading(r3, r4) == false) goto L4;
        return true;
    L8:
        return false;
    }

    public boolean shouldOverrideUrlLoading(WebView r3, String r4) {
        Iterator r0 = ((CopyOnWriteArrayList) this.e).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (((WebViewClient) r0.next()).shouldOverrideUrlLoading(r3, r4) == false) goto L4;
        return true;
    L8:
        return false;
    }

    public final void doUpdateVisitedHistory(WebView r3, String r4, boolean r5) {
        super.doUpdateVisitedHistory(r3, r4, r5);
        Iterator r0 = ((CopyOnWriteArrayList) this.e).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((WebViewClient) r0.next()).doUpdateVisitedHistory(r3, r4, r5);
        goto L4
    }

    public final void onFormResubmission(WebView r3, Message r4, Message r5) {
        super.onFormResubmission(r3, r4, r5);
        Iterator r0 = ((CopyOnWriteArrayList) this.e).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((WebViewClient) r0.next()).onFormResubmission(r3, r4, r5);
        goto L4
    }

    public void onPageStarted(WebView r3, String r4, Bitmap r5) {
        super.onPageStarted(r3, r4, r5);
        Iterator r0 = ((CopyOnWriteArrayList) this.e).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((WebViewClient) r0.next()).onPageStarted(r3, r4, r5);
        goto L4
    }

    public final void onReceivedError(WebView r3, WebResourceRequest r4, WebResourceError r5) {
        super.onReceivedError(r3, r4, r5);
        Iterator r0 = ((CopyOnWriteArrayList) this.e).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((WebViewClient) r0.next()).onReceivedError(r3, r4, r5);
        goto L4
    }

    public final void onReceivedHttpError(WebView r3, WebResourceRequest r4, WebResourceResponse r5) {
        super.onReceivedHttpError(r3, r4, r5);
        Iterator r0 = ((CopyOnWriteArrayList) this.e).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((WebViewClient) r0.next()).onReceivedHttpError(r3, r4, r5);
        goto L4
    }

    public final void onReceivedSslError(WebView r3, SslErrorHandler r4, SslError r5) {
        super.onReceivedSslError(r3, r4, r5);
        Iterator r0 = ((CopyOnWriteArrayList) this.e).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((WebViewClient) r0.next()).onReceivedSslError(r3, r4, r5);
        goto L4
    }

    public final void onScaleChanged(WebView r3, float r4, float r5) {
        super.onScaleChanged(r3, r4, r5);
        Iterator r0 = ((CopyOnWriteArrayList) this.e).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((WebViewClient) r0.next()).onScaleChanged(r3, r4, r5);
        goto L4
    }

    public final void onTooManyRedirects(WebView r3, Message r4, Message r5) {
        super.onTooManyRedirects(r3, r4, r5);
        Iterator r0 = ((CopyOnWriteArrayList) this.e).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((WebViewClient) r0.next()).onTooManyRedirects(r3, r4, r5);
        goto L4
    }

    public final void onReceivedError(WebView r3, int r4, String r5, String r6) {
        super.onReceivedError(r3, r4, r5, r6);
        Iterator r0 = ((CopyOnWriteArrayList) this.e).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((WebViewClient) r0.next()).onReceivedError(r3, r4, r5, r6);
        goto L4
    }

    public final void onReceivedHttpAuthRequest(WebView r3, HttpAuthHandler r4, String r5, String r6) {
        super.onReceivedHttpAuthRequest(r3, r4, r5, r6);
        Iterator r0 = ((CopyOnWriteArrayList) this.e).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((WebViewClient) r0.next()).onReceivedHttpAuthRequest(r3, r4, r5, r6);
        goto L4
    }

    public final void onReceivedLoginRequest(WebView r3, String r4, String r5, String r6) {
        super.onReceivedLoginRequest(r3, r4, r5, r6);
        Iterator r0 = ((CopyOnWriteArrayList) this.e).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((WebViewClient) r0.next()).onReceivedLoginRequest(r3, r4, r5, r6);
        goto L4
    }
}
