package com.larus.uaigc.createpage.component.inspiration;

/* JADX INFO: loaded from: classes31.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f371688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f371689b;

    public g() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f371688a == r101.f371688a) goto L12;
        return false;
    L12:
        if (this.f371689b == r101.f371689b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f371688a == false) goto L5;
        int r100 = 1231;
    L6:
        long r101 = this.f371689b;
        return (r100 * 31) + ((int) (r101 ^ (r101 >>> 32)));
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "ImageFaceDetectState(faceDetected=" + this.f371688a + ", timestamp=" + this.f371689b + ')';
    }

    public /* synthetic */ g(int r100) {
        this(false, -1);
    }

    public g(boolean r100, long r101) {
        this.f371688a = r100;
        this.f371689b = r101;
    }
}
