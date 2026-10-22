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
public final class k implements PrivilegedAction<Object> {
    public final /* synthetic */ MappedByteBuffer a;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("java.nio.DirectByteBuffer");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("java.nio.DirectByteBuffer");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("java.nio.DirectByteBuffer");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("java.nio.DirectByteBuffer");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("java.nio.DirectByteBuffer");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("java.nio.DirectByteBuffer");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("java.nio.DirectByteBuffer");
    }

    @Override // java.security.PrivilegedAction
    public final Object run() {
    L10:
        e = move-exception;
        b.b("Unable to unmap MappedByteBuffer! API: " + Build.VERSION.SDK_INT, e);
        return null;
    L3:
        if (m.a != null) goto L6;
        m.a = a();     // Catch: Exception -> L10
    L6:
        if (m.b != null) goto L8;
        m.b = m.a.getMethod("free", new Class[0]);     // Catch: Exception -> L10
    L8:
        m.b.setAccessible(true);     // Catch: Exception -> L10
        m.b.invoke(this.a, new Object[0]);     // Catch: Exception -> L10
        return null;
    }

    public k(MappedByteBuffer r1) {
        this.a = r1;
    }
}
