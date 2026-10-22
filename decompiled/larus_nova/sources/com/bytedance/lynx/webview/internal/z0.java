package com.bytedance.lynx.webview.internal;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import dalvik.system.DexClassLoader;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes21.dex */
public final class z0 extends DexClassLoader {
    @Override // dalvik.system.BaseDexClassLoader
    public final String toString() {
        return super.toString();
    }

    @Override // java.lang.ClassLoader
    public final Class<?> loadClass(String r100) throws ClassNotFoundException {
        Class<?> r101 = findLoadedClass(r100);
        if (r100.startsWith("ttwebview.") == false) goto L5;
    L17:
        if (r101 != null) goto L24;
        return findClass(r100);
    L21:
        return a(this, r100);
    L24:
        return r101;
    L5:
        if (r100.startsWith("com.") == true) goto L17;
        if (r100.startsWith("TT_J.") == true) goto L17;
        if (r100.startsWith("androidx.") == true) goto L17;
        if (r100.startsWith("org.chromium.") == true) goto L17;
        if (r100.startsWith("kotlin.") == true) goto L17;
        if (r100.startsWith("kotlinx.") == true) goto L17;
        r101 = a(this, r100);
        goto L17
    }

    public z0(String r100, ClassLoader r101) {
        super("", r100, null, r101);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class a(DexClassLoader r100, String r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r104 = super.loadClass(r101);     // Catch: Throwable -> L8
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r101);
    L12:
        throw th;
    L34:
        Class r105 = super.loadClass(r101);     // Catch: Throwable -> L17
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
    L16:
        return r105;
    L17:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r101);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r101);
    }
}
