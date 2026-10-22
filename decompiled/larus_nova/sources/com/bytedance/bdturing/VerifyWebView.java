package com.bytedance.bdturing;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
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
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import qb4.c0;
import qb4.d0;
import qb4.e0;
import qb4.f0;
import qb4.g0;
import qb4.n;
import qb4.p;
import rb4.g;

/* JADX INFO: loaded from: classes12.dex */
public class VerifyWebView extends WebView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g0 f201723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f201724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f201725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f201726d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f201727e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public p f201728f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f201729g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g f201730h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f201731i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final d f201732j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final e f201733k;

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
        public final /* synthetic */ VerifyWebView f201734a;

        public b(VerifyWebView r100) {
            this.f201734a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            ViewGroup.LayoutParams r101 = this.f201734a.getLayoutParams();
            int[] r102 = (int[]) r100.getAnimatedValue();
            r101.width = r102[0];
            r101.height = r102[1];
            this.f201734a.setLayoutParams(r101);
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
        public final /* synthetic */ VerifyWebView f201735a;

        public d(VerifyWebView r100) {
            this.f201735a = r100;
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView r100, String r101) {
            super.onLoadResource(r100, r101);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView r100, String r101) {
            VerifyWebView r102 = this.f201735a;
            boolean r103 = r102.f201724b;
            boolean r104 = r102.f201725c;
            int r105 = n.f532367a;
            if (r103 == true) goto L8;
            if (r104 == true) goto L8;
            r102.getClass();
            EventReport.J(0, "success", r102.f201731i, null);
            r102.f201725c = true;
            if (r102.f201723a == null) goto L8;
            r102.post(new d0(r102));
        L8:
            super.onPageFinished(r100, r101);
        }

        @Override // android.webkit.WebViewClient
        public final WebResourceResponse shouldInterceptRequest(WebView r100, String r101) {
            if (r101.toLowerCase().contains("/favicon.ico") == true) goto L16;
        L8:
            g r102 = this.f201735a.f201730h;
            if (r102 == null) goto L15;
            WebResourceResponse r103 = r102.c(r101);
            if (r103 == null) goto L15;
            this.f201735a.f201731i = 1;
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
        public void onPageStarted(WebView r100, String r101, Bitmap r102) {
            int r103 = n.f532367a;
            super.onPageStarted(r100, r101, r102);
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedHttpError(WebView r100, WebResourceRequest r101, WebResourceResponse r102) {
            super.onReceivedHttpError(r100, r101, r102);
            if (r101.getUrl().toString().toLowerCase().contains("/favicon.ico") == false) goto L8;
            return;
        L8:
            if (r102 == null) goto L10;
            int r103 = r102.getStatusCode();
        L11:
            if (r102 == null) goto L13;
            String r104 = r102.getReasonPhrase();
        L14:
            if (r101 == null) goto L16;
            String r105 = r101.getUrl().toString();
        L17:
            r101.isForMainFrame();
            int r106 = n.f532367a;
            VerifyWebView.a(this.f201735a, r103, r105, r104);
            return;
        L16:
            r105 = "";
            goto L17
        L13:
            r104 = "onReceivedHttpError";
            goto L14
        L10:
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
            VerifyWebView.a(this.f201735a, r103, r105, r104);
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
            VerifyWebView.a(this.f201735a, r101, r103, r105);
            super.onReceivedError(r100, r101, r102, r103);
            return;
        L5:
            r105 = "onReceivedError";
            goto L6
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VerifyWebView f201736a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f201737a;

            @Override // java.lang.Runnable
            public final void run() {
                this.f201737a.f201736a.reload();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(e r100) {
                this.f201737a = r100;
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            VerifyWebView r100 = this.f201736a;     // Catch: Throwable -> L6
            if (r100.f201727e == true) goto L9;
            r100.post(new a(this));     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public e(VerifyWebView r100) {
            this.f201736a = r100;
        }
    }

    @Override // android.webkit.WebView
    public final void reload() {
        int r100 = n.f532367a;
        this.f201725c = false;
        this.f201724b = false;
        super.reload();
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        EventReport.Y(null);
        this.f201729g = System.currentTimeMillis();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int r100 = n.f532367a;
        EventReport.X(this.f201725c, this.f201724b, System.currentTimeMillis() - this.f201729g, null);
        this.f201727e = true;
        c0 r101 = c0.a.f532328a;
        e r102 = this.f201733k;
        c0.b r103 = r101.f532327b;
        if (r103 == null) goto L7;
        if (r102 == null) goto L8;
        r103.removeCallbacks(r102);
        return;
    L8:
        return;
    }

    public VerifyWebView(Context r100) {
        super(b(r100), null);
        this.f201724b = false;
        this.f201725c = false;
        this.f201726d = 0;
        this.f201727e = false;
        this.f201730h = null;
        this.f201731i = 0;
        new c();
        this.f201732j = new d(this);
        this.f201733k = new e(this);
    }

    public static Context b(Context r100) {
        if (Build.VERSION.SDK_INT > 22) goto L6;
        Context r101 = r100.createConfigurationContext(new Configuration());
        NewMiraResourcesManager.getInstance().install(r101);
        return r101;
    L6:
        return r100;
    }

    public final void c(g0 r100) {
        this.f201723a = r100;
        WebSettings r101 = getSettings();
        boolean r102 = true;
        r101.setLoadWithOverviewMode(true);
        r101.setDomStorageEnabled(true);
        r101.setUseWideViewPort(true);
        r101.setSupportZoom(false);
        r101.setAllowFileAccessFromFileURLs(false);
        r101.setAllowFileAccess(false);
        r101.setLoadsImagesAutomatically(true);
        r101.setDefaultTextEncodingName(XML.CHARSET_UTF8);
        r101.setCacheMode(2);
        r101.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        r101.setTextZoom(100);
        BdTuringConfig r103 = qb4.b.c.f532315a.f532302a;
        if (r103 != null) goto L5;
    L7:
        r102 = false;
    L8:
        if (r102 == false) goto L16;
        r101.setMixedContentMode(0);
    L16:
        setOverScrollMode(2);     // Catch: Throwable -> L12
    L14:
        setScrollContainer(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        int r104 = n.f532367a;
        setWebViewClient(this.f201732j);
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
        goto L14
    L5:
        if (r103.getRegionType() != BdTuringConfig.RegionType.REGION_BOE) goto L7;
        goto L7
    }

    @Override // android.webkit.WebView
    public final void loadUrl(String r100) {
        super.loadUrl(r100);
        g r101 = this.f201730h;
        if (r101 == null) goto L6;
        r101.e(r100);
        return;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        p r101 = this.f201728f;
        if (r101 == null) goto L6;
        r101.a(r100);
    L6:
        return super.onTouchEvent(r100);
    }

    public void setOnTouchListener(p r100) {
        this.f201728f = r100;
    }

    public void setUrlInterceptor(g r100) {
        this.f201730h = r100;
    }

    public VerifyWebView(Context r100, AttributeSet r101) {
        super(b(r100), r101);
        this.f201724b = false;
        this.f201725c = false;
        this.f201726d = 0;
        this.f201727e = false;
        this.f201730h = null;
        this.f201731i = 0;
        new c();
        this.f201732j = new d(this);
        this.f201733k = new e(this);
    }

    public VerifyWebView(Context r100, AttributeSet r101, int r102) {
        super(b(r100), r101, r102);
        this.f201724b = false;
        this.f201725c = false;
        this.f201726d = 0;
        this.f201727e = false;
        this.f201730h = null;
        this.f201731i = 0;
        new c();
        this.f201732j = new d(this);
        this.f201733k = new e(this);
    }

    public static void a(VerifyWebView r100, int r101, String r102, String r103) {
        r100.f201724b = true;
        EventReport.J(r101, r103 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r102, r100.f201731i, null);
        if (r100.f201723a == null) goto L5;
        r100.post(new e0(r100, r101, r102, r103));
    L5:
        int r104 = r100.f201726d;
        if (r104 >= 3) goto L9;
        r100.f201726d = r104 + 1;
        c0.a.f532328a.b(r100.f201733k, 500);
        return;
    L9:
        if (r100.f201723a == null) goto L13;
        r100.post(new f0(r100, r101, r103));
        return;
    }

    public final void d(int r100, int r101, int r102, int r103) {
        ValueAnimator r104 = ValueAnimator.ofObject(new a(), new Object[]{new int[]{r102, r103}, new int[]{r100, r101}});
        r104.addUpdateListener(new b(this));
        r104.setDuration(300).start();
    }
}
