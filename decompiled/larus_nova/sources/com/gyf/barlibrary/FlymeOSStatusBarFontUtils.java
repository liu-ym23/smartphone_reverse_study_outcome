package com.gyf.barlibrary;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes23.dex */
public class FlymeOSStatusBarFontUtils {
    private static int SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
    private static Method mSetStatusBarColorIcon;
    private static Method mSetStatusBarDarkIcon;
    private static Field mStatusBarColorFiled;

    public FlymeOSStatusBarFontUtils() {
    }

    public static int toGrey(int r100) {
        int r101 = r100 & 255;
        int r102 = (65280 & r100) >> 8;
        return (((((r100 & 16711680) >> 16) * 38) + (r102 * 75)) + (r101 * 15)) >> 7;
    }

    static {
        mSetStatusBarColorIcon = Activity.class.getMethod("setStatusBarDarkIcon", new Class[]{Integer.TYPE});     // Catch: NoSuchMethodException -> L8
    L16:
        mSetStatusBarDarkIcon = Activity.class.getMethod("setStatusBarDarkIcon", new Class[]{Boolean.TYPE});     // Catch: NoSuchMethodException -> L9
    L12:
        mStatusBarColorFiled = WindowManager.LayoutParams.class.getField("statusBarColor");     // Catch: NoSuchFieldException -> L10
    L14:
        SYSTEM_UI_FLAG_LIGHT_STATUS_BAR = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR").getInt(null);     // Catch: Throwable -> L11
        return;
    }

    public static View INVOKEVIRTUAL_com_gyf_barlibrary_FlymeOSStatusBarFontUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static boolean isBlackColor(int r100, int r101) {
        if (toGrey(r100) >= r101) goto L5;
        return true;
    L5:
        return false;
    }

    private static void setStatusBarColor(Window r100, int r101) {
        WindowManager.LayoutParams r102 = r100.getAttributes();
        Field r103 = mStatusBarColorFiled;
        if (r103 == null) goto L13;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        if (r103.getInt(r102) == r101) goto L14;
        mStatusBarColorFiled.set(r102, Integer.valueOf(r101));     // Catch: IllegalAccessException -> L8
        r100.setAttributes(r102);     // Catch: IllegalAccessException -> L8
        return;
    L14:
        return;
    }

    public static void setStatusBarDarkIcon(Activity r100, int r101) {
        Method r102 = mSetStatusBarColorIcon;
        if (r102 != null) goto L16;
        boolean r103 = isBlackColor(r101, 50);
        if (mStatusBarColorFiled == null) goto L14;
        setStatusBarDarkIcon(r100, r103, r103);
        setStatusBarDarkIcon(r100.getWindow(), r101);
        return;
    L14:
        setStatusBarDarkIcon(r100, r103);
        return;
    L16:
        r102.invoke(r100, new Object[]{Integer.valueOf(r101)});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9
    L21:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public static void setStatusBarDarkIcon(Window r100, boolean r101) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        changeMeizuFlag(r100.getAttributes(), "MEIZU_FLAG_DARK_STATUS_BAR_ICON", r101);
        return;
    L5:
        setStatusBarDarkIcon(INVOKEVIRTUAL_com_gyf_barlibrary_FlymeOSStatusBarFontUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100), r101);
        setStatusBarColor(r100, 0);
    }

    public static void setStatusBarDarkIcon(Window r100, int r101) {
        setStatusBarColor(r100, r101);     // Catch: Exception -> L6
        if (Build.VERSION.SDK_INT <= 22) goto L11;
        setStatusBarDarkIcon(INVOKEVIRTUAL_com_gyf_barlibrary_FlymeOSStatusBarFontUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100), true);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    private static void setStatusBarDarkIcon(View r100, boolean r101) {
        int r102 = r100.getSystemUiVisibility();
        if (r101 == false) goto L5;
        int r103 = SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | r102;
    L6:
        if (r103 == r102) goto L9;
        r100.setSystemUiVisibility(r103);
        return;
    L9:
        return;
    L5:
        r103 = (~SYSTEM_UI_FLAG_LIGHT_STATUS_BAR) & r102;
        goto L6
    }

    public static void setStatusBarDarkIcon(Activity r100, boolean r101) {
        setStatusBarDarkIcon(r100, r101, true);
    }

    private static boolean changeMeizuFlag(WindowManager.LayoutParams r100, String r101, boolean r102) {
        Field r103 = r100.getClass().getDeclaredField(r101);     // Catch: Throwable -> L9 IllegalArgumentException -> L11 IllegalAccessException -> L13 NoSuchFieldException -> L15
        r103.setAccessible(true);     // Catch: Throwable -> L9 IllegalArgumentException -> L11 IllegalAccessException -> L13 NoSuchFieldException -> L15
        int r104 = r103.getInt(r100);     // Catch: Throwable -> L9 IllegalArgumentException -> L11 IllegalAccessException -> L13 NoSuchFieldException -> L15
        Field r105 = r100.getClass().getDeclaredField("meizuFlags");     // Catch: Throwable -> L9 IllegalArgumentException -> L11 IllegalAccessException -> L13 NoSuchFieldException -> L15
        r105.setAccessible(true);     // Catch: Throwable -> L9 IllegalArgumentException -> L11 IllegalAccessException -> L13 NoSuchFieldException -> L15
        int r106 = r105.getInt(r100);     // Catch: Throwable -> L9 IllegalArgumentException -> L11 IllegalAccessException -> L13 NoSuchFieldException -> L15
        if (r102 == false) goto L5;
        int r107 = r104 | r106;     // Catch: Throwable -> L9 IllegalArgumentException -> L11 IllegalAccessException -> L13 NoSuchFieldException -> L15
    L6:
        if (r106 == r107) goto L21;
        r105.setInt(r100, r107);     // Catch: Throwable -> L9 IllegalArgumentException -> L11 IllegalAccessException -> L13 NoSuchFieldException -> L15
        return true;
    L21:
        return false;
    L5:
        r107 = (~r104) & r106;     // Catch: Throwable -> L9 IllegalArgumentException -> L11 IllegalAccessException -> L13 NoSuchFieldException -> L15
    L13:
        e = move-exception;
        e.printStackTrace();
        return false;
    L11:
        e = move-exception;
        e.printStackTrace();
        return false;
    L15:
        e = move-exception;
        e.printStackTrace();
        return false;
    L9:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    private static void setStatusBarDarkIcon(Activity r100, boolean r101, boolean r102) {
        Method r103 = mSetStatusBarDarkIcon;
        if (r103 != null) goto L14;
        if (r102 == false) goto L18;
        setStatusBarDarkIcon(r100.getWindow(), r101);
        return;
    L18:
        return;
    L14:
        r103.invoke(r100, new Object[]{Boolean.valueOf(r101)});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9
    L19:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }
}
