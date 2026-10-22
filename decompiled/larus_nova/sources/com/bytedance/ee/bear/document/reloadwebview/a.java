package com.bytedance.ee.bear.document.reloadwebview;

import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebViewRenderProcess;
import com.bytedance.ee.larkwebview.base.LarkWebView;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.utils.di.TTWebViewUtil;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.jvm.JvmStatic;
import otb.n;
import p35.e;
import p35.f;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsThreadCheckConfig f221264a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f221265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f221266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f221267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f221268e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f221269f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static LarkWebView f221270g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f221271h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f221272i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final boolean f221273j = false;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.reloadwebview.a$a, reason: collision with other inner class name */
    public static final class C3153a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C3153a f221274a = null;

        static {
            f221274a = new C3153a();
        }

        public C3153a() {
        }

        @Override // p35.f
        public final void a(boolean r100, int r101) {
            a.f();
        }
    }

    public static final class b implements tb5.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f221275a = null;

        static {
            f221275a = new b();
        }

        public b() {
        }

        @Override // tb5.f.a
        public final void a() {
            a.f();
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f221276a = null;

        static {
            f221276a = new c();
        }

        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        L16:
            return;
        L3:
            if (Build.VERSION.SDK_INT < 29) goto L11;
            a.f221268e = true;     // Catch: Throwable -> L8
            e.f527582d = true;     // Catch: Throwable -> L8
            WebViewRenderProcess r100 = new LarkWebView(eu5.b.f474075a, null, 6).getWebViewRenderProcess();     // Catch: Throwable -> L8
            if (r100 == null) goto L15;
            r100.terminate();     // Catch: Throwable -> L8
            return;
        L15:
            return;
        }
    }

    public static final class d implements Runnable {
        public d() {
        }

        public static void a() {
            tt5.a.k("JsThreadChecker", "check js thread overtime");
            a.e();
            tt5.a.h("JsThreadChecker", "sPreloadHtmlFailedCount is " + a.f221265b + ", sOvertime100Count is " + a.f221266c + ", sCancel100Count is " + a.f221267d);
            Iterator<T> r100 = a.f221264a.getConditions().iterator();
        L4:
            if (r100.hasNext() == false) goto L15;
            JsThreadCheckConfig.Condition r101 = (JsThreadCheckConfig.Condition) r100.next();
            if (a.f221265b < r101.preloadHtmlFailedCount) goto L4;
            if (a.f221266c < r101.overtime100Count) goto L4;
            if (a.f221267d < r101.cancel100Count) goto L4;
            if (TextUtils.isEmpty(d25.d.f466517d) == false) goto L13;
            a.f221272i = true;
            goto L4
        L13:
            tt5.a.k("JsThreadChecker", "openingDocToken is not null, so killSandBoxProcesses immediately");
            a.b();
            goto L4
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

    @JvmStatic
    public static final void f() {
        f221265b = 0;
        f221266c = 0;
        f221267d = 0;
        f221272i = false;
    }

    static {
        com.bytedance.ee.bear.appsetting.c r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        JsThreadCheckConfig r101 = (JsThreadCheckConfig) r100.c("ccm_check_js_thread_was_blocked_config", JsThreadCheckConfig.class, new JsThreadCheckConfig());
        f221264a = r101;
        f221271h = new d();
        boolean r102 = r100.g("ccm.docs.kill_render_process_when_js_blocked");
        f221273j = r102;
        if (r102 == false) goto L6;
        e.a(C3153a.f221274a);
        tb5.f.f545258a = b.f221275a;
        tt5.a.h("JsThreadChecker", r101.toString());
        return;
    }

    public static void a() {
        tt5.a.h("JsThreadChecker", "checkJsThread....");
        if (f221273j == true) goto L6;
        tt5.a.h("JsThreadChecker", "checkEnable is false");
        return;
    L6:
        JsThreadCheckConfig r100 = f221264a;
        if (r100.isEnableCheckWhenLoadFailed() == true) goto L11;
        tt5.a.h("JsThreadChecker", "isEnableCheckWhenLoadFailed is false");
        return;
    L11:
        if (f221265b < 3) goto L13;
        tt5.a.h("JsThreadChecker", "sPreloadHtmlFailedCount more than 3");
        f221272i = true;
        return;
    L13:
        tt5.a.h("JsThreadChecker", "sPreloadHtmlFailedCount is " + f221265b + ", sOvertime100Count is " + f221266c + ", sCancel100Count is " + f221267d);
        Iterator<T> r101 = r100.getConditions().iterator();
    L15:
        if (r101.hasNext() == false) goto L55;
        JsThreadCheckConfig.Condition r102 = (JsThreadCheckConfig.Condition) r101.next();
        if (f221265b < r102.preloadHtmlFailedCount) goto L15;
        if (f221266c < r102.overtime100Count) goto L15;
        if (f221267d < r102.cancel100Count) goto L15;
        JsThreadCheckConfig r103 = f221264a;
        long r104 = r103.getCheckTimeout();
        tt5.a.h("JsThreadChecker", "realCheckJsThread....");
        if (f221269f >= r103.getMaxKillTims()) goto L24;
        if (eu5.b.f474075a == null) goto L27;
        d r105 = f221271h;
        if (j.a(r105) == true) goto L30;
        e();
        f221270g = new LarkWebView(eu5.b.f474075a, null, 6);
        j.e(r105);
        j.d(r105, r104);
        LarkWebView r106 = f221270g;
        if (r106 == null) goto L15;
        r106.evaluateJavascript("(function(){return 'onReceive';})()", com.bytedance.ee.bear.document.reloadwebview.b.f221277a);
        goto L15
    L30:
        tt5.a.h("JsThreadChecker", "we are checking already");
        goto L15
    L27:
        tt5.a.h("JsThreadChecker", "context is null");
        goto L15
    L24:
        tt5.a.h("JsThreadChecker", "realCheckJsThread... killTimes is " + f221269f);
        goto L15
    }

    @JvmStatic
    public static final void b() {
        long r100 = f221269f + 1;
        JsThreadCheckConfig r101 = f221264a;
        if (r100 <= r101.getMaxKillTims()) goto L7;
        tt5.a.h("JsThreadChecker", "killTimes is " + f221269f + " maxKillTimes is " + r101.getMaxKillTims());
        return;
    L7:
        if (f221273j == true) goto L11;
        tt5.a.h("JsThreadChecker", "checkEnable is false");
        return;
    L11:
        if (eu5.b.f474075a == null) goto L13;
        f();
        Lazy<n> r102 = TTWebViewUtil.f437209a;
        TTWebViewUtil.a.d(null);
        j.f(c.f221276a);
        f221269f++;
        tt5.a.h("JsThreadChecker", "killSandBoxProcesses");
        return;
    L13:
        tt5.a.h("JsThreadChecker", "context is null");
    }

    @JvmStatic
    public static final void c() {
        tt5.a.h("JsThreadChecker", "openDocCancel100....");
        f221267d++;
        if (f221272i == true) goto L5;
    L7:
        a();
        return;
    L5:
        if (eu5.b.f474075a == null) goto L7;
        tt5.a.h("JsThreadChecker", "kill when cancel 100");
        e.e(true);
        b();
    }

    @JvmStatic
    public static final void d() {
        tt5.a.h("JsThreadChecker", "openDocOvertime100....");
        f221266c++;
        if (f221272i == true) goto L5;
    L7:
        a();
        return;
    L5:
        if (eu5.b.f474075a == null) goto L7;
        tt5.a.h("JsThreadChecker", "kill when overtime 100");
        e.e(true);
        b();
    }

    public static void e() {
        tt5.a.h("JsThreadChecker", "releaseWebview");
        LarkWebView r100 = f221270g;
        if (r100 == null) goto L5;
        r100.destroy();
    L5:
        f221270g = null;
    }
}
