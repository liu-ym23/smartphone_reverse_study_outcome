package com.ss.android.lark.compose.chatterselector;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f417547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f417548b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f417547a == r101.f417547a) goto L12;
        return false;
    L12:
        if (Float.compare(this.f417548b, r101.f417548b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f417547a * 31) + Float.floatToIntBits(this.f417548b);
    }

    public final String toString() {
        return "CheckStyle(size=" + this.f417547a + ", strokeWidth=" + this.f417548b + ')';
    }

    public c() {
        this.f417547a = 22;
        this.f417548b = 2.0f;
    }
}
