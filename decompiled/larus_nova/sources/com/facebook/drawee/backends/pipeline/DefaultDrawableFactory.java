package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.OrientedDrawable;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class DefaultDrawableFactory implements DrawableFactory {

    @Nullable
    private final DrawableFactory mAnimatedDrawableFactory;
    private final Resources mResources;

    @Override // com.facebook.imagepipeline.drawable.DrawableFactory
    public boolean supportsImageType(CloseableImage r100) {
        return true;
    }

    private static boolean hasTransformableExifOrientation(CloseableStaticBitmap r100) {
        if (r100.getExifOrientation() != 1) goto L5;
    L7:
        return false;
    L5:
        if (r100.getExifOrientation() == 0) goto L7;
        return true;
    }

    private static boolean hasTransformableRotationAngle(CloseableStaticBitmap r100) {
        if (r100.getRotationAngle() != 0) goto L5;
    L7:
        return false;
    L5:
        if (r100.getRotationAngle() == (-1)) goto L7;
        return true;
    }

    @Override // com.facebook.imagepipeline.drawable.DrawableFactory
    @Nullable
    public Drawable createDrawable(CloseableImage r100) {
    L34:
        th = move-exception;
        if (FrescoSystrace.isTracing() == false) goto L38;
        FrescoSystrace.endSection();
    L38:
        throw th;
    L3:
        if (FrescoSystrace.isTracing() == false) goto L6;
        FrescoSystrace.beginSection("DefaultDrawableFactory#createDrawable");     // Catch: Throwable -> L34
    L6:
        if ((r100 instanceof CloseableStaticBitmap) == false) goto L20;
        CloseableStaticBitmap r101 = (CloseableStaticBitmap) r100;     // Catch: Throwable -> L34
        BitmapDrawable r102 = new BitmapDrawable(this.mResources, r101.getUnderlyingBitmap());     // Catch: Throwable -> L34
        if (hasTransformableRotationAngle(r101) == false) goto L10;
    L15:
        OrientedDrawable r103 = new OrientedDrawable(r102, r101.getRotationAngle(), r101.getExifOrientation());     // Catch: Throwable -> L34
        if (FrescoSystrace.isTracing() == false) goto L19;
        FrescoSystrace.endSection();
    L19:
        return r103;
    L10:
        if (hasTransformableExifOrientation(r101) == true) goto L15;
        if (FrescoSystrace.isTracing() == false) goto L14;
        FrescoSystrace.endSection();
    L14:
        return r102;
    L20:
        DrawableFactory r104 = this.mAnimatedDrawableFactory;     // Catch: Throwable -> L34
        if (r104 == null) goto L30;
        if (r104.supportsImageType(r100) == false) goto L30;
        Drawable r105 = this.mAnimatedDrawableFactory.createDrawable(r100);     // Catch: Throwable -> L34
        if (FrescoSystrace.isTracing() == false) goto L28;
        FrescoSystrace.endSection();
    L28:
        return r105;
    L30:
        if (FrescoSystrace.isTracing() == false) goto L40;
        FrescoSystrace.endSection();
        return null;
    L40:
        return null;
    }

    public DefaultDrawableFactory(Resources r100, @Nullable DrawableFactory r101) {
        this.mResources = r100;
        this.mAnimatedDrawableFactory = r101;
    }

    @Override // com.facebook.imagepipeline.drawable.DrawableFactory
    @Nullable
    public Drawable createDrawable(CloseableImage r100, Drawable r101) {
    L26:
        th = move-exception;
        if (FrescoSystrace.isTracing() == false) goto L30;
        FrescoSystrace.endSection();
    L30:
        throw th;
    L3:
        if (FrescoSystrace.isTracing() == false) goto L6;
        FrescoSystrace.beginSection("DefaultDrawableFactory#createDrawable");     // Catch: Throwable -> L26
    L6:
        if ((r100 instanceof CloseableStaticBitmap) == false) goto L12;
        Drawable r102 = createDrawable(r100);     // Catch: Throwable -> L26
        if (FrescoSystrace.isTracing() == false) goto L11;
        FrescoSystrace.endSection();
    L11:
        return r102;
    L12:
        DrawableFactory r103 = this.mAnimatedDrawableFactory;     // Catch: Throwable -> L26
        if (r103 == null) goto L22;
        if (r103.supportsImageType(r100) == false) goto L22;
        Drawable r104 = this.mAnimatedDrawableFactory.createDrawable(r100, r101);     // Catch: Throwable -> L26
        if (FrescoSystrace.isTracing() == false) goto L20;
        FrescoSystrace.endSection();
    L20:
        return r104;
    L22:
        if (FrescoSystrace.isTracing() == false) goto L32;
        FrescoSystrace.endSection();
        return null;
    L32:
        return null;
    }
}
