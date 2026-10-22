package com.bytedance.ee.docsdk.impl.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import androidx.core.view.WindowInsetsCompat;
import com.android.ttcjpaysdk.base.utils.CJPayGestureUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.home.impl.utils.c;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ttnet.org.chromium.net.NetError;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes18.dex */
public class StatusAndNavigationBarUtils {
    private static final String NAVIGATION = "navigationBarBackground";
    private static final String TAG = "StatusAndNavigationBarUtils";
    private static int navigationHeight = -1;
    private static int sStatusHeight = -1;

    public StatusAndNavigationBarUtils() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static View INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void clearViewUnderStatusBar(Window r100) {
        int r101 = INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100).getSystemUiVisibility();
        INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100).setSystemUiVisibility(r101 & (-1025));
    }

    public static void clearViewUnderStatusBarAndNavigationBar(Window r100) {
        int r101 = INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100).getSystemUiVisibility();
        INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100).setSystemUiVisibility(r101 & NetError.ERR_TTNET_FT_INVALID_STREAM);
    }

    public static int getNavigationBarHeight(Activity r100) {
        int r101 = 0;
        View r102 = INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow());     // Catch: Throwable -> L11
        if ((r102 instanceof ViewGroup) == false) goto L13;
        View r103 = r102.findViewById(R.id.navigationBarBackground);     // Catch: Throwable -> L11
        if (r103 == null) goto L13;
        if (r103.getVisibility() != 0) goto L13;
        r101 = r103.getHeight();     // Catch: Throwable -> L11
    L13:
        Log.d(TAG, "navigationBarHeight:" + r101);
        return r101;
    L11:
        th = move-exception;
        Log.e(TAG, th.getMessage(), th);
        goto L13
    }

    public static int getStatusBarHeight(Context r100) {
        int r101 = sStatusHeight;
        if (r101 == (-1)) goto L5;
        return r101;
    L5:
        Resources r102 = r100.getResources();
        Class r103 = INVOKESTATIC_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.android.internal.R$dimen");     // Catch: Exception -> L8
        sStatusHeight = r102.getDimensionPixelSize(CastIntegerProtector.parseInt(r103.getField("status_bar_height").get(r103.newInstance()).toString()));     // Catch: Exception -> L8
    L11:
        if (sStatusHeight > 0) goto L14;
        Log.e(TAG, "get the abnormal height value of the status bar " + sStatusHeight);
    L14:
        return sStatusHeight;
    L8:
        e = move-exception;
        Log.e(TAG, e.getMessage(), e);
        goto L11
    }

    public static void hideNavigation(Window r100) {
        int r101 = INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100).getSystemUiVisibility();
        INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100).setSystemUiVisibility((r101 | 2) | 4096);
    }

    public static boolean isHuaWeiNavigationBarExist(Context r100) {
        if ((r100 instanceof Activity) == false) goto L8;
        Activity r101 = (Activity) r100;
        int r102 = INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r101.getWindow()).getHeight();
        Point r103 = new Point();
        r101.getWindow().getWindowManager().getDefaultDisplay().getRealSize(r103);
        if (r102 == r103.y) goto L9;
        return true;
    L9:
        return false;
    L8:
        return false;
    }

    public static boolean isNavigationBarExist(Activity r100) {
        if (r100 != null) goto L5;
    L19:
        return false;
    L5:
        if (r100.isDestroyed() == true) goto L19;
        ViewGroup r101 = (ViewGroup) INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow());
        if (r101 == null) goto L19;
        int r102 = 0;
    L11:
        if (r102 >= r101.getChildCount()) goto L19;
        r101.getChildAt(r102).getContext().getPackageName();
        if (r101.getChildAt(r102).getId() == (-1)) goto L18;
        if (NAVIGATION.equals(r100.getResources().getResourceEntryName(r101.getChildAt(r102).getId())) == false) goto L18;
        return true;
    L18:
        r102 = r102 + 1;
        goto L11
    }

    public static boolean isStatusBarExist(Activity r100) {
        if (r100 != null) goto L5;
    L27:
        Log.i(TAG, "isNavigationBarExist, activity is null or activity is destroyed");
        return true;
    L5:
        if (r100.isDestroyed() == true) goto L27;
        Window r101 = r100.getWindow();
        if (r101 != null) goto L10;
        return true;
    L10:
        View r102 = INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r101);
        if (r102 != null) goto L14;
        return true;
    L14:
        if (Build.VERSION.SDK_INT < 23) goto L19;
        WindowInsets r103 = r102.getRootWindowInsets();
        if (r103 == null) goto L19;
        return WindowInsetsCompat.toWindowInsetsCompat(r103, r102).isVisible(WindowInsetsCompat.Type.statusBars());
    L19:
        View r104 = r102.findViewById(R.id.statusBarBackground);
        if (r104 != null) goto L23;
        return false;
    L23:
        if (r104.getHeight() != 0) goto L29;
        return false;
    L29:
        return true;
    }

    public static void setStatusBarTransparent(Context r100) {
        Activity r101 = (Activity) r100;
        INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r101.getWindow()).setSystemUiVisibility(1280);
        r101.getWindow().setStatusBarColor(0);
    }

    public static void setViewUnderStatusBar(Window r100) {
        int r101 = INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100).getSystemUiVisibility();
        INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100).setSystemUiVisibility(r101 | 1024);
    }

    public static void setViewUnderStatusBarAndNavigationBar(Window r100) {
        int r101 = INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100).getSystemUiVisibility();
        INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100).setSystemUiVisibility(r101 | 512);
    }

    public static void showNavigation(Window r100) {
        int r101 = INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100).getSystemUiVisibility();
        INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100).setSystemUiVisibility((r101 & (-3)) & (-4097));
    }

    public static int getNavigationBarHeight(Context r100) {
        int r101 = navigationHeight;
        if (r101 != (-1)) goto L12;
        Resources r102 = r100.getResources();
        if (r102.getIdentifier("config_showNavigationBar", "bool", "android") == 0) goto L10;
        int r103 = r102.getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");
        if (r103 <= 0) goto L13;
        int r104 = r102.getDimensionPixelSize(r103);
        navigationHeight = r104;
        return r104;
    L13:
        return 0;
    L10:
        return 0;
    L12:
        return r101;
    }
}
