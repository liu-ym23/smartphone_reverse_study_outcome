package com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes16.dex */
public interface b {
    Bitmap get(int r100, int r101, Bitmap.Config r102);

    Bitmap getDirty(int r100, int r101, Bitmap.Config r102);

    boolean put(Bitmap r100);
}
