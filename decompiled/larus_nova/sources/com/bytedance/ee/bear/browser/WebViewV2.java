package com.bytedance.ee.bear.browser;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.ee.bear.browser.view.DecorateWebViewV2;
import tt5.a;

/* JADX INFO: loaded from: classes16.dex */
public class WebViewV2 extends DecorateWebViewV2 {

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public int f216607b1;

    @Override // android.webkit.WebView, android.view.View
    public final int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.webkit.WebView, android.view.View
    public final int computeVerticalScrollRange() {
        int r100 = super.computeVerticalScrollRange();
        this.f216607b1 = r100;
        return r100;
    }

    public int getLastVerticalScrollRange() {
        return this.f216607b1;
    }

    public WebViewV2(Context r100) {
        super(r100);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onWindowFocusChanged(boolean r100) {
        super.onWindowFocusChanged(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        a.f("WebViewV2", th, false);
    }

    public WebViewV2(Context r100, AttributeSet r101) {
        super(r100, r101);
    }
}
