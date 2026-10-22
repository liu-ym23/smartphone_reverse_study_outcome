package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes41.dex */
public class GrayscaleTransformation extends BitmapTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.GrayscaleTransformation.1";
    private static final byte[] ID_BYTES = null;
    private static final int VERSION = 1;

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public int hashCode() {
        return -1580689316;
    }

    public String toString() {
        return "GrayscaleTransformation()";
    }

    static {
        ID_BYTES = ID.getBytes(Key.CHARSET);
    }

    public GrayscaleTransformation() {
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        return r100 instanceof GrayscaleTransformation;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        r100.update(ID_BYTES);
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    public Bitmap transform(Context r100, BitmapPool r101, Bitmap r102, int r103, int r104) {
        int r105 = r102.getWidth();
        int r106 = r102.getHeight();
        if (r102.getConfig() == null) goto L5;
        Bitmap.Config r107 = r102.getConfig();
    L6:
        Bitmap r108 = r101.get(r105, r106, r107);
        Canvas r109 = new Canvas(r108);
        ColorMatrix r110 = new ColorMatrix();
        r110.setSaturation(0.0f);
        Paint r111 = new Paint();
        r111.setColorFilter(new ColorMatrixColorFilter(r110));
        r109.drawBitmap(r102, 0.0f, 0.0f, r111);
        return r108;
    L5:
        r107 = Bitmap.Config.ARGB_8888;
        goto L6
    }
}
