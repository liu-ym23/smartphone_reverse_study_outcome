package ha6;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.kmp.ec.yata.common.log.YaTaLog;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f484384a = 0;

    static {
    }

    public static c a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "tempContext");
        int r101 = 0;
        Object r102 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Exception -> L26
        if ((r102 instanceof WindowManager) == false) goto L6;
        WindowManager r103 = (WindowManager) r102;     // Catch: Exception -> L26
    L7:
        if (r103 == null) goto L16;
        Display r104 = r103.getDefaultDisplay();     // Catch: Exception -> L26
        Point r105 = new Point();     // Catch: Exception -> L26
        if (r104 == null) goto L11;
        r104.getRealSize(r105);     // Catch: Exception -> L26
    L11:
        int r106 = r105.x;     // Catch: Exception -> L26
        if (r106 <= 0) goto L25;
        int r107 = r105.y;     // Catch: Exception -> L26
        if (r107 <= 0) goto L25;
        r101 = r107;
    L30:
        return new c(r106, r101);
    L25:
        r106 = 0;
        goto L30
    L16:
        Resources r108 = r100.getResources();     // Catch: Exception -> L26
        if (r108 == null) goto L25;
        DisplayMetrics r109 = WindowDisplayMetricsOverride.apply(r108, r108.getDisplayMetrics());     // Catch: Exception -> L26
        if (r109 == null) goto L25;
        int r110 = r109.widthPixels;     // Catch: Exception -> L26
        r101 = r109.heightPixels;     // Catch: Exception -> L23
    L22:
        r106 = r110;
    L23:
        e = e;
    L28:
        YaTaLog.f("YataScreenUtils", e, "getScreenSize crash");
        goto L22
    L6:
        r103 = null;
    L26:
        e = e;
        r110 = 0;
        goto L28
    }
}
