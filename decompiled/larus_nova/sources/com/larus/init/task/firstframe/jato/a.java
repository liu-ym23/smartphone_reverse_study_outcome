package com.larus.init.task.firstframe.jato;

import android.os.Build;
import android.os.Process;
import com.larus.apm.api.IApmTrace;
import com.larus.common.apphost.AppHost;
import com.larus.jato.api.IJato;
import com.larus.nova.NovaApplication;
import com.larus.settings.value.e10;
import com.larus.settings.value.hy;
import com.larus.settings.value.ly;
import com.larus.settings.value.vy;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import eg9.b;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import org.json.JSONObject;
import pt9.f;
import qt9.f4;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C4382a f351302e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile a f351303f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f351304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f351305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f351306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f351307d;

    /* JADX INFO: renamed from: com.larus.init.task.firstframe.jato.a$a, reason: collision with other inner class name */
    public static final class C4382a {
        public final a a() {
            a r100 = a.f351303f;
            if (r100 != null) goto L13;
            monitor-enter(this);
            r100 = a.f351303f;     // Catch: Throwable -> L10
            if (r100 != null) goto L8;
            r100 = new a();     // Catch: Throwable -> L10
            a.f351303f = r100;     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
        L10:
            th = move-exception;
            throw th;
        L13:
            return r100;
        }

        public C4382a() {
        }
    }

    static {
        f351302e = new C4382a();
    }

    public static void b() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 <= 30) goto L5;
        return;
    L5:
        if (r100 < 28) goto L19;
        e10 r101 = e10.f368561a;
        int r102 = l0.f375430a;
        boolean r103 = ((Boolean) l0.a(Boolean.FALSE, new ly())).booleanValue();
        FLogger r104 = FLogger.f375446a;
        r104.i("JatoOptHelper", "enableGpuResourceCleanup: " + r103);
        if (r103 == true) goto L16;
        r104.e("JatoOptHelper", "enableGpuResourceCleanup DISABLED!");
        return;
    L16:
        r104.i("JatoOptHelper", "enableGpuResourceCleanup start");     // Catch: Throwable -> L13
        IJato.f351658a.enableGpuResourceCleanup();     // Catch: Throwable -> L13
        r104.i("JatoOptHelper", "enableGpuResourceCleanup finish");     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        g("enableGpuResourceCleanup");
        FLogger.f375446a.e("JatoOptHelper", "enableGpuResourceCleanup had an error !!! ", th);
        return;
    }

    public static boolean c() {
        AppHost.Companion r100 = AppHost.f326268a;
        if (r100.isDebug() == false) goto L5;
    L8:
        return true;
    L5:
        if (r100.isTestChannel() == true) goto L8;
        return false;
    }

    public static void d() {
        if (Build.VERSION.SDK_INT >= 29) goto L6;
        return;
    L6:
        if (c() == false) goto L9;
        return;
    L9:
        if (Process.is64Bit() == true) goto L11;
        return;
    L11:
        e10 r100 = e10.f368561a;
        int r101 = l0.f375430a;
        boolean r102 = ((Boolean) l0.a(Boolean.FALSE, new vy())).booleanValue();
        FLogger r103 = FLogger.f375446a;
        r103.i("JatoOptHelper", "enableJITCodeCacheOpt: " + r102);
        if (r102 == true) goto L20;
        r103.e("JatoOptHelper", "jitCodeCacheExpandOpt DISABLED!");
        return;
    L20:
        r103.i("JatoOptHelper", "jitCodeCacheExpandOpt start");     // Catch: Throwable -> L17
        IJato.f351658a.enableJITCodeCacheOpt();     // Catch: Throwable -> L17
        r103.i("JatoOptHelper", "jitCodeCacheExpandOpt finish");     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        g("jitCodeCacheExpandOpt");
        FLogger.f375446a.e("JatoOptHelper", "jitCodeCacheExpandOpt had an error !!! ", th);
    }

    public static void h() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 >= 26) goto L5;
        return;
    L5:
        if (r100 <= 34) goto L8;
        return;
    L8:
        if (c() == false) goto L11;
        return;
    L11:
        if (Process.is64Bit() == true) goto L13;
        return;
    L13:
        e10 r101 = e10.f368561a;
        f4 r102 = (f4) l0.a(new f4(0), new hy());
        FLogger r103 = FLogger.f375446a;
        r103.i("JatoOptHelper", "softRefLruOptConfig: " + r102);
        if (r102.a() == true) goto L16;
    L25:
        r103.e("JatoOptHelper", "softRefLruOptConfig DISABLED!");
        return;
    L16:
        if (r102.c() <= 0) goto L25;
        if (r102.b() <= 0) goto L25;
        r103.i("JatoOptHelper", "softRefLruOpt start");     // Catch: Throwable -> L22
        IJato.f351658a.f(r102.c(), r102.b());     // Catch: Throwable -> L22
        r103.i("JatoOptHelper", "softRefLruOpt finish");     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        g("softRefLruOpt");
        FLogger.f375446a.e("JatoOptHelper", "softRefLruOpt had an error !!! ", th);
    }

    public final void a() {
        f r100 = ((pt9.a) this.f351305b.getValue()).b();
        if (r100 == null) goto L5;
        long r101 = r100.b();
    L7:
        if (r101 > 0) goto L9;
        return;
    L9:
        e("cpu boost and gpu boost");
        this.f351306c.compareAndSet(false, true);
        IJato r102 = (IJato) ServiceManager.get().getService(IJato.class);
        if (r102 == null) goto L12;
        NovaApplication r103 = NovaApplication.f360303e;
        r102.v(NovaApplication.a.a());
    L12:
        IJato r104 = (IJato) ServiceManager.get().getService(IJato.class);
        if (r104 == null) goto L16;
        r104.n(r101);
        return;
    L16:
        return;
    L5:
        r101 = 0;
        goto L7
    }

    public final void i() {
        StringBuilder r100 = new StringBuilder("call suppressGC(),block duration ");
        f r101 = ((pt9.a) this.f351305b.getValue()).b();
        if (r101 == null) goto L5;
        Long r102 = Long.valueOf(r101.a());
    L6:
        r100.append(r102);
        e(r100.toString());
        if (c() == false) goto L9;
        return;
    L9:
        IJato r103 = (IJato) ServiceManager.get().getService(IJato.class);
        if (r103 == null) goto L17;
        f r104 = ((pt9.a) this.f351305b.getValue()).b();
        if (r104 == null) goto L14;
        long r105 = r104.a();
    L15:
        r103.b(r105);
        return;
    L14:
        r105 = 2000;
        goto L15
    L17:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public a() {
        this.f351305b = LazyKt.lazy(new b());
        this.f351306c = new AtomicBoolean(false);
        this.f351307d = new AtomicBoolean(false);
    }

    public static void f() {
        e("removeHiddenApiFunction");
        int r100 = Build.VERSION.SDK_INT;
        if (r100 > 30) goto L5;
    L17:
        e("removeHiddenApiFunction Android version not fix ,current version is : " + r100 + "  (12<=version<14)");
        return;
    L5:
        if (r100 > 33) goto L17;
        if (c() == false) goto L19;
        return;
    L19:
        IJato r101 = (IJato) ServiceManager.get().getService(IJato.class);     // Catch: Throwable -> L14
        if (r101 == null) goto L21;
        r101.d();     // Catch: Throwable -> L14
        return;
    L21:
        return;
    L14:
        th = move-exception;
        FLogger.f375446a.e("JatoOptHelper", " removeHiddenApiFunction had an error !!! ", th);
    }

    public static void e(String r100) {
        if (AppHost.f326268a.isDebug() == false) goto L6;
        FLogger.f375446a.d("JatoOptHelper", "Jato opt message: " + r100);
        return;
    }

    public static void g(String r100) {
        IApmTrace.Companion r101 = IApmTrace.f286937a;     // Catch: Throwable -> L4
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L4
        r102.putOpt("jato_opt_type", r100);     // Catch: Throwable -> L4
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L4
        r101.f("jato_opt_fail_event", r102, null, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        FLogger.f375446a.e("JatoOptHelper", "reportJatoOptFail had an error!!! ", th);
    }
}
