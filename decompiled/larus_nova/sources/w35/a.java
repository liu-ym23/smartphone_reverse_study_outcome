package w35;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bytedance.ee.bear.document.DeviceInfo;
import com.bytedance.ee.bear.document.statistics.SendEventData;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.facade.common.widget.NoNetworkView;
import com.bytedance.ee.docsdk.impl.document.plugins.JsBridgeConstants;
import com.bytedance.ee.larkwebview.base.LarkWebView;
import com.bytedance.ee.util.ui.k;
import com.bytedance.ee.util.ui.n;
import com.google.gson.Gson;
import com.larus.nova.R;
import com.ss.android.lark.chameleon.bridge.Bridge;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends LarkWebView {
    public static final /* synthetic */ int K = 0;
    public final Map<String, Boolean> A;
    public final w35.d B;
    public int C;
    public final int D;
    public long E;
    public d F;
    public final com.bytedance.ee.bear.contract.d G;
    public BearUrl H;
    public String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public c f558151J;

    /* JADX INFO: renamed from: w35.a$a, reason: collision with other inner class name */
    public static final class C8062a extends WebChromeClient {
        @Override // android.webkit.WebChromeClient
        public final boolean onShowFileChooser(WebView r100, ValueCallback<Uri[]> r101, WebChromeClient.FileChooserParams r102) {
            return false;
        }

        public C8062a() {
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onConsoleMessage(ConsoleMessage r100) {
            Intrinsics.checkNotNullParameter(r100, "cm");
            if (r100.messageLevel().ordinal() <= ConsoleMessage.MessageLevel.LOG.ordinal()) goto L7;
            int r101 = a.K;
            tt5.a.h("SSR_REN_SSRWebView_js", du5.b.k(r100.message()) + " -- From line " + r100.lineNumber() + du5.b.k(r100.sourceId()));
            return true;
        L7:
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public final void onProgressChanged(WebView r100, int r101) {
            super.onProgressChanged(r100, r101);
            if (r100 == null) goto L5;
            String r102 = du5.b.k(r100.getUrl());
        L6:
            int r103 = a.K;
            tt5.a.h("SSR_REN_SSRWebView", "onProgressChanged: " + r101 + ", url: " + r102);
            return;
        L5:
            r102 = "";
            goto L6
        }
    }

    public static final class b {
    }

    public interface c {
        void a();

        void b(JSONObject r100);

        void c(SendEventData r100);
    }

    public interface d {
        void a();
    }

    public static final class e<T> implements ValueCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e<T> f558152a = null;

        static {
            f558152a = new e();
        }

        public e() {
        }

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(Object r100) {
            String r101 = (String) r100;
            int r102 = a.K;
            tt5.a.h("SSR_REN_SSRWebView", "onReceiveValue js renderCacheHTML");
        }
    }

    static {
    }

    private final int getTipLayoutHeight() {
        if (this.C != 0) goto L6;
        NoNetworkView r100 = new NoNetworkView(getContext());
        r100.setTip(getContext().getString(R.string.Doc_Facade_SyncedNextOnline));
        int r101 = n.f243167a;
        r100.measure(View.MeasureSpec.makeMeasureSpec(1073741823, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(1073741823, Integer.MIN_VALUE));
        this.C = n.E(r100.getMeasuredHeight());
    L6:
        return this.C;
    }

    @Override // com.bytedance.ee.larkwebview.base.LarkWebView, com.bytedance.ee.larkwebview.base.g, android.webkit.WebView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        tt5.a.h("SSR_REN_SSRWebView", "onAttachedToWindow...");
        clearView();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tt5.a.h("SSR_REN_SSRWebView", "onDetachedFromWindow...");
        this.H = null;
        this.I = null;
        this.f558151J = null;
        this.E = 0;
        Map<String, Boolean> r100 = this.A;
        HashMap r101 = (HashMap) r100;
        Boolean r102 = (Boolean) r101.get(sbb.e.f541304o.getType());
        if (r102 == null) goto L5;
        boolean r103 = r102.booleanValue();
    L6:
        if (r103 == false) goto L8;
        ap5.a.a(this, "javascript:clear", null, null);
        evaluateJavascript("ttwebview:/*cleanupGPUResource*/;", null);
    L8:
        clearHistory();
        return;
    L5:
        r103 = false;
        goto L6
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 6);
        this.A = new HashMap();
        this.G = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setSupportZoom(true);
        getSettings().setBuiltInZoomControls(true);
        getSettings().setDisplayZoomControls(false);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().setUseWideViewPort(true);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        this.B = new w35.d(this);
        addJavascriptInterface(this, Bridge.BRIDGE_NAME);
        this.D = n.E(k.e(r100));
        setWebChromeClient(new C8062a());
    }

    @JavascriptInterface
    public void invokeNative(String r100) {
        Intrinsics.checkNotNullParameter(r100, "jsMessage");
        tt5.a.h("SSR_REN_SSRWebView", r100);
        JSONObject r101 = new JSONObject(r100);     // Catch: Exception -> L6
        String r102 = r101.optString("apiName");     // Catch: Exception -> L6
        String r103 = r101.optString("data");     // Catch: Exception -> L6
        if (TextUtils.equals(JsBridgeConstants.BIZ_NOTIFY_READY, r102) == false) goto L9;
        com.bytedance.ee.util.ui.j.c(new w35.c(new JSONObject(r103).optString("type", ""), this));     // Catch: Exception -> L6
    L19:
        return;
    L9:
        if (TextUtils.equals(JsBridgeConstants.BIZ_UTIL_HIDELOADING, r102) == false) goto L12;
        com.bytedance.ee.util.ui.j.c(new w35.b(this));     // Catch: Exception -> L6
        goto L19
    L12:
        if (TextUtils.equals("biz.statistics.sendEvent", r102) == false) goto L19;
        c r104 = this.f558151J;     // Catch: Exception -> L6
        if (r104 == null) goto L19;
        r104.c((SendEventData) new Gson().fromJson(r103, SendEventData.class));     // Catch: Exception -> L6
    L6:
        e = move-exception;
        tt5.a.f("SSR_REN_SSRWebView", e, false);
    }

    @Override // com.bytedance.ee.larkwebview.base.LarkWebView, com.bytedance.ee.larkwebview.base.g, android.webkit.WebView
    public final void loadUrl(String r100) {
        tt5.a.h("SSR_REN_SSRWebView", "loadUrl: " + r100);
        n25.g r101 = this.B.f558156a;
        tt5.a.h(r101.f516714b, "setPreloadUrl()... preloadUrl = " + r100);
        r101.f516731s = r100;
        r101.f516734v = false;
        super.loadUrl(r100);
    }

    public final void setOnSsrScrollChangeListner(d r100) {
        Intrinsics.checkNotNullParameter(r100, "listner");
        this.F = r100;
    }

    public final void o(String r100, BearUrl r101) {
        if (r101 != null) goto L18;
        String r102 = null;
    L8:
        tt5.a.h("SSR_REN_SSRWebView", du5.b.i(r102));     // Catch: Exception -> L5
        JSONObject r103 = new JSONObject(r100);     // Catch: Exception -> L5
        int r104 = 50;
        if (com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a() == true) goto L11;
        r104 = 50 + getTipLayoutHeight();     // Catch: Exception -> L5
    L11:
        r103.put("deviceInfo", new Gson().toJson(new DeviceInfo(this.D, r104)));     // Catch: Exception -> L5
        c r105 = this.f558151J;     // Catch: Exception -> L5
        if (r105 == null) goto L14;
        r105.b(r103);     // Catch: Exception -> L5
    L14:
        evaluateJavascript("javascript:renderCacheHTML(" + r103 + ')', e.f558152a);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.f("SSR_REN_SSRWebView", e, false);
        return;
    L18:
        r102 = r101.f222561b;     // Catch: Exception -> L5
        goto L8
    }

    @Override // com.bytedance.ee.larkwebview.base.LarkWebView, android.webkit.WebView, android.view.View
    public final void onScrollChanged(int r100, int r101, int r102, int r103) {
        super.onScrollChanged(r100, r101, r102, r103);
        d r104 = this.F;
        if (r104 == null) goto L6;
        r104.a();
        return;
    }
}
