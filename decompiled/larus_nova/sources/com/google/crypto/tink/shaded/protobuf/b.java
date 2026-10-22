package com.google.crypto.tink.shaded.protobuf;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<SoftReference<byte[]>> f275857a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class<?> f275858b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f275859c = 0;

    static {
        f275857a = new ThreadLocal();
        Class<?> r100 = a();     // Catch: ClassNotFoundException -> L5
    L6:
        f275858b = r100;
        if (r100 != null) goto L16;
    L12:
        long r101 = -1;
    L13:
        f275859c = r101;
        return;
    L16:
        if (i.f275900d == false) goto L12;
        Field r102 = r100.getDeclaredField("channel");     // Catch: Throwable -> L15
        r101 = i.f275898b.j(r102);     // Catch: Throwable -> L15
    L5:
        r100 = null;
        goto L6
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("java.io.FileOutputStream");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("java.io.FileOutputStream");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("java.io.FileOutputStream");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("java.io.FileOutputStream");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("java.io.FileOutputStream");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("java.io.FileOutputStream");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("java.io.FileOutputStream");
    }
}
