package com.facebook.imagepipeline.cache;

import android.graphics.Bitmap;
import android.os.Looper;
import android.os.SystemClock;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Predicate;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.references.CloseableReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class CountingMemoryCache<K, V> implements MemoryCache<K, V>, MemoryTrimmable {
    static final long PARAMS_INTERCHECK_INTERVAL_MS = 0;
    public static boolean isForceRunInSubThread;
    private final CacheTrimStrategy mCacheTrimStrategy;
    final CountingLruMap<K, Entry<K, V>> mCachedEntries;
    final CountingLruMap<K, Entry<K, V>> mExclusiveEntries;
    private long mLastCacheParamsCheck;
    protected MemoryCacheParams mMemoryCacheParams;
    private final Supplier<MemoryCacheParams> mMemoryCacheParamsSupplier;
    final Map<Bitmap, Object> mOtherEntries;
    private final ValueDescriptor<V> mValueDescriptor;

    public interface CacheTrimStrategy {
        double getTrimRatio(MemoryTrimType r100);
    }

    /* JADX INFO: loaded from: classes23.dex */
    public static class Entry<K, V> {
        public int clientCount;
        public boolean isOrphan;
        public final K key;

        @Nullable
        public final EntryStateObserver<K> observer;
        public final CloseableReference<V> valueRef;

        private Entry(K r100, CloseableReference<V> r101, @Nullable EntryStateObserver<K> r102) {
            this.key = (K) Preconditions.checkNotNull(r100);
            this.valueRef = (CloseableReference) Preconditions.checkNotNull(CloseableReference.cloneOrNull(r101));
            this.clientCount = 0;
            this.isOrphan = false;
            this.observer = r102;
        }

        public static <K, V> Entry<K, V> of(K r100, CloseableReference<V> r101, @Nullable EntryStateObserver<K> r102) {
            return new Entry(r100, r101, r102);
        }
    }

    /* JADX INFO: loaded from: classes23.dex */
    public interface EntryStateObserver<K> {
        void onExclusivityChanged(K r100, boolean r101);
    }

    private void maybeEvictEntries() {
        monitor-enter(this);
        MemoryCacheParams r100 = this.mMemoryCacheParams;     // Catch: Throwable -> L6
        int r101 = Math.min(r100.maxEvictionQueueEntries, r100.maxCacheEntries - getInUseCount());     // Catch: Throwable -> L6
        MemoryCacheParams r102 = this.mMemoryCacheParams;     // Catch: Throwable -> L6
        trimExclusivelyOwnedEntries(r101, Math.min(r102.maxEvictionQueueSize, r102.getMaxCacheSize() - getInUseSizeInBytes()));     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized void maybeUpdateCacheParams() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if ((this.mLastCacheParamsCheck + PARAMS_INTERCHECK_INTERVAL_MS) <= SystemClock.uptimeMillis()) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.mLastCacheParamsCheck = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        this.mMemoryCacheParams = this.mMemoryCacheParamsSupplier.get();     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public void clear() {
        monitor-enter(this);
        ArrayList<Entry<K, V>> r100 = this.mExclusiveEntries.clear();     // Catch: Throwable -> L9
        ArrayList<Entry<K, V>> r101 = this.mCachedEntries.clear();     // Catch: Throwable -> L9
        makeOrphans(r101);     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        maybeClose(r101);
        maybeNotifyExclusiveEntryRemoval(r100);
        maybeUpdateCacheParams();
        if (this.mMemoryCacheParams.mOptReuseMemoryCache == false) goto L14;
        MemoryCacheUtil.clearReuseBitmapCacheMap();
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized int getCount() {
        monitor-enter(this);
        int r100 = this.mCachedEntries.getCount();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int getEvictionQueueCount() {
        monitor-enter(this);
        int r100 = this.mExclusiveEntries.getCount();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int getEvictionQueueSizeInBytes() {
        monitor-enter(this);
        int r100 = this.mExclusiveEntries.getSizeInBytes();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int getInUseCount() {
        monitor-enter(this);
        int r100 = this.mCachedEntries.getCount() - this.mExclusiveEntries.getCount();
        monitor-exit(this);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized int getInUseSizeInBytes() {
        monitor-enter(this);
        int r100 = this.mCachedEntries.getSizeInBytes() - this.mExclusiveEntries.getSizeInBytes();
        monitor-exit(this);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized int getSizeInBytes() {
        monitor-enter(this);
        int r100 = this.mCachedEntries.getSizeInBytes();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        PARAMS_INTERCHECK_INTERVAL_MS = TimeUnit.MINUTES.toMillis(5);
    }

    public CountingLruMap<K, Entry<K, V>> getCachedEntries() {
        return this.mCachedEntries;
    }

    public static /* synthetic */ void access$400(Entry r100) {
        maybeNotifyExclusiveEntryInsertion(r100);
    }

    public static /* synthetic */ void access$500(CountingMemoryCache r100) {
        r100.maybeUpdateCacheParams();
    }

    public static /* synthetic */ void access$600(CountingMemoryCache r100) {
        r100.maybeEvictEntries();
    }

    private synchronized boolean canCacheNewValue(V r100) {
        monitor-enter(this);
        int r101 = this.mValueDescriptor.getSizeInBytes(r100);     // Catch: Throwable -> L14
        if (r101 > this.mMemoryCacheParams.maxCacheEntrySize) goto L11;
        boolean r102 = true;
        if (getInUseCount() > (this.mMemoryCacheParams.maxCacheEntries - 1)) goto L11;
        if (getInUseSizeInBytes() > (this.mMemoryCacheParams.getMaxCacheSize() - r101)) goto L11;
    L12:
        monitor-exit(this);
        return r102;
    L11:
        r102 = false;
    L14:
        th = move-exception;
        throw th;
    }

    private synchronized void decreaseClientCount(Entry<K, V> r100) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.mMemoryCacheParams.mMemoryCacheOpt == true) goto L10;
        Preconditions.checkNotNull(r100);     // Catch: Throwable -> L14
        if (r100.clientCount <= 0) goto L8;
        boolean r101 = true;
    L9:
        Preconditions.checkState(r101);     // Catch: Throwable -> L14
        goto L10
    L8:
        r101 = false;
    L10:
        if (r100 == null) goto L12;
        r100.clientCount--;     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
    }

    private synchronized void decreaseClientCountNew(Entry<K, V> r100) {
        monitor-enter(this);
        Preconditions.checkNotNull(r100);     // Catch: Throwable -> L12
        if (this.mMemoryCacheParams.mMemoryCacheOpt == false) goto L6;
    L10:
        monitor-exit(this);
        return;
    L6:
        if (r100.clientCount <= 0) goto L8;
        boolean r101 = true;
    L9:
        Preconditions.checkState(r101);     // Catch: Throwable -> L12
        r100.clientCount = 0;     // Catch: Throwable -> L12
        goto L10
    L8:
        r101 = false;
    L12:
        th = move-exception;
        throw th;
    }

    private synchronized void increaseClientCount(Entry<K, V> r100) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.mMemoryCacheParams.mMemoryCacheOpt == true) goto L10;
        Preconditions.checkNotNull(r100);     // Catch: Throwable -> L14
        if (r100.isOrphan == true) goto L8;
        boolean r101 = true;
    L9:
        Preconditions.checkState(r101);     // Catch: Throwable -> L14
        goto L10
    L8:
        r101 = false;
    L10:
        if (r100 == null) goto L12;
        r100.clientCount++;     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
    }

    private synchronized void makeOrphan(Entry<K, V> r100) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.mMemoryCacheParams.mMemoryCacheOpt == true) goto L10;
        Preconditions.checkNotNull(r100);     // Catch: Throwable -> L14
        if (r100.isOrphan == true) goto L8;
        boolean r101 = true;
    L9:
        Preconditions.checkState(r101);     // Catch: Throwable -> L14
        goto L10
    L8:
        r101 = false;
    L10:
        if (r100 == null) goto L12;
        r100.isOrphan = true;     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
    }

    private synchronized void makeOrphans(@Nullable ArrayList<Entry<K, V>> r100) {
        monitor-enter(this);
        if (r100 != null) goto L14;
    L12:
        monitor-exit(this);
        return;
    L14:
        Iterator<Entry<K, V>> r101 = r100.iterator();     // Catch: Throwable -> L9
    L6:
        if (r101.hasNext() == false) goto L12;
        makeOrphan(r101.next());     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private synchronized boolean maybeAddToExclusives(Entry<K, V> r100) {
        monitor-enter(this);
        if (r100 != null) goto L20;
        monitor-exit(this);
        return false;
    L20:
    L17:
        th = move-exception;
        throw th;
    L8:
        if (r100.isOrphan == false) goto L10;
    L15:
        monitor-exit(this);
        return false;
    L10:
        if (r100.clientCount != 0) goto L15;
        this.mExclusiveEntries.put(r100.key, r100);     // Catch: Throwable -> L17
        monitor-exit(this);
        return true;
    }

    private void maybeClose(@Nullable ArrayList<Entry<K, V>> r100) {
        if (r100 == null) goto L7;
        Iterator<Entry<K, V>> r101 = r100.iterator();
    L5:
        if (r101.hasNext() == false) goto L9;
        CloseableReference.closeSafely(referenceToClose(r101.next()));
        goto L5
    L9:
        return;
    }

    private static <K, V> void maybeNotifyExclusiveEntryInsertion(@Nullable Entry<K, V> r100) {
        if (r100 == null) goto L7;
        EntryStateObserver<K> r101 = r100.observer;
        if (r101 == null) goto L8;
        r101.onExclusivityChanged(r100.key, true);
        return;
    L8:
        return;
    }

    private void maybeNotifyExclusiveEntryRemoval(@Nullable ArrayList<Entry<K, V>> r100) {
        if (r100 == null) goto L7;
        Iterator<Entry<K, V>> r101 = r100.iterator();
    L5:
        if (r101.hasNext() == false) goto L9;
        maybeNotifyExclusiveEntryRemoval(r101.next());
        goto L5
    L9:
        return;
    }

    private synchronized CloseableReference<V> newClientReference(final Entry<K, V> r100) {
        monitor-enter(this);
        increaseClientCount(r100);     // Catch: Throwable -> L6
        CloseableReference<V> r101 = CloseableReference.of(r100.valueRef.get(), new AnonymousClass2(this, r100));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    @Nullable
    private synchronized CloseableReference<V> referenceToClose(Entry<K, V> r100) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.mMemoryCacheParams.mMemoryCacheOpt == true) goto L6;
        Preconditions.checkNotNull(r100);     // Catch: Throwable -> L16
    L6:
        if (r100 != null) goto L8;
    L13:
        CloseableReference<V> r101 = null;
    L14:
        monitor-exit(this);
        return r101;
    L8:
        if (r100.isOrphan == false) goto L13;
        if (r100.clientCount != 0) goto L13;
        r101 = r100.valueRef;     // Catch: Throwable -> L16
        goto L14
    }

    private void releaseClientReference(final Entry<K, V> r100) {
        if (this.mMemoryCacheParams.mMemoryCacheOpt == true) goto L6;
        Preconditions.checkNotNull(r100);
    L6:
        if (isForceRunInSubThread == true) goto L8;
        monitor-enter(this);
        decreaseClientCount(r100);     // Catch: Throwable -> L30
        boolean r101 = maybeAddToExclusives(r100);     // Catch: Throwable -> L30
        CloseableReference<V> r102 = referenceToClose(r100);     // Catch: Throwable -> L30
        monitor-exit(this);     // Catch: Throwable -> L30
        CloseableReference.closeSafely(r102);
        if (r101 == true) goto L28;
        r100 = null;
    L28:
        maybeNotifyExclusiveEntryInsertion(r100);
        maybeUpdateCacheParams();
        maybeEvictEntries();
        return;
    L30:
        th = move-exception;
        throw th;
    L8:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L20;
        monitor-enter(this);
        decreaseClientCount(r100);     // Catch: Throwable -> L17
        boolean r103 = maybeAddToExclusives(r100);     // Catch: Throwable -> L17
        CloseableReference<V> r104 = referenceToClose(r100);     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        CloseableReference.closeSafely(r104);
        if (r103 == true) goto L16;
        r100 = null;
    L16:
        maybeNotifyExclusiveEntryInsertion(r100);
        maybeUpdateCacheParams();
        maybeEvictEntries();
        return;
    L17:
        th = move-exception;
        throw th;
    L20:
        DealCacheHelper.getIOExecutor().execute(new AnonymousClass3(this, r100));
    }

    private void releaseClientReferenceNew(final Entry<K, V> r100) {
        if (this.mMemoryCacheParams.mMemoryCacheOpt == true) goto L6;
        Preconditions.checkNotNull(r100);
    L6:
        if (isForceRunInSubThread == true) goto L8;
        monitor-enter(this);
        decreaseClientCountNew(r100);     // Catch: Throwable -> L30
        boolean r101 = maybeAddToExclusives(r100);     // Catch: Throwable -> L30
        CloseableReference<V> r102 = referenceToClose(r100);     // Catch: Throwable -> L30
        monitor-exit(this);     // Catch: Throwable -> L30
        CloseableReference.closeSafely(r102);
        if (r101 == true) goto L28;
        r100 = null;
    L28:
        maybeNotifyExclusiveEntryInsertion(r100);
        maybeUpdateCacheParams();
        maybeEvictEntries();
        return;
    L30:
        th = move-exception;
        throw th;
    L8:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L20;
        monitor-enter(this);
        decreaseClientCountNew(r100);     // Catch: Throwable -> L17
        boolean r103 = maybeAddToExclusives(r100);     // Catch: Throwable -> L17
        CloseableReference<V> r104 = referenceToClose(r100);     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        CloseableReference.closeSafely(r104);
        if (r103 == true) goto L16;
        r100 = null;
    L16:
        maybeNotifyExclusiveEntryInsertion(r100);
        maybeUpdateCacheParams();
        maybeEvictEntries();
        return;
    L17:
        th = move-exception;
        throw th;
    L20:
        DealCacheHelper.getIOExecutor().execute(new AnonymousClass4(this, r100));
    }

    private ValueDescriptor<Entry<K, V>> wrapValueDescriptor(final ValueDescriptor<V> r100) {
        return new AnonymousClass1(this, r100);
    }

    public void clearByPercentage(Double r100) {
        double r101 = r100.doubleValue();
        monitor-enter(this);
        int r102 = Math.max(0, (int) (((double) this.mCachedEntries.getSizeInBytes()) * (1.0d - r101)));     // Catch: Throwable -> L21
    L6:
        if (this.mCachedEntries.getSizeInBytes() <= r102) goto L18;
        K r103 = this.mCachedEntries.getFirstKey();     // Catch: Throwable -> L21
        if (r103 == null) goto L9;
        Entry<K, V> r104 = this.mCachedEntries.remove(r103);     // Catch: Throwable -> L21
        Entry<K, V> r105 = this.mExclusiveEntries.remove(r103);     // Catch: Throwable -> L21
        if (this.mMemoryCacheParams.mOptReuseMemoryCache == false) goto L14;
        MemoryCacheUtil.removeReuseBitmapCache(r103.toString());     // Catch: Throwable -> L21
    L14:
        if (r104 == null) goto L16;
        makeOrphan(r104);     // Catch: Throwable -> L21
        CloseableReference.closeSafely(referenceToClose(r104));     // Catch: Throwable -> L21
    L16:
        if (r105 == null) goto L6;
        maybeNotifyExclusiveEntryRemoval(r105);     // Catch: Throwable -> L21
        goto L6
    L9:
        monitor-exit(this);     // Catch: Throwable -> L21
        return;
    L18:
        monitor-exit(this);     // Catch: Throwable -> L21
        maybeUpdateCacheParams();
        return;
    L21:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public synchronized boolean contains(Predicate<K> r100) {
        monitor-enter(this);
        boolean r101 = !this.mCachedEntries.getMatchingEntries(r100).isEmpty();
        monitor-exit(this);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    @Nullable
    public CloseableReference<V> get(K r100) {
        Preconditions.checkNotNull(r100);
        monitor-enter(this);
        Entry<K, V> r101 = this.mExclusiveEntries.remove(r100);     // Catch: Throwable -> L11
        Entry<K, V> r102 = this.mCachedEntries.get(r100);     // Catch: Throwable -> L11
        if (r102 == null) goto L7;
        CloseableReference<V> r103 = newClientReference(r102);     // Catch: Throwable -> L11
    L8:
        monitor-exit(this);     // Catch: Throwable -> L11
        maybeNotifyExclusiveEntryRemoval(r101);
        maybeUpdateCacheParams();
        maybeEvictEntries();
        return r103;
    L7:
        r103 = null;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public int removeAll(Predicate<K> r100) {
        monitor-enter(this);
        ArrayList<Entry<K, V>> r101 = this.mExclusiveEntries.removeAll(r100);     // Catch: Throwable -> L10
        ArrayList<Entry<K, V>> r102 = this.mCachedEntries.removeAll(r100);     // Catch: Throwable -> L10
        makeOrphans(r102);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        maybeClose(r102);
        maybeNotifyExclusiveEntryRemoval(r101);
        maybeUpdateCacheParams();
        maybeEvictEntries();
        if (this.mMemoryCacheParams.mOptReuseMemoryCache == false) goto L9;
        MemoryCacheUtil.clearReuseBitmapCacheMap();
    L9:
        return r102.size();
    L10:
        th = move-exception;
        throw th;
    }

    public int removeAllForExclusive(Predicate<K> r100) {
        ArrayList<Entry<K, V>> r101 = new ArrayList();
        monitor-enter(this);
        ArrayList<Entry<K, V>> r102 = this.mExclusiveEntries.removeAll(r100);     // Catch: Throwable -> L16
        int r103 = 0;
    L6:
        if (r103 >= r102.size()) goto L13;
        Entry<K, V> r104 = r102.get(r103);     // Catch: Throwable -> L16
        r101.add(this.mCachedEntries.remove(r104.key));     // Catch: Throwable -> L16
        if (this.mMemoryCacheParams.mOptReuseMemoryCache == false) goto L12;
        K r105 = r104.key;     // Catch: Throwable -> L16
        if (r105 == null) goto L12;
        MemoryCacheUtil.removeReuseBitmapCache(r105.toString());     // Catch: Throwable -> L16
    L12:
        r103 = r103 + 1;     // Catch: Throwable -> L16
        goto L6
    L13:
        monitor-exit(this);     // Catch: Throwable -> L16
        maybeClose(r101);
        maybeNotifyExclusiveEntryRemoval(r102);
        maybeUpdateCacheParams();
        maybeEvictEntries();
        return r101.size();
    L16:
        th = move-exception;
        throw th;
    }

    @Nullable
    public CloseableReference<V> reuse(K r100) {
        Preconditions.checkNotNull(r100);
        monitor-enter(this);
        Entry<K, V> r101 = this.mExclusiveEntries.remove(r100);     // Catch: Throwable -> L22
        CloseableReference<V> r102 = null;
        boolean r103 = false;
        if (r101 == null) goto L18;
        Entry<K, V> r104 = this.mCachedEntries.remove(r100);     // Catch: Throwable -> L22
        if (this.mMemoryCacheParams.mOptReuseMemoryCache == false) goto L10;
        MemoryCacheUtil.removeReuseBitmapCache(r100.toString());     // Catch: Throwable -> L22
    L10:
        if (this.mMemoryCacheParams.mMemoryCacheOpt == true) goto L15;
        Preconditions.checkNotNull(r104);     // Catch: Throwable -> L22
        if (r104.clientCount != 0) goto L14;
        r103 = true;
    L14:
        Preconditions.checkState(r103);     // Catch: Throwable -> L22
    L15:
        if (r104 == null) goto L17;
        r102 = r104.valueRef;     // Catch: Throwable -> L22
    L17:
        r103 = true;
    L18:
        monitor-exit(this);     // Catch: Throwable -> L22
        if (r103 == false) goto L21;
        maybeNotifyExclusiveEntryRemoval(r101);
    L21:
        return r102;
    L22:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.common.memory.MemoryTrimmable
    public void trim(MemoryTrimType r100) {
        double r101 = this.mCacheTrimStrategy.getTrimRatio(r100);
        monitor-enter(this);
        trimExclusivelyOwnedEntries(Integer.MAX_VALUE, Math.max(0, ((int) (((double) this.mCachedEntries.getSizeInBytes()) * (1.0d - r101))) - getInUseSizeInBytes()));     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        maybeUpdateCacheParams();
        maybeEvictEntries();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static <K, V> void maybeNotifyExclusiveEntryRemoval(@Nullable Entry<K, V> r100) {
        if (r100 == null) goto L7;
        EntryStateObserver<K> r101 = r100.observer;
        if (r101 == null) goto L8;
        r101.onExclusivityChanged(r100.key, false);
        return;
    L8:
        return;
    }

    public synchronized boolean contains(K r100) {
        monitor-enter(this);
        boolean r101 = this.mCachedEntries.contains(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void access$000(CountingMemoryCache r100, Entry r101) {
        r100.releaseClientReference(r101);
    }

    public static /* synthetic */ void access$100(CountingMemoryCache r100, Entry r101) {
        r100.decreaseClientCount(r101);
    }

    public static /* synthetic */ boolean access$200(CountingMemoryCache r100, Entry r101) {
        return r100.maybeAddToExclusives(r101);
    }

    public static /* synthetic */ CloseableReference access$300(CountingMemoryCache r100, Entry r101) {
        return r100.referenceToClose(r101);
    }

    public static /* synthetic */ void access$700(CountingMemoryCache r100, Entry r101) {
        r100.decreaseClientCountNew(r101);
    }

    @Nullable
    private synchronized void trimExclusivelyOwnedEntries(int r100, int r101) {
        monitor-enter(this);
        int r102 = Math.max(r100, 0);     // Catch: Throwable -> L27
        int r103 = Math.max(r101, 0);     // Catch: Throwable -> L27
        if (this.mExclusiveEntries.getCount() > r102) goto L10;
        if (this.mExclusiveEntries.getSizeInBytes() > r103) goto L10;
        monitor-exit(this);
        return;
    L10:
        if (this.mExclusiveEntries.getCount() <= r102) goto L13;
    L17:
        K r104 = this.mExclusiveEntries.getFirstKey();     // Catch: Throwable -> L27
        if (r104 == null) goto L19;
        this.mExclusiveEntries.remove(r104);     // Catch: Throwable -> L27
        Entry<K, V> r105 = this.mCachedEntries.remove(r104);     // Catch: Throwable -> L27
        if (this.mMemoryCacheParams.mOptReuseMemoryCache == false) goto L24;
        MemoryCacheUtil.removeReuseBitmapCache(r104.toString());     // Catch: Throwable -> L27
    L24:
        if (r105 == null) goto L10;
        makeOrphan(r105);     // Catch: Throwable -> L27
        CloseableReference.closeSafely(referenceToClose(r105));     // Catch: Throwable -> L27
        maybeNotifyExclusiveEntryRemoval(r105);     // Catch: Throwable -> L27
        goto L10
    L19:
        monitor-exit(this);
        return;
    L13:
        if (this.mExclusiveEntries.getSizeInBytes() > r103) goto L17;
        monitor-exit(this);
        return;
    L27:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public CloseableReference<V> cache(K r100, CloseableReference<V> r101) {
        return cache(r100, r101, null);
    }

    public CountingMemoryCache(ValueDescriptor<V> r100, CacheTrimStrategy r101, Supplier<MemoryCacheParams> r102) {
        this.mOtherEntries = new WeakHashMap();
        this.mValueDescriptor = r100;
        this.mExclusiveEntries = new CountingLruMap(wrapValueDescriptor(r100));
        this.mCachedEntries = new CountingLruMap(wrapValueDescriptor(r100));
        this.mCacheTrimStrategy = r101;
        this.mMemoryCacheParamsSupplier = r102;
        this.mMemoryCacheParams = r102.get();
        this.mLastCacheParamsCheck = SystemClock.uptimeMillis();
    }

    public CloseableReference<V> cache(K r100, CloseableReference<V> r101, EntryStateObserver<K> r102) {
        Preconditions.checkNotNull(r100);
        Preconditions.checkNotNull(r101);
        maybeUpdateCacheParams();
        monitor-enter(this);
        Entry<K, V> r103 = this.mExclusiveEntries.remove(r100);     // Catch: Throwable -> L25
        Entry<K, V> r104 = this.mCachedEntries.remove(r100);     // Catch: Throwable -> L25
        CloseableReference<V> r105 = null;
        if (r104 == null) goto L7;
        makeOrphan(r104);     // Catch: Throwable -> L25
        CloseableReference<V> r106 = referenceToClose(r104);     // Catch: Throwable -> L25
    L8:
        int r107 = this.mValueDescriptor.getSizeInBytes(r101.get());     // Catch: Throwable -> L25
        if (canCacheNewValue(r101.get()) == false) goto L11;
        Entry<K, V> r108 = Entry.of(r100, r101, r102);     // Catch: Throwable -> L25
        this.mCachedEntries.put(r100, r108);     // Catch: Throwable -> L25
        r105 = newClientReference(r108);     // Catch: Throwable -> L25
    L22:
        monitor-exit(this);     // Catch: Throwable -> L25
        CloseableReference.closeSafely(r106);
        maybeNotifyExclusiveEntryRemoval(r103);
        maybeEvictEntries();
        return r105;
    L11:
        MemoryCacheParams r109 = this.mMemoryCacheParams;     // Catch: Throwable -> L25
        if (r109.mMemoryCacheOpt == false) goto L22;
        if (r107 >= Math.min(Math.min(r109.getMaxCacheSize(), this.mMemoryCacheParams.maxCacheEntrySize), this.mMemoryCacheParams.maxOptEntrySize)) goto L22;
    L16:
        if (canCacheNewValue(r101.get()) == true) goto L21;
        K r110 = this.mCachedEntries.getFirstKey();     // Catch: Throwable -> L25
        releaseClientReferenceNew(this.mCachedEntries.get(r110));     // Catch: Throwable -> L25
        this.mCachedEntries.remove(r110);     // Catch: Throwable -> L25
        if (this.mMemoryCacheParams.mOptReuseMemoryCache == false) goto L16;
        if (r110 == null) goto L16;
        MemoryCacheUtil.removeReuseBitmapCache(r110.toString());     // Catch: Throwable -> L25
        goto L16
    L21:
        Entry<K, V> r111 = Entry.of(r100, r101, r102);     // Catch: Throwable -> L25
        this.mCachedEntries.put(r100, r111);     // Catch: Throwable -> L25
        r105 = newClientReference(r111);     // Catch: Throwable -> L25
        goto L22
    L7:
        r106 = null;
    L25:
        th = move-exception;
        throw th;
    }
}
