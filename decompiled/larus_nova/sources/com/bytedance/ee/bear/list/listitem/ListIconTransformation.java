package com.bytedance.ee.bear.list.listitem;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes18.dex */
public class ListIconTransformation extends BitmapTransformation {
    private static final String ID = "com.bytedance.ee.bear.list.listitem.ListIconTransformation.1";
    private static final byte[] ID_BYTES = null;
    private static final String TAG = "ListIconTransformation";
    private static final int VERSION = 1;

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return -1834593300;
    }

    static {
        ID_BYTES = ID.getBytes(Key.CHARSET);
    }

    public ListIconTransformation() {
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        return r100 instanceof ListIconTransformation;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        r100.update(ID_BYTES);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(BitmapPool r100, Bitmap r101, int r102, int r103) {
        if (r101 != null) goto L5;
        return null;
    L5:
        int r104 = r101.getWidth();
        int r105 = r101.getHeight();
        if (r104 <= 0) goto L15;
        if (r105 > 0) goto L10;
        return null;
    L10:
        if (r104 <= r105) goto L12;
        int r106 = (r104 - r105) / 2;
    L14:
        return Bitmap.createBitmap(r101, r106, 0, r105, r105);
    L12:
        r105 = r104;
        r106 = 0;
        goto L14
    L15:
        return null;
    }
}
