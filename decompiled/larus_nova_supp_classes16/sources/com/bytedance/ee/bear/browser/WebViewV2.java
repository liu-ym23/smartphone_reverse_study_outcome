package com.bytedance.ee.bear.browser;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.ee.bear.browser.view.DecorateWebViewV2;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class WebViewV2 extends DecorateWebViewV2 {
    public int b1;

    /* JADX WARN: Multi-variable type inference failed */
    public final int computeHorizontalScrollRange() {
        return super/*android.webkit.WebView*/.computeHorizontalScrollRange();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int computeVerticalScrollRange() {
        int r0 = super/*android.webkit.WebView*/.computeVerticalScrollRange();
        this.b1 = r0;
        return r0;
    }

    public int getLastVerticalScrollRange() {
        return this.b1;
    }

    public WebViewV2(Context r1) {
        super(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onWindowFocusChanged(boolean r3) {
        super/*android.webkit.WebView*/.onWindowFocusChanged(r3);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        a.f("WebViewV2", th, false);
    }

    public WebViewV2(Context r1, AttributeSet r2) {
        super(r1, r2);
    }
}
