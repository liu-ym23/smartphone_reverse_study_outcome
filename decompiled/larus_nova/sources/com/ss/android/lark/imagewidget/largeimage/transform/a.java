package com.ss.android.lark.imagewidget.largeimage.transform;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f426681a = 0;

    static {
    }

    public static Bitmap a(Bitmap r110, float r210, float r211, Path r212, boolean r213, Function2 r214) {
        Intrinsics.checkNotNullParameter(r110, "inBitmap");
        Intrinsics.checkNotNullParameter(r214, "bitmapProvider");
        if (Math.abs(r210 - 1.0f) <= 1.0E-4f) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == true) goto L12;
        if (r213 == true) goto L12;
        return r110;
    L12:
        Matrix r101 = new Matrix();
        if (r100 == false) goto L15;
        r101.postScale(r210, r211, r110.getWidth() / 2.0f, r110.getHeight() / 2.0f);
    L15:
        Rect r102 = null;
        if (r213 == false) goto L21;
        int r103 = r110.getWidth();
        int r104 = r110.getHeight();
        if (r212 == null) goto L21;
        Matrix r111 = new Matrix();
        r111.setScale(r103 / 100.0f, r104 / 100.0f);
        Path r105 = new Path(r212);
        r105.transform(r111);
    L22:
        float r106 = 0.0f;
        if (r105 == null) goto L73;
        PathMeasure r107 = new PathMeasure(r105, false);
        float[] r112 = new float[2];
        float r113 = Float.NEGATIVE_INFINITY;
        float r114 = Float.NEGATIVE_INFINITY;
        float r115 = Float.POSITIVE_INFINITY;
        float r116 = Float.POSITIVE_INFINITY;
    L25:
        float r117 = r107.getLength();
        if (r117 <= r106) goto L56;
    L29:
        if (r106 > r117) goto L43;
        r107.getPosTan(r106, r112, null);
        float r118 = r112[0];
        float r119 = r112[1];
        if (r118 >= r116) goto L34;
        r116 = r118;
    L34:
        if (r118 <= r114) goto L37;
        r114 = r118;
    L37:
        if (r119 >= r115) goto L40;
        r115 = r119;
    L40:
        if (r119 <= r113) goto L42;
        r113 = r119;
    L42:
        r106 = r106 + 1.0f;
        goto L29
    L43:
        r107.getPosTan(r117, r112, null);
        float r108 = r112[0];
        float r120 = r112[1];
        if (r108 >= r116) goto L47;
        r116 = r108;
    L47:
        if (r108 <= r114) goto L50;
        r114 = r108;
    L50:
        if (r120 >= r115) goto L53;
        r115 = r120;
    L53:
        if (r120 <= r113) goto L56;
        r113 = r120;
    L56:
        if (r107.nextContour() == false) goto L58;
        r106 = 0.0f;
        goto L25
    L58:
        if (r116 != Float.POSITIVE_INFINITY) goto L60;
        boolean r109 = true;
    L61:
        if (r109 == false) goto L63;
        RectF r121 = new RectF();
    L64:
        r101.mapRect(r121);
        int r122 = r110.getWidth();
        int r123 = r110.getHeight();
        if (r121.isEmpty() == true) goto L73;
        int r124 = Math.min(Math.max((int) Math.floor(r121.left), 0), r122);
        int r125 = Math.min(Math.max((int) Math.floor(r121.top), 0), r123);
        int r126 = Math.min(Math.max((int) Math.ceil(r121.right), 0), r122);
        int r127 = Math.min(Math.max((int) Math.ceil(r121.bottom), 0), r123);
        if (r126 <= r124) goto L73;
        if (r127 <= r125) goto L73;
        r102 = new Rect(r124, r125, r126, r127);
        goto L73
    L63:
        r121 = new RectF(r116, r115, r114, r113);
        goto L64
    L60:
        r109 = false;
    L73:
        if (r102 == null) goto L75;
        int r128 = r102.width();
    L76:
        if (r102 == null) goto L78;
        int r129 = r102.height();
    L79:
        Bitmap r130 = (Bitmap) r214.invoke(Integer.valueOf(r128), Integer.valueOf(r129));
        r130.setHasAlpha(true);
        Canvas r131 = new Canvas(r130);
        r131.drawColor(-16777216);
        Matrix r132 = new Matrix(r101);
        if (r102 == null) goto L82;
        r132.postTranslate(-r102.left, -r102.top);
    L82:
        Paint r133 = new Paint(3);
        int r134 = r131.save();
        r131.concat(r132);
        if (r105 != null) goto L91;
    L85:
        r131.drawBitmap(r110, 0.0f, 0.0f, r133);     // Catch: Throwable -> L88
        r131.restoreToCount(r134);
        return r130;
    L88:
        th = move-exception;
        r131.restoreToCount(r134);
        throw th;
    L91:
        r131.clipPath(r105);     // Catch: Throwable -> L88
        goto L85
    L78:
        r129 = r110.getHeight();
        goto L79
    L75:
        r128 = r110.getWidth();
    L21:
        r105 = null;
        goto L22
    L5:
        if (Math.abs(r211 - 1.0f) > 1.0E-4f) goto L8;
        r100 = false;
        goto L9
    }
}
