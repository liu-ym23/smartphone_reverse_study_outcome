package com.facebook.cache.disk;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.CacheKeyUtil;
import com.facebook.cache.common.MultiCacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.common.disk.DiskTrimmable;
import com.facebook.common.disk.DiskTrimmableRegistry;
import com.facebook.common.logging.FLog;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import com.facebook.common.util.SecureHashUtil;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes22.dex */
public class TTDiskStorageCache implements TTFileCache, DiskTrimmable {
    private static final long FILECACHE_SIZE_UPDATE_PERIOD_MS = 0;
    private static final long FUTURE_TIMESTAMP_THRESHOLD_MS = 0;
    private static final String SHARED_PREFS_FILENAME_PREFIX = "disk_entries_list";
    public static final int START_OF_VERSIONING = 1;
    private static final Class<?> TAG = null;
    private static final double TRIMMING_LOWER_BOUND = 0.02d;
    private static final long UNINITIALIZED = -1;
    private final CacheErrorLogger mCacheErrorLogger;
    private final CacheEventListener mCacheEventListener;
    private long mCacheSizeLastUpdateTime;
    private long mCacheSizeLimit;
    private final long mCacheSizeLimitMinimum;
    private final DiskStorageCache.CacheStats mCacheStats;
    private final Clock mClock;
    private final CountDownLatch mCountDownLatch;
    private final long mDefaultCacheSizeLimit;
    private final EntryEvictionComparatorSupplier mEntryEvictionComparatorSupplier;
    private final Object mLock;
    private final long mLowDiskSpaceCacheSizeLimit;
    final Set<String> mResourceIndex;
    private final StatFsHelper mStatFsHelper;
    private final DiskStorage mStorage;
    final Set<String> mTempResourceIndex;

    public static class CacheStats {
        private long mCount;
        private boolean mInitialized;
        private long mSize;

        public synchronized long getCount() {
            monitor-enter(this);
            long r100 = this.mCount;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r100;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized long getSize() {
            monitor-enter(this);
            long r100 = this.mSize;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r100;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized boolean isInitialized() {
            monitor-enter(this);
            boolean r100 = this.mInitialized;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r100;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized void reset() {
            monitor-enter(this);
            this.mInitialized = false;     // Catch: Throwable -> L7
            this.mCount = -1;     // Catch: Throwable -> L7
            this.mSize = -1;     // Catch: Throwable -> L7
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public CacheStats() {
            this.mInitialized = false;
            this.mSize = -1;
            this.mCount = -1;
        }

        public synchronized void increment(long r100, long r101) {
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L4:
            if (this.mInitialized == false) goto L6;
            this.mSize += r100;     // Catch: Throwable -> L8
            this.mCount += r101;     // Catch: Throwable -> L8
        L6:
            monitor-exit(this);
        }

        public synchronized void set(long r100, long r101) {
            monitor-enter(this);
            this.mCount = r101;     // Catch: Throwable -> L6
            this.mSize = r100;     // Catch: Throwable -> L6
            this.mInitialized = true;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    public static class Params {
        public final long mCacheSizeLimitMinimum;
        public final long mDefaultCacheSizeLimit;
        public final long mLowDiskSpaceCacheSizeLimit;

        public Params(long r100, long r101, long r102) {
            this.mCacheSizeLimitMinimum = r100;
            this.mLowDiskSpaceCacheSizeLimit = r101;
            this.mDefaultCacheSizeLimit = r102;
        }
    }

    static {
        TAG = TTDiskStorageCache.class;
        FUTURE_TIMESTAMP_THRESHOLD_MS = TimeUnit.HOURS.toMillis(2);
        FILECACHE_SIZE_UPDATE_PERIOD_MS = TimeUnit.MINUTES.toMillis(30);
    }

    private void maybeEvictFilesInCacheDir() throws IOException {
        Object r100 = this.mLock;
        monitor-enter(r100);
        boolean r101 = maybeUpdateFileCacheSize();     // Catch: Throwable -> L13
        updateFileCacheSizeLimit();     // Catch: Throwable -> L13
        long r102 = this.mCacheStats.getSize();     // Catch: Throwable -> L13
        if (r102 <= this.mCacheSizeLimit) goto L8;
        if (r101 == true) goto L8;
        this.mCacheStats.reset();     // Catch: Throwable -> L13
        maybeUpdateFileCacheSize();     // Catch: Throwable -> L13
    L8:
        long r103 = this.mCacheSizeLimit;     // Catch: Throwable -> L13
        if (r102 <= r103) goto L11;
        evictAboveSize((r103 * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r100);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private boolean maybeUpdateFileCacheSize() {
        long r100 = this.mClock.now();
        if (this.mCacheStats.isInitialized() == false) goto L10;
        long r101 = this.mCacheSizeLastUpdateTime;
        if (r101 == (-1)) goto L10;
        if ((r100 - r101) > FILECACHE_SIZE_UPDATE_PERIOD_MS) goto L10;
        return false;
    L10:
        maybeUpdateFileCacheSizeAndIndex();
        this.mCacheSizeLastUpdateTime = r100;
        return true;
    }

    private void maybeUpdateFileCacheSizeAndIndex() {
        long r100 = this.mClock.now();
        long r101 = FUTURE_TIMESTAMP_THRESHOLD_MS + r100;
        if (this.mResourceIndex.isEmpty() == false) goto L5;
        Set<String> r102 = this.mResourceIndex;
    L28:
        Iterator<DiskStorage.Entry> r103 = this.mStorage.getEntries().iterator();     // Catch: IOException -> L25
        long r104 = 0;
        boolean r105 = false;
        long r110 = -1;
        int r111 = 0;
        int r112 = 0;
        int r113 = 0;
    L8:
        if (r103.hasNext() == false) goto L14;
        DiskStorage.Entry r114 = r103.next();     // Catch: IOException -> L25
        r111 = r111 + 1;     // Catch: IOException -> L25
        r104 = r104 + r114.getSize();     // Catch: IOException -> L25
        if (r114.getTimestamp() <= r101) goto L12;
        r112 = r112 + 1;     // Catch: IOException -> L25
        int r106 = (int) (((long) r113) + r114.getSize());     // Catch: IOException -> L25
        r110 = Math.max(r114.getTimestamp() - r100, r110);     // Catch: IOException -> L25
        r113 = r106;
        r105 = true;
    L13:
        r101 = r101;
        goto L8
    L12:
        r102.add(r114.getId());     // Catch: IOException -> L25
        goto L13
    L14:
        if (r105 == false) goto L16;
        this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, TAG, "Future timestamp found in " + r112 + " files , with a total size of " + r113 + " bytes, and a maximum time delta of " + r110 + "ms", null);     // Catch: IOException -> L25
    L16:
        long r107 = r111;
        if (this.mCacheStats.getCount() == r107) goto L19;
    L20:
        Set<String> r108 = this.mResourceIndex;     // Catch: IOException -> L25
        if (r108 == r102) goto L23;
        r108.clear();     // Catch: IOException -> L25
        this.mResourceIndex.addAll(r102);     // Catch: IOException -> L25
    L23:
        this.mCacheStats.set(r104, r107);     // Catch: IOException -> L25
        return;
    L19:
        if (this.mCacheStats.getSize() != r104) goto L20;
        return;
    L25:
        e = move-exception;
        this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, TAG, "calcFileCacheSize: " + e.getMessage(), e);
        return;
    L5:
        r102 = new HashSet();
        goto L28
    }

    private void updateFileCacheSizeLimit() {
        if (this.mStorage.isExternal() == false) goto L5;
        StatFsHelper.StorageType r100 = StatFsHelper.StorageType.EXTERNAL;
    L7:
        if (this.mStatFsHelper.testLowDiskSpace(r100, this.mDefaultCacheSizeLimit - this.mCacheStats.getSize()) == false) goto L9;
        this.mCacheSizeLimit = this.mLowDiskSpaceCacheSizeLimit;
        return;
    L9:
        this.mCacheSizeLimit = this.mDefaultCacheSizeLimit;
        return;
    L5:
        r100 = StatFsHelper.StorageType.INTERNAL;
        goto L7
    }

    public void awaitIndex() {
        this.mCountDownLatch.await();     // Catch: InterruptedException -> L4
        return;
    L4:
        FLog.e(TAG, "Memory Index is not ready yet. ");
    }

    @Override // com.facebook.cache.disk.FileCache
    public void clearAll() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        this.mStorage.clearAll();     // Catch: Throwable -> L6 IOException -> L8
        this.mResourceIndex.clear();     // Catch: Throwable -> L6 IOException -> L8
        DiskCacheUtil.clearDiskCacheVisitCountMap();     // Catch: Throwable -> L6 IOException -> L8
    L10:
        this.mCacheStats.reset();     // Catch: Throwable -> L6
        monitor-exit(r100);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    L8:
        e = move-exception;
        this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "clearAll: " + e.getMessage(), e);     // Catch: Throwable -> L6
        goto L10
    }

    @Override // com.facebook.cache.disk.FileCache
    public long getCount() {
        return this.mCacheStats.getCount();
    }

    @Override // com.facebook.cache.disk.FileCache
    public DiskStorage.DiskDumpInfo getDumpInfo() throws IOException {
        return this.mStorage.getDumpInfo();
    }

    @Override // com.facebook.cache.disk.FileCache
    public long getSize() {
        return this.mCacheStats.getSize();
    }

    @Override // com.facebook.cache.disk.FileCache
    public boolean isEnabled() {
        return this.mStorage.isEnabled();
    }

    @Override // com.facebook.common.disk.DiskTrimmable
    public void trimToMinimum() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        maybeUpdateFileCacheSize();     // Catch: Throwable -> L18
        long r101 = this.mCacheStats.getSize();     // Catch: Throwable -> L18
        long r102 = this.mCacheSizeLimitMinimum;     // Catch: Throwable -> L18
        if (r102 > 0) goto L7;
    L16:
        monitor-exit(r100);     // Catch: Throwable -> L18
        return;
    L7:
        if (r101 <= 0) goto L16;
        if (r101 < r102) goto L16;
        double r103 = 1.0d - (r102 / r101);     // Catch: Throwable -> L18
        if (r103 <= TRIMMING_LOWER_BOUND) goto L14;
        trimBy(r103);     // Catch: Throwable -> L18
    L14:
        monitor-exit(r100);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.common.disk.DiskTrimmable
    public void trimToNothing() {
        clearAll();
    }

    public static /* synthetic */ Object access$000(TTDiskStorageCache r100) {
        return r100.mLock;
    }

    public static /* synthetic */ boolean access$100(TTDiskStorageCache r100) {
        return r100.maybeUpdateFileCacheSize();
    }

    public static /* synthetic */ DiskStorage access$200(TTDiskStorageCache r100) {
        return r100.mStorage;
    }

    public static /* synthetic */ CountDownLatch access$400(TTDiskStorageCache r100) {
        return r100.mCountDownLatch;
    }

    public static String getFirstResourceId(CacheKey r100) {
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L3:
        if ((r100 instanceof MultiCacheKey) == false) goto L7;
        return secureHashKey(((MultiCacheKey) r100).getCacheKeys().get(0));
    L7:
        return secureHashKey(r100);
    }

    private static List<String> getResourceIds(CacheKey r100) {
    L10:
        e = move-exception;
        throw new RuntimeException(e);
    L3:
        if ((r100 instanceof MultiCacheKey) == false) goto L8;
        List<CacheKey> r101 = ((MultiCacheKey) r100).getCacheKeys();     // Catch: UnsupportedEncodingException -> L10
        ArrayList r102 = new ArrayList(r101.size());     // Catch: UnsupportedEncodingException -> L10
        int r103 = 0;
    L6:
        if (r103 >= r101.size()) goto L15;
        r102.add(secureHashKey(r101.get(r103)));     // Catch: UnsupportedEncodingException -> L10
        r103 = r103 + 1;     // Catch: UnsupportedEncodingException -> L10
        goto L6
    L15:
        return r102;
    L8:
        ArrayList r104 = new ArrayList(1);     // Catch: UnsupportedEncodingException -> L10
        r104.add(secureHashKey(r100));     // Catch: UnsupportedEncodingException -> L10
        return r104;
    }

    private Collection<DiskStorage.Entry> getSortedEntries(Collection<DiskStorage.Entry> r100) {
        long r101 = this.mClock.now() + FUTURE_TIMESTAMP_THRESHOLD_MS;
        ArrayList r102 = new ArrayList(r100.size());
        ArrayList r103 = new ArrayList(r100.size());
        Iterator<DiskStorage.Entry> r104 = r100.iterator();
    L4:
        if (r104.hasNext() == false) goto L9;
        DiskStorage.Entry r105 = r104.next();
        if (r105.getTimestamp() > r101) goto L7;
        r103.add(r105);
        goto L4
    L7:
        r102.add(r105);
        goto L4
    L9:
        Collections.sort(r103, this.mEntryEvictionComparatorSupplier.get());
        r102.addAll(r103);
        return r102;
    }

    private static String secureHashKey(CacheKey r100) throws UnsupportedEncodingException {
        return SecureHashUtil.makeSHA1HashBase64(r100.toString().getBytes("UTF-8"));
    }

    private void trimBy(double r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        this.mCacheStats.reset();     // Catch: Throwable -> L6 IOException -> L8
        maybeUpdateFileCacheSize();     // Catch: Throwable -> L6 IOException -> L8
        long r102 = this.mCacheStats.getSize();     // Catch: Throwable -> L6 IOException -> L8
        evictAboveSize(r102 - ((long) (r100 * r102)), CacheEventListener.EvictionReason.CACHE_MANAGER_TRIMMED);     // Catch: Throwable -> L6 IOException -> L8
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L6
        return;
    L8:
        e = move-exception;
        this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "trimBy: " + e.getMessage(), e);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.cache.disk.FileCache
    public void clearByPercentage(Double r110) {
        Object r100 = this.mLock;
        monitor-enter(r100);
        boolean r101 = maybeUpdateFileCacheSize();     // Catch: Throwable -> L17
        updateFileCacheSizeLimit();     // Catch: Throwable -> L17
        long r102 = this.mCacheStats.getSize();     // Catch: Throwable -> L17
        if (r102 <= this.mCacheSizeLimit) goto L10;
        if (r101 == true) goto L10;
        this.mCacheStats.reset();     // Catch: Throwable -> L17
        maybeUpdateFileCacheSize();     // Catch: Throwable -> L17
    L10:
        if (r102 > ((int) (this.mCacheSizeLimit * (1.0d - r110.doubleValue())))) goto L20;
    L15:
        monitor-exit(r100);     // Catch: Throwable -> L17
        return;
    L20:
        evictAboveSize((long) (this.mCacheSizeLimit * (1.0d - r110.doubleValue())), CacheEventListener.EvictionReason.USER_FORCED);     // Catch: IOException -> L13 Throwable -> L17
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.cache.disk.FileCache
    public void clearByTimestamp(long r110) {
        Object r100 = this.mLock;
        monitor-enter(r100);
        Collection<DiskStorage.Entry> r111 = getCanClearEntriesByTimestamp(this.mStorage.getEntries(), r110);     // Catch: Throwable -> L18 IOException -> L20
        long r101 = this.mCacheStats.getSize();     // Catch: Throwable -> L18
        Iterator<DiskStorage.Entry> r112 = r111.iterator();     // Catch: IOException -> L14 Throwable -> L18
        int r113 = 0;
        long r102 = 0;
    L8:
        if (r112.hasNext() == false) goto L12;
        DiskStorage.Entry r103 = r112.next();     // Catch: IOException -> L14 Throwable -> L18
        long r104 = this.mStorage.remove(r103);     // Catch: IOException -> L14 Throwable -> L18
        this.mResourceIndex.remove(r103.getId());     // Catch: IOException -> L14 Throwable -> L18
        this.mStorage.removeConfig(r103.getId());     // Catch: IOException -> L14 Throwable -> L18
        if (r104 <= 0) goto L8;
        r113 = r113 + 1;     // Catch: IOException -> L14 Throwable -> L18
        r102 = r102 + r104;     // Catch: IOException -> L14 Throwable -> L18
        SettableCacheEvent r105 = SettableCacheEvent.obtain().setResourceId(r103.getId()).setEvictionReason(CacheEventListener.EvictionReason.USER_FORCED).setItemSize(r104).setCacheSize(r101 - r102);     // Catch: IOException -> L14 Throwable -> L18
        this.mCacheEventListener.onEviction(r105);     // Catch: IOException -> L14 Throwable -> L18
        r105.recycle();     // Catch: IOException -> L14 Throwable -> L18
        goto L8
    L12:
        this.mCacheStats.increment(-r102, -r113);     // Catch: IOException -> L14 Throwable -> L18
        this.mStorage.purgeUnexpectedResources();     // Catch: IOException -> L14 Throwable -> L18
    L16:
        monitor-exit(r100);     // Catch: Throwable -> L18
        return;
    L14:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L18
        goto L16
    L18:
        th = move-exception;
        throw th;
    L20:
        e = move-exception;
        this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "evictAboveSize: " + e.getMessage(), e);     // Catch: Throwable -> L18
    }

    @Override // com.facebook.cache.disk.FileCache
    public long clearOldEntries(long r210) {
        Object r100 = this.mLock;
        monitor-enter(r100);
        long r101 = this.mClock.now();     // Catch: Throwable -> L22 IOException -> L24
        Collection<DiskStorage.Entry> r102 = this.mStorage.getEntries();     // Catch: Throwable -> L22 IOException -> L24
        long r103 = this.mCacheStats.getSize();     // Catch: Throwable -> L22 IOException -> L24
        Iterator<DiskStorage.Entry> r104 = r102.iterator();     // Catch: Throwable -> L22 IOException -> L24
        int r105 = 0;
        long r110 = 0;
        long r111 = 0;
    L33:
    L20:
        e = e;
        long r106 = r111;
    L26:
        this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "clearOldEntries: " + e.getMessage(), e);     // Catch: Throwable -> L22
        r111 = r106;
    L27:
        monitor-exit(r100);     // Catch: Throwable -> L22
        return r111;
    L7:
        if (r104.hasNext() == false) goto L16;
        DiskStorage.Entry r112 = r104.next();     // Catch: IOException -> L20 Throwable -> L22
        long r113 = r101;
        long r107 = Math.max(1, Math.abs(r101 - r112.getTimestamp()));     // Catch: IOException -> L20 Throwable -> L22
        if (r107 < r210) goto L14;
        long r108 = this.mStorage.remove(r112);     // Catch: IOException -> L20 Throwable -> L22
        this.mResourceIndex.remove(r112.getId());     // Catch: IOException -> L20 Throwable -> L22
        if (r108 <= 0) goto L15;
        r105 = r105 + 1;     // Catch: IOException -> L20 Throwable -> L22
        r110 = r110 + r108;     // Catch: IOException -> L20 Throwable -> L22
        this.mCacheEventListener.onEviction(SettableCacheEvent.obtain().setResourceId(r112.getId()).setEvictionReason(CacheEventListener.EvictionReason.CONTENT_STALE).setItemSize(r108).setCacheSize(r103 - r110));     // Catch: IOException -> L20 Throwable -> L22
    L15:
        r101 = r113;
        goto L33
    L14:
        r111 = Math.max(r111, r107);     // Catch: IOException -> L20 Throwable -> L22
        goto L15
    L16:
        this.mStorage.purgeUnexpectedResources();     // Catch: IOException -> L20 Throwable -> L22
        if (r105 <= 0) goto L27;
        maybeUpdateFileCacheSize();     // Catch: IOException -> L20 Throwable -> L22
        this.mCacheStats.increment(-r110, -r105);     // Catch: IOException -> L20 Throwable -> L22
    L24:
        e = e;
        r106 = 0;
    L22:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.cache.disk.FileCache
    public BinaryResource getResource(CacheKey r100) {
        SettableCacheEvent r101 = SettableCacheEvent.obtain().setCacheKey(r100);
        Object r102 = this.mLock;     // Catch: IOException -> L20
        monitor-enter(r102);     // Catch: IOException -> L20
        List<String> r103 = getResourceIds(r100);     // Catch: Throwable -> L17
        int r104 = 0;
        String r105 = null;
        BinaryResource r106 = null;
    L7:
        if (r104 >= r103.size()) goto L12;
        r105 = r103.get(r104);     // Catch: Throwable -> L17
        r101.setResourceId(r105);     // Catch: Throwable -> L17
        r106 = this.mStorage.getResource(r105, r100);     // Catch: Throwable -> L17
        if (r106 != null) goto L12;
        r104 = r104 + 1;     // Catch: Throwable -> L17
    L12:
        if (r106 != null) goto L14;
        this.mCacheEventListener.onMiss(r101);     // Catch: Throwable -> L17
        this.mResourceIndex.remove(r105);     // Catch: Throwable -> L17
    L15:
        monitor-exit(r102);     // Catch: Throwable -> L17
        return r106;
    L14:
        this.mCacheEventListener.onHit(r101);     // Catch: Throwable -> L17
        this.mResourceIndex.add(r105);     // Catch: Throwable -> L17
        DiskCacheUtil.updateDiskCacheVisitCount(r105);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;     // Catch: IOException -> L20
    L20:
        e = move-exception;
        this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, TAG, "getResource", e);
        r101.setException(e);
        this.mCacheEventListener.onReadException(r101);
        return null;
    }

    @Override // com.facebook.cache.disk.FileCache
    public Map<String, String> getResourceConfig(CacheKey r100) throws IOException {
        List<String> r101 = CacheKeyUtil.getResourceIds(r100);
        Map<String, String> r102 = null;
        int r103 = 0;
    L4:
        if (r103 >= r101.size()) goto L9;
        String r104 = r101.get(r103);
        r102 = this.mStorage.getResourceConfig(r104, r100);
        if (r102 != null) goto L9;
        r103 = r103 + 1;
    L9:
        return r102;
    }

    @Override // com.facebook.cache.disk.TTFileCache
    public BinaryResource getTempResource(CacheKey r100) {
        Object r101 = this.mLock;     // Catch: IOException -> L22
        monitor-enter(r101);     // Catch: IOException -> L22
        List<String> r102 = getResourceIds(r100);     // Catch: Throwable -> L19
        int r103 = 0;
        String r104 = null;
        BinaryResource r105 = null;
    L7:
        if (r103 >= r102.size()) goto L14;
        r104 = r102.get(r103);     // Catch: Throwable -> L19
        DiskStorage r106 = this.mStorage;     // Catch: Throwable -> L19
        if ((r106 instanceof TTDiskStorage) == false) goto L11;
        r105 = ((TTDiskStorage) r106).getTempResource(r104, r100);     // Catch: Throwable -> L19
    L11:
        if (r105 != null) goto L14;
        r103 = r103 + 1;     // Catch: Throwable -> L19
    L14:
        if (r105 != null) goto L16;
        this.mTempResourceIndex.remove(r104);     // Catch: Throwable -> L19
    L17:
        monitor-exit(r101);     // Catch: Throwable -> L19
        return r105;
    L16:
        this.mTempResourceIndex.add(r104);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;     // Catch: IOException -> L22
    L22:
        return null;
    }

    @Override // com.facebook.cache.disk.FileCache
    public boolean hasKey(CacheKey r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (hasKeySync(r100) == false) goto L26;
        monitor-exit(r101);     // Catch: Throwable -> L22
        return true;
    L26:
        List<String> r102 = getResourceIds(r100);     // Catch: IOException -> L20 Throwable -> L22
        int r103 = 0;
    L11:
        if (r103 >= r102.size()) goto L18;
        String r104 = r102.get(r103);     // Catch: IOException -> L20 Throwable -> L22
        if (this.mStorage.contains(r104, r100) == true) goto L14;
        r103 = r103 + 1;     // Catch: Throwable -> L22
        goto L11
    L14:
        this.mResourceIndex.add(r104);     // Catch: IOException -> L20 Throwable -> L22
        monitor-exit(r101);     // Catch: Throwable -> L22
        return true;
        goto L21
    L18:
        monitor-exit(r101);     // Catch: Throwable -> L22
        return false;
    L21:
        return false;
    }

    @Override // com.facebook.cache.disk.FileCache
    public boolean hasKeySync(CacheKey r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        List<String> r102 = getResourceIds(r100);     // Catch: Throwable -> L15
        int r103 = 0;
    L6:
        if (r103 >= r102.size()) goto L13;
        String r104 = r102.get(r103);     // Catch: Throwable -> L15
        if (this.mResourceIndex.contains(r104) == true) goto L9;
        r103 = r103 + 1;     // Catch: Throwable -> L15
        goto L6
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L15
        return true;
    L13:
        monitor-exit(r101);     // Catch: Throwable -> L15
        return false;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.cache.disk.FileCache
    public boolean probe(CacheKey r100) {
        String r101 = null;
        Object r102 = this.mLock;     // Catch: IOException -> L26
        monitor-enter(r102);     // Catch: IOException -> L26
        List<String> r103 = getResourceIds(r100);     // Catch: Throwable -> L18
        int r104 = 0;
    L7:
        if (r104 >= r103.size()) goto L16;
        String r105 = r103.get(r104);     // Catch: Throwable -> L18
        if (this.mStorage.touch(r105, r100) == true) goto L11;
        r104 = r104 + 1;
        r101 = r105;
        goto L7
    L11:
        this.mResourceIndex.add(r105);     // Catch: Throwable -> L24
        monitor-exit(r102);     // Catch: Throwable -> L24
        return true;
    L16:
        monitor-exit(r102);     // Catch: Throwable -> L18
        return false;
    L18:
        th = move-exception;
        String r106 = r101;
        th = th;
    L20:
        monitor-exit(r102);     // Catch: Throwable -> L24
        throw th;     // Catch: IOException -> L22
    L22:
        IOException e100 = e;
    L28:
        this.mCacheEventListener.onReadException(SettableCacheEvent.obtain().setCacheKey(r100).setResourceId(r106).setException(e100));
        return false;
    L24:
        th = th;
    L26:
        e = move-exception;
        r106 = null;
        e100 = e;
        goto L28
    }

    @Override // com.facebook.cache.disk.FileCache
    public void remove(CacheKey r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        List<String> r102 = getResourceIds(r100);     // Catch: Throwable -> L9 IOException -> L11
        int r103 = 0;
    L6:
        if (r103 >= r102.size()) goto L13;
        String r104 = r102.get(r103);     // Catch: Throwable -> L9 IOException -> L11
        this.mStorage.remove(r104);     // Catch: Throwable -> L9 IOException -> L11
        this.mResourceIndex.remove(r104);     // Catch: Throwable -> L9 IOException -> L11
        r103 = r103 + 1;
        goto L6
    L13:
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L11:
        e = move-exception;
        this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.DELETE_FILE, TAG, "delete: " + e.getMessage(), e);     // Catch: Throwable -> L9
        goto L13
    }

    public static /* synthetic */ void access$300(Context r100, String r101) {
        maybeDeleteSharedPreferencesFile(r100, r101);
    }

    private void evictAboveSize(long r110, CacheEventListener.EvictionReason r210) throws IOException {
        Collection<DiskStorage.Entry> r100 = getSortedEntries(this.mStorage.getEntries());     // Catch: IOException -> L16
        long r101 = this.mCacheStats.getSize();
        long r102 = r101 - r110;
        Iterator<DiskStorage.Entry> r103 = r100.iterator();
        int r111 = 0;
        long r112 = 0;
    L6:
        if (r103.hasNext() == false) goto L14;
        DiskStorage.Entry r113 = r103.next();
        if (r112 > r102) goto L14;
        long r114 = this.mStorage.remove(r113);
        this.mResourceIndex.remove(r113.getId());
        if (r114 <= 0) goto L6;
        r111 = r111 + 1;
        r112 = r112 + r114;
        this.mCacheEventListener.onEviction(SettableCacheEvent.obtain().setResourceId(r113.getId()).setEvictionReason(r210).setItemSize(r114).setCacheSize(r101 - r112).setCacheLimit(r110));
    L14:
        this.mCacheStats.increment(-r112, -r111);
        this.mStorage.purgeUnexpectedResources();
        return;
    L16:
        e = move-exception;
        this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "evictAboveSize: " + e.getMessage(), e);
        throw e;
    }

    private Collection<DiskStorage.Entry> getCanClearEntriesByTimestamp(Collection<DiskStorage.Entry> r100, long r101) {
        ArrayList r102 = new ArrayList(r100.size());
        Iterator<DiskStorage.Entry> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        DiskStorage.Entry r104 = r103.next();
        if (r104.getTimestamp() >= r101) goto L4;
        r102.add(r104);
        goto L4
    L8:
        return r102;
    }

    private static void maybeDeleteSharedPreferencesFile(Context r100, String r101) {
        Context r102 = r100.getApplicationContext();
        StringBuilder r103 = new StringBuilder();
        r103.append(r102.getFilesDir().getParent());
        String r104 = File.separator;
        r103.append(r104);
        r103.append("shared_prefs");
        r103.append(r104);
        r103.append(SHARED_PREFS_FILENAME_PREFIX);
        r103.append(r101);
        PolarisFileWrapper r105 = new PolarisFileWrapper(r103.toString() + ".xml");
    L7:
        FLog.e(TAG, "Fail to delete SharedPreference from file system. ");
        return;
    L4:
        if (r105.exists() == false) goto L11;
        r105.delete();     // Catch: Exception -> L7
        return;
    }

    private DiskStorage.Inserter startInsert(String r100, CacheKey r101) throws IOException {
        maybeEvictFilesInCacheDir();
        return this.mStorage.insert(r100, r101);
    }

    @Override // com.facebook.cache.disk.FileCache
    public BinaryResource insert(CacheKey r100, WriterCallback r101) throws IOException {
        SettableCacheEvent r102 = SettableCacheEvent.obtain().setCacheKey(r100);
        this.mCacheEventListener.onWriteAttempt(r102);
        Object r103 = this.mLock;
        monitor-enter(r103);
        String r104 = getFirstResourceId(r100);     // Catch: Throwable -> L21
        monitor-exit(r103);     // Catch: Throwable -> L21
        r102.setResourceId(r104);
        DiskStorage.Inserter r105 = startInsert(r104, r100);     // Catch: IOException -> L18
        r105.writeData(r101, r100);     // Catch: Throwable -> L13
        BinaryResource r106 = endInsert(r105, r100, r104);     // Catch: Throwable -> L13
        r102.setItemSize(r106.size()).setCacheSize(this.mCacheStats.getSize());     // Catch: Throwable -> L13
        this.mCacheEventListener.onWriteSuccess(r102);     // Catch: Throwable -> L13
    L10:
        if (r105.cleanUp() == true) goto L12;
        FLog.e(TAG, "Failed to delete temp file");     // Catch: IOException -> L18
    L12:
        return r106;
    L13:
        th = move-exception;
        if (r105.cleanUp() == true) goto L17;
        FLog.e(TAG, "Failed to delete temp file");     // Catch: IOException -> L18
    L17:
        throw th;     // Catch: IOException -> L18
    L18:
        e = move-exception;
        r102.setException(e);
        this.mCacheEventListener.onWriteException(r102);
        FLog.e(TAG, "Failed inserting a file into the cache", e);
        throw e;
    L21:
        th = move-exception;
        throw th;
    }

    private BinaryResource endInsert(DiskStorage.Inserter r100, CacheKey r101, String r102) throws IOException {
        Object r103 = this.mLock;
        monitor-enter(r103);
        BinaryResource r104 = r100.commit(r101);     // Catch: Throwable -> L7
        this.mResourceIndex.add(r102);     // Catch: Throwable -> L7
        this.mCacheStats.increment(r104.size(), 1);     // Catch: Throwable -> L7
        DiskCacheUtil.newDiskCacheVisitCount(r102);     // Catch: Throwable -> L7
        monitor-exit(r103);     // Catch: Throwable -> L7
        return r104;
    L7:
        th = move-exception;
        throw th;
    }

    private DiskStorage.Inserter startTempInsert(String r100, CacheKey r101, int r102) throws IOException {
        maybeEvictFilesInCacheDir();
        DiskStorage r103 = this.mStorage;
        if ((r103 instanceof TTDiskStorage) == true) goto L5;
        return null;
    L5:
        return ((TTDiskStorage) r103).insertTemp(r100, r102, r101);
    }

    public BinaryResource insertTempSync(CacheKey r100, WriterCallback r101, int r102, boolean r103) throws IOException {
        Object r104 = this.mLock;
        monitor-enter(r104);
        String r105 = getFirstResourceId(r100);     // Catch: Throwable -> L14
        monitor-exit(r104);     // Catch: Throwable -> L14
        DiskStorage.Inserter r106 = startTempInsert(r105, r100, r102);     // Catch: IOException -> L17
        if (r106 == null) goto L22;
        r106.writeData(r101, r100);     // Catch: IOException -> L17
        if (r103 == false) goto L23;
        return endInsert(r106, r100, r105);
    L23:
        return null;
    L22:
        return null;
    L24:
        return null;
    L14:
        th = move-exception;
        throw th;
    }

    public TTDiskStorageCache(DiskStorage r100, EntryEvictionComparatorSupplier r101, DiskStorageCache.Params r102, CacheEventListener r103, CacheErrorLogger r104, DiskTrimmableRegistry r105, final Context r106) {
        this.mCountDownLatch = new CountDownLatch(1);
        this.mLock = new Object();
        this.mLowDiskSpaceCacheSizeLimit = r102.mLowDiskSpaceCacheSizeLimit;
        long r107 = r102.mDefaultCacheSizeLimit;
        this.mDefaultCacheSizeLimit = r107;
        this.mCacheSizeLimit = r107;
        this.mStatFsHelper = StatFsHelper.getInstance();
        this.mStorage = r100;
        this.mEntryEvictionComparatorSupplier = r101;
        this.mCacheSizeLastUpdateTime = -1;
        this.mCacheEventListener = r103;
        this.mCacheSizeLimitMinimum = r102.mCacheSizeLimitMinimum;
        this.mCacheErrorLogger = r104;
        this.mCacheStats = new DiskStorageCache.CacheStats();
        if (r105 == null) goto L5;
        r105.registerDiskTrimmable(this);
    L5:
        this.mClock = SystemClock.get();
        this.mResourceIndex = new HashSet();
        this.mTempResourceIndex = new HashSet();
        PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("TTDiskStorageCache")).execute(new AnonymousClass1(this, r106));
    }
}
