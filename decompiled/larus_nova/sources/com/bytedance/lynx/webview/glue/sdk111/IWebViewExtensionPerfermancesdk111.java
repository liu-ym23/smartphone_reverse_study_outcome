package com.bytedance.lynx.webview.glue.sdk111;

/* JADX INFO: loaded from: classes21.dex */
public interface IWebViewExtensionPerfermancesdk111 {
    long getLoadingStatusCode();

    String getPerformanceMetrics(String r100);

    String getPerformanceTiming();

    void setPerformanceTimingListener(Object r100);
}
