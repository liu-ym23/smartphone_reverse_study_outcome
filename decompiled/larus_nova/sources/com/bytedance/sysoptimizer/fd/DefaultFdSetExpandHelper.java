package com.bytedance.sysoptimizer.fd;

import android.os.Build;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public class DefaultFdSetExpandHelper {
    private static final String TAG = "DefaultFdSetExpand";

    public DefaultFdSetExpandHelper() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private static native boolean hookJniMethods(Method r100, Method r101, Method r102);

    private static native boolean hookLibc();

    private static native boolean hookQtiBoostFramework();

    public static boolean applyJavaCryptoExpandFdSet() {
        if (Build.VERSION.SDK_INT < 24) goto L33;
        return true;
    L33:
        Method[] r100 = INVOKESTATIC_com_bytedance_sysoptimizer_fd_DefaultFdSetExpandHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.android.org.conscrypt.NativeCrypto").getDeclaredMethods();     // Catch: Throwable -> L32
        Method r101 = null;
        Method r102 = null;
        Method r103 = null;
        int r104 = 0;
    L9:
        if (r104 >= r100.length) goto L26;
        Method r105 = r100[r104];     // Catch: Throwable -> L32
        if (r105.getName().equals("SSL_do_handshake") == false) goto L16;
        if (r101 != null) goto L14;
        r101 = r105;
    L25:
        r104 = r104 + 1;
        goto L9
    L14:
        return false;
    L16:
        if (r105.getName().equals("SSL_read") == false) goto L20;
        if (r102 != null) goto L19;
        r102 = r105;
        goto L25
    L19:
        return false;
    L20:
        if (r105.getName().equals("SSL_write") == false) goto L25;
        if (r103 != null) goto L24;
        r103 = r105;
        goto L25
    L24:
        return false;
    L26:
        if (r101 == null) goto L43;
        if (r102 == null) goto L44;
        if (r103 != null) goto L31;
        return false;
    L31:
        return hookJniMethods(r101, r102, r103);
    L44:
        return false;
    L43:
        return false;
    L46:
        return false;
    }

    public static boolean applyLibcExpand() {
        return hookLibc();
    }

    public static boolean applyQtiBoostFrameworkExpand() {
        return hookQtiBoostFramework();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_sysoptimizer_fd_DefaultFdSetExpandHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
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
}
