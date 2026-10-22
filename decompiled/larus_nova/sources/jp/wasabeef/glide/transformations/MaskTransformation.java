package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes41.dex */
public class MaskTransformation extends BitmapTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.MaskTransformation.1";
    private static final byte[] ID_BYTES = null;
    private static final int VERSION = 1;
    private static Paint paint;
    private int maskId;

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public int hashCode() {
        return -1949385457;
    }

    static {
        ID_BYTES = ID.getBytes(Key.CHARSET);
        Paint r100 = new Paint();
        paint = r100;
        r100.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    public String toString() {
        return "MaskTransformation(maskId=" + this.maskId + ")";
    }

    public MaskTransformation(int r100) {
        this.maskId = r100;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        return r100 instanceof MaskTransformation;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        r100.update(ID_BYTES);
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    public Bitmap transform(Context r100, BitmapPool r101, Bitmap r102, int r103, int r104) {
        int r105 = r102.getWidth();
        int r106 = r102.getHeight();
        Bitmap r107 = r101.get(r105, r106, Bitmap.Config.ARGB_8888);
        r107.setHasAlpha(true);
        Drawable r108 = AppCompatResources.getDrawable(r100.getApplicationContext(), this.maskId);
        if (r108 == null) goto L7;
        Canvas r109 = new Canvas(r107);
        r108.setBounds(0, 0, r105, r106);
        r108.draw(r109);
        r109.drawBitmap(r102, 0.0f, 0.0f, paint);
        return r107;
    L7:
        throw new IllegalArgumentException("maskId is invalid");
    }
}
