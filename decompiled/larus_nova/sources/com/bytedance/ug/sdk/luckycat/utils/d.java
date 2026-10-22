package com.bytedance.ug.sdk.luckycat.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.view.Window;
import com.bytedance.ug.sdk.luckycat.impl.manager.m;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f271554f = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f271555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f271556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f271557c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f271558d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f271559e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f271560a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f271561b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f271562c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f271563d;

        public a() {
            this.f271560a = m.a.f271349a.f271333a.getResources().getColor(R.color.polaris_status_bar_color_white);
            this.f271561b = false;
            this.f271562c = false;
            this.f271563d = true;
        }

        public final void a(int r100) {
            this.f271560a = m.a.f271349a.f271333a.getResources().getColor(r100);
        }
    }

    public final void d() {
        boolean r100 = f271554f;
        if (r100 == false) goto L12;
        int r101 = this.f271556b;
        if (r100 == false) goto L9;
        this.f271556b = r101;
        Activity r102 = this.f271555a;
        if (r100 == false) goto L9;
        r102.getWindow().setStatusBarColor(r101);
    L9:
        boolean r103 = this.f271558d;
        c(this.f271555a.getWindow(), r103);
        if (this.f271559e == false) goto L14;
        a(this.f271555a.getWindow()).setSystemUiVisibility(1024);
        return;
    L14:
        return;
    L12:
        this.f271555a.getWindow().clearFlags(Integer.MIN_VALUE);
    }

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

    public d(Activity r100, a r101) {
        this.f271555a = r100;
        this.f271556b = r101.f271560a;
        this.f271559e = r101.f271561b;
        this.f271558d = r101.f271562c;
        if (r101.f271563d == false) goto L6;
        f271554f = true;
        return;
    }

    public static int b(Context r100, boolean r101) {
        int r102 = r100.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r102 <= 0) goto L7;
        if (r101 == false) goto L6;
        int r103 = r100.getResources().getDimensionPixelSize(r102);
    L8:
        if (r101 == false) goto L10;
        Resources r104 = r100.getResources();
        int r105 = (int) ((25.0f * WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).density) + 0.5f);
    L11:
        if (r103 == 0) goto L13;
        return r103;
    L13:
        return r105;
    L10:
        r105 = 25;
        goto L11
    L6:
        float r106 = r100.getResources().getDimension(r102);
        Resources r107 = r100.getResources();
        r103 = (int) (r106 / WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics()).density);
        goto L8
    L7:
        r103 = 0;
        goto L8
    }

    public static void c(Window r100, boolean r101) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return;
    L5:
        if (f271554f == false) goto L33;
        int r102 = a(r100).getSystemUiVisibility();
        View r103 = a(r100);
        if (r101 == false) goto L9;
        int r104 = r102 | 8192;
    L10:
        r103.setSystemUiVisibility(r104);
        if (c.f271553b == true) goto L17;
        if (c.a("miui.os.Build") == null) goto L15;
        c.f271552a = true;     // Catch: Exception -> L27
    L15:
        c.f271553b = true;
    L17:
        if (c.f271552a == false) goto L34;
        Class<?> r105 = r100.getClass();     // Catch: Throwable -> L24
        Class r106 = c.a("android.view.MiuiWindowManager$LayoutParams");     // Catch: Throwable -> L24
        int r107 = r106.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(r106);     // Catch: Throwable -> L24
        Class<?> r108 = Integer.TYPE;     // Catch: Throwable -> L24
        Method r109 = r105.getMethod("setExtraFlags", new Class[]{r108, r108});     // Catch: Throwable -> L24
        Object[] r110 = new Object[2];     // Catch: Throwable -> L24
        if (r101 == false) goto L21;
        int r111 = r107;
    L22:
        r110[0] = Integer.valueOf(r111);     // Catch: Throwable -> L24
        r110[1] = Integer.valueOf(r107);     // Catch: Throwable -> L24
        r109.invoke(r100, r110);     // Catch: Throwable -> L24
        return;
    L21:
        r111 = 0;
    L24:
        th = move-exception;
        th.printStackTrace();
        return;
    L34:
        return;
    L9:
        r104 = r102 & (-8193);
        goto L10
    }
}
