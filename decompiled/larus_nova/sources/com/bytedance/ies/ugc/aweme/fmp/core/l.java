package com.bytedance.ies.ugc.aweme.fmp.core;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes19.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f248936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f248937b;

    static {
    }

    public static void a(Context r100) {
        Object r101 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Exception -> L13
        if ((r101 instanceof WindowManager) == false) goto L5;
        WindowManager r102 = (WindowManager) r101;     // Catch: Exception -> L13
    L6:
        if (r102 == null) goto L11;
        Display r103 = r102.getDefaultDisplay();     // Catch: Exception -> L13
        if (r103 != null) goto L10;
        return;
    L10:
        Point r104 = new Point();     // Catch: Exception -> L13
        r103.getRealSize(r104);     // Catch: Exception -> L13
        f248936a = r104.y;     // Catch: Exception -> L13
        f248937b = r104.x;     // Catch: Exception -> L13
        return;
    L11:
        Resources r105 = r100.getResources();     // Catch: Exception -> L13
        DisplayMetrics r106 = WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics());     // Catch: Exception -> L13
        f248936a = r106.heightPixels;     // Catch: Exception -> L13
        f248937b = r106.widthPixels;     // Catch: Exception -> L13
        return;
    L5:
        r102 = null;
    L13:
        e = move-exception;
        e.printStackTrace();
    }
}
