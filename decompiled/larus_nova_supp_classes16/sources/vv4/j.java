package vv4;

import android.content.Context;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.jsbridge.BridgeWebViewV2;
import com.bytedance.ee.larkwebview.base.LarkWebView;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class j implements k {
    public final WebView a;
    public final at5.a b;

    @Override // vv4.k
    public void addWebChromeClientDelegate(WebChromeClient r1) {
    }

    @Override // vv4.k
    public void addWebChromeClientDelegate(WebChromeClient r1, int r2) {
    }

    @Override // vv4.k
    public void addWebViewClientDelegate(WebViewClient r1) {
    }

    @Override // vv4.k
    public void addWebViewClientDelegate(WebViewClient r1, int r2) {
    }

    @Override // vv4.k
    public final /* synthetic */ void c(k.a r1) {
    }

    @Override // vv4.k
    public tb5.n getBridge() {
        return null;
    }

    @Override // vv4.k
    public /* synthetic */ String getWebViewId() {
        return "";
    }

    @Override // vv4.k
    public /* synthetic */ void n(k.b r1) {
    }

    @Override // vv4.k
    public final /* synthetic */ void o(WebPluginHost r1) {
    }

    @Override // vv4.k
    public /* synthetic */ void removeJSONParamInterceptor() {
    }

    @Override // vv4.k
    public void removeWebChromeClientDelegate(WebChromeClient r1) {
    }

    @Override // vv4.k
    public void removeWebViewClientDelegate(WebViewClient r1) {
    }

    @Override // vv4.k
    public final /* synthetic */ void w(k.a r1) {
    }

    @Override // vv4.k, com.bytedance.ee.bear.document.z4
    public Context getContext() {
        return this.a.getContext().getApplicationContext();
    }

    @Override // vv4.k
    public final WebView getWebView() {
        return this.a;
    }

    @Override // vv4.k
    public final void addOnTouchListener(View.OnTouchListener r4) {
        Object r0 = this.a;
        if ((r0 instanceof BridgeWebViewV2) == false) goto L10;
        BridgeWebViewV2 r1 = (BridgeWebViewV2) r0;
        if (r4 == null) goto L9;
        com.bytedance.ee.larkwebview.util.b r2 = ((LarkWebView) r1).n;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "listener");
        if (((ArrayList) r2.a).contains(r4) == true) goto L12;
        ((ArrayList) r2.a).add(r4);
        return;
    L12:
        return;
    L9:
        r1.getClass();
        return;
    L10:
        tt5.a.e("SimpleWebV2", "addOnTouchListener", new IllegalStateException("addOnTouchListener NOT on BridgeWebView"), false);
    }

    @Override // vv4.k
    public final void execJS(String r2) {
        a(r2, null, null);
    }

    @Override // vv4.k
    public final void loadUrl(String r2) {
        this.a.loadUrl(r2);
    }

    @Override // vv4.k
    public final void removeOnTouchListener(View.OnTouchListener r4) {
        Object r0 = this.a;
        if ((r0 instanceof BridgeWebViewV2) == false) goto L8;
        BridgeWebViewV2 r1 = (BridgeWebViewV2) r0;
        if (r4 == null) goto L7;
        com.bytedance.ee.larkwebview.util.b r2 = ((LarkWebView) r1).n;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "listener");
        ((ArrayList) r2.a).remove(r4);
        return;
    L7:
        r1.getClass();
        return;
    L8:
        tt5.a.e("SimpleWebV2", "removeOnTouchListener", new IllegalStateException("removeOnTouchListener NOT on BridgeWebView"), false);
    }

    @Override // vv4.k
    public void unbindJSHandler(String r2) {
        this.b.d(r2);
    }

    public j(WebView r1, at5.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // vv4.k
    public final void B(String r3, tb5.o r4) {
        at5.a r0 = this.b;
        boolean r1 = BridgeWebViewV2.E;
        r0.c(r3, new tb5.j(r4));
    }

    @Override // vv4.k
    public void h(String r3, tb5.i r4) {
        at5.a r0 = this.b;
        boolean r1 = BridgeWebViewV2.E;
        r0.c(r3, new tb5.k(r4));
    }

    @Override // vv4.k
    public final void i(String r1, tb5.g r2) {
        iu5.d.a("SimpleWebV2", new RuntimeException("please use jsHandler"));
    }

    @Override // vv4.k
    public final void j(String r2, JSONObject r3) {
        a(r2, r3, null);
    }

    @Override // vv4.k
    public void u(String r3, NonProguard r4) {
        this.b.a(r3, r4, null);
    }

    @Override // vv4.k
    public void a(String r2, JSONObject r3, ValueCallback<String> r4) {
        this.b.a(r2, r3, r4);
    }

    @Override // vv4.k
    public void k(String r3, NonProguard r4, ValueCallback<String> r5) {
        WebView r0 = this.a;
        if (ap5.a.b(r0) == true) goto L7;
        r0.evaluateJavascript(swb.k.a(r3, r4), r5);
        return;
    }

    @Override // vv4.k
    public void l(String r3, org.json.JSONObject r4, ValueCallback<String> r5) {
        WebView r0 = this.a;
        if (ap5.a.b(r0) == true) goto L7;
        r0.evaluateJavascript(swb.k.a(r3, r4), r5);
        return;
    }
}
