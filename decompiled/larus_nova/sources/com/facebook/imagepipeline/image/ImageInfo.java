package com.facebook.imagepipeline.image;

import android.graphics.Rect;
import com.facebook.imageformat.ImageFormat;

/* JADX INFO: loaded from: classes23.dex */
public interface ImageInfo {
    CalculateColorInfo getCalculateColorInfo();

    int getHeight();

    int getImageCount();

    ImageFormat getImageFormat();

    QualityInfo getQualityInfo();

    Rect getRegionToDecode();

    int getSampleSize();

    Rect getSmartCrop();

    int getWidth();

    void setCalculateColorInfo(CalculateColorInfo r100);
}
