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
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public class j implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebView f557392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final at5.a f557393b;

    @Override // vv4.k
    public void addWebChromeClientDelegate(WebChromeClient r100) {
    }

    @Override // vv4.k
    public void addWebChromeClientDelegate(WebChromeClient r100, int r101) {
    }

    @Override // vv4.k
    public void addWebViewClientDelegate(WebViewClient r100) {
    }

    @Override // vv4.k
    public void addWebViewClientDelegate(WebViewClient r100, int r101) {
    }

    @Override // vv4.k
    public final /* synthetic */ void c(k.a r100) {
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
    public /* synthetic */ void n(k.b r100) {
    }

    @Override // vv4.k
    public final /* synthetic */ void o(WebPluginHost r100) {
    }

    @Override // vv4.k
    public /* synthetic */ void removeJSONParamInterceptor() {
    }

    @Override // vv4.k
    public void removeWebChromeClientDelegate(WebChromeClient r100) {
    }

    @Override // vv4.k
    public void removeWebViewClientDelegate(WebViewClient r100) {
    }

    @Override // vv4.k
    public final /* synthetic */ void w(k.a r100) {
    }

    @Override // vv4.k, com.bytedance.ee.bear.document.z4
    public Context getContext() {
        return this.f557392a.getContext().getApplicationContext();
    }

    @Override // vv4.k
    public final WebView getWebView() {
        return this.f557392a;
    }

    @Override // vv4.k
    public final void addOnTouchListener(View.OnTouchListener r100) {
        WebView r101 = this.f557392a;
        if ((r101 instanceof BridgeWebViewV2) == false) goto L10;
        BridgeWebViewV2 r102 = (BridgeWebViewV2) r101;
        if (r100 == null) goto L9;
        com.bytedance.ee.larkwebview.util.b r103 = r102.f242849n;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (((ArrayList) r103.f242966a).contains(r100) == true) goto L12;
        ((ArrayList) r103.f242966a).add(r100);
        return;
    L12:
        return;
    L9:
        r102.getClass();
        return;
    L10:
        tt5.a.e("SimpleWebV2", "addOnTouchListener", new IllegalStateException("addOnTouchListener NOT on BridgeWebView"), false);
    }

    @Override // vv4.k
    public final void execJS(String r100) {
        a(r100, null, null);
    }

    @Override // vv4.k
    public final void loadUrl(String r100) {
        this.f557392a.loadUrl(r100);
    }

    @Override // vv4.k
    public final void removeOnTouchListener(View.OnTouchListener r100) {
        WebView r101 = this.f557392a;
        if ((r101 instanceof BridgeWebViewV2) == false) goto L8;
        BridgeWebViewV2 r102 = (BridgeWebViewV2) r101;
        if (r100 == null) goto L7;
        com.bytedance.ee.larkwebview.util.b r103 = r102.f242849n;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((ArrayList) r103.f242966a).remove(r100);
        return;
    L7:
        r102.getClass();
        return;
    L8:
        tt5.a.e("SimpleWebV2", "removeOnTouchListener", new IllegalStateException("removeOnTouchListener NOT on BridgeWebView"), false);
    }

    @Override // vv4.k
    public void unbindJSHandler(String r100) {
        this.f557393b.d(r100);
    }

    public j(WebView r100, at5.a r101) {
        this.f557392a = r100;
        this.f557393b = r101;
    }

    @Override // vv4.k
    public final void B(String r100, tb5.o r101) {
        at5.a r102 = this.f557393b;
        boolean r103 = BridgeWebViewV2.E;
        r102.c(r100, new tb5.j(r101));
    }

    @Override // vv4.k
    public void h(String r100, tb5.i r101) {
        at5.a r102 = this.f557393b;
        boolean r103 = BridgeWebViewV2.E;
        r102.c(r100, new tb5.k(r101));
    }

    @Override // vv4.k
    public final void i(String r100, tb5.g r101) {
        iu5.d.a("SimpleWebV2", new RuntimeException("please use jsHandler"));
    }

    @Override // vv4.k
    public final void j(String r100, JSONObject r101) {
        a(r100, r101, null);
    }

    @Override // vv4.k
    public void u(String r100, NonProguard r101) {
        this.f557393b.a(r100, r101, null);
    }

    @Override // vv4.k
    public void a(String r100, JSONObject r101, ValueCallback<String> r102) {
        this.f557393b.a(r100, r101, r102);
    }

    @Override // vv4.k
    public void k(String r100, NonProguard r101, ValueCallback<String> r102) {
        WebView r103 = this.f557392a;
        if (ap5.a.b(r103) == true) goto L7;
        r103.evaluateJavascript(swb.k.a(r100, r101), r102);
        return;
    }

    @Override // vv4.k
    public void l(String r100, org.json.JSONObject r101, ValueCallback<String> r102) {
        WebView r103 = this.f557392a;
        if (ap5.a.b(r103) == true) goto L7;
        r103.evaluateJavascript(swb.k.a(r100, r101), r102);
        return;
    }
}
