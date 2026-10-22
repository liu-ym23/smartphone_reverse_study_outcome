package com.bytedance.ee.bear.drive.view.widget;

import android.net.Uri;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes16.dex */
public class d extends WebChromeClient {
    @Override // android.webkit.WebChromeClient
    public final void onCloseWindow(WebView r100) {
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView r100, ValueCallback<Uri[]> r101, WebChromeClient.FileChooserParams r102) {
        return false;
    }

    public d() {
    }
}
