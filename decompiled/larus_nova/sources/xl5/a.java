package xl5;

import androidx.lifecycle.Observer;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.ee.bear.contract.c0;
import com.bytedance.ee.bear.contract.n;
import com.bytedance.ee.bear.document.a4;
import com.bytedance.ee.bear.rn.RnSyncManager;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.util.ui.m;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxError;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements n.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f564500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f564501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f564502c;

    /* JADX INFO: renamed from: xl5.a$a, reason: collision with other inner class name */
    public static final class C8253a<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C8253a<T, R> f564503a = null;

        static {
            f564503a = new C8253a();
        }

        public C8253a() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Intrinsics.checkNotNullParameter((String) r100, "it");
            return (c0) org.koin.java.a.c(c0.class, null, null, 6);
        }
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f564504a;

        public b(a r100) {
            this.f564504a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            c0 r101 = (c0) r100;
            Intrinsics.checkNotNullParameter(r101, "listDataService");
            r101.q0(new xl5.b(this.f564504a));
            return Boolean.TRUE;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<T> f564505a = null;

        static {
            f564505a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
            tt5.a.h("KeepAliveService", "registerChangeCallback()...success");
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d<T> f564506a = null;

        static {
            f564506a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
            tt5.a.e("KeepAliveService", "registerChangeCallback()...failed, throwable", r101, false);
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f564507a;

        /* JADX INFO: renamed from: xl5.a$e$a, reason: collision with other inner class name */
        public static final class C8254a<T> implements Observer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f564508a;

            public C8254a(a r100) {
                this.f564508a = r100;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object r100) {
                Boolean r101 = (Boolean) r100;
                if (r101 != null) goto L5;
            L10:
                tt5.a.h("KeepAliveService", "mForegroundLiveData   : " + r101 + "    , isConnect : " + RnSyncManager.f236517v);
                return;
            L5:
                if (RnSyncManager.f236517v == false) goto L10;
                if (r101.booleanValue() == false) goto L9;
                this.f564508a.c();
                goto L10
            L9:
                this.f564508a.b();
                goto L10
            }
        }

        public e(a r100) {
            this.f564507a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ((com.bytedance.ee.bear.contract.f) org.koin.java.a.c(com.bytedance.ee.bear.contract.f.class, null, null, 6)).e().observeForever(new C8254a(this.f564507a));     // Catch: Throwable -> L4
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f564509a;

        public g(a r100) {
            this.f564509a = r100;
        }

        public final void a() {
            a r100 = this.f564509a;
            if (r100.f564500a == true) goto L5;
            r100.b();
            RnSyncManager r101 = RnSyncManager.f236496a;
            RnSyncManager.i();
        L6:
            boolean r102 = this.f564509a.f564500a;
            HashMap r103 = new HashMap();
            if (r102 == false) goto L9;
            String r104 = "1";
        L10:
            r103.put("webview_open_state", r104);
            r103.put("scm_version", ((a4) org.koin.java.a.c(a4.class, null, null, 6)).d());
            int r105 = unb.a.f550884a;
            r103.put("runtime", "vmsdk");
            ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).v("docs_rn_out_of_contact", r103);
            tt5.a.h("KeepAliveService", "aliveTimeOutRunnable isFileOpen : " + this.f564509a.f564500a);
            return;
        L9:
            r104 = "0";
            goto L10
        L5:
            r100.c();
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f564510a;

        public h(a r100) {
            this.f564510a = r100;
        }

        public final void a() {
            m.b(this.f564510a.f564502c, 15000);
            JSONObject r100 = new JSONObject();     // Catch: Exception -> L5
            r100.put("business", "base");     // Catch: Exception -> L5
            JSONObject r101 = new JSONObject();     // Catch: Exception -> L5
            r101.put(WikiFolderPushPlugin.OPT, "processRunning");     // Catch: Exception -> L5
            r100.put("data", r101);     // Catch: Exception -> L5
            RnSyncManager.k(r100.toJSONString());     // Catch: Exception -> L5
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
        tt5.a.h("KeepAliveService", BasicTestActionHandler.TEST_ACTION_RESET);
        m.e(this.f564501b);
        m.e(this.f564502c);
    }

    public a() {
        Flowable.just("").subscribeOn(fo5.d.b()).map(C8253a.f564503a).map(new b(this)).subscribe(c.f564505a, d.f564506a);
        m.a(new e(this));
        this.f564501b = new h(this);
        this.f564502c = new g(this);
    }

    public final void c() {
        b();
        m.b(this.f564501b, 60000);
        tt5.a.h("KeepAliveService", "restartAliveTask");
    }

    @Override // com.bytedance.ee.bear.contract.n.d
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    L7:
        e = move-exception;
        tt5.a.f("KeepAliveService", e, false);
        return;
    L4:
        if (Intrinsics.areEqual("confirmProcessRunning", JSON.parseObject(r100).getString("action")) == false) goto L12;
        tt5.a.h("KeepAliveService", "handle()... ");     // Catch: Exception -> L7
        c();     // Catch: Exception -> L7
        return;
    }
}
