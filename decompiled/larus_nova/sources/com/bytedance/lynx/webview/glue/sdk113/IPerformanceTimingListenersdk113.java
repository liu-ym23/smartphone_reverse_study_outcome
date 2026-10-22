package com.bytedance.lynx.webview.glue.sdk113;

/* JADX INFO: loaded from: classes21.dex */
public interface IPerformanceTimingListenersdk113 {

    /* JADX INFO: renamed from: com.bytedance.lynx.webview.glue.sdk113.IPerformanceTimingListenersdk113$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onGetJavaScriptStackTrace(IPerformanceTimingListenersdk113 r100, String r101) {
        }

        public static void $default$onImageTimelineInfo(IPerformanceTimingListenersdk113 r100, String r101) {
        }

        public static void $default$onScrollingSmoothnessInfo(IPerformanceTimingListenersdk113 r100, String r101) {
        }
    }

    void onBodyParsing();

    void onFirstImagePaint();

    void onGetJavaScriptStackTrace(String r100);

    void onIframeLoaded(String r100);

    void onImageTimelineInfo(String r100);

    void onJSError(String r100);

    void onNetFinish();

    void onReceivedSpecialEvent(String r100);

    void onScrollingSmoothnessInfo(String r100);
}
