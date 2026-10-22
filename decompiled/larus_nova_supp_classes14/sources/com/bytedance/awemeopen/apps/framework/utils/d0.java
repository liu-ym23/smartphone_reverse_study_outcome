package com.bytedance.awemeopen.apps.framework.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.awemeopen.infra.base.settings.AoSettings;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d0 {
    public static int a;
    public static int b;
    public static volatile boolean c;
    public static volatile boolean d;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.os.SystemProperties");
    }

    public static int b(Context r8) {
        Resources r0 = r8.getResources();
        int r1 = r0.getIdentifier("config_showNavigationBar", "bool", "android");
        if (r1 <= 0) goto L5;
        boolean r2 = r0.getBoolean(r1);
    L19:
        Class r3 = a();     // Catch: Exception -> L12
        String r4 = (String) r3.getMethod("get", new Class[]{String.class}).invoke(r3, new Object[]{"qemu.hw.mainkeys"});     // Catch: Exception -> L12
        if (CommentScene.COMMENTSCENE_NO_AWEME.equals(r4) == false) goto L9;
        r2 = false;
        goto L13
    L9:
        if ("0".equals(r4) == false) goto L13;
        r2 = true;
    L13:
        if (r2 == true) goto L15;
        return 0;
    L15:
        Resources r9 = r8.getResources();
        int r5 = r9.getIdentifier("navigation_bar_height", "dimen", "android");
        if (r5 > 0) goto L18;
        return 0;
    L18:
        return r9.getDimensionPixelSize(r5);
    L5:
        r2 = false;
        goto L19
    }

    public static int c(Context r2) {
        int r0 = b;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        WindowManager r1 = (WindowManager) r2.getSystemService("window");
        if (r1 == null) goto L9;
        Point r3 = new Point();
        r1.getDefaultDisplay().getSize(r3);
        a = r3.x;
        b = r3.y;
    L9:
        if (a != 0) goto L11;
    L12:
        Resources r4 = r2.getResources();
        DisplayMetrics r5 = WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics());
        a = r5.widthPixels;
        b = r5.heightPixels;
    L14:
        return b;
    L11:
        if (b != 0) goto L14;
        goto L12
    }

    public static int d(Context r2) {
        int r0 = a;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        WindowManager r1 = (WindowManager) r2.getSystemService("window");
        if (r1 == null) goto L9;
        Point r3 = new Point();
        r1.getDefaultDisplay().getSize(r3);
        a = r3.x;
        b = r3.y;
    L9:
        if (a != 0) goto L11;
    L12:
        Resources r4 = r2.getResources();
        DisplayMetrics r5 = WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics());
        a = r5.widthPixels;
        b = r5.heightPixels;
    L14:
        return a;
    L11:
        if (b != 0) goto L14;
        goto L12
    }

    public static boolean e(Context r3) {
        if (c == true) goto L5;
        c = true;
        d = false;
        if (r3 != null) goto L9;
        return false;
    L9:
        WindowManager r4 = (WindowManager) r3.getSystemService("window");
        if (r4 == null) goto L19;
        Display r5 = r4.getDefaultDisplay();
        Point r1 = new Point();
        r5.getRealSize(r1);
        int r6 = r1.x;
        int r2 = r1.y;
        if (r6 >= r2) goto L14;
        float r7 = r6;
        float r8 = r2;
    L16:
        if ((r8 / r7) < 1.97f) goto L19;
        d = true;
        goto L19
    L14:
        float r9 = r2;
        r8 = r6;
        r7 = r9;
    L19:
        return d;
    L5:
        return d;
    }

    public static boolean f(Activity r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        View r1 = r5.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L10;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r2 = ThreadMethodProxy.currentThread();
        if (r2 == com.larus.home.impl.utils.c.a) goto L10;
        com.larus.home.impl.utils.c.a(r2, "getDecorView");
    L10:
        FrameLayout r3 = (FrameLayout) r1;
        int r4 = r3.getHeight();
        if (r3.getChildAt(0) == null) goto L13;
        int r6 = r3.getChildAt(0).getHeight();
    L14:
        int r7 = r4 - r6;
        JSONObject r8 = AoSettings.a("ao_screen_config");
        if (r8 != null) goto L17;
        boolean r9 = false;
    L18:
        if (r9 == false) goto L20;
        int r10 = 80;
    L24:
        if (r7 < r10) goto L27;
        return true;
    L27:
        return false;
    L20:
        Resources r11 = r5.getResources();
        int r12 = r11.getIdentifier("navigation_bar_height", "dimen", "android");
        if (r12 == 0) goto L23;
        r10 = r11.getDimensionPixelSize(r12);
        goto L24
    L23:
        r10 = 0;
        goto L24
    L17:
        r9 = r8.optBoolean("is_use_default", false);
        goto L18
    L13:
        r6 = r4;
        goto L14
    }
}
