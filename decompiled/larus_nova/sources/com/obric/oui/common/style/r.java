package com.obric.oui.common.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.android.SystemUtils;
import com.lynx.serval.svg.SVGRenderEngine;
import com.obric.common.oea.foundation.graphics.smoothcorner.SmoothCornerHelper;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SmoothCornerHelper f399599a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SmoothCornerHelper f399600b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SmoothCornerHelper f399601c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final SmoothCornerHelper f399602d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f399603e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f399604f = false;

    static {
        f399599a = new SmoothCornerHelper();
        SmoothCornerHelper r100 = new SmoothCornerHelper();
        r100.b(SmoothCornerHelper.Companion.CurveType.BASIC);
        f399600b = r100;
        SmoothCornerHelper r101 = new SmoothCornerHelper();
        r101.b(SmoothCornerHelper.Companion.CurveType.SKETCH);
        f399601c = r101;
        SmoothCornerHelper r102 = new SmoothCornerHelper();
        r102.b(SmoothCornerHelper.Companion.CurveType.QUADRATIC_CAPSULE);
        f399602d = r102;
        f399603e = !TextUtils.equals(SystemUtils.PRODUCT_HUAWEI, Build.BRAND);
        f399604f = true;
    }

    public static Path a(RectF r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, SVGRenderEngine.RECT);
        float r102 = c(r101, r100);
        SmoothCornerHelper r103 = b(r102, Math.min(r100.width(), r100.height()));
        Rect r104 = new Rect();
        r100.roundOut(r104);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, SVGRenderEngine.RECT);
        return r103.f396561a.a(r104.left, r104.top, r104.right, r104.bottom, r102);
    }

    public static SmoothCornerHelper b(float r100, float r101) {
        if (f399604f == true) goto L5;
        SmoothCornerHelper r102 = f399599a;
        if (r102.f396561a.c(r100, r101) == true) goto L14;
        SmoothCornerHelper r103 = f399601c;
        if (r103.f396561a.c(r100, r101) == false) goto L13;
        return r103;
    L13:
        return f399602d;
    L14:
        return r102;
    L5:
        return f399600b;
    }

    public static float c(float r100, RectF r101) {
        if (r101.isEmpty() == false) goto L7;
        wma.b.b("SmoothCornerH", "decideValidCornerRadius: rectF is empty");
        return 0.0f;
    L7:
        return RangesKt.coerceAtLeast(Math.min(r100, Math.min(r101.width(), r101.height()) / 2.0f), 0.0f);
    }

    @JvmStatic
    public static final void e(Canvas r110, RectF r111, float r112, Paint r113) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r111, "rectF");
        Intrinsics.checkNotNullParameter(r113, "paint");
        float r100 = c(r112, r111);
        SmoothCornerHelper r101 = b(r100, Math.min(r111.width(), r111.height()));
        r101.getClass();
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r111, SVGRenderEngine.RECT);
        Intrinsics.checkNotNullParameter(r113, "paint");
        if (r111.isEmpty() == false) goto L5;
        mja.a.C6822a r114 = mja.a.f514263a;
        mja.a.b("SmoothCornerHelper", "empty rect: " + r111);
        return;
    L5:
        r101.a(r110, r113, r111.left, r111.top, r111.right, r111.bottom, r100);
    }

    @JvmStatic
    public static final void d(Canvas r100, float r110, float r111, float r112, float r113, float r114, Paint r115) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r115, "paint");
        float r101 = r112 - r110;
        float r102 = r113 - r111;
        float r103 = RangesKt.coerceAtLeast(Math.min(r114, Math.min(Math.abs(r101), Math.abs(r102)) / 2.0f), 0.0f);
        b(r103, Math.min(Math.abs(r101), Math.abs(r102))).a(r100, r115, r110, r111, r112, r113, r103);
    }
}
