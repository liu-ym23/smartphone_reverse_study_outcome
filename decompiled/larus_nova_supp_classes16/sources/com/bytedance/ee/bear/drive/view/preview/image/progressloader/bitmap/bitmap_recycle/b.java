package com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface b {
    Bitmap get(int r1, int r2, Bitmap.Config r3);

    Bitmap getDirty(int r1, int r2, Bitmap.Config r3);

    boolean put(Bitmap r1);
}
