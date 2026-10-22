package androidx.camera.core;

import android.graphics.Bitmap;
import android.media.Image;
import android.media.ImageWriter;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.internal.compat.ImageWriterCompat;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.core.util.Preconditions;
import com.larus.utils.logger.FLogger;
import java.nio.ByteBuffer;
import java.util.Locale;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class ImageProcessingUtil {
    private static final String TAG = "ImageProcessingUtil";
    private static int sImageCount;

    public static final enum Result extends Enum<Result> {
        private static final /* synthetic */ Result[] $VALUES = null;
        public static final Result ERROR_CONVERSION = null;
        public static final Result SUCCESS = null;
        public static final Result UNKNOWN = null;

        private static /* synthetic */ Result[] $values() {
            return new Result[]{UNKNOWN, SUCCESS, ERROR_CONVERSION};
        }

        static {
            UNKNOWN = new Result("UNKNOWN", 0);
            SUCCESS = new Result("SUCCESS", 1);
            ERROR_CONVERSION = new Result("ERROR_CONVERSION", 2);
            $VALUES = $values();
        }

        public static Result[] values() {
            return (Result[]) $VALUES.clone();
        }

        public static Result valueOf(String r1) {
            return (Result) r27.a.a(Result.class, r1);
        }

        private Result(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static /* synthetic */ void a(ImageProxy r0, ImageProxy r1, ImageProxy r2) {
        lambda$rotateYUV$1(r0, r1, r2);
    }

    public static /* synthetic */ void access$000(String r0) {
        System.loadLibrary(r0);
    }

    public static /* synthetic */ void b(ImageProxy r0, ImageProxy r1, ImageProxy r2) {
        lambda$convertYUVToRGB$0(r0, r1, r2);
    }

    private static boolean isSupportedRotationDegrees(int r1) {
        if (r1 != 0) goto L4;
    L11:
        return true;
    L4:
        if (r1 == 90) goto L11;
        if (r1 == 180) goto L11;
        if (r1 == 270) goto L11;
        return false;
    }

    private static native int nativeConvertAndroid420ToABGR(ByteBuffer r0, int r1, ByteBuffer r2, int r3, ByteBuffer r4, int r5, int r6, int r7, Surface r8, ByteBuffer r9, int r10, int r11, int r12, int r13, int r14, int r15);

    private static native int nativeConvertAndroid420ToBitmap(ByteBuffer r0, int r1, ByteBuffer r2, int r3, ByteBuffer r4, int r5, int r6, int r7, Bitmap r8, int r9, int r10, int r11);

    private static native int nativeCopyBetweenByteBufferAndBitmap(Bitmap r0, ByteBuffer r1, int r2, int r3, int r4, int r5, boolean r6);

    private static native int nativeRotateYUV(ByteBuffer r0, int r1, ByteBuffer r2, int r3, ByteBuffer r4, int r5, int r6, ByteBuffer r7, int r8, int r9, ByteBuffer r10, int r11, int r12, ByteBuffer r13, int r14, int r15, ByteBuffer r16, ByteBuffer r17, ByteBuffer r18, int r19, int r20, int r21);

    private static native int nativeShiftPixel(ByteBuffer r0, int r1, ByteBuffer r2, int r3, ByteBuffer r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11, int r12);

    private static native int nativeWriteJpegToSurface(byte[] r0, Surface r1);

    static {
        INVOKESTATIC_androidx_camera_core_ImageProcessingUtil_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("image_processing_util_jni");
    }

    private ImageProcessingUtil() {
    }

    @JvmStatic
    public static void INVOKESTATIC_androidx_camera_core_ImageProcessingUtil_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r4) {
        Intrinsics.checkNotNullParameter(r4, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
        com.bytedance.librarian.a.c(r4);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
    }

    public static boolean applyPixelShiftForYUV(ImageProxy r3) {
        if (isSupportedYUVFormat(r3) == true) goto L7;
        Logger.e(TAG, "Unsupported format for YUV to RGB");
        return false;
    L7:
        if (applyPixelShiftInternal(r3) != Result.ERROR_CONVERSION) goto L10;
        Logger.e(TAG, "One pixel shift for YUV failure");
        return false;
    L10:
        return true;
    }

    private static Result applyPixelShiftInternal(ImageProxy r13) {
        int r8 = r13.getWidth();
        int r9 = r13.getHeight();
        int r2 = r13.getPlanes()[0].getRowStride();
        int r4 = r13.getPlanes()[1].getRowStride();
        int r6 = r13.getPlanes()[2].getRowStride();
        int r10 = r13.getPlanes()[0].getPixelStride();
        int r12 = r13.getPlanes()[1].getPixelStride();
        if (nativeShiftPixel(r13.getPlanes()[0].getBuffer(), r2, r13.getPlanes()[1].getBuffer(), r4, r13.getPlanes()[2].getBuffer(), r6, r10, r12, r8, r9, r10, r12, r12) == 0) goto L7;
        return Result.ERROR_CONVERSION;
    L7:
        return Result.SUCCESS;
    }

    public static Bitmap convertYUVToBitmap(ImageProxy r14) {
        if (r14.getFormat() != 35) goto L10;
        int r12 = r14.getWidth();
        int r13 = r14.getHeight();
        int r3 = r14.getPlanes()[0].getRowStride();
        int r5 = r14.getPlanes()[1].getRowStride();
        int r7 = r14.getPlanes()[2].getRowStride();
        int r8 = r14.getPlanes()[0].getPixelStride();
        int r9 = r14.getPlanes()[1].getPixelStride();
        Bitmap r0 = Bitmap.createBitmap(r14.getWidth(), r14.getHeight(), Bitmap.Config.ARGB_8888);
        int r11 = r0.getRowBytes();
        if (nativeConvertAndroid420ToBitmap(r14.getPlanes()[0].getBuffer(), r3, r14.getPlanes()[1].getBuffer(), r5, r14.getPlanes()[2].getBuffer(), r7, r8, r9, r0, r11, r12, r13) != 0) goto L8;
        return r0;
    L8:
        throw new UnsupportedOperationException("YUV to RGB conversion failed");
    L10:
        throw new IllegalArgumentException("Input image format must be YUV_420_888");
    }

    private static boolean isSupportedYUVFormat(ImageProxy r2) {
        if (r2.getFormat() == 35) goto L5;
    L7:
        return false;
    L5:
        if (r2.getPlanes().length != 3) goto L7;
        return true;
    }

    public static ImageProxy convertJpegBytesToImage(ImageReaderProxy r2, byte[] r3) {
        if (r2.getImageFormat() != 256) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        Preconditions.checkNotNull(r3);
        Surface r1 = r2.getSurface();
        Preconditions.checkNotNull(r1);
        if (nativeWriteJpegToSurface(r3, r1) == 0) goto L10;
        Logger.e(TAG, "Failed to enqueue JPEG image.");
        return null;
    L10:
        ImageProxy r4 = r2.acquireLatestImage();
        if (r4 != null) goto L13;
        Logger.e(TAG, "Failed to get acquire JPEG image.");
    L13:
        return r4;
    L5:
        r0 = false;
        goto L6
    }

    public static boolean writeJpegBytesToSurface(Surface r0, byte[] r1) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r0);
        if (nativeWriteJpegToSurface(r1, r0) == 0) goto L6;
        Logger.e(TAG, "Failed to enqueue JPEG image.");
        return false;
    L6:
        return true;
    }

    public static void copyBitmapToByteBuffer(Bitmap r7, ByteBuffer r8, int r9) {
        nativeCopyBetweenByteBufferAndBitmap(r7, r8, r7.getRowBytes(), r9, r7.getWidth(), r7.getHeight(), false);
    }

    public static void copyByteBufferToBitmap(Bitmap r7, ByteBuffer r8, int r9) {
        nativeCopyBetweenByteBufferAndBitmap(r7, r8, r9, r7.getRowBytes(), r7.getWidth(), r7.getHeight(), true);
    }

    private static /* synthetic */ void lambda$convertYUVToRGB$0(ImageProxy r0, ImageProxy r1, ImageProxy r2) {
        if (r0 == null) goto L6;
        if (r1 == null) goto L7;
        r1.close();
        return;
    L7:
        return;
    }

    private static /* synthetic */ void lambda$rotateYUV$1(ImageProxy r0, ImageProxy r1, ImageProxy r2) {
        if (r0 == null) goto L6;
        if (r1 == null) goto L7;
        r1.close();
        return;
    L7:
        return;
    }

    public static boolean convertYuvToJpegBytesIntoSurface(ImageProxy r1, int r2, int r3, Surface r4) {
        return writeJpegBytesToSurface(r4, ImageUtil.yuvImageToJpegByteArray(r1, null, r2, r3));
    L5:
        e = move-exception;
        Logger.e(TAG, "Failed to encode YUV to JPEG", e);
        return false;
    }

    public static boolean convertYuvToJpegBytesIntoSurface(Image r1, int r2, int r3, Surface r4) {
        return convertYuvToJpegBytesIntoSurface(new AndroidImageProxy(r1), r2, r3, r4);
    }

    public static ImageProxy convertYUVToRGB(final ImageProxy r7, ImageReaderProxy r8, ByteBuffer r9, int r10, boolean r11) {
        if (isSupportedYUVFormat(r7) == true) goto L6;
        Logger.e(TAG, "Unsupported format for YUV to RGB");
        return null;
    L6:
        long r3 = System.currentTimeMillis();
        if (isSupportedRotationDegrees(r10) == true) goto L11;
        Logger.e(TAG, "Unsupported rotation degrees for rotate RGB");
        return null;
    L11:
        if (convertYUVToRGBInternal(r7, r8.getSurface(), r9, r10, r11) != Result.ERROR_CONVERSION) goto L15;
        Logger.e(TAG, "YUV to RGB conversion failure");
        return null;
    L15:
        if (Log.isLoggable("MH", 3) == false) goto L17;
        Logger.d(TAG, String.format(Locale.US, "Image processing performance profiling, duration: [%d], image count: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - r3), Integer.valueOf(sImageCount)}));
        sImageCount++;
    L17:
        final ImageProxy r12 = r8.acquireLatestImage();
        if (r12 != null) goto L21;
        Logger.e(TAG, "YUV to RGB acquireLatestImage failure");
        return null;
    L21:
        SingleCloseImageProxy r13 = new SingleCloseImageProxy(r12);
        r13.addOnImageCloseListener(new v(r12, r7));
        return r13;
    }

    private static Result convertYUVToRGBInternal(ImageProxy r16, Surface r17, ByteBuffer r18, int r19, boolean r20) {
        int r10 = r16.getWidth();
        int r11 = r16.getHeight();
        int r2 = r16.getPlanes()[0].getRowStride();
        int r4 = r16.getPlanes()[1].getRowStride();
        int r6 = r16.getPlanes()[2].getRowStride();
        int r7 = r16.getPlanes()[0].getPixelStride();
        int r8 = r16.getPlanes()[1].getPixelStride();
        if (r20 == false) goto L5;
        int r12 = r7;
    L6:
        if (r20 == false) goto L8;
        int r13 = r8;
    L9:
        if (r20 == false) goto L11;
        int r14 = r8;
    L13:
        if (nativeConvertAndroid420ToABGR(r16.getPlanes()[0].getBuffer(), r2, r16.getPlanes()[1].getBuffer(), r4, r16.getPlanes()[2].getBuffer(), r6, r7, r8, r17, r18, r10, r11, r12, r13, r14, r19) == 0) goto L17;
        return Result.ERROR_CONVERSION;
    L17:
        return Result.SUCCESS;
    L11:
        r14 = 0;
        goto L13
    L8:
        r13 = 0;
        goto L9
    L5:
        r12 = 0;
        goto L6
    }

    private static Result rotateYUVInternal(ImageProxy r23, ImageWriter r24, ByteBuffer r25, ByteBuffer r26, ByteBuffer r27, int r28) {
        int r19 = r23.getWidth();
        int r20 = r23.getHeight();
        int r3 = r23.getPlanes()[0].getRowStride();
        int r6 = r23.getPlanes()[1].getRowStride();
        int r16 = r23.getPlanes()[2].getRowStride();
        int r17 = r23.getPlanes()[1].getPixelStride();
        Image r14 = ImageWriterCompat.dequeueInputImage(r24);
        if (r14 != null) goto L7;
        return Result.ERROR_CONVERSION;
    L7:
        if (nativeRotateYUV(r23.getPlanes()[0].getBuffer(), r3, r23.getPlanes()[1].getBuffer(), r6, r23.getPlanes()[2].getBuffer(), r16, r17, r14.getPlanes()[0].getBuffer(), r14.getPlanes()[0].getRowStride(), r14.getPlanes()[0].getPixelStride(), r14.getPlanes()[1].getBuffer(), r14.getPlanes()[1].getRowStride(), r14.getPlanes()[1].getPixelStride(), r14.getPlanes()[2].getBuffer(), r14.getPlanes()[2].getRowStride(), r14.getPlanes()[2].getPixelStride(), r25, r26, r27, r19, r20, r28) != 0) goto L9;
        ImageWriterCompat.queueInputImage(r24, r14);
        return Result.SUCCESS;
    L9:
        return Result.ERROR_CONVERSION;
    }

    public static ImageProxy rotateYUV(final ImageProxy r9, ImageReaderProxy r10, ImageWriter r11, ByteBuffer r12, ByteBuffer r13, ByteBuffer r14, int r15) {
        if (isSupportedYUVFormat(r9) == true) goto L7;
        Logger.e(TAG, "Unsupported format for rotate YUV");
        return null;
    L7:
        if (isSupportedRotationDegrees(r15) == true) goto L10;
        Logger.e(TAG, "Unsupported rotation degrees for rotate YUV");
        return null;
    L10:
        Result r0 = Result.ERROR_CONVERSION;
        if (Build.VERSION.SDK_INT < 23) goto L14;
        if (r15 <= 0) goto L14;
        Result r16 = rotateYUVInternal(r9, r11, r12, r13, r14, r15);
    L15:
        if (r16 != r0) goto L18;
        Logger.e(TAG, "rotate YUV failure");
        return null;
    L18:
        final ImageProxy r17 = r10.acquireLatestImage();
        if (r17 != null) goto L22;
        Logger.e(TAG, "YUV rotation acquireLatestImage failure");
        return null;
    L22:
        SingleCloseImageProxy r18 = new SingleCloseImageProxy(r17);
        r18.addOnImageCloseListener(new w(r17, r9));
        return r18;
    L14:
        r16 = r0;
        goto L15
    }
}
