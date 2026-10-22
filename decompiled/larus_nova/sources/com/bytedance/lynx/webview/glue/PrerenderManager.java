package com.bytedance.lynx.webview.glue;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;

/* JADX INFO: loaded from: classes21.dex */
public interface PrerenderManager {
    public static final int DEPRECATED_FULL_PRERENDER = 1;
    public static final int NO_PRERENDER = 0;
    public static final int PREFETCH_ONLY = 2;
    public static final int PREFETCH_TO_MEMORY_CSS_JS = 4;
    public static final int PREFETCH_TO_MEMORY_IN_HEAD_TAG = 5;
    public static final int PREFETCH_TO_MEMORY_NO_FILTER = 3;

    public interface Client {
        WebResourceResponse shouldInterceptRequest(WebResourceRequest r100);
    }

    void clearQueuedPrefetchToMemory();

    void destroy();

    void prefetchToMemory(String r100, int r101);

    void removePrefetchToMemory(String r100);

    void setClient(Client r100);

    void setClient(Object r100);
}
