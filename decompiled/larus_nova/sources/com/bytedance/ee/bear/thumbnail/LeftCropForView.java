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
public class LeftCropForView extends BitmapTransformation {
    private static final String ID = "com.bytedance.ee.bear.thumbnail.LeftCropForView.1";
    private static final byte[] ID_BYTES = null;
    private static final int VERSION = 1;
    private int defaultHeight;
    private int defaultWidth;

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return 717654300;
    }

    static {
        ID_BYTES = ID.getBytes(Key.CHARSET);
    }

    private Bitmap.Config getSafeConfig(Bitmap r100) {
        if (r100.getConfig() == null) goto L6;
        return r100.getConfig();
    L6:
        return Bitmap.Config.ARGB_8888;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        return r100 instanceof LeftCropForView;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        r100.update(ID_BYTES);
    }

    public LeftCropForView(int r100, int r101) {
        this.defaultHeight = r100;
        this.defaultWidth = r101;
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
        int r104 = this.defaultHeight;
        int r105 = this.defaultWidth;
        if (r101.getConfig() == null) goto L5;
        Bitmap.Config r106 = r101.getConfig();
    L6:
        Bitmap r107 = r100.get(r105, r104, r106);
        Bitmap r108 = transform(r107, r101, r105, r104);
        if (r107 == null) goto L10;
        if (r107 == r108) goto L10;
        r100.put(r107);
    L10:
        return r108;
    L5:
        r106 = Bitmap.Config.ARGB_8888;
        goto L6
    }
}
