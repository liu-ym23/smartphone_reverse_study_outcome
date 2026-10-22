package w35;

import android.os.Build;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.bytedance.ee.bear.document.s1;
import com.bytedance.ee.larkwebview.base.LarkWebView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import s45.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h {
    public static final h a = null;
    public static w35.a b;
    public static j c;
    public static final com.bytedance.ee.bear.contract.d d = null;
    public static volatile boolean e;
    public static final g f = null;

    public static final class a implements p35.f {
        public a() {
        }

        @Override // p35.f
        public final void a(boolean r1, int r2) {
            tt5.a.h("SSR_REN_SsrWebViewManager", "preloadSSRWebView because of RenderProcessGone");
            h r3 = h.a;
            h.e = true;
            h.a.b();
        }
    }

    public static final class b<T, R> implements Function {
        public static final b<T, R> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        /* JADX WARN: Type inference failed for: r3v3, types: [android.webkit.WebView, w35.a] */
        public final Object apply(Object r3) {
            Intrinsics.checkNotNullParameter((String) r3, "it");
            w35.a r4 = h.b;     // Catch: Exception -> L7
            if (r4 == null) goto L9;
            r4.destroy();     // Catch: Exception -> L7
        L9:
            ?? r5 = new w35.a(LarkContext.getApplication());
            h.b = r5;
            r5.addOnAttachStateChangeListener(new w35.g());
            w35.a r6 = h.b;
            if (r6 == null) goto L13;
            h.c = new j(r6);
        L13:
            return h.b;
        L7:
            e = move-exception;
            tt5.a.l("SSR_REN_SsrWebViewManager", "destroy ssrwebview failed", e);
            goto L9
        }
    }

    public static final class c<T, R> implements Function {
        public static final c<T, R> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final Object apply(Object r5) {
            w35.a r6 = (w35.a) r5;
            if (r6 == null) goto L5;
            r6.B.a.a();
        L5:
            h r7 = h.a;
            t45.c r8 = (t45.c) k.a(LarkContext.getApplication(), t45.c.class);
            if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.ark_domain") == false) goto L8;
            String r0 = r8.f9();
        L9:
            String r1 = "https://" + r0 + r8.Mc();
            if (DocOpenConfig.g() == true) goto L12;
        L14:
            tt5.a.h("SSR_REN_SsrWebViewManager", "getPreloadUrl: url = " + r1);
            return r1;
        L12:
            if (Build.VERSION.SDK_INT >= 24) goto L14;
            r1 = "http://" + r0 + r8.Mc();
            goto L14
        L8:
            r0 = p.t;
            goto L9
        }
    }

    public static final class d<T, R> implements Function {
        public static final d<T, R> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final Object apply(Object r2) {
            String r3 = (String) r2;
            Intrinsics.checkNotNullParameter(r3, "url");
            w35.a r0 = h.b;
            if (r0 == null) goto L6;
            r0.loadUrl(r3);
        L6:
            return Boolean.TRUE;
        }
    }

    public static final class e<T> implements Consumer {
        public static final e<T> a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r2) {
            Boolean r3 = (Boolean) r2;
            tt5.a.h("SSR_REN_SsrWebViewManager", "preload ssr webview success");
        }
    }

    public static final class f<T> implements Consumer {
        public static final f<T> a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final void accept(Object r2) {
            tt5.a.j("SSR_REN_SsrWebViewManager", (Throwable) r2);
        }
    }

    public static final class g implements Runnable {
        public g() {
        }

        public static void a() {
            w35.a r0 = h.b;
            boolean r1 = false;
            if (r0 == null) goto L10;
            Map<String, Boolean> r2 = r0.A;
            HashMap r3 = (HashMap) r2;
            Boolean r4 = (Boolean) r3.get(sbb.e.o.getType());
            if (r4 == null) goto L7;
            boolean r5 = r4.booleanValue();
        L8:
            if (r5 != true) goto L10;
            r1 = true;
            goto L10
        L7:
            r5 = false;
        L10:
            if (r1 == true) goto L13;
            tt5.a.k("SSR_REN_SsrWebViewManager", "preload ssrwebview timeout");
            HashMap r6 = new HashMap();
            r6.put("file_type", "ssrwebview");
            com.bytedance.ee.bear.contract.d r7 = h.d;
            int r8 = s1.c.a;
            r7.v("dev_performance_doc_template_preload", r6);
            h.e = true;
            h.a.b();
            return;
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

    public h() {
    }

    public final synchronized void b() {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (e == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        LarkWebView r0 = b;     // Catch: Throwable -> L20
        if (r0 == null) goto L12;
        boolean r2 = true;
        if (r0.isAttachedToWindow() != true) goto L12;
    L13:
        if (r2 == false) goto L17;
        tt5.a.h("SSR_REN_SsrWebViewManager", "SsrWebview was attached to window");     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L17:
        g r1 = f;     // Catch: Throwable -> L20
        com.bytedance.ee.util.ui.j.e(r1);     // Catch: Throwable -> L20
        e = false;     // Catch: Throwable -> L20
        tt5.a.h("SSR_REN_SsrWebViewManager", "preloadSSRWebView()... ");     // Catch: Throwable -> L20
        Flowable.just("").observeOn(fo5.d.d()).map(b.a).observeOn(fo5.d.b()).map(c.a).observeOn(fo5.d.d()).map(d.a).subscribe(e.a, f.a);     // Catch: Throwable -> L20
        com.bytedance.ee.util.ui.j.d(r1, DocOpenConfig.f().preload_ssr_template_timeout);     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L12:
        r2 = false;
        goto L13
    }

    static {
        a = new h();
        d = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        e = true;
        f = new g();
    }

    @JvmStatic
    public static final void a() {
        if (com.bytedance.ee.bear.document.ssrrender.b.a() == true) goto L6;
        tt5.a.h("SSR_REN_SsrWebViewManager", "SsrWebView enable is false");
        return;
    L6:
        p35.e.a(new a());
        e = true;
        a.b();
    }
}
