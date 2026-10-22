package com.bytedance.lynx.webview.glue;

import android.webkit.ServiceWorkerController;
import android.webkit.TokenBindingService;
import android.webkit.WebViewFactoryProvider;

/* JADX INFO: loaded from: classes21.dex */
public final class GlueApiHelperForO {
    private GlueApiHelperForO() {
    }

    public static ServiceWorkerController createServiceWorkerController(WebViewFactoryProvider r100) {
        return r100.getServiceWorkerController();
    }

    public static TokenBindingService createTokenBindingService(WebViewFactoryProvider r100) {
        return r100.getTokenBindingService();
    }
}
