package com.larus.bmhome.view.actionbar.edit;

/* JADX INFO: loaded from: classes26.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f316731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f316732b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (this.f316731a == r101.f316731a) goto L12;
        return false;
    L12:
        if (this.f316732b == r101.f316732b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f316731a * 31;
        long r101 = this.f316732b;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "SelectedModelInfo(parentInstructionType=" + this.f316731a + ", id=" + this.f316732b + ')';
    }

    public p(int r100, long r101) {
        this.f316731a = r100;
        this.f316732b = r101;
    }
}
