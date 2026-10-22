package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics;

/* JADX INFO: loaded from: classes37.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f435485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f435486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f435487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f435488d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f435489e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (this.f435485a == r101.f435485a) goto L12;
        return false;
    L12:
        if (this.f435486b == r101.f435486b) goto L15;
        return false;
    L15:
        if (this.f435487c == r101.f435487c) goto L18;
        return false;
    L18:
        if (this.f435488d == r101.f435488d) goto L21;
        return false;
    L21:
        if (Float.compare(this.f435489e, r101.f435489e) == 0) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f435485a * 31) + this.f435486b) * 31) + this.f435487c) * 31) + this.f435488d) * 31) + Float.floatToIntBits(this.f435489e);
    }

    public final String toString() {
        return "MmRecordingUploadProgressSnapshot(totalCount=" + this.f435485a + ", successCount=" + this.f435486b + ", queueSize=" + this.f435487c + ", runningCount=" + this.f435488d + ", progress=" + this.f435489e + ')';
    }

    public o(int r100, int r101, int r102, int r103, float r104) {
        this.f435485a = r100;
        this.f435486b = r101;
        this.f435487c = r102;
        this.f435488d = r103;
        this.f435489e = r104;
    }
}
