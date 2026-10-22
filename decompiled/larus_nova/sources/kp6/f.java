package kp6;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes21.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f505517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f505518b;

    static {
    }

    public static int a() {
        int r100 = f505517a;
        if (r100 <= 0) goto L5;
        return r100;
    L5:
        c();
        int r101 = f505517a;
        if (r101 > 0) goto L10;
        return 0;
    L10:
        return r101;
    }

    public static int b() {
        int r100 = f505518b;
        if (r100 <= 0) goto L5;
        return r100;
    L5:
        c();
        int r101 = f505518b;
        if (r101 > 0) goto L10;
        return 0;
    L10:
        return r101;
    }

    public static void c() {
        com.bytedance.locallife.cube.c.c();
        Application r100 = com.bytedance.locallife.biz.base.cube.d.f256534a.a();
        if (r100 != null) goto L19;
        return;
    L19:
        Object r101 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Exception -> L16
        if ((r101 instanceof WindowManager) == false) goto L8;
        WindowManager r102 = (WindowManager) r101;     // Catch: Exception -> L16
    L9:
        if (r102 == null) goto L14;
        Display r103 = r102.getDefaultDisplay();     // Catch: Exception -> L16
        if (r103 != null) goto L13;
        return;
    L13:
        Point r104 = new Point();     // Catch: Exception -> L16
        r103.getRealSize(r104);     // Catch: Exception -> L16
        f505517a = r104.y;     // Catch: Exception -> L16
        f505518b = r104.x;     // Catch: Exception -> L16
        return;
    L14:
        Resources r105 = r100.getResources();     // Catch: Exception -> L16
        DisplayMetrics r106 = WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics());     // Catch: Exception -> L16
        f505517a = r106.heightPixels;     // Catch: Exception -> L16
        f505518b = r106.widthPixels;     // Catch: Exception -> L16
        return;
    L8:
        r102 = null;
    L16:
        e = move-exception;
        e.printStackTrace();
    }
}
