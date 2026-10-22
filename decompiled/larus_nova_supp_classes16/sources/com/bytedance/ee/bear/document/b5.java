package com.bytedance.ee.bear.document;

import android.content.Context;
import android.webkit.WebView;
import com.bytedance.ee.bear.browser.WebFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface b5 {

    public interface a {
        void a();
    }

    void a(WebFragment r1);

    void b(a r1);

    void c(a r1);

    void d(DocBridgeWebViewV2 r1, WebFragment r2);

    Context getContext();

    int getHeight();

    WebView getWebView();

    boolean isAttached();

    void onResume();
}
