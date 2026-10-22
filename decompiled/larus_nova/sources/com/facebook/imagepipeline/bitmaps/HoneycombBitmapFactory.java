package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.platform.PlatformDecoder;

/* JADX INFO: loaded from: classes23.dex */
public class HoneycombBitmapFactory extends PlatformBitmapFactory {
    private static final String TAG = null;
    private boolean mImmutableBitmapFallback;
    private final EmptyJpegGenerator mJpegGenerator;
    private final PlatformDecoder mPurgeableDecoder;

    static {
        TAG = "HoneycombBitmapFactory";
    }

    public HoneycombBitmapFactory(EmptyJpegGenerator r100, PlatformDecoder r101) {
        this.mJpegGenerator = r100;
        this.mPurgeableDecoder = r101;
    }

    private static CloseableReference<Bitmap> createFallbackBitmap(int r100, int r101, Bitmap.Config r102) {
        return CloseableReference.of(Bitmap.createBitmap(r100, r101, r102), SimpleBitmapReleaser.getInstance());
    }

    @Override // com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory
    public CloseableReference<Bitmap> createBitmapInternal(int r100, int r101, Bitmap.Config r102) {
        if (this.mImmutableBitmapFallback == true) goto L5;
        CloseableReference<PooledByteBuffer> r103 = this.mJpegGenerator.generate((short) r100, (short) r101);
        EncodedImage r104 = new EncodedImage(r103);     // Catch: Throwable -> L21
        r104.setImageFormat(DefaultImageFormats.JPEG);     // Catch: Throwable -> L21
        CloseableReference<Bitmap> r105 = this.mPurgeableDecoder.decodeJPEGFromEncodedImage(r104, r102, null, r103.get().size());     // Catch: Throwable -> L18
        if (r105.get().isMutable() == true) goto L14;
        CloseableReference.closeSafely(r105);     // Catch: Throwable -> L18
        this.mImmutableBitmapFallback = true;     // Catch: Throwable -> L18
        FLog.wtf(TAG, "Immutable bitmap returned by decoder");     // Catch: Throwable -> L18
        CloseableReference<Bitmap> r106 = createFallbackBitmap(r100, r101, r102);     // Catch: Throwable -> L18
        EncodedImage.closeSafely(r104);     // Catch: Throwable -> L21
        r103.close();
        return r106;
    L14:
        r105.get().setHasAlpha(true);     // Catch: Throwable -> L18
        r105.get().eraseColor(0);     // Catch: Throwable -> L18
        EncodedImage.closeSafely(r104);     // Catch: Throwable -> L21
        r103.close();
        return r105;
    L18:
        th = move-exception;
        EncodedImage.closeSafely(r104);     // Catch: Throwable -> L21
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        r103.close();
        throw th;
    L5:
        return createFallbackBitmap(r100, r101, r102);
    }
}
