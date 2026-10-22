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

/* JADX INFO: loaded from: classes16.dex */
public interface k {

    public interface a {
        void a(boolean r100, int r101);
    }

    public interface b {
        boolean enableAddJsonExtraParam();

        String getInterceptFuncName();

        JSONObject getInterceptJSONObject();
    }

    void B(String r100, tb5.o r101);

    void a(String r100, JSONObject r101, ValueCallback<String> r102);

    void addOnTouchListener(View.OnTouchListener r100);

    void addWebChromeClientDelegate(WebChromeClient r100);

    void addWebChromeClientDelegate(WebChromeClient r100, int r101);

    void addWebViewClientDelegate(WebViewClient r100);

    void addWebViewClientDelegate(WebViewClient r100, int r101);

    void c(a r100);

    void execJS(String r100);

    tb5.n getBridge();

    Context getContext();

    WebView getWebView();

    String getWebViewId();

    void h(String r100, tb5.i r101);

    void i(String r100, tb5.g r101);

    void j(String r100, JSONObject r101);

    void k(String r100, NonProguard r101, ValueCallback<String> r102);

    void l(String r100, org.json.JSONObject r101, ValueCallback<String> r102);

    void loadUrl(String r100);

    void n(b r100);

    void o(WebPluginHost r100);

    void removeJSONParamInterceptor();

    void removeOnTouchListener(View.OnTouchListener r100);

    void removeWebChromeClientDelegate(WebChromeClient r100);

    void removeWebViewClientDelegate(WebViewClient r100);

    void u(String r100, NonProguard r101);

    void unbindJSHandler(String r100);

    void w(a r100);
}
