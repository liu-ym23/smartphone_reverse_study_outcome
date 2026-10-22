package com.ss.android.lark.gadget.util;

import android.os.SystemClock;
import com.bytedance.ee.lark.infra.foundation.log.AppBrandLogger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes36.dex */
public class TimeMeter {
    private static final long INIT_LEFT_VAL = -1;
    private static final String TAG = "TimeMeter";
    private AtomicLong mLeftPoint;
    private AtomicLong mLength;
    private volatile long mStartPoint;

    public long getMillisAfterStart() {
        if (this.mStartPoint != (-1)) goto L7;
        return 0;
    L7:
        return currentMillis() - this.mStartPoint;
    }

    public boolean isRunning() {
        if ((-1) != this.mLeftPoint.addAndGet(0)) goto L5;
    L7:
        return false;
    L5:
        if (0 != this.mLength.addAndGet(0)) goto L7;
        return true;
    }

    public long stop() {
        long r100 = this.mLeftPoint.get();
        if ((-1) == r100) goto L5;
        long r101 = currentMillis() - r100;
    L7:
        if (this.mLength.compareAndSet(0, r101) == false) goto L9;
        this.mLeftPoint.set(-1);
        AppBrandLogger.d(TAG, new Object[]{"stop: success " + this.mLength});
    L11:
        return this.mLength.get();
    L9:
        AppBrandLogger.d(TAG, new Object[]{"stop: fail " + this.mLength});
        goto L11
    L5:
        r101 = 0;
        goto L7
    }

    public TimeMeter() {
        this.mLength = new AtomicLong(0);
        AtomicLong r100 = new AtomicLong(-1);
        this.mLeftPoint = r100;
        this.mStartPoint = r100.get();
    }

    public static long currentMillis() {
        return SystemClock.uptimeMillis();
    }

    public static TimeMeter newAndStart() {
        return newAndStart(currentMillis());
    }

    public long start() {
        return start(currentMillis());
    }

    public static TimeMeter newAndStart(long r100) {
        TimeMeter r101 = new TimeMeter();
        r101.start(r100);
        return r101;
    }

    public static long nowAfterStart(TimeMeter r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.getMillisAfterStart();
    }

    public static long nowDiff(long r100) {
        return currentMillis() - r100;
    }

    private long start(long r100) {
        if (this.mLeftPoint.compareAndSet(-1, r100) == false) goto L5;
        this.mLength.set(0);
        this.mStartPoint = this.mLeftPoint.get();
        AppBrandLogger.d(TAG, new Object[]{"start: success " + this.mLeftPoint});
    L7:
        return this.mLeftPoint.get();
    L5:
        AppBrandLogger.d(TAG, new Object[]{"start: fail " + this.mLeftPoint});
        goto L7
    }

    public static long stop(TimeMeter r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.stop();
    }
}
