package com.larus.bmhome.view.actionbar.edit;

/* JADX INFO: loaded from: classes26.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f316733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f316734b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (this.f316733a == r101.f316733a) goto L12;
        return false;
    L12:
        if (this.f316734b == r101.f316734b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f316733a * 31;
        long r101 = this.f316734b;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "SelectedRatioInfo(parentInstructionType=" + this.f316733a + ", id=" + this.f316734b + ')';
    }

    public q(int r100, long r101) {
        this.f316733a = r100;
        this.f316734b = r101;
    }
}
