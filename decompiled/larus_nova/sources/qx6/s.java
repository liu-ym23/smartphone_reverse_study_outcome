package qx6;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes21.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Field f535152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f535153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Field f535154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Field f535155d;

    static {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.view.MiuiWindowManager$LayoutParams");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.view.MiuiWindowManager$LayoutParams");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.view.MiuiWindowManager$LayoutParams");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.view.MiuiWindowManager$LayoutParams");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.view.MiuiWindowManager$LayoutParams");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.view.MiuiWindowManager$LayoutParams");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.view.MiuiWindowManager$LayoutParams");
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

    public static void c(Window r100) {
        if (Build.VERSION.SDK_INT < 23) goto L84;
        if (r100 != null) goto L7;
        return;
    L7:
        if (b(r100) != null) goto L9;
        return;
    L9:
        View r101 = b(r100);
        if (r101 == null) goto L16;
        int r102 = r101.getSystemUiVisibility();
        if ((r102 & 8192) == 8192) goto L16;
        r101.setSystemUiVisibility(r102 | 8192);
    L16:
        int r103 = 0;
    L21:
        th = move-exception;
        th.printStackTrace();
    L46:
        if (Build.DISPLAY.contains("Flyme") == false) goto L48;
    L51:
        boolean r104 = true;
    L52:
        if (r104 == false) goto L85;
        WindowManager.LayoutParams r105 = r100.getAttributes();     // Catch: Throwable -> L75
        if (f535155d != null) goto L59;
        Field r106 = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");     // Catch: Throwable -> L75
        f535155d = r106;     // Catch: Throwable -> L75
        if (r106 == null) goto L59;
        r106.setAccessible(true);     // Catch: Throwable -> L75
    L59:
        if (f535154c != null) goto L63;
        Field r107 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");     // Catch: Throwable -> L75
        f535154c = r107;     // Catch: Throwable -> L75
        if (r107 == null) goto L63;
        r107.setAccessible(true);     // Catch: Throwable -> L75
    L63:
        Field r108 = f535155d;     // Catch: Throwable -> L75
        if (r108 == null) goto L66;
        int r109 = r108.getInt(null);     // Catch: Throwable -> L75
    L67:
        Field r110 = f535154c;     // Catch: Throwable -> L75
        if (r110 == null) goto L70;
        r103 = r110.getInt(r105);     // Catch: Throwable -> L75
    L70:
        int r111 = r109 | r103;     // Catch: Throwable -> L75
        Field r112 = f535154c;     // Catch: Throwable -> L75
        if (r112 == null) goto L73;
        r112.setInt(r105, r111);     // Catch: Throwable -> L75
    L73:
        r100.setAttributes(r105);     // Catch: Throwable -> L75
        return;
    L66:
        r109 = 0;
    L75:
        th = move-exception;
        th.printStackTrace();
        return;
    L85:
        return;
    L48:
        if ("flyme".equals(Build.USER) == true) goto L51;
        r104 = false;
        goto L52
    L18:
        if (q.a() == null) goto L23;
        q.f535151a = true;     // Catch: Throwable -> L21 Exception -> L78
        boolean r113 = true;
    L24:
        if (r113 == false) goto L46;
        Class<?> r114 = r100.getClass();     // Catch: Throwable -> L21
        Class r115 = a();     // Catch: Throwable -> L21
        if (f535152a != null) goto L28;
    L29:
        Field r116 = r115.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");     // Catch: Throwable -> L21
        f535152a = r116;     // Catch: Throwable -> L21
        if (r116 == null) goto L33;
        r116.setAccessible(true);     // Catch: Throwable -> L21
    L33:
        Class<?> r117 = Integer.TYPE;     // Catch: Throwable -> L21
        Method r118 = r114.getMethod("setExtraFlags", new Class[]{r117, r117});     // Catch: Throwable -> L21
        f535153b = r118;     // Catch: Throwable -> L21
        if (r118 == null) goto L36;
        r118.setAccessible(true);     // Catch: Throwable -> L21
    L36:
        Field r119 = f535152a;     // Catch: Throwable -> L21
        if (r119 == null) goto L39;
        int r120 = r119.getInt(r115);     // Catch: Throwable -> L21
    L40:
        Method r121 = f535153b;     // Catch: Throwable -> L21
        if (r121 == null) goto L46;
        r121.invoke(r100, new Object[]{Integer.valueOf(r120), Integer.valueOf(r120)});     // Catch: Throwable -> L21
        goto L46
    L39:
        r120 = 0;
        goto L40
    L28:
        if (f535153b != null) goto L36;
    L23:
        r113 = q.f535151a;     // Catch: Throwable -> L21
        goto L24
    }
}
