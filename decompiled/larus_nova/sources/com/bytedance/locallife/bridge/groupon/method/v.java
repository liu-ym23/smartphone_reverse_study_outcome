package com.bytedance.locallife.bridge.groupon.method;

/* JADX INFO: loaded from: classes21.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f257121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f257122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f257123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f257124d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L8;
        return false;
    L8:
        v r101 = (v) r100;
        if (this.f257121a == r101.f257121a) goto L12;
        return false;
    L12:
        if (this.f257122b == r101.f257122b) goto L15;
        return false;
    L15:
        if (this.f257123c == r101.f257123c) goto L18;
        return false;
    L18:
        if (this.f257124d == r101.f257124d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f257121a * 31) + this.f257122b) * 31) + this.f257123c) * 31) + this.f257124d;
    }

    public final String toString() {
        return "PositionResult(top=" + this.f257121a + ", left=" + this.f257122b + ", width=" + this.f257123c + ", height=" + this.f257124d + ')';
    }

    public v(int r100, int r101, int r102, int r103) {
        this.f257121a = r100;
        this.f257122b = r101;
        this.f257123c = r102;
        this.f257124d = r103;
    }
}
