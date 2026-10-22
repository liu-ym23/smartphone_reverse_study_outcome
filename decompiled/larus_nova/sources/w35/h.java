package w35;

import android.os.Build;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.bytedance.ee.bear.document.s1;
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

/* JADX INFO: loaded from: classes16.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f558159a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static w35.a f558160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static j f558161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final com.bytedance.ee.bear.contract.d f558162d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f558163e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g f558164f = null;

    public static final class a implements p35.f {
        public a() {
        }

        @Override // p35.f
        public final void a(boolean r100, int r101) {
            tt5.a.h("SSR_REN_SsrWebViewManager", "preloadSSRWebView because of RenderProcessGone");
            h r102 = h.f558159a;
            h.f558163e = true;
            h.f558159a.b();
        }
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<T, R> f558165a = null;

        static {
            f558165a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Intrinsics.checkNotNullParameter((String) r100, "it");
            w35.a r101 = h.f558160b;     // Catch: Exception -> L7
            if (r101 == null) goto L9;
            r101.destroy();     // Catch: Exception -> L7
        L9:
            w35.a r102 = new w35.a(LarkContext.getApplication());
            h.f558160b = r102;
            r102.addOnAttachStateChangeListener(new w35.g());
            w35.a r103 = h.f558160b;
            if (r103 == null) goto L13;
            h.f558161c = new j(r103);
        L13:
            return h.f558160b;
        L7:
            e = move-exception;
            tt5.a.l("SSR_REN_SsrWebViewManager", "destroy ssrwebview failed", e);
            goto L9
        }
    }

    public static final class c<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<T, R> f558166a = null;

        static {
            f558166a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            w35.a r101 = (w35.a) r100;
            if (r101 == null) goto L5;
            r101.B.f558156a.a();
        L5:
            h r102 = h.f558159a;
            t45.c r103 = (t45.c) k.a(LarkContext.getApplication(), t45.c.class);
            if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.ark_domain") == false) goto L8;
            String r104 = r103.f9();
        L9:
            String r105 = "https://" + r104 + r103.Mc();
            if (DocOpenConfig.g() == true) goto L12;
        L14:
            tt5.a.h("SSR_REN_SsrWebViewManager", "getPreloadUrl: url = " + r105);
            return r105;
        L12:
            if (Build.VERSION.SDK_INT >= 24) goto L14;
            r105 = "http://" + r104 + r103.Mc();
            goto L14
        L8:
            r104 = p.f540583t;
            goto L9
        }
    }

    public static final class d<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d<T, R> f558167a = null;

        static {
            f558167a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            String r101 = (String) r100;
            Intrinsics.checkNotNullParameter(r101, "url");
            w35.a r102 = h.f558160b;
            if (r102 == null) goto L6;
            r102.loadUrl(r101);
        L6:
            return Boolean.TRUE;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e<T> f558168a = null;

        static {
            f558168a = new e();
        }

        public e() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
            tt5.a.h("SSR_REN_SsrWebViewManager", "preload ssr webview success");
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f<T> f558169a = null;

        static {
            f558169a = new f();
        }

        public f() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.j("SSR_REN_SsrWebViewManager", (Throwable) r100);
        }
    }

    public static final class g implements Runnable {
        public g() {
        }

        public static void a() {
            w35.a r100 = h.f558160b;
            boolean r101 = false;
            if (r100 == null) goto L10;
            Map<String, Boolean> r102 = r100.A;
            HashMap r103 = (HashMap) r102;
            Boolean r104 = (Boolean) r103.get(sbb.e.f541304o.getType());
            if (r104 == null) goto L7;
            boolean r105 = r104.booleanValue();
        L8:
            if (r105 != true) goto L10;
            r101 = true;
            goto L10
        L7:
            r105 = false;
        L10:
            if (r101 == true) goto L13;
            tt5.a.k("SSR_REN_SsrWebViewManager", "preload ssrwebview timeout");
            HashMap r106 = new HashMap();
            r106.put("file_type", "ssrwebview");
            com.bytedance.ee.bear.contract.d r107 = h.f558162d;
            int r108 = s1.c.f221497a;
            r107.v("dev_performance_doc_template_preload", r106);
            h.f558163e = true;
            h.f558159a.b();
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
        if (f558163e == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        w35.a r100 = f558160b;     // Catch: Throwable -> L20
        if (r100 == null) goto L12;
        boolean r101 = true;
        if (r100.isAttachedToWindow() != true) goto L12;
    L13:
        if (r101 == false) goto L17;
        tt5.a.h("SSR_REN_SsrWebViewManager", "SsrWebview was attached to window");     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L17:
        g r102 = f558164f;     // Catch: Throwable -> L20
        com.bytedance.ee.util.ui.j.e(r102);     // Catch: Throwable -> L20
        f558163e = false;     // Catch: Throwable -> L20
        tt5.a.h("SSR_REN_SsrWebViewManager", "preloadSSRWebView()... ");     // Catch: Throwable -> L20
        Flowable.just("").observeOn(fo5.d.d()).map(b.f558165a).observeOn(fo5.d.b()).map(c.f558166a).observeOn(fo5.d.d()).map(d.f558167a).subscribe(e.f558168a, f.f558169a);     // Catch: Throwable -> L20
        com.bytedance.ee.util.ui.j.d(r102, DocOpenConfig.f().preload_ssr_template_timeout);     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L12:
        r101 = false;
        goto L13
    }

    static {
        f558159a = new h();
        f558162d = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        f558163e = true;
        f558164f = new g();
    }

    @JvmStatic
    public static final void a() {
        if (com.bytedance.ee.bear.document.ssrrender.b.a() == true) goto L6;
        tt5.a.h("SSR_REN_SsrWebViewManager", "SsrWebView enable is false");
        return;
    L6:
        p35.e.a(new a());
        f558163e = true;
        f558159a.b();
    }
}
