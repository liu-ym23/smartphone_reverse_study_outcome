package t8a;

import android.content.Context;
import android.os.Build;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.xelement.webview.LynxUIWebView;

/* JADX INFO: loaded from: classes32.dex */
public final class a implements u8a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f545061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u8a.a f545062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WebView f545063c;

    /* JADX INFO: renamed from: t8a.a$a, reason: collision with other inner class name */
    public class C7696a extends WebViewClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f545064a;

        public C7696a(a r100) {
            this.f545064a = r100;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView r100, String r101) {
            super.onPageFinished(r100, r101);
            u8a.a r102 = this.f545064a.f545062b;
            if (r102 == null) goto L6;
            LynxUIWebView.a r103 = (LynxUIWebView.a) r102;
            LynxUIWebView.access$000(r103.f384354a).c("(function() {   window.addEventListener('message', function(event) {       window.LynxWebViewBridge.onMessageReceived(event.data);   });})();");
            r103.f384354a.getLynxContext().getEventEmitter().sendCustomEvent(new m7a.a(r103.f384354a.getSign(), "load"));
            return;
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedError(WebView r100, WebResourceRequest r101, WebResourceError r102) {
            super.onReceivedError(r100, r101, r102);
            if (Build.VERSION.SDK_INT < 23) goto L9;
            u8a.a r103 = this.f545064a.f545062b;
            if (r103 == null) goto L10;
            if (r102 == null) goto L11;
            int r104 = r102.getErrorCode();
            String r105 = r102.getDescription().toString();
            LynxUIWebView.a r106 = (LynxUIWebView.a) r103;
            r106.getClass();
            m7a.a r107 = new m7a.a(r106.f384354a.getSign(), "error");
            r107.a("errorCode", Integer.valueOf(r104));
            r107.a("errorMsg", r105);
            r106.f384354a.getLynxContext().getEventEmitter().sendCustomEvent(r107);
            return;
        L11:
            return;
        L10:
            return;
        }
    }

    @Override // u8a.b
    public final void a() {
    }

    @Override // u8a.b
    public final void b() {
        WebView r100 = new WebView(this.f545061a);
        this.f545063c = r100;
        WebSettings r101 = r100.getSettings();
        r101.setJavaScriptEnabled(true);
        r101.setAllowFileAccess(false);
        r101.setAllowContentAccess(false);
        r101.setJavaScriptCanOpenWindowsAutomatically(true);
        r101.setMixedContentMode(0);
        r101.setDomStorageEnabled(true);
        r101.setUseWideViewPort(true);
        r101.setLoadWithOverviewMode(true);
        this.f545063c.addJavascriptInterface(this, "LynxWebViewBridge");
        this.f545063c.setWebViewClient(new C7696a(this));
    }

    @Override // u8a.b
    public final void destroy() {
        WebView r100 = this.f545063c;
        if (r100 == null) goto L6;
        r100.destroy();
        this.f545063c = null;
        return;
    }

    @Override // u8a.b
    public final void reload() {
        WebView r100 = this.f545063c;
        if (r100 == null) goto L6;
        r100.reload();
        return;
    }

    @Override // u8a.b
    public final WebView getWebView() {
        return this.f545063c;
    }

    public a(LynxContext r100) {
        this.f545061a = r100;
    }

    @Override // u8a.b
    public final void c(String r100) {
        WebView r101 = this.f545063c;
        if (r101 == null) goto L6;
        r101.evaluateJavascript(r100, null);
        return;
    }

    @Override // u8a.b
    public final void d(LynxUIWebView.a r100) {
        this.f545062b = r100;
    }

    @Override // u8a.b
    public final void e(String r100) {
        WebView r101 = this.f545063c;
        if (r101 == null) goto L6;
        r101.loadDataWithBaseURL(null, r100, "text/html", XML.CHARSET_UTF8, null);
        return;
    }

    @Override // u8a.b
    public final void loadUrl(String r100) {
        WebView r101 = this.f545063c;
        if (r101 == null) goto L6;
        r101.loadUrl(r100);
        return;
    }

    @JavascriptInterface
    public void onMessageReceived(String r100) {
        u8a.a r101 = this.f545062b;
        if (r101 == null) goto L6;
        LynxUIWebView.a r102 = (LynxUIWebView.a) r101;
        r102.getClass();
        m7a.a r103 = new m7a.a(r102.f384354a.getSign(), "message");
        r103.a("msg", r100);
        r102.f384354a.getLynxContext().getEventEmitter().sendCustomEvent(r103);
        return;
    }
}
