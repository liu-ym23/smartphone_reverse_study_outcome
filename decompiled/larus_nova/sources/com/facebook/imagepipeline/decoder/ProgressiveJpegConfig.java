package com.facebook.imagepipeline.decoder;

import com.facebook.imagepipeline.image.QualityInfo;

/* JADX INFO: loaded from: classes3.dex */
public interface ProgressiveJpegConfig {
    int getNextScanNumberToDecode(int r100);

    QualityInfo getQualityInfo(int r100);
}
