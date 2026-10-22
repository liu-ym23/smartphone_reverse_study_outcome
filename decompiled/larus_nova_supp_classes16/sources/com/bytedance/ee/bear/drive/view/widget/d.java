package com.bytedance.ee.bear.drive.view.widget;

import android.net.Uri;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class d extends WebChromeClient {
    @Override // android.webkit.WebChromeClient
    public final void onCloseWindow(WebView r1) {
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView r1, ValueCallback<Uri[]> r2, WebChromeClient.FileChooserParams r3) {
        return false;
    }

    public d() {
    }
}
