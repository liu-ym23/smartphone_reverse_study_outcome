package com.facebook.cache.disk;

import android.content.Context;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.CacheKeyUtil;
import com.facebook.cache.common.MultiCacheEventListener;
import com.facebook.cache.common.WriterCallback;
import com.facebook.common.disk.DiskTrimmable;
import com.facebook.common.disk.DiskTrimmableRegistry;
import com.facebook.common.logging.FLog;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class DiskStorageCache implements FileCache, DiskTrimmable {
    public static final float DEFAULT_EVICT_RATIO = 0.1f;
    private static final long FILECACHE_SIZE_UPDATE_PERIOD_MS = 0;
    private static final long FUTURE_TIMESTAMP_THRESHOLD_MS = 0;
    private static final String SHARED_PREFS_FILENAME_PREFIX = "disk_entries_list";
    public static final int START_OF_VERSIONING = 1;
    private static final Class<?> TAG = null;
    private static final double TRIMMING_LOWER_BOUND = 0.02d;
    private static final long UNINITIALIZED = -1;
    private static boolean mOptDiskCacheWrite;
    private static boolean mOptimizeHasKey;
    private final CacheErrorLogger mCacheErrorLogger;
    private final MultiCacheEventListener mCacheEventListener;
    private long mCacheSizeLastUpdateTime;
    private long mCacheSizeLimit;
    private final long mCacheSizeLimitMinimum;
    private final CacheStats mCacheStats;
    private final Clock mClock;
    private final CountDownLatch mCountDownLatch;
    private final long mDefaultCacheSizeLimit;
    private final EntryEvictionComparatorSupplier mEntryEvictionComparatorSupplier;
    private float mEvictRatio;
    private final boolean mIndexPopulateAtStartupEnabled;
    private boolean mIndexReady;
    private final Object mLock;
    private final long mLowDiskSpaceCacheSizeLimit;
    final Set<String> mResourceIndex;
    private final StatFsHelper mStatFsHelper;
    private final DiskStorage mStorage;

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
        TAG = DiskStorageCache.class;
        FUTURE_TIMESTAMP_THRESHOLD_MS = TimeUnit.HOURS.toMillis(2);
        FILECACHE_SIZE_UPDATE_PERIOD_MS = TimeUnit.MINUTES.toMillis(30);
        mOptimizeHasKey = false;
        mOptDiskCacheWrite = false;
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
        evictAboveSize((long) (r103 * (1.0f - this.mEvictRatio)), CacheEventListener.EvictionReason.CACHE_FULL);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r100);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private boolean maybeUpdateFileCacheSize() {
        long r100 = this.mClock.now();
        if (mOptDiskCacheWrite == false) goto L13;
        if (this.mCacheStats.isInitialized() == false) goto L11;
        if (this.mCacheSizeLastUpdateTime == (-1)) goto L11;
        return false;
    L11:
        return maybeUpdateFileCacheSizeAndIndex();
    L13:
        if (this.mCacheStats.isInitialized() == false) goto L21;
        long r101 = this.mCacheSizeLastUpdateTime;
        if (r101 == (-1)) goto L21;
        if ((r100 - r101) > FILECACHE_SIZE_UPDATE_PERIOD_MS) goto L21;
        return false;
    L21:
        return maybeUpdateFileCacheSizeAndIndex();
    }

    private boolean maybeUpdateFileCacheSizeAndIndex() {
        long r100 = this.mClock.now();
        long r101 = FUTURE_TIMESTAMP_THRESHOLD_MS + r100;
        if (this.mIndexPopulateAtStartupEnabled == false) goto L8;
        if (this.mResourceIndex.isEmpty() == false) goto L8;
        Set<String> r102 = this.mResourceIndex;
    L52:
    L49:
        e = move-exception;
        this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, TAG, "calcFileCacheSize: " + e.getMessage(), e);
        return false;
    L12:
        if (mOptDiskCacheWrite == false) goto L14;
        Collection<DiskStorage.Entry> r103 = this.mStorage.getDiskCacheEntries();     // Catch: IOException -> L49
    L15:
        Iterator<DiskStorage.Entry> r104 = r103.iterator();     // Catch: IOException -> L49
        long r110 = 0;
        long r111 = -1;
        int r105 = 0;
        int r106 = 0;
        boolean r112 = false;
        int r113 = 0;
    L17:
        if (r104.hasNext() == false) goto L30;
        DiskStorage.Entry r114 = r104.next();     // Catch: IOException -> L49
        if (mOptDiskCacheWrite == false) goto L23;
        if (r114.isContentFile() == false) goto L17;
    L23:
        r113 = r113 + 1;     // Catch: IOException -> L49
        r110 = r110 + r114.getSize();     // Catch: IOException -> L49
        if (r114.getTimestamp() <= r101) goto L26;
        r106 = r106 + 1;     // Catch: IOException -> L49
        long r115 = r101;
        r105 = (int) (((long) r105) + r114.getSize());     // Catch: IOException -> L49
        r111 = Math.max(r114.getTimestamp() - r100, r111);     // Catch: IOException -> L49
        r112 = true;
    L29:
        r101 = r115;
        goto L17
    L26:
        r115 = r101;
        if (this.mIndexPopulateAtStartupEnabled == false) goto L29;
        r102.add(r114.getId());     // Catch: IOException -> L49
        goto L29
    L30:
        if (r112 == false) goto L33;
        this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, TAG, "Future timestamp found in " + r106 + " files , with a total size of " + r105 + " bytes, and a maximum time delta of " + r111 + "ms", null);     // Catch: IOException -> L49
    L33:
        long r107 = r113;
        if (this.mCacheStats.getCount() != r107) goto L38;
        if (this.mCacheStats.getSize() != r110) goto L38;
    L44:
        if (mOptDiskCacheWrite == false) goto L46;
        trimConfigFile(r103);     // Catch: IOException -> L49
    L47:
        this.mCacheSizeLastUpdateTime = r100;
        return true;
    L46:
        trimConfigFile();     // Catch: IOException -> L49
    L38:
        if (this.mIndexPopulateAtStartupEnabled == false) goto L42;
        Set<String> r108 = this.mResourceIndex;     // Catch: IOException -> L49
        if (r108 == r102) goto L42;
        r108.clear();     // Catch: IOException -> L49
        this.mResourceIndex.addAll(r102);     // Catch: IOException -> L49
    L42:
        this.mCacheStats.set(r110, r107);     // Catch: IOException -> L49
        goto L44
    L14:
        r103 = this.mStorage.getEntries();     // Catch: IOException -> L49
    L8:
        if (this.mIndexPopulateAtStartupEnabled == false) goto L10;
        r102 = new HashSet();
        goto L52
    L10:
        r102 = null;
        goto L52
    }

    private void trimConfigFile() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        Collection<DiskStorage.Entry> r101 = this.mStorage.getConfigEntries();     // Catch: Throwable -> L11 IOException -> L13
        List<DiskStorage.Entry> r102 = this.mStorage.getDiskCacheEntries();     // Catch: Throwable -> L11 IOException -> L13
        if (r101.size() <= r102.size()) goto L14;
        Iterator<DiskStorage.Entry> r103 = r101.iterator();     // Catch: Throwable -> L11 IOException -> L13
    L8:
        if (r103.hasNext() == false) goto L14;
        pureUnExpectedConfigFile(r103.next().getId(), r102);     // Catch: Throwable -> L11 IOException -> L13
    L14:
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L13:
        FLog.e(TAG, "remove config file failed");     // Catch: Throwable -> L11
        goto L14
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

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.facebook.cache.disk.FileCache
    public void clearAll() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        this.mStorage.clearAll();     // Catch: Throwable -> L6 Throwable -> L8 IOException -> L10
        this.mResourceIndex.clear();     // Catch: Throwable -> L6 Throwable -> L8 IOException -> L10
        this.mCacheEventListener.onCleared();     // Catch: Throwable -> L6 Throwable -> L8 IOException -> L10
        DiskCacheUtil.clearDiskCacheVisitCountMap();     // Catch: Throwable -> L6 Throwable -> L8 IOException -> L10
    L12:
        this.mCacheStats.reset();     // Catch: Throwable -> L6
        monitor-exit(r100);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    L8:
        e = move-exception;
        this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "clearAll: " + e.getMessage(), e);     // Catch: Throwable -> L6
        goto L12
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

    public boolean isIndexReady() {
        if (this.mIndexReady == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mIndexPopulateAtStartupEnabled == false) goto L8;
        return false;
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

    public static /* synthetic */ Object access$000(DiskStorageCache r100) {
        return r100.mLock;
    }

    public static /* synthetic */ boolean access$100(DiskStorageCache r100) {
        return r100.maybeUpdateFileCacheSize();
    }

    public static /* synthetic */ CountDownLatch access$300(DiskStorageCache r100) {
        return r100.mCountDownLatch;
    }

    private Collection<DiskStorage.Entry> getSortedEntries(Collection<DiskStorage.Entry> r100) {
        long r101 = this.mClock.now() + FUTURE_TIMESTAMP_THRESHOLD_MS;
        ArrayList r102 = new ArrayList(r100.size());
        ArrayList r103 = new ArrayList(r100.size());
        Iterator<DiskStorage.Entry> r104 = r100.iterator();
    L4:
        if (r104.hasNext() == false) goto L14;
        DiskStorage.Entry r105 = r104.next();
        if (mOptDiskCacheWrite == false) goto L11;
        if (r105.isContentFile() == false) goto L4;
    L11:
        if (r105.getTimestamp() > r101) goto L12;
        r103.add(r105);
        goto L4
    L12:
        r102.add(r105);
        goto L4
    L14:
        Collections.sort(r103, this.mEntryEvictionComparatorSupplier.get());
        r102.addAll(r103);
        return r102;
    }

    public static void setOptDiskCacheWrite(boolean r100) {
        mOptDiskCacheWrite = r100;
    }

    public static void setOptimizeHasKey(boolean r100) {
        mOptimizeHasKey = r100;
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

    private void trimConfigFile(Collection<DiskStorage.Entry> r100) {
        if (r100 != null) goto L13;
        return;
    L13:
        Collection<DiskStorage.Entry> r101 = this.mStorage.getConfigEntries();     // Catch: IOException -> L11
        if (r101.size() <= r100.size()) goto L17;
        Iterator<DiskStorage.Entry> r102 = r101.iterator();     // Catch: IOException -> L11
    L8:
        if (r102.hasNext() == false) goto L18;
        pureUnExpectedConfigFile(r102.next().getId(), r100);     // Catch: IOException -> L11
        goto L8
    L18:
        return;
    L17:
        return;
    L11:
        FLog.e(TAG, "remove config file failed 2");
    }

    public void addCacheEventListener(CacheEventListener r100) {
        this.mCacheEventListener.addCacheEventListener(r100);
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
    public long clearOldEntries(long r110) {
        Object r100 = this.mLock;
        monitor-enter(r100);
        long r101 = this.mClock.now();     // Catch: Throwable -> L21 IOException -> L23
        Collection<DiskStorage.Entry> r102 = this.mStorage.getEntries();     // Catch: Throwable -> L21 IOException -> L23
        long r103 = this.mCacheStats.getSize();     // Catch: Throwable -> L21 IOException -> L23
        Iterator<DiskStorage.Entry> r104 = r102.iterator();     // Catch: Throwable -> L21 IOException -> L23
        int r105 = 0;
        long r111 = 0;
        long r112 = 0;
    L30:
    L19:
        e = e;
        long r106 = r112;
    L25:
        this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "clearOldEntries: " + e.getMessage(), e);     // Catch: Throwable -> L21
        r112 = r106;
    L26:
        monitor-exit(r100);     // Catch: Throwable -> L21
        return r112;
    L7:
        if (r104.hasNext() == false) goto L15;
        DiskStorage.Entry r113 = r104.next();     // Catch: IOException -> L19 Throwable -> L21
        long r114 = r101;
        long r107 = Math.max(1, Math.abs(r101 - r113.getTimestamp()));     // Catch: IOException -> L19 Throwable -> L21
        if (r107 < r110) goto L13;
        long r108 = this.mStorage.remove(r113);     // Catch: IOException -> L19 Throwable -> L21
        this.mResourceIndex.remove(r113.getId());     // Catch: IOException -> L19 Throwable -> L21
        this.mStorage.removeConfig(r113.getId());     // Catch: IOException -> L19 Throwable -> L21
        DiskCacheUtil.deleteDiskCacheVisitCount(r113.getId());     // Catch: IOException -> L19 Throwable -> L21
        if (r108 <= 0) goto L14;
        r105 = r105 + 1;     // Catch: IOException -> L19 Throwable -> L21
        r111 = r111 + r108;     // Catch: IOException -> L19 Throwable -> L21
        SettableCacheEvent r109 = SettableCacheEvent.obtain().setResourceId(r113.getId()).setEvictionReason(CacheEventListener.EvictionReason.CONTENT_STALE).setItemSize(r108).setCacheSize(r103 - r111);     // Catch: IOException -> L19 Throwable -> L21
        this.mCacheEventListener.onEviction(r109);     // Catch: IOException -> L19 Throwable -> L21
        r109.recycle();     // Catch: IOException -> L19 Throwable -> L21
    L14:
        r101 = r114;
        goto L30
    L13:
        r112 = Math.max(r112, r107);     // Catch: IOException -> L19 Throwable -> L21
        goto L14
    L15:
        this.mStorage.purgeUnexpectedResources();     // Catch: IOException -> L19 Throwable -> L21
        if (r105 <= 0) goto L26;
        maybeUpdateFileCacheSize();     // Catch: IOException -> L19 Throwable -> L21
        this.mCacheStats.increment(-r111, -r105);     // Catch: IOException -> L19 Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    L23:
        e = e;
        r106 = 0;
        goto L25
    }

    @Override // com.facebook.cache.disk.FileCache
    public BinaryResource getResource(CacheKey r100) {
        SettableCacheEvent r101 = SettableCacheEvent.obtain().setCacheKey(r100);
        Object r102 = this.mLock;     // Catch: Throwable -> L21 IOException -> L23
        monitor-enter(r102);     // Catch: Throwable -> L21 IOException -> L23
        List<String> r103 = CacheKeyUtil.getResourceIds(r100);     // Catch: Throwable -> L18
        int r104 = 0;
        String r105 = null;
        BinaryResource r106 = null;
    L7:
        if (r104 >= r103.size()) goto L12;
        r105 = r103.get(r104);     // Catch: Throwable -> L18
        r101.setResourceId(r105);     // Catch: Throwable -> L18
        r106 = this.mStorage.getResource(r105, r100);     // Catch: Throwable -> L18
        if (r106 != null) goto L12;
        r104 = r104 + 1;     // Catch: Throwable -> L18
    L12:
        if (r106 != null) goto L14;
        this.mCacheEventListener.onMiss(r101);     // Catch: Throwable -> L18
        this.mResourceIndex.remove(r105);     // Catch: Throwable -> L18
    L15:
        monitor-exit(r102);     // Catch: Throwable -> L18
        r101.recycle();
        return r106;
    L14:
        this.mCacheEventListener.onHit(r101);     // Catch: Throwable -> L18
        this.mResourceIndex.add(r105);     // Catch: Throwable -> L18
        DiskCacheUtil.updateDiskCacheVisitCount(r105);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21 IOException -> L23
    L21:
        th = move-exception;
        r101.recycle();
        throw th;
    L23:
        e = move-exception;
        this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, TAG, "getResource", e);     // Catch: Throwable -> L21
        r101.setException(e);     // Catch: Throwable -> L21
        this.mCacheEventListener.onReadException(r101);     // Catch: Throwable -> L21
        r101.recycle();
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

    @Override // com.facebook.cache.disk.FileCache
    public boolean hasKey(CacheKey r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
    L44:
        th = move-exception;
        throw th;
    L5:
        if (mOptimizeHasKey == false) goto L28;
        List<String> r102 = CacheKeyUtil.getResourceIds(r100);     // Catch: Throwable -> L44
        int r103 = 0;
    L8:
        if (r103 >= r102.size()) goto L14;
        String r104 = r102.get(r103);     // Catch: Throwable -> L44
        if (this.mResourceIndex.contains(r104) == true) goto L11;
        r103 = r103 + 1;
        goto L8
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L44
        return true;
    L14:
        int r105 = 0;
    L49:
        if (r105 >= r102.size()) goto L23;
        String r106 = r102.get(r105);     // Catch: IOException -> L25 Throwable -> L44
        if (this.mStorage.contains(r106, r100) == true) goto L19;
        r105 = r105 + 1;     // Catch: Throwable -> L44
        goto L49
    L19:
        this.mResourceIndex.add(r106);     // Catch: IOException -> L25 Throwable -> L44
        monitor-exit(r101);     // Catch: Throwable -> L44
        return true;
        goto L26
    L23:
        monitor-exit(r101);     // Catch: Throwable -> L44
        return false;
    L26:
        return false;
    L28:
        if (hasKeySync(r100) == false) goto L47;
        monitor-exit(r101);     // Catch: Throwable -> L44
        return true;
    L47:
        List<String> r107 = CacheKeyUtil.getResourceIds(r100);     // Catch: IOException -> L42 Throwable -> L44
        int r108 = 0;
    L33:
        if (r108 >= r107.size()) goto L40;
        String r109 = r107.get(r108);     // Catch: IOException -> L42 Throwable -> L44
        if (this.mStorage.contains(r109, r100) == true) goto L36;
        r108 = r108 + 1;     // Catch: Throwable -> L44
        goto L33
    L36:
        this.mResourceIndex.add(r109);     // Catch: IOException -> L42 Throwable -> L44
        monitor-exit(r101);     // Catch: Throwable -> L44
        return true;
        goto L43
    L40:
        monitor-exit(r101);     // Catch: Throwable -> L44
        return false;
    L43:
        return false;
    }

    @Override // com.facebook.cache.disk.FileCache
    public boolean hasKeySync(CacheKey r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        List<String> r102 = CacheKeyUtil.getResourceIds(r100);     // Catch: Throwable -> L15
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
        List<String> r103 = CacheKeyUtil.getResourceIds(r100);     // Catch: Throwable -> L18
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
        SettableCacheEvent r107 = SettableCacheEvent.obtain().setCacheKey(r100).setResourceId(r106).setException(e100);
        this.mCacheEventListener.onReadException(r107);
        r107.recycle();
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
        List<String> r102 = CacheKeyUtil.getResourceIds(r100);     // Catch: Throwable -> L9 IOException -> L11
        int r103 = 0;
    L6:
        if (r103 >= r102.size()) goto L13;
        String r104 = r102.get(r103);     // Catch: Throwable -> L9 IOException -> L11
        this.mStorage.remove(r104);     // Catch: Throwable -> L9 IOException -> L11
        this.mResourceIndex.remove(r104);     // Catch: Throwable -> L9 IOException -> L11
        this.mStorage.removeConfig(r104);     // Catch: Throwable -> L9 IOException -> L11
        DiskCacheUtil.deleteDiskCacheVisitCount(r104);     // Catch: Throwable -> L9 IOException -> L11
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

    public static /* synthetic */ boolean access$202(DiskStorageCache r100, boolean r101) {
        r100.mIndexReady = r101;
        return r101;
    }

    private void evictAboveSize(long r110, CacheEventListener.EvictionReason r210) throws IOException {
    L28:
        e = move-exception;
        this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "evictAboveSize: " + e.getMessage(), e);
        throw e;
    L4:
        if (mOptDiskCacheWrite == false) goto L6;
        List<DiskStorage.Entry> r100 = this.mStorage.getDiskCacheEntries();     // Catch: IOException -> L28
        Collection<DiskStorage.Entry> r101 = getSortedEntries(r100);     // Catch: IOException -> L28
    L8:
        long r102 = this.mCacheStats.getSize();
        long r103 = r102 - r110;
        Iterator<DiskStorage.Entry> r104 = r101.iterator();
        int r111 = 0;
        long r112 = 0;
    L10:
        if (r104.hasNext() == false) goto L24;
        DiskStorage.Entry r113 = r104.next();
        if (mOptDiskCacheWrite == false) goto L17;
        if (r113.isContentFile() == false) goto L10;
    L17:
        if (r112 > r103) goto L24;
        long r105 = this.mStorage.remove(r113);
        Iterator<DiskStorage.Entry> r114 = r104;
        this.mResourceIndex.remove(r113.getId());
        this.mStorage.removeConfig(r113.getId());
        if (r105 <= 0) goto L23;
        r111 = r111 + 1;
        r112 = r112 + r105;
        SettableCacheEvent r106 = SettableCacheEvent.obtain().setResourceId(r113.getId()).setEvictionReason(r210).setItemSize(r105).setCacheSize(r102 - r112).setCacheLimit(r110);
        this.mCacheEventListener.onEviction(r106);
        r106.recycle();
    L23:
        r104 = r114;
    L24:
        this.mCacheStats.increment(-r112, -r111);
        this.mStorage.purgeUnexpectedResources();
        if (mOptDiskCacheWrite == false) goto L39;
        trimConfigFile(r100);
        return;
    L39:
        return;
    L6:
        r101 = getSortedEntries(this.mStorage.getEntries());     // Catch: IOException -> L28
        r100 = null;
        goto L8
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

    private void pureUnExpectedConfigFile(String r100, Collection<DiskStorage.Entry> r101) throws IOException {
        Iterator<DiskStorage.Entry> r102 = r101.iterator();
    L4:
        if (r102.hasNext() == true) goto L6;
        this.mStorage.removeConfig(r100);     // Catch: IOException -> L10
        return;
    L10:
        e = move-exception;
        throw e;
    L6:
        if (r100.equals(r102.next().getId()) == false) goto L4;
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
        String r104 = CacheKeyUtil.getFirstResourceId(r100);     // Catch: Throwable -> L26
        monitor-exit(r103);     // Catch: Throwable -> L26
        r102.setResourceId(r104);
        DiskStorage.Inserter r105 = startInsert(r104, r100);     // Catch: Throwable -> L19 IOException -> L21
        r105.writeData(r101, r100);     // Catch: Throwable -> L14
        BinaryResource r106 = endInsert(r105, r100, r104);     // Catch: Throwable -> L14
        r102.setItemSize(r106.size()).setCacheSize(this.mCacheStats.getSize());     // Catch: Throwable -> L14
        this.mCacheEventListener.onWriteSuccess(r102);     // Catch: Throwable -> L14
        if (r105.cleanUp() == true) goto L12;
        FLog.e(TAG, "Failed to delete temp file");     // Catch: Throwable -> L19 IOException -> L21
    L12:
        r102.recycle();
        return r106;
    L14:
        th = move-exception;
        if (r105.cleanUp() == true) goto L18;
        FLog.e(TAG, "Failed to delete temp file");     // Catch: Throwable -> L19 IOException -> L21
    L18:
        throw th;     // Catch: Throwable -> L19 IOException -> L21
    L19:
        th = move-exception;
        r102.recycle();
        throw th;
    L21:
        e = move-exception;
        r102.setException(e);     // Catch: Throwable -> L19
        this.mCacheEventListener.onWriteException(r102);     // Catch: Throwable -> L19
        FLog.e(TAG, "Failed inserting a file into the cache", e);     // Catch: Throwable -> L19
        throw e;     // Catch: Throwable -> L19
    L26:
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

    public DiskStorageCache(DiskStorage r110, EntryEvictionComparatorSupplier r111, Params r112, CacheEventListener r113, CacheErrorLogger r114, @Nullable DiskTrimmableRegistry r115, Context r116, Executor r117, boolean r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, 0.1f);
    }

    public DiskStorageCache(DiskStorage r100, EntryEvictionComparatorSupplier r101, Params r102, CacheEventListener r103, CacheErrorLogger r104, @Nullable DiskTrimmableRegistry r105, Context r106, Executor r110, boolean r111, float r112) {
        this.mLock = new Object();
        this.mLowDiskSpaceCacheSizeLimit = r102.mLowDiskSpaceCacheSizeLimit;
        long r107 = r102.mDefaultCacheSizeLimit;
        this.mDefaultCacheSizeLimit = r107;
        this.mCacheSizeLimit = r107;
        this.mStatFsHelper = StatFsHelper.getInstance();
        this.mStorage = r100;
        this.mEntryEvictionComparatorSupplier = r101;
        this.mCacheSizeLastUpdateTime = -1;
        MultiCacheEventListener r108 = new MultiCacheEventListener();
        this.mCacheEventListener = r108;
        r108.addCacheEventListener(r103);
        this.mCacheSizeLimitMinimum = r102.mCacheSizeLimitMinimum;
        this.mCacheErrorLogger = r104;
        this.mCacheStats = new CacheStats();
        this.mClock = SystemClock.get();
        this.mEvictRatio = r112;
        this.mIndexPopulateAtStartupEnabled = r111;
        this.mResourceIndex = new HashSet();
        if (r105 == null) goto L5;
        r105.registerDiskTrimmable(this);
    L5:
        if (r111 == false) goto L7;
        this.mCountDownLatch = new CountDownLatch(1);
        r110.execute(new AnonymousClass1(this));
        return;
    L7:
        this.mCountDownLatch = new CountDownLatch(0);
    }
}
