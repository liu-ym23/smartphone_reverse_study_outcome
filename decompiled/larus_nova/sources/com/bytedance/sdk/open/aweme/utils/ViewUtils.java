package com.bytedance.sdk.open.aweme.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes22.dex */
public final class ViewUtils {
    public static final int IMAGE_VIEW_OFFSET = 2131387320;
    public static final int STATUS_BAR_VIEW_ID = 2131387321;

    private ViewUtils() {
        throw new IllegalStateException("no instance.");
    }

    private static void addTranslucentView(Activity r100, int r101) {
        ViewGroup r102 = (ViewGroup) r100.findViewById(R.id.content);
        View r103 = r102.findViewById(STATUS_BAR_VIEW_ID);
        if (r103 != null) goto L5;
        r102.addView(createStatusBarView(r100, Color.argb(r101, 0, 0, 0)));
        return;
    L5:
        if (r103.getVisibility() != 8) goto L7;
        r103.setVisibility(0);
    L7:
        r103.setBackgroundColor(Color.argb(r101, 0, 0, 0));
    }

    private static View createStatusBarView(Activity r100, int r101) {
        View r102 = new View(r100);
        r102.setLayoutParams(new ViewGroup.LayoutParams(-1, getStatusBarHeight(r100)));
        r102.setBackgroundColor(r101);
        r102.setId(STATUS_BAR_VIEW_ID);
        return r102;
    }

    public static int getStatusBarHeight(Context r100) {
        int r101 = r100.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return r100.getResources().getDimensionPixelSize(r101);
    }

    private static void setRootView(Activity r100) {
        ViewGroup r101 = (ViewGroup) r100.findViewById(R.id.content);
        int r102 = r101.getChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        View r104 = r101.getChildAt(r103);
        if ((r104 instanceof ViewGroup) == false) goto L7;
        r104.setFitsSystemWindows(true);
        ((ViewGroup) r104).setClipToPadding(true);
    L7:
        r103 = r103 + 1;
        goto L3
    }

    public static void setStatusBarColor(Activity r100, int r101) {
        r100.getWindow().addFlags(Integer.MIN_VALUE);
        r100.getWindow().clearFlags(67108864);
        r100.getWindow().setStatusBarColor(r101);
    }

    public static void setStatusBarDarkMode(Activity r100) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        INVOKEVIRTUAL_com_bytedance_sdk_open_aweme_utils_ViewUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()).setSystemUiVisibility(1024);
        return;
    }

    public static void setStatusBarLightMode(Activity r100) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        INVOKEVIRTUAL_com_bytedance_sdk_open_aweme_utils_ViewUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()).setSystemUiVisibility(9216);
        return;
    }

    public static void setStatusBarTranslucentForImageView(Activity r100, int r101, View r102) {
        r100.getWindow().addFlags(Integer.MIN_VALUE);
        r100.getWindow().clearFlags(67108864);
        INVOKEVIRTUAL_com_bytedance_sdk_open_aweme_utils_ViewUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()).setSystemUiVisibility(1280);
        r100.getWindow().setStatusBarColor(0);
        ViewGroup r103 = (ViewGroup) r100.findViewById(R.id.content);
        int r104 = r103.getChildCount();
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L8;
        View r106 = r103.getChildAt(r105);
        if ((r106 instanceof ViewGroup) == false) goto L7;
        r106.setFitsSystemWindows(false);
    L7:
        r105 = r105 + 1;
        goto L3
    L8:
        addTranslucentView(r100, r101);
        if (r102 == null) goto L20;
        int r107 = IMAGE_VIEW_OFFSET;
        Object r108 = r102.getTag(r107);
        if (r108 != null) goto L13;
    L15:
        ViewGroup.MarginLayoutParams r109 = (ViewGroup.MarginLayoutParams) r102.getLayoutParams();
        r109.setMargins(r109.leftMargin, r109.topMargin + getStatusBarHeight(r100), r109.rightMargin, r109.bottomMargin);
        r102.setTag(r107, Boolean.TRUE);
        return;
    L13:
        if (((Boolean) r108).booleanValue() == false) goto L15;
        return;
    }

    public static void setTranslucentStatusBar(Activity r100, int r101) {
        setTransparent(r100);
        addTranslucentView(r100, r101);
    }

    public static void setTransparent(Activity r100) {
        r100.getWindow().addFlags(Integer.MIN_VALUE);
        r100.getWindow().clearFlags(67108864);
        r100.getWindow().setStatusBarColor(0);
        setRootView(r100);
    }

    public static View INVOKEVIRTUAL_com_bytedance_sdk_open_aweme_utils_ViewUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }
}
