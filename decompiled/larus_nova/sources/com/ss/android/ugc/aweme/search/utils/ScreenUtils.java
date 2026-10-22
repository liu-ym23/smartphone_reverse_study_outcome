package com.ss.android.ugc.aweme.search.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes40.dex */
public class ScreenUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f453418a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f453419b = -1;

    public static int a(Context r100) {
        int r101 = f453419b;
        if (r101 <= 0) goto L6;
        return r101;
    L6:
        if (r100 != null) goto L8;
        return 0;
    L8:
        d(r100);
        int r102 = f453419b;
        if (r102 > 0) goto L11;
        return 0;
    L11:
        return r102;
    }

    public static int b(Context r100) {
        int r101 = f453418a;
        if (r101 <= 0) goto L6;
        return r101;
    L6:
        if (r100 != null) goto L8;
        return 0;
    L8:
        d(r100);
        int r102 = f453418a;
        if (r102 > 0) goto L11;
        return 0;
    L11:
        return r102;
    }

    public static int c(Context r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        Resources r101 = r100.getResources();
        int r102 = r101.getIdentifier("status_bar_height", "dimen", "android");
        if (r102 > 0) goto L8;
        return 0;
    L8:
        return r101.getDimensionPixelSize(r102);
    }

    public static void d(Context r100) {
        if (r100 != null) goto L14;
        return;
    L14:
        WindowManager r101 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Exception -> L12
        if (r101 == null) goto L10;
        Display r102 = r101.getDefaultDisplay();     // Catch: Exception -> L12
        Point r103 = new Point();     // Catch: Exception -> L12
        if (r102 != null) goto L9;
        return;
    L9:
        r102.getRealSize(r103);     // Catch: Exception -> L12
        f453419b = r103.y;     // Catch: Exception -> L12
        f453418a = r103.x;     // Catch: Exception -> L12
    L13:
        return;
    L10:
        Resources r104 = r100.getResources();     // Catch: Exception -> L12
        DisplayMetrics r105 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics());     // Catch: Exception -> L12
        f453419b = r105.heightPixels;     // Catch: Exception -> L12
        f453418a = r105.widthPixels;     // Catch: Exception -> L12
    }
}
