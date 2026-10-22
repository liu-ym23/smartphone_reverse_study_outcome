package com.huawei.hms.framework.network.grs.g;

import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ExecutorService f277237b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, com.huawei.hms.framework.network.grs.g.j.b> f277238c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f277239d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.e.a f277240a;

    public class a implements Callable<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.huawei.hms.framework.network.grs.g.j.c f277241a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f277242b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.huawei.hms.framework.network.grs.e.c f277243c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ g f277244d;

        public a(g r100, com.huawei.hms.framework.network.grs.g.j.c r101, String r102, com.huawei.hms.framework.network.grs.e.c r103) {
            this.f277244d = r100;
            this.f277241a = r101;
            this.f277242b = r102;
            this.f277243c = r103;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public d call() {
            return new c(this.f277241a, g.a(this.f277244d)).a(g.a(), this.f277242b, this.f277243c);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ d call() {
            return call();
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.huawei.hms.framework.network.grs.g.j.c f277245a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f277246b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.huawei.hms.framework.network.grs.e.c f277247c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f277248d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.huawei.hms.framework.network.grs.b f277249e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ g f277250f;

        public b(g r100, com.huawei.hms.framework.network.grs.g.j.c r101, String r102, com.huawei.hms.framework.network.grs.e.c r103, int r104, com.huawei.hms.framework.network.grs.b r105) {
            this.f277250f = r100;
            this.f277245a = r101;
            this.f277246b = r102;
            this.f277247c = r103;
            this.f277248d = r104;
            this.f277249e = r105;
        }

        public void com_huawei_hms_framework_network_grs_g_g$b__run$___twin___() {
            g r100 = this.f277250f;
            g.a(r100, r100.a(this.f277245a, this.f277246b, this.f277247c, this.f277248d), this.f277249e);
        }

        @Override // java.lang.Runnable
        public void run() {
            com_huawei_hms_framework_network_grs_g_g$b_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_huawei_hms_framework_network_grs_g_g$b_com_larus_apm_impl_protector_RunnableLancet_run(b r100) {
            r100.com_huawei_hms_framework_network_grs_g_g$b__run$___twin___();     // Catch: Throwable -> L4
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
        f277237b = ExecutorsUtils.newCachedThreadPool("GrsReqPool");
        f277238c = new ConcurrentHashMap(16);
        f277239d = new Object();
    }

    public g() {
    }

    public static /* synthetic */ com.huawei.hms.framework.network.grs.e.a a(g r100) {
        return r100.f277240a;
    }

    public static /* synthetic */ ExecutorService a() {
        return f277237b;
    }

    private void a(d r100, com.huawei.hms.framework.network.grs.b r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r100 != null) goto L6;
        Logger.v("RequestController", "GrsResponse is null");
        r101.a();
        return;
    L6:
        Logger.v("RequestController", "GrsResponse is not null");
        r101.a(r100);
    }

    public static /* synthetic */ void a(g r100, d r101, com.huawei.hms.framework.network.grs.b r102) {
        r100.a(r101, r102);
    }

    public d a(com.huawei.hms.framework.network.grs.g.j.c r100, String r110, com.huawei.hms.framework.network.grs.e.c r111, int r112) {
        Logger.d("RequestController", "request to server with service name is: " + r110);
        String r101 = r100.b().getGrsParasKey(true, true, r100.a());
        Logger.v("RequestController", "request spUrlKey: " + r101);
        Object r102 = f277239d;
        monitor-enter(r102);
    L44:
        th = move-exception;
        throw th;
    L5:
        if (NetworkUtil.isNetworkAvailable(r100.a()) == true) goto L8;
        monitor-exit(r102);     // Catch: Throwable -> L44
        return null;
    L8:
        com.huawei.hms.framework.network.grs.h.d.a r103 = com.huawei.hms.framework.network.grs.h.d.a(r101);     // Catch: Throwable -> L44
        Map<String, com.huawei.hms.framework.network.grs.g.j.b> r104 = f277238c;     // Catch: Throwable -> L44
        com.huawei.hms.framework.network.grs.g.j.b r105 = r104.get(r101);     // Catch: Throwable -> L44
        if (r105 != null) goto L11;
    L14:
        if (r103 != null) goto L16;
    L20:
        Logger.d("RequestController", "hitGrsRequestBean == null or request block is released.");     // Catch: Throwable -> L44
        Future<d> r113 = f277237b.submit(new a(this, r100, r110, r111));     // Catch: Throwable -> L44
        r104.put(r101, new com.huawei.hms.framework.network.grs.g.j.b(r113));     // Catch: Throwable -> L44
    L21:
        monitor-exit(r102);     // Catch: Throwable -> L44
        if (r112 != (-1)) goto L29;
        com.huawei.hms.framework.network.grs.g.j.d r106 = com.huawei.hms.framework.network.grs.g.i.a.a(r100.a());
        if (r106 == null) goto L28;
        r112 = r106.c();
        goto L29
    L28:
        r112 = 10;
    L29:
        Logger.i("RequestController", "use grsQueryTimeout %d", new Object[]{Integer.valueOf(r112)});
        return r113.get(r112, TimeUnit.SECONDS);
    L36:
        e = e;
        String r114 = "RequestController";
        String r115 = "when check result, find InterruptedException, check others";
    L42:
        Logger.w(r114, r115, e);
        return null;
    L40:
        e = e;
        r114 = "RequestController";
        r115 = "when check result, find CancellationException, check others";
    L38:
        e = e;
        r114 = "RequestController";
        r115 = "when check result, find ExecutionException, check others";
    L34:
        e = e;
        r114 = "RequestController";
        r115 = "when check result, find TimeoutException, check others";
    L32:
        e = e;
        r114 = "RequestController";
        r115 = "when check result, find Other Exception, check others";
        goto L42
    L16:
        if (r103.a() == false) goto L20;
        monitor-exit(r102);     // Catch: Throwable -> L44
        return null;
    L11:
        if (r105.b() == false) goto L14;
        r113 = r105.a();     // Catch: Throwable -> L44
        goto L21
    }

    public void a(com.huawei.hms.framework.network.grs.e.a r100) {
        this.f277240a = r100;
    }

    public void a(com.huawei.hms.framework.network.grs.g.j.c r110, com.huawei.hms.framework.network.grs.b r111, String r112, com.huawei.hms.framework.network.grs.e.c r113, int r114) {
        f277237b.execute(new b(this, r110, r112, r113, r114, r111));
    }

    public void a(String r100) {
        Object r101 = f277239d;
        monitor-enter(r101);
        f277238c.remove(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
