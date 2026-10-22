package com.bytedance.ee.util.ui;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import androidx.core.view.WindowInsetsCompat;
import com.android.ttcjpaysdk.base.utils.CJPayGestureUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes19.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f243163a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f243164b = -1;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.android.internal.R$dimen");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.android.internal.R$dimen");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.android.internal.R$dimen");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.android.internal.R$dimen");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.android.internal.R$dimen");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.android.internal.R$dimen");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.android.internal.R$dimen");
    }

    public static View b(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static int c(Activity r100) {
        int r101 = 0;
        View r102 = b(r100.getWindow());     // Catch: Throwable -> L11
        if ((r102 instanceof ViewGroup) == false) goto L13;
        View r103 = r102.findViewById(R.id.navigationBarBackground);     // Catch: Throwable -> L11
        if (r103 == null) goto L13;
        if (r103.getVisibility() != 0) goto L13;
        r101 = r103.getHeight();     // Catch: Throwable -> L11
    L13:
        tt5.a.b("StatusAndNavigationBarUtils", "navigationBarHeight:" + r101);
        return r101;
    L11:
        th = move-exception;
        tt5.a.f("StatusAndNavigationBarUtils", th, false);
        goto L13
    }

    public static int d(Context r100) {
        int r101 = f243163a;
        if (r101 != (-1)) goto L12;
        Resources r102 = r100.getResources();
        if (r102.getIdentifier("config_showNavigationBar", "bool", "android") == 0) goto L10;
        int r103 = r102.getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");
        if (r103 <= 0) goto L13;
        int r104 = r102.getDimensionPixelSize(r103);
        f243163a = r104;
        return r104;
    L13:
        return 0;
    L10:
        return 0;
    L12:
        return r101;
    }

    public static int e(Context r100) {
        int r101 = f243164b;
        if (r101 == (-1)) goto L5;
        return r101;
    L5:
        Resources r102 = r100.getResources();
        Class r103 = a();     // Catch: Exception -> L8
        f243164b = r102.getDimensionPixelSize(CastIntegerProtector.parseInt(r103.getField("status_bar_height").get(r103.newInstance()).toString()));     // Catch: Exception -> L8
    L11:
        if (f243164b > 0) goto L14;
        tt5.a.d("StatusAndNavigationBarUtils", "get the abnormal height value of the status bar " + f243164b);
    L14:
        return f243164b;
    L8:
        e = move-exception;
        Log.d(tt5.a.a(""), "StatusAndNavigationBarUtils", e);
        goto L11
    }

    public static boolean f(Context r100) {
        if ((r100 instanceof Activity) == false) goto L8;
        Activity r101 = (Activity) r100;
        int r102 = b(r101.getWindow()).getHeight();
        Point r103 = new Point();
        r101.getWindow().getWindowManager().getDefaultDisplay().getRealSize(r103);
        if (r102 == r103.y) goto L9;
        return true;
    L9:
        return false;
    L8:
        return false;
    }

    public static boolean g(Activity r100) {
        if (r100 != null) goto L5;
    L27:
        tt5.a.h("StatusAndNavigationBarUtils", "isNavigationBarExist, activity is null or activity is destroyed");
        return true;
    L5:
        if (r100.isDestroyed() == true) goto L27;
        Window r101 = r100.getWindow();
        if (r101 != null) goto L10;
        return true;
    L10:
        View r102 = b(r101);
        if (r102 != null) goto L14;
        return true;
    L14:
        if (Build.VERSION.SDK_INT < 23) goto L19;
        WindowInsets r103 = r102.getRootWindowInsets();
        if (r103 == null) goto L19;
        return WindowInsetsCompat.toWindowInsetsCompat(r103, r102).isVisible(WindowInsetsCompat.Type.statusBars());
    L19:
        View r104 = r102.findViewById(R.id.statusBarBackground);
        if (r104 != null) goto L23;
        return false;
    L23:
        if (r104.getHeight() != 0) goto L29;
        return false;
    L29:
        return true;
    }

    public static void h(Window r100) {
        int r101 = b(r100).getSystemUiVisibility();
        b(r100).setSystemUiVisibility(r101 | 1024);
    }
}
