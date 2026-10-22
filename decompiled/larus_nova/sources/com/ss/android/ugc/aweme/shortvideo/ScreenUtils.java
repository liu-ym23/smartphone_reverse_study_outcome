package com.ss.android.ugc.aweme.shortvideo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Insets;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.Size;
import android.view.Display;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import com.bytedance.android.livesdk.end.LiveEndPageData;

/* JADX INFO: loaded from: classes40.dex */
public class ScreenUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile WindowMetrics f454179a;

    public ScreenUtils() {
    }

    public static int a(Context r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 30) goto L29;
        if (f454179a == null) goto L10;
    L23:
        WindowMetrics r102 = f454179a;
        if (r102 == null) goto L41;
        Insets r103 = r102.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.navigationBars() | WindowInsets.Type.displayCutout());
        int r104 = r103.right + r103.left;
        int r105 = r103.top + r103.bottom;
        Rect r106 = r102.getBounds();
        return new Size(r106.width() - r104, r106.height() - r105).getHeight();
    L41:
        return 0;
    L10:
        monitor-enter(ScreenUtils.class);
    L20:
        th = move-exception;
        throw th;
    L12:
        if (f454179a == null) goto L14;
    L18:
        monitor-exit(ScreenUtils.class);     // Catch: Throwable -> L20
        goto L23
    L14:
        if ((r100 instanceof Activity) == false) goto L16;
        WindowManager r107 = ((Activity) r100).getWindowManager();     // Catch: Throwable -> L20
    L17:
        f454179a = r107.getCurrentWindowMetrics();     // Catch: Throwable -> L20
        goto L18
    L16:
        r107 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Throwable -> L20
        goto L17
    L29:
        if ((r100 instanceof Activity) == false) goto L33;
        if (r101 < 30) goto L32;
        Display r108 = ((Activity) r100).getDisplay();
    L35:
        if (r108 == null) goto L42;
        Point r109 = new Point();
        r108.getSize(r109);
        return r109.y;
    L42:
        return 0;
    L32:
        WindowManager r110 = ((Activity) r100).getWindowManager();
    L34:
        r108 = r110.getDefaultDisplay();
        goto L35
    L33:
        r110 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        goto L34
    }
}
