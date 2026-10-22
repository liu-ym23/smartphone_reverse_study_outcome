package com.bytedance.ee.bear.thumbnail;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class LeftCrop extends BitmapTransformation {
    private static final String ID = "com.bytedance.ee.bear.thumbnail.LeftCrop.1";
    private static final byte[] ID_BYTES = null;
    private static final int VERSION = 1;

    public int hashCode() {
        return -543946696;
    }

    static {
        ID_BYTES = ID.getBytes(Key.CHARSET);
    }

    public LeftCrop() {
    }

    private Bitmap.Config getSafeConfig(Bitmap r2) {
        if (r2.getConfig() == null) goto L6;
        return r2.getConfig();
    L6:
        return Bitmap.Config.ARGB_8888;
    }

    public boolean equals(Object r1) {
        return r1 instanceof LeftCrop;
    }

    public void updateDiskCacheKey(MessageDigest r2) {
        r2.update(ID_BYTES);
    }

    private Bitmap transform(Bitmap r4, Bitmap r5, int r6, int r7) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (r5.getWidth() == r6) goto L8;
    L10:
        Matrix r0 = new Matrix();
        if ((r5.getWidth() * r7) <= (r5.getHeight() * r6)) goto L13;
        float r1 = r7;
        int r2 = r5.getHeight();
    L14:
        float r3 = r1 / r2;
        r0.setScale(r3, r3);
        if (r4 != null) goto L18;
        r4 = Bitmap.createBitmap(r6, r7, getSafeConfig(r5));
    L18:
        TransformationUtils.setAlpha(r5, r4);
        new Canvas(r4).drawBitmap(r5, r0, new Paint(6));
        return r4;
    L13:
        r1 = r6;
        r2 = r5.getWidth();
        goto L14
    L8:
        if (r5.getHeight() != r7) goto L10;
        return r5;
    }

    public Bitmap transform(BitmapPool r2, Bitmap r3, int r4, int r5) {
        if (r3.getConfig() == null) goto L5;
        Bitmap.Config r0 = r3.getConfig();
    L6:
        Bitmap r1 = r2.get(r4, r5, r0);
        Bitmap r6 = transform(r1, r3, r4, r5);
        if (r1 == null) goto L10;
        if (r1 == r6) goto L10;
        r2.put(r1);
    L10:
        return r6;
    L5:
        r0 = Bitmap.Config.ARGB_8888;
        goto L6
    }
}
