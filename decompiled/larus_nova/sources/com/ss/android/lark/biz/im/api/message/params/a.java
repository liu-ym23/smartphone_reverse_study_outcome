package com.ss.android.lark.biz.im.api.message.params;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f410331a;

    public a() {
        this(false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (this.f410331a == ((a) r100).f410331a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f410331a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "AtStyleParams(isDisableShowAtReadDot=" + this.f410331a + ')';
    }

    public a(boolean r100) {
        this.f410331a = r100;
    }
}
