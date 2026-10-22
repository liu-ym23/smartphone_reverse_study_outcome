package com.huawei.secure.android.common.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.huawei.secure.android.common.util.LogsUtil;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public class SafeWebView extends WebView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f278250f = "SafeWebView";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f278251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String[] f278252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String[] f278253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String[] f278254d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private WebViewLoadCallBack f278255e;

    public static /* synthetic */ class a {
    }

    public final class b extends WebViewClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WebViewClient f278256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f278257b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SafeWebView f278258c;

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView r100, String r101) {
            WebViewClient r102 = this.f278256a;
            if (r102 == null) goto L5;
            r102.onLoadResource(r100, r101);
            return;
        L5:
            super.onLoadResource(r100, r101);
        }

        @Override // android.webkit.WebViewClient
        public void onPageCommitVisible(WebView r100, String r101) {
            WebViewClient r102 = this.f278256a;
            if (r102 == null) goto L5;
            r102.onPageCommitVisible(r100, r101);
            return;
        L5:
            super.onPageCommitVisible(r100, r101);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView r100, String r101) {
            WebViewClient r102 = this.f278256a;
            if (r102 == null) goto L5;
            r102.onPageFinished(r100, r101);
            return;
        L5:
            super.onPageFinished(r100, r101);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedClientCertRequest(WebView r100, ClientCertRequest r101) {
            WebViewClient r102 = this.f278256a;
            if (r102 == null) goto L5;
            r102.onReceivedClientCertRequest(r100, r101);
            return;
        L5:
            super.onReceivedClientCertRequest(r100, r101);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView r100, RenderProcessGoneDetail r101) {
            WebViewClient r102 = this.f278256a;
            if (r102 == null) goto L7;
            return r102.onRenderProcessGone(r100, r101);
        L7:
            return super.onRenderProcessGone(r100, r101);
        }

        @Override // android.webkit.WebViewClient
        public void onUnhandledKeyEvent(WebView r100, KeyEvent r101) {
            WebViewClient r102 = this.f278256a;
            if (r102 == null) goto L5;
            r102.onUnhandledKeyEvent(r100, r101);
            return;
        L5:
            super.onUnhandledKeyEvent(r100, r101);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView r100, WebResourceRequest r101) {
            WebViewClient r102 = this.f278256a;
            if (r102 == null) goto L7;
            return r102.shouldInterceptRequest(r100, r101);
        L7:
            return super.shouldInterceptRequest(r100, r101);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideKeyEvent(WebView r100, KeyEvent r101) {
            WebViewClient r102 = this.f278256a;
            if (r102 == null) goto L7;
            return r102.shouldOverrideKeyEvent(r100, r101);
        L7:
            return super.shouldOverrideKeyEvent(r100, r101);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView r100, String r101) {
            WebViewClient r102 = this.f278256a;
            if (r102 == null) goto L9;
            if (this.f278257b == true) goto L9;
            return r102.shouldOverrideUrlLoading(r100, r101);
        L9:
            if (this.f278258c.isWhiteListUrl(r101) == true) goto L12;
            this.f278258c.onCheckError(r100, r101);
            return false;
        L12:
            WebViewClient r103 = this.f278256a;
            if (r103 == null) goto L17;
            return r103.shouldOverrideUrlLoading(r100, r101);
        L17:
            return super.shouldOverrideUrlLoading(r100, r101);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView r100, String r101) {
            WebViewClient r102 = this.f278256a;
            if (r102 == null) goto L7;
            return r102.shouldInterceptRequest(r100, r101);
        L7:
            return super.shouldInterceptRequest(r100, r101);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView r100, WebResourceRequest r101) {
            WebViewClient r102 = this.f278256a;
            if (r102 == null) goto L7;
            return r102.shouldOverrideUrlLoading(r100, r101);
        L7:
            return super.shouldOverrideUrlLoading(r100, r101);
        }

        private b(SafeWebView r100, WebViewClient r101, boolean r102) {
            this.f278258c = r100;
            this.f278256a = r101;
            this.f278257b = r102;
        }

        @Override // android.webkit.WebViewClient
        public void doUpdateVisitedHistory(WebView r100, String r101, boolean r102) {
            WebViewClient r103 = this.f278256a;
            if (r103 == null) goto L5;
            r103.doUpdateVisitedHistory(r100, r101, r102);
            return;
        L5:
            super.doUpdateVisitedHistory(r100, r101, r102);
        }

        @Override // android.webkit.WebViewClient
        public void onFormResubmission(WebView r100, Message r101, Message r102) {
            WebViewClient r103 = this.f278256a;
            if (r103 == null) goto L5;
            r103.onFormResubmission(r100, r101, r102);
            return;
        L5:
            super.onFormResubmission(r100, r101, r102);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView r100, String r101, Bitmap r102) {
            WebViewClient r103 = this.f278256a;
            if (r103 == null) goto L9;
            if (this.f278257b == true) goto L9;
            r103.onPageStarted(r100, r101, r102);
            return;
        L9:
            if (this.f278258c.isWhiteListUrl(r101) == true) goto L12;
            this.f278258c.onCheckError(r100, r101);
            return;
        L12:
            super.onPageStarted(r100, r101, r102);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView r100, WebResourceRequest r101, WebResourceError r102) {
            WebViewClient r103 = this.f278256a;
            if (r103 == null) goto L5;
            r103.onReceivedError(r100, r101, r102);
            return;
        L5:
            super.onReceivedError(r100, r101, r102);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView r100, WebResourceRequest r101, WebResourceResponse r102) {
            WebViewClient r103 = this.f278256a;
            if (r103 == null) goto L5;
            r103.onReceivedHttpError(r100, r101, r102);
            return;
        L5:
            super.onReceivedHttpError(r100, r101, r102);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView r100, SslErrorHandler r101, SslError r102) {
            WebViewClient r103 = this.f278256a;
            if (r103 == null) goto L5;
            r103.onReceivedSslError(r100, r101, r102);
            return;
        L5:
            super.onReceivedSslError(r100, r101, r102);
        }

        @Override // android.webkit.WebViewClient
        public void onScaleChanged(WebView r100, float r101, float r102) {
            WebViewClient r103 = this.f278256a;
            if (r103 == null) goto L5;
            r103.onScaleChanged(r100, r101, r102);
            return;
        L5:
            super.onScaleChanged(r100, r101, r102);
        }

        @Override // android.webkit.WebViewClient
        public void onTooManyRedirects(WebView r100, Message r101, Message r102) {
            WebViewClient r103 = this.f278256a;
            if (r103 == null) goto L5;
            r103.onTooManyRedirects(r100, r101, r102);
            return;
        L5:
            super.onTooManyRedirects(r100, r101, r102);
        }

        public /* synthetic */ b(SafeWebView r100, WebViewClient r101, boolean r102, a r103) {
            this(r100, r101, r102);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView r100, int r101, String r102, String r103) {
            WebViewClient r104 = this.f278256a;
            if (r104 == null) goto L5;
            r104.onReceivedError(r100, r101, r102, r103);
            return;
        L5:
            super.onReceivedError(r100, r101, r102, r103);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpAuthRequest(WebView r100, HttpAuthHandler r101, String r102, String r103) {
            WebViewClient r104 = this.f278256a;
            if (r104 == null) goto L5;
            r104.onReceivedHttpAuthRequest(r100, r101, r102, r103);
            return;
        L5:
            super.onReceivedHttpAuthRequest(r100, r101, r102, r103);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedLoginRequest(WebView r100, String r101, String r102, String r103) {
            WebViewClient r104 = this.f278256a;
            if (r104 == null) goto L5;
            r104.onReceivedLoginRequest(r100, r101, r102, r103);
            return;
        L5:
            super.onReceivedLoginRequest(r100, r101, r102, r103);
        }

        @Override // android.webkit.WebViewClient
        public void onSafeBrowsingHit(WebView r100, WebResourceRequest r101, int r102, SafeBrowsingResponse r103) {
            WebViewClient r104 = this.f278256a;
            if (r104 == null) goto L5;
            r104.onSafeBrowsingHit(r100, r101, r102, r103);
            return;
        L5:
            super.onSafeBrowsingHit(r100, r101, r102, r103);
        }
    }

    public String[] getWhitelist() {
        String[] r100 = this.f278252b;
        if (r100 != null) goto L6;
        return null;
    L6:
        return (String[]) Arrays.copyOf(r100, r100.length);
    }

    public String[] getWhitelistNotMatchSubDomain() {
        String[] r100 = this.f278253c;
        if (r100 != null) goto L6;
        return null;
    L6:
        return (String[]) Arrays.copyOf(r100, r100.length);
    }

    public String[] getWhitelistNotMathcSubDomain() {
        String[] r100 = this.f278253c;
        if (r100 != null) goto L6;
        return null;
    L6:
        return (String[]) Arrays.copyOf(r100, r100.length);
    }

    public String[] getWhitelistWithPath() {
        String[] r100 = this.f278254d;
        if (r100 != null) goto L6;
        return null;
    L6:
        return (String[]) Arrays.copyOf(r100, r100.length);
    }

    private void a() {
        SafeWebSettings.initWebviewAndSettings(this);
        setWebViewClient(null);
    }

    public String getDefaultErrorPage() {
        return this.f278251a;
    }

    public WebViewLoadCallBack getWebViewLoadCallBack() {
        return this.f278255e;
    }

    public SafeWebView(Context r100) {
        super(r100);
        a();
    }

    private boolean a(String r100) {
        return URLUtil.isHttpUrl(r100);
    }

    public boolean isWhiteListUrl(String r100) {
        boolean r101 = false;
        if (TextUtils.isEmpty(r100) == false) goto L7;
        LogsUtil.e(f278250f, "url is null");
        return false;
    L7:
        if (URLUtil.isNetworkUrl(r100) == true) goto L9;
        return true;
    L9:
        String[] r102 = getWhitelistWithPath();
        String[] r103 = getWhitelistNotMatchSubDomain();
        String[] r104 = getWhitelist();
        if (r102 != null) goto L12;
    L15:
        boolean r105 = true;
    L16:
        if (r103 != null) goto L18;
    L21:
        boolean r106 = true;
    L22:
        if (r104 != null) goto L24;
    L25:
        r101 = true;
    L26:
        if (r105 == false) goto L30;
        if (r106 == false) goto L30;
        if (r101 == false) goto L30;
        return true;
    L30:
        if (r102 != null) goto L32;
    L35:
        if (r103 == null) goto L41;
        if (r103.length == 0) goto L41;
        return UriUtil.isUrlHostSameWhitelist(r100, r103);
    L41:
        return UriUtil.isUrlHostInWhitelist(r100, r104);
    L32:
        if (r102.length == 0) goto L35;
        return UriUtil.isUrlHostAndPathInWhitelist(r100, r102);
    L24:
        if (r104.length != 0) goto L26;
    L18:
        if (r103.length == 0) goto L21;
        r106 = false;
        goto L22
    L12:
        if (r102.length == 0) goto L15;
        r105 = false;
        goto L16
    }

    @Override // android.webkit.WebView
    public void loadUrl(String r100) {
        if (isWhiteListUrl(r100) == false) goto L10;
        if (a(r100) == true) goto L10;
        super.loadUrl(r100);
        return;
    L10:
        if (TextUtils.isEmpty(this.f278251a) == true) goto L13;
        super.loadUrl(this.f278251a);
        return;
    L13:
        if (getWebViewLoadCallBack() == null) goto L17;
        getWebViewLoadCallBack().onCheckError(r100, WebViewLoadCallBack.ErrorCode.HTTP_URL);
        return;
    }

    public void setDefaultErrorPage(String r100) {
        this.f278251a = r100;
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient r100) {
        super.setWebViewClient(new b(this, r100, true, null));
    }

    public void setWebViewLoadCallBack(WebViewLoadCallBack r100) {
        this.f278255e = r100;
    }

    public void setWhitelist(String[] r100) {
        if (r100 != null) goto L4;
        String[] r101 = null;
    L5:
        this.f278252b = r101;
        return;
    L4:
        r101 = (String[]) Arrays.copyOf(r100, r100.length);
        goto L5
    }

    public void setWhitelistNotMatchSubDomain(String[] r100) {
        if (r100 != null) goto L4;
        String[] r101 = null;
    L5:
        this.f278253c = r101;
        return;
    L4:
        r101 = (String[]) Arrays.copyOf(r100, r100.length);
        goto L5
    }

    public void setWhitelistNotMathcSubDomain(String[] r100) {
        if (r100 != null) goto L4;
        String[] r101 = null;
    L5:
        this.f278253c = r101;
        return;
    L4:
        r101 = (String[]) Arrays.copyOf(r100, r100.length);
        goto L5
    }

    public void setWhitelistWithPath(String[] r100) {
        if (r100 != null) goto L4;
        String[] r101 = null;
    L5:
        this.f278254d = r101;
        return;
    L4:
        r101 = (String[]) Arrays.copyOf(r100, r100.length);
        goto L5
    }

    public SafeWebView(Context r100, AttributeSet r101) {
        super(r100, r101);
        a();
    }

    @Override // android.webkit.WebView
    public void loadUrl(String r100, Map<String, String> r101) {
        if (isWhiteListUrl(r100) == false) goto L10;
        if (a(r100) == true) goto L10;
        super.loadUrl(r100, r101);
        return;
    L10:
        if (TextUtils.isEmpty(this.f278251a) == true) goto L13;
        super.loadUrl(this.f278251a, r101);
        return;
    L13:
        if (getWebViewLoadCallBack() == null) goto L17;
        getWebViewLoadCallBack().onCheckError(r100, WebViewLoadCallBack.ErrorCode.HTTP_URL);
        return;
    }

    public final void onCheckError(WebView r100, String r101) {
        LogsUtil.e(f278250f, "onCheckError url is not in white list ", r101);
        r100.stopLoading();
        String r102 = getDefaultErrorPage();
        if (TextUtils.isEmpty(r102) == true) goto L6;
        r100.loadUrl(r102);
        return;
    L6:
        if (getWebViewLoadCallBack() == null) goto L10;
        getWebViewLoadCallBack().onCheckError(r101, WebViewLoadCallBack.ErrorCode.URL_NOT_IN_WHITE_LIST);
        return;
    }

    @Override // android.webkit.WebView
    public void postUrl(String r100, byte[] r101) {
        if (isWhiteListUrl(r100) == false) goto L10;
        if (a(r100) == true) goto L10;
        super.postUrl(r100, r101);
        return;
    L10:
        if (TextUtils.isEmpty(this.f278251a) == true) goto L13;
        super.postUrl(this.f278251a, r101);
        return;
    L13:
        if (getWebViewLoadCallBack() == null) goto L17;
        getWebViewLoadCallBack().onCheckError(r100, WebViewLoadCallBack.ErrorCode.HTTP_URL);
        return;
    }

    public void setWebViewClient(WebViewClient r100, boolean r101) {
        super.setWebViewClient(new b(this, r100, r101, null));
    }

    public SafeWebView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a();
    }

    public SafeWebView(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, r103);
        a();
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String r100, String r101, String r110, String r111, String r112) {
        if (a(r100) == true) goto L5;
        super.loadDataWithBaseURL(r100, r101, r110, r111, r112);
        return;
    L5:
        if (TextUtils.isEmpty(this.f278251a) == true) goto L8;
        super.loadDataWithBaseURL(this.f278251a, r101, r110, r111, r112);
        return;
    L8:
        if (getWebViewLoadCallBack() == null) goto L14;
        getWebViewLoadCallBack().onCheckError(r100, WebViewLoadCallBack.ErrorCode.HTTP_URL);
        return;
    }
}
