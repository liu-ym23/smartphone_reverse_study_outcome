package u35;

import android.os.Build;
import android.os.Looper;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.bytedance.ee.bear.document.container.DocumentImpl;
import com.bytedance.ee.bear.document.render.node.perf.SendEventData;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleonv2.Chameleon;
import com.ss.android.lark.chameleonv2.container.webcontainer.util.RenderGoneHelper;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import s45.p;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final a a = null;
    public static ChameleonWebView b;
    public static u35.c c;
    public static final com.bytedance.ee.bear.contract.d d = null;
    public static volatile boolean e;
    public static final e f = null;

    /* JADX INFO: renamed from: u35.a$a, reason: collision with other inner class name */
    public interface InterfaceC0304a {
        void a();

        void b(SendEventData r1);
    }

    public static final class b implements k.a {
        public b() {
        }

        @Override // vv4.k.a
        public final void a(boolean r3, int r4) {
            StringBuilder r0 = new StringBuilder("onRenderProcessGone didCrash ");
            r0.append(r3);
            r0.append(" rendererPriority ");
            r0.append(r4);
            r0.append("   webView ");
            ChameleonWebView r5 = a.b;
            if (r5 == null) goto L5;
            Integer r6 = Integer.valueOf(r5.hashCode());
        L6:
            r0.append(r6);
            tt5.a.h("SSR_REN_SsrWebViewManager", r0.toString());
            CopyOnWriteArrayList r7 = RenderGoneHelper.a;
            Intrinsics.checkNotNullParameter(this, "cb");
            RenderGoneHelper.a.remove(this);
            a.b = null;
            a.e = true;
            return;
        L5:
            r6 = null;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {
        public static final c<T> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r2) {
            ChameleonConfig r3 = (ChameleonConfig) r2;
            a r0 = a.a;
            Intrinsics.checkNotNull(r3);
            a.a(r3);
        }
    }

    public static final class d<T> implements Consumer {
        public static final d<T> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r3) {
            tt5.a.f("SSR_REN_SsrWebViewManager", (Throwable) r3, false);
        }
    }

    public static final class e implements Runnable {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public static void a() {
            ChameleonWebView r0 = a.b;
            if (r0 == null) goto L9;
            v35.a r1 = (v35.a) r0.getWebService(v35.a.class);
            if (r1 == null) goto L9;
            String r2 = sbb.e.o.getType();
            Intrinsics.checkNotNullParameter(r2, "type");
            if (Intrinsics.areEqual(((HashMap) r1.b).get(r2), Boolean.TRUE) != true) goto L9;
            boolean r3 = true;
        L10:
            if (r3 == true) goto L13;
            tt5.a.k("SSR_REN_SsrWebViewManager", "preload ssrwebview timeout");
            HashMap r4 = new HashMap();
            r4.put("file_type", "ssrwebview");
            com.bytedance.ee.bear.contract.d r5 = a.d;
            int r6 = a05.c.C0000c.a;
            r5.v("dev_performance_doc_template_preload", r4);
            a.e = true;
            a.c(null);
            return;
        L13:
            return;
        L9:
            r3 = false;
            goto L10
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

    public a() {
    }

    static {
        a = new a();
        d = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        e = true;
        f = e.a;
    }

    public static void a(ChameleonConfig r2) {
        Chameleon.c(Chameleon.a, r2);
        ChameleonWebView r3 = ((v1b.a) e0c.k.a(LarkContext.getApplication(), v1b.a.class)).F2().f(r2, "docs_sdk_ssr_webview");
        b = r3;
        c = new u35.c(r3);
        CopyOnWriteArrayList r4 = RenderGoneHelper.a;
        b r5 = new b();
        Intrinsics.checkNotNullParameter(r5, "cb");
        RenderGoneHelper.a.add(r5);
        j.d(f, DocOpenConfig.f().preload_ssr_template_timeout);
    }

    public static String b(DocumentImpl.b r2) {
        Intrinsics.checkNotNullParameter(r2, "userComponent");
        String r3 = ((com.bytedance.ee.bear.document.template.a) r2.a(com.bytedance.ee.bear.document.template.a.class)).y0();
        if (DocOpenConfig.g() == true) goto L5;
    L7:
        String r0 = "https://";
    L8:
        String r4 = r0 + r3 + p.a().Mc();
        tt5.a.h("SSR_REN_SsrWebViewManager", "getPreloadUrl: url = " + r4);
        return r4;
    L5:
        if (Build.VERSION.SDK_INT >= 24) goto L7;
        r0 = "http://";
        goto L8
    }

    @JvmStatic
    public static final void c(ChameleonConfig r2) {
        if (e == true) goto L5;
        return;
    L5:
        e = false;
        j.e(f);
        if (r2 != null) goto L9;
        r2 = DocumentImpl.b(null);
    L9:
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L11;
        a(r2);
        return;
    L11:
        Flowable.just(r2).observeOn(fo5.d.d()).subscribe(c.a, d.a);
    }
}
