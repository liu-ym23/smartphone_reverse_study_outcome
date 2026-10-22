package i84;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.huawei.hms.android.SystemUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f488631a = null;

    public static class a extends r<Boolean> {
        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class c() throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r102 = Class.forName("com.huawei.system.BuildEx");     // Catch: Throwable -> L8
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a("com.huawei.system.BuildEx");     // Catch: Throwable -> L8
        L7:
            return r102;
        L8:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b("com.huawei.system.BuildEx");
        L12:
            throw th;
        L34:
            Class<?> r103 = Class.forName("com.huawei.system.BuildEx");     // Catch: Throwable -> L17
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a("com.huawei.system.BuildEx");     // Catch: Throwable -> L17
        L16:
            return r103;
        L17:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b("com.huawei.system.BuildEx");
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName("com.huawei.system.BuildEx");
        }

        public a() {
        }

        @Override // i84.r
        public final Boolean a(Object[] r100) {
            Class r101 = c();     // Catch: Throwable -> L4
            return Boolean.valueOf(RomUtils.OS_HARMONY.equals(r101.getMethod("getOsBrand", new Class[0]).invoke(r101, new Object[0])));
        L4:
            com.bytedance.bdinstall.t.d("isn't harmony");
            return Boolean.FALSE;
        }
    }

    public static boolean j() {
        if (a("miui.os.Build").getName().length() <= 0) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    static {
        f488631a = new a();
    }

    public static boolean e() {
        Class r100 = a("android.os.SystemProperties");     // Catch: Exception -> L7
        String r101 = (String) r100.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(r100, new Object[]{com.alipay.sdk.m.c.a.f25238a});     // Catch: Exception -> L7
        if (TextUtils.isEmpty(r101) == true) goto L9;
        com.bytedance.bdinstall.t.a("honor# oldHonor device, version is" + r101);     // Catch: Exception -> L7
        return true;
    L9:
        return false;
    L7:
        e = move-exception;
        com.bytedance.bdinstall.t.c("Honor# " + e.getMessage(), e);
        goto L9
    }

    public static boolean f() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 30) goto L5;
    L10:
        return true;
    L5:
        if (r100 == 29) goto L7;
    L9:
        return false;
    L7:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L9;
        goto L9
    }

    public static boolean g() {
        if (AppConstants.CHANNEL_OPPO.equalsIgnoreCase(Build.MANUFACTURER) == true) goto L10;
        String r100 = Build.BRAND;
        if (AppConstants.CHANNEL_OPPO.equalsIgnoreCase(r100) == true) goto L10;
        if ("realme".equalsIgnoreCase(r100) == true) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean h() {
        String r100 = Build.DISPLAY;
        if (TextUtils.isEmpty(r100) == true) goto L7;
        if (r100.contains("Flyme") == false) goto L7;
    L8:
        return true;
    L7:
        if ("flyme".equals(Build.USER) == true) goto L8;
        return false;
    }

    public static boolean i() {
        String r100 = Build.BRAND;
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L6:
        String r101 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r101) == true) goto L11;
        if (r101.toLowerCase().startsWith(RomUtils.BRAND_HONOR) == false) goto L11;
    L12:
        return true;
    L11:
        if (SystemUtils.PRODUCT_HONOR.equalsIgnoreCase(r101) == true) goto L12;
        return false;
    L5:
        if (r100.toLowerCase().startsWith(RomUtils.BRAND_HONOR) == true) goto L12;
        goto L6
    }

    public static String b() {
        String r100 = c("persist.pxr.product.forcename");
        if (TextUtils.isEmpty(r100) == false) goto L6;
        r100 = c("pxr.vendorhw.product.name");
    L6:
        if (TextUtils.isEmpty(r100) == true) goto L8;
        return r100;
    L8:
        return Build.PRODUCT;
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

    public static String c(String r100) {
        return (String) a("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(null, new Object[]{r100, ""});
    L5:
        return "";
    }

    public static String d(String r100) {
        return (String) u.a(r100);
    }
}
