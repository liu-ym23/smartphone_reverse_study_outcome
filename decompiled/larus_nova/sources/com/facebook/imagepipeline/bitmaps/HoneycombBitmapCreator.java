package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.webp.BitmapCreator;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.FlexByteArrayPool;
import com.facebook.imagepipeline.memory.PoolFactory;

/* JADX INFO: loaded from: classes23.dex */
public class HoneycombBitmapCreator implements BitmapCreator {
    private final FlexByteArrayPool mFlexByteArrayPool;
    private final EmptyJpegGenerator mJpegGenerator;

    public HoneycombBitmapCreator(PoolFactory r100) {
        this.mFlexByteArrayPool = r100.getFlexByteArrayPool();
        this.mJpegGenerator = new EmptyJpegGenerator(r100.getPooledByteBufferFactory());
    }

    private static BitmapFactory.Options getBitmapFactoryOptions(int r100, Bitmap.Config r101) {
        BitmapFactory.Options r102 = new BitmapFactory.Options();
        r102.inDither = true;
        r102.inPreferredConfig = r101;
        r102.inPurgeable = true;
        r102.inInputShareable = true;
        r102.inSampleSize = r100;
        r102.inMutable = true;
        return r102;
    }

    @Override // com.facebook.common.webp.BitmapCreator
    public Bitmap createNakedBitmap(int r100, int r101, Bitmap.Config r102) {
        CloseableReference<PooledByteBuffer> r103 = this.mJpegGenerator.generate((short) r100, (short) r101);
        CloseableReference<byte[]> r104 = null;
        EncodedImage r105 = new EncodedImage(r103);     // Catch: Throwable -> L9
        r105.setImageFormat(DefaultImageFormats.JPEG);     // Catch: Throwable -> L7
        BitmapFactory.Options r106 = getBitmapFactoryOptions(r105.getSampleSize(), r102);     // Catch: Throwable -> L7
        int r107 = r103.get().size();     // Catch: Throwable -> L7
        PooledByteBuffer r108 = r103.get();     // Catch: Throwable -> L7
        r104 = this.mFlexByteArrayPool.get(r107 + 2);     // Catch: Throwable -> L7
        byte[] r109 = r104.get();     // Catch: Throwable -> L7
        r108.read(0, r109, 0, r107);     // Catch: Throwable -> L7
        Bitmap r110 = BitmapFactory.decodeByteArray(r109, 0, r107, r106);     // Catch: Throwable -> L7
        r110.setHasAlpha(true);     // Catch: Throwable -> L7
        r110.eraseColor(0);     // Catch: Throwable -> L7
        CloseableReference.closeSafely(r104);
        EncodedImage.closeSafely(r105);
        CloseableReference.closeSafely(r103);
        return r110;
    L7:
        th = th;
    L11:
        CloseableReference.closeSafely(r104);
        EncodedImage.closeSafely(r105);
        CloseableReference.closeSafely(r103);
        throw th;
    L9:
        th = th;
        r105 = null;
        goto L11
    }
}
