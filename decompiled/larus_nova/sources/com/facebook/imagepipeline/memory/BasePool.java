package com.facebook.imagepipeline.memory;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Sets;
import com.facebook.common.internal.Throwables;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.Pool;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BasePool<V> implements Pool<V> {
    private final Class<?> TAG;
    private boolean mAllowNewBuckets;
    final SparseArray<Bucket<V>> mBuckets;
    final Counter mFree;
    public final Set<V> mInUseValues;
    final MemoryTrimmableRegistry mMemoryTrimmableRegistry;
    final PoolParams mPoolParams;
    protected final PoolStatsTracker mPoolStatsTracker;
    final Counter mUsed;

    public static class Counter {
        private static final String TAG = "com.facebook.imagepipeline.memory.BasePool.Counter";
        int mCount;
        int mNumBytes;

        public Counter() {
        }

        public void reset() {
            this.mCount = 0;
            this.mNumBytes = 0;
            FrescoCacheMonitorUtil.setUsedBytes(0);
        }

        public void decrement(int r100) {
            int r101 = this.mNumBytes;
            if (r101 < r100) goto L7;
            int r102 = this.mCount;
            if (r102 <= 0) goto L7;
            this.mCount = r102 - 1;
            this.mNumBytes = r101 - r100;
        L8:
            FrescoCacheMonitorUtil.setUsedBytes(this.mNumBytes);
            return;
        L7:
            FLog.wtf(TAG, "Unexpected decrement of %d. Current numBytes = %d, count = %d", new Object[]{Integer.valueOf(r100), Integer.valueOf(this.mNumBytes), Integer.valueOf(this.mCount)});
            goto L8
        }

        public void increment(int r100) {
            this.mCount++;
            int r101 = this.mNumBytes + r100;
            this.mNumBytes = r101;
            FrescoCacheMonitorUtil.setUsedBytes(r101);
        }
    }

    /* JADX INFO: loaded from: classes23.dex */
    public static class InvalidSizeException extends RuntimeException {
        public InvalidSizeException(Object r100) {
            super("Invalid size: " + r100.toString());
        }
    }

    /* JADX INFO: loaded from: classes23.dex */
    public static class InvalidValueException extends RuntimeException {
        public InvalidValueException(Object r100) {
            super("Invalid value: " + r100.toString());
        }
    }

    /* JADX INFO: loaded from: classes23.dex */
    public static class PoolSizeViolationException extends RuntimeException {
        public PoolSizeViolationException(int r100, int r101, int r102, int r103) {
            super("Pool hard cap violation? Hard cap = " + r100 + " Used size = " + r101 + " Free size = " + r102 + " Request size = " + r103);
        }
    }

    /* JADX INFO: loaded from: classes23.dex */
    public static class SizeTooLargeException extends InvalidSizeException {
        public SizeTooLargeException(Object r100) {
            super(r100);
        }
    }

    private synchronized void initBuckets() {
        monitor-enter(this);
        SparseIntArray r100 = this.mPoolParams.bucketSizes;     // Catch: Throwable -> L9
        if (r100 == null) goto L6;
        fillBuckets(r100);     // Catch: Throwable -> L9
        this.mAllowNewBuckets = false;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        this.mAllowNewBuckets = true;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public abstract V alloc(int r100);

    public synchronized void ensurePoolSizeInvariant() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (isMaxSizeSoftCapExceeded() == true) goto L6;
    L9:
        boolean r100 = true;
    L10:
        Preconditions.checkState(r100);     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L6:
        if (this.mFree.mNumBytes == 0) goto L9;
        r100 = false;
        goto L10
    }

    public abstract void free(V r100);

    public abstract int getBucketedSize(int r100);

    public abstract int getBucketedSizeForValue(V r100);

    public abstract int getSizeInBytes(int r100);

    public synchronized Map<String, Integer> getStats() {
        monitor-enter(this);
        HashMap r100 = new HashMap();     // Catch: Throwable -> L10
        int r101 = 0;
    L5:
        if (r101 >= this.mBuckets.size()) goto L7;
        r100.put(PoolStatsTracker.BUCKETS_USED_PREFIX + getSizeInBytes(this.mBuckets.keyAt(r101)), Integer.valueOf(this.mBuckets.valueAt(r101).getInUseCount()));     // Catch: Throwable -> L10
        r101 = r101 + 1;     // Catch: Throwable -> L10
        goto L5
    L7:
        r100.put(PoolStatsTracker.SOFT_CAP, Integer.valueOf(this.mPoolParams.maxSizeSoftCap));     // Catch: Throwable -> L10
        r100.put(PoolStatsTracker.HARD_CAP, Integer.valueOf(this.mPoolParams.maxSizeHardCap));     // Catch: Throwable -> L10
        r100.put(PoolStatsTracker.USED_COUNT, Integer.valueOf(this.mUsed.mCount));     // Catch: Throwable -> L10
        r100.put(PoolStatsTracker.USED_BYTES, Integer.valueOf(this.mUsed.mNumBytes));     // Catch: Throwable -> L10
        r100.put(PoolStatsTracker.FREE_COUNT, Integer.valueOf(this.mFree.mCount));     // Catch: Throwable -> L10
        r100.put(PoolStatsTracker.FREE_BYTES, Integer.valueOf(this.mFree.mNumBytes));     // Catch: Throwable -> L10
        monitor-exit(this);
        return r100;
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized boolean isMaxSizeSoftCapExceeded() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if ((this.mUsed.mNumBytes + this.mFree.mNumBytes) <= this.mPoolParams.maxSizeSoftCap) goto L6;
        boolean r100 = true;
    L7:
        if (r100 == false) goto L9;
        this.mPoolStatsTracker.onSoftCapReached();     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return r100;
    L6:
        r100 = false;
        goto L7
    }

    public void logStats() {
        if (FLog.isLoggable(2) == false) goto L6;
        FLog.v(this.TAG, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.mUsed.mCount), Integer.valueOf(this.mUsed.mNumBytes), Integer.valueOf(this.mFree.mCount), Integer.valueOf(this.mFree.mNumBytes));
        return;
    }

    public void onParamsChanged() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void trimToNothing() {
        monitor-enter(this);
        int r100 = 0;
        if (this.mPoolParams.fixBucketsReinitialization == false) goto L6;
        List r101 = refillBuckets();     // Catch: Throwable -> L25
    L14:
        this.mFree.reset();     // Catch: Throwable -> L25
        logStats();     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L25
        onParamsChanged();
    L18:
        if (r100 >= r101.size()) goto L24;
        Bucket r102 = (Bucket) r101.get(r100);
    L20:
        Object r103 = r102.pop();
        if (r103 == null) goto L22;
        free(r103);
        goto L20
    L22:
        r100 = r100 + 1;
        goto L18
    L24:
        return;
    L6:
        ArrayList r104 = new ArrayList(this.mBuckets.size());     // Catch: Throwable -> L25
        SparseIntArray r105 = new SparseIntArray();     // Catch: Throwable -> L25
        int r106 = 0;
    L8:
        if (r106 >= this.mBuckets.size()) goto L13;
        Bucket<V> r107 = this.mBuckets.valueAt(r106);     // Catch: Throwable -> L25
        if (r107.getFreeListSize() <= 0) goto L12;
        r104.add(r107);     // Catch: Throwable -> L25
    L12:
        r105.put(this.mBuckets.keyAt(r106), r107.getInUseCount());     // Catch: Throwable -> L25
        r106 = r106 + 1;     // Catch: Throwable -> L25
        goto L8
    L13:
        legacyInitBuckets(r105);     // Catch: Throwable -> L25
        r101 = r104;
    L25:
        th = move-exception;
        throw th;
    }

    public synchronized void trimToSoftCap() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (isMaxSizeSoftCapExceeded() == false) goto L6;
        trimToSize(this.mPoolParams.maxSizeSoftCap);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    private List<Bucket<V>> refillBuckets() {
        ArrayList r100 = new ArrayList(this.mBuckets.size());
        int r101 = this.mBuckets.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        Bucket<V> r103 = this.mBuckets.valueAt(r102);
        int r104 = r103.mItemSize;
        int r105 = r103.mMaxLength;
        int r106 = r103.getInUseCount();
        if (r103.getFreeListSize() <= 0) goto L7;
        r100.add(r103);
    L7:
        this.mBuckets.setValueAt(r102, new Bucket(getSizeInBytes(r104), r105, r106, this.mPoolParams.fixBucketsReinitialization));
        r102 = r102 + 1;
        goto L3
    L8:
        return r100;
    }

    public void initialize() {
        this.mMemoryTrimmableRegistry.registerMemoryTrimmable(this);
        this.mPoolStatsTracker.setBasePool(this);
    }

    private void fillBuckets(SparseIntArray r100) {
        this.mBuckets.clear();
        int r101 = 0;
    L4:
        if (r101 >= r100.size()) goto L6;
        int r102 = r100.keyAt(r101);
        int r103 = r100.valueAt(r101);
        this.mBuckets.put(r102, new Bucket(getSizeInBytes(r102), r103, 0, this.mPoolParams.fixBucketsReinitialization));
        r101 = r101 + 1;
        goto L4
    }

    private synchronized void legacyInitBuckets(SparseIntArray r110) {
        monitor-enter(this);
        Preconditions.checkNotNull(r110);     // Catch: Throwable -> L13
        this.mBuckets.clear();     // Catch: Throwable -> L13
        SparseIntArray r100 = this.mPoolParams.bucketSizes;     // Catch: Throwable -> L13
        if (r100 == null) goto L10;
        int r101 = 0;
    L7:
        if (r101 >= r100.size()) goto L9;
        int r102 = r100.keyAt(r101);     // Catch: Throwable -> L13
        int r103 = r100.valueAt(r101);     // Catch: Throwable -> L13
        int r104 = r110.get(r102, 0);     // Catch: Throwable -> L13
        this.mBuckets.put(r102, new Bucket(getSizeInBytes(r102), r103, r104, this.mPoolParams.fixBucketsReinitialization));     // Catch: Throwable -> L13
        r101 = r101 + 1;     // Catch: Throwable -> L13
        goto L7
    L9:
        this.mAllowNewBuckets = false;     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
        return;
    L10:
        this.mAllowNewBuckets = true;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public synchronized boolean canAllocate(int r100) {
        monitor-enter(this);
        PoolParams r101 = this.mPoolParams;     // Catch: Throwable -> L19
        int r102 = r101.maxSizeHardCap;     // Catch: Throwable -> L19
        int r103 = this.mUsed.mNumBytes;     // Catch: Throwable -> L19
        if (r100 <= (r102 - r103)) goto L8;
        this.mPoolStatsTracker.onHardCapReached();     // Catch: Throwable -> L19
        monitor-exit(this);
        return false;
    L8:
        int r104 = r101.maxSizeSoftCap;     // Catch: Throwable -> L19
        if (r100 <= (r104 - (r103 + this.mFree.mNumBytes))) goto L12;
        trimToSize(r104 - r100);     // Catch: Throwable -> L19
    L12:
        if (r100 <= (r102 - (this.mUsed.mNumBytes + this.mFree.mNumBytes))) goto L16;
        this.mPoolStatsTracker.onHardCapReached();     // Catch: Throwable -> L19
        monitor-exit(this);
        return false;
    L16:
        monitor-exit(this);
        return true;
    L19:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.common.memory.Pool
    public V get(int r100) {
        ensurePoolSizeInvariant();
        int r101 = getBucketedSize(r100);
        monitor-enter(this);
        Bucket<V> r102 = getBucket(r101);     // Catch: Throwable -> L42
        if (r102 == null) goto L13;
        V r103 = getValue(r102);     // Catch: Throwable -> L42
        if (r103 == null) goto L13;
        Preconditions.checkState(this.mInUseValues.add(r103));     // Catch: Throwable -> L42
        int r104 = getBucketedSizeForValue(r103);     // Catch: Throwable -> L42
        int r105 = getSizeInBytes(r104);     // Catch: Throwable -> L42
        this.mUsed.increment(r105);     // Catch: Throwable -> L42
        this.mFree.decrement(r105);     // Catch: Throwable -> L42
        this.mPoolStatsTracker.onValueReuse(r105);     // Catch: Throwable -> L42
        logStats();     // Catch: Throwable -> L42
        if (FLog.isLoggable(2) == false) goto L11;
        FLog.v(this.TAG, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(r103)), Integer.valueOf(r104));     // Catch: Throwable -> L42
    L11:
        monitor-exit(this);     // Catch: Throwable -> L42
        return r103;
    L13:
        int r106 = getSizeInBytes(r101);     // Catch: Throwable -> L42
        if (canAllocate(r106) == false) goto L41;
        this.mUsed.increment(r106);     // Catch: Throwable -> L42
        if (r102 == null) goto L18;
        r102.incrementInUseCount();     // Catch: Throwable -> L42
    L18:
        monitor-exit(this);     // Catch: Throwable -> L42
        V r107 = alloc(r101);     // Catch: Throwable -> L21
    L28:
        monitor-enter(this);
        Preconditions.checkState(this.mInUseValues.add(r107));     // Catch: Throwable -> L34
        trimToSoftCap();     // Catch: Throwable -> L34
        this.mPoolStatsTracker.onAlloc(r106);     // Catch: Throwable -> L34
        logStats();     // Catch: Throwable -> L34
        if (FLog.isLoggable(2) == false) goto L32;
        FLog.v(this.TAG, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(r107)), Integer.valueOf(r101));     // Catch: Throwable -> L34
    L32:
        monitor-exit(this);     // Catch: Throwable -> L34
        return r107;
    L34:
        th = move-exception;
        throw th;
    L21:
        th = move-exception;
        monitor-enter(this);
        this.mUsed.decrement(r106);     // Catch: Throwable -> L37
        Bucket<V> r108 = getBucket(r101);     // Catch: Throwable -> L37
        if (r108 == null) goto L26;
        r108.decrementInUseCount();     // Catch: Throwable -> L37
    L26:
        Throwables.propagateIfPossible(th);
        r107 = null;
    L37:
        th = move-exception;
        throw th;
    L41:
        throw new PoolSizeViolationException(this.mPoolParams.maxSizeHardCap, this.mUsed.mNumBytes, this.mFree.mNumBytes, r106);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        throw th;
    }

    public synchronized Bucket<V> getBucket(int r100) {
        monitor-enter(this);
        Bucket<V> r101 = this.mBuckets.get(r100);     // Catch: Throwable -> L16
        if (r101 == null) goto L6;
    L14:
        monitor-exit(this);
        return r101;
    L6:
        if (this.mAllowNewBuckets == false) goto L14;
        if (FLog.isLoggable(2) == false) goto L11;
        FLog.v(this.TAG, "creating new bucket %s", Integer.valueOf(r100));     // Catch: Throwable -> L16
    L11:
        Bucket<V> r102 = newBucket(r100);     // Catch: Throwable -> L16
        this.mBuckets.put(r100, r102);     // Catch: Throwable -> L16
        monitor-exit(this);
        return r102;
    L16:
        th = move-exception;
        throw th;
    }

    public synchronized Bucket<V> getBucketIfPresent(int r100) {
        monitor-enter(this);
        Bucket<V> r101 = this.mBuckets.get(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    @Nullable
    public synchronized V getValue(Bucket<V> r100) {
        monitor-enter(this);
        V r101 = r100.get();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    public boolean isReusable(V r100) {
        Preconditions.checkNotNull(r100);
        return true;
    }

    public Bucket<V> newBucket(int r100) {
        return new Bucket(getSizeInBytes(r100), Integer.MAX_VALUE, 0, this.mPoolParams.fixBucketsReinitialization);
    }

    @Override // com.facebook.common.memory.Pool, com.facebook.common.references.ResourceReleaser
    public void release(V r100) {
        Preconditions.checkNotNull(r100);
        int r101 = getBucketedSizeForValue(r100);
        int r102 = getSizeInBytes(r101);
        monitor-enter(this);
        Bucket<V> r103 = getBucketIfPresent(r101);     // Catch: Throwable -> L27
        if (this.mInUseValues.remove(r100) == true) goto L7;
        FLog.e(this.TAG, "release (free, value unrecognized) (object, size) = (%x, %s)", new Object[]{Integer.valueOf(System.identityHashCode(r100)), Integer.valueOf(r101)});     // Catch: Throwable -> L27
        free(r100);     // Catch: Throwable -> L27
        this.mPoolStatsTracker.onFree(r102);     // Catch: Throwable -> L27
    L24:
        logStats();     // Catch: Throwable -> L27
        monitor-exit(this);     // Catch: Throwable -> L27
        return;
    L7:
        if (r103 != null) goto L9;
    L18:
        if (r103 == null) goto L21;
        r103.decrementInUseCount();     // Catch: Throwable -> L27
    L21:
        if (FLog.isLoggable(2) == false) goto L23;
        FLog.v(this.TAG, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(r100)), Integer.valueOf(r101));     // Catch: Throwable -> L27
    L23:
        free(r100);     // Catch: Throwable -> L27
        this.mUsed.decrement(r102);     // Catch: Throwable -> L27
        this.mPoolStatsTracker.onFree(r102);     // Catch: Throwable -> L27
        goto L24
    L9:
        if (r103.isMaxLengthExceeded() == true) goto L18;
        if (isMaxSizeSoftCapExceeded() == true) goto L18;
        if (isReusable(r100) == false) goto L18;
        r103.release(r100);     // Catch: Throwable -> L27
        this.mFree.increment(r102);     // Catch: Throwable -> L27
        this.mUsed.decrement(r102);     // Catch: Throwable -> L27
        this.mPoolStatsTracker.onValueRelease(r102);     // Catch: Throwable -> L27
        if (FLog.isLoggable(2) == false) goto L24;
        FLog.v(this.TAG, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(r100)), Integer.valueOf(r101));     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.common.memory.MemoryTrimmable
    public void trim(MemoryTrimType r100) {
        trimToNothing();
    }

    synchronized void trimToSize(int r100) {
        monitor-enter(this);
        int r101 = this.mUsed.mNumBytes;     // Catch: Throwable -> L28
        int r102 = this.mFree.mNumBytes;     // Catch: Throwable -> L28
        int r103 = Math.min((r101 + r102) - r100, r102);     // Catch: Throwable -> L28
        if (r103 > 0) goto L9;
        monitor-exit(this);
        return;
    L9:
        if (FLog.isLoggable(2) == false) goto L11;
        FLog.v(this.TAG, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(r100), Integer.valueOf(this.mUsed.mNumBytes + this.mFree.mNumBytes), Integer.valueOf(r103));     // Catch: Throwable -> L28
    L11:
        logStats();     // Catch: Throwable -> L28
        int r104 = 0;
    L13:
        if (r104 >= this.mBuckets.size()) goto L23;
        if (r103 <= 0) goto L23;
        Bucket<V> r105 = this.mBuckets.valueAt(r104);     // Catch: Throwable -> L28
    L17:
        if (r103 <= 0) goto L22;
        V r106 = r105.pop();     // Catch: Throwable -> L28
        if (r106 == null) goto L22;
        free(r106);     // Catch: Throwable -> L28
        int r107 = r105.mItemSize;     // Catch: Throwable -> L28
        r103 = r103 - r107;     // Catch: Throwable -> L28
        this.mFree.decrement(r107);     // Catch: Throwable -> L28
    L22:
        r104 = r104 + 1;     // Catch: Throwable -> L28
    L23:
        logStats();     // Catch: Throwable -> L28
        if (FLog.isLoggable(2) == false) goto L26;
        FLog.v(this.TAG, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(r100), Integer.valueOf(this.mUsed.mNumBytes + this.mFree.mNumBytes));     // Catch: Throwable -> L28
    L26:
        monitor-exit(this);
        return;
    L28:
        th = move-exception;
        throw th;
    }

    public BasePool(MemoryTrimmableRegistry r100, PoolParams r101, PoolStatsTracker r102) {
        this.TAG = getClass();
        this.mMemoryTrimmableRegistry = (MemoryTrimmableRegistry) Preconditions.checkNotNull(r100);
        PoolParams r103 = (PoolParams) Preconditions.checkNotNull(r101);
        this.mPoolParams = r103;
        FrescoCacheMonitorUtil.setMaxSizeHardCap(r103.maxSizeHardCap);
        this.mPoolStatsTracker = (PoolStatsTracker) Preconditions.checkNotNull(r102);
        this.mBuckets = new SparseArray();
        if (r103.fixBucketsReinitialization == false) goto L5;
        initBuckets();
    L6:
        this.mInUseValues = Sets.newIdentityHashSet();
        this.mFree = new Counter();
        this.mUsed = new Counter();
        return;
    L5:
        legacyInitBuckets(new SparseIntArray(0));
        goto L6
    }
}
