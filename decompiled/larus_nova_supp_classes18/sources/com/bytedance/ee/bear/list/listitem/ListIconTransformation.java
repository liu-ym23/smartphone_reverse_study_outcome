package com.bytedance.ee.bear.list.listitem;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ListIconTransformation extends BitmapTransformation {
    private static final String ID = "com.bytedance.ee.bear.list.listitem.ListIconTransformation.1";
    private static final byte[] ID_BYTES = null;
    private static final String TAG = "ListIconTransformation";
    private static final int VERSION = 1;

    public int hashCode() {
        return -1834593300;
    }

    static {
        ID_BYTES = ID.getBytes(Key.CHARSET);
    }

    public ListIconTransformation() {
    }

    public boolean equals(Object r1) {
        return r1 instanceof ListIconTransformation;
    }

    public void updateDiskCacheKey(MessageDigest r2) {
        r2.update(ID_BYTES);
    }

    public Bitmap transform(BitmapPool r1, Bitmap r2, int r3, int r4) {
        if (r2 != null) goto L5;
        return null;
    L5:
        int r5 = r2.getWidth();
        int r6 = r2.getHeight();
        if (r5 <= 0) goto L15;
        if (r6 > 0) goto L10;
        return null;
    L10:
        if (r5 <= r6) goto L12;
        int r7 = (r5 - r6) / 2;
    L14:
        return Bitmap.createBitmap(r2, r7, 0, r6, r6);
    L12:
        r6 = r5;
        r7 = 0;
        goto L14
    L15:
        return null;
    }
}
