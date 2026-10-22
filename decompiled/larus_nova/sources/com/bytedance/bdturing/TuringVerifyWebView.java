package com.bytedance.bdturing;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import qb4.c0;
import qb4.g0;
import qb4.n;
import qb4.p;
import qb4.u;
import qb4.v;
import qb4.w;
import rb4.g;

/* JADX INFO: loaded from: classes12.dex */
public class TuringVerifyWebView extends WebView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g0 f201705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f201706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f201707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f201708d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f201709e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f201710f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public p f201711g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f201712h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f201713i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public g f201714j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f201715k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public jc4.a f201716l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final d f201717m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final e f201718n;

    public class a implements TypeEvaluator<int[]> {
        public a() {
        }

        @Override // android.animation.TypeEvaluator
        public final int[] evaluate(float r100, int[] r101, int[] r102) {
            int[] r103 = r101;
            int[] r104 = r102;
            int r105 = r103.length;
            int[] r106 = new int[r105];
            int r107 = 0;
        L3:
            if (r107 >= r105) goto L5;
            int r108 = r103[r107];
            r106[r107] = (int) (r108 + ((r104[r107] - r108) * r100));
            r107 = r107 + 1;
            goto L3
        L5:
            return r106;
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TuringVerifyWebView f201719a;

        public b(TuringVerifyWebView r100) {
            this.f201719a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            ViewGroup.LayoutParams r101 = this.f201719a.getLayoutParams();
            int[] r102 = (int[]) r100.getAnimatedValue();
            r101.width = r102[0];
            r101.height = r102[1];
            this.f201719a.setLayoutParams(r101);
        }
    }

    public class c extends WebChromeClient {
        public c() {
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onConsoleMessage(ConsoleMessage r100) {
            if (r100 == null) goto L4;
            r100.message();
        L4:
            int r101 = n.f532367a;
            return super.onConsoleMessage(r100);
        }
    }

    public class d extends WebViewClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TuringVerifyWebView f201720a;

        public d(TuringVerifyWebView r100) {
            this.f201720a = r100;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView r100, String r110) {
            TuringVerifyWebView r101 = this.f201720a;
            boolean r102 = r101.f201707c;
            boolean r103 = r101.f201708d;
            boolean r104 = r101.f201713i;
            int r105 = n.f532367a;
            if (r101.f201706b == true) goto L5;
            r101.e();
        L5:
            TuringVerifyWebView r106 = this.f201720a;
            boolean r107 = r106.f201713i;
            jc4.a r108 = r106.f201716l;
            JSONObject r109 = new JSONObject();
            r109.put("key", "web_load_finish");     // Catch: JSONException -> L12
            r109.put("duration", System.currentTimeMillis() - EventReport.f201688a);     // Catch: JSONException -> L12
            if (r107 == false) goto L9;
            int r111 = 1;
        L10:
            r109.put("result", r111);     // Catch: JSONException -> L12
            EventReport.w("turing_verify_sdk", r109, r108);
        L14:
            super.onPageFinished(r100, r110);
            return;
        L9:
            r111 = 0;
        L12:
            e = move-exception;
            int r112 = n.f532367a;
            Intrinsics.checkNotNullParameter(e, "e");
            e.printStackTrace();
            goto L14
        }

        @Override // android.webkit.WebViewClient
        public final WebResourceResponse shouldInterceptRequest(WebView r100, String r101) {
            if (r101.toLowerCase().contains("/favicon.ico") == true) goto L16;
        L8:
            System.currentTimeMillis();
            g r102 = this.f201720a.f201714j;
            if (r102 == null) goto L15;
            WebResourceResponse r103 = r102.c(r101);
            if (r103 == null) goto L15;
            System.currentTimeMillis();
            int r104 = n.f532367a;
            this.f201720a.f201715k = 1;
            return r103;
        L15:
            return super.shouldInterceptRequest(r100, r101);
        L16:
            return new WebResourceResponse("image/png", null, null);
        L6:
            e = move-exception;
            e.printStackTrace();
            goto L8
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedHttpError(WebView r100, WebResourceRequest r101, WebResourceResponse r102) {
            super.onReceivedHttpError(r100, r101, r102);
            if (r101.getUrl().toString().toLowerCase().contains("/favicon.ico") == false) goto L8;
            return;
        L8:
            this.f201720a.f201713i = true;
            if (r102 == null) goto L11;
            int r103 = r102.getStatusCode();
        L12:
            if (r102 == null) goto L14;
            String r104 = r102.getReasonPhrase();
        L15:
            if (r101 == null) goto L17;
            String r105 = r101.getUrl().toString();
        L18:
            r101.isForMainFrame();
            int r106 = n.f532367a;
            TuringVerifyWebView.a(this.f201720a, r103, r105, r104);
            return;
        L17:
            r105 = "";
            goto L18
        L14:
            r104 = "onReceivedHttpError";
            goto L15
        L11:
            r103 = -1;
        L6:
            e = move-exception;
            int r107 = n.f532367a;
            Intrinsics.checkNotNullParameter(e, "e");
            e.printStackTrace();
            goto L8
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedSslError(WebView r100, SslErrorHandler r101, SslError r102) {
            if (r102 == null) goto L4;
            int r103 = r102.getPrimaryError();
        L5:
            if (r102 != null) goto L7;
        L9:
            String r104 = "onReceivedSslError";
        L10:
            if (r102 == null) goto L12;
            String r105 = r102.getUrl();
        L13:
            TuringVerifyWebView.a(this.f201720a, r103, r105, r104);
            this.f201720a.f201713i = true;
            Objects.toString(r102);
            ThreadMethodProxy.currentThread().getName();
            int r106 = n.f532367a;
            super.onReceivedSslError(r100, r101, r102);
            return;
        L12:
            r105 = "";
            goto L13
        L7:
            if (r102.getCertificate() == null) goto L9;
            r104 = r102.getCertificate().toString();
            goto L10
        L4:
            r103 = -1;
            goto L5
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedError(WebView r100, int r101, String r102, String r103) {
            int r104 = n.f532367a;
            if (TextUtils.isEmpty(r102) == true) goto L5;
            String r105 = r102;
        L6:
            TuringVerifyWebView r106 = this.f201720a;
            r106.f201713i = true;
            TuringVerifyWebView.a(r106, r101, r103, r105);
            super.onReceivedError(r100, r101, r102, r103);
            return;
        L5:
            r105 = "onReceivedError";
            goto L6
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TuringVerifyWebView f201721a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f201722a;

            @Override // java.lang.Runnable
            public final void run() {
                TuringVerifyWebView.b(this.f201722a.f201721a);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(e r100) {
                this.f201722a = r100;
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            TuringVerifyWebView r100 = this.f201721a;     // Catch: Throwable -> L6
            if (r100.f201710f == true) goto L9;
            r100.post(new a(this));     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public e(TuringVerifyWebView r100) {
            this.f201721a = r100;
        }
    }

    public final void e() {
        this.f201710f = true;
        this.f201707c = false;
        this.f201709e = 0;
        c0 r100 = c0.a.f532328a;
        e r101 = this.f201718n;
        c0.b r102 = r100.f532327b;
        if (r102 == null) goto L6;
        if (r101 == null) goto L6;
        r102.removeCallbacks(r101);
    L6:
        int r103 = n.f532367a;
        EventReport.J(0, "success", this.f201715k, this.f201716l);
        this.f201708d = true;
        if (this.f201705a == null) goto L10;
        post(new u(this));
        return;
    }

    private long getTimeOut() {
        com.bytedance.bdturing.setting.e r100 = com.bytedance.bdturing.setting.e.f202077a;
        return Math.max(com.bytedance.bdturing.setting.e.e("common").optLong("h5_load_timeout", 0), KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL);
    }

    @Override // android.webkit.WebView
    public final void reload() {
        int r100 = n.f532367a;
        super.reload();
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        EventReport.Y(this.f201716l);
        this.f201712h = System.currentTimeMillis();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        EventReport.X(this.f201708d, this.f201707c, System.currentTimeMillis() - this.f201712h, this.f201716l);
        this.f201710f = true;
        c0 r100 = c0.a.f532328a;
        e r101 = this.f201718n;
        c0.b r102 = r100.f532327b;
        if (r102 == null) goto L7;
        if (r101 == null) goto L8;
        r102.removeCallbacks(r101);
        return;
    L8:
        return;
    }

    public TuringVerifyWebView(Context r100) {
        super(c(r100), null);
        this.f201706b = true;
        this.f201707c = false;
        this.f201708d = false;
        this.f201709e = 0;
        this.f201710f = false;
        this.f201713i = false;
        this.f201714j = null;
        this.f201715k = 0;
        new c();
        this.f201717m = new d(this);
        this.f201718n = new e(this);
    }

    public static void b(TuringVerifyWebView r100) {
        if (r100.f201710f == true) goto L11;
        int r101 = r100.f201709e + 1;
        r100.f201709e = r101;
        if (r101 >= 3) goto L8;
        r100.f201708d = false;
        r100.f201707c = false;
        r100.f201713i = false;
        int r102 = n.f532367a;
        r100.reload();
        long r103 = r100.getTimeOut();
        c0.a.f532328a.b(r100.f201718n, r103);
        return;
    L8:
        r100.f201708d = false;
        r100.f201707c = true;
        r100.post(new w(r100));
        return;
    }

    public static Context c(Context r100) {
        if (Build.VERSION.SDK_INT > 22) goto L6;
        Context r101 = r100.createConfigurationContext(new Configuration());
        NewMiraResourcesManager.getInstance().install(r101);
        return r101;
    L6:
        return r100;
    }

    @Override // android.webkit.WebView
    public final void loadUrl(String r100) {
        super.loadUrl(r100);
        int r101 = n.f532367a;
        if ("about:blank".equals(r100) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L16;
        g r102 = this.f201714j;
        if (r102 == null) goto L10;
        r102.e(r100);
    L10:
        this.f201713i = false;
        this.f201708d = false;
        this.f201707c = false;
        this.f201709e = 0;
        if (this.f201706b == false) goto L15;
        c0.a.f532328a.b(this.f201718n, getTimeOut());
        return;
    L15:
        return;
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        p r101 = this.f201711g;
        if (r101 == null) goto L6;
        r101.a(r100);
    L6:
        return super.onTouchEvent(r100);
    }

    public void setInterceptor(g r100) {
        this.f201714j = r100;
    }

    public void setOnTouchListener(p r100) {
        this.f201711g = r100;
    }

    public TuringVerifyWebView(Context r100, AttributeSet r101) {
        super(c(r100), r101);
        this.f201706b = true;
        this.f201707c = false;
        this.f201708d = false;
        this.f201709e = 0;
        this.f201710f = false;
        this.f201713i = false;
        this.f201714j = null;
        this.f201715k = 0;
        new c();
        this.f201717m = new d(this);
        this.f201718n = new e(this);
    }

    public TuringVerifyWebView(Context r100, AttributeSet r101, int r102) {
        super(c(r100), r101, r102);
        this.f201706b = true;
        this.f201707c = false;
        this.f201708d = false;
        this.f201709e = 0;
        this.f201710f = false;
        this.f201713i = false;
        this.f201714j = null;
        this.f201715k = 0;
        new c();
        this.f201717m = new d(this);
        this.f201718n = new e(this);
    }

    public final void d(g0 r100, boolean r101, jc4.a r102) {
        this.f201706b = r101;
        this.f201705a = r100;
        this.f201716l = r102;
        WebSettings r103 = getSettings();
        r103.setLoadWithOverviewMode(true);
        r103.setDomStorageEnabled(true);
        r103.setUseWideViewPort(true);
        r103.setSupportZoom(false);
        r103.setAllowFileAccessFromFileURLs(false);
        r103.setAllowFileAccess(false);
        r103.setLoadsImagesAutomatically(true);
        r103.setDefaultTextEncodingName(XML.CHARSET_UTF8);
        r103.setCacheMode(2);
        r103.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        r103.setTextZoom(100);
        setOverScrollMode(2);     // Catch: Throwable -> L5
    L7:
        setScrollContainer(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        int r104 = n.f532367a;
        setWebViewClient(this.f201717m);
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    public static void a(TuringVerifyWebView r100, int r101, String r102, String r103) {
        r100.getClass();
        EventReport.J(r101, r103 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r102, r100.f201715k, r100.f201716l);
        if (r100.f201705a == null) goto L6;
        r100.post(new v(r100, r101, r102, r103));
        return;
    }

    public final void f(int r100, int r101, int r102, int r103) {
        ValueAnimator r104 = ValueAnimator.ofObject(new a(), new Object[]{new int[]{r102, r103}, new int[]{r100, r101}});
        r104.addUpdateListener(new b(this));
        r104.setDuration(300).start();
    }
}
