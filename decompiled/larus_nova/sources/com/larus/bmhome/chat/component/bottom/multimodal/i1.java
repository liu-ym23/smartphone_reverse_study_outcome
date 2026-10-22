package com.larus.bmhome.chat.component.bottom.multimodal;

/* JADX INFO: loaded from: classes25.dex */
public final class i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f299793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f299794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f299795c;

    public i1() {
        this(0, 0, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i1) == true) goto L8;
        return false;
    L8:
        i1 r101 = (i1) r100;
        if (this.f299793a == r101.f299793a) goto L12;
        return false;
    L12:
        if (this.f299794b == r101.f299794b) goto L15;
        return false;
    L15:
        if (this.f299795c == r101.f299795c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f299793a * 31) + this.f299794b) * 31) + this.f299795c;
    }

    public final String toString() {
        return "MultipleFileSizeData(textFileSize=" + this.f299793a + ", imageSize=" + this.f299794b + ", audioSize=" + this.f299795c + ')';
    }

    public i1(int r100, int r101, int r102) {
        this.f299793a = r100;
        this.f299794b = r101;
        this.f299795c = r102;
    }
}
