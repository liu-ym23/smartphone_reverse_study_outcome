package com.bytedance.news.common.service.manager;

import android.util.Log;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import f37.b;
import f37.c;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class ServiceManager {
    private static final ConcurrentHashMap<Class, Object> SERVICES = null;
    private static final ConcurrentHashMap<Class, f37.a<?>> SERVICE_CREATORS = null;
    private static final ConcurrentHashMap<Class, c> SERVICE_LOAD_LISTENERS = null;
    public static boolean sIsDebug;
    public static boolean sUseNewFindService;

    /* JADX INFO: loaded from: classes21.dex */
    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RuntimeException f265970a;

        @Override // java.lang.Runnable
        public final void run() {
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        L3:
            throw this.f265970a;     // Catch: Throwable -> L4
        }

        public a(RuntimeException r100) {
            this.f265970a = r100;
        }
    }

    public ServiceManager() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        SERVICES = new ConcurrentHashMap();
        SERVICE_CREATORS = new ConcurrentHashMap();
        SERVICE_LOAD_LISTENERS = new ConcurrentHashMap();
        sIsDebug = false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_news_common_service_manager_ServiceManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [T] */
    public static <T> T getService(Class<T> r100) {
        ConcurrentHashMap<Class, Object> r101 = SERVICES;
        Object r102 = r101.get(r100);
        boolean r103 = true;
        if (r102 != null) goto L5;
    L10:
        boolean r104 = false;
        T r105 = r102;
    L11:
        if (r105 != 0) goto L57;
        monitor-enter(r100);
        T r106 = (T) r101.get(r100);
        if (r106 != null) goto L16;
        r103 = r104;
    L24:
        ConcurrentHashMap<Class, f37.a<?>> r107 = SERVICE_CREATORS;     // Catch: Throwable -> L54
        f37.a<?> r108 = r107.get(r100);     // Catch: Throwable -> L54
        if (r108 == null) goto L59;
        T r109 = (T) r108.create();
        r107.remove(r100);     // Catch: Throwable -> L54
        if (r109 == null) goto L59;
        if (r103 == false) goto L30;
        throwException(r100);     // Catch: Throwable -> L54
    L30:
        putService(r100, r109);     // Catch: Throwable -> L54
        monitor-exit(r100);     // Catch: Throwable -> L54
        return r109;
    L59:
    L43:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L54
    L45:
        r105 = (T) tryGetByReflect(r100);
        if (r105 == 0) goto L52;
        if (r103 == false) goto L49;
        throwException(r100);     // Catch: Throwable -> L54
    L49:
        putService(r100, r105);     // Catch: Throwable -> L54
        monitor-exit(r100);     // Catch: Throwable -> L54
        return r105;
    L52:
        monitor-exit(r100);     // Catch: Throwable -> L54
        goto L57
    L34:
        if (sUseNewFindService == false) goto L36;
        T r110 = (T) b.b(r100);
    L37:
        if (r110 == null) goto L45;
        if (r103 == false) goto L40;
        throwException(r100);     // Catch: Exception -> L43 Throwable -> L54
    L40:
        putService(r100, r110);     // Catch: Exception -> L43 Throwable -> L54
        monitor-exit(r100);     // Catch: Throwable -> L54
        return r110;
    L36:
        r110 = (T) b.a(r100);
        goto L37
    L16:
        if (r106.getClass() == Object.class) goto L18;
        monitor-exit(r100);     // Catch: Throwable -> L54
        return r106;
    L18:
        if (sIsDebug == true) goto L24;
        monitor-exit(r100);     // Catch: Throwable -> L54
        return null;
    L54:
        th = move-exception;
        throw th;
    L57:
        return (T) r105;
    L5:
        if (r102.getClass() != Object.class) goto L10;
        if (sIsDebug == true) goto L9;
        return null;
    L9:
        r104 = true;
        r105 = (T) null;
        goto L11
    }

    public static <T> T getServiceCache(Class<T> r100) {
        T r101 = (T) SERVICES.get(r100);
        if (r101 != null) goto L5;
        return r101;
    L5:
        if (r101.getClass() != Object.class) goto L9;
        return null;
    L9:
        return r101;
    }

    private static void throwException(Class<?> r100) {
        ThreadMethodProxy.start(new PthreadThreadV2(new a(new RuntimeException(r100.getName().concat("已被提前注入空实现，请在ArticleApplication.registerReturnNullService()方法中将提前注入空实现的代码删除，有疑问联系 @zenghongjian.zhj"))), "erviceManager"));
    }

    private static <T> T tryGetByReflect(Class<T> r100) {
        Object r101 = INVOKESTATIC_com_bytedance_news_common_service_manager_ServiceManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String.format("%s__ServiceProxy", new Object[]{r100.getName()})).newInstance();     // Catch: Throwable -> L7
        if ((r101 instanceof IServiceProxy) == false) goto L13;
        return (T) ((IServiceProxy) r101).newInstance();
    L13:
        return null;
    L7:
        th = move-exception;
        Log.getStackTraceString(th);
        return null;
    }

    private static <T> void putService(Class<T> r100, T r101) {
        SERVICES.put(r100, r101);
        ConcurrentHashMap<Class, c> r102 = SERVICE_LOAD_LISTENERS;
        c r103 = r102.get(r100);
        if (r103 == null) goto L6;
        r103.a();
        r102.remove(r100);
        return;
    }

    public static <T> void registerService(Class<T> r100, f37.a<T> r101) {
        SERVICE_CREATORS.put(r100, r101);
        ConcurrentHashMap<Class, Object> r102 = SERVICES;
        Object r103 = r102.get(r100);
        if (r103 != null) goto L5;
        return;
    L5:
        if (r103.getClass() != Object.class) goto L9;
        r102.remove(r100);
        return;
    }

    public static <T> void registerServiceLoadListener(Class<T> r100, c<T> r101) {
        SERVICE_LOAD_LISTENERS.put(r100, r101);
    }

    public static <T> void unregisterService(Class<T> r100, T r101) {
        SERVICES.remove(r100, r101);
    }

    public static <T> void registerService(Class<T> r100, T r101) {
        SERVICES.put(r100, r101);
    }
}
