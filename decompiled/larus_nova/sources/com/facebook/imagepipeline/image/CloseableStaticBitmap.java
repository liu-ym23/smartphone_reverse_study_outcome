package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageutils.BitmapUtil;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class CloseableStaticBitmap extends CloseableBitmap {
    private volatile Bitmap mBitmap;
    private CloseableReference<Bitmap> mBitmapReference;
    private final int mExifOrientation;
    private final QualityInfo mQualityInfo;
    private final Rect mRegionToDecode;
    private final int mRotationAngle;
    private final int mSampleSize;
    private final Rect mSmartCrop;

    private synchronized CloseableReference<Bitmap> detachBitmapReference() {
        monitor-enter(this);
        CloseableReference<Bitmap> r100 = this.mBitmapReference;     // Catch: Throwable -> L6
        this.mBitmapReference = null;     // Catch: Throwable -> L6
        this.mBitmap = null;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Nullable
    public synchronized CloseableReference<Bitmap> cloneUnderlyingBitmapReference() {
        monitor-enter(this);
        CloseableReference<Bitmap> r100 = CloseableReference.cloneOrNull(this.mBitmapReference);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized CloseableReference<Bitmap> convertToBitmapReference() {
        monitor-enter(this);
        Preconditions.checkNotNull(this.mBitmapReference, "Cannot convert a closed static bitmap");     // Catch: Throwable -> L6
        CloseableReference<Bitmap> r100 = detachBitmapReference();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public int getImageCount() {
        return 1;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public synchronized boolean isClosed() {
        monitor-enter(this);
        if (this.mBitmapReference != null) goto L6;
        boolean r100 = true;
    L7:
        monitor-exit(this);
        return r100;
    L6:
        r100 = false;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public int getHeight() {
        if ((this.mRotationAngle % 180) != 0) goto L12;
        int r100 = this.mExifOrientation;
        if (r100 == 5) goto L12;
        if (r100 == 7) goto L12;
        return getBitmapHeight(this.mBitmap);
    L12:
        return getBitmapWidth(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public int getSizeInBytes() {
        return BitmapUtil.getSizeInBytes(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public int getWidth() {
        if ((this.mRotationAngle % 180) != 0) goto L12;
        int r100 = this.mExifOrientation;
        if (r100 == 5) goto L12;
        if (r100 == 7) goto L12;
        return getBitmapWidth(this.mBitmap);
    L12:
        return getBitmapHeight(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        CloseableReference<Bitmap> r100 = detachBitmapReference();
        if (r100 == null) goto L6;
        r100.close();
        return;
    }

    public int getExifOrientation() {
        return this.mExifOrientation;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, com.facebook.imagepipeline.image.ImageInfo
    public QualityInfo getQualityInfo() {
        return this.mQualityInfo;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, com.facebook.imagepipeline.image.ImageInfo
    public Rect getRegionToDecode() {
        return this.mRegionToDecode;
    }

    public int getRotationAngle() {
        return this.mRotationAngle;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, com.facebook.imagepipeline.image.ImageInfo
    public int getSampleSize() {
        return this.mSampleSize;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, com.facebook.imagepipeline.image.ImageInfo
    public Rect getSmartCrop() {
        return this.mSmartCrop;
    }

    @Override // com.facebook.imagepipeline.image.CloseableBitmap
    public Bitmap getUnderlyingBitmap() {
        return this.mBitmap;
    }

    private static int getBitmapHeight(@Nullable Bitmap r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getHeight();
    }

    private static int getBitmapWidth(@Nullable Bitmap r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getWidth();
    }

    public CloseableStaticBitmap(CloseableReference<Bitmap> r100, QualityInfo r101, int r102) {
        this(r100, r101, r102, 0);
    }

    public CloseableStaticBitmap(CloseableReference<Bitmap> r110, QualityInfo r111, int r112, ImageFormat r113) {
        this(r110, r111, r112, 0, null, null, -1, r113);
    }

    public CloseableStaticBitmap(CloseableReference<Bitmap> r100, QualityInfo r110, int r111, int r112) {
        this(r100, r110, r111, r112, null, null, -1);
    }

    public CloseableStaticBitmap(Bitmap r100, ResourceReleaser<Bitmap> r101, QualityInfo r102, int r110) {
        this(r100, r101, r102, r110, 0);
    }

    public CloseableStaticBitmap(Bitmap r110, ResourceReleaser<Bitmap> r111, QualityInfo r112, int r113, int r114) {
        this(r110, r111, r112, r113, r114, null, null, -1);
    }

    public CloseableStaticBitmap(CloseableReference<Bitmap> r100, QualityInfo r101, int r102, int r103, Rect r104, Rect r105, int r106) {
        CloseableReference<Bitmap> r107 = (CloseableReference) Preconditions.checkNotNull(r100.cloneOrNull());
        this.mBitmapReference = r107;
        this.mBitmap = r107.get();
        this.mQualityInfo = r101;
        this.mRotationAngle = r102;
        this.mExifOrientation = r103;
        this.mRegionToDecode = r104;
        this.mSmartCrop = r105;
        this.mSampleSize = r106;
    }

    public CloseableStaticBitmap(Bitmap r100, ResourceReleaser<Bitmap> r101, QualityInfo r102, int r103, int r104, Rect r105, Rect r106, int r107) {
        this.mBitmap = (Bitmap) Preconditions.checkNotNull(r100);
        this.mBitmapReference = CloseableReference.of(this.mBitmap, (ResourceReleaser) Preconditions.checkNotNull(r101));
        this.mQualityInfo = r102;
        this.mRotationAngle = r103;
        this.mExifOrientation = r104;
        this.mRegionToDecode = r105;
        this.mSmartCrop = r106;
        this.mSampleSize = r107;
    }

    public CloseableStaticBitmap(CloseableReference<Bitmap> r100, QualityInfo r101, int r102, int r103, Rect r104, Rect r105, int r106, ImageFormat r107) {
        CloseableReference<Bitmap> r108 = (CloseableReference) Preconditions.checkNotNull(r100.cloneOrNull());
        this.mBitmapReference = r108;
        this.mBitmap = r108.get();
        this.mQualityInfo = r101;
        this.mRotationAngle = r102;
        this.mExifOrientation = r103;
        this.mRegionToDecode = r104;
        this.mSmartCrop = r105;
        this.mSampleSize = r106;
        this.mImageFormat = r107;
    }

    public CloseableStaticBitmap(CloseableReference<Bitmap> r100, QualityInfo r101, int r102, int r103, Rect r104, Rect r105, int r106, ImageFormat r107, int r108) {
        CloseableReference<Bitmap> r109 = (CloseableReference) Preconditions.checkNotNull(r100.cloneOrNull());
        this.mBitmapReference = r109;
        this.mBitmap = r109.get();
        this.mQualityInfo = r101;
        this.mRotationAngle = r102;
        this.mExifOrientation = r103;
        this.mRegionToDecode = r104;
        this.mSmartCrop = r105;
        this.mSampleSize = r106;
        this.mImageFormat = r107;
        setImageFrom(r108);
    }

    public CloseableStaticBitmap(Bitmap r100, ResourceReleaser<Bitmap> r101, QualityInfo r102, int r103, int r104, Rect r105, Rect r106, int r107, ImageFormat r108) {
        this.mBitmap = (Bitmap) Preconditions.checkNotNull(r100);
        this.mBitmapReference = CloseableReference.of(this.mBitmap, (ResourceReleaser) Preconditions.checkNotNull(r101));
        this.mQualityInfo = r102;
        this.mRotationAngle = r103;
        this.mExifOrientation = r104;
        this.mRegionToDecode = r105;
        this.mSmartCrop = r106;
        this.mSampleSize = r107;
        this.mImageFormat = r108;
    }

    public CloseableStaticBitmap(CloseableReference<Bitmap> r100, QualityInfo r101, int r102, int r103, Rect r104, Rect r105, int r106, ImageFormat r107, Map<String, String> r108) {
        CloseableReference<Bitmap> r109 = (CloseableReference) Preconditions.checkNotNull(r100.cloneOrNull());
        this.mBitmapReference = r109;
        this.mBitmap = r109.get();
        this.mQualityInfo = r101;
        this.mRotationAngle = r102;
        this.mExifOrientation = r103;
        this.mRegionToDecode = r104;
        this.mSmartCrop = r105;
        this.mSampleSize = r106;
        this.mImageFormat = r107;
        this.mExtraMap = r108;
    }

    public CloseableStaticBitmap(CloseableReference<Bitmap> r100, QualityInfo r101, int r102, int r103, Rect r104, Rect r105, int r106, ImageFormat r107, int r108, Map<String, String> r110) {
        CloseableReference<Bitmap> r109 = (CloseableReference) Preconditions.checkNotNull(r100.cloneOrNull());
        this.mBitmapReference = r109;
        this.mBitmap = r109.get();
        this.mQualityInfo = r101;
        this.mRotationAngle = r102;
        this.mExifOrientation = r103;
        this.mRegionToDecode = r104;
        this.mSmartCrop = r105;
        this.mSampleSize = r106;
        this.mImageFormat = r107;
        this.mExtraMap = r110;
        setImageFrom(r108);
    }

    public CloseableStaticBitmap(Bitmap r100, ResourceReleaser<Bitmap> r101, QualityInfo r102, int r103, int r104, Rect r105, Rect r106, int r107, ImageFormat r108, Map<String, String> r110) {
        this.mBitmap = (Bitmap) Preconditions.checkNotNull(r100);
        this.mBitmapReference = CloseableReference.of(this.mBitmap, (ResourceReleaser) Preconditions.checkNotNull(r101));
        this.mQualityInfo = r102;
        this.mRotationAngle = r103;
        this.mExifOrientation = r104;
        this.mRegionToDecode = r105;
        this.mSmartCrop = r106;
        this.mSampleSize = r107;
        this.mImageFormat = r108;
        this.mExtraMap = r110;
    }
}
