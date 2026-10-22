package com.bytedance.live.richcontent.resource.cache;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f255795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f255796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f255797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f255798d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f255799e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f255800f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L18;
        e r101 = (e) r100;
        if (this.f255795a == r101.f255795a) goto L8;
        return false;
    L8:
        if (this.f255796b == r101.f255796b) goto L10;
        return false;
    L10:
        if (this.f255797c == r101.f255797c) goto L12;
        return false;
    L12:
        if (this.f255798d == r101.f255798d) goto L14;
        return false;
    L14:
        if (this.f255799e == r101.f255799e) goto L16;
        return false;
    L16:
        if (this.f255800f == r101.f255800f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        return (((((((((this.f255795a * 31) + this.f255796b) * 31) + this.f255797c) * 31) + this.f255798d) * 31) + this.f255799e) * 31) + this.f255800f;
    }

    public final String toString() {
        return "CacheState(entitySize=" + this.f255795a + ", totalSize=" + this.f255796b + ", putCount=" + this.f255797c + ", hitCount=" + this.f255798d + ", missCount=" + this.f255799e + ", evictionCount=" + this.f255800f + ")";
    }

    public e() {
        this.f255795a = 0;
        this.f255796b = 0;
        this.f255797c = 0;
        this.f255798d = 0;
        this.f255799e = 0;
        this.f255800f = 0;
    }
}
