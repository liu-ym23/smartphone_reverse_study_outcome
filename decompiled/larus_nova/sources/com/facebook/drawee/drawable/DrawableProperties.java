package com.facebook.drawee.drawable;

import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes3.dex */
public class DrawableProperties {
    private static final int UNSET = -1;
    private int mAlpha;
    private ColorFilter mColorFilter;
    private int mDither;
    private int mFilterBitmap;
    private boolean mIsSetColorFilter;

    public DrawableProperties() {
        this.mAlpha = -1;
        this.mIsSetColorFilter = false;
        this.mColorFilter = null;
        this.mDither = -1;
        this.mFilterBitmap = -1;
    }

    public void applyTo(Drawable r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = this.mAlpha;
        if (r101 == (-1)) goto L8;
        r100.setAlpha(r101);
    L8:
        if (this.mIsSetColorFilter == false) goto L10;
        r100.setColorFilter(this.mColorFilter);
    L10:
        int r102 = this.mDither;
        boolean r103 = true;
        if (r102 == (-1)) goto L16;
        if (r102 == 0) goto L14;
        boolean r104 = true;
    L15:
        r100.setDither(r104);
        goto L16
    L14:
        r104 = false;
    L16:
        int r105 = this.mFilterBitmap;
        if (r105 == (-1)) goto L23;
        if (r105 != 0) goto L21;
        r103 = false;
    L21:
        r100.setFilterBitmap(r103);
        return;
    }

    public void setAlpha(int r100) {
        this.mAlpha = r100;
    }

    public void setColorFilter(ColorFilter r100) {
        this.mColorFilter = r100;
        this.mIsSetColorFilter = true;
    }

    public void setDither(boolean r100) {
        this.mDither = r100 ? 1 : 0;
    }

    public void setFilterBitmap(boolean r100) {
        this.mFilterBitmap = r100 ? 1 : 0;
    }
}
