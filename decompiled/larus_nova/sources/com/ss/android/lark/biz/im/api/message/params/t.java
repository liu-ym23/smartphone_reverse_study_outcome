package com.ss.android.lark.biz.im.api.message.params;

/* JADX INFO: loaded from: classes34.dex */
public final class t implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f410379a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L9;
        return false;
    L9:
        if (this.f410379a == ((t) r100).f410379a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f410379a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "ReadStateParam(isShow=" + this.f410379a + ')';
    }

    public t() {
        this.f410379a = false;
    }
}
