package com.larus.chat.job.impl.page.edit;

/* JADX INFO: loaded from: classes26.dex */
public final class q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f325327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f325328b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q1) == true) goto L8;
        return false;
    L8:
        q1 r101 = (q1) r100;
        if (this.f325327a == r101.f325327a) goto L12;
        return false;
    L12:
        if (this.f325328b == r101.f325328b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f325327a * 31) + this.f325328b;
    }

    public final String toString() {
        return "TextInputSelection(start=" + this.f325327a + ", end=" + this.f325328b + ')';
    }

    public q1(int r100, int r101) {
        this.f325327a = r100;
        this.f325328b = r101;
    }
}
