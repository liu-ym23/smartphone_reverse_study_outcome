package com.google.common.base;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.CheckForNull;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    public static final Object f274740a = null;

    static {
        Method r100 = null;
        Object r101 = a("sun.misc.SharedSecrets").getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L5 ThreadDeath -> L25
    L6:
        f274740a = r101;
        if (r101 != null) goto L32;
    L13:
        if (r101 == null) goto L36;
        r100 = a("sun.misc.JavaLangAccess").getMethod("getStackTraceDepth", new Class[]{Throwable.class});     // Catch: Throwable -> L27 ThreadDeath -> L20
    L20:
        e = move-exception;
        throw e;     // Catch: Throwable -> L28 Throwable -> L28 Throwable -> L28
    L17:
        if (r100 == null) goto L37;
        r100.invoke(r101, new Object[]{new Throwable()});     // Catch: Throwable -> L28 Throwable -> L28 Throwable -> L28
        return;
    L37:
        return;
    L38:
        return;
    L36:
        return;
    L32:
        a("sun.misc.JavaLangAccess").getMethod("getStackTraceElement", new Class[]{Throwable.class, Integer.TYPE});     // Catch: Throwable -> L12 ThreadDeath -> L23
    L23:
        e = move-exception;
        throw e;
    L25:
        e = move-exception;
        throw e;
    L5:
        r101 = null;
        goto L6
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100, false, null);     // Catch: Throwable -> L8
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
        Class<?> r104 = Class.forName(r100, false, null);     // Catch: Throwable -> L17
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
}
