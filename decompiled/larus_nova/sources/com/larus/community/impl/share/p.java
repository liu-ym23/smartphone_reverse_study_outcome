package com.larus.community.impl.share;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.z0;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes27.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f329836a = null;

    static {
        f329836a = new p();
    }

    public p() {
    }

    public static Bitmap a(Bitmap r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "sourceBitmap");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        if (r100.isRecycled() == false) goto L6;
        return r100;
    L6:
        Bitmap r103 = r100.copy(z0.b(r100.getConfig()), false);     // Catch: Throwable -> L8
        Bitmap r104 = Bitmap.createBitmap(r103.getWidth(), r103.getHeight(), Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L8
        Canvas r105 = new Canvas(r104);     // Catch: Throwable -> L8
        Paint r106 = new Paint();     // Catch: Throwable -> L8
        r106.setAntiAlias(true);     // Catch: Throwable -> L8
        Shader.TileMode r107 = Shader.TileMode.CLAMP;     // Catch: Throwable -> L8
        r106.setShader(new BitmapShader(r103, r107, r107));     // Catch: Throwable -> L8
        r105.drawRoundRect(new RectF(0.0f, 0.0f, r103.getWidth(), r103.getHeight()), r101, r101, r106);     // Catch: Throwable -> L8
        Object r108 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L8
    L10:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L13;
        FLogger.f375446a.e("ImageCombineUtils", "Error in addRoundedCorners, returning original bitmap", r109);
    L13:
        Object r110 = r100;
        if (Result.m9455isFailureimpl(r108) == true) goto L18;
        r110 = r108;
    L18:
        return (Bitmap) r110;
    L8:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public static Bitmap b(Bitmap r100, int r101, int r110) {
        int r102 = r100.getWidth();
        int r103 = r100.getHeight();
        FLogger r104 = FLogger.f375446a;
        r104.d("ImageCombineUtils", "Source: " + r102 + Permission.EXECUTE + r103 + ", Target: " + r101 + Permission.EXECUTE + r110);
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L12
        if (Math.abs((r102 / r103) - (r101 / r110)) > 0.01f) goto L6;
        r104.d("ImageCombineUtils", "Same aspect ratio - direct scale");     // Catch: Throwable -> L12
        Bitmap r106 = Bitmap.createScaledBitmap(r100, r101, r110, true);     // Catch: Throwable -> L12
    L10:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L12
    L14:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L18;
        FLogger.f375446a.e("ImageCombineUtils", "Error in processBitmapToTargetSize, trying fallback", r108);
    L18:
        if (Result.m9452exceptionOrNullimpl(r107) == null) goto L33;
        Object r109 = Result.m9449constructorimpl(Bitmap.createScaledBitmap(r100, r101, r110, true));     // Catch: Throwable -> L22
    L24:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r109);
        if (r111 == null) goto L27;
        FLogger.f375446a.e("ImageCombineUtils", "Fallback also failed, returning original", r111);
    L27:
        Object r112 = r100;
        if (Result.m9455isFailureimpl(r109) == true) goto L31;
        r112 = r109;
    L31:
        r107 = (Bitmap) r112;
    L22:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L33:
        return (Bitmap) r107;
    L6:
        if (r102 < r101) goto L9;
        if (r103 < r110) goto L9;
        r104.d("ImageCombineUtils", "Center crop - source is larger with different ratio");     // Catch: Throwable -> L12
        int r114 = r100.getWidth();     // Catch: Throwable -> L12
        int r115 = r100.getHeight();     // Catch: Throwable -> L12
        r106 = Bitmap.createBitmap(r100, Math.max(0, (r114 - r101) / 2), Math.max(0, (r115 - r110) / 2), Math.min(r101, r114), Math.min(r110, r115));     // Catch: Throwable -> L12
    L9:
        r104.d("ImageCombineUtils", "Scale up and crop - different ratio");     // Catch: Throwable -> L12
        r106 = d(r100, r101, r110);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public static Bitmap d(Bitmap r100, int r101, int r102) {
        float r103 = r100.getWidth();
        float r104 = r100.getHeight();
        float r105 = Math.max(r101 / r103, r102 / r104);
        FLogger.f375446a.d("ImageCombineUtils", "Scale factor: " + r105);
        int r106 = (int) (r103 * r105);
        int r107 = (int) (r104 * r105);
        Bitmap r108 = Bitmap.createScaledBitmap(r100, r106, r107, true);
        if (r106 != r101) goto L6;
        if (r107 != r102) goto L6;
        return r108;
    L6:
        Bitmap r109 = Bitmap.createBitmap(r108, Math.max(0, (r106 - r101) / 2), Math.max(0, (r107 - r102) / 2), r101, r102);
        if (Intrinsics.areEqual(r108, r100) == true) goto L9;
        r108.recycle();
    L9:
        return r109;
    }

    public static Bitmap c(Function2 r110, int r111, int r112, Bitmap r113) {
        if (z2.f365865a.disablePuzzleSizeLimit() == true) goto L5;
        float r100 = 1.0f;
        Throwable r101 = null;
    L8:
        if (r100 < 0.25f) goto L30;
        int r102 = (int) (r111 * r100);
        int r103 = (int) (r112 * r100);
        if (r102 > 4096) goto L29;
        if (r103 > 4096) goto L29;
        FLogger.f375446a.d("ImageCombineUtils", "Attempting operation with scale: " + r100 + ", size: " + r102 + Permission.EXECUTE + r103);
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L16
        Object r105 = Result.m9449constructorimpl((Bitmap) r110.invoke(Integer.valueOf(r102), Integer.valueOf(r103)));     // Catch: Throwable -> L16
    L19:
        if (Result.m9456isSuccessimpl(r105) == true) goto L21;
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L8;
        if ((r106 instanceof OutOfMemoryError) == false) goto L27;
        FLogger.f375446a.w("ImageCombineUtils", "OOM occurred with scale: " + r100 + ", trying smaller scale", r106);
    L28:
        r100 = r100 * 0.75f;
        r101 = r106;
        goto L8
    L27:
        FLogger.f375446a.e("ImageCombineUtils", "Unexpected error with scale: " + r100, r106);
        goto L28
    L21:
        return (Bitmap) r105;
    L16:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L29:
        FLogger.f375446a.w("ImageCombineUtils", "Bitmap size too large: " + r102 + Permission.EXECUTE + r103 + ", scaling down");
        r100 = r100 * 0.75f;
        goto L8
    L30:
        FLogger.f375446a.e("ImageCombineUtils", "All attempts failed, returning fallback bitmap", r101);
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L33
        Object r115 = Result.m9449constructorimpl(a(r113, i5.q()));     // Catch: Throwable -> L33
    L35:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r115);
        if (r116 != null) goto L38;
        Object r117 = r115;
    L40:
        return (Bitmap) r117;
    L38:
        FLogger.f375446a.e("ImageCombineUtils", "Even fallback failed, returning original bitmap", r116);
        r117 = r113;
    L33:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L35
    L5:
        return (Bitmap) r110.invoke(Integer.valueOf(r111), Integer.valueOf(r112));
    }
}
