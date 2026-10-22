package com.ss.ttvideoengine.selector.shift;

import java.io.Serializable;

/* JADX INFO: loaded from: classes34.dex */
class Shift implements Comparable<Shift>, Serializable {
    private static final long serialVersionUID = 7003130400674500845L;
    public final double mDownThreshold;
    public final double mRate;
    public final double mUpThreshold;

    public double getMedianThreshold() {
        return (this.mDownThreshold + this.mUpThreshold) / 2.0d;
    }

    public int hashCode() {
        long r100 = Double.doubleToLongBits(this.mRate);
        int r101 = (int) (r100 ^ (r100 >>> 32));
        long r102 = Double.doubleToLongBits(this.mDownThreshold);
        int r103 = (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
        long r104 = Double.doubleToLongBits(this.mUpThreshold);
        return (r103 * 31) + ((int) (r104 ^ (r104 >>> 32)));
    }

    public String toString() {
        return "Shift{mRate=" + this.mRate + ", mDownThreshold=" + this.mDownThreshold + ", mUpThreshold=" + this.mUpThreshold + '}';
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Shift r100) {
        return Double.compare(this.mRate, r100.mRate);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Shift) == true) goto L8;
        return false;
    L8:
        Shift r101 = (Shift) r100;
        if (Double.compare(r101.mRate, this.mRate) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(r101.mDownThreshold, this.mDownThreshold) == 0) goto L15;
        return false;
    L15:
        if (Double.compare(r101.mUpThreshold, this.mUpThreshold) == 0) goto L19;
        return false;
    L19:
        return true;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Shift r100) {
        return compareTo2(r100);
    }

    public Shift(double r100, double r101, double r102) {
        this.mRate = r100;
        this.mDownThreshold = r101;
        this.mUpThreshold = r102;
    }
}
