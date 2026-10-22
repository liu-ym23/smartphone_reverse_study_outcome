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
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.document.DeviceInfo;
import com.bytedance.ee.bear.document.statistics.SendEventData;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.facade.common.widget.NoNetworkView;
import com.bytedance.ee.larkwebview.base.LarkWebView;
import com.bytedance.ee.util.ui.k;
import com.bytedance.ee.util.ui.n;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
    public c J;

    /* JADX INFO: renamed from: w35.a$a, reason: collision with other inner class name */
    public static final class C0317a extends WebChromeClient {
        @Override // android.webkit.WebChromeClient
        public final boolean onShowFileChooser(WebView r1, ValueCallback<Uri[]> r2, WebChromeClient.FileChooserParams r3) {
            return false;
        }

        public C0317a() {
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onConsoleMessage(ConsoleMessage r3) {
            Intrinsics.checkNotNullParameter(r3, "cm");
            if (r3.messageLevel().ordinal() <= ConsoleMessage.MessageLevel.LOG.ordinal()) goto L7;
            int r0 = a.K;
            tt5.a.h("SSR_REN_SSRWebView_js", du5.b.k(r3.message()) + " -- From line " + r3.lineNumber() + du5.b.k(r3.sourceId()));
            return true;
        L7:
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public final void onProgressChanged(WebView r3, int r4) {
            super.onProgressChanged(r3, r4);
            if (r3 == null) goto L5;
            String r5 = du5.b.k(r3.getUrl());
        L6:
            int r0 = a.K;
            tt5.a.h("SSR_REN_SSRWebView", "onProgressChanged: " + r4 + ", url: " + r5);
            return;
        L5:
            r5 = "";
            goto L6
        }
    }

    public static final class b {
    }

    public interface c {
        void a();

        void b(JSONObject r1);

        void c(SendEventData r1);
    }

    public interface d {
        void a();
    }

    public static final class e<T> implements ValueCallback {
        public static final e<T> a = null;

        static {
            a = new e();
        }

        public e() {
        }

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(Object r2) {
            String r3 = (String) r2;
            int r4 = a.K;
            tt5.a.h("SSR_REN_SSRWebView", "onReceiveValue js renderCacheHTML");
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.View, android.view.ViewGroup, com.bytedance.ee.bear.facade.common.widget.NoNetworkView] */
    private final int getTipLayoutHeight() {
        if (this.C != 0) goto L6;
        ?? r0 = new NoNetworkView(getContext());
        r0.setTip(getContext().getString(2131887839));
        int r1 = n.a;
        r0.measure(View.MeasureSpec.makeMeasureSpec(1073741823, ShareItemModel.SRC_TINT_UNDEFINED), View.MeasureSpec.makeMeasureSpec(1073741823, ShareItemModel.SRC_TINT_UNDEFINED));
        this.C = n.E(r0.getMeasuredHeight());
    L6:
        return this.C;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        tt5.a.h("SSR_REN_SSRWebView", "onAttachedToWindow...");
        clearView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.webkit.WebView*/.onDetachedFromWindow();
        tt5.a.h("SSR_REN_SSRWebView", "onDetachedFromWindow...");
        this.H = null;
        this.I = null;
        this.J = null;
        this.E = 0;
        Map<String, Boolean> r1 = this.A;
        HashMap r2 = (HashMap) r1;
        Boolean r3 = (Boolean) r2.get(sbb.e.o.getType());
        if (r3 == null) goto L5;
        boolean r4 = r3.booleanValue();
    L6:
        if (r4 == false) goto L8;
        ap5.a.a(this, "javascript:clear", null, null);
        evaluateJavascript("ttwebview:/*cleanupGPUResource*/;", null);
    L8:
        clearHistory();
        return;
    L5:
        r4 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null, 6);
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
        addJavascriptInterface(this, "Lark_Bridge");
        this.D = n.E(k.e(r4));
        setWebChromeClient(new C0317a());
    }

    @JavascriptInterface
    public void invokeNative(String r5) {
        Intrinsics.checkNotNullParameter(r5, "jsMessage");
        tt5.a.h("SSR_REN_SSRWebView", r5);
        JSONObject r1 = new JSONObject(r5);     // Catch: Exception -> L6
        String r6 = r1.optString("apiName");     // Catch: Exception -> L6
        String r2 = r1.optString("data");     // Catch: Exception -> L6
        if (TextUtils.equals("biz.notify.ready", r6) == false) goto L9;
        com.bytedance.ee.util.ui.j.c(new w35.c(new JSONObject(r2).optString("type", ""), this));     // Catch: Exception -> L6
    L19:
        return;
    L9:
        if (TextUtils.equals("biz.util.hideLoading", r6) == false) goto L12;
        com.bytedance.ee.util.ui.j.c(new w35.b(this));     // Catch: Exception -> L6
        goto L19
    L12:
        if (TextUtils.equals("biz.statistics.sendEvent", r6) == false) goto L19;
        c r7 = this.J;     // Catch: Exception -> L6
        if (r7 == null) goto L19;
        r7.c((SendEventData) new Gson().fromJson(r2, SendEventData.class));     // Catch: Exception -> L6
    L6:
        e = move-exception;
        tt5.a.f("SSR_REN_SSRWebView", e, false);
    }

    public final void loadUrl(String r5) {
        tt5.a.h("SSR_REN_SSRWebView", "loadUrl: " + r5);
        n25.g r0 = this.B.a;
        tt5.a.h(r0.b, "setPreloadUrl()... preloadUrl = " + r5);
        r0.s = r5;
        r0.v = false;
        super.loadUrl(r5);
    }

    public final void setOnSsrScrollChangeListner(d r2) {
        Intrinsics.checkNotNullParameter(r2, "listner");
        this.F = r2;
    }

    public final void o(String r7, BearUrl r8) {
        if (r8 != null) goto L18;
        String r9 = null;
    L8:
        tt5.a.h("SSR_REN_SSRWebView", du5.b.i(r9));     // Catch: Exception -> L5
        JSONObject r10 = new JSONObject(r7);     // Catch: Exception -> L5
        int r2 = 50;
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L11;
        r2 = 50 + getTipLayoutHeight();     // Catch: Exception -> L5
    L11:
        r10.put("deviceInfo", new Gson().toJson(new DeviceInfo(this.D, r2)));     // Catch: Exception -> L5
        c r11 = this.J;     // Catch: Exception -> L5
        if (r11 == null) goto L14;
        r11.b(r10);     // Catch: Exception -> L5
    L14:
        evaluateJavascript("javascript:renderCacheHTML(" + r10 + ')', e.a);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.f("SSR_REN_SSRWebView", e, false);
        return;
    L18:
        r9 = r8.b;     // Catch: Exception -> L5
        goto L8
    }

    public final void onScrollChanged(int r1, int r2, int r3, int r4) {
        super.onScrollChanged(r1, r2, r3, r4);
        d r5 = this.F;
        if (r5 == null) goto L6;
        r5.a();
        return;
    }
}
