package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Util;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes41.dex */
public abstract class BitmapTransformation implements Transformation<Bitmap> {
    public BitmapTransformation() {
    }

    @Override // com.bumptech.glide.load.Key
    public abstract boolean equals(Object r100);

    @Override // com.bumptech.glide.load.Key
    public abstract int hashCode();

    public abstract Bitmap transform(Context r100, BitmapPool r101, Bitmap r102, int r103, int r104);

    @Override // com.bumptech.glide.load.Key
    public abstract void updateDiskCacheKey(MessageDigest r100);

    @Override // com.bumptech.glide.load.Transformation
    public final Resource<Bitmap> transform(Context r100, Resource<Bitmap> r110, int r111, int r112) {
        if (Util.isValidDimensions(r111, r112) == false) goto L16;
        BitmapPool r101 = Glide.get(r100).getBitmapPool();
        Bitmap r102 = r110.get();
        if (r111 != Integer.MIN_VALUE) goto L7;
        r111 = r102.getWidth();
    L7:
        int r103 = r111;
        if (r112 != Integer.MIN_VALUE) goto L10;
        r112 = r102.getHeight();
    L10:
        Bitmap r104 = transform(r100.getApplicationContext(), r101, r102, r103, r112);
        if (r102.equals(r104) == false) goto L14;
        return r110;
    L14:
        return BitmapResource.obtain(r104, r101);
    L16:
        throw new IllegalArgumentException("Cannot apply transformation on width: " + r111 + " or height: " + r112 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }
}
