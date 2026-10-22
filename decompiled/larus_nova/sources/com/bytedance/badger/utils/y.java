package com.bytedance.badger.utils;

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

/* JADX INFO: loaded from: classes47.dex */
public final class y {
    public static String b(String r100) {
    L7:
        return "";
    L5:
        return (String) a().getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(null, new Object[]{r100, ""});
    }

    public static boolean c() {
        Class r100 = a();     // Catch: Exception -> L9
        if (TextUtils.isEmpty((String) r100.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(r100, new Object[]{com.alipay.sdk.m.c.a.f25238a})) == true) goto L8;
        return true;
    L8:
        return false;
    }

    public static boolean d() {
        if (AppConstants.CHANNEL_OPPO.equalsIgnoreCase(Build.MANUFACTURER) == true) goto L12;
        String r100 = Build.BRAND;
        if (AppConstants.CHANNEL_OPPO.equalsIgnoreCase(r100) == true) goto L12;
        if ("realme".equalsIgnoreCase(r100) == true) goto L12;
        if ("OnePlus".equalsIgnoreCase(r100) == true) goto L12;
        return false;
    L12:
        return true;
    }

    public static boolean e() {
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

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.os.SystemProperties");
    }
}
