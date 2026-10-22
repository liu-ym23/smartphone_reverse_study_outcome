package com.bytedance.ee.bear.document;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c extends WebViewClient {
    public static final /* synthetic */ int a = 0;

    public static class a {
        public static final c a = null;

        static {
            a = new c();
        }
    }

    public c() {
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r2, String r3) {
        tt5.a.d("BackgroundWebViewClient", "BackgroundWebViewClient shouldOverrideUrlLoading " + du5.b.l(r3));
        return true;
    }
}
