package zma;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.Size;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.view.WindowMetrics;
import bna.e;
import com.android.ttcjpaysdk.base.utils.CJPayGestureUtils;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import pla.d;
import wma.b;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f572881a = null;

    static {
        f572881a = new a();
    }

    public a() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    @JvmStatic
    public static final Size c(Context r100) {
        if (r100 == null) goto L4;
        Activity r101 = f572881a.getActivity(r100);
        if (r101 != null) goto L8;
        Object r102 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        Rect r103 = null;
        if ((r102 instanceof WindowManager) == false) goto L12;
        WindowManager r104 = (WindowManager) r102;
    L14:
        if (Build.VERSION.SDK_INT < 30) goto L21;
        if (r104 == null) goto L21;
        WindowMetrics r105 = r104.getCurrentWindowMetrics();
        if (r105 == null) goto L21;
        r103 = r105.getBounds();
    L21:
        if (r103 == null) goto L25;
        return new Size(r103.width(), r103.height());
    L25:
        return new Size(d.j(r100), d.i(r100));
    L12:
        r104 = null;
        goto L14
    L8:
        return new Size(e.b(r101).a().width(), e.b(r101).a().height());
    L4:
        return new Size(0, 0);
    }

    public static int d(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        WindowInsetsController r101 = r100.getWindowInsetsController();     // Catch: Exception -> L34
        if (r101 != null) goto L6;
        return 0;
    L6:
        Method r102 = r101.getClass().getDeclaredMethod("getState", new Class[0]);     // Catch: Exception -> L34
        r102.setAccessible(true);     // Catch: Exception -> L34
        Object r103 = r102.invoke(r101, new Object[0]);     // Catch: Exception -> L34
        int r104 = Build.VERSION.SDK_INT;     // Catch: Exception -> L34
        if (r104 < 35) goto L9;
        Class r105 = a("android.view.InsetsSource");     // Catch: Exception -> L34
    L10:
        if (r104 < 35) goto L12;
        Field r106 = r105.getDeclaredField("ID_IME");     // Catch: Exception -> L34
    L13:
        r106.setAccessible(true);     // Catch: Exception -> L34
        Rect r107 = null;
        int r108 = r106.getInt(null);     // Catch: Exception -> L34
        Method r109 = r103.getClass().getDeclaredMethod("peekSource", new Class[]{Integer.TYPE});     // Catch: Exception -> L34
        r109.setAccessible(true);     // Catch: Exception -> L34
        Object r110 = r109.invoke(r103, new Object[]{Integer.valueOf(r108)});     // Catch: Exception -> L34
        if (r110 != null) goto L17;
        r110 = null;
    L17:
        if (r110 != null) goto L19;
        return 0;
    L19:
        Method r111 = r110.getClass().getDeclaredMethod("isVisible", new Class[0]);     // Catch: Exception -> L34
        r111.setAccessible(true);     // Catch: Exception -> L34
        Object r112 = r111.invoke(r110, new Object[0]);     // Catch: Exception -> L34
        if ((r112 instanceof Boolean) == false) goto L22;
        Boolean r113 = (Boolean) r112;     // Catch: Exception -> L34
    L23:
        if (r113 != null) goto L26;
        return 0;
    L26:
        if (r113.booleanValue() == false) goto L36;
        Method r114 = r110.getClass().getDeclaredMethod("getFrame", new Class[0]);     // Catch: Exception -> L34
        r114.setAccessible(true);     // Catch: Exception -> L34
        Object r115 = r114.invoke(r110, new Object[0]);     // Catch: Exception -> L34
        if ((r115 instanceof Rect) == false) goto L30;
        r107 = (Rect) r115;     // Catch: Exception -> L34
    L30:
        if (r107 != null) goto L32;
        return 0;
    L32:
        return r107.height();
    L36:
        return 0;
    L22:
        r113 = null;
        goto L23
    L12:
        r106 = r105.getDeclaredField("ITYPE_IME");     // Catch: Exception -> L34
        goto L13
    L9:
        r105 = a("android.view.InsetsState");     // Catch: Exception -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
        goto L36
    }

    public static int e(Context r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r101 = r100.getResources().getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");
        if (r101 > 0) goto L8;
        Class r102 = a("com.android.internal.R$dimen");     // Catch: Exception -> L11
        Object r103 = r102.newInstance();     // Catch: Exception -> L11
        int r104 = CastIntegerProtector.parseInt(r102.getField(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT).get(r103).toString());     // Catch: Exception -> L11
        return r100.getResources().getDimensionPixelSize(r104);
    L11:
        return 0;
    L8:
        return r100.getResources().getDimensionPixelSize(r101);
    }

    @JvmStatic
    public static final boolean g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (Build.VERSION.SDK_INT < 29) goto L10;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r101 = r100.getResources();
        int r102 = r101.getIdentifier("config_navBarInteractionMode", "integer", "android");
        if (r102 > 0) goto L7;
        return false;
    L7:
        if (r101.getInteger(r102) == 2) goto L9;
        return false;
    L9:
        return true;
    L10:
        return false;
    }

    public static boolean h(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r100.getResources().getConfiguration().orientation != 2) goto L9;
        return true;
    L9:
        return false;
    L7:
        e = move-exception;
        b.c("OWindowConfigController", "isLandscape error", e);
        goto L9
    }

    public final Activity getActivity(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((r100 instanceof Activity) == false) goto L7;
        return (Activity) r100;
    L7:
        if ((r100 instanceof ContextWrapper) == true) goto L9;
        return null;
    L9:
        return getActivity(((ContextWrapper) r100).getBaseContext());
    }

    @JvmStatic
    public static final void b(Context r100, WindowManager.LayoutParams r101, Boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "params");
        int r103 = Build.VERSION.SDK_INT;
        if (r103 >= 28) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        a r104 = f572881a;
        if (h(r100) == true) goto L10;
        return;
    L10:
        Activity r105 = r104.getActivity(r100);
        if (r102 != null) goto L13;
        if (r105 == null) goto L25;
        Window r106 = r105.getWindow();
        if (r106 == null) goto L25;
        WindowManager.LayoutParams r107 = r106.getAttributes();
        if (r107 == null) goto L25;
        int r108 = r107.layoutInDisplayCutoutMode;
    L27:
        r101.layoutInDisplayCutoutMode = r108;
        return;
    L25:
        r108 = 2;
        goto L27
    L13:
        if (r102.booleanValue() == false) goto L25;
        if (r103 < 30) goto L17;
        r108 = 3;
        goto L27
    L17:
        r108 = 1;
        goto L27
    }

    @JvmStatic
    public static final xma.b f(View r100, WindowInsets r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (Build.VERSION.SDK_INT < 23) goto L5;
        if (r101 != null) goto L8;
        r101 = r100.getRootWindowInsets();
    L8:
        if (r101 != null) goto L12;
        return xma.b.f564553e;
    L12:
        if (r102 == false) goto L16;
        return xma.e.a(r101, null).f564561a.f(7);
    L16:
        return xma.e.a(r101, null).f564561a.k();
    L5:
        return xma.b.f564553e;
    }
}
