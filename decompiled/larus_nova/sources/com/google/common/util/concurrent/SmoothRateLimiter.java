package com.google.common.util.concurrent;

import androidx.camera.video.AudioStats;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
abstract class SmoothRateLimiter extends RateLimiter {
    double maxPermits;
    private long nextFreeTicketMicros;
    double stableIntervalMicros;
    double storedPermits;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.SmoothRateLimiter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class SmoothBursty extends SmoothRateLimiter {
        final double maxBurstSeconds;

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public long storedPermitsToWaitTime(double r100, double r101) {
            return 0;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public double coolDownIntervalMicros() {
            return this.stableIntervalMicros;
        }

        public SmoothBursty(RateLimiter.SleepingStopwatch r100, double r101) {
            super(r100, null);
            this.maxBurstSeconds = r101;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public void doSetRate(double r100, double r101) {
            double r102 = this.maxPermits;
            double r103 = this.maxBurstSeconds * r100;
            this.maxPermits = r103;
            if (r102 != Double.POSITIVE_INFINITY) goto L5;
            this.storedPermits = r103;
            return;
        L5:
            double r104 = AudioStats.AUDIO_AMPLITUDE_NONE;
            if (r102 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L9;
            r104 = (this.storedPermits * r103) / r102;
        L9:
            this.storedPermits = r104;
        }
    }

    public static final class SmoothWarmingUp extends SmoothRateLimiter {
        private double coldFactor;
        private double slope;
        private double thresholdPermits;
        private final long warmupPeriodMicros;

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public double coolDownIntervalMicros() {
            return this.warmupPeriodMicros / this.maxPermits;
        }

        private double permitsToTime(double r100) {
            return this.stableIntervalMicros + (r100 * this.slope);
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public void doSetRate(double r100, double r110) {
            double r101 = this.maxPermits;
            double r102 = this.coldFactor * r110;
            long r103 = this.warmupPeriodMicros;
            double r104 = (r103 * 0.5d) / r110;
            this.thresholdPermits = r104;
            double r105 = ((r103 * 2.0d) / (r110 + r102)) + r104;
            this.maxPermits = r105;
            this.slope = (r102 - r110) / (r105 - r104);
            if (r101 != Double.POSITIVE_INFINITY) goto L6;
            this.storedPermits = AudioStats.AUDIO_AMPLITUDE_NONE;
            return;
        L6:
            if (r101 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L9;
            r105 = (this.storedPermits * r105) / r101;
        L9:
            this.storedPermits = r105;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public long storedPermitsToWaitTime(double r100, double r101) {
            double r102 = r100 - this.thresholdPermits;
            if (r102 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
            double r103 = Math.min(r102, r101);
            long r104 = (long) (((permitsToTime(r102) + permitsToTime(r102 - r103)) * r103) / 2.0d);
            r101 = r101 - r103;
        L7:
            return r104 + ((long) (this.stableIntervalMicros * r101));
        L5:
            r104 = 0;
            goto L7
        }

        public SmoothWarmingUp(RateLimiter.SleepingStopwatch r100, long r101, TimeUnit r102, double r103) {
            super(r100, null);
            this.warmupPeriodMicros = r102.toMicros(r101);
            this.coldFactor = r103;
        }
    }

    public abstract double coolDownIntervalMicros();

    public abstract void doSetRate(double r100, double r101);

    public abstract long storedPermitsToWaitTime(double r100, double r101);

    @Override // com.google.common.util.concurrent.RateLimiter
    public final double doGetRate() {
        return TimeUnit.SECONDS.toMicros(1) / this.stableIntervalMicros;
    }

    private SmoothRateLimiter(RateLimiter.SleepingStopwatch r100) {
        super(r100);
        this.nextFreeTicketMicros = 0;
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    public final long queryEarliestAvailable(long r100) {
        return this.nextFreeTicketMicros;
    }

    public void resync(long r100) {
        long r101 = this.nextFreeTicketMicros;
        if (r100 <= r101) goto L6;
        this.storedPermits = Math.min(this.maxPermits, this.storedPermits + ((r100 - r101) / coolDownIntervalMicros()));
        this.nextFreeTicketMicros = r100;
        return;
    }

    public /* synthetic */ SmoothRateLimiter(RateLimiter.SleepingStopwatch r100, AnonymousClass1 r101) {
        this(r100);
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    public final void doSetRate(double r100, long r101) {
        resync(r101);
        double r102 = TimeUnit.SECONDS.toMicros(1) / r100;
        this.stableIntervalMicros = r102;
        doSetRate(r100, r102);
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    public final long reserveEarliestAvailable(int r110, long r111) {
        resync(r111);
        long r112 = this.nextFreeTicketMicros;
        double r100 = r110;
        double r101 = Math.min(r100, this.storedPermits);
        long r102 = storedPermitsToWaitTime(this.storedPermits, r101) + ((long) ((r100 - r101) * this.stableIntervalMicros));
        long r103 = this.nextFreeTicketMicros;
        long r104 = r103 + r102;
        boolean r113 = false;
        if ((r102 ^ r103) >= 0) goto L5;
        boolean r105 = true;
    L7:
        if ((r103 ^ r104) < 0) goto L10;
        r113 = true;
    L10:
        if ((r113 | r105) == true) goto L13;
        r104 = ((r104 >>> 63) ^ 1) + Long.MAX_VALUE;
    L13:
        this.nextFreeTicketMicros = r104;
        this.storedPermits -= r101;
        return r112;
    L5:
        r105 = false;
        goto L7
    }
}
