package com.ss.android.lark.image.impl.image_compress;

import android.graphics.Bitmap;
import java.io.File;

/* JADX INFO: loaded from: classes36.dex */
class LubanBuilder {
    File cacheDir;
    Bitmap.CompressFormat compressFormat;
    int gear;
    int maxHeight;
    int maxSize;
    int maxWidth;

    public LubanBuilder(File r100) {
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.gear = 3;
        this.cacheDir = r100;
    }
}
