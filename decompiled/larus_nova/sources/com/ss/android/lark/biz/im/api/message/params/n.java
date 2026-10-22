package com.ss.android.lark.biz.im.api.message.params;

/* JADX INFO: loaded from: classes34.dex */
public final class n implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f410371a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L9;
        return false;
    L9:
        if (this.f410371a == ((n) r100).f410371a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f410371a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "MessageRenderReadyParam(enabled=" + this.f410371a + ')';
    }

    public n() {
        this.f410371a = false;
    }
}
