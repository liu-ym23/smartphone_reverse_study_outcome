package com.bytedance.bdinstall;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class p0 implements g84.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicBoolean f199755g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile boolean f199756h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile o0 f199757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile i0 f199758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile b84.q f199759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile k74.c f199760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f199761e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final y f199762f;

    public class a implements u74.b {
        public a() {
        }
    }

    public class b implements u74.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o0 f199763a;

        public b(o0 r100) {
            this.f199763a = r100;
        }
    }

    public class c implements u74.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o0 f199764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ p0 f199765b;

        public c(p0 r100, o0 r101) {
            this.f199765b = r100;
            this.f199764a = r101;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p0 f199766a;

        @Override // java.lang.Runnable
        public final void run() {
            p0.o(this.f199766a, false);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(p0 r100) {
            this.f199766a = r100;
        }
    }

    /* JADX INFO: loaded from: classes8.dex */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u f199767a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ p0 f199768b;

        public final void a() {
            this.f199768b.f199758b.c(this.f199767a, false);
            b84.q r100 = this.f199768b.f199759c;
            r100.getClass();
            g84.a r101 = (g84.a) g84.e.a(g84.a.class, String.valueOf(r100.f18042f.f199728a));
            if (r101 == null) goto L5;
            r101.clearAll();
        L5:
            n.a(r100.f18041e, r100.f18042f);
            i84.n r102 = i84.o.f488630a;
            i84.o.f488630a = new i84.n();
            b84.q r103 = this.f199768b.f199759c;
            r103.g();
            k74.c r104 = r103.f18050n;
            if (r104 == null) goto L8;
            r104.a(new l74.a(r103.f18045i));
        L8:
            r103.j();
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

        public e(p0 r100, u r101) {
            this.f199768b = r100;
            this.f199767a = r101;
        }
    }

    /* JADX INFO: loaded from: classes8.dex */
    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u f199769a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ p0 f199770b;

        public final void a() {
            if (this.f199770b.f199761e.get() == false) goto L5;
            this.f199770b.f199758b.d(this.f199769a, false, true);
            return;
        L5:
            t.a("not start yet,start it " + this.f199769a);
            this.f199770b.f199758b.c(this.f199769a, true);
            p0.o(this.f199770b, true);
            this.f199770b.q();
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

        public f(p0 r100, u r101) {
            this.f199770b = r100;
            this.f199769a = r101;
        }
    }

    /* JADX INFO: loaded from: classes8.dex */
    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p0 f199771a;

        public final void a() {
            i0 r100 = this.f199771a.f199758b;
            if (r100 == null) goto L10;
            t.a("dispatcher#activeManually");
            long r101 = System.currentTimeMillis();
            if ((r101 - r100.f199662i) >= 900000) goto L7;
            return;
        L7:
            if (i84.j.a(r100.f199654a.getContext()) == false) goto L14;
            r100.f199662i = r101;
            r100.b(new com.bytedance.bdinstall.c(r100.f199654a, r100.f199658e));
            return;
        L14:
            return;
        L10:
            t.e(new RuntimeException("active failed"));
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

        public g(p0 r100) {
            this.f199771a = r100;
        }
    }

    /* JADX INFO: loaded from: classes8.dex */
    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Account f199772a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ p0 f199773b;

        public final void a() {
            if (this.f199773b.f199757a == null) goto L5;
            o0 r100 = this.f199773b.f199757a;
            r100.f199752y = this.f199772a;
        L5:
            g84.a r101 = (g84.a) g84.e.a(g84.a.class, String.valueOf(this.f199773b.f199757a.f199728a));
            if (r101 == null) goto L9;
            r101.b(this.f199772a);
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

        public h(p0 r100, Account r101) {
            this.f199773b = r100;
            this.f199772a = r101;
        }
    }

    @Override // g84.b
    public final void l(n0 r100) {
    }

    static {
        f199755g = new AtomicBoolean(false);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class n() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.bdinstall.nu.NUModeServiceImpl");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.bdinstall.nu.NUModeServiceImpl");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.bdinstall.nu.NUModeServiceImpl");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.bdinstall.nu.NUModeServiceImpl");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.bdinstall.nu.NUModeServiceImpl");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.bdinstall.nu.NUModeServiceImpl");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.bdinstall.nu.NUModeServiceImpl");
    }

    @Override // g84.b
    public final boolean e() {
        t.a("install#activeManually");
        if (this.f199758b == null) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
    L11:
        return false;
    L8:
        if (this.f199757a == null) goto L11;
        v.e(this.f199757a.a(), new g(this));
        return true;
    L5:
        r100 = false;
        goto L6
    }

    @Override // g84.b
    public final u f() {
        if (this.f199759c != null) goto L7;
        return null;
    L7:
        return this.f199759c.f18040d;
    }

    @Override // g84.b
    public final n0 g() {
        if (this.f199759c != null) goto L7;
        return null;
    L7:
        return this.f199759c.e();
    }

    @Override // g84.b
    public final String getDid() {
        if (this.f199759c != null) goto L7;
        return null;
    L7:
        return this.f199759c.d();
    }

    @Override // g84.b
    public final boolean k() {
        if (this.f199759c != null) goto L5;
        return false;
    L5:
        return this.f199759c.f18048l;
    }

    public final void q() {
        if (i84.a.a(this.f199757a.getContext(), this.f199757a).getBoolean("_install_started_v2", false) == true) goto L6;
        i84.a.a(this.f199757a.getContext(), this.f199757a).edit().putBoolean("_install_started_v2", true).apply();
        return;
    }

    @Override // g84.b
    public final void start() {
        if (this.f199758b == null) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L12;
        if (this.f199757a == null) goto L12;
        t.a("install#start aid : " + this.f199757a.f199728a);
        v.e(this.f199757a.a(), new d(this));
        q();
        return;
    L12:
        throw new RuntimeException("please init first");
    L5:
        r100 = false;
        goto L6
    }

    public p0(k r100) {
        this.f199761e = new AtomicBoolean(false);
        this.f199762f = r100;
    }

    @Override // g84.b
    public final void a(u r100) {
        t.a("install#changeUriRuntimeAndReInstall");
        if (this.f199758b != null) goto L5;
    L7:
        t.e(new RuntimeException("not init yet"));
        return;
    L5:
        if (this.f199757a == null) goto L7;
        t.a("changeUriRuntimeAndReInstall " + r100);
        v.e(this.f199757a.a(), new f(this, r100));
    }

    @Override // g84.b
    public final void b(Account r100) {
        if (this.f199757a != null) goto L5;
        return;
    L5:
        v.e(this.f199757a.a(), new h(this, r100));
    }

    @Override // g84.b
    public final void c(Map r100) {
        if (this.f199759c == null) goto L21;
        Iterator r101 = new ConcurrentHashMap(r100).entrySet().iterator();
    L5:
        boolean r102 = false;
    L7:
        if (r101.hasNext() == false) goto L12;
        Map.Entry r103 = (Map.Entry) r101.next();
        String r104 = (String) r103.getKey();
        Object r105 = r103.getValue();
        if (this.f199759c.l(r104, r105) == true) goto L11;
        if (r102 == false) goto L5;
    L11:
        r102 = true;
        goto L7
    L12:
        if (r102 == true) goto L14;
        return;
    L14:
        if (this.f199760d == null) goto L23;
        this.f199760d.a(new l74.a(this.f199759c.f18045i));
        return;
    L23:
        return;
    }

    @Override // g84.b
    public final boolean d(JSONObject r100) {
        if (this.f199759c == null) goto L11;
        b84.q r101 = this.f199759c;
        if (r101.f18047k == false) goto L7;
        JSONObject r102 = r101.f18045i;
    L8:
        if (r102 == null) goto L13;
        c1.e(r100, r102);
        return true;
    L13:
        return false;
    L7:
        r102 = null;
        goto L8
    L11:
        return false;
    }

    @Override // g84.b
    public final void i(u r100) {
        t.a("install#clearInstallInfoWhenSwitchChildMode");
        if (this.f199758b != null) goto L5;
    L9:
        t.e(new RuntimeException("not init yet"));
        return;
    L5:
        if (this.f199757a == null) goto L9;
        if (this.f199759c == null) goto L9;
        t.a("clearInstallInfoWhenSwitchChildMode " + r100);
        v.e(this.f199757a.a(), new e(this, r100));
    }

    public final void p(o0 r100) {
        if (n74.a.f518199a == false) goto L6;
        m74.a.f512332a = new a();
        t.a("[dt] DTRAIT开启，初始化并执行预加载逻辑......");
        n74.a.f518203e = new b(r100);
        n74.a.f518202d = new c(this, r100);
        r74.g r101 = new m74.c(r100.getContext(), f199756h).f512345a.f553480a.f512335c;
        r101.f536452q.post(new r74.d(r101));
        return;
    }

    public static void o(p0 r100, boolean r101) {
        if (r100.f199758b == null) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L36;
        if (r100.f199757a == null) goto L36;
        if (r100.f199761e.getAndSet(true) == true) goto L37;
        g84.c r103 = (g84.c) g84.e.a(g84.c.class, r100.f199757a.a());
        if (r103 == null) goto L15;
        r103.start();
    L15:
        r100.f199759c.k();
        i0 r104 = r100.f199758b;
        r104.e(r104.f199658e, r101);
        if (r104.f199654a.f199743p == false) goto L22;
        j0 r105 = new j0(r104);
        j74.b r106 = r104.f199657d;
        j74.a r107 = (j74.a) r106;
        r107.f497577d = new k0(r104, r105);
        if (r107.f497576c == false) goto L22;
        t.a("dispatcher#active isActive");
        r105.run();
    L22:
        if (n74.a.f518199a == false) goto L30;
        m74.c r108 = (m74.c) v74.e.a(m74.c.class);
        if (r108 == null) goto L30;
        v74.c r109 = r108.f512345a;
        b84.m r110 = r104.f199655b;
        if (r110.f18047k == false) goto L28;
        JSONObject r111 = r110.f18045i;
    L29:
        r109.getClass();
        System.currentTimeMillis();
        r74.g r112 = r109.f553480a.f512335c;
        r112.getClass();
        r74.e r113 = new r74.e(r112, r111);
        o74.a.f522260c.b(new Object[0]).execute(r113);
        goto L30
    L28:
        r111 = null;
    L30:
        v0 r114 = new v0(r100.f199757a.getContext());
        o0 r115 = r100.f199757a;
        r114.f199806b = r115;
        if (r115 == null) goto L38;
        String r116 = String.valueOf(r115.f199728a);
        j74.a r117 = i.f199651a;
        k.k(r116).c(true, r114);
        return;
    L38:
        return;
    L37:
        return;
    L36:
        throw new RuntimeException("please init first");
    L5:
        r102 = false;
        goto L6
    }

    @Override // g84.b
    public final void m(o0 r100, u r110) {
        long r101 = System.currentTimeMillis();
        t.a("main process install#init：aid: " + r100.f199728a);
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f199758b != null) goto L14;
        this.f199757a = r100;     // Catch: Throwable -> L12
        if (TextUtils.equals(r100.f199734g, "local_test") == true) goto L21;
    L11:
        this.f199759c = new b84.q(r100.getContext(), r100, r110);     // Catch: Throwable -> L12
        this.f199759c.f18050n = this.f199760d;     // Catch: Throwable -> L12
        b84.q r102 = this.f199759c;     // Catch: Throwable -> L12
        j74.a r103 = i.f199651a;     // Catch: Throwable -> L12
        this.f199758b = new i0(r100, r102, r110);     // Catch: Throwable -> L12
        this.f199758b.f199663j = this.f199760d;     // Catch: Throwable -> L12
        this.f199759c.getClass();     // Catch: Throwable -> L12
        g84.e.b(r.class, new s(r100, r110), String.valueOf(r100.f199728a));     // Catch: Throwable -> L12
        f199756h = r100.c().contains("device_id");     // Catch: Throwable -> L12
        p(r100);     // Catch: Throwable -> L12
        goto L14
    L21:
        g84.e.b(g84.c.class, (g84.c) n().getConstructor(new Class[]{o0.class}).newInstance(new Object[]{r100}), String.valueOf(r100.f199728a));     // Catch: Throwable -> L10
    L10:
        t.b("not find new user mode impl ,ignore");     // Catch: Throwable -> L12
    L14:
        monitor-exit(this);     // Catch: Throwable -> L12
        t.a("init ：" + (System.currentTimeMillis() - r101));
    }

    @Override // g84.b
    public final void h(Context r100, Map r101, boolean r102) {
        SharedPreferences.Editor r103 = i84.a.a(r100, this.f199757a).edit();
        boolean r104 = false;
        if (this.f199759c == null) goto L18;
        Iterator r105 = ((HashMap) r101).entrySet().iterator();
        boolean r106 = false;
    L6:
        if (r105.hasNext() == false) goto L15;
        Map.Entry r107 = (Map.Entry) r105.next();
        String r108 = (String) r107.getKey();
        String r109 = (String) r107.getValue();
        if (this.f199759c.l(r108, r109) == true) goto L12;
        if (r106 == true) goto L12;
        r106 = false;
    L13:
        if (r103 == null) goto L6;
        r103.putString(r108, r109);
    L12:
        r106 = true;
        goto L13
    L15:
        if (r103 == null) goto L17;
        r103.apply();
    L17:
        r104 = r106;
    L18:
        if (r104 == false) goto L25;
        if (r102 == false) goto L25;
        if (this.f199758b == null) goto L25;
        i0 r110 = this.f199758b;
        y0 r111 = r110.f199660g;
        if (r111 == null) goto L25;
        r110.g(r111, true);
    L25:
        if (r104 == true) goto L27;
        return;
    L27:
        if (this.f199760d == null) goto L36;
        this.f199760d.a(new l74.a(this.f199759c.f18045i));
        return;
    }

    @Override // g84.b
    public final void j(u r100, long r101, t0 r102) {
        t.a("install#resetInstallInfoWhenSwitchChildMode");
        if (this.f199758b == null) goto L7;
        t.a("resetInstallInfoWhenSwitchChildMode " + r100);
        i84.w r103 = new i84.w(r101, r102, this.f199757a);
        ((k) this.f199762f).c(false, r103);
        r103.f488646c.postDelayed(new i84.x(r103), r103.f488644a);
        if (this.f199757a == null) goto L9;
        v.e(this.f199757a.a(), new q0(this, r100));
        return;
    L9:
        return;
    L7:
        t.e(new RuntimeException("not init yet"));
    }
}
