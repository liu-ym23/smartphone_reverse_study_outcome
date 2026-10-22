package com.bytedance.locallife.live.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes21.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f260693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f260694b;

    static {
    }

    public static int a() {
        int r100 = f260693a;
        if (r100 <= 0) goto L5;
        return r100;
    L5:
        c();
        int r101 = f260693a;
        if (r101 > 0) goto L10;
        return 0;
    L10:
        return r101;
    }

    public static int b() {
        int r100 = f260694b;
        if (r100 <= 0) goto L5;
        return r100;
    L5:
        c();
        int r101 = f260694b;
        if (r101 > 0) goto L10;
        return 0;
    L10:
        return r101;
    }

    public static void c() {
        Context r100 = LiveLifeSaaSUtil.p();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L15
        Object r102 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Throwable -> L15
        if ((r102 instanceof WindowManager) == false) goto L6;
        WindowManager r103 = (WindowManager) r102;     // Catch: Throwable -> L15
    L7:
        if (r103 == null) goto L12;
        Display r104 = r103.getDefaultDisplay();     // Catch: Throwable -> L15
        if (r104 != null) goto L11;
        return;
    L11:
        Point r105 = new Point();     // Catch: Throwable -> L15
        r104.getRealSize(r105);     // Catch: Throwable -> L15
        f260693a = r105.y;     // Catch: Throwable -> L15
        f260694b = r105.x;     // Catch: Throwable -> L15
    L13:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
        return;
    L12:
        Resources r106 = r100.getResources();     // Catch: Throwable -> L15
        DisplayMetrics r107 = WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics());     // Catch: Throwable -> L15
        f260693a = r107.heightPixels;     // Catch: Throwable -> L15
        f260694b = r107.widthPixels;     // Catch: Throwable -> L15
        goto L13
    L6:
        r103 = null;
    L15:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
