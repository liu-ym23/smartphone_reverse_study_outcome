package com.ss.android.vesdk.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public class VEScreenUtils {
    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private VEScreenUtils() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_vesdk_utils_VEScreenUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static DisplayMetrics INVOKEVIRTUAL_com_ss_android_vesdk_utils_VEScreenUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static int getBottomStatusHeight(Context r100) {
        return getDpi(r100) - getScreenHeight(r100);
    }

    public static int getDpi(Context r100) {
        Display r101 = ((WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay();
        DisplayMetrics r102 = new DisplayMetrics();
        INVOKESTATIC_com_ss_android_vesdk_utils_VEScreenUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.view.Display").getMethod("getRealMetrics", new Class[]{DisplayMetrics.class}).invoke(r101, new Object[]{r102});     // Catch: Exception -> L5
        return r102.heightPixels;
    L5:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public static int getRealHight(Context r100) {
        DisplayMetrics r101 = new DisplayMetrics();
        ((WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay().getRealMetrics(r101);
        return r101.heightPixels;
    }

    public static int getScreenHeight(Context r100) {
        WindowManager r101 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        DisplayMetrics r102 = new DisplayMetrics();
        r101.getDefaultDisplay().getMetrics(r102);
        return r102.heightPixels;
    }

    public static int getScreenWidth(Context r100) {
        WindowManager r101 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        DisplayMetrics r102 = new DisplayMetrics();
        r101.getDefaultDisplay().getMetrics(r102);
        return r102.widthPixels;
    }

    public static int getTitleHeight(Activity r100) {
        return r100.getWindow().findViewById(R.id.content).getTop();
    }

    public static boolean isScreenOriatationPortrait(Context r100) {
        if (r100.getResources().getConfiguration().orientation == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static int dp2px(Context r100, float r101) {
        return (int) TypedValue.applyDimension(1, r101, INVOKEVIRTUAL_com_ss_android_vesdk_utils_VEScreenUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()));
    }

    public static float px2dp(Context r100, float r101) {
        return r101 / INVOKEVIRTUAL_com_ss_android_vesdk_utils_VEScreenUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density;
    }

    public static float px2sp(Context r100, float r101) {
        return r101 / INVOKEVIRTUAL_com_ss_android_vesdk_utils_VEScreenUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).scaledDensity;
    }

    public static int sp2px(Context r100, float r101) {
        return (int) TypedValue.applyDimension(2, r101, INVOKEVIRTUAL_com_ss_android_vesdk_utils_VEScreenUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()));
    }
}
