package com.bytedance.android.tools.superkv;

import android.os.Build;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.nio.MappedByteBuffer;
import java.security.PrivilegedAction;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l implements PrivilegedAction<Object> {
    public final /* synthetic */ MappedByteBuffer a;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("sun.misc.Cleaner");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("sun.misc.Cleaner");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("sun.misc.Cleaner");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("sun.misc.Cleaner");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("sun.misc.Cleaner");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("sun.misc.Cleaner");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("sun.misc.Cleaner");
    }

    @Override // java.security.PrivilegedAction
    public final Object run() {
    L13:
        e = move-exception;
        b.b("Unable to unmap MappedByteBuffer! API: " + Build.VERSION.SDK_INT, e);
        return null;
    L3:
        if (m.c != null) goto L6;
        m.c = this.a.getClass().getMethod("cleaner", new Class[0]);     // Catch: Exception -> L13
    L6:
        if (m.d != null) goto L9;
        m.d = a();     // Catch: Exception -> L13
    L9:
        if (m.e != null) goto L11;
        m.e = m.d.getMethod("clean", new Class[0]);     // Catch: Exception -> L13
    L11:
        m.c.setAccessible(true);     // Catch: Exception -> L13
        m.e.setAccessible(true);     // Catch: Exception -> L13
        m.e.invoke(m.c.invoke(this.a, new Object[0]), new Object[0]);     // Catch: Exception -> L13
        return null;
    }

    public l(MappedByteBuffer r1) {
        this.a = r1;
    }
}
