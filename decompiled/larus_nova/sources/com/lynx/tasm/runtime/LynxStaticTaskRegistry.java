package com.lynx.tasm.runtime;

import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.tasm.base.LLog;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes32.dex */
final class LynxStaticTaskRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f383713a = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f383714a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f383715b;

        public a(Object r100, Method r101) {
            this.f383714a = r100;
            this.f383715b = r101;
        }
    }

    public LynxStaticTaskRegistry() {
    }

    static {
        f383713a = new ConcurrentHashMap();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
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
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
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

    public static Method b(Object r100) {
        Method[] r101 = r100.getClass().getMethods();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L10;
        Method r104 = r101[r103];
        if (AbsMethodDelegate.TAG_INVOKE.equals(r104.getName()) == false) goto L9;
        if (r104.getParameterTypes().length != 1) goto L9;
        return r104;
    L9:
        r103 = r103 + 1;
        goto L3
    L10:
        return null;
    }

    public static Object c(Class<?> r100) throws Exception {
        Object r101 = r100.getMethod("getTask", new Class[0]).invoke(null, new Object[0]);     // Catch: NoSuchMethodException -> L5
    L8:
        if (r101 == null) goto L10;
        return r101;
    L10:
        Object r102 = r100.getField("Companion").get(null);
        return r102.getClass().getMethod("getTask", new Class[0]).invoke(r102, new Object[0]);
    L14:
        return r102.getClass().getField("task").get(r102);
    L5:
        r101 = r100.getField("task").get(null);     // Catch: NoSuchFieldException -> L7
    L7:
        r101 = null;
        goto L8
    }

    public static boolean d(a r100, long r101) {
        r100.f383715b.invoke(r100.f383714a, new Object[]{Long.valueOf(r101)});     // Catch: Exception -> L5
        return true;
    L5:
        e = move-exception;
        LLog.w("LynxStaticTaskRegistry", "Failed to invoke native task: " + e.getMessage());
        return false;
    }

    public static boolean executeTaskForId(String r100, long r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L35:
        return false;
    L5:
        if (r101 == 0) goto L35;
        if (r100.startsWith("kmp:jvm:") == false) goto L11;
        String r102 = r100.substring(8);
    L15:
        if (TextUtils.isEmpty(r102) == false) goto L17;
        return false;
    L17:
        ConcurrentHashMap<String, a> r103 = f383713a;
        a r104 = r103.get(r102);
        if (r104 != null) goto L20;
        Object r105 = c(a(r102));     // Catch: Exception -> L33 ClassNotFoundException -> L36
        if (r105 != null) goto L24;
        return false;
    L24:
        Method r106 = b(r105);     // Catch: Exception -> L33 ClassNotFoundException -> L36
        if (r106 != null) goto L28;
        LLog.w("LynxStaticTaskRegistry", "No invoke method found on native task: ".concat(r105.getClass().getName()));     // Catch: Exception -> L33 ClassNotFoundException -> L36
        return false;
    L28:
        a r107 = new a(r105, r106);     // Catch: Exception -> L33 ClassNotFoundException -> L36
        a r108 = r103.putIfAbsent(r102, r107);     // Catch: Exception -> L33 ClassNotFoundException -> L36
        if (r108 == null) goto L32;
        r107 = r108;
    L32:
        return d(r107, r101);
    L33:
        e = move-exception;
        LLog.w("LynxStaticTaskRegistry", "Failed to resolve static task for id " + r100 + ": " + e.getMessage());
        goto L35
    L20:
        return d(r104, r101);
    L11:
        if (r100.startsWith("kmp:") == false) goto L13;
        r102 = null;
        goto L15
    L13:
        r102 = r100;
        goto L15
    }
}
