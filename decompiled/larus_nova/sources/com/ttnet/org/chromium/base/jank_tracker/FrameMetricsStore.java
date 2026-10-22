package com.ttnet.org.chromium.base.jank_tracker;

import com.ttnet.org.chromium.build.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes41.dex */
class FrameMetricsStore {
    private final Object mLock;
    private final HashMap<Integer, Long> mScenarioPreviousFrameTimestampNs;
    private final ArrayList<Integer> mSkippedFrames;
    private final ArrayList<Long> mTimestampsNs;
    private final ArrayList<Long> mTotalDurationsNs;

    private long findFirstUsedTimestamp() {
        Iterator<Long> r100 = this.mScenarioPreviousFrameTimestampNs.values().iterator();
        long r101 = Long.MAX_VALUE;
    L4:
        if (r100.hasNext() == false) goto L8;
        long r102 = r100.next().longValue();
        if (r102 >= r101) goto L4;
        r101 = r102;
        goto L4
    L8:
        return r101;
    }

    private void removeUnusedFrames() {
        if (this.mScenarioPreviousFrameTimestampNs.isEmpty() == false) goto L6;
        this.mTimestampsNs.clear();
        this.mTotalDurationsNs.clear();
        this.mSkippedFrames.clear();
        return;
    L6:
        long r100 = findFirstUsedTimestamp();
        if (r100 != 0) goto L9;
        return;
    L9:
        int r101 = this.mTimestampsNs.indexOf(Long.valueOf(r100));
        if (r101 == (-1)) goto L12;
        this.mTimestampsNs.subList(0, r101).clear();
        this.mTotalDurationsNs.subList(0, r101).clear();
        this.mSkippedFrames.subList(0, r101).clear();
        return;
    L12:
        if (BuildConfig.ENABLE_ASSERTS == true) goto L15;
        return;
    L15:
        throw new IllegalStateException("Timestamp for tracked scenario not found");
    }

    public FrameMetrics getAllStoredMetricsForTesting() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        ArrayList<Long> r101 = this.mTimestampsNs;     // Catch: Throwable -> L7
        Long[] r102 = (Long[]) r101.toArray(new Long[r101.size()]);     // Catch: Throwable -> L7
        ArrayList<Long> r103 = this.mTotalDurationsNs;     // Catch: Throwable -> L7
        Long[] r104 = (Long[]) r103.toArray(new Long[r103.size()]);     // Catch: Throwable -> L7
        ArrayList<Integer> r105 = this.mSkippedFrames;     // Catch: Throwable -> L7
        FrameMetrics r106 = new FrameMetrics(r102, r104, (Integer[]) r105.toArray(new Integer[r105.size()]));     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r106;
    L7:
        th = move-exception;
        throw th;
    }

    public FrameMetricsStore() {
        this.mLock = new Object();
        this.mTimestampsNs = new ArrayList();
        this.mTotalDurationsNs = new ArrayList();
        this.mSkippedFrames = new ArrayList();
        this.mScenarioPreviousFrameTimestampNs = new HashMap();
    }

    public void startTrackingScenario(int r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mScenarioPreviousFrameTimestampNs.containsKey(Integer.valueOf(r100)) == false) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L14
        return;
    L8:
        Long r102 = 0L;     // Catch: Throwable -> L14
        if (this.mTimestampsNs.isEmpty() == true) goto L11;
        ArrayList<Long> r103 = this.mTimestampsNs;     // Catch: Throwable -> L14
        r102 = r103.get(r103.size() - 1);     // Catch: Throwable -> L14
    L11:
        this.mScenarioPreviousFrameTimestampNs.put(Integer.valueOf(r100), r102);     // Catch: Throwable -> L14
        monitor-exit(r101);     // Catch: Throwable -> L14
    }

    public FrameMetrics stopTrackingScenario(int r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        Long r102 = this.mScenarioPreviousFrameTimestampNs.remove(Integer.valueOf(r100));     // Catch: Throwable -> L20
        if (r102 != null) goto L10;
        FrameMetrics r103 = new FrameMetrics();     // Catch: Throwable -> L20
        monitor-exit(r101);     // Catch: Throwable -> L20
        return r103;
    L10:
        if (r102.longValue() != 0) goto L12;
        int r104 = 0;
    L17:
        int r105 = this.mTimestampsNs.size();     // Catch: Throwable -> L20
        int r106 = r105 - r104;     // Catch: Throwable -> L20
        FrameMetrics r107 = new FrameMetrics((Long[]) this.mTimestampsNs.subList(r104, r105).toArray(new Long[r106]), (Long[]) this.mTotalDurationsNs.subList(r104, r105).toArray(new Long[r106]), (Integer[]) this.mSkippedFrames.subList(r104, r105).toArray(new Integer[r106]));     // Catch: Throwable -> L20
        removeUnusedFrames();     // Catch: Throwable -> L20
        monitor-exit(r101);     // Catch: Throwable -> L20
        return r107;
    L12:
        r104 = this.mTimestampsNs.indexOf(r102) + 1;     // Catch: Throwable -> L20
        if (r104 < this.mTimestampsNs.size()) goto L17;
        FrameMetrics r108 = new FrameMetrics();     // Catch: Throwable -> L20
        monitor-exit(r101);     // Catch: Throwable -> L20
        return r108;
    L20:
        th = move-exception;
        throw th;
    }

    public void addFrameMeasurement(long r100, long r101, int r102) {
        Object r103 = this.mLock;
        monitor-enter(r103);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mScenarioPreviousFrameTimestampNs.isEmpty() == false) goto L8;
        monitor-exit(r103);     // Catch: Throwable -> L11
        return;
    L8:
        this.mTimestampsNs.add(Long.valueOf(r100));     // Catch: Throwable -> L11
        this.mTotalDurationsNs.add(Long.valueOf(r101));     // Catch: Throwable -> L11
        this.mSkippedFrames.add(Integer.valueOf(r102));     // Catch: Throwable -> L11
        monitor-exit(r103);     // Catch: Throwable -> L11
    }
}
