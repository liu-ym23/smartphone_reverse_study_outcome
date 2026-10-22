package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.common.TooManyBitmapsException;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapCounter;
import com.facebook.imagepipeline.memory.BitmapCounterProvider;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.imageutils.BitmapUtil;
import java.util.Locale;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public abstract class DalvikPurgeableDecoder implements PlatformDecoder {
    protected static final byte[] EOI = null;
    private final BitmapCounter mUnpooledBitmapsCounter;

    private static native void nativePinBitmap(Bitmap r100);

    public abstract Bitmap decodeByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> r100, BitmapFactory.Options r101);

    public abstract Bitmap decodeJPEGByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> r100, int r101, BitmapFactory.Options r102);

    static {
        ImagePipelineNativeLoader.load();
        EOI = new byte[]{-1, -39};
    }

    public DalvikPurgeableDecoder() {
        this.mUnpooledBitmapsCounter = BitmapCounterProvider.get();
    }

    public CloseableReference<Bitmap> pinBitmap(Bitmap r100) {
        Preconditions.checkNotNull(r100);
        nativePinBitmap(r100);     // Catch: Exception -> L10
        if (this.mUnpooledBitmapsCounter.increase(r100) == true) goto L7;
        int r101 = BitmapUtil.getSizeInBytes(r100);
        r100.recycle();
        throw new TooManyBitmapsException(String.format(Locale.US, "Attempted to pin a bitmap of size %d bytes. The current pool count is %d, the current pool size is %d bytes. The current pool max count is %d, the current pool max size is %d bytes.", new Object[]{Integer.valueOf(r101), Integer.valueOf(this.mUnpooledBitmapsCounter.getCount()), Long.valueOf(this.mUnpooledBitmapsCounter.getSize()), Integer.valueOf(this.mUnpooledBitmapsCounter.getMaxCount()), Integer.valueOf(this.mUnpooledBitmapsCounter.getMaxSize())}));
    L7:
        return CloseableReference.of(r100, this.mUnpooledBitmapsCounter.getReleaser());
    L10:
        e = move-exception;
        r100.recycle();
        throw Throwables.propagate(e);
    }

    public static boolean endsWithEOI(CloseableReference<PooledByteBuffer> r100, int r101) {
        PooledByteBuffer r102 = r100.get();
        if (r101 >= 2) goto L5;
    L9:
        return false;
    L5:
        if (r102.read(r101 - 2) != (-1)) goto L9;
        if (r102.read(r101 - 1) != (-39)) goto L9;
        return true;
    }

    public static BitmapFactory.Options getBitmapFactoryOptions(int r100, Bitmap.Config r101) {
        BitmapFactory.Options r102 = new BitmapFactory.Options();
        r102.inDither = true;
        r102.inPreferredConfig = r101;
        r102.inPurgeable = true;
        r102.inInputShareable = true;
        r102.inSampleSize = r100;
        r102.inMutable = true;
        return r102;
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference<Bitmap> decodeFromEncodedImage(EncodedImage r100, Bitmap.Config r101, @Nullable Rect r102) {
        return decodeFromEncodedImageWithColorSpace(r100, r101, r102, false);
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference<Bitmap> decodeFromEncodedImageWithColorSpace(EncodedImage r100, Bitmap.Config r101, @Nullable Rect r102, boolean r103) {
        BitmapFactory.Options r104 = getBitmapFactoryOptions(r100.getSampleSize(), r101);
        CloseableReference<PooledByteBuffer> r105 = r100.getByteBufferRef();
        Preconditions.checkNotNull(r105);
        CloseableReference<Bitmap> r106 = pinBitmap(decodeByteArrayAsPurgeable(r105, r104));     // Catch: Throwable -> L6
        CloseableReference.closeSafely(r105);
        return r106;
    L6:
        th = move-exception;
        CloseableReference.closeSafely(r105);
        throw th;
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference<Bitmap> decodeJPEGFromEncodedImage(EncodedImage r100, Bitmap.Config r101, @Nullable Rect r102, int r110) {
        return decodeJPEGFromEncodedImageWithColorSpace(r100, r101, r102, r110, false);
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference<Bitmap> decodeJPEGFromEncodedImageWithColorSpace(EncodedImage r100, Bitmap.Config r101, @Nullable Rect r102, int r103, boolean r104) {
        BitmapFactory.Options r105 = getBitmapFactoryOptions(r100.getSampleSize(), r101);
        CloseableReference<PooledByteBuffer> r106 = r100.getByteBufferRef();
        Preconditions.checkNotNull(r106);
        CloseableReference<Bitmap> r107 = pinBitmap(decodeJPEGByteArrayAsPurgeable(r106, r103, r105));     // Catch: Throwable -> L6
        CloseableReference.closeSafely(r106);
        return r107;
    L6:
        th = move-exception;
        CloseableReference.closeSafely(r106);
        throw th;
    }
}
