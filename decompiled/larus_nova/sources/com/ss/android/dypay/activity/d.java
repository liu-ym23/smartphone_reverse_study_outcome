package com.ss.android.dypay.activity;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ss.android.dypay.webview.DyJsWebView;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class d extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DyPayH5Activity f408381a;

    public d(DyPayH5Activity r100) {
        this.f408381a = r100;
    }

    @Override // android.webkit.WebViewClient
    public void onPageCommitVisible(WebView r100, String r101) {
        DyPayH5Activity.i(this.f408381a, "commit_visible");
        super.onPageCommitVisible(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView r100, String r101, Bitmap r102) {
        DyPayH5Activity.i(this.f408381a, "page_started");
        super.onPageStarted(r100, r101, r102);
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView r100, WebResourceRequest r101) {
        DyPayH5Activity.i(this.f408381a, "intercept_request");
        return super.shouldInterceptRequest(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView r100, String r101) {
        DyPayH5Activity.i(this.f408381a, "intercept_request");
        return super.shouldInterceptRequest(r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r100, String r101) {
        DyPayH5Activity.i(this.f408381a, "page_finished");
        super.onPageFinished(r100, r101);
        DyJsWebView r102 = this.f408381a.f408352c;
        if (r102 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        if (r102.getProgress() <= 80) goto L13;
        DyPayH5Activity r103 = this.f408381a;
        View r104 = r103.f408355f;
        if (r104 == null) goto L10;
        r104.setVisibility(8);
    L10:
        ObjectAnimator r105 = r103.f408357h;
        if (r105 == null) goto L13;
        r105.cancel();
    L13:
        DyPayH5Activity r106 = this.f408381a;
        if (r106.f408362m == true) goto L17;
        r106.f408362m = true;
        DyPayH5Activity.j(r106, "load_finished", "webview_page_load_finished", 4);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView r100, WebResourceRequest r101, WebResourceError r102) {
        super.onReceivedError(r100, r101, r102);
        DyPayH5Activity r103 = this.f408381a;
        View r104 = r103.f408355f;
        if (r104 == null) goto L5;
        r104.setVisibility(8);
    L5:
        ObjectAnimator r105 = r103.f408357h;
        if (r105 == null) goto L9;
        r105.cancel();
    L9:
        if (this.f408381a.f408364o == false) goto L12;
        return;
    L12:
        if (Build.VERSION.SDK_INT < 23) goto L17;
        if (r102 == null) goto L15;
        CharSequence r106 = r102.getDescription();
    L16:
        String r107 = String.valueOf(r106);
    L18:
        JSONObject r108 = sta.a.f543575a;
        sta.a.g("DyPayH5Activity_onReceivedError, ".concat(r107));
        return;
    L15:
        r106 = null;
        goto L16
    L17:
        r107 = "";
        goto L18
    }
}
