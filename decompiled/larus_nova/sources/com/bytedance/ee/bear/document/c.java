package com.bytedance.ee.bear.document;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: loaded from: classes16.dex */
public final class c extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f219176a = 0;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f219177a = null;

        static {
            f219177a = new c();
        }
    }

    public c() {
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r100, String r101) {
        tt5.a.d("BackgroundWebViewClient", "BackgroundWebViewClient shouldOverrideUrlLoading " + du5.b.l(r101));
        return true;
    }
}
