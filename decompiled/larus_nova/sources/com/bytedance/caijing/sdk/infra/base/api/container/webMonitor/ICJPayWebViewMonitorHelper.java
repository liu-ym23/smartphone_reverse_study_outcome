package com.bytedance.caijing.sdk.infra.base.api.container.webMonitor;

import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.bytedance.map.api.monitor.MapMonitorConst;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J&\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J5\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0002\u0010\u0011J&\u0010\u0012\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\u001a\u0010\u0015\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0012\u0010\u0018\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\u0019\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u000fH&J\u001c\u0010\u001b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u000fH&J\u001c\u0010\u001c\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u000fH&J!\u0010\u001d\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\rH&¢\u0006\u0002\u0010\u001fJ\u0012\u0010 \u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006!"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/container/webMonitor/ICJPayWebViewMonitorHelper;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", MapMonitorConst.EVENT_DESTROY, "", "webView", "Landroid/webkit/WebView;", "goBack", "handleRequestError", "request", "Landroid/webkit/WebResourceRequest;", "error", "Landroid/webkit/WebResourceError;", "errorCode", "", "description", "", "failingUrl", "(Landroid/webkit/WebView;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "handleRequestHttpError", "errorResponse", "Landroid/webkit/WebResourceResponse;", "handleViewCreate", "isMonitor", "", "onAttachedToWindow", "onLoadUrl", "url", "onPageFinished", "onPageStarted", "onProgressChanged", "newProgress", "(Landroid/webkit/WebView;Ljava/lang/Integer;)V", "reload", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJPayWebViewMonitorHelper extends ICJService {
    void destroy(WebView r100);

    void goBack(WebView r100);

    void handleRequestError(WebView r100, WebResourceRequest r101, WebResourceError r102);

    void handleRequestError(WebView r100, Integer r101, String r102, String r103);

    void handleRequestHttpError(WebView r100, WebResourceRequest r101, WebResourceResponse r102);

    void handleViewCreate(WebView r100, boolean r101);

    void onAttachedToWindow(WebView r100);

    void onLoadUrl(WebView r100, String r101);

    void onPageFinished(WebView r100, String r101);

    void onPageStarted(WebView r100, String r101);

    void onProgressChanged(WebView r100, Integer r101);

    void reload(WebView r100);
}
