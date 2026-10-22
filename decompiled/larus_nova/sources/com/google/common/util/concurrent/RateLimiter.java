package com.google.common.util.concurrent;

import androidx.camera.video.AudioStats;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class RateLimiter {

    @CheckForNull
    private volatile Object mutexDoNotUseDirectly;
    private final SleepingStopwatch stopwatch;

    public static abstract class SleepingStopwatch {
        public SleepingStopwatch() {
        }

        public abstract long readMicros();

        public abstract void sleepMicrosUninterruptibly(long r100);

        public static SleepingStopwatch createFromSystemTimer() {
            return new AnonymousClass1();
        }
    }

    public double acquire() {
        return acquire(1);
    }

    public abstract double doGetRate();

    public abstract void doSetRate(double r100, long r101);

    public abstract long queryEarliestAvailable(long r100);

    public abstract long reserveEarliestAvailable(int r100, long r101);

    private Object mutex() {
        Object r100 = this.mutexDoNotUseDirectly;
        if (r100 != null) goto L13;
        monitor-enter(this);
        r100 = this.mutexDoNotUseDirectly;     // Catch: Throwable -> L10
        if (r100 != null) goto L8;
        r100 = new Object();     // Catch: Throwable -> L10
        this.mutexDoNotUseDirectly = r100;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    L13:
        return r100;
    }

    public String toString() {
        return String.format(Locale.ROOT, "RateLimiter[stableRate=%3.1fqps]", new Object[]{Double.valueOf(getRate())});
    }

    public boolean tryAcquire() {
        return tryAcquire(1, 0, TimeUnit.MICROSECONDS);
    }

    public final double getRate() {
        Object r100 = mutex();
        monitor-enter(r100);
        double r101 = doGetRate();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public RateLimiter(SleepingStopwatch r100) {
        r100.getClass();
        this.stopwatch = r100;
    }

    private static void checkPermits(int r100) {
        if (r100 <= 0) goto L4;
        boolean r101 = true;
    L5:
        com.google.common.base.m.d(r101, "Requested permits (%s) must be positive", r100);
        return;
    L4:
        r101 = false;
        goto L5
    }

    public static RateLimiter create(double r100) {
        return create(r100, SleepingStopwatch.createFromSystemTimer());
    }

    public double acquire(int r100) {
        long r101 = reserve(r100);
        this.stopwatch.sleepMicrosUninterruptibly(r101);
        return (r101 * 1.0d) / TimeUnit.SECONDS.toMicros(1);
    }

    public final long reserve(int r100) {
        checkPermits(r100);
        Object r101 = mutex();
        monitor-enter(r101);
        long r102 = reserveAndGetWaitLength(r100, this.stopwatch.readMicros());     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public final void setRate(double r100) {
        if (r100 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
    L7:
        boolean r101 = false;
    L8:
        com.google.common.base.m.c(r101, "rate must be positive");
        Object r102 = mutex();
        monitor-enter(r102);
        doSetRate(r100, this.stopwatch.readMicros());     // Catch: Throwable -> L13
        monitor-exit(r102);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    L5:
        if (Double.isNaN(r100) == true) goto L7;
        r101 = true;
        goto L8
    }

    public boolean tryAcquire(int r100) {
        return tryAcquire(r100, 0, TimeUnit.MICROSECONDS);
    }

    private boolean canAcquire(long r100, long r101) {
        if ((queryEarliestAvailable(r100) - r101) > r100) goto L5;
        return true;
    L5:
        return false;
    }

    public static RateLimiter create(double r100, SleepingStopwatch r101) {
        SmoothRateLimiter.SmoothBursty r102 = new SmoothRateLimiter.SmoothBursty(r101, 1.0d);
        r102.setRate(r100);
        return r102;
    }

    public final long reserveAndGetWaitLength(int r100, long r101) {
        return Math.max(reserveEarliestAvailable(r100, r101) - r101, 0);
    }

    public boolean tryAcquire(long r100, TimeUnit r101) {
        return tryAcquire(1, r100, r101);
    }

    public static RateLimiter create(double r110, long r111, TimeUnit r112) {
        if (r111 < 0) goto L5;
        boolean r100 = true;
    L6:
        com.google.common.base.m.f(r100, "warmupPeriod must not be negative: %s", r111);
        return create(r110, r111, r112, 3.0d, SleepingStopwatch.createFromSystemTimer());
    L5:
        r100 = false;
        goto L6
    }

    public boolean tryAcquire(int r100, long r101, TimeUnit r102) {
        long r103 = Math.max(r102.toMicros(r101), 0);
        checkPermits(r100);
        Object r104 = mutex();
        monitor-enter(r104);
        long r105 = this.stopwatch.readMicros();     // Catch: Throwable -> L13
        if (canAcquire(r105, r103) == true) goto L9;
        monitor-exit(r104);     // Catch: Throwable -> L13
        return false;
    L9:
        long r106 = reserveAndGetWaitLength(r100, r105);     // Catch: Throwable -> L13
        monitor-exit(r104);     // Catch: Throwable -> L13
        this.stopwatch.sleepMicrosUninterruptibly(r106);
        return true;
    L13:
        th = move-exception;
        throw th;
    }

    public static RateLimiter create(double r100, long r110, TimeUnit r111, double r112, SleepingStopwatch r113) {
        SmoothRateLimiter.SmoothWarmingUp r101 = new SmoothRateLimiter.SmoothWarmingUp(r113, r110, r111, r112);
        r101.setRate(r100);
        return r101;
    }
}
