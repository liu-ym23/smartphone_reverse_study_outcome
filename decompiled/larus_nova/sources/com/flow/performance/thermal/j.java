package com.flow.performance.thermal;

/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f274215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f274216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f274217c;

    public j() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (this.f274215a == r101.f274215a) goto L12;
        return false;
    L12:
        if (this.f274216b == r101.f274216b) goto L15;
        return false;
    L15:
        if (this.f274217c == r101.f274217c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f274215a * 31) + this.f274216b) * 31) + this.f274217c;
    }

    public final String toString() {
        return "ThermalData(powerMode=" + this.f274215a + ", sleepMode=" + this.f274216b + ", thermalRiskLevel=" + this.f274217c + ')';
    }

    public j(int r100) {
        this.f274215a = -1;
        this.f274216b = -1;
        this.f274217c = -1;
    }
}
