package j46;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f497369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f497370b;

    public static int a(Context r100) {
        int r101 = f497370b;
        if (r101 == 0) goto L5;
        return r101;
    L5:
        WindowManager r102 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        if (r102 == null) goto L9;
        Point r103 = new Point();
        r102.getDefaultDisplay().getSize(r103);
        f497369a = r103.x;
        f497370b = r103.y;
    L9:
        if (f497369a != 0) goto L11;
    L12:
        Resources r104 = r100.getResources();
        DisplayMetrics r105 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics());
        f497369a = r105.widthPixels;
        f497370b = r105.heightPixels;
    L14:
        return f497370b;
    L11:
        if (f497370b != 0) goto L14;
        goto L12
    }

    public static int b(Context r100) {
        int r101 = f497369a;
        if (r101 == 0) goto L5;
        return r101;
    L5:
        WindowManager r102 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        if (r102 == null) goto L9;
        Point r103 = new Point();
        r102.getDefaultDisplay().getSize(r103);
        f497369a = r103.x;
        f497370b = r103.y;
    L9:
        if (f497369a != 0) goto L11;
    L12:
        Resources r104 = r100.getResources();
        DisplayMetrics r105 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics());
        f497369a = r105.widthPixels;
        f497370b = r105.heightPixels;
    L14:
        return f497369a;
    L11:
        if (f497370b != 0) goto L14;
        goto L12
    }
}
