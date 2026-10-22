package kxb;

import android.os.Handler;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.utils.di.ThreadUtil;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.quality.HangDetectConfig;
import com.ss.android.lark.officewebview.quality.WebViewOptimizeConfig;
import com.ss.android.lark.officewebview.quality.hang.HangDetectStrategy;
import com.ss.android.lark.officewebview.quality.hang.detect.JSPingCheckSource;
import com.ss.android.lark.officewebview.quality.hang.detect.ResetPingSource;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements kxb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OfficeWebView f506600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f506601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f506602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f506603d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f506604e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f506605f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f506606g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f506607h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f506608i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f506609j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d f506610k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c f506611l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final RunnableC6631b f506612m;

    public static final class a {
    }

    /* JADX INFO: renamed from: kxb.b$b, reason: collision with other inner class name */
    public static final class RunnableC6631b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f506613a;

        public RunnableC6631b(b r100) {
            this.f506613a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            j.f("RunJSPingHangDetector", "checkState timeout, force start ping");     // Catch: Throwable -> L4
            b.a(this.f506613a, JSPingCheckSource.UNRESPONSIVE.getValue());     // Catch: Throwable -> L4
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
        public final /* synthetic */ b f506614a;

        public c(b r100) {
            this.f506614a = r100;
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
            if (this.f506614a.f506606g == false) goto L9;
            j.e("RunJSPingHangDetector", "delay ping start");     // Catch: Throwable -> L6
            b.a(this.f506614a, JSPingCheckSource.NOT_READY_DELAY.getValue());     // Catch: Throwable -> L6
            return;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f506615a;

        public d(b r100) {
            this.f506615a = r100;
        }

        public final void a() {
            this.f506615a.f506608i++;
            j.b("RunJSPingHangDetector", "hang biz: " + this.f506615a.f506600a.getBizScene$webview_release() + ", timeout:" + this.f506615a.f506608i + ", isVisible: " + this.f506615a.f506606g);
            b r100 = this.f506615a;
            if (r100.f506606g == true) goto L5;
            return;
        L5:
            r100.f506601b.invoke();
            b r101 = this.f506615a;
            if (r101.f506608i < r101.f506609j) goto L8;
            j.b("RunJSPingHangDetector", "hang detected");
            this.f506615a.c(ResetPingSource.HangDetected.getValue());
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

    @Override // kxb.a
    public final /* synthetic */ void init() {
    }

    @Override // kxb.a
    public final void start() {
        this.f506606g = true;
        if (this.f506607h == false) goto L7;
        j.e("RunJSPingHangDetector", "bizScene=" + this.f506600a.getBizScene$webview_release() + " has checked");
        return;
    L7:
        if (this.f506600a.n() == true) goto L9;
        return;
    L9:
        j.e("RunJSPingHangDetector", "start: bizScene=" + this.f506600a.getBizScene$webview_release() + ", webViewId=" + Integer.toHexString(System.identityHashCode(this.f506600a)) + ' ');
        this.f506607h = true;
        this.f506608i = 0;
        b();
        if (this.f506600a.getWebViewIsDestroy() == true) goto L20;
        j.e("RunJSPingHangDetector", "checkReadyAndPing");
        Lazy<Handler> r100 = ThreadUtil.f437211a;
        ThreadUtil.a.d(this.f506612m, this.f506603d);
        this.f506600a.evaluateJavascript("document.readyState", new kxb.c(this));     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        b();
        j.c("RunJSPingHangDetector", "checkState error", th);
        return;
    }

    public final void b() {
        Lazy<Handler> r100 = ThreadUtil.f437211a;
        ThreadUtil.a.e(this.f506610k);
        ThreadUtil.a.e(this.f506612m);
        ThreadUtil.a.e(this.f506611l);
    }

    @Override // kxb.a
    public final void stop() {
        j.e("RunJSPingHangDetector", "stop: bizScene=" + this.f506600a.getBizScene$webview_release() + ", webViewId=" + Integer.toHexString(System.identityHashCode(this.f506600a)));
        this.f506606g = false;
        this.f506607h = false;
        this.f506608i = 0;
        b();
    }

    public final void c(String r100) {
        j.e("RunJSPingHangDetector", "resetPing, from " + r100);
        Lazy<Handler> r101 = ThreadUtil.f437211a;
        ThreadUtil.a.e(this.f506610k);
        this.f506608i = 0;
    }

    public static final void a(b r100, String r101) {
        r100.getClass();
        j.e("RunJSPingHangDetector", "sendPing, from " + r101);
        if (r100.f506606g == false) goto L5;
    L7:
        r100.b();
        Lazy<Handler> r102 = ThreadUtil.f437211a;     // Catch: Throwable -> L10
        ThreadUtil.a.d(r100.f506610k, r100.f506605f);     // Catch: Throwable -> L10
        r100.f506600a.evaluateJavascript("(function(){return 'onReceive';})()", new kxb.d(r100));     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        j.c("RunJSPingHangDetector", "evaluateJavascript ping error", th);
        r100.c(ResetPingSource.Error.getValue());
        r100.f506602c.invoke();
        return;
    L5:
        if (r100.f506600a.getWebViewIsDestroy() == false) goto L7;
        j.e("RunJSPingHangDetector", "stop sendPing, webView is invisible or destroy");
        r100.b();
    }

    public b(OfficeWebView r100, Function0<Unit> r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(r101, "onHang");
        Intrinsics.checkNotNullParameter(r102, "onResponsive");
        this.f506600a = r100;
        this.f506601b = r101;
        this.f506602c = r102;
        HangDetectStrategy r103 = HangDetectStrategy.UNKNOWN;
        WebViewOptimizeConfig r104 = ixb.a.f496453a;
        if (r104 == null) goto L5;
        HangDetectConfig r105 = r104.getHangDetect();
    L6:
        long r106 = 5000;
        if (r105 == null) goto L9;
        long r107 = r105.getCheckReadyTimeout();
    L10:
        this.f506603d = r107;
        if (r105 == null) goto L13;
        long r108 = r105.getSendPingDelay();
    L14:
        this.f506604e = r108;
        if (r105 == null) goto L17;
        r106 = r105.getPingTimeout();
    L17:
        this.f506605f = r106;
        if (r105 == null) goto L20;
        int r109 = r105.getMaxHangCount();
    L21:
        this.f506609j = r109;
        this.f506610k = new d(this);
        this.f506611l = new c(this);
        this.f506612m = new RunnableC6631b(this);
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
