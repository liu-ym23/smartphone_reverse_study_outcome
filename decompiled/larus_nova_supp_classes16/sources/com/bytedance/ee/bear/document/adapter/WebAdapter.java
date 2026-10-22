package com.bytedance.ee.bear.document.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.m0;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.fail.DocException;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.bear.document.offline.sync.opendoc.FetchClientVarExecutor;
import com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3;
import com.bytedance.ee.bear.document.statistics.SendEventData;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.document.v2;
import com.bytedance.ee.bear.document.z4;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.Gson;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleonv2.container.webcontainer.ChameleonSafeReuseWeb;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.officewebview.bridge.Message;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import k25.e0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import tb5.i;
import tb5.m;
import tb5.n;
import tb5.o;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class WebAdapter implements k, z4 {
    public final ChameleonPluginHost a;
    public final ChameleonWebView b;
    public final k c;
    public final com.bytedance.ee.bear.document.ssrrender.a d;
    public ConcurrentHashMap<String, String> e;
    public final com.bytedance.ee.bear.contract.d f;
    public boolean g;
    public boolean h;
    public h i;
    public final d j;
    public final Lazy k;

    public static final class a implements m0 {
        public final /* synthetic */ WebAdapter a;

        @Override // com.bytedance.ee.bear.contract.m0
        public final void a() {
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void b() {
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void c() {
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void e() {
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void f() {
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void g() {
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void h() {
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void i(DocException r1, Map r2) {
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void m(Map<String, String> r1) {
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void d() {
            this.a.h = true;
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void j() {
            this.a.g = true;
        }

        public a(WebAdapter r1) {
            this.a = r1;
        }
    }

    public static final class b extends WebChromeClient {
        public final /* synthetic */ WebAdapter a;

        public b(WebAdapter r1) {
            this.a = r1;
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onJsPrompt(WebView r10, String r11, String r12, String r13, JsPromptResult r14) {
            Intrinsics.checkNotNullParameter(r10, "view");
            Intrinsics.checkNotNullParameter(r11, "url");
            Intrinsics.checkNotNullParameter(r12, "message");
            Intrinsics.checkNotNullParameter(r13, "defaultValue");
            Intrinsics.checkNotNullParameter(r14, TipCallBackData.RESULT);
            if (TextUtils.equals("__featureGatingValue__", r12) == true) goto L5;
        L12:
            boolean r1 = false;
            if (TextUtils.equals("__getPendingSSR__", r12) == false) goto L41;
            WebAdapter r16 = this.a;
            r16.getClass();
            Intrinsics.checkNotNullParameter(r14, TipCallBackData.RESULT);
            DocViewModel r17 = (DocViewModel) r16.a.getHostAbilityOrNull(DocViewModel.class);
            if (r17 == null) goto L17;
            BearUrl r18 = r17.getBearUrl();
        L18:
            JSONObject r3 = new JSONObject();
            String r4 = r16.f.e("render_cache", "value_render_cache_prompt_count");
        L23:
            th = move-exception;
            tt5.a.f("WebAdapter", th, false);
        L25:
            String r5 = DiagramData$RESULT.SUCCESS;
        L26:
            r16.f.j("render_cache", "value_render_cache_prompt_count", r5);
            AccountService$Account r2 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
            String r6 = "{}";
            if (r18 == null) goto L43;
            String r7 = r18.a;
            Map<String, String> r8 = r18.d;
            FetchClientVarExecutor r9 = com.bytedance.ee.bear.document.offline.sync.opendoc.k.a;
            String r19 = e0.m().n(n35.a.b(r2, r7, r8), r18.b).c;
            if (TextUtils.isEmpty(r19) == true) goto L43;
            int r20 = r19.length();
            DocOpenConfig.a();
            if (r20 <= DocOpenConfig.g.get_pending_ssr_max_length) goto L33;
            r16.f.j("render_cache", "render_cache_over_limit", DiagramData$RESULT.SUCCESS);
            tt5.a.h("WebAdapter_getPendingSSR", "ssr is over limit");
        L34:
            r1 = true;
            goto L43
        L33:
            Intrinsics.checkNotNull(r19);
            r16.h = false;
            tt5.a.h("WebAdapter_getPendingSSR", "success... html cache is " + r19.length());
            r16.f.j("render_cache", "render_cache_from", "prompt");
            r6 = r19;
        L43:
            r3.put("ssrContent", r6);     // Catch: Throwable -> L37
            r3.put("disable_next_time", r1);     // Catch: Throwable -> L37
        L39:
            tt5.a.b("WebAdapter", "ssrContent length is " + r6.length() + " disableNextTime is " + r1);
            r14.confirm(r3.toString());
            return true;
        L37:
            th = move-exception;
            tt5.a.j("WebAdapter", th);
            goto L39
        L20:
            if (TextUtils.isEmpty(r4) == true) goto L25;
            Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L23
            r5 = String.valueOf(CastIntegerProtector.parseInt(r4) + 1);     // Catch: Throwable -> L23
            goto L26
        L17:
            r18 = null;
            goto L18
        L41:
            tt5.a.h("WebAdapter_onJsPrompt", r12 + ',' + r13);
            return false;
        L5:
            if (TextUtils.isEmpty(r13) == true) goto L12;
            boolean r110 = com.bytedance.ee.bear.appsetting.c.a.a.g(r13);
            if (r110 == false) goto L9;
            String r111 = "true";
        L10:
            r14.confirm(r111);
            tt5.a.h("WebAdapter_onJsPromptFg", "key:" + r13 + ", value:" + r110);
            return true;
        L9:
            r111 = "false";
            goto L10
        }
    }

    public static final class c {
    }

    public static final class d implements xwb.k {
        public final /* synthetic */ WebAdapter a;

        public d(WebAdapter r1) {
            this.a = r1;
        }

        public final boolean p(Message r3, xwb.d r4) {
            String r5 = r3.getApiName();
            if (r5 == null) goto L11;
            h r0 = this.a.i;
            if (r0 == null) goto L10;
            r0.a(r5, r3.getData(), r3.getCallbackID());
            return false;
        L10:
            return false;
        L11:
            return false;
        }
    }

    public static final class e<T> implements ValueCallback {
        public final /* synthetic */ h a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;
        public final /* synthetic */ ValueCallback<String> d;

        public e(h r1, String r2, long r3, ValueCallback<String> r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(Object r7) {
            String r8 = (String) r7;
            this.a.b(this.b, System.currentTimeMillis() - this.c, r8);
            ValueCallback<String> r0 = this.d;
            if (r0 == null) goto L6;
            r0.onReceiveValue(r8);
            return;
        }
    }

    public static final class f implements m {
        public f() {
        }

        @Override // tb5.m
        public final void a(NonProguard r1) {
        }

        @Override // tb5.m
        public final void b(com.alibaba.fastjson.JSONObject r1) {
        }

        @Override // tb5.m
        public final void onCallBack(String r1) {
        }
    }

    static {
    }

    @Override // vv4.k
    public final void B(String r2, o r3) {
        this.c.B(r2, r3);
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void C(v2 r1) {
    }

    @Override // vv4.k
    public final void addOnTouchListener(View.OnTouchListener r2) {
        this.c.addOnTouchListener(r2);
    }

    @Override // vv4.k
    public final void addWebChromeClientDelegate(WebChromeClient r2) {
        this.c.addWebChromeClientDelegate(r2);
    }

    @Override // vv4.k
    public final void addWebChromeClientDelegate(WebChromeClient r2, int r3) {
        this.c.addWebChromeClientDelegate(r2, -1073741824);
    }

    @Override // vv4.k
    public final void addWebViewClientDelegate(WebViewClient r2) {
        this.c.addWebViewClientDelegate(r2);
    }

    @Override // vv4.k
    public final void addWebViewClientDelegate(WebViewClient r2, int r3) {
        this.c.addWebViewClientDelegate(r2, r3);
    }

    @Override // vv4.k
    public final /* synthetic */ void c(k.a r1) {
    }

    @Override // vv4.k
    public final n getBridge() {
        return this.c.getBridge();
    }

    @Override // vv4.k, com.bytedance.ee.bear.document.z4
    public Context getContext() {
        return this.c.getContext();
    }

    @Override // vv4.k
    public final WebView getWebView() {
        return this.c.getWebView();
    }

    @Override // vv4.k
    public final /* synthetic */ String getWebViewId() {
        return "";
    }

    @Override // vv4.k
    public final void h(String r2, i r3) {
        this.c.h(r2, r3);
    }

    @Override // vv4.k
    public final void i(String r2, tb5.g r3) {
        this.c.i(r2, r3);
    }

    @Override // vv4.k
    public final void loadUrl(String r2) {
        this.c.loadUrl(r2);
    }

    @Override // vv4.k
    public final /* synthetic */ void n(k.b r1) {
    }

    @Override // vv4.k
    public final /* synthetic */ void o(WebPluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void onDestroy() {
        this.i = null;
        xwb.a r0 = this.b.getBridge();
        d r1 = this.j;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "interceptor");
        r0.d.remove(r1);
    }

    @Override // vv4.k
    public final /* synthetic */ void removeJSONParamInterceptor() {
    }

    @Override // vv4.k
    public final void removeOnTouchListener(View.OnTouchListener r2) {
        this.c.removeOnTouchListener(r2);
    }

    @Override // vv4.k
    public final void removeWebChromeClientDelegate(WebChromeClient r2) {
        this.c.removeWebChromeClientDelegate(r2);
    }

    @Override // vv4.k
    public final void removeWebViewClientDelegate(WebViewClient r2) {
        this.c.removeWebViewClientDelegate(r2);
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void s(boolean r1, Integer r2) {
    }

    @Override // vv4.k
    public final void unbindJSHandler(String r2) {
        this.c.unbindJSHandler(r2);
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void v() {
    }

    @Override // vv4.k
    public final /* synthetic */ void w(k.a r1) {
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final int computeVerticalScrollRange() {
        return this.b.computeVerticalScrollRange();
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final ConcurrentHashMap<String, String> e() {
        int r1 = 0;
        VFSPath r0 = this.b.y(false).a;
        if (r0 == null) goto L5;
        VFSFile r2 = ay4.d.a().F(r0);
        this.e = new ConcurrentHashMap();
        if (r2 != null) goto L9;
    L21:
        ConcurrentHashMap<String, String> r3 = this.e;
        if (r3 == null) goto L24;
        String r4 = r3.get("mobile_index.html");
    L25:
        TextUtils.isEmpty(r4);
        ConcurrentHashMap<String, String> r5 = this.e;
        if (r5 == null) goto L28;
        return r5;
    L28:
        return new ConcurrentHashMap();
    L24:
        r4 = null;
        goto L25
    L9:
        if (r2.exists() == false) goto L21;
        HashMap r6 = new HashMap();
        File r7 = r2.getParentFile();
        if (r7 == null) goto L15;
        String r8 = r7.getAbsolutePath();
        if (r8 == null) goto L15;
        r1 = r8.length();
    L15:
        p(r2, r6, r1);
        ConcurrentHashMap<String, String> r9 = this.e;
        if (r9 == null) goto L18;
        r9.putAll(r6);
    L18:
        ConcurrentHashMap<String, String> r10 = this.e;
        if (r10 == null) goto L21;
        String r11 = r10.put("resource_root_path", r2.getVfsPath().getAbsolutePath());
        goto L21
    L5:
        return new ConcurrentHashMap();
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final WebViewClient getWebViewClient() {
        return this.b.getWebViewClient();
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final int r() {
        return this.b.getLastVerticalScrollRange();
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final boolean G() {
        return this.g;
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final boolean f() {
        return this.h;
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void D(com.bytedance.ee.bear.document.ssrrender.a.b r2) {
        this.d.a = null;
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void F(zv4.f r2) {
        this.b.B(r2);
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void d(zv4.f r2) {
        this.b.x(r2);
    }

    @Override // vv4.k
    public final void execJS(String r2) {
        a(r2, null, null);
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void m(m0 r2) {
        Intrinsics.checkNotNullParameter(r2, "renderCallback");
        ((DocumentLoaderV3) this.k.getValue()).n(r2);
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void q(com.bytedance.ee.bear.document.ssrrender.a.b r2) {
        this.d.a = r2;
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void x(m0 r2) {
        Intrinsics.checkNotNullParameter(r2, "renderCallback");
        ((DocumentLoaderV3) this.k.getValue()).m(r2);
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void y(SendEventData r3) {
        com.bytedance.ee.bear.jsbridge.Message r0 = new com.bytedance.ee.bear.jsbridge.Message();
        r0.e = "biz.statistics.sendEvent";
        String r4 = GsonProtectorUtils.toJson(new Gson(), r3);
        if (r4 != null) goto L5;
        r4 = "{}";
    L5:
        r0.d = r4;
        E(r0, new f());
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void z(boolean r2) {
        this.b.setEnableOverScrollBy(r2);
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final boolean E(com.bytedance.ee.bear.jsbridge.Message r4, m r5) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        Intrinsics.checkNotNullParameter(r5, "callback");
        tt5.a.h("WebAdapter", "onIntercept msg:" + r4.e);
        ChameleonSafeReuseWeb r0 = this.c;
        if ((r0 instanceof ChameleonSafeReuseWeb) == false) goto L6;
        Message r1 = new Message();
        r1.setApiName(r4.e);
        r1.setData(r4.d);
        r1.setCallbackID(r4.a);
        return r0.J(r1, r5);
    L6:
        return false;
    }

    public final ValueCallback<String> I(String r8, ValueCallback<String> r9) {
        h r1 = this.i;
        if (r1 != null) goto L5;
        return r9;
    L5:
        if (r8 != null) goto L8;
        return r9;
    L8:
        return new e(r1, r8, System.currentTimeMillis(), r9);
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void b(String r2, Serializable r3) {
        Intrinsics.checkNotNullParameter("renderSSRWebviewType", "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        ((DocumentLoaderV3) this.k.getValue()).h.a("renderSSRWebviewType", r3);
    }

    @Override // vv4.k
    public final void j(String r2, com.alibaba.fastjson.JSONObject r3) {
        a(r2, r3, null);
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void t(BearUrl r2, String r3) {
        o45.a r4 = (o45.a) this.a.getWebService(o45.a.class);
        if (r4 == null) goto L6;
        r4.a = r2;
        return;
    }

    @Override // vv4.k
    public final void u(String r2, NonProguard r3) {
        k(r2, r3, null);
    }

    public WebAdapter(ChameleonPluginHost r2, ChameleonWebView r3, k r4) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "chameleonWebView");
        Intrinsics.checkNotNullParameter(r4, "web");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = new com.bytedance.ee.bear.document.ssrrender.a();
        this.f = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        this.j = new d(this);
        Lazy r5 = LazyKt.lazy(new WebAdapter$documentLoader$2(this));
        this.k = r5;
        ((DocumentLoaderV3) r5.getValue()).m(new a(this));
        r2.getWeb().addWebChromeClientDelegate(new b(this));
    }

    public static void p(VFSFile r13, Map r14, int r16) {
        File[] r0 = r13.listFiles();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.length <= 0) goto L31;
        int r1 = r0.length;
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L32;
        File r4 = r0[r3];
        if (r4.getName() != null) goto L11;
    L25:
        iu5.d.a("WebAdapter", new RuntimeException("name = " + r4.getName() + " path = " + r4.getAbsolutePath() + " file = " + r4 + " dir = " + r13));
    L26:
        r3 = r3 + 1;
        goto L7
    L11:
        if (r4.getAbsolutePath() == null) goto L25;
        if (ay4.d.a().i(r4.getAbsolutePath()).isFile() == false) goto L24;
        String r5 = r4.getAbsolutePath();
        Intrinsics.checkNotNull(r5);
        if (StringsKt.endsWith$default(r5, "mobile_index.html", false, 2, null) == false) goto L20;
        boolean r7 = true;
        if (TextUtils.equals(r5.substring(StringsKt.lastIndexOf$default(r5, "/", 0, false, 6, null) + 1), "mobile_index.html") == false) goto L20;
    L21:
        if (r7 == false) goto L23;
        ((HashMap) r14).put("mobile_index.html", r5);
        goto L24
    L23:
        ((HashMap) r14).put(r5.substring(r16), r5);
    L20:
        r7 = false;
    L24:
        p(r4, r14, r16);
        goto L26
    L32:
        return;
    }

    @Override // vv4.k
    public final void a(String r2, com.alibaba.fastjson.JSONObject r3, ValueCallback<String> r4) {
        this.c.a(r2, r3, I(r2, r4));
    }

    @Override // vv4.k
    public final void k(String r2, NonProguard r3, ValueCallback<String> r4) {
        this.c.k(r2, r3, I(r2, r4));
    }

    @Override // vv4.k
    public final void l(String r2, JSONObject r3, ValueCallback<String> r4) {
        this.c.l(r2, r3, I(r2, r4));
    }
}
