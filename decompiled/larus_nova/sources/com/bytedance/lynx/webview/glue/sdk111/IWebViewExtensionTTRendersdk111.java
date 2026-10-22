package com.bytedance.lynx.webview.glue.sdk111;

import android.view.View;

/* JADX INFO: loaded from: classes21.dex */
public interface IWebViewExtensionTTRendersdk111 {
    boolean isTTRenderInBrowserEnabled();

    void platformViewOnComputeScroll(int r100, int r101, int r102);

    void platformViewParpareDraw(int r100);

    void registerPlatformView(View r100, int r101);

    void setPlatformViewLayersScrollListener(Object r100);

    void unregisterPlatformView(View r100, int r101);
}
