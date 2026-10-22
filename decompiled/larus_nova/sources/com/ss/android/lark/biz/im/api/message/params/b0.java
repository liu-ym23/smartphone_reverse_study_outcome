package com.ss.android.lark.biz.im.api.message.params;

/* JADX INFO: loaded from: classes34.dex */
public final class b0 implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f410337a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b0) == true) goto L9;
        return false;
    L9:
        if (this.f410337a == ((b0) r100).f410337a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f410337a;
    }

    public final String toString() {
        return "UrlPreviewBlockParam(bottomPaddingDp=" + this.f410337a + ')';
    }

    public b0() {
        this.f410337a = 5;
    }
}
