package com.bytedance.ug.sdk.luckycat.impl.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.camera.video.AudioStats;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.common.utility.DeviceUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes22.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f271523a = 0;

    static {
    }

    public static boolean a(String r100) {
        if (r100 != null) goto L6;
        a.c("PadAdapterUtils", "enablePadAdapter, schema is null");
        return false;
    L6:
        a.c("PadAdapterUtils", "enablePadAdapter start, schema = ".concat(r100));
        Uri r101 = UriProtector.parse(r100);
        if (r101 != null) goto L10;
        a.c("PadAdapterUtils", "enablePadAdapter, uri is null, schema = ".concat(r100));
        return false;
    L10:
        String r102 = UriProtector.getQueryParameter(r101, "enable_pad_adapter");
        if (r102 != null) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(r102, "1") == false) goto L15;
    L16:
        return true;
    L15:
        if (Intrinsics.areEqual(r102, "true") == true) goto L16;
        return false;
    }

    public static Pair b(Context r100, String r110) {
        Double r101 = null;
        if (r100 != null) goto L6;
        a.c("PadAdapterUtils", "getTaskContainerViewInfo, context is null");
        return null;
    L6:
        if (r110 != null) goto L9;
        a.c("PadAdapterUtils", "getTaskContainerViewInfo, schema is null");
        return null;
    L9:
        a.c("PadAdapterUtils", "getTaskContainerViewInfo start, schema=".concat(r110));
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L22
        Object r103 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Throwable -> L22
        if (r103 != null) goto L13;
    L20:
        Resources r104 = r100.getResources();     // Catch: Throwable -> L22
        DisplayMetrics r105 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics());     // Catch: Throwable -> L22
        Pair r106 = new Pair(Integer.valueOf(r105.widthPixels), Integer.valueOf(r105.heightPixels));     // Catch: Throwable -> L22
    L54:
    L27:
        if (r106 == null) goto L53;
        a.c("PadAdapterUtils", "screenInfo = " + ((Number) r106.getFirst()).intValue() + ", " + ((Number) r106.getSecond()).intValue());
        int r107 = ((Number) r106.getFirst()).intValue();
        int r108 = ((Number) r106.getSecond()).intValue();
        com.bytedance.ug.sdk.luckycat.impl.manager.m r109 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a;
        int r111 = (r108 + 0) + 0;
        if ((r100 instanceof Activity) == true) goto L31;
        Context r112 = null;
    L32:
        Activity r113 = (Activity) r112;
        if (r113 != null) goto L35;
    L37:
        double r114 = ((double) r107) / ((double) r111);
        Uri r115 = UriProtector.parse(r110);
        if (r115 == null) goto L53;
        String r116 = UriProtector.getQueryParameter(r115, "pad_ratio");
        if (r116 == null) goto L42;
        r101 = StringsKt.toDoubleOrNull(r116);
    L42:
        if (r101 != null) goto L44;
    L46:
        Float r117 = Float.valueOf(0.47368422f);
    L48:
        if (Double.compare(r114, r117.floatValue()) <= 0) goto L50;
        int r118 = (int) (r111 * r117.floatValue());
        int r119 = r111;
    L51:
        a.c("PadAdapterUtils", "getTaskContainerViewInfo, screenUsableWidth=" + r107 + ", screenUsableHeight=" + r111 + ", topHeight=0, bottomHeight=0, screenRatio=" + r114 + ", passRatio=" + r117 + ", padRatioWidth=" + r118 + ", padRatioHeight=" + r119);
        return new Pair(Integer.valueOf(r118), Integer.valueOf(r119));
    L50:
        r119 = (int) (r107 / r117.floatValue());
        r118 = r107;
        goto L51
    L44:
        if (r101.doubleValue() <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L46;
        r117 = Float.valueOf((float) r101.doubleValue());
        goto L48
    L35:
        if (DeviceUtils.hasNavBar(r113) == false) goto L37;
        r111 = r111 - DeviceUtils.getNavigationBarHeight(r100);
        goto L37
    L31:
        r112 = r100;
    L53:
        return null;
    L13:
        if ((r103 instanceof WindowManager) == true) goto L15;
        r103 = null;
    L15:
        WindowManager r120 = (WindowManager) r103;     // Catch: Throwable -> L22
        if (r120 == null) goto L20;
        Display r121 = r120.getDefaultDisplay();     // Catch: Throwable -> L22
        if (r121 == null) goto L20;
        Point r122 = new Point();     // Catch: Throwable -> L22
        r121.getRealSize(r122);     // Catch: Throwable -> L22
        r106 = new Pair(Integer.valueOf(r122.x), Integer.valueOf(r122.y));     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        Object r124 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r124) == false) goto L26;
        r124 = null;
    L26:
        r106 = (Pair) r124;
        goto L27
    }
}
