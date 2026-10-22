package com.larus.bmhome.chat.component.bottom.core.inputtext;

/* JADX INFO: loaded from: classes25.dex */
public final class n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f299006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f299007b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n1) == true) goto L8;
        return false;
    L8:
        n1 r101 = (n1) r100;
        if (this.f299006a == r101.f299006a) goto L12;
        return false;
    L12:
        if (this.f299007b == r101.f299007b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f299006a * 31) + this.f299007b;
    }

    public final String toString() {
        return "SearchHighlightRange(start=" + this.f299006a + ", endExclusive=" + this.f299007b + ')';
    }

    public n1(int r100, int r101) {
        this.f299006a = r100;
        this.f299007b = r101;
    }
}
