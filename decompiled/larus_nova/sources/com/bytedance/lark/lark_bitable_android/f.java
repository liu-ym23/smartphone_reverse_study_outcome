package com.bytedance.lark.lark_bitable_android;

/* JADX INFO: loaded from: classes43.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f252995a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L9;
        return false;
    L9:
        if (this.f252995a == ((f) r100).f252995a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f252995a;
    }

    public final String toString() {
        return "BitableAppInfo(bizType=" + this.f252995a + ')';
    }

    public f(int r100) {
        this.f252995a = r100;
    }
}
