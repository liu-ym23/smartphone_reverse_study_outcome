package com.larus.platform.model.chat;

/* JADX INFO: loaded from: classes31.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f365590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f365591b;

    public m() {
        this(false, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (this.f365590a == r101.f365590a) goto L12;
        return false;
    L12:
        if (this.f365591b == r101.f365591b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f365590a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f365591b;
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "CreationPreviewConfig(enablePreview=" + this.f365590a + ", prefetchSize=" + this.f365591b + ')';
    }

    public m(boolean r100, int r101) {
        this.f365590a = r100;
        this.f365591b = r101;
    }
}
