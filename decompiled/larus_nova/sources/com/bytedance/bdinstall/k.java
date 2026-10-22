package com.bytedance.bdinstall;

import android.accounts.Account;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class k implements y {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Map<String, k> f199672m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final AtomicInteger f199673n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile o0 f199674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile g f199675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile a84.a f199676c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s0 f199677d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f199678e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f199679f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final j f199680g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f199681h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final f f199682i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i84.b f199683j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final k74.c f199684k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f199685l;

    public class a extends i84.g<g84.b> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k f199686b;

        public a(k r100) {
            this.f199686b = r100;
        }

        @Override // i84.g
        public final g84.b a(Object[] r100) {
            if (c1.g((Context) r100[0]) == false) goto L15;
            p0 r101 = new p0(this.f199686b);
            Context r102 = (Context) r100[0];
            if ((r102 instanceof Application) == true) goto L8;
            if (r102 == null) goto L8;
            r102 = r102.getApplicationContext();
        L8:
            Application r103 = (Application) r102;
            if (r103 != null) goto L12;
        L14:
            r101.f199760d = this.f199686b.f199684k;
            return r101;
        L12:
            if (p0.f199755g.compareAndSet(false, true) == false) goto L14;
            r103.registerActivityLifecycleCallbacks(i.f199651a);
            goto L14
        L15:
            w0 r104 = new w0(this.f199686b);
            r104.f199808b = this.f199686b.f199684k;
            return r104;
        }
    }

    public class b extends i84.r<n0> {
        public b() {
        }

        @Override // i84.r
        public final n0 a(Object[] r100) {
            String r101 = ((Context) r100[0]).getSharedPreferences("ug_install_op_pref", 0).getString("install_info", null);     // Catch: Exception -> L8
            if (TextUtils.isEmpty(r101) == false) goto L6;
            String r102 = c1.f199627a;     // Catch: Exception -> L8
        L6:
            return n0.b(r101);
        L8:
            e = move-exception;
            e.printStackTrace();
            return null;
        }
    }

    static {
        f199672m = new ConcurrentHashMap();
        f199673n = new AtomicInteger(0);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
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

    private Context getContext() {
        if (this.f199674a == null) goto L9;
        if (this.f199674a.getContext() == null) goto L9;
        return this.f199674a.getContext();
    L9:
        if (this.f199675b == null) goto L15;
        if (this.f199675b.getContext() == null) goto L15;
        return this.f199675b.getContext();
    L15:
        return BDInstallProvider.f199591d;
    }

    public final boolean b() {
        if (this.f199678e.get() == true) goto L6;
        this.f199679f.set(true);
        return false;
    L6:
        Context r100 = getContext();
        if (r100 != null) goto L10;
        return false;
    L10:
        return this.f199681h.b(new Object[]{r100}).e();
    }

    public final boolean e() {
        if (this != i.f199652b) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L9;
        return true;
    L9:
        if (this.f199674a != null) goto L13;
        return false;
    L13:
        return true;
    L5:
        r100 = false;
        goto L6
    }

    public final Integer g() {
        if (this.f199674a == null) goto L7;
        return Integer.valueOf(this.f199674a.f199728a);
    L7:
        if (this.f199675b != null) goto L9;
        return null;
    L9:
        return Integer.valueOf(this.f199675b.getAid());
    }

    public final n0 j() {
        if (this.f199674a != null) goto L5;
    L9:
        t.b("BDInstall#getInstallInfo error, not init yet!");
        return q();
    L5:
        if (this.f199674a.getContext() == null) goto L9;
        return this.f199681h.b(new Object[]{this.f199674a.getContext()}).g();
    }

    public k() {
        this.f199674a = null;
        this.f199676c = new a84.a.C0026a();
        this.f199677d = new s0();
        this.f199678e = new AtomicBoolean(false);
        this.f199679f = new AtomicBoolean(false);
        this.f199680g = new j();
        this.f199681h = new a(this);
        this.f199685l = new b();
        f199673n.incrementAndGet();
        this.f199682i = new f(this);
        this.f199683j = new i84.b();
        this.f199684k = new k74.c();
    }

    public final u h() {
        Context r100 = getContext();
        if (r100 != null) goto L7;
        return null;
    L7:
        return this.f199681h.b(new Object[]{r100}).f();
    }

    public final boolean m() {
        Context r100 = getContext();
        if (r100 != null) goto L6;
        return false;
    L6:
        return this.f199681h.b(new Object[]{r100}).k();
    }

    public final n0 q() {
        Context r100 = getContext();
        if (r100 != null) goto L7;
        return null;
    L7:
        return this.f199685l.b(new Object[]{r100});
    }

    public static k k(String r100) {
        return (k) ((ConcurrentHashMap) f199672m).get(r100);
    }

    public final void d(u r100) {
        Context r101 = getContext();
        if (r101 != null) goto L5;
        return;
    L5:
        this.f199681h.b(new Object[]{r101}).a(r100);
    }

    public final void f(u r100) {
        Context r101 = getContext();
        if (r101 != null) goto L5;
        return;
    L5:
        this.f199681h.b(new Object[]{r101}).i(r100);
    }

    public final boolean i(JSONObject r100) {
        Context r101 = getContext();
        if (r101 != null) goto L10;
        return false;
    L10:
        return this.f199681h.b(new Object[]{r101}).d(r100);
    L7:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public final void o(Account r100) {
        Context r101 = getContext();
        if (r101 != null) goto L5;
        return;
    L5:
        this.f199681h.b(new Object[]{r101}).b(r100);
    }

    public final void p(n0 r100) {
        Context r101 = getContext();
        if (r101 != null) goto L5;
        return;
    L5:
        this.f199681h.b(new Object[]{r101}).l(r100);
    }

    public final void c(boolean r100, e0 r101) {
        this.f199684k.b(r100, new k74.f(r101));
    }

    public final void l(o0 r100, u r101) {
        monitor-enter(this);
        Map<String, k> r102 = f199672m;     // Catch: Throwable -> L24
        if (((ConcurrentHashMap) r102).containsKey(String.valueOf(r100.f199728a)) == true) goto L26;
        t.a("instance init " + r100.f199728a);     // Catch: Throwable -> L24
        ((ConcurrentHashMap) r102).put(String.valueOf(r100.f199728a), this);     // Catch: Throwable -> L24
        if (this != i.f199652b) goto L9;
        boolean r103 = true;
    L10:
        r100.O = r103;     // Catch: Throwable -> L24
        this.f199674a = r100;     // Catch: Throwable -> L24
        this.f199684k.f502008e = this.f199674a.a();     // Catch: Throwable -> L24
        a84.a r104 = r100.f199749v;     // Catch: Throwable -> L24
        if (r104 == null) goto L13;
        this.f199676c = r104;     // Catch: Throwable -> L24
    L13:
        h0 r105 = r100.f199747t;     // Catch: Throwable -> L24
        if (r105 == null) goto L19;
        String r106 = String.valueOf(r100.f199728a);     // Catch: Throwable -> L24
        ConcurrentHashMap<String, h0> r107 = z0.f199821c;     // Catch: Throwable -> L24
        if (r107.containsKey(r106) == true) goto L19;
        r107.put(r106, r105);     // Catch: Throwable -> L24
    L19:
        if (r100.K == false) goto L21;
        this.f199682i.f199641g = i84.l.a(r100.getContext());     // Catch: Throwable -> L24
        i84.l.f488626e.incrementAndGet();     // Catch: Throwable -> L24
        t.a("NetworkStatusProvider increment reference count");     // Catch: Throwable -> L24
    L21:
        this.f199681h.b(new Object[]{r100.getContext()}).m(r100, r101);     // Catch: Throwable -> L24
        this.f199678e.set(true);     // Catch: Throwable -> L24
        if (this.f199679f.get() == false) goto L26;
        b();     // Catch: Throwable -> L24
        goto L26
    L9:
        r103 = false;
    L26:
        monitor-exit(this);     // Catch: Throwable -> L24
        return;
    L24:
        th = move-exception;
        throw th;
    }

    public final void n(Context r100, u r101, long r102, t0 r103) {
        Context r104 = getContext();
        if (r104 != null) goto L5;
        return;
    L5:
        this.f199681h.b(new Object[]{r104}).j(r101, r102, r103);
    }
}
