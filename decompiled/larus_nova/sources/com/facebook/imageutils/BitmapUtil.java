package com.facebook.imageutils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.util.Pair;
import androidx.core.util.Pools;
import com.facebook.common.internal.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class BitmapUtil {
    public static final int ALPHA_8_BYTES_PER_PIXEL = 1;
    public static final int ARGB_4444_BYTES_PER_PIXEL = 2;
    public static final int ARGB_8888_BYTES_PER_PIXEL = 4;
    private static final Pools.SynchronizedPool<ByteBuffer> DECODE_BUFFERS = null;
    private static final int DECODE_BUFFER_SIZE = 16384;
    public static float MAX_BITMAP_SIZE = 0.0f;
    private static final int POOL_SIZE = 12;
    public static final int RGBA_F16_BYTES_PER_PIXEL = 8;
    public static final int RGB_565_BYTES_PER_PIXEL = 2;

    /* JADX INFO: renamed from: com.facebook.imageutils.BitmapUtil$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes23.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config = null;

        static {
            int[] r100 = new int[Bitmap.Config.values().length];
            $SwitchMap$android$graphics$Bitmap$Config = r100;
            r100[Bitmap.Config.ARGB_8888.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ALPHA_8.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_4444.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGB_565.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGBA_F16.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.HARDWARE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public BitmapUtil() {
    }

    static {
        DECODE_BUFFERS = new Pools.SynchronizedPool(12);
        MAX_BITMAP_SIZE = 2048.0f;
    }

    @Nullable
    public static Pair<Integer, Integer> decodeDimensions(InputStream r100) {
        Preconditions.checkNotNull(r100);
        Pools.SynchronizedPool<ByteBuffer> r101 = DECODE_BUFFERS;
        ByteBuffer r102 = r101.acquire();
        if (r102 != null) goto L5;
        r102 = ByteBuffer.allocate(16384);
    L5:
        BitmapFactory.Options r103 = new BitmapFactory.Options();
        r103.inJustDecodeBounds = true;
        r103.inTempStorage = r102.array();     // Catch: Throwable -> L14
        Pair<Integer, Integer> r104 = null;
        BitmapFactory.decodeStream(r100, null, r103);     // Catch: Throwable -> L14
        if (r103.outWidth != (-1)) goto L9;
    L12:
        r101.release(r102);
        return r104;
    L9:
        if (r103.outHeight == (-1)) goto L12;
        r104 = new Pair(Integer.valueOf(r103.outWidth), Integer.valueOf(r103.outHeight));     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        DECODE_BUFFERS.release(r102);
        throw th;
    }

    public static ImageMetaData decodeDimensionsAndColorSpace(InputStream r100) {
        Preconditions.checkNotNull(r100);
        Pools.SynchronizedPool<ByteBuffer> r101 = DECODE_BUFFERS;
        ByteBuffer r102 = r101.acquire();
        if (r102 != null) goto L5;
        r102 = ByteBuffer.allocate(16384);
    L5:
        BitmapFactory.Options r103 = new BitmapFactory.Options();
        r103.inJustDecodeBounds = true;
        r103.inTempStorage = r102.array();     // Catch: Throwable -> L12
        ColorSpace r104 = null;
        BitmapFactory.decodeStream(r100, null, r103);     // Catch: Throwable -> L12
        if (Build.VERSION.SDK_INT < 26) goto L9;
        r104 = r103.outColorSpace;     // Catch: Throwable -> L12
    L9:
        ImageMetaData r105 = new ImageMetaData(r103.outWidth, r103.outHeight, r104);     // Catch: Throwable -> L12
        r101.release(r102);
        return r105;
    L12:
        th = move-exception;
        DECODE_BUFFERS.release(r102);
        throw th;
    }

    public static String getBitmapConfigName(Bitmap r100) {
        if (r100 != null) goto L5;
        return "unknown";
    L5:
        Bitmap.Config r101 = r100.getConfig();
        if (r101 != null) goto L9;
        return "unknown";
    L9:
        return r101.name();
    }

    public static int getPixelSizeForBitmapConfig(Bitmap.Config r100) {
        switch(AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[r100.ordinal()]) {
            case 1: goto L12;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        return 4;
    L7:
        return 8;
    L9:
        return 2;
    L10:
        return 1;
    L12:
        return 4;
    L5:
        throw new UnsupportedOperationException("The provided Bitmap.Config is not supported");
    }

    public static int getSizeInBytes(@Nullable Bitmap r100) {
        if (r100 != null) goto L9;
        return 0;
    L9:
        return r100.getAllocationByteCount();
    L8:
        return r100.getByteCount();
    }

    @Nullable
    public static Pair<Integer, Integer> decodeDimensions(byte[] r100) {
        return decodeDimensions(new ByteArrayInputStream(r100));
    }

    public static int getPixel(Bitmap r100, int r101, int r102) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L12;
        if (r100.getConfig() != Bitmap.Config.HARDWARE) goto L12;
        return r100.copy(Bitmap.Config.ARGB_8888, false).getPixel(r101, r102);
    L12:
        return r100.getPixel(r101, r102);
    }

    public static int getSizeInByteForBitmap(int r100, int r101, Bitmap.Config r102) {
        return (r100 * r101) * getPixelSizeForBitmapConfig(r102);
    }
}
