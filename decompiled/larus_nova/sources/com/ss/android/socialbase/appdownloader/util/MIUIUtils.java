package com.ss.android.socialbase.appdownloader.util;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.Base64;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes38.dex */
public class MIUIUtils {
    private static final String BASIC_PURE_MODE_ACTIVITY = "bWl1aV9wYWNrYWdlaW5zdGFsbGVyOi8vY29tLm1pdWkucGFja2FnZWluc3RhbGxlci9zYWZlX21vZGU/c2FmZV9tb2RlX3R5cGU9c2V0dGluZyZzYWZlX21vZGVfcmVmPXNldHRpbmdfZW50cnk=";
    private static final String MIUI_VERSION_PROPERTY = "ro.miui.ui.version.name";
    private static final String SAFE_MODE_ENABLE = "miui_safe_mode";

    public MIUIUtils() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static String getMiuiVersion() {
        Class r100 = INVOKESTATIC_com_ss_android_socialbase_appdownloader_util_MIUIUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties");     // Catch: Throwable -> L4
        return (String) r100.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(r100, new Object[]{MIUI_VERSION_PROPERTY});
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_socialbase_appdownloader_util_MIUIUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static boolean checkPureModeEnabled(Context r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (readPureModeState(r100) == (-1)) goto L6;
        return true;
    }

    public static boolean isPureModeOpened(Context r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (readPureModeState(r100) != 1) goto L6;
        return true;
    }

    public static boolean jumpPureModeActivity(Context r100) {
        if (r100 != null) goto L11;
        return false;
    L11:
        Intent r101 = Intent.parseUri(new String(Base64.decode(BASIC_PURE_MODE_ACTIVITY, 0), "UTF-8"), 0);     // Catch: Exception -> L8
        r101.setFlags(268435456);     // Catch: Exception -> L8
        r100.startActivity(r101);     // Catch: Exception -> L8
        return true;
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static int readPureModeState(Context r100) {
        if (r100 != null) goto L4;
        return 0;
    L4:
        return Settings.Secure.getInt(r100.getContentResolver(), SAFE_MODE_ENABLE, -1);
    }
}
