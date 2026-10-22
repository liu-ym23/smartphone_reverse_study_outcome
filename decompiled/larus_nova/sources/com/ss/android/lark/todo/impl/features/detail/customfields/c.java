package com.ss.android.lark.todo.impl.features.detail.customfields;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f443044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f443045b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f443044a == r101.f443044a) goto L12;
        return false;
    L12:
        if (this.f443045b == r101.f443045b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f443044a * 31) + this.f443045b;
    }

    public final String toString() {
        return "TagColorConfig(bgColorRes=" + this.f443044a + ", textColorRes=" + this.f443045b + ')';
    }

    public c(int r100, int r101) {
        this.f443044a = r100;
        this.f443045b = r101;
    }
}
