package com.ss.android.dypay.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010$\u001a\u00020\u0010¢\u0006\u0004\b%\u0010&J#\u0010\u0006\u001a\u00020\u00052\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u001c\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006'"}, d2 = {"Lcom/ss/android/dypay/webview/DyJsWebView;", "Landroid/widget/FrameLayout;", "", "", "params", "", "setHeaderParams", "(Ljava/util/Map;)V", "Landroid/webkit/WebViewClient;", "webViewClient", "setWebViewClient", "(Landroid/webkit/WebViewClient;)V", "Landroid/webkit/WebChromeClient;", "webChromeClient", "setWebChromeClient", "(Landroid/webkit/WebChromeClient;)V", "", "getProgress", "()I", "Landroid/webkit/WebView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/webkit/WebView;", "getWebView", "()Landroid/webkit/WebView;", "webView", "Landroid/webkit/WebSettings;", "getSettings", "()Landroid/webkit/WebSettings;", "settings", "getUrl", "()Ljava/lang/String;", "url", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dy-pay-sdk_withoutLogRelease"}, k = 1, mv = {1, 4, 0})
public final class DyJsWebView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f408526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, String> f408527b;

    public DyJsWebView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DyJsWebView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public /* synthetic */ DyJsWebView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final int getProgress() {
        return this.f408526a.getProgress();
    }

    public final WebSettings getSettings() {
        return this.f408526a.getSettings();
    }

    public final String getUrl() {
        String r100 = this.f408526a.getUrl();
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100;
    }

    public final WebView getWebView() {
        return this.f408526a;
    }

    public final void setHeaderParams(Map<String, String> r100) {
        if (r100 == null) goto L5;
        this.f408527b = r100;
        return;
    }

    public final void setWebChromeClient(WebChromeClient r100) {
        this.f408526a.setWebChromeClient(r100);
    }

    public final void setWebViewClient(WebViewClient r100) {
        this.f408526a.setWebViewClient(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDefaultTextEncodingName("UTF-8");
        getSettings().setAllowFileAccess(false);
        getSettings().setAllowContentAccess(false);
        getSettings().setDomStorageEnabled(true);
        getSettings().setCacheMode(-1);
        getSettings().setSavePassword(false);
        getSettings().setAllowFileAccess(false);
        getSettings().setAllowFileAccessFromFileURLs(false);
        getSettings().setAllowUniversalAccessFromFileURLs(false);
        getSettings().setMixedContentMode(0);
        this.f408526a.setVerticalScrollBarEnabled(true);
    }

    public DyJsWebView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        b r103 = new b(r100);
        this.f408526a = r103;
        addView(r103);
    }
}
