package com.ss.android.lark.image.impl.compress2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a*\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004\u001a\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0004\u001a\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0002\u001a\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0002\u001a \u0010\u0015\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"DEFAULT_PAINT", "Landroid/graphics/Paint;", "rotateSizeIfNeeded", "Lkotlin/Pair;", "", "width", "height", "exifOrientation", "rotateImageExif", "Landroid/graphics/Bitmap;", "inBitmap", "isRotationRequired", "", "degreesToRotate", "initializeMatrixForRotation", "", "matrix", "Landroid/graphics/Matrix;", "getNonNullConfig", "Landroid/graphics/Bitmap$Config;", SimplayerImageStrategy.RESULT_BITMAP, "applyMatrix", "targetBitmap", "lark-image_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TransformationUtilsKt {
    private static final Paint DEFAULT_PAINT = null;

    static {
        DEFAULT_PAINT = new Paint(6);
    }

    private static final Bitmap.Config getNonNullConfig(Bitmap r100) {
        Bitmap.Config r101 = r100.getConfig();
        if (r101 == null) goto L5;
        return r101;
    L5:
        return Bitmap.Config.ARGB_8888;
    }

    private static final void initializeMatrixForRotation(int r100, Matrix r101) {
        switch(r100) {
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L19;
        };
    L5:
        r101.setRotate(-90.0f);
        return;
    L6:
        r101.setRotate(-90.0f);
        r101.postScale(-1.0f, 1.0f);
        return;
    L7:
        r101.setRotate(90.0f);
        return;
    L8:
        r101.setRotate(90.0f);
        r101.postScale(-1.0f, 1.0f);
        return;
    L9:
        r101.setRotate(180.0f);
        r101.postScale(-1.0f, 1.0f);
        return;
    L10:
        r101.setRotate(180.0f);
        return;
    L11:
        r101.setScale(-1.0f, 1.0f);
        return;
    }

    public static final Bitmap rotateImageExif(Bitmap r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "inBitmap");
        if (TransformationUtils.isExifOrientationRequired(r101) == true) goto L5;
        return r100;
    L5:
        Matrix r102 = new Matrix();
        initializeMatrixForRotation(r101, r102);
        RectF r103 = new RectF(0.0f, 0.0f, r100.getWidth(), r100.getHeight());
        r102.mapRect(r103);
        Bitmap r104 = Bitmap.createBitmap(Math.round(r103.width()), Math.round(r103.height()), getNonNullConfig(r100));
        r102.postTranslate(-r103.left, -r103.top);
        r104.setHasAlpha(r100.hasAlpha());
        applyMatrix(r100, r104, r102);
        return r104;
    }

    private static final void applyMatrix(Bitmap r100, Bitmap r101, Matrix r102) {
        TransformationUtils.getBitmapDrawableLock().lock();
        Canvas r103 = new Canvas(r101);     // Catch: Throwable -> L6
        r103.drawBitmap(r100, r102, DEFAULT_PAINT);     // Catch: Throwable -> L6
        r103.setBitmap(null);     // Catch: Throwable -> L6
        TransformationUtils.getBitmapDrawableLock().unlock();
        return;
    L6:
        th = move-exception;
        TransformationUtils.getBitmapDrawableLock().unlock();
        throw th;
    }
}
