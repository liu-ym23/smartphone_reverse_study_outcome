package com.bytedance.bdinstall;

import android.accounts.Account;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import i84.g;
import i84.r;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import k74.c;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class k implements y {
    public static final Map<String, k> m = null;
    public static final AtomicInteger n = null;
    public volatile o0 a;
    public volatile g b;
    public volatile a84.a c;
    public final s0 d;
    public final AtomicBoolean e;
    public final AtomicBoolean f;
    public final j g;
    public final a h;
    public final f i;
    public final i84.b j;
    public final c k;
    public final b l;

    public class a extends g<g84.b> {
        public final /* synthetic */ k b;

        public a(k r1) {
            this.b = r1;
        }

        @Override // i84.g
        public final g84.b a(Object[] r5) {
            if (c1.g((Context) r5[0]) == false) goto L15;
            p0 r1 = new p0(this.b);
            Context r6 = (Context) r5[0];
            if ((r6 instanceof Application) == true) goto L8;
            if (r6 == null) goto L8;
            r6 = r6.getApplicationContext();
        L8:
            Application r7 = (Application) r6;
            if (r7 != null) goto L12;
        L14:
            r1.d = this.b.k;
            return r1;
        L12:
            if (p0.g.compareAndSet(false, true) == false) goto L14;
            r7.registerActivityLifecycleCallbacks(i.a);
            goto L14
        L15:
            w0 r2 = new w0(this.b);
            r2.b = this.b.k;
            return r2;
        }
    }

    public class b extends r<n0> {
        public b() {
        }

        @Override // i84.r
        public final n0 a(Object[] r4) {
            String r5 = ((Context) r4[0]).getSharedPreferences("ug_install_op_pref", 0).getString("install_info", null);     // Catch: Exception -> L8
            if (TextUtils.isEmpty(r5) == false) goto L6;
            String r0 = c1.a;     // Catch: Exception -> L8
        L6:
            return n0.b(r5);
        L8:
            e = move-exception;
            e.printStackTrace();
            return null;
        }
    }

    static {
        m = new ConcurrentHashMap();
        n = new AtomicInteger(0);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("com.bytedance.bdinstall.nu.NUModeServiceImpl");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.bdinstall.nu.NUModeServiceImpl");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.bdinstall.nu.NUModeServiceImpl");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("com.bytedance.bdinstall.nu.NUModeServiceImpl");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.bdinstall.nu.NUModeServiceImpl");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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
        if (this.a == null) goto L9;
        if (this.a.getContext() == null) goto L9;
        return this.a.getContext();
    L9:
        if (this.b == null) goto L15;
        if (this.b.getContext() == null) goto L15;
        return this.b.getContext();
    L15:
        return BDInstallProvider.d;
    }

    public final boolean b() {
        if (this.e.get() == true) goto L6;
        this.f.set(true);
        return false;
    L6:
        Context r0 = getContext();
        if (r0 != null) goto L10;
        return false;
    L10:
        return this.h.b(new Object[]{r0}).e();
    }

    public final boolean e() {
        if (this != i.b) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return true;
    L9:
        if (this.a != null) goto L13;
        return false;
    L13:
        return true;
    L5:
        r0 = false;
        goto L6
    }

    public final Integer g() {
        if (this.a == null) goto L7;
        return Integer.valueOf(this.a.a);
    L7:
        if (this.b != null) goto L9;
        return null;
    L9:
        return Integer.valueOf(this.b.getAid());
    }

    public final n0 j() {
        if (this.a != null) goto L5;
    L9:
        t.b("BDInstall#getInstallInfo error, not init yet!");
        return q();
    L5:
        if (this.a.getContext() == null) goto L9;
        return this.h.b(new Object[]{this.a.getContext()}).g();
    }

    public k() {
        this.a = null;
        this.c = new a84.a.C0000a();
        this.d = new s0();
        this.e = new AtomicBoolean(false);
        this.f = new AtomicBoolean(false);
        this.g = new j();
        this.h = new a(this);
        this.l = new b();
        n.incrementAndGet();
        this.i = new f(this);
        this.j = new i84.b();
        this.k = new c();
    }

    public final u h() {
        Context r0 = getContext();
        if (r0 != null) goto L7;
        return null;
    L7:
        return this.h.b(new Object[]{r0}).f();
    }

    public final boolean m() {
        Context r0 = getContext();
        if (r0 != null) goto L6;
        return false;
    L6:
        return this.h.b(new Object[]{r0}).k();
    }

    public final n0 q() {
        Context r0 = getContext();
        if (r0 != null) goto L7;
        return null;
    L7:
        return this.l.b(new Object[]{r0});
    }

    public static k k(String r1) {
        return (k) ((ConcurrentHashMap) m).get(r1);
    }

    public final void d(u r5) {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        this.h.b(new Object[]{r0}).a(r5);
    }

    public final void f(u r5) {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        this.h.b(new Object[]{r0}).i(r5);
    }

    public final boolean i(JSONObject r5) {
        Context r0 = getContext();
        if (r0 != null) goto L10;
        return false;
    L10:
        return this.h.b(new Object[]{r0}).d(r5);
    L7:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public final void o(Account r5) {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        this.h.b(new Object[]{r0}).b(r5);
    }

    public final void p(n0 r5) {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        this.h.b(new Object[]{r0}).l(r5);
    }

    public final void c(boolean r3, e0 r4) {
        this.k.b(r3, new k74.f(r4));
    }

    public final void l(o0 r7, u r8) {
        monitor-enter(this);
        Map<String, k> r1 = m;     // Catch: Throwable -> L24
        if (((ConcurrentHashMap) r1).containsKey(String.valueOf(r7.a)) == true) goto L26;
        t.a("instance init " + r7.a);     // Catch: Throwable -> L24
        ((ConcurrentHashMap) r1).put(String.valueOf(r7.a), this);     // Catch: Throwable -> L24
        if (this != i.b) goto L9;
        boolean r0 = true;
    L10:
        r7.O = r0;     // Catch: Throwable -> L24
        this.a = r7;     // Catch: Throwable -> L24
        this.k.e = this.a.a();     // Catch: Throwable -> L24
        a84.a r2 = r7.v;     // Catch: Throwable -> L24
        if (r2 == null) goto L13;
        this.c = r2;     // Catch: Throwable -> L24
    L13:
        h0 r3 = r7.t;     // Catch: Throwable -> L24
        if (r3 == null) goto L19;
        String r4 = String.valueOf(r7.a);     // Catch: Throwable -> L24
        ConcurrentHashMap r5 = z0.c;     // Catch: Throwable -> L24
        if (r5.containsKey(r4) == true) goto L19;
        r5.put(r4, r3);     // Catch: Throwable -> L24
    L19:
        if (r7.K == false) goto L21;
        this.i.g = i84.l.a(r7.getContext());     // Catch: Throwable -> L24
        i84.l.e.incrementAndGet();     // Catch: Throwable -> L24
        t.a("NetworkStatusProvider increment reference count");     // Catch: Throwable -> L24
    L21:
        this.h.b(new Object[]{r7.getContext()}).m(r7, r8);     // Catch: Throwable -> L24
        this.e.set(true);     // Catch: Throwable -> L24
        if (this.f.get() == false) goto L26;
        b();     // Catch: Throwable -> L24
        goto L26
    L9:
        r0 = false;
    L26:
        monitor-exit(this);     // Catch: Throwable -> L24
        return;
    L24:
        th = move-exception;
        throw th;
    }

    public final void n(Context r4, u r5, long r6, t0 r8) {
        Context r7 = getContext();
        if (r7 != null) goto L5;
        return;
    L5:
        this.h.b(new Object[]{r7}).j(r5, r6, r8);
    }
}
