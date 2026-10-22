package com.larus.project;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f367001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f367002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f367003c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f367001a == r101.f367001a) goto L12;
        return false;
    L12:
        if (this.f367002b == r101.f367002b) goto L15;
        return false;
    L15:
        if (this.f367003c == r101.f367003c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f367001a * 31) + this.f367002b) * 31) + this.f367003c;
    }

    public final String toString() {
        return "GroupPagingConfig(firstPageSize=" + this.f367001a + ", secondPageSize=" + this.f367002b + ", pageSize=" + this.f367003c + ')';
    }

    public b() {
        this(5, 10, 20);
    }

    public b(int r100, int r101, int r102) {
        this.f367001a = r100;
        this.f367002b = r101;
        this.f367003c = r102;
    }
}
