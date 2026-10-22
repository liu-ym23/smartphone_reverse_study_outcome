package com.larus.audio.ttsV2;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f289910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f289911b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f289910a == r101.f289910a) goto L12;
        return false;
    L12:
        if (this.f289911b == r101.f289911b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f289910a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f289911b == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "EarphoneState(isEarphoneOn=" + this.f289910a + ", isTtsCheck=" + this.f289911b + ')';
    }

    public a(boolean r100, boolean r101) {
        this.f289910a = r100;
        this.f289911b = r101;
    }
}
