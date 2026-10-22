package xl5;

import androidx.lifecycle.Observer;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.c0;
import com.bytedance.ee.bear.contract.n;
import com.bytedance.ee.bear.document.a4;
import com.bytedance.ee.bear.rn.RnSyncManager;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.util.ui.m;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements n.d {
    public boolean a;
    public final h b;
    public final g c;

    /* JADX INFO: renamed from: xl5.a$a, reason: collision with other inner class name */
    public static final class C0334a<T, R> implements Function {
        public static final C0334a<T, R> a = null;

        static {
            a = new C0334a();
        }

        public C0334a() {
        }

        public final Object apply(Object r3) {
            Intrinsics.checkNotNullParameter((String) r3, "it");
            return (c0) org.koin.java.a.c(c0.class, null, null, 6);
        }
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        public final Object apply(Object r3) {
            c0 r4 = (c0) r3;
            Intrinsics.checkNotNullParameter(r4, "listDataService");
            r4.q0(new xl5.b(this.a));
            return Boolean.TRUE;
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
            Boolean r3 = (Boolean) r2;
            tt5.a.h("KeepAliveService", "registerChangeCallback()...success");
        }
    }

    public static final class d<T> implements Consumer {
        public static final d<T> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            Intrinsics.checkNotNullParameter(r5, "throwable");
            tt5.a.e("KeepAliveService", "registerChangeCallback()...failed, throwable", r5, false);
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ a a;

        /* JADX INFO: renamed from: xl5.a$e$a, reason: collision with other inner class name */
        public static final class C0335a<T> implements Observer {
            public final /* synthetic */ a a;

            public C0335a(a r1) {
                this.a = r1;
            }

            public final void onChanged(Object r3) {
                Boolean r4 = (Boolean) r3;
                if (r4 != null) goto L5;
            L10:
                tt5.a.h("KeepAliveService", "mForegroundLiveData   : " + r4 + "    , isConnect : " + RnSyncManager.v);
                return;
            L5:
                if (RnSyncManager.v == false) goto L10;
                if (r4.booleanValue() == false) goto L9;
                this.a.c();
                goto L10
            L9:
                this.a.b();
                goto L10
            }
        }

        public e(a r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ((com.bytedance.ee.bear.contract.f) org.koin.java.a.c(com.bytedance.ee.bear.contract.f.class, null, null, 6)).e().observeForever(new C0335a(this.a));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f {
    }

    public static final class g implements Runnable {
        public final /* synthetic */ a a;

        public g(a r1) {
            this.a = r1;
        }

        public final void a() {
            a r0 = this.a;
            if (r0.a == true) goto L5;
            r0.b();
            RnSyncManager r1 = RnSyncManager.a;
            RnSyncManager.i();
        L6:
            boolean r2 = this.a.a;
            HashMap r3 = new HashMap();
            if (r2 == false) goto L9;
            String r4 = "1";
        L10:
            r3.put("webview_open_state", r4);
            r3.put("scm_version", ((a4) org.koin.java.a.c(a4.class, null, null, 6)).d());
            int r5 = unb.a.a;
            r3.put("runtime", "vmsdk");
            ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).v("docs_rn_out_of_contact", r3);
            tt5.a.h("KeepAliveService", "aliveTimeOutRunnable isFileOpen : " + this.a.a);
            return;
        L9:
            r4 = "0";
            goto L10
        L5:
            r0.c();
            goto L6
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

    public static final class h implements Runnable {
        public final /* synthetic */ a a;

        public h(a r1) {
            this.a = r1;
        }

        public final void a() {
            m.b(this.a.c, 15000);
            JSONObject r1 = new JSONObject();     // Catch: Exception -> L5
            r1.put("business", "base");     // Catch: Exception -> L5
            JSONObject r2 = new JSONObject();     // Catch: Exception -> L5
            r2.put(WikiFolderPushPlugin.OPT, "processRunning");     // Catch: Exception -> L5
            r1.put(WikiFolderPushPlugin.DATA, r2);     // Catch: Exception -> L5
            RnSyncManager.k(r1.toJSONString());     // Catch: Exception -> L5
        L7:
            tt5.a.h("KeepAliveService", "keepAliveRunnable");
            return;
        L5:
            e = move-exception;
            tt5.a.f("KeepAliveService", e, false);
            goto L7
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

    public final void b() {
        tt5.a.h("KeepAliveService", "reset");
        m.e(this.b);
        m.e(this.c);
    }

    public a() {
        Flowable.just("").subscribeOn(fo5.d.b()).map(C0334a.a).map(new b(this)).subscribe(c.a, d.a);
        m.a(new e(this));
        this.b = new h(this);
        this.c = new g(this);
    }

    public final void c() {
        b();
        m.b(this.b, 60000);
        tt5.a.h("KeepAliveService", "restartAliveTask");
    }

    public final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, WikiFolderPushPlugin.DATA);
    L7:
        e = move-exception;
        tt5.a.f("KeepAliveService", e, false);
        return;
    L4:
        if (Intrinsics.areEqual("confirmProcessRunning", JSON.parseObject(r3).getString("action")) == false) goto L12;
        tt5.a.h("KeepAliveService", "handle()... ");     // Catch: Exception -> L7
        c();     // Catch: Exception -> L7
        return;
    }
}
