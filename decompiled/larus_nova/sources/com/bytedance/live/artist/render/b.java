package com.bytedance.live.artist.render;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements nf6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f254847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f254848b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (Float.compare(this.f254847a, r101.f254847a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f254848b, r101.f254848b) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f254847a) * 31) + Float.floatToIntBits(this.f254848b);
    }

    public final String toString() {
        return "Position(x=" + this.f254847a + ", y=" + this.f254848b + ")";
    }

    public b() {
        this.f254847a = 0.0f;
        this.f254848b = 0.0f;
    }
}
