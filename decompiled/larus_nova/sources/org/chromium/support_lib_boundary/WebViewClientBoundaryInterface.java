package org.chromium.support_lib_boundary;

import android.app.PendingIntent;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.lang.reflect.InvocationHandler;

/* JADX INFO: loaded from: classes42.dex */
public interface WebViewClientBoundaryInterface extends FeatureFlagHolderBoundaryInterface {
    void onPageCommitVisible(WebView r100, String r101);

    void onReceivedError(WebView r100, WebResourceRequest r101, InvocationHandler r102);

    void onReceivedHttpError(WebView r100, WebResourceRequest r101, WebResourceResponse r102);

    void onSafeBrowsingHit(WebView r100, WebResourceRequest r101, int r102, InvocationHandler r103);

    boolean onWebAuthnIntent(WebView r100, PendingIntent r101, InvocationHandler r102);

    boolean shouldOverrideUrlLoading(WebView r100, WebResourceRequest r101);
}
