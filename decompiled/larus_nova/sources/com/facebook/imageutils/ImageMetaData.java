package com.facebook.imageutils;

import android.graphics.ColorSpace;
import android.util.Pair;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class ImageMetaData {

    @Nullable
    private final ColorSpace mColorSpace;

    @Nullable
    private final Pair<Integer, Integer> mDimensions;

    @Nullable
    public ColorSpace getColorSpace() {
        return this.mColorSpace;
    }

    @Nullable
    public Pair<Integer, Integer> getDimensions() {
        return this.mDimensions;
    }

    public ImageMetaData(int r100, int r101, @Nullable ColorSpace r102) {
        if (r100 == (-1)) goto L7;
        if (r101 == (-1)) goto L7;
        Pair<Integer, Integer> r103 = new Pair(Integer.valueOf(r100), Integer.valueOf(r101));
    L8:
        this.mDimensions = r103;
        this.mColorSpace = r102;
        return;
    L7:
        r103 = null;
        goto L8
    }
}
