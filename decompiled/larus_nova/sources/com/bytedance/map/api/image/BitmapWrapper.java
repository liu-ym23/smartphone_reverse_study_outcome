package com.bytedance.map.api.image;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes21.dex */
public class BitmapWrapper implements Comparable<BitmapWrapper> {
    private Bitmap mBitmap;
    private int mIndex;

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public int getIndex() {
        return this.mIndex;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(BitmapWrapper r100) {
        return compareTo2(r100);
    }

    public void setBitmap(Bitmap r100) {
        this.mBitmap = r100;
    }

    public void setIndex(int r100) {
        this.mIndex = r100;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(BitmapWrapper r100) {
        return this.mIndex - r100.mIndex;
    }

    public BitmapWrapper(Bitmap r100, int r101) {
        this.mBitmap = r100;
        this.mIndex = r101;
    }
}
