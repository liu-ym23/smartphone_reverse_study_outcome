package com.bytedance.fresco.heif;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.facebook.common.heif.HeifBitmapFactory;
import com.facebook.common.heif.HeifDecodeData;
import com.facebook.common.internal.Closeables;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatCheckerUtils;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.decoder.DefaultImageDecoder;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.memory.BasePool;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class HeifDecoder {
    public static boolean DEBUG = false;
    public static final ImageFormat HEIF_FORMAT = null;
    public static final ImageFormat HEIF_FORMAT_ANIMATED = null;
    public static final int MAX_BITMAP_SIZE = 104857600;
    public static final String TAG = "XGFrescoLog";
    public static final int TARGET_BITMAP_SIZE = 4194304;
    public static final ImageFormat VVIC_FORMAT = null;
    public static boolean mHeifDecodeLog;
    public static HeifBitmapFactory sBitmapFactory;
    public static boolean sHeifWppEnable;

    /* JADX INFO: loaded from: classes19.dex */
    public static class HeifBitmap extends CloseableStaticBitmap {
        public HeifBitmap(CloseableReference<Bitmap> r100, QualityInfo r101, int r102) {
            super(r100, r101, r102);
        }

        public HeifBitmap(CloseableReference<Bitmap> r100, QualityInfo r101, int r102, int r103, Rect r104, Rect r105, int r106, ImageFormat r107) {
            super(r100, r101, r102, r103, r104, r105, r106, r107);
        }

        public HeifBitmap(Bitmap r100, ResourceReleaser<Bitmap> r101, QualityInfo r102, int r103, int r104, Rect r105, Rect r106, int r107, ImageFormat r108) {
            super(r100, r101, r102, r103, r104, r105, r106, r107, r108);
        }

        public HeifBitmap(CloseableReference<Bitmap> r100, QualityInfo r101, int r102, int r103, Rect r104, Rect r105, int r106, ImageFormat r107, Map<String, String> r108) {
            super(r100, r101, r102, r103, r104, r105, r106, r107, r108);
        }

        public HeifBitmap(Bitmap r100, ResourceReleaser<Bitmap> r101, QualityInfo r102, int r103, int r104, Rect r105, Rect r106, int r107, ImageFormat r108, Map<String, String> r110) {
            super(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110);
        }
    }

    public static class HeifFormatChecker implements ImageFormat.FormatChecker {
        private static final int HEIF_HEADER_LENGTH = 0;
        private static final String HEIF_HEADER_PREFIX = "ftyp";
        private static final String[] HEIF_HEADER_SUFFIXES = null;

        public HeifFormatChecker() {
        }

        static {
            String[] r100 = {"heic", "heix", "hevc", "hevx", "mif1", "msf1", "vvic"};
            HEIF_HEADER_SUFFIXES = r100;
            HEIF_HEADER_LENGTH = ImageFormatCheckerUtils.asciiBytes(HEIF_HEADER_PREFIX + r100[0]).length;
        }

        @Override // com.facebook.imageformat.ImageFormat.FormatChecker
        public int getHeaderSize() {
            return HEIF_HEADER_LENGTH;
        }

        private static String getHeifHeader(byte[] r100, int r101) {
            if (r101 >= HEIF_HEADER_LENGTH) goto L6;
            return null;
        L6:
            if (r100[3] >= 8) goto L8;
            return null;
        L8:
            String[] r102 = HEIF_HEADER_SUFFIXES;
            int r103 = r102.length;
            int r104 = 0;
        L9:
            if (r104 >= r103) goto L18;
            String r105 = r102[r104];
            if (ImageFormatCheckerUtils.indexOfPattern(r100, r100.length, ImageFormatCheckerUtils.asciiBytes(HEIF_HEADER_PREFIX + r105), HEIF_HEADER_LENGTH) > (-1)) goto L13;
            r104 = r104 + 1;
            goto L9
        L13:
            if ("vvic".equalsIgnoreCase(r105) == true) goto L21;
            return "heic";
        L21:
            return "vvic";
        L18:
            return null;
        }

        @Override // com.facebook.imageformat.ImageFormat.FormatChecker
        public ImageFormat determineFormat(byte[] r100, int r101) {
            String r102 = getHeifHeader(r100, r101);
            if (TextUtils.isEmpty(r102) == false) goto L5;
            return null;
        L5:
            if ("vvic".equalsIgnoreCase(r102) == false) goto L9;
            return HeifDecoder.VVIC_FORMAT;
        L9:
            return HeifDecoder.HEIF_FORMAT;
        }
    }

    public static class HeifFormatDecoder implements ImageDecoder {
        private final BitmapPool mBitmapPool;
        private boolean mDecodeHeicUseSystemApiFirst;
        private PlatformDecoder mPlatformDecoder;
        private PooledByteBufferFactory mPooledByteBufferFactory;

        public boolean isDecodeHeicUseSystemApiFirst() {
            return this.mDecodeHeicUseSystemApiFirst;
        }

        public HeifFormatDecoder(PooledByteBufferFactory r100) {
            this(r100, false, null);
        }

        public void setDecodeHeicUseSystemApiFirst(boolean r100) {
            this.mDecodeHeicUseSystemApiFirst = r100;
        }

        public HeifFormatDecoder(boolean r100) {
            this(null, r100, null);
        }

        public HeifFormatDecoder(boolean r100, BitmapPool r101) {
            this(null, false, r101);
        }

        public HeifFormatDecoder(PooledByteBufferFactory r100, BitmapPool r101) {
            this(r100, false, r101);
        }

        public HeifFormatDecoder(PooledByteBufferFactory r100, boolean r101, BitmapPool r102) {
            this.mPooledByteBufferFactory = r100;
            this.mDecodeHeicUseSystemApiFirst = r101;
            this.mBitmapPool = r102;
        }

        private CloseableImage decodeAndBmfSr(EncodedImage r310, int r311, QualityInfo r312, ImageDecodeOptions r410) {
            CloseableReference<Bitmap> r100 = null;
            if (r310 != null) goto L5;
            return null;
        L5:
            HeifDecodeData r110 = new HeifDecodeData();
            r110.setHasAlpha(r310.hasAlpha());
            r110.setWidth(r310.getWidth());
            r110.setHeight(r310.getHeight());
            r310.setHeicSysFirst(false);
            r310.setHeicCustomDecoder(1);
            Rect r111 = HeifDecoder.access$000(r310, r410);
            int r112 = r310.getNativeSize();
            if (HeifDecoder.mHeifDecodeLog == false) goto L65;
            boolean r101 = r410.optSrWhenHeicDecode;
        L65:
            long r210 = r310.getNativePtr();     // Catch: Throwable -> L55 BasePool.PoolSizeViolationException -> L59
            int r211 = r310.getThumbWidth();     // Catch: Throwable -> L55 BasePool.PoolSizeViolationException -> L59
            int r212 = r310.getThumbHeight();     // Catch: Throwable -> L55 BasePool.PoolSizeViolationException -> L59
            r310.getSize();     // Catch: Throwable -> L55 BasePool.PoolSizeViolationException -> L59
            if (r310.isDecodeThumb() == false) goto L19;
            long r102 = SystemClock.uptimeMillis();     // Catch: Throwable -> L55 BasePool.PoolSizeViolationException -> L59
            CloseableReference<Bitmap> r103 = HeifDecoder.getBitmapFactory().decodeThumbByNativePtr(this.mBitmapPool, r210, r112, r211, r212, null, null, null);     // Catch: Throwable -> L55 BasePool.PoolSizeViolationException -> L59
            if (r103 != null) goto L62;
            Bitmap r104 = null;
        L14:
            r310.setThumbDecodeDuration(SystemClock.uptimeMillis() - r102);     // Catch: Throwable -> L51 BasePool.PoolSizeViolationException -> L53
            if (r104 == null) goto L18;
            FLog.d("XGFrescoLog", "decode thumb successfully");     // Catch: Throwable -> L51 BasePool.PoolSizeViolationException -> L53
            HeifBitmap r105 = HeifDecoder.access$400(r103, ImmutableQualityInfo.FULL_QUALITY, r310.getRotationAngle(), 0, HeifDecoder.access$000(r310, r410), r310.getRegionToDecode(), r310.getSampleSize(), r310.getImageFormat());     // Catch: Throwable -> L51 BasePool.PoolSizeViolationException -> L53
            r105.setThumbCache(true);     // Catch: Throwable -> L51 BasePool.PoolSizeViolationException -> L53
            return r105;
        L18:
            CloseableReference<Bitmap> r113 = r103;
        L20:
            if (r111 != null) goto L63;
            Bitmap r106 = null;
        L32:
            if (r106 != null) goto L41;
            HashMap r114 = new HashMap();     // Catch: Throwable -> L27 BasePool.PoolSizeViolationException -> L29
            if (HeifDecoder.mHeifDecodeLog == false) goto L36;
            Objects.toString(r410.heicSROptions);     // Catch: Throwable -> L27 BasePool.PoolSizeViolationException -> L29
        L36:
            CloseableReference<Bitmap> r107 = HeifDecoder.getBitmapFactory().decodeByNativePtrCombineSr(this.mBitmapPool, r210, r112, r111, HeifDecoder.access$100(r310, r410.bitmapConfig), r110, r410.heicSROptions, r114);     // Catch: Throwable -> L27 BasePool.PoolSizeViolationException -> L29
            if (r107 != null) goto L39;
            r106 = null;
        L40:
            r310.setHeifDecError(r110.getHeifDecError());     // Catch: Throwable -> L51 BasePool.PoolSizeViolationException -> L53
            r310.setHeifSizeAbnormal(r110.isSizeAbnormal());     // Catch: Throwable -> L51 BasePool.PoolSizeViolationException -> L53
        L42:
            if (r106 == null) goto L58;
            Bitmap r108 = HeifDecoder.access$300(this.mBitmapPool, r106, r310);     // Catch: Throwable -> L51 BasePool.PoolSizeViolationException -> L53
            if (r108 == r106) goto L47;
            CloseableReference.closeSafely(r107);     // Catch: Throwable -> L51 BasePool.PoolSizeViolationException -> L53
            r107 = CloseableReference.of(r108, SimpleBitmapReleaser.getInstance());     // Catch: Throwable -> L51 BasePool.PoolSizeViolationException -> L53
        L47:
            if (HeifDecoder.mHeifDecodeLog == false) goto L50;
            Objects.toString(r108);     // Catch: Throwable -> L51 BasePool.PoolSizeViolationException -> L53
            Objects.toString(r114);     // Catch: Throwable -> L51 BasePool.PoolSizeViolationException -> L53
        L50:
            return HeifDecoder.access$500(r107, ImmutableQualityInfo.FULL_QUALITY, r310.getRotationAngle(), 0, HeifDecoder.access$000(r310, r410), r310.getRegionToDecode(), r310.getSampleSize(), r310.getImageFormat(), r114);
        L58:
            return null;
        L39:
            r106 = r107.get();     // Catch: Throwable -> L51 BasePool.PoolSizeViolationException -> L53
            goto L40
        L29:
            e = e;
            r100 = r113;
        L60:
            CloseableReference.closeSafely(r100);
            throw e;
        L27:
            th = th;
            r103 = r113;
        L57:
            CloseableReference.closeSafely(r103);
            FLog.d("XGFrescoLog", "decodeAndBmfSr isUseUltimateOptHeifBitmap t = " + th);
            goto L58
        L41:
            r114 = null;
            r107 = r113;
            goto L42
        L63:
            CloseableReference<Bitmap> r109 = HeifDecoder.getBitmapFactory().decodeByNativePtr(this.mBitmapPool, r210, r112, r111, HeifDecoder.access$100(r310, r410.bitmapConfig), r110);     // Catch: Throwable -> L27 BasePool.PoolSizeViolationException -> L29
            if (r109 != null) goto L24;
            r106 = null;
        L25:
            r310.setHeifDecError(r110.getHeifDecError());     // Catch: Throwable -> L51 BasePool.PoolSizeViolationException -> L53
            r310.setHeifSizeAbnormal(r110.isSizeAbnormal());     // Catch: Throwable -> L51 BasePool.PoolSizeViolationException -> L53
            r113 = r109;
            goto L32
        L24:
            r106 = r109.get();     // Catch: Throwable -> L51 BasePool.PoolSizeViolationException -> L53
            goto L25
        L62:
            r104 = r103.get();     // Catch: Throwable -> L51 BasePool.PoolSizeViolationException -> L53
        L53:
            e = e;
            r100 = r103;
        L51:
            th = th;
            goto L57
        L19:
            r113 = null;
        L59:
            e = e;
        L55:
            th = th;
            r103 = null;
            goto L57
        }

        private CloseableImage decodeHdrHeic(EncodedImage r210, int r211, QualityInfo r212, ImageDecodeOptions r213) {
            CloseableReference<Bitmap> r100 = null;
            if (r210 != null) goto L5;
            return null;
        L5:
            HeifDecodeData r110 = new HeifDecodeData();
            r110.setHasAlpha(r210.hasAlpha());
            r110.setWidth(r210.getWidth());
            r110.setHeight(r210.getHeight());
            r110.setHdrType(r210.getHdrType());
            r210.setHeicSysFirst(false);
            r210.setHeicCustomDecoder(1);
            HeifDecoder.access$000(r210, r213);
            r210.getNativeSize();
            if (HeifDecoder.mHeifDecodeLog == false) goto L8;
            FrescoCacheMonitorUtil.isUseUltimateOptHeifBitmap();
        L8:
            InputStream r111 = r210.getInputStream();
            CloseableReference<Bitmap> r101 = HeifDecoder.getBitmapFactory().decodeStream(this.mBitmapPool, r111, null, HeifDecoder.access$100(r210, r213.bitmapConfig), r110);     // Catch: Throwable -> L33 BasePool.PoolSizeViolationException -> L40
            if (r101 != null) goto L48;
            Bitmap r102 = null;
        L13:
            r210.setHeifDecError(r110.getHeifDecError());     // Catch: Throwable -> L29 BasePool.PoolSizeViolationException -> L31
            r210.setHeifSizeAbnormal(r110.isSizeAbnormal());     // Catch: Throwable -> L29 BasePool.PoolSizeViolationException -> L31
            if (HeifDecoder.mHeifDecodeLog == false) goto L16;
            Objects.toString(r102);     // Catch: Throwable -> L29 BasePool.PoolSizeViolationException -> L31
        L16:
            if (r102 == null) goto L18;
        L22:
            if (r102 == null) goto L38;
            Bitmap r103 = HeifDecoder.access$300(this.mBitmapPool, r102, r210);     // Catch: Throwable -> L29 BasePool.PoolSizeViolationException -> L31
            if (r103 == r102) goto L26;
            CloseableReference.closeSafely(r101);     // Catch: Throwable -> L29 BasePool.PoolSizeViolationException -> L31
            r101 = CloseableReference.of(r103, SimpleBitmapReleaser.getInstance());     // Catch: Throwable -> L29 BasePool.PoolSizeViolationException -> L31
        L26:
            HeifBitmap r104 = HeifDecoder.access$400(r101, ImmutableQualityInfo.FULL_QUALITY, r210.getRotationAngle(), 0, HeifDecoder.access$000(r210, r213), r210.getRegionToDecode(), r210.getSampleSize(), r210.getImageFormat());     // Catch: Throwable -> L29 BasePool.PoolSizeViolationException -> L31
            Closeables.closeQuietly(r111);
            return r104;
        L31:
            e = e;
            r100 = r101;
        L41:
            CloseableReference.closeSafely(r100);     // Catch: Throwable -> L43
            throw e;     // Catch: Throwable -> L43
        L29:
            th = th;
        L35:
            CloseableReference.closeSafely(r101);     // Catch: Throwable -> L43
            if (HeifDecoder.DEBUG == false) goto L38;
            FLog.d("XGFrescoLog", "decodeHdrHeic exception:" + Log.getStackTraceString(th));     // Catch: Throwable -> L43
        L38:
            Closeables.closeQuietly(r111);
            return null;
        L18:
            if (Build.VERSION.SDK_INT < 27) goto L22;
            r111.reset();     // Catch: Throwable -> L29 BasePool.PoolSizeViolationException -> L31
            BitmapFactory.Options r105 = HeifDecoder.access$200(r210, r213.bitmapConfig);     // Catch: Throwable -> L29 BasePool.PoolSizeViolationException -> L31
            r111.reset();     // Catch: Throwable -> L29 BasePool.PoolSizeViolationException -> L31
            r102 = BitmapFactory.decodeStream(r111, null, r105);     // Catch: Throwable -> L29 BasePool.PoolSizeViolationException -> L31
            r101 = CloseableReference.of(r102, SimpleBitmapReleaser.getInstance());     // Catch: Throwable -> L29 BasePool.PoolSizeViolationException -> L31
            r210.setHeicCustomDecoder(0);     // Catch: Throwable -> L29 BasePool.PoolSizeViolationException -> L31
            if (HeifDecoder.mHeifDecodeLog == false) goto L22;
            Objects.toString(r102);     // Catch: Throwable -> L29 BasePool.PoolSizeViolationException -> L31
            goto L22
        L48:
            r102 = r101.get();     // Catch: Throwable -> L29 BasePool.PoolSizeViolationException -> L31
            goto L13
        L43:
            th = move-exception;
            Closeables.closeQuietly(r111);
            throw th;
        L40:
            e = e;
        L33:
            th = th;
            r101 = null;
            goto L35
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r37v0, types: [com.facebook.imagepipeline.image.EncodedImage] */
        /* JADX WARN: Type inference failed for: r4v1 */
        /* JADX WARN: Type inference failed for: r4v10 */
        /* JADX WARN: Type inference failed for: r4v11, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r4v2 */
        /* JADX WARN: Type inference failed for: r4v22 */
        /* JADX WARN: Type inference failed for: r4v23 */
        /* JADX WARN: Type inference failed for: r4v24 */
        /* JADX WARN: Type inference failed for: r4v25 */
        /* JADX WARN: Type inference failed for: r4v3 */
        /* JADX WARN: Type inference failed for: r4v4 */
        /* JADX WARN: Type inference failed for: r4v5 */
        /* JADX WARN: Type inference failed for: r4v6 */
        /* JADX WARN: Type inference failed for: r4v7 */
        /* JADX WARN: Type inference failed for: r4v8 */
        /* JADX WARN: Type inference failed for: r4v9 */
        /* JADX WARN: Type inference failed for: r5v14, types: [boolean] */
        /* JADX WARN: Type inference failed for: r5v28, types: [android.graphics.BitmapRegionDecoder] */
        /* JADX WARN: Type inference failed for: r5v30 */
        /* JADX WARN: Type inference failed for: r5v31 */
        /* JADX WARN: Type inference failed for: r5v32 */
        /* JADX WARN: Type inference failed for: r5v33 */
        /* JADX WARN: Type inference failed for: r5v37 */
        /* JADX WARN: Type inference failed for: r5v40 */
        /* JADX WARN: Type inference failed for: r5v42 */
        /* JADX WARN: Type inference failed for: r5v43 */
        /* JADX WARN: Type inference failed for: r5v44 */
        /* JADX WARN: Type inference failed for: r5v45 */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r5v38 java.lang.StringBuilder, still in use, count: 1, list:
              (r5v38 java.lang.StringBuilder) from MOVE (r5v43 ??) = (r5v38 java.lang.StringBuilder) A[SYNTHETIC]
            	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
            	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
            	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
            	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:59)
            	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:463)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:97)
            */
        private com.facebook.imagepipeline.image.CloseableImage decodeUseLibHeifFirst(com.facebook.imagepipeline.image.EncodedImage r37, int r38, com.facebook.imagepipeline.image.QualityInfo r39, com.facebook.imagepipeline.common.ImageDecodeOptions r40) {
            java.lang.String r4 = "Could not decode region %s, decoding full bitmap instead.";
            java.lang.String r5 = "HeifFormatDecoder.decode exception:";
            if (r37 != 0) goto L5;
            return null;
        L5:
            com.facebook.common.heif.HeifDecodeData r15 = new com.facebook.common.heif.HeifDecodeData();
            boolean r0 = r37.hasAlpha();
            r15.setHasAlpha(r0);
            int r0 = r37.getWidth();
            r15.setWidth(r0);
            int r0 = r37.getHeight();
            r15.setHeight(r0);
            r37.setHeicSysFirst(false);
            r37.setHeicCustomDecoder(1);
            android.graphics.Rect r12 = com.bytedance.fresco.heif.HeifDecoder.access$000(r37, r40);
            int r0 = r37.getNativeSize();
            boolean r7 = com.bytedance.fresco.heif.HeifDecoder.mHeifDecodeLog;
            if (r7 == false) goto L8;
            com.facebook.imagepipeline.core.FrescoCacheMonitorUtil.isUseUltimateOptHeifBitmap();
        L8:
            boolean r7 = com.facebook.imagepipeline.core.FrescoCacheMonitorUtil.isUseUltimateOptHeifBitmap();
            if (r7 == true) goto L182;
            r19 = "Could not decode region %s, decoding full bitmap instead.";
            r39 = "HeifFormatDecoder.decode exception:";
            java.lang.String r6 = "XGFrescoLog";
            java.lang.String r5 = "decode thumb successfully";
            android.graphics.Rect r18 = r12;
            int r4 = 1;
            android.graphics.Bitmap r7 = null;
            com.facebook.common.references.CloseableReference<android.graphics.Bitmap> r10 = null;
        L75:
            java.io.InputStream r13 = r37.getInputStream();
            boolean r0 = r37.isDecodeThumb();     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            com.facebook.common.references.CloseableReference<android.graphics.Bitmap> r10 = r10;
            if (r0 == false) goto L87;
            long r8 = android.os.SystemClock.uptimeMillis();     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            com.bytedance.fresco.heif.HeifBitmapFactoryV2Impl r0 = com.bytedance.fresco.heif.HeifDecoder.getBitmapFactory();     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            com.facebook.imagepipeline.memory.BitmapPool r11 = r36.mBitmapPool;     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            com.facebook.common.references.CloseableReference<android.graphics.Bitmap> r10 = r0.decodeThumb(r11, r13, null, null);     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            if (r10 != null) goto L81;
            android.graphics.Bitmap r0 = null;
        L82:
            long r11 = android.os.SystemClock.uptimeMillis();     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            long r11 = r11 - r8;     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            r37.setThumbDecodeDuration(r11);     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            r13.reset();     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            r10 = r10;
            if (r0 == null) goto L87;
            com.facebook.common.logging.FLog.d(r6, r5);     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            com.facebook.imagepipeline.image.QualityInfo r21 = com.facebook.imagepipeline.image.ImmutableQualityInfo.FULL_QUALITY;     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            int r22 = r37.getRotationAngle();     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            android.graphics.Rect r24 = com.bytedance.fresco.heif.HeifDecoder.access$000(r37, r40);     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            android.graphics.Rect r25 = r37.getRegionToDecode();     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            int r26 = r37.getSampleSize();     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            com.facebook.imageformat.ImageFormat r27 = r37.getImageFormat();     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            com.bytedance.fresco.heif.HeifDecoder.HeifBitmap r0 = com.bytedance.fresco.heif.HeifDecoder.access$400(r10, r21, r22, 0, r24, r25, r26, r27);     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            r0.setThumbCache(r4);     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            com.facebook.common.internal.Closeables.closeQuietly(r13);
            return r0;
        L81:
            android.graphics.Bitmap r0 = r10.get();     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            r0 = r0;     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
        L87:
            com.facebook.common.references.CloseableReference<android.graphics.Bitmap> r5 = r10;
            android.graphics.Rect r14 = r18;
            if (r14 != null) goto L189;
            r5 = r5;
        L124:
            if (r7 != null) goto L133;
            r13.reset();     // Catch: java.lang.Throwable -> L119 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L121
            com.bytedance.fresco.heif.HeifBitmapFactoryV2Impl r7 = com.bytedance.fresco.heif.HeifDecoder.getBitmapFactory();     // Catch: java.lang.Throwable -> L119 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L121
            com.facebook.imagepipeline.memory.BitmapPool r8 = r36.mBitmapPool;     // Catch: java.lang.Throwable -> L119 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L121
            android.graphics.Bitmap.Config r0 = r40.bitmapConfig;     // Catch: java.lang.Throwable -> L119 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L121
            android.graphics.BitmapFactory.Options r11 = com.bytedance.fresco.heif.HeifDecoder.access$100(r37, r0);     // Catch: java.lang.Throwable -> L119 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L121
            int r4 = 0;
            com.facebook.common.references.CloseableReference<android.graphics.Bitmap> r10 = r7.decodeStream(r8, r13, null, r11, r15);     // Catch: java.lang.Throwable -> L119 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L121
            if (r10 != null) goto L128;
            android.graphics.Bitmap r0 = null;
        L129:
            int r5 = r15.getHeifDecError();     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            r37.setHeifDecError(r5);     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            boolean r5 = r15.isSizeAbnormal();     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            r37.setHeifSizeAbnormal(r5);     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            boolean r5 = com.bytedance.fresco.heif.HeifDecoder.mHeifDecodeLog;     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            ?? r5 = r5;
            if (r5 == false) goto L132;
            java.util.Objects.toString(r0);     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            r5 = r5;
        L132:
            r7 = r0;
            goto L30b;
            ?? r5 = r5;
            com.facebook.common.references.CloseableReference<android.graphics.Bitmap> r10 = r10;
        L134:
            boolean r0 = com.facebook.imagepipeline.core.FrescoCacheMonitorUtil.isRemoveVvicUseSystemApi();     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            if (r0 == false) goto L138;
            com.facebook.imageformat.ImageFormat r0 = r37.getImageFormat();     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            boolean r0 = com.facebook.imageformat.DefaultImageFormats.isHeifFormat(r0);     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            if (r0 == true) goto L138;
        L144:
            if (r7 == null) goto L176;
            com.facebook.imagepipeline.memory.BitmapPool r0 = r36.mBitmapPool;     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            android.graphics.Bitmap r0 = com.bytedance.fresco.heif.HeifDecoder.access$300(r0, r7, r37);     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            com.facebook.common.references.CloseableReference<android.graphics.Bitmap> r10 = r10;
            if (r0 == r7) goto L148;
            com.facebook.common.references.CloseableReference.closeSafely(r10);     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser r4 = com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser.getInstance();     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            com.facebook.common.references.CloseableReference<android.graphics.Bitmap> r0 = com.facebook.common.references.CloseableReference.of(r0, r4);     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            r10 = r0;
        L148:
            com.facebook.imagepipeline.image.QualityInfo r15 = com.facebook.imagepipeline.image.ImmutableQualityInfo.FULL_QUALITY;     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            int r16 = r37.getRotationAngle();     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            android.graphics.Rect r18 = com.bytedance.fresco.heif.HeifDecoder.access$000(r37, r40);     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            android.graphics.Rect r19 = r37.getRegionToDecode();     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            int r20 = r37.getSampleSize();     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            com.facebook.imageformat.ImageFormat r21 = r37.getImageFormat();     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            com.facebook.common.references.CloseableReference<android.graphics.Bitmap> r14 = r10;
            com.bytedance.fresco.heif.HeifDecoder.HeifBitmap r0 = com.bytedance.fresco.heif.HeifDecoder.access$400(r14, r15, r16, 0, r18, r19, r20, r21);     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            com.facebook.common.internal.Closeables.closeQuietly(r13);
            return r0;
        L176:
        L155:
            com.facebook.common.internal.Closeables.closeQuietly(r13);
            return null;
        L111:
            r0 = move-exception;
            if (r5 == 0) goto L114;
            r5.recycle();     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
        L114:
            throw r0;     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
        L138:
            if (r7 != null) goto L144;
            int r0 = android.os.Build.VERSION.SDK_INT;     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            r5 = 27;
            if (r0 < 27) goto L144;
            r13.reset();     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            android.graphics.Bitmap.Config r0 = r40.bitmapConfig;     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            android.graphics.BitmapFactory.Options r0 = com.bytedance.fresco.heif.HeifDecoder.access$200(r37, r0);     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            r13.reset();     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            r5 = 0;
            r5 = 0;
            r7 = android.graphics.BitmapFactory.decodeStream(r13, null, r0);     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser r0 = com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser.getInstance();     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            r10 = com.facebook.common.references.CloseableReference.of(r7, r0);     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            r37.setHeicCustomDecoder(r4);     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            boolean r0 = com.bytedance.fresco.heif.HeifDecoder.mHeifDecodeLog;     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            if (r0 == false) goto L144;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder;     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            java.util.Objects.toString(r7);     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            goto L144
        L128:
            android.graphics.Bitmap r0 = r10.get();     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            r0 = r0;     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            goto L129
        L121:
            r0 = e;
            r10 = r5;
        L158:
            com.facebook.common.references.CloseableReference.closeSafely(r10);     // Catch: java.lang.Throwable -> L160
            throw r0;     // Catch: java.lang.Throwable -> L160
        L119:
            r0 = th;
            r10 = r5;
        L152:
            com.facebook.common.references.CloseableReference.closeSafely(r10);     // Catch: java.lang.Throwable -> L160
            boolean r2 = com.bytedance.fresco.heif.HeifDecoder.DEBUG;     // Catch: java.lang.Throwable -> L160
            if (r2 == false) goto L155;
            java.lang.String r3 = r39;
            java.lang.StringBuilder r2 = new java.lang.StringBuilder(r3);     // Catch: java.lang.Throwable -> L160
            java.lang.String r0 = android.util.Log.getStackTraceString(r0);     // Catch: java.lang.Throwable -> L160
            r2.append(r0);     // Catch: java.lang.Throwable -> L160
            java.lang.String r0 = r2.toString();     // Catch: java.lang.Throwable -> L160
            com.facebook.common.logging.FLog.d(r6, r0);     // Catch: java.lang.Throwable -> L160
            goto L155
        L133:
            r4 = 0;
            r10 = r5;
            r5 = r5;
            goto L134
        L189:
            com.bytedance.fresco.heif.HeifBitmapFactoryV2Impl r7 = com.bytedance.fresco.heif.HeifDecoder.getBitmapFactory();     // Catch: java.lang.Throwable -> L119 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L121
            com.facebook.imagepipeline.memory.BitmapPool r8 = r36.mBitmapPool;     // Catch: java.lang.Throwable -> L119 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L121
            android.graphics.Bitmap.Config r0 = r40.bitmapConfig;     // Catch: java.lang.Throwable -> L119 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L121
            android.graphics.BitmapFactory.Options r11 = com.bytedance.fresco.heif.HeifDecoder.access$100(r37, r0);     // Catch: java.lang.Throwable -> L119 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L121
            com.facebook.common.references.CloseableReference<android.graphics.Bitmap> r10 = r7.decodeStream(r8, r13, r14, r11, r15);     // Catch: java.lang.Throwable -> L119 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L121
            if (r10 != null) goto L92;
            android.graphics.Bitmap r0 = null;
        L93:
            int r5 = r15.getHeifDecError();     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            r37.setHeifDecError(r5);     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            r5 = r15.isSizeAbnormal();     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            r37.setHeifSizeAbnormal(r5);     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            if (r0 == null) goto L181;
            r7 = r0;
            android.graphics.BitmapRegionDecoder r5 = null;
        L116:
            if (r5 == null) goto L118;
        L117:
            r5.recycle();     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
        L118:
            r5 = r10;
            goto L124
        L181:
            r13.reset();     // Catch: java.lang.Throwable -> L103 java.io.IOException -> L107
            r5 = android.graphics.BitmapRegionDecoder.newInstance(r13, r4);     // Catch: java.io.IOException -> L101 java.lang.Throwable -> L103
        L191:
            android.graphics.Bitmap.Config r7 = r40.bitmapConfig;     // Catch: java.lang.Throwable -> L99 java.io.IOException -> L100
            android.graphics.BitmapFactory.Options r7 = com.bytedance.fresco.heif.HeifDecoder.access$600(r37, r7);     // Catch: java.lang.Throwable -> L99 java.io.IOException -> L100
            r0 = r5.decodeRegion(r14, r7);     // Catch: java.lang.Throwable -> L99 java.io.IOException -> L100
            com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser r7 = com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser.getInstance();     // Catch: java.lang.Throwable -> L99 java.io.IOException -> L100
            com.facebook.common.references.CloseableReference<android.graphics.Bitmap> r4 = com.facebook.common.references.CloseableReference.of(r0, r7);     // Catch: java.lang.Throwable -> L99 java.io.IOException -> L100
            r7 = r0;
            r10 = r4;
            goto L116
        L100:
            r7 = r0;
        L102:
            char r12 = 0;
        L108:
            java.lang.Object[] r0 = new java.lang.Object[r4];     // Catch: java.lang.Throwable -> L111
            r0[r12] = r14;     // Catch: java.lang.Throwable -> L111
            com.facebook.common.logging.FLog.e(r6, r8, r0);     // Catch: java.lang.Throwable -> L111
            if (r5 == null) goto L118;
        L99:
            r7 = r0;
        L104:
            java.lang.Object[] r0 = new java.lang.Object[r4];     // Catch: java.lang.Throwable -> L111
            r0[0] = r14;     // Catch: java.lang.Throwable -> L111
            java.lang.String r8 = r19;
            com.facebook.common.logging.FLog.e(r6, r8, r0);     // Catch: java.lang.Throwable -> L111
            if (r5 == null) goto L118;
            goto L2bf;
        L101:
            r7 = r0;
            r5 = null;
        L103:
            r7 = r0;
            r5 = null;
        L107:
            r8 = r19;
            r12 = 0;
            r7 = r0;
            r5 = null;
            goto L108
        L92:
            android.graphics.Bitmap r0 = r10.get();     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
            r0 = r0;     // Catch: java.lang.Throwable -> L151 com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException -> L157
        L160:
            r0 = move-exception;
            com.facebook.common.internal.Closeables.closeQuietly(r13);
            throw r0;
        L157:
            r0 = e;
        L151:
            r0 = th;
            goto L152
        L182:
            long r26 = r37.getNativePtr();     // Catch: java.lang.Throwable -> L71
            int r21 = r37.getThumbWidth();     // Catch: java.lang.Throwable -> L71
            int r22 = r37.getThumbHeight();     // Catch: java.lang.Throwable -> L71
            r37.getSize();     // Catch: java.lang.Throwable -> L71
            boolean r7 = r37.isDecodeThumb();     // Catch: java.lang.Throwable -> L71
            if (r7 == true) goto L187;
            com.facebook.common.references.CloseableReference<android.graphics.Bitmap> r16 = null;
        L27:
            if (r12 != null) goto L174;
            r19 = "Could not decode region %s, decoding full bitmap instead.";
            r39 = "HeifFormatDecoder.decode exception:";
            r6 = "XGFrescoLog";
            r5 = "decode thumb successfully";
            r18 = r12;
            r4 = 1;
            com.facebook.common.references.CloseableReference<android.graphics.Bitmap> r17 = r16;
            android.graphics.Bitmap r16 = null;
        L45:
            if (r16 == null) goto L168;
            r7 = r16;
            r10 = r17;
        L60:
            if (r7 == null) goto L75;
            com.facebook.imagepipeline.memory.BitmapPool r0 = r36.mBitmapPool;     // Catch: java.lang.Throwable -> L69
            android.graphics.Bitmap r0 = com.bytedance.fresco.heif.HeifDecoder.access$300(r0, r7, r37);     // Catch: java.lang.Throwable -> L69
            r10 = r10;
            if (r0 == r7) goto L64;
            com.facebook.common.references.CloseableReference.closeSafely(r10);     // Catch: java.lang.Throwable -> L69
            com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser r8 = com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser.getInstance();     // Catch: java.lang.Throwable -> L69
            com.facebook.common.references.CloseableReference<android.graphics.Bitmap> r8 = com.facebook.common.references.CloseableReference.of(r0, r8);     // Catch: java.lang.Throwable -> L69
            r10 = r8;
        L64:
            boolean r8 = com.bytedance.fresco.heif.HeifDecoder.mHeifDecodeLog;     // Catch: java.lang.Throwable -> L69
            if (r8 == false) goto L67;
            java.lang.StringBuilder r8 = new java.lang.StringBuilder;     // Catch: java.lang.Throwable -> L69
            java.util.Objects.toString(r0);     // Catch: java.lang.Throwable -> L69
        L67:
            com.facebook.imagepipeline.image.QualityInfo r21 = com.facebook.imagepipeline.image.ImmutableQualityInfo.FULL_QUALITY;     // Catch: java.lang.Throwable -> L69
            int r22 = r37.getRotationAngle();     // Catch: java.lang.Throwable -> L69
            android.graphics.Rect r24 = com.bytedance.fresco.heif.HeifDecoder.access$000(r37, r40);     // Catch: java.lang.Throwable -> L69
            android.graphics.Rect r25 = r37.getRegionToDecode();     // Catch: java.lang.Throwable -> L69
            int r26 = r37.getSampleSize();     // Catch: java.lang.Throwable -> L69
            com.facebook.imageformat.ImageFormat r27 = r37.getImageFormat();     // Catch: java.lang.Throwable -> L69
            com.facebook.common.references.CloseableReference<android.graphics.Bitmap> r20 = r10;
            com.bytedance.fresco.heif.HeifDecoder.HeifBitmap r0 = com.bytedance.fresco.heif.HeifDecoder.access$400(r20, r21, r22, 0, r24, r25, r26, r27);     // Catch: java.lang.Throwable -> L69
            return r0;
        L69:
            r0 = th;
        L73:
            com.facebook.common.references.CloseableReference.closeSafely(r10);
            java.lang.StringBuilder r8 = new java.lang.StringBuilder("decodeUseLibHeifFirst isUseUltimateOptHeifBitmap t = ");
            r8.append(r0);
            java.lang.String r0 = r8.toString();
            com.facebook.common.logging.FLog.d(r6, r0);
            goto L75
        L168:
            boolean r7 = com.bytedance.fresco.heif.HeifDecoder.mHeifDecodeLog;     // Catch: java.lang.Throwable -> L57
            if (r7 == false) goto L49;
            java.lang.StringBuilder r7 = new java.lang.StringBuilder;     // Catch: java.lang.Throwable -> L57
            com.facebook.imagepipeline.core.FrescoCacheMonitorUtil.isUseUltimateOptHeifBitmap();     // Catch: java.lang.Throwable -> L57
        L49:
            com.bytedance.fresco.heif.HeifBitmapFactoryV2Impl r7 = com.bytedance.fresco.heif.HeifDecoder.getBitmapFactory();     // Catch: java.lang.Throwable -> L57
            com.facebook.imagepipeline.memory.BitmapPool r8 = r36.mBitmapPool;     // Catch: java.lang.Throwable -> L57
            android.graphics.Bitmap.Config r9 = r40.bitmapConfig;     // Catch: java.lang.Throwable -> L57
            android.graphics.BitmapFactory.Options r13 = com.bytedance.fresco.heif.HeifDecoder.access$100(r37, r9);     // Catch: java.lang.Throwable -> L57
            android.graphics.Rect r12 = r18;
            r10 = r7.decodeByNativePtr(r8, r26, r0, r12, r13, r15);     // Catch: java.lang.Throwable -> L57
            if (r10 != null) goto L164;
            r7 = null;
        L54:
            int r0 = r15.getHeifDecError();     // Catch: java.lang.Throwable -> L69
            r37.setHeifDecError(r0);     // Catch: java.lang.Throwable -> L69
            boolean r0 = r15.isSizeAbnormal();     // Catch: java.lang.Throwable -> L69
            r37.setHeifSizeAbnormal(r0);     // Catch: java.lang.Throwable -> L69
            goto L176;
            r10 = r10;
            goto L60
        L164:
            android.graphics.Bitmap r0 = r10.get();     // Catch: java.lang.Throwable -> L55
            android.graphics.Bitmap r0 = r0;     // Catch: java.lang.Throwable -> L55
            r7 = r0;
        L55:
            r0 = th;
            r7 = r16;
            goto L1c2;
        L57:
            r0 = th;
            r7 = r16;
            r10 = r17;
            goto L1c2;
            goto L73
        L174:
            com.bytedance.fresco.heif.HeifBitmapFactoryV2Impl r7 = com.bytedance.fresco.heif.HeifDecoder.getBitmapFactory();     // Catch: java.lang.Throwable -> L40
            com.facebook.imagepipeline.memory.BitmapPool r8 = r36.mBitmapPool;     // Catch: java.lang.Throwable -> L40
            android.graphics.Bitmap.Config r10 = r40.bitmapConfig;     // Catch: java.lang.Throwable -> L40
            android.graphics.BitmapFactory.Options r17 = com.bytedance.fresco.heif.HeifDecoder.access$100(r37, r10);     // Catch: java.lang.Throwable -> L40
            r6 = "XGFrescoLog";
            r39 = "HeifFormatDecoder.decode exception:";
            r5 = "decode thumb successfully";
            r18 = r12;
            r19 = "Could not decode region %s, decoding full bitmap instead.";
            r4 = 1;
            r4 = 1;
            r4 = 1;
            r4 = 1;
            r10 = r7.decodeByNativePtr(r8, r26, r0, r12, r17, r15);     // Catch: java.lang.Throwable -> L38
            if (r10 != null) goto L170;
            r7 = null;
        L179:
            int r8 = r15.getHeifDecError();     // Catch: java.lang.Throwable -> L69
            r37.setHeifDecError(r8);     // Catch: java.lang.Throwable -> L69
            boolean r8 = r15.isSizeAbnormal();     // Catch: java.lang.Throwable -> L69
            r37.setHeifSizeAbnormal(r8);     // Catch: java.lang.Throwable -> L69
            r16 = r7;
            r17 = r10;
            goto L45
        L170:
            android.graphics.Bitmap r7 = r10.get();     // Catch: java.lang.Throwable -> L36
            r7 = r7;     // Catch: java.lang.Throwable -> L36
        L36:
            r0 = th;
        L43:
            r7 = null;
        L38:
            r0 = th;
        L42:
            r10 = r16;
        L40:
            r0 = th;
            r19 = "Could not decode region %s, decoding full bitmap instead.";
            r39 = "HeifFormatDecoder.decode exception:";
            r6 = "XGFrescoLog";
            r5 = "decode thumb successfully";
            r18 = r12;
            r4 = 1;
            goto L42
        L187:
            long r7 = android.os.SystemClock.uptimeMillis();     // Catch: java.lang.Throwable -> L23
            com.bytedance.fresco.heif.HeifBitmapFactoryV2Impl r16 = com.bytedance.fresco.heif.HeifDecoder.getBitmapFactory();     // Catch: java.lang.Throwable -> L23
            com.facebook.imagepipeline.memory.BitmapPool r10 = r36.mBitmapPool;     // Catch: java.lang.Throwable -> L23
            com.facebook.common.references.CloseableReference<android.graphics.Bitmap> r10 = r16.decodeThumbByNativePtr(r10, r26, r0, r21, r22, null, null, null);     // Catch: java.lang.Throwable -> L23
            if (r10 != null) goto L185;
            android.graphics.Bitmap r16 = null;
        L16:
            long r17 = android.os.SystemClock.uptimeMillis();     // Catch: java.lang.Throwable -> L21
            long r7 = r17 - r7;     // Catch: java.lang.Throwable -> L21
            r37.setThumbDecodeDuration(r7);     // Catch: java.lang.Throwable -> L21
            if (r16 == null) goto L20;
            com.facebook.common.logging.FLog.d("XGFrescoLog", "decode thumb successfully");     // Catch: java.lang.Throwable -> L21
            com.facebook.imagepipeline.image.QualityInfo r29 = com.facebook.imagepipeline.image.ImmutableQualityInfo.FULL_QUALITY;     // Catch: java.lang.Throwable -> L21
            int r30 = r37.getRotationAngle();     // Catch: java.lang.Throwable -> L21
            android.graphics.Rect r32 = com.bytedance.fresco.heif.HeifDecoder.access$000(r37, r40);     // Catch: java.lang.Throwable -> L21
            android.graphics.Rect r33 = r37.getRegionToDecode();     // Catch: java.lang.Throwable -> L21
            int r34 = r37.getSampleSize();     // Catch: java.lang.Throwable -> L21
            com.facebook.imageformat.ImageFormat r35 = r37.getImageFormat();     // Catch: java.lang.Throwable -> L21
            com.bytedance.fresco.heif.HeifDecoder.HeifBitmap r0 = com.bytedance.fresco.heif.HeifDecoder.access$400(r10, r29, r30, 0, r32, r33, r34, r35);     // Catch: java.lang.Throwable -> L21
            r0.setThumbCache(true);     // Catch: java.lang.Throwable -> L21
            return r0;
        L21:
            r0 = th;
            r7 = null;
            r10 = r10;
        L25:
            r6 = "XGFrescoLog";
            r5 = "decode thumb successfully";
            r18 = r12;
            r4 = 1;
            goto L73
        L20:
            r16 = r10;
            goto L27
        L185:
            android.graphics.Bitmap r16 = r10.get();     // Catch: java.lang.Throwable -> L21
            r16 = r16;     // Catch: java.lang.Throwable -> L21
        L23:
            r0 = th;
            r7 = null;
            r10 = null;
        L71:
            r0 = th;
            r19 = "Could not decode region %s, decoding full bitmap instead.";
            r39 = "HeifFormatDecoder.decode exception:";
            r6 = "XGFrescoLog";
            r5 = "decode thumb successfully";
            r18 = r12;
            r4 = 1;
            r7 = null;
            r10 = null;
            goto L73
        }

        @Override // com.facebook.imagepipeline.decoder.ImageDecoder
        public CloseableImage decode(EncodedImage r110, int r111, QualityInfo r112, ImageDecodeOptions r113) {
            r110.getHdrType();
            if (r110.getHdrType() > 0) goto L5;
            if (r113 != null) goto L8;
        L15:
            SimplayerImageStrategy r100 = SimplayerImageStrategy.getStrategy();
            boolean r101 = false;
            if (r100 != null) goto L18;
        L38:
            boolean r102 = false;
            int r103 = 1;
        L40:
            if (this.mDecodeHeicUseSystemApiFirst == false) goto L42;
        L43:
            r101 = true;
        L45:
            if (r103 == 3) goto L50;
            if (r103 != 2) goto L49;
            if (r101 == false) goto L50;
        L49:
            r102 = r101;
        L50:
            r110.getImageFormat();
            ImageFormat r104 = HeifDecoder.HEIF_FORMAT;
            if (r110.getImageFormat() != r104) goto L56;
            if (r102 == false) goto L56;
            return decodeUseSystemApiFirst(r110, r111, r112, r113, FrescoCacheMonitorUtil.isUseImageDecoder());
        L56:
            return decodeUseLibHeifFirst(r110, r111, r112, r113);
        L42:
            if (ImagePipelineConfig.getDefaultImageRequestConfig().isDecodeHeicUseSystemApiFirst() == false) goto L45;
        L18:
            if (r110.getViewWidth() <= 0) goto L38;
            if (r110.getViewHeight() <= 0) goto L38;
            if (r110.getUri() == null) goto L38;
            JSONObject r105 = new JSONObject();     // Catch: JSONException -> L35
            r105.put("viewWidth", r110.getViewWidth());     // Catch: JSONException -> L35
            r105.put("viewHeight", r110.getViewHeight());     // Catch: JSONException -> L35
            r105.put("imageFormat", r110.getImageFormat());     // Catch: JSONException -> L35
            if (SimplayerImageStrategy.isOpenLog() == false) goto L26;
            r105.toString();     // Catch: JSONException -> L35
            r110.getUri();     // Catch: JSONException -> L35
        L26:
            JSONObject r106 = r100.getResult(2, r110.getUri(), r105);     // Catch: JSONException -> L35
            if (SimplayerImageStrategy.isOpenLog() == false) goto L29;
            Objects.toString(r106);     // Catch: JSONException -> L35
        L29:
            if (r106 == null) goto L38;
            r103 = r106.optInt("priority", 1);     // Catch: JSONException -> L35
            r102 = r106.optBoolean(SimplayerImageStrategy.RESULT_USE_SYSTEM_API_FIRST);     // Catch: JSONException -> L33
        L33:
            e = e;
        L37:
            e.printStackTrace();
            r102 = false;
        L35:
            e = e;
            r103 = 1;
            goto L37
        L8:
            if (r113.optSrWhenHeicDecode == false) goto L15;
            if (r113.heicSROptions == null) goto L15;
            if (r110.hasAlpha() == true) goto L15;
            return decodeAndBmfSr(r110, r111, r112, r113);
        L5:
            return decodeHdrHeic(r110, r111, r112, r113);
        }

        public Bitmap decodeByImageDecoder(InputStream r100, int r101, final Rect r102, final BitmapFactory.Options r103) {
            ByteBuffer r104 = ByteBuffer.allocateDirect(r101);
            byte[] r105 = new byte[8192];     // Catch: Throwable -> L21
        L4:
            int r106 = r100.read(r105);     // Catch: Throwable -> L21
            if (r106 == (-1)) goto L7;
            r104.put(r105, 0, r106);     // Catch: Throwable -> L21
            goto L4
        L7:
            r104.flip();     // Catch: Throwable -> L21
            r104.compact();     // Catch: Throwable -> L21
            if (r104.limit() <= 0) goto L20;
            if (r103 == null) goto L11;
            final int r107 = r103.inSampleSize;     // Catch: Throwable -> L21
        L13:
            if (Build.VERSION.SDK_INT < 28) goto L20;
            r104.position();     // Catch: Throwable -> L21
            if (r104.position() == 0) goto L17;
            r104.rewind();     // Catch: Throwable -> L21
        L17:
            Bitmap r108 = android.graphics.ImageDecoder.decodeBitmap(android.graphics.ImageDecoder.createSource(r104), new AnonymousClass1(this, r102, r107, r103));     // Catch: Throwable -> L21
            Objects.toString(r108.getConfig());     // Catch: Throwable -> L21
            r108.getWidth();     // Catch: Throwable -> L21
            r108.getHeight();     // Catch: Throwable -> L21
            Objects.toString(r108.getColorSpace());     // Catch: Throwable -> L21
            r108.getByteCount();     // Catch: Throwable -> L21
            r104.clear();
            return r108;
        L11:
            r107 = 1;
        L20:
            r104.clear();
            return null;
        L21:
            th = move-exception;
            FLog.e("XGFrescoLog", "HeifDecoder.decodeByImageDecoder exception:" + Log.getStackTraceString(th));     // Catch: Throwable -> L26
        L26:
            th = move-exception;
            r104.clear();
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v15, types: [com.bytedance.fresco.heif.HeifBitmapFactoryV2Impl] */
        /* JADX WARN: Type inference failed for: r10v28, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r12v0, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r12v1 */
        /* JADX WARN: Type inference failed for: r12v10 */
        /* JADX WARN: Type inference failed for: r12v11 */
        /* JADX WARN: Type inference failed for: r12v3 */
        /* JADX WARN: Type inference failed for: r12v4 */
        /* JADX WARN: Type inference failed for: r12v7 */
        /* JADX WARN: Type inference failed for: r12v8 */
        /* JADX WARN: Type inference failed for: r12v9 */
        /* JADX WARN: Type inference failed for: r24v0, types: [com.bytedance.fresco.heif.HeifDecoder$HeifFormatDecoder] */
        /* JADX WARN: Type inference failed for: r25v0, types: [com.facebook.imagepipeline.image.EncodedImage] */
        /* JADX WARN: Type inference failed for: r7v1 */
        /* JADX WARN: Type inference failed for: r7v10 */
        /* JADX WARN: Type inference failed for: r7v12 */
        /* JADX WARN: Type inference failed for: r7v13 */
        /* JADX WARN: Type inference failed for: r7v14 */
        /* JADX WARN: Type inference failed for: r7v15 */
        /* JADX WARN: Type inference failed for: r7v16, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r7v17 */
        /* JADX WARN: Type inference failed for: r7v18 */
        /* JADX WARN: Type inference failed for: r7v3, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r7v4 */
        /* JADX WARN: Type inference failed for: r7v5 */
        /* JADX WARN: Type inference failed for: r7v7 */
        /* JADX WARN: Type inference failed for: r8v1, types: [long] */
        /* JADX WARN: Type inference failed for: r8v12 */
        /* JADX WARN: Type inference failed for: r8v13 */
        /* JADX WARN: Type inference failed for: r8v14 */
        /* JADX WARN: Type inference failed for: r8v15 */
        /* JADX WARN: Type inference failed for: r8v17, types: [com.bytedance.fresco.heif.HeifBitmapFactoryV2Impl] */
        /* JADX WARN: Type inference failed for: r8v22, types: [java.lang.Object[]] */
        /* JADX WARN: Type inference failed for: r8v28 */
        /* JADX WARN: Type inference failed for: r8v29 */
        /* JADX WARN: Type inference failed for: r8v3, types: [android.graphics.BitmapRegionDecoder] */
        /* JADX WARN: Type inference failed for: r8v30 */
        /* JADX WARN: Type inference failed for: r8v32 */
        /* JADX WARN: Type inference failed for: r8v33 */
        /* JADX WARN: Type inference failed for: r8v35 */
        /* JADX WARN: Type inference failed for: r8v36 */
        /* JADX WARN: Type inference failed for: r8v9, types: [com.bytedance.fresco.heif.HeifBitmapFactoryV2Impl] */
        private CloseableImage decodeUseSystemApiFirst(EncodedImage r210, int r211, QualityInfo r212, ImageDecodeOptions r213, boolean r214) {
            if (r210 != 0) goto L5;
            return null;
        L5:
            HeifDecodeData r110 = new HeifDecodeData();
            r110.setHasAlpha(r210.hasAlpha());
            r110.setWidth(r210.getWidth());
            r110.setHeight(r210.getHeight());
            r210.setHeicSysFirst(true);
            r210.setHeicCustomDecoder(0);
            ?? r111 = r210.getInputStream();
            Rect r112 = HeifDecoder.access$000(r210, r213);
            if (r210.isDecodeThumb() == true) goto L165;
            CloseableReference<Bitmap> r113 = null;
        L151:
            if (r112 != null) goto L176;
            ?? r100 = r111;
            Bitmap r101 = null;
            ?? r102 = r8;
            CloseableReference<Bitmap> r114 = r113;
            ?? r115 = r111;
        L72:
            if (r101 == null) goto L75;
        L112:
            CloseableReference<Bitmap> r103 = r114;
            ?? r104 = r102;
            Bitmap r105 = r101;
        L113:
            if (r105 != null) goto L126;
            r100.reset();     // Catch: Throwable -> L122 BasePool.PoolSizeViolationException -> L124
            ?? r106 = HeifDecoder.getBitmapFactory();     // Catch: Throwable -> L122 BasePool.PoolSizeViolationException -> L124
            BitmapPool r107 = this.mBitmapPool;     // Catch: Throwable -> L122 BasePool.PoolSizeViolationException -> L124
            BitmapFactory.Options r116 = HeifDecoder.access$100(r210, r213.bitmapConfig);     // Catch: Throwable -> L122 BasePool.PoolSizeViolationException -> L124
            CloseableReference<Bitmap> r117 = r106.decodeStream(r107, r100, null, r116, r110);     // Catch: Throwable -> L122 BasePool.PoolSizeViolationException -> L124
            if (r117 != null) goto L117;
            Bitmap r108 = null;
        L118:
            r210.setHeicCustomDecoder(1);     // Catch: Throwable -> L108 BasePool.PoolSizeViolationException -> L110
            r210.setHeifDecError(r110.getHeifDecError());     // Catch: Throwable -> L108 BasePool.PoolSizeViolationException -> L110
            r210.setHeifSizeAbnormal(r110.isSizeAbnormal());     // Catch: Throwable -> L108 BasePool.PoolSizeViolationException -> L110
            if (HeifDecoder.mHeifDecodeLog == false) goto L121;
            Objects.toString(r108);     // Catch: Throwable -> L108 BasePool.PoolSizeViolationException -> L110
        L121:
            Bitmap r109 = r108;
            ?? r118 = r108;
            CloseableReference<Bitmap> r119 = r117;
            r111 = r116;
        L127:
            if (r109 == null) goto L150;
            Bitmap r120 = HeifDecoder.access$300(this.mBitmapPool, r109, r210);     // Catch: Throwable -> L108 BasePool.PoolSizeViolationException -> L110
            if (r120 == r109) goto L132;
            CloseableReference.closeSafely(r119);     // Catch: Throwable -> L108 BasePool.PoolSizeViolationException -> L110
            CloseableReference<Bitmap> r121 = CloseableReference.of(r120, SimpleBitmapReleaser.getInstance());     // Catch: Throwable -> L108 BasePool.PoolSizeViolationException -> L110
        L133:
            HeifBitmap r122 = HeifDecoder.access$400(r121, ImmutableQualityInfo.FULL_QUALITY, r210.getRotationAngle(), 0, HeifDecoder.access$000(r210, r213), r210.getRegionToDecode(), r210.getSampleSize(), r210.getImageFormat());     // Catch: Throwable -> L122 BasePool.PoolSizeViolationException -> L124
            Closeables.closeQuietly(r100);
            return r122;
        L124:
            e = e;
        L125:
            CloseableReference<Bitmap> r123 = r121;
        L145:
            CloseableReference.closeSafely(r123);     // Catch: Throwable -> L147
            throw e;     // Catch: Throwable -> L147
        L122:
            th = th;
        L123:
            r123 = r121;
        L138:
            CloseableReference.closeSafely(r123);     // Catch: Throwable -> L147
            if (HeifDecoder.DEBUG == false) goto L141;
            FLog.d("XGFrescoLog", "HeifFormatDecoder.decode exception:" + Log.getStackTraceString(th));     // Catch: Throwable -> L147
        L141:
            Closeables.closeQuietly(r100);
            return null;
        L132:
            r121 = r119;
            goto L133
        L150:
            goto L141
        L117:
            r108 = r117.get();     // Catch: Throwable -> L108 BasePool.PoolSizeViolationException -> L110
            goto L118
        L126:
            r119 = r103;
            r118 = r104;
            r109 = r105;
            r111 = r115;
            goto L127
        L75:
            if (Build.VERSION.SDK_INT < 28) goto L112;
            r100.reset();     // Catch: Throwable -> L104
            BitmapFactory.Options r124 = HeifDecoder.access$200(r210, r213.bitmapConfig);     // Catch: Throwable -> L104
            r100.reset();     // Catch: Throwable -> L104
            if (r214 == false) goto L88;
            Bitmap r125 = decodeByImageDecoder(r100, r100.available(), null, r124);     // Catch: Throwable -> L104
            CloseableReference<Bitmap> r126 = CloseableReference.of(r125, SimpleBitmapReleaser.getInstance());     // Catch: Throwable -> L85
            r210.setHeicCustomDecoder(-1);     // Catch: Throwable -> L83
            Bitmap r127 = r125;
            int r128 = 0;
            CloseableReference<Bitmap> r129 = r126;
        L153:
        L97:
            th = th;
            r114 = r129;
            r101 = r127;
        L106:
            r102 = new Object[r128];     // Catch: Throwable -> L108 BasePool.PoolSizeViolationException -> L110
            FLog.e("XGFrescoLog", th, "Could not decode full image use system api.", r102);     // Catch: Throwable -> L108 BasePool.PoolSizeViolationException -> L110
            goto L112
        L94:
            if (HeifDecoder.mHeifDecodeLog == false) goto L96;
            Objects.toString(r127);     // Catch: Throwable -> L97
        L96:
            r103 = r129;
            r104 = r129;
            r105 = r127;
        L83:
            th = th;
            r101 = r125;
            r114 = r126;
        L105:
            r128 = 0;
            r101 = r101;
            r114 = r114;
        L85:
            th = th;
            r101 = r125;
            goto L105
        L88:
            Bitmap r130 = BitmapFactory.decodeStream(r100, null, r124);     // Catch: Throwable -> L104
            CloseableReference<Bitmap> r131 = CloseableReference.of(r130, SimpleBitmapReleaser.getInstance());     // Catch: Throwable -> L101
            r128 = 0;
            r210.setHeicCustomDecoder(0);     // Catch: Throwable -> L99
            r127 = r130;
            r129 = r131;
        L99:
            th = th;
            CloseableReference<Bitmap> r132 = r131;
        L103:
            r101 = r130;
            r114 = r132;
        L101:
            th = th;
            r128 = 0;
            r132 = r114;
        L104:
            th = th;
            goto L105
        L176:
            BitmapRegionDecoder r133 = BitmapRegionDecoder.newInstance(r111, true);     // Catch: Throwable -> L42 IOException -> L47
            Bitmap r134 = r133.decodeRegion(r112, HeifDecoder.access$600(r210, r213.bitmapConfig));     // Catch: Throwable -> L38 IOException -> L40
        L173:
            CloseableReference<Bitmap> r135 = CloseableReference.of(r134, SimpleBitmapReleaser.getInstance());     // Catch: Throwable -> L34 IOException -> L36
            BitmapRegionDecoder r136 = r133;
            Bitmap r137 = r134;
            CloseableReference<Bitmap> r138 = r135;
        L32:
            r136.recycle();     // Catch: Throwable -> L17 BasePool.PoolSizeViolationException -> L19
            BitmapRegionDecoder r139 = r136;
            Bitmap r140 = r137;
            CloseableReference<Bitmap> r141 = r138;
        L52:
            r121 = r141;
            if (r140 == null) goto L167;
            r100 = r111;
            r114 = r121;
            r102 = r139;
            r101 = r140;
            r115 = r111;
            goto L72
        L167:
            r111.reset();     // Catch: Throwable -> L61 BasePool.PoolSizeViolationException -> L63
            ?? r142 = HeifDecoder.getBitmapFactory();     // Catch: Throwable -> L61 BasePool.PoolSizeViolationException -> L63
            BitmapPool r143 = this.mBitmapPool;     // Catch: Throwable -> L61 BasePool.PoolSizeViolationException -> L63
            r100 = r111;
            BitmapFactory.Options r144 = HeifDecoder.access$100(r210, r213.bitmapConfig);     // Catch: Throwable -> L61 BasePool.PoolSizeViolationException -> L63
            r123 = r142.decodeStream(r143, r111, r112, r144, r110);     // Catch: Throwable -> L122 BasePool.PoolSizeViolationException -> L124
            if (r123 != null) goto L169;
            Bitmap r145 = null;
        L60:
            r210.setHeicCustomDecoder(1);     // Catch: Throwable -> L108 BasePool.PoolSizeViolationException -> L110
            r210.setHeifDecError(r110.getHeifDecError());     // Catch: Throwable -> L108 BasePool.PoolSizeViolationException -> L110
            r210.setHeifSizeAbnormal(r110.isSizeAbnormal());     // Catch: Throwable -> L108 BasePool.PoolSizeViolationException -> L110
            r101 = r145;
            r100 = r100;
            r102 = r142;
            r114 = r123;
            r115 = r144;
            goto L72
        L169:
            r145 = r123.get();     // Catch: Throwable -> L108 BasePool.PoolSizeViolationException -> L110
        L110:
            e = e;
        L108:
            th = th;
            goto L138
        L63:
            e = e;
        L61:
            th = th;
            r100 = r111;
            goto L123
        L36:
            e = e;
        L49:
            FLog.e("XGFrescoLog", e, "Could not decode region %s use system api.", new Object[]{r112});     // Catch: Throwable -> L66
            r136 = r133;
            r137 = r134;
            r138 = r113;
            r139 = r133;
            r140 = r134;
            r141 = r113;
            if (r133 == null) goto L52;
        L34:
            th = th;
        L44:
            FLog.e("XGFrescoLog", th, "Could not decode region %s use system api.", new Object[]{r112});     // Catch: Throwable -> L66
            r139 = r133;
            r140 = r134;
            r141 = r113;
            if (r133 == null) goto L52;
            r136 = r133;
            r137 = r134;
            r138 = r113;
        L40:
            e = e;
            r134 = null;
        L38:
            th = th;
            r134 = null;
            goto L44
        L47:
            e = e;
            r133 = null;
            r134 = null;
        L42:
            th = th;
            r133 = null;
            r134 = null;
        L66:
            th = move-exception;
            if (r118 == 0) goto L70;
            r118.recycle();     // Catch: Throwable -> L108 BasePool.PoolSizeViolationException -> L110
        L70:
            throw th;     // Catch: Throwable -> L108 BasePool.PoolSizeViolationException -> L110
        L165:
            long r146 = SystemClock.uptimeMillis();     // Catch: Throwable -> L21 BasePool.PoolSizeViolationException -> L24
            r123 = HeifDecoder.getBitmapFactory().decodeThumb(this.mBitmapPool, r111, null, null);     // Catch: Throwable -> L21 BasePool.PoolSizeViolationException -> L24
            if (r123 != null) goto L170;
            Bitmap r147 = null;
        L12:
            r118 = SystemClock.uptimeMillis() - r146;     // Catch: Throwable -> L17 BasePool.PoolSizeViolationException -> L19
            r210.setThumbDecodeDuration(r118);     // Catch: Throwable -> L17 BasePool.PoolSizeViolationException -> L19
            r111.reset();     // Catch: Throwable -> L17 BasePool.PoolSizeViolationException -> L19
            r113 = r123;
            if (r147 == null) goto L151;
            FLog.d("XGFrescoLog", "decode thumb successfully");     // Catch: Throwable -> L17 BasePool.PoolSizeViolationException -> L19
            HeifBitmap r148 = HeifDecoder.access$400(r123, ImmutableQualityInfo.FULL_QUALITY, r210.getRotationAngle(), 0, HeifDecoder.access$000(r210, r213), r210.getRegionToDecode(), r210.getSampleSize(), r210.getImageFormat());     // Catch: Throwable -> L17 BasePool.PoolSizeViolationException -> L19
            r148.setThumbCache(true);     // Catch: Throwable -> L17 BasePool.PoolSizeViolationException -> L19
            Closeables.closeQuietly(r111);
            return r148;
        L170:
            r147 = r123.get();     // Catch: Throwable -> L17 BasePool.PoolSizeViolationException -> L19
        L19:
            e = e;
        L17:
            th = th;
        L23:
            r100 = r111;
            goto L138
        L24:
            e = e;
            r123 = null;
        L21:
            th = th;
            r123 = null;
            goto L23
        L147:
            th = move-exception;
            Closeables.closeQuietly(null);
            throw th;
        L143:
            e = e;
            r123 = null;
        L136:
            th = th;
            r100 = r111;
            r123 = null;
            goto L138
        }
    }

    public HeifDecoder() {
    }

    static {
        HEIF_FORMAT = new ImageFormat("HEIF_FORMAT", "heic");
        VVIC_FORMAT = new ImageFormat("VVIC_FORMAT", "vvic");
        HEIF_FORMAT_ANIMATED = new ImageFormat("HEIF_FORMAT_ANIMATED", "heic");
        DEBUG = false;
        sBitmapFactory = new HeifBitmapFactoryV2Impl();
        sHeifWppEnable = true;
        mHeifDecodeLog = false;
    }

    public static HeifBitmapFactoryV2Impl getBitmapFactory() {
        return (HeifBitmapFactoryV2Impl) sBitmapFactory;
    }

    public static /* synthetic */ Rect access$000(EncodedImage r100, ImageDecodeOptions r101) {
        return getRegionToDecode(r100, r101);
    }

    public static /* synthetic */ BitmapFactory.Options access$100(EncodedImage r100, Bitmap.Config r101) {
        return getDecodeOptionsNoDecodeBound(r100, r101);
    }

    public static /* synthetic */ BitmapFactory.Options access$200(EncodedImage r100, Bitmap.Config r101) {
        return getDecodeOptionsHasDecodeBound(r100, r101);
    }

    public static /* synthetic */ BitmapFactory.Options access$600(EncodedImage r100, Bitmap.Config r101) {
        return getDecodeOptionsForStream(r100, r101);
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

    private static BitmapFactory.Options getDecodeOptionsHasDecodeBound(EncodedImage r100, Bitmap.Config r101) {
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

    private static BitmapFactory.Options getDecodeOptionsNoDecodeBound(EncodedImage r100, Bitmap.Config r101) {
        BitmapFactory.Options r102 = new BitmapFactory.Options();
        r102.inSampleSize = r100.getSampleSize();
        r102.inDither = true;
        r102.inPreferredConfig = r101;
        r102.inMutable = true;
        return r102;
    }

    private static Rect getRegionToDecode(EncodedImage r100, ImageDecodeOptions r101) {
        Rect r102 = r100.getRegionToDecode();
        if (r102 == null) goto L10;
        if (r101.useSmartCrop == false) goto L8;
        return r102;
    L8:
        return r101.regionToDecode;
    L10:
        return r101.regionToDecode;
    }

    public static /* synthetic */ Bitmap access$300(BitmapPool r100, Bitmap r101, EncodedImage r102) {
        return trimBitmap(r100, r101, r102);
    }

    private static Pair<Integer, Integer> calcDstWidthHeight(int r100, int r101, int r102) {
        float r103 = (r100 * r101) * (4194304.0f / r102);
        float r104 = r100 / r101;
        return new Pair(Integer.valueOf((int) Math.sqrt(r103 * r104)), Integer.valueOf((int) Math.sqrt(r103 / r104)));
    }

    private static Bitmap trimBitmap(BitmapPool r100, Bitmap r101, EncodedImage r102) {
        int r103 = r102.getWidth();
        int r104 = r102.getHeight();
        int r105 = r101.getByteCount();
        if (r105 <= 104857600) goto L6;
        FLog.w("XGFrescoLog", "Too large(" + r105 + ")bytes bitmap.  dimension: " + (r103 + "x" + r104) + " sampleSize: " + r102.getSampleSize() + " Config: " + r101.getConfig());
        Pair<Integer, Integer> r106 = calcDstWidthHeight(r103, r104, r105);
        return Bitmap.createScaledBitmap(r101, ((Integer) r106.first).intValue(), ((Integer) r106.second).intValue(), false);
    L6:
        return r101;
    }

    public static /* synthetic */ HeifBitmap access$400(CloseableReference r100, QualityInfo r101, int r102, int r103, Rect r104, Rect r105, int r106, ImageFormat r107) {
        return createHeifBitmap(r100, r101, r102, r103, r104, r105, r106, r107);
    }

    private static HeifBitmap createHeifBitmap(CloseableReference<Bitmap> r110, QualityInfo r111, int r112, int r113, Rect r114, Rect r115, int r116, ImageFormat r117) {
        HeifBitmap r100 = new HeifBitmap(r110, r111, r112, r113, r114, r115, r116, r117);     // Catch: Throwable -> L5
        r110.close();
        return r100;
    L5:
        th = move-exception;
        r110.close();
        throw th;
    }

    public static /* synthetic */ HeifBitmap access$500(CloseableReference r100, QualityInfo r101, int r102, int r103, Rect r104, Rect r105, int r106, ImageFormat r107, Map r108) {
        return createHeifBitmap(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    }

    private static HeifBitmap createHeifBitmap(CloseableReference<Bitmap> r110, QualityInfo r111, int r112, int r113, Rect r114, Rect r115, int r116, ImageFormat r117, Map<String, String> r118) {
        HeifBitmap r100 = new HeifBitmap(r110, r111, r112, r113, r114, r115, r116, r117, r118);     // Catch: Throwable -> L5
        r110.close();
        return r100;
    L5:
        th = move-exception;
        r110.close();
        throw th;
    }
}
