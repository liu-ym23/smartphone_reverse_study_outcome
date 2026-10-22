package com.bytedance.ee.bear.document.comment;

/* JADX INFO: loaded from: classes16.dex */
public final class q2 implements o2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f219347a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q2) == true) goto L9;
        return false;
    L9:
        if (this.f219347a == ((q2) r100).f219347a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f219347a;
    }

    public final String toString() {
        return "InputHeightChangeEvent(height=" + this.f219347a + ')';
    }

    public q2(int r100) {
        this.f219347a = r100;
    }
}
