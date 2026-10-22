package com.ss.android.lark.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes38.dex */
public class StatusBarUtil {
    public static final int DEFAULT_STATUS_BAR_ALPHA = 112;
    private static final int FAKE_STATUS_BAR_VIEW_ID = 2131387322;
    private static final int FAKE_TRANSLUCENT_VIEW_ID = 2131387323;
    private static final int TAG_KEY_HAVE_SET_OFFSET = -123;

    public StatusBarUtil() {
    }

    public static View INVOKEVIRTUAL_com_ss_android_lark_utils_StatusBarUtil_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    private static void clearPreviousSetting(Activity r100) {
        ViewGroup r101 = (ViewGroup) INVOKEVIRTUAL_com_ss_android_lark_utils_StatusBarUtil_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow());
        View r102 = r101.findViewById(FAKE_STATUS_BAR_VIEW_ID);
        if (r102 == null) goto L6;
        r101.removeView(r102);
        ((ViewGroup) ((ViewGroup) r100.findViewById(R.id.content)).getChildAt(0)).setPadding(0, 0, 0, 0);
        return;
    }

    public static int getStatusBarHeight(Context r100) {
        int r101 = r100.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return r100.getResources().getDimensionPixelSize(r101);
    }

    public static void hideStatusBar(Activity r100) {
        if (r100 == null) goto L5;
        r100.getWindow().addFlags(1024);
        return;
    }

    public static void setTransparent(Activity r100) {
        setTranslucentForImageView(r100, 0, new View[0]);
    }

    private static void setTransparentForWindow(Activity r100) {
        r100.getWindow().setStatusBarColor(0);
        int r101 = INVOKEVIRTUAL_com_ss_android_lark_utils_StatusBarUtil_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()).getSystemUiVisibility();
        INVOKEVIRTUAL_com_ss_android_lark_utils_StatusBarUtil_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()).setSystemUiVisibility((r101 | 256) | 1024);
    }

    public static void showStatusBar(Activity r100) {
        if (r100 == null) goto L5;
        r100.getWindow().clearFlags(1024);
        return;
    }

    private static void addTranslucentView(Activity r100, int r101) {
        ViewGroup r102 = (ViewGroup) r100.findViewById(R.id.content);
        View r103 = r102.findViewById(FAKE_TRANSLUCENT_VIEW_ID);
        if (r103 != null) goto L5;
        r102.addView(createTranslucentStatusBarView(r100, r101));
        return;
    L5:
        if (r103.getVisibility() != 8) goto L7;
        r103.setVisibility(0);
    L7:
        r103.setBackgroundColor(Color.argb(r101, 0, 0, 0));
    }

    private static View createTranslucentStatusBarView(Activity r100, int r101) {
        View r102 = new View(r100);
        r102.setLayoutParams(new LinearLayout.LayoutParams(-1, getStatusBarHeight(r100)));
        r102.setBackgroundColor(Color.argb(r101, 0, 0, 0));
        r102.setId(FAKE_TRANSLUCENT_VIEW_ID);
        return r102;
    }

    public static void setTranslucentForImageViewInFragment(Activity r100, View r101) {
        setTranslucentForImageViewInFragment(r100, 112, r101);
    }

    public static void setTransparentForImageView(Activity r100, View... r101) {
        setTranslucentForImageView(r100, 0, r101);
    }

    public static void setTransparentForImageViewInFragment(Activity r100, View r101) {
        setTranslucentForImageViewInFragment(r100, 0, r101);
    }

    public static void setTranslucentForImageView(Activity r100, int r101, View... r110) {
        if (r100.getWindow() != null) goto L5;
        return;
    L5:
        com.ss.android.lark.insets.h r102 = WindowInsetsUtils.c(r100);
        int r103 = 0;
        r102.c(false);
        r102.b(Color.argb(r101, 0, 0, 0));
        setTransparentForWindow(r100);
        if (r110 != null) goto L8;
        return;
    L8:
        int r104 = r110.length;
    L9:
        if (r103 >= r104) goto L20;
        View r105 = r110[r103];
        if (r105 == null) goto L19;
        Object r106 = r105.getTag(-123);
        if (r106 != null) goto L16;
    L18:
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r105.getLayoutParams();
        r107.setMargins(r107.leftMargin, r107.topMargin + getStatusBarHeight(r100), r107.rightMargin, r107.bottomMargin);
        r105.setTag(-123, Boolean.TRUE);
        goto L19
    L16:
        if (((Boolean) r106).booleanValue() == false) goto L18;
    L19:
        r103 = r103 + 1;
        goto L9
    }

    public static void setTranslucentForImageViewInFragment(Activity r100, int r101, View r102) {
        setTranslucentForImageView(r100, r101, new View[]{r102});
    }
}
