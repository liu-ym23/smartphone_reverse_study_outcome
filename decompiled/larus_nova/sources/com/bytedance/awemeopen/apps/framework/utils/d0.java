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
import com.android.ttcjpaysdk.base.utils.CJPayGestureUtils;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.awemeopen.infra.base.settings.AoSettings;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f197687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f197688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f197689c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f197690d;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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

    public static int b(Context r100) {
        Resources r101 = r100.getResources();
        int r102 = r101.getIdentifier("config_showNavigationBar", "bool", "android");
        if (r102 <= 0) goto L5;
        boolean r103 = r101.getBoolean(r102);
    L19:
        Class r104 = a();     // Catch: Exception -> L12
        String r105 = (String) r104.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(r104, new Object[]{"qemu.hw.mainkeys"});     // Catch: Exception -> L12
        if ("1".equals(r105) == false) goto L9;
        r103 = false;
        goto L13
    L9:
        if ("0".equals(r105) == false) goto L13;
        r103 = true;
    L13:
        if (r103 == true) goto L15;
        return 0;
    L15:
        Resources r106 = r100.getResources();
        int r107 = r106.getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");
        if (r107 > 0) goto L18;
        return 0;
    L18:
        return r106.getDimensionPixelSize(r107);
    L5:
        r103 = false;
        goto L19
    }

    public static int c(Context r100) {
        int r101 = f197688b;
        if (r101 == 0) goto L5;
        return r101;
    L5:
        WindowManager r102 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        if (r102 == null) goto L9;
        Point r103 = new Point();
        r102.getDefaultDisplay().getSize(r103);
        f197687a = r103.x;
        f197688b = r103.y;
    L9:
        if (f197687a != 0) goto L11;
    L12:
        Resources r104 = r100.getResources();
        DisplayMetrics r105 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics());
        f197687a = r105.widthPixels;
        f197688b = r105.heightPixels;
    L14:
        return f197688b;
    L11:
        if (f197688b != 0) goto L14;
        goto L12
    }

    public static int d(Context r100) {
        int r101 = f197687a;
        if (r101 == 0) goto L5;
        return r101;
    L5:
        WindowManager r102 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        if (r102 == null) goto L9;
        Point r103 = new Point();
        r102.getDefaultDisplay().getSize(r103);
        f197687a = r103.x;
        f197688b = r103.y;
    L9:
        if (f197687a != 0) goto L11;
    L12:
        Resources r104 = r100.getResources();
        DisplayMetrics r105 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics());
        f197687a = r105.widthPixels;
        f197688b = r105.heightPixels;
    L14:
        return f197687a;
    L11:
        if (f197688b != 0) goto L14;
        goto L12
    }

    public static boolean e(Context r100) {
        if (f197689c == true) goto L5;
        f197689c = true;
        f197690d = false;
        if (r100 != null) goto L9;
        return false;
    L9:
        WindowManager r101 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        if (r101 == null) goto L19;
        Display r102 = r101.getDefaultDisplay();
        Point r103 = new Point();
        r102.getRealSize(r103);
        int r104 = r103.x;
        int r105 = r103.y;
        if (r104 >= r105) goto L14;
        float r106 = r104;
        float r107 = r105;
    L16:
        if ((r107 / r106) < 1.97f) goto L19;
        f197690d = true;
        goto L19
    L14:
        float r108 = r105;
        r107 = r104;
        r106 = r108;
    L19:
        return f197690d;
    L5:
        return f197690d;
    }

    public static boolean f(Activity r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        View r101 = r100.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L10;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L10;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L10:
        FrameLayout r103 = (FrameLayout) r101;
        int r104 = r103.getHeight();
        if (r103.getChildAt(0) == null) goto L13;
        int r105 = r103.getChildAt(0).getHeight();
    L14:
        int r106 = r104 - r105;
        JSONObject r107 = AoSettings.a("ao_screen_config");
        if (r107 != null) goto L17;
        boolean r108 = false;
    L18:
        if (r108 == false) goto L20;
        int r109 = 80;
    L24:
        if (r106 < r109) goto L27;
        return true;
    L27:
        return false;
    L20:
        Resources r110 = r100.getResources();
        int r111 = r110.getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");
        if (r111 == 0) goto L23;
        r109 = r110.getDimensionPixelSize(r111);
        goto L24
    L23:
        r109 = 0;
        goto L24
    L17:
        r108 = r107.optBoolean("is_use_default", false);
        goto L18
    L13:
        r105 = r104;
        goto L14
    }
}
