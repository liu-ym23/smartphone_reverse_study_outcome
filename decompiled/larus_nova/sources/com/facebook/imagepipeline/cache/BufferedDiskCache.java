package com.facebook.imagepipeline.cache;

import bolts.Task;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.DiskWrapperCacheKey;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class BufferedDiskCache {
    private static final Class<?> TAG = null;
    private final FileCache mFileCache;
    private final ImageCacheStatsTracker mImageCacheStatsTracker;
    private boolean mNeedEncrypt;
    private boolean mNeedMD5;
    private final PooledByteBufferFactory mPooledByteBufferFactory;
    private final PooledByteStreams mPooledByteStreams;
    private final Executor mReadExecutor;
    private final StagingArea mStagingArea;
    private final Executor mWriteExecutor;

    static {
        TAG = BufferedDiskCache.class;
    }

    public Task<Void> clearAll() {
        this.mStagingArea.clearAll();
        return Task.call(new AnonymousClass6(this), this.mWriteExecutor);
    L5:
        e = move-exception;
        FLog.w(TAG, e, "Failed to schedule disk-cache clear", new Object[0]);
        return Task.forError(e);
    }

    public static /* synthetic */ Class access$200() {
        return TAG;
    }

    public boolean getNeedEncrypt() {
        return this.mNeedEncrypt;
    }

    public boolean getNeedMD5() {
        return this.mNeedMD5;
    }

    public StagingArea getStagingArea() {
        return this.mStagingArea;
    }

    public static /* synthetic */ StagingArea access$100(BufferedDiskCache r100) {
        return r100.mStagingArea;
    }

    public static /* synthetic */ boolean access$1000(BufferedDiskCache r100) {
        return r100.mNeedEncrypt;
    }

    public static /* synthetic */ PooledByteStreams access$1300(BufferedDiskCache r100) {
        return r100.mPooledByteStreams;
    }

    public static /* synthetic */ ImageCacheStatsTracker access$300(BufferedDiskCache r100) {
        return r100.mImageCacheStatsTracker;
    }

    public static /* synthetic */ FileCache access$400(BufferedDiskCache r100) {
        return r100.mFileCache;
    }

    public static /* synthetic */ boolean access$500(BufferedDiskCache r100) {
        return r100.mNeedMD5;
    }

    private boolean checkInStagingAreaAndFileCache(CacheKey r100) {
        EncodedImage r101 = this.mStagingArea.get(r100);
        if (r101 == null) goto L6;
        r101.close();
        FLog.v(TAG, "Found image for %s in staging area", r100.getUriString());
        this.mImageCacheStatsTracker.onStagingAreaHit(r100);
        return true;
    L6:
        FLog.v(TAG, "Did not find image for %s in staging area", r100.getUriString());
        this.mImageCacheStatsTracker.onStagingAreaMiss();
        return this.mFileCache.hasKey(r100);
    L9:
        return false;
    }

    private Task<Boolean> containsAsync(final CacheKey r100) {
        return Task.call(new AnonymousClass1(this, r100), this.mReadExecutor);
    L4:
        e = move-exception;
        FLog.w(TAG, e, "Failed to schedule disk-cache read for %s", new Object[]{r100.getUriString()});
        return Task.forError(e);
    }

    private PooledByteBuffer readFromDiskCache(CacheKey r100) throws Exception {
        Class<?> r101 = TAG;     // Catch: Exception -> L18
        FLog.v(r101, "Disk cache read for %s needEncrypt = %s", r100.getUriString(), Boolean.valueOf(this.mNeedEncrypt));     // Catch: Exception -> L18
        BinaryResource r102 = this.mFileCache.getResource(r100);     // Catch: Exception -> L18
        PooledByteBuffer r103 = null;
        if (r102 != null) goto L6;
        FLog.v(r101, "Disk cache miss for %s", r100.getUriString());     // Catch: Exception -> L18
        this.mImageCacheStatsTracker.onDiskCacheMiss();     // Catch: Exception -> L18
        return null;
    L6:
        FLog.v(r101, "Found entry in disk cache for %s", r100.getUriString());     // Catch: Exception -> L18
        this.mImageCacheStatsTracker.onDiskCacheHit(r100);     // Catch: Exception -> L18
        InputStream r104 = r102.openStream();     // Catch: Exception -> L18
    L15:
        th = move-exception;
        r104.close();     // Catch: Exception -> L18
        throw th;     // Catch: Exception -> L18
    L8:
        if (this.mNeedEncrypt == false) goto L12;
        byte[] r105 = ImageDiskEncryptUtils.decryptBytes(r104);     // Catch: Throwable -> L15
        if (r105 == null) goto L13;
        r103 = this.mPooledByteBufferFactory.newByteBuffer(r105);     // Catch: Throwable -> L15
    L13:
        r104.close();     // Catch: Exception -> L18
        FLog.v(r101, "Successful read from disk cache for %s needEncrypt = %s", r100.getUriString(), Boolean.valueOf(this.mNeedEncrypt));     // Catch: Exception -> L18
        return r103;
    L12:
        r103 = this.mPooledByteBufferFactory.newByteBuffer(r104, (int) r102.size());     // Catch: Throwable -> L15
    L18:
        e = move-exception;
        FLog.w(TAG, e, "Exception reading from cache for %s needEncrypt = %s", new Object[]{r100.getUriString(), Boolean.valueOf(this.mNeedEncrypt)});
        this.mImageCacheStatsTracker.onDiskCacheGetFail();
        throw e;
    }

    private PooledByteBuffer readFromMainDiskCache(CacheKey r100) throws Exception {
        Class<?> r101 = TAG;     // Catch: Exception -> L21
        FLog.v(r101, "fall back main Disk cache read for %s needEncrypt = %s", r100.getUriString(), Boolean.valueOf(this.mNeedEncrypt));     // Catch: Exception -> L21
        FileCache r102 = FrescoCacheMonitorUtil.getMainFileCache();     // Catch: Exception -> L21
        PooledByteBuffer r103 = null;
        if (r102 != null) goto L5;
        return null;
    L5:
        BinaryResource r104 = r102.getResource(r100);     // Catch: Exception -> L21
        if (r104 != null) goto L9;
        FLog.v(r101, "Disk cache miss for %s", r100.getUriString());     // Catch: Exception -> L21
        this.mImageCacheStatsTracker.onDiskCacheMiss();     // Catch: Exception -> L21
        return null;
    L9:
        FLog.v(r101, "Found entry in disk cache for %s", r100.getUriString());     // Catch: Exception -> L21
        this.mImageCacheStatsTracker.onDiskCacheHit(r100);     // Catch: Exception -> L21
        InputStream r105 = r104.openStream();     // Catch: Exception -> L21
    L18:
        th = move-exception;
        r105.close();     // Catch: Exception -> L21
        throw th;     // Catch: Exception -> L21
    L11:
        if (this.mNeedEncrypt == false) goto L15;
        byte[] r106 = ImageDiskEncryptUtils.decryptBytes(r105);     // Catch: Throwable -> L18
        if (r106 == null) goto L16;
        r103 = this.mPooledByteBufferFactory.newByteBuffer(r106);     // Catch: Throwable -> L18
    L16:
        r105.close();     // Catch: Exception -> L21
        FLog.v(r101, "Successful read from disk cache for %s needEncrypt = %s", r100.getUriString(), Boolean.valueOf(this.mNeedEncrypt));     // Catch: Exception -> L21
        return r103;
    L15:
        r103 = this.mPooledByteBufferFactory.newByteBuffer(r105, (int) r104.size());     // Catch: Throwable -> L18
    L21:
        e = move-exception;
        FLog.w(TAG, e, "Exception reading from cache for %s needEncrypt = %s", new Object[]{r100.getUriString(), Boolean.valueOf(this.mNeedEncrypt)});
        this.mImageCacheStatsTracker.onDiskCacheGetFail();
        throw e;
    }

    public Task<Void> clearByPercentage(final Double r100) {
        return Task.call(new AnonymousClass7(this, r100), this.mWriteExecutor);
    L4:
        e = move-exception;
        FLog.w(TAG, e, "clearByPercentage, Failed to schedule disk-cache clear", new Object[0]);
        return Task.forError(e);
    }

    public Task<Void> clearByTimestamp(final long r100) {
        return Task.call(new AnonymousClass8(this, r100), this.mWriteExecutor);
    L4:
        e = move-exception;
        FLog.w(TAG, e, "clearByTimestamp, Failed to schedule disk-cache clear", new Object[0]);
        return Task.forError(e);
    }

    public Task<Boolean> contains(CacheKey r100) {
        if (containsSync(r100) == false) goto L7;
        return Task.forResult(Boolean.TRUE);
    L7:
        return containsAsync(r100);
    }

    public boolean containsSync(CacheKey r100) {
        if (this.mStagingArea.containsKey(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mFileCache.hasKeySync(r100) == true) goto L8;
        return false;
    }

    public boolean diskCheckSync(CacheKey r100) {
        if (containsSync(r100) == false) goto L7;
        return true;
    L7:
        return checkInStagingAreaAndFileCache(r100);
    }

    public Task<Void> remove(final CacheKey r100) {
        Preconditions.checkNotNull(r100);
        this.mStagingArea.remove(r100);
        return Task.call(new AnonymousClass5(this, r100), this.mWriteExecutor);
    L5:
        e = move-exception;
        FLog.w(TAG, e, "Failed to schedule disk-cache remove for %s", new Object[]{r100.getUriString()});
        return Task.forError(e);
    }

    public void setNeedEncrypt(boolean r100) {
        this.mNeedEncrypt = r100;
    }

    public void setNeedMD5(boolean r100) {
        this.mNeedMD5 = r100;
    }

    public static /* synthetic */ boolean access$000(BufferedDiskCache r100, CacheKey r101) {
        return r100.checkInStagingAreaAndFileCache(r101);
    }

    public static /* synthetic */ PooledByteBuffer access$700(BufferedDiskCache r100, CacheKey r101) throws Exception {
        return r100.readFromDiskCache(r101);
    }

    public static /* synthetic */ PooledByteBuffer access$900(BufferedDiskCache r100, CacheKey r101) throws Exception {
        return r100.readFromMainDiskCache(r101);
    }

    private Task<EncodedImage> foundPinnedImage(CacheKey r100, EncodedImage r101) {
        FLog.v(TAG, "Found image for %s in staging area", r100.getUriString());
        this.mImageCacheStatsTracker.onStagingAreaHit(r100);
        return Task.forResult(r101);
    }

    private Task<EncodedImage> getAsync(final CacheKey r100, final AtomicBoolean r101) {
        return Task.call(new AnonymousClass2(this, r101, r100), this.mReadExecutor);
    L4:
        e = move-exception;
        FLog.w(TAG, e, "Failed to schedule disk-cache read for %s", new Object[]{r100.getUriString()});
        return Task.forError(e);
    }

    private PooledByteBuffer readFromDiskCacheAndCompareMD5(CacheKey r100, String r101) throws IOException {
        Class<?> r102 = TAG;     // Catch: IOException -> L16
        FLog.v(r102, "Disk cache read for %s, compare to md5:%s", r100.getUriString(), r101);     // Catch: IOException -> L16
        BinaryResource r103 = this.mFileCache.getResource(r100);     // Catch: IOException -> L16
        if (r103 != null) goto L6;
        FLog.v(r102, "Disk cache miss for %s", r100.getUriString());     // Catch: IOException -> L16
        this.mImageCacheStatsTracker.onDiskCacheMiss();     // Catch: IOException -> L16
        return null;
    L6:
        FLog.v(r102, "Found entry in disk cache for %s", r100.getUriString());     // Catch: IOException -> L16
        this.mImageCacheStatsTracker.onDiskCacheHit(r100);     // Catch: IOException -> L16
        InputStream r104 = r103.openStream();     // Catch: IOException -> L16
        PooledByteBuffer r105 = this.mPooledByteBufferFactory.newByteBuffer(r104, (int) r103.size(), r101);     // Catch: Throwable -> L13
        r104.close();     // Catch: IOException -> L16
        if (r105 != null) goto L11;
        FLog.v(r102, "Failed read from disk cache or MD5 did not match for %s", r100.getUriString());     // Catch: IOException -> L16
        this.mImageCacheStatsTracker.onDiskCacheMiss();     // Catch: IOException -> L16
    L12:
        return r105;
    L11:
        FLog.v(r102, "Successful read from disk cache for %s", r100.getUriString());     // Catch: IOException -> L16
        this.mImageCacheStatsTracker.onDiskCacheHit(r100);     // Catch: IOException -> L16
        goto L12
    L13:
        th = move-exception;
        r104.close();     // Catch: IOException -> L16
        throw th;     // Catch: IOException -> L16
    L16:
        e = move-exception;
        FLog.w(TAG, e, "Exception reading from cache for %s", new Object[]{r100.getUriString()});
        this.mImageCacheStatsTracker.onDiskCacheGetFail();
        throw e;
    }

    private PooledByteBuffer readFromMainDiskCacheAndCompareMD5(CacheKey r100, String r101) throws IOException {
        Class<?> r102 = TAG;     // Catch: IOException -> L19
        FLog.v(r102, "fall back main Disk cache read for %s, compare to md5:%s", r100.getUriString(), r101);     // Catch: IOException -> L19
        FileCache r103 = FrescoCacheMonitorUtil.getMainFileCache();     // Catch: IOException -> L19
        if (r103 != null) goto L5;
        return null;
    L5:
        BinaryResource r104 = r103.getResource(r100);     // Catch: IOException -> L19
        if (r104 != null) goto L9;
        FLog.v(r102, "Disk cache miss for %s", r100.getUriString());     // Catch: IOException -> L19
        this.mImageCacheStatsTracker.onDiskCacheMiss();     // Catch: IOException -> L19
        return null;
    L9:
        FLog.v(r102, "Found entry in disk cache for %s", r100.getUriString());     // Catch: IOException -> L19
        this.mImageCacheStatsTracker.onDiskCacheHit(r100);     // Catch: IOException -> L19
        InputStream r105 = r104.openStream();     // Catch: IOException -> L19
        PooledByteBuffer r106 = this.mPooledByteBufferFactory.newByteBuffer(r105, (int) r104.size(), r101);     // Catch: Throwable -> L16
        r105.close();     // Catch: IOException -> L19
        if (r106 != null) goto L14;
        FLog.v(r102, "Failed read from disk cache or MD5 did not match for %s", r100.getUriString());     // Catch: IOException -> L19
        this.mImageCacheStatsTracker.onDiskCacheMiss();     // Catch: IOException -> L19
    L15:
        return r106;
    L14:
        FLog.v(r102, "Successful read from disk cache for %s", r100.getUriString());     // Catch: IOException -> L19
        this.mImageCacheStatsTracker.onDiskCacheHit(r100);     // Catch: IOException -> L19
        goto L15
    L16:
        th = move-exception;
        r105.close();     // Catch: IOException -> L19
        throw th;     // Catch: IOException -> L19
    L19:
        e = move-exception;
        FLog.w(TAG, e, "Exception reading from cache for %s", new Object[]{r100.getUriString()});
        this.mImageCacheStatsTracker.onDiskCacheGetFail();
        throw e;
    }

    private void writeToDiskCache(CacheKey r100, final EncodedImage r101) {
        Class<?> r102 = TAG;
        FLog.v(r102, "About to write to disk-cache for key %s", r100.getUriString());
        this.mFileCache.insert(new DiskWrapperCacheKey(r100, r101.getExtraInfo()), new AnonymousClass9(this, r101));     // Catch: IOException -> L5
        FLog.v(r102, "Successful disk-cache write for key %s", r100.getUriString());     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        FLog.w(TAG, e, "Failed to write to disk-cache for key %s", new Object[]{r100.getUriString()});
    }

    private void writeToDiskCacheEncrypt(CacheKey r100, EncodedImage r101) {
        FLog.v(TAG, "About to write to disk-cache encrypt for key %s", r100.getUriString());
        EncodedImage r102 = null;
        byte[] r103 = ImageDiskEncryptUtils.encryptByte(r101.getInputStream());     // Catch: Throwable -> L13 Exception -> L15
        if (r103 == null) goto L12;
        EncodedImage r104 = new EncodedImage(CloseableReference.of(this.mPooledByteBufferFactory.newByteBuffer(r103)));     // Catch: Throwable -> L13 Exception -> L15
        r104.copyMetaDataFrom(r101);     // Catch: Throwable -> L8 Exception -> L10
        writeToDiskCache(r100, r104);     // Catch: Throwable -> L8 Exception -> L10
        r102 = r104;
        goto L12
    L10:
        e = e;
        r102 = r104;
    L16:
        FLog.w(TAG, e, "Failed to write to disk-cache encrypt for key %s", new Object[]{r100.getUriString()});     // Catch: Throwable -> L13
    L8:
        th = th;
        r102 = r104;
    L19:
        EncodedImage.closeSafely(r102);
        throw th;
    L12:
        EncodedImage.closeSafely(r102);
        return;
    L15:
        e = e;
    L13:
        th = th;
        goto L19
    }

    public Task<EncodedImage> get(CacheKey r100, AtomicBoolean r101) {
    L25:
        th = move-exception;
        if (FrescoSystrace.isTracing() == false) goto L29;
        FrescoSystrace.endSection();
    L29:
        throw th;
    L3:
        if (FrescoSystrace.isTracing() == false) goto L5;
        FrescoSystrace.beginSection("BufferedDiskCache#get");     // Catch: Throwable -> L25
    L5:
        EncodedImage r102 = this.mStagingArea.get(r100);     // Catch: Throwable -> L25
        if (r102 == null) goto L8;
    L14:
        if (r102 == null) goto L20;
        Task<EncodedImage> r103 = foundPinnedImage(r100, r102);     // Catch: Throwable -> L25
        if (FrescoSystrace.isTracing() == false) goto L19;
        FrescoSystrace.endSection();
    L19:
        return r103;
    L20:
        Task<EncodedImage> r104 = getAsync(r100, r101);     // Catch: Throwable -> L25
        if (FrescoSystrace.isTracing() == false) goto L24;
        FrescoSystrace.endSection();
    L24:
        return r104;
    L8:
        if (FrescoCacheMonitorUtil.isFallBackMainDisk() == false) goto L14;
        if (FrescoCacheMonitorUtil.getMainStagingArea() == this.mStagingArea) goto L14;
        StagingArea r105 = FrescoCacheMonitorUtil.getMainStagingArea();     // Catch: Throwable -> L25
        if (r105 == null) goto L14;
        r102 = r105.get(r100);     // Catch: Throwable -> L25
        goto L14
    }

    public void put(final CacheKey r100, EncodedImage r101) {
    L19:
        th = move-exception;
        if (FrescoSystrace.isTracing() == false) goto L23;
        FrescoSystrace.endSection();
    L23:
        throw th;
    L3:
        if (FrescoSystrace.isTracing() == false) goto L5;
        FrescoSystrace.beginSection("BufferedDiskCache#put");     // Catch: Throwable -> L19
    L5:
        Preconditions.checkNotNull(r100);     // Catch: Throwable -> L19
        Preconditions.checkArgument(EncodedImage.isValid(r101));     // Catch: Throwable -> L19
        this.mStagingArea.put(r100, r101);     // Catch: Throwable -> L19
        final EncodedImage r102 = EncodedImage.cloneOrNull(r101);     // Catch: Throwable -> L19
    L13:
        e = move-exception;
        FLog.w(TAG, e, "Failed to schedule disk-cache write for %s", new Object[]{r100.getUriString()});     // Catch: Throwable -> L19
        this.mStagingArea.remove(r100, r101);     // Catch: Throwable -> L19
        EncodedImage.closeSafely(r102);     // Catch: Throwable -> L19
    L16:
        if (FrescoSystrace.isTracing() == false) goto L29;
        FrescoSystrace.endSection();
        return;
    L29:
        return;
    L7:
        if (FrescoCacheMonitorUtil.isDelayWriteDisk() == true) goto L9;
    L11:
        this.mWriteExecutor.execute(new AnonymousClass4(this, r100, r102));     // Catch: Exception -> L13 Throwable -> L19
    L24:
    L9:
        if (FrescoCacheMonitorUtil.getNewIoBoundExecutor() == null) goto L11;
        FrescoCacheMonitorUtil.getNewIoBoundExecutor().schedule(new AnonymousClass3(this, r100, r102), FrescoCacheMonitorUtil.getDelayTime(), TimeUnit.MILLISECONDS);     // Catch: Exception -> L13 Throwable -> L19
        goto L24
    }

    public static /* synthetic */ void access$1100(BufferedDiskCache r100, CacheKey r101, EncodedImage r102) {
        r100.writeToDiskCacheEncrypt(r101, r102);
    }

    public static /* synthetic */ void access$1200(BufferedDiskCache r100, CacheKey r101, EncodedImage r102) {
        r100.writeToDiskCache(r101, r102);
    }

    public static /* synthetic */ PooledByteBuffer access$600(BufferedDiskCache r100, CacheKey r101, String r102) throws IOException {
        return r100.readFromDiskCacheAndCompareMD5(r101, r102);
    }

    public static /* synthetic */ PooledByteBuffer access$800(BufferedDiskCache r100, CacheKey r101, String r102) throws IOException {
        return r100.readFromMainDiskCacheAndCompareMD5(r101, r102);
    }

    public BufferedDiskCache(FileCache r100, PooledByteBufferFactory r101, PooledByteStreams r102, Executor r103, Executor r104, ImageCacheStatsTracker r105) {
        this.mFileCache = r100;
        this.mPooledByteBufferFactory = r101;
        this.mPooledByteStreams = r102;
        this.mReadExecutor = r103;
        this.mWriteExecutor = r104;
        this.mImageCacheStatsTracker = r105;
        this.mStagingArea = StagingArea.getInstance();
    }
}
