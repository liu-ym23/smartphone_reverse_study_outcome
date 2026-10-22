package com.bytedance.ug.sdk.luckycat.impl.browser.webview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import bn7.e;
import com.bytedance.ug.sdk.luckycat.api.depend.j;
import com.bytedance.ug.sdk.luckycat.impl.manager.m;
import com.bytedance.ug.sdk.luckycat.utils.i;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public class SSWebView extends WebView {
    @Override // android.webkit.WebView
    public boolean canGoBack() {
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
        String r100 = super.getOriginalUrl();     // Catch: Exception -> L12
        if (r100 != null) goto L5;
        return r100;
    L5:
        if (r100.startsWith("data:text/html") == false) goto L17;
        String r101 = super.getUrl();     // Catch: Exception -> L12
        if (r101 == null) goto L18;
        if (r101.startsWith(MSkiaImageRegionDecoder.FILE_PREFIX) == true) goto L11;
        return r100;
    L11:
        return r101;
    L18:
        return r100;
    L17:
        return r100;
    L12:
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
    public void goBack() {
        super.goBack();     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView
    public final void goForward() {
        super.goForward();     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView
    public void reload() {
        super.reload();     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView
    public final void stopLoading() {
        super.stopLoading();     // Catch: Exception -> L4
        return;
    }

    public SSWebView(Context r100) {
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

    public final String f(String r100) {
        if (getContext() != null) goto L5;
        return r100;
    L5:
        if (i.f(r100) == false) goto L17;
        j r101 = m.a.f271349a.f271336d;
        if (r101 == null) goto L18;
        e r102 = ((cn7.e) r101).f24556a;
        if (r102 == null) goto L11;
        r102.d();
        String r103 = "";
    L13:
        if (TextUtils.isEmpty(r103) == false) goto L15;
        return r100;
    L15:
        return r103;
    L11:
        r103 = r100;
        goto L13
    L18:
        return r100;
    L17:
        return r100;
    }

    @Override // android.webkit.WebView
    public final void goBackOrForward(int r100) {
        super.goBackOrForward(r100);     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView, cd7.a
    public void loadUrl(String r100) {
        super.loadUrl(f(r100));     // Catch: Exception -> L4
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
        super.setWebChromeClient(r100);     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient r100) {
        super.setWebViewClient(r100);     // Catch: Exception -> L4
        return;
    }

    public SSWebView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // android.webkit.WebView
    public final void loadUrl(String r100, Map<String, String> r101) {
        super.loadUrl(f(r100), r101);     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView
    public final void postUrl(String r100, byte[] r101) {
        super.postUrl(f(r100), r101);     // Catch: Exception -> L4
        return;
    }

    public SSWebView(Context r100, AttributeSet r101, int r102) {
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
