package com.bytedance.ee.bear.document.comment;

/* JADX INFO: loaded from: classes16.dex */
public final class n2 implements o2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f219337a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n2) == true) goto L9;
        return false;
    L9:
        if (this.f219337a == ((n2) r100).f219337a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f219337a;
    }

    public final String toString() {
        return "HeightChangeEvent(height=" + this.f219337a + ')';
    }

    public n2(int r100) {
        this.f219337a = r100;
    }
}
