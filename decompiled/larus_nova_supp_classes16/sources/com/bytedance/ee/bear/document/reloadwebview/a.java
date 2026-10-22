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
import p35.e;
import p35.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final JsThreadCheckConfig a = null;
    public static int b;
    public static int c;
    public static int d;
    public static boolean e;
    public static int f;
    public static LarkWebView g;
    public static final d h = null;
    public static boolean i;
    public static final boolean j = false;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.reloadwebview.a$a, reason: collision with other inner class name */
    public static final class C0097a implements f {
        public static final C0097a a = null;

        static {
            a = new C0097a();
        }

        public C0097a() {
        }

        @Override // p35.f
        public final void a(boolean r1, int r2) {
            a.f();
        }
    }

    public static final class b implements tb5.f.a {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // tb5.f.a
        public final void a() {
            a.f();
        }
    }

    public static final class c implements Runnable {
        public static final c a = null;

        static {
            a = new c();
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
            a.e = true;     // Catch: Throwable -> L8
            e.d = true;     // Catch: Throwable -> L8
            WebViewRenderProcess r0 = new LarkWebView(eu5.b.a, null, 6).getWebViewRenderProcess();     // Catch: Throwable -> L8
            if (r0 == null) goto L15;
            r0.terminate();     // Catch: Throwable -> L8
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
            tt5.a.h("JsThreadChecker", "sPreloadHtmlFailedCount is " + a.b + ", sOvertime100Count is " + a.c + ", sCancel100Count is " + a.d);
            Iterator<T> r1 = a.a.getConditions().iterator();
        L4:
            if (r1.hasNext() == false) goto L15;
            JsThreadCheckConfig.Condition r2 = (JsThreadCheckConfig.Condition) r1.next();
            if (a.b < r2.preloadHtmlFailedCount) goto L4;
            if (a.c < r2.overtime100Count) goto L4;
            if (a.d < r2.cancel100Count) goto L4;
            if (TextUtils.isEmpty(d25.d.d) == false) goto L13;
            a.i = true;
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
        b = 0;
        c = 0;
        d = 0;
        i = false;
    }

    static {
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        JsThreadCheckConfig r1 = (JsThreadCheckConfig) r0.c("ccm_check_js_thread_was_blocked_config", JsThreadCheckConfig.class, new JsThreadCheckConfig());
        a = r1;
        h = new d();
        boolean r2 = r0.g("ccm.docs.kill_render_process_when_js_blocked");
        j = r2;
        if (r2 == false) goto L6;
        e.a(C0097a.a);
        tb5.f.a = b.a;
        tt5.a.h("JsThreadChecker", r1.toString());
        return;
    }

    public static void a() {
        tt5.a.h("JsThreadChecker", "checkJsThread....");
        if (j == true) goto L6;
        tt5.a.h("JsThreadChecker", "checkEnable is false");
        return;
    L6:
        JsThreadCheckConfig r1 = a;
        if (r1.isEnableCheckWhenLoadFailed() == true) goto L11;
        tt5.a.h("JsThreadChecker", "isEnableCheckWhenLoadFailed is false");
        return;
    L11:
        if (b < 3) goto L13;
        tt5.a.h("JsThreadChecker", "sPreloadHtmlFailedCount more than 3");
        i = true;
        return;
    L13:
        tt5.a.h("JsThreadChecker", "sPreloadHtmlFailedCount is " + b + ", sOvertime100Count is " + c + ", sCancel100Count is " + d);
        Iterator<T> r2 = r1.getConditions().iterator();
    L15:
        if (r2.hasNext() == false) goto L55;
        JsThreadCheckConfig.Condition r3 = (JsThreadCheckConfig.Condition) r2.next();
        if (b < r3.preloadHtmlFailedCount) goto L15;
        if (c < r3.overtime100Count) goto L15;
        if (d < r3.cancel100Count) goto L15;
        JsThreadCheckConfig r4 = a;
        long r5 = r4.getCheckTimeout();
        tt5.a.h("JsThreadChecker", "realCheckJsThread....");
        if (f >= r4.getMaxKillTims()) goto L24;
        if (eu5.b.a == null) goto L27;
        d r6 = h;
        if (j.a(r6) == true) goto L30;
        e();
        g = new LarkWebView(eu5.b.a, null, 6);
        j.e(r6);
        j.d(r6, r5);
        LarkWebView r7 = g;
        if (r7 == null) goto L15;
        r7.evaluateJavascript("(function(){return 'onReceive';})()", com.bytedance.ee.bear.document.reloadwebview.b.a);
        goto L15
    L30:
        tt5.a.h("JsThreadChecker", "we are checking already");
        goto L15
    L27:
        tt5.a.h("JsThreadChecker", "context is null");
        goto L15
    L24:
        tt5.a.h("JsThreadChecker", "realCheckJsThread... killTimes is " + f);
        goto L15
    }

    @JvmStatic
    public static final void b() {
        long r0 = f + 1;
        JsThreadCheckConfig r2 = a;
        if (r0 <= r2.getMaxKillTims()) goto L7;
        tt5.a.h("JsThreadChecker", "killTimes is " + f + " maxKillTimes is " + r2.getMaxKillTims());
        return;
    L7:
        if (j == true) goto L11;
        tt5.a.h("JsThreadChecker", "checkEnable is false");
        return;
    L11:
        if (eu5.b.a == null) goto L13;
        f();
        Lazy r1 = TTWebViewUtil.a;
        TTWebViewUtil.a.d(null);
        j.f(c.a);
        f++;
        tt5.a.h("JsThreadChecker", "killSandBoxProcesses");
        return;
    L13:
        tt5.a.h("JsThreadChecker", "context is null");
    }

    @JvmStatic
    public static final void c() {
        tt5.a.h("JsThreadChecker", "openDocCancel100....");
        d++;
        if (i == true) goto L5;
    L7:
        a();
        return;
    L5:
        if (eu5.b.a == null) goto L7;
        tt5.a.h("JsThreadChecker", "kill when cancel 100");
        e.e(true);
        b();
    }

    @JvmStatic
    public static final void d() {
        tt5.a.h("JsThreadChecker", "openDocOvertime100....");
        c++;
        if (i == true) goto L5;
    L7:
        a();
        return;
    L5:
        if (eu5.b.a == null) goto L7;
        tt5.a.h("JsThreadChecker", "kill when overtime 100");
        e.e(true);
        b();
    }

    public static void e() {
        tt5.a.h("JsThreadChecker", "releaseWebview");
        LarkWebView r0 = g;
        if (r0 == null) goto L5;
        r0.destroy();
    L5:
        g = null;
    }
}
