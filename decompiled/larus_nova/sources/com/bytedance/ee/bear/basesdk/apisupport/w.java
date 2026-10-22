package com.bytedance.ee.bear.basesdk.apisupport;

import android.app.Application;
import android.os.Looper;
import android.os.SystemClock;
import android.os.Trace;
import com.bytedance.ee.bear.bizwidget.officesdk.CCMOfficeSDKAssembleFG;
import com.bytedance.ee.bear.task.BenefitInitTask;
import com.bytedance.ee.bear.task.DocsBaseTask;
import com.bytedance.ee.bear.task.DocsCentralTask;
import com.bytedance.ee.bear.task.DocsOnBoardingTask;
import com.bytedance.ee.bear.task.DocsRustInitTask;
import com.bytedance.ee.bear.task.DocsUserInfoTask;
import com.bytedance.ee.bear.task.DomainCharacteristicFetchTask;
import com.bytedance.ee.bear.task.EditorTask;
import com.bytedance.ee.bear.task.InitAuditTask;
import com.bytedance.ee.bear.task.InitCipherTask;
import com.bytedance.ee.bear.task.InitOperationUploadTask;
import com.bytedance.ee.bear.task.InitRedirectTableTask;
import com.bytedance.ee.bear.task.ReportLaunchTask;
import com.bytedance.ee.bear.task.SensitiveLogCheckTask;
import com.bytedance.ee.bear.task.SnapBoostTask;
import com.bytedance.ee.bear.task.UserCommonSettingsTask;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larksuite.framework.launch.task.ILaunchTask;
import com.larksuite.framework.launch.task.LaunchMode;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes15.dex */
public final class w implements n {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static l f206577e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static m f206578f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicBoolean f206579g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final List<on4.r> f206580h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h28.d f206581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReportLaunchTask f206582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f206583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ReentrantLock f206584d;

    static {
        f206579g = new AtomicBoolean(false);
        f206580h = new CopyOnWriteArrayList();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.ee.bear.basesdk.apisupport.AppSpacekitModuleImpl");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.ee.bear.basesdk.apisupport.AppSpacekitModuleImpl");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.ee.bear.basesdk.apisupport.AppSpacekitModuleImpl");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.ee.bear.basesdk.apisupport.AppSpacekitModuleImpl");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.ee.bear.basesdk.apisupport.AppSpacekitModuleImpl");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.ee.bear.basesdk.apisupport.AppSpacekitModuleImpl");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.ee.bear.basesdk.apisupport.AppSpacekitModuleImpl");
    }

    public static boolean c() {
        return f206579g.get();
    }

    public static l e() {
        if (f206577e != null) goto L13;
        Constructor r100 = a().getDeclaredConstructor(new Class[0]);     // Catch: Exception -> L6 ClassNotFoundException -> L9
        r100.setAccessible(true);     // Catch: Exception -> L6 ClassNotFoundException -> L9
        f206577e = (l) r100.newInstance(new Object[0]);     // Catch: Exception -> L6 ClassNotFoundException -> L9
    L9:
        e = move-exception;
        throw new IllegalStateException("failed to find AppSpacekitModuleImpl, please check if an annotationProcessor compile dependency is included in your application  and a @SpacekitModule annotated AppSpacekitModule implementation", e);
    L6:
        e = move-exception;
        throw new IllegalStateException("incorrect AppSpacekitModuleImpl, please check if the instance implements AppSpacekitModule and keep the default constructor.", e);
    L13:
        return f206577e;
    }

    public final void d() {
        if (LarkAppContext.inst().buildConfig().isOfficeSDK() == false) goto L9;
        if (CCMOfficeSDKAssembleFG.b() == true) goto L9;
        tt5.a.h("SdkInitChecker", "OfficeSDK checkAndInit, but isEnable is false");
        return;
    L9:
        if (c() == false) goto L30;
        return;
    L30:
        this.f206584d.lock();     // Catch: Throwable -> L21
        if (c() == false) goto L15;
        this.f206584d.unlock();
        return;
    L15:
        Trace.beginSection("init_space_sdk");     // Catch: Throwable -> L21
        tt5.a.h("SdkInitChecker", "Spacekit init start. ");     // Catch: Throwable -> L21
        long r100 = SystemClock.uptimeMillis();     // Catch: Throwable -> L21
        yn4.b.f568527c = r100;     // Catch: Throwable -> L21
        yn4.b.f568528d = yu5.c.d(new Throwable());     // Catch: Throwable -> L21
        f();     // Catch: Throwable -> L21
        long r101 = SystemClock.uptimeMillis() - r100;     // Catch: Throwable -> L21
        tt5.a.h("SdkInitChecker", "Spacekit init complete. costTime: " + r101);     // Catch: Throwable -> L21
        ((ConcurrentHashMap) this.f206583c).put("SdkInitChecker", String.valueOf(r101));     // Catch: Throwable -> L21
        Map<String, String> r102 = this.f206583c;     // Catch: Throwable -> L21
        if (Looper.myLooper() != Looper.getMainLooper()) goto L18;
        boolean r103 = true;
    L19:
        ((ConcurrentHashMap) r102).put("is_main_thread", String.valueOf(r103));     // Catch: Throwable -> L21
        tt5.a.h("SdkInitChecker", "dispatchDocInit");     // Catch: Throwable -> L21
        iu5.f.a(new t());     // Catch: Throwable -> L21
        Trace.endSection();     // Catch: Throwable -> L21
        f206579g.compareAndSet(false, true);     // Catch: Throwable -> L21
        km4.a.f504063a = true;     // Catch: Throwable -> L21
    L23:
        this.f206584d.unlock();
        return;
    L18:
        r103 = false;
    L21:
        th = move-exception;
        iu5.d.b("SdkInitChecker", th);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        this.f206584d.unlock();
        throw th;
    }

    public final void f() {
        this.f206581a.a(new DocsCentralTask());
        this.f206581a.b();
        if (eu5.g.j() == false) goto L5;
        h28.d r100 = this.f206581a;
        r100.a(new DocsUserInfoTask());
        r100.a(new DomainCharacteristicFetchTask());
        f206578f.getClass();
        this.f206581a.a(new InitOperationUploadTask());
        this.f206581a.a(new InitRedirectTableTask());
        this.f206581a.a(new EditorTask());
        this.f206581a.a(new SnapBoostTask());
        this.f206581a.a(new UserCommonSettingsTask());
    L5:
        this.f206581a.a(new SensitiveLogCheckTask());
        h28.d r101 = this.f206581a;
        r101.a(new DocsRustInitTask());
        r101.a(new DocsOnBoardingTask());
        r101.a(new InitAuditTask());
        this.f206581a.b();
        this.f206581a.a(this.f206582b);
        this.f206581a.a(new InitCipherTask());
        this.f206581a.a(new BenefitInitTask());
        Iterator<ILaunchTask<?>> r102 = ((ib5.a) org.koin.java.a.a(ib5.a.class)).d().iterator();     // Catch: Throwable -> L12
    L8:
        if (r102.hasNext() == false) goto L10;
        ILaunchTask<?> r103 = r102.next();     // Catch: Throwable -> L12
        this.f206581a.a(r103);     // Catch: Throwable -> L12
        goto L8
    L10:
        this.f206581a.b();     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        iu5.d.a("SdkInitChecker", th);
    }

    public w(ra5.i r100) {
        ConcurrentHashMap r101 = new ConcurrentHashMap();
        this.f206583c = r101;
        this.f206584d = new ReentrantLock();
        f206578f = r100;
        LaunchMode r102 = LaunchMode.NORMAL;
        Application r103 = e().application();
        u r104 = new u(this);
        ExecutorService r105 = CoreThreadPool.getDefault().getFixedThreadPool();
        if (r105 != null) goto L5;
        r105 = new PThreadScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), new i28.a(new AtomicInteger(1)));
    L5:
        v r106 = new v();
        h28.d r107 = new h28.d(r103, new i28.b(r105, r104, true, r102));
        g28.b.f479742a = r106;
        this.f206581a = r107;
        r107.a(new DocsBaseTask());
        this.f206582b = new ReportLaunchTask(r101);
    }

    public static void b(on4.r r100) {
        CopyOnWriteArrayList r101 = (CopyOnWriteArrayList) f206580h;
        if (r101.contains(r100) == true) goto L6;
        r101.add(r100);
        return;
    }
}
