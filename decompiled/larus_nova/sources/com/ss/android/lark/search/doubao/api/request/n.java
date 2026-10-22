package com.ss.android.lark.search.doubao.api.request;

/* JADX INFO: loaded from: classes38.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f439984a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L9;
        return false;
    L9:
        if (this.f439984a == ((n) r100).f439984a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f439984a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "MailContactDslModel(searchableWhenVisible=" + this.f439984a + ')';
    }

    public n(boolean r100) {
        this.f439984a = r100;
    }
}
