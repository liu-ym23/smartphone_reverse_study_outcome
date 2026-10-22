package com.bytedance.android.shopping.buynow.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static f a(Context r4) {
        if (r4 != null) goto L4;
        r4 = ECAppInfoService.e.getCurrentActivity();
    L4:
        if (r4 != null) goto L6;
        r4 = ECAppInfoService.e.getApplicationContext();
    L6:
        int r0 = 0;
        Object r1 = null;
        if (r4 != null) goto L37;
        Object r2 = null;
    L11:
        if ((r2 instanceof WindowManager) == false) goto L14;
        r1 = r2;
    L14:
        WindowManager r3 = (WindowManager) r1;     // Catch: Exception -> L33
        if (r3 == null) goto L24;
        Display r5 = r3.getDefaultDisplay();     // Catch: Exception -> L33
        Point r6 = new Point();     // Catch: Exception -> L33
        if (r5 == null) goto L19;
        r5.getRealSize(r6);     // Catch: Exception -> L33
    L19:
        int r7 = r6.x;     // Catch: Exception -> L33
        if (r7 <= 0) goto L32;
        int r8 = r6.y;     // Catch: Exception -> L33
        if (r8 <= 0) goto L32;
        r0 = r8;
    L35:
        return new f(r7, r0);
    L32:
        r7 = 0;
        goto L35
    L24:
        if (r4 == null) goto L32;
        Resources r9 = r4.getResources();     // Catch: Exception -> L33
        if (r9 == null) goto L32;
        DisplayMetrics r10 = WindowDisplayMetricsOverride.apply(r9, r9.getDisplayMetrics());     // Catch: Exception -> L33
        if (r10 == null) goto L32;
        int r11 = r10.widthPixels;     // Catch: Exception -> L33
        r0 = r10.heightPixels;     // Catch: Exception -> L36
    L31:
        r7 = r11;
        goto L35
    L37:
        r2 = r4.getSystemService("window");     // Catch: Exception -> L33
    L33:
        r11 = 0;
        goto L31
    }
}
