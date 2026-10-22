package com.bytedance.kmp.network.nqe;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f252551d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f252552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f252553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f252554c;

    public static final class a {
    }

    public d() {
        this(-1, -1, -1);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f252552a == r101.f252552a) goto L12;
        return false;
    L12:
        if (this.f252553b == r101.f252553b) goto L15;
        return false;
    L15:
        if (this.f252554c == r101.f252554c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f252552a * 31) + this.f252553b) * 31) + this.f252554c;
    }

    public final String toString() {
        return "RttAndThroughput(httpRttMs=" + this.f252552a + ", transportRttMs=" + this.f252553b + ", downstreamKbps=" + this.f252554c + ')';
    }

    static {
        f252551d = new d(-1, -1, -1);
    }

    public d(int r100, int r101, int r102) {
        this.f252552a = r100;
        this.f252553b = r101;
        this.f252554c = r102;
    }
}
