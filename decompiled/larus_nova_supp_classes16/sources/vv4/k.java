package vv4;

import android.content.Context;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface k {

    public interface a {
        void a(boolean r1, int r2);
    }

    public interface b {
        boolean enableAddJsonExtraParam();

        String getInterceptFuncName();

        JSONObject getInterceptJSONObject();
    }

    void B(String r1, tb5.o r2);

    void a(String r1, JSONObject r2, ValueCallback<String> r3);

    void addOnTouchListener(View.OnTouchListener r1);

    void addWebChromeClientDelegate(WebChromeClient r1);

    void addWebChromeClientDelegate(WebChromeClient r1, int r2);

    void addWebViewClientDelegate(WebViewClient r1);

    void addWebViewClientDelegate(WebViewClient r1, int r2);

    void c(a r1);

    void execJS(String r1);

    tb5.n getBridge();

    Context getContext();

    WebView getWebView();

    String getWebViewId();

    void h(String r1, tb5.i r2);

    void i(String r1, tb5.g r2);

    void j(String r1, JSONObject r2);

    void k(String r1, NonProguard r2, ValueCallback<String> r3);

    void l(String r1, org.json.JSONObject r2, ValueCallback<String> r3);

    void loadUrl(String r1);

    void n(b r1);

    void o(WebPluginHost r1);

    void removeJSONParamInterceptor();

    void removeOnTouchListener(View.OnTouchListener r1);

    void removeWebChromeClientDelegate(WebChromeClient r1);

    void removeWebViewClientDelegate(WebViewClient r1);

    void u(String r1, NonProguard r2);

    void unbindJSHandler(String r1);

    void w(a r1);
}
