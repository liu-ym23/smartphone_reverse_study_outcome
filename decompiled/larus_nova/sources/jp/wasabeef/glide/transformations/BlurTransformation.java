package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.renderscript.RSRuntimeException;
import auc.a;
import auc.b;
import auc.c;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes41.dex */
public class BlurTransformation extends BitmapTransformation {
    private static int DEFAULT_DOWN_SAMPLING = 0;
    private static final String ID = "jp.wasabeef.glide.transformations.BlurTransformation.1";
    private static final byte[] ID_BYTES = null;
    private static int MAX_RADIUS = 0;
    private static final int MAX_SIDE_LENGTH = 1024;
    private static final String TAG = "BlurTransformation";
    private static final int VERSION = 1;
    private boolean enableRenderEffectBlur;
    private int radius;
    private int sampling;

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public int hashCode() {
        return 737513610;
    }

    static {
        ID_BYTES = ID.getBytes(Key.CHARSET);
        MAX_RADIUS = 25;
        DEFAULT_DOWN_SAMPLING = 1;
    }

    public BlurTransformation() {
        this(MAX_RADIUS, DEFAULT_DOWN_SAMPLING, false);
    }

    public String toString() {
        return "BlurTransformation(radius=" + this.radius + ", sampling=" + this.sampling + ")";
    }

    public BlurTransformation(int r100) {
        this(r100, DEFAULT_DOWN_SAMPLING, false);
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        return r100 instanceof BlurTransformation;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        r100.update(ID_BYTES);
    }

    public BlurTransformation(int r100, int r101, boolean r102) {
        this.radius = r100;
        this.sampling = r101;
        this.enableRenderEffectBlur = r102;
    }

    private Bitmap getFastBlurIfNeed(Context r100, Bitmap r101, int r102) {
        if (r101.getWidth() > 1024) goto L9;
        if (r101.getHeight() > 1024) goto L9;
        return a.a(r101, r102);
    L9:
        return getRSBlur(r100, r101, r102);
    }

    private Bitmap getRSBlur(Context r100, Bitmap r101, int r102) {
        b.a(r100, r101, r102);     // Catch: RSRuntimeException -> L4
        return r101;
    L5:
        return a.a(r101, r102);
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    public Bitmap transform(Context r100, BitmapPool r101, Bitmap r102, int r103, int r104) {
        int r105 = r102.getWidth();
        int r106 = r102.getHeight();
        int r107 = this.sampling;
        Bitmap r108 = r101.get(r105 / r107, r106 / r107, Bitmap.Config.ARGB_8888);
        Canvas r109 = new Canvas(r108);
        int r110 = this.sampling;
        r109.scale(1.0f / r110, 1.0f / r110);
        Paint r111 = new Paint();
        r111.setFlags(2);
        r109.drawBitmap(r102, 0.0f, 0.0f, r111);
        if (Build.VERSION.SDK_INT < 34) goto L11;
        if (this.enableRenderEffectBlur == false) goto L15;
        return c.a(r108, this.radius);
    L14:
        return getFastBlurIfNeed(r100, r108, this.radius);
    L15:
        return getFastBlurIfNeed(r100, r108, this.radius);
    L11:
        return getRSBlur(r100, r108, this.radius);
    }
}
