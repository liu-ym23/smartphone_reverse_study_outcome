package com.bytedance.news.common.service.manager;

import android.util.Log;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import f37.a;
import f37.b;
import f37.c;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class ServiceManager {
    private static final ConcurrentHashMap<Class, Object> SERVICES = null;
    private static final ConcurrentHashMap<Class, a<?>> SERVICE_CREATORS = null;
    private static final ConcurrentHashMap<Class, c> SERVICE_LOAD_LISTENERS = null;
    public static boolean sIsDebug;
    public static boolean sUseNewFindService;

    public ServiceManager() {
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    static {
        SERVICES = new ConcurrentHashMap();
        SERVICE_CREATORS = new ConcurrentHashMap();
        SERVICE_LOAD_LISTENERS = new ConcurrentHashMap();
        sIsDebug = false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_news_common_service_manager_ServiceManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [T] */
    public static <T> T getService(Class<T> r6) {
        ConcurrentHashMap<Class, Object> r0 = SERVICES;
        Object r1 = r0.get(r6);
        boolean r2 = true;
        if (r1 != null) goto L5;
    L10:
        boolean r4 = false;
        T r3 = r1;
    L11:
        if (r3 != 0) goto L57;
        monitor-enter(r6);
        T r5 = (T) r0.get(r6);
        if (r5 != null) goto L16;
        r2 = r4;
    L24:
        ConcurrentHashMap<Class, a<?>> r7 = SERVICE_CREATORS;     // Catch: Throwable -> L54
        a<?> r8 = r7.get(r6);     // Catch: Throwable -> L54
        if (r8 == null) goto L59;
        T r9 = (T) r8.create();
        r7.remove(r6);     // Catch: Throwable -> L54
        if (r9 == null) goto L59;
        if (r2 == false) goto L30;
        throwException(r6);     // Catch: Throwable -> L54
    L30:
        putService(r6, r9);     // Catch: Throwable -> L54
        monitor-exit(r6);     // Catch: Throwable -> L54
        return r9;
    L59:
    L43:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L54
    L45:
        r3 = (T) tryGetByReflect(r6);
        if (r3 == 0) goto L52;
        if (r2 == false) goto L49;
        throwException(r6);     // Catch: Throwable -> L54
    L49:
        putService(r6, r3);     // Catch: Throwable -> L54
        monitor-exit(r6);     // Catch: Throwable -> L54
        return r3;
    L52:
        monitor-exit(r6);     // Catch: Throwable -> L54
        goto L57
    L34:
        if (sUseNewFindService == false) goto L36;
        T r10 = (T) b.b(r6);
    L37:
        if (r10 == null) goto L45;
        if (r2 == false) goto L40;
        throwException(r6);     // Catch: Exception -> L43 Throwable -> L54
    L40:
        putService(r6, r10);     // Catch: Exception -> L43 Throwable -> L54
        monitor-exit(r6);     // Catch: Throwable -> L54
        return r10;
    L36:
        r10 = (T) b.a(r6);
        goto L37
    L16:
        if (r5.getClass() == Object.class) goto L18;
        monitor-exit(r6);     // Catch: Throwable -> L54
        return r5;
    L18:
        if (sIsDebug == true) goto L24;
        monitor-exit(r6);     // Catch: Throwable -> L54
        return null;
    L54:
        th = move-exception;
        throw th;
    L57:
        return (T) r3;
    L5:
        if (r1.getClass() != Object.class) goto L10;
        if (sIsDebug == true) goto L9;
        return null;
    L9:
        r4 = true;
        r3 = (T) null;
        goto L11
    }

    public static <T> T getServiceCache(Class<T> r2) {
        T r3 = (T) SERVICES.get(r2);
        if (r3 != null) goto L5;
        return r3;
    L5:
        if (r3.getClass() != Object.class) goto L9;
        return null;
    L9:
        return r3;
    }

    private static void throwException(Class<?> r2) {
        ThreadMethodProxy.start(new PthreadThreadV2(new a(new RuntimeException(r2.getName().concat("已被提前注入空实现，请在ArticleApplication.registerReturnNullService()方法中将提前注入空实现的代码删除，有疑问联系 @zenghongjian.zhj"))), "erviceManager"));
    }

    private static <T> T tryGetByReflect(Class<T> r2) {
        Object r3 = INVOKESTATIC_com_bytedance_news_common_service_manager_ServiceManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String.format("%s__ServiceProxy", new Object[]{r2.getName()})).newInstance();     // Catch: Throwable -> L7
        if ((r3 instanceof IServiceProxy) == false) goto L13;
        return (T) ((IServiceProxy) r3).newInstance();
    L13:
        return null;
    L7:
        th = move-exception;
        Log.getStackTraceString(th);
        return null;
    }

    private static <T> void putService(Class<T> r1, T r2) {
        SERVICES.put(r1, r2);
        ConcurrentHashMap<Class, c> r3 = SERVICE_LOAD_LISTENERS;
        c r0 = r3.get(r1);
        if (r0 == null) goto L6;
        r0.a();
        r3.remove(r1);
        return;
    }

    public static <T> void registerService(Class<T> r2, a<T> r3) {
        SERVICE_CREATORS.put(r2, r3);
        ConcurrentHashMap<Class, Object> r4 = SERVICES;
        Object r0 = r4.get(r2);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getClass() != Object.class) goto L9;
        r4.remove(r2);
        return;
    }

    public static <T> void registerServiceLoadListener(Class<T> r1, c<T> r2) {
        SERVICE_LOAD_LISTENERS.put(r1, r2);
    }

    public static <T> void unregisterService(Class<T> r1, T r2) {
        SERVICES.remove(r1, r2);
    }

    public static <T> void registerService(Class<T> r1, T r2) {
        SERVICES.put(r1, r2);
    }
}
