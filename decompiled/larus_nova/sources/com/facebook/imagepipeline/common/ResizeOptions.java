package com.facebook.imagepipeline.common;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.util.HashCodeUtil;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class ResizeOptions {
    public static final float DEFAULT_ROUNDUP_FRACTION = 0.6666667f;
    public final int height;
    public final float maxBitmapSize;
    public final float roundUpFraction;
    public final int width;

    public String toString() {
        return String.format(null, "%dx%d", new Object[]{Integer.valueOf(this.width), Integer.valueOf(this.height)});
    }

    public int hashCode() {
        return HashCodeUtil.hashCode(this.width, this.height);
    }

    @Nullable
    public static ResizeOptions forSquareSize(int r100) {
        if (r100 > 0) goto L6;
        return null;
    L6:
        return new ResizeOptions(r100, r100);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof ResizeOptions) == true) goto L8;
        return false;
    L8:
        ResizeOptions r101 = (ResizeOptions) r100;
        if (this.width == r101.width) goto L11;
    L13:
        return false;
    L11:
        if (this.height != r101.height) goto L13;
        return true;
    }

    public ResizeOptions(int r100, int r101) {
        this(r100, r101, BitmapUtil.MAX_BITMAP_SIZE);
    }

    @Nullable
    public static ResizeOptions forDimensions(int r100, int r101) {
        if (r100 <= 0) goto L7;
        if (r101 > 0) goto L6;
        return null;
    L6:
        return new ResizeOptions(r100, r101);
    L7:
        return null;
    }

    public ResizeOptions(int r100, int r101, float r102) {
        this(r100, r101, r102, 0.6666667f);
    }

    public ResizeOptions(int r100, int r101, float r102, float r103) {
        boolean r104 = true;
        if (r100 <= 0) goto L5;
        boolean r105 = true;
    L6:
        Preconditions.checkArgument(r105);
        if (r101 > 0) goto L10;
        r104 = false;
    L10:
        Preconditions.checkArgument(r104);
        this.width = r100;
        this.height = r101;
        this.maxBitmapSize = r102;
        this.roundUpFraction = r103;
        return;
    L5:
        r105 = false;
        goto L6
    }
}
