package com.bytedance.android.shopping.sku.common.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static h a(Activity r4) {
        if (r4 != null) goto L4;
        Context r5 = ECAppInfoService.e.getCurrentActivity();
    L4:
        if (r5 != null) goto L7;
        r5 = ECAppInfoService.e.getApplicationContext();
    L7:
        int r0 = 0;
        Object r1 = null;
        if (r5 != null) goto L38;
        Object r2 = null;
    L12:
        if ((r2 instanceof WindowManager) == false) goto L15;
        r1 = r2;
    L15:
        WindowManager r3 = (WindowManager) r1;     // Catch: Exception -> L34
        if (r3 == null) goto L25;
        Display r6 = r3.getDefaultDisplay();     // Catch: Exception -> L34
        Point r7 = new Point();     // Catch: Exception -> L34
        if (r6 == null) goto L20;
        r6.getRealSize(r7);     // Catch: Exception -> L34
    L20:
        int r8 = r7.x;     // Catch: Exception -> L34
        if (r8 <= 0) goto L33;
        int r9 = r7.y;     // Catch: Exception -> L34
        if (r9 <= 0) goto L33;
        r0 = r9;
    L36:
        return new h(r8, r0);
    L33:
        r8 = 0;
        goto L36
    L25:
        if (r5 == null) goto L33;
        Resources r10 = r5.getResources();     // Catch: Exception -> L34
        if (r10 == null) goto L33;
        DisplayMetrics r11 = WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics());     // Catch: Exception -> L34
        if (r11 == null) goto L33;
        int r12 = r11.widthPixels;     // Catch: Exception -> L34
        r0 = r11.heightPixels;     // Catch: Exception -> L37
    L32:
        r8 = r12;
        goto L36
    L38:
        r2 = r5.getSystemService("window");     // Catch: Exception -> L34
    L34:
        r12 = 0;
        goto L32
    }
}
