package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import com.facebook.common.logging.FLog;
import com.facebook.imageutils.BitmapUtil;

/* JADX INFO: loaded from: classes23.dex */
public class BitmapPoolBackend extends LruBucketsPoolBackend<Bitmap> {
    private static final String TAG = "BitmapPoolBackend";

    public BitmapPoolBackend() {
    }

    @Override // com.facebook.imagepipeline.memory.LruBucketsPoolBackend, com.facebook.imagepipeline.memory.PoolBackend
    public Bitmap get(int r100) {
        Bitmap r101 = (Bitmap) super.get(r100);
        if (r101 != null) goto L5;
        return null;
    L5:
        if (isReusable(r101) == false) goto L10;
        r101.eraseColor(0);
        return r101;
    L10:
        return null;
    }

    @Override // com.facebook.imagepipeline.memory.PoolBackend
    public /* bridge */ /* synthetic */ int getSize(Object r100) {
        return getSize((Bitmap) r100);
    }

    public boolean isReusable(Bitmap r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.isRecycled() == false) goto L10;
        FLog.wtf(TAG, "Cannot reuse a recycled bitmap: %s", new Object[]{r100});
        return false;
    L10:
        if (r100.isMutable() == true) goto L13;
        FLog.wtf(TAG, "Cannot reuse an immutable bitmap: %s", new Object[]{r100});
        return false;
    L13:
        return true;
    }

    public void put(Bitmap r100) {
        if (isReusable(r100) == false) goto L6;
        super.put(r100);
        return;
    }

    @Override // com.facebook.imagepipeline.memory.LruBucketsPoolBackend, com.facebook.imagepipeline.memory.PoolBackend
    public /* bridge */ /* synthetic */ Object get(int r100) {
        return get(r100);
    }

    public int getSize(Bitmap r100) {
        return BitmapUtil.getSizeInBytes(r100);
    }

    @Override // com.facebook.imagepipeline.memory.LruBucketsPoolBackend, com.facebook.imagepipeline.memory.PoolBackend
    public /* bridge */ /* synthetic */ void put(Object r100) {
        put((Bitmap) r100);
    }
}
