package com.facebook.imagepipeline.image;

import android.graphics.Rect;
import com.facebook.common.logging.FLog;
import com.facebook.imageformat.ImageFormat;
import java.io.Closeable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public abstract class CloseableImage implements Closeable, ImageInfo, MemoryCacheHitTracker {
    private static final String TAG = "CloseableImage";
    private static final Set<String> mImageExtrasList = null;
    private boolean isHitBitmapMemoryCache;
    private boolean isHitDiskCache;
    private boolean isHitEncodeMemoryCache;
    private boolean isRequestInternet;
    private boolean isThumbCache;
    protected CalculateColorInfo mCalculateColorInfo;
    protected Map<String, String> mExtraMap;
    private Map<String, Object> mExtras;
    private int mFileSize;
    protected ImageFormat mImageFormat;

    public CloseableImage cloneOrNull() {
        return null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public Rect getRegionToDecode() {
        return null;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public int getSampleSize() {
        return -1;
    }

    public abstract int getSizeInBytes();

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public Rect getSmartCrop() {
        return null;
    }

    public String getSourceUri() {
        return null;
    }

    @Override // com.facebook.imagepipeline.image.MemoryCacheHitTracker
    public void hitBitmapMemoryCache() {
        this.isHitBitmapMemoryCache = true;
        this.isHitEncodeMemoryCache = false;
        this.isHitDiskCache = false;
        this.isRequestInternet = false;
    }

    @Override // com.facebook.imagepipeline.image.MemoryCacheHitTracker
    public void hitEncodeMemoryCache() {
        this.isHitEncodeMemoryCache = true;
        this.isHitBitmapMemoryCache = false;
        this.isHitDiskCache = false;
        this.isRequestInternet = false;
    }

    public abstract boolean isClosed();

    public boolean isStateful() {
        return false;
    }

    public void setSourceUri(String r100) {
    }

    static {
        mImageExtrasList = new HashSet(Arrays.asList(new String[]{"is_rounded"}));
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public ImageFormat getImageFormat() {
        ImageFormat r100 = this.mImageFormat;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return ImageFormat.UNKNOWN;
    }

    public boolean isHitMemoryCache() {
        if (this.isHitEncodeMemoryCache == false) goto L5;
    L8:
        return true;
    L5:
        if (this.isHitBitmapMemoryCache == true) goto L8;
        return false;
    }

    public CloseableImage() {
        this.mExtras = new HashMap();
        this.isRequestInternet = false;
        this.isHitDiskCache = false;
        this.isHitEncodeMemoryCache = false;
        this.isHitBitmapMemoryCache = false;
    }

    public void finalize() throws Throwable {
        if (isClosed() == false) goto L5;
        return;
    L5:
        FLog.d(TAG, "finalize: %s %x still open.", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
        close();     // Catch: Throwable -> L9
        super.finalize();
        return;
    L9:
        th = move-exception;
        super.finalize();
        throw th;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public CalculateColorInfo getCalculateColorInfo() {
        return this.mCalculateColorInfo;
    }

    public Map<String, String> getExtraMap() {
        return this.mExtraMap;
    }

    public Map<String, Object> getExtras() {
        return this.mExtras;
    }

    public int getFileSize() {
        return this.mFileSize;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public QualityInfo getQualityInfo() {
        return ImmutableQualityInfo.FULL_QUALITY;
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

    public boolean isRequestInternet() {
        return this.isRequestInternet;
    }

    public boolean isThumbCache() {
        return this.isThumbCache;
    }

    public void copyImageFromTrace(EncodedImage r100) {
        this.isRequestInternet = r100.isRequestNetwork();
        this.isHitDiskCache = r100.isHitDiskCache();
        this.isHitEncodeMemoryCache = r100.isHitEncodeMemoryCache();
        this.isHitBitmapMemoryCache = r100.isHitBitmapMemoryCache();
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public void setCalculateColorInfo(CalculateColorInfo r100) {
        this.mCalculateColorInfo = r100;
    }

    public void setExtraMap(Map<String, String> r100) {
        this.mExtraMap = r100;
    }

    public void setFileSize(int r100) {
        this.mFileSize = r100;
    }

    public void setImageExtras(@Nullable Map<String, Object> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<String> r101 = mImageExtrasList.iterator();
    L6:
        if (r101.hasNext() == false) goto L11;
        String r102 = r101.next();
        Object r103 = r100.get(r102);
        if (r103 == null) goto L6;
        this.mExtras.put(r102, r103);
        goto L6
    }

    public void setImageFrom(int r100) {
        if (r100 == 0) goto L13;
        if (r100 != 1) goto L6;
        hitEncodeMemoryCache();
        return;
    L6:
        if (r100 != 2) goto L8;
        this.isHitEncodeMemoryCache = false;
        this.isHitBitmapMemoryCache = false;
        this.isHitDiskCache = true;
        this.isRequestInternet = false;
        return;
    L8:
        if (r100 != 3) goto L18;
        hitBitmapMemoryCache();
        return;
    L18:
        return;
    L13:
        this.isHitEncodeMemoryCache = false;
        this.isHitBitmapMemoryCache = false;
        this.isHitDiskCache = false;
        this.isRequestInternet = true;
    }

    public void setThumbCache(boolean r100) {
        this.isThumbCache = r100;
    }

    public void setImageExtra(String r100, Object r101) {
        if (mImageExtrasList.contains(r100) == false) goto L6;
        this.mExtras.put(r100, r101);
        return;
    }
}
