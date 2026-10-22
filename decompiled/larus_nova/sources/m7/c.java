package m7;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
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
import com.bytedance.android.annie.param.AnnieXLiveContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnnieXLiveContext f512319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WebViewClient f512320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b7.b f512321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ia.c f512322d;

    public static final class a {
    }

    static {
    }

    public c(AnnieXLiveContext r100, WebViewClient r101) {
        Intrinsics.checkNotNullParameter(r101, "webViewClient");
        this.f512319a = r100;
        this.f512320b = r101;
        if (r100 == null) goto L5;
        b7.b r102 = r100.getCommonLifecycle();
    L6:
        this.f512321c = r102;
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView r100, String r101) {
        super.onLoadResource(r100, r101);
        this.f512320b.onLoadResource(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public void onPageCommitVisible(WebView r100, String r101) {
        super.onPageCommitVisible(r100, r101);
        this.f512320b.onPageCommitVisible(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r100, String r101) {
        super.onPageFinished(r100, r101);
        this.f512320b.onPageFinished(r100, r101);
        b7.b r102 = this.f512321c;
        if (r102 == null) goto L6;
        r102.onLoadSuccess(r100);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedClientCertRequest(WebView r100, ClientCertRequest r101) {
        super.onReceivedClientCertRequest(r100, r101);
        this.f512320b.onReceivedClientCertRequest(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView r100, RenderProcessGoneDetail r101) {
        this.f512320b.onRenderProcessGone(r100, r101);
        return super.onRenderProcessGone(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public final void onUnhandledKeyEvent(WebView r100, KeyEvent r101) {
        super.onUnhandledKeyEvent(r100, r101);
        this.f512320b.onUnhandledKeyEvent(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView r100, WebResourceRequest r101) {
        this.f512320b.shouldInterceptRequest(r100, r101);
        return super.shouldInterceptRequest(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideKeyEvent(WebView r100, KeyEvent r101) {
        this.f512320b.shouldOverrideKeyEvent(r100, r101);
        return super.shouldOverrideKeyEvent(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView r100, WebResourceRequest r101) {
        this.f512320b.shouldOverrideUrlLoading(r100, r101);
        return super.shouldOverrideUrlLoading(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView r100, String r101) {
        this.f512320b.shouldInterceptRequest(r100, r101);
        return super.shouldInterceptRequest(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r100, String r101) {
        this.f512320b.shouldOverrideUrlLoading(r100, r101);
        return super.shouldOverrideUrlLoading(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public final void doUpdateVisitedHistory(WebView r100, String r101, boolean r102) {
        super.doUpdateVisitedHistory(r100, r101, r102);
        this.f512320b.doUpdateVisitedHistory(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public final void onFormResubmission(WebView r100, Message r101, Message r102) {
        super.onFormResubmission(r100, r101, r102);
        this.f512320b.onFormResubmission(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView r100, String r101, Bitmap r102) {
        super.onPageStarted(r100, r101, r102);
        this.f512320b.onPageStarted(r100, r101, r102);
        b7.b r103 = this.f512321c;
        if (r103 == null) goto L6;
        r103.onLoadStart(r100, false);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView r100, WebResourceRequest r101, WebResourceError r102) {
        super.onReceivedError(r100, r101, r102);
        this.f512320b.onReceivedError(r100, r101, r102);
        b7.b r103 = this.f512321c;
        if (r103 == null) goto L17;
        ia.c r104 = this.f512322d;
        CharSequence r105 = null;
        if (r104 == null) goto L7;
        View r106 = r104.getKitView();
    L8:
        AnnieXLiveContext r107 = this.f512319a;
        if (r107 == null) goto L11;
        String r108 = r107.getUrl();
    L12:
        String r109 = String.valueOf(r108);
        if (r102 == null) goto L15;
        r105 = r102.getDescription();
    L15:
        r103.onLoadFail(r106, r109, String.valueOf(r105));
        return;
    L11:
        r108 = null;
        goto L12
    L7:
        r106 = null;
        goto L8
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView r100, WebResourceRequest r101, WebResourceResponse r102) {
        super.onReceivedHttpError(r100, r101, r102);
        this.f512320b.onReceivedHttpError(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView r100, SslErrorHandler r101, SslError r102) {
        super.onReceivedSslError(r100, r101, r102);
        this.f512320b.onReceivedSslError(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public final void onScaleChanged(WebView r100, float r101, float r102) {
        super.onScaleChanged(r100, r101, r102);
        this.f512320b.onScaleChanged(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public final void onTooManyRedirects(WebView r100, Message r101, Message r102) {
        super.onTooManyRedirects(r100, r101, r102);
        this.f512320b.onTooManyRedirects(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView r100, int r101, String r102, String r103) {
        super.onReceivedError(r100, r101, r102, r103);
        this.f512320b.onReceivedError(r100, r101, r102, r103);
        b7.b r104 = this.f512321c;
        if (r104 == null) goto L13;
        ia.c r105 = this.f512322d;
        String r106 = null;
        if (r105 == null) goto L7;
        View r107 = r105.getKitView();
    L8:
        AnnieXLiveContext r108 = this.f512319a;
        if (r108 == null) goto L11;
        r106 = r108.getUrl();
    L11:
        r104.onLoadFail(r107, String.valueOf(r106), r102);
        return;
    L7:
        r107 = null;
        goto L8
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpAuthRequest(WebView r100, HttpAuthHandler r101, String r102, String r103) {
        super.onReceivedHttpAuthRequest(r100, r101, r102, r103);
        this.f512320b.onReceivedHttpAuthRequest(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedLoginRequest(WebView r100, String r101, String r102, String r103) {
        super.onReceivedLoginRequest(r100, r101, r102, r103);
        this.f512320b.onReceivedLoginRequest(r100, r101, r102, r103);
    }

    @Override // android.webkit.WebViewClient
    public final void onSafeBrowsingHit(WebView r100, WebResourceRequest r101, int r102, SafeBrowsingResponse r103) {
        this.f512320b.onSafeBrowsingHit(r100, r101, r102, r103);
        super.onSafeBrowsingHit(r100, r101, r102, r103);
    }
}
