package com.bytedance.ug.sdk.luckycat.impl.manager;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f271308a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static com.bytedance.ug.sdk.luckycat.api.depend.l f271309b;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.ug.sdk.luckycat.keep.impl.UIConfigImpl");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.ug.sdk.luckycat.keep.impl.UIConfigImpl");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.ug.sdk.luckycat.keep.impl.UIConfigImpl");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.ug.sdk.luckycat.keep.impl.UIConfigImpl");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.ug.sdk.luckycat.keep.impl.UIConfigImpl");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.ug.sdk.luckycat.keep.impl.UIConfigImpl");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.ug.sdk.luckycat.keep.impl.UIConfigImpl");
    }

    public static com.bytedance.ug.sdk.luckycat.api.depend.l b() {
        if (f271308a == true) goto L6;
        return null;
    L6:
        com.bytedance.ug.sdk.luckycat.api.depend.l r100 = f271309b;
        if (r100 == null) goto L14;
        return r100;
    L14:
        f271309b = (com.bytedance.ug.sdk.luckycat.api.depend.l) a().newInstance();     // Catch: Throwable -> L11
    L13:
        return f271309b;
    L11:
        f271308a = false;
        goto L13
    }
}
