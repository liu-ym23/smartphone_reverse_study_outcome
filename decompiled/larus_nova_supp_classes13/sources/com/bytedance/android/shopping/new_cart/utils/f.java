package com.bytedance.android.shopping.new_cart.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "tempContext");
        Object r0 = r2.getSystemService("window");     // Catch: Exception -> L22
        if ((r0 instanceof WindowManager) == true) goto L6;
        r0 = null;
    L6:
        WindowManager r1 = (WindowManager) r0;     // Catch: Exception -> L22
        if (r1 == null) goto L16;
        Display r3 = r1.getDefaultDisplay();     // Catch: Exception -> L22
        Point r4 = new Point();     // Catch: Exception -> L22
        if (r3 == null) goto L12;
        r3.getRealSize(r4);     // Catch: Exception -> L22
    L12:
        if (r4.x <= 0) goto L24;
        int r5 = r4.y;     // Catch: Exception -> L22
        if (r5 <= 0) goto L24;
        return r5;
    L24:
        return 0;
    L16:
        Resources r6 = r2.getResources();     // Catch: Exception -> L22
        if (r6 == null) goto L24;
        DisplayMetrics r7 = WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics());     // Catch: Exception -> L22
        if (r7 == null) goto L24;
        return r7.heightPixels;
    L22:
        e = move-exception;
        ECExceptionMonitor.d("YATA_CART", e, "getScreenSize crash");
        goto L24
    }
}
