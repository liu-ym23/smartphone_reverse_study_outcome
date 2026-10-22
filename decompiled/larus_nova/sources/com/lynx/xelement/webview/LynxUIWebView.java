package com.lynx.xelement.webview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.LynxBehavior;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxGeneratorName;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import java.util.HashMap;
import t8a.b;

/* JADX INFO: loaded from: classes32.dex */
@LynxBehavior(isCreateAsync = false, tagName = {"webview"})
@LynxGeneratorName(packageName = "com.lynx.xelement.webview")
public class LynxUIWebView<T extends t8a.b> extends UISimpleView<T> {
    public static final String DEFAULT = "default";
    private String html;
    private boolean htmlChanged;
    private u8a.c provider;
    private String type;
    private String url;
    private boolean urlChanged;
    private WebView webView;
    private HashMap<String, Object> webViewParams;
    private u8a.b webViewService;

    public class a implements u8a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxUIWebView f384354a;

        public a(LynxUIWebView r100) {
            this.f384354a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxUIWebView f384355a;

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (LynxUIWebView.access$000(this.f384355a) == null) goto L9;
            LynxUIWebView.access$000(this.f384355a).loadUrl(LynxUIWebView.access$100(this.f384355a));     // Catch: Throwable -> L6
            return;
        }

        public b(LynxUIWebView r100) {
            this.f384355a = r100;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxUIWebView f384356a;

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (LynxUIWebView.access$000(this.f384356a) == null) goto L9;
            LynxUIWebView.access$000(this.f384356a).e(LynxUIWebView.access$200(this.f384356a));     // Catch: Throwable -> L6
            return;
        }

        public c(LynxUIWebView r100) {
            this.f384356a = r100;
        }
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void destroy() {
        super.destroy();
        u8a.b r100 = this.webViewService;
        if (r100 == null) goto L6;
        r100.destroy();
        this.webViewService = null;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onNodeReady() {
        super.onNodeReady();
        if (this.webViewService != null) goto L13;
        if (this.provider != null) goto L7;
        this.provider = new t8a.c();
    L7:
        u8a.b r100 = this.provider.a(this.type, this.mContext);
        this.webViewService = r100;
        if (r100 == null) goto L13;
        r100.a();
        this.webViewService.b();
        this.webViewService.d(new a(this));
        WebView r101 = this.webViewService.getWebView();
        this.webView = r101;
        if (r101 == null) goto L13;
        r101.setBackgroundColor(0);
        ((t8a.b) this.mView).addView(this.webView, new ViewGroup.LayoutParams(-1, -1));
    L13:
        if (this.urlChanged == false) goto L15;
    L16:
        String r102 = this.url;
        boolean r103 = true;
        if (r102 != null) goto L19;
    L21:
        boolean r104 = false;
    L22:
        String r105 = this.html;
        if (r105 != null) goto L25;
    L27:
        r103 = false;
    L28:
        if (r104 == true) goto L30;
    L32:
        if (r103 == false) goto L35;
        if (r104 == true) goto L35;
        ((t8a.b) this.mView).post(new c(this));
    L35:
        if (r104 == true) goto L38;
        if (r103 == true) goto L38;
        m7a.a r106 = new m7a.a(getSign(), "error");
        r106.a("errorCode", -1);
        r106.a("errorMsg", "invalid input: src and html are empty");
        getLynxContext().getEventEmitter().sendCustomEvent(r106);
    L38:
        this.urlChanged = false;
        this.htmlChanged = false;
        return;
    L30:
        if (this.urlChanged == false) goto L32;
        ((t8a.b) this.mView).post(new b(this));
        goto L35
    L25:
        if (r105.isEmpty() == true) goto L27;
    L19:
        if (r102.isEmpty() == true) goto L21;
        r104 = true;
        goto L22
    L15:
        if (this.htmlChanged == true) goto L16;
    }

    public String getHtml() {
        return this.html;
    }

    public u8a.c getProvider() {
        return this.provider;
    }

    public String getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public LynxUIWebView(LynxContext r100) {
        this(r100, null);
    }

    public static /* synthetic */ u8a.b access$000(LynxUIWebView r100) {
        return r100.webViewService;
    }

    public static /* synthetic */ String access$100(LynxUIWebView r100) {
        return r100.url;
    }

    public static /* synthetic */ String access$200(LynxUIWebView r100) {
        return r100.html;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public T createView(Context r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return (T) createWebViewContainer(r100);
    }

    public T createWebViewContainer(Context r100) {
        return (T) new t8a.b(r100);
    }

    @LynxProp(name = "enable-debug")
    public void setDebug(boolean r100) {
        if (LynxEnv.inst().isDevtoolEnabled() == true) goto L8;
        LynxContext r101 = this.mContext;
        if (r101 == null) goto L10;
        r101.handleLynxError(new LynxError(229800, "Not allow to set enable-debug if devtool is not enabled, please enable Lynx Devtool.", "", "warn"));
        return;
    L10:
        return;
    L8:
        WebView.setWebContentsDebuggingEnabled(r100);
    }

    public void setHtml(String r100) {
        this.html = r100;
    }

    @LynxProp(name = "html")
    public void setHtmlString(String r100) {
        this.html = r100;
        this.htmlChanged = true;
    }

    @LynxProp(name = "params")
    public void setParams(ReadableMap r100) {
        if (r100 != null) goto L4;
        HashMap<String, Object> r101 = null;
    L5:
        this.webViewParams = r101;
        return;
    L4:
        r101 = r100.asHashMap();
        goto L5
    }

    public void setProvider(u8a.c r100) {
        this.provider = r100;
    }

    @LynxProp(name = "src")
    public void setSrc(String r100) {
        this.url = r100;
        this.urlChanged = true;
    }

    public void setType(String r100) {
        this.type = r100;
    }

    public void setUrl(String r100) {
        this.url = r100;
    }

    @LynxProp(name = "webview-type")
    public void setWebViewType(String r100) {
        this.type = r100;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public /* bridge */ /* synthetic */ View createView(Context r100) {
        return createView(r100);
    }

    public LynxUIWebView(LynxContext r100, Object r101) {
        super(r100, r101);
        this.type = "default";
    }

    @LynxUIMethod
    public void eval(ReadableMap r100, Callback r101) {
        if (r100 != null) goto L4;
        String r102 = null;
    L6:
        if (r102 == null) goto L12;
        u8a.b r103 = this.webViewService;
        if (r103 == null) goto L10;
        r103.c(r102);
    L10:
        if (r101 == null) goto L15;
        r101.invoke(new Object[]{0});
        return;
    L15:
        return;
    L12:
        if (r101 == null) goto L17;
        r101.invoke(new Object[]{4, "params error"});
        return;
    L17:
        return;
    L4:
        r102 = r100.getString("func");
        goto L6
    }

    @LynxUIMethod
    public void reload(ReadableMap r100, Callback r101) {
        u8a.b r102 = this.webViewService;
        if (r102 == null) goto L5;
        r102.reload();
    L5:
        if (r101 == null) goto L8;
        r101.invoke(new Object[]{0});
        return;
    }
}
