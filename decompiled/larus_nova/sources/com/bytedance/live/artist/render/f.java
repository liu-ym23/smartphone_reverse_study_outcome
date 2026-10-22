package com.bytedance.live.artist.render;

/* JADX INFO: loaded from: classes45.dex */
public final class f implements nf6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f254852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f254853b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L10;
        f r101 = (f) r100;
        if (Float.compare(this.f254852a, r101.f254852a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f254853b, r101.f254853b) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f254852a) * 31) + Float.floatToIntBits(this.f254853b);
    }

    public final String toString() {
        return "Size(width=" + this.f254852a + ", height=" + this.f254853b + ")";
    }

    public f() {
        this.f254852a = 0.0f;
        this.f254853b = 0.0f;
    }
}
