package com.ss.android.lark.image.impl.compress2;

import android.graphics.Bitmap;
import com.ss.android.lark.image.uploader.utils.ImageInfo;

/* JADX INFO: loaded from: classes36.dex */
public interface ICompressStrategy {
    int calcExpectShortSize(ImageInfo r100);

    int calcSampleSize(ImageInfo r100);

    int calcTargetQuality(ImageInfo r100);

    Bitmap.CompressFormat getCompressFormat(String r100);

    boolean shouldSkipCompress(ImageInfo r100, int r101, int r102);
}
