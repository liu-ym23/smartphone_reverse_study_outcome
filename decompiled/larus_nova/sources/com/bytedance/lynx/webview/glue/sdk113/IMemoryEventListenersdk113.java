package com.bytedance.lynx.webview.glue.sdk113;

import android.webkit.WebView;

/* JADX INFO: loaded from: classes21.dex */
public interface IMemoryEventListenersdk113 {
    void onGLOom(WebView r100, String r101);

    void onImageDecodeOom(WebView r100, String r101);

    void onMemoryPressure(WebView r100, int r101, String r102);
}
