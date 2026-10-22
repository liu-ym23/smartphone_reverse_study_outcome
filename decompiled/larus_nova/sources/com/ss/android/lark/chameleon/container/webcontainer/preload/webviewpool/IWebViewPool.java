package com.ss.android.lark.chameleon.container.webcontainer.preload.webviewpool;

import com.ss.android.lark.chameleon.api.ChameleonConfig;
import com.ss.android.lark.chameleon.container.webcontainer.view.ChameleonWebView;

/* JADX INFO: loaded from: classes35.dex */
public interface IWebViewPool {

    public interface TraverseAction {
        boolean onWebViewTraverse(ChameleonWebView r100);
    }

    public interface WebViewLifecycleListener {
        void onWebViewCreated(ChameleonWebView r100);

        void onWebViewDestroyed(ChameleonWebView r100);
    }

    ChameleonWebView createWebView(ChameleonConfig r100);

    void destroyAll();

    void destroyWebView(ChameleonWebView r100);

    ChameleonWebView detachWebView(Object r100);

    ChameleonWebView getCurWebView(Object r100, boolean r101);

    WebViewPool.WebViewItem getCurWebViewItem(Object r100, boolean r101);

    ChameleonWebView getOverMaxUsedWebView(int r100);

    int occupiedSize();

    int poolSize();

    ChameleonWebView provideWebView(Object r100, boolean r101);

    void setWebViewLifeCycleListener(WebViewLifecycleListener r100);

    void traversePool(TraverseAction r100);
}
