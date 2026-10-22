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

/* JADX INFO: loaded from: classes18.dex */
public class LeftCrop extends BitmapTransformation {
    private static final String ID = "com.bytedance.ee.bear.thumbnail.LeftCrop.1";
    private static final byte[] ID_BYTES = null;
    private static final int VERSION = 1;

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return -543946696;
    }

    static {
        ID_BYTES = ID.getBytes(Key.CHARSET);
    }

    public LeftCrop() {
    }

    private Bitmap.Config getSafeConfig(Bitmap r100) {
        if (r100.getConfig() == null) goto L6;
        return r100.getConfig();
    L6:
        return Bitmap.Config.ARGB_8888;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        return r100 instanceof LeftCrop;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        r100.update(ID_BYTES);
    }

    private Bitmap transform(Bitmap r100, Bitmap r101, int r102, int r103) {
        if (r101 != null) goto L6;
        return null;
    L6:
        if (r101.getWidth() == r102) goto L8;
    L10:
        Matrix r104 = new Matrix();
        if ((r101.getWidth() * r103) <= (r101.getHeight() * r102)) goto L13;
        float r105 = r103;
        int r106 = r101.getHeight();
    L14:
        float r107 = r105 / r106;
        r104.setScale(r107, r107);
        if (r100 != null) goto L18;
        r100 = Bitmap.createBitmap(r102, r103, getSafeConfig(r101));
    L18:
        TransformationUtils.setAlpha(r101, r100);
        new Canvas(r100).drawBitmap(r101, r104, new Paint(6));
        return r100;
    L13:
        r105 = r102;
        r106 = r101.getWidth();
        goto L14
    L8:
        if (r101.getHeight() != r103) goto L10;
        return r101;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(BitmapPool r100, Bitmap r101, int r102, int r103) {
        if (r101.getConfig() == null) goto L5;
        Bitmap.Config r104 = r101.getConfig();
    L6:
        Bitmap r105 = r100.get(r102, r103, r104);
        Bitmap r106 = transform(r105, r101, r102, r103);
        if (r105 == null) goto L10;
        if (r105 == r106) goto L10;
        r100.put(r105);
    L10:
        return r106;
    L5:
        r104 = Bitmap.Config.ARGB_8888;
        goto L6
    }
}
