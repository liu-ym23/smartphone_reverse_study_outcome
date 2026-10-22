package com.gyf.barlibrary;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.home.impl.utils.c;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class NotchUtils {
    private static final String NOTCH_HUA_WEI = "com.huawei.android.util.HwNotchSizeUtil";
    private static final String NOTCH_OPPO = "com.oppo.feature.screen.heteromorphism";
    private static final String NOTCH_VIVO = "android.util.FtFeature";
    private static final String NOTCH_XIAO_MI = "ro.miui.notch";
    private static final String SYSTEM_PROPERTIES = "android.os.SystemProperties";
    private static boolean isNotchResultInitialized;
    private static boolean sNotchResult;

    public NotchUtils() {
    }

    public static View INVOKEVIRTUAL_com_gyf_barlibrary_NotchUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    private static DisplayCutout getDisplayCutout(Activity r100) {
        if (Build.VERSION.SDK_INT < 28) goto L11;
        if (r100 == null) goto L13;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L14;
        WindowInsets r102 = INVOKEVIRTUAL_com_gyf_barlibrary_NotchUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r101).getRootWindowInsets();
        if (r102 != null) goto L10;
        return null;
    L10:
        return r102.getDisplayCutout();
    L14:
        return null;
    L13:
        return null;
    L11:
        return null;
    }

    private static boolean hasNotchAtAndroidP(Activity r100) {
        if (getDisplayCutout(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean hasNotchAtHuaWei(Context r100) {
        Class r101 = INVOKEVIRTUAL_com_gyf_barlibrary_NotchUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r100.getClassLoader(), NOTCH_HUA_WEI);     // Catch: Throwable -> L5
        return ((Boolean) r101.getMethod("hasNotchInScreen", new Class[0]).invoke(r101, new Object[0])).booleanValue();
    L8:
        return false;
    }

    private static boolean hasNotchAtOPPO(Context r100) {
        return r100.getPackageManager().hasSystemFeature(NOTCH_OPPO);
    L4:
        return false;
    }

    private static boolean hasNotchAtVIVO(Context r100) {
        Class r101 = INVOKEVIRTUAL_com_gyf_barlibrary_NotchUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r100.getClassLoader(), NOTCH_VIVO);     // Catch: Throwable -> L5
        return ((Boolean) r101.getMethod("isFeatureSupport", new Class[]{Integer.TYPE}).invoke(r101, new Object[]{32})).booleanValue();
    L8:
        return false;
    }

    private static boolean hasNotchAtXiaoMi(Context r100) {
        if ("Xiaomi".equals(Build.MANUFACTURER) == true) goto L12;
    L7:
        int r101 = 0;
    L8:
        if (r101 == 1) goto L14;
        return false;
    L14:
        return true;
    L12:
        Class r102 = INVOKEVIRTUAL_com_gyf_barlibrary_NotchUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r100.getClassLoader(), SYSTEM_PROPERTIES);     // Catch: Throwable -> L6
        r101 = ((Integer) r102.getMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke(r102, new Object[]{NOTCH_XIAO_MI, 0})).intValue();     // Catch: Throwable -> L6
        goto L8
    }

    public static boolean hasNotchScreen(View r100) {
        if (isNotchResultInitialized == true) goto L5;
        boolean r101 = false;
        if (r100 != null) goto L10;
        return false;
    L10:
        if (hasNotchAtXiaoMi(r100.getContext()) == false) goto L12;
    L19:
        r101 = true;
    L20:
        sNotchResult = r101;
        isNotchResultInitialized = true;
        return r101;
    L12:
        if (hasNotchAtHuaWei(r100.getContext()) == true) goto L19;
        if (hasNotchAtOPPO(r100.getContext()) == true) goto L19;
        if (hasNotchAtVIVO(r100.getContext()) == true) goto L19;
        if (hasNotchAtAndroidP(r100) == false) goto L20;
    L5:
        return sNotchResult;
    }

    private static DisplayCutout getDisplayCutout(View r100) {
        if (Build.VERSION.SDK_INT < 28) goto L9;
        if (r100 == null) goto L11;
        WindowInsets r101 = r100.getRootWindowInsets();
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.getDisplayCutout();
    L11:
        return null;
    L9:
        return null;
    }

    private static boolean hasNotchAtAndroidP(View r100) {
        if (getDisplayCutout(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean hasNotchScreen(Activity r100) {
        if (isNotchResultInitialized == true) goto L5;
        boolean r101 = false;
        if (r100 != null) goto L10;
        return false;
    L10:
        if (hasNotchAtXiaoMi(r100) == false) goto L12;
    L19:
        r101 = true;
    L20:
        sNotchResult = r101;
        isNotchResultInitialized = true;
        return r101;
    L12:
        if (hasNotchAtHuaWei(r100) == true) goto L19;
        if (hasNotchAtOPPO(r100) == true) goto L19;
        if (hasNotchAtVIVO(r100) == true) goto L19;
        if (hasNotchAtAndroidP(r100) == false) goto L20;
    L5:
        return sNotchResult;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_com_gyf_barlibrary_NotchUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r101);
    L12:
        throw th;
    L34:
        Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
    L16:
        return r105;
    L17:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r101);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r101);
    }
}
