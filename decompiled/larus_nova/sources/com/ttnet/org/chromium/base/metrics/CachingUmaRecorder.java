package com.ttnet.org.chromium.base.metrics;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ttnet.org.chromium.base.Callback;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.build.BuildConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes41.dex */
final class CachingUmaRecorder implements UmaRecorder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MAX_HISTOGRAM_COUNT = 256;
    static final int MAX_USER_ACTION_COUNT = 256;
    private static final String TAG = "CachingUmaRecorder";
    private UmaRecorder mDelegate;
    private AtomicInteger mDroppedHistogramSampleCount;
    private int mDroppedUserActionCount;
    private Map<String, Histogram> mHistogramByName;
    private final ReentrantReadWriteLock mRwLock;
    private List<Callback<String>> mUserActionCallbacksForTesting;
    private List<UserAction> mUserActions;

    public static class Histogram {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final int MAX_SAMPLE_COUNT = 256;
        private final int mMax;
        private final int mMin;
        private final String mName;
        private final int mNumBuckets;
        private final List<Integer> mSamples;
        private final int mType;

        @Retention(RetentionPolicy.SOURCE)
        public @interface Type {
            public static final int BOOLEAN = 1;
            public static final int EXPONENTIAL = 2;
            public static final int LINEAR = 3;
            public static final int SPARSE = 4;
        }

        static {
        }

        public static /* synthetic */ List access$000(Histogram r100) {
            return r100.mSamples;
        }

        public synchronized int flushTo(UmaRecorder r100) {
            monitor-enter(this);
            int r101 = this.mType;     // Catch: Throwable -> L32
            int r102 = 0;
            if (r101 != 1) goto L6;
            int r103 = 0;
        L23:
            if (r103 >= this.mSamples.size()) goto L29;
            int r104 = ((Integer) ListProtector.get(this.mSamples, r103)).intValue();     // Catch: Throwable -> L32
            String r105 = this.mName;     // Catch: Throwable -> L32
            if (r104 == 0) goto L27;
            boolean r106 = true;
        L28:
            r100.recordBooleanHistogram(r105, r106);     // Catch: Throwable -> L32
            r103 = r103 + 1;     // Catch: Throwable -> L32
            goto L23
        L27:
            r106 = false;
        L29:
            int r107 = this.mSamples.size();     // Catch: Throwable -> L32
            this.mSamples.clear();     // Catch: Throwable -> L32
            monitor-exit(this);
            return r107;
        L6:
            if (r101 == 2) goto L19;
            if (r101 == 3) goto L16;
            if (r101 != 4) goto L29;
        L13:
            if (r102 >= this.mSamples.size()) goto L29;
            int r108 = ((Integer) ListProtector.get(this.mSamples, r102)).intValue();     // Catch: Throwable -> L32
            r100.recordSparseHistogram(this.mName, r108);     // Catch: Throwable -> L32
            r102 = r102 + 1;     // Catch: Throwable -> L32
        L16:
            if (r102 >= this.mSamples.size()) goto L29;
            int r109 = ((Integer) ListProtector.get(this.mSamples, r102)).intValue();     // Catch: Throwable -> L32
            r100.recordLinearHistogram(this.mName, r109, this.mMin, this.mMax, this.mNumBuckets);     // Catch: Throwable -> L32
            r102 = r102 + 1;     // Catch: Throwable -> L32
        L19:
            if (r102 >= this.mSamples.size()) goto L29;
            int r110 = ((Integer) ListProtector.get(this.mSamples, r102)).intValue();     // Catch: Throwable -> L32
            r100.recordExponentialHistogram(this.mName, r110, this.mMin, this.mMax, this.mNumBuckets);     // Catch: Throwable -> L32
            r102 = r102 + 1;     // Catch: Throwable -> L32
        L32:
            th = move-exception;
            throw th;
        }

        public Histogram(int r100, String r101, int r102, int r103, int r104) {
            this.mType = r100;
            this.mName = r101;
            this.mMin = r102;
            this.mMax = r103;
            this.mNumBuckets = r104;
            this.mSamples = new ArrayList(1);
        }

        public synchronized boolean addSample(int r100, String r101, int r102, int r103, int r104, int r105) {
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L5:
            if (this.mSamples.size() < 256) goto L9;
            monitor-exit(this);
            return false;
        L9:
            this.mSamples.add(Integer.valueOf(r102));     // Catch: Throwable -> L13
            monitor-exit(this);
            return true;
        }
    }

    public static class UserAction {
        private final long mElapsedRealtimeMillis;
        private final String mName;

        public void flushTo(UmaRecorder r100) {
            r100.recordUserAction(this.mName, this.mElapsedRealtimeMillis);
        }

        public UserAction(String r100, long r101) {
            this.mName = r100;
            this.mElapsedRealtimeMillis = r101;
        }
    }

    public CachingUmaRecorder() {
        this.mRwLock = new ReentrantReadWriteLock(false);
        this.mHistogramByName = new HashMap();
        this.mDroppedHistogramSampleCount = new AtomicInteger();
        this.mUserActions = new ArrayList();
    }

    static {
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void addUserActionCallbackForTesting(Callback<String> r100) {
        this.mRwLock.writeLock().lock();
    L11:
        th = move-exception;
        this.mRwLock.writeLock().unlock();
        throw th;
    L4:
        if (this.mUserActionCallbacksForTesting != null) goto L6;
        this.mUserActionCallbacksForTesting = new ArrayList();     // Catch: Throwable -> L11
    L6:
        this.mUserActionCallbacksForTesting.add(r100);     // Catch: Throwable -> L11
        UmaRecorder r101 = this.mDelegate;     // Catch: Throwable -> L11
        if (r101 == null) goto L9;
        r101.addUserActionCallbackForTesting(r100);     // Catch: Throwable -> L11
    L9:
        this.mRwLock.writeLock().unlock();
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public int getHistogramTotalCountForTesting(String r100) {
        this.mRwLock.readLock().lock();
        UmaRecorder r101 = this.mDelegate;     // Catch: Throwable -> L20
        if (r101 == null) goto L8;
        int r102 = r101.getHistogramTotalCountForTesting(r100);     // Catch: Throwable -> L20
        this.mRwLock.readLock().unlock();
        return r102;
    L8:
        Histogram r103 = this.mHistogramByName.get(r100);     // Catch: Throwable -> L20
        if (r103 != null) goto L12;
        this.mRwLock.readLock().unlock();
        return 0;
    L12:
        monitor-enter(r103);     // Catch: Throwable -> L20
        int r104 = Histogram.access$000(r103).size();     // Catch: Throwable -> L17
        monitor-exit(r103);     // Catch: Throwable -> L17
        this.mRwLock.readLock().unlock();
        return r104;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        this.mRwLock.readLock().unlock();
        throw th;
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void removeUserActionCallbackForTesting(Callback<String> r100) {
        this.mRwLock.writeLock().lock();
        List<Callback<String>> r101 = this.mUserActionCallbacksForTesting;     // Catch: Throwable -> L12
        if (r101 != null) goto L7;
        this.mRwLock.writeLock().unlock();
        return;
    L7:
        r101.remove(r100);     // Catch: Throwable -> L12
        UmaRecorder r102 = this.mDelegate;     // Catch: Throwable -> L12
        if (r102 == null) goto L10;
        r102.removeUserActionCallbackForTesting(r100);     // Catch: Throwable -> L12
    L10:
        this.mRwLock.writeLock().unlock();
        return;
    L12:
        th = move-exception;
        this.mRwLock.writeLock().unlock();
        throw th;
    }

    public UmaRecorder setDelegate(UmaRecorder r100) {
        this.mRwLock.writeLock().lock();
        UmaRecorder r101 = this.mDelegate;     // Catch: Throwable -> L29
        this.mDelegate = r100;     // Catch: Throwable -> L29
        if (BuildConfig.IS_FOR_TEST == false) goto L6;
        swapUserActionCallbacksForTesting(r101, r100);     // Catch: Throwable -> L29
    L6:
        if (r100 != null) goto L9;
        this.mRwLock.writeLock().unlock();
        return r101;
    L9:
        List<UserAction> r102 = null;
        int r103 = 0;
        if (this.mHistogramByName.isEmpty() == true) goto L12;
        Map<String, Histogram> r104 = this.mHistogramByName;     // Catch: Throwable -> L29
        this.mHistogramByName = new HashMap();     // Catch: Throwable -> L29
        int r105 = this.mDroppedHistogramSampleCount.getAndSet(0);     // Catch: Throwable -> L29
    L14:
        if (this.mUserActions.isEmpty() == true) goto L16;
        r102 = this.mUserActions;     // Catch: Throwable -> L29
        this.mUserActions = new ArrayList();     // Catch: Throwable -> L29
        int r106 = this.mDroppedUserActionCount;     // Catch: Throwable -> L29
        this.mDroppedUserActionCount = 0;     // Catch: Throwable -> L29
        r103 = r106;
    L16:
        this.mRwLock.readLock().lock();     // Catch: Throwable -> L29
        this.mRwLock.writeLock().unlock();
        if (r104 != null) goto L34;
    L22:
        if (r102 == null) goto L27;
        flushUserActionsAlreadyLocked(r102, r103);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        this.mRwLock.readLock().unlock();
        throw th;
    L27:
        this.mRwLock.readLock().unlock();
        return r101;
    L34:
        flushHistogramsAlreadyLocked(r104, r105);     // Catch: Throwable -> L20
        goto L22
    L12:
        r104 = null;
        r105 = 0;
    L29:
        th = move-exception;
        this.mRwLock.writeLock().unlock();
        throw th;
    }

    private void flushHistogramsAlreadyLocked(Map<String, Histogram> r110, int r111) {
        int r100 = r110.size();
        Iterator<Histogram> r112 = r110.values().iterator();
        int r101 = 0;
    L4:
        if (r112.hasNext() == false) goto L6;
        r101 = r101 + r112.next().flushTo(this.mDelegate);
        goto L4
    L6:
        Log.i(TAG, "Flushed %d samples from %d histograms.", new Object[]{Integer.valueOf(r101), Integer.valueOf(r100)});
        this.mDelegate.recordExponentialHistogram("UMA.JavaCachingRecorder.DroppedHistogramSampleCount", r111, 1, 1000000, 50);
        this.mDelegate.recordExponentialHistogram("UMA.JavaCachingRecorder.FlushedHistogramCount", r100, 1, 100000, 50);
        this.mDelegate.recordExponentialHistogram("UMA.JavaCachingRecorder.InputHistogramSampleCount", r101 + r111, 1, 1000000, 50);
    }

    private void flushUserActionsAlreadyLocked(List<UserAction> r110, int r111) {
        Iterator<UserAction> r100 = r110.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().flushTo(this.mDelegate);
        goto L4
    L6:
        this.mDelegate.recordExponentialHistogram("UMA.JavaCachingRecorder.DroppedUserActionCount", r111, 1, 1000, 50);
        this.mDelegate.recordExponentialHistogram("UMA.JavaCachingRecorder.InputUserActionCount", r110.size() + r111, 1, 10000, 50);
    }

    private void swapUserActionCallbacksForTesting(UmaRecorder r100, UmaRecorder r101) {
        if (this.mUserActionCallbacksForTesting != null) goto L5;
        return;
    L5:
        int r102 = 0;
    L7:
        if (r102 >= this.mUserActionCallbacksForTesting.size()) goto L13;
        if (r100 == null) goto L10;
        r100.removeUserActionCallbackForTesting((Callback) ListProtector.get(this.mUserActionCallbacksForTesting, r102));
    L10:
        if (r101 == null) goto L12;
        r101.addUserActionCallbackForTesting((Callback) ListProtector.get(this.mUserActionCallbacksForTesting, r102));
    L12:
        r102 = r102 + 1;
        goto L7
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public int getHistogramValueCountForTesting(String r100, int r101) {
        this.mRwLock.readLock().lock();
        UmaRecorder r102 = this.mDelegate;     // Catch: Throwable -> L27
        if (r102 == null) goto L8;
        int r103 = r102.getHistogramValueCountForTesting(r100, r101);     // Catch: Throwable -> L27
        this.mRwLock.readLock().unlock();
        return r103;
    L8:
        Histogram r104 = this.mHistogramByName.get(r100);     // Catch: Throwable -> L27
        int r105 = 0;
        if (r104 != null) goto L13;
        this.mRwLock.readLock().unlock();
        return 0;
    L13:
        monitor-enter(r104);     // Catch: Throwable -> L27
        int r106 = 0;
    L30:
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L16:
        if (r105 >= Histogram.access$000(r104).size()) goto L21;
        if (((Integer) Histogram.access$000(r104).get(r105)).intValue() != r101) goto L20;
        r106 = r106 + 1;     // Catch: Throwable -> L24
    L20:
        r105 = r105 + 1;     // Catch: Throwable -> L24
        goto L30
    L21:
        monitor-exit(r104);     // Catch: Throwable -> L24
        this.mRwLock.readLock().unlock();
        return r106;
    L27:
        th = move-exception;
        this.mRwLock.readLock().unlock();
        throw th;
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordBooleanHistogram(String r100, boolean r101) {
        cacheOrRecordHistogramSample(1, r100, r101 ? 1 : 0, 0, 0, 0);
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordSparseHistogram(String r100, int r101) {
        cacheOrRecordHistogramSample(4, r100, r101, 0, 0, 0);
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordUserAction(String r100, long r101) {
        this.mRwLock.readLock().lock();
        UmaRecorder r102 = this.mDelegate;     // Catch: Throwable -> L35
        if (r102 == null) goto L8;
        r102.recordUserAction(r100, r101);     // Catch: Throwable -> L35
        this.mRwLock.readLock().unlock();
        return;
    L8:
        this.mRwLock.readLock().unlock();
        this.mRwLock.writeLock().lock();
    L32:
        th = move-exception;
        this.mRwLock.writeLock().unlock();
        throw th;
    L10:
        if (this.mDelegate == null) goto L12;
        this.mRwLock.readLock().lock();     // Catch: Throwable -> L32
        this.mRwLock.writeLock().unlock();
        this.mDelegate.recordUserAction(r100, r101);     // Catch: Throwable -> L29
        this.mRwLock.readLock().unlock();
        return;
    L29:
        th = move-exception;
        this.mRwLock.readLock().unlock();
        throw th;
    L12:
        if (this.mUserActions.size() >= 256) goto L14;
        this.mUserActions.add(new UserAction(r100, r101));     // Catch: Throwable -> L32
    L16:
        if (this.mUserActionCallbacksForTesting == null) goto L22;
        int r103 = 0;
    L19:
        if (r103 >= this.mUserActionCallbacksForTesting.size()) goto L22;
        this.mUserActionCallbacksForTesting.get(r103).onResult(r100);     // Catch: Throwable -> L32
        r103 = r103 + 1;
    L22:
        this.mRwLock.writeLock().unlock();
        return;
    L14:
        this.mDroppedUserActionCount++;     // Catch: Throwable -> L32
    L35:
        th = move-exception;
        this.mRwLock.readLock().unlock();
        throw th;
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordExponentialHistogram(String r100, int r101, int r110, int r111, int r112) {
        cacheOrRecordHistogramSample(2, r100, r101, r110, r111, r112);
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordLinearHistogram(String r100, int r101, int r110, int r111, int r112) {
        cacheOrRecordHistogramSample(3, r100, r101, r110, r111, r112);
    }

    private void cacheHistogramSampleAlreadyWriteLocked(int r100, String r110, int r111, int r112, int r113, int r114) {
        Histogram r101 = this.mHistogramByName.get(r110);
        if (r101 != null) goto L10;
        if (this.mHistogramByName.size() < 256) goto L8;
        this.mDroppedHistogramSampleCount.incrementAndGet();
        return;
    L8:
        Histogram r102 = new Histogram(r100, r110, r112, r113, r114);
        this.mHistogramByName.put(r110, r102);
        r101 = r102;
    L10:
        if (r101.addSample(r100, r110, r111, r112, r113, r114) == true) goto L13;
        this.mDroppedHistogramSampleCount.incrementAndGet();
        return;
    }

    private void cacheOrRecordHistogramSample(int r100, String r101, int r102, int r103, int r104, int r105) {
        if (tryAppendOrRecordSample(r100, r101, r102, r103, r104, r105) == false) goto L5;
        return;
    L5:
        this.mRwLock.writeLock().lock();
    L19:
        th = move-exception;
        this.mRwLock.writeLock().unlock();
        throw th;
    L7:
        if (this.mDelegate != null) goto L11;
        cacheHistogramSampleAlreadyWriteLocked(r100, r101, r102, r103, r104, r105);     // Catch: Throwable -> L19
        this.mRwLock.writeLock().unlock();
        return;
    L11:
        this.mRwLock.readLock().lock();     // Catch: Throwable -> L19
        this.mRwLock.writeLock().unlock();
        recordHistogramSampleAlreadyLocked(r100, r101, r102, r103, r104, r105);     // Catch: Throwable -> L16
        this.mRwLock.readLock().unlock();
        return;
    L16:
        th = move-exception;
        this.mRwLock.readLock().unlock();
        throw th;
    }

    private void recordHistogramSampleAlreadyLocked(int r100, String r101, int r110, int r111, int r112, int r113) {
        boolean r102 = true;
        if (r100 != 1) goto L5;
        UmaRecorder r103 = this.mDelegate;
        if (r110 != 0) goto L19;
        r102 = false;
    L19:
        r103.recordBooleanHistogram(r101, r102);
        return;
    L5:
        if (r100 != 2) goto L7;
        this.mDelegate.recordExponentialHistogram(r101, r110, r111, r112, r113);
        return;
    L7:
        if (r100 != 3) goto L9;
        this.mDelegate.recordLinearHistogram(r101, r110, r111, r112, r113);
        return;
    L9:
        if (r100 != 4) goto L12;
        this.mDelegate.recordSparseHistogram(r101, r110);
        return;
    L12:
        throw new UnsupportedOperationException("Unknown histogram type " + r100);
    }

    private boolean tryAppendOrRecordSample(int r110, String r111, int r112, int r113, int r114, int r115) {
        this.mRwLock.readLock().lock();
    L17:
        th = move-exception;
        this.mRwLock.readLock().unlock();
        throw th;
    L4:
        if (this.mDelegate == null) goto L8;
        recordHistogramSampleAlreadyLocked(r110, r111, r112, r113, r114, r115);     // Catch: Throwable -> L17
    L6:
        this.mRwLock.readLock().unlock();
        return true;
    L8:
        Histogram r100 = this.mHistogramByName.get(r111);     // Catch: Throwable -> L17
        if (r100 != null) goto L14;
        this.mRwLock.readLock().unlock();
        return false;
    L14:
        if (r100.addSample(r110, r111, r112, r113, r114, r115) == true) goto L6;
        this.mDroppedHistogramSampleCount.incrementAndGet();     // Catch: Throwable -> L17
        goto L6
    }
}
