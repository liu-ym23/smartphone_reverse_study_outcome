package com.bytedance.lynx.webview.glue.sdk113;

import android.graphics.Canvas;
import android.os.Bundle;
import android.webkit.ValueCallback;
import android.webkit.WebMessagePort;
import android.webkit.WebView;
import com.bytedance.lynx.webview.glue.ITTWebPluginManager;
import g17.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public interface IWebViewExtensionsdk113 {

    public interface BlankDetectAsyncCallbackImpl {
        void onResult(String r100);
    }

    public interface DownloadFileCallback {
        void onDownloadFinish(String r100, boolean r101, String r102);
    }

    public interface GrabSnapshotAsyncCallback {
        void onResult(Canvas r100, boolean r101);
    }

    public interface IResourceLoadListenerSdk113 {

        /* JADX INFO: renamed from: com.bytedance.lynx.webview.glue.sdk113.IWebViewExtensionsdk113$IResourceLoadListenerSdk113$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onNetworkEvent(IResourceLoadListenerSdk113 r100, String r101, String r102, String r103) {
            }
        }

        void onNetworkEvent(String r100, String r101, String r102);

        void onResourceLoaded(WebView r100, String r101, String r102, String r103, long r104);
    }

    public interface ITTAdblockEventListenerSdk113 {
        void onAdblockIntercept(JSONObject r100);
    }

    public interface ITTSafeBrowsingListenerSdk113 {

        /* JADX INFO: renamed from: com.bytedance.lynx.webview.glue.sdk113.IWebViewExtensionsdk113$ITTSafeBrowsingListenerSdk113$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onSDKSafeBrowsingHit(ITTSafeBrowsingListenerSdk113 r100, WebView r101, String r102, a r103, ValueCallback r104) {
            }

            public static void $default$onSafeBrowsingCallback(ITTSafeBrowsingListenerSdk113 r100, String r101, String r102) {
            }

            public static boolean $default$shouldSkipCheck(ITTSafeBrowsingListenerSdk113 r100, WebView r101, String r102) {
                return false;
            }
        }

        void onSDKSafeBrowsingHit(WebView r100, String r101, a r102, ValueCallback<String> r103);

        void onSafeBrowsingCallback(String r100, String r101);

        void onTTSafeBrowsingHit(String r100, boolean r101, int r102, int r103, String r104);

        void onTTSafeBrowsingHitV2(String r100, boolean r101, int r102, int r103, String r104, ValueCallback<String> r105);

        boolean shouldSkipCheck(WebView r100, String r101);
    }

    long GetNativeMessagePort(WebMessagePort r100);

    void addResourceEventListener(Object r100);

    boolean blankDetectAsyncImpl(Object r100, int r101) throws Exception;

    WebMessagePort[] createWebMessageChannel();

    void downloadFileImpl(String r100, Object r101) throws Exception;

    boolean execute(String r100, Bundle r101);

    ITTWebPluginManager getTTWebPluginManager();

    boolean grabSnapshotAsyncImpl(Canvas r100, Object r101) throws Exception;

    boolean isFeatureSupport(String r100);

    boolean isFeatureSupport(String r100, int r101);

    void notificationV8ToGC();

    void notifyV8ToGC();

    void removeResourceEventListener(Object r100);

    void resetWebView();

    void setCSPEnableFromClient(boolean r100);

    void setImageLazyLoadEnabled(boolean r100);

    void setMemoryEventListener(Object r100);

    void setPredictorEventListener(Object r100);

    void setQuickResponseEnabled(boolean r100);

    void setResourceLoadListener(Object r100);

    void setSccExtraInfo(JSONObject r100);

    void setSccExtraScene(String r100);

    void setTTAdblockEventListener(Object r100);

    void setTTSafeBrowsingListener(Object r100);

    void setTTUserResponseListener(Object r100);

    void setTouchHitTestListener(String[] r100, ValueCallback<JSONObject> r101);

    void setWebContentsDebuggingEnabled(boolean r100);
}
