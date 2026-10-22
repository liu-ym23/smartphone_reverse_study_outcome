package com.ss.ttffmpeg;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public class CustomVerify {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Method f457027a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class<?> f457028b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Method f457029c = null;

    public CustomVerify() {
    }

    private static final native void _init();

    static {
        f457027a = a("com.ttnet.org.chromium.net.X509Util").getMethod("verifyServerCertificates", new Class[]{byte[][].class, String.class, String.class});     // Catch: Exception -> L4
        Class<?> r100 = a("com.ttnet.org.chromium.net.AndroidCertVerifyResult");     // Catch: Exception -> L4
        f457028b = r100;     // Catch: Exception -> L4
        f457029c = r100.getMethod("getStatus", new Class[0]);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.getMessage();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
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

    public static int doVerify(byte[][] r100, String r101, String r102) {
        Method r103 = f457027a;
        if (r103 != null) goto L5;
        return -99995;
    L5:
        if (f457028b == null) goto L18;
        Method r104 = f457029c;
        if (r104 == null) goto L19;
        return ((Integer) r104.invoke(r103.invoke(null, new Object[]{r100, r101, r102}), new Object[0])).intValue();
    L11:
        th = move-exception;
        th.printStackTrace();
        th.getMessage();
        return -99996;
    L19:
        return -99995;
    L18:
        return -99995;
    }
}
