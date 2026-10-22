package com.bytedance.ee.bear.document.comment;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements o2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f219286a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L9;
        return false;
    L9:
        if (this.f219286a == ((c) r100).f219286a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f219286a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "CommentEditFocusChangeEvent(hasFocus=" + this.f219286a + ')';
    }

    public c(boolean r100) {
        this.f219286a = r100;
    }
}
