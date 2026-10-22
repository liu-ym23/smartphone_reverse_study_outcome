package androidx.camera.core.internal.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.YuvImage;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.ExifData;
import androidx.camera.core.impl.utils.ExifOutputStream;
import androidx.compose.material3.MenuKt;
import androidx.core.util.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class ImageUtil {
    public static final int DEFAULT_RGBA_PIXEL_STRIDE = 4;
    private static final String TAG = "ImageUtil";

    public static final class CodecFailedException extends Exception {
        private final FailureType mFailureType;

        public static final enum FailureType extends Enum<FailureType> {
            private static final /* synthetic */ FailureType[] $VALUES = null;
            public static final FailureType DECODE_FAILED = null;
            public static final FailureType ENCODE_FAILED = null;
            public static final FailureType UNKNOWN = null;

            private static /* synthetic */ FailureType[] $values() {
                return new FailureType[]{ENCODE_FAILED, DECODE_FAILED, UNKNOWN};
            }

            static {
                ENCODE_FAILED = new FailureType("ENCODE_FAILED", 0);
                DECODE_FAILED = new FailureType("DECODE_FAILED", 1);
                UNKNOWN = new FailureType("UNKNOWN", 2);
                $VALUES = $values();
            }

            public static FailureType[] values() {
                return (FailureType[]) $VALUES.clone();
            }

            public static FailureType valueOf(String r1) {
                return (FailureType) a.a(FailureType.class, r1);
            }

            private FailureType(String r1, int r2) {
                super(r1, r2);
            }
        }

        public FailureType getFailureType() {
            return this.mFailureType;
        }

        public CodecFailedException(String r1) {
            super(r1);
            this.mFailureType = FailureType.UNKNOWN;
        }

        public CodecFailedException(String r1, FailureType r2) {
            super(r1);
            this.mFailureType = r2;
        }
    }

    public static boolean isJpegFormats(int r1) {
        if (r1 != 256) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 4101) goto L8;
        return false;
    }

    public static boolean shouldCropImage(int r0, int r1, int r2, int r3) {
        if (r0 != r2) goto L6;
        if (r1 != r3) goto L6;
        return false;
    L6:
        return true;
    }

    private ImageUtil() {
    }

    public static Bitmap createBitmapFromImageProxy(ImageProxy r3) {
        int r0 = r3.getFormat();
        if (r0 == 1) goto L18;
        if (r0 == 35) goto L16;
        if (r0 == 256) goto L14;
        if (r0 == 4101) goto L14;
        throw new IllegalArgumentException("Incorrect image format of the input image proxy: " + r3.getFormat() + ", only ImageFormat.YUV_420_888 and PixelFormat.RGBA_8888 are supported");
    L14:
        return createBitmapFromJpegImage(r3);
    L16:
        return ImageProcessingUtil.convertYUVToBitmap(r3);
    L18:
        return createBitmapFromRgbaImage(r3);
    }

    private static Bitmap createBitmapFromJpegImage(ImageProxy r3) {
        byte[] r4 = jpegImageToJpegByteArray(r3);
        Bitmap r5 = BitmapFactory.decodeByteArray(r4, 0, r4.length, null);
        if (r5 == null) goto L6;
        return r5;
    L6:
        throw new UnsupportedOperationException("Decode jpeg byte array failed");
    }

    private static Bitmap createBitmapFromRgbaImage(ImageProxy r3) {
        Bitmap r0 = Bitmap.createBitmap(r3.getWidth(), r3.getHeight(), Bitmap.Config.ARGB_8888);
        r3.getPlanes()[0].getBuffer().rewind();
        ImageProcessingUtil.copyByteBufferToBitmap(r0, r3.getPlanes()[0].getBuffer(), r3.getPlanes()[0].getRowStride());
        return r0;
    }

    public static ByteBuffer createDirectByteBuffer(Bitmap r2) {
        if (r2.getConfig() != Bitmap.Config.ARGB_8888) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "Only accept Bitmap with ARGB_8888 format for now.");
        ByteBuffer r1 = ByteBuffer.allocateDirect(r2.getAllocationByteCount());
        ImageProcessingUtil.copyBitmapToByteBuffer(r2, r1, r2.getRowBytes());
        r1.rewind();
        return r1;
    L5:
        r0 = false;
        goto L6
    }

    private static Rational inverseRational(Rational r2) {
        if (r2 != null) goto L5;
        return r2;
    L5:
        return new Rational(r2.getDenominator(), r2.getNumerator());
    }

    public static boolean isAspectRatioValid(Rational r2) {
        if (r2 != null) goto L4;
    L8:
        return false;
    L4:
        if (r2.floatValue() <= MenuKt.ClosedAlphaTarget) goto L8;
        if (r2.isNaN() == true) goto L8;
        return true;
    }

    public static byte[] jpegImageToJpegByteArray(ImageProxy r3) {
        if (isJpegFormats(r3.getFormat()) == false) goto L7;
        ByteBuffer r4 = r3.getPlanes()[0].getBuffer();
        byte[] r0 = new byte[r4.capacity()];
        r4.rewind();
        r4.get(r0);
        return r0;
    L7:
        throw new IllegalArgumentException("Incorrect image format of the input image proxy: " + r3.getFormat());
    }

    public static boolean shouldCropImage(ImageProxy r3) {
        return shouldCropImage(r3.getWidth(), r3.getHeight(), r3.getCropRect().width(), r3.getCropRect().height());
    }

    public static float[] sizeToVertexes(Size r4) {
        return new float[]{MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r4.getWidth(), MenuKt.ClosedAlphaTarget, r4.getWidth(), r4.getHeight(), MenuKt.ClosedAlphaTarget, r4.getHeight()};
    }

    public static byte[] yuv_420_888toNv21(ImageProxy r19) {
        ImageProxy.PlaneProxy r0 = r19.getPlanes()[0];
        ImageProxy.PlaneProxy r2 = r19.getPlanes()[1];
        ImageProxy.PlaneProxy r3 = r19.getPlanes()[2];
        ByteBuffer r5 = r0.getBuffer();
        ByteBuffer r6 = r2.getBuffer();
        ByteBuffer r7 = r3.getBuffer();
        r5.rewind();
        r6.rewind();
        r7.rewind();
        int r8 = r5.remaining();
        byte[] r9 = new byte[((r19.getWidth() * r19.getHeight()) / 2) + r8];
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r10 >= r19.getHeight()) goto L6;
        r5.get(r9, r11, r19.getWidth());
        r11 = r11 + r19.getWidth();
        r5.position(Math.min(r8, (r5.position() - r19.getWidth()) + r0.getRowStride()));
        r10 = r10 + 1;
        goto L4
    L6:
        int r1 = r19.getHeight() / 2;
        int r12 = r19.getWidth() / 2;
        int r4 = r3.getRowStride();
        int r13 = r2.getRowStride();
        int r14 = r3.getPixelStride();
        int r15 = r2.getPixelStride();
        byte[] r16 = new byte[r4];
        byte[] r17 = new byte[r13];
        int r18 = 0;
    L7:
        if (r18 >= r1) goto L12;
        r7.get(r16, 0, Math.min(r4, r7.remaining()));
        r6.get(r17, 0, Math.min(r13, r6.remaining()));
        int r110 = 0;
        int r111 = 0;
        int r112 = 0;
    L9:
        if (r110 >= r12) goto L11;
        int r113 = r11 + 1;
        r9[r11] = r16[r111];
        r11 = r113 + 1;
        r9[r113] = r17[r112];
        r111 = r111 + r14;
        r112 = r112 + r15;
        r110 = r110 + 1;
        goto L9
    L11:
        r18 = r18 + 1;
        goto L7
    L12:
        return r9;
    }

    public static Rect computeCropRectFromAspectRatio(Size r8, Rational r9) {
        if (isAspectRatioValid(r9) == true) goto L6;
        Logger.w(TAG, "Invalid view ratio.");
        return null;
    L6:
        int r0 = r8.getWidth();
        int r10 = r8.getHeight();
        float r1 = r0;
        float r2 = r10;
        float r3 = r1 / r2;
        int r4 = r9.getNumerator();
        int r5 = r9.getDenominator();
        int r6 = 0;
        if (r9.floatValue() <= r3) goto L9;
        int r11 = Math.round((r1 / r4) * r5);
        int r12 = (r10 - r11) / 2;
        r10 = r11;
    L11:
        return new Rect(r6, r12, r0 + r6, r10 + r12);
    L9:
        int r13 = Math.round((r2 / r5) * r4);
        r6 = (r0 - r13) / 2;
        r0 = r13;
        r12 = 0;
        goto L11
    }

    public static Rational getRotatedAspectRatio(int r1, Rational r2) {
        if (r1 == 90) goto L10;
        if (r1 == 270) goto L10;
        return new Rational(r2.getNumerator(), r2.getDenominator());
    L10:
        return inverseRational(r2);
    }

    public static boolean isAspectRatioValid(Size r2, Rational r3) {
        if (r3 != null) goto L4;
    L10:
        return false;
    L4:
        if (r3.floatValue() <= MenuKt.ClosedAlphaTarget) goto L10;
        if (isCropAspectRatioHasEffect(r2, r3) == false) goto L10;
        if (r3.isNaN() == true) goto L10;
        return true;
    }

    private static boolean isCropAspectRatioHasEffect(Size r3, Rational r4) {
        int r0 = r3.getWidth();
        int r5 = r3.getHeight();
        float r1 = r4.getNumerator();
        float r6 = r4.getDenominator();
        if (r5 == Math.round((r0 / r1) * r6)) goto L5;
    L8:
        return true;
    L5:
        if (r0 != Math.round((r5 / r6) * r1)) goto L8;
        return false;
    }

    public static Bitmap rotateBitmap(Bitmap r7, int r8) {
        Matrix r5 = new Matrix();
        r5.postRotate(r8);
        return Bitmap.createBitmap(r7, 0, 0, r7.getWidth(), r7.getHeight(), r5, true);
    }

    public static Bitmap createBitmapFromPlane(ImageProxy.PlaneProxy[] r4, int r5, int r6) {
        boolean r2 = true;
        if (r4.length != 1) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "Expect a single plane");
        if (r4[0].getPixelStride() != 4) goto L9;
        boolean r1 = true;
    L10:
        Preconditions.checkArgument(r1, "Expect pixelStride=4");
        if (r4[0].getRowStride() == (r5 * 4)) goto L14;
        r2 = false;
    L14:
        Preconditions.checkArgument(r2, "Expect rowStride=width*4");
        Bitmap r7 = Bitmap.createBitmap(r5, r6, Bitmap.Config.ARGB_8888);
        r4[0].getBuffer().rewind();
        ImageProcessingUtil.copyByteBufferToBitmap(r7, r4[0].getBuffer(), r4[0].getRowStride());
        return r7;
    L9:
        r1 = false;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    private static byte[] cropJpegByteArray(byte[] r3, Rect r4, int r5) throws CodecFailedException {
        BitmapRegionDecoder r6 = BitmapRegionDecoder.newInstance(r3, 0, r3.length, false);     // Catch: IOException -> L13 IllegalArgumentException -> L15
        Bitmap r7 = r6.decodeRegion(r4, new BitmapFactory.Options());     // Catch: IOException -> L13 IllegalArgumentException -> L15
        r6.recycle();     // Catch: IOException -> L13 IllegalArgumentException -> L15
        if (r7 == null) goto L12;
        ByteArrayOutputStream r8 = new ByteArrayOutputStream();
        if (r7.compress(Bitmap.CompressFormat.JPEG, r5, r8) == false) goto L10;
        r7.recycle();
        return r8.toByteArray();
    L10:
        throw new CodecFailedException("Encode bitmap failed.", CodecFailedException.FailureType.ENCODE_FAILED);
    L12:
        throw new CodecFailedException("Decode byte array failed.", CodecFailedException.FailureType.DECODE_FAILED);
    L15:
        e = move-exception;
        throw new CodecFailedException("Decode byte array failed with illegal argument." + e, CodecFailedException.FailureType.DECODE_FAILED);
    L14:
        throw new CodecFailedException("Decode byte array failed.", CodecFailedException.FailureType.DECODE_FAILED);
    }

    public static byte[] jpegImageToJpegByteArray(ImageProxy r1, Rect r2, int r3) throws CodecFailedException {
        if (isJpegFormats(r1.getFormat()) == false) goto L7;
        return cropJpegByteArray(jpegImageToJpegByteArray(r1), r2, r3);
    L7:
        throw new IllegalArgumentException("Incorrect image format of the input image proxy: " + r1.getFormat());
    }

    public static Rect computeCropRectFromDispatchInfo(Rect r4, int r5, Size r6, int r7) {
        Matrix r0 = new Matrix();
        r0.setRotate(r7 - r5);
        float[] r8 = sizeToVertexes(r6);
        r0.mapPoints(r8);
        r0.postTranslate(-min(r8[0], r8[2], r8[4], r8[6]), -min(r8[1], r8[3], r8[5], r8[7]));
        r0.invert(r0);
        RectF r9 = new RectF();
        r0.mapRect(r9, new RectF(r4));
        r9.sort();
        Rect r10 = new Rect();
        r9.round(r10);
        return r10;
    }

    public static float min(float r0, float r1, float r2, float r3) {
        return Math.min(Math.min(r0, r1), Math.min(r2, r3));
    }

    public static byte[] yuvImageToJpegByteArray(ImageProxy r8, Rect r9, int r10, int r11) throws CodecFailedException {
        if (r8.getFormat() != 35) goto L14;
        YuvImage r0 = new YuvImage(yuv_420_888toNv21(r8), 17, r8.getWidth(), r8.getHeight(), null);
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();
        ExifOutputStream r2 = new ExifOutputStream(r1, ExifData.create(r8, r11));
        if (r9 != null) goto L8;
        r9 = new Rect(0, 0, r8.getWidth(), r8.getHeight());
    L8:
        if (r0.compressToJpeg(r9, r10, r2) == false) goto L12;
        return r1.toByteArray();
    L12:
        throw new CodecFailedException("YuvImage failed to encode jpeg.", CodecFailedException.FailureType.ENCODE_FAILED);
    L14:
        throw new IllegalArgumentException("Incorrect image format of the input image proxy: " + r8.getFormat());
    }
}
