package vd7;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.ies.bullet.core.h;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f554208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f554209b;

    static {
        f554208a = -1;
        f554209b = -1;
    }

    public static int c() {
        Application r100 = h.f246501h.f246503b;
        if (r100 == null) goto L7;
        int r101 = r100.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r101 <= 0) goto L7;
        return r100.getResources().getDimensionPixelSize(r101);
    L7:
        return 0;
    }

    public static int a(Context r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        d(r100);
        int r101 = f554208a;
        if (r101 > 0) goto L8;
        return 0;
    L8:
        return r101;
    }

    public static int b(Context r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        d(r100);
        int r101 = f554209b;
        if (r101 > 0) goto L8;
        return 0;
    L8:
        return r101;
    }

    public static void d(Context r100) {
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
        f554208a = r104.y;     // Catch: Exception -> L13
        f554209b = r104.x;     // Catch: Exception -> L13
        return;
    L11:
        Resources r105 = r100.getResources();     // Catch: Exception -> L13
        DisplayMetrics r106 = WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics());     // Catch: Exception -> L13
        f554208a = r106.heightPixels;     // Catch: Exception -> L13
        f554209b = r106.widthPixels;     // Catch: Exception -> L13
        return;
    L5:
        r102 = null;
        goto L6
    }
}
