package org.chromium.support_lib_boundary;

import android.net.Uri;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import java.lang.reflect.InvocationHandler;

/* JADX INFO: loaded from: classes42.dex */
public interface WebViewProviderBoundaryInterface {
    InvocationHandler addDocumentStartJavaScript(String r100, String[] r101);

    void addWebMessageListener(String r100, String[] r101, InvocationHandler r102);

    InvocationHandler[] createWebMessageChannel();

    WebChromeClient getWebChromeClient();

    WebViewClient getWebViewClient();

    InvocationHandler getWebViewRenderer();

    InvocationHandler getWebViewRendererClient();

    void insertVisualStateCallback(long r100, InvocationHandler r101);

    void postMessageToMainFrame(InvocationHandler r100, Uri r101);

    void removeWebMessageListener(String r100);

    void setWebViewRendererClient(InvocationHandler r100);
}
