package com.ss.android.socialbase.downloader.network.throttle;

import android.net.TrafficStats;
import androidx.camera.video.AudioStats;
import com.ss.android.socialbase.downloader.network.ExponentialGeometricAverage;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes38.dex */
public class SmartThrottleInputStream extends ThrottleInputStream {
    private static final double DEFAULT_DECAY_CONSTANT = 0.1d;
    public static final float DEFAULT_THROTTLE_FACTOR_MAX = 0.7f;
    public static final float DEFAULT_THROTTLE_FACTOR_MIN = 0.1f;
    private static final int LEFT_MOVE = -1;
    private static final int RIGHT_MOVE = 1;
    private static final String TAG = "SmartThrottle";
    private long curReadBytes;
    private long curTotalBytes;
    private double lastOtherAvgSpeed;
    private double lastReadAvgSpeed;
    private long lastReadBytes;
    private long lastStatsSpeedTime;
    private double lastTotalAvgSpeed;
    private long lastTotalBytes;
    private long lastUpdateThrottleFactorTime;
    private int otherSpeedDeltaThreshold;
    private long overSleepTime;
    private double pendingOtherAvgSpeedDelta;
    private final ExponentialGeometricAverage readSpeedAverage;
    private long statsSpeedPeriod;
    private float throttleFactor;
    private float throttleFactorMax;
    private final float throttleFactorMiddle;
    private float throttleFactorMin;
    private int throttleFactorMoveTrend;
    private float throttleFactorStep;
    private final ExponentialGeometricAverage totalSpeedAverage;
    private long updateThrottleFactorPeriod;

    private void leftMoveThrottleFactor() {
        if (this.throttleFactor <= this.throttleFactorMiddle) goto L5;
        float r100 = (-this.throttleFactorStep) * 2.0f;
    L6:
        addThrottleFactor(r100);
        return;
    L5:
        r100 = -this.throttleFactorStep;
        goto L6
    }

    private void rightMoveThrottleFactor() {
        if (this.throttleFactor >= this.throttleFactorMiddle) goto L5;
        float r100 = this.throttleFactorStep * 2.0f;
    L6:
        addThrottleFactor(r100);
        return;
    L5:
        r100 = this.throttleFactorStep;
        goto L6
    }

    private void addThrottleFactor(float r100) {
        if (r100 <= 0.0f) goto L8;
        if (this.throttleFactor < this.throttleFactorMax) goto L12;
        r100 = -this.throttleFactorStep;
    L12:
        float r101 = this.throttleFactor + r100;
        this.throttleFactor = r101;
        if (r100 <= 0.0f) goto L15;
        this.throttleFactorMoveTrend = 1;
        float r102 = Math.min(r101, this.throttleFactorMax);
    L16:
        this.throttleFactor = r102;
        return;
    L15:
        this.throttleFactorMoveTrend = -1;
        r102 = Math.max(this.throttleFactorMin, r101);
        goto L16
    L8:
        if (r100 >= 0.0f) goto L12;
        if (this.throttleFactor > this.throttleFactorMin) goto L12;
        r100 = this.throttleFactorStep;
        goto L12
    }

    private void statsSpeed(long r100) {
        long r101 = this.lastStatsSpeedTime;
        if ((r100 - r101) < this.statsSpeedPeriod) goto L12;
        double r102 = r100 - r101;
        if (r101 > 0) goto L7;
    L10:
        this.lastStatsSpeedTime = r100;
        this.lastTotalBytes = TrafficStats.getTotalRxBytes();
        this.lastReadBytes = this.curReadBytes;
        return;
    L7:
        if (r102 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L10;
        this.lastStatsSpeedTime = r100;
        long r103 = TrafficStats.getTotalRxBytes();
        this.curTotalBytes = r103;
        long r104 = this.curReadBytes;
        long r105 = r104 - this.lastReadBytes;
        long r106 = r103 - this.lastTotalBytes;
        this.lastReadBytes = r104;
        this.lastTotalBytes = r103;
        this.readSpeedAverage.addMeasurement(r105 / r102);
        this.totalSpeedAverage.addMeasurement(r106 / r102);
        return;
    }

    private void updateThrottleFactor(long r110) {
        long r100 = this.lastUpdateThrottleFactorTime;
        if ((r110 - r100) >= this.updateThrottleFactorPeriod) goto L5;
        return;
    L5:
        if (r100 != 0) goto L8;
        this.lastUpdateThrottleFactorTime = r110;
        return;
    L8:
        this.lastUpdateThrottleFactorTime = r110;
        double r111 = this.readSpeedAverage.getAverage();
        double r101 = this.totalSpeedAverage.getAverage();
        double r102 = r101 - r111;
        double r103 = r111 - this.lastReadAvgSpeed;
        double r104 = r101 - this.lastTotalAvgSpeed;
        double r112 = r102 - this.lastOtherAvgSpeed;
        this.lastReadAvgSpeed = r111;
        this.lastTotalAvgSpeed = r101;
        this.lastOtherAvgSpeed = r102;
        int r113 = calculatorThrottleFactorTrend(r103, r104, r112);
        if (r113 <= 0) goto L11;
        rightMoveThrottleFactor();
        return;
    L11:
        if (r113 >= 0) goto L14;
        leftMoveThrottleFactor();
        return;
    L14:
        if (this.throttleFactor >= this.throttleFactorMiddle) goto L16;
        addThrottleFactor(this.throttleFactorStep);
        return;
    L16:
        addThrottleFactor(-this.throttleFactorStep);
    }

    public SmartThrottleInputStream(InputStream r100, float r101, float r102) {
        super(r100);
        this.throttleFactorMin = 0.1f;
        this.throttleFactorMax = 0.7f;
        this.throttleFactor = 0.1f;
        this.throttleFactorStep = 0.1f;
        this.statsSpeedPeriod = 1000;
        this.updateThrottleFactorPeriod = 2000;
        this.readSpeedAverage = new ExponentialGeometricAverage(DEFAULT_DECAY_CONSTANT);
        this.totalSpeedAverage = new ExponentialGeometricAverage(DEFAULT_DECAY_CONSTANT);
        this.throttleFactorMoveTrend = 1;
        this.otherSpeedDeltaThreshold = 60;
        if (r101 < r102) goto L5;
    L9:
        if (r101 < r102) goto L11;
    L15:
        this.throttleFactorMiddle = (this.throttleFactorMin + this.throttleFactorMax) / 2.0f;
        return;
    L11:
        if (r102 <= 0.0f) goto L15;
        if (r102 > 1.0f) goto L15;
        this.throttleFactorMax = r102;
        goto L15
    L5:
        if (r101 < 0.0f) goto L9;
        if (r101 >= 1.0f) goto L9;
        this.throttleFactorMin = r101;
        goto L9
    }

    private int calculatorThrottleFactorTrend(double r100, double r101, double r102) {
        double r103 = r102 + this.pendingOtherAvgSpeedDelta;
        this.pendingOtherAvgSpeedDelta = AudioStats.AUDIO_AMPLITUDE_NONE;
        int r104 = this.otherSpeedDeltaThreshold;
        if (r103 < r104) goto L6;
        return -1;
    L6:
        if (r103 >= (-r104)) goto L8;
        return -1;
    L8:
        this.pendingOtherAvgSpeedDelta = r103;
        if (r103 <= ((-r104) / 2.0f)) goto L12;
        return 1;
    L12:
        return 0;
    }

    @Override // com.ss.android.socialbase.downloader.network.throttle.ThrottleInputStream, java.io.InputStream
    public int read(byte[] r100, int r110, int r111) throws IOException {
        if (this.throttleNetSpeed != (-1)) goto L27;
        long r101 = System.currentTimeMillis();
        if ((r101 - this.periodStartTime) <= this.throttlePeriod) goto L22;
        this.periodStartTime = r101;
        statsSpeed(r101);
        updateThrottleFactor(r101);
        long r102 = (long) (this.throttlePeriod * ((double) (1.0f - this.throttleFactor)));
        long r103 = this.overSleepTime;
        if (r103 < r102) goto L10;
        this.overSleepTime = r103 - r102;
        goto L22
    L10:
        if (r103 <= 0) goto L13;
        r102 = r102 - r103;
        this.overSleepTime = 0;
    L13:
        if (r102 <= 0) goto L22;
        long r104 = System.currentTimeMillis();
        Thread.sleep(r102);     // Catch: InterruptedException -> L19
        long r105 = (System.currentTimeMillis() - r104) - r102;
        if (r105 <= 0) goto L22;
        this.overSleepTime = r105;
    L19:
        e = move-exception;
        throw new IOException(e);
    L22:
        int r106 = superRead(r100, r110, r111);
        if (r106 == (-1)) goto L25;
        this.curReadBytes += (long) r106;
    L25:
        return r106;
    L27:
        return super.read(r100, r110, r111);
    }
}
