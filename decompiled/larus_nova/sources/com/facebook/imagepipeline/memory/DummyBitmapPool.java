package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import com.facebook.common.memory.MemoryTrimType;

/* JADX INFO: loaded from: classes23.dex */
public class DummyBitmapPool implements BitmapPool {
    public DummyBitmapPool() {
    }

    @Override // com.facebook.common.memory.MemoryTrimmable
    public void trim(MemoryTrimType r100) {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.common.memory.Pool
    public Bitmap get(int r100) {
        return Bitmap.createBitmap(1, (int) Math.ceil(((double) r100) / 2.0d), Bitmap.Config.RGB_565);
    }

    @Override // com.facebook.common.memory.Pool, com.facebook.common.references.ResourceReleaser
    public /* bridge */ /* synthetic */ void release(Object r100) {
        release((Bitmap) r100);
    }

    @Override // com.facebook.common.memory.Pool
    public /* bridge */ /* synthetic */ Bitmap get(int r100) {
        return get(r100);
    }

    public void release(Bitmap r100) {
        r100.recycle();
    }
}
