package com.ss.texturerender.effect.vr.director.sensordirector;

import com.ss.texturerender.math.Vector3d;

/* JADX INFO: loaded from: classes40.dex */
public class LowPassFilter {
    private static final double MAX_TIME_STEP = 1.0d;
    private static final double MIN_TIME_STEP = 0.001d;
    private static final double NANOS_TO_SECONDS = 1.0E-9d;
    private final Vector3d filteredData;
    private boolean mIsInit;
    private long mLastTimestampNs;
    private int mNumSamples;
    private final double mTimeConstantSecs;
    private final Vector3d temp;

    public Vector3d getFilteredData() {
        return this.filteredData;
    }

    public int getNumSamples() {
        return this.mNumSamples;
    }

    public long getRecentTime() {
        return this.mLastTimestampNs;
    }

    public boolean isIsInit() {
        return this.mIsInit;
    }

    public LowPassFilter(double r100) {
        this.filteredData = new Vector3d();
        this.temp = new Vector3d();
        this.mIsInit = false;
        this.mTimeConstantSecs = 1.0d / (r100 * 6.283185307179586d);
    }

    public void addSample(Vector3d r100, long r101) {
        addWeightedSample(r100, r101, 1.0d);
    }

    public void addWeightedSample(Vector3d r100, long r101, double r102) {
        this.mNumSamples++;
        if (this.mIsInit == true) goto L6;
        this.filteredData.set(r100);
        this.mLastTimestampNs = r101;
        this.mIsInit = true;
        return;
    L6:
        long r103 = this.mLastTimestampNs;
        if (r101 >= r103) goto L10;
        this.mLastTimestampNs = r101;
        return;
    L10:
        double r104 = (r102 * (r101 - r103)) * 1.0E-9d;
        if (r104 >= MIN_TIME_STEP) goto L13;
    L17:
        this.mLastTimestampNs = r101;
        return;
    L13:
        if (r104 > 1.0d) goto L17;
        double r105 = r104 / (this.mTimeConstantSecs + r104);
        this.filteredData.scale(1.0d - r105);
        this.temp.set(r100);
        this.temp.scale(r105);
        Vector3d r106 = this.temp;
        Vector3d r107 = this.filteredData;
        Vector3d.add(r106, r107, r107);
        this.mLastTimestampNs = r101;
    }
}
