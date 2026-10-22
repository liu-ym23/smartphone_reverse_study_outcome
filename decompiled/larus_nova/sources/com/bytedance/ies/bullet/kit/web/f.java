package com.bytedance.ies.bullet.kit.web;

import android.webkit.WebView;

/* JADX INFO: loaded from: classes19.dex */
public final class f extends b36.j {
    public f() {
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView r100, int r101) {
        super.onProgressChanged(r100, r101);
        com.bytedance.android.monitorV2.webview.m.f163358f.K(r100, r101);
    }
}
