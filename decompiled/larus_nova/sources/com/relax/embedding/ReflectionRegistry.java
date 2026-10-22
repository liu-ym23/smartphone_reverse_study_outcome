package com.relax.embedding;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public class ReflectionRegistry {
    private static final Object lock = null;
    private static Map<String, Map<a, Method>> registry;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f404632a;

        public final int hashCode() {
            return this.f404632a.hashCode();
        }

        public a(String r100) {
            this.f404632a = r100;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L5;
            return true;
        L5:
            if (r100 != null) goto L7;
            return false;
        L7:
            if (a.class == r100.getClass()) goto L10;
            return false;
        L10:
            return this.f404632a.equals(((a) r100).f404632a);
        }
    }

    public ReflectionRegistry() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        registry = new HashMap();
        lock = new Object();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_relax_embedding_ReflectionRegistry_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static boolean hasHostFunction(String r100) {
        Object r101 = lock;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (registry.get(r100) != null) goto L9;
        monitor-exit(r101);     // Catch: Throwable -> L12
        return false;
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return true;
    }

    public static Object invokeMethod(String r100, String r101, Object... r102) {
        Object r103 = lock;     // Catch: Throwable -> L19 IllegalAccessException -> L21
        monitor-enter(r103);     // Catch: Throwable -> L19 IllegalAccessException -> L21
        Map<a, Method> r104 = registry.get(r100);     // Catch: Throwable -> L16
        if (r104 == null) goto L15;
        Method r105 = r104.get(new a(r101));     // Catch: Throwable -> L16
        monitor-exit(r103);     // Catch: Throwable -> L16
        if (r105 == null) goto L13;
        return r105.invoke(null, r102);
    L13:
        throw new IllegalArgumentException("Method not registered: " + r101);     // Catch: Throwable -> L19 IllegalAccessException -> L21
    L15:
        throw new IllegalArgumentException("Class not registered: " + r100);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19 IllegalAccessException -> L21
    L19:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static void registerMethod(String r100, String r101, String r102, Class<?>... r103) {
        Object r104 = lock;     // Catch: Throwable -> L14 ClassNotFoundException -> L16
        monitor-enter(r104);     // Catch: Throwable -> L14 ClassNotFoundException -> L16
        Method r105 = INVOKESTATIC_com_relax_embedding_ReflectionRegistry_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r101).getDeclaredMethod(r102, r103);     // Catch: Throwable -> L11
        r105.setAccessible(true);     // Catch: Throwable -> L11
        if (registry.containsKey(r100) == false) goto L7;
        Map<a, Method> r106 = registry.get(r100);     // Catch: Throwable -> L11
    L8:
        r106.put(new a(r102), r105);     // Catch: Throwable -> L11
        monitor-exit(r104);     // Catch: Throwable -> L11
    L23:
        return;
    L7:
        HashMap r107 = new HashMap();     // Catch: Throwable -> L11
        registry.put(r100, r107);     // Catch: Throwable -> L11
        r106 = r107;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14 ClassNotFoundException -> L16
    L14:
        e = move-exception;
        e.printStackTrace();
    }
}
