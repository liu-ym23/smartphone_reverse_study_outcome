package com.ss.android.photoeditor.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes38.dex */
public final class b {
    public static String b(Context r100) {
        StringBuilder r101 = new StringBuilder();
        String r102 = com.ss.android.lark.diskmanage.storage.d.i(r100) + "/editor_result/";
        FileUtils.t(r102);
        r101.append(r102);
        r101.append(System.currentTimeMillis());
        r101.append(".jpeg");
        return r101.toString();
    }

    public static void e(Bitmap r100) {
        Log.i("PhotoEditorUtil", "safeRecycleBitmap");
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isRecycled() == true) goto L9;
        r100.recycle();
        return;
    }

    public static void g(Matrix r100, Bitmap r101, RectF r102) {
        if (r100 == null) goto L8;
        if (r101 == null) goto L9;
        if (r102 == null) goto L10;
        r100.reset();
        float r103 = r102.width() / r101.getWidth();
        float r104 = r102.left;
        float r105 = r102.top;
        r100.postScale(r103, r103);
        r100.postTranslate(r104, r105);
        return;
    L10:
        return;
    L9:
        return;
    }

    public static RectF a(PointF r100, PointF r101, PointF r102, PointF r103) {
        if (Math.abs(r100.x - r101.x) >= 3.0f) goto L21;
        if (r100.x >= r102.x) goto L14;
        if (r100.y < r101.y) goto L11;
        r100 = r101;
    L11:
        if (r102.y > r103.y) goto L47;
    L58:
        r102 = r100;
        r100 = r103;
    L60:
        return new RectF(r102.x, r102.y, r100.x, r100.y);
    L47:
        r102 = r100;
        r100 = r102;
        goto L60
    L14:
        if (r102.y < r103.y) goto L18;
        r102 = r103;
    L18:
        if (r100.y > r101.y) goto L60;
    L49:
        r100 = r101;
        goto L60
    L21:
        if (Math.abs(r100.x - r102.x) >= 3.0f) goto L40;
        if (r100.x >= r101.x) goto L32;
        if (r100.y < r102.y) goto L29;
        r100 = r102;
    L29:
        if (r101.y <= r103.y) goto L58;
    L48:
        r102 = r100;
        goto L49
    L32:
        if (r101.y < r103.y) goto L36;
        r101 = r103;
    L36:
        if (r100.y > r102.y) goto L56;
        r100 = r101;
    L56:
        r102 = r101;
        goto L60
    L40:
        if (r100.x >= r101.x) goto L51;
        if (r100.y < r103.y) goto L46;
        r100 = r103;
    L46:
        if (r102.y <= r101.y) goto L48;
    L51:
        if (r101.y < r102.y) goto L55;
        r101 = r102;
    L55:
        if (r100.y > r103.y) goto L56;
        r100 = r101;
        goto L58
    }

    public static void c(PointF r100, float r101, float r110, int r111) {
        double r102 = r111 * 0.017453292f;
        float r112 = (float) (((((double) (r100.x - r101)) * Math.cos(r102)) - (((double) (r100.y - r110)) * Math.sin(r102))) + ((double) r101));
        float r103 = (float) (((((double) (r100.x - r101)) * Math.sin(r102)) + (((double) (r100.y - r110)) * Math.cos(r102))) + ((double) r110));
        r100.x = r112;
        r100.y = r103;
    }

    public static void d(RectF r100, int r101, float r102, float r103) {
        PointF r104 = new PointF(r100.left, r100.top);
        PointF r105 = new PointF(r100.right, r100.top);
        PointF r106 = new PointF(r100.left, r100.bottom);
        PointF r107 = new PointF(r100.right, r100.bottom);
        c(r104, r102, r103, r101);
        c(r105, r102, r103, r101);
        c(r106, r102, r103, r101);
        c(r107, r102, r103, r101);
        r100.set(a(r104, r105, r106, r107));
    }

    public static void f(RectF r100, float r101, float r102, float r103, float r104) {
        r100.left = ((r100.left - r101) * r103) + r101;
        r100.right = ((r100.right - r101) * r103) + r101;
        r100.top = ((r100.top - r102) * r104) + r102;
        r100.bottom = ((r100.bottom - r102) * r104) + r102;
    }
}
