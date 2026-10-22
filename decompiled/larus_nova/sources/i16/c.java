package i16;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.android.ttcjpaysdk.base.utils.CJPayGestureUtils;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.ies.bullet.base.utils.RomUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import me.ele.lancet.base.annotations.Skip;
import w26.e;
import w26.g;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f487996a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static float f487997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f487998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static float f487999d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f488000a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f488001b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f488000a == r101.f488000a) goto L12;
            return false;
        L12:
            if (this.f488001b == r101.f488001b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f488000a * 31) + this.f488001b;
        }

        public final String toString() {
            return "DisplayMetric(width=" + this.f488000a + ", height=" + this.f488001b + ')';
        }

        public a(int r100, int r101) {
            this.f488000a = r100;
            this.f488001b = r101;
        }
    }

    public c() {
    }

    static {
        f487996a = new c();
        f487997b = -1.0f;
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

    public static DisplayMetrics c(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static boolean d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r101 = r100.getResources();
        int r102 = r101.getIdentifier("config_showNavigationBar", "bool", "android");
        if (r102 <= 0) goto L5;
        boolean r103 = r101.getBoolean(r102);
    L15:
        Class r104 = a("android.os.SystemProperties");     // Catch: Exception -> L14
        Object r105 = r104.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(r104, new Object[]{"qemu.hw.mainkeys"});     // Catch: Exception -> L14
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L14
        String r106 = (String) r105;     // Catch: Exception -> L14
        if (Intrinsics.areEqual("1", r106) == true) goto L17;
        if (Intrinsics.areEqual("0", r106) == false) goto L13;
        return true;
    L17:
        return false;
    L13:
        return r103;
    L5:
        r103 = false;
        goto L15
    }

    @JvmStatic
    public static final a g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = -1;
        Object r102 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Exception -> L10
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.view.WindowManager");     // Catch: Exception -> L10
        Display r103 = ((WindowManager) r102).getDefaultDisplay();     // Catch: Exception -> L10
        Point r104 = new Point();     // Catch: Exception -> L10
        if (r103 == null) goto L6;
        r103.getRealSize(r104);     // Catch: Exception -> L10
        int r105 = l(r104.x, r100);     // Catch: Exception -> L10
        r101 = l(r104.y, r100);     // Catch: Exception -> L13
    L12:
        return new a(r105, r101);
    L6:
        return new a(-1, -1);
    L10:
        r105 = -1;
        goto L12
    }

    public static int i(Context r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        DisplayMetrics r101 = c(r100.getResources());
        if (r101 != null) goto L8;
        return 0;
    L8:
        return r101.heightPixels;
    }

    public static int j(Context r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        DisplayMetrics r101 = c(r100.getResources());
        if (r101 != null) goto L8;
        return 0;
    L8:
        return r101.widthPixels;
    }

    public final Resources getResources(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r101 = r100.getResources();
        if (r101 == null) goto L5;
        return r101;
    L5:
        return Resources.getSystem();
    }

    public final int h(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (((Boolean) RomUtils.f246320a.getValue()).booleanValue() == true) goto L5;
    L7:
        Resources r100 = r110.getResources();
        int r101 = r100.getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");
        if (r101 <= 0) goto L10;
        int r102 = r100.getDimensionPixelSize(r101);
    L11:
        Rect r103 = new Rect();
        if ((r110 instanceof Activity) == false) goto L31;
        b(((Activity) r110).getWindow()).getWindowVisibleDisplayFrame(r103);
        int r104 = r103.height();
    L23:
        int r105 = i(r110);
    L24:
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r111 = getResources(r110);
        int r106 = r111.getIdentifier("status_bar_height", "dimen", "android");
        if (r106 <= 0) goto L27;
        int r112 = r111.getDimensionPixelSize(r106);
    L29:
        return RangesKt.coerceAtMost(RangesKt.coerceAtLeast((r105 - r112) - r104, 0), r102);
    L27:
        r112 = 0;
        goto L29
    L15:
        if ((r110 instanceof Activity) == false) goto L17;
        WindowManager r107 = ((Activity) r110).getWindowManager();     // Catch: Exception -> L23
    L18:
        Display r108 = r107.getDefaultDisplay();
        DisplayMetrics r109 = new DisplayMetrics();
        a("android.view.Display").getMethod("getRealMetrics", new Class[]{DisplayMetrics.class}).invoke(r108, new Object[]{r109});     // Catch: Exception -> L21
        r105 = r109.heightPixels;     // Catch: Exception -> L21
    L21:
        e = move-exception;
        int r113 = i(r110);
        e.printStackTrace();
        r105 = r113;
        goto L24
    L17:
        Object r114 = r110.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Exception -> L23
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type android.view.WindowManager");     // Catch: Exception -> L23
        r107 = (WindowManager) r114;     // Catch: Exception -> L23
        goto L18
    L31:
        if (d(r110) == true) goto L34;
        return 0;
    L34:
        return r102;
    L10:
        r102 = 0;
        goto L11
    L5:
        if (Settings.Global.getInt(r110.getContentResolver(), "hide_gesture_line", 0) != 1) goto L7;
        return 0;
    }

    public static float e(Context r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return (r101 * c(r100.getResources()).density) + 0.5f;
    }

    @JvmStatic
    public static final int f(int r100, Context r101) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (f487997b >= 0) goto L5;
        f487997b = c(r101.getResources()).density;
    L5:
        Map<String, Map<Class<?>, Object>> r102 = x26.a.f562251a;
        g r103 = (g) x26.a.a(g.class);
        if (r103 == null) goto L12;
        e r104 = (e) r103.n0(e.class);
        if (r104 == null) goto L12;
        Boolean r105 = r104.Q0();
        if (r105 == null) goto L12;
        boolean r106 = r105.booleanValue();
    L14:
        if (r106 == false) goto L17;
        return (int) ((r100 * f487997b) + 0.5f);
    L17:
        return MathKt.roundToInt((r100 * f487997b) + 0.5f);
    L12:
        r106 = true;
        goto L14
    }

    public static int k(Context r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (f487998c == false) goto L5;
        float r102 = f487999d;
    L7:
        return (int) ((r101 / r102) + 0.5f);
    L5:
        r102 = c(r100.getResources()).density;
        goto L7
    }

    @JvmStatic
    public static final int l(int r100, Context r101) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (f487997b >= 0) goto L6;
        f487997b = c(r101.getResources()).density;
    L6:
        return (int) ((r100 / f487997b) + 0.5f);
    }
}
