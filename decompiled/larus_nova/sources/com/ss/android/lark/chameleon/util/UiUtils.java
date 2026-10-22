package com.ss.android.lark.chameleon.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.content.res.AppCompatResources;
import com.android.ttcjpaysdk.base.utils.CJPayGestureUtils;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes35.dex */
public class UiUtils {
    private static final String TAG = "UiUtils";
    private static int navigationHeight = -1;
    private static RectF reactionArea;
    private static int[] reactionLoc;
    private static int realScreenHeight;

    static {
        reactionLoc = new int[2];
    }

    public UiUtils() {
    }

    public static View INVOKEVIRTUAL_com_ss_android_lark_chameleon_util_UiUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_ss_android_lark_chameleon_util_UiUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static int dp2px(int r100) {
        return (int) ((r100 * INVOKEVIRTUAL_com_ss_android_lark_chameleon_util_UiUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()).density) + 0.5f);
    }

    public static int getNavigationBarHeight(Context r100) {
        int r101 = navigationHeight;
        if (r101 != (-1)) goto L10;
        Resources r102 = r100.getResources();
        int r103 = r102.getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");
        if (r103 <= 0) goto L8;
        int r104 = r102.getDimensionPixelSize(r103);
        navigationHeight = r104;
        return r104;
    L8:
        return 0;
    L10:
        return r101;
    }

    public static Resources getResources(Context r100) {
        return r100.getResources();
    }

    public static int getScreenHeight(Context r100) {
        int r101 = realScreenHeight;
        if (r101 != 0) goto L6;
        Display r102 = ((WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay();
        DisplayMetrics r103 = new DisplayMetrics();
        r102.getRealMetrics(r103);
        int r104 = r103.heightPixels;
        realScreenHeight = r104;
        return r104;
    L6:
        return r101;
    }

    public static void hide(View r100) {
        if (r100 == null) goto L5;
        r100.setVisibility(8);
        return;
    }

    public static void invisible(View r100) {
        if (r100 == null) goto L5;
        r100.setVisibility(4);
        return;
    }

    public static boolean isActivityRunning(Activity r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (isActivityRunningInner(r100) == false) goto L6;
        return true;
    }

    private static boolean isActivityRunningInner(Activity r100) {
        if (r100.isDestroyed() == false) goto L5;
    L7:
        return false;
    L5:
        if (r100.isFinishing() == true) goto L7;
        return true;
    }

    public static boolean isVisible(View r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getVisibility() != 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static int px2sp(int r100) {
        return (int) ((r100 / INVOKEVIRTUAL_com_ss_android_lark_chameleon_util_UiUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()).scaledDensity) + 0.5f);
    }

    public static void show(View r100) {
        if (r100 == null) goto L5;
        r100.setVisibility(0);
        return;
    }

    public static void display(View r100, boolean r101) {
        if (r101 == false) goto L4;
        show(r100);
        return;
    L4:
        hide(r100);
    }

    public static int dp2px(Context r100, float r101) {
        return (int) ((r101 * INVOKEVIRTUAL_com_ss_android_lark_chameleon_util_UiUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density) + 0.5f);
    }

    public static int getColor(Context r100, int r101) {
        return getResources(r100).getColor(r101);
    }

    public static Drawable getCompatDrawable(Context r100, int r101) {
        return AppCompatResources.getDrawable(r100, r101);
    }

    public static int getDimens(Context r100, int r101) {
        return getResources(r100).getDimensionPixelSize(r101);
    }

    public static Drawable getDrawable(Context r100, int r101) {
        return getResources(r100).getDrawable(r101);
    }

    public static int getInternalDimensionSize(Resources r100, String r101) {
        int r102 = r100.getIdentifier(r101, "dimen", "android");
        if (r102 > 0) goto L7;
        return 0;
    L7:
        return r100.getDimensionPixelSize(r102);
    }

    public static String getString(Context r100, int r101) {
        return getResources(r100).getString(r101);
    }

    public static String[] getStringArray(Context r100, int r101) {
        return getResources(r100).getStringArray(r101);
    }

    public static boolean isHoverOnView(View r100, MotionEvent r101) {
        r100.getLocationOnScreen(reactionLoc);
        int[] r102 = reactionLoc;
        int r103 = r102[0];
        RectF r104 = new RectF(r103, r102[1], r103 + r100.getWidth(), reactionLoc[1] + r100.getHeight());
        reactionArea = r104;
        return r104.contains(r101.getRawX(), r101.getRawY());
    }

    public static int px2dp(Context r100, float r101) {
        return (int) ((r101 / INVOKEVIRTUAL_com_ss_android_lark_chameleon_util_UiUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density) + 0.5f);
    }

    public static int px2sp(Context r100, int r101) {
        return (int) ((r101 / INVOKEVIRTUAL_com_ss_android_lark_chameleon_util_UiUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).scaledDensity) + 0.5f);
    }

    public static String getString(Context r100, int r101, Object... r102) throws Resources.NotFoundException {
        return getResources(r100).getString(r101, r102);
    }

    public static void setForegroundDrawable(Activity r100, float r101, Drawable r102) {
        if (r100 == null) goto L10;
        Window r103 = r100.getWindow();
        if (r103 == null) goto L11;
        View r104 = INVOKEVIRTUAL_com_ss_android_lark_chameleon_util_UiUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r103);
        if (Build.VERSION.SDK_INT < 23) goto L8;
        r104.setForeground(r102);
        return;
    L8:
        WindowManager.LayoutParams r105 = r103.getAttributes();
        r105.alpha = r101;
        r103.setAttributes(r105);
        return;
    L11:
        return;
    }
}
