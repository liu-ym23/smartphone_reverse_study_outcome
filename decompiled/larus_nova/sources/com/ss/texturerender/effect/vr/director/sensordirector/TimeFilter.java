package com.ss.texturerender.effect.vr.director.sensordirector;

/* JADX INFO: loaded from: classes40.dex */
public class TimeFilter {
    private static final double FILTER_COEFF = 0.949999988079071d;
    private static final int MIN_TIME_SAMPLE = 10;
    private boolean isFilterValid;
    private double mFilteredTime;
    private boolean mIsInit;
    private int mSampleCount;

    public TimeFilter() {
        this.mIsInit = false;
        this.isFilterValid = false;
    }

    public double getFilteredTime() {
        return this.mFilteredTime;
    }

    public boolean isFilterValid() {
        return this.isFilterValid;
    }

    public void addSample(double r100) {
        if (this.mIsInit == true) goto L6;
        this.mFilteredTime = r100;
        this.mIsInit = true;
        this.mSampleCount = 1;
        return;
    L6:
        this.mFilteredTime = (this.mFilteredTime * FILTER_COEFF) + (r100 * 0.050000011920928955d);
        int r101 = this.mSampleCount + 1;
        this.mSampleCount = r101;
        if (r101 <= 10) goto L10;
        this.isFilterValid = true;
        return;
    }
}
