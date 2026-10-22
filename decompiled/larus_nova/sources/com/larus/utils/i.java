package com.larus.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class i {
    public static final FragmentActivity a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Activity r101 = getActivity(r100);
        if ((r101 instanceof FragmentActivity) == true) goto L7;
        return null;
    L7:
        return (FragmentActivity) r101;
    }

    public static final int b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        WindowManager r101 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        DisplayMetrics r102 = new DisplayMetrics();
        if (r101 == null) goto L6;
        r101.getDefaultDisplay().getRealMetrics(r102);
        return r102.heightPixels;
    L6:
        return c(r100);
    }

    public static final int c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Resources r101 = AppHost.f326268a.getApplication().getResources();
        return WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).heightPixels;
    }

    public static final int d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Resources r101 = AppHost.f326268a.getApplication().getResources();
        return WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).widthPixels;
    }

    public static final int e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        i0.f375410a.getClass();
        return i0.g();
    }

    public static final int f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r101 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager r102 = (WindowManager) r101;
        if (Build.VERSION.SDK_INT < 30) goto L5;
        int r103 = r102.getCurrentWindowMetrics().getBounds().width();
    L6:
        Resources r104 = r100.getResources();
        int r105 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).widthPixels;
        if (g(r100) == true) goto L11;
        if (r105 == r103) goto L10;
        return r105;
    L10:
        return r105 - e(r100);
    L11:
        return r105;
    L5:
        DisplayMetrics r106 = new DisplayMetrics();
        r102.getDefaultDisplay().getRealMetrics(r106);
        r103 = r106.widthPixels;
        goto L6
    }

    public static final boolean g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r101 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        if ((r101 instanceof WindowManager) == false) goto L5;
        WindowManager r102 = (WindowManager) r101;
    L7:
        if (r102 == null) goto L9;
        int r103 = r102.getDefaultDisplay().getRotation();
        if (r103 != 0) goto L15;
    L16:
        return true;
    L15:
        if (r103 == 2) goto L16;
        return false;
    L9:
        if (r100.getResources().getConfiguration().orientation != 1) goto L18;
        return true;
    L18:
        return false;
    L5:
        r102 = null;
        goto L7
    }

    public static final Activity getActivity(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
    L4:
        if (r100 == null) goto L12;
        if ((r100 instanceof Activity) == true) goto L8;
        if ((r100 instanceof ContextWrapper) == false) goto L12;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L4
    L8:
        return (Activity) r100;
    L12:
        return null;
    }

    public static final boolean h(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getResources().getConfiguration().getLayoutDirection() == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
