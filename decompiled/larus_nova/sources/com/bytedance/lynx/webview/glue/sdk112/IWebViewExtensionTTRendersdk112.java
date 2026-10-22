package com.bytedance.lynx.webview.glue.sdk112;

import android.webkit.ValueCallback;

/* JADX INFO: loaded from: classes21.dex */
public interface IWebViewExtensionTTRendersdk112 {
    boolean isTTRenderEnabled(String r100);

    boolean renderEvaluateJavaScript(String r100, ValueCallback<String> r101);
}
