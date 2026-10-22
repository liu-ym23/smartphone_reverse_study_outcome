package com.gyf.barlibrary;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes23.dex */
class BarConfig {
    private static final String MIUI_FORCE_FSG_NAV_BAR = "force_fsg_nav_bar";
    private static final String NAV_BAR_HEIGHT_LANDSCAPE_RES_NAME = "navigation_bar_height_landscape";
    private static final String NAV_BAR_HEIGHT_RES_NAME = "navigation_bar_height";
    private static final String NAV_BAR_WIDTH_RES_NAME = "navigation_bar_width";
    private static final String STATUS_BAR_HEIGHT_RES_NAME = "status_bar_height";
    private final int mActionBarHeight;
    private final boolean mHasNavigationBar;
    private final boolean mHasNotchScreen;
    private final boolean mInPortrait;
    private final int mNavigationBarHeight;
    private final int mNavigationBarWidth;
    private final float mSmallestWidthDp;
    private final int mStatusBarHeight;

    public boolean isNavigationAtBottom() {
        if (this.mSmallestWidthDp < 600.0f) goto L5;
    L8:
        return true;
    L5:
        if (this.mInPortrait == true) goto L8;
        return false;
    }

    public int getActionBarHeight() {
        return this.mActionBarHeight;
    }

    public int getNavigationBarHeight() {
        return this.mNavigationBarHeight;
    }

    public int getNavigationBarWidth() {
        return this.mNavigationBarWidth;
    }

    public int getStatusBarHeight() {
        return this.mStatusBarHeight;
    }

    public boolean hasNavigationBar() {
        return this.mHasNavigationBar;
    }

    public boolean hasNotchScreen() {
        return this.mHasNotchScreen;
    }

    public BarConfig(Activity r100) {
        boolean r101 = false;
        if (r100.getResources().getConfiguration().orientation != 1) goto L5;
        boolean r102 = true;
    L6:
        this.mInPortrait = r102;
        this.mSmallestWidthDp = getSmallestWidthDp(r100);
        this.mStatusBarHeight = getInternalDimensionSize(r100, "status_bar_height");
        this.mActionBarHeight = getActionBarHeight(r100);
        int r103 = getNavigationBarHeight(r100);
        this.mNavigationBarHeight = r103;
        this.mNavigationBarWidth = getNavigationBarWidth(r100);
        if (r103 <= 0) goto L9;
        r101 = true;
    L9:
        this.mHasNavigationBar = r101;
        this.mHasNotchScreen = NotchUtils.hasNotchScreen(r100);
        return;
    L5:
        r102 = false;
        goto L6
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_gyf_barlibrary_BarConfig_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private int getActionBarHeight(Context r100) {
        TypedValue r101 = new TypedValue();
        r100.getTheme().resolveAttribute(R.attr.actionBarSize, r101, true);
        return TypedValue.complexToDimensionPixelSize(r101.data, INVOKEVIRTUAL_com_gyf_barlibrary_BarConfig_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()));
    }

    private int getNavigationBarHeight(Context r100) {
        if (hasNavBar((Activity) r100) == true) goto L5;
        return 0;
    L5:
        if (this.mInPortrait == false) goto L7;
        String r101 = "navigation_bar_height";
    L9:
        return getInternalDimensionSize(r100, r101);
    L7:
        r101 = "navigation_bar_height_landscape";
        goto L9
    }

    private int getNavigationBarWidth(Context r100) {
        if (hasNavBar((Activity) r100) == true) goto L5;
        return 0;
    L5:
        return getInternalDimensionSize(r100, NAV_BAR_WIDTH_RES_NAME);
    }

    private float getSmallestWidthDp(Activity r100) {
        DisplayMetrics r101 = new DisplayMetrics();
        r100.getWindowManager().getDefaultDisplay().getRealMetrics(r101);
        float r102 = r101.widthPixels;
        float r103 = r101.density;
        return Math.min(r102 / r103, r101.heightPixels / r103);
    }

    private boolean hasNavBar(Activity r100) {
        if (Settings.Global.getInt(r100.getContentResolver(), MIUI_FORCE_FSG_NAV_BAR, 0) == 0) goto L5;
        return false;
    L5:
        Display r101 = r100.getWindowManager().getDefaultDisplay();
        DisplayMetrics r102 = new DisplayMetrics();
        r101.getRealMetrics(r102);
        int r103 = r102.heightPixels;
        int r104 = r102.widthPixels;
        DisplayMetrics r105 = new DisplayMetrics();
        r101.getMetrics(r105);
        int r106 = r105.heightPixels;
        if ((r104 - r105.widthPixels) <= 0) goto L8;
    L9:
        return true;
    L8:
        if ((r103 - r106) > 0) goto L9;
        return false;
    }

    private int getInternalDimensionSize(Context r100, String r101) {
        int r102 = Resources.getSystem().getIdentifier(r101, "dimen", "android");     // Catch: Resources.NotFoundException -> L11
        if (r102 <= 0) goto L10;
        int r103 = r100.getResources().getDimensionPixelSize(r102);     // Catch: Resources.NotFoundException -> L11
        int r104 = Resources.getSystem().getDimensionPixelSize(r102);     // Catch: Resources.NotFoundException -> L11
        if (r104 < r103) goto L8;
        return r104;
    L8:
        return Math.round((r103 * INVOKEVIRTUAL_com_gyf_barlibrary_BarConfig_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()).density) / INVOKEVIRTUAL_com_gyf_barlibrary_BarConfig_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density);
    L10:
        return 0;
    }
}
