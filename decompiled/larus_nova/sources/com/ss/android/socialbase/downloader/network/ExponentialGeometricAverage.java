package com.ss.android.socialbase.downloader.network;

import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes38.dex */
public class ExponentialGeometricAverage {
    private int mCount;
    private final int mCutover;
    private final double mDecayConstant;
    private volatile double mRealTimeSpeed;
    private double mValue;

    public void reset() {
        this.mValue = -1.0d;
        this.mCount = 0;
    }

    public double getAverage() {
        return this.mValue;
    }

    public double getRealTimeSpeed() {
        return this.mRealTimeSpeed;
    }

    public ExponentialGeometricAverage(double r100) {
        this.mValue = -1.0d;
        this.mRealTimeSpeed = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mDecayConstant = r100;
        if (r100 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        int r101 = Integer.MAX_VALUE;
    L6:
        this.mCutover = r101;
        return;
    L5:
        r101 = (int) Math.ceil(1.0d / r100);
        goto L6
    }

    public void addMeasurement(double r100) {
        this.mRealTimeSpeed = r100;
        double r101 = 1.0d - this.mDecayConstant;
        int r102 = this.mCount;
        if (r102 <= this.mCutover) goto L5;
        this.mValue = Math.exp((r101 * Math.log(this.mValue)) + (this.mDecayConstant * Math.log(r100)));
    L8:
        this.mCount++;
        return;
    L5:
        if (r102 <= 0) goto L7;
        double r103 = (r101 * ((double) r102)) / (((double) r102) + 1.0d);
        this.mValue = Math.exp((r103 * Math.log(this.mValue)) + ((1.0d - r103) * Math.log(r100)));
        goto L8
    L7:
        this.mValue = r100;
        goto L8
    }
}
