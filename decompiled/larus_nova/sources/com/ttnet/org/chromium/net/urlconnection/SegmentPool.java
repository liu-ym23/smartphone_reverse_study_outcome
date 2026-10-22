package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.base.Logger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes41.dex */
public final class SegmentPool {
    static long byteCount = 0;
    static Segment next = null;
    private static long sMaxPoolSize = 262144;
    private static long sMinIdleSizeSinceLastCheck = 0;
    private static long sMinPoolSize = 131072;
    private static boolean sSizesSet;
    private static final AtomicLong segmentAllocateTimes = null;
    private static final AtomicLong segmentRequestTimes = null;
    private static final AtomicLong segmentReuseTimes = null;

    public SegmentPool() {
    }

    public static Segment take() {
        Segment r100 = take(false);
        if (Logger.debug() == false) goto L5;
        StringBuilder r101 = new StringBuilder("after take state:当前pool中segment数量: ");
        r101.append(byteCount / ((long) Segment.getSize()));
        r101.append(" 请求次数: ");
        AtomicLong r102 = segmentRequestTimes;
        r101.append(r102.get());
        r101.append(" 不复用次数: ");
        r101.append(segmentAllocateTimes.get());
        r101.append(" 复用次数: ");
        AtomicLong r103 = segmentReuseTimes;
        r101.append(r103.get());
        r101.append(" 复用率: ");
        r101.append(r103.get() / r102.get());
        Logger.d("SegmentPool", r101.toString());
    L5:
        return r100;
    }

    static {
        segmentAllocateTimes = new AtomicLong(0);
        segmentReuseTimes = new AtomicLong(0);
        segmentRequestTimes = new AtomicLong(0);
    }

    public static boolean checkAndReleaseIdleSegments() {
        monitor-enter(SegmentPool.class);
    L31:
        th = move-exception;
        throw th;
    L5:
        if (Logger.debug() == false) goto L7;
        Logger.d("SegmentPool", "sMinIdleSizeSinceLastCheck before reset " + (sMinIdleSizeSinceLastCheck / ((long) Segment.getSize())) + ", byteCount: " + (byteCount / ((long) Segment.getSize())));     // Catch: Throwable -> L31
    L7:
        long r100 = byteCount;     // Catch: Throwable -> L31
        long r101 = sMinPoolSize;     // Catch: Throwable -> L31
        if (r100 <= r101) goto L10;
        long r102 = Math.max(r101, r100 - sMinIdleSizeSinceLastCheck);     // Catch: Throwable -> L31
        if (Logger.debug() == false) goto L18;
        Logger.d("SegmentPool", "segment count want save targetByteCount " + (r102 / ((long) Segment.getSize())));     // Catch: Throwable -> L31
    L18:
        long r103 = byteCount;     // Catch: Throwable -> L31
        if (r103 > r102) goto L25;
        sMinIdleSizeSinceLastCheck = r103;     // Catch: Throwable -> L31
        if (Logger.debug() == false) goto L23;
        Logger.d("SegmentPool", "will not shrink 2");     // Catch: Throwable -> L31
    L23:
        monitor-exit(SegmentPool.class);     // Catch: Throwable -> L31
        return false;
    L25:
        releaseSegmentsToTarget(r102);     // Catch: Throwable -> L31
        sMinIdleSizeSinceLastCheck = byteCount;     // Catch: Throwable -> L31
        if (Logger.debug() == false) goto L28;
        Logger.d("SegmentPool", "segment count has been reset to " + (sMinIdleSizeSinceLastCheck / ((long) Segment.getSize())));     // Catch: Throwable -> L31
    L28:
        monitor-exit(SegmentPool.class);     // Catch: Throwable -> L31
        return true;
    L10:
        if (Logger.debug() == false) goto L12;
        Logger.d("SegmentPool", "will not shrink 1");     // Catch: Throwable -> L31
    L12:
        sMinIdleSizeSinceLastCheck = byteCount;     // Catch: Throwable -> L31
        monitor-exit(SegmentPool.class);     // Catch: Throwable -> L31
        return false;
    }

    public static boolean recycle(Segment r110) {
        if (r110.next != null) goto L26;
        if (r110.prev != null) goto L26;
        monitor-enter(SegmentPool.class);
        long r100 = Segment.getSize();     // Catch: Throwable -> L22
        long r101 = byteCount;     // Catch: Throwable -> L22
        if ((r101 + r100) > sMaxPoolSize) goto L11;
        byteCount = r101 + r100;     // Catch: Throwable -> L22
        r110.next = next;     // Catch: Throwable -> L22
        next = r110;     // Catch: Throwable -> L22
        if (Logger.debug() == false) goto L19;
        Logger.d("SegmentPool", "after recycle state:当前pool中segment数量: " + (byteCount / ((long) Segment.getSize())));     // Catch: Throwable -> L22
    L19:
        monitor-exit(SegmentPool.class);     // Catch: Throwable -> L22
        return true;
    L11:
        if (Logger.debug() == false) goto L13;
        Logger.d("SegmentPool", "full, will not recycle this segment");     // Catch: Throwable -> L22
    L13:
        monitor-exit(SegmentPool.class);     // Catch: Throwable -> L22
        return false;
    L22:
        th = move-exception;
        throw th;
    L26:
        throw new IllegalArgumentException("Segment is still in use");
    }

    private static void releaseSegmentsToTarget(long r100) {
        if (byteCount > r100) goto L5;
        return;
    L5:
        int r101 = (int) Math.ceil((byteCount - r100) / Segment.getSize());
        if (Logger.debug() == false) goto L8;
        Logger.d("SegmentPool", "releaseSegmentsToTarget, targetByteCount: " + r100 + ", segmentsToRelease: " + r101);
    L8:
        int r102 = 0;
    L9:
        if (r102 >= r101) goto L11;
        take(true);
        r102 = r102 + 1;
        goto L9
    }

    public static Segment take(boolean r110) {
        monitor-enter(SegmentPool.class);
    L33:
        th = move-exception;
        throw th;
    L5:
        if (Logger.debug() == false) goto L9;
        if (r110 == true) goto L9;
        segmentRequestTimes.incrementAndGet();     // Catch: Throwable -> L33
    L9:
        if (next != null) goto L11;
        monitor-exit(SegmentPool.class);     // Catch: Throwable -> L33
        if (r110 == false) goto L28;
        return null;
    L28:
        if (Logger.debug() == false) goto L31;
        segmentAllocateTimes.incrementAndGet();
    L31:
        return new Segment();
    L11:
        if (Logger.debug() == false) goto L14;
        if (r110 == true) goto L14;
        segmentReuseTimes.incrementAndGet();     // Catch: Throwable -> L33
    L14:
        Segment r100 = next;     // Catch: Throwable -> L33
        next = r100.next;     // Catch: Throwable -> L33
        r100.next = null;     // Catch: Throwable -> L33
        byteCount -= (long) Segment.getSize();     // Catch: Throwable -> L33
        if (Logger.debug() == false) goto L17;
        Logger.d("SegmentPool", "sMinIdleSizeSinceLastCheck check if decreased, current is " + (sMinIdleSizeSinceLastCheck / ((long) Segment.getSize())));     // Catch: Throwable -> L33
    L17:
        long r101 = byteCount;     // Catch: Throwable -> L33
        if (r101 >= sMinIdleSizeSinceLastCheck) goto L23;
        if (r110 == true) goto L23;
        sMinIdleSizeSinceLastCheck = r101;     // Catch: Throwable -> L33
        if (Logger.debug() == false) goto L23;
        Logger.d("SegmentPool", "segment count decreased to " + (sMinIdleSizeSinceLastCheck / ((long) Segment.getSize())));     // Catch: Throwable -> L33
    L23:
        monitor-exit(SegmentPool.class);     // Catch: Throwable -> L33
        return r100;
    }

    public static void setSizes(long r100, long r101) {
        if (r100 < 0) goto L25;
        if (r101 <= 0) goto L23;
        if (r100 > r101) goto L21;
        monitor-enter(SegmentPool.class);
    L17:
        th = move-exception;
        throw th;
    L11:
        if (sSizesSet == false) goto L14;
        monitor-exit(SegmentPool.class);     // Catch: Throwable -> L17
        return;
    L14:
        sMinPoolSize = r100;     // Catch: Throwable -> L17
        sMaxPoolSize = r101;     // Catch: Throwable -> L17
        sSizesSet = true;     // Catch: Throwable -> L17
        releaseSegmentsToTarget(r101);     // Catch: Throwable -> L17
        monitor-exit(SegmentPool.class);     // Catch: Throwable -> L17
        return;
    L21:
        throw new IllegalArgumentException("Minimum pool size cannot be greater than maximum pool size");
    L23:
        throw new IllegalArgumentException("Max pool size cannot be negative");
    L25:
        throw new IllegalArgumentException("Minimum pool size cannot be negative");
    }
}
