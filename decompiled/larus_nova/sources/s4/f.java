package s4;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes43.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f540533a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f540534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f540535c;

    public f() {
    }

    static {
        f540533a = new f();
        f540534b = -1;
        f540535c = -1;
    }

    public static int a(Context r100) {
        int r101 = f540534b;
        if (r101 <= 0) goto L6;
        return r101;
    L6:
        if (r100 != null) goto L8;
        return 0;
    L8:
        c(r100);
        int r102 = f540534b;
        if (r102 > 0) goto L11;
        return 0;
    L11:
        return r102;
    }

    public static int b(Context r100) {
        int r101 = f540535c;
        if (r101 <= 0) goto L6;
        return r101;
    L6:
        if (r100 != null) goto L8;
        return 0;
    L8:
        c(r100);
        int r102 = f540535c;
        if (r102 > 0) goto L11;
        return 0;
    L11:
        return r102;
    }

    public static void c(Context r100) {
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
        f540534b = r104.y;     // Catch: Exception -> L13
        f540535c = r104.x;     // Catch: Exception -> L13
        return;
    L11:
        Resources r105 = r100.getResources();     // Catch: Exception -> L13
        DisplayMetrics r106 = WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics());     // Catch: Exception -> L13
        f540534b = r106.heightPixels;     // Catch: Exception -> L13
        f540535c = r106.widthPixels;     // Catch: Exception -> L13
        return;
    L5:
        r102 = null;
        goto L6
    }
}
