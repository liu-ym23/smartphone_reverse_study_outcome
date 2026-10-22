package com.bytedance.lynx.webview.glue.sdk111;

import com.bytedance.lynx.webview.glue.TTWebViewSettings;
import com.bytedance.lynx.webview.glue.TextSelectedEventListener;

/* JADX INFO: loaded from: classes21.dex */
public interface IWebViewExtensionsdk111 {
    TTWebViewSettings getTTWebViewSettings();

    void setHeadXRequestWith(boolean r100, String r101);

    void setIsNeedTTwebviewUserAgent(boolean r100);

    void setTextSelectedEventListener(TextSelectedEventListener r100);

    void setTextSelectedEventListener(Object r100);
}
