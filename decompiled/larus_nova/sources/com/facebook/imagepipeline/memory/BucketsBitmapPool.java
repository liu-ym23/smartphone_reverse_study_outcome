package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class BucketsBitmapPool extends BasePool<Bitmap> implements BitmapPool {
    @Override // com.facebook.imagepipeline.memory.BasePool
    public int getBucketedSize(int r100) {
        return r100;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public int getSizeInBytes(int r100) {
        return r100;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.imagepipeline.memory.BasePool
    public Bitmap alloc(int r100) {
        return Bitmap.createBitmap(1, (int) Math.ceil(((double) r100) / 2.0d), Bitmap.Config.RGB_565);
    }

    /* JADX INFO: renamed from: free, reason: avoid collision after fix types in other method */
    public void free2(Bitmap r100) {
        Preconditions.checkNotNull(r100);
        r100.recycle();
    }

    /* JADX INFO: renamed from: getBucketedSizeForValue, reason: avoid collision after fix types in other method */
    public int getBucketedSizeForValue2(Bitmap r100) {
        Preconditions.checkNotNull(r100);
        return r100.getAllocationByteCount();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.imagepipeline.memory.BasePool
    @Nullable
    public Bitmap getValue(Bucket<Bitmap> r100) {
        Bitmap r101 = (Bitmap) super.getValue(r100);
        if (r101 == null) goto L5;
        r101.eraseColor(0);
    L5:
        return r101;
    }

    /* JADX INFO: renamed from: isReusable, reason: avoid collision after fix types in other method */
    public boolean isReusable2(Bitmap r100) {
        Preconditions.checkNotNull(r100);
        if (r100.isRecycled() == false) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L10;
        r100.setPremultiplied(true);
    L10:
        return r101;
    L5:
        if (r100.isMutable() == false) goto L7;
        r101 = true;
        goto L8
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public /* bridge */ /* synthetic */ Bitmap alloc(int r100) {
        return alloc(r100);
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public /* bridge */ /* synthetic */ void free(Bitmap r100) {
        free2(r100);
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public /* bridge */ /* synthetic */ int getBucketedSizeForValue(Bitmap r100) {
        return getBucketedSizeForValue2(r100);
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    @Nullable
    public /* bridge */ /* synthetic */ Bitmap getValue(Bucket<Bitmap> r100) {
        return getValue(r100);
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public /* bridge */ /* synthetic */ boolean isReusable(Bitmap r100) {
        return isReusable2(r100);
    }

    public BucketsBitmapPool(MemoryTrimmableRegistry r100, PoolParams r101, PoolStatsTracker r102) {
        super(r100, r101, r102);
        initialize();
    }
}
