package com.larus.utils;

import android.graphics.Color;
import android.view.View;
import android.view.Window;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.FragmentActivity;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class u {
    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static final int b(FragmentActivity r100) {
        if (r100 != null) goto L5;
        i0.f375410a.getClass();
        return i0.e();
    L5:
        Integer r101 = nda.d.a().ka(r100);
        if (r101 != null) goto L8;
    L17:
        i0.f375410a.getClass();
        return Math.min(i0.c(r100), i0.e());
    L8:
        if (r101.intValue() <= 0) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == true) goto L14;
        r101 = null;
    L14:
        if (r101 == null) goto L17;
        return r101.intValue();
    L10:
        r102 = false;
        goto L11
    }

    public static final int c(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        i0.f375410a.getClass();
        return i0.g();
    }

    public static final void d(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        WindowCompat.setDecorFitsSystemWindows(r100.getWindow(), false);
        r100.getWindow().setNavigationBarColor(Color.argb(1, 255, 255, 255));     // Catch: Exception -> L5
    L7:
        WindowCompat.getInsetsController(r100.getWindow(), a(r100.getWindow())).setAppearanceLightNavigationBars(true);
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("FragmentActivityExt", "exception=" + e.getMessage());
        goto L7
    }

    public static final void f(FragmentActivity r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        WindowCompat.setDecorFitsSystemWindows(r100.getWindow(), false);
        r100.getWindow().setStatusBarColor(0);
        r100.getWindow().setNavigationBarColor(0);
        WindowInsetsControllerCompat r102 = WindowCompat.getInsetsController(r100.getWindow(), a(r100.getWindow()));
        r102.setAppearanceLightStatusBars(r101);
        r102.setAppearanceLightNavigationBars(r101);
    }

    public static final void g(FragmentActivity r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.getWindow().setNavigationBarColor(0);
        WindowCompat.getInsetsController(r100.getWindow(), a(r100.getWindow())).setAppearanceLightNavigationBars(r101);
    }

    public static final void h(FragmentActivity r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.getWindow().setStatusBarColor(0);
        r100.getWindow().setNavigationBarColor(0);
        WindowInsetsControllerCompat r102 = WindowCompat.getInsetsController(r100.getWindow(), a(r100.getWindow()));
        r102.setAppearanceLightStatusBars(r101);
        r102.setAppearanceLightNavigationBars(r101);
    }

    public static final void e(FragmentActivity r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        WindowCompat.setDecorFitsSystemWindows(r100.getWindow(), false);
        r100.getWindow().setStatusBarColor(Color.argb(1, 255, 255, 255));     // Catch: Exception -> L5
    L7:
        WindowInsetsControllerCompat r103 = WindowCompat.getInsetsController(r100.getWindow(), a(r100.getWindow()));
        if (r102 == false) goto L10;
        r103.setAppearanceLightStatusBars(false);
        return;
    L10:
        r103.setAppearanceLightStatusBars(r101);
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("FragmentActivityExt", "exception=" + e.getMessage());
        goto L7
    }
}
