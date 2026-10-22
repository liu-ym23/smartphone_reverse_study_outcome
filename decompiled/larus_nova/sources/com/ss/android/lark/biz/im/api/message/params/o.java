package com.ss.android.lark.biz.im.api.message.params;

/* JADX INFO: loaded from: classes34.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f410372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f410373b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (this.f410372a == r101.f410372a) goto L12;
        return false;
    L12:
        if (this.f410373b == r101.f410373b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f410372a * 31) + this.f410373b;
    }

    public final String toString() {
        return "MessageSenderColorSelector(meTextColorRes=" + this.f410372a + ", otherTextColorRes=" + this.f410373b + ')';
    }

    public o(int r100, int r101) {
        this.f410372a = r100;
        this.f410373b = r101;
    }
}
