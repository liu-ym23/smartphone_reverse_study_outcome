package com.larus.bmhome.view.actionbar.edit;

/* JADX INFO: loaded from: classes26.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f316729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f316730b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (this.f316729a == r101.f316729a) goto L12;
        return false;
    L12:
        if (this.f316730b == r101.f316730b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f316729a * 31;
        long r101 = this.f316730b;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "SelectedDurationInfo(parentInstructionType=" + this.f316729a + ", id=" + this.f316730b + ')';
    }

    public o(long r100) {
        this.f316729a = 18;
        this.f316730b = r100;
    }
}
