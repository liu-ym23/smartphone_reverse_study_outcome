package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imageutils.BitmapUtil;

/* JADX INFO: loaded from: classes23.dex */
public final class ThumbnailSizeChecker {
    public static final float ACCEPTABLE_REQUESTED_TO_ACTUAL_SIZE_RATIO = 1.3333334f;
    private static final int ROTATED_90_DEGREES_CLOCKWISE = 90;
    private static final int ROTATED_90_DEGREES_COUNTER_CLOCKWISE = 270;

    public ThumbnailSizeChecker() {
    }

    public static int getAcceptableSize(int r100) {
        return (int) (r100 * 1.3333334f);
    }

    public static boolean isImageBigEnough(EncodedImage r100, ResizeOptions r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r102 = r100.getRotationAngle();
        if (r102 == 90) goto L12;
        if (r102 == 270) goto L12;
        return isImageBigEnough(r100.getWidth(), r100.getHeight(), r101);
    L12:
        return isImageBigEnough(r100.getHeight(), r100.getWidth(), r101);
    }

    public static boolean isImageBigEnough(int r100, int r101, ResizeOptions r102) {
        if (r102 != null) goto L12;
        if (getAcceptableSize(r100) >= BitmapUtil.MAX_BITMAP_SIZE) goto L7;
    L9:
        return false;
    L7:
        if (getAcceptableSize(r101) < ((int) BitmapUtil.MAX_BITMAP_SIZE)) goto L9;
        return true;
    L12:
        if (getAcceptableSize(r100) >= r102.width) goto L14;
    L16:
        return false;
    L14:
        if (getAcceptableSize(r101) < r102.height) goto L16;
        return true;
    }
}
