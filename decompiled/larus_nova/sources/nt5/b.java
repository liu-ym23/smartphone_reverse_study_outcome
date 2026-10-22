package nt5;

import android.os.Handler;
import com.bytedance.ee.larkwebview.base.LarkWebView;
import com.bytedance.ee.larkwebview.quality.HangDetectConfig;
import com.bytedance.ee.larkwebview.quality.WebViewOptimizeConfig;
import com.bytedance.ee.larkwebview.quality.hang.HangDetectStrategy;
import com.bytedance.ee.larkwebview.quality.hang.detect.JSPingCheckSource;
import com.bytedance.ee.larkwebview.quality.hang.detect.ResetPingSource;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements nt5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarkWebView f520499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f520500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f520501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f520502d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f520503e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f520504f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f520505g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f520506h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f520507i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f520508j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d f520509k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c f520510l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final RunnableC6973b f520511m;

    public static final class a {
    }

    /* JADX INFO: renamed from: nt5.b$b, reason: collision with other inner class name */
    public static final class RunnableC6973b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f520512a;

        public RunnableC6973b(b r100) {
            this.f520512a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Log.w("RunJSPingHangDetector", "checkState timeout, force start ping");     // Catch: Throwable -> L4
            b.a(this.f520512a, JSPingCheckSource.UNRESPONSIVE.getValue());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f520513a;

        public c(b r100) {
            this.f520513a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (this.f520513a.f520505g == false) goto L9;
            Log.i("RunJSPingHangDetector", "delay ping start");     // Catch: Throwable -> L6
            b.a(this.f520513a, JSPingCheckSource.NOT_READY_DELAY.getValue());     // Catch: Throwable -> L6
            return;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f520514a;

        public d(b r100) {
            this.f520514a = r100;
        }

        public final void a() {
            this.f520514a.f520507i++;
            Log.e("RunJSPingHangDetector", "hang url: " + this.f520514a.f520499a.getBizScene$lark_webview_base_chinaRelease() + ", timeout:" + this.f520514a.f520507i + ", isVisible: " + this.f520514a.f520505g);
            b r100 = this.f520514a;
            if (r100.f520505g == true) goto L5;
            return;
        L5:
            r100.f520500b.invoke();
            b r101 = this.f520514a;
            if (r101.f520507i < r101.f520508j) goto L8;
            Log.e("RunJSPingHangDetector", "hang detected");
            this.f520514a.c(ResetPingSource.HangDetected.getValue());
            return;
        L8:
            b.a(r101, JSPingCheckSource.DOUBLE_CHECK.getValue());
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // nt5.a
    public final void init() {
    }

    @Override // nt5.a
    public final void start() {
        this.f520505g = true;
        if (this.f520506h == false) goto L7;
        Log.i("RunJSPingHangDetector", "bizScene=" + this.f520499a.getBizScene$lark_webview_base_chinaRelease() + " has checked");
        return;
    L7:
        if (this.f520499a.n() == true) goto L9;
        return;
    L9:
        Log.i("RunJSPingHangDetector", "start: bizScene=" + this.f520499a.getBizScene$lark_webview_base_chinaRelease() + ", webViewId=" + Integer.toHexString(System.identityHashCode(this.f520499a)) + ' ');
        this.f520506h = true;
        this.f520507i = 0;
        b();
        if (this.f520499a.getWebViewIsDestroy() == true) goto L23;
        Log.i("RunJSPingHangDetector", "checkReadyAndPing");
        RunnableC6973b r100 = this.f520511m;
        long r101 = this.f520502d;
        if (r101 > 0) goto L15;
        mz7.b.a(r100);
    L21:
        this.f520499a.evaluateJavascript("document.readyState", new nt5.c(this));     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        b();
        Log.e("RunJSPingHangDetector", "checkState error", th);
        return;
    L15:
        mz7.b.f516538a.postDelayed(r100, r101);
        goto L21
    }

    public final void b() {
        d r100 = this.f520509k;
        if (r100 != null) goto L5;
        Handler r101 = mz7.b.f516538a;
    L6:
        RunnableC6973b r102 = this.f520511m;
        if (r102 == null) goto L10;
        mz7.b.f516538a.removeCallbacks(r102);
    L10:
        c r103 = this.f520510l;
        if (r103 == null) goto L15;
        mz7.b.f516538a.removeCallbacks(r103);
        return;
    L15:
        return;
    L5:
        mz7.b.f516538a.removeCallbacks(r100);
        goto L6
    }

    public final void c(String r100) {
        Log.i("RunJSPingHangDetector", "resetPing, from " + r100);
        d r101 = this.f520509k;
        if (r101 != null) goto L5;
        Handler r102 = mz7.b.f516538a;
    L6:
        this.f520507i = 0;
        return;
    L5:
        mz7.b.f516538a.removeCallbacks(r101);
        goto L6
    }

    public static final void a(b r100, String r101) {
        r100.getClass();
        Log.i("RunJSPingHangDetector", "sendPing, from " + r101);
        if (r100.f520505g == true) goto L5;
    L16:
        Log.i("RunJSPingHangDetector", "stop sendPing, webView is invisible or destroy");
        r100.b();
        return;
    L5:
        if (r100.f520499a.getWebViewIsDestroy() == true) goto L16;
        r100.b();
        d r102 = r100.f520509k;     // Catch: Throwable -> L14
        long r103 = r100.f520504f;     // Catch: Throwable -> L14
        if (r103 > 0) goto L11;
        mz7.b.a(r102);     // Catch: Throwable -> L14
    L12:
        r100.f520499a.evaluateJavascript("(function(){return 'onReceive';})()", new nt5.d(r100));     // Catch: Throwable -> L14
        return;
    L11:
        mz7.b.f516538a.postDelayed(r102, r103);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Log.e("RunJSPingHangDetector", "evaluateJavascript ping error", th);
        r100.c(ResetPingSource.Error.getValue());
        r100.f520501c.invoke();
    }

    public b(LarkWebView r100, Function0<Unit> r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(r101, "onHang");
        Intrinsics.checkNotNullParameter(r102, "onResponsive");
        this.f520499a = r100;
        this.f520500b = r101;
        this.f520501c = r102;
        HangDetectStrategy r103 = HangDetectStrategy.UNKNOWN;
        WebViewOptimizeConfig r104 = lt5.a.f510672a;
        if (r104 == null) goto L5;
        HangDetectConfig r105 = r104.getHangDetect();
    L6:
        long r106 = 5000;
        if (r105 == null) goto L9;
        long r107 = r105.getCheckReadyTimeout();
    L10:
        this.f520502d = r107;
        if (r105 == null) goto L13;
        long r108 = r105.getSendPingDelay();
    L14:
        this.f520503e = r108;
        if (r105 == null) goto L17;
        r106 = r105.getPingTimeout();
    L17:
        this.f520504f = r106;
        if (r105 == null) goto L20;
        int r109 = r105.getMaxHangCount();
    L21:
        this.f520508j = r109;
        this.f520509k = new d(this);
        this.f520510l = new c(this);
        this.f520511m = new RunnableC6973b(this);
        return;
    L20:
        r109 = 2;
        goto L21
    L13:
        r108 = 5000;
        goto L14
    L9:
        r107 = 5000;
        goto L10
    L5:
        r105 = null;
        goto L6
    }
}
