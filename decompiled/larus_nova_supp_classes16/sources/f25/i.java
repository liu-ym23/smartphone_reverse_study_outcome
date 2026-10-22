package f25;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.bytedance.lark.lark_markdown_render_android.BuildConfig;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i {
    public static final int b = 0;
    public static volatile lr5.f c;
    public static volatile t d;
    public static volatile com.larksuite.framework.thread.p e;
    public final ConnectionService a;

    public static int a() {
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        Application r1 = eu5.b.a();
        r0.getClass();
        UserSession r2 = ((com.ss.android.lark.passportc.convention.a) e0c.k.a(r1, com.ss.android.lark.passportc.convention.a.class)).b();
        if (((dn4.a) e0c.k.b(((v) e0c.k.a(r1, v.class)).c(r2), dn4.a.class)).a().isCurrentEnable("ccm.mobile.max_requests_per_host") == false) goto L6;
        return 5;
    L6:
        return 64;
    }

    public final lr5.f b() {
        if (c != null) goto L37;
        monitor-enter(i.class);
    L33:
        th = move-exception;
        throw th;
    L7:
        if (c != null) goto L31;
        DocOpenConfig.a();     // Catch: Throwable -> L33
        int r4 = DocOpenConfig.g.fetch_core_pool_size;     // Catch: Throwable -> L33
        int r2 = b * 8;     // Catch: Throwable -> L33
        DocOpenConfig.a();     // Catch: Throwable -> L33
        int r5 = Math.max(r2, DocOpenConfig.g.fetch_max_pool_size);     // Catch: Throwable -> L33
        DocOpenConfig.a();     // Catch: Throwable -> L33
        boolean r10 = true;
        e = new com.larksuite.framework.thread.p("BEAR_FETCH", r4, r5, DocOpenConfig.g.fetch_keep_alive_time, new SynchronousQueue(), new com.larksuite.framework.thread.n("fetch", 1));     // Catch: Throwable -> L33
        okhttp3.h r3 = new nv4.a();     // Catch: Throwable -> L33
        nv4.b.a r6 = nv4.b.a;     // Catch: Throwable -> L33
        if (r6 == null) goto L11;
        r3 = r6.a();     // Catch: Throwable -> L33
    L11:
        d = new t(r3);     // Catch: Throwable -> L33
        Dispatcher r1 = new Dispatcher(e);     // Catch: Throwable -> L33
        r1.setMaxRequestsPerHost(a());     // Catch: Throwable -> L33
        lr5.a r7 = lr5.b.b().b();     // Catch: Throwable -> L33
        if (this.a.getNetworkState().getType() != 1) goto L14;
        boolean r8 = true;
    L15:
        int r9 = 10000;
        if (r8 == false) goto L18;
        int r11 = 10000;
    L19:
        long r12 = r11;
        TimeUnit r13 = TimeUnit.MILLISECONDS;     // Catch: Throwable -> L33
        r7.a.connectTimeout(r12, r13);     // Catch: Throwable -> L33
        if (this.a.getNetworkState().getType() == 1) goto L23;
        r10 = false;
    L23:
        if (r10 == true) goto L26;
        r9 = 20000;
    L26:
        r7.a.readTimeout(r9, r13);     // Catch: Throwable -> L33
        r7.a.dispatcher(r1);     // Catch: Throwable -> L33
        r7.a.cookieJar(d);     // Catch: Throwable -> L33
        boolean r14 = TextUtils.equals(BuildConfig.BUILD_TYPE, ((b0) org.koin.java.a.a(b0.class)).e());     // Catch: Throwable -> L33
        if (TextUtils.isEmpty(s45.p.a().getProxy()) == true) goto L30;
        if (r14 == true) goto L30;
        r7.a.addNetworkInterceptor(new h());     // Catch: Throwable -> L33
    L30:
        c = r7.a();     // Catch: Throwable -> L33
        goto L31
    L18:
        r11 = 20000;
        goto L19
    L14:
        r8 = false;
    L31:
        monitor-exit(i.class);     // Catch: Throwable -> L33
    L37:
        return c;
    }

    static {
        b = Runtime.getRuntime().availableProcessors();
    }

    public i(com.bytedance.ee.bear.contract.j r1) {
        this.a = r1;
    }
}
