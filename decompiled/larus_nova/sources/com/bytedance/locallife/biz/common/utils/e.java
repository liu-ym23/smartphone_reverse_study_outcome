package com.bytedance.locallife.biz.common.utils;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.locallife.dito.utils.ApplicationUtil;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes21.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f256640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f256641b;

    static {
    }

    public static int a() {
        int r100 = f256640a;
        if (r100 <= 0) goto L5;
        return r100;
    L5:
        c();
        int r101 = f256640a;
        if (r101 > 0) goto L10;
        return 0;
    L10:
        return r101;
    }

    public static int b() {
        int r100 = f256641b;
        if (r100 <= 0) goto L5;
        return r100;
    L5:
        c();
        int r101 = f256641b;
        if (r101 > 0) goto L10;
        return 0;
    L10:
        return r101;
    }

    public static void c() {
        Application r100 = ApplicationUtil.a();
        Object r101 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Exception -> L14
        if ((r101 instanceof WindowManager) == false) goto L6;
        WindowManager r102 = (WindowManager) r101;     // Catch: Exception -> L14
    L7:
        if (r102 == null) goto L12;
        Display r103 = r102.getDefaultDisplay();     // Catch: Exception -> L14
        if (r103 != null) goto L11;
        return;
    L11:
        Point r104 = new Point();     // Catch: Exception -> L14
        r103.getRealSize(r104);     // Catch: Exception -> L14
        f256640a = r104.y;     // Catch: Exception -> L14
        f256641b = r104.x;     // Catch: Exception -> L14
        return;
    L12:
        Resources r105 = r100.getResources();     // Catch: Exception -> L14
        DisplayMetrics r106 = WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics());     // Catch: Exception -> L14
        f256640a = r106.heightPixels;     // Catch: Exception -> L14
        f256641b = r106.widthPixels;     // Catch: Exception -> L14
        return;
    L6:
        r102 = null;
    L14:
        e = move-exception;
        e.printStackTrace();
    }
}
