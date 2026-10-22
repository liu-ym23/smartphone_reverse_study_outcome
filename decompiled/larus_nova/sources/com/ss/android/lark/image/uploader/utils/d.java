package com.ss.android.lark.image.uploader.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f426439a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Paint f426440b = null;

    public d() {
    }

    static {
        f426439a = new d();
        f426440b = new Paint(6);
    }

    public final Bitmap a(Bitmap r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "inBitmap");
        switch(r101) {
            case 2: goto L5;
            case 3: goto L5;
            case 4: goto L5;
            case 5: goto L5;
            case 6: goto L5;
            case 7: goto L5;
            case 8: goto L5;
            default: goto L4;
        };
    L4:
        boolean r102 = false;
    L6:
        if (r102 == true) goto L8;
        return r100;
    L8:
        Matrix r103 = new Matrix();
        switch(r101) {
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            default: goto L18;
        };
    L11:
        r103.setRotate(-90.0f);
        goto L18
    L12:
        r103.setRotate(-90.0f);
        r103.postScale(-1.0f, 1.0f);
        goto L18
    L13:
        r103.setRotate(90.0f);
        goto L18
    L14:
        r103.setRotate(90.0f);
        r103.postScale(-1.0f, 1.0f);
        goto L18
    L15:
        r103.setRotate(180.0f);
        r103.postScale(-1.0f, 1.0f);
        goto L18
    L16:
        r103.setRotate(180.0f);
        goto L18
    L17:
        r103.setScale(-1.0f, 1.0f);
    L18:
        RectF r104 = new RectF(0.0f, 0.0f, r100.getWidth(), r100.getHeight());
        r103.mapRect(r104);
        int r105 = Math.round(r104.width());
        int r106 = Math.round(r104.height());
        Bitmap.Config r107 = r100.getConfig();
        if (r107 != null) goto L21;
        r107 = Bitmap.Config.ARGB_8888;
    L21:
        Bitmap r108 = Bitmap.createBitmap(r105, r106, r107);
        r103.postTranslate(-r104.left, -r104.top);
        r108.setHasAlpha(r100.hasAlpha());
        monitor-enter(this);
        Canvas r109 = new Canvas(r108);     // Catch: Throwable -> L26
        r109.drawBitmap(r100, r103, f426440b);     // Catch: Throwable -> L26
        r109.setBitmap(null);     // Catch: Throwable -> L26
        monitor-exit(this);
        return r108;
    L26:
        th = move-exception;
        throw th;
    L5:
        r102 = true;
        goto L6
    }
}
