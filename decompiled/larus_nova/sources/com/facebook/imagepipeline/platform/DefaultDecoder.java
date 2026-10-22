package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import android.os.Build;
import androidx.core.util.Pools;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.streams.LimitedInputStream;
import com.facebook.common.streams.TailAppendingInputStream;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imagepipeline.decoder.DefaultImageDecoder;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapPool;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DefaultDecoder implements PlatformDecoder {
    private static final int DECODE_BUFFER_SIZE = 16384;
    private static final byte[] EOI_TAIL = null;
    private static final Class<?> TAG = null;
    private static boolean optPngDecode;
    private final BitmapPool mBitmapPool;
    final Pools.SynchronizedPool<ByteBuffer> mDecodeBuffers;

    @Nullable
    private final PreverificationHelper mPreverificationHelper;

    public abstract int getBitmapSize(int r100, int r101, BitmapFactory.Options r102);

    static {
        TAG = DefaultDecoder.class;
        EOI_TAIL = new byte[]{-1, -39};
    }

    public static void setOptPngDecode(boolean r100) {
        optPngDecode = r100;
    }

    private static BitmapFactory.Options getDecodeOptionsForStream(EncodedImage r100, Bitmap.Config r101) {
        BitmapFactory.Options r102 = new BitmapFactory.Options();
        r102.inSampleSize = r100.getSampleSize();
        r102.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(r100.getInputStream(), null, r102);
        if (r102.outWidth == (-1)) goto L9;
        if (r102.outHeight == (-1)) goto L9;
        r102.inJustDecodeBounds = false;
        r102.inDither = true;
        r102.inPreferredConfig = r101;
        r102.inMutable = true;
        return r102;
    L9:
        throw new IllegalArgumentException(DefaultImageDecoder.parseEncodedImageInfo(r100));
    }

    public DefaultDecoder(BitmapPool r100, int r101, Pools.SynchronizedPool r102) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        PreverificationHelper r103 = new PreverificationHelper();
    L6:
        this.mPreverificationHelper = r103;
        this.mBitmapPool = r100;
        this.mDecodeBuffers = r102;
        int r104 = 0;
    L7:
        if (r104 >= r101) goto L9;
        this.mDecodeBuffers.release(ByteBuffer.allocate(16384));
        r104 = r104 + 1;
        goto L7
    L9:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference<Bitmap> decodeFromEncodedImage(EncodedImage r100, Bitmap.Config r101, @Nullable Rect r102) {
        return decodeFromEncodedImageWithColorSpace(r100, r101, r102, false);
    }

    public CloseableReference<Bitmap> decodeStaticImageFromStream(InputStream r100, BitmapFactory.Options r101, @Nullable Rect r102) {
        return decodeFromStream(r100, r101, r102, false);
    }

    private CloseableReference<Bitmap> decodeFromStream(InputStream r110, BitmapFactory.Options r111, @Nullable Rect r112, boolean r113) {
        Preconditions.checkNotNull(r110);
        int r100 = r111.outWidth;
        int r101 = r111.outHeight;
        if (r112 == null) goto L5;
        r100 = r112.width() / r111.inSampleSize;
        r101 = r112.height() / r111.inSampleSize;
    L5:
        int r102 = r100;
        int r103 = r101;
        int r104 = Build.VERSION.SDK_INT;
        if (r104 < 26) goto L12;
        PreverificationHelper r105 = this.mPreverificationHelper;
        if (r105 == null) goto L12;
        if (r105.shouldUseHardwareBitmapConfig(r111.inPreferredConfig) == false) goto L12;
        boolean r106 = true;
    L14:
        if (r112 != null) goto L17;
        if (r106 == false) goto L17;
        r111.inMutable = false;
        Bitmap r114 = null;
    L23:
        r111.inBitmap = r114;
        if (r104 < 26) goto L27;
        if (r113 == false) goto L27;
        r111.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
    L27:
        ByteBuffer r115 = this.mDecodeBuffers.acquire();
        if (r115 != null) goto L87;
        r115 = ByteBuffer.allocate(16384);
    L87:
        r111.inTempStorage = r115.array();     // Catch: Throwable -> L62 OutOfMemoryError -> L64 RuntimeException -> L67 IllegalArgumentException -> L71
        if (r112 == null) goto L47;
        if (r114 == null) goto L47;
        r114.reconfigure(r102, r103, r111.inPreferredConfig);     // Catch: Throwable -> L37 IOException -> L39
        BitmapRegionDecoder r107 = BitmapRegionDecoder.newInstance(r110, true);     // Catch: Throwable -> L37 IOException -> L39
        Bitmap r116 = r107.decodeRegion(r112, r111);     // Catch: IOException -> L85 Throwable -> L43
        r107.recycle();     // Catch: Throwable -> L62 OutOfMemoryError -> L64 RuntimeException -> L67 IllegalArgumentException -> L71
    L48:
        if (r116 == null) goto L91;
    L54:
        this.mDecodeBuffers.release(r115);
        if (r114 == null) goto L61;
        if (r114 == r116) goto L61;
        this.mBitmapPool.release(r114);
        r116.recycle();
        throw new IllegalStateException();
    L61:
        return CloseableReference.of(r116, this.mBitmapPool);
    L91:
        r110.reset();     // Catch: IOException -> L51 Throwable -> L62 OutOfMemoryError -> L64 RuntimeException -> L67 IllegalArgumentException -> L71
    L53:
        r116 = decodeBitmap(r110, r111, r102, r103, r114);     // Catch: Throwable -> L62 OutOfMemoryError -> L64 RuntimeException -> L67 IllegalArgumentException -> L71
    L51:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L62 OutOfMemoryError -> L64 RuntimeException -> L67 IllegalArgumentException -> L71
    L43:
        th = th;
    L44:
        if (r107 == null) goto L46;
        r107.recycle();     // Catch: Throwable -> L62 OutOfMemoryError -> L64 RuntimeException -> L67 IllegalArgumentException -> L71
    L46:
        throw th;     // Catch: Throwable -> L62 OutOfMemoryError -> L64 RuntimeException -> L67 IllegalArgumentException -> L71
    L40:
        FLog.e(TAG, "Could not decode region %s, decoding full bitmap instead.", new Object[]{r112});     // Catch: Throwable -> L43
        if (r107 == null) goto L47;
        r107.recycle();     // Catch: Throwable -> L62 OutOfMemoryError -> L64 RuntimeException -> L67 IllegalArgumentException -> L71
        goto L47
    L39:
        r107 = null;
    L37:
        th = th;
        r107 = null;
    L47:
        r116 = null;
    L62:
        th = move-exception;
        this.mDecodeBuffers.release(r115);
        throw th;
    L71:
        e = move-exception;
        if (r114 == null) goto L86;
        this.mBitmapPool.release(r114);     // Catch: Throwable -> L62
    L86:
        r110.reset();     // Catch: Throwable -> L62 IOException -> L80
        BitmapFactory.Options r108 = new BitmapFactory.Options();     // Catch: Throwable -> L62 IOException -> L80
        r108.inMutable = true;     // Catch: Throwable -> L62 IOException -> L80
        r108.inSampleSize = r111.inSampleSize;     // Catch: Throwable -> L62 IOException -> L80
        Bitmap r117 = BitmapFactory.decodeStream(r110, null, r108);     // Catch: Throwable -> L62 IOException -> L80
        if (r117 == null) goto L79;
        CloseableReference<Bitmap> r118 = CloseableReference.of(r117, SimpleBitmapReleaser.getInstance());     // Catch: Throwable -> L62 IOException -> L80
        this.mDecodeBuffers.release(r115);
        return r118;
    L79:
        throw e;     // Catch: Throwable -> L62 IOException -> L80
    L80:
        throw e;     // Catch: Throwable -> L62
    L64:
        e = move-exception;
        this.mBitmapPool.release(r114);     // Catch: Throwable -> L62
        throw e;     // Catch: Throwable -> L62
    L67:
        e = move-exception;
        if (r114 == null) goto L70;
        this.mBitmapPool.release(r114);     // Catch: Throwable -> L62
    L70:
        throw e;     // Catch: Throwable -> L62
    L17:
        if (r112 == null) goto L20;
        if (r106 == false) goto L20;
        r111.inPreferredConfig = Bitmap.Config.ARGB_8888;
    L20:
        Bitmap r109 = this.mBitmapPool.get(getBitmapSize(r102, r103, r111));
        if (r109 == null) goto L84;
        r114 = r109;
        goto L23
    L84:
        throw new NullPointerException("BitmapPool.get returned null");
    L12:
        r106 = false;
        goto L14
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference<Bitmap> decodeFromEncodedImageWithColorSpace(EncodedImage r100, Bitmap.Config r101, @Nullable Rect r102, boolean r103) {
        BitmapFactory.Options r104 = getDecodeOptionsForStream(r100, r101);
        if (r104.inPreferredConfig == Bitmap.Config.ARGB_8888) goto L5;
        boolean r105 = true;
    L22:
    L17:
        e = move-exception;
        if (r105 == true) goto L20;
        throw e;
    L20:
        return decodeFromEncodedImageWithColorSpace(r100, Bitmap.Config.ARGB_8888, r102, r103);
    L7:
        if (optPngDecode == true) goto L9;
    L15:
        return decodeFromStream(r100.getInputStream(), r104, r102, r103);
    L9:
        if ("PNG".equalsIgnoreCase(r100.getImageFormat().toString()) == false) goto L15;
        if (r100.hasAlpha() == false) goto L13;
    L14:
        r104.inPreferredConfig = Bitmap.Config.ARGB_8888;     // Catch: RuntimeException -> L17
        goto L15
    L13:
        if (r100.is10Bit() == false) goto L15;
    L5:
        r105 = false;
        goto L22
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference<Bitmap> decodeJPEGFromEncodedImage(EncodedImage r100, Bitmap.Config r101, @Nullable Rect r102, int r110) {
        return decodeJPEGFromEncodedImageWithColorSpace(r100, r101, r102, r110, false);
    }

    public Bitmap decodeBitmap(InputStream r100, BitmapFactory.Options r101, int r102, int r103, Bitmap r104) {
        return BitmapFactory.decodeStream(r100, null, r101);
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference<Bitmap> decodeJPEGFromEncodedImageWithColorSpace(EncodedImage r100, Bitmap.Config r101, @Nullable Rect r110, int r111, boolean r112) {
        boolean r102 = r100.isCompleteAt(r111);
        BitmapFactory.Options r103 = getDecodeOptionsForStream(r100, r101);
        InputStream r104 = r100.getInputStream();
        Preconditions.checkNotNull(r104);
        if (r100.getSize() <= r111) goto L5;
        r104 = new LimitedInputStream(r104, r111);
    L5:
        if (r102 == true) goto L8;
        r104 = new TailAppendingInputStream(r104, EOI_TAIL);
    L8:
        if (r103.inPreferredConfig == Bitmap.Config.ARGB_8888) goto L10;
        boolean r105 = true;
    L18:
        return decodeFromStream(r104, r103, r110, r112);
    L13:
        e = move-exception;
        if (r105 == true) goto L16;
        throw e;
    L16:
        return decodeJPEGFromEncodedImageWithColorSpace(r100, Bitmap.Config.ARGB_8888, r110, r111, r112);
    L10:
        r105 = false;
        goto L18
    }
}
