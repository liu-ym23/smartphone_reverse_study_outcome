package w55;

import android.app.Application;
import com.bytedance.ee.plugin.common.PluginManager;
import com.bytedance.ee.plugin.common.ttreader.ITTOfficePlugin;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Flowable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class e {
    public final k a;
    public final AtomicBoolean b;

    public class a implements k {
        public final AtomicBoolean a;
        public final /* synthetic */ e b;

        @Override // w55.k
        public final void a() {
            e r0 = this.b;     // Catch: Exception -> L4
            o75.b.a().getDriveConfig();     // Catch: Exception -> L4
            e.c(r0);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            this.b.getClass();
            tt5.a.f("com.bytedance.ee.plugin.ttoffice", e, false);
        }

        @Override // w55.k
        public final boolean c() {
            boolean r1 = false;
            if (this.b.e() == true) goto L6;
            return false;
        L6:
            if (this.b.e() == true) goto L8;
            tt5.a.d("com.bytedance.ee.plugin.ttoffice", "isInstalled() isPkgCanUsePlugin is false, return false.");
        L9:
            if (r1 == false) goto L11;
            this.b.a.a();
        L11:
            e.b(this.b);
            return true;
        L8:
            r1 = l.a.b();
            goto L9
        }

        @Override // w55.k
        public final void d() {
            Flowable.just("").observeOn(fo5.d.b()).map(new w55.b(this)).subscribe(new c(this), new d(this));
        }

        @Override // w55.k
        public final boolean hasInit() {
            return this.a.get();
        }

        public a(e r2) {
            this.b = r2;
            this.a = new AtomicBoolean(false);
        }

        @Override // w55.k
        public final void b(w55.a r4) {
            h0b.d r0 = (h0b.d) ApiUtils.getApi(h0b.d.class);
            if (r0 != null) goto L6;
            this.b.getClass();
            tt5.a.k("com.bytedance.ee.plugin.ttoffice", "handlePluginUpdate() ICCMPluginAgent is null");
            r4.a(-1, "ICCMPluginAgent not registered");
            return;
        L6:
            this.b.getClass();
            r0.installPlugin("com.bytedance.ee.plugin.ttoffice", r4);
        }

        @Override // w55.k
        public final void setInit(boolean r2) {
            this.a.set(r2);
        }
    }

    public class b implements k {
        public final AtomicBoolean a;
        public final /* synthetic */ e b;

        @Override // w55.k
        public final void a() {
            Flowable.just("").observeOn(fo5.d.b()).map(new f(this)).subscribe(new g(this), new h(this));
        }

        @Override // w55.k
        public final boolean c() {
            boolean r1 = false;
            if (this.b.e() == true) goto L6;
            return false;
        L6:
            if (this.b.e() == true) goto L8;
            tt5.a.d("com.bytedance.ee.plugin.ttoffice", "isInstalled() isPkgCanUsePlugin is false, return false.");
        L9:
            if (r1 == true) goto L11;
            e();
        L11:
            e.b(this.b);
            return true;
        L8:
            r1 = l.a.b();
            goto L9
        }

        @Override // w55.k
        public final void d() {
            this.b.a.a();
        }

        public final boolean e() {
            this.b.getClass();
            StringBuilder r0 = new StringBuilder("install com.bytedance.ee.plugin.ttoffice plugin onSuccess,current is init=");
            this.b.getClass();
            r0.append(this.a.get());
            r0.append(", start check init.");
            tt5.a.h("com.bytedance.ee.plugin.ttoffice", r0.toString());
            if (this.a.get() == true) goto L6;
            e r1 = this.b;
            o75.b.a().getDriveConfig();
            e.c(r1);
        L6:
            return this.a.get();
        }

        @Override // w55.k
        public final boolean hasInit() {
            return this.a.get();
        }

        public b(e r2) {
            this.b = r2;
            this.a = new AtomicBoolean(false);
        }

        @Override // w55.k
        public final void b(w55.a r4) {
            h0b.d r0 = (h0b.d) ApiUtils.getApi(h0b.d.class);
            if (r0 != null) goto L6;
            this.b.getClass();
            tt5.a.k("com.bytedance.ee.plugin.ttoffice", "handlePluginUpdate() ICCMPluginAgent is null");
            r4.a(-1, "ICCMPluginAgent not registered");
            return;
        L6:
            this.b.getClass();
            r0.installPlugin("com.bytedance.ee.plugin.ttoffice", r4);
        }

        @Override // w55.k
        public final void setInit(boolean r2) {
            this.a.set(r2);
        }
    }

    public abstract boolean e();

    public abstract boolean f();

    public e() {
        this.b = new AtomicBoolean(false);
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.drive.mira_plugin_opt");
        tt5.a.h("DriveBasePlugin", "DriveBasePlugin optimiseEnable= " + r0);
        if (r0 == false) goto L5;
        k r1 = new b(this);
    L6:
        this.a = r1;
        return;
    L5:
        r1 = new a(this);
        goto L6
    }

    public final boolean d() {
        if (e() == true) goto L5;
        tt5.a.d("com.bytedance.ee.plugin.ttoffice", "isInstalled() isPkgCanUsePlugin is false, return false.");
        boolean r0 = false;
    L6:
        if (r0 == true) goto L8;
    L10:
        boolean r1 = this.a.hasInit();
        boolean r3 = f();
        boolean r4 = e();
        boolean r5 = this.b.get();
        StringBuilder r6 = new StringBuilder("com.bytedance.ee.plugin.ttoffice isActiveState():  isInit=");
        r6.append(r1);
        r6.append(" isPkgCanUsePlugin=");
        r6.append(r4);
        r6.append(" isPluginEnable=");
        r6.append(r3);
        r6.append(" netInitFalseUninstalled is false?=");
        r6.append(!r5);
        tt5.a.h("com.bytedance.ee.plugin.ttoffice", r6.toString());
        if (r1 == false) goto L17;
        if (r4 == false) goto L18;
        if (r3 == false) goto L19;
        if (r5 == true) goto L20;
        return true;
    L20:
        return false;
    L19:
        return false;
    L18:
        return false;
    L17:
        return false;
    L8:
        if (this.a.hasInit() == true) goto L10;
        tt5.a.h("com.bytedance.ee.plugin.ttoffice", "checkInit, do init. ");
        this.a.a();
        goto L10
    L5:
        r0 = l.a.a();
        goto L6
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class a(ClassLoader r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r4 = r3.loadClass("com.bytedance.ee.plugin.ttoffice.TTOfficeInit");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.ee.plugin.ttoffice.TTOfficeInit");     // Catch: Throwable -> L8
    L7:
        return r4;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.ee.plugin.ttoffice.TTOfficeInit");
    L12:
        throw th;
    L34:
        Class<?> r5 = r3.loadClass("com.bytedance.ee.plugin.ttoffice.TTOfficeInit");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.ee.plugin.ttoffice.TTOfficeInit");     // Catch: Throwable -> L17
    L16:
        return r5;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.ee.plugin.ttoffice.TTOfficeInit");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass("com.bytedance.ee.plugin.ttoffice.TTOfficeInit");
    }

    public static void b(e r2) {
        if (r2.e() == true) goto L10;
        StringBuilder r3 = new StringBuilder("checkInstallPlugin() isPkgCanUsePlugin=false, ignore install Plugin , pkg=");
        Application r0 = eu5.b.a;
        if (r0 != null) goto L7;
        String r1 = "";
    L8:
        r3.append(r1);
        tt5.a.k("com.bytedance.ee.plugin.ttoffice", r3.toString());
        return;
    L7:
        r1 = r0.getPackageName();
        goto L8
    L10:
        if (r2.b.get() == false) goto L12;
        tt5.a.k("com.bytedance.ee.plugin.ttoffice", "checkInstallPlugin, but current sNetInitFalseUninstalled=true, ignore checkInstallPlugin");
        return;
    L12:
        tt5.a.h("com.bytedance.ee.plugin.ttoffice", "checkInstallPlugin start onPluginUpdate");
        r2.a.b(new w55.a(r2));
    }

    public static void c(e r12) {
        monitor-enter(r12);
    L55:
        th = move-exception;
        throw th;
    L5:
        if (r12.a.hasInit() == false) goto L10;
        tt5.a.h("com.bytedance.ee.plugin.ttoffice", "sHasInit is true, ignore init");     // Catch: Throwable -> L55
        monitor-exit(r12);
        return;
    L10:
        if (r12.b.get() == false) goto L14;
        tt5.a.h("com.bytedance.ee.plugin.ttoffice", "sNetInitFalseUninstalled is true, ignore init");     // Catch: Throwable -> L55
        monitor-exit(r12);
        return;
    L14:
        long r5 = System.currentTimeMillis();     // Catch: Throwable -> L55
    L51:
        th = move-exception;
        tt5.a.f("com.bytedance.ee.plugin.ttoffice", th, false);     // Catch: Throwable -> L55
    L53:
        monitor-exit(r12);
        return;
    L17:
        if (r12.e() == true) goto L22;
        tt5.a.h("com.bytedance.ee.plugin.ttoffice", "init isPkgCanUsePlugin=false, ignore init");     // Catch: Throwable -> L51
        monitor-exit(r12);
        return;
    L22:
        if (r12.f() == true) goto L26;
        tt5.a.h("com.bytedance.ee.plugin.ttoffice", "init isPluginStateEnable=false, ignore init");     // Catch: Throwable -> L51
        monitor-exit(r12);
        return;
    L26:
        x55.a r8 = l.a;     // Catch: Throwable -> L51
        if (eu5.b.a != null) goto L31;
        tt5.a.d("com.bytedance.ee.plugin.ttoffice", "pluginContext is null");     // Catch: Throwable -> L51
        monitor-exit(r12);
        return;
    L31:
        x55.a r9 = l.a;     // Catch: Throwable -> L51
        boolean r10 = r9.b();     // Catch: Throwable -> L51
        tt5.a.h("com.bytedance.ee.plugin.ttoffice", "isPluginLoaded=" + r10);     // Catch: Throwable -> L51
        if (r10 == true) goto L38;
        tt5.a.b("com.bytedance.ee.plugin.ttoffice", "init isPluginLoaded=false");     // Catch: Throwable -> L51
        boolean r4 = r9.loadPlugin();     // Catch: Throwable -> L51
        tt5.a.b("com.bytedance.ee.plugin.ttoffice", "init loadSuccess=" + r4);     // Catch: Throwable -> L51
        if (r4 == true) goto L38;
        tt5.a.d("com.bytedance.ee.plugin.ttoffice", "init return loadSuccess=" + r4);     // Catch: Throwable -> L51
        monitor-exit(r12);
        return;
    L38:
        tt5.a.h("com.bytedance.ee.plugin.ttoffice", "init start");     // Catch: Throwable -> L51
        ClassLoader r1 = r9.e();     // Catch: Throwable -> L51
        if (r1 != null) goto L43;
        tt5.a.d("com.bytedance.ee.plugin.ttoffice", "pluginClassLoader is null");     // Catch: Throwable -> L51
        monitor-exit(r12);
        return;
    L43:
        a(r1).getMethod("install", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L51
        if (PluginManager.getPluginApi(ITTOfficePlugin.class) != null) goto L46;
        tt5.a.d("TTOfficePlugin", "PluginManager.getPluginApi() is null");     // Catch: Throwable -> L51
        boolean r2 = false;
    L47:
        if (r2 == true) goto L49;
        tt5.a.d("com.bytedance.ee.plugin.ttoffice", "uninstallSuccess false!!!, try uninstall plugin....");     // Catch: Throwable -> L51
        boolean r3 = r9.c();     // Catch: Throwable -> L51
        tt5.a.h("com.bytedance.ee.plugin.ttoffice", "uninstallSuccess false, uninstall result=" + r3);     // Catch: Throwable -> L51
        r12.b.set(r3);     // Catch: Throwable -> L51
    L49:
        r12.a.setInit(r2);     // Catch: Throwable -> L51
        tt5.a.h("com.bytedance.ee.plugin.ttoffice", "init end, cost time = " + (System.currentTimeMillis() - r5) + " thread=" + ThreadMethodProxy.currentThread() + " success=" + r2 + " pluginApiVersion=" + PluginManager.getPluginApiVersion());     // Catch: Throwable -> L51
        goto L53
    L46:
        r2 = true;
        goto L47
    }
}
