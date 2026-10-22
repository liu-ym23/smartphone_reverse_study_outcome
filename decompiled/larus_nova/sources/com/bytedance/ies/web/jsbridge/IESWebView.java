package com.bytedance.ies.web.jsbridge;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Map;
import java.util.Objects;
import n56.b;
import n56.e;

/* JADX INFO: loaded from: classes19.dex */
public class IESWebView extends WebView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f249265a;

    public void setWebViewUrlFilter(e r100) {
    }

    @Override // android.webkit.WebView
    public final boolean canGoBack() {
        return super.canGoBack();
    L4:
        return false;
    }

    @Override // android.webkit.WebView
    public final boolean canGoForward() {
        return super.canGoForward();
    L4:
        return false;
    }

    @Override // android.webkit.WebView
    public int getContentHeight() {
        return super.getContentHeight();
    L4:
        return 1;
    }

    @Override // android.webkit.WebView
    public String getOriginalUrl() {
        return super.getOriginalUrl();
    L4:
        return null;
    }

    @Override // android.webkit.WebView
    public int getProgress() {
        return super.getProgress();
    L4:
        return 100;
    }

    @Override // android.webkit.WebView
    public String getUrl() {
        return super.getUrl();
    L4:
        return null;
    }

    @Override // android.webkit.WebView
    public final void clearFormData() {
        super.clearFormData();     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView
    public final void clearHistory() {
        super.clearHistory();     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView, android.view.View
    public final void computeScroll() {
        super.computeScroll();     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView
    public final void goBack() {
        super.goBack();     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView
    public final void goForward() {
        super.goForward();     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView
    public final void reload() {
        super.reload();     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView
    public final void stopLoading() {
        super.stopLoading();     // Catch: Exception -> L4
        return;
    }

    public IESWebView(Context r100) {
        super(r100);
    }

    @Override // android.webkit.WebView
    public final boolean canGoBackOrForward(int r100) {
        return super.canGoBackOrForward(r100);
    L4:
        return false;
    }

    @Override // android.webkit.WebView
    public final void clearCache(boolean r100) {
        super.clearCache(r100);     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView
    public final void goBackOrForward(int r100) {
        super.goBackOrForward(r100);     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView
    public final void loadUrl(String r100) {
        super.loadUrl(r100);     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        return super.onTouchEvent(r100);
    L4:
        return false;
    }

    @Override // android.webkit.WebView, android.view.View
    public void setBackgroundColor(int r100) {
        super.setBackgroundColor(r100);     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView
    public void setDownloadListener(DownloadListener r100) {
        super.setDownloadListener(r100);     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView
    public void setNetworkAvailable(boolean r100) {
        super.setNetworkAvailable(r100);     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient r100) {
        super.setWebChromeClient(r100);     // Catch: Exception -> L9
        if (r100 == null) goto L6;
        boolean r101 = true;
    L7:
        this.f249265a = r101;     // Catch: Exception -> L9
        return;
    L6:
        r101 = false;
    L9:
        this.f249265a = false;
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient r100) {
        super.setWebViewClient(r100);     // Catch: Exception -> L6
        if ((r100 instanceof b) == true) goto L9;
        Objects.toString(r100);     // Catch: Exception -> L6
        return;
    L9:
        return;
    }

    public IESWebView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // android.webkit.WebView
    public final void loadUrl(String r100, Map<String, String> r101) {
        super.loadUrl(r100, r101);     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView
    public final void postUrl(String r100, byte[] r101) {
        super.postUrl(r100, r101);     // Catch: Exception -> L4
        return;
    }

    public IESWebView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }

    @Override // android.webkit.WebView
    public final void loadData(String r100, String r101, String r102) {
        super.loadData(r100, r101, r102);     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView
    public final void loadDataWithBaseURL(String r100, String r101, String r102, String r103, String r104) {
        super.loadDataWithBaseURL(r100, r101, r102, r103, r104);     // Catch: Exception -> L4
        return;
    }
}
