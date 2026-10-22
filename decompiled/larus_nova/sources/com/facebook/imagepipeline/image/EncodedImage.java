package com.facebook.imagepipeline.image;

import android.graphics.ColorSpace;
import android.graphics.Rect;
import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.common.references.SharedReference;
import com.facebook.imageformat.AlphaChecker;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imageutils.AvifFormatUtil;
import com.facebook.imageutils.BitmapUtil;
import com.facebook.imageutils.DngExifUtil;
import com.facebook.imageutils.HeifExifUtil;
import com.facebook.imageutils.HeifFormatUtil;
import com.facebook.imageutils.ImageMetaData;
import com.facebook.imageutils.JfifUtil;
import com.facebook.imageutils.WebpUtil;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class EncodedImage implements Closeable {
    public static final int DEFAULT_SAMPLE_SIZE = 1;
    public static final String REGION_TO_DECODE = "regionToDecode";
    public static final int UNKNOWN_HEIGHT = -1;
    public static final int UNKNOWN_ROTATION_ANGLE = -1;
    public static final int UNKNOWN_STREAM_SIZE = -1;
    public static final int UNKNOWN_WIDTH = -1;
    public static final String URL = "url";
    public static final String VIEW_HEIGHT = "viewHeight";
    public static final String VIEW_WIDTH = "viewWidth";
    private static boolean mOptHeifParse;
    private static boolean mUseUltimateOptHeifBitmap;

    @Nullable
    private int heicCustomDecoder;

    @Nullable
    private boolean heicSysFirst;
    private boolean isDecodeThumb;
    private boolean isHitBitmapMemoryCache;
    private boolean isHitDiskCache;
    private boolean isHitEncodeMemoryCache;
    private boolean isRequestNetwork;

    @Nullable
    private BytesRange mBytesRange;

    @Nullable
    private ColorSpace mColorSpace;
    private int mDecodeStatus;
    private int mExifOrientation;

    @Nullable
    private Map<String, String> mExtraInfo;
    private boolean mHasAlpha;
    private int mHdrType;
    private int mHeifDecError;
    private boolean mHeifSizeAbnormal;
    private int mHeight;
    private ImageFormat mImageFormat;

    @Nullable
    private final Supplier<FileInputStream> mInputStreamSupplier;
    private boolean mIs10Bit;

    @Nullable
    private final CloseableReference<PooledByteBuffer> mPooledByteBufferRef;

    @Nullable
    private Rect mRegionToDecode;
    private int mRotationAngle;
    private int mSampleSize;
    private int mStreamSize;
    private int mWidth;

    @Nullable
    private long thumbDecodeDuration;
    private int thumbHeight;
    private int thumbWidth;

    @Nullable
    private String uri;
    private int viewHeight;
    private int viewWidth;

    public static class EncodeImagePooledByteBuffer implements PooledByteBuffer, ResourceReleaser<EncodeImagePooledByteBuffer>, MemoryCacheHitTracker {
        public final CloseableReference<PooledByteBuffer> byteBufferRef;
        private boolean isHitBitmapMemoryCache;
        private boolean isHitEncodeMemoryCache;
        private Map<String, String> mExtraInfo;

        @Override // com.facebook.imagepipeline.image.MemoryCacheHitTracker
        public void hitBitmapMemoryCache() {
            setHitBitmapMemoryCache(true);
        }

        @Override // com.facebook.imagepipeline.image.MemoryCacheHitTracker
        public void hitEncodeMemoryCache() {
            setHitEncodeMemoryCache(true);
        }

        @Override // com.facebook.common.memory.PooledByteBuffer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.byteBufferRef.get().close();
        }

        @Override // com.facebook.common.memory.PooledByteBuffer
        @Nullable
        public ByteBuffer getByteBuffer() {
            return this.byteBufferRef.get().getByteBuffer();
        }

        @Override // com.facebook.common.memory.PooledByteBuffer
        public long getNativePtr() {
            return this.byteBufferRef.get().getNativePtr();
        }

        @Override // com.facebook.common.memory.PooledByteBuffer
        public boolean isClosed() {
            return this.byteBufferRef.get().isClosed();
        }

        @Override // com.facebook.common.memory.PooledByteBuffer
        public int size() {
            return this.byteBufferRef.get().size();
        }

        public Map<String, String> getExtraInfo() {
            return this.mExtraInfo;
        }

        public boolean isHitBitmapMemoryCache() {
            return this.isHitBitmapMemoryCache;
        }

        public boolean isHitEncodeMemoryCache() {
            return this.isHitEncodeMemoryCache;
        }

        public EncodeImagePooledByteBuffer(CloseableReference<PooledByteBuffer> r100) {
            this.byteBufferRef = r100;
        }

        public static /* synthetic */ boolean access$000(EncodeImagePooledByteBuffer r100) {
            return r100.isHitEncodeMemoryCache;
        }

        public static /* synthetic */ boolean access$100(EncodeImagePooledByteBuffer r100) {
            return r100.isHitBitmapMemoryCache;
        }

        @Override // com.facebook.common.memory.PooledByteBuffer
        public byte read(int r100) {
            return this.byteBufferRef.get().read(r100);
        }

        /* JADX INFO: renamed from: release, reason: avoid collision after fix types in other method */
        public void release2(EncodeImagePooledByteBuffer r100) {
            r100.byteBufferRef.close();
        }

        public void setExtraInfo(Map<String, String> r100) {
            this.mExtraInfo = r100;
        }

        public void setHitBitmapMemoryCache(boolean r100) {
            this.isHitBitmapMemoryCache = r100;
        }

        public void setHitEncodeMemoryCache(boolean r100) {
            this.isHitEncodeMemoryCache = r100;
        }

        @Override // com.facebook.common.references.ResourceReleaser
        public /* bridge */ /* synthetic */ void release(EncodeImagePooledByteBuffer r100) {
            release2(r100);
        }

        @Override // com.facebook.common.memory.PooledByteBuffer
        public int read(int r100, byte[] r101, int r102, int r103) {
            return this.byteBufferRef.get().read(r100, r101, r102, r103);
        }
    }

    public synchronized SharedReference<PooledByteBuffer> getUnderlyingReferenceTestOnly() {
        monitor-enter(this);
        CloseableReference<PooledByteBuffer> r100 = this.mPooledByteBufferRef;     // Catch: Throwable -> L10
        if (r100 == null) goto L7;
        SharedReference<PooledByteBuffer> r101 = r100.getUnderlyingReferenceTestOnly();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return r101;
    L7:
        r101 = null;
    L10:
        th = move-exception;
        throw th;
    }

    public void hitBitmapMemoryCache() {
        this.isHitEncodeMemoryCache = false;
        this.isHitBitmapMemoryCache = true;
        this.isHitDiskCache = false;
        this.isRequestNetwork = false;
    }

    public void hitDisCache() {
        this.isHitEncodeMemoryCache = false;
        this.isHitBitmapMemoryCache = false;
        this.isHitDiskCache = true;
        this.isRequestNetwork = false;
    }

    public void hitEncodeMemoryCache() {
        this.isHitEncodeMemoryCache = true;
        this.isHitBitmapMemoryCache = false;
        this.isHitDiskCache = false;
        this.isRequestNetwork = false;
    }

    public synchronized boolean isValid() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (CloseableReference.isValid(this.mPooledByteBufferRef) == true) goto L9;
        if (this.mInputStreamSupplier != null) goto L9;
        boolean r100 = false;
    L10:
        monitor-exit(this);
        return r100;
    L9:
        r100 = true;
        goto L10
    }

    public void setRequestNetwork() {
        this.isHitEncodeMemoryCache = false;
        this.isHitBitmapMemoryCache = false;
        this.isHitDiskCache = false;
        this.isRequestNetwork = true;
    }

    private boolean isCompleteForStatus() {
        int r100 = this.mDecodeStatus;
        if (r100 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 3) goto L8;
        return false;
    }

    private void parseMetaDataIfNeeded() {
        if (this.mWidth >= 0) goto L5;
    L6:
        parseMetaData();
        return;
    L5:
        if (this.mHeight < 0) goto L6;
    }

    public EncodedImage cloneOrNull() {
        Supplier<FileInputStream> r100 = this.mInputStreamSupplier;
        if (r100 == null) goto L5;
        EncodedImage r101 = new EncodedImage(r100, this.mStreamSize);
    L10:
        if (r101 == null) goto L12;
        r101.copyMetaDataFrom(this);
    L12:
        return r101;
    L5:
        CloseableReference r102 = CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
        if (r102 != null) goto L16;
        r101 = null;
    L9:
        CloseableReference.closeSafely(r102);
        goto L10
    L16:
        r101 = new EncodedImage(r102);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableReference.closeSafely(r102);
        throw th;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        CloseableReference.closeSafely(this.mPooledByteBufferRef);
    }

    public CloseableReference<PooledByteBuffer> getByteBufferRef() {
        return CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
    }

    public InputStream getInputStream() {
        Supplier<FileInputStream> r100 = this.mInputStreamSupplier;
        if (r100 != null) goto L5;
        CloseableReference r101 = CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
        if (r101 != null) goto L16;
        return null;
    L16:
        PooledByteBufferInputStream r102 = new PooledByteBufferInputStream((PooledByteBuffer) r101.get());     // Catch: Throwable -> L11
        CloseableReference.closeSafely(r101);
        return r102;
    L11:
        th = move-exception;
        CloseableReference.closeSafely(r101);
        throw th;
    L5:
        return r100.get();
    }

    public long getNativePtr() {
        return this.mPooledByteBufferRef.get().getNativePtr();
    L4:
        return -1;
    }

    public int getNativeSize() {
        return this.mPooledByteBufferRef.get().size();
    L4:
        return -1;
    }

    public int getSize() {
        CloseableReference<PooledByteBuffer> r100 = this.mPooledByteBufferRef;
        if (r100 == null) goto L9;
        if (r100.get() == null) goto L9;
        return this.mPooledByteBufferRef.get().size();
    L9:
        return this.mStreamSize;
    }

    private Pair<Integer, Integer> readAvifImageMetaData() {
        InputStream r100 = getInputStream();
    L25:
        th = move-exception;
        if (r100 == null) goto L42;
        r100.close();     // Catch: IOException -> L40
    L42:
        if (FrescoSystrace.isTracing() == false) goto L55;
        FrescoSystrace.endSection();
        throw th;
    L55:
        throw th;
    L27:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L25
        if (r100 == null) goto L34;
        r100.close();     // Catch: IOException -> L32
    L34:
        if (FrescoSystrace.isTracing() == false) goto L36;
        FrescoSystrace.endSection();
    L36:
        return null;
    L4:
        if (FrescoSystrace.isTracing() == false) goto L6;
        FrescoSystrace.beginSection("EncodedImage#readAvifImageMetaData");     // Catch: Throwable -> L25 Exception -> L27
    L6:
        int[] r101 = AvifFormatUtil.readAvifImageSize(r100);     // Catch: Throwable -> L25 Exception -> L27
        if (r101 == null) goto L17;
        this.mWidth = r101[0];     // Catch: Throwable -> L25 Exception -> L27
        this.mHeight = r101[1];     // Catch: Throwable -> L25 Exception -> L27
        int r102 = JfifUtil.transformStandarExifOrientationForAvif(r101[2]);     // Catch: Throwable -> L25 Exception -> L27
        this.mExifOrientation = r102;     // Catch: Throwable -> L25 Exception -> L27
        this.mRotationAngle = JfifUtil.getAutoRotateAngleFromOrientation(r102);     // Catch: Throwable -> L25 Exception -> L27
        Pair<Integer, Integer> r103 = new Pair(Integer.valueOf(r101[0]), Integer.valueOf(r101[1]));     // Catch: Throwable -> L25 Exception -> L27
        if (r100 == null) goto L14;
        r100.close();     // Catch: IOException -> L12
    L14:
        if (FrescoSystrace.isTracing() == false) goto L16;
        FrescoSystrace.endSection();
    L16:
        return r103;
    L17:
        if (r100 == null) goto L22;
        r100.close();     // Catch: IOException -> L20
    L22:
        if (FrescoSystrace.isTracing() == false) goto L24;
        FrescoSystrace.endSection();
    L24:
        return null;
    }

    private Pair<Integer, Integer> readHeifFormatImageSizeForSimple() {
        InputStream r100 = getInputStream();
        long r101 = getNativePtr();     // Catch: Throwable -> L29 Exception -> L31
        if (mOptHeifParse == false) goto L6;
        int[] r102 = HeifFormatUtil.readHeifFormatImageSizeForSimple(r101, getSize());     // Catch: Throwable -> L29 Exception -> L31
    L7:
        if (r102 == null) goto L26;
        this.mWidth = r102[0];     // Catch: Throwable -> L29 Exception -> L31
        this.mHeight = r102[1];     // Catch: Throwable -> L29 Exception -> L31
        if (r102[8] != 1) goto L11;
        boolean r103 = true;
    L12:
        this.mHasAlpha = r103;     // Catch: Throwable -> L29 Exception -> L31
        if (r102[9] != 10) goto L15;
        boolean r104 = true;
    L16:
        this.mIs10Bit = r104;     // Catch: Throwable -> L29 Exception -> L31
        this.mRotationAngle = JfifUtil.transformFromClockWiseToAntiClockWise(r102[2]);     // Catch: Throwable -> L29 Exception -> L31
        this.mExifOrientation = r102[10];     // Catch: Throwable -> L29 Exception -> L31
        if (r102.length < 12) goto L20;
        this.mHdrType = r102[11];     // Catch: Throwable -> L29 Exception -> L31
    L20:
        if (r102[3] != 0) goto L22;
        this.mImageFormat = HeifFormatUtil.getHeifFormatAnimated();     // Catch: Throwable -> L29 Exception -> L31
    L22:
        Pair<Integer, Integer> r105 = new Pair(Integer.valueOf(r102[0]), Integer.valueOf(r102[1]));     // Catch: Throwable -> L29 Exception -> L31
        if (r100 != null) goto L47;
    L25:
        return r105;
    L47:
        r100.close();     // Catch: IOException -> L40
        goto L25
    L15:
        r104 = false;
        goto L16
    L11:
        r103 = false;
        goto L12
    L26:
        if (r100 != null) goto L45;
        return null;
    L45:
        r100.close();     // Catch: IOException -> L41
        return null;
    L54:
        return null;
    L6:
        r102 = HeifFormatUtil.readHeifFormatImageSizeForSimple(r100);     // Catch: Throwable -> L29 Exception -> L31
    L31:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L29
        if (r100 != null) goto L45;
        return null;
    L29:
        th = move-exception;
        if (r100 != null) goto L49;
    L39:
        throw th;
    L49:
        r100.close();     // Catch: IOException -> L42
        goto L39
    }

    private ImageMetaData readImageMetaData() {
        InputStream r100 = getInputStream();     // Catch: Throwable -> L11
        ImageMetaData r101 = BitmapUtil.decodeDimensionsAndColorSpace(r100);     // Catch: Throwable -> L9
        this.mColorSpace = r101.getColorSpace();     // Catch: Throwable -> L9
        Pair<Integer, Integer> r102 = r101.getDimensions();     // Catch: Throwable -> L9
        if (r102 == null) goto L6;
        this.mWidth = ((Integer) r102.first).intValue();     // Catch: Throwable -> L9
        this.mHeight = ((Integer) r102.second).intValue();     // Catch: Throwable -> L9
    L6:
        if (r100 != null) goto L22;
    L8:
        return r101;
    L22:
        r100.close();     // Catch: IOException -> L16
    L9:
        th = th;
    L13:
        if (r100 != null) goto L20;
    L15:
        throw th;
    L20:
        r100.close();     // Catch: IOException -> L17
    L11:
        th = th;
        r100 = null;
        goto L13
    }

    private Pair<Integer, Integer> readWebPImageSize() {
        Pair<Integer, Integer> r100 = WebpUtil.getSize(getInputStream());
        if (r100 == null) goto L5;
        this.mWidth = ((Integer) r100.first).intValue();
        this.mHeight = ((Integer) r100.second).intValue();
    L5:
        return r100;
    }

    @Nullable
    public ColorSpace getColorSpace() {
        parseMetaDataIfNeeded();
        return this.mColorSpace;
    }

    public int getExifOrientation() {
        parseMetaDataIfNeeded();
        return this.mExifOrientation;
    }

    public int getHeight() {
        parseMetaDataIfNeeded();
        return this.mHeight;
    }

    public ImageFormat getImageFormat() {
        parseMetaDataIfNeeded();
        return this.mImageFormat;
    }

    public int getRotationAngle() {
        parseMetaDataIfNeeded();
        return this.mRotationAngle;
    }

    public int getWidth() {
        parseMetaDataIfNeeded();
        return this.mWidth;
    }

    public void parseMetaData() {
        ImageFormat r100 = ImageFormatChecker.getImageFormat_WrapIOException(getInputStream());
        this.mImageFormat = r100;
        if (DefaultImageFormats.isWebpFormat(r100) == false) goto L6;
        Pair<Integer, Integer> r101 = readWebPImageSize();
    L16:
        if (r100 != DefaultImageFormats.JPEG) goto L22;
        if (this.mRotationAngle != (-1)) goto L22;
        if (r101 == null) goto L35;
        int r102 = JfifUtil.getOrientation(getInputStream());
        this.mExifOrientation = r102;
        this.mRotationAngle = JfifUtil.getAutoRotateAngleFromOrientation(r102);
    L35:
        if (mUseUltimateOptHeifBitmap == true) goto L39;
        if (mOptHeifParse == true) goto L39;
    L42:
        this.mHasAlpha = AlphaChecker.hasAlpha(r100, getInputStream(), true);
    L43:
        this.mRegionToDecode = parseRegionToDecode(this.mExtraInfo);
        return;
    L39:
        if (DefaultImageFormats.isHeifFormat(r100) == true) goto L43;
        if (DefaultImageFormats.isVvifFormat(r100) == true) goto L43;
    L22:
        if (DefaultImageFormats.isHeifFormat(r100) == false) goto L27;
        if (this.mRotationAngle != (-1)) goto L27;
        int r103 = HeifExifUtil.getOrientation(getInputStream());
        this.mExifOrientation = r103;
        this.mRotationAngle = JfifUtil.getAutoRotateAngleFromOrientation(r103);
    L27:
        if (r100 != DefaultImageFormats.DNG) goto L32;
        if (this.mRotationAngle != (-1)) goto L32;
        int r104 = DngExifUtil.getOrientation(getInputStream());
        this.mExifOrientation = r104;
        this.mRotationAngle = JfifUtil.getAutoRotateAngleFromOrientation(r104);
    L32:
        if (this.mRotationAngle != (-1)) goto L35;
        this.mRotationAngle = 0;
        goto L35
    L6:
        if (DefaultImageFormats.isHeifFormat(r100) == false) goto L8;
    L14:
        r101 = readHeifFormatImageSizeForSimple();
        goto L16
    L8:
        if (DefaultImageFormats.isVvifFormat(r100) == true) goto L14;
        if (DefaultImageFormats.isAvifOrAvis(r100) == false) goto L13;
        r101 = readAvifImageMetaData();
        goto L16
    L13:
        r101 = readImageMetaData().getDimensions();
        goto L16
    }

    public static boolean isOptHeifParse() {
        return mOptHeifParse;
    }

    @Nullable
    public BytesRange getBytesRange() {
        return this.mBytesRange;
    }

    public int getDecodeStatus() {
        return this.mDecodeStatus;
    }

    @Nullable
    public Map<String, String> getExtraInfo() {
        return this.mExtraInfo;
    }

    public int getHdrType() {
        return this.mHdrType;
    }

    public int getHeicCustomDecoder() {
        return this.heicCustomDecoder;
    }

    public int getHeifDecError() {
        return this.mHeifDecError;
    }

    @Nullable
    public Rect getRegionToDecode() {
        return this.mRegionToDecode;
    }

    public int getSampleSize() {
        return this.mSampleSize;
    }

    public long getThumbDecodeDuration() {
        return this.thumbDecodeDuration;
    }

    public int getThumbHeight() {
        return this.thumbHeight;
    }

    public int getThumbWidth() {
        return this.thumbWidth;
    }

    public String getUri() {
        return this.uri;
    }

    public int getViewHeight() {
        return this.viewHeight;
    }

    public int getViewWidth() {
        return this.viewWidth;
    }

    public boolean hasAlpha() {
        return this.mHasAlpha;
    }

    public boolean is10Bit() {
        return this.mIs10Bit;
    }

    public boolean isDecodeThumb() {
        return this.isDecodeThumb;
    }

    public boolean isHeicSysFirst() {
        return this.heicSysFirst;
    }

    public int isHeifSizeAbnormal() {
        return this.mHeifSizeAbnormal ? 1 : 0;
    }

    public boolean isHitBitmapMemoryCache() {
        return this.isHitBitmapMemoryCache;
    }

    public boolean isHitDiskCache() {
        return this.isHitDiskCache;
    }

    public boolean isHitEncodeMemoryCache() {
        return this.isHitEncodeMemoryCache;
    }

    public boolean isRequestNetwork() {
        return this.isRequestNetwork;
    }

    public EncodedImage(CloseableReference<PooledByteBuffer> r100) {
        this.mImageFormat = ImageFormat.UNKNOWN;
        this.mRotationAngle = -1;
        this.mExifOrientation = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.mStreamSize = -1;
        this.mHasAlpha = true;
        this.mIs10Bit = false;
        this.mHdrType = -1;
        this.mDecodeStatus = 0;
        this.isRequestNetwork = false;
        this.isHitDiskCache = false;
        this.isHitEncodeMemoryCache = false;
        this.isHitBitmapMemoryCache = false;
        this.thumbDecodeDuration = -1;
        Preconditions.checkArgument(CloseableReference.isValid(r100));
        PooledByteBuffer r101 = r100.get();
        if ((r101 instanceof EncodeImagePooledByteBuffer) == false) goto L10;
        this.mPooledByteBufferRef = r100.clone();
        EncodeImagePooledByteBuffer r102 = (EncodeImagePooledByteBuffer) r101;
        this.mExtraInfo = r102.getExtraInfo();
        if (EncodeImagePooledByteBuffer.access$000(r102) == false) goto L8;
        hitEncodeMemoryCache();
        r102.setHitEncodeMemoryCache(false);
    L11:
        this.mInputStreamSupplier = null;
        return;
    L8:
        if (EncodeImagePooledByteBuffer.access$100(r102) == false) goto L11;
        hitBitmapMemoryCache();
        r102.setHitBitmapMemoryCache(false);
        goto L11
    L10:
        this.mPooledByteBufferRef = CloseableReference.of(new EncodeImagePooledByteBuffer(r100.clone()));
        goto L11
    }

    public static EncodedImage cloneOrNull(EncodedImage r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.cloneOrNull();
    }

    public static void closeSafely(@Nullable EncodedImage r100) {
        if (r100 == null) goto L5;
        r100.close();
        return;
    }

    public static boolean isMetaDataAvailable(EncodedImage r100) {
        if (r100.mRotationAngle >= 0) goto L5;
    L9:
        return false;
    L5:
        if (r100.mWidth < 0) goto L9;
        if (r100.mHeight < 0) goto L9;
        return true;
    }

    public static boolean isValid(@Nullable EncodedImage r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.isValid() == false) goto L6;
        return true;
    }

    private Rect parseRegionToDecode(Map<String, String> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.isEmpty() == true) goto L13;
        String r101 = r100.get("regionToDecode");
        if (r101 != null) goto L11;
        return null;
    L11:
        return Rect.unflattenFromString(r101);
    L13:
        return null;
    }

    public static void setOptHeifParse(boolean r100) {
        mOptHeifParse = r100;
    }

    public static void setUseUltimateOptHeifBitmap(boolean r100) {
        mUseUltimateOptHeifBitmap = r100;
    }

    public void copyMetaDataFrom(EncodedImage r100) {
        this.mImageFormat = r100.getImageFormat();
        this.mWidth = r100.getWidth();
        this.mHeight = r100.getHeight();
        this.mRotationAngle = r100.getRotationAngle();
        this.mExifOrientation = r100.getExifOrientation();
        this.mSampleSize = r100.getSampleSize();
        this.mStreamSize = r100.getSize();
        this.mBytesRange = r100.getBytesRange();
        this.mColorSpace = r100.getColorSpace();
        this.mHasAlpha = r100.hasAlpha();
        this.mDecodeStatus = r100.getDecodeStatus();
        this.mRegionToDecode = r100.getRegionToDecode();
        this.mExtraInfo = r100.getExtraInfo();
        this.isRequestNetwork = r100.isRequestNetwork;
        this.isHitDiskCache = r100.isHitDiskCache;
        this.isHitEncodeMemoryCache = r100.isHitEncodeMemoryCache;
        this.isHitBitmapMemoryCache = r100.isHitBitmapMemoryCache;
        this.uri = r100.uri;
        this.viewWidth = r100.viewWidth;
        this.viewHeight = r100.viewHeight;
        this.mIs10Bit = r100.is10Bit();
        this.mHdrType = r100.getHdrType();
    }

    public String getFirstBytesAsHexString(int r100) {
        CloseableReference<PooledByteBuffer> r101 = getByteBufferRef();
        if (r101 != null) goto L5;
        return "";
    L5:
        int r102 = Math.min(getSize(), r100);
        byte[] r103 = new byte[r102];
        PooledByteBuffer r104 = r101.get();     // Catch: Throwable -> L17
        if (r104 != null) goto L11;
        r101.close();
        return "";
    L11:
        r104.read(0, r103, 0, r102);     // Catch: Throwable -> L17
        r101.close();
        StringBuilder r105 = new StringBuilder(r102 * 2);
        int r106 = 0;
    L13:
        if (r106 >= r102) goto L16;
        r105.append(String.format("%02X", new Object[]{Byte.valueOf(r103[r106])}));
        r106 = r106 + 1;
        goto L13
    L16:
        return r105.toString();
    L17:
        th = move-exception;
        r101.close();
        throw th;
    }

    public boolean isCompleteAt(int r100) {
        ImageFormat r101 = this.mImageFormat;
        ImageFormat r102 = DefaultImageFormats.JPEG;
        if (r101 == r102) goto L10;
        if (r101 == DefaultImageFormats.WEBP_ANIMATED) goto L10;
        if (r101 == DefaultImageFormats.DNG) goto L10;
        return true;
    L10:
        if (this.mInputStreamSupplier == null) goto L12;
        return true;
    L12:
        Preconditions.checkNotNull(this.mPooledByteBufferRef);
        PooledByteBuffer r103 = this.mPooledByteBufferRef.get();
        ImageFormat r104 = this.mImageFormat;
        if (r104 != r102) goto L22;
        if (r103.read(r100 - 2) == (-1)) goto L17;
    L19:
        return false;
    L17:
        if (r103.read(r100 - 1) != (-39)) goto L19;
        return true;
    L22:
        if (r104 == DefaultImageFormats.WEBP_ANIMATED) goto L24;
        return true;
    L24:
        return isCompleteForStatus();
    }

    public void setBytesRange(@Nullable BytesRange r100) {
        this.mBytesRange = r100;
    }

    public void setDecodeStatus(int r100) {
        this.mDecodeStatus = r100;
    }

    public void setExifOrientation(int r100) {
        this.mExifOrientation = r100;
    }

    public void setExtraInfo(@Nullable Map<String, String> r100) {
        this.mExtraInfo = r100;
        CloseableReference<PooledByteBuffer> r101 = this.mPooledByteBufferRef;
        if (r101 != null) goto L5;
        return;
    L5:
        if ((r101.get() instanceof EncodeImagePooledByteBuffer) == false) goto L9;
        ((EncodeImagePooledByteBuffer) this.mPooledByteBufferRef.get()).setExtraInfo(r100);
        return;
    }

    public void setHeicCustomDecoder(int r100) {
        this.heicCustomDecoder = r100;
    }

    public void setHeicSysFirst(boolean r100) {
        this.heicSysFirst = r100;
    }

    public void setHeifDecError(int r100) {
        this.mHeifDecError = r100;
    }

    public void setHeifSizeAbnormal(boolean r100) {
        this.mHeifSizeAbnormal = r100;
    }

    public void setHeight(int r100) {
        this.mHeight = r100;
    }

    public void setImageFormat(ImageFormat r100) {
        this.mImageFormat = r100;
    }

    public void setIsDecodeThumb(boolean r100) {
        this.isDecodeThumb = r100;
    }

    public void setRegionToDecode(@Nullable Rect r100) {
        this.mRegionToDecode = r100;
    }

    public void setRotationAngle(int r100) {
        this.mRotationAngle = r100;
    }

    public void setSampleSize(int r100) {
        this.mSampleSize = r100;
    }

    public void setStreamSize(int r100) {
        this.mStreamSize = r100;
    }

    public void setThumbDecodeDuration(long r100) {
        this.thumbDecodeDuration = r100;
    }

    public void setThumbHeight(int r100) {
        this.thumbHeight = r100;
    }

    public void setThumbWidth(int r100) {
        this.thumbWidth = r100;
    }

    public void setUri(String r100) {
        this.uri = r100;
    }

    public void setViewHeight(int r100) {
        this.viewHeight = r100;
    }

    public void setViewWidth(int r100) {
        this.viewWidth = r100;
    }

    public void setWidth(int r100) {
        this.mWidth = r100;
    }

    public EncodedImage(Supplier<FileInputStream> r100) {
        this.mImageFormat = ImageFormat.UNKNOWN;
        this.mRotationAngle = -1;
        this.mExifOrientation = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.mStreamSize = -1;
        this.mHasAlpha = true;
        this.mIs10Bit = false;
        this.mHdrType = -1;
        this.mDecodeStatus = 0;
        this.isRequestNetwork = false;
        this.isHitDiskCache = false;
        this.isHitEncodeMemoryCache = false;
        this.isHitBitmapMemoryCache = false;
        this.thumbDecodeDuration = -1;
        Preconditions.checkNotNull(r100);
        this.mPooledByteBufferRef = null;
        this.mInputStreamSupplier = r100;
    }

    public EncodedImage(Supplier<FileInputStream> r100, int r101) {
        this(r100);
        this.mStreamSize = r101;
    }
}
