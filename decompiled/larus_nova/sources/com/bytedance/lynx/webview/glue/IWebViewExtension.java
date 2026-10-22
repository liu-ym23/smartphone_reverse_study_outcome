package com.bytedance.lynx.webview.glue;

import android.webkit.ValueCallback;
import com.bytedance.lynx.webview.glue.sdk111.IPerformanceTimingListenersdk111;
import com.bytedance.lynx.webview.glue.sdk111.IPlatformViewLayersScrollListenersdk111;
import com.bytedance.lynx.webview.glue.sdk111.IWebViewExtensionNetsdk111;
import com.bytedance.lynx.webview.glue.sdk111.IWebViewExtensionPerfermancesdk111;
import com.bytedance.lynx.webview.glue.sdk111.IWebViewExtensionTTRendersdk111;
import com.bytedance.lynx.webview.glue.sdk111.IWebViewExtensionsdk111;
import com.bytedance.lynx.webview.glue.sdk112.IPerformanceTimingListenersdk112;
import com.bytedance.lynx.webview.glue.sdk112.IRenderProcessGoneListenerWrappersdk112;
import com.bytedance.lynx.webview.glue.sdk112.IRenderProcessGoneListenersdk112;
import com.bytedance.lynx.webview.glue.sdk112.IWebViewExtensionNetsdk112;
import com.bytedance.lynx.webview.glue.sdk112.IWebViewExtensionPerfermancesdk112;
import com.bytedance.lynx.webview.glue.sdk112.IWebViewExtensionTTRendersdk112;
import com.bytedance.lynx.webview.glue.sdk112.IWebViewExtensionsdk112;
import com.bytedance.lynx.webview.glue.sdk113.IMemoryEventListenersdk113;
import com.bytedance.lynx.webview.glue.sdk113.IPerformanceTimingListenersdk113;
import com.bytedance.lynx.webview.glue.sdk113.IPredictorEventListenersdk113;
import com.bytedance.lynx.webview.glue.sdk113.IResourceEventListenersdk113;
import com.bytedance.lynx.webview.glue.sdk113.IWebViewExtensionNetsdk113;
import com.bytedance.lynx.webview.glue.sdk113.IWebViewExtensionPerfermancesdk113;
import com.bytedance.lynx.webview.glue.sdk113.IWebViewExtensionPredictorsdk113;
import com.bytedance.lynx.webview.glue.sdk113.IWebViewExtensionsdk113;

/* JADX INFO: loaded from: classes21.dex */
public interface IWebViewExtension extends IWebViewExtensionsdk111, IWebViewExtensionTTRendersdk111, IWebViewExtensionNetsdk111, IWebViewExtensionPerfermancesdk111, IWebViewExtensionsdk112, IWebViewExtensionTTRendersdk112, IWebViewExtensionNetsdk112, IWebViewExtensionPerfermancesdk112, IWebViewExtensionsdk113, IWebViewExtensionNetsdk113, IWebViewExtensionPredictorsdk113, IWebViewExtensionPerfermancesdk113 {

    public interface MemoryEventListener extends IMemoryEventListenersdk113 {
    }

    public interface PerformanceTimingListener extends IPerformanceTimingListenersdk111, IPerformanceTimingListenersdk112, IPerformanceTimingListenersdk113 {
    }

    public interface PlatformViewLayersScrollListener extends IPlatformViewLayersScrollListenersdk111 {
    }

    public static class PredictorEventListener extends IPredictorEventListenersdk113 {
        public PredictorEventListener() {
        }
    }

    public interface RenderProcessGoneListener extends IRenderProcessGoneListenersdk112 {
    }

    public interface RenderProcessGoneListenerWrapper extends IRenderProcessGoneListenerWrappersdk112 {
    }

    public static class ResourceEventListener extends IResourceEventListenersdk113 {
        public ResourceEventListener() {
        }
    }

    public interface ResourceLoadListener extends IWebViewExtensionsdk113.IResourceLoadListenerSdk113 {
    }

    public interface TTAdblockEventListener extends IWebViewExtensionsdk113.ITTAdblockEventListenerSdk113 {
    }

    public interface TTSafeBrowsingListener extends IWebViewExtensionsdk113.ITTSafeBrowsingListenerSdk113 {
        public static final String SAFEBROWSING_DONT_PROCEED = "safebrowsing_dont_proceed";
        public static final String SAFEBROWSING_FEEDBACK = "safebrowsing_feedback";
        public static final String SAFEBROWSING_NOT_SHOW_INTERSTITIAL = "safebrowsing_not_show_interstitial";
        public static final String SAFEBROWSING_OPEN_HELP_CENTER = "safebrowsing_open_help_center";
        public static final String SAFEBROWSING_PROCEED = "safebrowsing_proceed";
        public static final String SAFEBROWSING_SHOW = "safebrowsing_show";
        public static final String SAFEBROWSING_SHOW_FORBID = "safebrowsing_show_forbid";
        public static final String SAFEBROWSING_SHOW_MORE_SECTION = "safebrowsing_show_more_section";
        public static final String SAFEBROWSING_USER_GOBACK = "safebrowsing_user_goback";
    }

    public interface TTUserResponseListener {
        public static final int CANCEL_NOT_NOW = 2;
        public static final int CONFIRM_YES = 1;
        public static final int DENY_NEVER = 0;

        void onSaveLoginPassword(ValueCallback<Integer> r100);
    }

    void addResourceEventListener(ResourceEventListener r100);

    void displaySafeBrowsingWarningAgain();

    void removeResourceEventListener(ResourceEventListener r100);

    void setMemoryEventListener(MemoryEventListener r100);

    void setPerformanceTimingListener(PerformanceTimingListener r100);

    void setPlatformViewLayersScrollListener(PlatformViewLayersScrollListener r100);

    void setPredictorEventListener(PredictorEventListener r100);

    void setRenderProcessGoneListener(RenderProcessGoneListener r100);

    void setResourceLoadListener(ResourceLoadListener r100);

    void setTTAdblockEventListener(TTAdblockEventListener r100);

    void setTTSafeBrowsingListener(TTSafeBrowsingListener r100);

    void setTTUserResponseListener(TTUserResponseListener r100);
}
