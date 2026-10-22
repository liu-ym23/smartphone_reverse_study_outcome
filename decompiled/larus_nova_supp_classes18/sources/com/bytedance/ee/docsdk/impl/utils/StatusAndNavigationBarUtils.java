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
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.home.impl.utils.c;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class StatusAndNavigationBarUtils {
    private static final String NAVIGATION = "navigationBarBackground";
    private static final String TAG = "StatusAndNavigationBarUtils";
    private static int navigationHeight = -1;
    private static int sStatusHeight = -1;

    public StatusAndNavigationBarUtils() {
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static View INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static void clearViewUnderStatusBar(Window r1) {
        int r0 = INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1).getSystemUiVisibility();
        INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1).setSystemUiVisibility(r0 & (-1025));
    }

    public static void clearViewUnderStatusBarAndNavigationBar(Window r1) {
        int r0 = INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1).getSystemUiVisibility();
        INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1).setSystemUiVisibility(r0 & (-513));
    }

    public static int getNavigationBarHeight(Activity r3) {
        int r1 = 0;
        View r4 = INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r3.getWindow());     // Catch: Throwable -> L11
        if ((r4 instanceof ViewGroup) == false) goto L13;
        View r5 = r4.findViewById(R.id.navigationBarBackground);     // Catch: Throwable -> L11
        if (r5 == null) goto L13;
        if (r5.getVisibility() != 0) goto L13;
        r1 = r5.getHeight();     // Catch: Throwable -> L11
    L13:
        Log.d(TAG, "navigationBarHeight:" + r1);
        return r1;
    L11:
        th = move-exception;
        Log.e(TAG, th.getMessage(), th);
        goto L13
    }

    public static int getStatusBarHeight(Context r4) {
        int r1 = sStatusHeight;
        if (r1 == (-1)) goto L5;
        return r1;
    L5:
        Resources r5 = r4.getResources();
        Class r2 = INVOKESTATIC_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.android.internal.R$dimen");     // Catch: Exception -> L8
        sStatusHeight = r5.getDimensionPixelSize(CastIntegerProtector.parseInt(r2.getField("status_bar_height").get(r2.newInstance()).toString()));     // Catch: Exception -> L8
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

    public static void hideNavigation(Window r1) {
        int r0 = INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1).getSystemUiVisibility();
        INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1).setSystemUiVisibility((r0 | 2) | DocUserPermission.USER_PERCEIVE);
    }

    public static boolean isHuaWeiNavigationBarExist(Context r3) {
        if ((r3 instanceof Activity) == false) goto L8;
        Activity r4 = (Activity) r3;
        int r0 = INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r4.getWindow()).getHeight();
        Point r2 = new Point();
        r4.getWindow().getWindowManager().getDefaultDisplay().getRealSize(r2);
        if (r0 == r2.y) goto L9;
        return true;
    L9:
        return false;
    L8:
        return false;
    }

    public static boolean isNavigationBarExist(Activity r5) {
        if (r5 != null) goto L5;
    L19:
        return false;
    L5:
        if (r5.isDestroyed() == true) goto L19;
        ViewGroup r1 = (ViewGroup) INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r5.getWindow());
        if (r1 == null) goto L19;
        int r2 = 0;
    L11:
        if (r2 >= r1.getChildCount()) goto L19;
        r1.getChildAt(r2).getContext().getPackageName();
        if (r1.getChildAt(r2).getId() == (-1)) goto L18;
        if (NAVIGATION.equals(r5.getResources().getResourceEntryName(r1.getChildAt(r2).getId())) == false) goto L18;
        return true;
    L18:
        r2 = r2 + 1;
        goto L11
    }

    public static boolean isStatusBarExist(Activity r3) {
        if (r3 != null) goto L5;
    L27:
        Log.i(TAG, "isNavigationBarExist, activity is null or activity is destroyed");
        return true;
    L5:
        if (r3.isDestroyed() == true) goto L27;
        Window r4 = r3.getWindow();
        if (r4 != null) goto L10;
        return true;
    L10:
        View r5 = INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r4);
        if (r5 != null) goto L14;
        return true;
    L14:
        if (Build.VERSION.SDK_INT < 23) goto L19;
        WindowInsets r1 = r5.getRootWindowInsets();
        if (r1 == null) goto L19;
        return WindowInsetsCompat.toWindowInsetsCompat(r1, r5).isVisible(WindowInsetsCompat.Type.statusBars());
    L19:
        View r6 = r5.findViewById(R.id.statusBarBackground);
        if (r6 != null) goto L23;
        return false;
    L23:
        if (r6.getHeight() != 0) goto L29;
        return false;
    L29:
        return true;
    }

    public static void setStatusBarTransparent(Context r2) {
        Activity r3 = (Activity) r2;
        INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r3.getWindow()).setSystemUiVisibility(1280);
        r3.getWindow().setStatusBarColor(0);
    }

    public static void setViewUnderStatusBar(Window r1) {
        int r0 = INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1).getSystemUiVisibility();
        INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1).setSystemUiVisibility(r0 | DocUserPermission.USER_PERM_FULL_ACCESS);
    }

    public static void setViewUnderStatusBarAndNavigationBar(Window r1) {
        int r0 = INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1).getSystemUiVisibility();
        INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1).setSystemUiVisibility(r0 | 512);
    }

    public static void showNavigation(Window r1) {
        int r0 = INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1).getSystemUiVisibility();
        INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_StatusAndNavigationBarUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1).setSystemUiVisibility((r0 & (-3)) & (-4097));
    }

    public static int getNavigationBarHeight(Context r3) {
        int r0 = navigationHeight;
        if (r0 != (-1)) goto L12;
        Resources r4 = r3.getResources();
        if (r4.getIdentifier("config_showNavigationBar", "bool", "android") == 0) goto L10;
        int r1 = r4.getIdentifier("navigation_bar_height", "dimen", "android");
        if (r1 <= 0) goto L13;
        int r5 = r4.getDimensionPixelSize(r1);
        navigationHeight = r5;
        return r5;
    L13:
        return 0;
    L10:
        return 0;
    L12:
        return r0;
    }
}
