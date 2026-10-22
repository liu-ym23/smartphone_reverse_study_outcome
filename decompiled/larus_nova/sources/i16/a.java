package i16;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.ies.bullet.core.device.PropsUtilsKt;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import t36.j;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f487988a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f487989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static float f487990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f487991d;

    static {
        f487988a = CollectionsKt.listOf("PFJM10");
    }

    public static String e() {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        Locale r100 = LocaleList.getDefault().get(0);
    L7:
        return r100.getLanguage() + '-' + r100.getCountry();
    L5:
        r100 = Locale.getDefault();
        goto L7
    }

    public static boolean k() {
    L20:
        e = move-exception;
        e.getMessage();
    L22:
        return false;
    L3:
        if (com.bytedance.ies.bullet.base.utils.a.f246322a != null) goto L15;
        monitor-enter(com.bytedance.ies.bullet.base.utils.a.class);     // Catch: Exception -> L20
    L11:
        th = move-exception;
        throw th;     // Catch: Exception -> L20
    L7:
        if (com.bytedance.ies.bullet.base.utils.a.f246322a != null) goto L9;
        com.bytedance.ies.bullet.base.utils.a.f246322a = com.bytedance.ies.bullet.base.utils.a.d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(com.bytedance.ies.bullet.base.utils.a.class);     // Catch: Throwable -> L11
    L15:
        if (TextUtils.isEmpty(com.bytedance.ies.bullet.base.utils.a.f246322a) == true) goto L22;
        if (Intrinsics.areEqual("arm64-v8a", com.bytedance.ies.bullet.base.utils.a.c()) == true) goto L22;
        return true;
    }

    public static float b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        if (f487989b == false) goto L6;
        float r102 = f487990c;     // Catch: Throwable -> L9
    L7:
        Object r103 = Result.m9449constructorimpl(Float.valueOf(r102));     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r103) == false) goto L14;
        r103 = null;
    L14:
        Float r104 = (Float) r103;
        if (r104 != null) goto L21;
        return 0.0f;
    L21:
        return r104.floatValue();
    L6:
        Resources r105 = r100.getResources();     // Catch: Throwable -> L9
        r102 = WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()).density;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public static Display c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((r100 instanceof Activity) == false) goto L5;
        WindowManager r101 = ((Activity) r100).getWindowManager();
    L6:
        if (r101 != null) goto L10;
        return null;
    L10:
        return r101.getDefaultDisplay();
    L5:
        Object r102 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.view.WindowManager");
        r101 = (WindowManager) r102;
        goto L6
    }

    public static int d(Context r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r100);     // Catch: Throwable -> L4
        Object r102 = r100.getSystemService("activity");     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Throwable -> L4
        ConfigurationInfo r103 = ((ActivityManager) r102).getDeviceConfigurationInfo();     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L4
        Object r104 = Result.m9449constructorimpl(Integer.valueOf(r103.reqGlEsVersion));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r104) == false) goto L9;
        r104 = null;
    L9:
        Integer r105 = (Integer) r104;
        if (r105 != null) goto L16;
        return 0;
    L16:
        return r105.intValue();
    L4:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static int f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Display r101 = c(r100);
        if (r101 != null) goto L10;
        return 0;
    L10:
        Point r102 = new Point();     // Catch: Exception -> L7
        r101.getRealSize(r102);     // Catch: Exception -> L7
        BulletLogger.k("use real size for screenHeight in global props", null, null, 6);     // Catch: Exception -> L7
        return r102.y;
    L7:
        e = move-exception;
        e.getMessage();
        return 0;
    }

    public static Pair g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L16
        Object r103 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Throwable -> L16
        if (r103 != null) goto L6;
    L14:
        Resources r104 = r100.getResources();     // Catch: Throwable -> L16
        DisplayMetrics r105 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics());     // Catch: Throwable -> L16
        return new Pair(Integer.valueOf(r105.widthPixels), Integer.valueOf(r105.heightPixels));
    L6:
        if ((r103 instanceof WindowManager) == false) goto L8;
        WindowManager r106 = (WindowManager) r103;     // Catch: Throwable -> L16
    L9:
        if (r106 == null) goto L14;
        Display r107 = r106.getDefaultDisplay();     // Catch: Throwable -> L16
        if (r107 == null) goto L14;
        Point r108 = new Point();     // Catch: Throwable -> L16
        r107.getRealSize(r108);     // Catch: Throwable -> L16
        return new Pair(Integer.valueOf(r108.x), Integer.valueOf(r108.y));
    L8:
        r106 = null;
    L16:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Object r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r110) == true) goto L22;
        r101 = r110;
    L22:
        return (Pair) r101;
    }

    public static int i(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Display r101 = c(r100);
        if (r101 != null) goto L10;
        return 0;
    L10:
        Point r102 = new Point();     // Catch: Exception -> L7
        r101.getSize(r102);     // Catch: Exception -> L7
        return r102.x;
    L7:
        e = move-exception;
        e.getMessage();
        return 0;
    }

    public static int j(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = f487991d;
        if (r101 <= 0) goto L5;
        return r101;
    L5:
        int r102 = b.f487992a;
        int r103 = 0;
        if (r102 == (-1)) goto L81;
        if (r102 != 1) goto L9;
        boolean r104 = true;
    L14:
        if (r104 == true) goto L39;
        int r105 = b.f487993b;
        if (r105 == (-1)) goto L83;
        if (r105 != 1) goto L19;
        int r106 = 1;
    L36:
        if (r106 != 0) goto L39;
        boolean r107 = false;
    L40:
        if (r107 == true) goto L42;
    L45:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r108 = b.f487994c;
        if (r108 == (-1)) goto L77;
        if (r108 != 1) goto L49;
        boolean r109 = true;
    L54:
        if (r109 == true) goto L56;
    L70:
        int r110 = r100.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r110 <= 0) goto L73;
        r103 = r100.getResources().getDimensionPixelOffset(r110);
    L73:
        if (r103 != 0) goto L75;
        c r111 = c.f487996a;
        r103 = (int) c.e(r100, 25.0f);
    L75:
        f487991d = r103;
        return r103;
    L56:
        if (f487988a.contains(Build.MODEL) == true) goto L70;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r112 = b.f487995d;
        if (r112 != (-1)) goto L68;
        int[] r113 = {0, 0};
        Class r114 = b.b(r100.getClassLoader());     // Catch: Exception -> L63
        Object r115 = r114.getMethod("getNotchSize", new Class[0]).invoke(r114, new Object[0]);     // Catch: Exception -> L63
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type kotlin.IntArray");     // Catch: Exception -> L63
        r113 = (int[]) r115;     // Catch: Exception -> L63
    L64:
        r112 = r113[1];
        if (r112 > 0) goto L67;
        c r116 = c.f487996a;
        r112 = (int) c.e(r100, 28);
    L67:
        b.f487995d = r112;
    L68:
        f487991d = r112;
        return r112;
    L49:
        r109 = false;
        goto L54
    L77:
        Class r117 = b.b(r100.getClassLoader());     // Catch: Exception -> L52
        Object r118 = r117.getMethod("hasNotchInScreen", new Class[0]).invoke(r117, new Object[0]);     // Catch: Exception -> L52
        Intrinsics.checkNotNull(r118, "null cannot be cast to non-null type kotlin.Boolean");     // Catch: Exception -> L52
        r109 = ((Boolean) r118).booleanValue();     // Catch: Exception -> L52
    L53:
        b.f487994c = r109 ? 1 : 0;
    L52:
        r109 = false;
        goto L53
    L42:
        if (f487988a.contains(Build.MODEL) == true) goto L45;
        c r119 = c.f487996a;
        int r120 = (int) c.e(r100, 27);
        f487991d = r120;
        return r120;
    L19:
        r106 = 0;
        goto L36
    L83:
        if (TextUtils.equals(AppConstants.CHANNEL_OPPO, Build.BRAND.toLowerCase(Locale.getDefault())) == false) goto L26;
        if (r100 == null) goto L26;
        boolean r121 = r100.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");     // Catch: Throwable -> L25
    L27:
        if (r121 == false) goto L34;
        if (r100 != null) goto L30;
        int r122 = 0;
    L32:
        if (r122 < 2280) goto L34;
        r106 = 1;
    L35:
        b.f487993b = r106;
        goto L36
    L30:
        DisplayMetrics r123 = new DisplayMetrics();
        Object r124 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNull(r124, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) r124).getDefaultDisplay().getRealMetrics(r123);
        r122 = r123.heightPixels;
    L34:
        r106 = 0;
    L26:
        r121 = false;
    L39:
        r107 = true;
        goto L40
    L9:
        r104 = false;
        goto L14
    L81:
        Class r125 = b.a();     // Catch: Exception -> L12
        Object r126 = r125.getDeclaredMethod("isFeatureSupport", new Class[]{Integer.TYPE}).invoke(r125, new Object[]{32});     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r126, "null cannot be cast to non-null type kotlin.Boolean");     // Catch: Exception -> L12
        r104 = ((Boolean) r126).booleanValue();     // Catch: Exception -> L12
    L13:
        b.f487992a = r104 ? 1 : 0;
    L12:
        r104 = false;
        goto L13
    }

    public static boolean l(Context r100) {
        AnnieXRuntime.a().getClass();
        if (r100 != null) goto L21;
    L9:
        AccessibilityManager r101 = null;
    L10:
        if (r101 == null) goto L20;
        List<AccessibilityServiceInfo> r102 = r101.getEnabledAccessibilityServiceList(1);     // Catch: Exception -> L19
        if (r102 == null) goto L20;
        if ((!r102.isEmpty()) == false) goto L18;
        if (r101.isTouchExplorationEnabled() == false) goto L18;
        return true;
    L19:
        BulletLogger.k("getEnabledAccessibilityServiceList failed by system exception", null, null, 6);
    L18:
        return false;
    L20:
        return false;
    L21:
        Object r103 = r100.getSystemService("accessibility");     // Catch: Exception -> L19
        if (r103 == null) goto L9;
        if ((r103 instanceof AccessibilityManager) == false) goto L9;
        r101 = (AccessibilityManager) r103;     // Catch: Exception -> L19
        goto L10
    }

    public static float a(Context r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return (r101 * b(r100)) + 0.5f;
    }

    public static int m(double r100, Context r101) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        return (int) ((r100 / ((double) b(r101))) + ((double) 0.5f));
    }

    public static Map h(Context r100, int r101, j r102) {
        if (r100 != null) goto L5;
        return null;
    L5:
        LinkedHashMap r103 = new LinkedHashMap();
        if (r101 != 2) goto L8;
        String r104 = "landscape";
    L9:
        r103.put("screenOrientation", r104);
        AnnieXRuntime.b().getClass();
        Pair r105 = g(r100);
        if (r105 == null) goto L12;
        r103.put("screenWidth", Integer.valueOf(m(((Number) r105.getFirst()).intValue(), r100)));
        r103.put("screenHeight", Integer.valueOf(m(((Number) r105.getSecond()).intValue(), r100)));
    L12:
        Map<String, Object> r106 = PropsUtilsKt.getContainerProps(r100, null);
        if (r106 == null) goto L15;
        r103.putAll(r106);
    L15:
        Map<String, Object> r107 = PropsUtilsKt.getPageCommonProps(r100, r102);
        Object r108 = r107.get("contentWidth");
        if (r108 == null) goto L18;
        r103.put("contentWidth", r108);
    L18:
        Object r109 = r107.get("contentHeight");
        if (r109 == null) goto L21;
        r103.put("contentHeight", r109);
    L21:
        AnnieXRuntime.b().getClass();
        return r103;
    L8:
        r104 = "portrait";
        goto L9
    }
}
