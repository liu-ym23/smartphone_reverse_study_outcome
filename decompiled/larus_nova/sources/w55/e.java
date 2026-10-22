package w55;

import android.app.Application;
import com.bytedance.ee.plugin.common.PluginManager;
import com.bytedance.ee.plugin.common.ttreader.ITTOfficePlugin;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.officesdk.api.plugin.OfficeSDKPluginIds;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Flowable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes16.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f558325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f558326b;

    public class a implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicBoolean f558327a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f558328b;

        @Override // w55.k
        public final void a() {
            e r100 = this.f558328b;     // Catch: Exception -> L4
            o75.b.a().getDriveConfig();     // Catch: Exception -> L4
            e.c(r100);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            this.f558328b.getClass();
            tt5.a.f(OfficeSDKPluginIds.TT_OFFICE, e, false);
        }

        @Override // w55.k
        public final boolean c() {
            boolean r100 = false;
            if (this.f558328b.e() == true) goto L6;
            return false;
        L6:
            if (this.f558328b.e() == true) goto L8;
            tt5.a.d(OfficeSDKPluginIds.TT_OFFICE, "isInstalled() isPkgCanUsePlugin is false, return false.");
        L9:
            if (r100 == false) goto L11;
            this.f558328b.f558325a.a();
        L11:
            e.b(this.f558328b);
            return true;
        L8:
            r100 = l.f558336a.b();
            goto L9
        }

        @Override // w55.k
        public final void d() {
            Flowable.just("").observeOn(fo5.d.b()).map(new w55.b(this)).subscribe(new c(this), new d(this));
        }

        @Override // w55.k
        public final boolean hasInit() {
            return this.f558327a.get();
        }

        public a(e r100) {
            this.f558328b = r100;
            this.f558327a = new AtomicBoolean(false);
        }

        @Override // w55.k
        public final void b(w55.a r100) {
            h0b.d r101 = (h0b.d) ApiUtils.getApi(h0b.d.class);
            if (r101 != null) goto L6;
            this.f558328b.getClass();
            tt5.a.k(OfficeSDKPluginIds.TT_OFFICE, "handlePluginUpdate() ICCMPluginAgent is null");
            r100.a(-1, "ICCMPluginAgent not registered");
            return;
        L6:
            this.f558328b.getClass();
            r101.installPlugin(OfficeSDKPluginIds.TT_OFFICE, r100);
        }

        @Override // w55.k
        public final void setInit(boolean r100) {
            this.f558327a.set(r100);
        }
    }

    public class b implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicBoolean f558329a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f558330b;

        @Override // w55.k
        public final void a() {
            Flowable.just("").observeOn(fo5.d.b()).map(new f(this)).subscribe(new g(this), new h(this));
        }

        @Override // w55.k
        public final boolean c() {
            boolean r100 = false;
            if (this.f558330b.e() == true) goto L6;
            return false;
        L6:
            if (this.f558330b.e() == true) goto L8;
            tt5.a.d(OfficeSDKPluginIds.TT_OFFICE, "isInstalled() isPkgCanUsePlugin is false, return false.");
        L9:
            if (r100 == true) goto L11;
            e();
        L11:
            e.b(this.f558330b);
            return true;
        L8:
            r100 = l.f558336a.b();
            goto L9
        }

        @Override // w55.k
        public final void d() {
            this.f558330b.f558325a.a();
        }

        public final boolean e() {
            this.f558330b.getClass();
            StringBuilder r100 = new StringBuilder("install com.bytedance.ee.plugin.ttoffice plugin onSuccess,current is init=");
            this.f558330b.getClass();
            r100.append(this.f558329a.get());
            r100.append(", start check init.");
            tt5.a.h(OfficeSDKPluginIds.TT_OFFICE, r100.toString());
            if (this.f558329a.get() == true) goto L6;
            e r101 = this.f558330b;
            o75.b.a().getDriveConfig();
            e.c(r101);
        L6:
            return this.f558329a.get();
        }

        @Override // w55.k
        public final boolean hasInit() {
            return this.f558329a.get();
        }

        public b(e r100) {
            this.f558330b = r100;
            this.f558329a = new AtomicBoolean(false);
        }

        @Override // w55.k
        public final void b(w55.a r100) {
            h0b.d r101 = (h0b.d) ApiUtils.getApi(h0b.d.class);
            if (r101 != null) goto L6;
            this.f558330b.getClass();
            tt5.a.k(OfficeSDKPluginIds.TT_OFFICE, "handlePluginUpdate() ICCMPluginAgent is null");
            r100.a(-1, "ICCMPluginAgent not registered");
            return;
        L6:
            this.f558330b.getClass();
            r101.installPlugin(OfficeSDKPluginIds.TT_OFFICE, r100);
        }

        @Override // w55.k
        public final void setInit(boolean r100) {
            this.f558329a.set(r100);
        }
    }

    public abstract boolean e();

    public abstract boolean f();

    public e() {
        this.f558326b = new AtomicBoolean(false);
        boolean r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.drive.mira_plugin_opt");
        tt5.a.h("DriveBasePlugin", "DriveBasePlugin optimiseEnable= " + r100);
        if (r100 == false) goto L5;
        k r101 = new b(this);
    L6:
        this.f558325a = r101;
        return;
    L5:
        r101 = new a(this);
        goto L6
    }

    public final boolean d() {
        if (e() == true) goto L5;
        tt5.a.d(OfficeSDKPluginIds.TT_OFFICE, "isInstalled() isPkgCanUsePlugin is false, return false.");
        boolean r100 = false;
    L6:
        if (r100 == true) goto L8;
    L10:
        boolean r101 = this.f558325a.hasInit();
        boolean r102 = f();
        boolean r103 = e();
        boolean r104 = this.f558326b.get();
        StringBuilder r105 = new StringBuilder("com.bytedance.ee.plugin.ttoffice isActiveState():  isInit=");
        r105.append(r101);
        r105.append(" isPkgCanUsePlugin=");
        r105.append(r103);
        r105.append(" isPluginEnable=");
        r105.append(r102);
        r105.append(" netInitFalseUninstalled is false?=");
        r105.append(!r104);
        tt5.a.h(OfficeSDKPluginIds.TT_OFFICE, r105.toString());
        if (r101 == false) goto L17;
        if (r103 == false) goto L18;
        if (r102 == false) goto L19;
        if (r104 == true) goto L20;
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
        if (this.f558325a.hasInit() == true) goto L10;
        tt5.a.h(OfficeSDKPluginIds.TT_OFFICE, "checkInit, do init. ");
        this.f558325a.a();
        goto L10
    L5:
        r100 = l.f558336a.a();
        goto L6
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class a(ClassLoader r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = r100.loadClass("com.bytedance.ee.plugin.ttoffice.TTOfficeInit");     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.ee.plugin.ttoffice.TTOfficeInit");     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.ee.plugin.ttoffice.TTOfficeInit");
    L12:
        throw th;
    L34:
        Class<?> r104 = r100.loadClass("com.bytedance.ee.plugin.ttoffice.TTOfficeInit");     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.ee.plugin.ttoffice.TTOfficeInit");     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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

    public static void b(e r100) {
        if (r100.e() == true) goto L10;
        StringBuilder r101 = new StringBuilder("checkInstallPlugin() isPkgCanUsePlugin=false, ignore install Plugin , pkg=");
        Application r102 = eu5.b.f474075a;
        if (r102 != null) goto L7;
        String r103 = "";
    L8:
        r101.append(r103);
        tt5.a.k(OfficeSDKPluginIds.TT_OFFICE, r101.toString());
        return;
    L7:
        r103 = r102.getPackageName();
        goto L8
    L10:
        if (r100.f558326b.get() == false) goto L12;
        tt5.a.k(OfficeSDKPluginIds.TT_OFFICE, "checkInstallPlugin, but current sNetInitFalseUninstalled=true, ignore checkInstallPlugin");
        return;
    L12:
        tt5.a.h(OfficeSDKPluginIds.TT_OFFICE, "checkInstallPlugin start onPluginUpdate");
        r100.f558325a.b(new w55.a(r100));
    }

    public static void c(e r110) {
        monitor-enter(r110);
    L55:
        th = move-exception;
        throw th;
    L5:
        if (r110.f558325a.hasInit() == false) goto L10;
        tt5.a.h(OfficeSDKPluginIds.TT_OFFICE, "sHasInit is true, ignore init");     // Catch: Throwable -> L55
        monitor-exit(r110);
        return;
    L10:
        if (r110.f558326b.get() == false) goto L14;
        tt5.a.h(OfficeSDKPluginIds.TT_OFFICE, "sNetInitFalseUninstalled is true, ignore init");     // Catch: Throwable -> L55
        monitor-exit(r110);
        return;
    L14:
        long r100 = System.currentTimeMillis();     // Catch: Throwable -> L55
    L51:
        th = move-exception;
        tt5.a.f(OfficeSDKPluginIds.TT_OFFICE, th, false);     // Catch: Throwable -> L55
    L53:
        monitor-exit(r110);
        return;
    L17:
        if (r110.e() == true) goto L22;
        tt5.a.h(OfficeSDKPluginIds.TT_OFFICE, "init isPkgCanUsePlugin=false, ignore init");     // Catch: Throwable -> L51
        monitor-exit(r110);
        return;
    L22:
        if (r110.f() == true) goto L26;
        tt5.a.h(OfficeSDKPluginIds.TT_OFFICE, "init isPluginStateEnable=false, ignore init");     // Catch: Throwable -> L51
        monitor-exit(r110);
        return;
    L26:
        x55.a r101 = l.f558336a;     // Catch: Throwable -> L51
        if (eu5.b.f474075a != null) goto L31;
        tt5.a.d(OfficeSDKPluginIds.TT_OFFICE, "pluginContext is null");     // Catch: Throwable -> L51
        monitor-exit(r110);
        return;
    L31:
        x55.a r102 = l.f558336a;     // Catch: Throwable -> L51
        boolean r103 = r102.b();     // Catch: Throwable -> L51
        tt5.a.h(OfficeSDKPluginIds.TT_OFFICE, "isPluginLoaded=" + r103);     // Catch: Throwable -> L51
        if (r103 == true) goto L38;
        tt5.a.b(OfficeSDKPluginIds.TT_OFFICE, "init isPluginLoaded=false");     // Catch: Throwable -> L51
        boolean r104 = r102.loadPlugin();     // Catch: Throwable -> L51
        tt5.a.b(OfficeSDKPluginIds.TT_OFFICE, "init loadSuccess=" + r104);     // Catch: Throwable -> L51
        if (r104 == true) goto L38;
        tt5.a.d(OfficeSDKPluginIds.TT_OFFICE, "init return loadSuccess=" + r104);     // Catch: Throwable -> L51
        monitor-exit(r110);
        return;
    L38:
        tt5.a.h(OfficeSDKPluginIds.TT_OFFICE, "init start");     // Catch: Throwable -> L51
        ClassLoader r105 = r102.e();     // Catch: Throwable -> L51
        if (r105 != null) goto L43;
        tt5.a.d(OfficeSDKPluginIds.TT_OFFICE, "pluginClassLoader is null");     // Catch: Throwable -> L51
        monitor-exit(r110);
        return;
    L43:
        a(r105).getMethod("install", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L51
        if (((ITTOfficePlugin) PluginManager.getPluginApi(ITTOfficePlugin.class)) != null) goto L46;
        tt5.a.d("TTOfficePlugin", "PluginManager.getPluginApi() is null");     // Catch: Throwable -> L51
        boolean r106 = false;
    L47:
        if (r106 == true) goto L49;
        tt5.a.d(OfficeSDKPluginIds.TT_OFFICE, "uninstallSuccess false!!!, try uninstall plugin....");     // Catch: Throwable -> L51
        boolean r107 = r102.c();     // Catch: Throwable -> L51
        tt5.a.h(OfficeSDKPluginIds.TT_OFFICE, "uninstallSuccess false, uninstall result=" + r107);     // Catch: Throwable -> L51
        r110.f558326b.set(r107);     // Catch: Throwable -> L51
    L49:
        r110.f558325a.setInit(r106);     // Catch: Throwable -> L51
        tt5.a.h(OfficeSDKPluginIds.TT_OFFICE, "init end, cost time = " + (System.currentTimeMillis() - r100) + " thread=" + ThreadMethodProxy.currentThread() + " success=" + r106 + " pluginApiVersion=" + PluginManager.getPluginApiVersion());     // Catch: Throwable -> L51
        goto L53
    L46:
        r106 = true;
        goto L47
    }
}
