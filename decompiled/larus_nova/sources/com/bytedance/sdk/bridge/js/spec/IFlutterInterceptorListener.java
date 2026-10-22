package com.bytedance.sdk.bridge.js.spec;

import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.bridge.model.BridgeResult;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\rH&¨\u0006\u0011"}, d2 = {"Lcom/bytedance/sdk/bridge/js/spec/IFlutterInterceptorListener;", "", NotificationCompat.CATEGORY_CALL, "", "bridgeMethod", "", "params", "Lorg/json/JSONObject;", "jsBridgeContext", "Lcom/bytedance/sdk/bridge/js/spec/JsBridgeContext;", "callSync", "Lcom/bytedance/sdk/bridge/model/BridgeResult;", "isFlutterWebView", "", "webView", "Landroid/webkit/WebView;", "isInterceptor", "js-bridge_release"}, k = 1, mv = {1, 1, 15})
public interface IFlutterInterceptorListener {
    void call(String r100, JSONObject r101, JsBridgeContext r102);

    @Deprecated(message = "temp method")
    BridgeResult callSync(String r100, JSONObject r101, JsBridgeContext r102);

    boolean isFlutterWebView(WebView r100);

    boolean isInterceptor();
}
