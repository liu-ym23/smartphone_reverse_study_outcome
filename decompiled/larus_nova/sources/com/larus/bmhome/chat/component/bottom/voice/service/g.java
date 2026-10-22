package com.larus.bmhome.chat.component.bottom.voice.service;

/* JADX INFO: loaded from: classes25.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f300488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f300489b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f300488a == r101.f300488a) goto L12;
        return false;
    L12:
        if (this.f300489b == r101.f300489b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f300488a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f300489b;
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "Status(open=" + this.f300488a + ", experimentGroup=" + this.f300489b + ')';
    }

    public g(boolean r100, int r101) {
        this.f300488a = r100;
        this.f300489b = r101;
    }
}
