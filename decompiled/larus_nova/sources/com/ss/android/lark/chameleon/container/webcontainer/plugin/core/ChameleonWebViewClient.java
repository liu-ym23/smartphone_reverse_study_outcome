package com.ss.android.lark.chameleon.container.webcontainer.plugin.core;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ss.android.lark.chameleon.api.pluginapi.IChameleonLoader;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.container.webcontainer.res.IWebResourceInterceptor;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.chameleon.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.EncriptUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0002'(B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001c\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J&\u0010\u0011\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J&\u0010\u0014\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0017J.\u0010\u0014\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u0010H\u0016J&\u0010\u001d\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001c\u0010 \u001a\u00020!2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001c\u0010$\u001a\u00020!2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u001e\u0010%\u001a\u0004\u0018\u00010\u001f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001c\u0010&\u001a\u00020!2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001c\u0010&\u001a\u00020!2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00060\nR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/core/ChameleonWebViewClient;", "Landroid/webkit/WebViewClient;", "interceptor", "Lcom/ss/android/lark/chameleon/container/webcontainer/res/IWebResourceInterceptor;", "webView", "Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonWebView;", "callback", "Lcom/ss/android/lark/chameleon/api/pluginapi/IChameleonLoader$LoadingCallback;", "(Lcom/ss/android/lark/chameleon/container/webcontainer/res/IWebResourceInterceptor;Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonWebView;Lcom/ss/android/lark/chameleon/api/pluginapi/IChameleonLoader$LoadingCallback;)V", "debounceShouldOverrideUrlLoading", "Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/core/ChameleonWebViewClient$DebounceShouldOverrideUrlLoading;", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onReceivedError", "request", "Landroid/webkit/WebResourceRequest;", "error", "Landroid/webkit/WebResourceError;", "errorCode", "", "description", "failingUrl", "onReceivedHttpError", "errorResponse", "Landroid/webkit/WebResourceResponse;", "onRenderProcessGone", "", "detail", "Landroid/webkit/RenderProcessGoneDetail;", "overrideUrlLoading", "shouldInterceptRequest", "shouldOverrideUrlLoading", "Companion", "DebounceShouldOverrideUrlLoading", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ChameleonWebViewClient extends WebViewClient {
    public static final Companion Companion = null;
    public static final int DEFAULT_SAFE_TIME = 500;
    private static final String MIME_TYPE_HTML = "text/html";
    private static final String MIME_TYPE_XHTML = "application/xhtml+xml";
    public static final String TAG = "CML_TAG_ChameleonWebViewClient";
    private final IChameleonLoader.LoadingCallback callback;
    private final DebounceShouldOverrideUrlLoading debounceShouldOverrideUrlLoading;
    private final IWebResourceInterceptor interceptor;
    private final ChameleonWebView webView;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/core/ChameleonWebViewClient$Companion;", "", "()V", "DEFAULT_SAFE_TIME", "", "MIME_TYPE_HTML", "", "MIME_TYPE_XHTML", "TAG", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/core/ChameleonWebViewClient$DebounceShouldOverrideUrlLoading;", "", "(Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/core/ChameleonWebViewClient;)V", "lastProcessTime", "", "lastUrl", "", "shouldOverrideUrlLoading", "", "view", "Landroid/webkit/WebView;", "url", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class DebounceShouldOverrideUrlLoading {
        private long lastProcessTime;
        private String lastUrl;
        final /* synthetic */ ChameleonWebViewClient this$0;

        public DebounceShouldOverrideUrlLoading(ChameleonWebViewClient r100) {
            this.this$0 = r100;
        }

        public final boolean shouldOverrideUrlLoading(WebView r100, String r101) {
            long r102 = System.currentTimeMillis();
            if (TextUtils.equals(this.lastUrl, r101) == true) goto L5;
        L8:
            this.lastProcessTime = r102;
            this.lastUrl = r101;
            return ChameleonWebViewClient.access$overrideUrlLoading(this.this$0, r100, r101);
        L5:
            if ((r102 - this.lastProcessTime) >= 500) goto L8;
            Log.w(ChameleonWebViewClient.TAG, "So fast click , ignored !");
            return true;
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final boolean overrideUrlLoading(WebView r100, String r101) {
        Log.i(TAG, "overrideUrlLoading:" + EncriptUtils.replaceToken(ChameleonContainerUtils.INSTANCE.safeUrlString(r101)));
        return false;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r100, String r101) {
        super.onPageFinished(r100, r101);
        Log.i(TAG, "onPageFinished");
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView r100, RenderProcessGoneDetail r101) {
        ChameleonOpenTracker.SessionTracker r102 = ChameleonOpenTracker.INSTANCE.getSessionTracker(this.webView.getSession());
        if (r102 == null) goto L5;
        r102.reportCommonError(100, "", !this.webView.isVisible() ? 1 : 0);
    L5:
        this.callback.onRenderProcessGone();
        return true;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView r100, WebResourceRequest r101) {
        IWebResourceInterceptor r102 = this.interceptor;
        Map<String, String> r103 = null;
        if (r101 == null) goto L5;
        Uri r104 = r101.getUrl();
    L6:
        if (r101 == null) goto L8;
        String r105 = r101.getMethod();
    L9:
        if (r101 == null) goto L12;
        r103 = r101.getRequestHeaders();
    L12:
        return r102.shouldInterceptRequest(r104, r105, r103);
    L8:
        r105 = null;
        goto L9
    L5:
        r104 = null;
        goto L6
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r100, WebResourceRequest r101) {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
    L13:
        if (r101 == null) goto L18;
        Uri r102 = r101.getUrl();
        if (r102 == null) goto L18;
        String r103 = r102.toString();
        if (r103 == null) goto L18;
    L20:
        return shouldOverrideUrlLoading(r100, r103);
    L18:
        r103 = "";
        goto L20
    L5:
        if (r101 == null) goto L9;
        boolean r104 = true;
        if (r101.isRedirect() != true) goto L9;
    L10:
        if (r104 == false) goto L13;
        Log.i(TAG, "shouldOverrideUrlLoading, is redirect, not intercept");
        return false;
    L9:
        r104 = false;
        goto L10
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r100, String r101) {
        return this.debounceShouldOverrideUrlLoading.shouldOverrideUrlLoading(r100, r101);
    }

    public ChameleonWebViewClient(IWebResourceInterceptor r100, ChameleonWebView r101, IChameleonLoader.LoadingCallback r102) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        Intrinsics.checkNotNullParameter(r101, "webView");
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.interceptor = r100;
        this.webView = r101;
        this.callback = r102;
        this.debounceShouldOverrideUrlLoading = new DebounceShouldOverrideUrlLoading(this);
    }

    public static final /* synthetic */ boolean access$overrideUrlLoading(ChameleonWebViewClient r100, WebView r101, String r102) {
        return r100.overrideUrlLoading(r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView r100, String r101, Bitmap r102) {
        super.onPageStarted(r100, r101, r102);
        Log.i(TAG, "onPageStarted");
        this.callback.onPageStarted(r101);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView r100, WebResourceRequest r101, WebResourceError r102) {
        super.onReceivedError(r100, r101, r102);
        String r103 = null;
        if (r101 == null) goto L5;
        Boolean r104 = Boolean.valueOf(r101.isForMainFrame());
    L6:
        Log.i(TAG, "onReceivedError  isMainFrame--" + r104);
        if (Build.VERSION.SDK_INT < 23) goto L37;
        StringBuilder r105 = new StringBuilder("onReceivedError request=");
        ChameleonContainerUtils r106 = ChameleonContainerUtils.INSTANCE;
        if (r101 == null) goto L11;
        Uri r107 = r101.getUrl();
    L12:
        r105.append(r106.safeUrlString(String.valueOf(r107)));
        r105.append(", error=");
        if (r102 == null) goto L15;
        Integer r108 = Integer.valueOf(r102.getErrorCode());
    L16:
        r105.append(r108);
        r105.append(": ");
        if (r102 == null) goto L19;
        CharSequence r109 = r102.getDescription();
    L20:
        r105.append(r109);
        Log.e(TAG, r105.toString());
        if (Intrinsics.areEqual(r104, Boolean.TRUE) == false) goto L41;
        IChameleonLoader.LoadingCallback r110 = this.callback;
        if (r102 == null) goto L25;
        int r111 = r102.getErrorCode();
    L26:
        if (r102 == null) goto L30;
        CharSequence r112 = r102.getDescription();
        if (r112 == null) goto L30;
        String r113 = r112.toString();
    L32:
        if (r102 == null) goto L36;
        CharSequence r114 = r102.getDescription();
        if (r114 == null) goto L36;
        r103 = r114.toString();
    L36:
        r110.onLoadFail(r111, r113, new Throwable(r103));
        return;
    L30:
        r113 = null;
        goto L32
    L25:
        r111 = 10000;
        goto L26
    L41:
        return;
    L19:
        r109 = null;
        goto L20
    L15:
        r108 = null;
        goto L16
    L11:
        r107 = null;
        goto L12
    L37:
        Log.e(TAG, "onReceivedError error=" + r102);
        if (Intrinsics.areEqual(r104, Boolean.TRUE) == false) goto L43;
        this.callback.onLoadFail(-1, "onReceivedError", new Throwable("onReceivedError"));
        return;
    L43:
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView r100, WebResourceRequest r101, WebResourceResponse r102) {
        super.onReceivedHttpError(r100, r101, r102);
        if (Build.VERSION.SDK_INT < 23) goto L18;
        StringBuilder r103 = new StringBuilder("onReceivedHttpError request=");
        ChameleonContainerUtils r104 = ChameleonContainerUtils.INSTANCE;
        Map<String, String> r105 = null;
        if (r101 == null) goto L9;
        Uri r106 = r101.getUrl();
        if (r106 == null) goto L9;
        String r107 = r106.toString();
    L10:
        r103.append(r104.safeUrlString(r107));
        r103.append(", error=");
        if (r102 == null) goto L13;
        Integer r108 = Integer.valueOf(r102.getStatusCode());
    L14:
        r103.append(r108);
        r103.append(": ");
        if (r102 == null) goto L17;
        r105 = r102.getResponseHeaders();
    L17:
        r103.append(r105);
        Log.e(TAG, r103.toString());
    L19:
        boolean r109 = false;
        if (r101 != null) goto L22;
    L24:
        if (r102 == null) goto L26;
        String r110 = r102.getMimeType();
        int r111 = r102.getStatusCode();
        String r112 = r102.getReasonPhrase();
    L27:
        Log.i(ChameleonLoaderImpl.TAG, "onReceivedHttpError  isMainFrame--" + r109 + " ,   statusCode--" + r111 + ",   mimeType--" + r110 + ",   description--" + r112);
        if (TextUtils.equals(MIME_TYPE_XHTML, r110) == false) goto L30;
    L33:
        if (r109 == true) goto L37;
        Log.i(ChameleonLoaderImpl.TAG, "isMainFrame--" + r109);
        return;
    L37:
        if (r111 < 400) goto L40;
        this.callback.onLoadFail(r111, r112, new Throwable(r112));
        return;
    L40:
        return;
    L30:
        if (TextUtils.equals("text/html", r110) == true) goto L33;
        Log.i(ChameleonLoaderImpl.TAG, "is no html ,return ");
        return;
    L26:
        r110 = "";
        r111 = 10000;
        r112 = "";
        goto L27
    L22:
        if (r101.isForMainFrame() != true) goto L24;
        r109 = true;
        goto L24
    L13:
        r108 = null;
    L9:
        r107 = null;
        goto L10
    L18:
        Log.e(TAG, "onReceivedHttpError error=" + r102);
        goto L19
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView r100, int r101, String r102, String r103) {
        super.onReceivedError(r100, r101, r102, r103);
        Log.e(TAG, "onReceivedError errorCode=" + r101 + ", description=" + r102 + ", failingUrl=" + ChameleonContainerUtils.INSTANCE.safeUrlString(r103));
    }
}
