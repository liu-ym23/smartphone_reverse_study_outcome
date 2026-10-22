package rq7;

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
import com.bytedance.webx.event.EventManager;
import pq7.c;

/* JADX INFO: loaded from: classes22.dex */
public final class b extends sq7.b {

    public static abstract class a extends com.bytedance.webx.event.a<b> {
        public a() {
        }

        public boolean A(WebView r100, String r101) {
            com.bytedance.webx.event.a r102 = EventManager.a(c(), this, "shouldOverrideUrlLoading");
            if ((r102 instanceof a) == false) goto L7;
            return ((a) r102).A(r100, r101);
        L7:
            return b.a(b(), r100, r101);
        }

        public final void g(WebView r100, String r101) {
            com.bytedance.webx.event.a r102 = EventManager.a(c(), this, "onLoadResource");
            if ((r102 instanceof a) == false) goto L5;
            ((a) r102).g(r100, r101);
            return;
        L5:
            b.s(b(), r100, r101);
        }

        public final void h(WebView r100, String r101) {
            com.bytedance.webx.event.a r102 = EventManager.a(c(), this, "onPageCommitVisible");
            if ((r102 instanceof a) == false) goto L5;
            ((a) r102).h(r100, r101);
            return;
        L5:
            b.t(b(), r100, r101);
        }

        public final void i(WebView r100, String r101) {
            com.bytedance.webx.event.a r102 = EventManager.a(c(), this, "onPageFinished");
            if ((r102 instanceof a) == false) goto L5;
            ((a) r102).i(r100, r101);
            return;
        L5:
            b.r(b(), r100, r101);
        }

        public final void k(WebView r100, ClientCertRequest r101) {
            com.bytedance.webx.event.a r102 = EventManager.a(c(), this, "onReceivedClientCertRequest");
            if ((r102 instanceof a) == false) goto L5;
            ((a) r102).k(r100, r101);
            return;
        L5:
            b.i(b(), r100, r101);
        }

        public final boolean r(WebView r100, RenderProcessGoneDetail r101) {
            com.bytedance.webx.event.a r102 = EventManager.a(c(), this, "onRenderProcessGone");
            if ((r102 instanceof a) == false) goto L7;
            return ((a) r102).r(r100, r101);
        L7:
            return b.p(b(), r100, r101);
        }

        public final void v(WebView r100, KeyEvent r101) {
            com.bytedance.webx.event.a r102 = EventManager.a(c(), this, "onUnhandledKeyEvent");
            if ((r102 instanceof a) == false) goto L5;
            ((a) r102).v(r100, r101);
            return;
        L5:
            b.l(b(), r100, r101);
        }

        public final WebResourceResponse w(WebView r100, WebResourceRequest r101) {
            com.bytedance.webx.event.a r102 = EventManager.a(c(), this, "shouldInterceptRequest");
            if ((r102 instanceof a) == false) goto L7;
            return ((a) r102).w(r100, r101);
        L7:
            return b.v(b(), r100, r101);
        }

        public final WebResourceResponse x(WebView r100, String r101) {
            com.bytedance.webx.event.a r102 = EventManager.a(c(), this, "shouldInterceptRequest");
            if ((r102 instanceof a) == false) goto L7;
            return ((a) r102).x(r100, r101);
        L7:
            return b.u(b(), r100, r101);
        }

        public final boolean y(WebView r100, KeyEvent r101) {
            com.bytedance.webx.event.a r102 = EventManager.a(c(), this, "shouldOverrideKeyEvent");
            if ((r102 instanceof a) == false) goto L7;
            return ((a) r102).y(r100, r101);
        L7:
            return b.k(b(), r100, r101);
        }

        public boolean z(WebView r100, WebResourceRequest r101) {
            com.bytedance.webx.event.a r102 = EventManager.a(c(), this, "shouldOverrideUrlLoading");
            if ((r102 instanceof a) == false) goto L7;
            return ((a) r102).z(r100, r101);
        L7:
            return b.c(b(), r100, r101);
        }

        public void e(WebView r100, String r101, boolean r102) {
            com.bytedance.webx.event.a r103 = EventManager.a(c(), this, "doUpdateVisitedHistory");
            if ((r103 instanceof a) == false) goto L5;
            ((a) r103).e(r100, r101, r102);
            return;
        L5:
            b.g(b(), r100, r101, r102);
        }

        public final void f(WebView r100, Message r101, Message r102) {
            com.bytedance.webx.event.a r103 = EventManager.a(c(), this, "onFormResubmission");
            if ((r103 instanceof a) == false) goto L5;
            ((a) r103).f(r100, r101, r102);
            return;
        L5:
            b.f(b(), r100, r101, r102);
        }

        public final void j(WebView r100, String r101, Bitmap r102) {
            com.bytedance.webx.event.a r103 = EventManager.a(c(), this, "onPageStarted");
            if ((r103 instanceof a) == false) goto L5;
            ((a) r103).j(r100, r101, r102);
            return;
        L5:
            b.n(b(), r100, r101, r102);
        }

        public final void m(WebView r100, WebResourceRequest r101, WebResourceError r102) {
            com.bytedance.webx.event.a r103 = EventManager.a(c(), this, "onReceivedError");
            if ((r103 instanceof a) == false) goto L5;
            ((a) r103).m(r100, r101, r102);
            return;
        L5:
            b.d(b(), r100, r101, r102);
        }

        public final void o(WebView r100, WebResourceRequest r101, WebResourceResponse r102) {
            com.bytedance.webx.event.a r103 = EventManager.a(c(), this, "onReceivedHttpError");
            if ((r103 instanceof a) == false) goto L5;
            ((a) r103).o(r100, r101, r102);
            return;
        L5:
            b.e(b(), r100, r101, r102);
        }

        public final void q(WebView r100, SslErrorHandler r101, SslError r102) {
            com.bytedance.webx.event.a r103 = EventManager.a(c(), this, "onReceivedSslError");
            if ((r103 instanceof a) == false) goto L5;
            ((a) r103).q(r100, r101, r102);
            return;
        L5:
            b.h(b(), r100, r101, r102);
        }

        public final void t(WebView r100, float r101, float r102) {
            com.bytedance.webx.event.a r103 = EventManager.a(c(), this, "onScaleChanged");
            if ((r103 instanceof a) == false) goto L5;
            ((a) r103).t(r100, r101, r102);
            return;
        L5:
            b.m(b(), r100, r101, r102);
        }

        public final void u(WebView r100, Message r101, Message r102) {
            com.bytedance.webx.event.a r103 = EventManager.a(c(), this, "onTooManyRedirects");
            if ((r103 instanceof a) == false) goto L5;
            ((a) r103).u(r100, r101, r102);
            return;
        L5:
            b.w(b(), r100, r101, r102);
        }

        public final void l(WebView r100, int r101, String r102, String r103) {
            com.bytedance.webx.event.a r104 = EventManager.a(c(), this, "onReceivedError");
            if ((r104 instanceof a) == false) goto L5;
            ((a) r104).l(r100, r101, r102, r103);
            return;
        L5:
            b.x(b(), r100, r101, r102, r103);
        }

        public final void n(WebView r100, HttpAuthHandler r101, String r102, String r103) {
            com.bytedance.webx.event.a r104 = EventManager.a(c(), this, "onReceivedHttpAuthRequest");
            if ((r104 instanceof a) == false) goto L5;
            ((a) r104).n(r100, r101, r102, r103);
            return;
        L5:
            b.j(b(), r100, r101, r102, r103);
        }

        public final void p(WebView r100, String r101, String r102, String r103) {
            com.bytedance.webx.event.a r104 = EventManager.a(c(), this, "onReceivedLoginRequest");
            if ((r104 instanceof a) == false) goto L5;
            ((a) r104).p(r100, r101, r102, r103);
            return;
        L5:
            b.o(b(), r100, r101, r102, r103);
        }

        public final void s(WebView r100, WebResourceRequest r101, int r102, SafeBrowsingResponse r103) {
            com.bytedance.webx.event.a r104 = EventManager.a(c(), this, "onSafeBrowsingHit");
            if ((r104 instanceof a) == false) goto L5;
            ((a) r104).s(r100, r101, r102, r103);
            return;
        L5:
            b.q(b(), r100, r101, r102, r103);
        }
    }

    public b() {
    }

    @Override // sq7.b, android.webkit.WebViewClient
    public void onLoadResource(WebView r100, String r101) {
        com.bytedance.webx.event.a r102 = EventManager.b(getExtendableContext(), "onLoadResource");
        if ((r102 instanceof a) == false) goto L5;
        c.b r103 = c.f530286b;
        r103.get().b();
        ((a) r102).g(r100, r101);
        r103.get().a();
        return;
    L5:
        super.onLoadResource(r100, r101);
    }

    @Override // sq7.b, android.webkit.WebViewClient
    public void onPageCommitVisible(WebView r100, String r101) {
        com.bytedance.webx.event.a r102 = EventManager.b(getExtendableContext(), "onPageCommitVisible");
        if ((r102 instanceof a) == false) goto L5;
        c.b r103 = c.f530286b;
        r103.get().b();
        ((a) r102).h(r100, r101);
        r103.get().a();
        return;
    L5:
        super.onPageCommitVisible(r100, r101);
    }

    @Override // sq7.b, android.webkit.WebViewClient
    public void onPageFinished(WebView r100, String r101) {
        com.bytedance.webx.event.a r102 = EventManager.b(getExtendableContext(), "onPageFinished");
        if ((r102 instanceof a) == false) goto L5;
        c.b r103 = c.f530286b;
        r103.get().b();
        ((a) r102).i(r100, r101);
        r103.get().a();
        return;
    L5:
        super.onPageFinished(r100, r101);
    }

    @Override // sq7.b, android.webkit.WebViewClient
    public final void onReceivedClientCertRequest(WebView r100, ClientCertRequest r101) {
        com.bytedance.webx.event.a r102 = EventManager.b(getExtendableContext(), "onReceivedClientCertRequest");
        if ((r102 instanceof a) == false) goto L5;
        c.b r103 = c.f530286b;
        r103.get().b();
        ((a) r102).k(r100, r101);
        r103.get().a();
        return;
    L5:
        super.onReceivedClientCertRequest(r100, r101);
    }

    @Override // sq7.b, android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView r100, RenderProcessGoneDetail r101) {
        com.bytedance.webx.event.a r102 = EventManager.b(getExtendableContext(), "onRenderProcessGone");
        if ((r102 instanceof a) == false) goto L7;
        c.b r103 = c.f530286b;
        r103.get().b();
        boolean r104 = ((a) r102).r(r100, r101);
        r103.get().a();
        return r104;
    L7:
        return super.onRenderProcessGone(r100, r101);
    }

    @Override // sq7.b, android.webkit.WebViewClient
    public final void onUnhandledKeyEvent(WebView r100, KeyEvent r101) {
        com.bytedance.webx.event.a r102 = EventManager.b(getExtendableContext(), "onUnhandledKeyEvent");
        if ((r102 instanceof a) == false) goto L5;
        c.b r103 = c.f530286b;
        r103.get().b();
        ((a) r102).v(r100, r101);
        r103.get().a();
        return;
    L5:
        super.onUnhandledKeyEvent(r100, r101);
    }

    @Override // sq7.b, android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView r100, WebResourceRequest r101) {
        com.bytedance.webx.event.a r102 = EventManager.b(getExtendableContext(), "shouldInterceptRequest");
        if ((r102 instanceof a) == false) goto L7;
        c.b r103 = c.f530286b;
        r103.get().b();
        WebResourceResponse r104 = ((a) r102).w(r100, r101);
        r103.get().a();
        return r104;
    L7:
        return super.shouldInterceptRequest(r100, r101);
    }

    @Override // sq7.b, android.webkit.WebViewClient
    public final boolean shouldOverrideKeyEvent(WebView r100, KeyEvent r101) {
        com.bytedance.webx.event.a r102 = EventManager.b(getExtendableContext(), "shouldOverrideKeyEvent");
        if ((r102 instanceof a) == false) goto L7;
        c.b r103 = c.f530286b;
        r103.get().b();
        boolean r104 = ((a) r102).y(r100, r101);
        r103.get().a();
        return r104;
    L7:
        return super.shouldOverrideKeyEvent(r100, r101);
    }

    @Override // sq7.b, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView r100, WebResourceRequest r101) {
        com.bytedance.webx.event.a r102 = EventManager.b(getExtendableContext(), "shouldOverrideUrlLoading");
        if ((r102 instanceof a) == false) goto L7;
        c.b r103 = c.f530286b;
        r103.get().b();
        boolean r104 = ((a) r102).z(r100, r101);
        r103.get().a();
        return r104;
    L7:
        return super.shouldOverrideUrlLoading(r100, r101);
    }

    @Override // sq7.b, android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView r100, String r101) {
        com.bytedance.webx.event.a r102 = EventManager.b(getExtendableContext(), "shouldInterceptRequest");
        if ((r102 instanceof a) == false) goto L7;
        c.b r103 = c.f530286b;
        r103.get().b();
        WebResourceResponse r104 = ((a) r102).x(r100, r101);
        r103.get().a();
        return r104;
    L7:
        return super.shouldInterceptRequest(r100, r101);
    }

    @Override // sq7.b, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r100, String r101) {
        com.bytedance.webx.event.a r102 = EventManager.b(getExtendableContext(), "shouldOverrideUrlLoading");
        if ((r102 instanceof a) == false) goto L7;
        c.b r103 = c.f530286b;
        r103.get().b();
        boolean r104 = ((a) r102).A(r100, r101);
        r103.get().a();
        return r104;
    L7:
        return super.shouldOverrideUrlLoading(r100, r101);
    }

    public static boolean a(b r100, WebView r101, String r102) {
        return super.shouldOverrideUrlLoading(r101, r102);
    }

    public static boolean c(b r100, WebView r101, WebResourceRequest r102) {
        return super.shouldOverrideUrlLoading(r101, r102);
    }

    public static void i(b r100, WebView r101, ClientCertRequest r102) {
        super.onReceivedClientCertRequest(r101, r102);
    }

    public static boolean k(b r100, WebView r101, KeyEvent r102) {
        return super.shouldOverrideKeyEvent(r101, r102);
    }

    public static void l(b r100, WebView r101, KeyEvent r102) {
        super.onUnhandledKeyEvent(r101, r102);
    }

    public static boolean p(b r100, WebView r101, RenderProcessGoneDetail r102) {
        return super.onRenderProcessGone(r101, r102);
    }

    public static void r(b r100, WebView r101, String r102) {
        super.onPageFinished(r101, r102);
    }

    public static void s(b r100, WebView r101, String r102) {
        super.onLoadResource(r101, r102);
    }

    public static void t(b r100, WebView r101, String r102) {
        super.onPageCommitVisible(r101, r102);
    }

    public static WebResourceResponse u(b r100, WebView r101, String r102) {
        return super.shouldInterceptRequest(r101, r102);
    }

    public static WebResourceResponse v(b r100, WebView r101, WebResourceRequest r102) {
        return super.shouldInterceptRequest(r101, r102);
    }

    @Override // sq7.b, android.webkit.WebViewClient
    public final void doUpdateVisitedHistory(WebView r100, String r101, boolean r102) {
        com.bytedance.webx.event.a r103 = EventManager.b(getExtendableContext(), "doUpdateVisitedHistory");
        if ((r103 instanceof a) == false) goto L5;
        c.b r104 = c.f530286b;
        r104.get().b();
        ((a) r103).e(r100, r101, r102);
        r104.get().a();
        return;
    L5:
        super.doUpdateVisitedHistory(r100, r101, r102);
    }

    @Override // sq7.b, android.webkit.WebViewClient
    public final void onFormResubmission(WebView r100, Message r101, Message r102) {
        com.bytedance.webx.event.a r103 = EventManager.b(getExtendableContext(), "onFormResubmission");
        if ((r103 instanceof a) == false) goto L5;
        c.b r104 = c.f530286b;
        r104.get().b();
        ((a) r103).f(r100, r101, r102);
        r104.get().a();
        return;
    L5:
        super.onFormResubmission(r100, r101, r102);
    }

    @Override // sq7.b, android.webkit.WebViewClient
    public void onPageStarted(WebView r100, String r101, Bitmap r102) {
        com.bytedance.webx.event.a r103 = EventManager.b(getExtendableContext(), "onPageStarted");
        if ((r103 instanceof a) == false) goto L5;
        c.b r104 = c.f530286b;
        r104.get().b();
        ((a) r103).j(r100, r101, r102);
        r104.get().a();
        return;
    L5:
        super.onPageStarted(r100, r101, r102);
    }

    @Override // sq7.b, android.webkit.WebViewClient
    public final void onReceivedError(WebView r100, WebResourceRequest r101, WebResourceError r102) {
        com.bytedance.webx.event.a r103 = EventManager.b(getExtendableContext(), "onReceivedError");
        if ((r103 instanceof a) == false) goto L5;
        c.b r104 = c.f530286b;
        r104.get().b();
        ((a) r103).m(r100, r101, r102);
        r104.get().a();
        return;
    L5:
        super.onReceivedError(r100, r101, r102);
    }

    @Override // sq7.b, android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView r100, WebResourceRequest r101, WebResourceResponse r102) {
        com.bytedance.webx.event.a r103 = EventManager.b(getExtendableContext(), "onReceivedHttpError");
        if ((r103 instanceof a) == false) goto L5;
        c.b r104 = c.f530286b;
        r104.get().b();
        ((a) r103).o(r100, r101, r102);
        r104.get().a();
        return;
    L5:
        super.onReceivedHttpError(r100, r101, r102);
    }

    @Override // sq7.b, android.webkit.WebViewClient
    public final void onReceivedSslError(WebView r100, SslErrorHandler r101, SslError r102) {
        com.bytedance.webx.event.a r103 = EventManager.b(getExtendableContext(), "onReceivedSslError");
        if ((r103 instanceof a) == false) goto L5;
        c.b r104 = c.f530286b;
        r104.get().b();
        ((a) r103).q(r100, r101, r102);
        r104.get().a();
        return;
    L5:
        super.onReceivedSslError(r100, r101, r102);
    }

    @Override // sq7.b, android.webkit.WebViewClient
    public final void onScaleChanged(WebView r100, float r101, float r102) {
        com.bytedance.webx.event.a r103 = EventManager.b(getExtendableContext(), "onScaleChanged");
        if ((r103 instanceof a) == false) goto L5;
        c.b r104 = c.f530286b;
        r104.get().b();
        ((a) r103).t(r100, r101, r102);
        r104.get().a();
        return;
    L5:
        super.onScaleChanged(r100, r101, r102);
    }

    @Override // sq7.b, android.webkit.WebViewClient
    public final void onTooManyRedirects(WebView r100, Message r101, Message r102) {
        com.bytedance.webx.event.a r103 = EventManager.b(getExtendableContext(), "onTooManyRedirects");
        if ((r103 instanceof a) == false) goto L5;
        c.b r104 = c.f530286b;
        r104.get().b();
        ((a) r103).u(r100, r101, r102);
        r104.get().a();
        return;
    L5:
        super.onTooManyRedirects(r100, r101, r102);
    }

    public static void d(b r100, WebView r101, WebResourceRequest r102, WebResourceError r103) {
        super.onReceivedError(r101, r102, r103);
    }

    public static void e(b r100, WebView r101, WebResourceRequest r102, WebResourceResponse r103) {
        super.onReceivedHttpError(r101, r102, r103);
    }

    public static void f(b r100, WebView r101, Message r102, Message r103) {
        super.onFormResubmission(r101, r102, r103);
    }

    public static void g(b r100, WebView r101, String r102, boolean r103) {
        super.doUpdateVisitedHistory(r101, r102, r103);
    }

    public static void h(b r100, WebView r101, SslErrorHandler r102, SslError r103) {
        super.onReceivedSslError(r101, r102, r103);
    }

    public static void m(b r100, WebView r101, float r102, float r103) {
        super.onScaleChanged(r101, r102, r103);
    }

    public static void n(b r100, WebView r101, String r102, Bitmap r103) {
        super.onPageStarted(r101, r102, r103);
    }

    public static void w(b r100, WebView r101, Message r102, Message r103) {
        super.onTooManyRedirects(r101, r102, r103);
    }

    @Override // sq7.b, android.webkit.WebViewClient
    public final void onReceivedError(WebView r100, int r101, String r102, String r103) {
        com.bytedance.webx.event.a r104 = EventManager.b(getExtendableContext(), "onReceivedError");
        if ((r104 instanceof a) == false) goto L5;
        c.b r105 = c.f530286b;
        r105.get().b();
        ((a) r104).l(r100, r101, r102, r103);
        r105.get().a();
        return;
    L5:
        super.onReceivedError(r100, r101, r102, r103);
    }

    @Override // sq7.b, android.webkit.WebViewClient
    public final void onReceivedHttpAuthRequest(WebView r100, HttpAuthHandler r101, String r102, String r103) {
        com.bytedance.webx.event.a r104 = EventManager.b(getExtendableContext(), "onReceivedHttpAuthRequest");
        if ((r104 instanceof a) == false) goto L5;
        c.b r105 = c.f530286b;
        r105.get().b();
        ((a) r104).n(r100, r101, r102, r103);
        r105.get().a();
        return;
    L5:
        super.onReceivedHttpAuthRequest(r100, r101, r102, r103);
    }

    @Override // sq7.b, android.webkit.WebViewClient
    public final void onReceivedLoginRequest(WebView r100, String r101, String r102, String r103) {
        com.bytedance.webx.event.a r104 = EventManager.b(getExtendableContext(), "onReceivedLoginRequest");
        if ((r104 instanceof a) == false) goto L5;
        c.b r105 = c.f530286b;
        r105.get().b();
        ((a) r104).p(r100, r101, r102, r103);
        r105.get().a();
        return;
    L5:
        super.onReceivedLoginRequest(r100, r101, r102, r103);
    }

    @Override // sq7.b, android.webkit.WebViewClient
    public final void onSafeBrowsingHit(WebView r100, WebResourceRequest r101, int r102, SafeBrowsingResponse r103) {
        com.bytedance.webx.event.a r104 = EventManager.b(getExtendableContext(), "onSafeBrowsingHit");
        if ((r104 instanceof a) == false) goto L5;
        c.b r105 = c.f530286b;
        r105.get().b();
        ((a) r104).s(r100, r101, r102, r103);
        r105.get().a();
        return;
    L5:
        super.onSafeBrowsingHit(r100, r101, r102, r103);
    }

    public static void j(b r100, WebView r101, HttpAuthHandler r102, String r103, String r104) {
        super.onReceivedHttpAuthRequest(r101, r102, r103, r104);
    }

    public static void o(b r100, WebView r101, String r102, String r103, String r104) {
        super.onReceivedLoginRequest(r101, r102, r103, r104);
    }

    public static void q(b r100, WebView r101, WebResourceRequest r102, int r103, SafeBrowsingResponse r104) {
        super.onSafeBrowsingHit(r101, r102, r103, r104);
    }

    public static void x(b r100, WebView r101, int r102, String r103, String r104) {
        super.onReceivedError(r101, r102, r103, r104);
    }
}
