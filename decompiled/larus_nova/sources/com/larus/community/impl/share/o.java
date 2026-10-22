package com.larus.community.impl.share;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import com.larus.utils.logger.FLogger;
import kotlin.KotlinNothingValueException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final /* synthetic */ class o implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bitmap f329833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bitmap f329834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f329835c;

    public /* synthetic */ o(Bitmap r100, Bitmap r101) {
        this.f329833a = r100;
        this.f329834b = r101;
        this.f329835c = 0.0f;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object r110, Object r111) {
        Bitmap r100 = this.f329833a;
        Bitmap r101 = this.f329834b;
        float r102 = this.f329835c;
        int r112 = ((Integer) r110).intValue();
        int r113 = ((Integer) r111).intValue();
        p.f329836a.getClass();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L17
        int r104 = r112 * 2;     // Catch: Throwable -> L17
        Bitmap r105 = Bitmap.createBitmap(r104, r113, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L17
        Canvas r106 = new Canvas(r105);     // Catch: Throwable -> L17
        Bitmap r107 = p.b(r100, r112, r113);     // Catch: Throwable -> L17
        if (r101.getWidth() == r112) goto L6;
    L9:
        Bitmap r108 = Bitmap.createScaledBitmap(r101, r112, r113, true);     // Catch: Throwable -> L17
    L10:
        Bitmap r109 = Bitmap.createBitmap(r104, r113, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L17
        Canvas r114 = new Canvas(r109);     // Catch: Throwable -> L17
        r114.drawBitmap(r107, 0.0f, 0.0f, null);     // Catch: Throwable -> L17
        r114.drawBitmap(r108, r112, 0.0f, null);     // Catch: Throwable -> L17
        Paint r115 = new Paint();     // Catch: Throwable -> L17
        r115.setAntiAlias(true);     // Catch: Throwable -> L17
        Shader.TileMode r116 = Shader.TileMode.CLAMP;     // Catch: Throwable -> L17
        r115.setShader(new BitmapShader(r109, r116, r116));     // Catch: Throwable -> L17
        r106.drawRoundRect(new RectF(0.0f, 0.0f, r104, r113), r102, r102, r115);     // Catch: Throwable -> L17
        r109.recycle();     // Catch: Throwable -> L17
        if (Intrinsics.areEqual(r107, r100) == true) goto L14;
        r107.recycle();     // Catch: Throwable -> L17
    L14:
        if (Intrinsics.areEqual(r108, r101) == true) goto L26;
        r108.recycle();     // Catch: Throwable -> L17
    L26:
        return r105;
    L6:
        if (r101.getHeight() != r113) goto L9;
        r108 = r101;
    L17:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        Throwable r118 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r118 == null) goto L23;
        FLogger.f375446a.e("ImageCombineUtils", "combineImagesHorizontallyInternal error", r118);
        return r101;
    L23:
        throw new KotlinNothingValueException();
    }
}
