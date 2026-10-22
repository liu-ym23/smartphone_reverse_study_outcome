package com.bytedance.lark.lynxlib.image;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.ss.android.lark.log.Log;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes19.dex */
public class MayDownSampleBitmapTransform extends BitmapTransformation {
    private static final String ID = "com.bytedance.lark.lynxlib.MayDownSampleBitmapTransform";
    private static final byte[] ID_BYTES = null;
    private static final String TAG = "MayDownSampleBitmapTransform";
    private final int mMaxBitmapDimension;

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return 356647580;
    }

    static {
        ID_BYTES = ID.getBytes(Key.CHARSET);
    }

    public MayDownSampleBitmapTransform(int r100) {
        this.mMaxBitmapDimension = r100;
    }

    private Bitmap mayTransform(Bitmap r100) {
        if (r100 == null) goto L17;
        int r101 = r100.getWidth();
        int r102 = r100.getHeight();
        int r103 = 1;
    L5:
        if ((Math.max(r101, r102) / r103) <= this.mMaxBitmapDimension) goto L7;
        r103 = r103 * 2;
        goto L5
    L7:
        if (r103 <= 1) goto L18;
        int r104 = r101 / r103;
        int r105 = r102 / r103;
        Log.i(TAG, "origin w:" + r101 + ", h:" + r102 + ", sample:" + r103 + ", maxDimension:" + this.mMaxBitmapDimension);
        return Bitmap.createScaledBitmap(r100, r104, r105, true);
    L11:
        e = move-exception;
        Log.i(TAG, "error:" + e);
        return r100;
    L18:
        return r100;
    L17:
        return r100;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        return r100 instanceof MayDownSampleBitmapTransform;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        r100.update(ID_BYTES);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(BitmapPool r100, Bitmap r101, int r102, int r103) {
        return mayTransform(r101);
    }
}
