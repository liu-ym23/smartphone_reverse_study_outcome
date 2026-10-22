package vmc;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Class<?> f556360a;

    public a() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static boolean isLicenseManagerClassClassExist() {
        if (licenseManager() == null) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    private static Class<?> licenseManager() throws ClassNotFoundException {
        monitor-enter(a.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f556360a != null) goto L7;
        f556360a = INVOKESTATIC_com_ss_videoarch_liveplayer_license_LicenseManagerClassHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.pandora.ttlicense2.LicenseManager");     // Catch: Throwable -> L10
    L7:
        Class<?> r100 = f556360a;     // Catch: Throwable -> L10
        monitor-exit(a.class);     // Catch: Throwable -> L10
        return r100;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_videoarch_liveplayer_license_LicenseManagerClassHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static int checkFeatureAuth(String r100) {
        Class<?> r101 = licenseManager();     // Catch: IllegalAccessException -> L5 InvocationTargetException -> L7 NoSuchMethodException -> L9 ClassNotFoundException -> L11
        Method r102 = r101.getDeclaredMethod("getInstance", new Class[0]);     // Catch: IllegalAccessException -> L5 InvocationTargetException -> L7 NoSuchMethodException -> L9 ClassNotFoundException -> L11
        r102.setAccessible(true);     // Catch: IllegalAccessException -> L5 InvocationTargetException -> L7 NoSuchMethodException -> L9 ClassNotFoundException -> L11
        Object r103 = r102.invoke(null, new Object[0]);     // Catch: IllegalAccessException -> L5 InvocationTargetException -> L7 NoSuchMethodException -> L9 ClassNotFoundException -> L11
        Method r104 = r101.getDeclaredMethod("checkFeatureAuth", new Class[]{String.class, String.class});     // Catch: IllegalAccessException -> L5 InvocationTargetException -> L7 NoSuchMethodException -> L9 ClassNotFoundException -> L11
        r104.setAccessible(true);     // Catch: IllegalAccessException -> L5 InvocationTargetException -> L7 NoSuchMethodException -> L9 ClassNotFoundException -> L11
        return ((Integer) r104.invoke(r103, new Object[]{"live_pull", r100})).intValue();
    L11:
        e = move-exception;
        e.printStackTrace();
    L13:
        return 0;
    L5:
        e = move-exception;
        e.printStackTrace();
    L9:
        e = move-exception;
        e.printStackTrace();
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }
}
