package com.ss.android.ttve.vealgorithm.params;

/* JADX INFO: loaded from: classes38.dex */
public class VEBorderDetectResult extends VEAlgorithmResult {
    public int frameHeight;
    public int frameWidth;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public int f449977x1;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    public int f449978x2;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public int f449979y1;

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    public int f449980y2;

    public String toString() {
        return "VEBorderDetectResult{x1=" + this.f449977x1 + ", y1=" + this.f449979y1 + ", x2=" + this.f449978x2 + ", y2=" + this.f449980y2 + ", frameWidth=" + this.frameWidth + ", frameHeight=" + this.frameHeight + '}';
    }

    public VEBorderDetectResult(int r100, int r101, int r102, int r103, int r104, int r105) {
        this.type = VEAlgorithmType.VE_ALGORITHM_TYPE_BORDER_DETECT;
        this.f449977x1 = r100;
        this.f449979y1 = r101;
        this.f449978x2 = r102;
        this.f449980y2 = r103;
        this.frameWidth = r104;
        this.frameHeight = r105;
    }
}
