package com.larus.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f375450a;

    static {
    }

    public static int a(Context r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 30) goto L17;
        if ((r100 instanceof Activity) == false) goto L10;
        WindowManager r102 = ((Activity) r100).getWindowManager();
        Intrinsics.checkNotNull(r102);
    L11:
        WindowMetrics r103 = r102.getCurrentWindowMetrics();
        if (r103 == null) goto L29;
        Rect r104 = r103.getBounds();
        if (r104 != null) goto L31;
        return 0;
    L31:
        return r104.height();
    L29:
        return 0;
    L10:
        Object r105 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.view.WindowManager");
        r102 = (WindowManager) r105;
        goto L11
    L17:
        if ((r100 instanceof Activity) == false) goto L23;
        if (r101 < 30) goto L22;
        Display r106 = ((Activity) r100).getDisplay();
        if (r106 == null) goto L22;
    L25:
        if (r106 == null) goto L32;
        DisplayMetrics r107 = new DisplayMetrics();
        r106.getRealMetrics(r107);
        return r107.heightPixels;
    L32:
        return 0;
    L22:
        WindowManager r108 = ((Activity) r100).getWindowManager();
        Intrinsics.checkNotNull(r108);
    L24:
        r106 = r108.getDefaultDisplay();
        goto L25
    L23:
        Object r109 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type android.view.WindowManager");
        r108 = (WindowManager) r109;
        goto L24
    }

    public static int b(Context r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        Resources r101 = r100.getResources();
        return WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).widthPixels;
    }

    public static int c(Context r100) {
        int r101 = f375450a;
        if (r101 <= 0) goto L5;
        return r101;
    L5:
        int r102 = b(r100);
        f375450a = r102;
        return r102;
    }

    public static boolean d(WindowInsets r100) {
        Intrinsics.checkNotNullParameter(r100, "insets");
        if (Build.VERSION.SDK_INT < 30) goto L6;
        return r100.isVisible(WindowInsets.Type.navigationBars());
    L6:
        if (r100.getSystemWindowInsetBottom() <= 0) goto L8;
        return true;
    L8:
        return false;
    }

    public static boolean e(View r100) {
        Intrinsics.checkNotNullParameter(r100, "bottomView");
        int[] r101 = new int[2];
        r100.getLocationOnScreen(r101);
        int r102 = r101[1] + r100.getHeight();
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        if ((r103 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r103;
    L7:
        if (r104 == null) goto L9;
        int r105 = r104.bottomMargin;
    L10:
        int r106 = r102 + r105;
        int r107 = a(r100.getContext());
        FLogger.f375446a.i("ScreenUtils", "isViewMeetScreenBottom viewBottom=" + r106 + " screenHeight=" + r107);
        if (r106 >= r107) goto L15;
        return false;
    L15:
        return true;
    L9:
        r105 = 0;
        goto L10
    L5:
        r104 = null;
        goto L7
    }
}
