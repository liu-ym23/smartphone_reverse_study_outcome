package com.lynx.tasm.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes32.dex */
public class DisplayMetricsHolder {
    public static final float DEFAULT_SCREEN_SCALE = 1.0f;
    public static final int UNDEFINE_SCREEN_SIZE_VALUE = -1;
    private static boolean hasNativeUpdateDeviceInfo = false;
    private static boolean isCacheInvalid = false;
    private static int sOrientation = -1;
    private static float sScaleDensity = -1.0f;
    private static DisplayMetrics sScreenDisplayMetrics;
    private static DisplayMetrics sWindowDisplayMetrics;

    public DisplayMetricsHolder() {
    }

    public static native void nativeUpdateDevice(int r100, int r101, float r102);

    public static DisplayMetrics getScreenDisplayMetrics() {
        monitor-enter(DisplayMetricsHolder.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (sScreenDisplayMetrics != null) goto L9;
        monitor-exit(DisplayMetricsHolder.class);     // Catch: Throwable -> L12
        return null;
    L9:
        DisplayMetrics r100 = new DisplayMetrics();     // Catch: Throwable -> L12
        r100.setTo(sScreenDisplayMetrics);     // Catch: Throwable -> L12
        monitor-exit(DisplayMetricsHolder.class);     // Catch: Throwable -> L12
        return r100;
    }

    public static DisplayMetrics getWindowDisplayMetrics() {
        monitor-enter(DisplayMetricsHolder.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (sWindowDisplayMetrics != null) goto L9;
        monitor-exit(DisplayMetricsHolder.class);     // Catch: Throwable -> L12
        return null;
    L9:
        DisplayMetrics r100 = new DisplayMetrics();     // Catch: Throwable -> L12
        r100.setTo(sWindowDisplayMetrics);     // Catch: Throwable -> L12
        monitor-exit(DisplayMetricsHolder.class);     // Catch: Throwable -> L12
        return r100;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_lynx_tasm_utils_DisplayMetricsHolder_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static DisplayMetrics getRealScreenDisplayMetrics(Context r100) {
        DisplayMetrics r101 = new DisplayMetrics();
        DisplayMetrics r102 = getWindowDisplayMetrics();
        if (r102 == null) goto L5;
        r101.setTo(r102);
    L5:
        WindowManager r103 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        if (r103 == null) goto L12;
        Display r104 = r103.getDefaultDisplay();
        if (r104 == null) goto L10;
        r104.getRealMetrics(r101);
    L10:
        return r101;
    L12:
        throw new AssertionError("WindowManager is null!");
    }

    private static boolean isDensityChanged(Float r100) {
        DisplayMetrics r101 = sScreenDisplayMetrics;
        if (r101 == null) goto L8;
        if (r100 == null) goto L8;
        if (r101.density == r100.floatValue()) goto L8;
        return true;
    L8:
        return false;
    }

    private static boolean isOrientationChanged(Context r100) {
        if (sOrientation == r100.getResources().getConfiguration().orientation) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isScaleDensityChange(DisplayMetrics r100) {
        if (sScaleDensity == r100.scaledDensity) goto L5;
        return true;
    L5:
        return false;
    }

    private static void setScreenDisplayMetrics(DisplayMetrics r100) {
        boolean r101 = LynxEnv.inst().isNativeLibraryLoaded();
        monitor-enter(DisplayMetricsHolder.class);
        sScreenDisplayMetrics = r100;     // Catch: Throwable -> L9
        if (r101 == false) goto L7;
        hasNativeUpdateDeviceInfo = true;     // Catch: Throwable -> L9
        nativeUpdateDevice(r100.widthPixels, r100.heightPixels, r100.density);     // Catch: Throwable -> L9
    L7:
        monitor-exit(DisplayMetricsHolder.class);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private static void setWindowDisplayMetrics(DisplayMetrics r100) {
        monitor-enter(DisplayMetricsHolder.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sWindowDisplayMetrics != null) goto L7;
        sWindowDisplayMetrics = new DisplayMetrics();     // Catch: Throwable -> L10
    L7:
        sWindowDisplayMetrics.setTo(r100);     // Catch: Throwable -> L10
        monitor-exit(DisplayMetricsHolder.class);     // Catch: Throwable -> L10
    }

    private static void updateCurrentProps(Context r100) {
        sScaleDensity = INVOKEVIRTUAL_com_lynx_tasm_utils_DisplayMetricsHolder_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).scaledDensity;
        sOrientation = r100.getResources().getConfiguration().orientation;
    }

    public static boolean updateOrInitDisplayMetrics(Context r100) {
        return updateOrInitDisplayMetrics(r100, null);
    }

    private static boolean shouldUpdateScreenMetrics(Context r100, Float r101) {
        DisplayMetrics r102 = INVOKEVIRTUAL_com_lynx_tasm_utils_DisplayMetricsHolder_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources());
        if (getScreenDisplayMetrics() != null) goto L5;
    L14:
        return true;
    L5:
        if (isOrientationChanged(r100) == true) goto L14;
        if (isScaleDensityChange(r102) == true) goto L14;
        if (hasNativeUpdateDeviceInfo == false) goto L14;
        if (isDensityChanged(r101) == true) goto L14;
        return false;
    }

    public static void updateDisplayMetrics(int r100, int r101) {
        monitor-enter(DisplayMetricsHolder.class);
        isCacheInvalid = true;     // Catch: Throwable -> L13
        DisplayMetrics r102 = sWindowDisplayMetrics;     // Catch: Throwable -> L13
        if (r102 == null) goto L8;
        r102.widthPixels = r100;     // Catch: Throwable -> L13
        r102.heightPixels = r101;     // Catch: Throwable -> L13
    L8:
        DisplayMetrics r103 = sScreenDisplayMetrics;     // Catch: Throwable -> L13
        if (r103 == null) goto L11;
        r103.widthPixels = r100;     // Catch: Throwable -> L13
        r103.heightPixels = r101;     // Catch: Throwable -> L13
    L11:
        monitor-exit(DisplayMetricsHolder.class);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public static boolean updateOrInitDisplayMetrics(Context r100, Float r101) {
        if (r100 != null) goto L4;
        LLog.w("Lynx", "updateOrInitDisplayMetrics context parameter is null, fallback to updateOrInitDisplayMetrics by ApplicationContext");
        r100 = LynxEnv.inst().getAppContext();
    L4:
        updateWindowDisplayMetrics(r100, r101);
        boolean r102 = shouldUpdateScreenMetrics(r100, r101);
        if (r102 == false) goto L7;
    L8:
        updateScreenDisplayMetrics(r100, r101);
        isCacheInvalid = false;
    L9:
        updateCurrentProps(r100);
        return r102;
    L7:
        if (isCacheInvalid == false) goto L9;
        goto L8
    }

    private static void updateScreenDisplayMetrics(Context r100, Float r101) {
        DisplayMetrics r102 = getRealScreenDisplayMetrics(r100);
        if (r101 == null) goto L5;
        r102.density = r101.floatValue();
    L5:
        setScreenDisplayMetrics(r102);
    }

    private static void updateWindowDisplayMetrics(Context r100, Float r101) {
        DisplayMetrics r102 = INVOKEVIRTUAL_com_lynx_tasm_utils_DisplayMetricsHolder_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources());
        if (r101 == null) goto L5;
        r102.density = r101.floatValue();
    L5:
        setWindowDisplayMetrics(r102);
    }
}
