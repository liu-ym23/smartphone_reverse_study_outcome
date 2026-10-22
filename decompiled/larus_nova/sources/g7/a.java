package g7;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import b8.b;
import com.bytedance.android.annie.bridge.method.abs.GetAppInfoResultModel;
import com.bytedance.android.annie.log.LogLevel;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f480179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f480180b;

    static {
        f480179a = -1;
        f480180b = -1;
    }

    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static int d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = r100.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return r100.getResources().getDimensionPixelSize(r101);
    }

    public static void e(Context r100) {
        Object r101 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Exception -> L13
        if ((r101 instanceof WindowManager) == false) goto L5;
        WindowManager r102 = (WindowManager) r101;     // Catch: Exception -> L13
    L6:
        if (r102 == null) goto L11;
        Display r103 = r102.getDefaultDisplay();     // Catch: Exception -> L13
        Point r104 = new Point();     // Catch: Exception -> L13
        if (r103 != null) goto L10;
        return;
    L10:
        r103.getRealSize(r104);     // Catch: Exception -> L13
        f480179a = r104.y;     // Catch: Exception -> L13
        f480180b = r104.x;     // Catch: Exception -> L13
        return;
    L11:
        Resources r105 = r100.getResources();     // Catch: Exception -> L13
        DisplayMetrics r106 = WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics());     // Catch: Exception -> L13
        f480179a = r106.heightPixels;     // Catch: Exception -> L13
        f480180b = r106.widthPixels;     // Catch: Exception -> L13
        return;
    L5:
        r102 = null;
        goto L6
    }

    public static GetAppInfoResultModel.GetAppInfoSafeArea b(Activity r100, Context r110) {
        Intrinsics.checkNotNullParameter(r110, "applicationContext");
        if (r100 != null) goto L22;
        return null;
    L22:
    L18:
        e = move-exception;
        b8.a r101 = b8.a.f17992a;
        b8.a.a(new b("getSafeArea", LogLevel.ERROR, e, null, 8), true);
        return null;
    L6:
        if (r100.getResources().getConfiguration().orientation != 2) goto L8;
        boolean r102 = true;
    L9:
        int r103 = f(d(r110), r110);     // Catch: Exception -> L18
        Rect r104 = new Rect();     // Catch: Exception -> L18
        a(r100.getWindow()).getWindowVisibleDisplayFrame(r104);     // Catch: Exception -> L18
        int r105 = f(a(r100.getWindow()).getHeight(), r100);     // Catch: Exception -> L18
        int r106 = f(r104.top, r110);     // Catch: Exception -> L18
        int r107 = f(r104.bottom, r110);     // Catch: Exception -> L18
        if (r105 != 0) goto L13;
        if (r106 != 0) goto L13;
        r107 = r107 + r103;     // Catch: Exception -> L18
    L13:
        int r108 = Math.max(c(r100, r110) - r107, 0);     // Catch: Exception -> L18
        if (r102 == false) goto L16;
        GetAppInfoResultModel.GetAppInfoSafeArea r111 = new GetAppInfoResultModel.GetAppInfoSafeArea();     // Catch: Exception -> L18
        r111.setMarginLeft(Integer.valueOf(r103));     // Catch: Exception -> L18
        r111.setMarginRight(Integer.valueOf(r108));     // Catch: Exception -> L18
        r111.setMarginTop(0);     // Catch: Exception -> L18
        r111.setMarginBottom(0);     // Catch: Exception -> L18
        return r111;
    L16:
        GetAppInfoResultModel.GetAppInfoSafeArea r112 = new GetAppInfoResultModel.GetAppInfoSafeArea();     // Catch: Exception -> L18
        r112.setMarginTop(Integer.valueOf(r103));     // Catch: Exception -> L18
        r112.setMarginBottom(Integer.valueOf(r108));     // Catch: Exception -> L18
        r112.setMarginRight(0);     // Catch: Exception -> L18
        r112.setMarginLeft(0);     // Catch: Exception -> L18
        return r112;
    L8:
        r102 = false;
        goto L9
    }

    public static int c(Context r100, Context r101) {
        Intrinsics.checkNotNullParameter(r101, "applicationContext");
        if (r100 != null) goto L5;
        r100 = r101;
    L5:
        int r102 = 0;
        if (r100.getResources().getConfiguration().orientation != 2) goto L8;
        boolean r103 = true;
    L9:
        int r104 = f480180b;
        if (r104 > 0) goto L16;
        e(r100);
        r104 = f480180b;
        if (r104 > 0) goto L16;
        r104 = 0;
    L16:
        int r105 = f(r104, r100);
        int r106 = f480179a;
        if (r106 > 0) goto L23;
        e(r100);
        int r107 = f480179a;
        if (r107 <= 0) goto L22;
        r102 = r107;
    L22:
        r106 = r102;
    L23:
        int r108 = f(r106, r100);
        if (r103 == false) goto L27;
        return Math.min(r105, r108);
    L27:
        return Math.max(r105, r108);
    L8:
        r103 = false;
        goto L9
    }

    public static int f(double r100, Context r101) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r102 = r101.getResources();
        return (int) ((r100 / ((double) WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density)) + ((double) 0.5f));
    }
}
