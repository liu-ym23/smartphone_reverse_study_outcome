package js7;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.dtf.face.log.RecordService;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import us7.h;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f500230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f500231b;

    public static boolean g() {
        boolean r100 = hs7.a.h().f487013y;
        Activity r101 = h.f551544b.b();
        if (r101 != null) goto L15;
    L14:
        return false;
    L15:
        int r102 = r101.getWindowManager().getDefaultDisplay().getRotation();     // Catch: Throwable -> L12
        if (r102 == 0) goto L8;
        if (r100 == true) goto L8;
    L10:
        return true;
    L8:
        if (r102 == 1) goto L17;
        if (r100 == true) goto L10;
        return false;
    L17:
        return false;
    L12:
        th = move-exception;
        RecordService.getInstance().recordEvent(4, "errMsg", new String[]{Log.getStackTraceString(th)});
        goto L14
    }

    public static Point c(Configuration r100) {
        Point r101 = new Point();
        if (r100 != null) goto L5;
        r100 = hs7.a.h().getContext().getResources().getConfiguration();
    L5:
        r101.x = r100.screenWidthDp;
        r101.y = r100.screenHeightDp;
        return r101;
    }

    public static Point d(Context r100) {
        if (r100 == null) goto L4;
        Resources r101 = r100.getResources();
        DisplayMetrics r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics());
        return new Point(r102.widthPixels, r102.heightPixels);
    L4:
        return new Point(1, 1);
    }

    public static float e(Context r100) {
        Point r101 = d(r100);
        float r102 = r101.y;
        float r103 = r101.x;
        if (r103 != 0.0f) goto L7;
        return 1.0f;
    L7:
        return r102 / r103;
    }

    public static int f(Context r100) {
        if (r100 == null) goto L7;
        if (f500231b != 0) goto L7;
        int r101 = r100.getResources().getIdentifier("status_bar_height", "dimen", "android");
        f500231b = r100.getResources().getDimensionPixelSize(r101);
    L7:
        return f500231b;
    }

    public static int a(Context r100, float r101) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        Resources r102 = r100.getResources();
        return (int) ((r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f);
    }

    public static void h(boolean r100, View... r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L21;
        View r104 = r101[r103];
        if (r104 == null) goto L20;
    L18:
        th = move-exception;
        RecordService.getInstance().recordEvent(1, "setLayoutParamsErr", new String[]{"errMsg", RecordService.getStackTraceString(th)});
        goto L20
    L7:
        if ((r104.getLayoutParams() instanceof RelativeLayout.LayoutParams) == false) goto L20;
        RelativeLayout.LayoutParams r105 = (RelativeLayout.LayoutParams) r104.getLayoutParams();     // Catch: Throwable -> L18
        int r106 = 9;
        if (r100 == false) goto L11;
        int r107 = 11;
    L12:
        r105.removeRule(r107);     // Catch: Throwable -> L18
        if (r100 == true) goto L16;
        r106 = 11;
    L16:
        r105.addRule(r106);     // Catch: Throwable -> L18
        r104.setLayoutParams(r105);     // Catch: Throwable -> L18
        goto L20
    L11:
        r107 = 9;
    L20:
        r103 = r103 + 1;
        goto L3
    }

    public static void b(Window r100, boolean r101, boolean r102, boolean r103) {
        int r104 = 0;
        if (r102 == true) goto L7;
        if (r103 == true) goto L7;
        boolean r105 = false;
    L8:
        if (r100 == null) goto L48;
        View r106 = r100.getDecorView();     // Catch: Throwable -> L44
        if (c.f346345e == false) goto L14;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L44
        Thread r107 = Thread.currentThread();     // Catch: Throwable -> L44
        if (r107 == c.f346341a) goto L14;
        c.a(r107, "getDecorView");     // Catch: Throwable -> L44
    L14:
        if (r106 == null) goto L49;
        int r108 = -16777216;
        if (r101 == false) goto L32;
        int r109 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L44
        r100.addFlags(Integer.MIN_VALUE);     // Catch: Throwable -> L44
        r100.clearFlags(67108864);     // Catch: Throwable -> L44
        r100.clearFlags(AMapEngineUtils.HALF_MAX_P20_WIDTH);     // Catch: Throwable -> L44
        if (r109 < 23) goto L23;
        if (r102 == false) goto L21;
        int r110 = 8208;
    L22:
        r106.setSystemUiVisibility(r110 | 1280);     // Catch: Throwable -> L44
    L24:
        if (r105 == false) goto L26;
        int r111 = 0;
    L27:
        r100.setStatusBarColor(r111);     // Catch: Throwable -> L44
        if (r105 == true) goto L31;
        r104 = -16777216;
    L31:
        r100.setNavigationBarColor(r104);     // Catch: Throwable -> L44
        return;
    L26:
        r111 = -16777216;
        goto L27
    L21:
        r110 = 0;
        goto L22
    L23:
        r106.setSystemUiVisibility(1280);     // Catch: Throwable -> L44
        goto L24
    L32:
        int r112 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L44
        r100.addFlags(67108864);     // Catch: Throwable -> L44
        r100.addFlags(Integer.MIN_VALUE);     // Catch: Throwable -> L44
        if (r112 < 28) goto L35;
        WindowManager.LayoutParams r113 = r100.getAttributes();     // Catch: Throwable -> L44
        r113.layoutInDisplayCutoutMode = 1;     // Catch: Throwable -> L44
        r100.setAttributes(r113);     // Catch: Throwable -> L44
    L35:
        r106.setSystemUiVisibility(5380);     // Catch: Throwable -> L44
        if (r105 == true) goto L39;
        r104 = -16777216;
    L39:
        r100.setStatusBarColor(r104);     // Catch: Throwable -> L44
        if (r102 == false) goto L42;
        r108 = -1;
    L42:
        r100.setNavigationBarColor(r108);     // Catch: Throwable -> L44
        return;
    L49:
        return;
    L44:
        th = move-exception;
        RecordService.getInstance().recordException(th);
        return;
    L48:
        return;
    L7:
        r105 = true;
        goto L8
    }
}
